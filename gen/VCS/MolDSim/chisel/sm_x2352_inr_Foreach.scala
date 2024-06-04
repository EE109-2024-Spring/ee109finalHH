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

/** Hierarchy: x2352 -> x2353 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2352_inr_Foreach **/
class x2352_inr_Foreach_kernel(
  list_b2295: List[Bool],
  list_b555: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x2306_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x2352_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2352_inr_Foreach_iiCtr"))
  
  abstract class x2352_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2295 = Input(Bool())
      val in_x2306_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2306_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b555 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b565 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2304_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2304_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b2292 = Input(new FixedPoint(true, 32, 0))
      val in_x2303_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2303_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2305_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2305_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2302_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2302_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b2295 = {io.in_b2295} 
    def x2306_tmp_4 = {io.in_x2306_tmp_4} ; io.in_x2306_tmp_4 := DontCare
    def b555 = {io.in_b555} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b565 = {io.in_b565} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x2304_tmp_2 = {io.in_x2304_tmp_2} ; io.in_x2304_tmp_2 := DontCare
    def b2292 = {io.in_b2292} 
    def x2303_tmp_1 = {io.in_x2303_tmp_1} ; io.in_x2303_tmp_1 := DontCare
    def x2305_tmp_3 = {io.in_x2305_tmp_3} ; io.in_x2305_tmp_3 := DontCare
    def x2302_tmp_0 = {io.in_x2302_tmp_0} ; io.in_x2302_tmp_0 := DontCare
  }
  def connectWires0(module: x2352_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2295 <> b2295
    x2306_tmp_4.connectLedger(module.io.in_x2306_tmp_4)
    module.io.in_b555 <> b555
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b565 <> b565
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x2304_tmp_2.connectLedger(module.io.in_x2304_tmp_2)
    module.io.in_b2292 <> b2292
    x2303_tmp_1.connectLedger(module.io.in_x2303_tmp_1)
    x2305_tmp_3.connectLedger(module.io.in_x2305_tmp_3)
    x2302_tmp_0.connectLedger(module.io.in_x2302_tmp_0)
  }
  val b2295 = list_b2295(0)
  val b565 = list_b2295(1)
  val b555 = list_b555(0)
  val b2292 = list_b555(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x2306_tmp_4 = list_x2306_tmp_4(0)
  val x2304_tmp_2 = list_x2306_tmp_4(1)
  val x2303_tmp_1 = list_x2306_tmp_4(2)
  val x2305_tmp_3 = list_x2306_tmp_4(3)
  val x2302_tmp_0 = list_x2306_tmp_4(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2352_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2352_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2352_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2352_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2352_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2352_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2352_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2352_instrctr, cycles_x2352_inr_Foreach.io.count, iters_x2352_inr_Foreach.io.count, 0.U, 0.U)
      val b2332 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2332.suggestName("b2332")
      val b2333 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2333.suggestName("b2333")
      val x2338_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2338_rd""")
      val x2338_rd_banks = List[UInt](0.U,0.U)
      val x2338_rd_ofs = List[UInt](0.U)
      val x2338_rd_en = List[Bool](true.B)
      val x2338_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2338_rd_shared_en")
      x2338_rd.toSeq.zip(x471_A_sram_0.connectRPort(2338, x2338_rd_banks, x2338_rd_ofs, io.sigsIn.backpressure, x2338_rd_en.map(_ && x2338_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2339 = VecApply(x2338,0)
      val x2339_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2339_elem_0""")
      x2339_elem_0.r := x2338_rd(0).r
      val x2344_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2344_rd""")
      val x2344_rd_banks = List[UInt](0.U,0.U)
      val x2344_rd_ofs = List[UInt](0.U)
      val x2344_rd_en = List[Bool](true.B)
      val x2344_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2344_rd_shared_en")
      x2344_rd.toSeq.zip(x472_A_sram_1.connectRPort(2344, x2344_rd_banks, x2344_rd_ofs, io.sigsIn.backpressure, x2344_rd_en.map(_ && x2344_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x2345 = VecApply(x2344,0)
      val x2345_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2345_elem_0""")
      x2345_elem_0.r := x2344_rd(0).r
      val x3650 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3650_x2345_elem_0_D20") 
      x3650.r := getRetimed(x2345_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2346_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2346_sub""")
      x2346_sub.r := Math.sub(x2339_elem_0,x3650,Some(1.0), true.B, Truncate, Wrapping, "x2346_sub").r
      val x3651 = Wire(Bool()).suggestName("x3651_b2295_D25") 
      x3651.r := getRetimed(b2295.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3652 = Wire(Bool()).suggestName("x3652_b565_D25") 
      x3652.r := getRetimed(b565.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3653 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3653_b2332_D25") 
      x3653.r := getRetimed(b2332.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3654 = Wire(Bool()).suggestName("x3654_b2333_D25") 
      x3654.r := getRetimed(b2333.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x2347_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2347_wr_ofs = List[UInt](x3653.r)
      val x2347_wr_en = List[Bool](true.B)
      val x2347_wr_data = List[UInt](x2346_sub.r)
      x2306_tmp_4.connectWPort(2347, x2347_wr_banks, x2347_wr_ofs, x2347_wr_data, x2347_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3654 & x3651 & x3652))
      val x2348_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2348_wr_ofs = List[UInt](x3653.r)
      val x2348_wr_en = List[Bool](true.B)
      val x2348_wr_data = List[UInt](x2346_sub.r)
      x2304_tmp_2.connectWPort(2348, x2348_wr_banks, x2348_wr_ofs, x2348_wr_data, x2348_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3654 & x3651 & x3652))
      val x2349_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2349_wr_ofs = List[UInt](x3653.r)
      val x2349_wr_en = List[Bool](true.B)
      val x2349_wr_data = List[UInt](x2346_sub.r)
      x2303_tmp_1.connectWPort(2349, x2349_wr_banks, x2349_wr_ofs, x2349_wr_data, x2349_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3654 & x3651 & x3652))
      val x2350_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2350_wr_ofs = List[UInt](x3653.r)
      val x2350_wr_en = List[Bool](true.B)
      val x2350_wr_data = List[UInt](x2346_sub.r)
      x2305_tmp_3.connectWPort(2350, x2350_wr_banks, x2350_wr_ofs, x2350_wr_data, x2350_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3654 & x3651 & x3652))
      val x2351_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2351_wr_ofs = List[UInt](x3653.r)
      val x2351_wr_en = List[Bool](true.B)
      val x2351_wr_data = List[UInt](x2346_sub.r)
      x2302_tmp_0.connectWPort(2351, x2351_wr_banks, x2351_wr_ofs, x2351_wr_data, x2351_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3654 & x3651 & x3652))
    }
    val module = Module(new x2352_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2352_inr_Foreach **/
