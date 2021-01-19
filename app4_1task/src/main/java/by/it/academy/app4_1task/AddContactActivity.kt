package by.it.academy.app4_1task

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class AddContactActivity : AppCompatActivity() {

    private lateinit var radioGroup:RadioGroup
    private lateinit var radioButtonPhoneNumber:RadioButton
    private lateinit var editTextName: EditText
    private lateinit var editTextPhoneNumberOrEmail :EditText
    private lateinit var buttonApply:ImageButton

    private fun addContactToContactList(image: Int, name1: String, emailOrPhoneNumber1: String) {
        val contact = Contact(image, name1, emailOrPhoneNumber1)
        ContactManager.ContactListManager.addContactToList(contact)
        intent.putExtra("add", 0)
             setResult(RESULT_OK,intent)
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        radioGroup = findViewById(R.id.radioGroupAddContact)
        radioButtonPhoneNumber = findViewById(R.id.radioButtonPhoneNumber)
        editTextName = findViewById(R.id.editTextNameAddContact)
        editTextPhoneNumberOrEmail = findViewById(R.id.editTextPhoneNumberOrEmailAddContact)
        buttonApply = findViewById(R.id.buttonAddContactApply)

        findViewById<ImageButton>(R.id.buttonBackInToolbarAddContact).setOnClickListener {
            finish()
        }

        radioGroup.setOnCheckedChangeListener { _, optionId ->
            run {
                when (optionId) {
                    R.id.radioButtonPhoneNumber -> {
                        editTextPhoneNumberOrEmail.setHint(R.string.phone_number)
                        editTextPhoneNumberOrEmail.inputType = InputType.TYPE_CLASS_PHONE
                    }
                    R.id.radioButtonEmail -> {
                        editTextPhoneNumberOrEmail.setHint(R.string.email)
                        editTextPhoneNumberOrEmail.inputType = InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
                    }
                }
            }
        }

        buttonApply.setOnClickListener {
            val name: Editable? = editTextName.text
            val emailOrPhoneNumber: Editable? = editTextPhoneNumberOrEmail.text

            val name1: String = name.toString()
            val emailOrPhoneNumber1: String = emailOrPhoneNumber.toString()

            if (name1.isNotBlank() && emailOrPhoneNumber1.isNotBlank()) {

                if (radioButtonPhoneNumber.isChecked) {
                    addContactToContactList(R.drawable.ic_baseline_contact_phone_24, name1, emailOrPhoneNumber1)
                } else {
                    addContactToContactList(R.drawable.ic_baseline_contact_mail_24, name1, emailOrPhoneNumber1)
                }
            }
        }


    }

}