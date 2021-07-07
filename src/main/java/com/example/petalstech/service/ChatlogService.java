package com.example.petalstech.service;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.petalstech.model.Chatlog;
import com.example.petalstech.repository.ChatLogRepository;

@Service
@Transactional
public class ChatlogService 
{
	@Autowired
	ChatLogRepository chatLogRepository; // using bean of repository we can use JPA different methods


	// will return the entries in limit from start by reverse sorting according to timeStamp
	public List<Chatlog> getChatLogUser(String user, int limit, int page)
	{
		//List<Chatlog> chatlogs = new ArrayList<Chatlog>();
		
		//chatLogRepository.findFirst10ByUserOrderByTimeStampDesc(user).forEach(chatlog -> chatlogs.add(chatlog));
		
		Pageable paging = PageRequest.of(page, limit, Sort.by("timeStamp").descending());
		 
        Page<Chatlog> pagedResult = chatLogRepository.findByUser(user, paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Chatlog>();
        }
		
		//return chatlogs;
	}
	
	public Chatlog save(Chatlog chatlog)
	{
		return chatLogRepository.save(chatlog);
	}// using save method provided by JPA repo
	
	public void deleteByUser(String user)
	{ 
		chatLogRepository.deleteAllByUser(user);
	} // using deleteAllByUser (JPAmethod)
	
	public void delete(Long msgId) {
		chatLogRepository.deleteById(msgId);
//		return chatLogRepository.findById(msgId)
//				.map(customer->{
//					customerRepository.delete(customer);
//					return ResponseEntity.ok().build();
//				});

	}
}
