import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Dealer extends Player {
    public boolean play = false;

    public Dealer() {
        super();
    }

    public Dealer(String name, Card[] hand) {
        super(name, hand);
    }

    public String printHand() {
        String introString = "This is the dealer's hand: ";
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
        String totalString = introString + "\n" + lineOne + "\n" + lineTwo + "\n" + lineThree + "\n" + lineFour + "\n"
                + lineFive + "\nTotal: " + this.total;
        return totalString;
    }

    public String printShowHand() {
        String returnString = super.printHand();
        returnString = returnString.substring(18);
        return returnString;
    }

    public void decisionMaker(ArrayList<Card> deck) {
        this.computeTotal();
        Random rand = new Random();
        while (this.computeTotal() < 21 && this.getNonNullHandLength() < 5) {

            if (getNonNullHandLength() == 2) {
                if (this.computeTotal() <= 16) {
                    this.draw(deck);
                } else if (this.computeTotal() >= 17) {
                    break;
                }
            } else if (getNonNullHandLength() == 3) {
                if (this.computeTotal() >= 17) {
                    break;
                } else {

                    Double r = rand.nextDouble();
                    r = Double.parseDouble(new DecimalFormat("#.00").format(r));
                    if (r <= 0.67) {
                        this.draw(deck);
                    } else {
                        break;
                    }
                }
            } else if (getNonNullHandLength() == 4) {
                if (this.computeTotal() >= 17) {
                    break;
                } else {
                    Double r = Double.parseDouble(new DecimalFormat("#.00").format(rand.nextDouble()));
                    if (r <= 0.22) {
                        this.draw(deck);
                    } else {
                        break;
                    }
                }
            }

        }
        System.out.println("Exiting Decision Maker!");

    }

    public void draw(ArrayList<Card> deck) {
        Random rand = new Random();
        int seed = rand.nextInt();
        rand.setSeed(seed);
        int cardDraw = rand.nextInt(deck.size());
        Card drawnCard = deck.get(cardDraw);
        deck.remove(cardDraw);
        for (int i = 0; i < hand.length; i++) {

            if (hand[i] == null) {
                hand[i] = drawnCard;
                System.out.println(hand[i]);
                System.out.println(this.getName() + " drew a Card!\n");

                break;
            }
        }
    }

}