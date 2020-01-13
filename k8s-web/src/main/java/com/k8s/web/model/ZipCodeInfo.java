package com.k8s.web.model;

import lombok.Data;

@Data
public class ZipCodeInfo {

    private String zip_code;
    private String lat;
    private String lng;
    private String city;
    private String state;
    private CityState[] acceptable_city_names;
    private Timezone timezone;
}
