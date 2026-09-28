package com.fraudwatch.service;

import com.fraudwatch.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FraudService {

    public List<Transaction> list = new ArrayList<>();

    public void add(Transaction t) {

        if (t.getAmount() > 10000) {
            t.setStatus("FLAGGED");
        } else {
            t.setStatus("NORMAL");
        }

        list.add(t);
    }
}