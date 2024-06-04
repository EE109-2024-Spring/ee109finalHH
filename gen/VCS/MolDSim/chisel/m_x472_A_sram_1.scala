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

class x472_A_sram_1 {
  lazy val w0 = Access(534, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1,0,2),RG(0)))))
  lazy val r2 = Access(1907, 0, 0, List(0), List(6), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r3 = Access(2552, 0, 1, List(1), List(9), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r5 = Access(1928, 0, 1, List(1), List(6), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r8 = Access(1096, 0, 1, List(1), List(2), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r9 = Access(2323, 0, 0, List(0), List(8), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r6 = Access(2344, 0, 1, List(1), List(8), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r16 = Access(1491, 0, 0, List(0), List(4), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r11 = Access(1720, 0, 1, List(1), List(5), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r0 = Access(2136, 0, 1, List(1), List(7), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r4 = Access(1283, 0, 0, List(0), List(3), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r13 = Access(1699, 0, 0, List(0), List(5), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r10 = Access(1075, 0, 0, List(0), List(2), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r15 = Access(680, 0, 1, List(1), List(0), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r19 = Access(659, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r12 = Access(888, 0, 1, List(1), List(1), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r14 = Access(1304, 0, 1, List(1), List(3), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val r7 = Access(2115, 0, 0, List(0), List(7), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r18 = Access(867, 0, 0, List(0), List(1), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r1 = Access(2531, 0, 0, List(0), List(9), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(0),RG(0)))))
  lazy val r17 = Access(1512, 0, 1, List(1), List(4), None, PortInfo(Some(0), 1, 8, List(2,1), 32, List(List(RG(1),RG(0)))))
  lazy val m = Module(new BankedSRAM(
    List[Int](100,3),
     32, 
    List[Int](2,1),
    List[Int](1,1),
    List[Int](2,1),
    List(w0),
    List(r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19),
    BankedMemory, 
    None, 
    true, 
    22,
    21, 
    myName = "x472_A_sram_1"
  ))
  m.io.asInstanceOf[StandardInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x472_A_sram_1_p", m.io.p)
}
