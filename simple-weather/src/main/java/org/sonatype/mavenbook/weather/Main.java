package org.sonatype.mavenbook.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {
	
		private int zipcode;
	public Main(int zip) {
			// TODO Auto-generated constructor stub
		this.zipcode= zip;
		}

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
		
		int zip = 60;
		try {
			zip = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			// Start the program
			new Main(zip).start();
		}

	}

	private void start() throws Exception {
		// TODO Auto-generated method stub
		// Retrieve Data
		InputStream dataIn = new YahooRetriever().retrieve( zipcode );
		// Parse Data
		Weather weather = new YahooParser().parse( dataIn );
		// Format (Print) Data
		System.out.print( new WeatherFormatter().format( weather ) );
	}
}
