package com.mach1.reafs.estates;

import java.util.List;
import java.util.ArrayList;

import com.mach1.reafs.output.UserOutput;
import com.mach1.reafs.output.types.*;

public class EstateProperty {

	private String identificator;
	private RealEstateType realEstateType;
	private TransactionType transactionType;
	private RealEstateLocation realEstateLocation;
	private Price price;
	private int priceValue;
	private PlotSize plotSize;
	private int plotSizeValue;
	private NumberOfRooms numberOfRooms;
	private int numberOfRoomsValue;
	private TotalArea totalArea;
	private double totalAreaValue;
	private NumberOfFloors numberOfFloors;
	private int numberOfFloorsValue;
	private Condition condition;
	
	private boolean isSuitable = true;

	private List<UserOutput> allProperties = new ArrayList<UserOutput>();

	public EstateProperty() {
	}
	
	public EstateProperty(String identificator, RealEstateType realEstateType, TransactionType transactionType,
			RealEstateLocation realEstateLocation, int priceValue, int plotSizeValue,
			int numberOfRoomsValue, double totalAreaValue, int numberOfFloorsValue, 
			Condition condition) {
		
		this(realEstateType, transactionType, realEstateLocation, 
				buildPrice(priceValue), buildPlotSize(plotSizeValue),
				buildNumberOfRooms(numberOfRoomsValue), buildTotalArea(totalAreaValue), 
				buildNumberOfFloors(numberOfFloorsValue),condition);
		
		this.identificator = identificator;
		this.priceValue = priceValue;
		this.plotSizeValue = plotSizeValue;
		this.numberOfRoomsValue = numberOfRoomsValue;
		this.totalAreaValue = totalAreaValue;
		this.numberOfFloorsValue = numberOfFloorsValue;
		
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
	
	private static Price buildPrice(int priceValue) {
		if (priceValue > 250000) {
			return Price.MORE_THAN_250000;
		} else if (priceValue > 50000) {
			return Price.FROM_50000_TO_250000;
		} else if (priceValue > 1200) {
			return Price.FROM_1200_TO_50000;
		} else if (priceValue > 500) {
			return Price.FROM_500_TO_1200;
		} else if (priceValue > 200) {
			return Price.FROM_200_TO_500;
		} else return Price.LESS_THAN_200;
	}
	
	private static PlotSize buildPlotSize(int plotSizeValue) {
		if (plotSizeValue > 1500) {
			return PlotSize.MORE_THAN_1500;
		} else if (plotSizeValue > 500) {
			return PlotSize.FROM_500_TO_1500;
		} else return PlotSize.LESS_THAN_500;
	}
	
	private static NumberOfRooms buildNumberOfRooms(int numberOfRoomsValue) {
		switch (numberOfRoomsValue) {
		case 1: 
			return NumberOfRooms.ONE;
		case 2: 
			return NumberOfRooms.TWO;
		case 3: 
			return NumberOfRooms.THREE;
		case 4: 
			return NumberOfRooms.FOUR;
		default: 
			return NumberOfRooms.MORE_THAN_FOUR;
		}
	}
	
	private static TotalArea buildTotalArea(double totalAreaValue) {
		if (totalAreaValue > 250) {
			return TotalArea.MORE_THAN_250;
		} else if(totalAreaValue > 100) {
			return TotalArea.FROM_100_TO_250;
		} else if(totalAreaValue > 50) {
			return TotalArea.FROM_50_TO_100;
		} else return TotalArea.LESS_THAN_50;
	}
	
	private static NumberOfFloors buildNumberOfFloors(int numberOfFloorsValue) {
		switch (numberOfFloorsValue) {
		case 1: 
			return NumberOfFloors.ONE;
		case 2: 
			return NumberOfFloors.TWO;
		case 3: 
			return NumberOfFloors.THREE;
		default: 
			return NumberOfFloors.MORE_THAN_THREE;
		}
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

	public int getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(int priceValue) {
		this.priceValue = priceValue;
	}

	public int getPlotSizeValue() {
		return plotSizeValue;
	}

	public void setPlotSizeValue(int plotSizeValue) {
		this.plotSizeValue = plotSizeValue;
	}

	public int getNumberOfRoomsValue() {
		return numberOfRoomsValue;
	}

	public void setNumberOfRoomsValue(int numberOfRoomsValue) {
		this.numberOfRoomsValue = numberOfRoomsValue;
	}

	public double getTotalAreaValue() {
		return totalAreaValue;
	}

	public void setTotalAreaValue(double totalAreaValue) {
		this.totalAreaValue = totalAreaValue;
	}

	public int getNumberOfFloorsValue() {
		return numberOfFloorsValue;
	}

	public void setNumberOfFloorsValue(int numberOfFloorsValue) {
		this.numberOfFloorsValue = numberOfFloorsValue;
	}

	public String getIdentificator() {
		return identificator;
	}

	public void setIdentificator(String identificator) {
		this.identificator = identificator;
	}

	@Override
	public String toString() {
		return "EstateProperty [identificator=" + identificator
				+ ", realEstateType=" + realEstateType + ", transactionType="
				+ transactionType + ", realEstateLocation="
				+ realEstateLocation + ", price=" + price + ", priceValue="
				+ priceValue + ", plotSize=" + plotSize + ", plotSizeValue="
				+ plotSizeValue + ", numberOfRooms=" + numberOfRooms
				+ ", numberOfRoomsValue=" + numberOfRoomsValue + ", totalArea="
				+ totalArea + ", totalAreaValue=" + totalAreaValue
				+ ", numberOfFloors=" + numberOfFloors
				+ ", numberOfFloorsValue=" + numberOfFloorsValue
				+ ", condition=" + condition + ", isSuitable=" + isSuitable
				+ "]";
	}

}
