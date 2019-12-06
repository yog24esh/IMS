package com.accenture.ims.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.service.PurchaseEntryService;

@Controller
@SessionAttributes("purchaseEntryBean")
public class PurchaseController {
	
	@Autowired
	private PurchaseEntryService service;
	
	@ModelAttribute("purchaseEntryBean")
	public PurchaseEntryBean setUpPurchaseEntryForm(){
		return new PurchaseEntryBean();
	}
	
	@ModelAttribute("VendorNamesList")
	public List<String> populateVendorNames() throws Exception{
		VendorServiceConsumer vendorConsumer = new VendorServiceConsumer();
		List<String> vendorNameList = vendorConsumer.listVendorName();
		return vendorNameList;
	}
	
	@ModelAttribute("MaterialCategoryIdAndName")
	public Map<String,String> populateMaterialCategory(){
		MaterialServiceConsumer materialConsumer = new MaterialServiceConsumer();
		Map<String, String> materialCategoryIdAndName = materialConsumer.getMaterialCategories();
		return materialCategoryIdAndName;
	}
	
	//write one req handler
	//
	
	@RequestMapping(value="/loadPurchaseEntryPage",method=RequestMethod.GET)
	public ModelAndView loadPurchaseEntryPage() {
		
		ModelAndView modelAndView = new ModelAndView();
		PurchaseEntryBean purchaseEntryBean = new PurchaseEntryBean();
		modelAndView.setViewName("PurchaseEntry");
	
		return modelAndView;
	}
	
	@RequestMapping(value="/getMaterialTypeAndUnit",method=RequestMethod.POST)
	public ModelAndView loadMaterialTypeAndId(@ModelAttribute("purchaseEntryBean")PurchaseEntryBean purchaseEntryBean) {
		ModelAndView modelAndView = new ModelAndView();
		MaterialServiceConsumer materialConsumer = new MaterialServiceConsumer();
		Map<String, String> materialTypeNameAndId = materialConsumer.getMaterialTypeByCategoryId(purchaseEntryBean.getMaterialCategoryId());
		Map<String, String> materialUnitNameAndId = materialConsumer.getMaterialUnitByCategoryId(purchaseEntryBean.getMaterialCategoryId());
		modelAndView.addObject("materialTypeNameAndId", materialTypeNameAndId);
		modelAndView.addObject("materialUnitNameAndId", materialUnitNameAndId);
		modelAndView.setViewName("PurchaseEntry");
		return modelAndView;
	}
	
	@RequestMapping(value="/addPurchaseEntry",method=RequestMethod.POST)
	public ModelAndView addPurchaseEntry(@ModelAttribute("purchaseEntryBean")PurchaseEntryBean purchaseEntryBean) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(purchaseEntryBean);
		modelAndView.addObject("PurchaseEntryBEan",purchaseEntryBean);
		modelAndView.setViewName("PurchaseEntrySuccess");
		return modelAndView;
	}
}
