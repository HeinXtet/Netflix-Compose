package com.dee.netflix.ui.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dee.domain.model.GameModel
import com.dee.netflix.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor()  :ViewModel(){

    val games = MutableLiveData(
        listOf(
            GameModel(
                title = "Squard Game",
                backgroundRes = com.dee.common.R.drawable.game_poster_one,
                iconRes = com.dee.common.R.drawable.squard_game_poster
            ),
            GameModel(
                title = "Sex Education",
                backgroundRes = com.dee.common.R.drawable.sex_education_background,
                iconRes = com.dee.common.R.drawable.squard_game_poster
            ),
            GameModel(
                title = "Sex Education 2",
                backgroundRes = com.dee.common.R.drawable.sex_education_background,
                iconRes = com.dee.common.R.drawable.squard_game_poster
            )
        )
    )
}