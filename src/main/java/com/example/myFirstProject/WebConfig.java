//package com.example.myFirstProject;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
//import org.springframework.web.servlet.view.tiles3.TilesView;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration
//public class WebConfig {
//	
//	@Bean
//	public UrlBasedViewResolver tilesViewResolver()
//	{
//		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
//		tilesViewResolver.setViewClass(TilesView.class);
//		return tilesViewResolver;
//	}
//	
//	
//	@Bean
//	public TilesConfigurer tilesConfigurer() {
//		TilesConfigurer tconf = new TilesConfigurer();
//		tconf.setDefinitions(new String[] { "/WEB-INF/tiles/tiles.xml" });
//		return tconf;
//	}
//	
//	@Bean
//	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter()
//	{
//
//		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		jsonConverter.setObjectMapper(objectMapper);
//		return jsonConverter;
//
//	}
//	
//	
//}
