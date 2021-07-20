package com.youtube.javabrains.advance_JAX_RS.converter;

import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;

import com.youtube.javabrains.advance_JAX_RS.model.MyDate;

public class MyDateConvertor implements ParamConverter<MyDate> {

	@Override
	public MyDate fromString(String value) {
		Calendar calendar = Calendar.getInstance();
		if ("tomorrow".equalsIgnoreCase(value)) {
			calendar.add(Calendar.DATE, 1);
		} else if ("yesterday".equalsIgnoreCase(value)) {
			calendar.add(Calendar.DATE, -1);
		}
		MyDate myDate = new MyDate();
		myDate.setDate(calendar.get(Calendar.DATE));
		myDate.setMonth(calendar.get(Calendar.MONTH));
		myDate.setYear(calendar.get(Calendar.YEAR));
		return myDate;
	}

	@Override
	public String toString(MyDate myBean) {
		if (myBean == null) {
			return null;
		}
		return myBean.toString();
	}
}
