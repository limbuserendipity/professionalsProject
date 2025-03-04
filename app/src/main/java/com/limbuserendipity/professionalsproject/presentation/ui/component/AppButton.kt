package com.limbuserendipity.professionalsproject.presentation.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    text : String,
    onClick : () -> Unit,
    color : Color = MaterialTheme.colorScheme.primary,
    icon : Int? = null,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
){

    Surface(
        onClick = onClick,
        color = color,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(
                text = text,
                color = LocalContentColor.current
            )
            if(icon != null){
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "button icon",
                    tint = LocalContentColor.current,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}