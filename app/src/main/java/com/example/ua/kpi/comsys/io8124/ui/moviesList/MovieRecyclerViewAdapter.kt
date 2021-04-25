package com.example.ua.kpi.comsys.io8124.ui.moviesList

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ua.kpi.comsys.io8124.R

class MovieRecyclerViewAdapter(
    private val context: Context,
    private val values: List<Search>
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_film, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title + "\n"
        holder.year.text = item.year + "\n"
        holder.type.text = item.type + "\n"

        if (item.poster != null && item.poster!!.isNotEmpty()) {
            val drawable = context.resources.getIdentifier(
                item.poster!!.replace(".jpg", ""), "drawable",
                context.packageName
            )

            holder.poster.setImageDrawable(
                    ContextCompat.getDrawable(context, drawable)
            )
        } else {
            ContextCompat.getDrawable(context, android.R.color.transparent)
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)
        val year: TextView = view.findViewById(R.id.year)
        val type: TextView = view.findViewById(R.id.type)
        val poster: ImageView = view.findViewById(R.id.image)
    }
}
