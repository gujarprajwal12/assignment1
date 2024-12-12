package com.example.assignmet.Data

data class PayGatewayR(
    val Id: String,
    val PG_Pass_Secret__c: String,
    val PG_Signature__c: String,
    val PG_User_Key__c: String,
    val PGateway_Type__c: String,
    val PGateway_Type__r: PGatewayTypeR,
    val Paygateway_Label__c: String,
    val attributes: Attributes
)