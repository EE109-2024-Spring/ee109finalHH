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

/** Hierarchy: x1536 -> x1550 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1536_inr_UnitPipe **/
class x1536_inr_UnitPipe_kernel(
  list_b1462: List[Bool],
  list_x1522_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1536_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1536_inr_UnitPipe_iiCtr"))
  
  abstract class x1536_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1522_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1522_r_0_p").asInstanceOf[NBufParams] ))
      val in_b1462 = Input(Bool())
      val in_x1465_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1465_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_x1466_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1466_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1467_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1467_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1522_r_0 = {io.in_x1522_r_0} ; io.in_x1522_r_0 := DontCare
    def b1462 = {io.in_b1462} 
    def x1465_tmp_0 = {io.in_x1465_tmp_0} ; io.in_x1465_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def x1466_tmp_1 = {io.in_x1466_tmp_1} ; io.in_x1466_tmp_1 := DontCare
    def x1467_tmp_2 = {io.in_x1467_tmp_2} ; io.in_x1467_tmp_2 := DontCare
  }
  def connectWires0(module: x1536_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1522_r_0.connectLedger(module.io.in_x1522_r_0)
    module.io.in_b1462 <> b1462
    x1465_tmp_0.connectLedger(module.io.in_x1465_tmp_0)
    module.io.in_b561 <> b561
    x1466_tmp_1.connectLedger(module.io.in_x1466_tmp_1)
    x1467_tmp_2.connectLedger(module.io.in_x1467_tmp_2)
  }
  val b1462 = list_b1462(0)
  val b561 = list_b1462(1)
  val x1522_r_0 = list_x1522_r_0(0)
  val x1465_tmp_0 = list_x1522_r_0(1)
  val x1466_tmp_1 = list_x1522_r_0(2)
  val x1467_tmp_2 = list_x1522_r_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1536_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1536_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1536_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1536_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1536_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1536_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1536_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1536_instrctr, cycles_x1536_inr_UnitPipe.io.count, iters_x1536_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1524_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1524_rd""")
      val x1524_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1524_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1524_rd_en = List[Bool](true.B)
      val x1524_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1524_rd_shared_en")
      x1524_rd.toSeq.zip(x1465_tmp_0.connectRPort(1524, x1524_rd_banks, x1524_rd_ofs, io.sigsIn.backpressure, x1524_rd_en.map(_ && x1524_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1525 = VecApply(x1524,0)
      val x1525_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1525_elem_0""")
      x1525_elem_0.r := x1524_rd(0).r
      val x1527_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1527_rd""")
      val x1527_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1527_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1527_rd_en = List[Bool](true.B)
      val x1527_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1527_rd_shared_en")
      x1527_rd.toSeq.zip(x1466_tmp_1.connectRPort(1527, x1527_rd_banks, x1527_rd_ofs, io.sigsIn.backpressure, x1527_rd_en.map(_ && x1527_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1528 = VecApply(x1527,0)
      val x1528_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1528_elem_0""")
      x1528_elem_0.r := x1527_rd(0).r
      val x1529_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1529_mul""")
      x1529_mul.r := (Math.mul(x1528_elem_0, x1528_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1529_mul")).r
      val x3411 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3411_x1525_elem_0_D6") 
      x3411.r := getRetimed(x1525_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3033 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3033""")
      x3033.r := Math.fma(x3411,x3411,x1529_mul,Some(6.0), true.B, "x3033").toFixed(x3033, "cast_x3033").r
      val x1531_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1531_rd""")
      val x1531_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1531_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1531_rd_en = List[Bool](true.B)
      val x1531_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1531_rd_shared_en")
      x1531_rd.toSeq.zip(x1467_tmp_2.connectRPort(1531, x1531_rd_banks, x1531_rd_ofs, io.sigsIn.backpressure, x1531_rd_en.map(_ && x1531_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1532 = VecApply(x1531,0)
      val x1532_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1532_elem_0""")
      x1532_elem_0.r := x1531_rd(0).r
      val x3412 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3412_x1532_elem_0_D12") 
      x3412.r := getRetimed(x1532_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3034 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3034""")
      x3034.r := Math.fma(x3412,x3412,x3033,Some(6.0), true.B, "x3034").toFixed(x3034, "cast_x3034").r
      val x1535_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1535_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1535_wr_en = List[Bool](true.B)
      val x1535_wr_data = List[UInt](x3034.r)
      x1522_r_0.connectWPort(1535, x1535_wr_banks, x1535_wr_ofs, x1535_wr_data, x1535_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1536_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1536_inr_UnitPipe **/
