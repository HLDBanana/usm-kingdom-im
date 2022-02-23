//package com.powernow.usm.config;
//
//import com.alibaba.fastjson.serializer.SerializeConfig;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.serializer.ToStringSerializer;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Configuration
//public class HttpConverterConfig {
//
//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters() {
//
//		// 1.定义一个converters转换消息的对象
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//		// 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setCharset(java.nio.charset.Charset.forName("UTF-8"));
//		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//		fastJsonConfig.setSerializerFeatures(
//				SerializerFeature.DisableCircularReferenceDetect,
//				SerializerFeature.WriteEnumUsingName,
//				SerializerFeature.PrettyFormat,
//				SerializerFeature.WriteNullListAsEmpty,
//				SerializerFeature.WriteMapNullValue,
//				SerializerFeature.WriteNullStringAsEmpty, // 字符串null返回空字符串
//				SerializerFeature.WriteNullBooleanAsFalse,
//				SerializerFeature.WriteDateUseDateFormat,
//				SerializerFeature.SortField);
//		// 3.在converter中添加配置信息
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//		SerializeConfig serializeConfig = SerializeConfig.globalInstance;
//		serializeConfig.put(Long.class , ToStringSerializer.instance);
//		serializeConfig.put(Long.TYPE , ToStringSerializer.instance);
//		//处理LocalDateTime类型日期
//		serializeConfig.put(LocalDateTime.class, LocalDateTimeSerializer.instance);
//		//处理LocalDate类型日期
//		serializeConfig.put(LocalDate.class, LocalDateSerializer.instance);
//		//处理Date类型日期
//		serializeConfig.put(Date.class, DateSerializer.instance);
//		fastJsonConfig.setSerializeConfig(serializeConfig);
//		List<MediaType> supportedMediaTypes = new ArrayList<>();
//		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
//		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//		supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
//		supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
//		supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//		supportedMediaTypes.add(MediaType.APPLICATION_PDF);
//		supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
//		supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
//		supportedMediaTypes.add(MediaType.APPLICATION_XML);
//		supportedMediaTypes.add(MediaType.IMAGE_GIF);
//		supportedMediaTypes.add(MediaType.IMAGE_JPEG);
//		supportedMediaTypes.add(MediaType.IMAGE_PNG);
//		supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
//		supportedMediaTypes.add(MediaType.TEXT_HTML);
//		supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
//		supportedMediaTypes.add(MediaType.TEXT_PLAIN);
//		supportedMediaTypes.add(MediaType.TEXT_XML);
//		fastConverter.setSupportedMediaTypes(supportedMediaTypes);
//		// 4.将converter赋值给HttpMessageConverter
//		HttpMessageConverter<?> converter = fastConverter;
//		// 5.返回HttpMessageConverters对象
//		return new HttpMessageConverters(converter);
//	}
//
//}