package org.sonatype.mavenbook.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {
	
	private static Logger logger = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve (int zipcode) throws Exception{
		logger.debug("Retrieving Weather Data");
		String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;
		URLConnection conn = new URL(url).openConnection();
		return conn.getInputStream();
	}
}
