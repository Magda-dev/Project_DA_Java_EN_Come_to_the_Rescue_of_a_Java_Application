package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {


	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile readSymptomData = new ReadSymptomDataFromFile(new File("Project02Eclipse/symptoms.txt").getAbsolutePath());
		// lire le fichier et extraire les symptomes
		List<String> symptoms = readSymptomData.getSymptoms();
		// compter les symptomes (j'ai du caster les arguments pourquoi ? faire recherches)
		HashMap<String, Integer> symptomsAnalytics = readSymptomData.countSymptoms((ArrayList<String>) symptoms);

		//Exporter les symptomes
		readSymptomData.exportSymptoms((HashMap<String, Integer>)symptomsAnalytics);
		//donner un nom de fichier en parametre (à formatter)










		HashMap<String, Integer> symptomsMap = new HashMap<>();

/**
		int i = 0;    // set i to 0
		int headCount = 0;    // counts headaches
		Symptom symptom = null;
		while (line != null) {

			i++;    // increment i
			//System.out.println("symptom from file: " + line);
			if (symptomsMap.containsKey(line)) {
				symptomsMap.get(line);
				symptomsMap.merge(line, 1, Integer::sum);


			} else {
				symptom = new Symptom(line, 1);

				symptomsMap.put(line, symptomCounter);

			}
			line = reader.readLine();    // get another symptom

		}
		System.out.println(symptomsMap);
		// next generate output
		FileWriter writer = new FileWriter("result.out");

		writer.write(symptom + " : " + String.valueOf(symptomCounter));
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}*/
}
}