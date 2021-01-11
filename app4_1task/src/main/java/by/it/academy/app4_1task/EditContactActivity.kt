package by.it.academy.app4_1task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class EditContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        val editTextName = findViewById<EditText>(R.id.editTextNameEditContact)
        val editTextEmailOrPhoneNumber = findViewById<EditText>(R.id.editTextEmailOrPhoneEditContact)
        val buttonApply = findViewById<ImageButton>(R.id.buttonEditContactApply)

        val buttonDeletedContact = findViewById<Button>(R.id.buttonRemoveEditContact)

        findViewById<ImageButton>(R.id.buttonBackInToolbarEditContact).setOnClickListener { finish() }

        val position = intent.getIntExtra("position", 0)
        var name = intent.getStringExtra("name")
        var emailOrPhoneNumber = intent.getStringExtra("emailOrPhoneNumber")
        val image = intent.getIntExtra("image", 0)

        editTextName.setText(name)
        editTextEmailOrPhoneNumber.setText(emailOrPhoneNumber)

        buttonDeletedContact.setOnClickListener {
            Contact.ContactListManager.deleteContactFromList(position)
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonApply.setOnClickListener {
            name = editTextName.text.toString()
            emailOrPhoneNumber = editTextEmailOrPhoneNumber.text.toString()

            if (name!!.isNotBlank()) {
                if (name!!.isNotBlank()) {
                    val contact = Contact(image, name!!, emailOrPhoneNumber!!)
                    Contact.ContactListManager.editContactInList(position, contact)
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}