package com.k8s.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@Slf4j
public class ServiceController {
    private static final String key="B8Vc6v900QZcXyleXAUJxXr5xOQoGQBblqqQYi4RRP8uWRsffiqhtFZn3PTjlVlr";
    private static final String URLPrefix = "https://www.zipcodeapi.com/rest/"+key+"/";
    private static final String GET = "GET";

    @Autowired
    public ServiceController() {
        log.info("ServiceController initiated");
    }

    @RequestMapping(value = "/zipcodeservice/info/{zipcode}", produces = { "application/json" })
    public String getZipcodeInfo(@PathVariable("zipcode") Integer zipcode) {
        return getURLResponse("info.json/" + zipcode + "/degrees");
    }

    @RequestMapping(value = "/zipcodeservice/nearby/{zipcode}/{distance}", produces = { "application/json" })
    public String getNearbyZipcodes(@PathVariable("zipcode") Integer zipcode,
            @PathVariable("distance") Integer distance) {
        return getURLResponse("radius.json/" + zipcode + "/" + distance + "/mile");
    }

    private String getURLResponse(String path) {
        try {
            URL url = new URL(URLPrefix + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(GET);
            StringBuilder result = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            return result.toString();
        } catch (MalformedURLException e1) {
            log.error(e1.getMessage());
            return null;
        } catch (IOException e2) {
            log.error(e2.getMessage());
            return null;
        }
    }
}