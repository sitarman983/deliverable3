package ca.sheridancollege.project;

import java.util.ArrayList;
//
public class WarGame extends Game {
    private GroupOfCards deck;
    private ArrayList<WarCard> cardDeck;

    public WarGame(String name) {
     
        super(name);
          deck = new GroupOfCards(52);
        cardDeck = new ArrayList<>();
          initializeDeck();
    }

    private void initializeDeck() {
        
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
      for (String suit : suits) {
          for (int value = 2; value <= 14; value++) { 
              cardDeck.add(new WarCard(suit, value));
            }
        }
        deck = new GroupOfCards(cardDeck);
        deck.shuffle();
    }

    public GroupOfCards getDeck() {
        return deck;
    }

    @Override
    public void play()
    
    {
        ArrayList<WarPlayer> players = getPlayers();
        
        boolean gameOngoing = true;

        while (gameOngoing) 
        {
            ArrayList<WarCard> table = new ArrayList<>();


            
            for (WarPlayer player : players) {
        
                if (player.getHand().getSize() > 0) {
                    WarCard playedCard = player.getHand().showCards().remove(0);
                    table.add(playedCard);
                    System.out.println(player.getPlayerID() + " plays " + playedCard);
                }
                
            }

            if (table.size() == players.size()) {
                WarCard winningCard = findWinningCard(table);
               WarPlayer roundWinner = determineRoundWinner(players, winningCard);

      if (roundWinner != null) {
              System.out.println("Round winner is " + roundWinner.getPlayerID());
                for (WarCard card : table) {
                   roundWinner.getHand().showCards().add(card);
                    }
                }
            }
            players.removeIf(player -> player.getHand().getSize() == 0);

            if (players.size() <= 1) {
                gameOngoing = false;
            }
        }

        declareWinner();
    }

    private WarPlayer determineRoundWinner(ArrayList<WarPlayer> players, WarCard winningCard) {
           for (WarPlayer player : players) {
         if (player.getHand().showCards().contains(winningCard)) {
             return player;
            }
        }
        return null; // This should never happen if the logic is correct
    }

    private WarCard findWinningCard(ArrayList<WarCard> cards) {
        WarCard winningCard = cards.get(0);
        for (WarCard card : cards) {
            if (card.getValue() > winningCard.getValue()) {
                winningCard = card;
            }
        }
        return winningCard;
    }

    @Override
    public void declareWinner()
    {
        
        ArrayList<WarPlayer> players = getPlayers();
        WarPlayer winner = null;

        for (WarPlayer player : players)
        {
           
            if (winner == null || player.getHand().getSize() > winner.getHand().getSize()) {
                winner = player;
            }
        }

        if (winner != null) {
            
            
            System.out.println("The winner is " + winner.getPlayerID() + " with " + winner.getHand().getSize() + " cards!");
        }
        
        else {
            System.out.println("It's a tie!");
        }
    }
}
