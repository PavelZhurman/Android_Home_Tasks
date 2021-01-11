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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupAddContact)
        val radioButtonPhoneNumber = findViewById<RadioButton>(R.id.radioButtonPhoneNumber)
        val radioButtonEmail = findViewById<RadioButton>(R.id.radioButtonEmail)
        val editTextName = findViewById<EditText>(R.id.editTextNameAddContact)
        val editTextPhoneNumberOrEmail = findViewById<EditText>(R.id.editTextPhoneNumberOrEmailAddContact)
        val buttonApply = findViewById<ImageButton>(R.id.buttonAddContactApply)

        findViewById<ImageButton>(R.id.buttonBackInToolbarAddContact).setOnClickListener {
            finish()
        }

        radioButtonPhoneNumber.setOnClickListener {
            radioGroup!!.checkedRadioButtonId
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

            var success = false

            if (name1.isNotBlank() && emailOrPhoneNumber1.isNotBlank()) {

                if (radioButtonPhoneNumber.isChecked) {
                    val contact = Contact(R.drawable.ic_baseline_contact_phone_24, name1, emailOrPhoneNumber1)
                    Contact.ContactListManager.addContactToList(contact)
                    success = true
                }

                if (radioButtonEmail.isChecked) {
                    val contact = Contact(R.drawable.ic_baseline_contact_mail_24, name1, emailOrPhoneNumber1)

                    Contact.ContactListManager.addContactToList(contact)
                    success = true
                }

                if (success) finish()
            }
        }

    }

}