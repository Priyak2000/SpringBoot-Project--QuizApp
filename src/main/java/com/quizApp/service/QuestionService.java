package com.quizApp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.quizApp.dao.QuestionDao;
//import com.quizApp.dao.Imp.QuestionDaoImp;
import com.quizApp.entity.Question;
import jakarta.transaction.Transactional;
@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	public List<Question> getAllQuestions() {
		return questionDao.findAll();
	}
	public List<Question> getQuestionsByCategory(String category) {
		
		return questionDao.findByCategory(category);
	}
	
	public ResponseEntity<String> createQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	 @Transactional
	public ResponseEntity<String> updateQuestionById(Integer id) {
		int rowUpdated =questionDao.updateById(id);
		if(rowUpdated>0) {
			return ResponseEntity.ok("Updated successfully!");
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question id is not found");
		}
	}
	public ResponseEntity<String> deleteQuestionById(Integer id) {
		questionDao.deleteById(id);
		return ResponseEntity.ok("Question Deleted");
	}
	public ResponseEntity<List<Question>> getQuestionByLevel(String level) {
		List<Question> questions = questionDao.findByDifficultyLevel(level);
		return ResponseEntity.ok(questions);
	}

}
