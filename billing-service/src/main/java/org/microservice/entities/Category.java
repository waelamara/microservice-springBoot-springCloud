package org.microservice.entities;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;

@Data
public class Category {
    private String id;
    private String name;
    private Collection<Product> products = new ArrayList<>();
}
