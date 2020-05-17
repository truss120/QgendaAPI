package edu.bcm.api.cms.entity;

/*
This POJO was generated based on JSON data.
The initial code was generated at http://www.jsonschema2pojo.org/
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, allowSetters = true)
public class CmsGeneralObject extends CmsObject {

    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_Country")
    private String applicableManufacturerOrApplicableGPOMakingPaymentCountry;
    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_ID")
    private String applicableManufacturerOrApplicableGPOMakingPaymentID;
    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_Name")
    private String applicableManufacturerOrApplicableGPOMakingPaymentName;
    @JsonProperty("Applicable_Manufacturer_or_Applicable_GPO_Making_Payment_State")
    private String applicableManufacturerOrApplicableGPOMakingPaymentState;
    @JsonProperty("Change_Type")
    private String changeType;
    @JsonProperty("Charity_Indicator")
    private String charityIndicator;
    @JsonProperty("Covered_Recipient_Type")
    private String coveredRecipientType;
    @JsonProperty("Covered_or_Noncovered_Indicator_1")
    private String coveredOrNoncoveredIndicator1;
    @JsonProperty("Date_of_Payment")
    private String dateOfPayment;
    @JsonProperty("Delay_in_Publication_Indicator")
    private String delayInPublicationIndicator;
    @JsonProperty("Dispute_Status_for_Publication")
    private String disputeStatusForPublication;
    @JsonProperty("Form_of_Payment_or_Transfer_of_Value")
    private String formOfPaymentOrTransferOfValue;
    @JsonProperty("Indicate_Drug_or_Biological_or_Device_or_Medical_Supply_1")
    private String indicateDrugOrBiologicalOrDeviceOrMedicalSupply1;
    @JsonProperty("Name_of_Drug_or_Biological_or_Device_or_Medical_Supply_1")
    private String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1;
    @JsonProperty("Nature_of_Payment_or_Transfer_of_Value")
    private String natureOfPaymentOrTransferOfValue;
    @JsonProperty("Number_of_Payments_Included_in_Total_Amount")
    private String numberOfPaymentsIncludedInTotalAmount;
    @JsonProperty("Payment_Publication_Date")
    private String paymentPublicationDate;
    @JsonProperty("Physician_First_Name")
    private String physicianFirstName;
    @JsonProperty("Physician_Last_Name")
    private String physicianLastName;
    @JsonProperty("Physician_License_State_code1")
    private String physicianLicenseStateCode1;
    @JsonProperty("Physician_Ownership_Indicator")
    private String physicianOwnershipIndicator;
    @JsonProperty("Physician_Primary_Type")
    private String physicianPrimaryType;
    @JsonProperty("Physician_Profile_ID")
    private String physicianProfileID;
    @JsonProperty("Physician_Specialty")
    private String physicianSpecialty;
    @JsonProperty("Product_Category_or_Therapeutic_Area_1")
    private String productCategoryOrTherapeuticArea1;
    @JsonProperty("Program_Year")
    private String programYear;
    @JsonProperty("Recipient_City")
    private String recipientCity;
    @JsonProperty("Recipient_Country")
    private String recipientCountry;
    @JsonProperty("Recipient_Primary_Business_Street_Address_Line1")
    private String recipientPrimaryBusinessStreetAddressLine1;
    @JsonProperty("Recipient_Primary_Business_Street_Address_Line2")
    private String recipientPrimaryBusinessStreetAddressLine2;
    @JsonProperty("Recipient_State")
    private String recipientState;
    @JsonProperty("Recipient_Zip_Code")
    private String recipientZipCode;
    @JsonProperty("Record_ID")
    private String recordID;
    @JsonProperty("Related_Product_Indicator")
    private String relatedProductIndicator;
    @JsonProperty("Submitting_Applicable_Manufacturer_or_Applicable_GPO_Name")
    private String submittingApplicableManufacturerOrApplicableGPOName;
    @JsonProperty("Third_Party_Payment_Recipient_Indicator")
    private String thirdPartyPaymentRecipientIndicator;
    @JsonProperty("Total_Amount_of_Payment_USDollars")
    private String totalAmountOfPaymentUSDollars;

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

    @JsonProperty("Charity_Indicator")
    public String getCharityIndicator() {
        return charityIndicator;
    }

    @JsonProperty("Charity_Indicator")
    public void setCharityIndicator(String charityIndicator) {
        this.charityIndicator = charityIndicator;
    }

    @JsonProperty("Covered_Recipient_Type")
    public String getCoveredRecipientType() {
        return coveredRecipientType;
    }

    @JsonProperty("Covered_Recipient_Type")
    public void setCoveredRecipientType(String coveredRecipientType) {
        this.coveredRecipientType = coveredRecipientType;
    }

    @JsonProperty("Covered_or_Noncovered_Indicator_1")
    public String getCoveredOrNoncoveredIndicator1() {
        return coveredOrNoncoveredIndicator1;
    }

    @JsonProperty("Covered_or_Noncovered_Indicator_1")
    public void setCoveredOrNoncoveredIndicator1(String coveredOrNoncoveredIndicator1) {
        this.coveredOrNoncoveredIndicator1 = coveredOrNoncoveredIndicator1;
    }

    @JsonProperty("Date_of_Payment")
    public String getDateOfPayment() {
        return dateOfPayment;
    }

    @JsonProperty("Date_of_Payment")
    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    @JsonProperty("Delay_in_Publication_Indicator")
    public String getDelayInPublicationIndicator() {
        return delayInPublicationIndicator;
    }

    @JsonProperty("Delay_in_Publication_Indicator")
    public void setDelayInPublicationIndicator(String delayInPublicationIndicator) {
        this.delayInPublicationIndicator = delayInPublicationIndicator;
    }

    @JsonProperty("Dispute_Status_for_Publication")
    public String getDisputeStatusForPublication() {
        return disputeStatusForPublication;
    }

    @JsonProperty("Dispute_Status_for_Publication")
    public void setDisputeStatusForPublication(String disputeStatusForPublication) {
        this.disputeStatusForPublication = disputeStatusForPublication;
    }

    @JsonProperty("Form_of_Payment_or_Transfer_of_Value")
    public String getFormOfPaymentOrTransferOfValue() {
        return formOfPaymentOrTransferOfValue;
    }

    @JsonProperty("Form_of_Payment_or_Transfer_of_Value")
    public void setFormOfPaymentOrTransferOfValue(String formOfPaymentOrTransferOfValue) {
        this.formOfPaymentOrTransferOfValue = formOfPaymentOrTransferOfValue;
    }

    @JsonProperty("Indicate_Drug_or_Biological_or_Device_or_Medical_Supply_1")
    public String getIndicateDrugOrBiologicalOrDeviceOrMedicalSupply1() {
        return indicateDrugOrBiologicalOrDeviceOrMedicalSupply1;
    }

    @JsonProperty("Indicate_Drug_or_Biological_or_Device_or_Medical_Supply_1")
    public void setIndicateDrugOrBiologicalOrDeviceOrMedicalSupply1(String indicateDrugOrBiologicalOrDeviceOrMedicalSupply1) {
        this.indicateDrugOrBiologicalOrDeviceOrMedicalSupply1 = indicateDrugOrBiologicalOrDeviceOrMedicalSupply1;
    }

    @JsonProperty("Name_of_Drug_or_Biological_or_Device_or_Medical_Supply_1")
    public String getNameOfDrugOrBiologicalOrDeviceOrMedicalSupply1() {
        return nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1;
    }

    @JsonProperty("Name_of_Drug_or_Biological_or_Device_or_Medical_Supply_1")
    public void setNameOfDrugOrBiologicalOrDeviceOrMedicalSupply1(String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1) {
        this.nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1 = nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1;
    }

    @JsonProperty("Nature_of_Payment_or_Transfer_of_Value")
    public String getNatureOfPaymentOrTransferOfValue() {
        return natureOfPaymentOrTransferOfValue;
    }

    @JsonProperty("Nature_of_Payment_or_Transfer_of_Value")
    public void setNatureOfPaymentOrTransferOfValue(String natureOfPaymentOrTransferOfValue) {
        this.natureOfPaymentOrTransferOfValue = natureOfPaymentOrTransferOfValue;
    }

    @JsonProperty("Number_of_Payments_Included_in_Total_Amount")
    public String getNumberOfPaymentsIncludedInTotalAmount() {
        return numberOfPaymentsIncludedInTotalAmount;
    }

    @JsonProperty("Number_of_Payments_Included_in_Total_Amount")
    public void setNumberOfPaymentsIncludedInTotalAmount(String numberOfPaymentsIncludedInTotalAmount) {
        this.numberOfPaymentsIncludedInTotalAmount = numberOfPaymentsIncludedInTotalAmount;
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

    @JsonProperty("Physician_License_State_code1")
    public String getPhysicianLicenseStateCode1() {
        return physicianLicenseStateCode1;
    }

    @JsonProperty("Physician_License_State_code1")
    public void setPhysicianLicenseStateCode1(String physicianLicenseStateCode1) {
        this.physicianLicenseStateCode1 = physicianLicenseStateCode1;
    }

    @JsonProperty("Physician_Ownership_Indicator")
    public String getPhysicianOwnershipIndicator() {
        return physicianOwnershipIndicator;
    }

    @JsonProperty("Physician_Ownership_Indicator")
    public void setPhysicianOwnershipIndicator(String physicianOwnershipIndicator) {
        this.physicianOwnershipIndicator = physicianOwnershipIndicator;
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

    @JsonProperty("Product_Category_or_Therapeutic_Area_1")
    public String getProductCategoryOrTherapeuticArea1() {
        return productCategoryOrTherapeuticArea1;
    }

    @JsonProperty("Product_Category_or_Therapeutic_Area_1")
    public void setProductCategoryOrTherapeuticArea1(String productCategoryOrTherapeuticArea1) {
        this.productCategoryOrTherapeuticArea1 = productCategoryOrTherapeuticArea1;
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

    @JsonProperty("Recipient_Primary_Business_Street_Address_Line2")
    public String getRecipientPrimaryBusinessStreetAddressLine2() {
        return recipientPrimaryBusinessStreetAddressLine2;
    }

    @JsonProperty("Recipient_Primary_Business_Street_Address_Line2")
    public void setRecipientPrimaryBusinessStreetAddressLine2(String recipientPrimaryBusinessStreetAddressLine2) {
        this.recipientPrimaryBusinessStreetAddressLine2 = recipientPrimaryBusinessStreetAddressLine2;
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

    @JsonProperty("Related_Product_Indicator")
    public String getRelatedProductIndicator() {
        return relatedProductIndicator;
    }

    @JsonProperty("Related_Product_Indicator")
    public void setRelatedProductIndicator(String relatedProductIndicator) {
        this.relatedProductIndicator = relatedProductIndicator;
    }

    @JsonProperty("Submitting_Applicable_Manufacturer_or_Applicable_GPO_Name")
    public String getSubmittingApplicableManufacturerOrApplicableGPOName() {
        return submittingApplicableManufacturerOrApplicableGPOName;
    }

    @JsonProperty("Submitting_Applicable_Manufacturer_or_Applicable_GPO_Name")
    public void setSubmittingApplicableManufacturerOrApplicableGPOName(String submittingApplicableManufacturerOrApplicableGPOName) {
        this.submittingApplicableManufacturerOrApplicableGPOName = submittingApplicableManufacturerOrApplicableGPOName;
    }

    @JsonProperty("Third_Party_Payment_Recipient_Indicator")
    public String getThirdPartyPaymentRecipientIndicator() {
        return thirdPartyPaymentRecipientIndicator;
    }

    @JsonProperty("Third_Party_Payment_Recipient_Indicator")
    public void setThirdPartyPaymentRecipientIndicator(String thirdPartyPaymentRecipientIndicator) {
        this.thirdPartyPaymentRecipientIndicator = thirdPartyPaymentRecipientIndicator;
    }

    @JsonProperty("Total_Amount_of_Payment_USDollars")
    public String getTotalAmountOfPaymentUSDollars() {
        return totalAmountOfPaymentUSDollars;
    }

    @JsonProperty("Total_Amount_of_Payment_USDollars")
    public void setTotalAmountOfPaymentUSDollars(String totalAmountOfPaymentUSDollars) {
        this.totalAmountOfPaymentUSDollars = totalAmountOfPaymentUSDollars;
    }
}