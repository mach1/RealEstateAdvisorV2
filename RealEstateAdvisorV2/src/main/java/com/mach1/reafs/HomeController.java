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

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String home(Locale locale, Model model) {
	// logger.info("Welcome home! The client locale is {}.", locale);
	//
	// Date date = new Date();
	// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
	// DateFormat.LONG, locale);
	//
	// String formattedDate = dateFormat.format(date);
	//
	// model.addAttribute("serverTime", formattedDate );
	//
	// List<UserInput> userInputs = new ArrayList<UserInput>();
	// userInputs.add(DistanceFromTheNeighbors.SAME_BUILDING);
	// userInputs.add(DistanceFromTheSea.VISIBLE_FROM_WINDOW);
	// for (UserInput userInput : userInputs) {
	// realEstatesKSession.insert(userInput);
	// }
	//
	// List<UserOutput> userOutputs = new ArrayList<UserOutput>();
	// realEstatesKSession.insert(userOutputs);
	// realEstatesKSession.fireAllRules();
	//
	// System.out.println(userOutputs);
	//
	// return "home";
	// }

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/input", method = RequestMethod.GET)
	public @ResponseBody
	List<UserInput> getUserInput(Locale locale, Model model) {
		logger.info("/addresses GET request");
		List<UserInput> userInputs = new ArrayList<UserInput>();
		userInputs.add(DistanceFromTheNeighbors.FEW_HUNDRED_METERS);
		return userInputs;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/input", method = RequestMethod.POST)
	public @ResponseBody
	List<UserInput> postUserInput(@RequestBody List<UserInput> userInputs,
			Locale locale, Model model) {
		
		List<Class> enumClasses = new ArrayList<Class>();
		enumClasses.add(CarAvailability.class);
		CarAvailability.values();
//		List<EstateProperty> estateProperties = realEstateProcessingService
//				.getEstates(userInputs);
		
		return userInputs;
	}

}
