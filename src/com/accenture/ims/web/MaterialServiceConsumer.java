package com.accenture.ims.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestTemplate;
import com.accenture.ims.business.bean.MaterialCategoryBean;
import com.accenture.ims.business.bean.MaterialTypeBean;
import com.accenture.ims.business.bean.MaterialUnitBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MaterialServiceConsumer {
 
	public static final String REST_SERVICE_URL = "http://localhost:8088/material/controller";

	// Returning MaterialType in the form of Map (typeId,materialType)
	// ----------------------------------------------------------------------------------------------

	public  Map<String, String> getMaterialTypeByCategoryId(String categoryId) {
		String url = REST_SERVICE_URL + "/getMaterialTypeByCategoryId/" + categoryId;
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> linkedHashMapList = restTemplate.getForObject(url, List.class);

		// mapper to covert Object to a specific type
		ObjectMapper mapper = new ObjectMapper();
		List<MaterialTypeBean> materialTypeBeanList = new ArrayList<MaterialTypeBean>();

		for (LinkedHashMap<String, Object> linkedHahMap : linkedHashMapList) {
			MaterialTypeBean materialTypeBean = mapper.convertValue(linkedHahMap, MaterialTypeBean.class);
			materialTypeBeanList.add(materialTypeBean);
		}

		Map<String, String> materialTypeBeanMap = new LinkedHashMap<String, String>();

		for (MaterialTypeBean materialTypeBean : materialTypeBeanList) {
			materialTypeBeanMap.put(materialTypeBean.getTypeId(), materialTypeBean.getTypeName());
		}
		return materialTypeBeanMap;

	}

	// Returning MaterialCategories in the form of Map (CategoryId,categoryName)
	// ----------------------------------------------------------------------------------------------

	public  Map<String, String> getMaterialCategories() {

		String url = REST_SERVICE_URL + "/getMaterialCategories";
		RestTemplate restTemplate = new RestTemplate();

		List<LinkedHashMap<String, Object>> linkedHashMapList = restTemplate.getForObject(url, List.class);

		// mapper to covert Object to a specific type
		ObjectMapper mapper = new ObjectMapper();
		List<MaterialCategoryBean> materialCategoryBeanList = new ArrayList<MaterialCategoryBean>();

		for (LinkedHashMap<String, Object> linkedHahMap : linkedHashMapList) {
			MaterialCategoryBean materialCategoryBean = mapper.convertValue(linkedHahMap, MaterialCategoryBean.class);
			materialCategoryBeanList.add(materialCategoryBean);
		}
		
		
		
		Map<String, String> materialCategoryBeanMap = new LinkedHashMap<String, String>();

		for (MaterialCategoryBean materialCategoryBean : materialCategoryBeanList) {
			materialCategoryBeanMap.put(materialCategoryBean.getCategoryId(), materialCategoryBean.getCategoryName());
		}
		return materialCategoryBeanMap;

	}

	// Returning MaterialUnit in the form of Map (unitId,unitName)
	// ----------------------------------------------------------------------------------------------

	public  Map<String, String> getMaterialUnitByCategoryId(String categoryId) {
		String url = REST_SERVICE_URL + "/getMaterialUnitById/" + categoryId;
		RestTemplate restTemplate = new RestTemplate();

		List<LinkedHashMap<String, Object>> linkedHashMapList = restTemplate.getForObject(url, List.class);

		// mapper to covert Object to a specific type
		ObjectMapper mapper = new ObjectMapper();
		List<MaterialUnitBean> materialUnitBeanList = new ArrayList<MaterialUnitBean>();

		for (LinkedHashMap<String, Object> linkedHahMap : linkedHashMapList) {
			MaterialUnitBean materialUnitBean = mapper.convertValue(linkedHahMap, MaterialUnitBean.class);
			materialUnitBeanList.add(materialUnitBean);
		}
		
		
		Map<String, String> materialUnitBeanMap = new LinkedHashMap<String, String>();

		for (MaterialUnitBean materialUnitBean : materialUnitBeanList) {
			materialUnitBeanMap.put(materialUnitBean.getUnitId(), materialUnitBean.getUnitName());
		}
		return materialUnitBeanMap;
	}

	// ----------------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------

	public  MaterialCategoryBean getMaterialCategoryById(String categoryId) {

		String url = REST_SERVICE_URL + "/getMaterialCategoryById/" + categoryId;
		RestTemplate restTemplate = new RestTemplate();
		MaterialCategoryBean materialCategoryBean = new MaterialCategoryBean();
		materialCategoryBean = restTemplate.getForObject(url, MaterialCategoryBean.class);
		return materialCategoryBean;
	}
}
