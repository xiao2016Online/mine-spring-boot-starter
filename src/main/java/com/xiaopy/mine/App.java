package com.xiaopy.mine;

import com.xiaopy.mine.annotation.MyAOP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaopeiyu
 * @since 2020/11/6
 */
@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @MyAOP(name = "hemaolin",value = "222")
    @GetMapping("/test")
    public String test(){
        return "hell0";
    }
}
