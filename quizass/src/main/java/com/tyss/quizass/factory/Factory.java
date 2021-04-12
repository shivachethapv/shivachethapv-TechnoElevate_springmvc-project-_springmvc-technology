package com.tyss.quizass.factory;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.quizass.dao.LoginDetails;
import com.tyss.quizass.dto.QuizQuestions;
import com.tyss.quizass.dto.Register;
import com.tyss.quizass.dto.Results;

public class Factory {

	ApplicationContext context = new ClassPathXmlApplicationContext("quiz.xml");
	LoginDetails loginDetails = (LoginDetails) context.getBean("loginDetails");
	Scanner scanner = new Scanner(System.in);
	int result = 0;
	int noOfQuestions = 0;

	public void register() {
		Register register = (Register) context.getBean("register");
		System.out.println("Enter UserName");
		String username = scanner.next();
		register.setUsername(username);
		System.out.println("Enter Password");
		String password = scanner.next();
		register.setPassword(password);
		System.out.println("Enter ConfirmPassword");
		String confirmPassword = scanner.next();
		if (password.equals(confirmPassword)) {
			register.setConfirmpassword(confirmPassword);
			loginDetails.register(register);
			System.out.println("Sucessfully Registered");
		}else
		{
			System.out.println("Confirm password is not matched");
		}
		
	}// End of the Method

	public void login() {

		Register login = (Register) context.getBean("register");
		System.out.println("Enter UserName");
		String username = scanner.next();
		System.out.println("Enter Password");
		String password = scanner.next();
		Register login2 = loginDetails.login(username, password);
		String password1 = login2.getPassword();
		if (password.equals(password1)) {
			System.out.println("Successfully Login");
			int iterate2;
			do {
				System.out.println("1----> JAVA");
				System.out.println("2----> HTML");
				System.out.println("3----> Hibernate");
				int subject = scanner.nextInt();
				subject(subject);
				questions(subject);
				results(subject);
				System.out.println("Enter 1 for to write one more Quiz");
				System.out.println("Enter 2 for Exit");
				iterate2 = scanner.nextInt();
			} while (iterate2 == 1);
		} else {
			System.out.println("wrong password");
		}
	}// End of the Method

	public void questions(int subject) {
		QuizQuestions questions1 = loginDetails.questions(subject);
		System.out.println("Pick correct answer from below options");
		System.out.println(questions1.getQuestion1());
		
		String answer1 = scanner.next();
		if (answer1.equalsIgnoreCase(questions1.getQuestion1answerString())) {
			result++;
		}
		System.out.println(questions1.getQuestion2());
		
		String answer2 = scanner.next();
		if (answer2.equalsIgnoreCase(questions1.getQuestion2answerString())) {
			result++;
		}
		System.out.println(questions1.getQuestion3());
		
		String answer3 = scanner.next();
		if (answer3.equalsIgnoreCase(questions1.getQuestion3answerString())) {
			result++;
		}
		System.out.println(questions1.getQuestion4());
		
		String answer4 = scanner.next();
		if (answer4.equalsIgnoreCase(questions1.getQuestion4answerString())) {
			result++;
		}
		System.out.println(questions1.getQuestion5());
		
		String answer5 = scanner.next();
		if (answer5.equalsIgnoreCase(questions1.getQuestion5answerString())) {
			result++;
		}
	}// End of the Method

	public void subject(int subject) {
		if (subject == 1) {
			QuizQuestions questions = (QuizQuestions) context.getBean("java");
		} else if (subject == 2) {
			QuizQuestions questions = (QuizQuestions) context.getBean("html");
		} else if (subject == 3) {
			QuizQuestions questions = (QuizQuestions) context.getBean("hibernate");
		}
	}// End of the Method

	public void results(int subject) {
		Results results = (Results) context.getBean("results");
		results.setId(subject);
		Date date = new Date();
		results.setTime_Date(date);
		results.setMarks(result);
		noOfQuestions = 5;
		results.setPercentage((result * 100) / noOfQuestions);
		//results.setUsername(null);
		loginDetails.results(results);
		Results results2 = loginDetails.getResults(date);
		System.out.println("Quiz Completed");
		System.out.println("Total marks obtained: " + results2.getMarks());
		System.out.println("Percentage: " + results2.getPercentage() + "%");
		result = 0;

	}// End of the Method

}// End of the class
