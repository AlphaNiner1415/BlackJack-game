public class Card{
    protected String suit;
    protected String cardNo;
    protected int value;
    protected char symbol;
    private char[] symbolsArray = {'\u2665','\u2660','\u2666','\u2663'}; //Hearts, Spade, Diamonds, Clubs.

    public Card(){
        this("heart","2");

    }
    public Card(String suit, String cardNo){
        this.suit = suit;
        this.cardNo = cardNo;
        if(cardNo == "A"){
            this.value = 1;
        }else if(cardNo == "J"|| cardNo == "Q"|| cardNo == "K"){
            this.value = 10;
        } else {
            this.value = Integer.parseInt(cardNo); 
        }
        
    }
    public String getCardNo() {
        return cardNo;
    }
    public String getSuit() {
        return suit;
    }
    public char getSymbol() {
        return symbol;
    }
    public int getValue() {
        return value;
    }
  
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
   
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
  
    public void setValue(int value) {
        this.value = value;
    }
    public String toString(){
        switch (cardNo) {
            case "A":
                return "Ace of " + suit;
            case "J":
                return "Jack of " + suit;
            case "Q":
                return "Queen of " + suit;
            case "K":
                return "King of " + suit;
        
            default:
                return cardNo + " of " + suit;
        }
        
    }
}