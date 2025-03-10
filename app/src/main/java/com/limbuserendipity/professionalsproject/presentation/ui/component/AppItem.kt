package com.limbuserendipity.professionalsproject.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.limbuserendipity.professionalsproject.R
import com.limbuserendipity.professionalsproject.domain.model.Item
import com.limbuserendipity.professionalsproject.presentation.ui.theme.Red
import com.limbuserendipity.professionalsproject.presentation.ui.theme.favoriteFill
import com.limbuserendipity.professionalsproject.presentation.ui.theme.favoritePath

@Composable
fun AppItem(
    item : Item
){
    Box(
        modifier = Modifier
            .size(160.dp, 144.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            )
    ){
        Column(

        ) {

            val favoriteIcon = if(item.isFavorite) favoriteFill else favoritePath
            val favoriteTint = if(item.isFavorite) Red else Color.Black

            Icon(
                painter = painterResource(favoriteIcon),
                contentDescription = "favorite",
                tint = favoriteTint
            )
            Image(
                painter = painterResource(item.imagePath),
                contentDescription = ""
            )
            Text(text = item.title)
            if(item.isBestSeller){
                Text("Best Seller")
            }
            Text(text = item.price)
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(34.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
                )
                .align(alignment = Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}
@Composable
@Preview
fun AppItemPreview(){
    AppItem(
        item = Item(
            title = "Nike Air Max",
            price = "₽752.00",
            imagePath = R.drawable.nike
        )
    )
}