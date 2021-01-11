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

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchView: SearchView = findViewById(R.id.searchView)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = Adapter(Contact.ContactListManager.getListOfContacts())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        val buttonAddContact: FloatingActionButton = findViewById(R.id.addContactButton)
        buttonAddContact.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }


    override fun onResume() {
        super.onResume()

        findViewById<TextView>(R.id.textNoContactsPleaseAdd).isVisible =
                Contact.ContactListManager.getListOfContacts().isEmpty()

    }
}