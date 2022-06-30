package com.dee.netflix.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.dee.common.theme.Purple200
import com.dee.common.theme.black
import com.dee.netflix.R

@Composable
fun CurrentPopularMovie(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(black.copy(alpha = 0.5f))

    ) {
        val (seriesTitle, tvName, tvCategories,actions) = createRefs()
        Row(
            modifier = Modifier.constrainAs(seriesTitle) {
                top.linkTo(parent.top, 16.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painterResource(id = R.drawable.netflix_logo), modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                contentDescription = ""
            )
            Text(
                text = "Series",
                style = MaterialTheme.typography.h6.copy(color = Color.White, fontSize = 36.sp)
            )
        }
        Text(
            "The Stranger Things 4",
            style = MaterialTheme.typography.body1.copy(
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 36.sp,
            ),
            modifier = Modifier.constrainAs(tvName) {
                top.linkTo(seriesTitle.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            })

        Text(
            stringResource(id = R.string.simple_category),
            modifier = Modifier.constrainAs(tvCategories) {
                top.linkTo(tvName.bottom, 16.dp)
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
            },
            style = MaterialTheme.typography.body1.copy(
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
        HomeMovieActions(modifier = Modifier.constrainAs(actions) {
            top.linkTo(tvCategories.bottom,24.dp)
        })
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewCurrentPopuar() {
    CurrentPopularMovie(modifier = Modifier)
}