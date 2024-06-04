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

/** Hierarchy: x1990 -> x1991 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1990_inr_UnitPipe **/
class x1990_inr_UnitPipe_kernel(
  list_b1879: List[Bool],
  list_x1939_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1990_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1990_inr_UnitPipe_iiCtr"))
  
  abstract class x1990_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1879 = Input(Bool())
      val in_x1939_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1939_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1970_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1970_reg_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_x1972_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1972_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1879 = {io.in_b1879} 
    def x1939_r_0 = {io.in_x1939_r_0} ; io.in_x1939_r_0 := DontCare
    def x1970_reg = {io.in_x1970_reg} ; io.in_x1970_reg := DontCare
    def b563 = {io.in_b563} 
    def x1972_reg = {io.in_x1972_reg} ; io.in_x1972_reg := DontCare
  }
  def connectWires0(module: x1990_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1879 <> b1879
    x1939_r_0.connectLedger(module.io.in_x1939_r_0)
    x1970_reg.connectLedger(module.io.in_x1970_reg)
    module.io.in_b563 <> b563
    x1972_reg.connectLedger(module.io.in_x1972_reg)
  }
  val b1879 = list_b1879(0)
  val b563 = list_b1879(1)
  val x1939_r_0 = list_x1939_r_0(0)
  val x1970_reg = list_x1939_r_0(1)
  val x1972_reg = list_x1939_r_0(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1990_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1990_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1990_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1990_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1990_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1990_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1990_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1990_instrctr, cycles_x1990_inr_UnitPipe.io.count, iters_x1990_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1982_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1982_rd""")
      val x1982_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1982_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1982_rd_en = List[Bool](true.B)
      val x1982_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1982_rd_shared_en")
      x1982_rd.toSeq.zip(x1939_r_0.connectRPort(1982, x1982_rd_banks, x1982_rd_ofs, io.sigsIn.backpressure, x1982_rd_en.map(_ && x1982_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1983 = VecApply(x1982,0)
      val x1983_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1983_elem_0""")
      x1983_elem_0.r := x1982_rd(0).r
      val x1984 = Wire(Bool()).suggestName("""x1984""")
      x1984.r := Math.lt(0.FP(true, 10, 22), x1983_elem_0, Some(0.4), true.B,"x1984").r
      val x1985 = Wire(Bool()).suggestName("""x1985""")
      x1985.r := Math.lt(1.FP(true, 10, 22), x1983_elem_0, Some(0.4), true.B,"x1985").r
      val x1986 = Wire(Bool()).suggestName("""x1986""")
      x1986 := x1984 & x1985
      val x1987 = Wire(Bool()).suggestName("""x1987""")
      x1987 := ~x1986
      val x1988_wr_x1970_banks = List[UInt]()
      val x1988_wr_x1970_ofs = List[UInt]()
      val x1988_wr_x1970_en = List[Bool](true.B)
      val x1988_wr_x1970_data = List[UInt](x1986.r)
      x1970_reg.connectWPort(1988, x1988_wr_x1970_banks, x1988_wr_x1970_ofs, x1988_wr_x1970_data, x1988_wr_x1970_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1989_wr_x1972_banks = List[UInt]()
      val x1989_wr_x1972_ofs = List[UInt]()
      val x1989_wr_x1972_en = List[Bool](true.B)
      val x1989_wr_x1972_data = List[UInt](x1987.r)
      x1972_reg.connectWPort(1989, x1989_wr_x1972_banks, x1989_wr_x1972_ofs, x1989_wr_x1972_data, x1989_wr_x1972_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1990_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectInstrCtrs(instrctrs, module.io.in_instrctrs)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x1990_inr_UnitPipe **/
