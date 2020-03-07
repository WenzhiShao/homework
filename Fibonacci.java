
import java.math.BigDecimal;
public class Fibonacci{
    public static BigDecimal of(int num) {
        if( num == 1 || num == 2)
        return new BigDecimal(1);
        BigDecimal pre1 = new BigDecimal(1);
        BigDecimal pre2 = new BigDecimal(1);
        BigDecimal res = new BigDecimal(0);
        for(int i = 3; i <= num; i++) {
            res = pre1.add(pre2);
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }

    public static void main(String [] args) {
        for(int i = 0; i < 200; i++) {
            System.out.println(Fibonacci.of(i));
        }
    }
}