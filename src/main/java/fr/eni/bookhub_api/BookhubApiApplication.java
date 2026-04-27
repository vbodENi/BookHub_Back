package fr.eni.bookhub_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BookhubApiApplication {

    public static void main(String[] args)
    {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(encoder.encode("pwd123"));
//        }

        SpringApplication.run(BookhubApiApplication.class, args);
    }
}
