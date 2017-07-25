package org.sonatype.mavenbook.weather;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class WeatherFormatter {

	private static Logger logger = Logger.getLogger(WeatherFormatter.class);

	public String format (Weather weather) throws ParseErrorException, MethodInvocationException, ResourceNotFoundException, IOException{
		
		logger.info("formatting weather!");
		Reader reader = new InputStreamReader(getClass().getResourceAsStream("output.vm"));
		VelocityContext context = new VelocityContext();
		context.put("weather", weather);
		StringWriter writer = new StringWriter();
		Velocity.evaluate(context, writer, "", reader);
		
		return writer.toString();
		
	}

}
