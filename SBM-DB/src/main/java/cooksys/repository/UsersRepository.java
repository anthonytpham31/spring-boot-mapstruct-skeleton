package cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
}
