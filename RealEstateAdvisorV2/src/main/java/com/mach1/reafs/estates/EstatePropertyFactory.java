package com.mach1.reafs.estates;

import java.util.ArrayList;
import java.util.List;

import com.mach1.reafs.output.types.Condition;
import com.mach1.reafs.output.types.NumberOfFloors;
import com.mach1.reafs.output.types.NumberOfRooms;
import com.mach1.reafs.output.types.PlotSize;
import com.mach1.reafs.output.types.Price;
import com.mach1.reafs.output.types.RealEstateLocation;
import com.mach1.reafs.output.types.RealEstateType;
import com.mach1.reafs.output.types.TotalArea;
import com.mach1.reafs.output.types.TransactionType;

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
				TransactionType.RENT, RealEstateLocation.KESKLINN,
				Price.FROM_500_TO_1200, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.NEW));
		return estateProperties;
	}
}
