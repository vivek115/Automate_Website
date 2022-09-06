package Pages;

public enum Stationary_Drop_Down {
    View_All("View All", 1),
    Greetings_Cards("Greetings Cards", 2),
    Birthday_Cards("Birthday Cards", 3),
    Congratulations_Cards("Congratulations Cards", 4),
    Thank_You_Cards("Thank You Cards", 5),
    Wrapping_Paper ("Wrapping Paper", 6),
    Notebooks("Notebooks", 7),
    Enamel_Pin_Badges("Enamel Pin Badges", 8);

    private String name;
    private int id;

    Stationary_Drop_Down(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String ChallengeName() {
        return this.name;
    }

    public int ChallengeId() {
        return this.id;
    }
}
