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

/** Hierarchy: x912 -> x926 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x912_inr_UnitPipe **/
class x912_inr_UnitPipe_kernel(
  list_b838: List[Bool],
  list_x898_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x912_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x912_inr_UnitPipe_iiCtr"))
  
  abstract class x912_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x898_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x898_r_0_p").asInstanceOf[NBufParams] ))
      val in_x841_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x841_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b838 = Input(Bool())
      val in_x842_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x842_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b558 = Input(Bool())
      val in_x843_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x843_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x898_r_0 = {io.in_x898_r_0} ; io.in_x898_r_0 := DontCare
    def x841_tmp_0 = {io.in_x841_tmp_0} ; io.in_x841_tmp_0 := DontCare
    def b838 = {io.in_b838} 
    def x842_tmp_1 = {io.in_x842_tmp_1} ; io.in_x842_tmp_1 := DontCare
    def b558 = {io.in_b558} 
    def x843_tmp_2 = {io.in_x843_tmp_2} ; io.in_x843_tmp_2 := DontCare
  }
  def connectWires0(module: x912_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x898_r_0.connectLedger(module.io.in_x898_r_0)
    x841_tmp_0.connectLedger(module.io.in_x841_tmp_0)
    module.io.in_b838 <> b838
    x842_tmp_1.connectLedger(module.io.in_x842_tmp_1)
    module.io.in_b558 <> b558
    x843_tmp_2.connectLedger(module.io.in_x843_tmp_2)
  }
  val b838 = list_b838(0)
  val b558 = list_b838(1)
  val x898_r_0 = list_x898_r_0(0)
  val x841_tmp_0 = list_x898_r_0(1)
  val x842_tmp_1 = list_x898_r_0(2)
  val x843_tmp_2 = list_x898_r_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x912_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x912_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x912_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x912_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x912_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x912_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x912_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X912_instrctr, cycles_x912_inr_UnitPipe.io.count, iters_x912_inr_UnitPipe.io.count, 0.U, 0.U)
      val x900_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x900_rd""")
      val x900_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x900_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x900_rd_en = List[Bool](true.B)
      val x900_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x900_rd_shared_en")
      x900_rd.toSeq.zip(x841_tmp_0.connectRPort(900, x900_rd_banks, x900_rd_ofs, io.sigsIn.backpressure, x900_rd_en.map(_ && x900_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x901 = VecApply(x900,0)
      val x901_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x901_elem_0""")
      x901_elem_0.r := x900_rd(0).r
      val x903_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x903_rd""")
      val x903_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x903_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x903_rd_en = List[Bool](true.B)
      val x903_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x903_rd_shared_en")
      x903_rd.toSeq.zip(x842_tmp_1.connectRPort(903, x903_rd_banks, x903_rd_ofs, io.sigsIn.backpressure, x903_rd_en.map(_ && x903_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x904 = VecApply(x903,0)
      val x904_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x904_elem_0""")
      x904_elem_0.r := x903_rd(0).r
      val x905_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x905_mul""")
      x905_mul.r := (Math.mul(x904_elem_0, x904_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x905_mul")).r
      val x3228 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3228_x901_elem_0_D6") 
      x3228.r := getRetimed(x901_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2997 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2997""")
      x2997.r := Math.fma(x3228,x3228,x905_mul,Some(6.0), true.B, "x2997").toFixed(x2997, "cast_x2997").r
      val x907_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x907_rd""")
      val x907_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x907_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x907_rd_en = List[Bool](true.B)
      val x907_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x907_rd_shared_en")
      x907_rd.toSeq.zip(x843_tmp_2.connectRPort(907, x907_rd_banks, x907_rd_ofs, io.sigsIn.backpressure, x907_rd_en.map(_ && x907_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x908 = VecApply(x907,0)
      val x908_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x908_elem_0""")
      x908_elem_0.r := x907_rd(0).r
      val x3229 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3229_x908_elem_0_D12") 
      x3229.r := getRetimed(x908_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x2998 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2998""")
      x2998.r := Math.fma(x3229,x3229,x2997,Some(6.0), true.B, "x2998").toFixed(x2998, "cast_x2998").r
      val x911_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x911_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x911_wr_en = List[Bool](true.B)
      val x911_wr_data = List[UInt](x2998.r)
      x898_r_0.connectWPort(911, x911_wr_banks, x911_wr_ofs, x911_wr_data, x911_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x912_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x912_inr_UnitPipe **/
