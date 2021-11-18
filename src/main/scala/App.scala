import java.util

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.yaml.snakeyaml.Yaml
import java.io.{File, PrintWriter}

import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml

import scala.beans.BeanProperty

import scala.collection.JavaConverters._
import java.util.{List=>JavaList}
import scala.collection.immutable.{List => ScalaList}
import scala.collection.mutable.{MutableList => ScalaMutableList}

object App {

  def main(args: Array[String]): Unit = {

    case class Student(@BeanProperty var name: String, @BeanProperty var age: Int, @BeanProperty var friends: JavaList[String])
    var souhaib = Student("souhaib", 31, List("achraf","walid").asJava)
    var ghizlane = Student("ghizlane", 31, List("achraf","walid").asJava)

    val options = new DumperOptions
    options.setIndent(2)
    options.setPrettyFlow(true)
    options.setExplicitEnd(true)
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK)
    val writer = new PrintWriter(new File("./src/main/resources/student_output.yml"))
    val yaml = new Yaml(options)
    yaml.dump(souhaib, writer)
    yaml.dump(ghizlane, writer)
  }

}
