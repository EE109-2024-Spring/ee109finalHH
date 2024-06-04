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

/** Hierarchy: x2497 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2497_inr_Foreach **/
class x2497_inr_Foreach_kernel(
  list_b2295: List[Bool],
  list_b2291: List[FixedPoint],
  list_x583_accum_0: List[StandardInterface],
  list_x2306_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x2497_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2497_inr_Foreach_iiCtr"))
  
  abstract class x2497_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2295 = Input(Bool())
      val in_x2306_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2306_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b565 = Input(Bool())
      val in_x2301_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2301_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b2291 = Input(new FixedPoint(true, 32, 0))
      val in_x583_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x583_accum_0_p").asInstanceOf[MemParams] ))
      val in_x584_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x584_accum_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b2295 = {io.in_b2295} 
    def x2306_tmp_4 = {io.in_x2306_tmp_4} ; io.in_x2306_tmp_4 := DontCare
    def b565 = {io.in_b565} 
    def x2301_tmp_4 = {io.in_x2301_tmp_4} ; io.in_x2301_tmp_4 := DontCare
    def b2291 = {io.in_b2291} 
    def x583_accum_0 = {io.in_x583_accum_0} ; io.in_x583_accum_0 := DontCare
    def x584_accum_1 = {io.in_x584_accum_1} ; io.in_x584_accum_1 := DontCare
  }
  def connectWires0(module: x2497_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2295 <> b2295
    x2306_tmp_4.connectLedger(module.io.in_x2306_tmp_4)
    module.io.in_b565 <> b565
    x2301_tmp_4.connectLedger(module.io.in_x2301_tmp_4)
    module.io.in_b2291 <> b2291
    x583_accum_0.connectLedger(module.io.in_x583_accum_0)
    x584_accum_1.connectLedger(module.io.in_x584_accum_1)
  }
  val b2295 = list_b2295(0)
  val b565 = list_b2295(1)
  val b2291 = list_b2291(0)
  val x583_accum_0 = list_x583_accum_0(0)
  val x2306_tmp_4 = list_x2306_tmp_4(0)
  val x2301_tmp_4 = list_x2306_tmp_4(1)
  val x584_accum_1 = list_x2306_tmp_4(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2497_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2497_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2497_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2497_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2497_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2497_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2497_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2497_instrctr, cycles_x2497_inr_Foreach.io.count, iters_x2497_inr_Foreach.io.count, 0.U, 0.U)
      val b2293 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2293.suggestName("b2293")
      val b2296 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2296.suggestName("b2296")
      val x2478_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2478_rd""")
      val x2478_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2478_rd_ofs = List[UInt](b2293.r)
      val x2478_rd_en = List[Bool](true.B)
      val x2478_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2296 & b565 ).suggestName("x2478_rd_shared_en")
      x2478_rd.toSeq.zip(x2301_tmp_4.connectRPort(2478, x2478_rd_banks, x2478_rd_ofs, io.sigsIn.backpressure, x2478_rd_en.map(_ && x2478_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2479 = VecApply(x2478,0)
      val x2479_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2479_elem_0""")
      x2479_elem_0.r := x2478_rd(0).r
      val x2480_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2480_rd""")
      val x2480_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2480_rd_ofs = List[UInt](b2293.r)
      val x2480_rd_en = List[Bool](true.B)
      val x2480_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2296 & b565 ).suggestName("x2480_rd_shared_en")
      x2480_rd.toSeq.zip(x2306_tmp_4.connectRPort(2480, x2480_rd_banks, x2480_rd_ofs, io.sigsIn.backpressure, x2480_rd_en.map(_ && x2480_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2481 = VecApply(x2480,0)
      val x2481_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2481_elem_0""")
      x2481_elem_0.r := x2480_rd(0).r
      val x3679 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3679_b2293_D1") 
      x3679.r := getRetimed(b2293.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3680 = Wire(Bool()).suggestName("x3680_b2296_D1") 
      x3680.r := getRetimed(b2296.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3681 = Wire(Bool()).suggestName("x3681_b565_D1") 
      x3681.r := getRetimed(b565.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2482_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2482_rd""")
      val x2482_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2482_rd_ofs = List[UInt](x3679.r)
      val x2482_rd_en = List[Bool](true.B)
      val x2482_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3680 & x3681 ).suggestName("x2482_rd_shared_en")
      x2482_rd.toSeq.zip(x583_accum_0.connectRPort(2482, x2482_rd_banks, x2482_rd_ofs, io.sigsIn.backpressure, x2482_rd_en.map(_ && x2482_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2483 = VecApply(x2482,0)
      val x2483_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2483_elem_0""")
      x2483_elem_0.r := x2482_rd(0).r
      val x2484 = Wire(Bool()).suggestName("""x2484""")
      x2484 := b2296 & b565
      val x2486 = Wire(Bool()).suggestName("""x2486""")
      x2486 := b2295 & b565
      val x2488 = Wire(Bool()).suggestName("""x2488""")
      x2488 := x2486 & x2484
      val x2489_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2489_sum""")
      x2489_sum.r := Math.add(x2479_elem_0,x2481_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2489_sum").r
      val x3682 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3682_x2479_elem_0_D1") 
      x3682.r := getRetimed(x2479_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3683 = Wire(Bool()).suggestName("x3683_x2488_D3") 
      x3683.r := getRetimed(x2488.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x2490 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2490""")
      x2490.r := Mux((x3683), x2489_sum.r, x3682.r)
      val x2492 = Wire(Bool()).suggestName("""x2492""")
      x2492.r := Math.eql(b2291, 0L.FP(true, 32, 0), Some(0.2), true.B,"x2492").r
      val x2493_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2493_sum""")
      x2493_sum.r := Math.add(x2490,x2483_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2493_sum").r
      val x3684 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3684_x2490_D1") 
      x3684.r := getRetimed(x2490.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3685 = Wire(Bool()).suggestName("x3685_x2492_D4") 
      x3685.r := getRetimed(x2492.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x2494 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2494""")
      x2494.r := Mux((x3685), x3684.r, x2493_sum.r)
      val x3686 = Wire(Bool()).suggestName("x3686_b565_D5") 
      x3686.r := getRetimed(b565.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3687 = Wire(Bool()).suggestName("x3687_b2296_D5") 
      x3687.r := getRetimed(b2296.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3688 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3688_b2293_D5") 
      x3688.r := getRetimed(b2293.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3689 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3689_x2494_D1") 
      x3689.r := getRetimed(x2494.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2495_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2495_wr_ofs = List[UInt](x3688.r)
      val x2495_wr_en = List[Bool](true.B)
      val x2495_wr_data = List[UInt](x3689.r)
      x584_accum_1.connectWPort(2495, x2495_wr_banks, x2495_wr_ofs, x2495_wr_data, x2495_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3687 & x3686))
      val x2496_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2496_wr_ofs = List[UInt](x3688.r)
      val x2496_wr_en = List[Bool](true.B)
      val x2496_wr_data = List[UInt](x3689.r)
      x583_accum_0.connectWPort(2496, x2496_wr_banks, x2496_wr_ofs, x2496_wr_data, x2496_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3687 & x3686))
      x2301_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x2306_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x2497_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2497_inr_Foreach **/
