package com.honeywell.intelligrated.wes.annotation.rest;

import com.honeywell.intelligrated.wes.annotation.annotation.MyAnnotation;
import com.honeywell.intelligrated.wes.annotation.business.MyService1;
import com.honeywell.intelligrated.wes.annotation.business.MyService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class MyController {

    @Autowired
    private MyService1 myService1;

    @Autowired
    private MyService2 myService2;

    @GetMapping("/service1/method1")
    @MyAnnotation
    public @ResponseBody ServiceResponse service1Method1(@RequestParam String input1, @RequestParam int input2) {
        myService1.method1(input1, input2);
        return new ServiceResponse("Executed service1Method1");
    }

    @GetMapping("/service1/method2")
    public String service1Method2(@RequestParam int input1, @RequestParam boolean input2) {
        myService1.method2(input1, input2);
        return "Executed service1Method2";
    }

    @GetMapping("/service1/method3")
    public String service1Method3(@RequestParam boolean input1, @RequestParam double input2) {
        myService1.method3(input1, input2);
        return "Executed service1Method3";
    }

    @GetMapping("/service2/method1")
    public String service2Method1(@RequestParam String input1, @RequestParam int input2) {
        myService2.method1(input1, input2);
        return "Executed service2Method1";
    }

    @GetMapping("/service2/method2")
    public String service2Method2(@RequestParam int input1, @RequestParam boolean input2) {
        myService2.method2(input1, input2);
        return "Executed service2Method2";
    }

    @GetMapping("/service2/method3")
    public String service2Method3(@RequestParam boolean input1, @RequestParam double input2) {
        myService2.method3(input1, input2);
        return "Executed service2Method3";
    }
}