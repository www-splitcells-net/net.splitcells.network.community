# No-Code Editor
> Distracting myself from the main goal.
# The Goals
> How it started.

After creating the [code editor](https://live.splitcells.net/net/splitcells/gel/ui/editor.html)
for the Generic Allocator (Gel),
I developed the [no-code editor](https://live.splitcells.net/net/splitcells/gel/ui/no/code/editor/index.html)
for Gel as well.

There were 2 primary purposes for no-code.
1. First, this lessened the amount of knowledge needed by the user to define optimization problems.
  The user would not need to know the syntax of the modelling language exactly and could be sure,
  that there are no syntax errors in the optimization problem's definition.
  Furthermore, the user would even be able to discover the language just by clicking through the editor.
  The editor itself would provide all information about the possibilities of the modelling language.
2. Second, the developer could avoid some amount of documentation regarding the modelling language's grammar,
  that is syntax specific.
  Such documentation would also be relatively hard to change,
  when the syntax changes, compared to the no-code alternative,
  where the documentation can focus more on the contents of the modelling language.
# The Results
> How it ended.

On a basic level, the no-code editor works as intended.
On a more nuanced level, the no-code editor has quite a number of bugs,
but proofs that the concept works.
The reason for the high number of bugs is the fact,
that one has to explicitly program any kind of user editing action,
which requires a lot more code compared to a basic text editor.

In a text editor, one just needs a parser/interpreter and that's basically it.
The rest can be done with a [ready to go text editor library](https://codemirror.net/),
that handles the text editing,
or even with just a [basic HTML text input](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input).
When one does not know a ready to go no-code editor library,
one has to create the no-code editor by himself.
This requires one to implement every kind of editing action explicitly by hand.
While all code editing actions are easily handled by a [simple input element](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input),
every possible no-code editing action has to be explicitly implemented.
Want to add a new variable? You need extra code for that.
Want to rename a variable? You need extra code for that.
Want to move a variable definition to a different line? You need extra code for that.

When I started working on no-code,
I quickly noticed, that in my case there probably are not better visualizations aside from text with some visual guiding elements.
Visualizing logic simply does not seem to be suitable for alternative representations,
which is a lot different for rendering data sets.

Even though there are not a lot of use cases for the no-code editor right now,
WYSIWYG and no-code editors in general seem to be a nice feature.
These can be used in order to make stateful logical things of the application interactable.
Using no-code in order to edit or check the app's configuration sounds like a neat little trick,
whereby the GUI can guide the user/admin and help to avoid incorrect settings.
# The Conclusions
> How it will go on.

So, I could fix all the no-code editor bugs right away,
but I decided against it for now,
because there are no real users of the software right now.
Furthermore, the no-code editor feels more and more as a distraction for now,
because the basic text editor already should be good enough for now.
Instead, improving the no-code editor becomes a secondary task for now and
working on solving the sport lesson assignment in order to restore some features lost 8 years ago is prioritized.

However, I already have a no-code editor, it is kind of working and
it shows potential.
It has potential as a programming IDE and potential as a generic config interface.
So, I will not delete the no-code editor.

Having 2 editors for the same thing, but with different grammars,
creates a bigger incentive to isolate my ANTLR4 dependencies from the core code,
as this allows one to avoid duplicate backends for the 2 editors.
This in turn has the nice side effect to make the core code more portable and adaptable.