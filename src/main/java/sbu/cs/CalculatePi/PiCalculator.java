package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {

    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     Experiment with different algorithms to find accurate results.

     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.

     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */

    public static BigDecimal PI;
    public static synchronized void addToPI(BigDecimal value){
        PI = PI.add(value);
    }

    public BigDecimal Leibniz_Formula(int floatingPoint) throws InterruptedException {
        PI = new BigDecimal(0, new MathContext(floatingPoint));
        BigDecimal n = new BigDecimal(0);
        ExecutorService threadPool =  Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            Leibniz_Formula leibnizFormula = new Leibniz_Formula(floatingPoint, n);
            n = n.add(new BigDecimal(100));
            threadPool.execute(leibnizFormula);
        }
        threadPool.shutdown();
        threadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
        return PI;
    }

    public String calculate(int floatingPoint) throws InterruptedException {
        BigDecimal pi = Leibniz_Formula(floatingPoint);
        return pi.toString();
    }

    public static void main(String[] args) {
        // Use the main function to test the code yourself
    }
}
