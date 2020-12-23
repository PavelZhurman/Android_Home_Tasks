package by.it.academy.app2task.logic;

import java.util.ArrayList;
import java.util.HashSet;

import by.it.academy.app2task.entity.Data;


public class Logic {


    public void initializeQuantity(Data data) {
        do {
            data.setQuantity(4 + (int) (Math.random() * 100));
        } while (data.getQuantity() % 2 != 0);
    }

    public void initializeHashSet(Data data) {
        data.setNumbersHashSet(new HashSet<>());
        initializeQuantity(data);

        while (!((data.getNumbersHashSetSize()) == data.getQuantity())) {
            int z = (int) (Math.random() * 500);

            data.addNumberToHashSet(z);
        }
    }

    public ArrayList<Integer> hashSetToArrayList(Data data) {

        return new ArrayList<>(data.getNumbersHashSet());
    }
}
