package org.example.patterns.structural.composite.project;

public class Project {
    public static void main(String[] args) {
        Developer projectTeam = new Team(TeamType.STAFF);
        Developer outsourceTeam = new Team(TeamType.OUTSOURCE);
        Developer trialEmployee = new JavaDeveloper(DeveloperLevel.TRAINEE);
        Developer wholeTeam = new Team();

        projectTeam.add(new JavaDeveloper(DeveloperLevel.JUNIOR));
        projectTeam.add(new CppDeveloper(DeveloperLevel.MIDDLE));
        projectTeam.add(new CppDeveloper(DeveloperLevel.JUNIOR));

        outsourceTeam.add(new JavaDeveloper(DeveloperLevel.SENIOR));
        outsourceTeam.add(new CppDeveloper(DeveloperLevel.SENIOR));

        wholeTeam.add(projectTeam);
        wholeTeam.add(outsourceTeam);
        wholeTeam.add(trialEmployee);

        wholeTeam.createProject();
    }
}
