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

/** Hierarchy: x742 -> x743 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x742_inr_UnitPipe **/
class x742_inr_UnitPipe_kernel(
  list_b631: List[Bool],
  list_x724_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x742_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x742_inr_UnitPipe_iiCtr"))
  
  abstract class x742_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x724_reg = Flipped(new NBufInterface(ModuleParams.getParams("x724_reg_p").asInstanceOf[NBufParams] ))
      val in_b631 = Input(Bool())
      val in_x722_reg = Flipped(new NBufInterface(ModuleParams.getParams("x722_reg_p").asInstanceOf[NBufParams] ))
      val in_b557 = Input(Bool())
      val in_x691_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x691_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x724_reg = {io.in_x724_reg} ; io.in_x724_reg := DontCare
    def b631 = {io.in_b631} 
    def x722_reg = {io.in_x722_reg} ; io.in_x722_reg := DontCare
    def b557 = {io.in_b557} 
    def x691_r_0 = {io.in_x691_r_0} ; io.in_x691_r_0 := DontCare
  }
  def connectWires0(module: x742_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x724_reg.connectLedger(module.io.in_x724_reg)
    module.io.in_b631 <> b631
    x722_reg.connectLedger(module.io.in_x722_reg)
    module.io.in_b557 <> b557
    x691_r_0.connectLedger(module.io.in_x691_r_0)
  }
  val b631 = list_b631(0)
  val b557 = list_b631(1)
  val x724_reg = list_x724_reg(0)
  val x722_reg = list_x724_reg(1)
  val x691_r_0 = list_x724_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x742_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x742_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x742_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x742_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x742_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x742_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x742_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X742_instrctr, cycles_x742_inr_UnitPipe.io.count, iters_x742_inr_UnitPipe.io.count, 0.U, 0.U)
      val x734_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x734_rd""")
      val x734_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x734_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x734_rd_en = List[Bool](true.B)
      val x734_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x734_rd_shared_en")
      x734_rd.toSeq.zip(x691_r_0.connectRPort(734, x734_rd_banks, x734_rd_ofs, io.sigsIn.backpressure, x734_rd_en.map(_ && x734_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x735 = VecApply(x734,0)
      val x735_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x735_elem_0""")
      x735_elem_0.r := x734_rd(0).r
      val x736 = Wire(Bool()).suggestName("""x736""")
      x736.r := Math.lt(0.FP(true, 10, 22), x735_elem_0, Some(0.4), true.B,"x736").r
      val x737 = Wire(Bool()).suggestName("""x737""")
      x737.r := Math.lt(1.FP(true, 10, 22), x735_elem_0, Some(0.4), true.B,"x737").r
      val x738 = Wire(Bool()).suggestName("""x738""")
      x738 := x736 & x737
      val x739 = Wire(Bool()).suggestName("""x739""")
      x739 := ~x738
      val x740_wr_x722_banks = List[UInt]()
      val x740_wr_x722_ofs = List[UInt]()
      val x740_wr_x722_en = List[Bool](true.B)
      val x740_wr_x722_data = List[UInt](x738.r)
      x722_reg.connectWPort(740, x740_wr_x722_banks, x740_wr_x722_ofs, x740_wr_x722_data, x740_wr_x722_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x741_wr_x724_banks = List[UInt]()
      val x741_wr_x724_ofs = List[UInt]()
      val x741_wr_x724_en = List[Bool](true.B)
      val x741_wr_x724_data = List[UInt](x739.r)
      x724_reg.connectWPort(741, x741_wr_x724_banks, x741_wr_x724_ofs, x741_wr_x724_data, x741_wr_x724_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x742_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x742_inr_UnitPipe **/
