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

/** Hierarchy: x2857 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2857_inr_Foreach **/
class x2857_inr_Foreach_kernel(
  list_b566: List[Bool],
  list_b556: List[FixedPoint],
  list_x473_A_sram_2: List[StandardInterface],
  list_x586_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2857_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2857_inr_Foreach_iiCtr"))
  
  abstract class x2857_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b566 = Input(Bool())
      val in_x586_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x586_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_b556 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b566 = {io.in_b566} 
    def x586_accum_1 = {io.in_x586_accum_1} ; io.in_x586_accum_1 := DontCare
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def b556 = {io.in_b556} 
  }
  def connectWires0(module: x2857_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b566 <> b566
    x586_accum_1.connectLedger(module.io.in_x586_accum_1)
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    module.io.in_b556 <> b556
  }
  val b566 = list_b566(0)
  val b556 = list_b556(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  val x586_accum_1 = list_x586_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2857_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2857_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2857_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2857_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2857_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2857_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2857_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2857_instrctr, cycles_x2857_inr_Foreach.io.count, iters_x2857_inr_Foreach.io.count, 0.U, 0.U)
      val b2845 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2845.suggestName("b2845")
      val b2846 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2846.suggestName("b2846")
      val x2847_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2847_rd""")
      val x2847_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2847_rd_ofs = List[UInt](b2845.r)
      val x2847_rd_en = List[Bool](true.B)
      val x2847_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2846 & b566 ).suggestName("x2847_rd_shared_en")
      x2847_rd.toSeq.zip(x586_accum_1.connectRPort(2847, x2847_rd_banks, x2847_rd_ofs, io.sigsIn.backpressure, x2847_rd_en.map(_ && x2847_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2848 = VecApply(x2847,0)
      val x2848_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2848_elem_0""")
      x2848_elem_0.r := x2847_rd(0).r
      val x2850_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2850_div""")
      x2850_div.r := (Math.div(b556, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2850_div")).r
      val x3115 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3115""")
      x3115.r := Math.arith_left_shift(x2850_div, 1, Some(0.2), true.B,"x3115").r
      val x3116_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3116_sum""")
      x3116_sum.r := Math.add(x3115,x2850_div,Some(1.0), true.B, Truncate, Wrapping, "x3116_sum").r
      val x3814 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3814_b2845_D21") 
      x3814.r := getRetimed(b2845.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2852_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2852_sum""")
      x2852_sum.r := Math.add(x3116_sum,x3814,Some(1.0), true.B, Truncate, Wrapping, "x2852_sum").r
      val x3815 = Wire(Bool()).suggestName("x3815_b2846_D22") 
      x3815.r := getRetimed(b2846.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3816 = Wire(Bool()).suggestName("x3816_b566_D22") 
      x3816.r := getRetimed(b566.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2853_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2853_rd""")
      val x2853_rd_banks = List[UInt](9L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2853_rd_ofs = List[UInt](x2852_sum.r)
      val x2853_rd_en = List[Bool](true.B)
      val x2853_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3815 & x3816 ).suggestName("x2853_rd_shared_en")
      x2853_rd.toSeq.zip(x473_A_sram_2.connectRPort(2853, x2853_rd_banks, x2853_rd_ofs, io.sigsIn.backpressure, x2853_rd_en.map(_ && x2853_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2854 = VecApply(x2853,0)
      val x2854_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2854_elem_0""")
      x2854_elem_0.r := x2853_rd(0).r
      val x3817 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3817_x2848_elem_0_D22") 
      x3817.r := getRetimed(x2848_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2855_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2855_sum""")
      x2855_sum.r := Math.add(x3817,x2854_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2855_sum").r
      val x3818 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3818_x2852_sum_D3") 
      x3818.r := getRetimed(x2852_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3819 = Wire(Bool()).suggestName("x3819_b566_D25") 
      x3819.r := getRetimed(b566.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3820 = Wire(Bool()).suggestName("x3820_b2846_D25") 
      x3820.r := getRetimed(b2846.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2856_wr_banks = List[UInt](9L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2856_wr_ofs = List[UInt](x3818.r)
      val x2856_wr_en = List[Bool](true.B)
      val x2856_wr_data = List[UInt](x2855_sum.r)
      x544_out_sram_0.connectWPort(2856, x2856_wr_banks, x2856_wr_ofs, x2856_wr_data, x2856_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3820 & x3819))
    }
    val module = Module(new x2857_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2857_inr_Foreach **/
