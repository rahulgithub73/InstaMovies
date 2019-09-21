package org.cod.config;

import java.util.Collections;

import org.cod.client.TrainClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
public class AppConfig implements WebMvcConfigurer {

	@Value("${base.file.path}")
	private String baseFilePath;

	@Bean("messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:locale/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	/*@Bean
	public FilterRegistrationBean<LoginFilter> corsFilterRegistration() {
		FilterRegistrationBean<LoginFilter> filterRegistrationBean = new FilterRegistrationBean<>(loginFilter());

		List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/paginationIndex/*");
		urlPatterns.add("/paginationMovies/*");
		urlPatterns.add("/paginationSeries/*");
		urlPatterns.add("/paginationMusic/*");
		urlPatterns.add("/paginationBooks/*");
		urlPatterns.add("/movieDetailPage/*");
		urlPatterns.add("/subSeries/*");
		urlPatterns.add("/seriesDetailPage/*");
		urlPatterns.add("/musicDetailPage/*");
		urlPatterns.add("/trainRunningInfo/*");
		urlPatterns.add("/trainTimeTable/*");

		filterRegistrationBean.setUrlPatterns(urlPatterns);

		return filterRegistrationBean;
	}*/

/*	@Bean
	public LoginFilter loginFilter() {
		return new LoginFilter();
	}*/

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		return localeResolver;
	}

	@Bean
	public TrainClient getTrainClient() {
		return new TrainClient();
	}

	@Bean(name = "restTemplate")
	public RestTemplate getRestClient() {
		RestTemplate restClient = new RestTemplate(
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

		// Add one interceptor like in your example, except using anonymous class.
		restClient.setInterceptors(Collections.singletonList((request, body, execution) -> {

			return execution.execute(request, body);
		}));

		return restClient;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**").addResourceLocations("file:///" + baseFilePath);
	}
}
