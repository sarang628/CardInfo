package com.sarang.torang.compose.cardinfo

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp

typealias CardInfoImageLoader = @Composable (
    modifier: Modifier,
    url: String,
    width: Dp?,
    height: Dp?,
    contentScale: ContentScale?
) -> Unit

val LocalCardInfoImageLoader = compositionLocalOf<CardInfoImageLoader> {
    // 기본 구현: 경고 로그 출력
    @Composable { modifier, _, _, _, _ ->
        Box(modifier = modifier)
        Log.w("__CardInfoImageLoader", "No CardInfoImageLoader provided.")
    }
}