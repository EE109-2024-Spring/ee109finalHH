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

/** Hierarchy: x2818 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2818_inr_Foreach **/
class x2818_inr_Foreach_kernel(
  list_b563: List[Bool],
  list_b553: List[FixedPoint],
  list_x580_accum_1: List[NBufInterface],
  list_x473_A_sram_2: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2818_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2818_inr_Foreach_iiCtr"))
  
  abstract class x2818_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b563 = Input(Bool())
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_b553 = Input(new FixedPoint(true, 32, 0))
      val in_x580_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x580_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b563 = {io.in_b563} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def b553 = {io.in_b553} 
    def x580_accum_1 = {io.in_x580_accum_1} ; io.in_x580_accum_1 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
  }
  def connectWires0(module: x2818_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b563 <> b563
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    module.io.in_b553 <> b553
    x580_accum_1.connectLedger(module.io.in_x580_accum_1)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
  }
  val b563 = list_b563(0)
  val b553 = list_b553(0)
  val x580_accum_1 = list_x580_accum_1(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2818_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2818_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2818_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2818_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2818_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2818_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2818_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2818_instrctr, cycles_x2818_inr_Foreach.io.count, iters_x2818_inr_Foreach.io.count, 0.U, 0.U)
      val b2806 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2806.suggestName("b2806")
      val b2807 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2807.suggestName("b2807")
      val x2808_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2808_rd""")
      val x2808_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2808_rd_ofs = List[UInt](b2806.r)
      val x2808_rd_en = List[Bool](true.B)
      val x2808_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2807 & b563 ).suggestName("x2808_rd_shared_en")
      x2808_rd.toSeq.zip(x580_accum_1.connectRPort(2808, x2808_rd_banks, x2808_rd_ofs, io.sigsIn.backpressure, x2808_rd_en.map(_ && x2808_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2809 = VecApply(x2808,0)
      val x2809_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2809_elem_0""")
      x2809_elem_0.r := x2808_rd(0).r
      val x2811_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2811_div""")
      x2811_div.r := (Math.div(b553, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2811_div")).r
      val x3109 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3109""")
      x3109.r := Math.arith_left_shift(x2811_div, 1, Some(0.2), true.B,"x3109").r
      val x3110_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3110_sum""")
      x3110_sum.r := Math.add(x3109,x2811_div,Some(1.0), true.B, Truncate, Wrapping, "x3110_sum").r
      val x3793 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3793_b2806_D21") 
      x3793.r := getRetimed(b2806.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2813_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2813_sum""")
      x2813_sum.r := Math.add(x3110_sum,x3793,Some(1.0), true.B, Truncate, Wrapping, "x2813_sum").r
      val x3794 = Wire(Bool()).suggestName("x3794_b2807_D22") 
      x3794.r := getRetimed(b2807.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3795 = Wire(Bool()).suggestName("x3795_b563_D22") 
      x3795.r := getRetimed(b563.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2814_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2814_rd""")
      val x2814_rd_banks = List[UInt](6L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2814_rd_ofs = List[UInt](x2813_sum.r)
      val x2814_rd_en = List[Bool](true.B)
      val x2814_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3794 & x3795 ).suggestName("x2814_rd_shared_en")
      x2814_rd.toSeq.zip(x473_A_sram_2.connectRPort(2814, x2814_rd_banks, x2814_rd_ofs, io.sigsIn.backpressure, x2814_rd_en.map(_ && x2814_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2815 = VecApply(x2814,0)
      val x2815_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2815_elem_0""")
      x2815_elem_0.r := x2814_rd(0).r
      val x3796 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3796_x2809_elem_0_D22") 
      x3796.r := getRetimed(x2809_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2816_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2816_sum""")
      x2816_sum.r := Math.add(x3796,x2815_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2816_sum").r
      val x3797 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3797_x2813_sum_D3") 
      x3797.r := getRetimed(x2813_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3798 = Wire(Bool()).suggestName("x3798_b563_D25") 
      x3798.r := getRetimed(b563.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3799 = Wire(Bool()).suggestName("x3799_b2807_D25") 
      x3799.r := getRetimed(b2807.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2817_wr_banks = List[UInt](6L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2817_wr_ofs = List[UInt](x3797.r)
      val x2817_wr_en = List[Bool](true.B)
      val x2817_wr_data = List[UInt](x2816_sum.r)
      x544_out_sram_0.connectWPort(2817, x2817_wr_banks, x2817_wr_ofs, x2817_wr_data, x2817_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3799 & x3798))
    }
    val module = Module(new x2818_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2818_inr_Foreach **/
