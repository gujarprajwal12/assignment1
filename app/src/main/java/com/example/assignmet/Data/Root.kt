package com.example.assignmet.Data

data class Root(
    val Connections: List<Any?>,
    val CurrencyList: List<Currency>,
    val Events: List<Event>,
    val ItemTypes: List<ItemType>,
    val PGatewaytypes: Any,
    val PayGateways: Any,
    val Profile: Profile,
    val StripeEventdexClientID: String,
    val StripeEventdexSecretKey: String,
    val UpcomingEvents: List<Any?>,
    val defaultmobiletheme: Defaultmobiletheme,
    val mobileimageurl: String,
    val msg: Msg,
    val scanticketavailable: Boolean
)