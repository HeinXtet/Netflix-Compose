package com.dee.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dee.common.R
import com.dee.common.theme.gray
import com.dee.domain.model.MovieData

@Composable
fun MovieItemView(modifier: Modifier = Modifier,item : MovieData) {
    ConstraintLayout(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .height(180.dp)
            .width(120.dp)
            .background(gray)
    ) {
        Image(painter = painterResource(id = item.imageResId), contentDescription = "Poster",
        contentScale = ContentScale.FillBounds)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieItemView() {
    MovieItemView(modifier = Modifier, MovieData(R.drawable.poster_one,""))
}