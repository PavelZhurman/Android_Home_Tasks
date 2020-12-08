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

public class SecondActivity extends AppCompatActivity implements Observer {
    private Observable observableActivity;
//   Logic logic = new Logic();

    private int sum;
    private double average;
    private double magicNumbers;

    ArrayList arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        observableActivity = Data.getInstance();
        observableActivity.registerObserver(this);
        Data data = Data.getInstance();

        TextView textView4 = findViewById(R.id.textView_array_list_second_activity);
       textView4.setText("" + data.getNumbersArrayList());

        arrayList = data.getNumbersArrayList();



        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sum =  data.sumOfAllNumbers(arrayList);
                Data.getInstance().setSum(sum);
                System.out.println("numb sum=" + sum);
                average = data.calculationOfTheArithmeticMean(arrayList);

                System.out.println("numb average=" + average);
                Data.getInstance().setAverage(average);
                magicNumbers = data.magicActions(arrayList);
                Data.getInstance().setMagicNumbers(magicNumbers);
                System.out.println("numb mn" + magicNumbers);

                Data.getInstance().setSum(sum);
                Data.getInstance().setAverage(average);
                Data.getInstance().setMagicNumbers(magicNumbers);
                observableActivity.notifyObservers();
                finish();
            }
        });

    }



    @Override
    public void update(Data data) {

        data.getInstance().setSum(sum);
        data.getInstance().setAverage(average);
        data.getInstance().setMagicNumbers(magicNumbers);
    }


}

