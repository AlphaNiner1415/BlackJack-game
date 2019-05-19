public class Test{
    public static void main(String[] args) {
        //System.out.println('\u2663');
        // System.out.printf("%s"+"%s","Hi","hi");
        Card This = new Card("clubs","A");
        Card[] a = {This};
        Player player1 = new Player("John", a);
        System.out.println(This.getSymbol());
    }
}