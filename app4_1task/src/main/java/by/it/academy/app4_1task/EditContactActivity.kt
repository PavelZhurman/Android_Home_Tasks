package by.it.academy.app4_1task


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class EditContactActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmailOrPhoneNumber: EditText
    private lateinit var buttonApply: ImageButton
    private lateinit var buttonDeletedContact: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        editTextName = findViewById(R.id.editTextNameEditContact)
        editTextEmailOrPhoneNumber = findViewById(R.id.editTextEmailOrPhoneEditContact)
        buttonApply = findViewById(R.id.buttonEditContactApply)
        buttonDeletedContact = findViewById(R.id.buttonRemoveEditContact)

        findViewById<ImageButton>(R.id.buttonBackInToolbarEditContact).setOnClickListener {
            setResult(RESULT_CANCELED, intent)
            finish()
        }

        val position = intent.getIntExtra("position", 0)
        var name = intent.getStringExtra("name")
        var emailOrPhoneNumber = intent.getStringExtra("emailOrPhoneNumber")
        val image = intent.getIntExtra("image", 0)

        editTextName.setText(name)
        editTextEmailOrPhoneNumber.setText(emailOrPhoneNumber)

        buttonDeletedContact.setOnClickListener {
            ContactManager.ContactListManager.deleteContactFromList(position)
            intent.putExtra("delete", position)
            setResult(RESULT_OK, intent)
            finish()
        }

        buttonApply.setOnClickListener {
            name = editTextName.text.toString()
            emailOrPhoneNumber = editTextEmailOrPhoneNumber.text.toString()

            if (name != null && emailOrPhoneNumber != null) {

                if (name!!.isNotBlank()) {
                    val contact = Contact(image, name!!, emailOrPhoneNumber!!)
                    ContactManager.ContactListManager.editContactInList(position, contact)
                    intent.putExtra("edit", position)
                    setResult(RESULT_OK, intent)
                    finish()
                }

            }
        }

    }
}