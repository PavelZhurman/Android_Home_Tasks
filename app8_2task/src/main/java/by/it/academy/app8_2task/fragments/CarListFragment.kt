package by.it.academy.app8_2task.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.it.academy.app8_2task.R
import by.it.academy.app8_2task.activity.ADD_CAR_FRAGMENT
import by.it.academy.app8_2task.activity.CAR_WORK_LIST_FRAGMENT
import by.it.academy.app8_2task.activity.EDIT_CAR_FRAGMENT
import by.it.academy.app8_2task.adapter.CarAdapter
import by.it.academy.app8_2task.repositories.DatabaseCarsRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CarListFragment : Fragment(R.layout.fragment_car_list) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var fAButtonAddCar: FloatingActionButton
    private lateinit var textViewNoCars: TextView
    private var carItemAdapter = CarAdapter(mutableListOf())
    private lateinit var databaseCarsRepository: DatabaseCarsRepository
    private lateinit var mainScope: CoroutineScope

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            databaseCarsRepository = DatabaseCarsRepository(context)
            mainScope = CoroutineScope(Dispatchers.Main + Job())

            fAButtonAddCar = findViewById(R.id.addCarFloatingActionButton)
            textViewNoCars = findViewById(R.id.textViewNoCarsAdded)

            recyclerView = findViewById(R.id.recyclerViewCarsList)
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            setValuesInAdapter()

            fAButtonAddCar.setOnClickListener {
                (activity as OnChangeFragmentListener).onFragmentChange(ADD_CAR_FRAGMENT, null)
            }

        }
    }


    private fun setValuesInAdapter() {

        mainScope.launch {
            carItemAdapter = CarAdapter(databaseCarsRepository.getAllCarsSortedByProducer())
            recyclerView.adapter = carItemAdapter

            carItemAdapter.onEditClickListener = {
                (activity as OnChangeFragmentListener).onFragmentChange(EDIT_CAR_FRAGMENT, bundleOf("carItem" to it))
            }
            carItemAdapter.onCarItemClickListener = {
                (activity as OnChangeFragmentListener).onFragmentChange(CAR_WORK_LIST_FRAGMENT, bundleOf("workList" to it))
            }
            visibilityOfTextViewNoCars()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_toolbar, menu)

        val searchView = menu.findItem(R.id.toolbarSearch)?.actionView as androidx.appcompat.widget.SearchView

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                carItemAdapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun visibilityOfTextViewNoCars() {
        if (carItemAdapter.itemCount == 0) {
            textViewNoCars.visibility = View.VISIBLE
        } else {
            textViewNoCars.visibility = View.INVISIBLE
        }
    }
}