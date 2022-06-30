package com.dee.netflix.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dee.common.R
import com.dee.domain.model.MovieData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val topTenMovieLists = MutableLiveData(
        listOf(
            MovieData(
                imageResId = R.drawable.poster_one,
                title = "13 Reasons why"
            ),
            MovieData(
                imageResId = R.drawable.poster_two,
                title = "Red Notice"
            ),
            MovieData(
                imageResId = R.drawable.poster_three,
                title = "The Projection"
            ),
            MovieData(
                imageResId = R.drawable.poster_four,
                title = "Dangerous Lies"
            ),
        )
    )
    val popularMovieLists = MutableLiveData(
        listOf(
            MovieData(
                imageResId = R.drawable.poster_five,
                title = "The Extraction"
            ),
            MovieData(
                imageResId = R.drawable.poster_six,
                title = "The Old Guard"
            ),
            MovieData(
                imageResId = R.drawable.poster_three,
                title = "The Projection"
            ),
            MovieData(
                imageResId = R.drawable.poster_four,
                title = "Dangerous Lies"
            ),
        )
    )
}