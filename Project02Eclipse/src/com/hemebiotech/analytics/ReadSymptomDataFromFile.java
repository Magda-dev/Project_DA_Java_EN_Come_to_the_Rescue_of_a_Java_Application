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


	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 *
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}


	/**
	 * get the symptoms from a file,
	 * that may contain many duplications
	 * @return a list of symptoms, 1 symptom per line
	 * @author
	 *
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
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


	/**
	 * get the symptoms list and count how many times they appear,
	 * @return a list of symptom associated with a counter
	 * @format symptom = counter
	 * @author Magdalena
	 *
	 */
	@Override
	public HashMap<String, Integer> countSymptoms(ArrayList<String> symptoms) {
		this.symptoms = symptoms;
		HashMap<String, Integer> symptomsAnalytics = new HashMap<>();

		for( String line : symptoms) {

			if (symptomsAnalytics.containsKey(line)) {
				symptomsAnalytics.get(line);
				symptomsAnalytics.merge(line, 1, Integer::sum);
			} else {
				symptomsAnalytics.put(line, 1);
			}
		}
		return symptomsAnalytics;
	}

	/**
	 * sort symptoms by alphebetical order
	 * Then write them on a file "result.out",
	 * @format symptom : counter, 1 symptom and its counter per line
	 * @author Magdalena
	 *
	 */
	@Override
	public void exportSymptoms(HashMap<String, Integer> symptomsAnalytics) throws IOException {
		final TreeMap<String, Integer> exportData = new TreeMap<>();
		FileWriter resultFile = new FileWriter ("result.out");

		for(HashMap.Entry<String, Integer> element : symptomsAnalytics.entrySet()) {
			exportData.put(element.getKey(), element.getValue());
		}

		for(Map.Entry<String, Integer> element : exportData.entrySet()) {
			resultFile.write(element.getKey() + " : " + element.getValue() +"\n");
		}

		resultFile.close();
	}
}

