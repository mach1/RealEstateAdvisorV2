package com.mach1.reafs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jess.JessException;

import com.mach1.reafs.estates.EstateProperty;
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
import com.mach1.reafs.service.RealEstateProcessingService;

public class RealEstateProcessingServiceTest {

	private RealEstateProcessingService service= new RealEstateProcessingService();
	
	@Test
	public void serviceTest() throws JessException {
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
		List<EstateProperty> result = service.getEstates(userInputs);

		System.out.println(result.toString());
		
		assertTrue(result.toString().contains("V-05"));
		assertTrue(result.toString().contains("V-01"));
		assertTrue(result.toString().contains("V-08"));
		
		userInputs = new ArrayList<UserInput>();
		userInputs.add(DistanceFromTheNeighbors.MORE_THAN_1_KM);
		userInputs.add(DistanceFromTheSea.NOT_IMPORTANT);
		userInputs.add(FamilySize.TWO_TO_FOUR_MEMBERS);
		userInputs.add(Income.BETWEEN_1200_AND_4000);
		userInputs.add(Silence.VERY_IMPORTANT);
		userInputs.add(Disabilities.NONE);
		userInputs.add(RepairSkills.SOME_PROFICIENCY_IN_REPAIRS);
		userInputs.add(Hobbies.LARGE_AREA_NEEDED);
		userInputs.add(SchoolTravelTime.MORE_THAN_45_MIN);
		userInputs.add(CurrentSchool.TALLINN_UNIVERSITY_OF_TECHNOLOGY);
		userInputs.add(TimeRequiredForHeating.LESS_THAN_1_HOUR);
		userInputs.add(MaritalStatus.COHABITING);
		userInputs.add(CarAvailability.MORE_THAN_ONE_CAR_IN_FAMILY);
		userInputs.add(ChildrenAged.INFANTS);
		userInputs.add(ReadyToBuy.YES);
		result = service.getEstates(userInputs);

		System.out.println(result.toString());
		
		assertTrue(result.toString().contains("V-31"));
		assertTrue(result.toString().contains("V-29"));
		assertTrue(result.toString().contains("V-24"));
	}
	
}
