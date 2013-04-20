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
	}

}
