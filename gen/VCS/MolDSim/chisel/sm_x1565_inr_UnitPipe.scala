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

/** Hierarchy: x1565 -> x1575 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1565_inr_UnitPipe **/
class x1565_inr_UnitPipe_kernel(
  list_b1462: List[Bool],
  list_x1522_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1565_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1565_inr_UnitPipe_iiCtr"))
  
  abstract class x1565_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1522_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1522_r_0_p").asInstanceOf[NBufParams] ))
      val in_b1462 = Input(Bool())
      val in_b561 = Input(Bool())
      val in_x1555_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1555_reg_p").asInstanceOf[NBufParams] ))
      val in_x1553_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1553_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1522_r_0 = {io.in_x1522_r_0} ; io.in_x1522_r_0 := DontCare
    def b1462 = {io.in_b1462} 
    def b561 = {io.in_b561} 
    def x1555_reg = {io.in_x1555_reg} ; io.in_x1555_reg := DontCare
    def x1553_reg = {io.in_x1553_reg} ; io.in_x1553_reg := DontCare
  }
  def connectWires0(module: x1565_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1522_r_0.connectLedger(module.io.in_x1522_r_0)
    module.io.in_b1462 <> b1462
    module.io.in_b561 <> b561
    x1555_reg.connectLedger(module.io.in_x1555_reg)
    x1553_reg.connectLedger(module.io.in_x1553_reg)
  }
  val b1462 = list_b1462(0)
  val b561 = list_b1462(1)
  val x1522_r_0 = list_x1522_r_0(0)
  val x1555_reg = list_x1522_r_0(1)
  val x1553_reg = list_x1522_r_0(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1565_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1565_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1565_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1565_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1565_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1565_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1565_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1565_instrctr, cycles_x1565_inr_UnitPipe.io.count, iters_x1565_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1557_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1557_rd""")
      val x1557_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1557_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1557_rd_en = List[Bool](true.B)
      val x1557_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1557_rd_shared_en")
      x1557_rd.toSeq.zip(x1522_r_0.connectRPort(1557, x1557_rd_banks, x1557_rd_ofs, io.sigsIn.backpressure, x1557_rd_en.map(_ && x1557_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1558 = VecApply(x1557,0)
      val x1558_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1558_elem_0""")
      x1558_elem_0.r := x1557_rd(0).r
      val x1559 = Wire(Bool()).suggestName("""x1559""")
      x1559.r := Math.lt(0.FP(true, 10, 22), x1558_elem_0, Some(0.4), true.B,"x1559").r
      val x1560 = Wire(Bool()).suggestName("""x1560""")
      x1560.r := Math.lt(1.FP(true, 10, 22), x1558_elem_0, Some(0.4), true.B,"x1560").r
      val x1561 = Wire(Bool()).suggestName("""x1561""")
      x1561 := x1559 & x1560
      val x1562 = Wire(Bool()).suggestName("""x1562""")
      x1562 := ~x1561
      val x1563_wr_x1553_banks = List[UInt]()
      val x1563_wr_x1553_ofs = List[UInt]()
      val x1563_wr_x1553_en = List[Bool](true.B)
      val x1563_wr_x1553_data = List[UInt](x1561.r)
      x1553_reg.connectWPort(1563, x1563_wr_x1553_banks, x1563_wr_x1553_ofs, x1563_wr_x1553_data, x1563_wr_x1553_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1564_wr_x1555_banks = List[UInt]()
      val x1564_wr_x1555_ofs = List[UInt]()
      val x1564_wr_x1555_en = List[Bool](true.B)
      val x1564_wr_x1555_data = List[UInt](x1562.r)
      x1555_reg.connectWPort(1564, x1564_wr_x1555_banks, x1564_wr_x1555_ofs, x1564_wr_x1555_data, x1564_wr_x1555_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1565_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1565_inr_UnitPipe **/
