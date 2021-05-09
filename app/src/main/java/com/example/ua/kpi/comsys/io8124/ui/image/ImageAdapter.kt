package com.example.ua.kpi.comsys.io8124.ui.image

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ua.kpi.comsys.io8124.R


class ImageAdapter(
    private val context: Context,
    private var values: List<ImageView>
) : RecyclerView.Adapter<ImageAdapter.MyPictureViewHolder>() {

    private lateinit var list: RecyclerView

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: MyPictureViewHolder, position: Int) {
        holder.bind(values[position], context)
    }

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPictureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_image, parent, false)
        return MyPictureViewHolder(view)
    }

    inner class MyPictureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.image)

        fun bind(value: ImageView, context: Context) {
            image.setImageDrawable(value.drawable)
        }
    }
}
