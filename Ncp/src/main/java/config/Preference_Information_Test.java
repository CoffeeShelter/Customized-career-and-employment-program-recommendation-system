package config;

import data.utils.ProgramUtils;
import rlogic.Rlogic;

public class Preference_Information_Test {

	public static void main(String[] args) {
		Rlogic rLogic = new Rlogic();
		ProgramUtils programUtils = new ProgramUtils();
		
		rLogic.getReccomendationResult("202011346");
	}
}