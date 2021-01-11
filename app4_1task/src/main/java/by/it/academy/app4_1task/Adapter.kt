        package by.it.academy.app4_1task

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale
import kotlin.collections.ArrayList


class Adapter(private val values: List<Contact>) : RecyclerView.Adapter<Adapter.ViewHolder>(), Filterable {

    var contactFilterList: List<Contact> = values

    override fun getItemCount(): Int = contactFilterList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_block_contact, parent, false)

        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: Contact = contactFilterList[position]

        holder.textViewName?.text = contact.getName()
        holder.textViewEmailOrPhone?.text = contact.getEmailOrPhone()
        holder.imageView?.setImageResource(contact.getImage())

        holder.itemView.setOnLongClickListener {
            val intent = Intent(holder.itemView.context, EditContactActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("name", contact.getName())
            intent.putExtra("emailOrPhoneNumber", contact.getEmailOrPhone())
            intent.putExtra("image", contact.getImage())
            holder.itemView.context.startActivity(intent)
            true
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: TextView? = null
        var textViewEmailOrPhone: TextView? = null
        var imageView: ImageView? = null

        init {
            textViewName = itemView.findViewById(R.id.textViewName)
            textViewEmailOrPhone = itemView.findViewById(R.id.textViewPhoneNumberOrEmail)
            imageView = itemView.findViewById(R.id.imageButtonContact)
        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isBlank()) {
                    contactFilterList = values
                } else {
                    val resultList = mutableListOf<Contact>()
                    for (row in values) {
                        if (row.getName().toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    contactFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = contactFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                contactFilterList = results?.values as ArrayList<Contact>
                notifyDataSetChanged()
            }

        }
    }


}