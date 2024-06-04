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

/** Hierarchy: x2753 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2753_inr_Foreach **/
class x2753_inr_Foreach_kernel(
  list_b558: List[Bool],
  list_b548: List[FixedPoint],
  list_x473_A_sram_2: List[StandardInterface],
  list_x570_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2753_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2753_inr_Foreach_iiCtr"))
  
  abstract class x2753_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x570_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x570_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b558 = Input(Bool())
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_b548 = Input(new FixedPoint(true, 32, 0))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x570_accum_1 = {io.in_x570_accum_1} ; io.in_x570_accum_1 := DontCare
    def b558 = {io.in_b558} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def b548 = {io.in_b548} 
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
  }
  def connectWires0(module: x2753_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x570_accum_1.connectLedger(module.io.in_x570_accum_1)
    module.io.in_b558 <> b558
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    module.io.in_b548 <> b548
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
  }
  val b558 = list_b558(0)
  val b548 = list_b548(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  val x570_accum_1 = list_x570_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2753_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2753_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2753_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2753_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2753_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2753_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2753_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2753_instrctr, cycles_x2753_inr_Foreach.io.count, iters_x2753_inr_Foreach.io.count, 0.U, 0.U)
      val b2741 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2741.suggestName("b2741")
      val b2742 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2742.suggestName("b2742")
      val x2743_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2743_rd""")
      val x2743_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2743_rd_ofs = List[UInt](b2741.r)
      val x2743_rd_en = List[Bool](true.B)
      val x2743_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2742 & b558 ).suggestName("x2743_rd_shared_en")
      x2743_rd.toSeq.zip(x570_accum_1.connectRPort(2743, x2743_rd_banks, x2743_rd_ofs, io.sigsIn.backpressure, x2743_rd_en.map(_ && x2743_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2744 = VecApply(x2743,0)
      val x2744_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2744_elem_0""")
      x2744_elem_0.r := x2743_rd(0).r
      val x2746_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2746_div""")
      x2746_div.r := (Math.div(b548, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2746_div")).r
      val x3099 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3099""")
      x3099.r := Math.arith_left_shift(x2746_div, 1, Some(0.2), true.B,"x3099").r
      val x3100_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3100_sum""")
      x3100_sum.r := Math.add(x3099,x2746_div,Some(1.0), true.B, Truncate, Wrapping, "x3100_sum").r
      val x3758 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3758_b2741_D21") 
      x3758.r := getRetimed(b2741.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2748_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2748_sum""")
      x2748_sum.r := Math.add(x3100_sum,x3758,Some(1.0), true.B, Truncate, Wrapping, "x2748_sum").r
      val x3759 = Wire(Bool()).suggestName("x3759_b2742_D22") 
      x3759.r := getRetimed(b2742.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3760 = Wire(Bool()).suggestName("x3760_b558_D22") 
      x3760.r := getRetimed(b558.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2749_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2749_rd""")
      val x2749_rd_banks = List[UInt](1L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2749_rd_ofs = List[UInt](x2748_sum.r)
      val x2749_rd_en = List[Bool](true.B)
      val x2749_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3759 & x3760 ).suggestName("x2749_rd_shared_en")
      x2749_rd.toSeq.zip(x473_A_sram_2.connectRPort(2749, x2749_rd_banks, x2749_rd_ofs, io.sigsIn.backpressure, x2749_rd_en.map(_ && x2749_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2750 = VecApply(x2749,0)
      val x2750_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2750_elem_0""")
      x2750_elem_0.r := x2749_rd(0).r
      val x3761 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3761_x2744_elem_0_D22") 
      x3761.r := getRetimed(x2744_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2751_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2751_sum""")
      x2751_sum.r := Math.add(x3761,x2750_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2751_sum").r
      val x3762 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3762_x2748_sum_D3") 
      x3762.r := getRetimed(x2748_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3763 = Wire(Bool()).suggestName("x3763_b558_D25") 
      x3763.r := getRetimed(b558.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3764 = Wire(Bool()).suggestName("x3764_b2742_D25") 
      x3764.r := getRetimed(b2742.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2752_wr_banks = List[UInt](1L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2752_wr_ofs = List[UInt](x3762.r)
      val x2752_wr_en = List[Bool](true.B)
      val x2752_wr_data = List[UInt](x2751_sum.r)
      x544_out_sram_0.connectWPort(2752, x2752_wr_banks, x2752_wr_ofs, x2752_wr_data, x2752_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3764 & x3763))
    }
    val module = Module(new x2753_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2753_inr_Foreach **/
