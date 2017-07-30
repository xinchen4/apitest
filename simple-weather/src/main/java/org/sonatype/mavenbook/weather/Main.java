package org.sonatype.mavenbook.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {
	
		private String zipcode;
	public Main(String zip) {
			// TODO Auto-generated constructor stub
		this.zipcode= zip;
		}

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
		
		String zip = "60";
		try {
			zip = args[0];
		} catch (Exception e) {}
			// Start the program
			System.out.println("in catch block");
			new Main(zip).start();
		

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
