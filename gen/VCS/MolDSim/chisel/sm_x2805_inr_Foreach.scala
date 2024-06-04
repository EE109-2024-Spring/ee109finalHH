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

/** Hierarchy: x2805 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2805_inr_Foreach **/
class x2805_inr_Foreach_kernel(
  list_b562: List[Bool],
  list_b552: List[FixedPoint],
  list_x473_A_sram_2: List[StandardInterface],
  list_x578_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2805_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2805_inr_Foreach_iiCtr"))
  
  abstract class x2805_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x578_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x578_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_b552 = Input(new FixedPoint(true, 32, 0))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x578_accum_1 = {io.in_x578_accum_1} ; io.in_x578_accum_1 := DontCare
    def b562 = {io.in_b562} 
    def b552 = {io.in_b552} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
  }
  def connectWires0(module: x2805_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x578_accum_1.connectLedger(module.io.in_x578_accum_1)
    module.io.in_b562 <> b562
    module.io.in_b552 <> b552
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
  }
  val b562 = list_b562(0)
  val b552 = list_b552(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  val x578_accum_1 = list_x578_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2805_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2805_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2805_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2805_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2805_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2805_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2805_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2805_instrctr, cycles_x2805_inr_Foreach.io.count, iters_x2805_inr_Foreach.io.count, 0.U, 0.U)
      val b2793 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2793.suggestName("b2793")
      val b2794 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2794.suggestName("b2794")
      val x2795_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2795_rd""")
      val x2795_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2795_rd_ofs = List[UInt](b2793.r)
      val x2795_rd_en = List[Bool](true.B)
      val x2795_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2794 & b562 ).suggestName("x2795_rd_shared_en")
      x2795_rd.toSeq.zip(x578_accum_1.connectRPort(2795, x2795_rd_banks, x2795_rd_ofs, io.sigsIn.backpressure, x2795_rd_en.map(_ && x2795_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2796 = VecApply(x2795,0)
      val x2796_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2796_elem_0""")
      x2796_elem_0.r := x2795_rd(0).r
      val x2798_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2798_div""")
      x2798_div.r := (Math.div(b552, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2798_div")).r
      val x3107 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3107""")
      x3107.r := Math.arith_left_shift(x2798_div, 1, Some(0.2), true.B,"x3107").r
      val x3108_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3108_sum""")
      x3108_sum.r := Math.add(x3107,x2798_div,Some(1.0), true.B, Truncate, Wrapping, "x3108_sum").r
      val x3786 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3786_b2793_D21") 
      x3786.r := getRetimed(b2793.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2800_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2800_sum""")
      x2800_sum.r := Math.add(x3108_sum,x3786,Some(1.0), true.B, Truncate, Wrapping, "x2800_sum").r
      val x3787 = Wire(Bool()).suggestName("x3787_b562_D22") 
      x3787.r := getRetimed(b562.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3788 = Wire(Bool()).suggestName("x3788_b2794_D22") 
      x3788.r := getRetimed(b2794.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2801_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2801_rd""")
      val x2801_rd_banks = List[UInt](5L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2801_rd_ofs = List[UInt](x2800_sum.r)
      val x2801_rd_en = List[Bool](true.B)
      val x2801_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3788 & x3787 ).suggestName("x2801_rd_shared_en")
      x2801_rd.toSeq.zip(x473_A_sram_2.connectRPort(2801, x2801_rd_banks, x2801_rd_ofs, io.sigsIn.backpressure, x2801_rd_en.map(_ && x2801_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2802 = VecApply(x2801,0)
      val x2802_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2802_elem_0""")
      x2802_elem_0.r := x2801_rd(0).r
      val x3789 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3789_x2796_elem_0_D22") 
      x3789.r := getRetimed(x2796_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2803_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2803_sum""")
      x2803_sum.r := Math.add(x3789,x2802_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2803_sum").r
      val x3790 = Wire(Bool()).suggestName("x3790_b2794_D25") 
      x3790.r := getRetimed(b2794.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3791 = Wire(Bool()).suggestName("x3791_b562_D25") 
      x3791.r := getRetimed(b562.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3792 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3792_x2800_sum_D3") 
      x3792.r := getRetimed(x2800_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x2804_wr_banks = List[UInt](5L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2804_wr_ofs = List[UInt](x3792.r)
      val x2804_wr_en = List[Bool](true.B)
      val x2804_wr_data = List[UInt](x2803_sum.r)
      x544_out_sram_0.connectWPort(2804, x2804_wr_banks, x2804_wr_ofs, x2804_wr_data, x2804_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3790 & x3791))
    }
    val module = Module(new x2805_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2805_inr_Foreach **/
