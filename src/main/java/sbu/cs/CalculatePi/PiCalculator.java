package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {

    public static BigDecimal PI;
    public static synchronized void addToPI(BigDecimal value){
        PI = PI.add(value);
    }

    public BigDecimal Leibniz_Formula() throws InterruptedException {
        PI = new BigDecimal(0);
        BigDecimal n = new BigDecimal(0);
        ExecutorService threadPool =  Executors.newFixedThreadPool(8);
        for (int i = 0; i < 100; i++) {
            Leibniz_Formula leibnizFormula = new Leibniz_Formula(n);
            n = n.add(new BigDecimal(100000));
            threadPool.execute(leibnizFormula);
        }
        threadPool.shutdown();
        threadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
        return PI;
    }

    // BBP
    public BigDecimal Bailey_Borwein_Plouffe_Formula() throws InterruptedException {
        PI = new BigDecimal(0);
        BigDecimal n = new BigDecimal(0);
        ExecutorService threadPool =  Executors.newFixedThreadPool(8);
        for (int i = 0; i < 100; i++) {
            BBP bbp = new BBP(n);
            n = n.add(new BigDecimal(100));
            threadPool.execute(bbp);
        }
        threadPool.shutdown();
        threadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
        return PI;
    }

    public String calculate(int floatingPoint) throws InterruptedException {
        BigDecimal pi = Bailey_Borwein_Plouffe_Formula();
        return pi.toString().substring(0, 2+floatingPoint);
    }

    public static void main(String[] args) {
    }
}
