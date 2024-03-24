----
* SPDX-License-Identifier: EPL-2.0 OR GPL-2.0-or-later
* SPDX-FileCopyrightText: Contributors To The `net.splitcells.*` Projects
----
# Providing an experimental school scheduling tool for schools in general.
> It took 8 months?
## Sub Project Start
On the September 2023 I started a [sub project](https://github.com/www-splitcells-net/net.splitcells.network/issues/252)
to provide a minimum viable product (MVP) for scheduling exams.
2 main issues were tackled by this:
* Make the software deployable and downloadable by the user.
* Create a first UI for the optimization software.

Although, extensive development was already done on the main project,
its deploy-ability was never a real concern.
The program was used in order to generate the static website,
but until now, it was not really considered to be an accessible tool for users.
It was more of a development tool,
that process local files with some kind of hard coded paths specific to my computer of course.

So, at the start, the program was not that portable.
## The New Filesystem API
During the project a completely new abstraction of the filesystem was required,
in order to bundle files in a portable way.
This new `net.splitcells.dem.resource.FileSystem` API allows one to easily bundle files for the distributed programs,
while allowing the developer to use local files during test runs,
in order to increase the development speed.
The configuration is done via dependency injection (DI),
which minimizes the amount of code required in order to support both file modes.
## GUIs
As this program would also be used in order to process sensitive data,
I decided to provide a program,
that the user can execute locally.
First I decided to use Eclipse for the GUI and I immediately regretted this,
because of Eclipse's build complexity.
Than I tried JavaFX and the results seem to be OK.
Now I have a [download page](https://splitcells.net/net/splitcells/network/distro/downloads/index.html)
of the app for different operation systems.

I have not tested the Mac version yet,
but I think, that it's not working.
As long as I don't have a Mac or relevant users for that,
I will probably not fix the Mac version.
Furthermore, no version has a signed executable.
So, on Windows there is a Windows warning,
when the user downloads the software and tries to start it.
I hope, I will be able to sign the executables somewhat cheaply in the future,
so that the warning can be avoided.
It's kind of a bummer, that a program for processing sensitive data causes a warning during its start ;)
At least I can build everything fairly easily and independent of the OS used for the build.
## Server
There is now also the publicly available [live.splitcells.net](http://live.splitcells.net) server.
The user can freely test and use the software.

Updating my privacy policy for the servers,
was kind of interesting:
the privacy laws itself in Germany are kind of nice,
also the EU version seem to be a bit complicated.
They also make a surprising amount of sense,
but creating a privacy policy and integrating it into the software as a developer is nevertheless not always easy.
## Future Plans
The next step is to [get a first real world user](https://codeberg.org/splitcells-net/net.splitcells.network.community/src/branch/main/src/main/md/net/splitcells/network/community/cooperation-and-symbiosis/2023-12-30-get-first-real-world-user.md)
and this means creating advertisement and getting in touch with schools.

We'll see, how well this goes ^^'

Ahh ... and did you notice,
that this new sub project is on Codeberg?
Yeah, I'm migrating from SourceHut to Codeberg,
as SourceHut seems to be stagnating on a relatively low level.
Therefore, I decided to migrate issues from GitHub to Codeberg as well,
in order to have one place for issues processed by core developers of the project.

Until, we meet again!