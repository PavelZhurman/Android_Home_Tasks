package by.it.academy.app2task.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import by.it.academy.app2task.R;
import by.it.academy.app2task.entity.Data;
import by.it.academy.app2task.logic.Logic;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
        Data data = new Data();
        TextView textView = findViewById(R.id.textViewSum);
        String temp = getString(R.string.sum_of_all_numbers) + " " +
                String.valueOf(getIntent().
                        getDoubleExtra("sum",
                                0.0));
        textView.setText(temp);

        textView = findViewById(R.id.textView_average);
        temp = getString(R.string.numbers_average) + " " +
                String.valueOf(getIntent().
                        getDoubleExtra("calculationOfTheArithmeticMean",
                                0.0));
        textView.setText(temp);

        textView = findViewById(R.id.textView_magic_number);
        temp = getString(R.string.magic_number) + " " +
                String.valueOf(getIntent().
                        getDoubleExtra("magicNumber",
                                0.0));
        textView.setText(temp);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Data data = Data.getInstance();
        Logic logic = new Logic();

        findViewById(R.id.button_init_array).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.initializeHashSet(data);
                data.setNumbersArrayList(logic.hashSetToArrayList(data));

                TextView textView = findViewById(R.id.textView_quantity);
                String temp = getString(R.string.amount_of_numbers) + " " +
                        String.valueOf(data.getQuantity());
                textView.setText(temp);
            }
        });


        findViewById(R.id.button_calculate_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putIntegerArrayListExtra("data", data.getNumbersArrayList());
                startActivity(intent);

            }
        });


    }


}
