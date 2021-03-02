package org.microservice.controller;

import java.util.Collection;

import org.microservice.entities.Bill;
import org.microservice.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

    @Autowired
    IBillService iBillService;

    @GetMapping("/bills")
    public Collection<Bill> findAll() {
        return iBillService.findAll();
    }

    @PostMapping("/addBill")
    public Bill AddBill(@RequestBody Bill bill) {
        return iBillService.save(bill);
    }

    @DeleteMapping("/deleteBill/{id}")
    public void deleteBill(@PathVariable(name = "id") Long id) {
        iBillService.removeByid(id);
    }
}
