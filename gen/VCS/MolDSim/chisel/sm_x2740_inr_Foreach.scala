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

/** Hierarchy: x2740 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2740_inr_Foreach **/
class x2740_inr_Foreach_kernel(
  list_b557: List[Bool],
  list_b547: List[FixedPoint],
  list_x568_accum_1: List[NBufInterface],
  list_x473_A_sram_2: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2740_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2740_inr_Foreach_iiCtr"))
  
  abstract class x2740_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b547 = Input(new FixedPoint(true, 32, 0))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_b557 = Input(Bool())
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_x568_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x568_accum_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b547 = {io.in_b547} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def b557 = {io.in_b557} 
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def x568_accum_1 = {io.in_x568_accum_1} ; io.in_x568_accum_1 := DontCare
  }
  def connectWires0(module: x2740_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b547 <> b547
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    module.io.in_b557 <> b557
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    x568_accum_1.connectLedger(module.io.in_x568_accum_1)
  }
  val b557 = list_b557(0)
  val b547 = list_b547(0)
  val x568_accum_1 = list_x568_accum_1(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2740_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2740_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2740_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2740_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2740_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2740_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2740_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2740_instrctr, cycles_x2740_inr_Foreach.io.count, iters_x2740_inr_Foreach.io.count, 0.U, 0.U)
      val b2728 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2728.suggestName("b2728")
      val b2729 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2729.suggestName("b2729")
      val x2730_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2730_rd""")
      val x2730_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2730_rd_ofs = List[UInt](b2728.r)
      val x2730_rd_en = List[Bool](true.B)
      val x2730_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2729 & b557 ).suggestName("x2730_rd_shared_en")
      x2730_rd.toSeq.zip(x568_accum_1.connectRPort(2730, x2730_rd_banks, x2730_rd_ofs, io.sigsIn.backpressure, x2730_rd_en.map(_ && x2730_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2731 = VecApply(x2730,0)
      val x2731_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2731_elem_0""")
      x2731_elem_0.r := x2730_rd(0).r
      val x2733_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2733_div""")
      x2733_div.r := (Math.div(b547, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2733_div")).r
      val x3097 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3097""")
      x3097.r := Math.arith_left_shift(x2733_div, 1, Some(0.2), true.B,"x3097").r
      val x3098_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3098_sum""")
      x3098_sum.r := Math.add(x3097,x2733_div,Some(1.0), true.B, Truncate, Wrapping, "x3098_sum").r
      val x3751 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3751_b2728_D21") 
      x3751.r := getRetimed(b2728.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2735_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2735_sum""")
      x2735_sum.r := Math.add(x3098_sum,x3751,Some(1.0), true.B, Truncate, Wrapping, "x2735_sum").r
      val x3752 = Wire(Bool()).suggestName("x3752_b557_D22") 
      x3752.r := getRetimed(b557.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3753 = Wire(Bool()).suggestName("x3753_b2729_D22") 
      x3753.r := getRetimed(b2729.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2736_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2736_rd""")
      val x2736_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2736_rd_ofs = List[UInt](x2735_sum.r)
      val x2736_rd_en = List[Bool](true.B)
      val x2736_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3753 & x3752 ).suggestName("x2736_rd_shared_en")
      x2736_rd.toSeq.zip(x473_A_sram_2.connectRPort(2736, x2736_rd_banks, x2736_rd_ofs, io.sigsIn.backpressure, x2736_rd_en.map(_ && x2736_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2737 = VecApply(x2736,0)
      val x2737_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2737_elem_0""")
      x2737_elem_0.r := x2736_rd(0).r
      val x3754 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3754_x2731_elem_0_D22") 
      x3754.r := getRetimed(x2731_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2738_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2738_sum""")
      x2738_sum.r := Math.add(x3754,x2737_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2738_sum").r
      val x3755 = Wire(Bool()).suggestName("x3755_b557_D25") 
      x3755.r := getRetimed(b557.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3756 = Wire(Bool()).suggestName("x3756_b2729_D25") 
      x3756.r := getRetimed(b2729.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3757 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3757_x2735_sum_D3") 
      x3757.r := getRetimed(x2735_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x2739_wr_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2739_wr_ofs = List[UInt](x3757.r)
      val x2739_wr_en = List[Bool](true.B)
      val x2739_wr_data = List[UInt](x2738_sum.r)
      x544_out_sram_0.connectWPort(2739, x2739_wr_banks, x2739_wr_ofs, x2739_wr_data, x2739_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3756 & x3755))
    }
    val module = Module(new x2740_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2740_inr_Foreach **/
