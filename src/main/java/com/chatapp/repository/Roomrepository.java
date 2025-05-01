package com.chatapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chatapp.entity.Room;

public interface Roomrepository extends MongoRepository<Room, String>{
Room findByRoomid(String roomid);
}
