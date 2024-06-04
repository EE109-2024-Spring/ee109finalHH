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

/** Hierarchy: x2174 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2174 **/
class x2174_kernel(
  list_b2086: List[Bool],
  list_x2094_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2174_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2174_iiCtr"))
  
  abstract class x2174_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2094_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2094_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2146_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2146_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2090_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2090_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2093_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2093_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2147_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2147_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2089_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2089_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2097_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2097_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b2086 = Input(Bool())
      val in_x2096_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2096_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2092_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2092_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2098_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2098_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2095_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2095_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b564 = Input(Bool())
      val in_x2091_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2091_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b2087 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x2094_tmp_0 = {io.in_x2094_tmp_0} ; io.in_x2094_tmp_0 := DontCare
    def x2146_r_0 = {io.in_x2146_r_0} ; io.in_x2146_r_0 := DontCare
    def x2090_tmp_1 = {io.in_x2090_tmp_1} ; io.in_x2090_tmp_1 := DontCare
    def x2093_tmp_4 = {io.in_x2093_tmp_4} ; io.in_x2093_tmp_4 := DontCare
    def x2147_r_0 = {io.in_x2147_r_0} ; io.in_x2147_r_0 := DontCare
    def x2089_tmp_0 = {io.in_x2089_tmp_0} ; io.in_x2089_tmp_0 := DontCare
    def x2097_tmp_3 = {io.in_x2097_tmp_3} ; io.in_x2097_tmp_3 := DontCare
    def b2086 = {io.in_b2086} 
    def x2096_tmp_2 = {io.in_x2096_tmp_2} ; io.in_x2096_tmp_2 := DontCare
    def x2092_tmp_3 = {io.in_x2092_tmp_3} ; io.in_x2092_tmp_3 := DontCare
    def x2098_tmp_4 = {io.in_x2098_tmp_4} ; io.in_x2098_tmp_4 := DontCare
    def x2095_tmp_1 = {io.in_x2095_tmp_1} ; io.in_x2095_tmp_1 := DontCare
    def b564 = {io.in_b564} 
    def x2091_tmp_2 = {io.in_x2091_tmp_2} ; io.in_x2091_tmp_2 := DontCare
    def b2087 = {io.in_b2087} 
  }
  def connectWires0(module: x2174_module)(implicit stack: List[KernelHash]): Unit = {
    x2094_tmp_0.connectLedger(module.io.in_x2094_tmp_0)
    x2146_r_0.connectLedger(module.io.in_x2146_r_0)
    x2090_tmp_1.connectLedger(module.io.in_x2090_tmp_1)
    x2093_tmp_4.connectLedger(module.io.in_x2093_tmp_4)
    x2147_r_0.connectLedger(module.io.in_x2147_r_0)
    x2089_tmp_0.connectLedger(module.io.in_x2089_tmp_0)
    x2097_tmp_3.connectLedger(module.io.in_x2097_tmp_3)
    module.io.in_b2086 <> b2086
    x2096_tmp_2.connectLedger(module.io.in_x2096_tmp_2)
    x2092_tmp_3.connectLedger(module.io.in_x2092_tmp_3)
    x2098_tmp_4.connectLedger(module.io.in_x2098_tmp_4)
    x2095_tmp_1.connectLedger(module.io.in_x2095_tmp_1)
    module.io.in_b564 <> b564
    x2091_tmp_2.connectLedger(module.io.in_x2091_tmp_2)
    module.io.in_b2087 <> b2087
  }
  val b2086 = list_b2086(0)
  val b564 = list_b2086(1)
  val b2087 = list_b2086(2)
  val x2094_tmp_0 = list_x2094_tmp_0(0)
  val x2146_r_0 = list_x2094_tmp_0(1)
  val x2090_tmp_1 = list_x2094_tmp_0(2)
  val x2093_tmp_4 = list_x2094_tmp_0(3)
  val x2147_r_0 = list_x2094_tmp_0(4)
  val x2089_tmp_0 = list_x2094_tmp_0(5)
  val x2097_tmp_3 = list_x2094_tmp_0(6)
  val x2096_tmp_2 = list_x2094_tmp_0(7)
  val x2092_tmp_3 = list_x2094_tmp_0(8)
  val x2098_tmp_4 = list_x2094_tmp_0(9)
  val x2095_tmp_1 = list_x2094_tmp_0(10)
  val x2091_tmp_2 = list_x2094_tmp_0(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2174")
    implicit val stack = ControllerStack.stack.toList
    class x2174_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2174_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2174 = Module(new InstrumentationCounter())
      val iters_x2174 = Module(new InstrumentationCounter())
      cycles_x2174.io.enable := io.sigsIn.baseEn
      iters_x2174.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2174_instrctr, cycles_x2174.io.count, iters_x2174.io.count, 0.U, 0.U)
      val x2160_inr_UnitPipe = new x2160_inr_UnitPipe_kernel(List(b2086,b564), List(x2146_r_0,x2090_tmp_1,x2089_tmp_0,x2091_tmp_2) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2160_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2160_inr_UnitPipe.sm.io.ctrInc)
      x2160_inr_UnitPipe.backpressure := true.B | x2160_inr_UnitPipe.sm.io.doneLatch
      x2160_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2160_inr_UnitPipe.sm.io.doneLatch
      x2160_inr_UnitPipe.sm.io.enableOut.zip(x2160_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2160_inr_UnitPipe.sm.io.break := false.B
      x2160_inr_UnitPipe.mask := true.B & b2086 & b564
      x2160_inr_UnitPipe.configure("x2160_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2160_inr_UnitPipe.kernel()
      val x2173_inr_UnitPipe = new x2173_inr_UnitPipe_kernel(List(b564,b2087), List(x2094_tmp_0,x2147_r_0,x2096_tmp_2,x2095_tmp_1) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2173_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2173_inr_UnitPipe.sm.io.ctrInc)
      x2173_inr_UnitPipe.backpressure := true.B | x2173_inr_UnitPipe.sm.io.doneLatch
      x2173_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2173_inr_UnitPipe.sm.io.doneLatch
      x2173_inr_UnitPipe.sm.io.enableOut.zip(x2173_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2173_inr_UnitPipe.sm.io.break := false.B
      x2173_inr_UnitPipe.mask := true.B & b2087 & b564
      x2173_inr_UnitPipe.configure("x2173_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2173_inr_UnitPipe.kernel()
      x2089_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2090_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2091_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2092_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2093_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2094_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2095_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2096_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2097_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2098_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2146_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2147_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x2174_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2174 **/
