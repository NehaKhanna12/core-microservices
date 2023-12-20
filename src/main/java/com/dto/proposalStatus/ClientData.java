package com.dto.proposalStatus;


public class ClientData {
    private String firstName;

    private String lastName;

    @Override
    public String toString() {
        return "ClientData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", loadingAmount='" + loadingAmount + '\'' +
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

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLoadingAmount() {
        return loadingAmount;
    }

    public void setLoadingAmount(String loadingAmount) {
        this.loadingAmount = loadingAmount;
    }

    private String clientCode;

    private String dateOfBirth;

    private String loadingAmount;
}
