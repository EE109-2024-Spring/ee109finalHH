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

/** Hierarchy: x718 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x718 **/
class x718_kernel(
  list_b630: List[Bool],
  list_x638_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x718_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x718_iiCtr"))
  
  abstract class x718_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x638_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x638_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x634_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x634_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b630 = Input(Bool())
      val in_x642_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x642_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x637_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x637_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x633_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x633_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x641_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x641_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b631 = Input(Bool())
      val in_x636_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x636_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b557 = Input(Bool())
      val in_x690_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x690_r_0_p").asInstanceOf[NBufParams] ))
      val in_x640_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x640_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x635_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x635_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x691_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x691_r_0_p").asInstanceOf[NBufParams] ))
      val in_x639_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x639_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x638_tmp_0 = {io.in_x638_tmp_0} ; io.in_x638_tmp_0 := DontCare
    def x634_tmp_1 = {io.in_x634_tmp_1} ; io.in_x634_tmp_1 := DontCare
    def b630 = {io.in_b630} 
    def x642_tmp_4 = {io.in_x642_tmp_4} ; io.in_x642_tmp_4 := DontCare
    def x637_tmp_4 = {io.in_x637_tmp_4} ; io.in_x637_tmp_4 := DontCare
    def x633_tmp_0 = {io.in_x633_tmp_0} ; io.in_x633_tmp_0 := DontCare
    def x641_tmp_3 = {io.in_x641_tmp_3} ; io.in_x641_tmp_3 := DontCare
    def b631 = {io.in_b631} 
    def x636_tmp_3 = {io.in_x636_tmp_3} ; io.in_x636_tmp_3 := DontCare
    def b557 = {io.in_b557} 
    def x690_r_0 = {io.in_x690_r_0} ; io.in_x690_r_0 := DontCare
    def x640_tmp_2 = {io.in_x640_tmp_2} ; io.in_x640_tmp_2 := DontCare
    def x635_tmp_2 = {io.in_x635_tmp_2} ; io.in_x635_tmp_2 := DontCare
    def x691_r_0 = {io.in_x691_r_0} ; io.in_x691_r_0 := DontCare
    def x639_tmp_1 = {io.in_x639_tmp_1} ; io.in_x639_tmp_1 := DontCare
  }
  def connectWires0(module: x718_module)(implicit stack: List[KernelHash]): Unit = {
    x638_tmp_0.connectLedger(module.io.in_x638_tmp_0)
    x634_tmp_1.connectLedger(module.io.in_x634_tmp_1)
    module.io.in_b630 <> b630
    x642_tmp_4.connectLedger(module.io.in_x642_tmp_4)
    x637_tmp_4.connectLedger(module.io.in_x637_tmp_4)
    x633_tmp_0.connectLedger(module.io.in_x633_tmp_0)
    x641_tmp_3.connectLedger(module.io.in_x641_tmp_3)
    module.io.in_b631 <> b631
    x636_tmp_3.connectLedger(module.io.in_x636_tmp_3)
    module.io.in_b557 <> b557
    x690_r_0.connectLedger(module.io.in_x690_r_0)
    x640_tmp_2.connectLedger(module.io.in_x640_tmp_2)
    x635_tmp_2.connectLedger(module.io.in_x635_tmp_2)
    x691_r_0.connectLedger(module.io.in_x691_r_0)
    x639_tmp_1.connectLedger(module.io.in_x639_tmp_1)
  }
  val b630 = list_b630(0)
  val b631 = list_b630(1)
  val b557 = list_b630(2)
  val x638_tmp_0 = list_x638_tmp_0(0)
  val x634_tmp_1 = list_x638_tmp_0(1)
  val x642_tmp_4 = list_x638_tmp_0(2)
  val x637_tmp_4 = list_x638_tmp_0(3)
  val x633_tmp_0 = list_x638_tmp_0(4)
  val x641_tmp_3 = list_x638_tmp_0(5)
  val x636_tmp_3 = list_x638_tmp_0(6)
  val x690_r_0 = list_x638_tmp_0(7)
  val x640_tmp_2 = list_x638_tmp_0(8)
  val x635_tmp_2 = list_x638_tmp_0(9)
  val x691_r_0 = list_x638_tmp_0(10)
  val x639_tmp_1 = list_x638_tmp_0(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x718")
    implicit val stack = ControllerStack.stack.toList
    class x718_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x718_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x718 = Module(new InstrumentationCounter())
      val iters_x718 = Module(new InstrumentationCounter())
      cycles_x718.io.enable := io.sigsIn.baseEn
      iters_x718.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X718_instrctr, cycles_x718.io.count, iters_x718.io.count, 0.U, 0.U)
      val x704_inr_UnitPipe = new x704_inr_UnitPipe_kernel(List(b630,b557), List(x634_tmp_1,x633_tmp_0,x690_r_0,x635_tmp_2) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x704_inr_UnitPipe.sm.io.ctrDone := risingEdge(x704_inr_UnitPipe.sm.io.ctrInc)
      x704_inr_UnitPipe.backpressure := true.B | x704_inr_UnitPipe.sm.io.doneLatch
      x704_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x704_inr_UnitPipe.sm.io.doneLatch
      x704_inr_UnitPipe.sm.io.enableOut.zip(x704_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x704_inr_UnitPipe.sm.io.break := false.B
      x704_inr_UnitPipe.mask := true.B & b630 & b557
      x704_inr_UnitPipe.configure("x704_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x704_inr_UnitPipe.kernel()
      val x717_inr_UnitPipe = new x717_inr_UnitPipe_kernel(List(b631,b557), List(x638_tmp_0,x640_tmp_2,x691_r_0,x639_tmp_1) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x717_inr_UnitPipe.sm.io.ctrDone := risingEdge(x717_inr_UnitPipe.sm.io.ctrInc)
      x717_inr_UnitPipe.backpressure := true.B | x717_inr_UnitPipe.sm.io.doneLatch
      x717_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x717_inr_UnitPipe.sm.io.doneLatch
      x717_inr_UnitPipe.sm.io.enableOut.zip(x717_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x717_inr_UnitPipe.sm.io.break := false.B
      x717_inr_UnitPipe.mask := true.B & b631 & b557
      x717_inr_UnitPipe.configure("x717_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x717_inr_UnitPipe.kernel()
      x633_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x634_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x635_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x636_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x637_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x638_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x639_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x640_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x641_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x642_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x690_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x691_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x718_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x718 **/
