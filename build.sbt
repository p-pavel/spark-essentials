name := "spark-essentials"

version := "0.1"

scalaVersion := "3.2.2"
javaOptions ++= Seq("--add-exports","java.base/sun.nio.ch=ALL-UNNAMED")
fork := true

Compile / run := Defaults.runTask(Compile / fullClasspath, Compile / run / mainClass, Compile / run / runner).evaluated


val sparkVersion = "3.3.1"
val vegasVersion = "0.3.11"
val postgresVersion = "42.2.2"

resolvers ++= Seq(
  "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven",
  "Typesafe Simple Repository" at "https://repo.typesafe.com/typesafe/simple/maven-releases",
  "MavenRepository" at "https://mvnrepository.com"
)


libraryDependencies ++= 
  Seq("spark-core", "spark-sql")
    .map(pkg => ("org.apache.spark" %% pkg % sparkVersion % "provided").cross(CrossVersion.for3Use2_13))
libraryDependencies ++=
  Seq(
  // logging
  "org.apache.logging.log4j" % "log4j-api" % "2.4.1",
  "org.apache.logging.log4j" % "log4j-core" % "2.4.1",
  // postgres for DB connectivity
  "org.postgresql" % "postgresql" % postgresVersion
)