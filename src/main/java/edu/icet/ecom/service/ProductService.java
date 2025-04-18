package edu.icet.ecom.service;

import edu.icet.ecom.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//@Component
@Service

public class ProductService {
    @Autowired
    RestTemplate restTemplate;

    ModelMapper modelMapper;

    public List<Product> getProducts(String category) {
        Product[] response = restTemplate.getForObject("https://fakestoreapi.com/products", Product[].class);

        return Arrays.stream(response).filter(product ->
                category.equalsIgnoreCase(product.getCategory())).toList();
    }

    public void createProduct(Product product) {

    }
}
