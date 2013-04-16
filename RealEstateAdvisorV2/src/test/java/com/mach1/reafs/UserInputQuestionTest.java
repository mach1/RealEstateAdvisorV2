package com.mach1.reafs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.mach1.reafs.input.UserInputQuestion;
import com.mach1.reafs.input.UserInputQuestionFactory;

public class UserInputQuestionTest {

	List<UserInputQuestion> userInputQuestions = UserInputQuestionFactory.getInstance().getUserInputQuestions();

	@Test
	public void getQuestionTextTest() {
		assertEquals(userInputQuestions.get(0).getQuestionText(), "Lähimad naabrid peaksid asuma...");
	}
	
	@Test
	public void getQuestionAnswerEnumStringTest() {
		assertEquals(userInputQuestions.get(0).getAnswerList().get(0).getAnswerEnumString(), "SAME_BUILDING");
	}

}
