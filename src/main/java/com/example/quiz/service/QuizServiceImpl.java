package com.example.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {
	@Autowired
	QuizRepository repository;
	
	@Override
	public Page<Quiz> findAll(Pageable pageable) {
		// 「Direction.fromString("ASC"), "id"」の部分で「id」列を昇順に並び替えている
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
				Direction.fromString("DESC"), "id");
		return repository.findAll(pageRequest);

	}

	@Override
	public Optional<Quiz> selectOneById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Quiz> selectOneRandomQuiz() {
		Integer randId = repository.getRandomId();
		
		if (randId == null) {
			return Optional.empty();
			
		}
		return repository.findById(randId);
	}

	@Override
	public Boolean checkQuiz(Integer id, Boolean myAnswer) {
		Boolean check = false;
		Optional<Quiz> optQuiz = repository.findById(id);
		
		if (optQuiz.isPresent()) {
			Quiz quiz = optQuiz.get();
			if (quiz.getAnswer().equals(myAnswer)) {
				check = true;
			}
		}
		
		return check;
	}

	@Override
	public void insertQuiz(Quiz quiz) {
		repository.save(quiz);
	}

	@Override
	public void updateQuiz(Quiz quiz) {
		repository.save(quiz);
	}

	@Override
	public void deleteQuizById(Integer id) {
		repository.deleteById(id);
	}

}
