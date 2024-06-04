package accel
import fringe._
import fringe.templates.memory._
import fringe.templates._
import fringe.Ledger._
import fringe.utils._
import fringe.utils.implicits._
import fringe.templates.math._
import fringe.templates.counters._
import fringe.templates.vector._
import fringe.templates.axi4._
import fringe.SpatialBlocks._
import fringe.templates.memory._
import fringe.templates.memory.implicits._
import fringe.templates.retiming._
import emul.ResidualGenerator._
import fringe.templates.euresys._
import api._
import chisel3._
import chisel3.util._
import Args._
import scala.collection.immutable._

class x544_out_sram_0 {
  lazy val w3 = Access(2791, 0, 4, List(4), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(4),RG(0)))))
  lazy val w4 = Access(2817, 0, 6, List(6), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(6),RG(0)))))
  lazy val w5 = Access(2856, 0, 9, List(9), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(9),RG(0)))))
  lazy val w1 = Access(2804, 0, 5, List(5), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(5),RG(0)))))
  lazy val w7 = Access(2752, 0, 1, List(1), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(1),RG(0)))))
  lazy val w6 = Access(2765, 0, 2, List(2), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(2),RG(0)))))
  lazy val w0 = Access(2778, 0, 3, List(3), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(3),RG(0)))))
  lazy val w9 = Access(2739, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(0),RG(0)))))
  lazy val w8 = Access(2843, 0, 8, List(8), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(8),RG(0)))))
  lazy val w2 = Access(2830, 0, 7, List(7), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(7),RG(0)))))
  lazy val r0 = Access(2905, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(1,0,10),RG(0)))))
  lazy val m = Module(new BankedSRAM(
    List[Int](100,3),
     32, 
    List[Int](10,1),
    List[Int](1,1),
    List[Int](10,1),
    List(w0,w1,w2,w3,w4,w5,w6,w7,w8,w9),
    List(r0),
    BankedMemory, 
    None, 
    true, 
    22,
    11, 
    myName = "x544_out_sram_0"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x544_out_sram_0_p", m.io.p)
}
