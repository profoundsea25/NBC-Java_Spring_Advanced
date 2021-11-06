package com.sparta.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProductRepository productRepository() {
        String dbId = "sa";
        String dbPassword = "";
        String dbUrl = "jdbc:h2:mem:springcoredb";
        return new ProductRepository(dbId, dbPassword, dbUrl);
    }

    @Bean // 객체 등록
    @Autowired // Bean으로 선언된 객체를 의존성 주입(DI) = 만들어진 객체를 활용
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}