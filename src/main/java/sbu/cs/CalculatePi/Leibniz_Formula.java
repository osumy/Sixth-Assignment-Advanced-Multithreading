package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Leibniz_Formula implements Runnable{
    MathContext mathContext;
    final int count = 100000;
    BigDecimal sum;
    BigDecimal n;

    public Leibniz_Formula(BigDecimal n){
        mathContext = new MathContext(1003);
        this.n = n;
        sum = new BigDecimal(0);
    }

    @Override
    public void run() {
        BigDecimal numerator = new BigDecimal(-4);
        for (int i = 0; i < count; i++) {
            numerator = numerator.multiply(new BigDecimal(-1), mathContext);
            BigDecimal denominator = new BigDecimal(n.multiply(new BigDecimal(2)).add(new BigDecimal(1)).toString(), mathContext);
            sum = sum.add(numerator.divide(denominator, mathContext));
            n = n.add(new BigDecimal(1));
        }
        PiCalculator.addToPI(sum);
    }
}
