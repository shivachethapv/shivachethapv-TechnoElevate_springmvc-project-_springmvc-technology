package com.tyss.quizass.dao;

import java.util.Date;

import com.tyss.quizass.dto.QuizQuestions;
import com.tyss.quizass.dto.Register;
import com.tyss.quizass.dto.Results;

interface Quiz {
	
	abstract  Register login(String username,String Password);
	
	abstract  Register register(Register register);
	
	abstract QuizQuestions questions(int id);
	
	abstract void results(Results results);
	
	abstract Results getResults(Date date);

}
