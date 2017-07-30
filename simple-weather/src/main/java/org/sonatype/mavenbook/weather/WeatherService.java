package org.sonatype.mavenbook.weather;

import java.io.InputStream;

public class WeatherService {
	
	private YahooRetriever yahooRetriever;
	private YahooParser yahooParser;

	public WeatherService() {
	}

	public Weather retrieveForcast(String zip) throws Exception {
		InputStream in = yahooRetriever.retrieve(zip);
		Weather weather = yahooParser.parse(in);
		return weather;
	}

	public YahooRetriever getYahooRetriever() {
		return yahooRetriever;
	}

	public void setYahooRetriever(YahooRetriever yahooRetriever) {
		this.yahooRetriever = yahooRetriever;
	}

	public YahooParser getYahooParser() {
		return yahooParser;
	}

	public void setYahooParser(YahooParser yahooParser) {
		this.yahooParser = yahooParser;
	}
	
}
