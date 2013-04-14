package com.mach1.reafs.estates;

import java.util.List;
import java.util.ArrayList;

import com.mach1.reafs.output.UserOutput;
import com.mach1.reafs.output.types.PlotSize;
import com.mach1.reafs.output.types.RealEstateLocation;
import com.mach1.reafs.output.types.RealEstateType;

public class EstateProperty {

	private RealEstateType realEstateType;
	private PlotSize plotSize;
	private RealEstateLocation realEstateLocation;
	private boolean isSuitable = true;

	private List<UserOutput> allProperties = new ArrayList<UserOutput>();

	public EstateProperty() {
	}

	public EstateProperty(RealEstateType realEstateType, PlotSize plotSize,
			RealEstateLocation realEstateLocation) {
		this.realEstateType = realEstateType;
		this.plotSize = plotSize;
		this.realEstateLocation = realEstateLocation;
		allProperties.add(realEstateType);
		allProperties.add(plotSize);
		allProperties.add(realEstateLocation);
	}

	public RealEstateType getRealEstateType() {
		return realEstateType;
	}

	public void setRealEstateType(RealEstateType realEstateType) {
		this.realEstateType = realEstateType;
	}

	public PlotSize getPlotSize() {
		return plotSize;
	}

	public void setPlotSize(PlotSize plotSize) {
		this.plotSize = plotSize;
	}

	public boolean isSuitable() {
		return isSuitable;
	}

	public void setSuitable(boolean isSuitable) {
		this.isSuitable = isSuitable;
	}

	public RealEstateLocation getRealEstateLocation() {
		return realEstateLocation;
	}

	public void setRealEstateLocation(RealEstateLocation realEstateLocation) {
		this.realEstateLocation = realEstateLocation;
	}

	@Override
	public String toString() {
		return "EstateProperty [realEstateType=" + realEstateType
				+ ", plotSize=" + plotSize + ", realEstateLocation="
				+ realEstateLocation + ", isSuitable=" + isSuitable + "]";
	}

	public List<UserOutput> getAllProperties() {
		return allProperties;
	}

	public void setAllProperties(List<UserOutput> allProperties) {
		this.allProperties = allProperties;
	}

}
