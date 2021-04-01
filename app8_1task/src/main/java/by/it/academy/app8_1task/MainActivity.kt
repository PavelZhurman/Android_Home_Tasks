package by.it.academy.app8_1task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import by.it.academy.app8_1task.fragment.AddContactFragment
import by.it.academy.app8_1task.fragment.EditContactFragment
import by.it.academy.app8_1task.fragment.ListOfContactsFragment
import by.it.academy.app8_1task.fragment.OnChangeFragmentListener

const val LIST_OF_CONTACTS_FRAGMENT = 1
const val ADD_CONTACT_FRAGMENT = 2
const val EDIT_CONTACT_FRAGMENT = 3

class MainActivity : AppCompatActivity(), OnChangeFragmentListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showListOfContactsFragment()
        }
    }

    private fun showListOfContactsFragment() {
        supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .setReorderingAllowed(true)
                .add(R.id.mainContainerFragment, ListOfContactsFragment())
                .commit()
    }

    override fun onChangeFragment(id: Int, bundle: Bundle?) {
        when (id) {
            LIST_OF_CONTACTS_FRAGMENT -> {
                supportFragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                        .replace(R.id.mainContainerFragment, ListOfContactsFragment())
                        .addToBackStack(null)
                        .setReorderingAllowed(true)
                        .commit()
            }

            ADD_CONTACT_FRAGMENT -> {
                supportFragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .setReorderingAllowed(true)
                        .replace(R.id.mainContainerFragment, AddContactFragment())
                        .commit()
            }

            EDIT_CONTACT_FRAGMENT -> {
                supportFragmentManager.commit {
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .setReorderingAllowed(true)
                            .replace(R.id.mainContainerFragment, EditContactFragment::class.java, bundle)
                }


            }
        }
    }

}


