package ca.sheridancollege.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WarGame game = new WarGame("War Card Game");

        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");
        ArrayList<WarCard> cardDeck1 = new ArrayList<>();
        ArrayList<WarCard> cardDeck2 = new ArrayList<>();
        // Distribute cards to players
        for (int i = 0; i < 26; i++) 
        {
            cardDeck1.add(game.getDeck().showCards().remove(0));
            cardDeck2.add(game.getDeck().showCards().remove(0));
        }
        GroupOfCards hand1 = new GroupOfCards(cardDeck1);
        GroupOfCards hand2 = new GroupOfCards(cardDeck2);

        
        player1.setHand(hand1);
       
        player2.setHand(hand2);

        game.setPlayers(new ArrayList<>());
        
        game.getPlayers().add(player1);
       
        game.getPlayers().add(player2);

        game.play();
    }
}
