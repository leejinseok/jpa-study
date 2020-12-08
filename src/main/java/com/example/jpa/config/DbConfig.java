package com.example.jpa.config;

import com.example.jpa.config.property.JpaProperties;
import com.example.jpa.repository.MemberRepository;
import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    basePackageClasses = {MemberRepository.class}
)
@EnableTransactionManagement
public class DbConfig {

    @Autowired
    JpaProperties jpaProperties2;

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory);
        return tm;
    }

    @Bean(name = "entityManagerFactoryBuilder")
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), jpaProperties(), null);
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder, DataSource dataSource) {
        return entityManagerFactoryBuilder
            .dataSource(dataSource)
            .packages(MemberRepository.class)
            .persistenceUnit("jpa-study")
            .build();
    }

    Map<String, Object> jpaProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "1111");
        properties.put("javax.persistence.jdbc.url","jdbc:mysql://localhost/jpa-study?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&tinyInt1isBit=false");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comments", "true");
        properties.put("hibernate.id.new_generator_mappings", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        return properties;
    }

}
