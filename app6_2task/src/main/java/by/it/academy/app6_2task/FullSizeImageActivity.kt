package by.it.academy.app6_2task

import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class FullSizeImageActivity : AppCompatActivity() {

    private lateinit var imageFull: ImageView
    private lateinit var textViewImagePath: TextView
    private lateinit var buttonBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_size_image)

        imageFull = findViewById(R.id.imageFull)
        textViewImagePath = findViewById(R.id.textViewImagePath)
        buttonBack = findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener { finish() }

        val uri = intent.getParcelableExtra<Uri>("uri")
        if (uri != null) {
            Glide.with(this).load(uri).into(imageFull)
            textViewImagePath.text = uri.path
        }
    }
}