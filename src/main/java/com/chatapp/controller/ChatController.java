package com.chatapp.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.entity.Message;
import com.chatapp.entity.Room;
import com.chatapp.repository.Roomrepository;
import com.chatapp.reqeust.MessageRequest;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "${frontend.origin}")
public class ChatController {

	@Autowired
	private Roomrepository repo;

	
	@PostMapping(value = "/rooms", consumes = "text/plain")
	public ResponseEntity<?> createRoom(@RequestBody String roomid){
		if(repo.findByRoomid(roomid)!= null) {
			return ResponseEntity.badRequest().body("Room Already Exist!");
		}else {
			Room room = new Room();
			room.setRoomid(roomid);
			Room data = repo.save(room);
		return ResponseEntity.status(HttpStatus.CREATED).body(room);
		}
	}
	
	@GetMapping("/join/{roomid}")
	public ResponseEntity<?> joinRoom(@PathVariable String roomid){
		Room room = repo.findByRoomid(roomid);
		if(room == null) {
			return ResponseEntity.badRequest().body("Room not found!");
		}else {
			return ResponseEntity.ok(room);
		}
	}
	

	@GetMapping("/{roomid}/message")
	public ResponseEntity<List<Message>> getMEssage(@PathVariable String roomid){
		Room status = repo.findByRoomid(roomid);
		if(status == null)
		{
			return ResponseEntity.badRequest().build();
			}else {
				List<Message> messages = status.getMessages();
				return ResponseEntity.ok(messages);
			}
		}
	
	
	@PutMapping("/update")
	public Message sendMessage( @RequestBody MessageRequest request ) {
		Room status = repo.findByRoomid(request.getRoomid());
		
			
		
		Message data = new Message();
		data.setContent(request.getContent());
		data.setSender(request.getSender());
		data.setTimestamp(LocalDateTime.now());
	if(status != null) {
		status.getMessages().add(data);
		repo.save(status);
	}else {
		throw new RuntimeException("Room not found!");
	}
	
	return data;
	}
	
	
	
	
	
	
	
	
	
}
