package com.farmers.farmazon.Controllers;


import com.farmers.farmazon.Models.*;
import com.farmers.farmazon.Services.ProductLineService;
import com.farmers.farmazon.Services.ProductService;
import com.farmers.farmazon.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class ProductLineController {

  @Autowired
  ProductLineService productLineService;

  @Autowired
  ProductService productService;

  @Autowired
  UserService userService;

  @GetMapping("/productlines")
  public Iterable<ProductLine> getProductLines(){
    return productLineService.getProductLines();
  }

  @PostMapping("/product/{productId}/newlinetocart")
  public ProductLine post(@RequestBody ProductLineBody productLineBody, @PathVariable Integer productId){
    Integer userId = productLineBody.getUserId();
    Integer quantity = productLineBody.getQuantity();
    String newProductLineName = productLineBody.getName();

    User tempUser = userService.getUserById(userId);
    Product tempProduct = productService.getProductById(productId);
    Cart tempCart = tempUser.getCart();

    String productName = tempProduct.getName();

    List<ProductLine> productLines = productLineService.getProductLines();


    Optional<ProductLine> existingProductLine = productLines.stream()
            .filter(line -> ((Objects.equals(line.getProductId(), productId)) && (Objects.equals(line.getUserId(), userId)) && (line.getInCart())))
            .findFirst();


    if(existingProductLine.isPresent()) {
      Integer totalQuantity = existingProductLine.get().getQuantity() + quantity;
      existingProductLine.get().setQuantity(totalQuantity);
      existingProductLine.get().setTotalPrice();
      return productLineService.createProductLine(existingProductLine.get());
    }


    ProductLine newProductLine = new ProductLine();
    newProductLine.setQuantity(quantity);
    newProductLine.setProduct(tempProduct);
    newProductLine.setUser(userService.getUserById(userId));
    newProductLine.setInCart(true);
    newProductLine.setCart(tempCart);
    newProductLine.setTotalPrice();
    return productLineService.createProductLine(newProductLine);

  }

  @DeleteMapping("/deleteproductlinebyid/{productLineId}")
  public void deleteProductLine(@PathVariable Integer productLineId){
    productLineService.deleteById(productLineId);
  }


}
