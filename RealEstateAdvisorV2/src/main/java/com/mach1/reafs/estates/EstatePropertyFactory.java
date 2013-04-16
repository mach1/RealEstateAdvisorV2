package com.mach1.reafs.estates;

import java.util.ArrayList;
import java.util.List;

import com.mach1.reafs.output.types.PlotSize;
import com.mach1.reafs.output.types.RealEstateLocation;
import com.mach1.reafs.output.types.RealEstateType;

public class EstatePropertyFactory {

	private static EstatePropertyFactory instance;

	static {
		instance = new EstatePropertyFactory();
	}

	public static EstatePropertyFactory getInstance() {
		return instance;
	}

	public List<EstateProperty> getEstateProperties() {
		List<EstateProperty> estateProperties = new ArrayList<EstateProperty>();
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				PlotSize.LESS_THAN_500, RealEstateLocation.KESKLINN));
		estateProperties.add(new EstateProperty(RealEstateType.TERRACED,
				PlotSize.LESS_THAN_500, RealEstateLocation.KRISTIINE));
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				PlotSize.FROM_500_TO_1500, RealEstateLocation.LASNAMAE));
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				PlotSize.MORE_THAN_1500, RealEstateLocation.MUSTAMAE));
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				PlotSize.LESS_THAN_500, RealEstateLocation.PIRITA));
		return estateProperties;
	}
}
