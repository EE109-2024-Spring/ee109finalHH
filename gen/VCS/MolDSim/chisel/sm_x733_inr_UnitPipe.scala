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

/** Hierarchy: x733 -> x743 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x733_inr_UnitPipe **/
class x733_inr_UnitPipe_kernel(
  list_b630: List[Bool],
  list_x721_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x733_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x733_inr_UnitPipe_iiCtr"))
  
  abstract class x733_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b630 = Input(Bool())
      val in_x721_reg = Flipped(new NBufInterface(ModuleParams.getParams("x721_reg_p").asInstanceOf[NBufParams] ))
      val in_b557 = Input(Bool())
      val in_x690_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x690_r_0_p").asInstanceOf[NBufParams] ))
      val in_x723_reg = Flipped(new NBufInterface(ModuleParams.getParams("x723_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b630 = {io.in_b630} 
    def x721_reg = {io.in_x721_reg} ; io.in_x721_reg := DontCare
    def b557 = {io.in_b557} 
    def x690_r_0 = {io.in_x690_r_0} ; io.in_x690_r_0 := DontCare
    def x723_reg = {io.in_x723_reg} ; io.in_x723_reg := DontCare
  }
  def connectWires0(module: x733_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b630 <> b630
    x721_reg.connectLedger(module.io.in_x721_reg)
    module.io.in_b557 <> b557
    x690_r_0.connectLedger(module.io.in_x690_r_0)
    x723_reg.connectLedger(module.io.in_x723_reg)
  }
  val b630 = list_b630(0)
  val b557 = list_b630(1)
  val x721_reg = list_x721_reg(0)
  val x690_r_0 = list_x721_reg(1)
  val x723_reg = list_x721_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x733_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x733_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x733_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x733_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x733_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x733_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x733_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X733_instrctr, cycles_x733_inr_UnitPipe.io.count, iters_x733_inr_UnitPipe.io.count, 0.U, 0.U)
      val x725_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x725_rd""")
      val x725_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x725_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x725_rd_en = List[Bool](true.B)
      val x725_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x725_rd_shared_en")
      x725_rd.toSeq.zip(x690_r_0.connectRPort(725, x725_rd_banks, x725_rd_ofs, io.sigsIn.backpressure, x725_rd_en.map(_ && x725_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x726 = VecApply(x725,0)
      val x726_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x726_elem_0""")
      x726_elem_0.r := x725_rd(0).r
      val x727 = Wire(Bool()).suggestName("""x727""")
      x727.r := Math.lt(0.FP(true, 10, 22), x726_elem_0, Some(0.4), true.B,"x727").r
      val x728 = Wire(Bool()).suggestName("""x728""")
      x728.r := Math.lt(1.FP(true, 10, 22), x726_elem_0, Some(0.4), true.B,"x728").r
      val x729 = Wire(Bool()).suggestName("""x729""")
      x729 := x727 & x728
      val x730 = Wire(Bool()).suggestName("""x730""")
      x730 := ~x729
      val x731_wr_x721_banks = List[UInt]()
      val x731_wr_x721_ofs = List[UInt]()
      val x731_wr_x721_en = List[Bool](true.B)
      val x731_wr_x721_data = List[UInt](x729.r)
      x721_reg.connectWPort(731, x731_wr_x721_banks, x731_wr_x721_ofs, x731_wr_x721_data, x731_wr_x721_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x732_wr_x723_banks = List[UInt]()
      val x732_wr_x723_ofs = List[UInt]()
      val x732_wr_x723_en = List[Bool](true.B)
      val x732_wr_x723_data = List[UInt](x730.r)
      x723_reg.connectWPort(732, x732_wr_x723_banks, x732_wr_x723_ofs, x732_wr_x723_data, x732_wr_x723_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x733_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x733_inr_UnitPipe **/
