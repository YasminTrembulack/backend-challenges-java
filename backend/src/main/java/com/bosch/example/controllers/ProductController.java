package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.JWTService;
import com.bosch.example.dto.JWTUserData;
import com.bosch.example.dto.ProductData;
import com.bosch.example.model.Product;
import com.bosch.example.model.User;
import com.bosch.example.services.ProductService;
import com.bosch.example.services.UserService;

@RestController
public class ProductController {
    
    @Autowired
    JWTService<JWTUserData> jwt;

    @Autowired
    ProductService repoProduct;

    @Autowired
    UserService repoUser;
    
    @PostMapping("product")
    public ResponseEntity<String> postMethodName(
        @RequestBody ProductData product){
        
        
        var data = jwt.validate(product.token());
        if (data == null)
            return ResponseEntity.status(401).build();

        Integer id = (Integer) data.get("id");
        User user = repoUser.getOne(Long.valueOf(id));

        
        if (!user.getEmail().contains("@loja.com")) {
            return ResponseEntity.status(403).build();
        }
        
        System.out.println(data.get("id"));

        Product pro = new Product();
        pro.setTitle(product.title());
        pro.setValue(product.value());

        repoProduct.save(pro);
        
        return ResponseEntity.ok().build();
    }
}
