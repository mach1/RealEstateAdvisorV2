package com.mach1.reafs.input;

import java.util.List;

public class UserInputQuestion {
	private String questionText;
	private List<UserInputAnswer> answerList;
	
	public UserInputQuestion() {}
	
	public UserInputQuestion(String questionText, List<UserInputAnswer> answerList) {
		this.questionText = questionText;
		this.answerList = answerList;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<UserInputAnswer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<UserInputAnswer> answerList) {
		this.answerList = answerList;
	}
	
	
}
