package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.WeatherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WeatherController {
	private WeatherService weatherService;

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
    public String listByScenario(@PathVariable String zip,Model model){
        model.addAttribute("zipcode", zip);
        
        return "case/list";
    }
}
