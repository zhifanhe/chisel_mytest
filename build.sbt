name := "mytest"

version := "0.1"

scalaVersion := "2.12.12"

scalacOptions := Seq("-deprecation", "-Xsource:2.11")

resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases")
)
// Chisel 3.4
libraryDependencies += "edu.berkeley.cs" %% "chisel3" % "3.4.0"
// old test library for "chisel tutorial"
libraryDependencies += "edu.berkeley.cs" %% "chisel-iotesters" % "1.5.1"
// new test library 
libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "0.3.1"
