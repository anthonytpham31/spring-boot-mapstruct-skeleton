package cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Users findByUserCredsName(String userName);
	
	List<Users> findByDeletedUsers(Integer tracker);
}
