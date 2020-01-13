package com.k8s.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebService {

    @Autowired
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    /**
     * The serviceURL parameter corresponds to the zipcode service.
     * 
     * @param String
     *            serviceURL
     */
    public WebService(String serviceURL) {
        this.serviceUrl = "http://" + serviceURL;
    }

    public String getZipInfo(String zipcode) {
        return restTemplate.getForObject(serviceUrl + 
            "/zipcodeservice/info/{zipcode}", String.class, zipcode);
    }

    public String getNearbyZipcodesWithinDistance(String zipcode, String distance) {
        return restTemplate.getForObject(serviceUrl + 
             "/zipcodeservice/nearby/{zipcode}/{distance}", String.class,
                zipcode, distance);
    }
}