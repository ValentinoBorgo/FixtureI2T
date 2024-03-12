package com.example.Fixture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FixtureApplication {

	public static void main(String[] args) {
		System.out.println("En funcionamiento");
		SpringApplication.run(FixtureApplication.class, args);
	}
        
        @Bean
        public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
            @Override
		public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
                    //we can provide other routes, further than the "/**".
			registry.addMapping("/**")
                                .allowedOrigins("http://localhost:4200")
                                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                                .allowedHeaders("Authorization","Content-Type","X-Requested-With")
                                .allowCredentials(true);
		}
	};
}

}
