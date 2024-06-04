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

/** Hierarchy: x2844 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2844_inr_Foreach **/
class x2844_inr_Foreach_kernel(
  list_b565: List[Bool],
  list_b555: List[FixedPoint],
  list_x473_A_sram_2: List[StandardInterface],
  list_x584_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2844_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2844_inr_Foreach_iiCtr"))
  
  abstract class x2844_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b555 = Input(new FixedPoint(true, 32, 0))
      val in_b565 = Input(Bool())
      val in_x584_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x584_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b555 = {io.in_b555} 
    def b565 = {io.in_b565} 
    def x584_accum_1 = {io.in_x584_accum_1} ; io.in_x584_accum_1 := DontCare
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
  }
  def connectWires0(module: x2844_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b555 <> b555
    module.io.in_b565 <> b565
    x584_accum_1.connectLedger(module.io.in_x584_accum_1)
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
  }
  val b565 = list_b565(0)
  val b555 = list_b555(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  val x584_accum_1 = list_x584_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2844_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2844_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2844_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2844_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2844_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2844_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2844_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2844_instrctr, cycles_x2844_inr_Foreach.io.count, iters_x2844_inr_Foreach.io.count, 0.U, 0.U)
      val b2832 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2832.suggestName("b2832")
      val b2833 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2833.suggestName("b2833")
      val x2834_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2834_rd""")
      val x2834_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2834_rd_ofs = List[UInt](b2832.r)
      val x2834_rd_en = List[Bool](true.B)
      val x2834_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2833 & b565 ).suggestName("x2834_rd_shared_en")
      x2834_rd.toSeq.zip(x584_accum_1.connectRPort(2834, x2834_rd_banks, x2834_rd_ofs, io.sigsIn.backpressure, x2834_rd_en.map(_ && x2834_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2835 = VecApply(x2834,0)
      val x2835_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2835_elem_0""")
      x2835_elem_0.r := x2834_rd(0).r
      val x2837_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2837_div""")
      x2837_div.r := (Math.div(b555, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2837_div")).r
      val x3113 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3113""")
      x3113.r := Math.arith_left_shift(x2837_div, 1, Some(0.2), true.B,"x3113").r
      val x3114_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3114_sum""")
      x3114_sum.r := Math.add(x3113,x2837_div,Some(1.0), true.B, Truncate, Wrapping, "x3114_sum").r
      val x3807 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3807_b2832_D21") 
      x3807.r := getRetimed(b2832.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2839_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2839_sum""")
      x2839_sum.r := Math.add(x3114_sum,x3807,Some(1.0), true.B, Truncate, Wrapping, "x2839_sum").r
      val x3808 = Wire(Bool()).suggestName("x3808_b2833_D22") 
      x3808.r := getRetimed(b2833.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3809 = Wire(Bool()).suggestName("x3809_b565_D22") 
      x3809.r := getRetimed(b565.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2840_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2840_rd""")
      val x2840_rd_banks = List[UInt](8L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2840_rd_ofs = List[UInt](x2839_sum.r)
      val x2840_rd_en = List[Bool](true.B)
      val x2840_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3808 & x3809 ).suggestName("x2840_rd_shared_en")
      x2840_rd.toSeq.zip(x473_A_sram_2.connectRPort(2840, x2840_rd_banks, x2840_rd_ofs, io.sigsIn.backpressure, x2840_rd_en.map(_ && x2840_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2841 = VecApply(x2840,0)
      val x2841_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2841_elem_0""")
      x2841_elem_0.r := x2840_rd(0).r
      val x3810 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3810_x2835_elem_0_D22") 
      x3810.r := getRetimed(x2835_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2842_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2842_sum""")
      x2842_sum.r := Math.add(x3810,x2841_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2842_sum").r
      val x3811 = Wire(Bool()).suggestName("x3811_b565_D25") 
      x3811.r := getRetimed(b565.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3812 = Wire(Bool()).suggestName("x3812_b2833_D25") 
      x3812.r := getRetimed(b2833.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3813 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3813_x2839_sum_D3") 
      x3813.r := getRetimed(x2839_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x2843_wr_banks = List[UInt](8L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2843_wr_ofs = List[UInt](x3813.r)
      val x2843_wr_en = List[Bool](true.B)
      val x2843_wr_data = List[UInt](x2842_sum.r)
      x544_out_sram_0.connectWPort(2843, x2843_wr_banks, x2843_wr_ofs, x2843_wr_data, x2843_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3812 & x3811))
    }
    val module = Module(new x2844_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2844_inr_Foreach **/
