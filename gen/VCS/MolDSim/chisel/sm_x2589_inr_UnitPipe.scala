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

/** Hierarchy: x2589 -> x2590 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2589_inr_UnitPipe **/
class x2589_inr_UnitPipe_kernel(
  list_b566: List[Bool],
  list_x2512_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x2589_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2589_inr_UnitPipe_iiCtr"))
  
  abstract class x2589_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2512_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2512_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_x2510_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2510_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b2503 = Input(Bool())
      val in_x2511_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2511_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2563_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2563_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2512_tmp_2 = {io.in_x2512_tmp_2} ; io.in_x2512_tmp_2 := DontCare
    def b566 = {io.in_b566} 
    def x2510_tmp_0 = {io.in_x2510_tmp_0} ; io.in_x2510_tmp_0 := DontCare
    def b2503 = {io.in_b2503} 
    def x2511_tmp_1 = {io.in_x2511_tmp_1} ; io.in_x2511_tmp_1 := DontCare
    def x2563_r_0 = {io.in_x2563_r_0} ; io.in_x2563_r_0 := DontCare
  }
  def connectWires0(module: x2589_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2512_tmp_2.connectLedger(module.io.in_x2512_tmp_2)
    module.io.in_b566 <> b566
    x2510_tmp_0.connectLedger(module.io.in_x2510_tmp_0)
    module.io.in_b2503 <> b2503
    x2511_tmp_1.connectLedger(module.io.in_x2511_tmp_1)
    x2563_r_0.connectLedger(module.io.in_x2563_r_0)
  }
  val b566 = list_b566(0)
  val b2503 = list_b566(1)
  val x2512_tmp_2 = list_x2512_tmp_2(0)
  val x2510_tmp_0 = list_x2512_tmp_2(1)
  val x2511_tmp_1 = list_x2512_tmp_2(2)
  val x2563_r_0 = list_x2512_tmp_2(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2589_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2589_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2589_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2589_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2589_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2589_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2589_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2589_instrctr, cycles_x2589_inr_UnitPipe.io.count, iters_x2589_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2577_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2577_rd""")
      val x2577_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2577_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2577_rd_en = List[Bool](true.B)
      val x2577_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2577_rd_shared_en")
      x2577_rd.toSeq.zip(x2510_tmp_0.connectRPort(2577, x2577_rd_banks, x2577_rd_ofs, io.sigsIn.backpressure, x2577_rd_en.map(_ && x2577_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2578 = VecApply(x2577,0)
      val x2578_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2578_elem_0""")
      x2578_elem_0.r := x2577_rd(0).r
      val x2580_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2580_rd""")
      val x2580_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2580_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x2580_rd_en = List[Bool](true.B)
      val x2580_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2580_rd_shared_en")
      x2580_rd.toSeq.zip(x2511_tmp_1.connectRPort(2580, x2580_rd_banks, x2580_rd_ofs, io.sigsIn.backpressure, x2580_rd_en.map(_ && x2580_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2581 = VecApply(x2580,0)
      val x2581_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2581_elem_0""")
      x2581_elem_0.r := x2580_rd(0).r
      val x2582_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2582_mul""")
      x2582_mul.r := (Math.mul(x2581_elem_0, x2581_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x2582_mul")).r
      val x3718 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3718_x2578_elem_0_D6") 
      x3718.r := getRetimed(x2578_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3095 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3095""")
      x3095.r := Math.fma(x3718,x3718,x2582_mul,Some(6.0), true.B, "x3095").toFixed(x3095, "cast_x3095").r
      val x2584_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2584_rd""")
      val x2584_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2584_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x2584_rd_en = List[Bool](true.B)
      val x2584_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2584_rd_shared_en")
      x2584_rd.toSeq.zip(x2512_tmp_2.connectRPort(2584, x2584_rd_banks, x2584_rd_ofs, io.sigsIn.backpressure, x2584_rd_en.map(_ && x2584_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2585 = VecApply(x2584,0)
      val x2585_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2585_elem_0""")
      x2585_elem_0.r := x2584_rd(0).r
      val x3719 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3719_x2585_elem_0_D12") 
      x3719.r := getRetimed(x2585_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3096 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3096""")
      x3096.r := Math.fma(x3719,x3719,x3095,Some(6.0), true.B, "x3096").toFixed(x3096, "cast_x3096").r
      val x2588_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2588_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2588_wr_en = List[Bool](true.B)
      val x2588_wr_data = List[UInt](x3096.r)
      x2563_r_0.connectWPort(2588, x2588_wr_banks, x2588_wr_ofs, x2588_wr_data, x2588_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2589_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2589_inr_UnitPipe **/
