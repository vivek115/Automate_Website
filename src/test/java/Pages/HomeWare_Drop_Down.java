package Pages;

public enum HomeWare_Drop_Down {
    View_All("View All", 1),
    Art_Prints ("Art + Prints", 2),
    Kitchenware("Kitchenware", 3),
    Home("Home", 4),
    Food_Drink("Food + Drink", 5),
    Books("Books", 6),
    Candles("Candles", 7),
    Craft_Kits("Craft Kits", 8),
    Wellness("Wellness", 9),
    Kindfulness_Subscription("Kindfulness Subscription", 10);


    private String name;
    private int id;

    HomeWare_Drop_Down(String name, int id) {
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
