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

/** Hierarchy: x2614 -> x2615 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2614_inr_UnitPipe **/
class x2614_inr_UnitPipe_kernel(
  list_b566: List[Bool],
  list_x2596_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x2614_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2614_inr_UnitPipe_iiCtr"))
  
  abstract class x2614_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2596_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2596_reg_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_b2503 = Input(Bool())
      val in_x2594_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2594_reg_p").asInstanceOf[NBufParams] ))
      val in_x2563_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2563_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2596_reg = {io.in_x2596_reg} ; io.in_x2596_reg := DontCare
    def b566 = {io.in_b566} 
    def b2503 = {io.in_b2503} 
    def x2594_reg = {io.in_x2594_reg} ; io.in_x2594_reg := DontCare
    def x2563_r_0 = {io.in_x2563_r_0} ; io.in_x2563_r_0 := DontCare
  }
  def connectWires0(module: x2614_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2596_reg.connectLedger(module.io.in_x2596_reg)
    module.io.in_b566 <> b566
    module.io.in_b2503 <> b2503
    x2594_reg.connectLedger(module.io.in_x2594_reg)
    x2563_r_0.connectLedger(module.io.in_x2563_r_0)
  }
  val b566 = list_b566(0)
  val b2503 = list_b566(1)
  val x2596_reg = list_x2596_reg(0)
  val x2594_reg = list_x2596_reg(1)
  val x2563_r_0 = list_x2596_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2614_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2614_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2614_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2614_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2614_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2614_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2614_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2614_instrctr, cycles_x2614_inr_UnitPipe.io.count, iters_x2614_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2606_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2606_rd""")
      val x2606_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2606_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2606_rd_en = List[Bool](true.B)
      val x2606_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2606_rd_shared_en")
      x2606_rd.toSeq.zip(x2563_r_0.connectRPort(2606, x2606_rd_banks, x2606_rd_ofs, io.sigsIn.backpressure, x2606_rd_en.map(_ && x2606_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2607 = VecApply(x2606,0)
      val x2607_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2607_elem_0""")
      x2607_elem_0.r := x2606_rd(0).r
      val x2608 = Wire(Bool()).suggestName("""x2608""")
      x2608.r := Math.lt(0.FP(true, 10, 22), x2607_elem_0, Some(0.4), true.B,"x2608").r
      val x2609 = Wire(Bool()).suggestName("""x2609""")
      x2609.r := Math.lt(1.FP(true, 10, 22), x2607_elem_0, Some(0.4), true.B,"x2609").r
      val x2610 = Wire(Bool()).suggestName("""x2610""")
      x2610 := x2608 & x2609
      val x2611 = Wire(Bool()).suggestName("""x2611""")
      x2611 := ~x2610
      val x2612_wr_x2594_banks = List[UInt]()
      val x2612_wr_x2594_ofs = List[UInt]()
      val x2612_wr_x2594_en = List[Bool](true.B)
      val x2612_wr_x2594_data = List[UInt](x2610.r)
      x2594_reg.connectWPort(2612, x2612_wr_x2594_banks, x2612_wr_x2594_ofs, x2612_wr_x2594_data, x2612_wr_x2594_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x2613_wr_x2596_banks = List[UInt]()
      val x2613_wr_x2596_ofs = List[UInt]()
      val x2613_wr_x2596_en = List[Bool](true.B)
      val x2613_wr_x2596_data = List[UInt](x2611.r)
      x2596_reg.connectWPort(2613, x2613_wr_x2596_banks, x2613_wr_x2596_ofs, x2613_wr_x2596_data, x2613_wr_x2596_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2614_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2614_inr_UnitPipe **/
