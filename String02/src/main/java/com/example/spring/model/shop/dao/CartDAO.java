package com.example.spring.model.shop.dao;

import java.util.List;

import com.example.spring.model.shop.dto.CartDTO;

public interface CartDAO {
	public List<CartDTO> cartMoeny(); // 장바구니 차트 출력 관련
	public void insert(CartDTO dto); //장바구니 상품 저장
	public List<CartDTO> listCart(String userid); //장바구니 상품 리스트 보기
	public void delete(int cart_id); // 장바구니 개별 상품 삭제
	public void deleteAll(String userid); //장바구니 전체 지우기
	public int sumMoney(String userid); //장바구니 상품 합계 금액처리
	public void modifyCart(CartDTO dto); //장바구니 개별 상품 수량 수정
	

}
