package edu.bcm.api.snow.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "u_building_name",
        "u_home_city",
        "u_processed",
        "u_rm_company_name",
        "sys_updated_on",
        "u_computer_server_names",
        "u_last_name",
        "u_data_element_view_edit",
        "u_desktop_or_server_access",
        "sys_updated_by",
        "u_gender",
        "u_phone",
        "sys_created_on",
        "u_rm_company_personal_id",
        "u_role",
        "u_account_type",
        "u_rm_days_to_expire",
        "sys_created_by",
        "u_interactive_logon",
        "u_company_name",
        "u_marital_status",
        "u_termination_date",
        "u_home_address",
        "u_provider_type",
        "u_mailstop",
        "u_building_code",
        "u_home_phone",
        "u_state",
        "u_room_number",
        "u_license",
        "u_first_name",
        "u_email_account",
        "u_user_name",
        "u_extension_attrib_7",
        "u_employee_number",
        "u_requester_eca",
        "u_visa_type",
        "u_department",
        "u_facility_name",
        "u_offsite_clinic_leasing_staff",
        "u_email",
        "u_address",
        "u_home_zip",
        "u_proposed_account_name",
        "u_middle_name",
        "u_employee_type",
        "sys_id",
        "u_elock",
        "u_home_state",
        "u_department_number",
        "u_date_of_birth",
        "u_system_names",
        "u_status",
        "u_mobile_phone",
        "u_request_type",
        "u_wireless_logon_access",
        "u_primary_eca",
        "u_city",
        "u_contact_phone",
        "u_title",
        "sys_mod_count",
        "sys_tags",
        "u_zip_code",
        "u_requested_item",
        "u_contact_email",
        "u_owner_eca",
        "u_contact_title",
        "u_facility_personal_id",
        "u_temporary_disable",
        "u_vpn_logon_access",
        "u_home_country"
})
public class SGARequest extends SNowObject {

/*  @JsonProperty("sys_mod_count")
    private String sysModCount;
    @JsonProperty("sys_tags")
    private String sysTags;
    @JsonProperty("sys_updated_on")
    private String sysUpdatedOn;
    @JsonProperty("sys_updated_by")
    private String sysUpdatedBy;
    @JsonProperty("sys_created_on")
    private String sysCreatedOn;
    @JsonProperty("sys_created_by")
    private String sysCreatedBy;
    @JsonProperty("sys_id")
    private String sysId;

*/

    @JsonProperty("u_building_name")
    private String buildingName;
    @JsonProperty("u_home_city")
    private String homeCity;
    @JsonProperty("u_processed")
    private String processed;
    @JsonProperty("u_rm_company_name")
    private String rmCompanyName;
    @JsonProperty("u_computer_server_names")
    private String computerServerNames;
    @JsonProperty("u_last_name")
    private String lastName;
    @JsonProperty("u_data_element_view_edit")
    private String dataElementViewEdit;
    @JsonProperty("u_desktop_or_server_access")
    private String desktopOrServerAccess;
    @JsonProperty("u_gender")
    private String gender;
    @JsonProperty("u_phone")
    private String phone;
    @JsonProperty("u_rm_company_personal_id")
    private String rmCompanyPersonalId;
    @JsonProperty("u_role")
    private String role;
    @JsonProperty("u_account_type")
    private String accountType;
    @JsonProperty("u_rm_days_to_expire")
    private String rmDaysToExpire;
    @JsonProperty("u_interactive_logon")
    private String interactiveLogon;
    @JsonProperty("u_company_name")
    private String companyName;
    @JsonProperty("u_marital_status")
    private String maritalStatus;
    @JsonProperty("u_termination_date")
    private String terminationDate;
    @JsonProperty("u_home_address")
    private String homeAddress;
    @JsonProperty("u_provider_type")
    private String providerType;
    @JsonProperty("u_mailstop")
    private String mailstop;
    @JsonProperty("u_building_code")
    private String buildingCode;
    @JsonProperty("u_home_phone")
    private String homePhone;
    @JsonProperty("u_state")
    private String state;
    @JsonProperty("u_room_number")
    private String roomNumber;
    @JsonProperty("u_license")
    private String license;
    @JsonProperty("u_first_name")
    private String firstName;
    @JsonProperty("u_email_account")
    private String emailAccount;
    @JsonProperty("u_user_name")
    private String userName;
    @JsonProperty("u_extension_attrib_7")
    private String extensionAttrib7;
    @JsonProperty("u_employee_number")
    private String employeeNumber;
    @JsonProperty("u_requester_eca")
    private String requesterEca;
    @JsonProperty("u_visa_type")
    private String visaType;
    @JsonProperty("u_department")
    private String department;
    @JsonProperty("u_facility_name")
    private String facilityName;
    @JsonProperty("u_offsite_clinic_leasing_staff")
    private String offsiteClinicLeasingStaff;
    @JsonProperty("u_email")
    private String email;
    @JsonProperty("u_address")
    private String address;
    @JsonProperty("u_home_zip")
    private String homeZip;
    @JsonProperty("u_proposed_account_name")
    private String proposedAccountName;
    @JsonProperty("u_middle_name")
    private String middleName;
    @JsonProperty("u_employee_type")
    private String employeeType;
    @JsonProperty("u_elock")
    private String eLock;
    @JsonProperty("u_home_state")
    private String homeState;
    @JsonProperty("u_department_number")
    private String departmentNumber;
    @JsonProperty("u_date_of_birth")
    private String dateOfBirth;
    @JsonProperty("u_system_names")
    private String systemNames;
    @JsonProperty("u_status")
    private String status;
    @JsonProperty("u_mobile_phone")
    private String mobilePhone;
    @JsonProperty("u_request_type")
    private String requestType;
    @JsonProperty("u_wireless_logon_access")
    private String wirelessLogonAccess;
    @JsonProperty("u_primary_eca")
    private String primaryEca;
    @JsonProperty("u_city")
    private String city;
    @JsonProperty("u_contact_phone")
    private String contactPhone;
    @JsonProperty("u_title")
    private String title;
    @JsonProperty("u_zip_code")
    private String zipCode;
    @JsonProperty("u_requested_item")
    private String requestedItem;
    @JsonProperty("u_contact_email")
    private String contactEmail;
    @JsonProperty("u_owner_eca")
    private String ownerEca;
    @JsonProperty("u_contact_title")
    private String contactTitle;
    @JsonProperty("u_facility_personal_id")
    private String facilityPersonalId;
    @JsonProperty("u_temporary_disable")
    private String temporaryDisable;
    @JsonProperty("u_vpn_logon_access")
    private String vpnLogonAccess;
    @JsonProperty("u_home_country")
    private String homeCountry;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public String getRmCompanyName() {
        return rmCompanyName;
    }

    public void setRmCompanyName(String rmCompanyName) {
        this.rmCompanyName = rmCompanyName;
    }

    public String getComputerServerNames() {
        return computerServerNames;
    }

    public void setComputerServerNames(String computerServerNames) {
        this.computerServerNames = computerServerNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDataElementViewEdit() {
        return dataElementViewEdit;
    }

    public void setDataElementViewEdit(String dataElementViewEdit) {
        this.dataElementViewEdit = dataElementViewEdit;
    }

    public String getDesktopOrServerAccess() {
        return desktopOrServerAccess;
    }

    public void setDesktopOrServerAccess(String desktopOrServerAccess) {
        this.desktopOrServerAccess = desktopOrServerAccess;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRmCompanyPersonalId() {
        return rmCompanyPersonalId;
    }

    public void setRmCompanyPersonalId(String rmCompanyPersonalId) {
        this.rmCompanyPersonalId = rmCompanyPersonalId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getRmDaysToExpire() {
        return rmDaysToExpire;
    }

    public void setRmDaysToExpire(String rmDaysToExpire) {
        this.rmDaysToExpire = rmDaysToExpire;
    }

    public String getInteractiveLogon() {
        return interactiveLogon;
    }

    public void setInteractiveLogon(String interactiveLogon) {
        this.interactiveLogon = interactiveLogon;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getMailstop() {
        return mailstop;
    }

    public void setMailstop(String mailstop) {
        this.mailstop = mailstop;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExtensionAttrib7() {
        return extensionAttrib7;
    }

    public void setExtensionAttrib7(String extensionAttrib7) {
        this.extensionAttrib7 = extensionAttrib7;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getRequesterEca() {
        return requesterEca;
    }

    public void setRequesterEca(String requesterEca) {
        this.requesterEca = requesterEca;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getOffsiteClinicLeasingStaff() {
        return offsiteClinicLeasingStaff;
    }

    public void setOffsiteClinicLeasingStaff(String offsiteClinicLeasingStaff) {
        this.offsiteClinicLeasingStaff = offsiteClinicLeasingStaff;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    public String getProposedAccountName() {
        return proposedAccountName;
    }

    public void setProposedAccountName(String proposedAccountName) {
        this.proposedAccountName = proposedAccountName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String geteLock() {
        return eLock;
    }

    public void seteLock(String eLock) {
        this.eLock = eLock;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSystemNames() {
        return systemNames;
    }

    public void setSystemNames(String systemNames) {
        this.systemNames = systemNames;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getWirelessLogonAccess() {
        return wirelessLogonAccess;
    }

    public void setWirelessLogonAccess(String wirelessLogonAccess) {
        this.wirelessLogonAccess = wirelessLogonAccess;
    }

    public String getPrimaryEca() {
        return primaryEca;
    }

    public void setPrimaryEca(String primaryEca) {
        this.primaryEca = primaryEca;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRequestedItem() {
        return requestedItem;
    }

    public void setRequestedItem(String requestedItem) {
        this.requestedItem = requestedItem;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getOwnerEca() {
        return ownerEca;
    }

    public void setOwnerEca(String ownerEca) {
        this.ownerEca = ownerEca;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getFacilityPersonalId() {
        return facilityPersonalId;
    }

    public void setFacilityPersonalId(String facilityPersonalId) {
        this.facilityPersonalId = facilityPersonalId;
    }

    public String getTemporaryDisable() {
        return temporaryDisable;
    }

    public void setTemporaryDisable(String temporaryDisable) {
        this.temporaryDisable = temporaryDisable;
    }

    public String getVpnLogonAccess() {
        return vpnLogonAccess;
    }

    public void setVpnLogonAccess(String vpnLogonAccess) {
        this.vpnLogonAccess = vpnLogonAccess;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


/*    @JsonProperty("sys_updated_on")
    public String getSysUpdatedOn() {
        return sysUpdatedOn;
    }

    @JsonProperty("sys_updated_on")
    public void setSysUpdatedOn(String sysUpdatedOn) {
        this.sysUpdatedOn = sysUpdatedOn;
    }

    @JsonProperty("sys_updated_by")
    public String getSysUpdatedBy() {
        return sysUpdatedBy;
    }

    @JsonProperty("sys_updated_by")
    public void setSysUpdatedBy(String sysUpdatedBy) {
        this.sysUpdatedBy = sysUpdatedBy;
    }


    @JsonProperty("sys_created_on")
    public String getSysCreatedOn() {
        return sysCreatedOn;
    }

    @JsonProperty("sys_created_on")
    public void setSysCreatedOn(String sysCreatedOn) {
        this.sysCreatedOn = sysCreatedOn;
    }

    @JsonProperty("sys_created_by")
    public String getSysCreatedBy() {
        return sysCreatedBy;
    }

    @JsonProperty("sys_created_by")
    public void setSysCreatedBy(String sysCreatedBy) {
        this.sysCreatedBy = sysCreatedBy;
    }

    @JsonProperty("sys_id")
    public String getSysId() {
        return sysId;
    }

    @JsonProperty("sys_id")
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    @JsonProperty("sys_mod_count")
    public String getSysModCount() {
        return sysModCount;
    }

    @JsonProperty("sys_mod_count")
    public void setSysModCount(String sysModCount) {
        this.sysModCount = sysModCount;
    }

    @JsonProperty("sys_tags")
    public String getSysTags() {
        return sysTags;
    }

    @JsonProperty("sys_tags")
    public void setSysTags(String sysTags) {
        this.sysTags = sysTags;
    }*/

    @Override
    public String toString() {
        return "{" +
                "buildingName='" + buildingName + '\'' +
                ", homeCity='" + homeCity + '\'' +
                ", processed='" + processed + '\'' +
                ", rmCompanyName='" + rmCompanyName + '\'' +
                ", computerServerNames='" + computerServerNames + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dataElementViewEdit='" + dataElementViewEdit + '\'' +
                ", desktopOrServerAccess='" + desktopOrServerAccess + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", rmCompanyPersonalId='" + rmCompanyPersonalId + '\'' +
                ", role='" + role + '\'' +
                ", accountType='" + accountType + '\'' +
                ", rmDaysToExpire='" + rmDaysToExpire + '\'' +
                ", interactiveLogon='" + interactiveLogon + '\'' +
                ", companyName='" + companyName + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", terminationDate='" + terminationDate + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", providerType='" + providerType + '\'' +
                ", mailstop='" + mailstop + '\'' +
                ", buildingCode='" + buildingCode + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", state='" + state + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", license='" + license + '\'' +
                ", firstName='" + firstName + '\'' +
                ", emailAccount='" + emailAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", extensionAttrib7='" + extensionAttrib7 + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", requesterEca='" + requesterEca + '\'' +
                ", visaType='" + visaType + '\'' +
                ", department='" + department + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", offsiteClinicLeasingStaff='" + offsiteClinicLeasingStaff + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", homeZip='" + homeZip + '\'' +
                ", proposedAccountName='" + proposedAccountName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", eLock='" + eLock + '\'' +
                ", homeState='" + homeState + '\'' +
                ", departmentNumber='" + departmentNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", systemNames='" + systemNames + '\'' +
                ", status='" + status + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", requestType='" + requestType + '\'' +
                ", wirelessLogonAccess='" + wirelessLogonAccess + '\'' +
                ", primaryEca='" + primaryEca + '\'' +
                ", city='" + city + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", title='" + title + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", requestedItem='" + requestedItem + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", ownerEca='" + ownerEca + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", facilityPersonalId='" + facilityPersonalId + '\'' +
                ", temporaryDisable='" + temporaryDisable + '\'' +
                ", vpnLogonAccess='" + vpnLogonAccess + '\'' +
                ", homeCountry='" + homeCountry + '\'' +
                ", sysCreatedBy='" + super.getSysCreatedBy() + '\'' +
                ", sysCreatedOn='" + super.getSysCreatedOn() + '\'' +
                ", sysId='" + super.getSysId() + '\'' +
                ", sysModCount='" + super.getSysModCount() + '\'' +
                ", sysTags='" + super.getSysTags() + '\'' +
                ", sysUpdatedBy='" + super.getSysUpdatedBy() + '\'' +
                ", sysUpdatedOn='" + super.getSysUpdatedOn() + '\'' +

                '}';
    }

    public String toJsonString() {
        return "{" +
                "\"buildingName\":\"" + buildingName + "\"" +
                ", \"homeCity\":\"" + homeCity + "\"" +
                ", \"processed\":\"" + processed + "\"" +
                ", \"rmCompanyName\":\"" + rmCompanyName + "\"" +
                ", \"computerServerNames\":\"" + computerServerNames + "\"" +
                ", \"lastName\":\"" + lastName + "\"" +
                ", \"dataElementViewEdit\":\"" + dataElementViewEdit + "\"" +
                ", \"desktopOrServerAccess\":\"" + desktopOrServerAccess + "\"" +
                ", \"gender\":\"" + gender + "\"" +
                ", \"phone\":\"" + phone + "\"" +
                ", \"rmCompanyPersonalId\":\"" + rmCompanyPersonalId + "\"" +
                ", \"role\":\"" + role + "\"" +
                ", \"accountType\":\"" + accountType + "\"" +
                ", \"rmDaysToExpire\":\"" + rmDaysToExpire + "\"" +
                ", \"interactiveLogon\":\"" + interactiveLogon + "\"" +
                ", \"companyName\":\"" + (companyName == null ? companyName : companyName.replace("\"", "")) + "\"" +
                ", \"maritalStatus\":\"" + maritalStatus + "\"" +
                ", \"terminationDate\":\"" + terminationDate + "\"" +
                ", \"homeAddress\":\"" + homeAddress + "\"" +
                ", \"providerType\":\"" + providerType + "\"" +
                ", \"mailstop\":\"" + mailstop + "\"" +
                ", \"buildingCode\":\"" + buildingCode + "\"" +
                ", \"homePhone\":\"" + homePhone + "\"" +
                ", \"state\":\"" + state + "\"" +
                ", \"roomNumber\":\"" + roomNumber + "\"" +
                ", \"license\":\"" + license + "\"" +
                ", \"firstName\":\"" + (firstName == null ? firstName : firstName.replace("\"", "")) + "\"" +
                ", \"emailAccount\":\"" + emailAccount + "\"" +
                ", \"userName\":\"" + userName + "\"" +
                ", \"extensionAttrib7\":\"" + extensionAttrib7 + "\"" +
                ", \"employeeNumber\":\"" + employeeNumber + "\"" +
                ", \"requesterEca\":\"" + requesterEca + "\"" +
                ", \"visaType\":\"" + visaType + "\"" +
                ", \"department\":\"" + department + "\"" +
                ", \"facilityName\":\"" + facilityName + "\"" +
                ", \"offsiteClinicLeasingStaff\":\"" + offsiteClinicLeasingStaff + "\"" +
                ", \"email\":\"" + email + "\"" +
                ", \"address\":\"" + address + "\"" +
                ", \"homeZip\":\"" + homeZip + "\"" +
                ", \"proposedAccountName\":\"" + proposedAccountName + "\"" +
                ", \"middleName\":\"" + middleName + "\"" +
                ", \"employeeType\":\"" + employeeType + "\"" +
                ", \"eLock\":\"" + eLock + "\"" +
                ", \"homeState\":\"" + homeState + "\"" +
                ", \"departmentNumber\":\"" + departmentNumber + "\"" +
                ", \"dateOfBirth\":\"" + dateOfBirth + "\"" +
                ", \"systemNames\":\"" + systemNames + "\"" +
                ", \"status\":\"" + status + "\"" +
                ", \"mobilePhone\":\"" + mobilePhone + "\"" +
                ", \"requestType\":\"" + requestType + "\"" +
                ", \"wirelessLogonAccess\":\"" + wirelessLogonAccess + "\"" +
                ", \"primaryEca\":\"" + primaryEca + "\"" +
                ", \"city\":\"" + city + "\"" +
                ", \"contactPhone\":\"" + contactPhone + "\"" +
                ", \"title\":\"" + title + "\"" +
                ", \"zipCode\":\"" + zipCode + "\"" +
                ", \"requestedItem\":\"" + requestedItem + "\"" +
                ", \"contactEmail\":\"" + contactEmail + "\"" +
                ", \"ownerEca\":\"" + ownerEca + "\"" +
                ", \"contactTitle\":\"" + contactTitle + "\"" +
                ", \"facilityPersonalId\":\"" + facilityPersonalId + "\"" +
                ", \"temporaryDisable\":\"" + temporaryDisable + "\"" +
                ", \"vpnLogonAccess\":\"" + vpnLogonAccess + "\"" +
                ", \"homeCountry\":\"" + homeCountry + "\"" +
                ", \"sysCreatedBy\":\"" + super.getSysCreatedBy() + "\"" +
                ", \"sysCreatedOn\":\"" + super.getSysCreatedOn() + "\"" +
                ", \"sysId\":\"" + super.getSysId() + "\"" +
                ", \"sysModCount\":\"" + super.getSysModCount() + "\"" +
                ", \"sysTags\":\"" + super.getSysTags() + "\"" +
                ", \"sysUpdatedBy\":\"" + super.getSysUpdatedBy() + "\"" +
                ", \"sysUpdatedOn\":\"" + super.getSysUpdatedOn() + "\"" +

                "}";
    }
}