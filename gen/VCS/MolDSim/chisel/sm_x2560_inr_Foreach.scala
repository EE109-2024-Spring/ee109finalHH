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

/** Hierarchy: x2560 -> x2561 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2560_inr_Foreach **/
class x2560_inr_Foreach_kernel(
  list_b566: List[Bool],
  list_b2500: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x2512_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2560_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2560_inr_Foreach_iiCtr"))
  
  abstract class x2560_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2512_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2512_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b566 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2514_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2514_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2510_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2510_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b2503 = Input(Bool())
      val in_x2513_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2513_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b2500 = Input(new FixedPoint(true, 32, 0))
      val in_x2511_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2511_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b556 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2512_tmp_2 = {io.in_x2512_tmp_2} ; io.in_x2512_tmp_2 := DontCare
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b566 = {io.in_b566} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x2514_tmp_4 = {io.in_x2514_tmp_4} ; io.in_x2514_tmp_4 := DontCare
    def x2510_tmp_0 = {io.in_x2510_tmp_0} ; io.in_x2510_tmp_0 := DontCare
    def b2503 = {io.in_b2503} 
    def x2513_tmp_3 = {io.in_x2513_tmp_3} ; io.in_x2513_tmp_3 := DontCare
    def b2500 = {io.in_b2500} 
    def x2511_tmp_1 = {io.in_x2511_tmp_1} ; io.in_x2511_tmp_1 := DontCare
    def b556 = {io.in_b556} 
  }
  def connectWires0(module: x2560_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x2512_tmp_2.connectLedger(module.io.in_x2512_tmp_2)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b566 <> b566
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x2514_tmp_4.connectLedger(module.io.in_x2514_tmp_4)
    x2510_tmp_0.connectLedger(module.io.in_x2510_tmp_0)
    module.io.in_b2503 <> b2503
    x2513_tmp_3.connectLedger(module.io.in_x2513_tmp_3)
    module.io.in_b2500 <> b2500
    x2511_tmp_1.connectLedger(module.io.in_x2511_tmp_1)
    module.io.in_b556 <> b556
  }
  val b566 = list_b566(0)
  val b2503 = list_b566(1)
  val b2500 = list_b2500(0)
  val b556 = list_b2500(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x2512_tmp_2 = list_x2512_tmp_2(0)
  val x2514_tmp_4 = list_x2512_tmp_2(1)
  val x2510_tmp_0 = list_x2512_tmp_2(2)
  val x2513_tmp_3 = list_x2512_tmp_2(3)
  val x2511_tmp_1 = list_x2512_tmp_2(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2560_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2560_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2560_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2560_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2560_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2560_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2560_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2560_instrctr, cycles_x2560_inr_Foreach.io.count, iters_x2560_inr_Foreach.io.count, 0.U, 0.U)
      val b2540 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2540.suggestName("b2540")
      val b2541 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2541.suggestName("b2541")
      val x2546_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2546_rd""")
      val x2546_rd_banks = List[UInt](0.U,0.U)
      val x2546_rd_ofs = List[UInt](0.U)
      val x2546_rd_en = List[Bool](true.B)
      val x2546_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2546_rd_shared_en")
      x2546_rd.toSeq.zip(x471_A_sram_0.connectRPort(2546, x2546_rd_banks, x2546_rd_ofs, io.sigsIn.backpressure, x2546_rd_en.map(_ && x2546_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2547 = VecApply(x2546,0)
      val x2547_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2547_elem_0""")
      x2547_elem_0.r := x2546_rd(0).r
      val x2552_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2552_rd""")
      val x2552_rd_banks = List[UInt](0.U,0.U)
      val x2552_rd_ofs = List[UInt](0.U)
      val x2552_rd_en = List[Bool](true.B)
      val x2552_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2552_rd_shared_en")
      x2552_rd.toSeq.zip(x472_A_sram_1.connectRPort(2552, x2552_rd_banks, x2552_rd_ofs, io.sigsIn.backpressure, x2552_rd_en.map(_ && x2552_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2553 = VecApply(x2552,0)
      val x2553_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2553_elem_0""")
      x2553_elem_0.r := x2552_rd(0).r
      val x3711 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3711_x2553_elem_0_D20") 
      x3711.r := getRetimed(x2553_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2554_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2554_sub""")
      x2554_sub.r := Math.sub(x2547_elem_0,x3711,Some(1.0), true.B, Truncate, Wrapping, "x2554_sub").r
      val x3712 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3712_b2540_D25") 
      x3712.r := getRetimed(b2540.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3713 = Wire(Bool()).suggestName("x3713_b2541_D25") 
      x3713.r := getRetimed(b2541.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3714 = Wire(Bool()).suggestName("x3714_b566_D25") 
      x3714.r := getRetimed(b566.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3715 = Wire(Bool()).suggestName("x3715_b2503_D25") 
      x3715.r := getRetimed(b2503.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2555_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2555_wr_ofs = List[UInt](x3712.r)
      val x2555_wr_en = List[Bool](true.B)
      val x2555_wr_data = List[UInt](x2554_sub.r)
      x2512_tmp_2.connectWPort(2555, x2555_wr_banks, x2555_wr_ofs, x2555_wr_data, x2555_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3713 & x3715 & x3714))
      val x2556_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2556_wr_ofs = List[UInt](x3712.r)
      val x2556_wr_en = List[Bool](true.B)
      val x2556_wr_data = List[UInt](x2554_sub.r)
      x2514_tmp_4.connectWPort(2556, x2556_wr_banks, x2556_wr_ofs, x2556_wr_data, x2556_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3713 & x3715 & x3714))
      val x2557_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2557_wr_ofs = List[UInt](x3712.r)
      val x2557_wr_en = List[Bool](true.B)
      val x2557_wr_data = List[UInt](x2554_sub.r)
      x2510_tmp_0.connectWPort(2557, x2557_wr_banks, x2557_wr_ofs, x2557_wr_data, x2557_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3713 & x3715 & x3714))
      val x2558_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2558_wr_ofs = List[UInt](x3712.r)
      val x2558_wr_en = List[Bool](true.B)
      val x2558_wr_data = List[UInt](x2554_sub.r)
      x2513_tmp_3.connectWPort(2558, x2558_wr_banks, x2558_wr_ofs, x2558_wr_data, x2558_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3713 & x3715 & x3714))
      val x2559_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2559_wr_ofs = List[UInt](x3712.r)
      val x2559_wr_en = List[Bool](true.B)
      val x2559_wr_data = List[UInt](x2554_sub.r)
      x2511_tmp_1.connectWPort(2559, x2559_wr_banks, x2559_wr_ofs, x2559_wr_data, x2559_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3713 & x3715 & x3714))
    }
    val module = Module(new x2560_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2560_inr_Foreach **/
