package com.countdistinct.countdistinctproblem;

import net.agkn.hll.HLL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class CountDistinctProblemApplication {

	private static final String RESOURCE = "src/main/resources/IP-list.txt";

	public static void main(String[] args) {
		SpringApplication.run(CountDistinctProblemApplication.class, args);

		getDistinctIPCount();
	}

	private static void getDistinctIPCount() {
		BufferedReader reader;

		try {
			HLL hll = new HLL(14, 5);
			reader = new BufferedReader(new FileReader(RESOURCE));
			String line = reader.readLine();
			while (line != null) {
				hll.addRaw(line.hashCode());
				// read next line
				line = reader.readLine();
			}
			reader.close();
			System.out.println("Distinct IP count is " + hll.cardinality());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
