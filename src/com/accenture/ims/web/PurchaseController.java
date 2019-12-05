package com.accenture.ims.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.service.PurchaseEntryService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseEntryService service;
	
	@ModelAttribute("VendorNamesList")
	public List<String> populateVendorNames() throws Exception{
		VendorServiceConsumer vendorConsumer = new VendorServiceConsumer();
		List<String> vendorNameList = vendorConsumer.listVendorName();
		return vendorNameList;
	}
	
/*	@ModelAttribute("MaterialCategoryList")
	public Map<String,String> populateMaterialCategory(){
		
		Map<String, String> materialCategoryIdAndName = new Map<String, String>();
		
	}*/
	
	
	@RequestMapping(value="/loadPurchaseEntryPage",method=RequestMethod.GET)
	public ModelAndView loadPurchaseEntryPage() {
		
		ModelAndView modelAndView = new ModelAndView();
		PurchaseEntryBean purchaseEntryBean = new PurchaseEntryBean();
		modelAndView.addObject("purchaseEntryBean", purchaseEntryBean);
		modelAndView.setViewName("PurchaseEntry");
		return modelAndView;
	}
	
	
}
