package com.macys.common.pricing.services.pricechangecalculator.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dozer.DozerConverter;

public class StringToTimestampFieldConverter extends DozerConverter<String, Date> {

	public StringToTimestampFieldConverter() {
		super(String.class, Date.class);
	}

	@Override
	public Date convertTo(String source, Date destination) {

		Date dateTimeStamp = null;
		if (null != source) {
			String dateRegex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";

			SimpleDateFormat dateFormat = null;
			Date date;
			if (source.matches(dateRegex)) {
				dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			} else {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS");
			}
			try {
				date = dateFormat.parse(source);
				dateTimeStamp = new Date(date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dateTimeStamp;
	}

	@Override
	public String convertFrom(Date source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
