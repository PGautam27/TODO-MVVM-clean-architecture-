package com.example.todokt.feature_note.domain.util

class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): NoteOrder(orderType)
}