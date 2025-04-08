---
title: On Creating The First Public Release
date: 2021-07-07
author: Mārtiņš Avots
license: EPL-2.0 OR GPL-2.0-or-later
SPDX-License-Identifier: EPL-2.0 OR GPL-2.0-or-later
SPDX-FileCopyrightText: Contributors To The `net.splitcells.*` Projects
---
This post is an excuse for the development practices done in this project.
Welcome to the cringe party 🎉
# Developing The Universal Allocation Program
The first version of this project was done during an internship at university with a friend of mine and
was called the Universal Allocation Program or Nap.
It took an Excel file as input containing an optimization problem model.
As output, the program also produced an Excel file, holding the best found solution to the problem.
It had a simple web page, where one could drop the input file and retrieve the output as a download.
Nap was probably badly coded, as it was my first complex program.
Nap did its job and that is the most important part of it:
it solved optimization challenges and I learned to code.

In hindsight, I noticed an emerging harmful pattern of mine during the development of Nap:
I searched for a good way, how to implement, organize and document program options in Java, which was used for Nap.
I did not find any, and frankly I probably did not know where to look.
In Nap, there is no special configuration framework used.
Instead, a CLI library and some static final variables were used.

The desire for a configuration framework, was the starting point for feature creep in the following versions.
As always, the evil is paved with the good intention to deal with program configurations.
# Developing The Generic Allocator
Thereafter, I created a successor for my master thesis and named it humbly the Generic Allocator or short Gal.
For this project, I definitely wanted to create a good configuration library
and named it Dependency Manager (`net.splitcells.dem`).

One can see, how this may have been a starting point for feature creep in a lot of projects of mine:
* Use a framework with fundamental flaws and combine it with the desire for a better one.
* Furthermore, searches for good frameworks don't lead to good results.

That's basically, what happened a lot of times.
Even with Nap itself: there were very limited alternative options to creating a new optimization framework,
because of my owns limited view in university.
Therefore, I constructed a completely new optimization program, instead of using and improving existing ones, in order to comply with demands.
Each new subproject has its own feature creep, which does sidetrack one from the goals that really matter.

Gal itself, the second version of the optimization program, was created in a simple way.
I created a new empty source code project.
For every file of Nap, I decided, what part could be reused and what needed to be changed.
Only the constraint system and the rating functions, were completely rewritten from the ground up,
because the new solving algorithm relied on a new constraint model.

This way of migrating code basically worked,
but I started to create my own mini frameworks for things like configurations.
# Developing The Third Version
Starting from this point, a very destructive path started.
After my master thesis I decided, to further work on this project and to create a third version.
The development plan was similar to the second version:
* Create a new empty project.
* Go through each file of the precursor and decide what parts should be adopted.

This seems to be fine on the first look
and a lot of code was migrated from the precursor to the successor.
It also worked for the migration from Nap to Gal as well.
So, everything is fine?

It took 4 years of implementation in order to even come close to finishing the third version,
and it does not have one test case, where the new functionality is really used.
Of course, I did not work non-stop on the project.
In matter of fact, I did not invest that much time into it,
but still: 4 years for nothing?

That is the toll of feature creep: being slowly killed by a thousand cuts.
# Migration Based Development and the Tower of Babel
When I kind of started to understand the problem and perceive its extent,
it was too late, as the new version already started to show its potential.
This does not mean, that deleting code is not an option,
but the trade-off of doing it, did not seem to be worth it anymore.

I started attempts to compensate these problems:
* I started publishing the project, in order to have some skin in the game.
* A new development paradigm was adopted: migration based development
  or in other words `Do break functionality.`
* Make many commits and try to make up to 20 of them each day,
  in order to have continuous progress.

Does this sound familiar to the opening point?
It certainly feels so.
# A New Adventure
Now there is a blog for this project,
where I want to write down my thought processes,
so one can get a grip of its history, progress and future.
It may newer become a truly open source project with a community.
The gods know, how bad I am in social and many other settings.
On the other hand, this creates uncertainty, which in turn makes this whole
journey a lot more exciting.

We'll see, what will happen.

The article is licensed under the [EPL-2.0](http://splitcells.net/net/splitcells/network/legal/licenses/EPL-2.0.txt)
OR [MIT](http://splitcells.net/net/splitcells/network/legal/licenses/MIT.txt).