package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.theme.MovieHeroTheme
import com.cuong.moviehero.ui.theme.Yellow
import androidx.compose.ui.graphics.Color

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    imageUrl: String = "",
    title: String = "",
    releaseDate: String = "",
    overview: String = "",
    rate: Float = 0f,
    onClick: () -> Unit = {},
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clickable( role = Role.Button, onClick = onClick )
            .height(152.dp)
            .padding(16.dp),
    ) {
        val ( imageRef, titleRef, overviewRef, dateRef, starRef, rateRef ) = createRefs()

        NetImage(
            modifier = Modifier
                .height(120.dp)
                .width(80.dp)
                .constrainAs(imageRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            contentDescription = null,
            imageUrl = imageUrl,
        )

        Text(
            modifier = Modifier
                .constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    start.linkTo(imageRef.end, margin = 8.dp)
                },
            text = title,
            style = MaterialTheme.typography.body1.copy(
                color = MaterialTheme.colors.onBackground,
            ),
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier
                .constrainAs(dateRef) {
                    top.linkTo(titleRef.bottom)
                    start.linkTo(titleRef.start)
                },
            text = releaseDate,
            style = MaterialTheme.typography.body2.copy(
                color = MaterialTheme.colors.onBackground,
            ),
        )
        Icon(
            modifier = Modifier
                .constrainAs(starRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(titleRef.start)
                },
            painter = painterResource(id = R.drawable.ic_star),
            tint = Yellow,
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .constrainAs(rateRef) {
                    top.linkTo(starRef.top)
                    start.linkTo(starRef.end, margin = 4.dp)
                },
            text = "$rate",
            style = MaterialTheme.typography.body2.copy(
                color = MaterialTheme.colors.onBackground,
            ),
        )

        Text(
            modifier = Modifier
                .constrainAs(overviewRef) {
                    top.linkTo(dateRef.bottom)
                    bottom.linkTo(starRef.top)
                    start.linkTo(titleRef.start)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                },
            maxLines = 3,
            text = overview,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body2.copy(
                color = MaterialTheme.colors.onBackground,
            ),
            fontStyle = FontStyle.Italic,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    MovieHeroTheme {
        Column(
            modifier = Modifier.background(Color.White)
        ) {
            MovieItem(
                imageUrl = "",
                title = "name",
                releaseDate = "2020/11/20",
                overview = "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                rate = 6.5f,
            )
        }
    }
}