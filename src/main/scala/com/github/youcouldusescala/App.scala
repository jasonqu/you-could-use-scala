package com.github.youcouldusescala

import io._

object App extends App {
  val res = Generator.processDir("src/main/content")

  val data = res.groupBy(x => (x.category, x.title, x.language.toLowerCase)).mapValues(_.head.code)
  val cats = res.map(_.category).distinct
  val tits = res.map(d => (d.category, d.title)).groupBy(_._1).mapValues(_.map(_._2).distinct)
  val languages = "java" :: "scala" :: Nil
//  println(cats)
//  println(tits)
//  println(Generator.processFile(new java.io.File("src/main/content/content.md")).head)
//  println(html.index(cats, tits, languages, data))
  
  val p = new java.io.PrintWriter("site/index.html")
  try { p.write(html.index(cats, tits, languages, data).toString()) } finally { p.close() }
}