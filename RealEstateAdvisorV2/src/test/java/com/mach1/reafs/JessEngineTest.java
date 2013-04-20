package com.mach1.reafs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import jess.JessException;

import org.junit.Test;

import com.mach1.reafs.input.UserInput;
import com.mach1.reafs.input.types.Income;
import com.mach1.reafs.jess.JessEngine;

public class JessEngineTest {

	@Test
	public void test() throws JessException {
		
		JessEngine e = new JessEngine();
		List<UserInput> userInputs = new ArrayList<UserInput>();
		userInputs.add(Income.BETWEEN_500_AND_1200);
		assertEquals(e.getUserOutputs(userInputs).size(), 7);
	}
	 
}
