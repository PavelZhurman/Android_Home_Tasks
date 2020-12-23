package by.it.academy.app2task.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import by.it.academy.app2task.R;
import by.it.academy.app2task.logic.strategy.CalculationOfTheArithmeticMean;
import by.it.academy.app2task.logic.strategy.MagicActions;
import by.it.academy.app2task.logic.strategy.Strategy;
import by.it.academy.app2task.logic.strategy.SumOfAllNumbers;

public class SecondActivity extends AppCompatActivity {

    private double calculationOfTheArithmeticMean = 0.0;
    private double magicNumber = 0.0;
    private double sum = 0.0;
    Strategy strategy;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ArrayList<Integer> numbersArrayList = getIntent().getIntegerArrayListExtra("data");

        TextView textView = findViewById(R.id.textView_array_list_second_activity);
        textView.setText("" + numbersArrayList);

        strategy = new CalculationOfTheArithmeticMean();
        calculationOfTheArithmeticMean = strategy.mathematicalCalculations(numbersArrayList);

        strategy = new SumOfAllNumbers();
        sum = strategy.mathematicalCalculations(numbersArrayList);

        strategy = new MagicActions();
        magicNumber = strategy.mathematicalCalculations(numbersArrayList);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,FirstActivity.class);
                intent.putExtra("sum", sum);
                intent.putExtra("magicNumber", magicNumber);
                intent.putExtra("calculationOfTheArithmeticMean", calculationOfTheArithmeticMean);
                startActivity(intent);
            }
        });
    }
}
