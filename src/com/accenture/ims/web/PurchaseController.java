package com.accenture.ims.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public PurchaseEntryBean setUpPurchaseEntryForm() {
		return new PurchaseEntryBean();
	}

	@ModelAttribute("VendorNamesList")
	public List<String> populateVendorNames() throws Exception {
		List<String> vendorNameList = VendorServiceConsumer.listVendorName();
		return vendorNameList;
	}

	@ModelAttribute("MaterialCategoryIdAndName")
	public Map<String, String> populateMaterialCategory() {
		MaterialServiceConsumer materialConsumer = new MaterialServiceConsumer();
		Map<String, String> materialCategoryIdAndName = materialConsumer.getMaterialCategories();
		return materialCategoryIdAndName;
	}

	@RequestMapping(value = "/loadPurchaseEntryPage", method = RequestMethod.GET)
	public ModelAndView loadPurchaseEntryPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PurchaseEntry");

		return modelAndView;
	}

	@RequestMapping(value = "/getMaterialTypeAndUnit", method = RequestMethod.POST)
	public ModelAndView loadMaterialTypeAndId(
			@ModelAttribute("purchaseEntryBean") PurchaseEntryBean purchaseEntryBean) {
		ModelAndView modelAndView = new ModelAndView();
		MaterialServiceConsumer materialConsumer = new MaterialServiceConsumer();
		Map<String, String> materialTypeNameAndId = materialConsumer
				.getMaterialTypeByCategoryId(purchaseEntryBean.getMaterialCategoryId());
		Map<String, String> materialUnitNameAndId = materialConsumer
				.getMaterialUnitByCategoryId(purchaseEntryBean.getMaterialCategoryId());
		modelAndView.addObject("materialTypeNameAndId", materialTypeNameAndId);
		modelAndView.addObject("materialUnitNameAndId", materialUnitNameAndId);
		modelAndView.setViewName("PurchaseEntry");
		return modelAndView;
	}

	@RequestMapping(value = "/addPurchaseEntry", method = RequestMethod.POST)
	public ModelAndView addPurchaseEntry(
			@Valid @ModelAttribute("purchaseEntryBean") PurchaseEntryBean purchaseEntryBean,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("PurchaseEntry");
			return modelAndView;
		} else {
			PurchaseEntryBean beanWithTransactionId = service.save(purchaseEntryBean);
			modelAndView.addObject("purchaseEntryBeanWithTransactionId", beanWithTransactionId);
			modelAndView.setViewName("PurchaseEntrySuccess");
			return modelAndView;
		}

	}

}
