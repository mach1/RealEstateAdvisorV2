package com.mach1.reafs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import jess.JessException;

import org.junit.Test;

import com.mach1.reafs.input.UserInput;
import com.mach1.reafs.input.types.CarAvailability;
import com.mach1.reafs.input.types.ChildrenAged;
import com.mach1.reafs.input.types.CurrentSchool;
import com.mach1.reafs.input.types.Disabilities;
import com.mach1.reafs.input.types.DistanceFromTheNeighbors;
import com.mach1.reafs.input.types.DistanceFromTheSea;
import com.mach1.reafs.input.types.FamilySize;
import com.mach1.reafs.input.types.Hobbies;
import com.mach1.reafs.input.types.Income;
import com.mach1.reafs.input.types.MaritalStatus;
import com.mach1.reafs.input.types.ReadyToBuy;
import com.mach1.reafs.input.types.RepairSkills;
import com.mach1.reafs.input.types.SchoolTravelTime;
import com.mach1.reafs.input.types.Silence;
import com.mach1.reafs.input.types.TimeRequiredForHeating;
import com.mach1.reafs.jess.JessEngine;

public class JessEngineTest {

	@Test
	public void test() throws JessException {
		
		JessEngine e = new JessEngine();
		List<UserInput> userInputs = new ArrayList<UserInput>();
		userInputs.add(DistanceFromTheNeighbors.SAME_BUILDING);
		userInputs.add(DistanceFromTheSea.NOT_IMPORTANT);
		userInputs.add(FamilySize.ONE_MEMBER);
		userInputs.add(Income.LESS_THAN_500);
		userInputs.add(Silence.NOT_NECESSARY);
		userInputs.add(Disabilities.NONE);
		userInputs.add(RepairSkills.SOME_PROFICIENCY_IN_REPAIRS);
		userInputs.add(Hobbies.NONE_OR_NO_SPECIAL_CONDITIONS_NEEDED);
		userInputs.add(SchoolTravelTime.MAX_OF_15_MIN);
		userInputs.add(CurrentSchool.TALLINN_UNIVERSITY);
		userInputs.add(TimeRequiredForHeating.LESS_THAN_1_HOUR);
		userInputs.add(MaritalStatus.SINGLE);
		userInputs.add(CarAvailability.ONE_CAR_IN_FAMILY);
		userInputs.add(ChildrenAged.NONE);
		userInputs.add(ReadyToBuy.NO);

		assertEquals(e.getUserOutputs(userInputs).size(), 23);
	}
	 
}
