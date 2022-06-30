package com.dee.netflix.ui.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.dee.netflix.ui.game.component.GameVerticalItemView


@Composable
fun GameScreen(viewModel: GameViewModel) {
    ConstraintLayout {
        val (tvTitle, vList) = createRefs()
        val games = viewModel.games.observeAsState()

        Text(
            "Mobile Game Trailer",
            modifier = Modifier.constrainAs(tvTitle) {
                top.linkTo(parent.top, 16.dp)
                start.linkTo(parent.start, 16.dp)
            },
            style = MaterialTheme.typography.h6.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        )
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(games.value.orEmpty().size) {
                GameVerticalItemView(modifier = Modifier.constrainAs(vList) {
                    top.linkTo(parent.bottom)
                }, gameModel = games.value.orEmpty()[it])
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGameScreen() {
    GameScreen(viewModel = hiltViewModel())
}
