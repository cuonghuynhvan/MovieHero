package com.cuong.moviehero.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.theme.MovieHeroTheme
import com.cuong.moviehero.ui.theme.Yellow

@Composable
fun MovieDetailSummary(
    modifier: Modifier = Modifier,
    title: String = "",
    rate: Float = 0f,
    maxRate: Int = 10,
    runtime: Int = 0,
    genes: List<String> = emptyList(),
) {
    ConstraintLayout(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .padding(horizontal = 16.dp),
    ) {
        val ( titleRef, starRef, runtimeRef, geneRef, rateRef, vLine1Ref, vLine2Ref  ) = createRefs()

        Text(
            modifier = Modifier
                .constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            text = title,
            style = MaterialTheme.typography.body1.copy(
                color = MaterialTheme.colors.onBackground,
            ),
            fontWeight = FontWeight.Bold,
        )

        Icon(
            modifier = Modifier
                .constrainAs(starRef) {
                    top.linkTo(titleRef.bottom)
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
            text = "$rate/$maxRate",
            style = MaterialTheme.typography.body2.copy(
                color = MaterialTheme.colors.onBackground,
            ),
        )

        VerticalLine(
            modifier = Modifier
                .constrainAs(vLine1Ref) {
                    top.linkTo(starRef.top)
                    bottom.linkTo(starRef.bottom)
                    start.linkTo(rateRef.end, margin = 8.dp)
                    height = Dimension.value(10.dp)
                },
        )

        RuntimeText(
            modifier = Modifier
                .constrainAs(runtimeRef) {
                    top.linkTo(starRef.top)
                    start.linkTo(vLine1Ref.end, margin = 8.dp)
                },
            runtime = runtime,
        )

        VerticalLine(
            modifier = Modifier
                .constrainAs(vLine2Ref) {
                    top.linkTo(starRef.top)
                    bottom.linkTo(starRef.bottom)
                    start.linkTo(runtimeRef.end, margin = 8.dp)
                    height = Dimension.value(10.dp)
                },
        )

        Text(
            modifier = Modifier
                .constrainAs(geneRef) {
                    top.linkTo(starRef.top)
                    start.linkTo(vLine2Ref.end, margin = 8.dp)
                },
            text = genes.joinToString(),
            style = MaterialTheme.typography.body2.copy(
                color = MaterialTheme.colors.onBackground,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailSummaryPreview() {
    MovieHeroTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            MovieDetailSummary(
                title = "The Shawshank Redemption",
                rate = 8.8f,
                runtime = 140,
                genes = listOf("Drama", "Drama", "Drama")
            )
        }
    }
}