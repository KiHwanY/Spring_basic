package com.example.spring.service.message;

import com.example.spring.model.message.dto.MessageDTO;

public interface MessageService {
	public void addMessage(MessageDTO dto);
	public MessageDTO readMessage(String userid, int mid);

}
