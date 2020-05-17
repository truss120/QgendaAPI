package edu.bcm.api.entity.cms;

/*
This POJO was generated based on JSON data.
The initial code was generated at http://www.jsonschema2pojo.org/
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
public class CmsResearchObject_old extends CmsObject {

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
    @JsonProperty("physician_profile_id")
    private String physicianProfileId;
    @JsonProperty("preclinical_research_indicator")
    private String preclinicalResearchIndicator;
    @JsonProperty("principal_investigator_1_business_street_address_line1")
    private String principalInvestigator1BusinessStreetAddressLine1;
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
    private final static long serialVersionUID = -801161069467590002L;

    /**
     * No args constructor for use in serialization
     */
    public CmsResearchObject_old() {
    }

    /**
     * @param recordId
     * @param associatedDrugOrBiologicalNdc1
     * @param recipientState
     * @param principalInvestigator1BusinessStreetAddressLine1
     * @param applicableManufacturerOrApplicableGpoMakingPaymentState
     * @param principalInvestigator1State
     * @param principalInvestigator1Specialty
     * @param dateOfPayment
     * @param nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1
     * @param nameOfStudy
     * @param principalInvestigator1LicenseStateCode1
     * @param principalInvestigator1City
     * @param productCategoryOrTherapeuticArea1
     * @param applicableManufacturerOrApplicableGpoMakingPaymentId
     * @param delayInPublicationIndicator
     * @param recipientCountry
     * @param totalAmountOfPaymentUsdollars
     * @param disputeStatusForPublication
     * @param coveredRecipientType
     * @param applicableManufacturerOrApplicableGpoMakingPaymentCountry
     * @param preclinicalResearchIndicator
     * @param principalInvestigator1PrimaryType
     * @param principalInvestigator1LastName
     * @param principalInvestigator1ZipCode
     * @param principalInvestigator1ProfileId
     * @param applicableManufacturerOrApplicableGpoMakingPaymentName
     * @param changeType
     * @param indicateDrugOrBiologicalOrDeviceOrMedicalSupply1
     * @param formOfPaymentOrTransferOfValue
     * @param submittingApplicableManufacturerOrApplicableGpoName
     * @param principalInvestigator1FirstName
     * @param noncoveredRecipientEntityName
     * @param recipientPrimaryBusinessStreetAddressLine2
     * @param principalInvestigator1Country
     * @param recipientPrimaryBusinessStreetAddressLine1
     * @param programYear
     * @param relatedProductIndicator
     * @param coveredOrNoncoveredIndicator1
     * @param recipientCity
     * @param recipientZipCode
     * @param paymentPublicationDate
     * @param physicianProfileId
     */
    public CmsResearchObject_old(String applicableManufacturerOrApplicableGpoMakingPaymentCountry, String applicableManufacturerOrApplicableGpoMakingPaymentId, String applicableManufacturerOrApplicableGpoMakingPaymentName, String applicableManufacturerOrApplicableGpoMakingPaymentState, String associatedDrugOrBiologicalNdc1, String changeType, String coveredOrNoncoveredIndicator1, String coveredRecipientType, String dateOfPayment, String delayInPublicationIndicator, String disputeStatusForPublication, String formOfPaymentOrTransferOfValue, String indicateDrugOrBiologicalOrDeviceOrMedicalSupply1, String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1, String nameOfStudy, String noncoveredRecipientEntityName, String paymentPublicationDate, String physicianProfileId, String preclinicalResearchIndicator, String principalInvestigator1BusinessStreetAddressLine1, String principalInvestigator1City, String principalInvestigator1Country, String principalInvestigator1FirstName, String principalInvestigator1LastName, String principalInvestigator1LicenseStateCode1, String principalInvestigator1PrimaryType, String principalInvestigator1ProfileId, String principalInvestigator1Specialty, String principalInvestigator1State, String principalInvestigator1ZipCode, String productCategoryOrTherapeuticArea1, String programYear, String recipientCity, String recipientCountry, String recipientPrimaryBusinessStreetAddressLine1, String recipientPrimaryBusinessStreetAddressLine2, String recipientState, String recipientZipCode, String recordId, String relatedProductIndicator, String submittingApplicableManufacturerOrApplicableGpoName, String totalAmountOfPaymentUsdollars) {
        super();
        this.applicableManufacturerOrApplicableGpoMakingPaymentCountry = applicableManufacturerOrApplicableGpoMakingPaymentCountry;
        this.applicableManufacturerOrApplicableGpoMakingPaymentId = applicableManufacturerOrApplicableGpoMakingPaymentId;
        this.applicableManufacturerOrApplicableGpoMakingPaymentName = applicableManufacturerOrApplicableGpoMakingPaymentName;
        this.applicableManufacturerOrApplicableGpoMakingPaymentState = applicableManufacturerOrApplicableGpoMakingPaymentState;
        this.associatedDrugOrBiologicalNdc1 = associatedDrugOrBiologicalNdc1;
        this.changeType = changeType;
        this.coveredOrNoncoveredIndicator1 = coveredOrNoncoveredIndicator1;
        this.coveredRecipientType = coveredRecipientType;
        this.dateOfPayment = dateOfPayment;
        this.delayInPublicationIndicator = delayInPublicationIndicator;
        this.disputeStatusForPublication = disputeStatusForPublication;
        this.formOfPaymentOrTransferOfValue = formOfPaymentOrTransferOfValue;
        this.indicateDrugOrBiologicalOrDeviceOrMedicalSupply1 = indicateDrugOrBiologicalOrDeviceOrMedicalSupply1;
        this.nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1 = nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1;
        this.nameOfStudy = nameOfStudy;
        this.noncoveredRecipientEntityName = noncoveredRecipientEntityName;
        this.paymentPublicationDate = paymentPublicationDate;
        this.physicianProfileId = physicianProfileId;
        this.preclinicalResearchIndicator = preclinicalResearchIndicator;
        this.principalInvestigator1BusinessStreetAddressLine1 = principalInvestigator1BusinessStreetAddressLine1;
        this.principalInvestigator1City = principalInvestigator1City;
        this.principalInvestigator1Country = principalInvestigator1Country;
        this.principalInvestigator1FirstName = principalInvestigator1FirstName;
        this.principalInvestigator1LastName = principalInvestigator1LastName;
        this.principalInvestigator1LicenseStateCode1 = principalInvestigator1LicenseStateCode1;
        this.principalInvestigator1PrimaryType = principalInvestigator1PrimaryType;
        this.principalInvestigator1ProfileId = principalInvestigator1ProfileId;
        this.principalInvestigator1Specialty = principalInvestigator1Specialty;
        this.principalInvestigator1State = principalInvestigator1State;
        this.principalInvestigator1ZipCode = principalInvestigator1ZipCode;
        this.productCategoryOrTherapeuticArea1 = productCategoryOrTherapeuticArea1;
        this.programYear = programYear;
        this.recipientCity = recipientCity;
        this.recipientCountry = recipientCountry;
        this.recipientPrimaryBusinessStreetAddressLine1 = recipientPrimaryBusinessStreetAddressLine1;
        this.recipientPrimaryBusinessStreetAddressLine2 = recipientPrimaryBusinessStreetAddressLine2;
        this.recipientState = recipientState;
        this.recipientZipCode = recipientZipCode;
        this.recordId = recordId;
        this.relatedProductIndicator = relatedProductIndicator;
        this.submittingApplicableManufacturerOrApplicableGpoName = submittingApplicableManufacturerOrApplicableGpoName;
        this.totalAmountOfPaymentUsdollars = totalAmountOfPaymentUsdollars;
    }

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

    @JsonProperty("physician_profile_id")
    public String getPhysicianProfileId() {
        return physicianProfileId;
    }

    @JsonProperty("physician_profile_id")
    public void setPhysicianProfileId(String physicianProfileId) {
        this.physicianProfileId = physicianProfileId;
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

    @Override
    public String toString() {
        return "CmsResearchObject_old{" +
                "applicableManufacturerOrApplicableGpoMakingPaymentCountry='" + applicableManufacturerOrApplicableGpoMakingPaymentCountry + '\'' +
                ", applicableManufacturerOrApplicableGpoMakingPaymentId='" + applicableManufacturerOrApplicableGpoMakingPaymentId + '\'' +
                ", applicableManufacturerOrApplicableGpoMakingPaymentName='" + applicableManufacturerOrApplicableGpoMakingPaymentName + '\'' +
                ", applicableManufacturerOrApplicableGpoMakingPaymentState='" + applicableManufacturerOrApplicableGpoMakingPaymentState + '\'' +
                ", associatedDrugOrBiologicalNdc1='" + associatedDrugOrBiologicalNdc1 + '\'' +
                ", changeType='" + changeType + '\'' +
                ", coveredOrNoncoveredIndicator1='" + coveredOrNoncoveredIndicator1 + '\'' +
                ", coveredRecipientType='" + coveredRecipientType + '\'' +
                ", dateOfPayment='" + dateOfPayment + '\'' +
                ", delayInPublicationIndicator='" + delayInPublicationIndicator + '\'' +
                ", disputeStatusForPublication='" + disputeStatusForPublication + '\'' +
                ", formOfPaymentOrTransferOfValue='" + formOfPaymentOrTransferOfValue + '\'' +
                ", indicateDrugOrBiologicalOrDeviceOrMedicalSupply1='" + indicateDrugOrBiologicalOrDeviceOrMedicalSupply1 + '\'' +
                ", nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1='" + nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1 + '\'' +
                ", nameOfStudy='" + nameOfStudy + '\'' +
                ", noncoveredRecipientEntityName='" + noncoveredRecipientEntityName + '\'' +
                ", paymentPublicationDate='" + paymentPublicationDate + '\'' +
                ", physicianProfileId='" + physicianProfileId + '\'' +
                ", preclinicalResearchIndicator='" + preclinicalResearchIndicator + '\'' +
                ", principalInvestigator1BusinessStreetAddressLine1='" + principalInvestigator1BusinessStreetAddressLine1 + '\'' +
                ", principalInvestigator1City='" + principalInvestigator1City + '\'' +
                ", principalInvestigator1Country='" + principalInvestigator1Country + '\'' +
                ", principalInvestigator1FirstName='" + principalInvestigator1FirstName + '\'' +
                ", principalInvestigator1LastName='" + principalInvestigator1LastName + '\'' +
                ", principalInvestigator1LicenseStateCode1='" + principalInvestigator1LicenseStateCode1 + '\'' +
                ", principalInvestigator1PrimaryType='" + principalInvestigator1PrimaryType + '\'' +
                ", principalInvestigator1ProfileId='" + principalInvestigator1ProfileId + '\'' +
                ", principalInvestigator1Specialty='" + principalInvestigator1Specialty + '\'' +
                ", principalInvestigator1State='" + principalInvestigator1State + '\'' +
                ", principalInvestigator1ZipCode='" + principalInvestigator1ZipCode + '\'' +
                ", productCategoryOrTherapeuticArea1='" + productCategoryOrTherapeuticArea1 + '\'' +
                ", programYear='" + programYear + '\'' +
                ", recipientCity='" + recipientCity + '\'' +
                ", recipientCountry='" + recipientCountry + '\'' +
                ", recipientPrimaryBusinessStreetAddressLine1='" + recipientPrimaryBusinessStreetAddressLine1 + '\'' +
                ", recipientPrimaryBusinessStreetAddressLine2='" + recipientPrimaryBusinessStreetAddressLine2 + '\'' +
                ", recipientState='" + recipientState + '\'' +
                ", recipientZipCode='" + recipientZipCode + '\'' +
                ", recordId='" + recordId + '\'' +
                ", relatedProductIndicator='" + relatedProductIndicator + '\'' +
                ", submittingApplicableManufacturerOrApplicableGpoName='" + submittingApplicableManufacturerOrApplicableGpoName + '\'' +
                ", totalAmountOfPaymentUsdollars='" + totalAmountOfPaymentUsdollars + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}


