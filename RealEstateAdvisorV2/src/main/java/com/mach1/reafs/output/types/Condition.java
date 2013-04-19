package com.mach1.reafs.output.types;

import com.mach1.reafs.output.UserOutput;

public enum Condition implements UserOutput {
	IN_NEED_OF_REPAIR, RENOVATED, NEW;

	public String getTranslation() {
		switch (this) {
		case IN_NEED_OF_REPAIR:
			return "Vajab remonti";
		case RENOVATED:
			return "Renoveeritud";
		case NEW:
			return "Uus";
		default:
			return null;
		}
	}
}