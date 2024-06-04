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

/** Hierarchy: x2792 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2792_inr_Foreach **/
class x2792_inr_Foreach_kernel(
  list_b561: List[Bool],
  list_b551: List[FixedPoint],
  list_x576_accum_1: List[NBufInterface],
  list_x473_A_sram_2: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2792_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2792_inr_Foreach_iiCtr"))
  
  abstract class x2792_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b561 = Input(Bool())
      val in_b551 = Input(new FixedPoint(true, 32, 0))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x576_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x576_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b561 = {io.in_b561} 
    def b551 = {io.in_b551} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x576_accum_1 = {io.in_x576_accum_1} ; io.in_x576_accum_1 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
  }
  def connectWires0(module: x2792_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b561 <> b561
    module.io.in_b551 <> b551
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x576_accum_1.connectLedger(module.io.in_x576_accum_1)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
  }
  val b561 = list_b561(0)
  val b551 = list_b551(0)
  val x576_accum_1 = list_x576_accum_1(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2792_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2792_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2792_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2792_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2792_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2792_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2792_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2792_instrctr, cycles_x2792_inr_Foreach.io.count, iters_x2792_inr_Foreach.io.count, 0.U, 0.U)
      val b2780 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2780.suggestName("b2780")
      val b2781 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2781.suggestName("b2781")
      val x2782_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2782_rd""")
      val x2782_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2782_rd_ofs = List[UInt](b2780.r)
      val x2782_rd_en = List[Bool](true.B)
      val x2782_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2781 & b561 ).suggestName("x2782_rd_shared_en")
      x2782_rd.toSeq.zip(x576_accum_1.connectRPort(2782, x2782_rd_banks, x2782_rd_ofs, io.sigsIn.backpressure, x2782_rd_en.map(_ && x2782_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2783 = VecApply(x2782,0)
      val x2783_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2783_elem_0""")
      x2783_elem_0.r := x2782_rd(0).r
      val x2785_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2785_div""")
      x2785_div.r := (Math.div(b551, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2785_div")).r
      val x3105 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3105""")
      x3105.r := Math.arith_left_shift(x2785_div, 1, Some(0.2), true.B,"x3105").r
      val x3106_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3106_sum""")
      x3106_sum.r := Math.add(x3105,x2785_div,Some(1.0), true.B, Truncate, Wrapping, "x3106_sum").r
      val x3779 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3779_b2780_D21") 
      x3779.r := getRetimed(b2780.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2787_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2787_sum""")
      x2787_sum.r := Math.add(x3106_sum,x3779,Some(1.0), true.B, Truncate, Wrapping, "x2787_sum").r
      val x3780 = Wire(Bool()).suggestName("x3780_b2781_D22") 
      x3780.r := getRetimed(b2781.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3781 = Wire(Bool()).suggestName("x3781_b561_D22") 
      x3781.r := getRetimed(b561.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2788_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2788_rd""")
      val x2788_rd_banks = List[UInt](4L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2788_rd_ofs = List[UInt](x2787_sum.r)
      val x2788_rd_en = List[Bool](true.B)
      val x2788_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3780 & x3781 ).suggestName("x2788_rd_shared_en")
      x2788_rd.toSeq.zip(x473_A_sram_2.connectRPort(2788, x2788_rd_banks, x2788_rd_ofs, io.sigsIn.backpressure, x2788_rd_en.map(_ && x2788_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2789 = VecApply(x2788,0)
      val x2789_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2789_elem_0""")
      x2789_elem_0.r := x2788_rd(0).r
      val x3782 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3782_x2783_elem_0_D22") 
      x3782.r := getRetimed(x2783_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2790_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2790_sum""")
      x2790_sum.r := Math.add(x3782,x2789_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2790_sum").r
      val x3783 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3783_x2787_sum_D3") 
      x3783.r := getRetimed(x2787_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3784 = Wire(Bool()).suggestName("x3784_b561_D25") 
      x3784.r := getRetimed(b561.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3785 = Wire(Bool()).suggestName("x3785_b2781_D25") 
      x3785.r := getRetimed(b2781.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2791_wr_banks = List[UInt](4L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2791_wr_ofs = List[UInt](x3783.r)
      val x2791_wr_en = List[Bool](true.B)
      val x2791_wr_data = List[UInt](x2790_sum.r)
      x544_out_sram_0.connectWPort(2791, x2791_wr_banks, x2791_wr_ofs, x2791_wr_data, x2791_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3785 & x3784))
    }
    val module = Module(new x2792_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2792_inr_Foreach **/
