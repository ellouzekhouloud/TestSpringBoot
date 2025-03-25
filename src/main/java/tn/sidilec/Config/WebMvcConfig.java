package tn.sidilec.Config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**","/fiche_technique/**")
                .addResourceLocations("file:src/main/resources/static/images/","file:src/main/resources/static/fiche_technique/");
    }
    
    
    
}