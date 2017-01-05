package com.codecool.frompythontojava.exercise3;


import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<String> details = new ArrayList<String>();

    public void addDetails(String details) {
        this.details.add(details);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "details=" + details +
                '}';
    }
}
