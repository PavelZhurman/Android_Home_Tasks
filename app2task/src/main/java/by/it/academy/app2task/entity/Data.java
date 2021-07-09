package by.it.academy.app2task.entity;

import java.util.ArrayList;
import java.util.HashSet;

import by.it.academy.app2task.Observable;
import by.it.academy.app2task.Observer;


public class Data implements Observable{
    private int quantity;
    private static Data INSTANCE = null;

    private HashSet<Integer> numbersHashSet;
    private ArrayList<Integer> numbersArrayList;

    private static final ArrayList<Observer> observers = new ArrayList<>();

    private double sum;
    private double average;
    private double magicNumbers;

    public Data() {
        numbersArrayList = new ArrayList<>();
        numbersHashSet = new HashSet<>();
    }

    public static Data getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Data();
        }
        return INSTANCE;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getSum() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Integer> getNumbersArrayList() {
        return numbersArrayList;
    }

    public void setNumbersArrayList(ArrayList<Integer> numbersArrayList) {
        this.numbersArrayList = numbersArrayList;
    }

    public HashSet<Integer> getNumbersHashSet() {
        return numbersHashSet;
    }

    public void addNumberToHashSet(int number) {
        numbersHashSet.add(number);
    }

    public int getNumbersHashSetSize() {
        return numbersHashSet.size();
    }

    public void setNumbersHashSet(HashSet<Integer> numbersHashSet) {
        this.numbersHashSet = numbersHashSet;
    }



    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
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
}
