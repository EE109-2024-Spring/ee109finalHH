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

class x471_A_sram_0 {
  lazy val w0 = Access(539, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(1,0,10),RG(0)))))
  lazy val r9 = Access(2525, 0, 9, List(9), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(9),RG(0)))))
  lazy val r11 = Access(653, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(0),RG(0)))))
  lazy val r16 = Access(2130, 0, 7, List(7), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(7),RG(0)))))
  lazy val r15 = Access(1506, 0, 4, List(4), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(4),RG(0)))))
  lazy val r7 = Access(674, 0, 0, List(0), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(0),RG(0)))))
  lazy val r4 = Access(1714, 0, 5, List(5), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(5),RG(0)))))
  lazy val r6 = Access(2546, 0, 9, List(9), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(9),RG(0)))))
  lazy val r18 = Access(1069, 0, 2, List(2), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(2),RG(0)))))
  lazy val r3 = Access(1922, 0, 6, List(6), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(6),RG(0)))))
  lazy val r2 = Access(1298, 0, 3, List(3), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(3),RG(0)))))
  lazy val r5 = Access(2317, 0, 8, List(8), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(8),RG(0)))))
  lazy val r0 = Access(2109, 0, 7, List(7), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(7),RG(0)))))
  lazy val r13 = Access(1901, 0, 6, List(6), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(6),RG(0)))))
  lazy val r12 = Access(1277, 0, 3, List(3), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(3),RG(0)))))
  lazy val r1 = Access(861, 0, 1, List(1), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(1),RG(0)))))
  lazy val r17 = Access(1693, 0, 5, List(5), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(5),RG(0)))))
  lazy val r14 = Access(1485, 0, 4, List(4), List(0), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(4),RG(0)))))
  lazy val r8 = Access(2338, 0, 8, List(8), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(8),RG(0)))))
  lazy val r19 = Access(882, 0, 1, List(1), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(1),RG(0)))))
  lazy val r10 = Access(1090, 0, 2, List(2), List(1), None, PortInfo(Some(0), 1, 5, List(4,1), 32, List(List(RG(2),RG(0)))))
  lazy val m = Module(new BankedSRAM(
    List[Int](100,3),
     32, 
    List[Int](10,1),
    List[Int](1,1),
    List[Int](10,1),
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19),
    BankedMemory, 
    None, 
    true, 
    22,
    21, 
    myName = "x471_A_sram_0"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x471_A_sram_0_p", m.io.p)
}
