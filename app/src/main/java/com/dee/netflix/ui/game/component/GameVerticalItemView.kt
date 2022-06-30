package com.dee.netflix.ui.game.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.dee.domain.model.GameModel

@Composable
fun GameVerticalItemView(modifier: Modifier, gameModel: GameModel) {
    ConstraintLayout(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Black)
    ) {
        val (ivVideo, lyPoster) = createRefs()
        Box(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(ivVideo) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
            .background(Color.Black)
            .height(250.dp)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = gameModel.backgroundRes),
                contentDescription = "", contentScale = ContentScale.FillBounds
            )
        }
        Row(modifier = Modifier
            .constrainAs(lyPoster) {
                top.linkTo(ivVideo.bottom, 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
            .padding(all = 8.dp)) {
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                Image(
                    painterResource(id = gameModel.iconRes),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier) {
                Text(
                    text = "Game Title",
                    style = MaterialTheme.typography.body1.copy(color = Color.White)
                )
                Text(
                    text = "Game Description",
                    style = MaterialTheme.typography.h1.copy(color = Color.Gray, fontSize = 14.sp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGameVerticalItemView() {
    GameVerticalItemView(
        modifier = Modifier, GameModel(
            "", com.dee.common.R.drawable.game_poster_one,
            com.dee.common.R.drawable.squard_game_poster
        )
    )
}