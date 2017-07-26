package org.sonatype.mavenbook.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sonatype.mavenbook.weather.WeatherService;

public class WeatherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String zip = req.getParameter("zip");
		WeatherService weatherService = new WeatherService();
		PrintWriter out = resp.getWriter();
		try {
			out.println(weatherService.retrieveForcast(zip));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("service error!!");
		}
		out.flush();
		out.close();
	}

}
