package com.fraudwatch.controller;

import com.fraudwatch.model.Transaction;
import com.fraudwatch.service.FraudService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class ApiController {

    private final FraudService service;

    public ApiController(FraudService service){
        this.service = service;
    }

    @GetMapping
    public List<Transaction> getAll(){
        return service.list;
    }

    @PostMapping
    public String add(@RequestBody Transaction t){
        service.add(t);
        return "Transaction Added Successfully";
    }
}