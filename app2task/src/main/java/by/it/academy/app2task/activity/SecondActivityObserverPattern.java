package by.it.academy.app2task.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


import by.it.academy.app2task.Observable;
import by.it.academy.app2task.Observer;
import by.it.academy.app2task.R;
import by.it.academy.app2task.entity.Data;
import by.it.academy.app2task.entity.DataResult;
import by.it.academy.app2task.logic.strategy.CalculationOfTheArithmeticMean;
import by.it.academy.app2task.logic.strategy.MagicActions;
import by.it.academy.app2task.logic.strategy.Strategy;
import by.it.academy.app2task.logic.strategy.SumOfAllNumbers;

public class SecondActivityObserverPattern extends AppCompatActivity implements Observer {
    private Observable observableActivity;

    private double sum;
    private double average;
    private double magicNumbers;
    Strategy strategy;
    ArrayList<Integer> numbersList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        observableActivity = Data.getInstance();

        observableActivity.registerObserver(this);

        Data data = Data.getInstance();

        TextView textView4 = findViewById(R.id.textView_array_list_second_activity);
        textView4.setText("" + data.getNumbersArrayList());

        numbersList = data.getNumbersArrayList();


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                strategy = new CalculationOfTheArithmeticMean();
                average = strategy.mathematicalCalculations(numbersList);
                data.setAverage(average);
                System.out.println("data " + average);

                strategy = new SumOfAllNumbers();
                sum = strategy.mathematicalCalculations(numbersList);
                data.setSum(sum);
                System.out.println("data " + sum);

                strategy = new MagicActions();
                magicNumbers = strategy.mathematicalCalculations(numbersList);
                data.setMagicNumbers(magicNumbers);
                System.out.println("data " + magicNumbers);

                data.notifyObservers();
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        observableActivity.removeObserver(this);
    }

    @Override
    public void update(Data data) {

        data.setSum(sum);
        data.setAverage(average);
        data.setMagicNumbers(magicNumbers);
    }


}

