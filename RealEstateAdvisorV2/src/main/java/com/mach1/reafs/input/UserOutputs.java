package com.mach1.reafs.input;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.OutSupport;

import com.mach1.reafs.output.UserOutput;

public class UserOutputs {

	private List<UserOutput> outputs = null;
	List<Class<?>> outputClasses = new ArrayList<Class<?>>();

	public UserOutputs() {
	}

	public UserOutputs(List<UserOutput> userOutputs) {
		this.setOutputs(userOutputs);
	}

	public List<UserOutput> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<UserOutput> outputs) {
		this.outputs = outputs;
		for (UserOutput userOutput : outputs) {
			outputClasses.add(userOutput.getClass());
		}
		System.out.println(outputs);
		System.out.println(outputClasses);
	}

	public void addUserOutput(UserOutput userOutput) {
		if (outputs == null) {
			outputs = new ArrayList<UserOutput>();
		}
		outputs.add(userOutput);
		outputClasses.add(userOutput.getClass());
	}

	public boolean containsOutputClass(Class<?> outputClass) {
		return outputClasses.contains(outputClass);
	}

	public boolean containsEnumValue(UserOutput userOutput) {
		return outputs.contains(userOutput);
	}

	public List<Class<?>> getOutputClasses() {
		return outputClasses;
	}

	public void setOutputClasses(List<Class<?>> outputClasses) {
		this.outputClasses = outputClasses;
	}
	
	
}
