(import com.mach1.reafs.input.*)
(import com.mach1.reafs.output.*)
(import com.mach1.reafs.input.types.CarAvailability)
(import com.mach1.reafs.input.types.ChildrenAged)
(import com.mach1.reafs.input.types.CurrentSchool)
(import com.mach1.reafs.input.types.Disabilities)
(import com.mach1.reafs.input.types.DistanceFromTheNeighbors)
(import com.mach1.reafs.input.types.DistanceFromTheSea)
(import com.mach1.reafs.input.types.FamilySize)
(import com.mach1.reafs.input.types.Hobbies)
(import com.mach1.reafs.input.types.Income)
(import com.mach1.reafs.input.types.MaritalStatus)
(import com.mach1.reafs.input.types.ReadyToBuy)
(import com.mach1.reafs.input.types.RepairSkills)
(import com.mach1.reafs.input.types.SchoolTravelTime)
(import com.mach1.reafs.input.types.Silence)
(import com.mach1.reafs.input.types.TimeRequiredForHeating)
(import com.mach1.reafs.output.types.Condition)
(import com.mach1.reafs.output.types.NumberOfFloors)
(import com.mach1.reafs.output.types.NumberOfRooms)
(import com.mach1.reafs.output.types.PlotSize)
(import com.mach1.reafs.output.types.Price)
(import com.mach1.reafs.output.types.RealEstateLocation)
(import com.mach1.reafs.output.types.RealEstateType)
(import com.mach1.reafs.output.types.TotalArea)
(import com.mach1.reafs.output.types.TransactionType)

(deftemplate UserInputWrapper       (declare (from-class UserInputWrapper)))

;Distance from neighbors rules
(defrule RE-01
    (UserInputWrapper {userInput == (DistanceFromTheNeighbors.SAME_BUILDING)} )
    => (add (new UserOutputWrapper (PlotSize.LESS_THAN_500) 3)))

(defrule RE-02
    (UserInputWrapper {userInput == (DistanceFromTheNeighbors.FEW_HUNDRED_METERS)} )
    => (add (new UserOutputWrapper (PlotSize.FROM_500_TO_1500) 3)))

(defrule RE-03
    (UserInputWrapper {userInput == (DistanceFromTheNeighbors.MORE_THAN_1_KM)} )
    => (add (new UserOutputWrapper (PlotSize.MORE_THAN_1500) 3)))

(defrule RE-04
    (UserInputWrapper {userInput == (DistanceFromTheNeighbors.SAME_BUILDING)} )
    => (add (new UserOutputWrapper (RealEstateType.FLAT) 3)))

(defrule RE-05
    (UserInputWrapper {userInput == (DistanceFromTheNeighbors.SAME_BUILDING)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 2)))

(defrule RE-06
    (UserInputWrapper {userInput == (DistanceFromTheNeighbors.FEW_HUNDRED_METERS)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 2)))

(defrule RE-07
    (UserInputWrapper {userInput == (DistanceFromTheNeighbors.FEW_HUNDRED_METERS)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 3)))

(defrule RE-08
    (UserInputWrapper {userInput == (DistanceFromTheNeighbors.MORE_THAN_1_KM)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 3)))

;Distance from the sea rules
(defrule RE-09
    (UserInputWrapper {userInput == (DistanceFromTheSea.VISIBLE_FROM_WINDOW)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 2)))

(defrule RE-10
    (UserInputWrapper {userInput == (DistanceFromTheSea.VISIBLE_FROM_WINDOW)} )
    => (add (new UserOutputWrapper (RealEstateLocation.PIRITA) 3)))

(defrule RE-11
    (UserInputWrapper {userInput == (DistanceFromTheSea.A_WALK_AWAY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.PIRITA) 1)))

(defrule RE-12
    (UserInputWrapper {userInput == (DistanceFromTheSea.A_WALK_AWAY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 3)))

(defrule RE-13
    (UserInputWrapper {userInput == (DistanceFromTheSea.A_WALK_AWAY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KRISTIINE) 2)))

(defrule RE-14
    (UserInputWrapper {userInput == (DistanceFromTheSea.NOT_IMPORTANT)} )
    => (add (new UserOutputWrapper (RealEstateLocation.LASNAMAE) 3)))

(defrule RE-15
    (UserInputWrapper {userInput == (DistanceFromTheSea.NOT_IMPORTANT)} )
    => (add (new UserOutputWrapper (RealEstateLocation.MUSTAMAE) 2)))

;Family size rules
(defrule RE-16
    (UserInputWrapper {userInput == (FamilySize.ONE_MEMBER)} )
    => (add (new UserOutputWrapper (TotalArea.LESS_THAN_50) 3)))

(defrule RE-17
    (UserInputWrapper {userInput == (FamilySize.TWO_TO_FOUR_MEMBERS)} )
    => (add (new UserOutputWrapper (TotalArea.FROM_50_TO_100) 2)))

(defrule RE-18
    (UserInputWrapper {userInput == (FamilySize.TWO_TO_FOUR_MEMBERS)} )
    => (add (new UserOutputWrapper (TotalArea.FROM_100_TO_250) 3)))

(defrule RE-19
    (UserInputWrapper {userInput == (FamilySize.FIVE_OR_MORE_MEMBERS)} )
    => (add (new UserOutputWrapper (TotalArea.FROM_100_TO_250) 2)))

(defrule RE-20
    (UserInputWrapper {userInput == (FamilySize.FIVE_OR_MORE_MEMBERS)} )
    => (add (new UserOutputWrapper (TotalArea.MORE_THAN_250) 3)))

(defrule RE-21
    (UserInputWrapper {userInput == (FamilySize.ONE_MEMBER)} )
    => (add (new UserOutputWrapper (NumberOfRooms.ONE) 2)))

(defrule RE-22
    (UserInputWrapper {userInput == (FamilySize.ONE_MEMBER)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 3)))

(defrule RE-23
    (UserInputWrapper {userInput == (FamilySize.TWO_TO_FOUR_MEMBERS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 1)))

(defrule RE-24
    (UserInputWrapper {userInput == (FamilySize.TWO_TO_FOUR_MEMBERS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 1)))

(defrule RE-25
    (UserInputWrapper {userInput == (FamilySize.TWO_TO_FOUR_MEMBERS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.FOUR) 2)))

(defrule RE-26
    (UserInputWrapper {userInput == (FamilySize.TWO_TO_FOUR_MEMBERS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.MORE_THAN_FOUR) 3)))

(defrule RE-27
    (UserInputWrapper {userInput == (FamilySize.FIVE_OR_MORE_MEMBERS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.MORE_THAN_FOUR) 3)))

;Income rules
(defrule RE-28
    (UserInputWrapper {userInput == (Income.LESS_THAN_500)} )
    => (add (new UserOutputWrapper (Price.LESS_THAN_200) 3)))

(defrule RE-29
    (UserInputWrapper {userInput == (Income.LESS_THAN_500)} )
    => (add (new UserOutputWrapper (Price.FROM_200_TO_500) 2)))

(defrule RE-30
    (UserInputWrapper {userInput == (Income.BETWEEN_500_AND_1200)} )
    => (add (new UserOutputWrapper (Price.LESS_THAN_200) 2)))

(defrule RE-31
    (UserInputWrapper {userInput == (Income.BETWEEN_500_AND_1200)} )
    => (add (new UserOutputWrapper (Price.FROM_200_TO_500) 3)))

(defrule RE-32
    (UserInputWrapper {userInput == (Income.BETWEEN_500_AND_1200)} )
    => (add (new UserOutputWrapper (Price.FROM_500_TO_1200) 1)))

(defrule RE-33
    (UserInputWrapper {userInput == (Income.BETWEEN_500_AND_1200)} )
    => (add (new UserOutputWrapper (Price.FROM_50000_TO_250000) 3)))

(defrule RE-34
    (UserInputWrapper {userInput == (Income.BETWEEN_1200_AND_4000)} )
    => (add (new UserOutputWrapper (Price.FROM_200_TO_500) 1)))

(defrule RE-35
    (UserInputWrapper {userInput == (Income.BETWEEN_1200_AND_4000)} )
    => (add (new UserOutputWrapper (Price.FROM_500_TO_1200) 3)))

(defrule RE-36
    (UserInputWrapper {userInput == (Income.BETWEEN_1200_AND_4000)} )
    => (add (new UserOutputWrapper (Price.FROM_1200_TO_50000) 2)))

(defrule RE-37
    (UserInputWrapper {userInput == (Income.BETWEEN_1200_AND_4000)} )
    => (add (new UserOutputWrapper (Price.FROM_50000_TO_250000) 3)))

(defrule RE-38
    (UserInputWrapper {userInput == (Income.MORE_THAN_4000)} )
    => (add (new UserOutputWrapper (Price.FROM_500_TO_1200) 2)))

(defrule RE-39
    (UserInputWrapper {userInput == (Income.MORE_THAN_4000)} )
    => (add (new UserOutputWrapper (Price.FROM_1200_TO_50000) 3)))

(defrule RE-40
    (UserInputWrapper {userInput == (Income.MORE_THAN_4000)} )
    => (add (new UserOutputWrapper (Price.MORE_THAN_250000) 3)))

(defrule RE-41
    (UserInputWrapper {userInput == (Income.LESS_THAN_500)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 3)))

(defrule RE-42
    (UserInputWrapper {userInput == (Income.BETWEEN_500_AND_1200)} )
    => (add (new UserOutputWrapper (Condition.IN_NEED_OF_REPAIR) 1)))

(defrule RE-43
    (UserInputWrapper {userInput == (Income.BETWEEN_500_AND_1200)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 3)))

(defrule RE-44
    (UserInputWrapper {userInput == (Income.BETWEEN_500_AND_1200)} )
    => (add (new UserOutputWrapper (Condition.NEW) 2)))

(defrule RE-45
    (UserInputWrapper {userInput == (Income.BETWEEN_1200_AND_4000)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 2)))

(defrule RE-46
    (UserInputWrapper {userInput == (Income.BETWEEN_1200_AND_4000)} )
    => (add (new UserOutputWrapper (Condition.NEW) 3)))

(defrule RE-47
    (UserInputWrapper {userInput == (Income.MORE_THAN_4000)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 2)))

(defrule RE-48
    (UserInputWrapper {userInput == (Income.MORE_THAN_4000)} )
    => (add (new UserOutputWrapper (Condition.NEW) 3)))

;Silence rules
(defrule RE-49
    (UserInputWrapper {userInput == (Silence.VERY_IMPORTANT)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 3)))

(defrule RE-50
    (UserInputWrapper {userInput == (Silence.LIKE_TO_WALK_IN_SILENCE_TIME_TO_TIME)} )
    => (add (new UserOutputWrapper (RealEstateType.FLAT) 3)))

(defrule RE-51
    (UserInputWrapper {userInput == (Silence.LIKE_TO_WALK_IN_SILENCE_TIME_TO_TIME)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 1)))

(defrule RE-52
    (UserInputWrapper {userInput == (Silence.LIKE_TO_WALK_IN_SILENCE_TIME_TO_TIME)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 2)))

(defrule RE-53
    (UserInputWrapper {userInput == (Silence.NOT_NECESSARY)} )
    => (add (new UserOutputWrapper (RealEstateType.FLAT) 3)))

(defrule RE-54
    (UserInputWrapper {userInput == (Silence.NOT_NECESSARY)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 1)))

(defrule RE-55
    (UserInputWrapper {userInput == (Silence.VERY_IMPORTANT)} )
    => (add (new UserOutputWrapper (PlotSize.MORE_THAN_1500) 3)))

(defrule RE-56
    (UserInputWrapper {userInput == (Silence.VERY_IMPORTANT)} )
    => (add (new UserOutputWrapper (PlotSize.FROM_500_TO_1500) 2)))

(defrule RE-57
    (UserInputWrapper {userInput == (Silence.LIKE_TO_WALK_IN_SILENCE_TIME_TO_TIME)} )
    => (add (new UserOutputWrapper (PlotSize.FROM_500_TO_1500) 3)))

(defrule RE-58
    (UserInputWrapper {userInput == (Silence.NOT_NECESSARY)} )
    => (add (new UserOutputWrapper (PlotSize.LESS_THAN_500) 3)))

(defrule RE-59
    (UserInputWrapper {userInput == (Silence.NOT_NECESSARY)} )
    => (add (new UserOutputWrapper (PlotSize.FROM_500_TO_1500) 2)))

;Disabilities rules
(defrule RE-60
    (UserInputWrapper {userInput == (Disabilities.NONE)} )
    => (add (new UserOutputWrapper (NumberOfFloors.ONE) 1)))

(defrule RE-61
    (UserInputWrapper {userInput == (Disabilities.NONE)} )
    => (add (new UserOutputWrapper (NumberOfFloors.TWO) 3)))

(defrule RE-62
    (UserInputWrapper {userInput == (Disabilities.NONE)} )
    => (add (new UserOutputWrapper (NumberOfFloors.THREE) 2)))

(defrule RE-63
    (UserInputWrapper {userInput == (Disabilities.NONE)} )
    => (add (new UserOutputWrapper (NumberOfFloors.MORE_THAN_THREE) 2)))

(defrule RE-64
    (UserInputWrapper {userInput == (Disabilities.MINOR_DISABILITY)} )
    => (add (new UserOutputWrapper (NumberOfFloors.ONE) 3)))

(defrule RE-65
    (UserInputWrapper {userInput == (Disabilities.MINOR_DISABILITY)} )
    => (add (new UserOutputWrapper (NumberOfFloors.TWO) 1)))

(defrule RE-66
    (UserInputWrapper {userInput == (Disabilities.SEVERE_DISABILITY)} )
    => (add (new UserOutputWrapper (NumberOfFloors.ONE) 3)))

(defrule RE-67
    (UserInputWrapper {userInput == (Disabilities.NONE)} )
    => (add (new UserOutputWrapper (Condition.NEW) 3)))

(defrule RE-68
    (UserInputWrapper {userInput == (Disabilities.NONE)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 2)))

(defrule RE-69
    (UserInputWrapper {userInput == (Disabilities.NONE)} )
    => (add (new UserOutputWrapper (Condition.IN_NEED_OF_REPAIR) 1)))

(defrule RE-70
    (UserInputWrapper {userInput == (Disabilities.MINOR_DISABILITY)} )
    => (add (new UserOutputWrapper (Condition.NEW) 3)))

(defrule RE-71
    (UserInputWrapper {userInput == (Disabilities.MINOR_DISABILITY)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 2)))

(defrule RE-72
    (UserInputWrapper {userInput == (Disabilities.SEVERE_DISABILITY)} )
    => (add (new UserOutputWrapper (Condition.NEW) 3)))

(defrule RE-73
    (UserInputWrapper {userInput == (Disabilities.SEVERE_DISABILITY)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 2)))

;Repair skills rules

(defrule RE-74
    (UserInputWrapper {userInput == (RepairSkills.REPAIR_OR_CONSTRUCTION_EDUCATION)} )
    => (add (new UserOutputWrapper (Condition.IN_NEED_OF_REPAIR) 3)))

(defrule RE-75
    (UserInputWrapper {userInput == (RepairSkills.SOME_PROFICIENCY_IN_REPAIRS)} )
    => (add (new UserOutputWrapper (Condition.IN_NEED_OF_REPAIR) 1)))

(defrule RE-76
    (UserInputWrapper {userInput == (RepairSkills.SOME_PROFICIENCY_IN_REPAIRS)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 2)))

(defrule RE-77
    (UserInputWrapper {userInput == (RepairSkills.NO_PROFICIENCY_IN_FAMILY)} )
    => (add (new UserOutputWrapper (Condition.RENOVATED) 2)))

(defrule RE-78
    (UserInputWrapper {userInput == (RepairSkills.NO_PROFICIENCY_IN_FAMILY)} )
    => (add (new UserOutputWrapper (Condition.NEW) 3)))

(defrule RE-79
    (UserInputWrapper {userInput == (RepairSkills.REPAIR_OR_CONSTRUCTION_EDUCATION)} )
    => (add (new UserOutputWrapper (Price.LESS_THAN_200) 3)))

(defrule RE-80
    (UserInputWrapper {userInput == (RepairSkills.REPAIR_OR_CONSTRUCTION_EDUCATION)} )
    => (add (new UserOutputWrapper (Price.FROM_200_TO_500) 2)))

(defrule RE-81
    (UserInputWrapper {userInput == (RepairSkills.REPAIR_OR_CONSTRUCTION_EDUCATION)} )
    => (add (new UserOutputWrapper (Price.FROM_1200_TO_50000) 3)))

(defrule RE-82
    (UserInputWrapper {userInput == (RepairSkills.NO_PROFICIENCY_IN_FAMILY)} )
    => (add (new UserOutputWrapper (Price.LESS_THAN_200) 2)))

(defrule RE-83
    (UserInputWrapper {userInput == (RepairSkills.SOME_PROFICIENCY_IN_REPAIRS)} )
    => (add (new UserOutputWrapper (Price.FROM_200_TO_500) 3)))

(defrule RE-84
    (UserInputWrapper {userInput == (RepairSkills.SOME_PROFICIENCY_IN_REPAIRS)} )
    => (add (new UserOutputWrapper (Price.FROM_1200_TO_50000) 2)))

(defrule RE-85
    (UserInputWrapper {userInput == (RepairSkills.SOME_PROFICIENCY_IN_REPAIRS)} )
    => (add (new UserOutputWrapper (Price.FROM_50000_TO_250000) 1)))

(defrule RE-86
    (UserInputWrapper {userInput == (RepairSkills.NO_PROFICIENCY_IN_FAMILY)} )
    => (add (new UserOutputWrapper (Price.FROM_500_TO_1200) 3)))

(defrule RE-87
    (UserInputWrapper {userInput == (RepairSkills.NO_PROFICIENCY_IN_FAMILY)} )
    => (add (new UserOutputWrapper (Price.FROM_1200_TO_50000) 2)))

(defrule RE-88
    (UserInputWrapper {userInput == (RepairSkills.NO_PROFICIENCY_IN_FAMILY)} )
    => (add (new UserOutputWrapper (Price.FROM_50000_TO_250000) 1)))

(defrule RE-89
    (UserInputWrapper {userInput == (RepairSkills.NO_PROFICIENCY_IN_FAMILY)} )
    => (add (new UserOutputWrapper (Price.MORE_THAN_250000) 3)))

;Hobbies rules
(defrule RE-90
    (UserInputWrapper {userInput == (Hobbies.NONE_OR_NO_SPECIAL_CONDITIONS_NEEDED)} )
    => (add (new UserOutputWrapper (PlotSize.LESS_THAN_500) 3)))

(defrule RE-91
    (UserInputWrapper {userInput == (Hobbies.LARGE_AREA_NEEDED)} )
    => (add (new UserOutputWrapper (PlotSize.FROM_500_TO_1500) 2)))

(defrule RE-92
    (UserInputWrapper {userInput == (Hobbies.LARGE_AREA_NEEDED)} )
    => (add (new UserOutputWrapper (PlotSize.MORE_THAN_1500) 3)))

(defrule RE-93
    (UserInputWrapper {userInput == (Hobbies.NOISY)} )
    => (add (new UserOutputWrapper (PlotSize.FROM_500_TO_1500) 2)))

(defrule RE-94
    (UserInputWrapper {userInput == (Hobbies.NOISY)} )
    => (add (new UserOutputWrapper (PlotSize.MORE_THAN_1500) 3)))

(defrule RE-95
    (UserInputWrapper {userInput == (Hobbies.NONE_OR_NO_SPECIAL_CONDITIONS_NEEDED)} )
    => (add (new UserOutputWrapper (RealEstateType.FLAT) 3)))

(defrule RE-96
    (UserInputWrapper {userInput == (Hobbies.NONE_OR_NO_SPECIAL_CONDITIONS_NEEDED)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 2)))

(defrule RE-97
    (UserInputWrapper {userInput == (Hobbies.LARGE_AREA_NEEDED)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 2)))

(defrule RE-98
    (UserInputWrapper {userInput == (Hobbies.LARGE_AREA_NEEDED)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 3)))

(defrule RE-99
    (UserInputWrapper {userInput == (Hobbies.NOISY)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 3)))

;School travel time rules
(defrule RE-100
    (UserInputWrapper {userInput == (SchoolTravelTime.MAX_OF_15_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 3)))

(defrule RE-101
    (UserInputWrapper {userInput == (SchoolTravelTime.MAX_OF_15_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KRISTIINE) 1)))

(defrule RE-102
    (UserInputWrapper {userInput == (SchoolTravelTime.MAX_OF_15_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.MUSTAMAE) 3)))

(defrule RE-103
    (UserInputWrapper {userInput == (SchoolTravelTime.MAX_OF_15_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.PIRITA) 1)))

(defrule RE-104
    (UserInputWrapper {userInput == (SchoolTravelTime.FROM_15_TO_45_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 3)))

(defrule RE-105
    (UserInputWrapper {userInput == (SchoolTravelTime.FROM_15_TO_45_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KRISTIINE) 2)))

(defrule RE-106
    (UserInputWrapper {userInput == (SchoolTravelTime.FROM_15_TO_45_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.MUSTAMAE) 3)))

(defrule RE-107
    (UserInputWrapper {userInput == (SchoolTravelTime.FROM_15_TO_45_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.LASNAMAE) 1)))

(defrule RE-108
    (UserInputWrapper {userInput == (SchoolTravelTime.FROM_15_TO_45_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.PIRITA) 2)))

(defrule RE-109
    (UserInputWrapper {userInput == (SchoolTravelTime.MORE_THAN_45_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.LASNAMAE) 3)))

(defrule RE-110
    (UserInputWrapper {userInput == (SchoolTravelTime.MORE_THAN_45_MIN)} )
    => (add (new UserOutputWrapper (RealEstateLocation.PIRITA) 2)))

;Current school rules
(defrule RE-111
    (UserInputWrapper {userInput == (CurrentSchool.TALLINN_UNIVERSITY_OF_TECHNOLOGY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 1)))

(defrule RE-112
    (UserInputWrapper {userInput == (CurrentSchool.TALLINN_UNIVERSITY_OF_TECHNOLOGY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KRISTIINE) 2)))

(defrule RE-113
    (UserInputWrapper {userInput == (CurrentSchool.TALLINN_UNIVERSITY_OF_TECHNOLOGY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.MUSTAMAE) 3)))

(defrule RE-114
    (UserInputWrapper {userInput == (CurrentSchool.TALLINN_UNIVERSITY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 3)))

(defrule RE-115
    (UserInputWrapper {userInput == (CurrentSchool.TALLINN_UNIVERSITY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KRISTIINE) 2)))

(defrule RE-116
    (UserInputWrapper {userInput == (CurrentSchool.TALLINN_UNIVERSITY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 3)))

(defrule RE-117
    (UserInputWrapper {userInput == (CurrentSchool.TALLINN_UNIVERSITY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.PIRITA) 1)))

;Time required for heating rules
(defrule RE-118
    (UserInputWrapper {userInput == (TimeRequiredForHeating.LESS_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (RealEstateType.FLAT) 3)))

(defrule RE-119
    (UserInputWrapper {userInput == (TimeRequiredForHeating.LESS_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 2)))

(defrule RE-120
    (UserInputWrapper {userInput == (TimeRequiredForHeating.MORE_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 2)))

(defrule RE-121
    (UserInputWrapper {userInput == (TimeRequiredForHeating.MORE_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 3)))

(defrule RE-122
    (UserInputWrapper {userInput == (TimeRequiredForHeating.NONE)} )
    => (add (new UserOutputWrapper (RealEstateType.FLAT) 3)))

(defrule RE-123
    (UserInputWrapper {userInput == (TimeRequiredForHeating.LESS_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (NumberOfRooms.ONE) 3)))

(defrule RE-124
    (UserInputWrapper {userInput == (TimeRequiredForHeating.LESS_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 2)))

(defrule RE-125
    (UserInputWrapper {userInput == (TimeRequiredForHeating.LESS_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 1)))

(defrule RE-126
    (UserInputWrapper {userInput == (TimeRequiredForHeating.MORE_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 1)))

(defrule RE-127
    (UserInputWrapper {userInput == (TimeRequiredForHeating.MORE_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 2)))

(defrule RE-128
    (UserInputWrapper {userInput == (TimeRequiredForHeating.MORE_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (NumberOfRooms.FOUR) 3)))

(defrule RE-129
    (UserInputWrapper {userInput == (TimeRequiredForHeating.MORE_THAN_1_HOUR)} )
    => (add (new UserOutputWrapper (NumberOfRooms.MORE_THAN_FOUR) 3)))

(defrule RE-130
    (UserInputWrapper {userInput == (TimeRequiredForHeating.NONE)} )
    => (add (new UserOutputWrapper (NumberOfRooms.ONE) 3)))

(defrule RE-131
    (UserInputWrapper {userInput == (TimeRequiredForHeating.NONE)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 2)))

;Marital Status rules
(defrule RE-132
    (UserInputWrapper {userInput == (MaritalStatus.SINGLE)} )
    => (add (new UserOutputWrapper (PlotSize.LESS_THAN_500) 3)))

(defrule RE-133
    (UserInputWrapper {userInput == (MaritalStatus.COHABITING)} )
    => (add (new UserOutputWrapper (PlotSize.FROM_500_TO_1500) 3)))

(defrule RE-134
    (UserInputWrapper {userInput == (MaritalStatus.COHABITING)} )
    => (add (new UserOutputWrapper (PlotSize.MORE_THAN_1500) 1)))

(defrule RE-135
    (UserInputWrapper {userInput == (MaritalStatus.MARRIED)} )
    => (add (new UserOutputWrapper (PlotSize.FROM_500_TO_1500) 1)))

(defrule RE-136
    (UserInputWrapper {userInput == (MaritalStatus.MARRIED)} )
    => (add (new UserOutputWrapper (PlotSize.MORE_THAN_1500) 3)))

(defrule RE-137
    (UserInputWrapper {userInput == (MaritalStatus.SINGLE)} )
    => (add (new UserOutputWrapper (NumberOfRooms.ONE) 2)))

(defrule RE-138
    (UserInputWrapper {userInput == (MaritalStatus.SINGLE)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 3)))

(defrule RE-139
    (UserInputWrapper {userInput == (MaritalStatus.COHABITING)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 1)))

(defrule RE-140
    (UserInputWrapper {userInput == (MaritalStatus.COHABITING)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 3)))

(defrule RE-141
    (UserInputWrapper {userInput == (MaritalStatus.COHABITING)} )
    => (add (new UserOutputWrapper (NumberOfRooms.FOUR) 2)))

(defrule RE-142
    (UserInputWrapper {userInput == (MaritalStatus.MARRIED)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 2)))

(defrule RE-143
    (UserInputWrapper {userInput == (MaritalStatus.MARRIED)} )
    => (add (new UserOutputWrapper (NumberOfRooms.FOUR) 3)))

(defrule RE-144
    (UserInputWrapper {userInput == (MaritalStatus.MARRIED)} )
    => (add (new UserOutputWrapper (NumberOfRooms.MORE_THAN_FOUR) 2)))

;Car availability rules
(defrule RE-145
    (UserInputWrapper {userInput == (CarAvailability.ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KRISTIINE) 3)))

(defrule RE-146
    (UserInputWrapper {userInput == (CarAvailability.ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 2)))

(defrule RE-147
    (UserInputWrapper {userInput == (CarAvailability.ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.MUSTAMAE) 2)))

(defrule RE-148
    (UserInputWrapper {userInput == (CarAvailability.ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.LASNAMAE) 1)))

(defrule RE-149
    (UserInputWrapper {userInput == (CarAvailability.ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.PIRITA) 3)))

(defrule RE-150
    (UserInputWrapper {userInput == (CarAvailability.MORE_THAN_ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.LASNAMAE) 2)))

(defrule RE-151
    (UserInputWrapper {userInput == (CarAvailability.MORE_THAN_ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.PIRITA) 3)))

(defrule RE-152
    (UserInputWrapper {userInput == (CarAvailability.NO_CAR)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KESKLINN) 3)))

(defrule RE-153
    (UserInputWrapper {userInput == (CarAvailability.MORE_THAN_ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.KRISTIINE) 1)))

(defrule RE-154
    (UserInputWrapper {userInput == (CarAvailability.MORE_THAN_ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateLocation.MUSTAMAE) 3)))

(defrule RE-155
    (UserInputWrapper {userInput == (CarAvailability.ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 2)))

(defrule RE-156
    (UserInputWrapper {userInput == (CarAvailability.ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 3)))

(defrule RE-157
    (UserInputWrapper {userInput == (CarAvailability.MORE_THAN_ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateType.TERRACED) 1)))

(defrule RE-158
    (UserInputWrapper {userInput == (CarAvailability.MORE_THAN_ONE_CAR_IN_FAMILY)} )
    => (add (new UserOutputWrapper (RealEstateType.HOUSE) 3)))

(defrule RE-159
    (UserInputWrapper {userInput == (CarAvailability.NO_CAR)} )
    => (add (new UserOutputWrapper (RealEstateType.FLAT) 3)))

;Children age rules
(defrule RE-160
    (UserInputWrapper {userInput == (ChildrenAged.NONE)} )
    => (add (new UserOutputWrapper (NumberOfRooms.ONE) 1)))

(defrule RE-161
    (UserInputWrapper {userInput == (ChildrenAged.NONE)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 3)))

(defrule RE-162
    (UserInputWrapper {userInput == (ChildrenAged.NONE)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 2)))

(defrule RE-163
    (UserInputWrapper {userInput == (ChildrenAged.INFANTS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 3)))

(defrule RE-164
    (UserInputWrapper {userInput == (ChildrenAged.INFANTS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.FOUR) 2)))

(defrule RE-165
    (UserInputWrapper {userInput == (ChildrenAged.TEENAGERS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 1)))

(defrule RE-166
    (UserInputWrapper {userInput == (ChildrenAged.TEENAGERS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.FOUR) 3)))

(defrule RE-167
    (UserInputWrapper {userInput == (ChildrenAged.TEENAGERS)} )
    => (add (new UserOutputWrapper (NumberOfRooms.MORE_THAN_FOUR) 2)))

(defrule RE-168
    (UserInputWrapper {userInput == (ChildrenAged.GROWN_UP_AND_LIVING_SEPARATELY)} )
    => (add (new UserOutputWrapper (NumberOfRooms.ONE) 1)))

(defrule RE-169
    (UserInputWrapper {userInput == (ChildrenAged.GROWN_UP_AND_LIVING_SEPARATELY)} )
    => (add (new UserOutputWrapper (NumberOfRooms.TWO) 3)))

(defrule RE-170
    (UserInputWrapper {userInput == (ChildrenAged.GROWN_UP_AND_LIVING_SEPARATELY)} )
    => (add (new UserOutputWrapper (NumberOfRooms.THREE) 2)))

(defrule RE-171
    (UserInputWrapper {userInput == (ChildrenAged.INFANTS)} )
    => (add (new UserOutputWrapper (TotalArea.FROM_50_TO_100) 2)))

(defrule RE-172
    (UserInputWrapper {userInput == (ChildrenAged.INFANTS)} )
    => (add (new UserOutputWrapper (TotalArea.FROM_100_TO_250) 3)))

(defrule RE-173
    (UserInputWrapper {userInput == (ChildrenAged.TEENAGERS)} )
    => (add (new UserOutputWrapper (TotalArea.FROM_50_TO_100) 1)))

(defrule RE-174
    (UserInputWrapper {userInput == (ChildrenAged.TEENAGERS)} )
    => (add (new UserOutputWrapper (TotalArea.FROM_100_TO_250) 2)))

(defrule RE-175
    (UserInputWrapper {userInput == (ChildrenAged.TEENAGERS)} )
    => (add (new UserOutputWrapper (TotalArea.MORE_THAN_250) 3)))

(defrule RE-176
    (UserInputWrapper {userInput == (ChildrenAged.GROWN_UP_AND_LIVING_SEPARATELY)} )
    => (add (new UserOutputWrapper (TotalArea.LESS_THAN_50) 1)))

(defrule RE-177
    (UserInputWrapper {userInput == (ChildrenAged.GROWN_UP_AND_LIVING_SEPARATELY)} )
    => (add (new UserOutputWrapper (TotalArea.FROM_50_TO_100) 3)))

;Ready to buy rules
(defrule RE-178
    (UserInputWrapper {userInput == (ReadyToBuy.YES)} )
    => (add (new UserOutputWrapper (TransactionType.SALE) 3)))

(defrule RE-179
    (UserInputWrapper {userInput == (ReadyToBuy.IF_POSSIBLE)} )
    => (add (new UserOutputWrapper (TransactionType.SALE) 3)))

(defrule RE-180
    (UserInputWrapper {userInput == (ReadyToBuy.IF_POSSIBLE)} )
    => (add (new UserOutputWrapper (TransactionType.RENT) 2)))

(defrule RE-181
    (UserInputWrapper {userInput == (ReadyToBuy.NO)} )
    => (add (new UserOutputWrapper (TransactionType.RENT) 3)))
