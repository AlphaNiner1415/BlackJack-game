import java.util.*;

public class DealerDecisionMakerTest {
    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<Card>(52);
        deck = fillDeck(deck);
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        Card[] emptyHand = new Card[5];
        Player player = new Player("Anon", emptyHand);
        Dealer dealer = new Dealer("dealer", emptyHand);
        int[] sumCollection = new int[5];
        int[] cardCount = new int[5];
        int n = 0;
        while (n < 5) {
            dealer.draw(deck);
            dealer.draw(deck);
            dealer.decisionMaker(deck);
            dealer.computeTotal();
            System.out.println("_____________________");
            sumCollection[n] = dealer.getTotal();
            cardCount[n] = dealer.getNonNullHandLength();
            dealer.clearHand();

            System.out.println("Going to next loop");
            n++;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(cardCount[i]);
            System.out.println(sumCollection[i]);
            System.out.println("-");
        }

    }

    public static ArrayList<Card> fillDeck(ArrayList<Card> deck) {
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