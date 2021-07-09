package by.it.academy.app2task.logic.strategy;

import java.util.ArrayList;

public class MagicActions implements Strategy {
    @Override
    public double mathematicalCalculations(ArrayList<Integer> arrayList) {
        double result;
        double firstHalf = 0.0;
        double secondHalf = 0.0;

        int temp = arrayList != null ? arrayList.size() : 1;

        temp = temp / 2;
        for (int i = 0; i < temp; i++) {

            firstHalf += arrayList.get(i);
        }
        for (int i = temp; i < arrayList.size(); i++) {
            secondHalf -= arrayList.get(i);
        }
        result = firstHalf / secondHalf;

        return result;
    }
}
