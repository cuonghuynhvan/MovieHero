package com.cuong.moviehero.ui.modules.movie_detail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.components.*
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun MovieDetailContent(
    state: MovieDetailContentState,
    onBackClick: () -> Unit,
) {
    val scrollState: ScrollState = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
    ) {
        val (titleBarRef, loadingRef, contentRef) = createRefs()

        TitleBarWithBackButton(
            modifier = Modifier
                .constrainAs(titleBarRef) {
                    top.linkTo(parent.top)
                    width = Dimension.matchParent
                },
            title = stringResource(id = R.string.title_movie_detail),
            onBackClick = onBackClick,
        )
        Column(
            modifier = Modifier
                .constrainAs(contentRef) {
                    top.linkTo(titleBarRef.bottom)
                    bottom.linkTo(parent.bottom)

                    width = Dimension.matchParent
                    height = Dimension.fillToConstraints
                }
                .verticalScroll(scrollState),
        ) {
            NetImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.78f),
                contentDescription = null,
                placeHolder = ImageBitmap.imageResource(id = R.drawable.bg_default_banner),
                error = ImageBitmap.imageResource(id = R.drawable.bg_default_banner),
                imageUrl = state.movieDetail.backdropImageUrl,
            )
            HorizontalLine()
            MovieDetailSummary(
                title = state.movieDetail.title,
                rate = state.movieDetail.rate,
                runtime = state.movieDetail.runtime,
                genes = state.movieDetail.genes,
            )
            HorizontalLine()
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = state.movieDetail.overview,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2.copy(
                    color = MaterialTheme.colors.onBackground,
                ),
                fontStyle = FontStyle.Italic,
            )
            HorizontalLine()
            Spacer(modifier = Modifier.navigationBarsPadding())
        }

        Loading(
            modifier = Modifier
                .constrainAs(loadingRef) {
                    top.linkTo(titleBarRef.bottom)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.matchParent
                },
            show = state.showLoading,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailContentReview() {
    MovieHeroTheme {
        MovieDetailContent(
            state = MovieDetailContentState(),
            onBackClick = {},
        )
    }
}