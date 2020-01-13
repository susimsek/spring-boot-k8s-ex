package com.k8s.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZipCodeWrapper {

    private ZipCode[] zip_codes;

    public String toString() {
        StringBuilder strBldr = new StringBuilder();
        strBldr.append("<p>Zip codes:<br>");
        for(ZipCode zipCode:zip_codes){
            strBldr.append(zipCode);
        }
        return strBldr.toString();
    }
}
