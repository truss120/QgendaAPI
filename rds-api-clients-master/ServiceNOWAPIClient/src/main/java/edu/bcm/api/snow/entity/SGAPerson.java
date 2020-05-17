package edu.bcm.api.snow.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, allowSetters = true, allowGetters = true)
public class SGAPerson {
    private String accountType;
    private String address;
    private String buildingCode;
    private String buildingName;
    private String city;
    private String companyName;
    private String computerServerNames;
    private String contactEmail;
    private String contactPhone;
    private String contactTitle;
    private String dataElementViewEdit;
    private Date dateOfBirth;
    private String department;
    private String departmentNumber;
    private String desktopOrServerAccess;
    private String elock;
    private String email;
    private String emailAccount;
    private String employeeNumber;
    private String employeeType;
    private String extensionAttrib7;
    private String facilityName;
    private String facilityPersonalId;
    private String firstName;
    private String gender;
    private String homeAddress;
    private String homeCity;
    private String homeCountry;
    private String homePhone;
    private String homeState;
    private String homeZip;
    private String interactiveLogon;
    private String lastName;
    private String license;
    private String mailstop;
    private String maritalStatus;
    private String middleName;
    private String mobilePhone;
    private String offsiteClinicLeasingStaff;
    private String ownerEca;
    private String phone;
    private String primaryEca;
    private String processed;
    private String proposedAccountName;
    private String providerType;
    private String requestType;
    private String requestedItem;
    private String requesterEca;
    private String rmCompanyName;
    private String rmCompanyPersonalId;
    private Long rmDaysToExpire;
    private String role;
    private String roomNumber;
    private String state;
    private String status;
    private String sysCreatedBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sysCreatedOn;
    private String sysId;
    private Long sysModCount;
    private String sysTags;
    private String sysUpdatedBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sysUpdatedOn;
    private String systemNames;
    private String temporaryDisable;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date terminationDate;
    private String title;
    private String userName;
    private String visaType;
    private String vpnLogonAccess;
    private String wirelessLogonAccess;
    private String zipCode;


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getComputerServerNames() {
        return computerServerNames;
    }

    public void setComputerServerNames(String computerServerNames) {
        this.computerServerNames = computerServerNames;
    }


    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }


    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }


    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }


    public String getDataElementViewEdit() {
        return dataElementViewEdit;
    }

    public void setDataElementViewEdit(String dataElementViewEdit) {
        this.dataElementViewEdit = dataElementViewEdit;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }


    public String getDesktopOrServerAccess() {
        return desktopOrServerAccess;
    }

    public void setDesktopOrServerAccess(String desktopOrServerAccess) {
        this.desktopOrServerAccess = desktopOrServerAccess;
    }

    public String getElock() {
        return elock;
    }

    public void setElock(String elock) {
        this.elock = elock;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }


    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }


    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }


    public String getExtensionAttrib7() {
        return extensionAttrib7;
    }

    public void setExtensionAttrib7(String extensionAttrib7) {
        this.extensionAttrib7 = extensionAttrib7;
    }


    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }


    public String getFacilityPersonalId() {
        return facilityPersonalId;
    }

    public void setFacilityPersonalId(String facilityPersonalId) {
        this.facilityPersonalId = facilityPersonalId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }


    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }


    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }


    public String getInteractiveLogon() {
        return interactiveLogon;
    }

    public void setInteractiveLogon(String interactiveLogon) {
        this.interactiveLogon = interactiveLogon;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }


    public String getMailstop() {
        return mailstop;
    }

    public void setMailstop(String mailstop) {
        this.mailstop = mailstop;
    }


    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }


    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    public String getOffsiteClinicLeasingStaff() {
        return offsiteClinicLeasingStaff;
    }

    public void setOffsiteClinicLeasingStaff(String offsiteClinicLeasingStaff) {
        this.offsiteClinicLeasingStaff = offsiteClinicLeasingStaff;
    }


    public String getOwnerEca() {
        return ownerEca;
    }

    public void setOwnerEca(String ownerEca) {
        this.ownerEca = ownerEca;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getPrimaryEca() {
        return primaryEca;
    }

    public void setPrimaryEca(String primaryEca) {
        this.primaryEca = primaryEca;
    }


    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }


    public String getProposedAccountName() {
        return proposedAccountName;
    }

    public void setProposedAccountName(String proposedAccountName) {
        this.proposedAccountName = proposedAccountName;
    }


    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestedItem() {
        return requestedItem;
    }

    public void setRequestedItem(String requestedItem) {
        this.requestedItem = requestedItem;
    }


    public String getRequesterEca() {
        return requesterEca;
    }

    public void setRequesterEca(String requesterEca) {
        this.requesterEca = requesterEca;
    }

    public String getRmCompanyName() {
        return rmCompanyName;
    }

    public void setRmCompanyName(String rmCompanyName) {
        this.rmCompanyName = rmCompanyName;
    }

    public String getRmCompanyPersonalId() {
        return rmCompanyPersonalId;
    }

    public void setRmCompanyPersonalId(String rmCompanyPersonalId) {
        this.rmCompanyPersonalId = rmCompanyPersonalId;
    }

    public Long getRmDaysToExpire() {
        return rmDaysToExpire;
    }

    public void setRmDaysToExpire(Long rmDaysToExpire) {
        this.rmDaysToExpire = rmDaysToExpire;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSysCreatedBy() {
        return sysCreatedBy;
    }

    public void setSysCreatedBy(String sysCreatedBy) {
        this.sysCreatedBy = sysCreatedBy;
    }

    public Date getSysCreatedOn() {
        return sysCreatedOn;
    }

    public void setSysCreatedOn(Date sysCreatedOn) {
        this.sysCreatedOn = sysCreatedOn;
    }


    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public Long getSysModCount() {
        return sysModCount;
    }

    public void setSysModCount(Long sysModCount) {
        this.sysModCount = sysModCount;
    }

    public String getSysTags() {
        return sysTags;
    }

    public void setSysTags(String sysTags) {
        this.sysTags = sysTags;
    }


    public String getSysUpdatedBy() {
        return sysUpdatedBy;
    }

    public void setSysUpdatedBy(String sysUpdatedBy) {
        this.sysUpdatedBy = sysUpdatedBy;
    }

    public Date getSysUpdatedOn() {
        return sysUpdatedOn;
    }

    public void setSysUpdatedOn(Date sysUpdatedOn) {
        this.sysUpdatedOn = sysUpdatedOn;
    }


    public String getSystemNames() {
        return systemNames;
    }

    public void setSystemNames(String systemNames) {
        this.systemNames = systemNames;
    }


    public String getTemporaryDisable() {
        return temporaryDisable;
    }

    public void setTemporaryDisable(String temporaryDisable) {
        this.temporaryDisable = temporaryDisable;
    }


    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }


    public String getVpnLogonAccess() {
        return vpnLogonAccess;
    }

    public void setVpnLogonAccess(String vpnLogonAccess) {
        this.vpnLogonAccess = vpnLogonAccess;
    }

    public String getWirelessLogonAccess() {
        return wirelessLogonAccess;
    }

    public void setWirelessLogonAccess(String wirelessLogonAccess) {
        this.wirelessLogonAccess = wirelessLogonAccess;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public Class<?> getEntityClass() {
        return SGAPerson.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SGAPerson that = (SGAPerson) o;
        return Objects.equals(accountType, that.accountType) &&
                Objects.equals(address, that.address) &&
                Objects.equals(buildingCode, that.buildingCode) &&
                Objects.equals(buildingName, that.buildingName) &&
                Objects.equals(city, that.city) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(computerServerNames, that.computerServerNames) &&
                Objects.equals(contactEmail, that.contactEmail) &&
                Objects.equals(contactPhone, that.contactPhone) &&
                Objects.equals(contactTitle, that.contactTitle) &&
                Objects.equals(dataElementViewEdit, that.dataElementViewEdit) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(department, that.department) &&
                Objects.equals(departmentNumber, that.departmentNumber) &&
                Objects.equals(desktopOrServerAccess, that.desktopOrServerAccess) &&
                Objects.equals(elock, that.elock) &&
                Objects.equals(email, that.email) &&
                Objects.equals(emailAccount, that.emailAccount) &&
                Objects.equals(employeeNumber, that.employeeNumber) &&
                Objects.equals(employeeType, that.employeeType) &&
                Objects.equals(extensionAttrib7, that.extensionAttrib7) &&
                Objects.equals(facilityName, that.facilityName) &&
                Objects.equals(facilityPersonalId, that.facilityPersonalId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(homeAddress, that.homeAddress) &&
                Objects.equals(homeCity, that.homeCity) &&
                Objects.equals(homeCountry, that.homeCountry) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(homeState, that.homeState) &&
                Objects.equals(homeZip, that.homeZip) &&
                Objects.equals(interactiveLogon, that.interactiveLogon) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(license, that.license) &&
                Objects.equals(mailstop, that.mailstop) &&
                Objects.equals(maritalStatus, that.maritalStatus) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(offsiteClinicLeasingStaff, that.offsiteClinicLeasingStaff) &&
                Objects.equals(ownerEca, that.ownerEca) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(primaryEca, that.primaryEca) &&
                Objects.equals(processed, that.processed) &&
                Objects.equals(proposedAccountName, that.proposedAccountName) &&
                Objects.equals(providerType, that.providerType) &&
                Objects.equals(requestType, that.requestType) &&
                Objects.equals(requestedItem, that.requestedItem) &&
                Objects.equals(requesterEca, that.requesterEca) &&
                Objects.equals(rmCompanyName, that.rmCompanyName) &&
                Objects.equals(rmCompanyPersonalId, that.rmCompanyPersonalId) &&
                Objects.equals(rmDaysToExpire, that.rmDaysToExpire) &&
                Objects.equals(role, that.role) &&
                Objects.equals(roomNumber, that.roomNumber) &&
                Objects.equals(state, that.state) &&
                Objects.equals(status, that.status) &&
                Objects.equals(sysCreatedBy, that.sysCreatedBy) &&
                Objects.equals(sysCreatedOn, that.sysCreatedOn) &&
                Objects.equals(sysId, that.sysId) &&
                Objects.equals(sysModCount, that.sysModCount) &&
                Objects.equals(sysTags, that.sysTags) &&
                Objects.equals(sysUpdatedBy, that.sysUpdatedBy) &&
                Objects.equals(sysUpdatedOn, that.sysUpdatedOn) &&
                Objects.equals(systemNames, that.systemNames) &&
                Objects.equals(temporaryDisable, that.temporaryDisable) &&
                Objects.equals(terminationDate, that.terminationDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(visaType, that.visaType) &&
                Objects.equals(vpnLogonAccess, that.vpnLogonAccess) &&
                Objects.equals(wirelessLogonAccess, that.wirelessLogonAccess) &&
                Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, address, buildingCode, buildingName, city, companyName, computerServerNames, contactEmail, contactPhone, contactTitle, dataElementViewEdit, dateOfBirth, department, departmentNumber, desktopOrServerAccess, elock, email, emailAccount, employeeNumber, employeeType, extensionAttrib7, facilityName, facilityPersonalId, firstName, gender, homeAddress, homeCity, homeCountry, homePhone, homeState, homeZip, interactiveLogon, lastName, license, mailstop, maritalStatus, middleName, mobilePhone, offsiteClinicLeasingStaff, ownerEca, phone, primaryEca, processed, proposedAccountName, providerType, requestType, requestedItem, requesterEca, rmCompanyName, rmCompanyPersonalId, rmDaysToExpire, role, roomNumber, state, status, sysCreatedBy, sysCreatedOn, sysId, sysModCount, sysTags, sysUpdatedBy, sysUpdatedOn, systemNames, temporaryDisable, terminationDate, title, userName, visaType, vpnLogonAccess, wirelessLogonAccess, zipCode);
    }


    public long getId() {
        return employeeNumber == null ? 0 : Long.valueOf(employeeNumber);
    }

    @Override
    public String toString() {
        return "SGAPerson{" +
                "accountType='" + accountType + '\'' +
                ", address='" + address + '\'' +
                ", buildingCode='" + buildingCode + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", computerServerNames='" + computerServerNames + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", dataElementViewEdit='" + dataElementViewEdit + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", department='" + department + '\'' +
                ", departmentNumber='" + departmentNumber + '\'' +
                ", desktopOrServerAccess='" + desktopOrServerAccess + '\'' +
                ", elock='" + elock + '\'' +
                ", email='" + email + '\'' +
                ", emailAccount='" + emailAccount + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", extensionAttrib7='" + extensionAttrib7 + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", facilityPersonalId='" + facilityPersonalId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", homeCity='" + homeCity + '\'' +
                ", homeCountry='" + homeCountry + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", homeState='" + homeState + '\'' +
                ", homeZip='" + homeZip + '\'' +
                ", interactiveLogon='" + interactiveLogon + '\'' +
                ", lastName='" + lastName + '\'' +
                ", license='" + license + '\'' +
                ", mailstop='" + mailstop + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", middleName='" + middleName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", offsiteClinicLeasingStaff='" + offsiteClinicLeasingStaff + '\'' +
                ", ownerEca='" + ownerEca + '\'' +
                ", phone='" + phone + '\'' +
                ", primaryEca='" + primaryEca + '\'' +
                ", processed='" + processed + '\'' +
                ", proposedAccountName='" + proposedAccountName + '\'' +
                ", providerType='" + providerType + '\'' +
                ", requestType='" + requestType + '\'' +
                ", requestedItem='" + requestedItem + '\'' +
                ", requesterEca='" + requesterEca + '\'' +
                ", rmCompanyName='" + rmCompanyName + '\'' +
                ", rmCompanyPersonalId='" + rmCompanyPersonalId + '\'' +
                ", rmDaysToExpire=" + rmDaysToExpire +
                ", role='" + role + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", state='" + state + '\'' +
                ", status='" + status + '\'' +
                ", sysCreatedBy='" + sysCreatedBy + '\'' +
                ", sysCreatedOn=" + sysCreatedOn +
                ", sysId='" + sysId + '\'' +
                ", sysModCount=" + sysModCount +
                ", sysTags='" + sysTags + '\'' +
                ", sysUpdatedBy='" + sysUpdatedBy + '\'' +
                ", sysUpdatedOn=" + sysUpdatedOn +
                ", systemNames='" + systemNames + '\'' +
                ", temporaryDisable='" + temporaryDisable + '\'' +
                ", terminationDate=" + terminationDate +
                ", title='" + title + '\'' +
                ", userName='" + userName + '\'' +
                ", visaType='" + visaType + '\'' +
                ", vpnLogonAccess='" + vpnLogonAccess + '\'' +
                ", wirelessLogonAccess='" + wirelessLogonAccess + '\'' +
                ", zipCode='" + zipCode + '\'' +
                "} " + super.toString();
    }
}
