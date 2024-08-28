# Solve school course scheduling problem
* [This is the original issue](https://github.com/www-splitcells-net/net.splitcells.network/issues/8)
* This is ticket is mainly used in order to improve constraint based repair and make the whole software package more usable for developers.
* [ ] Make the network distribution an optimization platform where the problems can also be stored on the server can be interacted with.
  A user authorization system is needed for this.
  Make the whole platform also easy usable as a tool, in order to synchronize Git repos for instance.
* [ ] Ensure, quickly as possible, that a minimum viable version of this works and improve this in subsequent tickets.
    * [x] Do this by creating new very simplified test data.
      Tackle the complex test data in a later project from website server.
        * [x] Ensure that problem parameters match result.
    * [ ] Make it easy to retrieve analysis data.
        * [ ] Make fods files downloadable via website.
    * [x] Document that the reason for this is the fact the school optimization in on itself is not that good advertisable without additional things like a GUI. In other words, the Cin project is more usable right now, than the school optimization project.
    * [x] Treat subsequent tickets to this topic as service tasks for now.
    * [x] Blog about this decision.
* [x] Ensure that Solution's name is based on the provided one and not the demand database.
  This is a problem for `SchoolCourseSchedulingTest#defineTeacherAllocationForCourses`.
* [x] Fix incorrectly implemented equals methods using `return identity().equals(castedArg.identity());` via helper function.
* [x] Model Problem.
* [x] Test rating with simple example problems. -> I think it's enough to solve the problem and then verify the solution manually.
* [x] Create meaningful random instance.
* [ ] Solve random instance via the repair based optimizer.
    * [ ] Use custom initializers for constraint based repair in order to improve results.
    * [ ] Render performance data in Graph and monitor results,
      in order to get a felling, how much needs to be done and how much effect a single action had.
      Do this by reimplementing the old problem specific initializers.
      (Currently done via https://localhost:8444/net/splitcells/martins/avots/website/test.html)
* [ ] Document problem, because it seems to be hard to understand for third party.
* [x] Implement Domsole, which can output a list of values, that can be easily graphed via LibreOffice and CLI tools.
  This can be used in order to easily render histograms of the solution rating during the optimization.
    * [x] Remove usage of Node logging interface. -> I removed some Node usage and deprecated the interface instead.
    * [x] Replace Node logging interface with Perspective logging interface.
    * [x] Create one ouput file for each logging context and enable creating csv files this way. -> UiRouter can be used as an alternative Domsole.
    * [x] Fix XML outpout for Domsole. -> Will fix it, when it is used again or the code is cleaned up during maintenance.
* [x] Allocations do not work for nested problems, because there is an equality problem. -> Allocations had an inconsistent path.
  ``Context of demand for removal should be part demands or used demands, but is not:
  Removal context is           Database[demands, Rails For School Scheduling, allocations],
  demands context is          [demands, Rails For School Scheduling] and
  used demands context is Database[demands, Rails For School Scheduling, Teacher Allocation For Courses, demands-used].``
* [ ] Imitate railed courses to teacher allocation solver from personal master thesis.
    * [x] Assign courses to rails.
        * [x] Every course is currently on the same rail.
        * [x] Every course has no allocated hours.
        * [x] Completely free courses are ignored by constraint repair.
          This happens when linear initialization is omitted or if repair reaches such state by accident.
            * [x] The same demand is allocated multiple times in one optimization step.
                * [x] freeSlots is determined incorrectly, because it assumes that demand grouping is always happaning along the course id.
        * [x] The average course length of the generated demands is not correct (half of target).
        * [x] Selecting element of a free course slot leads to an error, because there are fewer left than assumed.
            * freeDemandGroups contains only demands, that are freed in the current step. Already free demands are ignored.
            * solutionView still uses all demands of freeDemandGroups.
            * [x] allocatedCourses needs therefore to be checked.
            * [x] chosenSplit should also consider the real number of demands of a course to be repaired.
            * [x] freeSlots needs to be filled with pre optimize unused demands.
            * [x] How is determined, which demand gets void rail? -> via nonEmptySlotCount
        * [x] The allocated course hours is calculated incorrectly by the repair. Done via a repair hill climber.
            * [x] retainedAllocatedHours is calculated incorrectly as it does not substract allocated hourse which are removed in the current optimization step.
            * [x] There seems to be a problem in the understanding of index relations between allocations, free demands and used
              demands. -> This was documented.
        * [x] Create history report more searchable by LibreOffice.
          Otherwise, the low searchability will always take a toll during history analysis.
        * [x] Improve hill climber repair performance by trying every supply value combination once instead of trying out all free supplies, which contains duplicates.
    * [x] Assign teachers to courses.
        * [x] Only grouping by course is important.
        * [x] Determine not allocated courses and their not used demands.
        * [ ] Determine defying groups and their not used and used demands.
        * [ ] Determine a representative allocation of defying groups and undo all allocations of defying groups.
        * [x] Use free demands of the representative for the repair of each defying group.
        * [x] Randomize each repair step.
        * [x] Select only suitable teachers.
        * [x] Repair all incorrect values and not just some by repair any constraint error and by always converting all groupings to groupings by course id.
        * [ ] Deallocate all lines with a course id, that has an error, during each repair iteration step.
        * [ ] Optionally deallocate all lines with a subject, that has an error, during each repair iteration step.
        * [ ] Use unused demands.
        * [ ] Randomization performance seems to be bad.
        * [ ] Defiance and rating calculation by Constraint seems to have very bad performance.
        * [ ] When working on one sub problem, pause synchronization to other subscribed sub problems, in order to increase performance.
        * [ ] Lazy synchronization between tables and lookup tables.
        * [x] Improve raw lines and lines performance.
        * [x]  Performance of nested lookup seems to be lacking.
        * [ ] Improve `DatabaseI#distinctLines` performance.
    * [ ] Assign students to courses.
        * [ ] Ensure that all students are assigned to something, if there is something fitting. -> Optionally Log if fitting supplies are not present for constraint group repair. The reason in this case why no fitting supply is present, is caused by the fact, that there is no feedback between the first sub problem and that last sub problem, regarding available rails of a subject.
            * [x] How was the underlying solved in the second version of Gel? -> If a sub problem cannot be solved, deallocate the corresponding allocations of the previous sub problem.
            * [ ] Optimize solution dependencies, if solution cannot be optimized. Do this like in the second version of Gel, but in a generic way.
                * [ ] Create constraint based network destructor between 2 directly interlinked solutions.
                * [ ] Create escalation, so that indirectly linked solutions can be destructed as well.
                * [ ] Create a generic solver, that combines constraint based repair with escalating destructor.
        * [x] Free demands seemingly are ignored.
        * [x] Only assign courses to the students demands, which fit their subject and vintage.
        * [x] Is the following constraint correct? `r.forAll(RAIL).forAll(STUDENT).then(allSame(COURSE_ID));` -> No, this was caused by misreading the previous version of the software.
        * [x] Create cache for children rating. -> Obsolete, because symptom was caused by too many calls of defying by group id.
        * [x] Create performance test for defying by groupd id. -> This was caused by too many calls of defying by group id.
        * [x] Create cache for routing rating by group id. -> This was caused by too many calls of defying by group id.
        * [x] Make it easy to select constraint path during repair, via query interface.
* [ ] Implement constraint query system for tables and use it in constraint based repair. Online optimization would be needed for that.
* [x] Improve analysis by making it more table like and create guidelines for table (searchability and simplicity) versus tree (organization).
* [ ] Adjust teacher subject suitability and course subject in test data. Some course subjects may need to have a teacher for the subject adjustments.
* [ ] Test all constraints.
* [ ] Ensure that test data more sane by manually checking these.
* [x] Disable history by default, because otherwise is not a sane default performance setting.

# Future Tasks
* [ ] Fix last element of solution paths in logging (i.e. `net/splitcells/gel/GelEnv/demands.allocations.allocations/`).
* [ ] Create a presentation for the problem.
* [ ] Try out real profiling
    * [ ] Document reasons: http://psy-lob-saw.blogspot.com/2016/02/why-most-sampling-java-profilers-are.html
    * [ ] Via perfasm: http://psy-lob-saw.blogspot.com/2015/07/jmh-perfasm.html
    * [ ] Consider Perf + perf-map-agent.