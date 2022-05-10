package config;

import java.util.List;
import java.util.Map;

import rlogic.Recommendation_Program;

public class Preference_Information_Test {

	public static void main(String[] args) {
		// 201910823
		// 202011346
		
		Recommendation_Program recoProgram = new Recommendation_Program();
		List<Map<String, String>> datum = recoProgram.getPrettyRecommendation("12001");

		for(Map<String, String> data : datum) {
			System.out.println(data.toString());
		}
		
	}
}