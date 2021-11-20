package com.codelab.theming.ui.start.theme

import JetnewsTypography
import Red200
import Red300
import Red700
import Red800
import Red900
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.codelab.theming.data.PostRepo
import com.codelab.theming.ui.finish.FeaturedPost
import com.codelab.theming.ui.finish.theme.JetnewsShapes

private val LightColors = lightColors(
    primary = Red700,
    primaryVariant = Red900,
    onPrimary = Color.White,
    secondary = Red700,
    secondaryVariant = Red900,
    onSecondary = Color.White,
    error = Red800
)
private val DarkColors = darkColors(
    primary = Red300,
    primaryVariant = Red700,
    onPrimary = Color.Black,
    secondary = Red300,
    onSecondary = Color.Black,
    error = Red200
)

@Composable
fun JetnewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit){
    MaterialTheme(
        colors = if(darkTheme) DarkColors else LightColors,
        typography = JetnewsTypography,
        shapes = JetnewsShapes,
        content = content
    )
}

@Preview
@Composable
private fun FeaturePostPreview(){
    val post = remember { PostRepo.getFeaturedPost()}
    JetnewsTheme {
        FeaturedPost(post = post)
    }
}
