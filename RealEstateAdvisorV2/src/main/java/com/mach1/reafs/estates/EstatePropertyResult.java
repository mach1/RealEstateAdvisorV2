package com.mach1.reafs.estates;

public class EstatePropertyResult implements Comparable<EstatePropertyResult>{
	private EstateProperty estateProperty;
	private int score = 0;
	
	public EstatePropertyResult() {}
	
	public EstatePropertyResult(int score, EstateProperty estateProperty) {
		this.score = score;
		this.estateProperty = estateProperty;
	}
	
	public void addScore() {
		addScore(1);
	}
	
	public void addScore(int addition) {
		score += addition;
	}
	
	public EstateProperty getEstateProperty() {
		return estateProperty;
	}

	public void setEstateProperty(EstateProperty estateProperty) {
		this.estateProperty = estateProperty;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(EstatePropertyResult o) {
		if (this.score > o.getScore()) return -1;
		if (this.score < o.getScore()) return 1;
		return 0;
	}
	
	
}
