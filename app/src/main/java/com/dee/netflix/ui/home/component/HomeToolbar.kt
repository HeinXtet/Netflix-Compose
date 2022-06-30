package com.dee.netflix.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dee.netflix.R

@Composable
fun HomeToolbar(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        val (logo, search,avatar) = createRefs()
        Image(
            modifier = Modifier
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, 16.dp)
                }
                .height(40.dp)
                .width(40.dp),
            painter = painterResource(id = R.drawable.netflix_logo),
            contentDescription = "Logo"
        )
        Image(
            modifier = Modifier
                .constrainAs(search) {
                    top.linkTo(parent.top)
                    end.linkTo(avatar.start, 16.dp)
                }
                .height(35.dp)
                .width(40.dp),
            painter = painterResource(id = R.drawable.baseline_search_24),
            colorFilter = ColorFilter.tint(Color.White),
            contentDescription = "Logo"
        )
        Image(
            modifier = Modifier
                .constrainAs(avatar) {
                    top.linkTo(search.top)
                    end.linkTo(parent.end, 16.dp)
                    bottom.linkTo(search.bottom)
                }
                .height(35.dp)
                .width(35.dp)
                .clip(RoundedCornerShape(8.dp))
            ,
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Logo"
        )
    }
}