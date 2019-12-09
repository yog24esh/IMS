package com.accenture.ims.business.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class DateRangeBean {

	@NotNull(message="Date Cannot be Empty")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date fromDate;

	@NotNull(message="Date Cannot be Empty")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
   private Date toDate;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public DateRangeBean() {
		super();
	}

	@Override
	public String toString() {
		return "DateRangeBean [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

}
