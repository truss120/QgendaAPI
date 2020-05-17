package edu.bcm.api.medhub.util;

import java.util.Date;
import java.util.Objects;


public class AccountRequest {
    private String bcmId;
    private String eca;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private Date hireDate;
    private Date startDate;
    private String userType;
    private String camsId;
    private String sfId;
    private String medhubId;
    private String idmId;
    private Long accountRequestId;
    private Date createdTimestamp;
    private Date lastUpdatedTimestamp;
    private String sourceFileName;
    private String matchProcessingStatus;


    public String getBcmId() {
        return bcmId;
    }

    public void setBcmId(String bcmId) {
        this.bcmId = bcmId;
    }

    public String getEca() {
        return eca;
    }

    public void setEca(String eca) {
        this.eca = eca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCamsId() {
        return camsId;
    }

    public void setCamsId(String camsId) {
        this.camsId = camsId;
    }

    public String getSfId() {
        return sfId;
    }

    public void setSfId(String sfId) {
        this.sfId = sfId;
    }

    public String getMedhubId() {
        return medhubId;
    }

    public void setMedhubId(String medhubId) {
        this.medhubId = medhubId;
    }

    public String getIdmId() {
        return idmId;
    }

    public void setIdmId(String idmId) {
        this.idmId = idmId;
    }

    public Long getAccountRequestId() {
        return accountRequestId;
    }

    public void setAccountRequestId(Long accountRequestId) {
        this.accountRequestId = accountRequestId;
    }

    public String getMatchProcessingStatus() {
        return matchProcessingStatus;
    }

    public void setMatchProcessingStatus(String matchProcessingStatus) {
        this.matchProcessingStatus = matchProcessingStatus;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public Class<?> getEntityClass() {
        return AccountRequest.class;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRequest that = (AccountRequest) o;
        return accountRequestId == that.accountRequestId &&
                Objects.equals(bcmId, that.bcmId) &&
                Objects.equals(eca, that.eca) &&
                Objects.equals(email, that.email) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(hireDate, that.hireDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(camsId, that.camsId) &&
                Objects.equals(sfId, that.sfId) &&
                Objects.equals(medhubId, that.medhubId) &&
                Objects.equals(idmId, that.idmId) &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(lastUpdatedTimestamp, that.lastUpdatedTimestamp) &&
                Objects.equals(sourceFileName, that.sourceFileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bcmId, eca, email, firstName, middleName, lastName, birthDate, hireDate, startDate, userType, camsId, sfId, medhubId, idmId, accountRequestId, createdTimestamp, lastUpdatedTimestamp, sourceFileName);
    }

    public long getId() {
        return accountRequestId;
    }
}
