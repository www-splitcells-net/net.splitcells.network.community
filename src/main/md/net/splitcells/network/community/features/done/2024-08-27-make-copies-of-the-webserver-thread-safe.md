# Make copies of the webserver thread safe
* Issue number: [\#38](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/38)
* Primary method: `net.splitcells.website.server.Server.serveToHttpAt`
# Task Description
If multiple ProjectsRenderer are created and each used by a dedicated thread,
then these ProjectsRenderers still have problems with each other's thread.

The basis for the webserver thread safety was created [here](../projects/2024-08-22-sigma-grind-of-24th-of-august-2024.md).
This issue is part of ["Solve sport lesson assignment"](2021-03-07-solve-sport-lesson-assignment.md).
# Tasks
* [x] Multithreaded webserver sometimes has random errors, when optimization problems are submitted via the editors.
    * [x] The Whole XML class needs to be removed, as it is not thread safe.
      See ["Create minimal Java grammar."](../compatibility-portability-and-adaptability/2021-03-08-create-minimal-java-grammar.md).#
        * [x] Blog about the fact that the XML of Java used incorrectly, because of arrogance.
    * [x] Try improving the multithreaded webserver by trying an experimental handler fix for the multipart-bodies of forms:
      Use end handler and body handler by nesting these. -> It now works.
    * [o] Only expect multipart, if the request is not read yet: `if (!routingContext.request().isEnded()) { routingContext.request().setExpectMultipart(true);}`.
      See `Multipart Exception`. -> Multipart works now.
    * [o] When multi threading is enabled, forms are not executed in parallel. -> The handler of the router needs to be a blocking handler.
      `executeBlocking` does not to execute a request in a worker thread.
    * [x] BinaryProcessor does not execute requests in parallel. -> A synchronized modifier caused a problem.
    * [x] Use `.useNormalizedPath(true)`.
# Conclusions
Its hard for me to understand the Vert.x doc,
which caused many misunderstandings and pain.
# Multipart Exception
````
19:43:16.303 [vert.x-eventloop-thread-0] DEBUG io.vertx.ext.web.RoutingContext -- RoutingContext failure (500)
java.lang.IllegalStateException: Request has already been read
	at io.vertx.core.http.impl.Http1xServerRequest.checkEnded(Http1xServerRequest.java:671)
	at io.vertx.core.http.impl.Http1xServerRequest.setExpectMultipart(Http1xServerRequest.java:477)
	at io.vertx.core.http.impl.HttpServerRequestWrapper.setExpectMultipart(HttpServerRequestWrapper.java:254)
	at net.splitcells.website.server.Server$2$2.lambda$start$6(Server.java:177)
	at io.vertx.ext.web.impl.BlockingHandlerDecorator.lambda$handle$0(BlockingHandlerDecorator.java:48)
	at io.vertx.core.impl.ContextBase.lambda$null$0(ContextBase.java:137)
	at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:264)
	at io.vertx.core.impl.ContextBase.lambda$executeBlocking$1(ContextBase.java:135)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base/java.lang.Thread.run(Thread.java:1583)
````