# Configure logging via external config and not code.
* [ ] Create a model for external config.
* [ ] Currently, MessageFilter cannot be configured via the environment.
* [ ] Document config system.
    * [ ] Config is a special case of dependency injection. See Spring XML as an example, or Java's class path shell argument.
    * [ ] Blog about why this did not exist for a long time.
    * [ ] Config system should work like double-entry bookkeeping. Otherwise, understanding the logs or the system's setup becomes very hard.