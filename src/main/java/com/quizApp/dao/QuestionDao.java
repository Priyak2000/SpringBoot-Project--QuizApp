package com.quizApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.quizApp.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question , Integer> {

	List<Question> findAll();
	List<Question> findByCategory(String category);
	void deleteById(Integer id);
	@Modifying
	@Query(value = "UPDATE question SET difficulty_level = 'medium' WHERE id = :id", nativeQuery = true)
	int updateById(Integer id);
	
	List<Question> findByDifficultyLevel(String difficultyLevel);
	
	
}
