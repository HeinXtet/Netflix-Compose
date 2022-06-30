package com.dee.netflix.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.dee.netflix.R

@Composable
fun HomeMenu(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp)
    ) {
        val (tvShow, tvMovie, tvCategory) = createRefs()
        val menuStyle =
            MaterialTheme.typography.body1.copy(color = Color.White, textAlign = TextAlign.Center)
        createHorizontalChain(tvShow, tvMovie, tvCategory, chainStyle = ChainStyle.Spread)
        Text(text = stringResource(id = R.string.tv_show), modifier = Modifier
            .constrainAs(tvShow) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            }
            .clickable { }
            .padding(vertical = 16.dp), style = menuStyle)
        Text(text = stringResource(id = R.string.movies), modifier = Modifier
            .constrainAs(tvMovie) {
                start.linkTo(tvShow.start, 16.dp)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            }
            .clickable { }
            .padding(vertical = 16.dp), style = menuStyle)
        Row(
            modifier = Modifier
                .constrainAs(tvCategory) {
                    start.linkTo(tvMovie.start, 16.dp)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .clickable { }
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(id = R.string.categories),
                modifier = Modifier,
                style = menuStyle,
            )
            Icon(
                Icons.Filled.ArrowDropDown,
                contentDescription = "",
                modifier = Modifier.height(14.dp)
            )
        }
    }
}