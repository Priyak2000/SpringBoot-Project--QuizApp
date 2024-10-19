package com.quizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.entity.Question;
import com.quizApp.service.QuestionService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions(){
		return questionService.getAllQuestions();
		
	}
	@GetMapping("/byCategory/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);	
	}
	@PostMapping("/add")
	public ResponseEntity<String> createQuestions(@RequestBody Question question){
		return questionService.createQuestion(question);
	}
	@PutMapping("/updateById/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable Integer id){
		return questionService.updateQuestionById(id);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id) {
		return questionService.deleteQuestionById(id);
	}
	// Get Questions level
	@GetMapping("/ByDiffucultyLevel/{level}")
	public ResponseEntity<List<Question>> getQuestionByLevel(@PathVariable String level){
		
		return questionService.getQuestionByLevel(level);
		
	}

}
