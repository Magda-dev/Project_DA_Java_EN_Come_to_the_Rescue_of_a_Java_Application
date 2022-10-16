package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private String filepath;
	public List<String> symptoms;
	public HashMap <String, Integer> symptomsAnalytics;
	
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
	public HashMap<String, Integer> countSymptoms(ArrayList<String> symptoms) {
		this.symptoms = symptoms;
		HashMap<String, Integer> symptomsAnalytics = new HashMap<>(); //caste
		for( String line : symptoms) {
			if (symptomsAnalytics.containsKey(line)) {
				symptomsAnalytics.get(line);
				symptomsAnalytics.merge(line, 1, Integer::sum);
			}
			else {
				symptomsAnalytics.put(line, 1);
			}
		}
		return symptomsAnalytics;
	}

	@Override
	public void exportSymptoms(HashMap<String, Integer> symptomsAnalytics) throws IOException {
		final TreeMap<String, Integer> exportFile = new TreeMap<>();
		for(HashMap.Entry<String, Integer> element : symptomsAnalytics.entrySet()) {
			exportFile.put(element.getKey(), element.getValue());
		}
		exportFile.putAll(symptomsAnalytics);
		exportFile.putAll(symptomsAnalytics);
		System.out.println(exportFile);
		FileWriter writer = new FileWriter ("result.out");
		writer.write(String.valueOf(exportFile));
		writer.close();
	}
}

