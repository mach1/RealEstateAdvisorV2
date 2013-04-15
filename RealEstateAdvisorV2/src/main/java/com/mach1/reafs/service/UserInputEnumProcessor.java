package com.mach1.reafs.service;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.mach1.reafs.input.UserInput;

public class UserInputEnumProcessor {

	private List<Class<?>> inputEnumList;
	private static final String USER_INPUT_ENUM_PACKAGE = "com/mach1/reafs/input/types";
	private static UserInputEnumProcessor instance;

	static {
		instance = new UserInputEnumProcessor();
		instance.setInputEnumList(loadUserInputEnumClasses());
	}

	private static List<Class<?>> loadUserInputEnumClasses() {
		List<Class<?>> enumClasses = new ArrayList<Class<?>>();
		File directory = null;
		String packageName = USER_INPUT_ENUM_PACKAGE.replace("/", ".");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL resource = loader.getResource(USER_INPUT_ENUM_PACKAGE);
		try {
			directory = new File(resource.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(USER_INPUT_ENUM_PACKAGE + " ("
					+ resource + ") does not appear to be a valid URL / URI.",
					e);
		} catch (IllegalArgumentException e) {
			directory = null;
		}

		if (directory != null && directory.exists()) {
			// Get the list of the files contained in the package
			String[] files = directory.list();
			for (int i = 0; i < files.length; i++) {
				// we are only interested in .class files
				if (files[i].endsWith(".class")) {
					// removes the .class extension
					String className = packageName + '.'
							+ files[i].substring(0, files[i].length() - 6);
					System.out.println("ClassDiscovery: className = "
							+ className);
					try {
						enumClasses.add(Class.forName(className));
					} catch (ClassNotFoundException e) {
						throw new RuntimeException(
								"ClassNotFoundException loading " + className);
					}
				}
			}
		}
		return enumClasses;
	}

	public List<UserInput> processStrings(List<String> stringInputs) {
		List<UserInput> userInputs = new ArrayList<UserInput>();
		for (String stringInput : stringInputs) {
			userInputs.add(getEnumForString(stringInput));
		}
		return userInputs;
	}

	private UserInput getEnumForString(String stringValue) {
		for (Class<?> enumClass : inputEnumList) {
			try {
				return (UserInput) enumClass.getMethod("valueOf", String.class)
						.invoke(enumClass, stringValue);
			} catch (Exception e) {
				// Ignore it and check next
			}
		}
		return null;
	}

	public List<Class<?>> getInputEnumList() {
		return inputEnumList;
	}

	public void setInputEnumList(List<Class<?>> inputEnumList) {
		this.inputEnumList = inputEnumList;
	}

	public static UserInputEnumProcessor getInstance() {
		return instance;
	}

}
