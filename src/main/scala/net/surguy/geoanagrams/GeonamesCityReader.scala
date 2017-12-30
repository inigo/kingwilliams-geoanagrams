package net.surguy.geoanagrams

import java.nio.charset.StandardCharsets

import better.files._
import kantan.csv._
import kantan.csv.ops._

/**
  * Read a list of UK cities from the Geonames "cities15000.txt" file.
  */
class GeonamesCityReader(filename: String) {

  def allCities(): Stream[City] = {
    implicit val cityDecoder: RowDecoder[City] = RowDecoder.decoder(0, 1, 8, 14, 17)(City.apply)
    // File.resource(filename) isn't working - it's using the current context classloader on the thread, which doesn't find the resource
    val data = File(this.getClass.getResource(filename))

    (for (line <- data.lineIterator(StandardCharsets.ISO_8859_1)) yield {
      cityDecoder.unsafeDecode(line.split("\t"))
    }).toStream

//    data.contentAsString(StandardCharsets.ISO_8859_1)
//      .asCsvReader[City](rfc.withoutHeader.withCellSeparator('\t'))
//        .toStream.flatMap(_.toOption)
  }

  def ukCities(): Stream[City] = {
    allCities().filter(_.countryCode=="GB")
  }

}

case class City(id: String, name: String, countryCode: String, population: Int, region: String)
