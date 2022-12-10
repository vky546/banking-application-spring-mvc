package com.xoriant.bankingapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.xoriant.bankingapplication.interceptor.DayOfWeekBasedAccessInterceptor;

/*
 * web configuration like view resolver and resource handler
 */

@Configuration
@ComponentScan
@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter {
	@Bean
	DayOfWeekBasedAccessInterceptor demoInterceptor() {
		return new DayOfWeekBasedAccessInterceptor();
	}
	public void addInterceptor(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resource/**") // mapping
          .addResourceLocations("/resource/");	// location
    }
	
	@Bean
	public ViewResolver veiwResolver()
	{
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	
}
