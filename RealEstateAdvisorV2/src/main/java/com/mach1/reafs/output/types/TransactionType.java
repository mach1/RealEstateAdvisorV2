package com.mach1.reafs.output.types;

import com.mach1.reafs.output.UserOutput;

public enum TransactionType implements UserOutput {
	RENT, SALE;
	
	public String getTranslation() {
		switch (this) {
		case RENT:
			return "Üürimine";
		case SALE:
			return "Müük";
		default:
			return null;
		}
	}
}
