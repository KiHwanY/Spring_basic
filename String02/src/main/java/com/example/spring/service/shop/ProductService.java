package com.example.spring.service.shop;

import java.util.List;

import com.example.spring.model.shop.dto.ProductDTO;

public interface ProductService {
	
	List<ProductDTO> listProduct();
	ProductDTO detailProduct(int product_id);
	void updateProduct(ProductDTO dto);
	void deleteProduct(int product_id);
	void insertProduct(ProductDTO dto);
	String fileInfo(int product_id);
}
