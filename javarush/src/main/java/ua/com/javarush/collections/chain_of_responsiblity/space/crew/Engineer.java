package ua.com.javarush.collections.chain_of_responsiblity.space.crew;

public class Engineer extends AbstractCrewMember {
    public Engineer(AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doTheJob(String request) {
        System.out.println(request + " is a common engineering task. To the work!");
    }
}