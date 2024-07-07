----
* SPDX-License-Identifier: EPL-2.0 OR GPL-2.0-or-later
* SPDX-FileCopyrightText: Contributors To The `net.splitcells.*` Projects
----
# Migration From SourceHut to Codeberg
>  Never look back.

So today the migration from SourceHut to Codeberg is complete.
I am also using Codeberg as the main platform and
therefore removed the issues and project management from GitHub as well.
Now I am using the [community repo](https://codeberg.org/splitcells-net/net.splitcells.network.community)
for most issues and a [Codeberg project](https://codeberg.org/splitcells-net/net.splitcells.network.community/projects)
for issues were interactive things like discussions or image attachments are needed.

I can report, that there are no major issues with Codeberg, so everything looks good 🥳
# Reasons for Abandoning SourceHut
> Why was SourceHut used in the first place?

I started to use GitHub as the first git hoster,
but had 2 problems with it:
1. My account was once banned/deactivated and I could only get it back by asking a friend to do
  a support request via his paid enterprise account.
  I could not find out why I was banned.
  My support requests were not answered and I did not know. if making my account a paid one,
  would get me answers regarding my support requests.
  This was resolved, but in a way, that I have not a lot of confidence in GitHub anymore.
2. I am of the opinion, that there needs to be at least one strong open source git hosting software/platform,
  that is a competitor to closed source git hosting software.
  If there is no such thing, open source software will have a big problem sooner or later.
  So, I wanted to support such a hosting software at least a little bit,
  by using and paying for it.

Right at that time I started to look for alternatives, I started to hear of SourceHut.
The UI was not the best,
as navigating between each sub service of SourceHut is a big pain,
but it had everything working.

Some functionality, like being able to SSH into a CI container after the workflow finished are even extraordinary.
The ticket system was good enough for me,
also a bit bare bones and without support for image attachments.
The billing UI and its documents is great.
That's not really important, but it increases confidence.

SoureHut had always an nerd vibe to me,
because old things, that are hard to use by non exports are supported and focused on:
* e-mail based pushes
* mailing lists
* [IRC-Chat](http://chat.sr.ht)
* Gemini support for [static web hosting](http://srht.site)
* IMHO bad UI and UI navigation between services 🤣

To be frank, even so, it is not my cup of tea,
I kind of liked this,
especially as I can understand, why someone would want to have such functionality.
Also, nobody else seemed to offer something like this in a complete package.

So, I choose to use SourceHut and there were no problems with it.

> For the record: there was not a single real problem with SourceHut itself.

I once found 2 little UI errors in SourceHut's README rendering and submitted a patch.
I was only able to fix one of them, but the patched seemed to OK.
I fucked the patch submission up on my part, so the patch was never merged.

Then about 1 and half year, [nothing happened](https://sourcehut.org/blog).
Nothing *seems* to be improved furthermore.
In my mind, that last not small and new thing was chat.sr.ht. That was announced 2021.
[The most things being worked on is networking and its infrastructure](https://sourcehut.org/blog):
* 2024-06-12: [DDOS](https://sourcehut.org/blog/2024-06-12-infrastructure-updates/)
* 2024-06-04: [DDOS and Kubernetes and technical debt](https://sourcehut.org/blog/2024-06-04-status-and-plans/)
* 2024-01-19: [Network outage](https://sourcehut.org/blog/2024-01-19-outage-post-mortem/)
* 2023-01-09: [Traffic Problems with Google](https://sourcehut.org/blog/2023-01-09-gomodulemirror/)
* 2022-10-31: [Policy Update Regarding Crypto](https://sourcehut.org/blog/2022-10-31-tos-update-cryptocurrency/)
* 2022-10-18: [New Features: REUSE support, HTML support in mailing list and OAuth 2.0](https://sourcehut.org/blog/2022-10-18-whats-cooking-october-2022/)
* 2022-10-09: [SourceHut may get better UI](https://sourcehut.org/blog/2022-10-13-how-to-improve-sourcehut-design/)
* 2022-09-15: [Minor updates](https://sourcehut.org/blog/2022-09-15-whats-cooking-september-2022/)
* 2022-08-16: [Minor updates](https://sourcehut.org/blog/2022-08-16-whats-cooking-august-2022/)
* [...]

I understand, that one can **not** develop new features all the time.
Maybe there are a lot more relevant things being done in the background,
but I don't notice them.
Yes, some wishes are not compatible to SourceHut's vision.
On the other hand, some seemingly very simple things are not improved:
when one creates a ticket,
the text editor is just **way** too small in desktop mode.

I have a project,
that I would like to make popular in the future.
Maybe this will never happen as there are sever problems with me and my project,
but I would like to have users for my software in the future.
Currently, I can not imagine normal users and even some developers using the SourceHut as communication and
development platform.
I also, do not see this changing in the future.

Things like Forgejo/Codeberg, Gitea and GitLab offer such things,
and therefore I migrated to one of them.
# The GitLab Option
> Why did you not just use GitLab?

A friend asked me once, why I did not use GitLab from the start.
My basic idea is, that I want to support something, that an open source community is working on,
because from my point of view the wider open source ecosystem needs its own source code standards
in order to have a vision, that can be aspired to (like git, REUSE, etc.).

I am not convinced of this anymore on an emotional level regarding Forgejo/Codeberg.
Maybe switching to Forgejo/Codeberg is an error, maybe not.

[I REGRET NOTHING!11!!!!!!111!1](https://knowyourmeme.com/photos/257271-i-regret-nothing)