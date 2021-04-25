package com.example.ua.kpi.comsys.io8124.ui.moviesList

import com.fasterxml.jackson.annotation.JsonProperty

class SearchContainer {
    @JsonProperty("Search")
    var search: MutableList<Search> = ArrayList()
    override fun toString(): String {
        return search.toString()
    }
}
