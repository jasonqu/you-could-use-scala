package com.github.youcouldusescala

import io._

object App extends App {
  val lines = Source.fromFile("src/main/content/content.md").getLines.toList
  val res = Generator.processDir("src/main/content")
  
  
  
  
  
  val data = res.groupBy(x => (x.category, x.title, x.language))
  val cats = res.map(_.category).distinct
  val tits = res.map(_.title).distinct
  println(cats)
  println(tits)
  println(Generator.processFile(new java.io.File("src/main/content/content.md")).head)
}