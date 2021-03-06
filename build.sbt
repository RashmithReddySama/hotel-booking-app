name := "hotel-booking-app"

version := "1.0"

scalaVersion := "2.11.8"

val cucumberVersion = "1.2.5"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.11.8",
  "info.cukes" % "cucumber-junit" % cucumberVersion,
  "info.cukes" % "cucumber-scala_2.11" % cucumberVersion,
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "3.6.0",
  "org.seleniumhq.selenium" % "selenium-firefox-driver" % "3.6.0",
  "com.typesafe.play" %% "play-json" % "2.6.9",
  "org.pegdown" % "pegdown" % "1.6.0" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
)