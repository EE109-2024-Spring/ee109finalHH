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

/** Hierarchy: x704 -> x718 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x704_inr_UnitPipe **/
class x704_inr_UnitPipe_kernel(
  list_b630: List[Bool],
  list_x634_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x704_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x704_inr_UnitPipe_iiCtr"))
  
  abstract class x704_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x634_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x634_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b630 = Input(Bool())
      val in_x633_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x633_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b557 = Input(Bool())
      val in_x690_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x690_r_0_p").asInstanceOf[NBufParams] ))
      val in_x635_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x635_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x634_tmp_1 = {io.in_x634_tmp_1} ; io.in_x634_tmp_1 := DontCare
    def b630 = {io.in_b630} 
    def x633_tmp_0 = {io.in_x633_tmp_0} ; io.in_x633_tmp_0 := DontCare
    def b557 = {io.in_b557} 
    def x690_r_0 = {io.in_x690_r_0} ; io.in_x690_r_0 := DontCare
    def x635_tmp_2 = {io.in_x635_tmp_2} ; io.in_x635_tmp_2 := DontCare
  }
  def connectWires0(module: x704_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x634_tmp_1.connectLedger(module.io.in_x634_tmp_1)
    module.io.in_b630 <> b630
    x633_tmp_0.connectLedger(module.io.in_x633_tmp_0)
    module.io.in_b557 <> b557
    x690_r_0.connectLedger(module.io.in_x690_r_0)
    x635_tmp_2.connectLedger(module.io.in_x635_tmp_2)
  }
  val b630 = list_b630(0)
  val b557 = list_b630(1)
  val x634_tmp_1 = list_x634_tmp_1(0)
  val x633_tmp_0 = list_x634_tmp_1(1)
  val x690_r_0 = list_x634_tmp_1(2)
  val x635_tmp_2 = list_x634_tmp_1(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x704_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x704_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x704_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x704_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x704_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x704_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x704_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X704_instrctr, cycles_x704_inr_UnitPipe.io.count, iters_x704_inr_UnitPipe.io.count, 0.U, 0.U)
      val x692_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x692_rd""")
      val x692_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x692_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x692_rd_en = List[Bool](true.B)
      val x692_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x692_rd_shared_en")
      x692_rd.toSeq.zip(x633_tmp_0.connectRPort(692, x692_rd_banks, x692_rd_ofs, io.sigsIn.backpressure, x692_rd_en.map(_ && x692_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x693 = VecApply(x692,0)
      val x693_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x693_elem_0""")
      x693_elem_0.r := x692_rd(0).r
      val x695_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x695_rd""")
      val x695_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x695_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x695_rd_en = List[Bool](true.B)
      val x695_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x695_rd_shared_en")
      x695_rd.toSeq.zip(x634_tmp_1.connectRPort(695, x695_rd_banks, x695_rd_ofs, io.sigsIn.backpressure, x695_rd_en.map(_ && x695_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x696 = VecApply(x695,0)
      val x696_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x696_elem_0""")
      x696_elem_0.r := x695_rd(0).r
      val x697_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x697_mul""")
      x697_mul.r := (Math.mul(x696_elem_0, x696_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x697_mul")).r
      val x3167 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3167_x693_elem_0_D6") 
      x3167.r := getRetimed(x693_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2985 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2985""")
      x2985.r := Math.fma(x3167,x3167,x697_mul,Some(6.0), true.B, "x2985").toFixed(x2985, "cast_x2985").r
      val x699_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x699_rd""")
      val x699_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x699_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x699_rd_en = List[Bool](true.B)
      val x699_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x699_rd_shared_en")
      x699_rd.toSeq.zip(x635_tmp_2.connectRPort(699, x699_rd_banks, x699_rd_ofs, io.sigsIn.backpressure, x699_rd_en.map(_ && x699_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x700 = VecApply(x699,0)
      val x700_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x700_elem_0""")
      x700_elem_0.r := x699_rd(0).r
      val x3168 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3168_x700_elem_0_D12") 
      x3168.r := getRetimed(x700_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x2986 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2986""")
      x2986.r := Math.fma(x3168,x3168,x2985,Some(6.0), true.B, "x2986").toFixed(x2986, "cast_x2986").r
      val x703_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x703_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x703_wr_en = List[Bool](true.B)
      val x703_wr_data = List[UInt](x2986.r)
      x690_r_0.connectWPort(703, x703_wr_banks, x703_wr_ofs, x703_wr_data, x703_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x704_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x704_inr_UnitPipe **/
