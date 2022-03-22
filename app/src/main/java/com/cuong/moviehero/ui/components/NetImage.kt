package com.cuong.moviehero.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.R
import com.cuong.moviehero.ui.theme.MovieHeroTheme
import com.skydoves.landscapist.ImageBySource
import com.skydoves.landscapist.fresco.FrescoImage

@Composable
fun NetImage(
    modifier: Modifier = Modifier,
    imageUrl: String = "",
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    alpha: Float = DefaultAlpha,
    placeHolder: ImageBitmap = ImageBitmap.imageResource(id = R.drawable.bg_default_movie),
    error: ImageBitmap = ImageBitmap.imageResource(id = R.drawable.bg_default_movie),
    observeLoadingProcess: Boolean = false
) {
    if(imageUrl.isEmpty()) {
        ImageBySource(
            source = placeHolder,
            modifier = modifier,
            alignment = alignment,
            contentDescription = contentDescription,
            contentScale = contentScale,
            alpha = alpha
        )
        return
    }

    FrescoImage(
        modifier = modifier,
        imageUrl = imageUrl,
        alignment = alignment,
        contentScale = contentScale,
        contentDescription = contentDescription,
        alpha = alpha,
        observeLoadingProcess = observeLoadingProcess,
        loading = {
            ImageBySource(
                source = placeHolder,
                modifier = Modifier.fillMaxSize(),
                alignment = alignment,
                contentDescription = contentDescription,
                contentScale = contentScale,
                alpha = alpha
            )
        },
        failure = {
            ImageBySource(
                source = error,
                modifier = Modifier.fillMaxSize(),
                alignment = alignment,
                contentDescription = contentDescription,
                contentScale = contentScale,
                alpha = alpha,
            )
        },
    )
}



@Preview
@Composable
fun NetImagePreview() {
    MovieHeroTheme() {
        NetImage(
            modifier = Modifier
                .width(88.dp)
                .height(123.dp),
            contentScale = ContentScale.FillHeight,
            imageUrl = "",
            contentDescription = null,
        )
    }
}