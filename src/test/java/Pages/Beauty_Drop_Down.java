package Pages;

public enum Beauty_Drop_Down {
    View_All("View All", 1),
    Face("Face", 2),
    Body("Body", 3),
    Emolyne("Emolyne", 4);
    private String name;
    private int id;

    Beauty_Drop_Down(String name, int id) {
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
