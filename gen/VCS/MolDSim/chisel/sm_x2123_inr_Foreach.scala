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

/** Hierarchy: x2123 -> x2145 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2123_inr_Foreach **/
class x2123_inr_Foreach_kernel(
  list_b2086: List[Bool],
  list_b2083: List[FixedPoint],
  list_x2090_tmp_1: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2123_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2123_inr_Foreach_iiCtr"))
  
  abstract class x2123_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x2090_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2090_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2093_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2093_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b2083 = Input(new FixedPoint(true, 32, 0))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b554 = Input(new FixedPoint(true, 32, 0))
      val in_x2089_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2089_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b2086 = Input(Bool())
      val in_x2092_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2092_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b564 = Input(Bool())
      val in_x2091_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2091_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x2090_tmp_1 = {io.in_x2090_tmp_1} ; io.in_x2090_tmp_1 := DontCare
    def x2093_tmp_4 = {io.in_x2093_tmp_4} ; io.in_x2093_tmp_4 := DontCare
    def b2083 = {io.in_b2083} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b554 = {io.in_b554} 
    def x2089_tmp_0 = {io.in_x2089_tmp_0} ; io.in_x2089_tmp_0 := DontCare
    def b2086 = {io.in_b2086} 
    def x2092_tmp_3 = {io.in_x2092_tmp_3} ; io.in_x2092_tmp_3 := DontCare
    def b564 = {io.in_b564} 
    def x2091_tmp_2 = {io.in_x2091_tmp_2} ; io.in_x2091_tmp_2 := DontCare
  }
  def connectWires0(module: x2123_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x2090_tmp_1.connectLedger(module.io.in_x2090_tmp_1)
    x2093_tmp_4.connectLedger(module.io.in_x2093_tmp_4)
    module.io.in_b2083 <> b2083
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b554 <> b554
    x2089_tmp_0.connectLedger(module.io.in_x2089_tmp_0)
    module.io.in_b2086 <> b2086
    x2092_tmp_3.connectLedger(module.io.in_x2092_tmp_3)
    module.io.in_b564 <> b564
    x2091_tmp_2.connectLedger(module.io.in_x2091_tmp_2)
  }
  val b2086 = list_b2086(0)
  val b564 = list_b2086(1)
  val b2083 = list_b2083(0)
  val b554 = list_b2083(1)
  val x2090_tmp_1 = list_x2090_tmp_1(0)
  val x2093_tmp_4 = list_x2090_tmp_1(1)
  val x2089_tmp_0 = list_x2090_tmp_1(2)
  val x2092_tmp_3 = list_x2090_tmp_1(3)
  val x2091_tmp_2 = list_x2090_tmp_1(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2123_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2123_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2123_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2123_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2123_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2123_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2123_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2123_instrctr, cycles_x2123_inr_Foreach.io.count, iters_x2123_inr_Foreach.io.count, 0.U, 0.U)
      val b2103 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2103.suggestName("b2103")
      val b2104 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2104.suggestName("b2104")
      val x2106_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2106_div""")
      x2106_div.r := (Math.div(b554, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x2106_div")).r
      val x3061 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3061""")
      x3061.r := Math.arith_left_shift(x2106_div, 1, Some(0.2), true.B,"x3061").r
      val x3062_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3062_sum""")
      x3062_sum.r := Math.add(x3061,x2106_div,Some(1.0), true.B, Truncate, Wrapping, "x3062_sum").r
      val x3568 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3568_b2103_D21") 
      x3568.r := getRetimed(b2103.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x2108_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2108_sum""")
      x2108_sum.r := Math.add(x3062_sum,x3568,Some(1.0), true.B, Truncate, Wrapping, "x2108_sum").r
      val x3569 = Wire(Bool()).suggestName("x3569_b2104_D22") 
      x3569.r := getRetimed(b2104.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3570 = Wire(Bool()).suggestName("x3570_b2086_D22") 
      x3570.r := getRetimed(b2086.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3571 = Wire(Bool()).suggestName("x3571_b564_D22") 
      x3571.r := getRetimed(b564.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x2109_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2109_rd""")
      val x2109_rd_banks = List[UInt](7L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x2109_rd_ofs = List[UInt](x2108_sum.r)
      val x2109_rd_en = List[Bool](true.B)
      val x2109_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3569 & x3570 & x3571 ).suggestName("x2109_rd_shared_en")
      x2109_rd.toSeq.zip(x471_A_sram_0.connectRPort(2109, x2109_rd_banks, x2109_rd_ofs, io.sigsIn.backpressure, x2109_rd_en.map(_ && x2109_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2110 = VecApply(x2109,0)
      val x2110_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2110_elem_0""")
      x2110_elem_0.r := x2109_rd(0).r
      val x2115_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2115_rd""")
      val x2115_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x2115_rd_ofs = List[UInt](0.U)
      val x2115_rd_en = List[Bool](true.B)
      val x2115_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2115_rd_shared_en")
      x2115_rd.toSeq.zip(x472_A_sram_1.connectRPort(2115, x2115_rd_banks, x2115_rd_ofs, io.sigsIn.backpressure, x2115_rd_en.map(_ && x2115_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2116 = VecApply(x2115,0)
      val x2116_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2116_elem_0""")
      x2116_elem_0.r := x2115_rd(0).r
      val x3576 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3576_x2116_elem_0_D20") 
      x3576.r := getRetimed(x2116_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2117_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2117_sub""")
      x2117_sub.r := Math.sub(x2110_elem_0,x3576,Some(1.0), true.B, Truncate, Wrapping, "x2117_sub").r
      val x3577 = Wire(Bool()).suggestName("x3577_b2104_D25") 
      x3577.r := getRetimed(b2104.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3578 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3578_b2103_D25") 
      x3578.r := getRetimed(b2103.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3579 = Wire(Bool()).suggestName("x3579_b2086_D25") 
      x3579.r := getRetimed(b2086.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3580 = Wire(Bool()).suggestName("x3580_b564_D25") 
      x3580.r := getRetimed(b564.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2118_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2118_wr_ofs = List[UInt](x3578.r)
      val x2118_wr_en = List[Bool](true.B)
      val x2118_wr_data = List[UInt](x2117_sub.r)
      x2090_tmp_1.connectWPort(2118, x2118_wr_banks, x2118_wr_ofs, x2118_wr_data, x2118_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3577 & x3579 & x3580))
      val x2119_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2119_wr_ofs = List[UInt](x3578.r)
      val x2119_wr_en = List[Bool](true.B)
      val x2119_wr_data = List[UInt](x2117_sub.r)
      x2093_tmp_4.connectWPort(2119, x2119_wr_banks, x2119_wr_ofs, x2119_wr_data, x2119_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3577 & x3579 & x3580))
      val x2120_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2120_wr_ofs = List[UInt](x3578.r)
      val x2120_wr_en = List[Bool](true.B)
      val x2120_wr_data = List[UInt](x2117_sub.r)
      x2089_tmp_0.connectWPort(2120, x2120_wr_banks, x2120_wr_ofs, x2120_wr_data, x2120_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3577 & x3579 & x3580))
      val x2121_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2121_wr_ofs = List[UInt](x3578.r)
      val x2121_wr_en = List[Bool](true.B)
      val x2121_wr_data = List[UInt](x2117_sub.r)
      x2092_tmp_3.connectWPort(2121, x2121_wr_banks, x2121_wr_ofs, x2121_wr_data, x2121_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3577 & x3579 & x3580))
      val x2122_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2122_wr_ofs = List[UInt](x3578.r)
      val x2122_wr_en = List[Bool](true.B)
      val x2122_wr_data = List[UInt](x2117_sub.r)
      x2091_tmp_2.connectWPort(2122, x2122_wr_banks, x2122_wr_ofs, x2122_wr_data, x2122_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3577 & x3579 & x3580))
    }
    val module = Module(new x2123_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2123_inr_Foreach **/
