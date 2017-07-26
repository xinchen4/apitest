package org.sonatype.mavenbook.weather;

import java.io.InputStream;

public class WeatherService {

	public WeatherService() {
	}

	public String retrieveForcast(String zip) throws Exception {
		InputStream in = new YahooRetriever().retrieve(1);
		Weather weather = new YahooParser().parse(in);
		return new WeatherFormatter().format(weather);
	}
}
