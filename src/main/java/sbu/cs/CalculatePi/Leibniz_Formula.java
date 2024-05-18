package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;

public class Leibniz_Formula implements Runnable{
    MathContext mathContext;
    final int count = 100;
    BigDecimal sum;
    BigDecimal n;

    public Leibniz_Formula(int floatingPoint, BigDecimal n){
        mathContext = new MathContext(floatingPoint);
        this.n = n;
        sum = new BigDecimal(0);
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            BigDecimal numerator = new BigDecimal(4, mathContext);
            if (n.divideAndRemainder(new BigDecimal(2), mathContext)[1].equals(new BigDecimal(1))){
                numerator = numerator.multiply(new BigDecimal(-1), mathContext);
            }
            BigDecimal denominator = new BigDecimal(n.multiply(new BigDecimal(2), mathContext).add(new BigDecimal(1), mathContext).toString(), mathContext);
            sum = sum.add(numerator.divide(denominator), mathContext);
            PiCalculator.addToPI(sum);
            n = n.add(new BigDecimal(1));
        }
    }
}
