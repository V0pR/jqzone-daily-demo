package com.core.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
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
//        stringConverter.setWriteAcceptCharset(false);
        ArrayList<MediaType> mediaTypes = Lists.newArrayList(MediaType.TEXT_PLAIN, MediaType.TEXT_XML, MediaType.APPLICATION_XML);
        stringConverter.setSupportedMediaTypes(mediaTypes);
//
//        converters.add(new ByteArrayHttpMessageConverter());
//        converters.add(stringConverter);
//        converters.add(new ResourceHttpMessageConverter());
//        converters.add(new SourceHttpMessageConverter<Source>());
//        converters.add(new AllEncompassingFormHttpMessageConverter());
//        converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(fastJsonHttpMessageConverter());
    }


    /**
     * 草 终于解决了返回 String 转 object 的问题！！！！
     *
     * @return
     */
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        // 1、需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //2-1 处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);

        //3、在convert中添加配置信息.
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return fastConverter;
    }

//    @Bean
//    public GsonHttpMessageConverter gsonJsonHttpMessageConverter() {
//        // 使用Gson
//        return new GsonHttpMessageConverter();// Gson转换json的Converter
//    }


}
