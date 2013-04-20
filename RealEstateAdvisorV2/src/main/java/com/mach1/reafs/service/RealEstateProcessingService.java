package com.mach1.reafs.service;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mach1.reafs.estates.EstateProperty;
import com.mach1.reafs.estates.EstatePropertyFactory;
import com.mach1.reafs.estates.EstatePropertyResult;
import com.mach1.reafs.input.UserInput;
import com.mach1.reafs.input.UserOutputs;
import com.mach1.reafs.output.UserOutput;

@Component("realEstateProcessingService")
public class RealEstateProcessingService {

	@Autowired
	private KnowledgeBase realEstateKBase;
	
	private List<EstatePropertyResult> resultList = new ArrayList<EstatePropertyResult>();
	

	public List<EstateProperty> getEstates(List<UserInput> userInputs) {

		System.out.println("Processing with user inputs:");
		System.out.println(userInputs);
		List<UserOutput> userOutputsList = getDroolsOutput(userInputs);
		UserOutputs userOutputs = new UserOutputs(userOutputsList);

		System.out.println("Got user outputs:");
		System.out.println(userOutputs);
		List<EstateProperty> allEstateProperties = EstatePropertyFactory
				.getInstance().getEstateProperties();
		List<EstateProperty> filteredEstateProperties = getFilteredEstates(
				allEstateProperties, userOutputs);
		System.out.println("Filtered estates:");
		System.out.println(filteredEstateProperties);
		return filteredEstateProperties;
	}

	private List<UserOutput> getDroolsOutput(List<UserInput> userInputs) {
		StatefulKnowledgeSession realEstatesKSession = realEstateKBase.newStatefulKnowledgeSession();
		for (UserInput userInput : userInputs) {
			realEstatesKSession.insert(userInput);
		}
		List<UserOutput> userOutputs = new ArrayList<UserOutput>();
		realEstatesKSession.insert(userOutputs);
		realEstatesKSession.fireAllRules();
		realEstatesKSession.dispose();
		return userOutputs;
	}

	private List<EstateProperty> getFilteredEstates(
			List<EstateProperty> allEstateProperties, UserOutputs userOutputs) {
		List<EstateProperty> filteredEstates = new ArrayList<EstateProperty>();
		for (EstateProperty estateProperty : allEstateProperties) {
			resultList.add(scoreEstate(estateProperty, userOutputs));
		}
		java.util.Collections.sort(resultList);
		for (EstatePropertyResult result : resultList.subList(0, 3)) {
			filteredEstates.add(result.getEstateProperty());
		}
		return filteredEstates;
	}

	private EstatePropertyResult scoreEstate (EstateProperty estateProperty,
			UserOutputs userOutputs) {
		EstatePropertyResult result = new EstatePropertyResult(0, estateProperty);
		for (UserOutput userOutput : userOutputs.getOutputs()) {
			if (estateProperty.getAllProperties().contains(userOutput)) {
				result.addScore();
			} else if (estateProperty.getAllProperties().contains(userOutput.getClass())) {
				result.addScore(-1);
			}
		}
		return result;
	}
	
}
