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

/** Hierarchy: x2705 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2705_inr_Foreach **/
class x2705_inr_Foreach_kernel(
  list_b566: List[Bool],
  list_b2499: List[FixedPoint],
  list_x585_accum_0: List[StandardInterface],
  list_x2509_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x2705_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2705_inr_Foreach_iiCtr"))
  
  abstract class x2705_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2499 = Input(new FixedPoint(true, 32, 0))
      val in_b566 = Input(Bool())
      val in_x2509_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2509_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x586_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x586_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x2514_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2514_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b2503 = Input(Bool())
      val in_x585_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x585_accum_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b2499 = {io.in_b2499} 
    def b566 = {io.in_b566} 
    def x2509_tmp_4 = {io.in_x2509_tmp_4} ; io.in_x2509_tmp_4 := DontCare
    def x586_accum_1 = {io.in_x586_accum_1} ; io.in_x586_accum_1 := DontCare
    def x2514_tmp_4 = {io.in_x2514_tmp_4} ; io.in_x2514_tmp_4 := DontCare
    def b2503 = {io.in_b2503} 
    def x585_accum_0 = {io.in_x585_accum_0} ; io.in_x585_accum_0 := DontCare
  }
  def connectWires0(module: x2705_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2499 <> b2499
    module.io.in_b566 <> b566
    x2509_tmp_4.connectLedger(module.io.in_x2509_tmp_4)
    x586_accum_1.connectLedger(module.io.in_x586_accum_1)
    x2514_tmp_4.connectLedger(module.io.in_x2514_tmp_4)
    module.io.in_b2503 <> b2503
    x585_accum_0.connectLedger(module.io.in_x585_accum_0)
  }
  val b566 = list_b566(0)
  val b2503 = list_b566(1)
  val b2499 = list_b2499(0)
  val x585_accum_0 = list_x585_accum_0(0)
  val x2509_tmp_4 = list_x2509_tmp_4(0)
  val x586_accum_1 = list_x2509_tmp_4(1)
  val x2514_tmp_4 = list_x2509_tmp_4(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2705_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2705_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2705_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2705_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2705_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2705_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2705_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2705_instrctr, cycles_x2705_inr_Foreach.io.count, iters_x2705_inr_Foreach.io.count, 0.U, 0.U)
      val b2501 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2501.suggestName("b2501")
      val b2504 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2504.suggestName("b2504")
      val x2686_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2686_rd""")
      val x2686_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2686_rd_ofs = List[UInt](b2501.r)
      val x2686_rd_en = List[Bool](true.B)
      val x2686_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2504 & b566 ).suggestName("x2686_rd_shared_en")
      x2686_rd.toSeq.zip(x2509_tmp_4.connectRPort(2686, x2686_rd_banks, x2686_rd_ofs, io.sigsIn.backpressure, x2686_rd_en.map(_ && x2686_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2687 = VecApply(x2686,0)
      val x2687_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2687_elem_0""")
      x2687_elem_0.r := x2686_rd(0).r
      val x2688_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2688_rd""")
      val x2688_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2688_rd_ofs = List[UInt](b2501.r)
      val x2688_rd_en = List[Bool](true.B)
      val x2688_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2504 & b566 ).suggestName("x2688_rd_shared_en")
      x2688_rd.toSeq.zip(x2514_tmp_4.connectRPort(2688, x2688_rd_banks, x2688_rd_ofs, io.sigsIn.backpressure, x2688_rd_en.map(_ && x2688_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2689 = VecApply(x2688,0)
      val x2689_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2689_elem_0""")
      x2689_elem_0.r := x2688_rd(0).r
      val x3740 = Wire(Bool()).suggestName("x3740_b2504_D1") 
      x3740.r := getRetimed(b2504.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3741 = Wire(Bool()).suggestName("x3741_b566_D1") 
      x3741.r := getRetimed(b566.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3742 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3742_b2501_D1") 
      x3742.r := getRetimed(b2501.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2690_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2690_rd""")
      val x2690_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2690_rd_ofs = List[UInt](x3742.r)
      val x2690_rd_en = List[Bool](true.B)
      val x2690_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3740 & x3741 ).suggestName("x2690_rd_shared_en")
      x2690_rd.toSeq.zip(x585_accum_0.connectRPort(2690, x2690_rd_banks, x2690_rd_ofs, io.sigsIn.backpressure, x2690_rd_en.map(_ && x2690_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2691 = VecApply(x2690,0)
      val x2691_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2691_elem_0""")
      x2691_elem_0.r := x2690_rd(0).r
      val x2692 = Wire(Bool()).suggestName("""x2692""")
      x2692 := b2504 & b566
      val x2694 = Wire(Bool()).suggestName("""x2694""")
      x2694 := b2503 & b566
      val x2696 = Wire(Bool()).suggestName("""x2696""")
      x2696 := x2694 & x2692
      val x2697_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2697_sum""")
      x2697_sum.r := Math.add(x2687_elem_0,x2689_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2697_sum").r
      val x3743 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3743_x2687_elem_0_D1") 
      x3743.r := getRetimed(x2687_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3744 = Wire(Bool()).suggestName("x3744_x2696_D3") 
      x3744.r := getRetimed(x2696.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x2698 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2698""")
      x2698.r := Mux((x3744), x2697_sum.r, x3743.r)
      val x2700 = Wire(Bool()).suggestName("""x2700""")
      x2700.r := Math.eql(b2499, 0L.FP(true, 32, 0), Some(0.2), true.B,"x2700").r
      val x2701_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2701_sum""")
      x2701_sum.r := Math.add(x2698,x2691_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2701_sum").r
      val x3745 = Wire(Bool()).suggestName("x3745_x2700_D4") 
      x3745.r := getRetimed(x2700.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x3746 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3746_x2698_D1") 
      x3746.r := getRetimed(x2698.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2702 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2702""")
      x2702.r := Mux((x3745), x3746.r, x2701_sum.r)
      val x3747 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3747_b2501_D5") 
      x3747.r := getRetimed(b2501.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3748 = Wire(Bool()).suggestName("x3748_b566_D5") 
      x3748.r := getRetimed(b566.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3749 = Wire(Bool()).suggestName("x3749_b2504_D5") 
      x3749.r := getRetimed(b2504.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3750 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3750_x2702_D1") 
      x3750.r := getRetimed(x2702.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2703_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2703_wr_ofs = List[UInt](x3747.r)
      val x2703_wr_en = List[Bool](true.B)
      val x2703_wr_data = List[UInt](x3750.r)
      x585_accum_0.connectWPort(2703, x2703_wr_banks, x2703_wr_ofs, x2703_wr_data, x2703_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3749 & x3748))
      val x2704_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2704_wr_ofs = List[UInt](x3747.r)
      val x2704_wr_en = List[Bool](true.B)
      val x2704_wr_data = List[UInt](x3750.r)
      x586_accum_1.connectWPort(2704, x2704_wr_banks, x2704_wr_ofs, x2704_wr_data, x2704_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3749 & x3748))
      x2509_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x2514_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x2705_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2705_inr_Foreach **/
