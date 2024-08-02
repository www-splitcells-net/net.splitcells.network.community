# Double-Entry Bookkeeping in IT
> The boring stuff is often important.

For developers IT is shiny and bureaucracy are some dusty books,
but the more IT gets mature,
the more and more bureaucracy gets important as more and more complex systems are built.
Yes, bureaucracy is evil, but the more and more people are involved,
the more necessary it becomes.

Double-entry bookkeeping is an accounting system,
that states for everything from where something is coming from (credit) and where it is used at (debit).
It is an old yet still relevant tool, in order to handle inventories.
Also, software developers don't view themselves as accountants,
such administrative tasks are vital in order to keep clusters in check.
# Software Configuration
> We need double-entry bookkeeping in order to map inputs to its outputs.

A lot of software, supports the concept of configurations files like property files,
or allows injecting configurations via environment variables.
This is a useful technique, but it gets harder and harder to manage such configurations,
as it gets harder and harder to verify such configurations,
especially as automated checking tools are not widely available or even expected by the users.

The consequence is, that it gets harder and harder to check if a certain setting has
the correct or any effect at all.
Let's take a fictional property file excerpt for Spring Boot 2.x application.
A keystore file is set, in order to be used as a certificate for SSL. 
Which keystore file is used?
````
[...]
server.ssl.key-store=classpath:a.p12
[...]
management.server.ssl.key-store=classpath:b.p12
[...]
````
Of course, this was a trick question,
as [both](https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/production-ready-monitoring.html)
are valid properties for setting the SSL's keystore in of itself.
Of course, most will point out, that 2 such entries don't make sense,
but what happens, if multiple setting sources are present?
Yes, Spring Boot has a [well-defined priority order for properties](https://docs.spring.io/spring-boot/docs/1.0.1.RELEASE/reference/html/boot-features-external-config.html),
but does everybody have this always in mind?
Consider the fact, that most Spring Boot applications have 2 default property files (prod and test),
as a default configuration,
plus any base config of its dependencies,
plus some properties files lying around in the execution environment
and plus some environment variables.

And what do you do, when you encounter the final boss, the spelling errors of the property names?
In the worst case, one gets a program running with incorrect features,
like a forgotten open admin access with the password `123456`.
Hello stranger, do you want to upload something!?
In the best case, your coworker needs some coffee and a 4-hour debug session.
Oh, and don't forget the head banging against the wall.
It really helps, during debugging, I am told.
And all of this, because someone typed a capital `I` instead of an `l` on April the 1st 🎉

Software needs to reject completely unknown settings or settings without effects,
but it does not end here.
The software has to provide an accounting regarding which part of the input lead to any particular part of the output. 