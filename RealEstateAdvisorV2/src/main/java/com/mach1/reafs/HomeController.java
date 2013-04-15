package com.mach1.reafs;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.drools.runtime.StatefulKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mach1.reafs.estates.EstateProperty;
import com.mach1.reafs.input.UserInput;
import com.mach1.reafs.input.types.CarAvailability;
import com.mach1.reafs.input.types.DistanceFromTheNeighbors;
import com.mach1.reafs.service.RealEstateProcessingService;
import com.mach1.reafs.service.UserInputEnumProcessor;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private StatefulKnowledgeSession realEstatesKSession;

	@Autowired
	private RealEstateProcessingService realEstateProcessingService;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/input", method = RequestMethod.POST)
	public @ResponseBody
	List<EstateProperty> postUserInput(
			@RequestBody List<String> userInputStrings, Locale locale,
			Model model) {

		UserInputEnumProcessor userInputEnumProcessor = UserInputEnumProcessor
				.getInstance();
		List<UserInput> userInputs = userInputEnumProcessor
				.processStrings(userInputStrings);

		List<EstateProperty> filteredRealEstates = realEstateProcessingService
				.getEstates(userInputs);
		return filteredRealEstates;
	}

}
