package com.mach1.reafs.input;

public class UserInputWrapper{
	
	private UserInput userInput;
	private String enumKey;
	
	public UserInputWrapper() {}
	
	public UserInputWrapper(String enumKey, UserInput userInput) {
		this.enumKey = enumKey;
		this.userInput = userInput;
	}

	public UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(UserInput userInput) {
		this.userInput = userInput;
	}

	public String getEnumKey() {
		return enumKey;
	}

	public void setEnumKey(String enumKey) {
		this.enumKey = enumKey;
	}

}