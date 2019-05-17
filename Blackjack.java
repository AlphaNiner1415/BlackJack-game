import java.util.*;
public class Blackjack{
    public static void main(String[] args) {
        ArrayList <Card> deck = new ArrayList<Card>(52);
        //System.out.println(deck.size());
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        Card[] emptyHand = new Card[5];
        Player player = new Player("Anon",emptyHand);
        Dealer dealer = new Dealer("dealer", emptyHand);
        play(player,dealer,deck);
        deck = fillDeck(deck);
        while(player.computeTotal() < 21){
            System.out.println("What do you want to do?");
            System.out.print("> ");
            String userinput = sc.next();
            if(userinput == "Hit"){
                player.draw(deck);
                if(player.checkGameOver() == true){
                    System.out.println("Bust!!! Your total is over 21! Better luck next time!");
                    break;
                } else {
                    continue;
                }
            } else if (userinput == "Stand"){
                dealer.play = true;
                dealer.decisionMaker(deck);
            }
        }



        
        //player.printHand();
        
        //printHand(playerHand);
    }
    //This is to run the game.
    public static void play(Player player, Dealer dealer, ArrayList<Card> deck){
        deck = fillDeck(deck);
        player.draw(deck);
        dealer.draw(deck);
        player.draw(deck);
        dealer.draw(deck);
        //System.out.println(deck.size());

        player.computeTotal();
        dealer.printHand();
        player.printHand();
        
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
                deck.add(clubsCard);
            }
        }
        return deck;
    }


}