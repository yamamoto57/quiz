package com.example.quiz.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.quiz.entity.Quiz;

public interface QuizService {
	Page<Quiz> findAll(Pageable pageable);
	Optional<Quiz> selectOneById(Integer id);
	Optional<Quiz> selectOneRandomQuiz();
	Boolean checkQuiz(Integer id, Boolean myAnswer);
	void insertQuiz(Quiz quiz);
	void updateQuiz(Quiz quiz);
	void deleteQuizById(Integer id);

}
