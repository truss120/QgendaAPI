package edu.bcm.api.cms.entity;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "applicable_manufacturer_or_applicable_gpo_making_payment_country",
        "applicable_manufacturer_or_applicable_gpo_making_payment_id",
        "applicable_manufacturer_or_applicable_gpo_making_payment_name",
        "applicable_manufacturer_or_applicable_gpo_making_payment_state",
        "change_type",
        "dispute_status_for_publication",
        "payment_publication_date",
        "program_year",
        "recipient_city",
        "recipient_country",
        "recipient_primary_business_street_address_line1",
        "recipient_primary_business_street_address_line2",
        "recipient_state",
        "recipient_zip_code",
        "record_id",
        "submitting_applicable_manufacturer_or_applicable_gpo_name",
        "total_amount_of_payment_usdollars"
})
public class CmsObject implements Serializable {

    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_country")
    private String applicableManufacturerOrApplicableGpoMakingPaymentCountry;
    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_id")
    private String applicableManufacturerOrApplicableGpoMakingPaymentId;
    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_name")
    private String applicableManufacturerOrApplicableGpoMakingPaymentName;
    @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_state")
    private String applicableManufacturerOrApplicableGpoMakingPaymentState;
    @JsonProperty("change_type")
    private String changeType;
    @JsonProperty("dispute_status_for_publication")
    private String disputeStatusForPublication;
    @JsonProperty("payment_publication_date")
    private String paymentPublicationDate;
    @JsonProperty("physician_profile_id")
    private String physicianProfileId;
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
    @JsonProperty("submitting_applicable_manufacturer_or_applicable_gpo_name")
    private String submittingApplicableManufacturerOrApplicableGpoName;
    @JsonProperty("total_amount_of_payment_usdollars")
    private String totalAmountOfPaymentUsdollars;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 950302108035640642L;

    /**
     * No args constructor for use in serialization
     */
    public CmsObject() {
    }

    /**
     * @param recordId
     * @param applicableManufacturerOrApplicableGpoMakingPaymentCountry
     * @param recipientState
     * @param applicableManufacturerOrApplicableGpoMakingPaymentState
     * @param applicableManufacturerOrApplicableGpoMakingPaymentName
     * @param changeType
     * @param submittingApplicableManufacturerOrApplicableGpoName
     * @param applicableManufacturerOrApplicableGpoMakingPaymentId
     * @param recipientPrimaryBusinessStreetAddressLine2
     * @param recipientPrimaryBusinessStreetAddressLine1
     * @param programYear
     * @param recipientCountry
     * @param totalAmountOfPaymentUsdollars
     * @param disputeStatusForPublication
     * @param recipientCity
     * @param recipientZipCode
     * @param paymentPublicationDate
     */
    public CmsObject(String applicableManufacturerOrApplicableGpoMakingPaymentCountry, String applicableManufacturerOrApplicableGpoMakingPaymentId, String applicableManufacturerOrApplicableGpoMakingPaymentName, String applicableManufacturerOrApplicableGpoMakingPaymentState, String changeType, String disputeStatusForPublication, String paymentPublicationDate, String physicianProfileId, String programYear, String recipientCity, String recipientCountry, String recipientPrimaryBusinessStreetAddressLine1, String recipientPrimaryBusinessStreetAddressLine2, String recipientState, String recipientZipCode, String recordId, String submittingApplicableManufacturerOrApplicableGpoName, String totalAmountOfPaymentUsdollars) {
        super();
        this.applicableManufacturerOrApplicableGpoMakingPaymentCountry = applicableManufacturerOrApplicableGpoMakingPaymentCountry;
        this.applicableManufacturerOrApplicableGpoMakingPaymentId = applicableManufacturerOrApplicableGpoMakingPaymentId;
        this.applicableManufacturerOrApplicableGpoMakingPaymentName = applicableManufacturerOrApplicableGpoMakingPaymentName;
        this.applicableManufacturerOrApplicableGpoMakingPaymentState = applicableManufacturerOrApplicableGpoMakingPaymentState;
        this.changeType = changeType;
        this.disputeStatusForPublication = disputeStatusForPublication;
        this.paymentPublicationDate = paymentPublicationDate;
        this.physicianProfileId = physicianProfileId;
        this.programYear = programYear;
        this.recipientCity = recipientCity;
        this.recipientCountry = recipientCountry;
        this.recipientPrimaryBusinessStreetAddressLine1 = recipientPrimaryBusinessStreetAddressLine1;
        this.recipientPrimaryBusinessStreetAddressLine2 = recipientPrimaryBusinessStreetAddressLine2;
        this.recipientState = recipientState;
        this.recipientZipCode = recipientZipCode;
        this.recordId = recordId;
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

    @JsonProperty("change_type")
    public String getChangeType() {
        return changeType;
    }

    @JsonProperty("change_type")
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    @JsonProperty("dispute_status_for_publication")
    public String getDisputeStatusForPublication() {
        return disputeStatusForPublication;
    }

    @JsonProperty("dispute_status_for_publication")
    public void setDisputeStatusForPublication(String disputeStatusForPublication) {
        this.disputeStatusForPublication = disputeStatusForPublication;
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
        return "CmsObject{" +
                "applicableManufacturerOrApplicableGpoMakingPaymentCountry='" + applicableManufacturerOrApplicableGpoMakingPaymentCountry + '\'' +
                ", applicableManufacturerOrApplicableGpoMakingPaymentId='" + applicableManufacturerOrApplicableGpoMakingPaymentId + '\'' +
                ", applicableManufacturerOrApplicableGpoMakingPaymentName='" + applicableManufacturerOrApplicableGpoMakingPaymentName + '\'' +
                ", applicableManufacturerOrApplicableGpoMakingPaymentState='" + applicableManufacturerOrApplicableGpoMakingPaymentState + '\'' +
                ", changeType='" + changeType + '\'' +
                ", disputeStatusForPublication='" + disputeStatusForPublication + '\'' +
                ", paymentPublicationDate='" + paymentPublicationDate + '\'' +
                ", physicianProfileId='" + physicianProfileId + '\'' +
                ", programYear='" + programYear + '\'' +
                ", recipientCity='" + recipientCity + '\'' +
                ", recipientCountry='" + recipientCountry + '\'' +
                ", recipientPrimaryBusinessStreetAddressLine1='" + recipientPrimaryBusinessStreetAddressLine1 + '\'' +
                ", recipientPrimaryBusinessStreetAddressLine2='" + recipientPrimaryBusinessStreetAddressLine2 + '\'' +
                ", recipientState='" + recipientState + '\'' +
                ", recipientZipCode='" + recipientZipCode + '\'' +
                ", recordId='" + recordId + '\'' +
                ", submittingApplicableManufacturerOrApplicableGpoName='" + submittingApplicableManufacturerOrApplicableGpoName + '\'' +
                ", totalAmountOfPaymentUsdollars='" + totalAmountOfPaymentUsdollars + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}