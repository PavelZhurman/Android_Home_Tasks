package by.it.academy.app2task.logic.strategy;

import java.util.ArrayList;

public class SumOfAllNumbers implements Strategy {


    @Override
    public double mathematicalCalculations(ArrayList<Integer> arrayList) {

        int result = 0;
        for (int i : arrayList) {
            result += i;
        }

        return result;
    }
}

