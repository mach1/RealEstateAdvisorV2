package com.mach1.reafs.estates;

import java.util.ArrayList;
import java.util.List;

import com.mach1.reafs.output.types.Condition;
import com.mach1.reafs.output.types.RealEstateLocation;
import com.mach1.reafs.output.types.RealEstateType;
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
				600, 0,	2, 0, 1, Condition.NEW));
		//V-02
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.PIRITA,
				390, 0, 2, 51.70, 1, Condition.NEW));
		//V-03
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.MUSTAMAE,
				390, 0,	2, 59.90, 
				1, Condition.NEW));
		//V-04
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KRISTIINE,
				400, 0, 2, 39, 1, Condition.NEW));
		//V-05
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KESKLINN,
				400, 0, 2, 52, 1, Condition.RENOVATED));
		//V-06
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.PIRITA,
				100, 0, 1, 16, 1, Condition.RENOVATED));
		//V-07
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.MUSTAMAE,
				500, 0, 4, 75.60, 1, Condition.RENOVATED));
		//V-08
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KRISTIINE,
				390, 0, 2, 46.40, 1, Condition.RENOVATED));
		//V-09
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KESKLINN,
				140, 0, 1, 28.0, 1, Condition.IN_NEED_OF_REPAIR));
		//V-10
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.PIRITA,
				300, 0, 2, 51.0, 1, Condition.IN_NEED_OF_REPAIR));
		//V-11
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.MUSTAMAE,
				260, 0, 2, 43.0, 1, Condition.IN_NEED_OF_REPAIR));
		//V-12
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.KRISTIINE,
				140, 0, 2, 16, 1, Condition.IN_NEED_OF_REPAIR));
		//V-13
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.LASNAMAE,
				200, 0,1, 33, 1, Condition.RENOVATED));
		//V-14
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.LASNAMAE,
				230, 0,3, 64.50, 1, Condition.IN_NEED_OF_REPAIR));
		//V-15
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.RENT, RealEstateLocation.LASNAMAE,
				250, 0,2, 65, 1, Condition.IN_NEED_OF_REPAIR));
		//V-16
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				24000, 0,1, 16, 1, Condition.RENOVATED));
		//V-17
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				90000, 0,3, 73.80, 1, Condition.IN_NEED_OF_REPAIR));
		//V-18
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				84000, 0,3, 51.10, 1, Condition.NEW));
		//V-19
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.KRISTIINE,
				149000, 0,4, 125, 1, Condition.RENOVATED));
		//V-20
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.KRISTIINE,
				88000, 0,2, 49, 1, Condition.NEW));
		//V-21
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.LASNAMAE,
				51000, 0,1, 32, 1, Condition.RENOVATED));
		//V-22
		estateProperties.add(new EstateProperty(RealEstateType.FLAT,
				TransactionType.SALE, RealEstateLocation.LASNAMAE,
				38000, 0,2, 31.40,1, Condition.IN_NEED_OF_REPAIR));
		//V-23
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				380000, 600,8, 350, 4, Condition.NEW));
		//V-24
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.PIRITA,
				217000, 600,3, 124.70, 2, Condition.NEW));
		//V-25
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.MUSTAMAE,
				320000, 664,6, 300, 2, Condition.NEW));
		//V-26
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.KRISTIINE,
				348000, 777,5, 210,1, Condition.NEW));
		//V-27
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.LASNAMAE,
				350000, 1710,10, 315, 2, Condition.NEW));
		//V-28
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				120000, 100,3, 90, 2, Condition.RENOVATED));
		//V-29
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.PIRITA,
				146900, 938,4, 127, 2, Condition.RENOVATED));
		//V-30
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.KRISTIINE,
				225000, 900,5, 190, 3, Condition.RENOVATED));
		//V-31
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.LASNAMAE,
				150000, 759,6, 168, 2, Condition.RENOVATED));
		//V-32
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				110000, 301,3, 93, 1, Condition.IN_NEED_OF_REPAIR));
		//V-33
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.PIRITA,
				125000, 900,4, 112.9, 2, Condition.IN_NEED_OF_REPAIR));
		//V-34
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.MUSTAMAE,
				504900, 1650,5, 108, 2, Condition.IN_NEED_OF_REPAIR));
		//V-35
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.KRISTIINE,
				155000, 1500,6, 209.3, 2, Condition.IN_NEED_OF_REPAIR));
		//V-36
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.LASNAMAE,
				375000, 3838,8, 293.50, 2, Condition.IN_NEED_OF_REPAIR));
		//V-37
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.KESKLINN,
				189000, 1857,5, 140, 2, Condition.IN_NEED_OF_REPAIR));
		//V-38
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.KRISTIINE,
				280000, 2045,6, 120, 2, Condition.RENOVATED));
		//V-39
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.LASNAMAE,
				159000, 1200,4, 90, 2, Condition.IN_NEED_OF_REPAIR));
		//V-40
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.SALE, RealEstateLocation.MUSTAMAE,
				319000, 1003,6, 282, 2, Condition.NEW));
		//V-41
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.RENT, RealEstateLocation.PIRITA,
				850, 783,5, 158, 2, Condition.RENOVATED));
		//V-42
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.RENT, RealEstateLocation.KESKLINN,
				1500, 200,6, 260, 2, Condition.RENOVATED));
		//V-43
		estateProperties.add(new EstateProperty(RealEstateType.HOUSE,
				TransactionType.RENT, RealEstateLocation.KRISTIINE,
				3900, 1716,8, 500, 3, Condition.NEW));
		
		return estateProperties;
	}
}
