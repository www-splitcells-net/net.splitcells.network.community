# Disrespecting APIs
> Not reading the docs is not always the worst.

For [solving the sport lesson assignment](../../features/task-archive/2024-11-13-solve-sport-lesson-assignment.md)
it was decided to improve the web server,
[by supporting multithreading so that multiple users can submit multiple optimization tasks at once](../../features/done/2024-08-27-make-copies-of-the-webserver-thread-safe.md).
One of the hurdles, was the XML API, that threw exceptions sometimes,
that were caused by multiple threads working on XML objects.
So that was basically a race condition.

Now comes the curious part: 
on the first look, there was no part, where multiple threads were working on one XML document at once.
The race condition was caused, when 2 threads worked on 2 different XML documents at once.
Is Java's `org.w3c.*` not thread safe in that matter? Of course, it is!

I created and used `net.splitcells.dem.lang.Xml`.
It basically provides helper methods.
The first helper methods I implemented basically handled creating XML object factories.
It was a way to put all `org.w3c.*` dependent config code into one place.
So, if I had to add some security flags to the factory settings after the fact,
I could do that, by changing one file.
I would not have to change these settings everywhere.

I also quickly noticed, that the XML API was pretty hard, complicated and verbose.
In order to add an element to an existing one,
I had to write following code:
```java
final var document = DocumentBuilderFactory.newInstance().rootDocumentBuilder().newDocument();
final var html = document.createElement("x:html");
// [...]
// [Some other method, that only gets the html object.]
final var body = html.getOwnerDocument().createElement("x:body") // Note manually setting the namespace prefix.
final var lang = html.getOwnerDocument().createAttribute("lang"); // You always need to the owner.
lang.setNodeValue("de"); // No fluent API, but constructors with to few arguments require additional method calls.
body.setAttributeNode(lang); // Special methods for adding specific child nodes.
body.appendChild(rootElement.getOwnerDocument().createTextNode("body-text"));
html.appendChild(body);
```
I started to put more and more things into the utility class, until I placed nearly everything there.
This simplified and more importantly **standardized** the code: 
```java
final var html = rElement(HTML, "html")
final var body = element(HTML, "body")
html.setAttributeNode(attribute("lang", "de"));
body.appendChild(textNode("body-text"));
html.appendChild(body);
```
But it has one major flaw:
As you can see, the methods `rElement`, `element` and `textNode` do not take an element or document as an argument.

Do you see the problem?
In starting examples I always used `.getOwnerDocument().create`.
So, how did I avoid that?

I simply created a single static XML document,
in order to create new elements, attributes and nodes.
The XML helper methods are basically creating XML objects from a single special XML document,
in order to create new XML documents.
Java's XML code is intended to create 1 document object in order to create 1 XML.
My way was not the intended way.
The creation of new XML objects by one document is not thread safe and
therefore creates this race condition.
You can argue, that Java's XML code is bad,
but if you use it wrongly, it is your concern as well.

Why did I do this?
Because I ***hated*** Java's XML API and I wanted to get over it.
I did not want to read the doc and I blatantly ignored everything there,
that I did not like.
I blatantly despised the API and did everything to ignore and abuse it.

Basically being the maker of my own demise.

# The Final Solution
> Let the wicked forsake their ways and the unrighteous their thoughts. Let them turn to the lord, and he will have mercy on them, and to our God, for he will freely pardon.

I was already working on [replacing Java's XML with my own](../../compatibility-portability-and-adaptability/2021-03-08-create-minimal-java-grammar.md),
in order to simplify my code and make it more portable.
It was part of a secondary maintenance task,
that I was working a tiny bit each weekend.

So when this new feature required the replacement of Java's XML API,
I fast tracked this task and got it done.
The previous code, currently would look like this:
```java
tree("html", HTML)
    .withXmlAttribute("lang", "de", HTML)
    .withChild(tree("body", HTML).withChild(tree("body-text")));
```

Furthermore, I can expand my own API a lot easier.
For example, I could create a new helper method,
in order to simplify the code further:

```java
node("html", HTML)
    .withXmlAttribute("lang", "de", HTML)
    .withChild(node("body", HTML).withNode("body-text"));
```
# Conclusions
> Most of the times, the computer problem is sitting right in front of the monitor.

When a developer group refactors its code,
the major measurement for success is how good the developers will be able to work with the new code.
As a company, it's not important, how good the new code **really** is,
but how well the developers will **accept** and ***internalize*** the newly introduced structure.
That's not only true in a commercial sense,
but is probably more significant in free software.