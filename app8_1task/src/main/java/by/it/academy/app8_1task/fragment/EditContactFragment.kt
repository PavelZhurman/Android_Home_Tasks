package by.it.academy.app8_1task.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import by.it.academy.app8_1task.LIST_OF_CONTACTS_FRAGMENT
import by.it.academy.app8_1task.data.Contact
import by.it.academy.app8_1task.data.ContactListManager
import by.it.academy.app8_1task.R

class EditContactFragment : Fragment(R.layout.fragment_edit_contact) {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmailOrPhoneNumber: EditText
    private lateinit var buttonApply: ImageButton
    private lateinit var buttonDeletedContact: Button
    private lateinit var buttonBack: ImageButton
    private lateinit var name: String
    private lateinit var emailOrPhoneNumber: String
    private var image: Int = 0
    private var position = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            editTextName = findViewById(R.id.editTextNameEditContact)
            editTextEmailOrPhoneNumber = findViewById(R.id.editTextEmailOrPhoneEditContact)
            buttonApply = findViewById(R.id.buttonEditContactApply)
            buttonDeletedContact = findViewById(R.id.buttonRemoveEditContact)
            buttonBack = findViewById(R.id.buttonBackInToolbarEditContact)

            name = arguments?.getString("name", "").toString()
            emailOrPhoneNumber = arguments?.getString("emailOrPhoneNumber", "").toString()
            image = arguments?.getInt("image") ?: 0
            position = arguments?.getInt("position") ?: 0

            editTextName.setText(name)
            editTextEmailOrPhoneNumber.setText(emailOrPhoneNumber)

            buttonApply.setOnClickListener {

                val nameForButtonApply = editTextName.text.toString()
                val emailOrPhoneNumberForButtonApply = editTextEmailOrPhoneNumber.text.toString()

                if (name.isNotEmpty() && emailOrPhoneNumber.isNotEmpty()) {
                    val contact = Contact(image, nameForButtonApply, emailOrPhoneNumberForButtonApply)
                    ContactListManager.editContactInList(position, contact)
                    showListOfContactsFragment()
                }
            }

            buttonBack.setOnClickListener { showListOfContactsFragment() }

            buttonDeletedContact.setOnClickListener {
                ContactListManager.deleteContactFromList(position)
                showListOfContactsFragment()
            }
        }
    }

    private fun showListOfContactsFragment() {
        (activity as OnChangeFragmentListener).onChangeFragment(LIST_OF_CONTACTS_FRAGMENT, null)
    }
}
