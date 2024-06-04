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

/** Hierarchy: x2649 -> x2652 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2649_inr_UnitPipe **/
class x2649_inr_UnitPipe_kernel(
  list_b2502: List[Bool],
  list_x2633_inr_Switch: List[FixedPoint],
  list_x2591_force_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 1.0.toInt, myName = "x2649_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2649_inr_UnitPipe_iiCtr"))
  
  abstract class x2649_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2502 = Input(Bool())
      val in_b566 = Input(Bool())
      val in_x2591_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2591_force_0_p").asInstanceOf[NBufParams] ))
      val in_x2633_inr_Switch = Input(new FixedPoint(true, 10, 22))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b2502 = {io.in_b2502} 
    def b566 = {io.in_b566} 
    def x2591_force_0 = {io.in_x2591_force_0} ; io.in_x2591_force_0 := DontCare
    def x2633_inr_Switch = {io.in_x2633_inr_Switch} 
  }
  def connectWires0(module: x2649_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2502 <> b2502
    module.io.in_b566 <> b566
    x2591_force_0.connectLedger(module.io.in_x2591_force_0)
    module.io.in_x2633_inr_Switch <> x2633_inr_Switch
  }
  val b2502 = list_b2502(0)
  val b566 = list_b2502(1)
  val x2633_inr_Switch = list_x2633_inr_Switch(0)
  val x2591_force_0 = list_x2591_force_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2649_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2649_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2649_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2649_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2649_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2649_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2649_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2649_instrctr, cycles_x2649_inr_UnitPipe.io.count, iters_x2649_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2648_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2648_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2648_wr_en = List[Bool](true.B)
      val x2648_wr_data = List[UInt](x2633_inr_Switch.r)
      x2591_force_0.connectWPort(2648, x2648_wr_banks, x2648_wr_ofs, x2648_wr_data, x2648_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2649_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2649_inr_UnitPipe **/
