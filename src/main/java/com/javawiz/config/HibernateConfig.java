package com.javawiz.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class HibernateConfig {

   @Value("${hibernate.show_sql}")
   private String show_sql;
   
   @Value("${hibernate.hbm2ddl.auto}")
   private String hbm2ddl;
   
   @Autowired
   private DataSource dataSource;

   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      factoryBean.setDataSource(dataSource);
      
      Properties props=new Properties();
      props.put("hibernate.show_sql", show_sql);
      props.put("hibernate.hbm2ddl.auto", hbm2ddl);
      
      factoryBean.setPackagesToScan("com.javawiz.entity");
      factoryBean.setHibernateProperties(props);
      return factoryBean;
   }

   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }
}