import java.util.*;
public class Player{
    protected Card[] hand;
    protected int total;
    protected int money;
    protected String name;
    public boolean play = false;
    public Player(){
        this.hand = new Card[5];
        this.total = 0;
        this.money = 1000;
    }
    public Player(String name,Card[] hand){
        this.name = name;
        this.hand = new Card[5];
        for(int i = 0; i < getNonNullHandLength(); i++){
            this.hand[i] = hand[i];
        }
        this.money = 1000;
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
        this.total = 0;
        for (int i = 0;i < getNonNullHandLength(); i++) {
            if(hand[i].getCardNo() == "A" && total + 11 <=21){
                this.total += 11;
            }else {
                this.total += this.hand[i].getValue();
            }
            
        }
        return this.total;
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
        computeTotal();
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
    
     public void printHand(){
        System.out.println("This is your hand: ");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        String lineOne = "_______________";
        String lineTwo = String.format("| %s  ", hand[0].getCardNo());
        String lineThree = String.format("| %c  ",hand[0].getSymbol());
        String lineFour = "|    ";
        String lineFive = "_______________";
        for(int i = 1; i < getNonNullHandLength(); i++){
            sb.append(String.format("| %s  ",hand[i].getCardNo()));
            sb2.append(String.format("| %c  ",hand[i].getSymbol()));
            sb3.append("|    ");
        }
        int n = (getNonNullHandLength() + 4) * 3;
        lineOne = stringMultiply("_", n);
        lineTwo += sb.toString() + stringMultiply(" ", 12 - 2 * getNonNullHandLength())+"|"; //This here is the way to go change all the other loops to this
        lineThree += sb2.toString() + stringMultiply(" ", 12 -2*getNonNullHandLength())+"|";
        lineFour += sb3.toString()+ stringMultiply(" ", 12 -2*getNonNullHandLength())+"|";
        lineFive = stringMultiply("_", n);
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThree);
        System.out.println(lineFour);
        System.out.println(lineFive);
        System.out.println("Total: " + this.total);

     }
     
    public static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
    public boolean checkGameOver(){
        if(this.computeTotal() > 21){
            return true;
        } else {
            return false;
        }
    }
     
}