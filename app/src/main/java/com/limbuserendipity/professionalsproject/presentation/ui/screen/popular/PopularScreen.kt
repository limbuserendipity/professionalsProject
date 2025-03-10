package com.limbuserendipity.professionalsproject.presentation.ui.screen.popular

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.limbuserendipity.professionalsproject.R
import com.limbuserendipity.professionalsproject.domain.model.Item
import com.limbuserendipity.professionalsproject.presentation.ui.component.AppItem

@Composable
fun PopularScreen(){

    val items = listOf(
        Item(
            title = "Nike Air Max",
            price = "₽752.00",
            imagePath = R.drawable.nike
        ),
        Item(
            title = "Nike Air Max",
            price = "₽752.00",
            imagePath = R.drawable.nike
        ),
        Item(
            title = "Nike Air Max",
            price = "₽752.00",
            imagePath = R.drawable.nike
        ),
        Item(
            title = "Nike Air Max",
            price = "₽752.00",
            imagePath = R.drawable.nike
        ),
        Item(
            title = "Nike Air Max",
            price = "₽752.00",
            imagePath = R.drawable.nike
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {

        items(items){ item ->
            AppItem(item)
        }

    }

}
@Composable
@Preview
fun PopularScreenPreview(){
    PopularScreen()
}