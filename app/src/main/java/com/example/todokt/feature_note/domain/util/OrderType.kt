package com.example.todokt.feature_note.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
