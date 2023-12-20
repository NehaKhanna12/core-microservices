package com.dto.coreDetails;

import java.io.Serializable;
import java.util.List;


public class ContactInformation implements Serializable {
    private List<ContactNumber> contactNumber;
    private String email;

    @Override
    public String toString() {
        return "ContactInformation{" +
                "contactNumber=" + contactNumber +
                ", email='" + email + '\'' +
                '}';
    }

    public List<ContactNumber> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(List<ContactNumber> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
