package Pages;

public enum Clothing_Drop_Down {
    View_All("View All", 1),
    TShirts_Sweatshirts("T-Shirts + Sweatshirts", 2),
    Cycling_Jerseys("Cycling Jerseys", 3),
    Socks("Socks", 4),
    Tote_Bags("Tote Bags", 5),
    Shopping_Bags("Shopping Bags", 6),
    Jewellery("Jewellery", 7),
    Umbrellas("Umbrellas", 8);

    private String name;
    private int id;

   Clothing_Drop_Down(String name, int id) {
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
