package com.dto.coreDetails;


import java.io.Serializable;


public class ContactNumber  implements Serializable {
    private String number;
    private String type;

    @Override
    public String toString() {
        return "ContactNumber{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
