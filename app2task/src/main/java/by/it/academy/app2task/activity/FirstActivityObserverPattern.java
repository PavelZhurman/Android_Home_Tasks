package by.it.academy.app2task.activity;

import android.content.Intent;
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
import by.it.academy.app2task.logic.Logic;


public class FirstActivityObserverPattern extends AppCompatActivity implements Observer {

    private Observable observableActivity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        observableActivity = Data.getInstance();
        observableActivity.registerObserver(this);

        DataResult dataResult = new DataResult();
        Data data = Data.getInstance();
        Logic logic = new Logic();


        findViewById(R.id.button_init_array).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.initializeHashSet(Data.getInstance());
                data.setNumbersArrayList(logic.hashSetToArrayList(Data.getInstance()));

                TextView textView = findViewById(R.id.textView_array_list);
                textView.setText("" + (data.getNumbersArrayList()));

                textView = findViewById(R.id.textView_quantity);
                String temp = getString(R.string.amount_of_numbers) + " " + data.getQuantity();
                textView.setText(temp);


            }
        });

        findViewById(R.id.button_calculate_data).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivityObserverPattern.this, SecondActivityObserverPattern.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void update(Data data) {

        TextView textViewSum = findViewById(R.id.textViewSum);
        TextView textViewAverage = findViewById(R.id.textView_average);
        TextView textViewMagicNumber = findViewById(R.id.textView_magic_number);

        String textTemp = getString(R.string.sum_of_all_numbers) + " " + data.getSum();
        textViewSum.setText(textTemp);

        textTemp = getString(R.string.numbers_average) + " " + data.getAverage();

        textViewAverage.setText(textTemp);

        textTemp = getString(R.string.magic_number) + " " + data.getMagicNumbers();
        textViewMagicNumber.setText(textTemp);
    }


}
