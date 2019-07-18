import java.text.DecimalFormat;
import java.util.Random;
public class Test{
    public static void main(String[] args) {
        //System.out.println("This is your hand:".length());
        Random rand = new Random();
        Double d = rand.nextDouble();
        Double r = rand.nextDouble();
        r = Double.parseDouble(new DecimalFormat("#.00").format(r));
        System.out.println(r);
    }
}