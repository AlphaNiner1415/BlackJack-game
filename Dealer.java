public class Dealer extends Player{
    public Dealer(){
        super();
    }
    public Dealer(String name, Card[] hand){
        super(name,hand);
    }
    public void printHand(){
        System.out.println("This is the dealer's hand: ");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        String lineOne = "_______________";
        String lineTwo = String.format("| %s  ", hand[0].getCardNo());
        String lineThree = String.format("| %c  ", hand[0].getSymbol());
        String lineFour = "|    ";
        String lineFive = "_______________";
        for (int i = 1; i < getNonNullHandLength(); i++) {
            sb.append("|    ");
            sb2.append("|    ");
            sb3.append("|    ");
        }
        int n = (getNonNullHandLength() + 4) * 3;
        lineOne = stringMultiply("_", n);
        lineTwo += sb.toString() + stringMultiply(" ", 12 - 2 * getNonNullHandLength()) + "|"; 
        lineThree += sb2.toString() + stringMultiply(" ", 12 - 2 * getNonNullHandLength()) + "|";
        lineFour += sb3.toString() + stringMultiply(" ", 12 - 2 * getNonNullHandLength()) + "|";
        lineFive = stringMultiply("_", n);
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThree);
        System.out.println(lineFour);
        System.out.println(lineFive);
    }
}