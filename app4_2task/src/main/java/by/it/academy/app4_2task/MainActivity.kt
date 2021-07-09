package by.it.academy.app4_2task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var switch: SwitchCompat
    private lateinit var customView: CircleCustomView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app4_2task)
        customView = findViewById(R.id.customView)

        switch = findViewById(R.id.switchCompat)

        customView.customClickListener = { x: Int, y: Int, color: Int ->
            if (!switch.isChecked) {
                Snackbar.make(customView, "x= $x, y= $y", Snackbar.LENGTH_SHORT).setTextColor(color).show()
            } else {
                Toast.makeText(application, "x= $x, y= $y", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

