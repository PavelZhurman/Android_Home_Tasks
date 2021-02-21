package by.it.academy.app6_2task

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageThumbnailAdapter(private val values: MutableList<Uri>) : RecyclerView.Adapter<ImageThumbnailAdapter.ThumbnailViewHolder>() {

    lateinit var itemView: View

    lateinit var onThumbnailClickListener: (Uri) -> Unit

    class ThumbnailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewThumbnail: ImageView = itemView.findViewById(R.id.imageViewThumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_thumbnail, parent, false)
        return ThumbnailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        Glide.with(itemView).load(values[position]).into(holder.imageViewThumbnail)

        holder.itemView.setOnClickListener {
            onThumbnailClickListener.invoke(values[position])
        }
    }

    override fun getItemCount(): Int = values.size

}