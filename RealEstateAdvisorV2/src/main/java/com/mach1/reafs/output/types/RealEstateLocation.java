package com.mach1.reafs.output.types;

import com.mach1.reafs.output.UserOutput;

public enum RealEstateLocation implements UserOutput {
	KESKLINN, PIRITA, KRISTIINE, LASNAMAE, MUSTAMAE;

	public String getTranslation() {
		switch (this) {
		case KESKLINN:
			return "Kesklinn";
		case PIRITA:
			return "Pirita";
		case KRISTIINE:
			return "Kristiine";
		case LASNAMAE:
			return "Lasnamäe";
		case MUSTAMAE:
			return "Mustamäe";
		default:
			return null;
		}
	}
}
