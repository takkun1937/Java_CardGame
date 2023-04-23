package com.example.CardGameServer;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

//import com.example.CardGameServer.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
