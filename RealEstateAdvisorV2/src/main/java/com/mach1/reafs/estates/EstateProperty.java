package com.mach1.reafs.estates;

import java.util.List;
import java.util.ArrayList;

import com.mach1.reafs.output.UserOutput;
import com.mach1.reafs.output.types.*;

public class EstateProperty {

	private RealEstateType realEstateType;
	private TransactionType transactionType;
	private RealEstateLocation realEstateLocation;
	private Price price;
	private PlotSize plotSize;
	private NumberOfRooms numberOfRooms;
	private TotalArea totalArea;
	private NumberOfFloors numberOfFloors;
	private Condition condition;
	
	private boolean isSuitable = true;

	private List<UserOutput> allProperties = new ArrayList<UserOutput>();

	public EstateProperty() {
	}

	public EstateProperty(RealEstateType realEstateType, TransactionType transactionType,
			RealEstateLocation realEstateLocation, Price price, PlotSize plotSize,
			NumberOfRooms numberOfRooms, TotalArea totalArea, NumberOfFloors numberOfFloors, 
			Condition condition) {
		this.realEstateType = realEstateType;
		this.transactionType = transactionType;
		this.realEstateLocation = realEstateLocation;
		this.price = price;
		this.plotSize = plotSize;
		this.numberOfRooms = numberOfRooms;
		this.totalArea = totalArea;
		this.numberOfFloors = numberOfFloors;
		this.condition = condition;
		
		allProperties.add(realEstateType);
		allProperties.add(transactionType);
		allProperties.add(realEstateLocation);
		allProperties.add(price);
		allProperties.add(plotSize);
		allProperties.add(numberOfRooms);
		allProperties.add(totalArea);
		allProperties.add(numberOfFloors);
		allProperties.add(condition);
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

	public RealEstateType getRealEstateType() {
		return realEstateType;
	}

	public void setRealEstateType(RealEstateType realEstateType) {
		this.realEstateType = realEstateType;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public RealEstateLocation getRealEstateLocation() {
		return realEstateLocation;
	}

	public void setRealEstateLocation(RealEstateLocation realEstateLocation) {
		this.realEstateLocation = realEstateLocation;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public PlotSize getPlotSize() {
		return plotSize;
	}

	public void setPlotSize(PlotSize plotSize) {
		this.plotSize = plotSize;
	}

	public NumberOfRooms getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(NumberOfRooms numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public TotalArea getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(TotalArea totalArea) {
		this.totalArea = totalArea;
	}

	public NumberOfFloors getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(NumberOfFloors numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public boolean isSuitable() {
		return isSuitable;
	}

	public void setSuitable(boolean isSuitable) {
		this.isSuitable = isSuitable;
	}

}
