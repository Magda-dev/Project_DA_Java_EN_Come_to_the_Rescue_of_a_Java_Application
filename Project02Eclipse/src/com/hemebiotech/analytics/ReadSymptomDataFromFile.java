package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private String filepath;
	public List<String> symptoms;

	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}



	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public HashMap<String, Integer> countSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
		HashMap<String, Integer> symptomsAnalytics = new HashMap<>();
		for( String line : symptoms) {
			System.out.println( "1" +line );
			if (symptomsAnalytics.containsKey(line)) {
				symptomsAnalytics.get(line);
				symptomsAnalytics.merge(line, 1, Integer::sum);
				System.out.println("2" + symptomsAnalytics);
			}
			else {
				symptomsAnalytics.put(line, 1);
				System.out.println("3" +symptomsAnalytics);
			}
		}
		return symptomsAnalytics;
	}




	@Override
	public void exportSymptoms(HashMap<String, Integer> analyticsResult) {

	}

}
