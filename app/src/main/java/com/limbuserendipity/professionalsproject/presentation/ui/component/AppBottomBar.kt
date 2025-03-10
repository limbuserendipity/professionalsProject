package com.limbuserendipity.professionalsproject.presentation.ui.component

import android.annotation.SuppressLint
import android.app.Notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.shadow

import androidx.compose.ui.geometry.Size

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asAndroidPath

import androidx.compose.ui.graphics.vector.PathParser

import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.graphics.scaleMatrix
import com.limbuserendipity.professionalsproject.presentation.ui.theme.cartPath
import com.limbuserendipity.professionalsproject.presentation.ui.theme.favoritePath
import com.limbuserendipity.professionalsproject.presentation.ui.theme.homePath
import com.limbuserendipity.professionalsproject.presentation.ui.theme.notificationPath
import com.limbuserendipity.professionalsproject.presentation.ui.theme.profilePath


@SuppressLint("ResourceType", "UnusedBoxWithConstraintsScope")
@Composable
fun AppBottomBar(
    toHomeScreen : () -> Unit,
    toFavoriteScreen : () -> Unit,
    toNotificationScreen : () -> Unit,
    toProfileScreen : () -> Unit
) {

    val pathData = "M121.66,31.5C66.79,32.7 17.69,18.33 0,11V117H375V11C347.96,30.5 276.87,31 255.34,31C233.81,31 229.81,34 229.81,42.5C229.81,51 234.38,74.18 207.78,77.5C155.71,84 145.54,66.5 144.69,55.5C143.69,42.5 146.2,31.5 121.66,31.5Z"
    val xmlWidth = 375f
    val xmlHeight = 117f
    val path = PathParser().parsePathString(pathData).toPath()
    var size by remember {
        mutableStateOf(Size(0f, 0f))
    }
    val scaleX = size.width / xmlWidth
    val scaleY = size.height / xmlHeight
    val matrix = scaleMatrix(scaleX, scaleY)
    path.asAndroidPath().transform(matrix)

    val shape = object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            return Outline.Generic(path)
        }

    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(106.dp)
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(56.dp)
                .offset(
                    y = -20.dp
                )
                .shadow(
                    elevation = 4.dp,
                    shape = CircleShape,
                    clip = false,
                    spotColor = MaterialTheme.colorScheme.primary,
                    ambientColor = MaterialTheme.colorScheme.primary
                )
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .align(alignment = Alignment.Center)


        ){
            Icon(
                painter = painterResource(cartPath),
                contentDescription = "Cart",
                tint = MaterialTheme.colorScheme.surface
            )
        }

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .height(106.dp)
                .shadow(
                    elevation = 16.dp,
                    shape = shape,
                    clip = false
                )
                .background(
                    color = Color.White,
                    shape = shape
                )
        ) {

            with(LocalDensity.current){
                size = Size(
                    width = maxWidth.toPx(),
                    height = maxHeight.toPx()
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(106.dp)
            ) {
                IconButton(
                    onClick = {
                        toHomeScreen()
                    }
                ) {
                    Icon(
                        painter = painterResource(homePath),
                        contentDescription = "home"
                    )
                }
                IconButton(
                    onClick = {
                        toFavoriteScreen()
                    }
                ) {
                    Icon(
                        painter = painterResource(favoritePath),
                        contentDescription = "favorite"
                    )
                }
                IconButton(
                    onClick = {
                        toNotificationScreen()
                    }
                ) {
                    Icon(
                        painter = painterResource(notificationPath),
                        contentDescription = "notification"
                    )
                }
                IconButton(
                    onClick = {
                        toProfileScreen()
                    }
                ) {
                    Icon(
                        painter = painterResource(profilePath),
                        contentDescription = "profile"
                    )
                }
            }
        }

    }
}