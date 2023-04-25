package com.example.myOwnWebApp.service;

import com.example.myOwnWebApp.model.User;
import com.example.myOwnWebApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

//    List<Product> productList = null;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostConstruct
//    public void loadProductsFromDB() {
//        productList = IntStream.rangeClosed(1, 100)
//                .mapToObj(i -> Product.builder()
//                        .productId(i)
//                        .name("product " + i)
//                        .qty(new Random().nextInt(10))
//                        .price(new Random().nextInt(5000)).build()
//                ).collect(Collectors.toList());
//    }


//    public List<Product> getProducts() {
//        return productList;
//    }

//    public Product getProduct(int id) {
//        return productList.stream()
//                .filter(product -> product.getProductId() == id)
//                .findAny()
//                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
//    }


//    public String addUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepo.save(new User(user.getUsername(), user.getEmail(), user.getPassword()));
//        return "user added to system ";
//    }
}