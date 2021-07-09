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

        findViewById(R.id.first_button_linear_layout).setOnClickListener(onClickListener);
        findViewById(R.id.first_button_table_layout).setOnClickListener(onClickListener);

        findViewById(R.id.second_button_linear_layout).setOnClickListener(onClickListener);
        findViewById(R.id.second_button_constraint_layout).setOnClickListener(onClickListener);
        findViewById(R.id.second_button_relative_layout).setOnClickListener(onClickListener);

        findViewById(R.id.third_button_linear_layout).setOnClickListener(onClickListener);
        findViewById(R.id.third_button_constraint_layout).setOnClickListener(onClickListener);
        findViewById(R.id.third_button_relative_layout).setOnClickListener(onClickListener);

        findViewById(R.id.fourth_button_linear_layout).setOnClickListener(onClickListener);
        findViewById(R.id.fourth_button_constraint_layout).setOnClickListener(onClickListener);
        findViewById(R.id.fourth_button_relative_layout).setOnClickListener(onClickListener);

        findViewById(R.id.fifth_button_layout).setOnClickListener(onClickListener);



    }
}