package com.mach1.reafs.input;

public class UserInputAnswer {
	private String answerText;
	private String answerEnumString;
	
	public UserInputAnswer() {}
	
	public UserInputAnswer(String answerText, String answerEnumString) {
		this.answerText = answerText;
		this.answerEnumString = answerEnumString;
	}
	
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public String getAnswerEnumString() {
		return answerEnumString;
	}
	public void setAnswerEnumString(String answerEnumString) {
		this.answerEnumString = answerEnumString;
	}
	
}
