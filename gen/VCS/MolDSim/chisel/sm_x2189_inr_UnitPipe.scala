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

/** Hierarchy: x2189 -> x2199 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2189_inr_UnitPipe **/
class x2189_inr_UnitPipe_kernel(
  list_b2086: List[Bool],
  list_x2146_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x2189_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2189_inr_UnitPipe_iiCtr"))
  
  abstract class x2189_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2146_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2146_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2179_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2179_reg_p").asInstanceOf[NBufParams] ))
      val in_b2086 = Input(Bool())
      val in_b564 = Input(Bool())
      val in_x2177_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2177_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2146_r_0 = {io.in_x2146_r_0} ; io.in_x2146_r_0 := DontCare
    def x2179_reg = {io.in_x2179_reg} ; io.in_x2179_reg := DontCare
    def b2086 = {io.in_b2086} 
    def b564 = {io.in_b564} 
    def x2177_reg = {io.in_x2177_reg} ; io.in_x2177_reg := DontCare
  }
  def connectWires0(module: x2189_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2146_r_0.connectLedger(module.io.in_x2146_r_0)
    x2179_reg.connectLedger(module.io.in_x2179_reg)
    module.io.in_b2086 <> b2086
    module.io.in_b564 <> b564
    x2177_reg.connectLedger(module.io.in_x2177_reg)
  }
  val b2086 = list_b2086(0)
  val b564 = list_b2086(1)
  val x2146_r_0 = list_x2146_r_0(0)
  val x2179_reg = list_x2146_r_0(1)
  val x2177_reg = list_x2146_r_0(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2189_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2189_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2189_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2189_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2189_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2189_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2189_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2189_instrctr, cycles_x2189_inr_UnitPipe.io.count, iters_x2189_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2181_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2181_rd""")
      val x2181_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2181_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2181_rd_en = List[Bool](true.B)
      val x2181_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2181_rd_shared_en")
      x2181_rd.toSeq.zip(x2146_r_0.connectRPort(2181, x2181_rd_banks, x2181_rd_ofs, io.sigsIn.backpressure, x2181_rd_en.map(_ && x2181_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2182 = VecApply(x2181,0)
      val x2182_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2182_elem_0""")
      x2182_elem_0.r := x2181_rd(0).r
      val x2183 = Wire(Bool()).suggestName("""x2183""")
      x2183.r := Math.lt(0.FP(true, 10, 22), x2182_elem_0, Some(0.4), true.B,"x2183").r
      val x2184 = Wire(Bool()).suggestName("""x2184""")
      x2184.r := Math.lt(1.FP(true, 10, 22), x2182_elem_0, Some(0.4), true.B,"x2184").r
      val x2185 = Wire(Bool()).suggestName("""x2185""")
      x2185 := x2183 & x2184
      val x2186 = Wire(Bool()).suggestName("""x2186""")
      x2186 := ~x2185
      val x2187_wr_x2177_banks = List[UInt]()
      val x2187_wr_x2177_ofs = List[UInt]()
      val x2187_wr_x2177_en = List[Bool](true.B)
      val x2187_wr_x2177_data = List[UInt](x2185.r)
      x2177_reg.connectWPort(2187, x2187_wr_x2177_banks, x2187_wr_x2177_ofs, x2187_wr_x2177_data, x2187_wr_x2177_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x2188_wr_x2179_banks = List[UInt]()
      val x2188_wr_x2179_ofs = List[UInt]()
      val x2188_wr_x2179_en = List[Bool](true.B)
      val x2188_wr_x2179_data = List[UInt](x2186.r)
      x2179_reg.connectWPort(2188, x2188_wr_x2179_banks, x2188_wr_x2179_ofs, x2188_wr_x2179_data, x2188_wr_x2179_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2189_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2189_inr_UnitPipe **/
