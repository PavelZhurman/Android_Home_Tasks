package by.it.academy.app3task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.first_button_table_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivityTableLayout.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.first_button_linear_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivityLinearLayout.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.second_button_linear_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivityLinearLayout.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.second_button_constraint_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivityConstraintLayout.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.second_button_relative_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, SecondActivityRelativeLayout.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.third_button_linear_layout).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,ThirdActivityLinearLayout.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.third_button_constraint_layout).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivityConstraintLayout.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.third_button_relative_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, ThirdActivityRelativeLayout.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.fourth_button_linear_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, FourthActivityLinearLayout.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.fourth_button_constraint_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, FourthActivityConstraintLayout.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.fourth_button_relative_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, FourthActivityRelativeLayout.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.fifth_button_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, FifthActivityLayout.class);
                startActivity(intent);
            }
        });
    }
}