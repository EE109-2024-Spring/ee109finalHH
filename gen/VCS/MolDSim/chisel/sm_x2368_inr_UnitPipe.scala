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

/** Hierarchy: x2368 -> x2382 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2368_inr_UnitPipe **/
class x2368_inr_UnitPipe_kernel(
  list_b565: List[Bool],
  list_x2299_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x2368_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2368_inr_UnitPipe_iiCtr"))
  
  abstract class x2368_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b565 = Input(Bool())
      val in_x2299_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2299_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2298_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2298_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2354_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2354_r_0_p").asInstanceOf[NBufParams] ))
      val in_b2294 = Input(Bool())
      val in_x2297_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2297_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b565 = {io.in_b565} 
    def x2299_tmp_2 = {io.in_x2299_tmp_2} ; io.in_x2299_tmp_2 := DontCare
    def x2298_tmp_1 = {io.in_x2298_tmp_1} ; io.in_x2298_tmp_1 := DontCare
    def x2354_r_0 = {io.in_x2354_r_0} ; io.in_x2354_r_0 := DontCare
    def b2294 = {io.in_b2294} 
    def x2297_tmp_0 = {io.in_x2297_tmp_0} ; io.in_x2297_tmp_0 := DontCare
  }
  def connectWires0(module: x2368_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b565 <> b565
    x2299_tmp_2.connectLedger(module.io.in_x2299_tmp_2)
    x2298_tmp_1.connectLedger(module.io.in_x2298_tmp_1)
    x2354_r_0.connectLedger(module.io.in_x2354_r_0)
    module.io.in_b2294 <> b2294
    x2297_tmp_0.connectLedger(module.io.in_x2297_tmp_0)
  }
  val b565 = list_b565(0)
  val b2294 = list_b565(1)
  val x2299_tmp_2 = list_x2299_tmp_2(0)
  val x2298_tmp_1 = list_x2299_tmp_2(1)
  val x2354_r_0 = list_x2299_tmp_2(2)
  val x2297_tmp_0 = list_x2299_tmp_2(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2368_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2368_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2368_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2368_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2368_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2368_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2368_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2368_instrctr, cycles_x2368_inr_UnitPipe.io.count, iters_x2368_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2356_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2356_rd""")
      val x2356_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2356_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2356_rd_en = List[Bool](true.B)
      val x2356_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2356_rd_shared_en")
      x2356_rd.toSeq.zip(x2297_tmp_0.connectRPort(2356, x2356_rd_banks, x2356_rd_ofs, io.sigsIn.backpressure, x2356_rd_en.map(_ && x2356_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2357 = VecApply(x2356,0)
      val x2357_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2357_elem_0""")
      x2357_elem_0.r := x2356_rd(0).r
      val x2359_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2359_rd""")
      val x2359_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2359_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x2359_rd_en = List[Bool](true.B)
      val x2359_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2359_rd_shared_en")
      x2359_rd.toSeq.zip(x2298_tmp_1.connectRPort(2359, x2359_rd_banks, x2359_rd_ofs, io.sigsIn.backpressure, x2359_rd_en.map(_ && x2359_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2360 = VecApply(x2359,0)
      val x2360_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2360_elem_0""")
      x2360_elem_0.r := x2359_rd(0).r
      val x2361_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2361_mul""")
      x2361_mul.r := (Math.mul(x2360_elem_0, x2360_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x2361_mul")).r
      val x3655 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3655_x2357_elem_0_D6") 
      x3655.r := getRetimed(x2357_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3081 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3081""")
      x3081.r := Math.fma(x3655,x3655,x2361_mul,Some(6.0), true.B, "x3081").toFixed(x3081, "cast_x3081").r
      val x2363_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2363_rd""")
      val x2363_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2363_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x2363_rd_en = List[Bool](true.B)
      val x2363_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2363_rd_shared_en")
      x2363_rd.toSeq.zip(x2299_tmp_2.connectRPort(2363, x2363_rd_banks, x2363_rd_ofs, io.sigsIn.backpressure, x2363_rd_en.map(_ && x2363_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2364 = VecApply(x2363,0)
      val x2364_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2364_elem_0""")
      x2364_elem_0.r := x2363_rd(0).r
      val x3656 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3656_x2364_elem_0_D12") 
      x3656.r := getRetimed(x2364_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3082 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3082""")
      x3082.r := Math.fma(x3656,x3656,x3081,Some(6.0), true.B, "x3082").toFixed(x3082, "cast_x3082").r
      val x2367_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2367_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2367_wr_en = List[Bool](true.B)
      val x2367_wr_data = List[UInt](x3082.r)
      x2354_r_0.connectWPort(2367, x2367_wr_banks, x2367_wr_ofs, x2367_wr_data, x2367_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2368_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2368_inr_UnitPipe **/
