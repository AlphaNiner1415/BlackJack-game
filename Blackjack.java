import java.util.*;
public class Blackjack{
    public static void main(String[] args) {
        //This is to run the game
        ArrayList <Card> deck = new ArrayList<Card>(52);
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        Card[] playerHand = new Card[5];
        playerHand[0] = new Card("hearts","A");
        playerHand[1] = new Card("Spades", "2");
        ;
        for(int i = 0; i < playerHand.length; i++){
            System.out.println(playerHand[i]);
        }

        String[] CardNumbers = {"A","2","3","4","5","6","7","8","9","10", "J", "Q","K"};
        for(int i = 1; i <= 52; i++){
            if(i <= 13){
                Card heartCard = new Card("hearts", CardNumbers[i-1]);
                deck.add(heartCard);
            } else if (i > 13 && i <=26){
                Card diamondCard = new Card("diamonds",CardNumbers[i-1-13]);
                deck.add(diamondCard);
            } else if ( i > 26 && i <= 39){
                Card spadeCard = new Card("spades",CardNumbers[i-1-26]);
                deck.add(spadeCard);
            } else if ( i > 39 && i <= 52){
                Card clubsCard = new Card("clubs",CardNumbers[i-1-39]);
            }
            
        }
        printHand(playerHand);
    }
    public static int computeTotal(Card[] playerHand){
        int total = 0;
        for(int i =0; i < playerHand.length; i++){
            total += playerHand[i].getValue();
        }
        return total;
    }
    public static void draw(Card[] playerHand, ArrayList<Card> deck ){
        Random rand = new Random();
        int seed = rand.nextInt();
        rand.setSeed(seed);
        int cardDraw = rand.nextInt();
        Card drawnCard = deck.get(cardDraw);
        deck.remove(cardDraw);
        for(int i =0; i < playerHand.length;i++){
            if(playerHand[i] == null){
                playerHand[i] = drawnCard;
                System.out.println("Drawing a Card!");
                int total = computeTotal(playerHand);
                break;
            }
        }
    }
    public static void printHand(Card[] playerHand){
        System.out.println("-----------------");
        System.out.printf("I %s l  %s         I\n",playerHand[0].getCardNo(),playerHand[1].getCardNo());
        System.out.printf("I %c l  %c         I\n",'\u2666','\u2660');
        System.out.println("I   l            I");
        System.out.println("I   l            I");
        System.out.println("I   l            I");
        System.out.println("I   l            I");
        System.out.println("I   l            I");
        System.out.println("I   l            I");
        System.out.println("-----------------");

    }
}