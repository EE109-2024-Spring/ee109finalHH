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

/** Hierarchy: x2144 -> x2145 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2144_inr_Foreach **/
class x2144_inr_Foreach_kernel(
  list_b564: List[Bool],
  list_b554: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x2094_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2144_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2144_inr_Foreach_iiCtr"))
  
  abstract class x2144_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2094_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2094_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b554 = Input(new FixedPoint(true, 32, 0))
      val in_b2084 = Input(new FixedPoint(true, 32, 0))
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
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b554 = {io.in_b554} 
    def b2084 = {io.in_b2084} 
    def x2097_tmp_3 = {io.in_x2097_tmp_3} ; io.in_x2097_tmp_3 := DontCare
    def x2096_tmp_2 = {io.in_x2096_tmp_2} ; io.in_x2096_tmp_2 := DontCare
    def x2098_tmp_4 = {io.in_x2098_tmp_4} ; io.in_x2098_tmp_4 := DontCare
    def x2095_tmp_1 = {io.in_x2095_tmp_1} ; io.in_x2095_tmp_1 := DontCare
    def b564 = {io.in_b564} 
    def b2087 = {io.in_b2087} 
  }
  def connectWires0(module: x2144_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x2094_tmp_0.connectLedger(module.io.in_x2094_tmp_0)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b554 <> b554
    module.io.in_b2084 <> b2084
    x2097_tmp_3.connectLedger(module.io.in_x2097_tmp_3)
    x2096_tmp_2.connectLedger(module.io.in_x2096_tmp_2)
    x2098_tmp_4.connectLedger(module.io.in_x2098_tmp_4)
    x2095_tmp_1.connectLedger(module.io.in_x2095_tmp_1)
    module.io.in_b564 <> b564
    module.io.in_b2087 <> b2087
  }
  val b564 = list_b564(0)
  val b2087 = list_b564(1)
  val b554 = list_b554(0)
  val b2084 = list_b554(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x2094_tmp_0 = list_x2094_tmp_0(0)
  val x2097_tmp_3 = list_x2094_tmp_0(1)
  val x2096_tmp_2 = list_x2094_tmp_0(2)
  val x2098_tmp_4 = list_x2094_tmp_0(3)
  val x2095_tmp_1 = list_x2094_tmp_0(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2144_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2144_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2144_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2144_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2144_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2144_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2144_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2144_instrctr, cycles_x2144_inr_Foreach.io.count, iters_x2144_inr_Foreach.io.count, 0.U, 0.U)
      val b2124 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2124.suggestName("b2124")
      val b2125 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2125.suggestName("b2125")
      val x2130_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2130_rd""")
      val x2130_rd_banks = List[UInt](0.U,0.U)
      val x2130_rd_ofs = List[UInt](0.U)
      val x2130_rd_en = List[Bool](true.B)
      val x2130_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2130_rd_shared_en")
      x2130_rd.toSeq.zip(x471_A_sram_0.connectRPort(2130, x2130_rd_banks, x2130_rd_ofs, io.sigsIn.backpressure, x2130_rd_en.map(_ && x2130_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2131 = VecApply(x2130,0)
      val x2131_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2131_elem_0""")
      x2131_elem_0.r := x2130_rd(0).r
      val x2136_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2136_rd""")
      val x2136_rd_banks = List[UInt](0.U,0.U)
      val x2136_rd_ofs = List[UInt](0.U)
      val x2136_rd_en = List[Bool](true.B)
      val x2136_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2136_rd_shared_en")
      x2136_rd.toSeq.zip(x472_A_sram_1.connectRPort(2136, x2136_rd_banks, x2136_rd_ofs, io.sigsIn.backpressure, x2136_rd_en.map(_ && x2136_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2137 = VecApply(x2136,0)
      val x2137_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2137_elem_0""")
      x2137_elem_0.r := x2136_rd(0).r
      val x3589 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3589_x2137_elem_0_D20") 
      x3589.r := getRetimed(x2137_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2138_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2138_sub""")
      x2138_sub.r := Math.sub(x2131_elem_0,x3589,Some(1.0), true.B, Truncate, Wrapping, "x2138_sub").r
      val x3590 = Wire(Bool()).suggestName("x3590_b2125_D25") 
      x3590.r := getRetimed(b2125.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3591 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3591_b2124_D25") 
      x3591.r := getRetimed(b2124.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3592 = Wire(Bool()).suggestName("x3592_b564_D25") 
      x3592.r := getRetimed(b564.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3593 = Wire(Bool()).suggestName("x3593_b2087_D25") 
      x3593.r := getRetimed(b2087.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2139_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2139_wr_ofs = List[UInt](x3591.r)
      val x2139_wr_en = List[Bool](true.B)
      val x2139_wr_data = List[UInt](x2138_sub.r)
      x2094_tmp_0.connectWPort(2139, x2139_wr_banks, x2139_wr_ofs, x2139_wr_data, x2139_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3590 & x3593 & x3592))
      val x2140_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2140_wr_ofs = List[UInt](x3591.r)
      val x2140_wr_en = List[Bool](true.B)
      val x2140_wr_data = List[UInt](x2138_sub.r)
      x2097_tmp_3.connectWPort(2140, x2140_wr_banks, x2140_wr_ofs, x2140_wr_data, x2140_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3590 & x3593 & x3592))
      val x2141_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2141_wr_ofs = List[UInt](x3591.r)
      val x2141_wr_en = List[Bool](true.B)
      val x2141_wr_data = List[UInt](x2138_sub.r)
      x2096_tmp_2.connectWPort(2141, x2141_wr_banks, x2141_wr_ofs, x2141_wr_data, x2141_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3590 & x3593 & x3592))
      val x2142_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2142_wr_ofs = List[UInt](x3591.r)
      val x2142_wr_en = List[Bool](true.B)
      val x2142_wr_data = List[UInt](x2138_sub.r)
      x2098_tmp_4.connectWPort(2142, x2142_wr_banks, x2142_wr_ofs, x2142_wr_data, x2142_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3590 & x3593 & x3592))
      val x2143_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2143_wr_ofs = List[UInt](x3591.r)
      val x2143_wr_en = List[Bool](true.B)
      val x2143_wr_data = List[UInt](x2138_sub.r)
      x2095_tmp_1.connectWPort(2143, x2143_wr_banks, x2143_wr_ofs, x2143_wr_data, x2143_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3590 & x3593 & x3592))
    }
    val module = Module(new x2144_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2144_inr_Foreach **/
