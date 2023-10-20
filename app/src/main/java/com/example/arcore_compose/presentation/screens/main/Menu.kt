package com.example.arcore_compose.presentation.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.arcore_compose.R
import com.example.arcore_compose.data.entities.Food
import com.example.arcore_compose.ui.theme.Translucent

@Composable
fun Menu(
    modifier: Modifier,
    onClick: (String) -> Unit
) {
    var currentIndex by remember {
        mutableStateOf(0)
    }
    val itemsList = listOf(
        Food("burger", R.drawable.burger),
        Food("instant", R.drawable.instant),
        Food("momos", R.drawable.momos),
        Food("pizza", R.drawable.pizza),
        Food("ramen", R.drawable.ramen),
    )

    fun updateCurrentItem(offset: Int) {
        currentIndex = (currentIndex + offset + itemsList.size) % itemsList.size
        onClick(itemsList[currentIndex].name)
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(onClick = {
            updateCurrentItem(-1)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "previous"
            )
        }
        ImagePreviewContainer(imageId = itemsList[currentIndex].imageId)
        IconButton(onClick = {
            updateCurrentItem(1)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_forward),
                contentDescription = "forward"
            )
        }
    }
}

@Composable
fun ImagePreviewContainer(
    imageId: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(140.dp)
            .border(width = 3.dp, Translucent, RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "ARModelImage",
            contentScale = ContentScale.FillBounds
        )
    }
}