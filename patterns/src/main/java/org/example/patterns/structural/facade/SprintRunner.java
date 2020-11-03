package org.example.patterns.structural.facade;

public class SprintRunner {
    public static void main(String[] args) {
        // before workflow
        /*Job job = new Job();
        job.doJob();
        BugTracker bugTracker = new BugTracker();
        bugTracker.startSprint();
        Developer developer = new Developer();
        developer.doJobBeforeDeadline(bugTracker);

        bugTracker.finishSprint();
        developer.doJobBeforeDeadline(bugTracker);*/

        // with workflow
        Workflow workflow = new Workflow();
        workflow.solveProblems();
    }
}
