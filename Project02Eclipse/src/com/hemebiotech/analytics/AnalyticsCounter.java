package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {


	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile readSymptomData = new ReadSymptomDataFromFile(new File("Project02Eclipse/symptoms.txt").getAbsolutePath());

		List<String> symptoms = readSymptomData.getSymptoms();
		HashMap<String, Integer> symptomsAnalytics = readSymptomData.countSymptoms((ArrayList<String>) symptoms);
		readSymptomData.exportSymptoms((HashMap<String, Integer>)symptomsAnalytics);

}
}