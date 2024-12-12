package com.example.assignmet.Data

data class ProfileX(
    val Beacon_Max__c: Int,
    val Beacon_Min__c: Int,
    val Bln_Custom_Fields__c: String,
    val Bln_Custom_Fields__r: BlnCustomFieldsR,
    val Create_Event__c: Boolean,
    val Default_Company_ID__c: String,
    val Default_Company_ID__r: DefaultCompanyIDR,
    val Email__c: String,
    val First_Name__c: String,
    val Home_Address__c: String,
    val Home_Address__r: HomeAddressR,
    val Id: String,
    val Last_Name__c: String,
    val Name: String,
    val Quickblox_error__c: String,
    val Remove_event_date_restriction__c: Boolean,
    val UC_Role__r: UCRoleR,
    val User_OptOut__c: Boolean,
    val User_Pic__c: String,
    val attributes: Attributes
)