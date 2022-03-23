package com.farmers.farmazon.Services;

import com.farmers.farmazon.Models.ProductLine;
import com.farmers.farmazon.Repos.ProductLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLineService {

    @Autowired
    ProductLineRepo productLineRepo;

    public List<ProductLine> getProductLines() {
        return (List) productLineRepo.findAll();
    }


    public ProductLine getProductLineById(Integer id) {
        return productLineRepo.findById(id).get();
    }

    public ProductLine createProductLine(ProductLine productLine) {
        return productLineRepo.save(productLine);
    }

    public void deleteById(Integer id) {
        productLineRepo.deleteById(id);
    }
}
