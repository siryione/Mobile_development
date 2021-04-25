package com.example.ua.kpi.comsys.io8124.ui.moviesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fasterxml.jackson.databind.ObjectMapper
import com.example.ua.kpi.comsys.io8124.R

class MoviesListFragment : Fragment() {

    private var columnCount = 1
    private var searchContainer: SearchContainer = SearchContainer()
    private lateinit var view: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        view = inflater.inflate(R.layout.fragment_film_list, container, false) as RecyclerView
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(view) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
        }

        initFilms()
        val arr = searchContainer.search
        view.adapter = MovieRecyclerViewAdapter(requireContext(), arr)
    }

    private fun initFilms() {
        val mapper = ObjectMapper()
        val jsonText = requireView().resources.getString(R.string.json_films)
        searchContainer = mapper.readValue(jsonText, SearchContainer::class.java)
    }
}
