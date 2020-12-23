package by.it.academy.app3task;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(getIntent().getIntExtra("theme", 0));
        setContentView(getIntent().getIntExtra("id", 0));
    }
}
