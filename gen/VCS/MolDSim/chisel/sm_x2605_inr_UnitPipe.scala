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

/** Hierarchy: x2605 -> x2615 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2605_inr_UnitPipe **/
class x2605_inr_UnitPipe_kernel(
  list_b566: List[Bool],
  list_x2595_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x2605_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2605_inr_UnitPipe_iiCtr"))
  
  abstract class x2605_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2595_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2595_reg_p").asInstanceOf[NBufParams] ))
      val in_x2562_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2562_r_0_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_x2593_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2593_reg_p").asInstanceOf[NBufParams] ))
      val in_b2502 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2595_reg = {io.in_x2595_reg} ; io.in_x2595_reg := DontCare
    def x2562_r_0 = {io.in_x2562_r_0} ; io.in_x2562_r_0 := DontCare
    def b566 = {io.in_b566} 
    def x2593_reg = {io.in_x2593_reg} ; io.in_x2593_reg := DontCare
    def b2502 = {io.in_b2502} 
  }
  def connectWires0(module: x2605_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2595_reg.connectLedger(module.io.in_x2595_reg)
    x2562_r_0.connectLedger(module.io.in_x2562_r_0)
    module.io.in_b566 <> b566
    x2593_reg.connectLedger(module.io.in_x2593_reg)
    module.io.in_b2502 <> b2502
  }
  val b566 = list_b566(0)
  val b2502 = list_b566(1)
  val x2595_reg = list_x2595_reg(0)
  val x2562_r_0 = list_x2595_reg(1)
  val x2593_reg = list_x2595_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2605_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2605_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2605_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2605_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2605_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2605_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2605_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2605_instrctr, cycles_x2605_inr_UnitPipe.io.count, iters_x2605_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2597_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2597_rd""")
      val x2597_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2597_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2597_rd_en = List[Bool](true.B)
      val x2597_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2597_rd_shared_en")
      x2597_rd.toSeq.zip(x2562_r_0.connectRPort(2597, x2597_rd_banks, x2597_rd_ofs, io.sigsIn.backpressure, x2597_rd_en.map(_ && x2597_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2598 = VecApply(x2597,0)
      val x2598_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2598_elem_0""")
      x2598_elem_0.r := x2597_rd(0).r
      val x2599 = Wire(Bool()).suggestName("""x2599""")
      x2599.r := Math.lt(0.FP(true, 10, 22), x2598_elem_0, Some(0.4), true.B,"x2599").r
      val x2600 = Wire(Bool()).suggestName("""x2600""")
      x2600.r := Math.lt(1.FP(true, 10, 22), x2598_elem_0, Some(0.4), true.B,"x2600").r
      val x2601 = Wire(Bool()).suggestName("""x2601""")
      x2601 := x2599 & x2600
      val x2602 = Wire(Bool()).suggestName("""x2602""")
      x2602 := ~x2601
      val x2603_wr_x2593_banks = List[UInt]()
      val x2603_wr_x2593_ofs = List[UInt]()
      val x2603_wr_x2593_en = List[Bool](true.B)
      val x2603_wr_x2593_data = List[UInt](x2601.r)
      x2593_reg.connectWPort(2603, x2603_wr_x2593_banks, x2603_wr_x2593_ofs, x2603_wr_x2593_data, x2603_wr_x2593_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x2604_wr_x2595_banks = List[UInt]()
      val x2604_wr_x2595_ofs = List[UInt]()
      val x2604_wr_x2595_en = List[Bool](true.B)
      val x2604_wr_x2595_data = List[UInt](x2602.r)
      x2595_reg.connectWPort(2604, x2604_wr_x2595_banks, x2604_wr_x2595_ofs, x2604_wr_x2595_data, x2604_wr_x2595_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2605_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2605_inr_UnitPipe **/
