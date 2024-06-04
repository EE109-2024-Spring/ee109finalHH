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

/** Hierarchy: x2331 -> x2353 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2331_inr_Foreach **/
class x2331_inr_Foreach_kernel(
  list_b565: List[Bool],
  list_b555: List[FixedPoint],
  list_x2301_tmp_4: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2331_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2331_inr_Foreach_iiCtr"))
  
  abstract class x2331_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b555 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b565 = Input(Bool())
      val in_x2301_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2301_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b2291 = Input(new FixedPoint(true, 32, 0))
      val in_x2300_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2300_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2299_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2299_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2298_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2298_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b2294 = Input(Bool())
      val in_x2297_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2297_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b555 = {io.in_b555} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b565 = {io.in_b565} 
    def x2301_tmp_4 = {io.in_x2301_tmp_4} ; io.in_x2301_tmp_4 := DontCare
    def b2291 = {io.in_b2291} 
    def x2300_tmp_3 = {io.in_x2300_tmp_3} ; io.in_x2300_tmp_3 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x2299_tmp_2 = {io.in_x2299_tmp_2} ; io.in_x2299_tmp_2 := DontCare
    def x2298_tmp_1 = {io.in_x2298_tmp_1} ; io.in_x2298_tmp_1 := DontCare
    def b2294 = {io.in_b2294} 
    def x2297_tmp_0 = {io.in_x2297_tmp_0} ; io.in_x2297_tmp_0 := DontCare
  }
  def connectWires0(module: x2331_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b555 <> b555
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b565 <> b565
    x2301_tmp_4.connectLedger(module.io.in_x2301_tmp_4)
    module.io.in_b2291 <> b2291
    x2300_tmp_3.connectLedger(module.io.in_x2300_tmp_3)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x2299_tmp_2.connectLedger(module.io.in_x2299_tmp_2)
    x2298_tmp_1.connectLedger(module.io.in_x2298_tmp_1)
    module.io.in_b2294 <> b2294
    x2297_tmp_0.connectLedger(module.io.in_x2297_tmp_0)
  }
  val b565 = list_b565(0)
  val b2294 = list_b565(1)
  val b555 = list_b555(0)
  val b2291 = list_b555(1)
  val x2301_tmp_4 = list_x2301_tmp_4(0)
  val x2300_tmp_3 = list_x2301_tmp_4(1)
  val x2299_tmp_2 = list_x2301_tmp_4(2)
  val x2298_tmp_1 = list_x2301_tmp_4(3)
  val x2297_tmp_0 = list_x2301_tmp_4(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2331_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2331_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2331_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2331_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2331_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2331_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2331_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2331_instrctr, cycles_x2331_inr_Foreach.io.count, iters_x2331_inr_Foreach.io.count, 0.U, 0.U)
      val b2311 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2311.suggestName("b2311")
      val b2312 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2312.suggestName("b2312")
      val x2314_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2314_div""")
      x2314_div.r := (Math.div(b555, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2314_div")).r
      val x3073 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3073""")
      x3073.r := Math.arith_left_shift(x2314_div, 1, Some(0.2), true.B,"x3073").r
      val x3074_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3074_sum""")
      x3074_sum.r := Math.add(x3073,x2314_div,Some(1.0), true.B, Truncate, Wrapping, "x3074_sum").r
      val x3629 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3629_b2311_D21") 
      x3629.r := getRetimed(b2311.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2316_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2316_sum""")
      x2316_sum.r := Math.add(x3074_sum,x3629,Some(1.0), true.B, Truncate, Wrapping, "x2316_sum").r
      val x3630 = Wire(Bool()).suggestName("x3630_b565_D22") 
      x3630.r := getRetimed(b565.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3631 = Wire(Bool()).suggestName("x3631_b2312_D22") 
      x3631.r := getRetimed(b2312.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3632 = Wire(Bool()).suggestName("x3632_b2294_D22") 
      x3632.r := getRetimed(b2294.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2317_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2317_rd""")
      val x2317_rd_banks = List[UInt](8L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2317_rd_ofs = List[UInt](x2316_sum.r)
      val x2317_rd_en = List[Bool](true.B)
      val x2317_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3631 & x3632 & x3630 ).suggestName("x2317_rd_shared_en")
      x2317_rd.toSeq.zip(x471_A_sram_0.connectRPort(2317, x2317_rd_banks, x2317_rd_ofs, io.sigsIn.backpressure, x2317_rd_en.map(_ && x2317_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2318 = VecApply(x2317,0)
      val x2318_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2318_elem_0""")
      x2318_elem_0.r := x2317_rd(0).r
      val x2323_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2323_rd""")
      val x2323_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x2323_rd_ofs = List[UInt](0.U)
      val x2323_rd_en = List[Bool](true.B)
      val x2323_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2323_rd_shared_en")
      x2323_rd.toSeq.zip(x472_A_sram_1.connectRPort(2323, x2323_rd_banks, x2323_rd_ofs, io.sigsIn.backpressure, x2323_rd_en.map(_ && x2323_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2324 = VecApply(x2323,0)
      val x2324_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2324_elem_0""")
      x2324_elem_0.r := x2323_rd(0).r
      val x3637 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3637_x2324_elem_0_D20") 
      x3637.r := getRetimed(x2324_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2325_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2325_sub""")
      x2325_sub.r := Math.sub(x2318_elem_0,x3637,Some(1.0), true.B, Truncate, Wrapping, "x2325_sub").r
      val x3638 = Wire(Bool()).suggestName("x3638_b565_D25") 
      x3638.r := getRetimed(b565.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3639 = Wire(Bool()).suggestName("x3639_b2312_D25") 
      x3639.r := getRetimed(b2312.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3640 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3640_b2311_D25") 
      x3640.r := getRetimed(b2311.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3641 = Wire(Bool()).suggestName("x3641_b2294_D25") 
      x3641.r := getRetimed(b2294.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2326_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2326_wr_ofs = List[UInt](x3640.r)
      val x2326_wr_en = List[Bool](true.B)
      val x2326_wr_data = List[UInt](x2325_sub.r)
      x2301_tmp_4.connectWPort(2326, x2326_wr_banks, x2326_wr_ofs, x2326_wr_data, x2326_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3639 & x3641 & x3638))
      val x2327_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2327_wr_ofs = List[UInt](x3640.r)
      val x2327_wr_en = List[Bool](true.B)
      val x2327_wr_data = List[UInt](x2325_sub.r)
      x2300_tmp_3.connectWPort(2327, x2327_wr_banks, x2327_wr_ofs, x2327_wr_data, x2327_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3639 & x3641 & x3638))
      val x2328_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2328_wr_ofs = List[UInt](x3640.r)
      val x2328_wr_en = List[Bool](true.B)
      val x2328_wr_data = List[UInt](x2325_sub.r)
      x2299_tmp_2.connectWPort(2328, x2328_wr_banks, x2328_wr_ofs, x2328_wr_data, x2328_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3639 & x3641 & x3638))
      val x2329_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2329_wr_ofs = List[UInt](x3640.r)
      val x2329_wr_en = List[Bool](true.B)
      val x2329_wr_data = List[UInt](x2325_sub.r)
      x2298_tmp_1.connectWPort(2329, x2329_wr_banks, x2329_wr_ofs, x2329_wr_data, x2329_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3639 & x3641 & x3638))
      val x2330_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2330_wr_ofs = List[UInt](x3640.r)
      val x2330_wr_en = List[Bool](true.B)
      val x2330_wr_data = List[UInt](x2325_sub.r)
      x2297_tmp_0.connectWPort(2330, x2330_wr_banks, x2330_wr_ofs, x2330_wr_data, x2330_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3639 & x3641 & x3638))
    }
    val module = Module(new x2331_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2331_inr_Foreach **/
