package com.avios.statistics.dataprep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.avios.statistics.domain.Match;

public class DataPrepHelper {

	private DataAggregator dataAggregator = new DataAggregator();

	private String DELIVERIES = "deliveries";
	private String MATCHES = "matches";

	public Map<String, Match> getDataFromFiles() {

		readDataFromMatchesFile();
		
		readDataFromDeliveriesFile();

		return dataAggregator.getAggregatedData();
	}

	private void readDataFromDeliveriesFile() {

		FileReader fileReader = null;
		BufferedReader br = null;

		try {
			fileReader = new FileReader(getfile(DELIVERIES));
			br = new BufferedReader(fileReader);

			String deliveryLine = br.readLine();
			deliveryLine = br.readLine();

			while (null != deliveryLine) {

				dataAggregator.aggregateDeliveriesData(deliveryLine);
				deliveryLine = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void readDataFromMatchesFile() {

		FileReader fileReader = null;
		BufferedReader br = null;

		try {
			fileReader = new FileReader(getfile(MATCHES));
			br = new BufferedReader(fileReader);

			String matchLine = br.readLine();
			matchLine = br.readLine();

			while (null != matchLine) {

				dataAggregator.aggregateMatchData(matchLine);
				matchLine = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private File getfile(String fileName) {

		File file = null;
		file = new File("iplDataSet/" + fileName + ".csv");
		return file;
	}
	
}
