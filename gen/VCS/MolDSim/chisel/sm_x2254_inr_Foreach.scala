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

/** Hierarchy: x2254 -> x2269 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2254_inr_Foreach **/
class x2254_inr_Foreach_kernel(
  list_b2086: List[Bool],
  list_x2090_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x2254_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x2254_inr_Foreach_iiCtr"))
  
  abstract class x2254_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2090_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2090_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2093_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2093_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2089_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2089_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b2086 = Input(Bool())
      val in_x2175_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2175_force_0_p").asInstanceOf[NBufParams] ))
      val in_x2092_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2092_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b564 = Input(Bool())
      val in_x2091_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2091_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2090_tmp_1 = {io.in_x2090_tmp_1} ; io.in_x2090_tmp_1 := DontCare
    def x2093_tmp_4 = {io.in_x2093_tmp_4} ; io.in_x2093_tmp_4 := DontCare
    def x2089_tmp_0 = {io.in_x2089_tmp_0} ; io.in_x2089_tmp_0 := DontCare
    def b2086 = {io.in_b2086} 
    def x2175_force_0 = {io.in_x2175_force_0} ; io.in_x2175_force_0 := DontCare
    def x2092_tmp_3 = {io.in_x2092_tmp_3} ; io.in_x2092_tmp_3 := DontCare
    def b564 = {io.in_b564} 
    def x2091_tmp_2 = {io.in_x2091_tmp_2} ; io.in_x2091_tmp_2 := DontCare
  }
  def connectWires0(module: x2254_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x2090_tmp_1.connectLedger(module.io.in_x2090_tmp_1)
    x2093_tmp_4.connectLedger(module.io.in_x2093_tmp_4)
    x2089_tmp_0.connectLedger(module.io.in_x2089_tmp_0)
    module.io.in_b2086 <> b2086
    x2175_force_0.connectLedger(module.io.in_x2175_force_0)
    x2092_tmp_3.connectLedger(module.io.in_x2092_tmp_3)
    module.io.in_b564 <> b564
    x2091_tmp_2.connectLedger(module.io.in_x2091_tmp_2)
  }
  val b2086 = list_b2086(0)
  val b564 = list_b2086(1)
  val x2090_tmp_1 = list_x2090_tmp_1(0)
  val x2093_tmp_4 = list_x2090_tmp_1(1)
  val x2089_tmp_0 = list_x2090_tmp_1(2)
  val x2175_force_0 = list_x2090_tmp_1(3)
  val x2092_tmp_3 = list_x2090_tmp_1(4)
  val x2091_tmp_2 = list_x2090_tmp_1(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2254_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2254_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2254_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2254_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2254_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2254_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2254_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2254_instrctr, cycles_x2254_inr_Foreach.io.count, iters_x2254_inr_Foreach.io.count, 0.U, 0.U)
      val b2241 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2241.suggestName("b2241")
      val b2242 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2242.suggestName("b2242")
      val x2243_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2243_rd""")
      val x2243_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2243_rd_ofs = List[UInt](b2241.r)
      val x2243_rd_en = List[Bool](true.B)
      val x2243_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2242 & b2086 & b564 ).suggestName("x2243_rd_shared_en")
      x2243_rd.toSeq.zip(x2092_tmp_3.connectRPort(2243, x2243_rd_banks, x2243_rd_ofs, io.sigsIn.backpressure, x2243_rd_en.map(_ && x2243_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2244 = VecApply(x2243,0)
      val x2244_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2244_elem_0""")
      x2244_elem_0.r := x2243_rd(0).r
      val x2245_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2245_mul""")
      x2245_mul.r := (Math.mul(x2244_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x2245_mul")).r
      val x2246_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2246_rd""")
      val x2246_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2246_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2246_rd_en = List[Bool](true.B)
      val x2246_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2242 & b2086 & b564 ).suggestName("x2246_rd_shared_en")
      x2246_rd.toSeq.zip(x2175_force_0.connectRPort(2246, x2246_rd_banks, x2246_rd_ofs, io.sigsIn.backpressure, x2246_rd_en.map(_ && x2246_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2247 = VecApply(x2246,0)
      val x2247_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2247_elem_0""")
      x2247_elem_0.r := x2246_rd(0).r
      val x3608 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3608_x2247_elem_0_D6") 
      x3608.r := getRetimed(x2247_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2248_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2248_mul""")
      x2248_mul.r := (Math.mul(x2245_mul, x3608, Some(6.0), true.B, Truncate, Wrapping, "x2248_mul")).r
      val x3609 = Wire(Bool()).suggestName("x3609_b2242_D14") 
      x3609.r := getRetimed(b2242.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3610 = Wire(Bool()).suggestName("x3610_b2086_D14") 
      x3610.r := getRetimed(b2086.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3611 = Wire(Bool()).suggestName("x3611_b564_D14") 
      x3611.r := getRetimed(b564.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3612 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3612_b2241_D14") 
      x3612.r := getRetimed(b2241.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x2249_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2249_wr_ofs = List[UInt](x3612.r)
      val x2249_wr_en = List[Bool](true.B)
      val x2249_wr_data = List[UInt](x2248_mul.r)
      x2090_tmp_1.connectWPort(2249, x2249_wr_banks, x2249_wr_ofs, x2249_wr_data, x2249_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3609 & x3610 & x3611))
      val x2250_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2250_wr_ofs = List[UInt](x3612.r)
      val x2250_wr_en = List[Bool](true.B)
      val x2250_wr_data = List[UInt](x2248_mul.r)
      x2093_tmp_4.connectWPort(2250, x2250_wr_banks, x2250_wr_ofs, x2250_wr_data, x2250_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3609 & x3610 & x3611))
      val x2251_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2251_wr_ofs = List[UInt](x3612.r)
      val x2251_wr_en = List[Bool](true.B)
      val x2251_wr_data = List[UInt](x2248_mul.r)
      x2089_tmp_0.connectWPort(2251, x2251_wr_banks, x2251_wr_ofs, x2251_wr_data, x2251_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3609 & x3610 & x3611))
      val x2252_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2252_wr_ofs = List[UInt](x3612.r)
      val x2252_wr_en = List[Bool](true.B)
      val x2252_wr_data = List[UInt](x2248_mul.r)
      x2092_tmp_3.connectWPort(2252, x2252_wr_banks, x2252_wr_ofs, x2252_wr_data, x2252_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3609 & x3610 & x3611))
      val x2253_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2253_wr_ofs = List[UInt](x3612.r)
      val x2253_wr_en = List[Bool](true.B)
      val x2253_wr_data = List[UInt](x2248_mul.r)
      x2091_tmp_2.connectWPort(2253, x2253_wr_banks, x2253_wr_ofs, x2253_wr_data, x2253_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3609 & x3610 & x3611))
    }
    val module = Module(new x2254_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2254_inr_Foreach **/
