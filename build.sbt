name := """kingwilliams-geoanagrams"""

version := "1.0"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.specs2" % "specs2-core_2.12" % "3.8.9" % Test
  , "com.github.pathikrit" %% "better-files" % "3.4.0"
  , "com.nrinaudo" %% "kantan.csv" % "0.3.1"
)
