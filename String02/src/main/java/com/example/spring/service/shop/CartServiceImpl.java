package com.example.spring.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring.model.shop.dao.CartDAO;
import com.example.spring.model.shop.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {
	
	@Inject
	CartDAO cartDao;

	@Override
	public List<CartDTO> cartMoeny() {
		
		return null;
	}

	@Override
	public void insert(CartDTO dto) {
		cartDao.insert(dto);

	}

	@Override
	public List<CartDTO> listCart(String userid) {
		
		return cartDao.listCart(userid);
	}

	@Override
	public void delete(int cart_id) {
		cartDao.delete(cart_id);

	}

	@Override
	public void deleteAll(String userid) {
		cartDao.deleteAll(userid);
		

	}

	@Override
	public int sumMoney(String userid) {
		
		return cartDao.sumMoney(userid);
	}

	@Override
	public void modifyCart(CartDTO dto) {
		cartDao.modifyCart(dto);
		

	}

}
