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

/** Hierarchy: x2779 -> x2858 -> x2859 -> x444 **/
/** BEGIN None x2779_inr_Foreach **/
class x2779_inr_Foreach_kernel(
  list_b560: List[Bool],
  list_b550: List[FixedPoint],
  list_x473_A_sram_2: List[StandardInterface],
  list_x574_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2779_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2779_inr_Foreach_iiCtr"))
  
  abstract class x2779_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x574_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x574_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b550 = {io.in_b550} 
    def x574_accum_1 = {io.in_x574_accum_1} ; io.in_x574_accum_1 := DontCare
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x2779_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b550 <> b550
    x574_accum_1.connectLedger(module.io.in_x574_accum_1)
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    module.io.in_b560 <> b560
  }
  val b560 = list_b560(0)
  val b550 = list_b550(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  val x574_accum_1 = list_x574_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2779_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2779_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2779_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2779_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2779_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2779_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2779_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2779_instrctr, cycles_x2779_inr_Foreach.io.count, iters_x2779_inr_Foreach.io.count, 0.U, 0.U)
      val b2767 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2767.suggestName("b2767")
      val b2768 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2768.suggestName("b2768")
      val x2769_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2769_rd""")
      val x2769_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2769_rd_ofs = List[UInt](b2767.r)
      val x2769_rd_en = List[Bool](true.B)
      val x2769_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2768 & b560 ).suggestName("x2769_rd_shared_en")
      x2769_rd.toSeq.zip(x574_accum_1.connectRPort(2769, x2769_rd_banks, x2769_rd_ofs, io.sigsIn.backpressure, x2769_rd_en.map(_ && x2769_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2770 = VecApply(x2769,0)
      val x2770_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2770_elem_0""")
      x2770_elem_0.r := x2769_rd(0).r
      val x2772_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2772_div""")
      x2772_div.r := (Math.div(b550, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2772_div")).r
      val x3103 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3103""")
      x3103.r := Math.arith_left_shift(x2772_div, 1, Some(0.2), true.B,"x3103").r
      val x3104_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3104_sum""")
      x3104_sum.r := Math.add(x3103,x2772_div,Some(1.0), true.B, Truncate, Wrapping, "x3104_sum").r
      val x3772 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3772_b2767_D21") 
      x3772.r := getRetimed(b2767.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2774_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2774_sum""")
      x2774_sum.r := Math.add(x3104_sum,x3772,Some(1.0), true.B, Truncate, Wrapping, "x2774_sum").r
      val x3773 = Wire(Bool()).suggestName("x3773_b560_D22") 
      x3773.r := getRetimed(b560.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3774 = Wire(Bool()).suggestName("x3774_b2768_D22") 
      x3774.r := getRetimed(b2768.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2775_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2775_rd""")
      val x2775_rd_banks = List[UInt](3L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2775_rd_ofs = List[UInt](x2774_sum.r)
      val x2775_rd_en = List[Bool](true.B)
      val x2775_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3774 & x3773 ).suggestName("x2775_rd_shared_en")
      x2775_rd.toSeq.zip(x473_A_sram_2.connectRPort(2775, x2775_rd_banks, x2775_rd_ofs, io.sigsIn.backpressure, x2775_rd_en.map(_ && x2775_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2776 = VecApply(x2775,0)
      val x2776_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2776_elem_0""")
      x2776_elem_0.r := x2775_rd(0).r
      val x3775 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3775_x2770_elem_0_D22") 
      x3775.r := getRetimed(x2770_elem_0.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2777_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2777_sum""")
      x2777_sum.r := Math.add(x3775,x2776_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2777_sum").r
      val x3776 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3776_x2774_sum_D3") 
      x3776.r := getRetimed(x2774_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3777 = Wire(Bool()).suggestName("x3777_b2768_D25") 
      x3777.r := getRetimed(b2768.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3778 = Wire(Bool()).suggestName("x3778_b560_D25") 
      x3778.r := getRetimed(b560.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2778_wr_banks = List[UInt](3L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2778_wr_ofs = List[UInt](x3776.r)
      val x2778_wr_en = List[Bool](true.B)
      val x2778_wr_data = List[UInt](x2777_sum.r)
      x544_out_sram_0.connectWPort(2778, x2778_wr_banks, x2778_wr_ofs, x2778_wr_data, x2778_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3777 & x3778))
    }
    val module = Module(new x2779_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2779_inr_Foreach **/
