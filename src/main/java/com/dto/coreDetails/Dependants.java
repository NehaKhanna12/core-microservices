package com.dto.coreDetails;



import java.util.List;


public class Dependants {
    private List<Product> product;

    @Override
    public String toString() {
        return "Dependants{" +
                "product=" + product +
                ", address=" + address +
                ", annualIncome='" + annualIncome + '\'' +
                ", weight='" + weight + '\'' +
                ", clientStatus='" + clientStatus + '\'' +
                ", relationshipStatus='" + relationshipStatus + '\'' +
                ", relationshipCode='" + relationshipCode + '\'' +
                ", title='" + title + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", titleCode='" + titleCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", maritalStatusCode='" + maritalStatusCode + '\'' +
                ", genderCode='" + genderCode + '\'' +
                ", nationalityCode='" + nationalityCode + '\'' +
                ", contactInformation=" + contactInformation +
                ", clientCode='" + clientCode + '\'' +
                ", height='" + height + '\'' +
                '}';
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String getRelationshipCode() {
        return relationshipCode;
    }

    public void setRelationshipCode(String relationshipCode) {
        this.relationshipCode = relationshipCode;
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

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    private List<Address> address;

    private String annualIncome;

    private String weight;

    private String clientStatus;

    private String relationshipStatus;

    private String relationshipCode;

    private String title;

    private String birthDate;

    private String titleCode;

    private String firstName;
    private String lastName;
    private String middleName;
    private String maritalStatusCode;

    private String genderCode;

    private String nationalityCode;

    private ContactInformation contactInformation;

    private String clientCode;

    private String height;
}
