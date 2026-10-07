package com.example.laba1

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ProductCard(title: String, description: String, price: Double, status: ProductStatus) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .border(
                width = 1.dp,
                color = Color(0xffdee1ea),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ImageBox()

        Spacer(modifier = Modifier.height(8.dp))

        ProductInfo(title, description)

        Spacer(modifier = Modifier.height(8.dp))

        PriceAndStatus(price, status)
    }
}

@Composable
fun ImageBox() {
    Box(
        modifier = Modifier
            .size(120.dp, 92.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFdfeafe)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "PHOTO",
                fontSize = 10.sp,
                lineHeight = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff7e90b4))
            Text(
                text = "120 dp",
                fontSize = 7.sp,
                lineHeight = 7.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff7e90b4))
        }
    }

}

@Composable
fun ProductInfo(title: String, description: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.width(120.dp),
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight.Bold)
        Text(
            text = description,
            fontSize = 8.sp,
            lineHeight = 8.sp)
    }
}

@Composable
fun PriceAndStatus(price: Double, status: ProductStatus) {
    Row(
        modifier = Modifier
            .width(120.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = NumberFormat
                .getNumberInstance(Locale.forLanguageTag("ru-RU"))
                .format(price) + "₽",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(status.boxColor)
                .padding(4.dp, 3.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = status.title,
                fontSize = 6.sp,
                lineHeight = 6.sp,
                fontWeight = FontWeight.Bold,
                color = status.textColor
            )
        }
    }
}

