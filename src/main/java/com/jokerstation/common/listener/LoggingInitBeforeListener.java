package com.jokerstation.common.listener;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;

public class LoggingInitBeforeListener implements GenericApplicationListener {

	private static Class<?>[] EVENT_TYPES = {
//			ApplicationStartingEvent.class, 
			ApplicationEnvironmentPreparedEvent.class//,
//			ApplicationPreparedEvent.class, 
//			ContextClosedEvent.class, 
//			ApplicationFailedEvent.class 
	};

	private static Class<?>[] SOURCE_TYPES = {
			SpringApplication.class, 
			ApplicationContext.class
	};
	
	private static Map<String, String> DEFAULT_KV_MAP = new HashMap<String, String>();
	static {
		DEFAULT_KV_MAP.put("log_app_name", "${spring.application.name}");
	}
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationEnvironmentPreparedEvent) {
			System.out.println("== LoggingInitBeforeListener ApplicationEnvironmentPreparedEvent ==");
			try {
				ApplicationEnvironmentPreparedEvent e = (ApplicationEnvironmentPreparedEvent) event;
				
				for (String key : DEFAULT_KV_MAP.keySet()) {
					String value = DEFAULT_KV_MAP.get(key);
					if (e.getEnvironment().containsProperty(key)) {
						value = e.getEnvironment().getProperty(key);
					} else if (value.startsWith("${") && value.endsWith("}")) {
						String paramKey = value.substring(2, value.length() - 1);
						if (e.getEnvironment().containsProperty(paramKey)) {
							value = e.getEnvironment().getProperty(paramKey);
						}
					}
					System.out.println(key + ": " + value);
					System.setProperty(key, value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE + 10;
	}

	@Override
	public boolean supportsEventType(ResolvableType eventType) {
		boolean bool = isAssignableFrom(eventType.getRawClass(), EVENT_TYPES);
//		if (bool) {
//			System.out.println("eventType == " + eventType.getRawClass() + " ==");
//		}
		return bool;
	}

	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		boolean bool =  isAssignableFrom(sourceType, SOURCE_TYPES);
//		if (bool) {
//			System.out.println("sourceType == " + sourceType + " ==");
//		}
		return bool;
	}
	
	private boolean isAssignableFrom(Class<?> type, Class<?>... supportedTypes) {
		if (type != null) {
			for (Class<?> supportedType : supportedTypes) {
				if (supportedType.isAssignableFrom(type)) {
					return true;
				}
			}
		}
		return false;
	}

}
