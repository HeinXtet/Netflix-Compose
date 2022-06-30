package com.dee.netflix.ui.home

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.dee.domain.model.MovieData
import com.dee.netflix.R
import com.dee.netflix.ui.home.component.*

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    ConstraintLayout(modifier = Modifier.fillMaxSize(),) {
        val (homeToolbar, menu, contentScrollContainer) = createRefs()
        val topTenMovieLists = viewModel.topTenMovieLists.observeAsState()
        val popularMovieLists = viewModel.popularMovieLists.observeAsState()
        ConstraintLayout(modifier = Modifier
            .constrainAs(contentScrollContainer) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            }
            .verticalScroll(rememberScrollState())) {
            val (posterIv, popularMovie, actions, topTenMovies, popularTenMovie) = createRefs()

            Poster(modifier = Modifier.constrainAs(posterIv) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
            CurrentPopularMovie(modifier = Modifier
                .constrainAs(popularMovie) {
                    top.linkTo(posterIv.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .offset {
                    IntOffset(
                        0,
                        -300
                    )
                })
            MovieHorizontalView(modifier = Modifier
                .constrainAs(topTenMovies) {
                    top.linkTo(popularMovie.bottom)
                }
                .offset {
                    IntOffset(
                        0,
                        -200
                    )
                }, movieList = topTenMovieLists.value.orEmpty(), titleStr = stringResource(id = R.string.top_ten_thailand)
            )

            MovieHorizontalView(modifier = Modifier
                .constrainAs(popularTenMovie) {
                    top.linkTo(topTenMovies.bottom)
                }
                .offset {
                    IntOffset(
                        0,
                        -240
                    )
                }, titleStr = stringResource(id = R.string.popular_movie_thailand),
                movieList = popularMovieLists.value.orEmpty()
            )
        }
        HomeToolbar(modifier = Modifier.constrainAs(homeToolbar) {
            top.linkTo(parent.top, 55.dp)
        })
        HomeMenu(
            modifier = Modifier.constrainAs(menu) {
                top.linkTo(homeToolbar.bottom)
            }
        )

    }
}

@Composable
fun Poster(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.home_poster),
        contentDescription = "",
    )
}

@Preview(showBackground = true, backgroundColor = Color.BLACK.toLong())
@Composable
fun PreviewHomeScreen() {
    MaterialTheme() {
        HomeScreen(hiltViewModel())
    }
}