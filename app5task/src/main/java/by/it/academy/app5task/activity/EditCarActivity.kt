package by.it.academy.app5task.activity

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import by.it.academy.app5task.R
import by.it.academy.app5task.database.DatabaseCars
import by.it.academy.app5task.entity.CarItem
import by.it.academy.app5task.functions.createDirectory
import by.it.academy.app5task.functions.saveImage
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

private const val PHOTO_CODE_REQUEST = 10

class EditCarActivity : AppCompatActivity() {

    private lateinit var currentPhotoPath: String
    private lateinit var carPhotoImageView: ImageView
    private var pathImage: String? = null
    private var newPhotoLoaded = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_car)

        val ownerNameEditText: EditText = findViewById(R.id.editTextOwnerName)
        val producerEditText: EditText = findViewById(R.id.editTextProducer)
        val modelEditText: EditText = findViewById(R.id.editTextModel)
        val plateNumberEditText: EditText = findViewById(R.id.editTextPlateNumber)
        carPhotoImageView = findViewById(R.id.carPhoto)

        val dao = DatabaseCars.init(this).getCarDatabaseDAO()

        val car: CarItem? = intent.getParcelableExtra("carItem")
        ownerNameEditText.setText(car?.customerName)
        producerEditText.setText(car?.producer)
        modelEditText.setText(car?.carModel)
        plateNumberEditText.setText(car?.carPlate)
        if (!car?.pathImage.isNullOrEmpty()) {
            carPhotoImageView.setImageURI(car?.pathImage?.toUri())
        }


        findViewById<ImageButton>(R.id.buttonBack).setOnClickListener { finish() }


        findViewById<ImageButton>(R.id.buttonApply).setOnClickListener {
            if (car != null) {

                val ownerName = ownerNameEditText.text.toString()
                val producer = producerEditText.text.toString()
                val model = modelEditText.text.toString()
                val plateNumber = plateNumberEditText.text.toString()
                if (newPhotoLoaded) {
                    pathImage = currentPhotoPath
                } else {
                    if (car.pathImage.isNullOrEmpty()) {
                        pathImage = null
                    } else {
                        pathImage = car.pathImage.toString()
                    }

                }

                if (ownerName.isNotEmpty() && producer.isNotEmpty() && model.isNotEmpty() && plateNumber.isNotEmpty()) {
                    val carItem = CarItem(ownerName, producer, model, plateNumber, pathImage)
                    try {
                        dao.updateCar(carItem)
                        finishActivity()
                    } catch (e: Exception) {
                        Toast.makeText(this, getString(R.string.car_with_this_number_already_exists), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, getString(R.string.all_fields_must_be_filled), Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<FloatingActionButton>(R.id.addPhoto).setOnClickListener {
            intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, PHOTO_CODE_REQUEST)
        }
    }

    private fun finishActivity() {
        setResult(RESULT_OK)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            data.extras?.get("data").run {
                currentPhotoPath = createDirectory(applicationContext)?.let { saveImage(this as Bitmap, carPhotoImageView, it) }.toString()
                newPhotoLoaded = true
            }
        }
    }

}