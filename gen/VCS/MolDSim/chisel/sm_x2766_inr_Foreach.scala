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

/** Hierarchy: x2766 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2766_inr_Foreach **/
class x2766_inr_Foreach_kernel(
  list_b559: List[Bool],
  list_b549: List[FixedPoint],
  list_x473_A_sram_2: List[StandardInterface],
  list_x572_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2766_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2766_inr_Foreach_iiCtr"))
  
  abstract class x2766_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b559 = Input(Bool())
      val in_x572_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x572_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_b549 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b559 = {io.in_b559} 
    def x572_accum_1 = {io.in_x572_accum_1} ; io.in_x572_accum_1 := DontCare
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def b549 = {io.in_b549} 
  }
  def connectWires0(module: x2766_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b559 <> b559
    x572_accum_1.connectLedger(module.io.in_x572_accum_1)
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    module.io.in_b549 <> b549
  }
  val b559 = list_b559(0)
  val b549 = list_b549(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  val x572_accum_1 = list_x572_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2766_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2766_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2766_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2766_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2766_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2766_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2766_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2766_instrctr, cycles_x2766_inr_Foreach.io.count, iters_x2766_inr_Foreach.io.count, 0.U, 0.U)
      val b2754 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2754.suggestName("b2754")
      val b2755 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2755.suggestName("b2755")
      val x2756_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2756_rd""")
      val x2756_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2756_rd_ofs = List[UInt](b2754.r)
      val x2756_rd_en = List[Bool](true.B)
      val x2756_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2755 & b559 ).suggestName("x2756_rd_shared_en")
      x2756_rd.toSeq.zip(x572_accum_1.connectRPort(2756, x2756_rd_banks, x2756_rd_ofs, io.sigsIn.backpressure, x2756_rd_en.map(_ && x2756_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2757 = VecApply(x2756,0)
      val x2757_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2757_elem_0""")
      x2757_elem_0.r := x2756_rd(0).r
      val x2759_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2759_div""")
      x2759_div.r := (Math.div(b549, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2759_div")).r
      val x3101 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3101""")
      x3101.r := Math.arith_left_shift(x2759_div, 1, Some(0.2), true.B,"x3101").r
      val x3102_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3102_sum""")
      x3102_sum.r := Math.add(x3101,x2759_div,Some(1.0), true.B, Truncate, Wrapping, "x3102_sum").r
      val x3765 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3765_b2754_D21") 
      x3765.r := getRetimed(b2754.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2761_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2761_sum""")
      x2761_sum.r := Math.add(x3102_sum,x3765,Some(1.0), true.B, Truncate, Wrapping, "x2761_sum").r
      val x3766 = Wire(Bool()).suggestName("x3766_b559_D22") 
      x3766.r := getRetimed(b559.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3767 = Wire(Bool()).suggestName("x3767_b2755_D22") 
      x3767.r := getRetimed(b2755.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2762_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2762_rd""")
      val x2762_rd_banks = List[UInt](2L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2762_rd_ofs = List[UInt](x2761_sum.r)
      val x2762_rd_en = List[Bool](true.B)
      val x2762_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3767 & x3766 ).suggestName("x2762_rd_shared_en")
      x2762_rd.toSeq.zip(x473_A_sram_2.connectRPort(2762, x2762_rd_banks, x2762_rd_ofs, io.sigsIn.backpressure, x2762_rd_en.map(_ && x2762_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2763 = VecApply(x2762,0)
      val x2763_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2763_elem_0""")
      x2763_elem_0.r := x2762_rd(0).r
      val x3768 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3768_x2757_elem_0_D22") 
      x3768.r := getRetimed(x2757_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2764_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2764_sum""")
      x2764_sum.r := Math.add(x3768,x2763_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2764_sum").r
      val x3769 = Wire(Bool()).suggestName("x3769_b2755_D25") 
      x3769.r := getRetimed(b2755.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3770 = Wire(Bool()).suggestName("x3770_b559_D25") 
      x3770.r := getRetimed(b559.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3771 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3771_x2761_sum_D3") 
      x3771.r := getRetimed(x2761_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x2765_wr_banks = List[UInt](2L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2765_wr_ofs = List[UInt](x3771.r)
      val x2765_wr_en = List[Bool](true.B)
      val x2765_wr_data = List[UInt](x2764_sum.r)
      x544_out_sram_0.connectWPort(2765, x2765_wr_banks, x2765_wr_ofs, x2765_wr_data, x2765_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3769 & x3770))
    }
    val module = Module(new x2766_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2766_inr_Foreach **/
