//package com.mikotech.Reciept.Generator.controller;
//
//import com.mikotech.OkinBead.service.ProductService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/home")
////@RequiredArgsConstructor
//public class OpenEndpointsController {
//    private final ProductService productService;
//
//    public OpenEndpointsController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/getProducts")
//    public ResponseEntity<?> getProducts(){
//        var response = productService.getAllProduct();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//}
