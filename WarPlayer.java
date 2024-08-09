package ca.sheridancollege.project;

public class WarPlayer extends Player {
    private GroupOfCards hand;

    public WarPlayer(GroupOfCards hand, String name) {
        super(name);
        this.hand = hand;
    }

    public WarPlayer(String name) {
        super(name);
        hand = new GroupOfCards(0);
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    @Override
    public void play() {
        if (hand.getCards().size() > 0) {
            Card topCard = hand.showCards().remove(0);
            System.out.println(getPlayerID() + " plays " + topCard);
        }
    }
}
