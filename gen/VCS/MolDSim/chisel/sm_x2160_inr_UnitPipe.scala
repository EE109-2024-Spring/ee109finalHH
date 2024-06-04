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

/** Hierarchy: x2160 -> x2174 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2160_inr_UnitPipe **/
class x2160_inr_UnitPipe_kernel(
  list_b2086: List[Bool],
  list_x2146_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x2160_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2160_inr_UnitPipe_iiCtr"))
  
  abstract class x2160_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2146_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2146_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2090_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2090_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2089_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2089_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b2086 = Input(Bool())
      val in_b564 = Input(Bool())
      val in_x2091_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2091_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2146_r_0 = {io.in_x2146_r_0} ; io.in_x2146_r_0 := DontCare
    def x2090_tmp_1 = {io.in_x2090_tmp_1} ; io.in_x2090_tmp_1 := DontCare
    def x2089_tmp_0 = {io.in_x2089_tmp_0} ; io.in_x2089_tmp_0 := DontCare
    def b2086 = {io.in_b2086} 
    def b564 = {io.in_b564} 
    def x2091_tmp_2 = {io.in_x2091_tmp_2} ; io.in_x2091_tmp_2 := DontCare
  }
  def connectWires0(module: x2160_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2146_r_0.connectLedger(module.io.in_x2146_r_0)
    x2090_tmp_1.connectLedger(module.io.in_x2090_tmp_1)
    x2089_tmp_0.connectLedger(module.io.in_x2089_tmp_0)
    module.io.in_b2086 <> b2086
    module.io.in_b564 <> b564
    x2091_tmp_2.connectLedger(module.io.in_x2091_tmp_2)
  }
  val b2086 = list_b2086(0)
  val b564 = list_b2086(1)
  val x2146_r_0 = list_x2146_r_0(0)
  val x2090_tmp_1 = list_x2146_r_0(1)
  val x2089_tmp_0 = list_x2146_r_0(2)
  val x2091_tmp_2 = list_x2146_r_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2160_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2160_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2160_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2160_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2160_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2160_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2160_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2160_instrctr, cycles_x2160_inr_UnitPipe.io.count, iters_x2160_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2148_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2148_rd""")
      val x2148_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2148_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2148_rd_en = List[Bool](true.B)
      val x2148_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2148_rd_shared_en")
      x2148_rd.toSeq.zip(x2089_tmp_0.connectRPort(2148, x2148_rd_banks, x2148_rd_ofs, io.sigsIn.backpressure, x2148_rd_en.map(_ && x2148_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2149 = VecApply(x2148,0)
      val x2149_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2149_elem_0""")
      x2149_elem_0.r := x2148_rd(0).r
      val x2151_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2151_rd""")
      val x2151_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2151_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x2151_rd_en = List[Bool](true.B)
      val x2151_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2151_rd_shared_en")
      x2151_rd.toSeq.zip(x2090_tmp_1.connectRPort(2151, x2151_rd_banks, x2151_rd_ofs, io.sigsIn.backpressure, x2151_rd_en.map(_ && x2151_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2152 = VecApply(x2151,0)
      val x2152_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2152_elem_0""")
      x2152_elem_0.r := x2151_rd(0).r
      val x2153_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2153_mul""")
      x2153_mul.r := (Math.mul(x2152_elem_0, x2152_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x2153_mul")).r
      val x3594 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3594_x2149_elem_0_D6") 
      x3594.r := getRetimed(x2149_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3069 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3069""")
      x3069.r := Math.fma(x3594,x3594,x2153_mul,Some(6.0), true.B, "x3069").toFixed(x3069, "cast_x3069").r
      val x2155_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2155_rd""")
      val x2155_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2155_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x2155_rd_en = List[Bool](true.B)
      val x2155_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2155_rd_shared_en")
      x2155_rd.toSeq.zip(x2091_tmp_2.connectRPort(2155, x2155_rd_banks, x2155_rd_ofs, io.sigsIn.backpressure, x2155_rd_en.map(_ && x2155_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2156 = VecApply(x2155,0)
      val x2156_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2156_elem_0""")
      x2156_elem_0.r := x2155_rd(0).r
      val x3595 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3595_x2156_elem_0_D12") 
      x3595.r := getRetimed(x2156_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3070 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3070""")
      x3070.r := Math.fma(x3595,x3595,x3069,Some(6.0), true.B, "x3070").toFixed(x3070, "cast_x3070").r
      val x2159_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2159_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2159_wr_en = List[Bool](true.B)
      val x2159_wr_data = List[UInt](x3070.r)
      x2146_r_0.connectWPort(2159, x2159_wr_banks, x2159_wr_ofs, x2159_wr_data, x2159_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2160_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2160_inr_UnitPipe **/
