package org.microservice.service;

import java.util.Collection;

import org.microservice.entities.Bill;



public interface IBillService {
	public Collection<Bill> findAll();
	public Bill findById(Long id);
	public Bill save(Bill bill);
	public void removeByid(Long id);
	public Bill UpdateProduit(Bill bill);
}
