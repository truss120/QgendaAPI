package edu.bcm.api.cms.entity;

/*
This POJO was generated based on JSON data.
The initial code was generated at http://www.jsonschema2pojo.org/
 */

/*import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;*/

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, allowSetters = true, allowGetters = true)
@JsonPropertyOrder({
        "applicable_manufacturer_or_applicable_gpo_making_payment_country",
        "applicable_manufacturer_or_applicable_gpo_making_payment_id",
        "applicable_manufacturer_or_applicable_gpo_making_payment_name",
        "applicable_manufacturer_or_applicable_gpo_making_payment_state",
        "change_type",
        "dispute_status_for_publication",
        "interest_held_by_physician_or_an_immediate_family_member",
        "payment_publication_date",
        "physician_first_name",
        "physician_last_name",
        "physician_primary_type",
        "physician_profile_id",
        "physician_specialty",
        "program_year",
        "recipient_city",
        "recipient_country",
        "recipient_primary_business_street_address_line1",
        "recipient_state",
        "recipient_zip_code",
        "record_id",
        "submitting_applicable_manufacturer_or_applicable_gpo_name",
        "terms_of_interest",
        "total_amount_invested_usdollars",
        "value_of_interest"
})
public class CmsOwnershipObject extends CmsObject {

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_country")
    private String applicableManufacturerOrApplicableGPOMakingPaymentCountry;
    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_ID")
    private String applicableManufacturerOrApplicableGPOMakingPaymentID;
    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_Name")
    private String applicableManufacturerOrApplicableGPOMakingPaymentName;
    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_State")
    private String applicableManufacturerOrApplicableGPOMakingPaymentState;
    @JsonProperty("Change_Type")
    private String changeType;
    @JsonProperty("Dispute_Status_for_Publication")
    private String disputeStatusForPublication;
    @JsonProperty("Interest_Held_by_Physician_or_an_Immediate_Family_Member")
    private String interestHeldByPhysicianOrAnImmediateFamilyMember;
    @JsonProperty("Payment_Publication_Date")
    private String paymentPublicationDate;
    @JsonProperty("Physician_First_Name")
    private String physicianFirstName;
    @JsonProperty("Physician_Last_Name")
    private String physicianLastName;
    @JsonProperty("Physician_Primary_Type")
    private String physicianPrimaryType;
    @JsonProperty("Physician_Profile_ID")
    private String physicianProfileID;
    @JsonProperty("Physician_Specialty")
    private String physicianSpecialty;
    @JsonProperty("Program_Year")
    private String programYear;
    @JsonProperty("Recipient_City")
    private String recipientCity;
    @JsonProperty("Recipient_Country")
    private String recipientCountry;
    @JsonProperty("Recipient_Primary_Business_Street_Address_Line1")
    private String recipientPrimaryBusinessStreetAddressLine1;
    @JsonProperty("Recipient_State")
    private String recipientState;
    @JsonProperty("Recipient_Zip_Code")
    private String recipientZipCode;
    @JsonProperty("Record_ID")
    private String recordID;
    @JsonProperty("Submitting_Applicable_Manufacturer_or_Applicable_GPO_Name")
    private String submittingApplicableManufacturerOrApplicableGPOName;
    @JsonProperty("Terms_of_Interest")
    private String termsOfInterest;
    @JsonProperty("Total_Amount_Invested_USDollars")
    private String totalAmountInvestedUSDollars;
    @JsonProperty("Value_of_Interest")
    private String valueOfInterest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5126762653718688177L;

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_Country")
    public String getApplicableManufacturerOrApplicableGPOMakingPaymentCountry() {
        return applicableManufacturerOrApplicableGPOMakingPaymentCountry;
    }

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_Country")
    public void setApplicableManufacturerOrApplicableGPOMakingPaymentCountry(String applicableManufacturerOrApplicableGPOMakingPaymentCountry) {
        this.applicableManufacturerOrApplicableGPOMakingPaymentCountry = applicableManufacturerOrApplicableGPOMakingPaymentCountry;
    }

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_ID")
    public String getApplicableManufacturerOrApplicableGPOMakingPaymentID() {
        return applicableManufacturerOrApplicableGPOMakingPaymentID;
    }

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_ID")
    public void setApplicableManufacturerOrApplicableGPOMakingPaymentID(String applicableManufacturerOrApplicableGPOMakingPaymentID) {
        this.applicableManufacturerOrApplicableGPOMakingPaymentID = applicableManufacturerOrApplicableGPOMakingPaymentID;
    }

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_Name")
    public String getApplicableManufacturerOrApplicableGPOMakingPaymentName() {
        return applicableManufacturerOrApplicableGPOMakingPaymentName;
    }

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_Name")
    public void setApplicableManufacturerOrApplicableGPOMakingPaymentName(String applicableManufacturerOrApplicableGPOMakingPaymentName) {
        this.applicableManufacturerOrApplicableGPOMakingPaymentName = applicableManufacturerOrApplicableGPOMakingPaymentName;
    }

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_State")
    public String getApplicableManufacturerOrApplicableGPOMakingPaymentState() {
        return applicableManufacturerOrApplicableGPOMakingPaymentState;
    }

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_State")
    public void setApplicableManufacturerOrApplicableGPOMakingPaymentState(String applicableManufacturerOrApplicableGPOMakingPaymentState) {
        this.applicableManufacturerOrApplicableGPOMakingPaymentState = applicableManufacturerOrApplicableGPOMakingPaymentState;
    }

    @JsonProperty("Change_Type")
    public String getChangeType() {
        return changeType;
    }

    @JsonProperty("Change_Type")
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    @JsonProperty("Dispute_Status_for_Publication")
    public String getDisputeStatusForPublication() {
        return disputeStatusForPublication;
    }

    @JsonProperty("Dispute_Status_for_Publication")
    public void setDisputeStatusForPublication(String disputeStatusForPublication) {
        this.disputeStatusForPublication = disputeStatusForPublication;
    }

    @JsonProperty("Interest_Held_by_Physician_or_an_Immediate_Family_Member")
    public String getInterestHeldByPhysicianOrAnImmediateFamilyMember() {
        return interestHeldByPhysicianOrAnImmediateFamilyMember;
    }

    @JsonProperty("Interest_Held_by_Physician_or_an_Immediate_Family_Member")
    public void setInterestHeldByPhysicianOrAnImmediateFamilyMember(String interestHeldByPhysicianOrAnImmediateFamilyMember) {
        this.interestHeldByPhysicianOrAnImmediateFamilyMember = interestHeldByPhysicianOrAnImmediateFamilyMember;
    }

    @JsonProperty("Payment_Publication_Date")
    public String getPaymentPublicationDate() {
        return paymentPublicationDate;
    }

    @JsonProperty("Payment_Publication_Date")
    public void setPaymentPublicationDate(String paymentPublicationDate) {
        this.paymentPublicationDate = paymentPublicationDate;
    }

    @JsonProperty("Physician_First_Name")
    public String getPhysicianFirstName() {
        return physicianFirstName;
    }

    @JsonProperty("Physician_First_Name")
    public void setPhysicianFirstName(String physicianFirstName) {
        this.physicianFirstName = physicianFirstName;
    }

    @JsonProperty("Physician_Last_Name")
    public String getPhysicianLastName() {
        return physicianLastName;
    }

    @JsonProperty("Physician_Last_Name")
    public void setPhysicianLastName(String physicianLastName) {
        this.physicianLastName = physicianLastName;
    }

    @JsonProperty("Physician_Primary_Type")
    public String getPhysicianPrimaryType() {
        return physicianPrimaryType;
    }

    @JsonProperty("Physician_Primary_Type")
    public void setPhysicianPrimaryType(String physicianPrimaryType) {
        this.physicianPrimaryType = physicianPrimaryType;
    }

    @JsonProperty("Physician_Profile_ID")
    public String getPhysicianProfileID() {
        return physicianProfileID;
    }

    @JsonProperty("Physician_Profile_ID")
    public void setPhysicianProfileID(String physicianProfileID) {
        this.physicianProfileID = physicianProfileID;
    }

    @JsonProperty("Physician_Specialty")
    public String getPhysicianSpecialty() {
        return physicianSpecialty;
    }

    @JsonProperty("Physician_Specialty")
    public void setPhysicianSpecialty(String physicianSpecialty) {
        this.physicianSpecialty = physicianSpecialty;
    }

    @JsonProperty("Program_Year")
    public String getProgramYear() {
        return programYear;
    }

    @JsonProperty("Program_Year")
    public void setProgramYear(String programYear) {
        this.programYear = programYear;
    }

    @JsonProperty("Recipient_City")
    public String getRecipientCity() {
        return recipientCity;
    }

    @JsonProperty("Recipient_City")
    public void setRecipientCity(String recipientCity) {
        this.recipientCity = recipientCity;
    }

    @JsonProperty("Recipient_Country")
    public String getRecipientCountry() {
        return recipientCountry;
    }

    @JsonProperty("Recipient_Country")
    public void setRecipientCountry(String recipientCountry) {
        this.recipientCountry = recipientCountry;
    }

    @JsonProperty("Recipient_Primary_Business_Street_Address_Line1")
    public String getRecipientPrimaryBusinessStreetAddressLine1() {
        return recipientPrimaryBusinessStreetAddressLine1;
    }

    @JsonProperty("Recipient_Primary_Business_Street_Address_Line1")
    public void setRecipientPrimaryBusinessStreetAddressLine1(String recipientPrimaryBusinessStreetAddressLine1) {
        this.recipientPrimaryBusinessStreetAddressLine1 = recipientPrimaryBusinessStreetAddressLine1;
    }

    @JsonProperty("Recipient_State")
    public String getRecipientState() {
        return recipientState;
    }

    @JsonProperty("Recipient_State")
    public void setRecipientState(String recipientState) {
        this.recipientState = recipientState;
    }

    @JsonProperty("Recipient_Zip_Code")
    public String getRecipientZipCode() {
        return recipientZipCode;
    }

    @JsonProperty("Recipient_Zip_Code")
    public void setRecipientZipCode(String recipientZipCode) {
        this.recipientZipCode = recipientZipCode;
    }

    @JsonProperty("Record_ID")
    public String getRecordID() {
        return recordID;
    }

    @JsonProperty("Record_ID")
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    @JsonProperty("Submitting_Applicable_Manufacturer_or_Applicable_GPO_Name")
    public String getSubmittingApplicableManufacturerOrApplicableGPOName() {
        return submittingApplicableManufacturerOrApplicableGPOName;
    }

    @JsonProperty("Submitting_Applicable_Manufacturer_or_Applicable_GPO_Name")
    public void setSubmittingApplicableManufacturerOrApplicableGPOName(String submittingApplicableManufacturerOrApplicableGPOName) {
        this.submittingApplicableManufacturerOrApplicableGPOName = submittingApplicableManufacturerOrApplicableGPOName;
    }

    @JsonProperty("Terms_of_Interest")
    public String getTermsOfInterest() {
        return termsOfInterest;
    }

    @JsonProperty("Terms_of_Interest")
    public void setTermsOfInterest(String termsOfInterest) {
        this.termsOfInterest = termsOfInterest;
    }

    @JsonProperty("Total_Amount_Invested_USDollars")
    public String getTotalAmountInvestedUSDollars() {
        return totalAmountInvestedUSDollars;
    }

    @JsonProperty("Total_Amount_Invested_USDollars")
    public void setTotalAmountInvestedUSDollars(String totalAmountInvestedUSDollars) {
        this.totalAmountInvestedUSDollars = totalAmountInvestedUSDollars;
    }

    @JsonProperty("Value_of_Interest")
    public String getValueOfInterest() {
        return valueOfInterest;
    }

    @JsonProperty("Value_of_Interest")
    public void setValueOfInterest(String valueOfInterest) {
        this.valueOfInterest = valueOfInterest;
    }

}