package com.example.ll.batch_app;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//배치 프로그램을 돌림
@EnableBatchProcessing
public class BatchAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchAppApplication.class, args);
    }

}
