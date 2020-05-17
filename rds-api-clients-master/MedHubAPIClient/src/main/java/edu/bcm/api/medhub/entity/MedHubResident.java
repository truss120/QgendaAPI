package edu.bcm.api.medhub.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name_last",
        "name_first",
        "name_middle",
        "name_alias",
        "email",
        "username",
        "employeeID",
        "typeID",
        "type_name",
        "programID",
        "program_name",
        "level",
        "status",
        "birth_date",
        "gender",
        "citizenship",
        "ethnicity",
        "school_name",
        "school_degree",
        "school_start_date",
        "school_end_date",
        "school_graduated",
        "internal_address_state",
        "immunizations_comments",
        "pre_hire_active_start_date",
        "ecca_approval_date",
        "work_phone",
        "appt_type",
        "orientation_date",
        "pref_contact",
        "other_address_zipcode",
        "email_secondary",
        "irp_limit_date",
        "children",
        "verified_credentialed",
        "internal_address_country",
        "other_address_address_2",
        "other_address_address_1",
        "current_address_zipcode",
        "fax_number",
        "internal_address_address_1",
        "compliance_comments",
        "military_status_active_inactive",
        "bcm_official_start_date",
        "internal_address_address_2",
        "bcm_eca",
        "address_current_zipcode",
        "mailbox",
        "cost_center",
        "encode_number",
        "other",
        "data_coll_form",
        "access",
        "other_address_description",
        "date_of_birth",
        "demographics_comments",
        "permanent_address_country",
        "post_training",
        "other_address_state",
        "education_comments",
        "alumni",
        "spouse_name",
        "address_permanent_zipcode",
        "country_of_birth",
        "current_address_city",
        "emergency_address_relation",
        "last_name",
        "emergency_address_country",
        "internal_address_city",
        "emergency_address_phone_cell",
        "email_address",
        "ctry_of_citizenship",
        "current_address_address_2",
        "current_address_address_1",
        "verification_comments",
        "permanent_address_address_1",
        "permanent_address_address_2",
        "test_scores_comments",
        "ethnic_origin",
        "alternative_email",
        "other_address_city",
        "emergency_address_address_2",
        "emergency_address_address_1",
        "aamc_number",
        "pref_or_nickname",
        "contact_comments",
        "emergency_address_zipcode",
        "forms_files_comments",
        "training_history_comments",
        "pager",
        "visa_immigration_comments",
        "emergency_address_state",
        "military_status_y_n",
        "permanent_address_city",
        "home_phone",
        "program_comments",
        "empl_id",
        "gme_comments",
        "awards_discipline_comments",
        "permanent_address_zipcode",
        "compulsivity_index_comments",
        "emergency_address_contact_name",
        "address_other_description",
        "cell_phone",
        "current_address_country",
        "emergency_address_phone_work",
        "benefits",
        "permanent_address_state",
        "projected_start_date",
        "emergency_address_city",
        "military_status_regular_reserve",
        "address_other_zipcode",
        "emergency_address_phone_home",
        "parking_form",
        "internal_address_zipcode",
        "certifications_comments",
        "first_name",
        "institution_abbreviation",
        "emergency_address_email_address",
        "practitioner_id",
        "npi",
        "alumni_dues",
        "current_address_state",
        "marital_status",
        "finance_comments",
        "committee_approval_date",
        "funding_comments",
        "orientation_comments",
        "compensation",
        "other_address_country",
        "us_entry_date",
        "personal_email"
})
public class MedHubResident {

    @JsonProperty("custom_date2")
    private Date startDate;
    @JsonProperty("name_last")
    private String nameLast;
    @JsonProperty("name_first")
    private String nameFirst;
    @JsonProperty("name_middle")
    private String nameMiddle;
    @JsonProperty("name_alias")
    private String nameAlias;
    @JsonProperty("email")
    private String email;
    @JsonProperty("username")
    private String username;
    @JsonProperty("employeeID")
    private String employeeID;
    @JsonProperty("typeID")
    private String typeID;
    @JsonProperty("type_name")
    private String typeName;
    @JsonProperty("programID")
    private String programID;
    @JsonProperty("program_name")
    private String programName;
    @JsonProperty("level")
    private String level;
    @JsonProperty("status")
    private String status;
    @JsonProperty("birth_date")
    private String birthDate;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("citizenship")
    private String citizenship;
    @JsonProperty("ethnicity")
    private String ethnicity;
    @JsonProperty("school_name")
    private String schoolName;
    @JsonProperty("school_degree")
    private String schoolDegree;
    @JsonProperty("school_start_date")
    private String schoolStartDate;
    @JsonProperty("school_end_date")
    private String schoolEndDate;
    @JsonProperty("school_graduated")
    private Boolean schoolGraduated;
    @JsonProperty("internal_address_state")
    private Object internalAddressState;
    @JsonProperty("immunizations_comments")
    private Object immunizationsComments;
    @JsonProperty("pre_hire_active_start_date")
    private Object preHireActiveStartDate;
    @JsonProperty("ecca_approval_date")
    private Object eccaApprovalDate;
    @JsonProperty("work_phone")
    private Object workPhone;
    @JsonProperty("appt_type")
    private String apptType;
    @JsonProperty("orientation_date")
    private Object orientationDate;
    @JsonProperty("pref_contact")
    private String prefContact;
    @JsonProperty("other_address_zipcode")
    private Object otherAddressZipcode;
    @JsonProperty("email_secondary")
    private Object emailSecondary;
    @JsonProperty("irp_limit_date")
    private String irpLimitDate;
    @JsonProperty("children")
    private Object children;
    @JsonProperty("verified_credentialed")
    private String verifiedCredentialed;
    @JsonProperty("internal_address_country")
    private Object internalAddressCountry;
    @JsonProperty("other_address_address_2")
    private Object otherAddressAddress2;
    @JsonProperty("other_address_address_1")
    private Object otherAddressAddress1;
    @JsonProperty("current_address_zipcode")
    private Object currentAddressZipcode;
    @JsonProperty("fax_number")
    private Object faxNumber;
    @JsonProperty("internal_address_address_1")
    private Object internalAddressAddress1;
    @JsonProperty("compliance_comments")
    private Object complianceComments;
    @JsonProperty("military_status_active_inactive")
    private Object militaryStatusActiveInactive;
    @JsonProperty("bcm_official_start_date")
    private Object bcmOfficialStartDate;
    @JsonProperty("internal_address_address_2")
    private Object internalAddressAddress2;
    @JsonProperty("bcm_eca")
    private Object bcmEca;
    @JsonProperty("address_current_zipcode")
    private Object addressCurrentZipcode;
    @JsonProperty("mailbox")
    private Object mailbox;
    @JsonProperty("cost_center")
    private Object costCenter;
    @JsonProperty("encode_number")
    private Object encodeNumber;
    @JsonProperty("other")
    private Object other;
    @JsonProperty("data_coll_form")
    private Object dataCollForm;
    @JsonProperty("access")
    private String access;
    @JsonProperty("other_address_description")
    private Object otherAddressDescription;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    @JsonProperty("demographics_comments")
    private Object demographicsComments;
    @JsonProperty("permanent_address_country")
    private Object permanentAddressCountry;
    @JsonProperty("post_training")
    private String postTraining;
    @JsonProperty("other_address_state")
    private Object otherAddressState;
    @JsonProperty("education_comments")
    private String educationComments;
    @JsonProperty("alumni")
    private String alumni;
    @JsonProperty("spouse_name")
    private Object spouseName;
    @JsonProperty("address_permanent_zipcode")
    private Object addressPermanentZipcode;
    @JsonProperty("country_of_birth")
    private String countryOfBirth;
    @JsonProperty("current_address_city")
    private Object currentAddressCity;
    @JsonProperty("emergency_address_relation")
    private Object emergencyAddressRelation;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("emergency_address_country")
    private Object emergencyAddressCountry;
    @JsonProperty("internal_address_city")
    private Object internalAddressCity;
    @JsonProperty("emergency_address_phone_cell")
    private Object emergencyAddressPhoneCell;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("ctry_of_citizenship")
    private String ctryOfCitizenship;
    @JsonProperty("current_address_address_2")
    private Object currentAddressAddress2;
    @JsonProperty("current_address_address_1")
    private Object currentAddressAddress1;
    @JsonProperty("verification_comments")
    private Object verificationComments;
    @JsonProperty("permanent_address_address_1")
    private Object permanentAddressAddress1;
    @JsonProperty("permanent_address_address_2")
    private Object permanentAddressAddress2;
    @JsonProperty("test_scores_comments")
    private Object testScoresComments;
    @JsonProperty("ethnic_origin")
    private String ethnicOrigin;
    @JsonProperty("alternative_email")
    private Object alternativeEmail;
    @JsonProperty("other_address_city")
    private Object otherAddressCity;
    @JsonProperty("emergency_address_address_2")
    private Object emergencyAddressAddress2;
    @JsonProperty("emergency_address_address_1")
    private Object emergencyAddressAddress1;
    @JsonProperty("aamc_number")
    private Object aamcNumber;
    @JsonProperty("pref_or_nickname")
    private String prefOrNickname;
    @JsonProperty("contact_comments")
    private Object contactComments;
    @JsonProperty("emergency_address_zipcode")
    private Object emergencyAddressZipcode;
    @JsonProperty("forms_files_comments")
    private Object formsFilesComments;
    @JsonProperty("training_history_comments")
    private Object trainingHistoryComments;
    @JsonProperty("pager")
    private Object pager;
    @JsonProperty("visa_immigration_comments")
    private Object visaImmigrationComments;
    @JsonProperty("emergency_address_state")
    private Object emergencyAddressState;
    @JsonProperty("military_status_y_n")
    private Object militaryStatusYN;
    @JsonProperty("permanent_address_city")
    private Object permanentAddressCity;
    @JsonProperty("home_phone")
    private Object homePhone;
    @JsonProperty("program_comments")
    private Object programComments;
    @JsonProperty("empl_id")
    private String emplId;
    @JsonProperty("gme_comments")
    private Object gmeComments;
    @JsonProperty("awards_discipline_comments")
    private Object awardsDisciplineComments;
    @JsonProperty("permanent_address_zipcode")
    private Object permanentAddressZipcode;
    @JsonProperty("compulsivity_index_comments")
    private Object compulsivityIndexComments;
    @JsonProperty("emergency_address_contact_name")
    private Object emergencyAddressContactName;
    @JsonProperty("address_other_description")
    private Object addressOtherDescription;
    @JsonProperty("cell_phone")
    private Object cellPhone;
    @JsonProperty("current_address_country")
    private Object currentAddressCountry;
    @JsonProperty("emergency_address_phone_work")
    private Object emergencyAddressPhoneWork;
    @JsonProperty("benefits")
    private Object benefits;
    @JsonProperty("permanent_address_state")
    private Object permanentAddressState;
    @JsonProperty("projected_start_date")
    private Object projectedStartDate;
    @JsonProperty("emergency_address_city")
    private Object emergencyAddressCity;
    @JsonProperty("military_status_regular_reserve")
    private Object militaryStatusRegularReserve;
    @JsonProperty("address_other_zipcode")
    private Object addressOtherZipcode;
    @JsonProperty("emergency_address_phone_home")
    private Object emergencyAddressPhoneHome;
    @JsonProperty("parking_form")
    private Object parkingForm;
    @JsonProperty("internal_address_zipcode")
    private Object internalAddressZipcode;
    @JsonProperty("certifications_comments")
    private Object certificationsComments;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("institution_abbreviation")
    private String institutionAbbreviation;
    @JsonProperty("emergency_address_email_address")
    private Object emergencyAddressEmailAddress;
    @JsonProperty("practitioner_id")
    private Object practitionerId;
    @JsonProperty("npi")
    private String npi;
    @JsonProperty("alumni_dues")
    private Object alumniDues;
    @JsonProperty("current_address_state")
    private Object currentAddressState;
    @JsonProperty("marital_status")
    private Object maritalStatus;
    @JsonProperty("finance_comments")
    private Object financeComments;
    @JsonProperty("committee_approval_date")
    private Object committeeApprovalDate;
    @JsonProperty("funding_comments")
    private Object fundingComments;
    @JsonProperty("orientation_comments")
    private Object orientationComments;
    @JsonProperty("compensation")
    private Object compensation;
    @JsonProperty("other_address_country")
    private Object otherAddressCountry;
    @JsonProperty("us_entry_date")
    private Object usEntryDate;
    @JsonProperty("personal_email")
    private Object personalEmail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name_last")
    public String getNameLast() {
        return nameLast;
    }

    @JsonProperty("name_last")
    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    @JsonProperty("name_first")
    public String getNameFirst() {
        return nameFirst;
    }

    @JsonProperty("name_first")
    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    @JsonProperty("name_middle")
    public String getNameMiddle() {
        return nameMiddle;
    }

    @JsonProperty("name_middle")
    public void setNameMiddle(String nameMiddle) {
        this.nameMiddle = nameMiddle;
    }

    @JsonProperty("name_alias")
    public String getNameAlias() {
        return nameAlias;
    }

    @JsonProperty("name_alias")
    public void setNameAlias(String nameAlias) {
        this.nameAlias = nameAlias;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("employeeID")
    public String getEmployeeID() {
        return employeeID;
    }

    @JsonProperty("employeeID")
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @JsonProperty("typeID")
    public String getTypeID() {
        return typeID;
    }

    @JsonProperty("typeID")
    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    @JsonProperty("type_name")
    public String getTypeName() {
        return typeName;
    }

    @JsonProperty("type_name")
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @JsonProperty("programID")
    public String getProgramID() {
        return programID;
    }

    @JsonProperty("programID")
    public void setProgramID(String programID) {
        this.programID = programID;
    }

    @JsonProperty("program_name")
    public String getProgramName() {
        return programName;
    }

    @JsonProperty("program_name")
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("birth_date")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birth_date")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("citizenship")
    public String getCitizenship() {
        return citizenship;
    }

    @JsonProperty("citizenship")
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    @JsonProperty("ethnicity")
    public String getEthnicity() {
        return ethnicity;
    }

    @JsonProperty("ethnicity")
    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    @JsonProperty("school_name")
    public String getSchoolName() {
        return schoolName;
    }

    @JsonProperty("school_name")
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @JsonProperty("school_degree")
    public String getSchoolDegree() {
        return schoolDegree;
    }

    @JsonProperty("school_degree")
    public void setSchoolDegree(String schoolDegree) {
        this.schoolDegree = schoolDegree;
    }

    @JsonProperty("school_start_date")
    public String getSchoolStartDate() {
        return schoolStartDate;
    }

    @JsonProperty("school_start_date")
    public void setSchoolStartDate(String schoolStartDate) {
        this.schoolStartDate = schoolStartDate;
    }

    @JsonProperty("school_end_date")
    public String getSchoolEndDate() {
        return schoolEndDate;
    }

    @JsonProperty("school_end_date")
    public void setSchoolEndDate(String schoolEndDate) {
        this.schoolEndDate = schoolEndDate;
    }

    @JsonProperty("school_graduated")
    public Boolean getSchoolGraduated() {
        return schoolGraduated;
    }

    @JsonProperty("school_graduated")
    public void setSchoolGraduated(Boolean schoolGraduated) {
        this.schoolGraduated = schoolGraduated;
    }

    @JsonProperty("internal_address_state")
    public Object getInternalAddressState() {
        return internalAddressState;
    }

    @JsonProperty("internal_address_state")
    public void setInternalAddressState(Object internalAddressState) {
        this.internalAddressState = internalAddressState;
    }

    @JsonProperty("immunizations_comments")
    public Object getImmunizationsComments() {
        return immunizationsComments;
    }

    @JsonProperty("immunizations_comments")
    public void setImmunizationsComments(Object immunizationsComments) {
        this.immunizationsComments = immunizationsComments;
    }

    @JsonProperty("pre_hire_active_start_date")
    public Object getPreHireActiveStartDate() {
        return preHireActiveStartDate;
    }

    @JsonProperty("pre_hire_active_start_date")
    public void setPreHireActiveStartDate(Object preHireActiveStartDate) {
        this.preHireActiveStartDate = preHireActiveStartDate;
    }

    @JsonProperty("ecca_approval_date")
    public Object getEccaApprovalDate() {
        return eccaApprovalDate;
    }

    @JsonProperty("ecca_approval_date")
    public void setEccaApprovalDate(Object eccaApprovalDate) {
        this.eccaApprovalDate = eccaApprovalDate;
    }

    @JsonProperty("work_phone")
    public Object getWorkPhone() {
        return workPhone;
    }

    @JsonProperty("work_phone")
    public void setWorkPhone(Object workPhone) {
        this.workPhone = workPhone;
    }

    @JsonProperty("appt_type")
    public String getApptType() {
        return apptType;
    }

    @JsonProperty("appt_type")
    public void setApptType(String apptType) {
        this.apptType = apptType;
    }

    @JsonProperty("orientation_date")
    public Object getOrientationDate() {
        return orientationDate;
    }

    @JsonProperty("orientation_date")
    public void setOrientationDate(Object orientationDate) {
        this.orientationDate = orientationDate;
    }

    @JsonProperty("pref_contact")
    public String getPrefContact() {
        return prefContact;
    }

    @JsonProperty("pref_contact")
    public void setPrefContact(String prefContact) {
        this.prefContact = prefContact;
    }

    @JsonProperty("other_address_zipcode")
    public Object getOtherAddressZipcode() {
        return otherAddressZipcode;
    }

    @JsonProperty("other_address_zipcode")
    public void setOtherAddressZipcode(Object otherAddressZipcode) {
        this.otherAddressZipcode = otherAddressZipcode;
    }

    @JsonProperty("email_secondary")
    public Object getEmailSecondary() {
        return emailSecondary;
    }

    @JsonProperty("email_secondary")
    public void setEmailSecondary(Object emailSecondary) {
        this.emailSecondary = emailSecondary;
    }

    @JsonProperty("irp_limit_date")
    public String getIrpLimitDate() {
        return irpLimitDate;
    }

    @JsonProperty("irp_limit_date")
    public void setIrpLimitDate(String irpLimitDate) {
        this.irpLimitDate = irpLimitDate;
    }

    @JsonProperty("children")
    public Object getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(Object children) {
        this.children = children;
    }

    @JsonProperty("verified_credentialed")
    public String getVerifiedCredentialed() {
        return verifiedCredentialed;
    }

    @JsonProperty("verified_credentialed")
    public void setVerifiedCredentialed(String verifiedCredentialed) {
        this.verifiedCredentialed = verifiedCredentialed;
    }

    @JsonProperty("internal_address_country")
    public Object getInternalAddressCountry() {
        return internalAddressCountry;
    }

    @JsonProperty("internal_address_country")
    public void setInternalAddressCountry(Object internalAddressCountry) {
        this.internalAddressCountry = internalAddressCountry;
    }

    @JsonProperty("other_address_address_2")
    public Object getOtherAddressAddress2() {
        return otherAddressAddress2;
    }

    @JsonProperty("other_address_address_2")
    public void setOtherAddressAddress2(Object otherAddressAddress2) {
        this.otherAddressAddress2 = otherAddressAddress2;
    }

    @JsonProperty("other_address_address_1")
    public Object getOtherAddressAddress1() {
        return otherAddressAddress1;
    }

    @JsonProperty("other_address_address_1")
    public void setOtherAddressAddress1(Object otherAddressAddress1) {
        this.otherAddressAddress1 = otherAddressAddress1;
    }

    @JsonProperty("current_address_zipcode")
    public Object getCurrentAddressZipcode() {
        return currentAddressZipcode;
    }

    @JsonProperty("current_address_zipcode")
    public void setCurrentAddressZipcode(Object currentAddressZipcode) {
        this.currentAddressZipcode = currentAddressZipcode;
    }

    @JsonProperty("fax_number")
    public Object getFaxNumber() {
        return faxNumber;
    }

    @JsonProperty("fax_number")
    public void setFaxNumber(Object faxNumber) {
        this.faxNumber = faxNumber;
    }

    @JsonProperty("internal_address_address_1")
    public Object getInternalAddressAddress1() {
        return internalAddressAddress1;
    }

    @JsonProperty("internal_address_address_1")
    public void setInternalAddressAddress1(Object internalAddressAddress1) {
        this.internalAddressAddress1 = internalAddressAddress1;
    }

    @JsonProperty("compliance_comments")
    public Object getComplianceComments() {
        return complianceComments;
    }

    @JsonProperty("compliance_comments")
    public void setComplianceComments(Object complianceComments) {
        this.complianceComments = complianceComments;
    }

    @JsonProperty("military_status_active_inactive")
    public Object getMilitaryStatusActiveInactive() {
        return militaryStatusActiveInactive;
    }

    @JsonProperty("military_status_active_inactive")
    public void setMilitaryStatusActiveInactive(Object militaryStatusActiveInactive) {
        this.militaryStatusActiveInactive = militaryStatusActiveInactive;
    }

    @JsonProperty("bcm_official_start_date")
    public Object getBcmOfficialStartDate() {
        return bcmOfficialStartDate;
    }

    @JsonProperty("bcm_official_start_date")
    public void setBcmOfficialStartDate(Object bcmOfficialStartDate) {
        this.bcmOfficialStartDate = bcmOfficialStartDate;
    }

    @JsonProperty("internal_address_address_2")
    public Object getInternalAddressAddress2() {
        return internalAddressAddress2;
    }

    @JsonProperty("internal_address_address_2")
    public void setInternalAddressAddress2(Object internalAddressAddress2) {
        this.internalAddressAddress2 = internalAddressAddress2;
    }

    @JsonProperty("bcm_eca")
    public Object getBcmEca() {
        return bcmEca;
    }

    @JsonProperty("bcm_eca")
    public void setBcmEca(Object bcmEca) {
        this.bcmEca = bcmEca;
    }

    @JsonProperty("address_current_zipcode")
    public Object getAddressCurrentZipcode() {
        return addressCurrentZipcode;
    }

    @JsonProperty("address_current_zipcode")
    public void setAddressCurrentZipcode(Object addressCurrentZipcode) {
        this.addressCurrentZipcode = addressCurrentZipcode;
    }

    @JsonProperty("mailbox")
    public Object getMailbox() {
        return mailbox;
    }

    @JsonProperty("mailbox")
    public void setMailbox(Object mailbox) {
        this.mailbox = mailbox;
    }

    @JsonProperty("cost_center")
    public Object getCostCenter() {
        return costCenter;
    }

    @JsonProperty("cost_center")
    public void setCostCenter(Object costCenter) {
        this.costCenter = costCenter;
    }

    @JsonProperty("encode_number")
    public Object getEncodeNumber() {
        return encodeNumber;
    }

    @JsonProperty("encode_number")
    public void setEncodeNumber(Object encodeNumber) {
        this.encodeNumber = encodeNumber;
    }

    @JsonProperty("other")
    public Object getOther() {
        return other;
    }

    @JsonProperty("other")
    public void setOther(Object other) {
        this.other = other;
    }

    @JsonProperty("data_coll_form")
    public Object getDataCollForm() {
        return dataCollForm;
    }

    @JsonProperty("data_coll_form")
    public void setDataCollForm(Object dataCollForm) {
        this.dataCollForm = dataCollForm;
    }

    @JsonProperty("access")
    public String getAccess() {
        return access;
    }

    @JsonProperty("access")
    public void setAccess(String access) {
        this.access = access;
    }

    @JsonProperty("other_address_description")
    public Object getOtherAddressDescription() {
        return otherAddressDescription;
    }

    @JsonProperty("other_address_description")
    public void setOtherAddressDescription(Object otherAddressDescription) {
        this.otherAddressDescription = otherAddressDescription;
    }

    @JsonProperty("date_of_birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("date_of_birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("demographics_comments")
    public Object getDemographicsComments() {
        return demographicsComments;
    }

    @JsonProperty("demographics_comments")
    public void setDemographicsComments(Object demographicsComments) {
        this.demographicsComments = demographicsComments;
    }

    @JsonProperty("permanent_address_country")
    public Object getPermanentAddressCountry() {
        return permanentAddressCountry;
    }

    @JsonProperty("permanent_address_country")
    public void setPermanentAddressCountry(Object permanentAddressCountry) {
        this.permanentAddressCountry = permanentAddressCountry;
    }

    @JsonProperty("post_training")
    public String getPostTraining() {
        return postTraining;
    }

    @JsonProperty("post_training")
    public void setPostTraining(String postTraining) {
        this.postTraining = postTraining;
    }

    @JsonProperty("other_address_state")
    public Object getOtherAddressState() {
        return otherAddressState;
    }

    @JsonProperty("other_address_state")
    public void setOtherAddressState(Object otherAddressState) {
        this.otherAddressState = otherAddressState;
    }

    @JsonProperty("education_comments")
    public String getEducationComments() {
        return educationComments;
    }

    @JsonProperty("education_comments")
    public void setEducationComments(String educationComments) {
        this.educationComments = educationComments;
    }

    @JsonProperty("alumni")
    public String getAlumni() {
        return alumni;
    }

    @JsonProperty("alumni")
    public void setAlumni(String alumni) {
        this.alumni = alumni;
    }

    @JsonProperty("spouse_name")
    public Object getSpouseName() {
        return spouseName;
    }

    @JsonProperty("spouse_name")
    public void setSpouseName(Object spouseName) {
        this.spouseName = spouseName;
    }

    @JsonProperty("address_permanent_zipcode")
    public Object getAddressPermanentZipcode() {
        return addressPermanentZipcode;
    }

    @JsonProperty("address_permanent_zipcode")
    public void setAddressPermanentZipcode(Object addressPermanentZipcode) {
        this.addressPermanentZipcode = addressPermanentZipcode;
    }

    @JsonProperty("country_of_birth")
    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    @JsonProperty("country_of_birth")
    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    @JsonProperty("current_address_city")
    public Object getCurrentAddressCity() {
        return currentAddressCity;
    }

    @JsonProperty("current_address_city")
    public void setCurrentAddressCity(Object currentAddressCity) {
        this.currentAddressCity = currentAddressCity;
    }

    @JsonProperty("emergency_address_relation")
    public Object getEmergencyAddressRelation() {
        return emergencyAddressRelation;
    }

    @JsonProperty("emergency_address_relation")
    public void setEmergencyAddressRelation(Object emergencyAddressRelation) {
        this.emergencyAddressRelation = emergencyAddressRelation;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("emergency_address_country")
    public Object getEmergencyAddressCountry() {
        return emergencyAddressCountry;
    }

    @JsonProperty("emergency_address_country")
    public void setEmergencyAddressCountry(Object emergencyAddressCountry) {
        this.emergencyAddressCountry = emergencyAddressCountry;
    }

    @JsonProperty("internal_address_city")
    public Object getInternalAddressCity() {
        return internalAddressCity;
    }

    @JsonProperty("internal_address_city")
    public void setInternalAddressCity(Object internalAddressCity) {
        this.internalAddressCity = internalAddressCity;
    }

    @JsonProperty("emergency_address_phone_cell")
    public Object getEmergencyAddressPhoneCell() {
        return emergencyAddressPhoneCell;
    }

    @JsonProperty("emergency_address_phone_cell")
    public void setEmergencyAddressPhoneCell(Object emergencyAddressPhoneCell) {
        this.emergencyAddressPhoneCell = emergencyAddressPhoneCell;
    }

    @JsonProperty("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("email_address")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("ctry_of_citizenship")
    public String getCtryOfCitizenship() {
        return ctryOfCitizenship;
    }

    @JsonProperty("ctry_of_citizenship")
    public void setCtryOfCitizenship(String ctryOfCitizenship) {
        this.ctryOfCitizenship = ctryOfCitizenship;
    }

    @JsonProperty("current_address_address_2")
    public Object getCurrentAddressAddress2() {
        return currentAddressAddress2;
    }

    @JsonProperty("current_address_address_2")
    public void setCurrentAddressAddress2(Object currentAddressAddress2) {
        this.currentAddressAddress2 = currentAddressAddress2;
    }

    @JsonProperty("current_address_address_1")
    public Object getCurrentAddressAddress1() {
        return currentAddressAddress1;
    }

    @JsonProperty("current_address_address_1")
    public void setCurrentAddressAddress1(Object currentAddressAddress1) {
        this.currentAddressAddress1 = currentAddressAddress1;
    }

    @JsonProperty("verification_comments")
    public Object getVerificationComments() {
        return verificationComments;
    }

    @JsonProperty("verification_comments")
    public void setVerificationComments(Object verificationComments) {
        this.verificationComments = verificationComments;
    }

    @JsonProperty("permanent_address_address_1")
    public Object getPermanentAddressAddress1() {
        return permanentAddressAddress1;
    }

    @JsonProperty("permanent_address_address_1")
    public void setPermanentAddressAddress1(Object permanentAddressAddress1) {
        this.permanentAddressAddress1 = permanentAddressAddress1;
    }

    @JsonProperty("permanent_address_address_2")
    public Object getPermanentAddressAddress2() {
        return permanentAddressAddress2;
    }

    @JsonProperty("permanent_address_address_2")
    public void setPermanentAddressAddress2(Object permanentAddressAddress2) {
        this.permanentAddressAddress2 = permanentAddressAddress2;
    }

    @JsonProperty("test_scores_comments")
    public Object getTestScoresComments() {
        return testScoresComments;
    }

    @JsonProperty("test_scores_comments")
    public void setTestScoresComments(Object testScoresComments) {
        this.testScoresComments = testScoresComments;
    }

    @JsonProperty("ethnic_origin")
    public String getEthnicOrigin() {
        return ethnicOrigin;
    }

    @JsonProperty("ethnic_origin")
    public void setEthnicOrigin(String ethnicOrigin) {
        this.ethnicOrigin = ethnicOrigin;
    }

    @JsonProperty("alternative_email")
    public Object getAlternativeEmail() {
        return alternativeEmail;
    }

    @JsonProperty("alternative_email")
    public void setAlternativeEmail(Object alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    @JsonProperty("other_address_city")
    public Object getOtherAddressCity() {
        return otherAddressCity;
    }

    @JsonProperty("other_address_city")
    public void setOtherAddressCity(Object otherAddressCity) {
        this.otherAddressCity = otherAddressCity;
    }

    @JsonProperty("emergency_address_address_2")
    public Object getEmergencyAddressAddress2() {
        return emergencyAddressAddress2;
    }

    @JsonProperty("emergency_address_address_2")
    public void setEmergencyAddressAddress2(Object emergencyAddressAddress2) {
        this.emergencyAddressAddress2 = emergencyAddressAddress2;
    }

    @JsonProperty("emergency_address_address_1")
    public Object getEmergencyAddressAddress1() {
        return emergencyAddressAddress1;
    }

    @JsonProperty("emergency_address_address_1")
    public void setEmergencyAddressAddress1(Object emergencyAddressAddress1) {
        this.emergencyAddressAddress1 = emergencyAddressAddress1;
    }

    @JsonProperty("aamc_number")
    public Object getAamcNumber() {
        return aamcNumber;
    }

    @JsonProperty("aamc_number")
    public void setAamcNumber(Object aamcNumber) {
        this.aamcNumber = aamcNumber;
    }

    @JsonProperty("pref_or_nickname")
    public String getPrefOrNickname() {
        return prefOrNickname;
    }

    @JsonProperty("pref_or_nickname")
    public void setPrefOrNickname(String prefOrNickname) {
        this.prefOrNickname = prefOrNickname;
    }

    @JsonProperty("contact_comments")
    public Object getContactComments() {
        return contactComments;
    }

    @JsonProperty("contact_comments")
    public void setContactComments(Object contactComments) {
        this.contactComments = contactComments;
    }

    @JsonProperty("emergency_address_zipcode")
    public Object getEmergencyAddressZipcode() {
        return emergencyAddressZipcode;
    }

    @JsonProperty("emergency_address_zipcode")
    public void setEmergencyAddressZipcode(Object emergencyAddressZipcode) {
        this.emergencyAddressZipcode = emergencyAddressZipcode;
    }

    @JsonProperty("forms_files_comments")
    public Object getFormsFilesComments() {
        return formsFilesComments;
    }

    @JsonProperty("forms_files_comments")
    public void setFormsFilesComments(Object formsFilesComments) {
        this.formsFilesComments = formsFilesComments;
    }

    @JsonProperty("training_history_comments")
    public Object getTrainingHistoryComments() {
        return trainingHistoryComments;
    }

    @JsonProperty("training_history_comments")
    public void setTrainingHistoryComments(Object trainingHistoryComments) {
        this.trainingHistoryComments = trainingHistoryComments;
    }

    @JsonProperty("pager")
    public Object getPager() {
        return pager;
    }

    @JsonProperty("pager")
    public void setPager(Object pager) {
        this.pager = pager;
    }

    @JsonProperty("visa_immigration_comments")
    public Object getVisaImmigrationComments() {
        return visaImmigrationComments;
    }

    @JsonProperty("visa_immigration_comments")
    public void setVisaImmigrationComments(Object visaImmigrationComments) {
        this.visaImmigrationComments = visaImmigrationComments;
    }

    @JsonProperty("emergency_address_state")
    public Object getEmergencyAddressState() {
        return emergencyAddressState;
    }

    @JsonProperty("emergency_address_state")
    public void setEmergencyAddressState(Object emergencyAddressState) {
        this.emergencyAddressState = emergencyAddressState;
    }

    @JsonProperty("military_status_y_n")
    public Object getMilitaryStatusYN() {
        return militaryStatusYN;
    }

    @JsonProperty("military_status_y_n")
    public void setMilitaryStatusYN(Object militaryStatusYN) {
        this.militaryStatusYN = militaryStatusYN;
    }

    @JsonProperty("permanent_address_city")
    public Object getPermanentAddressCity() {
        return permanentAddressCity;
    }

    @JsonProperty("permanent_address_city")
    public void setPermanentAddressCity(Object permanentAddressCity) {
        this.permanentAddressCity = permanentAddressCity;
    }

    @JsonProperty("home_phone")
    public Object getHomePhone() {
        return homePhone;
    }

    @JsonProperty("home_phone")
    public void setHomePhone(Object homePhone) {
        this.homePhone = homePhone;
    }

    @JsonProperty("program_comments")
    public Object getProgramComments() {
        return programComments;
    }

    @JsonProperty("program_comments")
    public void setProgramComments(Object programComments) {
        this.programComments = programComments;
    }

    @JsonProperty("empl_id")
    public String getEmplId() {
        return emplId;
    }

    @JsonProperty("empl_id")
    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    @JsonProperty("gme_comments")
    public Object getGmeComments() {
        return gmeComments;
    }

    @JsonProperty("gme_comments")
    public void setGmeComments(Object gmeComments) {
        this.gmeComments = gmeComments;
    }

    @JsonProperty("awards_discipline_comments")
    public Object getAwardsDisciplineComments() {
        return awardsDisciplineComments;
    }

    @JsonProperty("awards_discipline_comments")
    public void setAwardsDisciplineComments(Object awardsDisciplineComments) {
        this.awardsDisciplineComments = awardsDisciplineComments;
    }

    @JsonProperty("permanent_address_zipcode")
    public Object getPermanentAddressZipcode() {
        return permanentAddressZipcode;
    }

    @JsonProperty("permanent_address_zipcode")
    public void setPermanentAddressZipcode(Object permanentAddressZipcode) {
        this.permanentAddressZipcode = permanentAddressZipcode;
    }

    @JsonProperty("compulsivity_index_comments")
    public Object getCompulsivityIndexComments() {
        return compulsivityIndexComments;
    }

    @JsonProperty("compulsivity_index_comments")
    public void setCompulsivityIndexComments(Object compulsivityIndexComments) {
        this.compulsivityIndexComments = compulsivityIndexComments;
    }

    @JsonProperty("emergency_address_contact_name")
    public Object getEmergencyAddressContactName() {
        return emergencyAddressContactName;
    }

    @JsonProperty("emergency_address_contact_name")
    public void setEmergencyAddressContactName(Object emergencyAddressContactName) {
        this.emergencyAddressContactName = emergencyAddressContactName;
    }

    @JsonProperty("address_other_description")
    public Object getAddressOtherDescription() {
        return addressOtherDescription;
    }

    @JsonProperty("address_other_description")
    public void setAddressOtherDescription(Object addressOtherDescription) {
        this.addressOtherDescription = addressOtherDescription;
    }

    @JsonProperty("cell_phone")
    public Object getCellPhone() {
        return cellPhone;
    }

    @JsonProperty("cell_phone")
    public void setCellPhone(Object cellPhone) {
        this.cellPhone = cellPhone;
    }

    @JsonProperty("current_address_country")
    public Object getCurrentAddressCountry() {
        return currentAddressCountry;
    }

    @JsonProperty("current_address_country")
    public void setCurrentAddressCountry(Object currentAddressCountry) {
        this.currentAddressCountry = currentAddressCountry;
    }

    @JsonProperty("emergency_address_phone_work")
    public Object getEmergencyAddressPhoneWork() {
        return emergencyAddressPhoneWork;
    }

    @JsonProperty("emergency_address_phone_work")
    public void setEmergencyAddressPhoneWork(Object emergencyAddressPhoneWork) {
        this.emergencyAddressPhoneWork = emergencyAddressPhoneWork;
    }

    @JsonProperty("benefits")
    public Object getBenefits() {
        return benefits;
    }

    @JsonProperty("benefits")
    public void setBenefits(Object benefits) {
        this.benefits = benefits;
    }

    @JsonProperty("permanent_address_state")
    public Object getPermanentAddressState() {
        return permanentAddressState;
    }

    @JsonProperty("permanent_address_state")
    public void setPermanentAddressState(Object permanentAddressState) {
        this.permanentAddressState = permanentAddressState;
    }

    @JsonProperty("projected_start_date")
    public Object getProjectedStartDate() {
        return projectedStartDate;
    }

    @JsonProperty("projected_start_date")
    public void setProjectedStartDate(Object projectedStartDate) {
        this.projectedStartDate = projectedStartDate;
    }

    @JsonProperty("emergency_address_city")
    public Object getEmergencyAddressCity() {
        return emergencyAddressCity;
    }

    @JsonProperty("emergency_address_city")
    public void setEmergencyAddressCity(Object emergencyAddressCity) {
        this.emergencyAddressCity = emergencyAddressCity;
    }

    @JsonProperty("military_status_regular_reserve")
    public Object getMilitaryStatusRegularReserve() {
        return militaryStatusRegularReserve;
    }

    @JsonProperty("military_status_regular_reserve")
    public void setMilitaryStatusRegularReserve(Object militaryStatusRegularReserve) {
        this.militaryStatusRegularReserve = militaryStatusRegularReserve;
    }

    @JsonProperty("address_other_zipcode")
    public Object getAddressOtherZipcode() {
        return addressOtherZipcode;
    }

    @JsonProperty("address_other_zipcode")
    public void setAddressOtherZipcode(Object addressOtherZipcode) {
        this.addressOtherZipcode = addressOtherZipcode;
    }

    @JsonProperty("emergency_address_phone_home")
    public Object getEmergencyAddressPhoneHome() {
        return emergencyAddressPhoneHome;
    }

    @JsonProperty("emergency_address_phone_home")
    public void setEmergencyAddressPhoneHome(Object emergencyAddressPhoneHome) {
        this.emergencyAddressPhoneHome = emergencyAddressPhoneHome;
    }

    @JsonProperty("parking_form")
    public Object getParkingForm() {
        return parkingForm;
    }

    @JsonProperty("parking_form")
    public void setParkingForm(Object parkingForm) {
        this.parkingForm = parkingForm;
    }

    @JsonProperty("internal_address_zipcode")
    public Object getInternalAddressZipcode() {
        return internalAddressZipcode;
    }

    @JsonProperty("internal_address_zipcode")
    public void setInternalAddressZipcode(Object internalAddressZipcode) {
        this.internalAddressZipcode = internalAddressZipcode;
    }

    @JsonProperty("certifications_comments")
    public Object getCertificationsComments() {
        return certificationsComments;
    }

    @JsonProperty("certifications_comments")
    public void setCertificationsComments(Object certificationsComments) {
        this.certificationsComments = certificationsComments;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("institution_abbreviation")
    public String getInstitutionAbbreviation() {
        return institutionAbbreviation;
    }

    @JsonProperty("institution_abbreviation")
    public void setInstitutionAbbreviation(String institutionAbbreviation) {
        this.institutionAbbreviation = institutionAbbreviation;
    }

    @JsonProperty("emergency_address_email_address")
    public Object getEmergencyAddressEmailAddress() {
        return emergencyAddressEmailAddress;
    }

    @JsonProperty("emergency_address_email_address")
    public void setEmergencyAddressEmailAddress(Object emergencyAddressEmailAddress) {
        this.emergencyAddressEmailAddress = emergencyAddressEmailAddress;
    }

    @JsonProperty("practitioner_id")
    public Object getPractitionerId() {
        return practitionerId;
    }

    @JsonProperty("practitioner_id")
    public void setPractitionerId(Object practitionerId) {
        this.practitionerId = practitionerId;
    }

    @JsonProperty("npi")
    public String getNpi() {
        return npi;
    }

    @JsonProperty("npi")
    public void setNpi(String npi) {
        this.npi = npi;
    }

    @JsonProperty("alumni_dues")
    public Object getAlumniDues() {
        return alumniDues;
    }

    @JsonProperty("alumni_dues")
    public void setAlumniDues(Object alumniDues) {
        this.alumniDues = alumniDues;
    }

    @JsonProperty("current_address_state")
    public Object getCurrentAddressState() {
        return currentAddressState;
    }

    @JsonProperty("current_address_state")
    public void setCurrentAddressState(Object currentAddressState) {
        this.currentAddressState = currentAddressState;
    }

    @JsonProperty("marital_status")
    public Object getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("marital_status")
    public void setMaritalStatus(Object maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @JsonProperty("finance_comments")
    public Object getFinanceComments() {
        return financeComments;
    }

    @JsonProperty("finance_comments")
    public void setFinanceComments(Object financeComments) {
        this.financeComments = financeComments;
    }

    @JsonProperty("committee_approval_date")
    public Object getCommitteeApprovalDate() {
        return committeeApprovalDate;
    }

    @JsonProperty("committee_approval_date")
    public void setCommitteeApprovalDate(Object committeeApprovalDate) {
        this.committeeApprovalDate = committeeApprovalDate;
    }

    @JsonProperty("funding_comments")
    public Object getFundingComments() {
        return fundingComments;
    }

    @JsonProperty("funding_comments")
    public void setFundingComments(Object fundingComments) {
        this.fundingComments = fundingComments;
    }

    @JsonProperty("orientation_comments")
    public Object getOrientationComments() {
        return orientationComments;
    }

    @JsonProperty("orientation_comments")
    public void setOrientationComments(Object orientationComments) {
        this.orientationComments = orientationComments;
    }

    @JsonProperty("compensation")
    public Object getCompensation() {
        return compensation;
    }

    @JsonProperty("compensation")
    public void setCompensation(Object compensation) {
        this.compensation = compensation;
    }

    @JsonProperty("other_address_country")
    public Object getOtherAddressCountry() {
        return otherAddressCountry;
    }

    @JsonProperty("other_address_country")
    public void setOtherAddressCountry(Object otherAddressCountry) {
        this.otherAddressCountry = otherAddressCountry;
    }

    @JsonProperty("us_entry_date")
    public Object getUsEntryDate() {
        return usEntryDate;
    }

    @JsonProperty("us_entry_date")
    public void setUsEntryDate(Object usEntryDate) {
        this.usEntryDate = usEntryDate;
    }

    @JsonProperty("personal_email")
    public Object getPersonalEmail() {
        return personalEmail;
    }

    @JsonProperty("personal_email")
    public void setPersonalEmail(Object personalEmail) {
        this.personalEmail = personalEmail;
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
        String mainProps = "{" +
                "nameLast='" + nameLast + '\'' +
                ", nameFirst='" + nameFirst + '\'' +
                ", nameMiddle='" + nameMiddle + '\'' +
                ", nameAlias='" + nameAlias + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", typeID='" + typeID + '\'' +
                ", typeName='" + typeName + '\'' +
                ", programID='" + programID + '\'' +
                ", programName='" + programName + '\'' +
                ", level='" + level + '\'' +
                ", status='" + status + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolDegree='" + schoolDegree + '\'' +
                ", schoolStartDate='" + schoolStartDate + '\'' +
                ", schoolEndDate='" + schoolEndDate + '\'' +
                ", schoolGraduated=" + schoolGraduated +
                ", internalAddressState=" + internalAddressState +
                ", immunizationsComments=" + immunizationsComments +
                ", preHireActiveStartDate=" + preHireActiveStartDate +
                ", eccaApprovalDate=" + eccaApprovalDate +
                ", workPhone=" + workPhone +
                ", apptType='" + apptType + '\'' +
                ", orientationDate=" + orientationDate +
                ", prefContact='" + prefContact + '\'' +
                ", otherAddressZipcode=" + otherAddressZipcode +
                ", emailSecondary=" + emailSecondary +
                ", irpLimitDate='" + irpLimitDate + '\'' +
                ", children=" + children +
                ", verifiedCredentialed='" + verifiedCredentialed + '\'' +
                ", internalAddressCountry=" + internalAddressCountry +
                ", otherAddressAddress2=" + otherAddressAddress2 +
                ", otherAddressAddress1=" + otherAddressAddress1 +
                ", currentAddressZipcode=" + currentAddressZipcode +
                ", faxNumber=" + faxNumber +
                ", internalAddressAddress1=" + internalAddressAddress1 +
                ", complianceComments=" + complianceComments +
                ", militaryStatusActiveInactive=" + militaryStatusActiveInactive +
                ", bcmOfficialStartDate=" + bcmOfficialStartDate +
                ", internalAddressAddress2=" + internalAddressAddress2 +
                ", bcmEca=" + bcmEca +
                ", addressCurrentZipcode=" + addressCurrentZipcode +
                ", mailbox=" + mailbox +
                ", costCenter=" + costCenter +
                ", encodeNumber=" + encodeNumber +
                ", other=" + other +
                ", dataCollForm=" + dataCollForm +
                ", access='" + access + '\'' +
                ", otherAddressDescription=" + otherAddressDescription +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", demographicsComments=" + demographicsComments +
                ", permanentAddressCountry=" + permanentAddressCountry +
                ", postTraining='" + postTraining + '\'' +
                ", otherAddressState=" + otherAddressState +
                ", educationComments='" + educationComments + '\'' +
                ", alumni='" + alumni + '\'' +
                ", spouseName=" + spouseName +
                ", addressPermanentZipcode=" + addressPermanentZipcode +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", currentAddressCity=" + currentAddressCity +
                ", emergencyAddressRelation=" + emergencyAddressRelation +
                ", lastName='" + lastName + '\'' +
                ", emergencyAddressCountry=" + emergencyAddressCountry +
                ", internalAddressCity=" + internalAddressCity +
                ", emergencyAddressPhoneCell=" + emergencyAddressPhoneCell +
                ", emailAddress='" + emailAddress + '\'' +
                ", ctryOfCitizenship='" + ctryOfCitizenship + '\'' +
                ", currentAddressAddress2=" + currentAddressAddress2 +
                ", currentAddressAddress1=" + currentAddressAddress1 +
                ", verificationComments=" + verificationComments +
                ", permanentAddressAddress1=" + permanentAddressAddress1 +
                ", permanentAddressAddress2=" + permanentAddressAddress2 +
                ", testScoresComments=" + testScoresComments +
                ", ethnicOrigin='" + ethnicOrigin + '\'' +
                ", alternativeEmail=" + alternativeEmail +
                ", otherAddressCity=" + otherAddressCity +
                ", emergencyAddressAddress2=" + emergencyAddressAddress2 +
                ", emergencyAddressAddress1=" + emergencyAddressAddress1 +
                ", aamcNumber=" + aamcNumber +
                ", prefOrNickname='" + prefOrNickname + '\'' +
                ", contactComments=" + contactComments +
                ", emergencyAddressZipcode=" + emergencyAddressZipcode +
                ", formsFilesComments=" + formsFilesComments +
                ", trainingHistoryComments=" + trainingHistoryComments +
                ", pager=" + pager +
                ", visaImmigrationComments=" + visaImmigrationComments +
                ", emergencyAddressState=" + emergencyAddressState +
                ", militaryStatusYN=" + militaryStatusYN +
                ", permanentAddressCity=" + permanentAddressCity +
                ", homePhone=" + homePhone +
                ", programComments=" + programComments +
                ", emplId='" + emplId + '\'' +
                ", gmeComments=" + gmeComments +
                ", awardsDisciplineComments=" + awardsDisciplineComments +
                ", permanentAddressZipcode=" + permanentAddressZipcode +
                ", compulsivityIndexComments=" + compulsivityIndexComments +
                ", emergencyAddressContactName=" + emergencyAddressContactName +
                ", addressOtherDescription=" + addressOtherDescription +
                ", cellPhone=" + cellPhone +
                ", currentAddressCountry=" + currentAddressCountry +
                ", emergencyAddressPhoneWork=" + emergencyAddressPhoneWork +
                ", benefits=" + benefits +
                ", permanentAddressState=" + permanentAddressState +
                ", projectedStartDate=" + projectedStartDate +
                ", emergencyAddressCity=" + emergencyAddressCity +
                ", militaryStatusRegularReserve=" + militaryStatusRegularReserve +
                ", addressOtherZipcode=" + addressOtherZipcode +
                ", emergencyAddressPhoneHome=" + emergencyAddressPhoneHome +
                ", parkingForm=" + parkingForm +
                ", internalAddressZipcode=" + internalAddressZipcode +
                ", certificationsComments=" + certificationsComments +
                ", firstName='" + firstName + '\'' +
                ", institutionAbbreviation='" + institutionAbbreviation + '\'' +
                ", emergencyAddressEmailAddress=" + emergencyAddressEmailAddress +
                ", practitionerId=" + practitionerId +
                ", npi='" + npi + '\'' +
                ", alumniDues=" + alumniDues +
                ", currentAddressState=" + currentAddressState +
                ", maritalStatus=" + maritalStatus +
                ", financeComments=" + financeComments +
                ", committeeApprovalDate=" + committeeApprovalDate +
                ", fundingComments=" + fundingComments +
                ", orientationComments=" + orientationComments +
                ", compensation=" + compensation +
                ", otherAddressCountry=" + otherAddressCountry +
                ", usEntryDate=" + usEntryDate +
                ", personalEmail=" + personalEmail +
                ", additionalProperties={";

        StringBuilder sb = new StringBuilder();
        sb.append(mainProps);

        Set keys = this.additionalProperties.keySet();
        for (Object key : keys) {
            sb.append(key).append(" = '").append(this.additionalProperties.get(key)).append("', ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}").append(" }");

        return sb.toString();
    }

}