package by.it.academy.app8_2task.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import by.it.academy.app8_2task.R
import by.it.academy.app8_2task.fragments.AddCarFragment
import by.it.academy.app8_2task.fragments.AddWorkFragment
import by.it.academy.app8_2task.fragments.CarListFragment
import by.it.academy.app8_2task.fragments.CarWorkListFragment
import by.it.academy.app8_2task.fragments.EditCarFragment
import by.it.academy.app8_2task.fragments.EditWorkFragment
import by.it.academy.app8_2task.fragments.OnChangeFragmentListener
import java.text.SimpleDateFormat
import java.util.Date

const val CAR_LIST_FRAGMENT = 1
const val ADD_CAR_FRAGMENT = 2
const val EDIT_CAR_FRAGMENT = 3
const val CAR_WORK_LIST_FRAGMENT = 4
const val ADD_WORK_FRAGMENT = 5
const val EDIT_WORK_FRAGMENT = 6

class MainActivity : AppCompatActivity(), OnChangeFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            writeDateToLogFile()
            showCarListFragment()
        }
    }

    private fun showCarListFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.mainContainer, CarListFragment())
                .setReorderingAllowed(true)
                .commit()
    }

    private fun writeDateToLogFile() {
        val dateTimeInstance = SimpleDateFormat.getDateTimeInstance()

        openFileOutput("logWithDate.txt", MODE_APPEND).apply {
            val date = dateTimeInstance.format(Date())
            write(date.toByteArray())
            close()
        }
    }

    override fun onFragmentChange(id: Int, bundle: Bundle?) {

        when (id) {
            CAR_LIST_FRAGMENT -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContainer, CarListFragment())
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit()
            }

            ADD_CAR_FRAGMENT -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContainer, AddCarFragment())
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit()
            }

            EDIT_CAR_FRAGMENT -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                            .addToBackStack(null)
                            .replace(R.id.mainContainer, EditCarFragment::class.java, bundle)
                }
            }

            CAR_WORK_LIST_FRAGMENT -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                            .addToBackStack(null)
                            .replace(R.id.mainContainer, CarWorkListFragment::class.java, bundle)
                }
            }

            ADD_WORK_FRAGMENT -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                            .addToBackStack(null)
                            .replace(R.id.mainContainer, AddWorkFragment::class.java, bundle)
                }
            }

            EDIT_WORK_FRAGMENT -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                            .addToBackStack(null)
                            .replace(R.id.mainContainer, EditWorkFragment::class.java, bundle)
                }
            }


        }

    }
}