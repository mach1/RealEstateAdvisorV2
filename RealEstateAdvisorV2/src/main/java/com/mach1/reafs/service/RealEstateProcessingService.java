package com.mach1.reafs.service;

import java.util.ArrayList;
import java.util.List;

import jess.JessException;

import org.springframework.stereotype.Component;

import com.mach1.reafs.estates.EstateProperty;
import com.mach1.reafs.estates.EstatePropertyFactory;
import com.mach1.reafs.estates.EstatePropertyResult;
import com.mach1.reafs.input.UserInput;
import com.mach1.reafs.jess.JessEngine;
import com.mach1.reafs.output.UserOutputWrapper;

@Component("realEstateProcessingService")
public class RealEstateProcessingService {

	private List<EstatePropertyResult> resultList;
	
	private JessEngine jessEngine;
	
	public List<EstateProperty> getEstates(List<UserInput> userInputs) throws JessException {

		jessEngine = new JessEngine();
		
		System.out.println("Processing with user inputs:");
		System.out.println(userInputs);
		List<UserOutputWrapper> userOutputsList = jessEngine.getUserOutputs(userInputs);
		
		System.out.println("Got user outputs:");
		System.out.println(userOutputsList);
		List<EstateProperty> allEstateProperties = EstatePropertyFactory
				.getInstance().getEstateProperties();
		List<EstateProperty> filteredEstateProperties = getFilteredEstates(
				allEstateProperties, userOutputsList);
		System.out.println("Filtered estates:");
		System.out.println(filteredEstateProperties);
		return filteredEstateProperties;
	}

	private List<EstateProperty> getFilteredEstates(
			List<EstateProperty> allEstateProperties, 
			List<UserOutputWrapper> userOutputsList) {
		
		resultList = new ArrayList<EstatePropertyResult>();
		
		List<EstateProperty> filteredEstates = new ArrayList<EstateProperty>();
		for (EstateProperty estateProperty : allEstateProperties) {
			resultList.add(scoreEstate(estateProperty, userOutputsList));
		}
		java.util.Collections.sort(resultList);
		for (EstatePropertyResult result : resultList.subList(0, 3)) {
			filteredEstates.add(result.getEstateProperty());
		}
		return filteredEstates;
	}

	private EstatePropertyResult scoreEstate (EstateProperty estateProperty,
			List<UserOutputWrapper> userOutputsList) {
		EstatePropertyResult result = new EstatePropertyResult(0, estateProperty);
		for (UserOutputWrapper userOutput : userOutputsList) {
			if (estateProperty.getAllProperties().contains(userOutput.getUserOutput())) {
				result.addScore(userOutput.getWeight());
			} 
		}
		return result;
	}
	
}
