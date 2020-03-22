import java.util.*;

public class Player {
    protected Card[] hand;
    protected int total;
    protected int money;
    protected String name;

    public Player() {
        this.hand = new Card[5];
        this.total = 0;
        this.money = 1000;
    }

    public Player(String name, Card[] hand) {
        this.name = name;
        this.hand = new Card[5];
        for (int i = 0; i < this.hand.length; i++) {
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
        this.computeTotal();
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

    public int computeTotal() {
        total = 0;
        boolean flag = false;
        for (int i = 0; i < getNonNullHandLength(); i++) {
            if (hand[i].getCardNo() == "A") {
                flag = true;
                continue;
            } else {
                this.total += this.hand[i].getValue();
            }
        }
        if (flag) {
            if (this.total + 11 > 21) {
                this.total += 1;
            } else {
                this.total += 11;
            }
        }
        return total;
    }
    /**
     * Method that draws a random card from the remaining cards in the deck.
     * Also giving feedback to the screen that you drew a card, and recomputes the total of the player's hand.
     * @param deck
     *            The deck of cards
     */
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
                System.out.println(this.getName() + " drew a Card!");
                this.computeTotal();
                break;
            }
        }
    }

    public int getNonNullHandLength() {
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                count++;
            }
        }
        return count;
    }

    public boolean checkGameOver() {
        if (this.computeTotal() > 21) {
            return true;
        } else {
            return false;
        }
    }

    public String printHand() {

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        String lineOne = "_______________";
        String lineTwo = String.format("| %s  ", hand[0].getCardNo());
        String lineThree = String.format("| %c  ", hand[0].getSymbol());
        String lineFour = "|    ";
        String lineFive = "_______________";
        for (int i = 1; i < getNonNullHandLength(); i++) {
            sb.append(String.format("| %s  ", hand[i].getCardNo()));
            sb2.append(String.format("| %c  ", hand[i].getSymbol()));
            sb3.append("|    ");
        }
        int n = (getNonNullHandLength() + 4) * 3;
        lineOne = stringMultiply("_", n);
        lineTwo += sb.toString() + stringMultiply(" ", 12 - 2 * getNonNullHandLength()) + "|"; // This here is the way
                                                                                               // to go change all the
                                                                                               // other loops to this
        lineThree += sb2.toString() + stringMultiply(" ", 12 - 2 * getNonNullHandLength()) + "|";
        lineFour += sb3.toString() + stringMultiply(" ", 12 - 2 * getNonNullHandLength()) + "|";
        lineFive = stringMultiply("_", n);
        String introString = "This is your hand:";
        String totalString = introString + "\n" + lineOne + "\n" + lineTwo + "\n" + lineThree + "\n" + lineFour + "\n"
                + lineFive + "\nTotal: " + this.total;
        return totalString;
    }

    public static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public void clearHand() {
        for (int i = 0; i < 5; i++) {
            hand[i] = null;
        }
    }

}