import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Blackjack{
    public static void main(String[] args) {
        
        ArrayList <Card> deck = new ArrayList<Card>(52);
        //System.out.println(deck.size());
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        Card[] emptyHand = new Card[5];
        Player player = new Player("Anon",emptyHand);
        Dealer dealer = new Dealer("dealer", emptyHand);
        
        
       
        int bet = play(player,dealer,deck);
        deck = fillDeck(deck);
        Collections.shuffle(deck);
        while(player.computeTotal() < 21){
            //userHandTotal.setText("Total: " + player.computeTotal());
            System.out.println("What do you want to do?");
            System.out.print("> ");
            String userinput = sc.nextLine();
            if(userinput.equals("Hit")){
                System.out.println("Hitting!!");
                player.draw(deck);
                player.printHand();
                //System.out.println(player.computeTotal());
                if(player.checkGameOver() == true){
                    System.out.println("Bust!!! Your total is over 21! Better luck next time!");
                    player.setMoney(player.getMoney() - bet);
                    break;
                } else {
                    continue;
                }
            } else if (userinput.equals("Stand")){
                dealer.play = true;
                dealer.decisionMaker(deck);
                break;
            }
            System.out.println("Going to next iteration");
        }
        System.out.println("exiting the loop");



        
        //player.printHand();
        
        //printHand(playerHand);
    }
    //This is to run the game.
    public static int play(Player player, Dealer dealer, ArrayList<Card> deck){
        Scanner sc = new Scanner(System.in);
        System.out.print("How much do you want to bet? ");
        int bet = sc.nextInt();
        deck = fillDeck(deck);
        player.draw(deck);
        dealer.draw(deck);
        player.draw(deck);
        dealer.draw(deck);
        //System.out.println(deck.size());

        player.computeTotal();
        dealer.printHand();
        player.printHand();
        return bet;
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