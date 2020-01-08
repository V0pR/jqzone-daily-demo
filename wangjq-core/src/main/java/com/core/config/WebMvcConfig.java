package com.core.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.xml.transform.Source;
import java.util.List;

/**
 * Created by rocky on 2017/07/20.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    /**
     * 添加MessageConverters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setWriteAcceptCharset(false);
        stringConverter.setSupportedMediaTypes(Lists.newArrayList(MediaType.TEXT_PLAIN, MediaType.TEXT_XML, MediaType.APPLICATION_XML));

        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(stringConverter);
        converters.add(new ResourceHttpMessageConverter());
        converters.add(new SourceHttpMessageConverter<Source>());
        converters.add(new AllEncompassingFormHttpMessageConverter());
        converters.add(new Jaxb2RootElementHttpMessageConverter());

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        // builder.modules(jacksonEbeanModule());
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }

//    @Bean
//    public Module jacksonEbeanModule() {
//        return new JacksonEbeanModule();
//    }

}
