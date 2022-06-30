package com.dee.netflix.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dee.common.component.MovieItemView
import com.dee.domain.model.MovieData

@Composable
fun MovieHorizontalView(modifier: Modifier, titleStr: String, movieList: List<MovieData>) {
    ConstraintLayout(modifier) {
        val (title, list) = createRefs()
        Text(
            titleStr,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, 16.dp)
                start.linkTo(parent.start, 16.dp)
            },
            style = MaterialTheme.typography.h6.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        )
        LazyRow(
            modifier = Modifier.constrainAs(list) {
                top.linkTo(title.bottom)
            }, contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(
                10.dp
            )
        ) {
            items(movieList.size) {
                MovieItemView(
                    item = movieList[it]
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopTenMovies() {
    MaterialTheme() {
        MovieHorizontalView(modifier = Modifier, "", emptyList())
    }
}