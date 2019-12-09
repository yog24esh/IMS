package com.accenture.ims.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.ims.business.bean.DateRangeBean;
import com.accenture.ims.business.bean.LoginBean;
import com.accenture.ims.business.bean.PurchaseEntryBean;
import com.accenture.ims.service.ReportByDateService;

@Controller
public class ReportController {

	@Autowired
	private ReportByDateService reportByDateService;

	@RequestMapping(value = "/getDateRangeBean", method = RequestMethod.GET)
	public ModelAndView getDateRangeBean() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PurchaseEntryDetailsByDate");
		modelAndView.addObject("dateRangeBean", new DateRangeBean());
		return modelAndView;
	}

	@RequestMapping(value = "/submitDateRangeBean", method = RequestMethod.POST)
	public ModelAndView getDetailsByDate(@Valid @ModelAttribute("dateRangeBean") DateRangeBean dateRangeBean,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		/*
		 * System.out.println("========\nRunning Submit Date Range BEan\n======");
		 * List<PurchaseEntryBean> purchaseEntryBeanList = new
		 * ArrayList<PurchaseEntryBean>(); purchaseEntryBeanList =
		 * reportByDateService.getDetailsByDate(dateRangeBean.getFromDate(),
		 * dateRangeBean.getToDate());
		 * modelAndView.setViewName("PurchaseEntryDetailsByDate");
		 * modelAndView.addObject("purchaseEntryBeanList", purchaseEntryBeanList);
		 * System.out.println("\n" + purchaseEntryBeanList); return modelAndView;
		 */

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("PurchaseEntryDetailsByDate");
			return modelAndView;

		} else {
			List<PurchaseEntryBean> purchaseEntryBeanList = new ArrayList<PurchaseEntryBean>();
			purchaseEntryBeanList = reportByDateService.getDetailsByDate(dateRangeBean.getFromDate(),
					dateRangeBean.getToDate());
			modelAndView.setViewName("PurchaseEntryDetailsByDate");
			modelAndView.addObject("purchaseEntryBeanList", purchaseEntryBeanList);
			return modelAndView;
		}
	}

}
