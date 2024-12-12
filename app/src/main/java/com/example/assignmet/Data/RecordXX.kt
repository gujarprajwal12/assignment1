package com.example.assignmet.Data

data class RecordXX(
    val BL_Fee_Amount__c: Double,
    val BL_Fee_Percentage__c: Double,
    val Event__c: String,
    val Id: String,
    val Item_type__c: String,
    val Item_type__r: ItemTypeR,
    val Name: String,
    val attributes: Attributes
)