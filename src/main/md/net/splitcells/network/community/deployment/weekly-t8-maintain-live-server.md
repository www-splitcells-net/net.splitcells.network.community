# Weekly maintain live server.
* Issue number: [\#8](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/8)
## Service
* The server is publicly available at http://live.splitcells.net
* Update server.
    * Upgrade major version of OS when available.
    * Update deployed software.
* Improve deployment and its processes.
* Test security
* Test legalities and privacy policy.
    * Check via browser, if really no cookies are set.
* Check via browser, if there are client side errors.
* Check htop.9
## Open Tasks
* [ ] Test if pages with authorization do work without authentication. This should not be the case.
* [ ] Use only fast-forward git pulls for relevant workflows.
* [ ] Detect any deployment errors.
    * [ ] Maven Build
    * [ ] Shell Project Setup
    * [ ] End execution on first failure.
* [ ] Create dedicated logging services.
    * [ ] Move from Dockerfile to Podman compose.
    * [ ] Setup metrics server: https://prometheus.io/docs/prometheus/latest/installation/
    * [ ] Get access to server via SSH port-forwarding scripts.
    * [ ] Setup visualisation server based on Grafana:
    * [ ] Adapt logging to Prometheus via vendor-agnostic OpenTelemetry: use Prometheus server, if it is found via config or convention and otherwise store logs to file as it already is.
        * [ ] Create own telemetry log API.
        * [ ] Forward own API calls to OpenTelemetry.
    * [ ] Log JVM metrics: https://prometheus.github.io/client_java/instrumentation/jvm/
        * [ ] CPU usage
        * [ ] Memory usage
    * [ ] Setup Java profiling: https://grafana.com/docs/pyroscope/latest/configure-client/grafana-alloy/java/
    * [ ] Consider creating a VPN.
    * [ ] Note, that this is done as this is generic functionality.
      It also allows one to do complex analysis and monitoring.
    * [ ] Send vert.x log to Prometheus as well.
* [ ] Host CPU/Memory Utilization page does not work.
    * [ ] https://live.splitcells.net/net/splitcells/host/resource/cpu/utilization.csv.html
    * [ ] https://live.splitcells.net/net/splitcells/host/resource/memory/utilization.csv.html
* [ ] Provide debug port for Java service over SSH based port forwarding.
* [ ] Safe user credentials as salted hashes.
* [ ] If external ACME server is not available, but the certificate is still valid, that service should be able to start successfully and not crash at start.
* [ ] Declare a data protection officer.
* [ ] Make privacy policy of live and static server the same.
* [ ] Playwright based test sometime do nothing.
    * [x] Avoid XSL errors in systemd logs.
    * [ ] Maybe there is also a problem, when the submitted problem is optimized, but not fully solved. -> No, Playwright is not working.
        * [x] Minimize Systemd logs, so that Playwright errors can be found there. -> No Playwright errors are outputed to the standard out and error anymore 
        * [ ] Run program in remote debug mode.
            * [ ] Add new JVM parameter `-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=127.0.0.1:8000`.
            * [ ] Forward port of container to host machine, but don't make the port publicly available.
            * [ ] Create command to forward the liver server debug port to local machine over SSH.
        * [ ] For each log message, also log its thread name.
        * [ ] Try restarting Playwright instance daily.
        * [x] Maybe an error in the test causes problems for Playwright. -> According to the logs, errors are recovered. 
        * [x] Maybe the problem is that optimization requests are being queue, but not processed yet.
          Thereby, the queue grows until something breaks. -> This does not seem to be the case.
        * [x] Is Playwright present in container in the correct version? -> Yes
        * [x] Create only one Playwright server, that one browser per HtmlClient in Java.
    * [ ] If nothing works, use HTMLUnit instead.
* [ ] Reset the git repos, in order to prevent an unexpected state.
* [ ] Log UI test runtime performance.
* [ ] Synchronize Playwright in Container created by `network.execute` and in Network Bom,
  in order to avoid some Playwright integration issues.
* [ ] Sometimes submitting an optimization does not work.
* [ ] This was caused by a bug in the LookupManager, when the persisted lookup got enabled.
    * [ ] Add a test for submitting optimization to the daily Codeberg CI.
    * [ ] Create test for lookup manager.
* [ ] Create an admin page, where all distinct errors can be viewed.
    * [ ] Add command to delete 1 error from the view.
* [ ] Make logs smaller.
* [ ] Reset .m2 folder, in order to prevent an unexpected state.
* [ ] Create test workers like htmlClient, but without a browser, because currently the browser tests seem to be kind of unreliable.
  The reason for that, is that something goes wrong after a while in the Playwright integration.
  There always new problems and tests
    * [ ] Document the goal of non GUI test workers.
    * [ ] Consider HTML/Javascript client written purely in Java as well, in order to avoid the problems with Playwright.
    * [ ] For this the ProjectsRenderer needs to be a Dem Option.
        * [x] Create ProjectsRendererOption.
        * [ ] Initialize at least, when the Live Distro or its Dev is run.
* [ ] Fix memory leak in main Java service, that get it killed by the OS in 2 days.
  See `Main service killed by OOM killer after 2 days.`.
    * [o] Restart the application every Sunday once at 1 hour after midnight. -> It worked for some days. It seems to be better to let the program run as long as possible, in order to find some issues.
    * [ ] Every program exit should cause a heap dump, for better maintenance.
        * [x] Core dumps are created by default on JVM crashes. These should be enough.
          Set `-XX:ErrorFile=` for the JVM, so core dumps are persisted and can be analyzed.
        * [ ] Delete all core dumps older than 7 days, as these could contain private information.
          Do this in the `worker.execute` command via a generated execution script, when the flag `--class-for-execution` flag is used,
          because the `worker.execute` determines, that the core dumps are created and determines its location.
            * [ ] Document this in the arg doc of the network worker and note, that this is done in order to comply with EU's GDPR.
            * [ ] Create script template.
            * [ ] Generate script.
            * [ ] Launch script in container instead of using Java entrypoint.
* [ ] Create error reporter page, that lists all errors without duplicates and not the complete log.
* [ ] Install a TUI for Docker in order to debug Forgejo runner, as it sometimes does seem to start a queued workflow a bit late.
* [ ] Restart main service, when the UI testers are not working anymore.
  Currently, an error for the UI testers not working could not be found.
* [ ] Execute runtime profiling for long-running instances and store these,
  in order to improve day to day performance via [Grafana and Pyroscope](https://grafana.com/docs/pyroscope/latest/get-started/).
* [ ] Automatically and continuously check, if the SSL certificate for HTTPS is still valid
  and replace it automatically.
* [ ] Execute the complete test suite on live server periodically and commit result data to network log.
* [ ] Automatically restart server after update installation.
* [ ] `apt upgrade` packages are seemingly not installed by unattended-upgrades.
  This is required for Linux kernel updates. 
* [ ] Make default file storage locations more sane regarding Linux home folder standard.
    * [ ] Migrate files on live server accordingly.
* [ ] Manage upgrading major OS versions.
* [ ] The corresponding systemd service should only store logs up to 7 days.
* [ ] Make private setup script public, in order to have a basis for default setup script for a server.
* [ ] Run Forgejo Runner via Podman in order to not require root rights for Forgejo Runner: https://code.forgejo.org/forgejo/runner/src/branch/main/scripts/systemd.md
* [ ] Do not log already logged message, in order to simplify logs on live server.
* [ ] Do not output logs to standard output by default,
  in order to have minimal OS logs.
* [ ] Consider creating double book-keeping for config files, in order to check ones, that are not used.
  Abort the software, when such an unused file is found.
* [ ] Create backup of files.
* [ ] Do disaster recovery tests.
* [ ] Update certificates for ACME automatically without an explicit restart, in order to avoid these expiring during production.
* [ ] Create dedicated error log or error search query.
* [ ] Consider migrate from Podman to k8s.
    * [ ] In order to be able to run many other things with unified infrastructure like the Codeberg runner,
      that currently kind of needs docker (via https://code.forgejo.org/forgejo/runner/src/branch/main/examples/kubernetes).
    * [ ] Consider using https://k9scli.io/ as cli TUI.
* [ ] Block outgoing connections.
* [ ] Make setup script for live server open source as well.
* [ ] Create 404 page for web server.
* [ ] Consider automatically sending a mail, when an error happens.
* [ ] Consider Nix for package management: [Matthew Croughan - Use flake.nix, not Dockerfile - MCH2022 ](https://www.youtube.com/watch?v=0uixRE8xlbY)
* [ ] Speed up deployment via parallel module builds with mvnd.
## Done Tasks
* [x] Because of Playwright TimeoutError:
  According to HtmlClientSharer, closing the Firefox browser with Playwright does not always work.
  So, starting and closing a real browser for each test run may not work with Playwright,
  as this can cause a resource leak.
  If this is the case, consider changing HtmlClientSharer so that there is pool of real browser instances,
  instead of just one (`HTMLClients#ROOT_CLIENT`).
  In other words, use one browser per CPU core, instead of one browser tab of a singleton browser per thread.
  Use this HtmlClientSharer, instead of starting and closing a browser for each test run.
    * [x] Implement this.
    * [x] Test `podman run --security-opt seccomp=unconfined` as a fix for NodeJS start.
      -> `--security-opt seccomp=unconfined` does not fix the issue,
      because closing a Playwright instance does not terminate all of its processes.
      So, in the end process are spawned until there are to many for the OS.
    * [x] Note the reason, why a browser is only accessed by one thread at a time: https://github.com/microsoft/playwright-java/issues/1184
    * [x] Only one browser at a time should be launched, as this also caused threading issues in the past.
    * [x] Clean up the LiveDistro TODOs, if the UI tester works by now.
    * [x] See chapter `process/resource limits reached`.
        * [x] Try `--security-opt seccomp=unconfined`. -> This worked.
        * [x] Document why `--security-opt seccomp=unconfined` is used.
        * [x] `--pids-limit=-1` seems to be the actual solution. Remove `--security-opt seccomp=unconfined` and deploy this to live server and check results.
            * [x] Deploy `--security-opt seccomp=unconfined` removal. -> The deployment is broken. -> The deployment is fixed.
            * [x] Check results.
    * [o] Why are tabs or their context etc. being closed? `Target page, context or browser has been closed\n  name='TargetClosedError\n  stack='TargetClosedError: Target page, context or browser has been closed\n`
      -> This does not need to be noted as saving resources is the default use case for closing a resource.
    * [x] Clean up HtmlClientsShare and HtmlClientsSharer.
    * [x] Note the reason for the error message `[62.986s][warning][os,thread] Failed to start thread "Unknown thread" - pthread_create failed (EAGAIN) for attributes: stacksize: 1024k, guardsize: 4k, detached.`.
    * [x] Clean up HtmlClients.
* [x] Because of Playwright TimeoutError: Try UI tester, that starts a browser for each test instance and then destroy it,
  but do not do actions over any browsers in parallel.
  This is like the first UI HTML client draft, but with an exclusive lock for any action on any browser.
  -> Closing Playwright instance does sometimes not work, which causes a resource leak.
  The leak leads to the crash of the container, as there are too many processes.
  Therefore, this does not work.
  Furthermore, maybe all errors was caused by the fact, that the Geal editor test was not correctly written.
    * [x] Analyse how the HTML client works now.
      -> It has a fixed pool of browsers, where only one thread can do on any one of them at a time.
      The HTML client has to kill its browser after the usage is done.
    * [x] The Geal editor has to replace the code editor fully first.
    * [x] Correct the Playwright's locator usage and keep in mind,
      that access none existing thing by locators causes a timeout exception.
        * [x] One has to check the thing's presence first.
        * [x] Handle timeout exceptions and add a better message to these, so its meaning is easier to understand.
* [x] Check if the error `Failed to create driver` at `com.microsoft.playwright.impl.driver.Driver.createAndInstall(Driver.java:105)` reappears.
  If that is the case, the reason for it must be found. A theory is, that the Playwright initial Java base setup does not work. For this the Linux journal log can be checked.
    * [x] Playwright cannot download the browser sometimes, because of a network error.
        * [x] Cache Playwright's browser downloads, by caching `~/.cache/ms-playwright/` via `worker.execute`.
* [x] Fix `Failed to create driver` at `com.microsoft.playwright.impl.driver.Driver.createAndInstall(Driver.java:105)`. -> Updating and redeploying the software fixed the issue.
* [x] Restart the server daily automatically.
    * [x] Move automatic update to 3:00 to 3:45.
    * [x] Setup daily restart configuration for at 4:00.
    * [x] Check if new configuration worked.
* [x] The deployed systemd service shuts down after a while.
  Maybe this is caused by the oneshot type or maybe this is caused by the daily server restart?
  -> This is caused by the fact, that the systemd service config has not configured an automated service start.
  -> The systemd user service was not enabled.
* [x] Create and user generic `worker.execute` command, in order to make things portable regarding the infrastructure.
    * [x] Deploy server software as systemd user service.
        * [x] Create user service.
        * [x] Make user service reachable via network.
        * [x] Start user service on server start automatically.
        * [x] Build image during build command and execute image during execute command with `net.splitcells.network/bin/worker.execute`,
          instead of  `net.splitcells.network.worker/bin/worker.execute`.
          Currently, the build command builds the Java part and the execute command builds the container image.
            * [x] Merge `worker.execute.*` commands into one `worker.execute` command.
                * [x] `worker.execute` is command with file storage.
                    * [x] Use more descriptive names for `$1` amd `$2`.
                * [x] `worker.program` is command without file storage.
                * [x] `worker.service` is command to execute command in detached mode.
            * [o] Consider `worker.bootstrap.remote.at`.
            * [x] Add parameter to `worker.execute` in order to build a project at the current folder in a standardized way.
                * [o] Consolidate `worker.repo.build`.
            * [o] Create flag for `worker.execute` command, in order to execute program based on files created via `worker.build`.
            * [x] Create flag in order to execute program as a persistent service.
    * [x] Delete obsolete `net.splitcells.network.worker` repo.
    * [x] Use this command for existing test deployment commands as well.
      This tests whether this new command is portable or not.
        * [o] `deploy.build.at` -> This command is deleted.
        * [o] `deploy.test.extensively.at` -> This command is deleted.
    * [x] Build everything via `mvn clean install` at `net.splitcells.network.hub`.
    * [x] Simplify `deploy.remote`.
* [x] Correct download logs command.
* [x] Support flat folder on Java side.
* [x] Set program name to `net.splitcells.martins.avots.distro`.
* [x] Execute more test at once, in order to have a better load test on production.
* [x] Create UI tester for text editor as well, in order to test both.
* [o] Browser tests are not always working. Log message: `Target page, context or browser has been closed`
  -> The warning log `Closing HTML clients is implemented, but is not actually expected to be used in production.` with its stack-trace was implemented and deployed in order to find the reason for this error.
  For now this task is closed, as this only appears sometimes.
  When the warning or log message is found again it will be attempted again.
* [x] Fix JS errors in Gel's UI editor. -> JQuery was not unpacked by Maven, as there was a silent dependency resolution error.
* [x] Avoid deadlock in HTML client factory.
* [x] Playwright is not working anymore.
    * [x] Install Playwright dependencies via Maven, so that the dependencies are more consistent. See `Playwright Notes`.
    * [x] Try using only one browser playwright instance at a time.
    * [x] Use public domain for Playwright based tests, so that the certificate can be accepted by the browser.
    * [o] Try fixing Playwright's potential race condition, while still maintaining multiple Playwright instances.
      -> Using one Playwright instance, that is shared across multiple testers makes this work and is even more performant.
    * [x] Use only one browser instance and one browser tab for each tester instead,
      in order to avoid process leak in Playwright.
      Playwright does not seem to close all processes/threads after the browser and Playwright is closed in Java,
      as many `Socket Process` and `Utility Process` processes with dedicated PIDs were found on live server.
    * [ ] There seems to be a race condition regarding the close method. ->
      This may be caused by not closing the tabs of the HTML clients after the test.
      Currently, it is not the close method, but the newPage method of Playwright instead.
      Make recycle browser tabs like the browser itself.
        * [x] Playwright is [not thread safe](https://playwright.dev/python/docs/library#threading).
          Use one dedicated instance per thread.
            * [x] Simplify Playwright factory implementation by using a thread safe queue instead.
            * [x] Provide thread safe queue implementation.
        * [x] A solution is implemented and deployed, that provides one browser per live tester thread.
          Check later, if this solution is working for more than 24 hours.
* [x] Avoiding sharing document files in `worker.execute` by default.
* [x] Pull source code from Codeberg instead of GitHub.
* [x] Avoid logging to stdout and stderr, in order to have a clean systemd log.
* [x] Correct deployment via worker on live server. Currently, it is completely broken as the file paths have changed.
* [x] Automatic upgrade does not always work. There is sometimes a difference between unattended-upgrades
  (with apt-daily and apt-daily-upgrade) and `apt update && apt upgrade --yes`.
    * [o] Create own automatic restart service, if this gets too complicated. It already cost too many hours.
      Also keep in mind that unattended-upgrades config is very complex and therefore already an argument in itself to replace it with simple custom command.
      Especially, when the debug log is so bad, because one does not see the concrete APT/dpkg actions in the log.
      If this is done, document this reasoning.
      -> The unattended-upgrades usage is fixed, so this is not needed for now.
    * [x] Check if unattended-upgrades is working with some fixes.
        * [ ] If this works, persist fixes in private git repo.
        * [x] Try solving the problem via Origins-Pattern of `"origin=*";` and `"o=*";`.
        * [x] Expand `/etc/apt/apt.conf.d/20auto-upgrades` with `APT::Periodic::Enable "1";`.
        * [x] Expand `/etc/apt/apt.conf.d/50unattended-upgrades` with `Unattended-Upgrade::SyslogEnable "true";Unattended-Upgrade::SyslogFacility "daemon";Unattended-Upgrade::Verbose "true";`.
        * [x] Expand `/etc/apt/apt.conf.d/50unattended-upgrades` with `Unattended-Upgrade::Debug "false";`.
* [x] Make unattended-upgrades work.
* [x] Do not require `loginctl enable-linger` in order to run Podman container without ssh session,
  in order to ensure, that all programs of ssh sessions are closed.
  -> The container is now run via a systemd user service and therefore `loginctl enable-linger` is not needed anymore.
* [x] Create double-checking for every config step. -> Check description is present in config script.
# Playwright Notes
````
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>net.splitcells</groupId>
    <artifactId>worker.pom.empty</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>com.microsoft.playwright</groupId>
            <artifactId>playwright</artifactId>
            <version>1.45.0</version>
        </dependency>
    </dependencies>
</project>

mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install-deps"
````
# Main service killed by OOM killer after 2 days.
```
Jan 01 15:40:56 net-splitcells-live systemd[821]: user.slice: A process of this unit has been killed by the OOM killer.
Jan 01 15:40:56 net-splitcells-live systemd[821]: libpod-480013e988f74f4b0a05947771663c4dc6b1e904f6984183568e8ceba925af67.scope: Consumed 1d 20h 33min 42.329s CPU time.
Jan 01 15:40:55 net-splitcells-live systemd[821]: libpod-480013e988f74f4b0a05947771663c4dc6b1e904f6984183568e8ceba925af67.scope: A process of this unit has been killed by the OOM killer.
```

# process/resource limits reached
````
Sep 28 01:10:49 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[805419]: [9.596s][warning][os,thread] Failed to start thread "Unknown thread" - pthread_create failed (EAGAIN) for attributes: stacksize: 1024k, guardsize: 4k, detached.
Sep 28 01:10:49 net-splitcells-live podman[805374]: [9.596s][warning][os,thread] Failed to start thread "Unknown thread" - pthread_create failed (EAGAIN) for attributes: stacksize: 1024k, guardsize: 4k, detached.
````

````
Sep 28 00:50:41 net-splitcells-live podman[715008]: java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]: java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]: [13.236s][warning][os,thread] Failed to start the native thread for java.lang.Thread "HtmlLiveTester-7"
Sep 28 00:50:41 net-splitcells-live podman[715008]: [13.236s][warning][os,thread] Failed to start the native thread for java.lang.Thread "HtmlLiveTester-7"
Sep 28 00:50:41 net-splitcells-live podman[715008]: [13.236s][warning][os,thread] Failed to start thread "Unknown thread" - pthread_create failed (EAGAIN) for attributes: stacksize: 1024k, guardsize: 4k, detached.
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]: [13.236s][warning][os,thread] Failed to start thread "Unknown thread" - pthread_create failed (EAGAIN) for attributes: stacksize: 1024k, guardsize: 4k, detached.
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]:         at java.base/java.lang.Thread.run(Thread.java:1583)
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]:         at net.splitcells.website.server.test.HtmlLiveTester$1.lambda$executeTest$1(HtmlLiveTester.java:55)
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]:         at net.splitcells.website.server.test.HtmlLiveTester$1.executeTest(HtmlLiveTester.java:46)
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]:         at net.splitcells.dem.Dem.executeThread(Dem.java:124)
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]:         at java.base/java.lang.Thread.start(Thread.java:1526)
Sep 28 00:50:41 net-splitcells-live net.splitcells.martins.avots.distro.livedistro.daemon[715057]:         at java.base/java.lang.Thread.start0(Native Method)
````