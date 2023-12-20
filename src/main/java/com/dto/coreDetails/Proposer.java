package com.dto.coreDetails;


import java.io.Serializable;
import java.util.List;

public class Proposer implements Serializable {
    private String firstName;

    private String lastName;

    private String maritalStatusCode;

    @Override
    public String toString() {
        return "Proposer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", maritalStatusCode='" + maritalStatusCode + '\'' +
                ", genderCode='" + genderCode + '\'' +
                ", address=" + address +
                ", contactInformation=" + contactInformation +
                ", clientCode='" + clientCode + '\'' +
                ", middleName='" + middleName + '\'' +
                ", relationshipCode='" + relationshipCode + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getRelationshipCode() {
        return relationshipCode;
    }

    public void setRelationshipCode(String relationshipCode) {
        this.relationshipCode = relationshipCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    private String genderCode;

    private List<Address> address;

    private ContactInformation contactInformation;

    private String clientCode;

    private String middleName;

    private String relationshipCode;

    private String birthDate;
}
