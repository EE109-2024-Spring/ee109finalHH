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

class x1522_r_0 {
  lazy val w0 = Access(1535, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 1, List(1), 32, List(List(RG(0)))))
  lazy val r0 = Access(1557, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 1, List(1), 32, List(List(RG(0)))))
  lazy val r1 = Access(1581, 0, 0, List(0), List(0), None, PortInfo(Some(2), 1, 1, List(1), 32, List(List(RG(0)))))
  lazy val m = Module(new NBufMem(BankedSRAMType, 
    List[Int](1),
    3, 32, 
    List[Int](1),
    List[Int](1),
    List[Int](1),
    List(w0),
    List(r0,r1),
    BankedMemory, 
    None, 
    true, 
    22,
    3, 
    myName = "x1522_r_0"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x1522_r_0_p", m.io.np)
}
