package by.it.academy.app8_1task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListOfContactsFragment()
    }

    private fun showListOfContactsFragment() {
        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.mainContainerFragment, ListOfContactsFragment())
                .commit()
    }

}


