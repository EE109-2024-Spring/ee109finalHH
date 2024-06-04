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

/** Hierarchy: x2268 -> x2269 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2268_inr_Foreach **/
class x2268_inr_Foreach_kernel(
  list_b564: List[Bool],
  list_x2094_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x2268_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x2268_inr_Foreach_iiCtr"))
  
  abstract class x2268_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2094_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2094_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2176_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2176_force_0_p").asInstanceOf[NBufParams] ))
      val in_x2097_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2097_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2096_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2096_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2098_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2098_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2095_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2095_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b564 = Input(Bool())
      val in_b2087 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2094_tmp_0 = {io.in_x2094_tmp_0} ; io.in_x2094_tmp_0 := DontCare
    def x2176_force_0 = {io.in_x2176_force_0} ; io.in_x2176_force_0 := DontCare
    def x2097_tmp_3 = {io.in_x2097_tmp_3} ; io.in_x2097_tmp_3 := DontCare
    def x2096_tmp_2 = {io.in_x2096_tmp_2} ; io.in_x2096_tmp_2 := DontCare
    def x2098_tmp_4 = {io.in_x2098_tmp_4} ; io.in_x2098_tmp_4 := DontCare
    def x2095_tmp_1 = {io.in_x2095_tmp_1} ; io.in_x2095_tmp_1 := DontCare
    def b564 = {io.in_b564} 
    def b2087 = {io.in_b2087} 
  }
  def connectWires0(module: x2268_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x2094_tmp_0.connectLedger(module.io.in_x2094_tmp_0)
    x2176_force_0.connectLedger(module.io.in_x2176_force_0)
    x2097_tmp_3.connectLedger(module.io.in_x2097_tmp_3)
    x2096_tmp_2.connectLedger(module.io.in_x2096_tmp_2)
    x2098_tmp_4.connectLedger(module.io.in_x2098_tmp_4)
    x2095_tmp_1.connectLedger(module.io.in_x2095_tmp_1)
    module.io.in_b564 <> b564
    module.io.in_b2087 <> b2087
  }
  val b564 = list_b564(0)
  val b2087 = list_b564(1)
  val x2094_tmp_0 = list_x2094_tmp_0(0)
  val x2176_force_0 = list_x2094_tmp_0(1)
  val x2097_tmp_3 = list_x2094_tmp_0(2)
  val x2096_tmp_2 = list_x2094_tmp_0(3)
  val x2098_tmp_4 = list_x2094_tmp_0(4)
  val x2095_tmp_1 = list_x2094_tmp_0(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2268_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2268_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2268_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2268_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2268_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2268_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2268_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2268_instrctr, cycles_x2268_inr_Foreach.io.count, iters_x2268_inr_Foreach.io.count, 0.U, 0.U)
      val b2255 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2255.suggestName("b2255")
      val b2256 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2256.suggestName("b2256")
      val x2257_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2257_rd""")
      val x2257_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2257_rd_ofs = List[UInt](b2255.r)
      val x2257_rd_en = List[Bool](true.B)
      val x2257_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2256 & b2087 & b564 ).suggestName("x2257_rd_shared_en")
      x2257_rd.toSeq.zip(x2097_tmp_3.connectRPort(2257, x2257_rd_banks, x2257_rd_ofs, io.sigsIn.backpressure, x2257_rd_en.map(_ && x2257_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2258 = VecApply(x2257,0)
      val x2258_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2258_elem_0""")
      x2258_elem_0.r := x2257_rd(0).r
      val x2259_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2259_mul""")
      x2259_mul.r := (Math.mul(x2258_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x2259_mul")).r
      val x2260_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2260_rd""")
      val x2260_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2260_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2260_rd_en = List[Bool](true.B)
      val x2260_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2256 & b2087 & b564 ).suggestName("x2260_rd_shared_en")
      x2260_rd.toSeq.zip(x2176_force_0.connectRPort(2260, x2260_rd_banks, x2260_rd_ofs, io.sigsIn.backpressure, x2260_rd_en.map(_ && x2260_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2261 = VecApply(x2260,0)
      val x2261_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2261_elem_0""")
      x2261_elem_0.r := x2260_rd(0).r
      val x3613 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3613_x2261_elem_0_D6") 
      x3613.r := getRetimed(x2261_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2262_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2262_mul""")
      x2262_mul.r := (Math.mul(x2259_mul, x3613, Some(6.0), true.B, Truncate, Wrapping, "x2262_mul")).r
      val x3614 = Wire(Bool()).suggestName("x3614_b2256_D14") 
      x3614.r := getRetimed(b2256.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3615 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3615_b2255_D14") 
      x3615.r := getRetimed(b2255.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3616 = Wire(Bool()).suggestName("x3616_b564_D14") 
      x3616.r := getRetimed(b564.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3617 = Wire(Bool()).suggestName("x3617_b2087_D14") 
      x3617.r := getRetimed(b2087.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x2263_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2263_wr_ofs = List[UInt](x3615.r)
      val x2263_wr_en = List[Bool](true.B)
      val x2263_wr_data = List[UInt](x2262_mul.r)
      x2094_tmp_0.connectWPort(2263, x2263_wr_banks, x2263_wr_ofs, x2263_wr_data, x2263_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3614 & x3617 & x3616))
      val x2264_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2264_wr_ofs = List[UInt](x3615.r)
      val x2264_wr_en = List[Bool](true.B)
      val x2264_wr_data = List[UInt](x2262_mul.r)
      x2097_tmp_3.connectWPort(2264, x2264_wr_banks, x2264_wr_ofs, x2264_wr_data, x2264_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3614 & x3617 & x3616))
      val x2265_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2265_wr_ofs = List[UInt](x3615.r)
      val x2265_wr_en = List[Bool](true.B)
      val x2265_wr_data = List[UInt](x2262_mul.r)
      x2096_tmp_2.connectWPort(2265, x2265_wr_banks, x2265_wr_ofs, x2265_wr_data, x2265_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3614 & x3617 & x3616))
      val x2266_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2266_wr_ofs = List[UInt](x3615.r)
      val x2266_wr_en = List[Bool](true.B)
      val x2266_wr_data = List[UInt](x2262_mul.r)
      x2098_tmp_4.connectWPort(2266, x2266_wr_banks, x2266_wr_ofs, x2266_wr_data, x2266_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3614 & x3617 & x3616))
      val x2267_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2267_wr_ofs = List[UInt](x3615.r)
      val x2267_wr_en = List[Bool](true.B)
      val x2267_wr_data = List[UInt](x2262_mul.r)
      x2095_tmp_1.connectWPort(2267, x2267_wr_banks, x2267_wr_ofs, x2267_wr_data, x2267_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3614 & x3617 & x3616))
    }
    val module = Module(new x2268_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2268_inr_Foreach **/
