package edu.bcm.api.cms.entity;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "applicable_manufacturer_or_applicable_gpo_making_payment_country",
        "applicable_manufacturer_or_applicable_gpo_making_payment_id",
        "applicable_manufacturer_or_applicable_gpo_making_payment_name",
        "applicable_manufacturer_or_applicable_gpo_making_payment_state",
        "associated_drug_or_biological_ndc_1",
        "change_type",
        "covered_or_noncovered_indicator_1",
        "covered_recipient_type",
        "date_of_payment",
        "delay_in_publication_indicator",
        "dispute_status_for_publication",
        "form_of_payment_or_transfer_of_value",
        "indicate_drug_or_biological_or_device_or_medical_supply_1",
        "name_of_drug_or_biological_or_device_or_medical_supply_1",
        "name_of_study",
        "noncovered_recipient_entity_name",
        "payment_publication_date",
        "preclinical_research_indicator",
        "principal_investigator_1_business_street_address_line1",
        "principal_investigator_1_business_street_address_line2",
        "principal_investigator_1_city",
        "principal_investigator_1_country",
        "principal_investigator_1_first_name",
        "principal_investigator_1_last_name",
        "principal_investigator_1_license_state_code1",
        "principal_investigator_1_middle_name",
        "principal_investigator_1_primary_type",
        "principal_investigator_1_profile_id",
        "principal_investigator_1_specialty",
        "principal_investigator_1_state",
        "principal_investigator_1_zip_code",
        "product_category_or_therapeutic_area_1",
        "program_year",
        "recipient_city",
        "recipient_country",
        "recipient_primary_business_street_address_line1",
        "recipient_primary_business_street_address_line2",
        "recipient_state",
        "recipient_zip_code",
        "record_id",
        "related_product_indicator",
        "submitting_applicable_manufacturer_or_applicable_gpo_name",
        "total_amount_of_payment_usdollars"
})
public class CmsResearchObject extends CmsObject {

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_country")
    private String applicableManufacturerOrApplicableGpoMakingPaymentCountry;
    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_id")
    private String applicableManufacturerOrApplicableGpoMakingPaymentId;
    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_name")
    private String applicableManufacturerOrApplicableGpoMakingPaymentName;
    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_state")
    private String applicableManufacturerOrApplicableGpoMakingPaymentState;
    @JsonProperty("associated_drug_or_biological_ndc_1")
    private String associatedDrugOrBiologicalNdc1;
    @JsonProperty("change_type")
    private String changeType;
    @JsonProperty("covered_or_noncovered_indicator_1")
    private String coveredOrNoncoveredIndicator1;
    @JsonProperty("covered_recipient_type")
    private String coveredRecipientType;
    @JsonProperty("date_of_payment")
    private String dateOfPayment;
    @JsonProperty("delay_in_publication_indicator")
    private String delayInPublicationIndicator;
    @JsonProperty("dispute_status_for_publication")
    private String disputeStatusForPublication;
    @JsonProperty("form_of_payment_or_transfer_of_value")
    private String formOfPaymentOrTransferOfValue;
    @JsonProperty("indicate_drug_or_biological_or_device_or_medical_supply_1")
    private String indicateDrugOrBiologicalOrDeviceOrMedicalSupply1;
    @JsonProperty("name_of_drug_or_biological_or_device_or_medical_supply_1")
    private String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1;
    @JsonProperty("name_of_study")
    private String nameOfStudy;
    @JsonProperty("noncovered_recipient_entity_name")
    private String noncoveredRecipientEntityName;
    @JsonProperty("payment_publication_date")
    private String paymentPublicationDate;
    @JsonProperty("preclinical_research_indicator")
    private String preclinicalResearchIndicator;
    @JsonProperty("principal_investigator_1_business_street_address_line1")
    private String principalInvestigator1BusinessStreetAddressLine1;
    @JsonProperty("principal_investigator_1_business_street_address_line2")
    private String principalInvestigator1BusinessStreetAddressLine2;
    @JsonProperty("principal_investigator_1_city")
    private String principalInvestigator1City;
    @JsonProperty("principal_investigator_1_country")
    private String principalInvestigator1Country;
    @JsonProperty("principal_investigator_1_first_name")
    private String principalInvestigator1FirstName;
    @JsonProperty("principal_investigator_1_last_name")
    private String principalInvestigator1LastName;
    @JsonProperty("principal_investigator_1_license_state_code1")
    private String principalInvestigator1LicenseStateCode1;
    @JsonProperty("principal_investigator_1_middle_name")
    private String principalInvestigator1MiddleName;
    @JsonProperty("principal_investigator_1_primary_type")
    private String principalInvestigator1PrimaryType;
    @JsonProperty("principal_investigator_1_profile_id")
    private String principalInvestigator1ProfileId;
    @JsonProperty("principal_investigator_1_specialty")
    private String principalInvestigator1Specialty;
    @JsonProperty("principal_investigator_1_state")
    private String principalInvestigator1State;
    @JsonProperty("principal_investigator_1_zip_code")
    private String principalInvestigator1ZipCode;
    @JsonProperty("product_category_or_therapeutic_area_1")
    private String productCategoryOrTherapeuticArea1;
    @JsonProperty("program_year")
    private String programYear;
    @JsonProperty("recipient_city")
    private String recipientCity;
    @JsonProperty("recipient_country")
    private String recipientCountry;
    @JsonProperty("recipient_primary_business_street_address_line1")
    private String recipientPrimaryBusinessStreetAddressLine1;
    @JsonProperty("recipient_primary_business_street_address_line2")
    private String recipientPrimaryBusinessStreetAddressLine2;
    @JsonProperty("recipient_state")
    private String recipientState;
    @JsonProperty("recipient_zip_code")
    private String recipientZipCode;
    @JsonProperty("record_id")
    private String recordId;
    @JsonProperty("related_product_indicator")
    private String relatedProductIndicator;
    @JsonProperty("submitting_applicable_manufacturer_or_applicable_gpo_name")
    private String submittingApplicableManufacturerOrApplicableGpoName;
    @JsonProperty("total_amount_of_payment_usdollars")
    private String totalAmountOfPaymentUsdollars;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5126766909838088177L;

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_country")
    public String getApplicableManufacturerOrApplicableGpoMakingPaymentCountry() {
        return applicableManufacturerOrApplicableGpoMakingPaymentCountry;
    }

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_country")
    public void setApplicableManufacturerOrApplicableGpoMakingPaymentCountry(String applicableManufacturerOrApplicableGpoMakingPaymentCountry) {
        this.applicableManufacturerOrApplicableGpoMakingPaymentCountry = applicableManufacturerOrApplicableGpoMakingPaymentCountry;
    }

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_id")
    public String getApplicableManufacturerOrApplicableGpoMakingPaymentId() {
        return applicableManufacturerOrApplicableGpoMakingPaymentId;
    }

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_id")
    public void setApplicableManufacturerOrApplicableGpoMakingPaymentId(String applicableManufacturerOrApplicableGpoMakingPaymentId) {
        this.applicableManufacturerOrApplicableGpoMakingPaymentId = applicableManufacturerOrApplicableGpoMakingPaymentId;
    }

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_name")
    public String getApplicableManufacturerOrApplicableGpoMakingPaymentName() {
        return applicableManufacturerOrApplicableGpoMakingPaymentName;
    }

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_name")
    public void setApplicableManufacturerOrApplicableGpoMakingPaymentName(String applicableManufacturerOrApplicableGpoMakingPaymentName) {
        this.applicableManufacturerOrApplicableGpoMakingPaymentName = applicableManufacturerOrApplicableGpoMakingPaymentName;
    }

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_state")
    public String getApplicableManufacturerOrApplicableGpoMakingPaymentState() {
        return applicableManufacturerOrApplicableGpoMakingPaymentState;
    }

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_state")
    public void setApplicableManufacturerOrApplicableGpoMakingPaymentState(String applicableManufacturerOrApplicableGpoMakingPaymentState) {
        this.applicableManufacturerOrApplicableGpoMakingPaymentState = applicableManufacturerOrApplicableGpoMakingPaymentState;
    }

    @JsonProperty("associated_drug_or_biological_ndc_1")
    public String getAssociatedDrugOrBiologicalNdc1() {
        return associatedDrugOrBiologicalNdc1;
    }

    @JsonProperty("associated_drug_or_biological_ndc_1")
    public void setAssociatedDrugOrBiologicalNdc1(String associatedDrugOrBiologicalNdc1) {
        this.associatedDrugOrBiologicalNdc1 = associatedDrugOrBiologicalNdc1;
    }

    @JsonProperty("change_type")
    public String getChangeType() {
        return changeType;
    }

    @JsonProperty("change_type")
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    @JsonProperty("covered_or_noncovered_indicator_1")
    public String getCoveredOrNoncoveredIndicator1() {
        return coveredOrNoncoveredIndicator1;
    }

    @JsonProperty("covered_or_noncovered_indicator_1")
    public void setCoveredOrNoncoveredIndicator1(String coveredOrNoncoveredIndicator1) {
        this.coveredOrNoncoveredIndicator1 = coveredOrNoncoveredIndicator1;
    }

    @JsonProperty("covered_recipient_type")
    public String getCoveredRecipientType() {
        return coveredRecipientType;
    }

    @JsonProperty("covered_recipient_type")
    public void setCoveredRecipientType(String coveredRecipientType) {
        this.coveredRecipientType = coveredRecipientType;
    }

    @JsonProperty("date_of_payment")
    public String getDateOfPayment() {
        return dateOfPayment;
    }

    @JsonProperty("date_of_payment")
    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    @JsonProperty("delay_in_publication_indicator")
    public String getDelayInPublicationIndicator() {
        return delayInPublicationIndicator;
    }

    @JsonProperty("delay_in_publication_indicator")
    public void setDelayInPublicationIndicator(String delayInPublicationIndicator) {
        this.delayInPublicationIndicator = delayInPublicationIndicator;
    }

    @JsonProperty("dispute_status_for_publication")
    public String getDisputeStatusForPublication() {
        return disputeStatusForPublication;
    }

    @JsonProperty("dispute_status_for_publication")
    public void setDisputeStatusForPublication(String disputeStatusForPublication) {
        this.disputeStatusForPublication = disputeStatusForPublication;
    }

    @JsonProperty("form_of_payment_or_transfer_of_value")
    public String getFormOfPaymentOrTransferOfValue() {
        return formOfPaymentOrTransferOfValue;
    }

    @JsonProperty("form_of_payment_or_transfer_of_value")
    public void setFormOfPaymentOrTransferOfValue(String formOfPaymentOrTransferOfValue) {
        this.formOfPaymentOrTransferOfValue = formOfPaymentOrTransferOfValue;
    }

    @JsonProperty("indicate_drug_or_biological_or_device_or_medical_supply_1")
    public String getIndicateDrugOrBiologicalOrDeviceOrMedicalSupply1() {
        return indicateDrugOrBiologicalOrDeviceOrMedicalSupply1;
    }

    @JsonProperty("indicate_drug_or_biological_or_device_or_medical_supply_1")
    public void setIndicateDrugOrBiologicalOrDeviceOrMedicalSupply1(String indicateDrugOrBiologicalOrDeviceOrMedicalSupply1) {
        this.indicateDrugOrBiologicalOrDeviceOrMedicalSupply1 = indicateDrugOrBiologicalOrDeviceOrMedicalSupply1;
    }

    @JsonProperty("name_of_drug_or_biological_or_device_or_medical_supply_1")
    public String getNameOfDrugOrBiologicalOrDeviceOrMedicalSupply1() {
        return nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1;
    }

    @JsonProperty("name_of_drug_or_biological_or_device_or_medical_supply_1")
    public void setNameOfDrugOrBiologicalOrDeviceOrMedicalSupply1(String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1) {
        this.nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1 = nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1;
    }

    @JsonProperty("name_of_study")
    public String getNameOfStudy() {
        return nameOfStudy;
    }

    @JsonProperty("name_of_study")
    public void setNameOfStudy(String nameOfStudy) {
        this.nameOfStudy = nameOfStudy;
    }

    @JsonProperty("noncovered_recipient_entity_name")
    public String getNoncoveredRecipientEntityName() {
        return noncoveredRecipientEntityName;
    }

    @JsonProperty("noncovered_recipient_entity_name")
    public void setNoncoveredRecipientEntityName(String noncoveredRecipientEntityName) {
        this.noncoveredRecipientEntityName = noncoveredRecipientEntityName;
    }

    @JsonProperty("payment_publication_date")
    public String getPaymentPublicationDate() {
        return paymentPublicationDate;
    }

    @JsonProperty("payment_publication_date")
    public void setPaymentPublicationDate(String paymentPublicationDate) {
        this.paymentPublicationDate = paymentPublicationDate;
    }

    @JsonProperty("preclinical_research_indicator")
    public String getPreclinicalResearchIndicator() {
        return preclinicalResearchIndicator;
    }

    @JsonProperty("preclinical_research_indicator")
    public void setPreclinicalResearchIndicator(String preclinicalResearchIndicator) {
        this.preclinicalResearchIndicator = preclinicalResearchIndicator;
    }

    @JsonProperty("principal_investigator_1_business_street_address_line1")
    public String getPrincipalInvestigator1BusinessStreetAddressLine1() {
        return principalInvestigator1BusinessStreetAddressLine1;
    }

    @JsonProperty("principal_investigator_1_business_street_address_line1")
    public void setPrincipalInvestigator1BusinessStreetAddressLine1(String principalInvestigator1BusinessStreetAddressLine1) {
        this.principalInvestigator1BusinessStreetAddressLine1 = principalInvestigator1BusinessStreetAddressLine1;
    }

    @JsonProperty("principal_investigator_1_business_street_address_line2")
    public String getPrincipalInvestigator1BusinessStreetAddressLine2() {
        return principalInvestigator1BusinessStreetAddressLine2;
    }

    @JsonProperty("principal_investigator_1_business_street_address_line2")
    public void setPrincipalInvestigator1BusinessStreetAddressLine2(String principalInvestigator1BusinessStreetAddressLine2) {
        this.principalInvestigator1BusinessStreetAddressLine2 = principalInvestigator1BusinessStreetAddressLine2;
    }

    @JsonProperty("principal_investigator_1_city")
    public String getPrincipalInvestigator1City() {
        return principalInvestigator1City;
    }

    @JsonProperty("principal_investigator_1_city")
    public void setPrincipalInvestigator1City(String principalInvestigator1City) {
        this.principalInvestigator1City = principalInvestigator1City;
    }

    @JsonProperty("principal_investigator_1_country")
    public String getPrincipalInvestigator1Country() {
        return principalInvestigator1Country;
    }

    @JsonProperty("principal_investigator_1_country")
    public void setPrincipalInvestigator1Country(String principalInvestigator1Country) {
        this.principalInvestigator1Country = principalInvestigator1Country;
    }

    @JsonProperty("principal_investigator_1_first_name")
    public String getPrincipalInvestigator1FirstName() {
        return principalInvestigator1FirstName;
    }

    @JsonProperty("principal_investigator_1_first_name")
    public void setPrincipalInvestigator1FirstName(String principalInvestigator1FirstName) {
        this.principalInvestigator1FirstName = principalInvestigator1FirstName;
    }

    @JsonProperty("principal_investigator_1_last_name")
    public String getPrincipalInvestigator1LastName() {
        return principalInvestigator1LastName;
    }

    @JsonProperty("principal_investigator_1_last_name")
    public void setPrincipalInvestigator1LastName(String principalInvestigator1LastName) {
        this.principalInvestigator1LastName = principalInvestigator1LastName;
    }

    @JsonProperty("principal_investigator_1_license_state_code1")
    public String getPrincipalInvestigator1LicenseStateCode1() {
        return principalInvestigator1LicenseStateCode1;
    }

    @JsonProperty("principal_investigator_1_license_state_code1")
    public void setPrincipalInvestigator1LicenseStateCode1(String principalInvestigator1LicenseStateCode1) {
        this.principalInvestigator1LicenseStateCode1 = principalInvestigator1LicenseStateCode1;
    }

    @JsonProperty("principal_investigator_1_middle_name")
    public String getPrincipalInvestigator1MiddleName() {
        return principalInvestigator1MiddleName;
    }

    @JsonProperty("principal_investigator_1_middle_name")
    public void setPrincipalInvestigator1MiddleName(String principalInvestigator1MiddleName) {
        this.principalInvestigator1MiddleName = principalInvestigator1MiddleName;
    }

    @JsonProperty("principal_investigator_1_primary_type")
    public String getPrincipalInvestigator1PrimaryType() {
        return principalInvestigator1PrimaryType;
    }

    @JsonProperty("principal_investigator_1_primary_type")
    public void setPrincipalInvestigator1PrimaryType(String principalInvestigator1PrimaryType) {
        this.principalInvestigator1PrimaryType = principalInvestigator1PrimaryType;
    }

    @JsonProperty("principal_investigator_1_profile_id")
    public String getPrincipalInvestigator1ProfileId() {
        return principalInvestigator1ProfileId;
    }

    @JsonProperty("principal_investigator_1_profile_id")
    public void setPrincipalInvestigator1ProfileId(String principalInvestigator1ProfileId) {
        this.principalInvestigator1ProfileId = principalInvestigator1ProfileId;
    }

    @JsonProperty("principal_investigator_1_specialty")
    public String getPrincipalInvestigator1Specialty() {
        return principalInvestigator1Specialty;
    }

    @JsonProperty("principal_investigator_1_specialty")
    public void setPrincipalInvestigator1Specialty(String principalInvestigator1Specialty) {
        this.principalInvestigator1Specialty = principalInvestigator1Specialty;
    }

    @JsonProperty("principal_investigator_1_state")
    public String getPrincipalInvestigator1State() {
        return principalInvestigator1State;
    }

    @JsonProperty("principal_investigator_1_state")
    public void setPrincipalInvestigator1State(String principalInvestigator1State) {
        this.principalInvestigator1State = principalInvestigator1State;
    }

    @JsonProperty("principal_investigator_1_zip_code")
    public String getPrincipalInvestigator1ZipCode() {
        return principalInvestigator1ZipCode;
    }

    @JsonProperty("principal_investigator_1_zip_code")
    public void setPrincipalInvestigator1ZipCode(String principalInvestigator1ZipCode) {
        this.principalInvestigator1ZipCode = principalInvestigator1ZipCode;
    }

    @JsonProperty("product_category_or_therapeutic_area_1")
    public String getProductCategoryOrTherapeuticArea1() {
        return productCategoryOrTherapeuticArea1;
    }

    @JsonProperty("product_category_or_therapeutic_area_1")
    public void setProductCategoryOrTherapeuticArea1(String productCategoryOrTherapeuticArea1) {
        this.productCategoryOrTherapeuticArea1 = productCategoryOrTherapeuticArea1;
    }

    @JsonProperty("program_year")
    public String getProgramYear() {
        return programYear;
    }

    @JsonProperty("program_year")
    public void setProgramYear(String programYear) {
        this.programYear = programYear;
    }

    @JsonProperty("recipient_city")
    public String getRecipientCity() {
        return recipientCity;
    }

    @JsonProperty("recipient_city")
    public void setRecipientCity(String recipientCity) {
        this.recipientCity = recipientCity;
    }

    @JsonProperty("recipient_country")
    public String getRecipientCountry() {
        return recipientCountry;
    }

    @JsonProperty("recipient_country")
    public void setRecipientCountry(String recipientCountry) {
        this.recipientCountry = recipientCountry;
    }

    @JsonProperty("recipient_primary_business_street_address_line1")
    public String getRecipientPrimaryBusinessStreetAddressLine1() {
        return recipientPrimaryBusinessStreetAddressLine1;
    }

    @JsonProperty("recipient_primary_business_street_address_line1")
    public void setRecipientPrimaryBusinessStreetAddressLine1(String recipientPrimaryBusinessStreetAddressLine1) {
        this.recipientPrimaryBusinessStreetAddressLine1 = recipientPrimaryBusinessStreetAddressLine1;
    }

    @JsonProperty("recipient_primary_business_street_address_line2")
    public String getRecipientPrimaryBusinessStreetAddressLine2() {
        return recipientPrimaryBusinessStreetAddressLine2;
    }

    @JsonProperty("recipient_primary_business_street_address_line2")
    public void setRecipientPrimaryBusinessStreetAddressLine2(String recipientPrimaryBusinessStreetAddressLine2) {
        this.recipientPrimaryBusinessStreetAddressLine2 = recipientPrimaryBusinessStreetAddressLine2;
    }

    @JsonProperty("recipient_state")
    public String getRecipientState() {
        return recipientState;
    }

    @JsonProperty("recipient_state")
    public void setRecipientState(String recipientState) {
        this.recipientState = recipientState;
    }

    @JsonProperty("recipient_zip_code")
    public String getRecipientZipCode() {
        return recipientZipCode;
    }

    @JsonProperty("recipient_zip_code")
    public void setRecipientZipCode(String recipientZipCode) {
        this.recipientZipCode = recipientZipCode;
    }

    @JsonProperty("record_id")
    public String getRecordId() {
        return recordId;
    }

    @JsonProperty("record_id")
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @JsonProperty("related_product_indicator")
    public String getRelatedProductIndicator() {
        return relatedProductIndicator;
    }

    @JsonProperty("related_product_indicator")
    public void setRelatedProductIndicator(String relatedProductIndicator) {
        this.relatedProductIndicator = relatedProductIndicator;
    }

    @JsonProperty("submitting_applicable_manufacturer_or_applicable_gpo_name")
    public String getSubmittingApplicableManufacturerOrApplicableGpoName() {
        return submittingApplicableManufacturerOrApplicableGpoName;
    }

    @JsonProperty("submitting_applicable_manufacturer_or_applicable_gpo_name")
    public void setSubmittingApplicableManufacturerOrApplicableGpoName(String submittingApplicableManufacturerOrApplicableGpoName) {
        this.submittingApplicableManufacturerOrApplicableGpoName = submittingApplicableManufacturerOrApplicableGpoName;
    }

    @JsonProperty("total_amount_of_payment_usdollars")
    public String getTotalAmountOfPaymentUsdollars() {
        return totalAmountOfPaymentUsdollars;
    }

    @JsonProperty("total_amount_of_payment_usdollars")
    public void setTotalAmountOfPaymentUsdollars(String totalAmountOfPaymentUsdollars) {
        this.totalAmountOfPaymentUsdollars = totalAmountOfPaymentUsdollars;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}