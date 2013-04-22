package com.mach1.reafs.output;

public class UserOutputWrapper{
	
	private int weight = 0;
	private UserOutput userOutput;
	
	public UserOutputWrapper() {}
	
	public UserOutputWrapper(UserOutput userOutput, int weight) {
		this.userOutput = userOutput;
		this.weight = weight;
	}

	public void addWeight(int weight) {
		this.weight = this.weight + weight;
	}

	@Override
	public String toString() {
		return "WeightUserOutput [userOutput=" + userOutput + ", weight=" + weight
				+ "]";
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public UserOutput getUserOutput() {
		return userOutput;
	}

	public void setUserOutput(UserOutput userOutput) {
		this.userOutput = userOutput;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserOutputWrapper other = (UserOutputWrapper) obj;
		if (userOutput == null) {
			if (other.userOutput != null)
				return false;
		} else if (!userOutput.toString().equals(other.userOutput.toString()))
			return false;
		return true;
	}
	
}
