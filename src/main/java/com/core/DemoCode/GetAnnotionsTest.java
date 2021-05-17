package com.core.DemoCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@Component
@Slf4j
public class GetAnnotionsTest implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("我被初始化了.......");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("哈哈哈哈哈吗，我来了");
        Map<String, Object> annotation = applicationContext.getBeansWithAnnotation(RestController.class);
        Collection<Object> values = annotation.values();
        for (Object o : values) {
            Class<?> controllerClazz = o.getClass();
            AnnotationUtils.findAnnotation(controllerClazz, RestController.class);
           // AnnotationUtils.findAnnotation();
        }
        for (Map.Entry<String, Object> entry : annotation.entrySet()) {
            System.err.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
