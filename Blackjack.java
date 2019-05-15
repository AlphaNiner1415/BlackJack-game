import java.util.*;
public class Blackjack{
    public static void main(String[] args) {
        ArrayList <Card> deck = new ArrayList<Card>(52);
        deck = fillDeck(deck);
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        Card[] emptyHand = new Card[5];
        Player player = new Player("Anon",emptyHand);
        Player dealer = new Player("dealer", emptyHand);
        play(player,dealer,deck);



        
        //player.printHand();
        
        //printHand(playerHand);
    }
    //This is to run the game.
    public static void play(Player player, Player dealer, ArrayList<Card> deck){
        deck = fillDeck(deck);
        player.draw(deck);
        dealer.draw(deck);
        player.draw(deck);
        dealer.draw(deck);
        player.setTotal(player.computeTotal());
        player.printHand(dealer);
    }
    public static ArrayList<Card> fillDeck(ArrayList <Card> deck){
        deck.clear();
        String[] CardNumbers = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        for (int i = 1; i <= 52; i++) {
            if (i <= 13) {
                Card heartCard = new Card("hearts", CardNumbers[i - 1]);
                deck.add(heartCard);
            } else if (i > 13 && i <= 26) {
                Card diamondCard = new Card("diamonds", CardNumbers[i - 1 - 13]);
                deck.add(diamondCard);
            } else if (i > 26 && i <= 39) {
                Card spadeCard = new Card("spades", CardNumbers[i - 1 - 26]);
                deck.add(spadeCard);
            } else if (i > 39 && i <= 52) {
                Card clubsCard = new Card("clubs", CardNumbers[i - 1 - 39]);
            }
        }
        return deck;
    }


}