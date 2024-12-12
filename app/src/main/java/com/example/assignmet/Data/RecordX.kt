package com.example.assignmet.Data

data class RecordX(
    val Events__c: String,
    val Id: String,
    val Name: String,
    val Pay_Gateway__c: String,
    val Pay_Gateway__r: PayGatewayR,
    val Registration_Type__c: String,
    val attributes: Attributes
)