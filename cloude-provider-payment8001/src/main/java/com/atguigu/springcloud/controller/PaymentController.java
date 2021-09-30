package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommentResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("插入结果"+result);


        if(result>0){
            return new CommentResult(200,"插入数据成功",result);
        }else {
            return new CommentResult(444,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id")Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("插入结果"+payment);
        if(payment!=null){
            return new CommentResult(200,"查询结果成功",payment);
        }else {
            return new CommentResult(444,"查询失败",null);
        }
    }
}
