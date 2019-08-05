package com.javawiz;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javawiz.config.AppConfig;
import com.javawiz.entity.User;
import com.javawiz.service.UserService;

public class SpringApplication {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      // Add Users
      userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
      userService.add(new User("David", "Miller", "david.miller@example.com"));
      userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
      userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

      // Get Users
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}