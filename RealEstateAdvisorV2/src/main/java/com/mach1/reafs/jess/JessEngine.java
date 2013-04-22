package com.mach1.reafs.jess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mach1.reafs.input.UserInput;
import com.mach1.reafs.input.UserInputWrapper;
import com.mach1.reafs.output.UserOutputWrapper;

import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;

@Component("JessEngine")
public class JessEngine {
	private static final String RULES_FILE = "rules.clp";
	private Rete engine;
	private WorkingMemoryMarker marker;
	
	public JessEngine() throws JessException {
		engine = new Rete();
		engine.reset();
		
		//Load the rules
		engine.batch(RULES_FILE);
		marker = engine.mark();
		
	}
	
	public List<UserOutputWrapper> getUserOutputs(List<UserInput> userInputs) throws JessException {
		System.out.println("Processing with user inputs:");
		System.out.println(userInputs);
		Iterator<UserOutputWrapper> result;
		List<UserInputWrapper> inputs = new ArrayList<UserInputWrapper>();
		for(UserInput input : userInputs) {
			inputs.add(new UserInputWrapper(input.toString(), input));
		}		
		
		result = run(inputs);
		List<UserOutputWrapper> userOutputsList = new ArrayList<UserOutputWrapper>();
		while (result.hasNext()) {
			UserOutputWrapper n = result.next();
			if (!userOutputsList.contains(n)) {
				userOutputsList.add(n);
			} else {
				userOutputsList.get(userOutputsList.indexOf(n)).addWeight(n.getWeight());
			}
		}
		
		return userOutputsList;
	}
	
	@SuppressWarnings("unchecked")
	private Iterator<UserOutputWrapper> run(List<UserInputWrapper> inputs) throws JessException {
		
		//to make sure no facts are in memory
		engine.resetToMark(marker);
		
		//Load input data into engine
		engine.addAll(inputs);
		
		engine.run();
		
		return engine.getObjects(new Filter.ByClass(UserOutputWrapper.class));
	}
}
