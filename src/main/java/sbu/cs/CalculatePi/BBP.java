package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;

public class BBP implements Runnable {
    MathContext mathContext;
    final int count = 100;
    BigDecimal sum;
    BigDecimal n;

    public BBP(BigDecimal n){
        mathContext = new MathContext(1003);
        this.n = n;
        sum = new BigDecimal(0);
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            BigDecimal a = new BigDecimal(1);
            BigDecimal a2 = new BigDecimal(16);
            a2 = a2.pow(Integer.parseInt(n.toString()));
            a = a.divide(a2, mathContext);

            BigDecimal numerator1 = new BigDecimal(4);
            BigDecimal numerator2 = new BigDecimal(-2);
            BigDecimal numerator3 = new BigDecimal(-1);
            BigDecimal numerator4 = new BigDecimal(-1);

            BigDecimal denominator1 = new BigDecimal(8*Integer.parseInt(n.toString()) + 1);
            BigDecimal denominator2 = new BigDecimal(8*Integer.parseInt(n.toString()) + 4);
            BigDecimal denominator3 = new BigDecimal(8*Integer.parseInt(n.toString()) + 5);
            BigDecimal denominator4 = new BigDecimal(8*Integer.parseInt(n.toString()) + 6);

            numerator1 = numerator1.divide(denominator1, mathContext);
            numerator2 = numerator2.divide(denominator2, mathContext);
            numerator3 = numerator3.divide(denominator3, mathContext);
            numerator4 = numerator4.divide(denominator4, mathContext);

            BigDecimal b = numerator1.add(numerator2.add(numerator3.add(numerator4)));

            sum = sum.add(a.multiply(b, mathContext));
            n = n.add(new BigDecimal(1));
        }
        PiCalculator.addToPI(sum);
    }
}
