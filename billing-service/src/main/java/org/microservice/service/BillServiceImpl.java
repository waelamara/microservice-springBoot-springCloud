package org.microservice.service;

import java.util.Collection;

import org.microservice.dao.BillRepository;
import org.microservice.entities.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    BillRepository billRepository;
    @Autowired
    IUserService iUserService;
    @Autowired
    IProductService iProductService;

    @Override
    public Collection<Bill> findAll() {
        Collection<Bill> bill = billRepository.findAll();
        for (Bill b : bill) {
            b.setUser(iUserService.findUserById(b.getUserId()));
            b.getProductItems().forEach(p -> p.setProduct(iProductService.findProductById(p.getProductId())));
        }
        return bill;
    }

    @Override
    public Bill findById(Long id) {
        return billRepository.getOne(id);
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public void removeByid(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public Bill UpdateProduit(Bill bill) {
        return billRepository.save(bill);
    }


}
