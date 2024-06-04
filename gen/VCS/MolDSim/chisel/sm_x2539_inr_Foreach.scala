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

/** Hierarchy: x2539 -> x2561 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2539_inr_Foreach **/
class x2539_inr_Foreach_kernel(
  list_b566: List[Bool],
  list_b2499: List[FixedPoint],
  list_x2508_tmp_3: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2539_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2539_inr_Foreach_iiCtr"))
  
  abstract class x2539_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2499 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x2508_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2508_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_x2509_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2509_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2505_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2505_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2506_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2506_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b556 = Input(new FixedPoint(true, 32, 0))
      val in_b2502 = Input(Bool())
      val in_x2507_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2507_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b2499 = {io.in_b2499} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x2508_tmp_3 = {io.in_x2508_tmp_3} ; io.in_x2508_tmp_3 := DontCare
    def b566 = {io.in_b566} 
    def x2509_tmp_4 = {io.in_x2509_tmp_4} ; io.in_x2509_tmp_4 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x2505_tmp_0 = {io.in_x2505_tmp_0} ; io.in_x2505_tmp_0 := DontCare
    def x2506_tmp_1 = {io.in_x2506_tmp_1} ; io.in_x2506_tmp_1 := DontCare
    def b556 = {io.in_b556} 
    def b2502 = {io.in_b2502} 
    def x2507_tmp_2 = {io.in_x2507_tmp_2} ; io.in_x2507_tmp_2 := DontCare
  }
  def connectWires0(module: x2539_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2499 <> b2499
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x2508_tmp_3.connectLedger(module.io.in_x2508_tmp_3)
    module.io.in_b566 <> b566
    x2509_tmp_4.connectLedger(module.io.in_x2509_tmp_4)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x2505_tmp_0.connectLedger(module.io.in_x2505_tmp_0)
    x2506_tmp_1.connectLedger(module.io.in_x2506_tmp_1)
    module.io.in_b556 <> b556
    module.io.in_b2502 <> b2502
    x2507_tmp_2.connectLedger(module.io.in_x2507_tmp_2)
  }
  val b566 = list_b566(0)
  val b2502 = list_b566(1)
  val b2499 = list_b2499(0)
  val b556 = list_b2499(1)
  val x2508_tmp_3 = list_x2508_tmp_3(0)
  val x2509_tmp_4 = list_x2508_tmp_3(1)
  val x2505_tmp_0 = list_x2508_tmp_3(2)
  val x2506_tmp_1 = list_x2508_tmp_3(3)
  val x2507_tmp_2 = list_x2508_tmp_3(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2539_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2539_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2539_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2539_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2539_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2539_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2539_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2539_instrctr, cycles_x2539_inr_Foreach.io.count, iters_x2539_inr_Foreach.io.count, 0.U, 0.U)
      val b2519 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2519.suggestName("b2519")
      val b2520 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2520.suggestName("b2520")
      val x2522_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2522_div""")
      x2522_div.r := (Math.div(b556, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2522_div")).r
      val x3085 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3085""")
      x3085.r := Math.arith_left_shift(x2522_div, 1, Some(0.2), true.B,"x3085").r
      val x3086_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3086_sum""")
      x3086_sum.r := Math.add(x3085,x2522_div,Some(1.0), true.B, Truncate, Wrapping, "x3086_sum").r
      val x3690 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3690_b2519_D21") 
      x3690.r := getRetimed(b2519.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2524_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2524_sum""")
      x2524_sum.r := Math.add(x3086_sum,x3690,Some(1.0), true.B, Truncate, Wrapping, "x2524_sum").r
      val x3691 = Wire(Bool()).suggestName("x3691_b2520_D22") 
      x3691.r := getRetimed(b2520.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3692 = Wire(Bool()).suggestName("x3692_b566_D22") 
      x3692.r := getRetimed(b566.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3693 = Wire(Bool()).suggestName("x3693_b2502_D22") 
      x3693.r := getRetimed(b2502.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2525_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2525_rd""")
      val x2525_rd_banks = List[UInt](9L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2525_rd_ofs = List[UInt](x2524_sum.r)
      val x2525_rd_en = List[Bool](true.B)
      val x2525_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3691 & x3693 & x3692 ).suggestName("x2525_rd_shared_en")
      x2525_rd.toSeq.zip(x471_A_sram_0.connectRPort(2525, x2525_rd_banks, x2525_rd_ofs, io.sigsIn.backpressure, x2525_rd_en.map(_ && x2525_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2526 = VecApply(x2525,0)
      val x2526_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2526_elem_0""")
      x2526_elem_0.r := x2525_rd(0).r
      val x2531_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2531_rd""")
      val x2531_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x2531_rd_ofs = List[UInt](0.U)
      val x2531_rd_en = List[Bool](true.B)
      val x2531_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2531_rd_shared_en")
      x2531_rd.toSeq.zip(x472_A_sram_1.connectRPort(2531, x2531_rd_banks, x2531_rd_ofs, io.sigsIn.backpressure, x2531_rd_en.map(_ && x2531_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2532 = VecApply(x2531,0)
      val x2532_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2532_elem_0""")
      x2532_elem_0.r := x2531_rd(0).r
      val x3698 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3698_x2532_elem_0_D20") 
      x3698.r := getRetimed(x2532_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2533_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2533_sub""")
      x2533_sub.r := Math.sub(x2526_elem_0,x3698,Some(1.0), true.B, Truncate, Wrapping, "x2533_sub").r
      val x3699 = Wire(Bool()).suggestName("x3699_b2520_D25") 
      x3699.r := getRetimed(b2520.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3700 = Wire(Bool()).suggestName("x3700_b566_D25") 
      x3700.r := getRetimed(b566.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3701 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3701_b2519_D25") 
      x3701.r := getRetimed(b2519.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3702 = Wire(Bool()).suggestName("x3702_b2502_D25") 
      x3702.r := getRetimed(b2502.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2534_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2534_wr_ofs = List[UInt](x3701.r)
      val x2534_wr_en = List[Bool](true.B)
      val x2534_wr_data = List[UInt](x2533_sub.r)
      x2508_tmp_3.connectWPort(2534, x2534_wr_banks, x2534_wr_ofs, x2534_wr_data, x2534_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3699 & x3702 & x3700))
      val x2535_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2535_wr_ofs = List[UInt](x3701.r)
      val x2535_wr_en = List[Bool](true.B)
      val x2535_wr_data = List[UInt](x2533_sub.r)
      x2509_tmp_4.connectWPort(2535, x2535_wr_banks, x2535_wr_ofs, x2535_wr_data, x2535_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3699 & x3702 & x3700))
      val x2536_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2536_wr_ofs = List[UInt](x3701.r)
      val x2536_wr_en = List[Bool](true.B)
      val x2536_wr_data = List[UInt](x2533_sub.r)
      x2505_tmp_0.connectWPort(2536, x2536_wr_banks, x2536_wr_ofs, x2536_wr_data, x2536_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3699 & x3702 & x3700))
      val x2537_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2537_wr_ofs = List[UInt](x3701.r)
      val x2537_wr_en = List[Bool](true.B)
      val x2537_wr_data = List[UInt](x2533_sub.r)
      x2506_tmp_1.connectWPort(2537, x2537_wr_banks, x2537_wr_ofs, x2537_wr_data, x2537_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3699 & x3702 & x3700))
      val x2538_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2538_wr_ofs = List[UInt](x3701.r)
      val x2538_wr_en = List[Bool](true.B)
      val x2538_wr_data = List[UInt](x2533_sub.r)
      x2507_tmp_2.connectWPort(2538, x2538_wr_banks, x2538_wr_ofs, x2538_wr_data, x2538_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3699 & x3702 & x3700))
    }
    val module = Module(new x2539_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2539_inr_Foreach **/
