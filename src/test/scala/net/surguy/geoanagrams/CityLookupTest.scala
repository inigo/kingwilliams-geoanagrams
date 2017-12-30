package net.surguy.geoanagrams

import org.specs2.mutable.Specification

class CityLookupTest extends Specification {

  private lazy val cityLookup = new CityLookup(new GeonamesCityReader("/cities15000.txt"))

  "looking up cities" should {
    "find an existing city by name" in {cityLookup.lookup("london") must beSome[City] }
    "find an existing city by name ignoring spaces" in {cityLookup.lookup("woodfordgreen") must beSome[City] }
    "not find nonexistent cities" in {cityLookup.lookup("NoSuchThing") must beNone }
  }

}
