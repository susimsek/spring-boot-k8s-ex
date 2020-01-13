package com.k8s.web.controller;

import com.google.gson.Gson;
import com.k8s.web.model.ZipCodeInfo;
import com.k8s.web.model.ZipCodeWrapper;
import com.k8s.web.service.WebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WebController {


	protected WebService service;


	@Autowired
	public WebController(WebService service) {
		log.info("WebController initiated");
		;
		this.service = service;
	}

	@RequestMapping(value = "/zip/getZipcodeInfo/{zipcode}", produces = {"text/html"})
	public String zipInfo(@PathVariable("zipcode") String zipcode) {
		Gson gson = new Gson();
		String response = service.getZipInfo(zipcode);
		log.info(response);
		ZipCodeInfo info = gson.fromJson(response, ZipCodeInfo.class);

		StringBuilder result = new StringBuilder();
		result.append("<html><body>");
		if (info != null) {
			result.append(info.toString());
		}
		result.append("</body></html>");
		return result.toString();
	}

	@RequestMapping(value = "/zip/getNearbyZipcodes/{zipcode}/{distance}", produces = {"text/html"})
	public String zipDistance(@PathVariable("zipcode") String zipcode, @PathVariable("distance") String distance) {
		Gson gson = new Gson();
		String response = service.getNearbyZipcodesWithinDistance(zipcode, distance);
		log.info(response);
		ZipCodeWrapper zipCodes = gson.fromJson(response, ZipCodeWrapper.class);
		StringBuilder result = new StringBuilder();
		result.append("<html><body>");
		if (zipCodes != null) {
			result.append(zipCodes.toString());
		}
		result.append("</body></html>");
		return result.toString();
	}
}