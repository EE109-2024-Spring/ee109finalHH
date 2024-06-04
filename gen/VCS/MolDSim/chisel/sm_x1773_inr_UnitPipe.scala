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

/** Hierarchy: x1773 -> x1783 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1773_inr_UnitPipe **/
class x1773_inr_UnitPipe_kernel(
  list_b562: List[Bool],
  list_x1761_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1773_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1773_inr_UnitPipe_iiCtr"))
  
  abstract class x1773_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1761_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1761_reg_p").asInstanceOf[NBufParams] ))
      val in_x1730_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1730_r_0_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1763_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1763_reg_p").asInstanceOf[NBufParams] ))
      val in_b1670 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1761_reg = {io.in_x1761_reg} ; io.in_x1761_reg := DontCare
    def x1730_r_0 = {io.in_x1730_r_0} ; io.in_x1730_r_0 := DontCare
    def b562 = {io.in_b562} 
    def x1763_reg = {io.in_x1763_reg} ; io.in_x1763_reg := DontCare
    def b1670 = {io.in_b1670} 
  }
  def connectWires0(module: x1773_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1761_reg.connectLedger(module.io.in_x1761_reg)
    x1730_r_0.connectLedger(module.io.in_x1730_r_0)
    module.io.in_b562 <> b562
    x1763_reg.connectLedger(module.io.in_x1763_reg)
    module.io.in_b1670 <> b1670
  }
  val b562 = list_b562(0)
  val b1670 = list_b562(1)
  val x1761_reg = list_x1761_reg(0)
  val x1730_r_0 = list_x1761_reg(1)
  val x1763_reg = list_x1761_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1773_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1773_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1773_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1773_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1773_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1773_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1773_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1773_instrctr, cycles_x1773_inr_UnitPipe.io.count, iters_x1773_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1765_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1765_rd""")
      val x1765_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1765_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1765_rd_en = List[Bool](true.B)
      val x1765_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1765_rd_shared_en")
      x1765_rd.toSeq.zip(x1730_r_0.connectRPort(1765, x1765_rd_banks, x1765_rd_ofs, io.sigsIn.backpressure, x1765_rd_en.map(_ && x1765_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1766 = VecApply(x1765,0)
      val x1766_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1766_elem_0""")
      x1766_elem_0.r := x1765_rd(0).r
      val x1767 = Wire(Bool()).suggestName("""x1767""")
      x1767.r := Math.lt(0.FP(true, 10, 22), x1766_elem_0, Some(0.4), true.B,"x1767").r
      val x1768 = Wire(Bool()).suggestName("""x1768""")
      x1768.r := Math.lt(1.FP(true, 10, 22), x1766_elem_0, Some(0.4), true.B,"x1768").r
      val x1769 = Wire(Bool()).suggestName("""x1769""")
      x1769 := x1767 & x1768
      val x1770 = Wire(Bool()).suggestName("""x1770""")
      x1770 := ~x1769
      val x1771_wr_x1761_banks = List[UInt]()
      val x1771_wr_x1761_ofs = List[UInt]()
      val x1771_wr_x1761_en = List[Bool](true.B)
      val x1771_wr_x1761_data = List[UInt](x1769.r)
      x1761_reg.connectWPort(1771, x1771_wr_x1761_banks, x1771_wr_x1761_ofs, x1771_wr_x1761_data, x1771_wr_x1761_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1772_wr_x1763_banks = List[UInt]()
      val x1772_wr_x1763_ofs = List[UInt]()
      val x1772_wr_x1763_en = List[Bool](true.B)
      val x1772_wr_x1763_data = List[UInt](x1770.r)
      x1763_reg.connectWPort(1772, x1772_wr_x1763_banks, x1772_wr_x1763_ofs, x1772_wr_x1763_data, x1772_wr_x1763_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1773_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1773_inr_UnitPipe **/
