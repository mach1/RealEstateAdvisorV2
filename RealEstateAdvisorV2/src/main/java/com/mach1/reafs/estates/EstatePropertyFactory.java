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
		//V-01
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KESKLINN,
				Price.FROM_500_TO_1200, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.NEW));
		//V-02
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.PIRITA,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.FROM_50_TO_100, 
				NumberOfFloors.ONE, Condition.NEW));
		//V-03
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.MUSTAMAE,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.FROM_50_TO_100, 
				NumberOfFloors.ONE, Condition.NEW));
		//V-04
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KRISTIINE,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.NEW));
		//V-05
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KESKLINN,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.FROM_50_TO_100, 
				NumberOfFloors.ONE, Condition.RENOVATED));
		//V-06
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.PIRITA,
				Price.LESS_THAN_200, PlotSize.LESS_THAN_500,
				NumberOfRooms.ONE, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.RENOVATED));
		//V-07
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.MUSTAMAE,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.FOUR, TotalArea.FROM_50_TO_100, 
				NumberOfFloors.ONE, Condition.RENOVATED));
		//V-08
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KRISTIINE,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.RENOVATED));
		//V-09
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KESKLINN,
				Price.LESS_THAN_200, PlotSize.LESS_THAN_500,
				NumberOfRooms.ONE, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.IN_NEED_OF_REPAIR));
		//V-10
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.PIRITA,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.FROM_50_TO_100, 
				NumberOfFloors.ONE, Condition.IN_NEED_OF_REPAIR));
		//V-11
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.MUSTAMAE,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.IN_NEED_OF_REPAIR));
		//V-12
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KRISTIINE,
				Price.LESS_THAN_200, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.IN_NEED_OF_REPAIR));
		//V-13
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.LASNAMAE,
				Price.LESS_THAN_200, PlotSize.LESS_THAN_500,
				NumberOfRooms.ONE, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.RENOVATED));
		//V-14
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.LASNAMAE,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.THREE, TotalArea.FROM_50_TO_100, 
				NumberOfFloors.ONE, Condition.IN_NEED_OF_REPAIR));
		//V-15
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.LASNAMAE,
				Price.FROM_200_TO_500, PlotSize.LESS_THAN_500,
				NumberOfRooms.TWO, TotalArea.FROM_50_TO_100, 
				NumberOfFloors.ONE, Condition.IN_NEED_OF_REPAIR));
		//V-16
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				Price.FROM_1200_TO_50000, PlotSize.LESS_THAN_500,
				NumberOfRooms.ONE, TotalArea.LESS_THAN_50, 
				NumberOfFloors.ONE, Condition.RENOVATED));
		//V-17
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				Price.FROM_50000_TO_250000, PlotSize.LESS_THAN_500,
				NumberOfRooms.THREE, TotalArea.FROM_50_TO_100, 
				NumberOfFloors.ONE, Condition.IN_NEED_OF_REPAIR));
		
		return estateProperties;
	}
}
