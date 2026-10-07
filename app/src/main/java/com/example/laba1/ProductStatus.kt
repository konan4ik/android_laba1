package com.example.laba1

import androidx.compose.ui.graphics.Color

enum class ProductStatus(val title: String, val boxColor: Color, val textColor: Color) {
    IN_STOCK("В наличии", Color(0xffccf2dd), Color(0xff387c53)),
    OUT_OF_STOCK("Нет в наличии", Color.Gray, Color.Black);
}