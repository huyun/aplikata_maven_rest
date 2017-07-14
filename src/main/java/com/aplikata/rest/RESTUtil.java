package com.aplikata.rest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.aplikata.Constants;

public class RESTUtil {
	public static String getMsg(MessageSource messageSource, String key){
		return messageSource.getMessage(key, new Object[0], LocaleContextHolder.getLocale());
	}
	
	public static String getMsg(MessageSource messageSource, String key, Object[] objs){
		return messageSource.getMessage(key, objs, LocaleContextHolder.getLocale());
	}
	
	public static String getRequiredMsg(MessageSource messageSource, String key){
		String msg = messageSource.getMessage(key, new Object[0], LocaleContextHolder.getLocale());
		return messageSource.getMessage(Constants.MSG_REQUIED, new Object[]{msg}, LocaleContextHolder.getLocale());
	}
	
	public static String getExistMsg(MessageSource messageSource, String existObjectName){
		return messageSource.getMessage(Constants.MSG_EXIST, new Object[]{existObjectName}, LocaleContextHolder.getLocale());
	}
}
