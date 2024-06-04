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

/** Hierarchy: x1782 -> x1783 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1782_inr_UnitPipe **/
class x1782_inr_UnitPipe_kernel(
  list_b1671: List[Bool],
  list_x1762_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1782_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1782_inr_UnitPipe_iiCtr"))
  
  abstract class x1782_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1671 = Input(Bool())
      val in_x1762_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1762_reg_p").asInstanceOf[NBufParams] ))
      val in_x1764_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1764_reg_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1731_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1731_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1671 = {io.in_b1671} 
    def x1762_reg = {io.in_x1762_reg} ; io.in_x1762_reg := DontCare
    def x1764_reg = {io.in_x1764_reg} ; io.in_x1764_reg := DontCare
    def b562 = {io.in_b562} 
    def x1731_r_0 = {io.in_x1731_r_0} ; io.in_x1731_r_0 := DontCare
  }
  def connectWires0(module: x1782_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1671 <> b1671
    x1762_reg.connectLedger(module.io.in_x1762_reg)
    x1764_reg.connectLedger(module.io.in_x1764_reg)
    module.io.in_b562 <> b562
    x1731_r_0.connectLedger(module.io.in_x1731_r_0)
  }
  val b1671 = list_b1671(0)
  val b562 = list_b1671(1)
  val x1762_reg = list_x1762_reg(0)
  val x1764_reg = list_x1762_reg(1)
  val x1731_r_0 = list_x1762_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1782_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1782_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1782_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1782_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1782_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1782_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1782_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1782_instrctr, cycles_x1782_inr_UnitPipe.io.count, iters_x1782_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1774_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1774_rd""")
      val x1774_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1774_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1774_rd_en = List[Bool](true.B)
      val x1774_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1774_rd_shared_en")
      x1774_rd.toSeq.zip(x1731_r_0.connectRPort(1774, x1774_rd_banks, x1774_rd_ofs, io.sigsIn.backpressure, x1774_rd_en.map(_ && x1774_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1775 = VecApply(x1774,0)
      val x1775_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1775_elem_0""")
      x1775_elem_0.r := x1774_rd(0).r
      val x1776 = Wire(Bool()).suggestName("""x1776""")
      x1776.r := Math.lt(0.FP(true, 10, 22), x1775_elem_0, Some(0.4), true.B,"x1776").r
      val x1777 = Wire(Bool()).suggestName("""x1777""")
      x1777.r := Math.lt(1.FP(true, 10, 22), x1775_elem_0, Some(0.4), true.B,"x1777").r
      val x1778 = Wire(Bool()).suggestName("""x1778""")
      x1778 := x1776 & x1777
      val x1779 = Wire(Bool()).suggestName("""x1779""")
      x1779 := ~x1778
      val x1780_wr_x1762_banks = List[UInt]()
      val x1780_wr_x1762_ofs = List[UInt]()
      val x1780_wr_x1762_en = List[Bool](true.B)
      val x1780_wr_x1762_data = List[UInt](x1778.r)
      x1762_reg.connectWPort(1780, x1780_wr_x1762_banks, x1780_wr_x1762_ofs, x1780_wr_x1762_data, x1780_wr_x1762_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1781_wr_x1764_banks = List[UInt]()
      val x1781_wr_x1764_ofs = List[UInt]()
      val x1781_wr_x1764_en = List[Bool](true.B)
      val x1781_wr_x1764_data = List[UInt](x1779.r)
      x1764_reg.connectWPort(1781, x1781_wr_x1764_banks, x1781_wr_x1764_ofs, x1781_wr_x1764_data, x1781_wr_x1764_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1782_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1782_inr_UnitPipe **/
