package net.surguy.geoanagrams

/**
  * A hashmap for fast lookup of city names.
  */
class CityLookup(cityReader: GeonamesCityReader) {

  private val cities: Map[String, City] = cityReader.ukCities().map(c => (escapeName(c.name), c)).toMap

  def lookup(city: String): Option[City] = {
    cities.get(city)
  }

  private def escapeName(s: String) = s.toLowerCase.replaceAll(" ", "")

}
