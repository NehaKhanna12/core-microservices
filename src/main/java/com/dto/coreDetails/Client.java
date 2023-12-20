package com.dto.coreDetails;



import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {
    private String panMasalaPacketsPerDay;

    private String lastName;

    @Override
    public String toString() {
        return "Client{" +
                "panMasalaPacketsPerDay='" + panMasalaPacketsPerDay + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IDProofTypeCode='" + IDProofTypeCode + '\'' +
                ", product=" + product +
                ", noOfCigarettes='" + noOfCigarettes + '\'' +
                ", ghd='" + ghd + '\'' +
                ", address=" + address +
                ", annualIncome='" + annualIncome + '\'' +
                ", IDProofType='" + IDProofType + '\'' +
                ", title='" + title + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", relationshipCode='" + relationshipCode + '\'' +
                ", titleCode='" + titleCode + '\'' +
                ", smokerFlag='" + smokerFlag + '\'' +
                ", alcoholConsumedPerWeek='" + alcoholConsumedPerWeek + '\'' +
                ", firstName='" + firstName + '\'' +
                ", maritalStatusCode='" + maritalStatusCode + '\'' +
                ", genderCode='" + genderCode + '\'' +
                ", nationalityCode='" + nationalityCode + '\'' +
                ", smokingDuration='" + smokingDuration + '\'' +
                ", contactInformation=" + contactInformation +
                ", panMasalaFlag='" + panMasalaFlag + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", mandatoryDocuments='" + mandatoryDocuments + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dependants=" + dependants +
                '}';
    }

    public String getPanMasalaPacketsPerDay() {
        return panMasalaPacketsPerDay;
    }

    public void setPanMasalaPacketsPerDay(String panMasalaPacketsPerDay) {
        this.panMasalaPacketsPerDay = panMasalaPacketsPerDay;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIDProofTypeCode() {
        return IDProofTypeCode;
    }

    public void setIDProofTypeCode(String IDProofTypeCode) {
        this.IDProofTypeCode = IDProofTypeCode;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getNoOfCigarettes() {
        return noOfCigarettes;
    }

    public void setNoOfCigarettes(String noOfCigarettes) {
        this.noOfCigarettes = noOfCigarettes;
    }

    public String getGhd() {
        return ghd;
    }

    public void setGhd(String ghd) {
        this.ghd = ghd;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getIDProofType() {
        return IDProofType;
    }

    public void setIDProofType(String IDProofType) {
        this.IDProofType = IDProofType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRelationshipCode() {
        return relationshipCode;
    }

    public void setRelationshipCode(String relationshipCode) {
        this.relationshipCode = relationshipCode;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getSmokerFlag() {
        return smokerFlag;
    }

    public void setSmokerFlag(String smokerFlag) {
        this.smokerFlag = smokerFlag;
    }

    public String getAlcoholConsumedPerWeek() {
        return alcoholConsumedPerWeek;
    }

    public void setAlcoholConsumedPerWeek(String alcoholConsumedPerWeek) {
        this.alcoholConsumedPerWeek = alcoholConsumedPerWeek;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getSmokingDuration() {
        return smokingDuration;
    }

    public void setSmokingDuration(String smokingDuration) {
        this.smokingDuration = smokingDuration;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getPanMasalaFlag() {
        return panMasalaFlag;
    }

    public void setPanMasalaFlag(String panMasalaFlag) {
        this.panMasalaFlag = panMasalaFlag;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getMandatoryDocuments() {
        return mandatoryDocuments;
    }

    public void setMandatoryDocuments(String mandatoryDocuments) {
        this.mandatoryDocuments = mandatoryDocuments;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public List<Dependants> getDependants() {
        return dependants;
    }

    public void setDependants(List<Dependants> dependants) {
        this.dependants = dependants;
    }

    private String IDProofTypeCode;

    private List<Product> product;

    private String noOfCigarettes;

    private String ghd;

    private List<Address> address;

    private String annualIncome;

    private String IDProofType;

    private String title;

    private String birthDate;
    private String relationshipCode;
    private String titleCode;

    private String smokerFlag;

    private String alcoholConsumedPerWeek;

    private String firstName;

    private String maritalStatusCode;

    private String genderCode;

    private String nationalityCode;

    private String smokingDuration;

    private ContactInformation contactInformation;

    private String panMasalaFlag;

    private String clientCode;

    private String mandatoryDocuments;

    private String middleName;
    private List<Dependants> dependants;
}
