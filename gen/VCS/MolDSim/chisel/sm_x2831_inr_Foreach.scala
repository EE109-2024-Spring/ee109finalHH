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

/** Hierarchy: x2831 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2831_inr_Foreach **/
class x2831_inr_Foreach_kernel(
  list_b564: List[Bool],
  list_b554: List[FixedPoint],
  list_x473_A_sram_2: List[StandardInterface],
  list_x582_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2831_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2831_inr_Foreach_iiCtr"))
  
  abstract class x2831_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x582_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x582_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b554 = Input(new FixedPoint(true, 32, 0))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_b564 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x582_accum_1 = {io.in_x582_accum_1} ; io.in_x582_accum_1 := DontCare
    def b554 = {io.in_b554} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def b564 = {io.in_b564} 
  }
  def connectWires0(module: x2831_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x582_accum_1.connectLedger(module.io.in_x582_accum_1)
    module.io.in_b554 <> b554
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    module.io.in_b564 <> b564
  }
  val b564 = list_b564(0)
  val b554 = list_b554(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  val x582_accum_1 = list_x582_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2831_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2831_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2831_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2831_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2831_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2831_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2831_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2831_instrctr, cycles_x2831_inr_Foreach.io.count, iters_x2831_inr_Foreach.io.count, 0.U, 0.U)
      val b2819 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2819.suggestName("b2819")
      val b2820 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2820.suggestName("b2820")
      val x2821_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2821_rd""")
      val x2821_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2821_rd_ofs = List[UInt](b2819.r)
      val x2821_rd_en = List[Bool](true.B)
      val x2821_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2820 & b564 ).suggestName("x2821_rd_shared_en")
      x2821_rd.toSeq.zip(x582_accum_1.connectRPort(2821, x2821_rd_banks, x2821_rd_ofs, io.sigsIn.backpressure, x2821_rd_en.map(_ && x2821_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2822 = VecApply(x2821,0)
      val x2822_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2822_elem_0""")
      x2822_elem_0.r := x2821_rd(0).r
      val x2824_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2824_div""")
      x2824_div.r := (Math.div(b554, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2824_div")).r
      val x3111 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3111""")
      x3111.r := Math.arith_left_shift(x2824_div, 1, Some(0.2), true.B,"x3111").r
      val x3112_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3112_sum""")
      x3112_sum.r := Math.add(x3111,x2824_div,Some(1.0), true.B, Truncate, Wrapping, "x3112_sum").r
      val x3800 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3800_b2819_D21") 
      x3800.r := getRetimed(b2819.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2826_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2826_sum""")
      x2826_sum.r := Math.add(x3112_sum,x3800,Some(1.0), true.B, Truncate, Wrapping, "x2826_sum").r
      val x3801 = Wire(Bool()).suggestName("x3801_b564_D22") 
      x3801.r := getRetimed(b564.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3802 = Wire(Bool()).suggestName("x3802_b2820_D22") 
      x3802.r := getRetimed(b2820.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2827_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2827_rd""")
      val x2827_rd_banks = List[UInt](7L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2827_rd_ofs = List[UInt](x2826_sum.r)
      val x2827_rd_en = List[Bool](true.B)
      val x2827_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3802 & x3801 ).suggestName("x2827_rd_shared_en")
      x2827_rd.toSeq.zip(x473_A_sram_2.connectRPort(2827, x2827_rd_banks, x2827_rd_ofs, io.sigsIn.backpressure, x2827_rd_en.map(_ && x2827_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2828 = VecApply(x2827,0)
      val x2828_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2828_elem_0""")
      x2828_elem_0.r := x2827_rd(0).r
      val x3803 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3803_x2822_elem_0_D22") 
      x3803.r := getRetimed(x2822_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2829_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2829_sum""")
      x2829_sum.r := Math.add(x3803,x2828_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2829_sum").r
      val x3804 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3804_x2826_sum_D3") 
      x3804.r := getRetimed(x2826_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3805 = Wire(Bool()).suggestName("x3805_b2820_D25") 
      x3805.r := getRetimed(b2820.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3806 = Wire(Bool()).suggestName("x3806_b564_D25") 
      x3806.r := getRetimed(b564.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2830_wr_banks = List[UInt](7L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2830_wr_ofs = List[UInt](x3804.r)
      val x2830_wr_en = List[Bool](true.B)
      val x2830_wr_data = List[UInt](x2829_sum.r)
      x544_out_sram_0.connectWPort(2830, x2830_wr_banks, x2830_wr_ofs, x2830_wr_data, x2830_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3805 & x3806))
    }
    val module = Module(new x2831_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2831_inr_Foreach **/
