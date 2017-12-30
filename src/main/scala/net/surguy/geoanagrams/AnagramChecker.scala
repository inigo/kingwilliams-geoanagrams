package net.surguy.geoanagrams

/**
  *
  */
class AnagramChecker(cityLookup: CityLookup) {
  private val maxWords = 4

  def lookupSentence(s: String): Stream[City] = {
    findCandidates(s.replaceAll("[^A-Za-z ]","").toLowerCase).flatMap(anagrams).map(cityLookup.lookup).collect{ case Some(c) => println(c); c }
  }

  private[geoanagrams] def anagrams(s: String): Seq[String] = s.permutations.toSeq

  private[geoanagrams] def findCandidates(s: String): Stream[String] = {
    val words = s.split("\\s+").toList
    val allCandidates = for (count <- 1 to maxWords) yield {
      words.sliding(count).map(_.mkString)
    }
    allCandidates.flatten.toStream
  }

}