package by.it.academy.app2task.logic.strategy;


import java.util.ArrayList;

public class CalculationOfTheArithmeticMean implements Strategy {

    @Override
    public double mathematicalCalculations(ArrayList<Integer> arrayList) {

        int sum = 0;
        double result;
        for (double i : arrayList) {
            sum += i;
        }
        result = (double) sum / (double) arrayList.size();

        return result;

    }
}
