import java.util.*;
public class Player{
    protected Card[] hand;
    protected int total;
    protected int money;
    protected String name;
    public Player(){
        this.hand = new Card[5];
        this.total = 0;
        this.money = 1000;
    }
    public Player(String name,Card[] hand){
        this.name = name;
        this.hand = new Card[5];
        for(int i = 0; i < this.hand.length; i++){
            this.hand[i] = hand[i];
        }
    }
    public Card[] getHand() {
        return hand;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    public int computeTotal(){
        total = 0;
        for (int i = 0;i < getNonNullHandLength(); i++) {
            if(hand[i].getCardNo() == "A" && total + 11 <=21){
                this.total += 11;
            }else {
                this.total += this.hand[i].getValue();
            }
            
        }
        return total;
    }
    public void draw( ArrayList<Card> deck ){
        Random rand = new Random();
        int seed = rand.nextInt();
        rand.setSeed(seed);
        int cardDraw = rand.nextInt(deck.size());
        Card drawnCard = deck.get(cardDraw);
        deck.remove(cardDraw);
        for(int i =0; i < hand.length;i++){
            
            if(hand[i] == null){
                hand[i] = drawnCard;
                System.out.println(hand[i]);
                System.out.println(this.getName() + " drew a Card!");
                break;
            }
        }
    }
    public int getNonNullHandLength(){
        int count = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] != null){
                count++;
            }
        }
        return count;
    }
    
     public void printHand(Player dealer){
        StringBuilder sb = new StringBuilder();
        System.out.println("The dealer currently has a " + dealer.hand[0] + " and " + (dealer.getNonNullHandLength()-1) +" other cards.");
        String lineOne = "_______________";
        String lineTwo = String.format("| %s  ", hand[0].getCardNo());
        String lineThree = String.format("| %c  ",hand[0].getSymbol());
        String lineFour = "|    ";
        String lineFive = "_______________";
        for(int i = 0; i < getNonNullHandLength(); i++){
            sb.append(String.format("| %s  ",hand[i].getCardNo()));
        }
        lineTwo = sb.toString(); //This here is the way to go change all the other loops to this
        System.out.println(lineTwo);



        if(getNonNullHandLength() ==1){
            System.out.println(lineOne);
            System.out.println(lineTwo);
            System.out.println(lineThree);
            System.out.println(lineFour);
            System.out.println(lineFive);

        }else if(getNonNullHandLength()== 2){
            System.out.println("__________________");//18 underScores
            System.out.printf("| %s  | %s         |\n", hand[0].getCardNo(), hand[1].getCardNo());
            System.out.printf("| %c  | %c         |\n", hand[0].getSymbol(), hand[1].getSymbol());
            System.out.println("|    |           |");
            System.out.println("|    |           |");

            System.out.println("------------------");
        } else if (getNonNullHandLength() == 3) {
            System.out.println("_____________________"); //21 Underscores
            System.out.printf("| %s  | %s  | %s       |\n", hand[0].getCardNo(), hand[1].getCardNo(),hand[2].getCardNo());
            System.out.printf("| %c  | %c  | %s       |\n", hand[0].getSymbol(), hand[1].getSymbol(),hand[2].getSymbol());
            System.out.println("|    |    |         |");
            System.out.println("|    |    |         |");

            System.out.println("---------------------");
        }
        System.out.println("Total: " + this.total);
        
     
     }
     
    public static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
     
}