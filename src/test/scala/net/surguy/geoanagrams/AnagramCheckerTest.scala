package net.surguy.geoanagrams

import org.specs2.mutable.Specification

class AnagramCheckerTest extends Specification {

  private lazy val anagramChecker = new AnagramChecker(new CityLookup(new GeonamesCityReader("/cities15000.txt")))

  "finding anagrams" should {
    "find the right number of anagrams" in { anagramChecker.anagrams("cat") must haveLength(6) }
    "find sensible results" in { anagramChecker.anagrams("cat") must contain(allOf("act", "tac", "act")) }
  }

  "combining words" should {
    "combine multiple words from a sentence" in {
      anagramChecker.findCandidates("Eat tasty pie") must contain(allOf("Eattasty", "tastypie", "Eattastypie", "Eat", "tasty", "pie"))
    }
  }

  "finding anagrams based on places" should {
    "match an actual question" in { anagramChecker.lookupSentence("Although the brewery no longer dominates, the pachydermal weather vane survives").head.name mustEqual "Maidstone"  }
  }

}
