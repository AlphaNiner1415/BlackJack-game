import java.util.ArrayList;
public class Blackjack{
    public static void main(String[] args) {
        //This is to run the game
        ArrayList <Card> deck = new ArrayList<Card>(52);
        Card AceTest = new Card("Spades", "A", "");
        String[] CardNumbers = {"A","2","3","4","5","6","7","8","9","10", "J", "Q","K"};
        for(int i = 1; i <= 13; i++){
            Card card = new Card("hearts", CardNumbers[i-1], "");
            deck.add(i-1, card);
        }
        for(int i = 0; i < 13; i++){
            System.out.println(deck.get(i));
            System.out.println(deck.get(i).getValue());
        }
    }
}