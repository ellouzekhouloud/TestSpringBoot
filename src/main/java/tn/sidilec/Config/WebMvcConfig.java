package tn.sidilec.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**","/fiche_technique/**")
                .addResourceLocations("file:src/main/resources/static/images/","file:src/main/resources/static/fiche_technique/");
    }
    
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Autorise toutes les URL
                .allowedOrigins("http://localhost:4200") // Autorise Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Autorise ces méthodes
                .allowedHeaders("*") // Autorise tous les headers
                .allowCredentials(true); // Autorise les cookies si besoin
    }
}