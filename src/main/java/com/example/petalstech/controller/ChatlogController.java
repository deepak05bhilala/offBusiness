package com.example.petalstech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.petalstech.model.Chatlog;
import com.example.petalstech.service.ChatlogService;

@RestController
public class ChatlogController 
{
	@Autowired
	ChatlogService chatlogService;
	
	@PostMapping("/chatlogs/{user}") //post method  saving chatlogs in database
	public Long saveChatlog(@PathVariable("user") String user, @RequestBody Chatlog chatlog) //requesting json body
	{
		Chatlog ch = chatlogService.save(chatlog);
		return ch.getMsgId();
	}
	
	@GetMapping("/chatlogs/{user}")
	public List<Chatlog> getChatlogs(@PathVariable("user") String user,       // getting chatlogs of user of last N rows according by timestamp
			@RequestParam(defaultValue = "10", name = "limit") Integer limit, // taking default limits and page whitch we
			@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return chatlogService.getChatLogUser(user, limit, page); //
	}
	
	@DeleteMapping("/chatlogs/{user}") // Deleting all the entries of a particular user
	public ResponseEntity<HttpStatus> deleteAllChatlog(@PathVariable("user") String user) {
	//public void deleteAllChatlog(@PathVariable("user") String user) {

		try {
			chatlogService.deleteByUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {  // handling the exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//chatlogService.deleteByUser(user);
	}
	
	@DeleteMapping("/chatlogs/user/{msgId}") // delete entries of particular message id
	public ResponseEntity<HttpStatus> deleteChatlog(@PathVariable("msgId") Long msgId) {
	//public void deleteChatlog(@PathVariable("msgId") Long msgId) {
		//chatlogService.delete(msgId);
		try {
			chatlogService.delete(msgId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
