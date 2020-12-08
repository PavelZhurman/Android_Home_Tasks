package by.it.academy.app2task.entity;


import java.util.ArrayList;
import java.util.HashSet;


import by.it.academy.app2task.Observable;
import by.it.academy.app2task.Observer;


public class Data implements Observable {
    private int quantity;

    private static Data INSTANCE = null;

    private final ArrayList<Observer> observers;

    private int sum;
    private double average;
    private double magicNumbers;

    private HashSet<Integer> numbersHashSet;
    private ArrayList<Integer> numbersArrayList;

    public Data() {

        this.observers = new ArrayList<>();

        this.numbersHashSet = new HashSet<>();
        this.numbersArrayList = new ArrayList<>();


    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setMagicNumbers(double magicNumbers) {
        this.magicNumbers = magicNumbers;
    }

    public double getMagicNumbers() {
        return magicNumbers;
    }

    public static Data getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Data();
        }
        return INSTANCE;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addNumberToHashSet(int number) {
        this.numbersHashSet.add(number);
    }

    public void hashSetToArrayList() {
        this.numbersArrayList = new ArrayList<>(this.numbersHashSet);
        notifyObservers();

    }

    public int getHashSetSize() {
        return this.numbersHashSet.size();
    }

    public ArrayList<Integer> getNumbersArrayList() {
        return numbersArrayList;
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(INSTANCE);
        }
    }

    public double calculationOfTheArithmeticMean(ArrayList<Integer> arrayList) {

        int sum = 0;
        double result;
        for (double i : arrayList) {
            sum += i;
        }
        result = (double) sum / (double) arrayList.size();

        return result;

    }

    public int sumOfAllNumbers(ArrayList<Integer> arrayList) {
        int result = 0;
        for (int i : arrayList) {
            result += i;
        }

        return result;
    }

    public double magicActions(ArrayList<Integer> arrayList) {
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

    public void initializeQuantity(Data data) {

        do {
            data.setQuantity(4 + (int) (Math.random() * 100));
        } while (data.getQuantity() % 2 != 0);

    }

    public void initializeHashSet(Data data) {
        this.numbersHashSet = new HashSet<>();
        initializeQuantity(data);

        while (!((data.getHashSetSize()) == data.getQuantity())) {
            int z = (int) (Math.random() * 500);

            data.addNumberToHashSet(z);

        }

    }

}
