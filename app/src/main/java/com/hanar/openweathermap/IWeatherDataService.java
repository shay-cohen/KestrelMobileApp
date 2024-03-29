
package com.hanar.openweathermap;

/**
 * The Interface IWeatherDataService.
 * An Interface for the developers.
 * Contains methods for weather analyzing.
 *
 *  @author Shay Cohen and Lior Krengel and Aviv Shrem.
 */

public interface IWeatherDataService {


/**
	 * Gets the weather data.
	 *
	 * @param  lon,lat (Location)
	 * @return WeatherData which includes the weather information.
	 * @throws WeatherDataServiceException
	 */

	public abstract WeatherData getWeatherData(Double lon, Double lat)throws WeatherDataServiceException;
}

