package com.youtube.javabrains.advance_JAX_RS.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.youtube.javabrains.advance_JAX_RS.model.MyDate;

@Provider
public class MyDateCoverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		if (rawType.getName().equals(MyDate.class.getName())) {
			//send back the param convertor
			return (ParamConverter<T>) new MyDateConvertor();
		}
		return null;
	}
}
