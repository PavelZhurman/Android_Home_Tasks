package by.it.academy.app2task.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import by.it.academy.app2task.Observable;
import by.it.academy.app2task.Observer;
import by.it.academy.app2task.R;
import by.it.academy.app2task.entity.Data;



public class FirstActivity extends AppCompatActivity implements Observer {

    private Observable observableActivity;
    private int sum;
    private double average;
    private double magicNumbers;

    private TextView textViewSum;
    private TextView textViewAverage;
    private TextView textViewMagicNumber;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        observableActivity = Data.getInstance();
        observableActivity.registerObserver(this);


        findViewById(R.id.init).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Data.getInstance().initializeHashSet(Data.getInstance());
               Data.getInstance().hashSetToArrayList();

                TextView textView112 = findViewById(R.id.textView_array_list);
                textView112.setText("" + Data.getInstance().getNumbersArrayList());

                TextView textView = findViewById(R.id.textView_quantity);
                textView.setText(getString((R.string.amount_of_numbers), Data.getInstance().getQuantity()));

            }
        });

        findViewById(R.id.button_calculate_data).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void update(Data data) {

        textViewSum = findViewById(R.id.textViewSum);
        textViewAverage = findViewById(R.id.textView_average);
        textViewMagicNumber = findViewById(R.id.textView_magic_number);


        this.magicNumbers = Data.getInstance().getMagicNumbers();
        this.average = Data.getInstance().getAverage();
        this.sum = Data.getInstance().getSum();

        String textTemp = getString(R.string.sum_of_all_numbers) + " " + sum;
        textViewSum.setText(textTemp);

        textTemp = getString(R.string.numbers_average) + " " + average;

        textViewAverage.setText(textTemp);

        textTemp = getString(R.string.magic_number) + " " + magicNumbers;
        textViewMagicNumber.setText(textTemp);
    }

}
