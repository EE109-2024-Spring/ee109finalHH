package model
import models.Sensitivity

object AppSensitivity extends App {
  override def main(args: Array[String]): Unit = {
    val center: Map[String,String] = Map()
    println(s"Center: $center") 
    println(s"Hashcode mapping:")
    Sensitivity.around("/home/hhollen/ee109finalHH/./gen/VCS/MolDSim///MolDSim_data.csv", center)
  }
}
