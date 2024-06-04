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

/** Hierarchy: x1549 -> x1550 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1549_inr_UnitPipe **/
class x1549_inr_UnitPipe_kernel(
  list_b561: List[Bool],
  list_x1470_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1549_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1549_inr_UnitPipe_iiCtr"))
  
  abstract class x1549_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1470_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1470_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_x1471_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1471_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1472_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1472_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1523_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1523_r_0_p").asInstanceOf[NBufParams] ))
      val in_b1463 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1470_tmp_0 = {io.in_x1470_tmp_0} ; io.in_x1470_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def x1471_tmp_1 = {io.in_x1471_tmp_1} ; io.in_x1471_tmp_1 := DontCare
    def x1472_tmp_2 = {io.in_x1472_tmp_2} ; io.in_x1472_tmp_2 := DontCare
    def x1523_r_0 = {io.in_x1523_r_0} ; io.in_x1523_r_0 := DontCare
    def b1463 = {io.in_b1463} 
  }
  def connectWires0(module: x1549_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1470_tmp_0.connectLedger(module.io.in_x1470_tmp_0)
    module.io.in_b561 <> b561
    x1471_tmp_1.connectLedger(module.io.in_x1471_tmp_1)
    x1472_tmp_2.connectLedger(module.io.in_x1472_tmp_2)
    x1523_r_0.connectLedger(module.io.in_x1523_r_0)
    module.io.in_b1463 <> b1463
  }
  val b561 = list_b561(0)
  val b1463 = list_b561(1)
  val x1470_tmp_0 = list_x1470_tmp_0(0)
  val x1471_tmp_1 = list_x1470_tmp_0(1)
  val x1472_tmp_2 = list_x1470_tmp_0(2)
  val x1523_r_0 = list_x1470_tmp_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1549_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1549_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1549_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1549_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1549_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1549_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1549_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1549_instrctr, cycles_x1549_inr_UnitPipe.io.count, iters_x1549_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1537_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1537_rd""")
      val x1537_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1537_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1537_rd_en = List[Bool](true.B)
      val x1537_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1537_rd_shared_en")
      x1537_rd.toSeq.zip(x1470_tmp_0.connectRPort(1537, x1537_rd_banks, x1537_rd_ofs, io.sigsIn.backpressure, x1537_rd_en.map(_ && x1537_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1538 = VecApply(x1537,0)
      val x1538_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1538_elem_0""")
      x1538_elem_0.r := x1537_rd(0).r
      val x1540_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1540_rd""")
      val x1540_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1540_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1540_rd_en = List[Bool](true.B)
      val x1540_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1540_rd_shared_en")
      x1540_rd.toSeq.zip(x1471_tmp_1.connectRPort(1540, x1540_rd_banks, x1540_rd_ofs, io.sigsIn.backpressure, x1540_rd_en.map(_ && x1540_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1541 = VecApply(x1540,0)
      val x1541_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1541_elem_0""")
      x1541_elem_0.r := x1540_rd(0).r
      val x1542_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1542_mul""")
      x1542_mul.r := (Math.mul(x1541_elem_0, x1541_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1542_mul")).r
      val x3413 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3413_x1538_elem_0_D6") 
      x3413.r := getRetimed(x1538_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3035 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3035""")
      x3035.r := Math.fma(x3413,x3413,x1542_mul,Some(6.0), true.B, "x3035").toFixed(x3035, "cast_x3035").r
      val x1544_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1544_rd""")
      val x1544_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1544_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1544_rd_en = List[Bool](true.B)
      val x1544_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1544_rd_shared_en")
      x1544_rd.toSeq.zip(x1472_tmp_2.connectRPort(1544, x1544_rd_banks, x1544_rd_ofs, io.sigsIn.backpressure, x1544_rd_en.map(_ && x1544_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1545 = VecApply(x1544,0)
      val x1545_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1545_elem_0""")
      x1545_elem_0.r := x1544_rd(0).r
      val x3414 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3414_x1545_elem_0_D12") 
      x3414.r := getRetimed(x1545_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3036 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3036""")
      x3036.r := Math.fma(x3414,x3414,x3035,Some(6.0), true.B, "x3036").toFixed(x3036, "cast_x3036").r
      val x1548_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1548_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1548_wr_en = List[Bool](true.B)
      val x1548_wr_data = List[UInt](x3036.r)
      x1523_r_0.connectWPort(1548, x1548_wr_banks, x1548_wr_ofs, x1548_wr_data, x1548_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1549_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1549_inr_UnitPipe **/
