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

        Button button1 = findViewById(R.id.first_button_linear_layout);
        Button button2 = findViewById(R.id.first_button_table_layout);

        Button button3 = findViewById(R.id.second_button_linear_layout);
        Button button4 = findViewById(R.id.second_button_constraint_layout);
        Button button5 = findViewById(R.id.second_button_relative_layout);

        Button button6 = findViewById(R.id.third_button_linear_layout);
        Button button7 = findViewById(R.id.third_button_constraint_layout);
        Button button8 = findViewById(R.id.third_button_relative_layout);

        Button button9 = findViewById(R.id.fourth_button_linear_layout);
        Button button10 = findViewById(R.id.fourth_button_constraint_layout);
        Button button11 = findViewById(R.id.fourth_button_relative_layout);

        Button button12 = findViewById(R.id.fifth_button_layout);


        View.OnClickListener onClickListener = v -> {
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            switch (v.getId()) {
                case R.id.first_button_linear_layout:
                    intent.putExtra("id", R.layout.activity_first_linear_layout);
                    intent.putExtra("theme", R.style.Widget_AppCompat_Light_ActionBar);
                    startActivity(intent);
                    break;
                case R.id.first_button_table_layout:
                    intent.putExtra("id", R.layout.activity_first_table_layout);
                    intent.putExtra("theme", R.style.Widget_AppCompat_ActionBar);
                    startActivity(intent);
                    break;
                case R.id.second_button_linear_layout:
                    intent.putExtra("id", R.layout.activity_second_linear_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);
                    startActivity(intent);
                    break;
                case R.id.second_button_constraint_layout:
                    intent.putExtra("id", R.layout.activity_second_constraint_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);
                    startActivity(intent);
                    break;
                case R.id.second_button_relative_layout:
                    intent.putExtra("id", R.layout.activity_second_relative_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);
                    startActivity(intent);
                    break;
                case R.id.third_button_linear_layout:
                    intent.putExtra("id", R.layout.activity_third_linear_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);
                    startActivity(intent);
                    break;

                case R.id.third_button_constraint_layout:
                    intent.putExtra("id", R.layout.activity_third_constraint_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);
                    startActivity(intent);
                    break;

                case R.id.third_button_relative_layout:
                    intent.putExtra("id", R.layout.activity_third_relative_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);
                    startActivity(intent);
                    break;
                case R.id.fourth_button_linear_layout:
                    intent.putExtra("id", R.layout.activity_fourth_linear_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);
                    startActivity(intent);
                    break;
                case R.id.fourth_button_constraint_layout:
                    intent.putExtra("id", R.layout.activity_fourth_constraint_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);
                    startActivity(intent);
                    break;
                case R.id.fourth_button_relative_layout:
                    intent.putExtra("id", R.layout.activity_fourth_relative_layout);
                    intent.putExtra("theme", R.style.Theme_AppCompat_Light_NoActionBar);

                    startActivity(intent);
                    break;
                case R.id.fifth_button_layout:
                    Intent intent2 = new Intent(MainActivity.this, FifthActivityLayout.class);
                    intent2.putExtra("theme", R.style.Theme_AppCompat_Light_DarkActionBar);
                    intent2.putExtra("id", R.layout.activity_fifth_layout);
                    startActivity(intent2);
                    break;
            }
        };

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
        button9.setOnClickListener(onClickListener);
        button10.setOnClickListener(onClickListener);
        button11.setOnClickListener(onClickListener);
        button12.setOnClickListener(onClickListener);


    }
}