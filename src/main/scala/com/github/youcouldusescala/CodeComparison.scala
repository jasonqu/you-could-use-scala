package com.github.youcouldusescala

case class CodeComparison(val category: String, val title: String, val language: String, val code: String)

import java.io.File

object Generator {
  def processDir(dir: String): List[CodeComparison] = {
    new File(dir).listFiles.foldLeft(List[CodeComparison]()) { (result, file) => processFile(file) ::: result }
  }

  def processFile(file: File): List[CodeComparison] = {
    var list: List[CodeComparison] = Nil;
    var category = "";
    var title = "";
    var language = "";
    var code = "";
    io.Source.fromFile(file, "UTF8").getLines().foreach {
      line =>
        line match {
          case x if x.trim().isEmpty() =>
          case x if x.startsWith("#####") =>
            if (!code.trim().isEmpty()) {
              list = CodeComparison(category, title, language, code) :: list
              code = ""
            }
            language = x.substring(5)
          case x if x.startsWith("###") =>
            if (!code.trim().isEmpty()) {
              list = CodeComparison(category, title, language, code) :: list
              code = ""
            }
            title = x.substring(3)
          case x if x.startsWith("##") => category = x.substring(2)
          case x if x.startsWith("\t") =>
            code = code + x.substring(1) + '\n'
        }
    }

    // add the last elem
    CodeComparison(category, title, language, code) :: list reverse
  }
}