package com.example.spring.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring.model.shop.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Inject
	SqlSession sqlsession;
	
	@Override
	public List<CartDTO> cartMoeny() {
		
		return null;
	}

	@Override
	public void insert(CartDTO dto) {
		sqlsession.insert("cart.insert", dto);

	}

	@Override
	public List<CartDTO> listCart(String userid) {
		
		return sqlsession.selectList("cart.listCart", userid);
	}

	@Override
	public void delete(int cart_id) {
		sqlsession.delete("cart.delete", cart_id);

	}

	@Override
	public void deleteAll(String userid) {
		sqlsession.delete("cart.deleteAll", userid);

	}

	@Override
	public int sumMoney(String userid) {
			
		return sqlsession.selectOne("cart.sumMoney", userid);
	}

	@Override
	public void modifyCart(CartDTO dto) {
		sqlsession.update("cart.modifyCart", dto);

	}

}
