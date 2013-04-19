package com.mach1.reafs.output.types;

import com.mach1.reafs.output.UserOutput;

public enum RealEstateType implements UserOutput {
	FLAT, TERRACED, HOUSE;

	public String getTranslation() {
		switch (this) {
		case FLAT:
			return "Korter";
		case TERRACED:
			return "Ridaelamu";
		case HOUSE:
			return "Maja";
		default:
			return null;
		}
	}
}
