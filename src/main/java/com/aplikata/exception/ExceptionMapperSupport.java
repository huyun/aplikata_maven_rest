package com.aplikata.exception;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.WebApplicationContext;

@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Throwable> {
	private static final Logger LOGGER = Logger.getLogger(ExceptionMapperSupport.class);

	private static final String CONTEXT_ATTRIBUTE = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;

	@Context
	private HttpServletRequest request;

	@Context
	private ServletContext servletContext;

	@Override
	public Response toResponse(Throwable exception) {
		String message = ExceptionCode.INTERNAL_SERVER_ERROR;
		Status statusCode = Status.INTERNAL_SERVER_ERROR;
		WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(CONTEXT_ATTRIBUTE);
		// 处理checked exception
		if (exception instanceof RequiredException) {
			BaseException baseException = (BaseException) exception;
			String code = baseException.getCode();
			String msg = context.getMessage(code, null, LocaleContextHolder.getLocale());
			message = context.getMessage(ExceptionCode.REQUIRED, new Object[]{msg}, exception.getMessage(), request.getLocale());
		} else if (exception instanceof BaseException) {
			BaseException baseException = (BaseException) exception;
			String code = baseException.getCode();

			Object[] args = baseException.getValues();
			message = context.getMessage(code, args, exception.getMessage(), request.getLocale());
		} else if (exception instanceof NotFoundException) {
			message = ExceptionCode.REQUEST_NOT_FOUND;
			statusCode = Status.NOT_FOUND;
		}
		// checked exception和unchecked exception均被记录在日志里
		LOGGER.error(message, exception);
		return Response.ok(message, MediaType.TEXT_PLAIN).status(statusCode).build();
	}

}
