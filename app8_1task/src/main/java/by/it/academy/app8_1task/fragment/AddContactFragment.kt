package by.it.academy.app8_1task.fragment

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import by.it.academy.app8_1task.data.Contact
import by.it.academy.app8_1task.data.ContactListManager
import by.it.academy.app8_1task.R

class AddContactFragment : Fragment(R.layout.fragment_add_contact) {

    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButtonPhoneNumber: RadioButton
    private lateinit var editTextName: EditText
    private lateinit var editTextPhoneNumberOrEmail: EditText
    private lateinit var buttonApply: ImageButton
    private lateinit var buttonBack: ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            editTextName = findViewById(R.id.editTextNameAddContact)
            editTextPhoneNumberOrEmail = findViewById(R.id.editTextPhoneNumberOrEmailAddContact)
            radioGroup = findViewById(R.id.radioGroupAddContact)
            radioButtonPhoneNumber = findViewById(R.id.radioButtonPhoneNumber)
            buttonApply = findViewById(R.id.buttonAddContactApply)
            buttonBack = findViewById(R.id.buttonBackInToolbarAddContact)


            buttonApply.setOnClickListener {
                val name = editTextName.text.toString()
                val numberOrEmail = editTextPhoneNumberOrEmail.text.toString()
                val imageId = if (radioButtonPhoneNumber.isChecked) {
                    R.drawable.ic_baseline_contact_phone_24
                } else {
                    R.drawable.ic_baseline_contact_mail_24
                }

                addContactToContactList(imageId, name, numberOrEmail)
            }

            buttonBack.setOnClickListener {

            }

        }

    }

    private fun addContactToContactList(image: Int, name1: String, emailOrPhoneNumber1: String) {
        val contact = Contact(image, name1, emailOrPhoneNumber1)
        ContactListManager.addContactToList(contact)
        parentFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.mainContainerFragment, ListOfContactsFragment()).commit()
    }
}