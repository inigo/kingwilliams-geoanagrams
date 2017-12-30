package net.surguy.geoanagrams

import org.specs2.mutable.Specification

class GeonamesCityReaderTest extends Specification {

  "reading city names" should {
    "find some cities" in {
      new GeonamesCityReader("/cities15000.txt").allCities() must haveLength(greaterThan(20000))
    }
    "read appropriate values for the first city" in {
      new GeonamesCityReader("/cities15000.txt").allCities().head mustEqual City("3040051", "les Escaldes", "AD", 15853, "Europe/Andorra")
    }
  }

  "reading UK cities" should {
    "find a smaller number of cities" in {
      val cities = new GeonamesCityReader("/cities15000.txt").ukCities()
      cities must haveLength(lessThan(1000))
      cities must haveLength(greaterThan(100))
    }
  }

}
