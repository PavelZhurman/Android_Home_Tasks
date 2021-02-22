package by.it.academy.app4_1task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val ACTIVITY_ADD_CONTACT = 1
private const val ACTIVITY_EDIT_CONTACT = 2

class MainActivity : AppCompatActivity(), ContactAdapter.OnContactAdapterClick {

    private lateinit var textViewNoContacts: TextView
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewNoContacts = findViewById(R.id.textNoContactsPleaseAdd)

        searchView = findViewById(R.id.searchView)
        recyclerView = findViewById(R.id.recyclerView)
        contactAdapter = ContactAdapter(ContactListManager.getListOfContacts(), this)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = contactAdapter


        val buttonAddContact: FloatingActionButton = findViewById(R.id.addContactButton)
        buttonAddContact.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivityForResult(intent, ACTIVITY_ADD_CONTACT)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                contactAdapter.filter.filter(newText)
                return false
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            if (requestCode == ACTIVITY_EDIT_CONTACT && resultCode == RESULT_OK) {

                if (data.hasExtra("delete") || data.hasExtra("edit")) {
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }

            if (requestCode == ACTIVITY_ADD_CONTACT && resultCode == RESULT_OK) {
                if (data.hasExtra("add")) {
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        textViewNoContacts.isVisible = ContactListManager.getListOfContacts().isEmpty()
    }

    override fun onContactClick(item: Contact, position: Int) {
        val intent = Intent(this, EditContactActivity::class.java)
        with(intent) {
            putExtra("position", position)
            putExtra("name", item.name)
            putExtra("emailOrPhoneNumber", item.emailOrPhoneNumber)
            putExtra("image", item.image)
            startActivityForResult(this, ACTIVITY_EDIT_CONTACT)
        }
    }
}