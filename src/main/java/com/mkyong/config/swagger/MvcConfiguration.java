package com.mkyong.config.swagger;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

/**
 * 
 * @author Tola
 *	Created Date: 2017/06/27
 */
@Configuration
//@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// Swagger
		registry.addViewController("/swagger").setViewName("/swagger/swagger-ui");
		registry.addViewController("/swagger-ui.html").setViewName("/swagger/swagger-ui");

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		 * Static Resources store in the project
		 */
		registry.addResourceHandler("/resources/**")
					.addResourceLocations("classpath:/static/");
		/*
		 * Static Resources store outside the project
		 */
		registry.addResourceHandler("/files/**")
					.addResourceLocations("file:/opt/FILES_MANAGEMENT/images/");
	}
	
	
	
	/*
	 * Internalization i18n
	 */
	
	/*
	 * In order for our application to be able to determine which locale is
	 * currently being used, we need to add a LocaleResolver bean:
	 */
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("kh"));
		resolver.setCookieName("Spring_Locale");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}

	/*
	 * Next, we need to add an interceptor bean that will switch to a new locale
	 * based on the value of the lang parameter appended to a request:
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	/*
	 * In order to take effect, this bean needs to be added to the application’s
	 * interceptor registry.
	 *
	 * To achieve this, our @Configuration class has to extend the
	 * WebMvcConfigurerAdapter class and override the addInterceptors() method:
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	/*
	 * Defining the Message Sources
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/i18n/messages/message");
		messageSource.setCacheSeconds(0);
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	
}
