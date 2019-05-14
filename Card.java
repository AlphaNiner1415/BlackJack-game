public class Card{
    protected String suit;
    protected String cardNo;
    protected int value;
    protected String symbol;
    

    public Card(){
        suit = "heart";
        cardNo = "2";
        value = 2;

    }
    public Card(String suit, String cardNo, String symbol){
        this.suit = suit;
        this.cardNo = cardNo;
        if(cardNo.equals("A")){
            this.value = 1;
        }
        if(cardNo == "J"|| cardNo == "Q"|| cardNo == "K"){
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
    public String getSymbol() {
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
   
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
  
    public void setValue(int value) {
        this.value = value;
    }
    public String toString(){
        return cardNo + " of" + suit;
    }
}