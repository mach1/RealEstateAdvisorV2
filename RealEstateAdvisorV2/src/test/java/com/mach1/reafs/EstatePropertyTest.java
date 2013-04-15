package com.mach1.reafs;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mach1.reafs.estates.EstateProperty;
import com.mach1.reafs.estates.EstatePropertyFactory;
import com.mach1.reafs.output.types.RealEstateType;

public class EstatePropertyTest {

	List<EstateProperty> estateProperties = EstatePropertyFactory.getInstance().getEstateProperties();
	
	@Test
	public void getRealEstateTypeTest() {
		assertEquals(estateProperties.get(0).getRealEstateType(), RealEstateType.FLAT);
		assertEquals(estateProperties.get(1).getRealEstateType(), RealEstateType.TERRACED);
		assertEquals(estateProperties.get(2).getRealEstateType(), RealEstateType.HOUSE);
		assertEquals(estateProperties.get(3).getRealEstateType(), RealEstateType.HOUSE);
		assertEquals(estateProperties.get(4).getRealEstateType(), RealEstateType.FLAT);
	}

}
