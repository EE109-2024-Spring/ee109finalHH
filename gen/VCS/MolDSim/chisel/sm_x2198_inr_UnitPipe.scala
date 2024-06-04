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

/** Hierarchy: x2198 -> x2199 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2198_inr_UnitPipe **/
class x2198_inr_UnitPipe_kernel(
  list_b564: List[Bool],
  list_x2178_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x2198_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2198_inr_UnitPipe_iiCtr"))
  
  abstract class x2198_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2178_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2178_reg_p").asInstanceOf[NBufParams] ))
      val in_x2147_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2147_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2180_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2180_reg_p").asInstanceOf[NBufParams] ))
      val in_b564 = Input(Bool())
      val in_b2087 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2178_reg = {io.in_x2178_reg} ; io.in_x2178_reg := DontCare
    def x2147_r_0 = {io.in_x2147_r_0} ; io.in_x2147_r_0 := DontCare
    def x2180_reg = {io.in_x2180_reg} ; io.in_x2180_reg := DontCare
    def b564 = {io.in_b564} 
    def b2087 = {io.in_b2087} 
  }
  def connectWires0(module: x2198_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2178_reg.connectLedger(module.io.in_x2178_reg)
    x2147_r_0.connectLedger(module.io.in_x2147_r_0)
    x2180_reg.connectLedger(module.io.in_x2180_reg)
    module.io.in_b564 <> b564
    module.io.in_b2087 <> b2087
  }
  val b564 = list_b564(0)
  val b2087 = list_b564(1)
  val x2178_reg = list_x2178_reg(0)
  val x2147_r_0 = list_x2178_reg(1)
  val x2180_reg = list_x2178_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2198_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2198_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2198_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2198_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2198_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2198_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2198_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2198_instrctr, cycles_x2198_inr_UnitPipe.io.count, iters_x2198_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2190_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2190_rd""")
      val x2190_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2190_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2190_rd_en = List[Bool](true.B)
      val x2190_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2190_rd_shared_en")
      x2190_rd.toSeq.zip(x2147_r_0.connectRPort(2190, x2190_rd_banks, x2190_rd_ofs, io.sigsIn.backpressure, x2190_rd_en.map(_ && x2190_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2191 = VecApply(x2190,0)
      val x2191_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2191_elem_0""")
      x2191_elem_0.r := x2190_rd(0).r
      val x2192 = Wire(Bool()).suggestName("""x2192""")
      x2192.r := Math.lt(0.FP(true, 10, 22), x2191_elem_0, Some(0.4), true.B,"x2192").r
      val x2193 = Wire(Bool()).suggestName("""x2193""")
      x2193.r := Math.lt(1.FP(true, 10, 22), x2191_elem_0, Some(0.4), true.B,"x2193").r
      val x2194 = Wire(Bool()).suggestName("""x2194""")
      x2194 := x2192 & x2193
      val x2195 = Wire(Bool()).suggestName("""x2195""")
      x2195 := ~x2194
      val x2196_wr_x2178_banks = List[UInt]()
      val x2196_wr_x2178_ofs = List[UInt]()
      val x2196_wr_x2178_en = List[Bool](true.B)
      val x2196_wr_x2178_data = List[UInt](x2194.r)
      x2178_reg.connectWPort(2196, x2196_wr_x2178_banks, x2196_wr_x2178_ofs, x2196_wr_x2178_data, x2196_wr_x2178_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x2197_wr_x2180_banks = List[UInt]()
      val x2197_wr_x2180_ofs = List[UInt]()
      val x2197_wr_x2180_en = List[Bool](true.B)
      val x2197_wr_x2180_data = List[UInt](x2195.r)
      x2180_reg.connectWPort(2197, x2197_wr_x2180_banks, x2197_wr_x2180_ofs, x2197_wr_x2180_data, x2197_wr_x2180_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2198_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2198_inr_UnitPipe **/
