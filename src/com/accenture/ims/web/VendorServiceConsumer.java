package com.accenture.ims.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.accenture.ims.business.bean.VendorBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VendorServiceConsumer {
	
	//public static final String REST_SERVICE_URL = "http://localhost:8088";
	
	
	public static final String REST_SERVICE_URL="http://javastreamims.devops.vendorservice.ci.18.203.244.244.xip.io/project/vendor/controller/getVendors";

	public static List<String> listVendorName() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		List<LinkedHashMap<String, Object>> vendorListJSON = restTemplate
				.getForObject(REST_SERVICE_URL , List.class);

		ObjectMapper mapper = new ObjectMapper();

		List<String> vendorListName = new ArrayList<String>();

		
		if (vendorListJSON != null) {
			for (LinkedHashMap<String, Object> vendorObj : vendorListJSON) {
				VendorBean vendorBean = mapper.convertValue(vendorObj, VendorBean.class);
				vendorListName.add(vendorBean.getVendorName());
			}
			return vendorListName;
		} else {
			throw new Exception("No Vendors to Display");
		}

	}

}
