package ua.com.javarush.collections.chain_of_responsiblity.space.crew;

public class CabinBoy extends AbstractCrewMember {
    public CabinBoy(AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doTheJob(String request) {
        System.out.println("Even the cabin boy can handle the request " + request);
    }
}