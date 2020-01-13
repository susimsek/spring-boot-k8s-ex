package com.k8s.web.model;

import lombok.Data;

@Data
public class ZipCode {
    private String zip_code;
    private String distance;
    private String city;
    private String state;
}
