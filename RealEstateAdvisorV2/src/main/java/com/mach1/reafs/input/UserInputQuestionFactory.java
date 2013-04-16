package com.mach1.reafs.input;

import java.util.ArrayList;
import java.util.List;

import com.mach1.reafs.input.types.CarAvailability;
import com.mach1.reafs.input.types.ChildrenAged;
import com.mach1.reafs.input.types.CurrentSchool;
import com.mach1.reafs.input.types.Disabilities;
import com.mach1.reafs.input.types.DistanceFromTheNeighbors;
import com.mach1.reafs.input.types.DistanceFromTheSea;
import com.mach1.reafs.input.types.FamilySize;
import com.mach1.reafs.input.types.Hobbies;
import com.mach1.reafs.input.types.Income;
import com.mach1.reafs.input.types.MaritalStatus;
import com.mach1.reafs.input.types.ReadyToBuy;
import com.mach1.reafs.input.types.RepairSkills;
import com.mach1.reafs.input.types.SchoolTravelTime;
import com.mach1.reafs.input.types.Silence;
import com.mach1.reafs.input.types.TimeRequiredForHeating;

public class UserInputQuestionFactory {
	private static UserInputQuestionFactory instance;

	static {
		instance = new UserInputQuestionFactory();
	}

	public static UserInputQuestionFactory getInstance() {
		return instance;
	}

	public List<UserInputQuestion> getUserInputQuestions() {
		List<UserInputQuestion> userInputQuestions = new ArrayList<UserInputQuestion>();
		
		List<UserInputAnswer> userInputAnswers;
		//DistanceFromTheNeighbors
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Samas majas", 
				DistanceFromTheNeighbors.SAME_BUILDING.toString()));
		userInputAnswers.add(new UserInputAnswer("Paarisaja meetri raadiuses", 
				DistanceFromTheNeighbors.FEW_HUNDRED_METERS.toString()));
		userInputAnswers.add(new UserInputAnswer("Kaugemal kui 1km", 
				DistanceFromTheNeighbors.MORE_THAN_1_KM.toString()));
		userInputQuestions.add(new UserInputQuestion("Lähimad naabrid peaksid asuma...", 
				userInputAnswers));
		
		//DistanceFromTheSea
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Peaks paistma aknast", 
				DistanceFromTheSea.VISIBLE_FROM_WINDOW.toString()));
		userInputAnswers.add(new UserInputAnswer("Peaks olema jalutuskäigu kaugusel", 
				DistanceFromTheSea.A_WALK_AWAY.toString()));
		userInputAnswers.add(new UserInputAnswer("Mere lähedus pole oluline", 
				DistanceFromTheSea.NOT_IMPORTANT.toString()));
		userInputQuestions.add(new UserInputQuestion("Meri...", 
				userInputAnswers));
		
		//FamilySize
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("1 liige", 
				FamilySize.ONE_MEMBER.toString()));
		userInputAnswers.add(new UserInputAnswer("2-4 liiget", 
				FamilySize.TWO_TO_FOUR_MEMBERS.toString()));
		userInputAnswers.add(new UserInputAnswer("5 või rohkem liiget", 
				FamilySize.FIVE_OR_MORE_MEMBERS.toString()));
		userInputQuestions.add(new UserInputQuestion("Kodu otsiva pere suurus on...", 
				userInputAnswers));
		
		//Income
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("< 500€", 
				Income.LESS_THAN_500.toString()));
		userInputAnswers.add(new UserInputAnswer("500€ < sissetulek < 1200€", 
				Income.BETWEEN_500_AND_1200.toString()));
		userInputAnswers.add(new UserInputAnswer("1201€ < sissetulek < 4000€", 
				Income.BETWEEN_1200_AND_4000.toString()));
		userInputAnswers.add(new UserInputAnswer(">4000€", 
				Income.MORE_THAN_4000.toString()));
		userInputQuestions.add(new UserInputQuestion("Perekonna sissetulek kuus on...", 
				userInputAnswers));

		//Silence
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("On minu jaoks väga oluline", 
				Silence.VERY_IMPORTANT.toString()));
		userInputAnswers.add(new UserInputAnswer("Meeldib aegajalt vaikuses/looduses jalutada", 
				Silence.LIKE_TO_WALK_IN_SILENCE_TIME_TO_TIME.toString()));
		userInputAnswers.add(new UserInputAnswer("Pole mulle vajalik ega minu loomuses", 
				Silence.NOT_NECESSARY.toString()));
		userInputQuestions.add(new UserInputQuestion("Vaikus...", 
				userInputAnswers));
		
		//Disabilities
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Ei esine puudeid", 
				Disabilities.NONE.toString()));
		userInputAnswers.add(new UserInputAnswer("Esineb kerge puue", 
				Disabilities.MINOR_DISABILITY.toString()));
		userInputAnswers.add(new UserInputAnswer("Esineb raske või liitpuue", 
				Disabilities.SEVERE_DISABILITY.toString()));
		userInputQuestions.add(new UserInputQuestion("Minu perekonnaliikmetel...", 
				userInputAnswers));
		
		//RepairSkills
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Kellel on remondi- või ehitusalane haridus", 
				RepairSkills.REPAIR_OR_CONSTRUCTION_EDUCATION.toString()));
		userInputAnswers.add(new UserInputAnswer("Mõningad oskused remondi- või ehitusalal", 
				RepairSkills.SOME_PROFICIENCY_IN_REPAIRS.toString()));
		userInputAnswers.add(new UserInputAnswer("Remondi- või ehitusalased oskused minu perekonnaliikmete hulgas puuduvad", 
				RepairSkills.NO_PROFICIENCY_IN_FAMILY.toString()));
		userInputQuestions.add(new UserInputQuestion("Minu perekonnaliikmete hulgas on inimesi...", 
				userInputAnswers));
		
		//Hobbies
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Hobid puuduvad või ei vaja eritingimusi(lugemine, kudumine) ", 
				Hobbies.NONE_OR_NO_SPECIAL_CONDITIONS_NEEDED.toString()));
		userInputAnswers.add(new UserInputAnswer("Hobid, mis vajavad suurt ala(jalgpall, golf, aiandus)", 
				Hobbies.LARGE_AREA_NEEDED.toString()));
		userInputAnswers.add(new UserInputAnswer("Hobid, mis tekitavad müra (motohuvi, muusika)", 
				Hobbies.NOISY.toString()));
		userInputQuestions.add(new UserInputQuestion("Hobid...", 
				userInputAnswers));
		
		//SchoolTravelTime
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Maksimaalselt 15 minutit", 
				SchoolTravelTime.MAX_OF_15_MIN.toString()));
		userInputAnswers.add(new UserInputAnswer("15 – 45 minutit", 
				SchoolTravelTime.FROM_15_TO_45_MIN.toString()));
		userInputAnswers.add(new UserInputAnswer("Rohkem kui 45 minutit", 
				SchoolTravelTime.MORE_THAN_45_MIN.toString()));
		userInputQuestions.add(new UserInputQuestion("Maksimaalne lubatud aeg kooli sõitmiseks...", 
				userInputAnswers));
		
		//CurrentSchool
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Tallinna Tehnikaülikool", 
				CurrentSchool.TALLINN_UNIVERSITY_OF_TECHNOLOGY.toString()));
		userInputAnswers.add(new UserInputAnswer("Tallinna Ülikool", 
				CurrentSchool.TALLINN_UNIVERSITY.toString()));
		userInputQuestions.add(new UserInputQuestion("Kus koolis õpid?", 
				userInputAnswers));
		
		//TimeRequiredForHeating
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Vähem kui tund aega", 
				TimeRequiredForHeating.LESS_THAN_1_HOUR.toString()));
		userInputAnswers.add(new UserInputAnswer("Rohkem kui tund aega", 
				TimeRequiredForHeating.MORE_THAN_1_HOUR.toString()));
		userInputAnswers.add(new UserInputAnswer("Kütmisele aega ei tohi kuluda", 
				TimeRequiredForHeating.NONE.toString()));
		userInputQuestions.add(new UserInputQuestion("Keskmine päevane maksimaalne lubatud aeg hoone kütmisele...", 
				userInputAnswers));
		
		//MaritalStatus
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Vallaline", 
				MaritalStatus.SINGLE.toString()));
		userInputAnswers.add(new UserInputAnswer("Vabaabielu", 
				MaritalStatus.COHABITING.toString()));
		userInputAnswers.add(new UserInputAnswer("Abielus", 
				MaritalStatus.MARRIED.toString()));
		userInputQuestions.add(new UserInputQuestion("Perekonnaseis...", 
				userInputAnswers));
		
		//CarAvailability
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Jah, peres on 1 auto", 
				CarAvailability.ONE_CAR_IN_FAMILY.toString()));
		userInputAnswers.add(new UserInputAnswer("Jah, peres on rohkem kui 1 auto", 
				CarAvailability.MORE_THAN_ONE_CAR_IN_FAMILY.toString()));
		userInputAnswers.add(new UserInputAnswer("Ei, auto puudub", 
				CarAvailability.NO_CAR.toString()));
		userInputQuestions.add(new UserInputQuestion("Auto olemasolu...", 
				userInputAnswers));
		
		//ChildrenAged
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Lapsi pole", 
				ChildrenAged.NONE.toString()));
		userInputAnswers.add(new UserInputAnswer("Laps/lapsed on imikueas", 
				ChildrenAged.INFANTS.toString()));
		userInputAnswers.add(new UserInputAnswer("Laps/lapsed on teismeeas", 
				ChildrenAged.TEENAGERS.toString()));
		userInputAnswers.add(new UserInputAnswer("Laps/lapsed on täiskasvanud ja elavad eraldi", 
				ChildrenAged.GROWN_UP_AND_LIVING_SEPARATELY.toString()));
		userInputQuestions.add(new UserInputQuestion("Laste vanused on...", 
				userInputAnswers));
		
		//ReadyToBuy
		userInputAnswers = new ArrayList<UserInputAnswer>();
		userInputAnswers.add(new UserInputAnswer("Jah, soovime osta", 
				ReadyToBuy.YES.toString()));
		userInputAnswers.add(new UserInputAnswer("Esialgu plaan puudub, kuid võimalusel soovime osta", 
				ReadyToBuy.IF_POSSIBLE.toString()));
		userInputAnswers.add(new UserInputAnswer("Kindlasti ei soovi osta", 
				ReadyToBuy.NO.toString()));
		userInputQuestions.add(new UserInputQuestion("Kinnisvaraobjekti ostuvalmidus...", 
				userInputAnswers));
						
		return userInputQuestions;
	}
}