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

class x2595_reg {
  lazy val w0 = Access(2604, 0, 0, List(0), List(0), None, PortInfo(Some(0), 1, 1, List(1), 1, List(List())))
  lazy val r0 = Access(2964, 0, 0, List(0), List(0), None, PortInfo(Some(1), 1, 1, List(1), 1, List(List())))
  lazy val m = Module(new NBufMem(FFType, 
    List[Int](1),
    2, 1, 
    List[Int](1),
    List[Int](1),
    List[Int](),
    List(w0),
    List(r0),
    BankedMemory, 
    Some(List((0).toDouble)), 
    true, 
    0,
    2, 
    myName = "x2595_reg"
  ))
  m.io.asInstanceOf[NBufInterface] <> DontCare
  m.io.reset := false.B
  ModuleParams.addParams("x2595_reg_p", m.io.np)
}
