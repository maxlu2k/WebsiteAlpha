package com.app.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlphaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaApplication.class, args);
        String a = "abc";
        String b = "";
        if(a == b){
            System.out.println("a bằng b");
        }else{
            System.out.println("a khác b");
        }
    }

}
