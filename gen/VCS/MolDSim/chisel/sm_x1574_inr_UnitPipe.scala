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

/** Hierarchy: x1574 -> x1575 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1574_inr_UnitPipe **/
class x1574_inr_UnitPipe_kernel(
  list_b561: List[Bool],
  list_x1554_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1574_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1574_inr_UnitPipe_iiCtr"))
  
  abstract class x1574_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1554_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1554_reg_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_x1556_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1556_reg_p").asInstanceOf[NBufParams] ))
      val in_x1523_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1523_r_0_p").asInstanceOf[NBufParams] ))
      val in_b1463 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1554_reg = {io.in_x1554_reg} ; io.in_x1554_reg := DontCare
    def b561 = {io.in_b561} 
    def x1556_reg = {io.in_x1556_reg} ; io.in_x1556_reg := DontCare
    def x1523_r_0 = {io.in_x1523_r_0} ; io.in_x1523_r_0 := DontCare
    def b1463 = {io.in_b1463} 
  }
  def connectWires0(module: x1574_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1554_reg.connectLedger(module.io.in_x1554_reg)
    module.io.in_b561 <> b561
    x1556_reg.connectLedger(module.io.in_x1556_reg)
    x1523_r_0.connectLedger(module.io.in_x1523_r_0)
    module.io.in_b1463 <> b1463
  }
  val b561 = list_b561(0)
  val b1463 = list_b561(1)
  val x1554_reg = list_x1554_reg(0)
  val x1556_reg = list_x1554_reg(1)
  val x1523_r_0 = list_x1554_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1574_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1574_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1574_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1574_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1574_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1574_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1574_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1574_instrctr, cycles_x1574_inr_UnitPipe.io.count, iters_x1574_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1566_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1566_rd""")
      val x1566_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1566_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1566_rd_en = List[Bool](true.B)
      val x1566_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1566_rd_shared_en")
      x1566_rd.toSeq.zip(x1523_r_0.connectRPort(1566, x1566_rd_banks, x1566_rd_ofs, io.sigsIn.backpressure, x1566_rd_en.map(_ && x1566_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1567 = VecApply(x1566,0)
      val x1567_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1567_elem_0""")
      x1567_elem_0.r := x1566_rd(0).r
      val x1568 = Wire(Bool()).suggestName("""x1568""")
      x1568.r := Math.lt(0.FP(true, 10, 22), x1567_elem_0, Some(0.4), true.B,"x1568").r
      val x1569 = Wire(Bool()).suggestName("""x1569""")
      x1569.r := Math.lt(1.FP(true, 10, 22), x1567_elem_0, Some(0.4), true.B,"x1569").r
      val x1570 = Wire(Bool()).suggestName("""x1570""")
      x1570 := x1568 & x1569
      val x1571 = Wire(Bool()).suggestName("""x1571""")
      x1571 := ~x1570
      val x1572_wr_x1554_banks = List[UInt]()
      val x1572_wr_x1554_ofs = List[UInt]()
      val x1572_wr_x1554_en = List[Bool](true.B)
      val x1572_wr_x1554_data = List[UInt](x1570.r)
      x1554_reg.connectWPort(1572, x1572_wr_x1554_banks, x1572_wr_x1554_ofs, x1572_wr_x1554_data, x1572_wr_x1554_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1573_wr_x1556_banks = List[UInt]()
      val x1573_wr_x1556_ofs = List[UInt]()
      val x1573_wr_x1556_en = List[Bool](true.B)
      val x1573_wr_x1556_data = List[UInt](x1571.r)
      x1556_reg.connectWPort(1573, x1573_wr_x1556_banks, x1573_wr_x1556_ofs, x1573_wr_x1556_data, x1573_wr_x1556_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1574_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1574_inr_UnitPipe **/
