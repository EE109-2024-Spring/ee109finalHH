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

/** Hierarchy: x2652 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2652 **/
class x2652_kernel(
  list_b566: List[Bool],
  list_x2647_inr_Switch: List[FixedPoint],
  list_x2512_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2652_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2652_iiCtr"))
  
  abstract class x2652_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2512_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2512_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2508_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2508_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_x2509_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2509_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2505_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2505_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2514_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2514_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2510_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2510_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2647_inr_Switch = Input(new FixedPoint(true, 10, 22))
      val in_x2592_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2592_force_0_p").asInstanceOf[NBufParams] ))
      val in_x2633_inr_Switch = Input(new FixedPoint(true, 10, 22))
      val in_x2506_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2506_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b2503 = Input(Bool())
      val in_x2513_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2513_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2511_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2511_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2591_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2591_force_0_p").asInstanceOf[NBufParams] ))
      val in_b2502 = Input(Bool())
      val in_x2507_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2507_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x2512_tmp_2 = {io.in_x2512_tmp_2} ; io.in_x2512_tmp_2 := DontCare
    def x2508_tmp_3 = {io.in_x2508_tmp_3} ; io.in_x2508_tmp_3 := DontCare
    def b566 = {io.in_b566} 
    def x2509_tmp_4 = {io.in_x2509_tmp_4} ; io.in_x2509_tmp_4 := DontCare
    def x2505_tmp_0 = {io.in_x2505_tmp_0} ; io.in_x2505_tmp_0 := DontCare
    def x2514_tmp_4 = {io.in_x2514_tmp_4} ; io.in_x2514_tmp_4 := DontCare
    def x2510_tmp_0 = {io.in_x2510_tmp_0} ; io.in_x2510_tmp_0 := DontCare
    def x2647_inr_Switch = {io.in_x2647_inr_Switch} 
    def x2592_force_0 = {io.in_x2592_force_0} ; io.in_x2592_force_0 := DontCare
    def x2633_inr_Switch = {io.in_x2633_inr_Switch} 
    def x2506_tmp_1 = {io.in_x2506_tmp_1} ; io.in_x2506_tmp_1 := DontCare
    def b2503 = {io.in_b2503} 
    def x2513_tmp_3 = {io.in_x2513_tmp_3} ; io.in_x2513_tmp_3 := DontCare
    def x2511_tmp_1 = {io.in_x2511_tmp_1} ; io.in_x2511_tmp_1 := DontCare
    def x2591_force_0 = {io.in_x2591_force_0} ; io.in_x2591_force_0 := DontCare
    def b2502 = {io.in_b2502} 
    def x2507_tmp_2 = {io.in_x2507_tmp_2} ; io.in_x2507_tmp_2 := DontCare
  }
  def connectWires0(module: x2652_module)(implicit stack: List[KernelHash]): Unit = {
    x2512_tmp_2.connectLedger(module.io.in_x2512_tmp_2)
    x2508_tmp_3.connectLedger(module.io.in_x2508_tmp_3)
    module.io.in_b566 <> b566
    x2509_tmp_4.connectLedger(module.io.in_x2509_tmp_4)
    x2505_tmp_0.connectLedger(module.io.in_x2505_tmp_0)
    x2514_tmp_4.connectLedger(module.io.in_x2514_tmp_4)
    x2510_tmp_0.connectLedger(module.io.in_x2510_tmp_0)
    module.io.in_x2647_inr_Switch <> x2647_inr_Switch
    x2592_force_0.connectLedger(module.io.in_x2592_force_0)
    module.io.in_x2633_inr_Switch <> x2633_inr_Switch
    x2506_tmp_1.connectLedger(module.io.in_x2506_tmp_1)
    module.io.in_b2503 <> b2503
    x2513_tmp_3.connectLedger(module.io.in_x2513_tmp_3)
    x2511_tmp_1.connectLedger(module.io.in_x2511_tmp_1)
    x2591_force_0.connectLedger(module.io.in_x2591_force_0)
    module.io.in_b2502 <> b2502
    x2507_tmp_2.connectLedger(module.io.in_x2507_tmp_2)
  }
  val b566 = list_b566(0)
  val b2503 = list_b566(1)
  val b2502 = list_b566(2)
  val x2647_inr_Switch = list_x2647_inr_Switch(0)
  val x2633_inr_Switch = list_x2647_inr_Switch(1)
  val x2512_tmp_2 = list_x2512_tmp_2(0)
  val x2508_tmp_3 = list_x2512_tmp_2(1)
  val x2509_tmp_4 = list_x2512_tmp_2(2)
  val x2505_tmp_0 = list_x2512_tmp_2(3)
  val x2514_tmp_4 = list_x2512_tmp_2(4)
  val x2510_tmp_0 = list_x2512_tmp_2(5)
  val x2592_force_0 = list_x2512_tmp_2(6)
  val x2506_tmp_1 = list_x2512_tmp_2(7)
  val x2513_tmp_3 = list_x2512_tmp_2(8)
  val x2511_tmp_1 = list_x2512_tmp_2(9)
  val x2591_force_0 = list_x2512_tmp_2(10)
  val x2507_tmp_2 = list_x2512_tmp_2(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2652")
    implicit val stack = ControllerStack.stack.toList
    class x2652_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2652_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2652 = Module(new InstrumentationCounter())
      val iters_x2652 = Module(new InstrumentationCounter())
      cycles_x2652.io.enable := io.sigsIn.baseEn
      iters_x2652.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2652_instrctr, cycles_x2652.io.count, iters_x2652.io.count, 0.U, 0.U)
      val x2649_inr_UnitPipe = new x2649_inr_UnitPipe_kernel(List(b2502,b566), List(x2633_inr_Switch), List(x2591_force_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2649_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2649_inr_UnitPipe.sm.io.ctrInc)
      x2649_inr_UnitPipe.backpressure := true.B | x2649_inr_UnitPipe.sm.io.doneLatch
      x2649_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2649_inr_UnitPipe.sm.io.doneLatch
      x2649_inr_UnitPipe.sm.io.enableOut.zip(x2649_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2649_inr_UnitPipe.sm.io.break := false.B
      x2649_inr_UnitPipe.mask := true.B & b2502 & b566
      x2649_inr_UnitPipe.configure("x2649_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2649_inr_UnitPipe.kernel()
      val x2651_inr_UnitPipe = new x2651_inr_UnitPipe_kernel(List(b2503,b566), List(x2647_inr_Switch), List(x2592_force_0) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2651_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2651_inr_UnitPipe.sm.io.ctrInc)
      x2651_inr_UnitPipe.backpressure := true.B | x2651_inr_UnitPipe.sm.io.doneLatch
      x2651_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2651_inr_UnitPipe.sm.io.doneLatch
      x2651_inr_UnitPipe.sm.io.enableOut.zip(x2651_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2651_inr_UnitPipe.sm.io.break := false.B
      x2651_inr_UnitPipe.mask := true.B & b2503 & b566
      x2651_inr_UnitPipe.configure("x2651_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2651_inr_UnitPipe.kernel()
      x2505_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2506_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2507_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2508_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2509_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2510_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2511_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2512_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2513_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2514_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x2591_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2592_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x2652_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2652 **/
