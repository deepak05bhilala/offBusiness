package com.example.petalstech.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.petalstech.model.Chatlog;

// ChatLogRepository is extending JPARepository for CRUD operations
@Repository
public interface ChatLogRepository extends JpaRepository<Chatlog, Long>  //
{
	Page<Chatlog> findByUser(String user, Pageable pageable);  // finding t
	List<Chatlog> findFirst10ByUserOrderByTimeStampDesc(String user);
	void deleteAllByUser(String user);
	void deleteById(Long msgId);
}
