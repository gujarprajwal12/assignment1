package com.example.assignmet.Data

data class EventPayGatewayR(
    val done: Boolean,
    val records: List<RecordX>,
    val totalSize: Int
)