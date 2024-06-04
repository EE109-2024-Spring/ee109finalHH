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

/** Hierarchy: x1981 -> x1991 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1981_inr_UnitPipe **/
class x1981_inr_UnitPipe_kernel(
  list_b1878: List[Bool],
  list_x1971_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1981_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1981_inr_UnitPipe_iiCtr"))
  
  abstract class x1981_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1971_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1971_reg_p").asInstanceOf[NBufParams] ))
      val in_x1938_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1938_r_0_p").asInstanceOf[NBufParams] ))
      val in_b1878 = Input(Bool())
      val in_x1969_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1969_reg_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1971_reg = {io.in_x1971_reg} ; io.in_x1971_reg := DontCare
    def x1938_r_0 = {io.in_x1938_r_0} ; io.in_x1938_r_0 := DontCare
    def b1878 = {io.in_b1878} 
    def x1969_reg = {io.in_x1969_reg} ; io.in_x1969_reg := DontCare
    def b563 = {io.in_b563} 
  }
  def connectWires0(module: x1981_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1971_reg.connectLedger(module.io.in_x1971_reg)
    x1938_r_0.connectLedger(module.io.in_x1938_r_0)
    module.io.in_b1878 <> b1878
    x1969_reg.connectLedger(module.io.in_x1969_reg)
    module.io.in_b563 <> b563
  }
  val b1878 = list_b1878(0)
  val b563 = list_b1878(1)
  val x1971_reg = list_x1971_reg(0)
  val x1938_r_0 = list_x1971_reg(1)
  val x1969_reg = list_x1971_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1981_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1981_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1981_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1981_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1981_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1981_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1981_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1981_instrctr, cycles_x1981_inr_UnitPipe.io.count, iters_x1981_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1973_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1973_rd""")
      val x1973_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1973_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1973_rd_en = List[Bool](true.B)
      val x1973_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1973_rd_shared_en")
      x1973_rd.toSeq.zip(x1938_r_0.connectRPort(1973, x1973_rd_banks, x1973_rd_ofs, io.sigsIn.backpressure, x1973_rd_en.map(_ && x1973_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1974 = VecApply(x1973,0)
      val x1974_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1974_elem_0""")
      x1974_elem_0.r := x1973_rd(0).r
      val x1975 = Wire(Bool()).suggestName("""x1975""")
      x1975.r := Math.lt(0.FP(true, 10, 22), x1974_elem_0, Some(0.4), true.B,"x1975").r
      val x1976 = Wire(Bool()).suggestName("""x1976""")
      x1976.r := Math.lt(1.FP(true, 10, 22), x1974_elem_0, Some(0.4), true.B,"x1976").r
      val x1977 = Wire(Bool()).suggestName("""x1977""")
      x1977 := x1975 & x1976
      val x1978 = Wire(Bool()).suggestName("""x1978""")
      x1978 := ~x1977
      val x1979_wr_x1969_banks = List[UInt]()
      val x1979_wr_x1969_ofs = List[UInt]()
      val x1979_wr_x1969_en = List[Bool](true.B)
      val x1979_wr_x1969_data = List[UInt](x1977.r)
      x1969_reg.connectWPort(1979, x1979_wr_x1969_banks, x1979_wr_x1969_ofs, x1979_wr_x1969_data, x1979_wr_x1969_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1980_wr_x1971_banks = List[UInt]()
      val x1980_wr_x1971_ofs = List[UInt]()
      val x1980_wr_x1971_en = List[Bool](true.B)
      val x1980_wr_x1971_data = List[UInt](x1978.r)
      x1971_reg.connectWPort(1980, x1980_wr_x1971_banks, x1980_wr_x1971_ofs, x1980_wr_x1971_data, x1980_wr_x1971_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1981_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1981_inr_UnitPipe **/
