package com.mach1.reafs.input.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mach1.reafs.input.UserInput;

public enum DistanceFromTheNeighbors implements UserInput {
	SAME_BUILDING, FEW_HUNDRED_METERS, MORE_THAN_1_KM
}
