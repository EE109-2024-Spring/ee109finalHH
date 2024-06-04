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

/** Hierarchy: x2269 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2269 **/
class x2269_kernel(
  list_b2086: List[Bool],
  list_x2240_ctrchain: List[CounterChainInterface],
  list_x2094_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2269_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2269_iiCtr"))
  
  abstract class x2269_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2094_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2094_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2090_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2090_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2093_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2093_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2240_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2240_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x2089_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2089_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2176_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2176_force_0_p").asInstanceOf[NBufParams] ))
      val in_x2097_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2097_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b2086 = Input(Bool())
      val in_x2239_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2239_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x2096_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2096_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2175_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2175_force_0_p").asInstanceOf[NBufParams] ))
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
    def x2090_tmp_1 = {io.in_x2090_tmp_1} ; io.in_x2090_tmp_1 := DontCare
    def x2093_tmp_4 = {io.in_x2093_tmp_4} ; io.in_x2093_tmp_4 := DontCare
    def x2240_ctrchain = {io.in_x2240_ctrchain} ; io.in_x2240_ctrchain := DontCare
    def x2089_tmp_0 = {io.in_x2089_tmp_0} ; io.in_x2089_tmp_0 := DontCare
    def x2176_force_0 = {io.in_x2176_force_0} ; io.in_x2176_force_0 := DontCare
    def x2097_tmp_3 = {io.in_x2097_tmp_3} ; io.in_x2097_tmp_3 := DontCare
    def b2086 = {io.in_b2086} 
    def x2239_ctrchain = {io.in_x2239_ctrchain} ; io.in_x2239_ctrchain := DontCare
    def x2096_tmp_2 = {io.in_x2096_tmp_2} ; io.in_x2096_tmp_2 := DontCare
    def x2175_force_0 = {io.in_x2175_force_0} ; io.in_x2175_force_0 := DontCare
    def x2092_tmp_3 = {io.in_x2092_tmp_3} ; io.in_x2092_tmp_3 := DontCare
    def x2098_tmp_4 = {io.in_x2098_tmp_4} ; io.in_x2098_tmp_4 := DontCare
    def x2095_tmp_1 = {io.in_x2095_tmp_1} ; io.in_x2095_tmp_1 := DontCare
    def b564 = {io.in_b564} 
    def x2091_tmp_2 = {io.in_x2091_tmp_2} ; io.in_x2091_tmp_2 := DontCare
    def b2087 = {io.in_b2087} 
  }
  def connectWires0(module: x2269_module)(implicit stack: List[KernelHash]): Unit = {
    x2094_tmp_0.connectLedger(module.io.in_x2094_tmp_0)
    x2090_tmp_1.connectLedger(module.io.in_x2090_tmp_1)
    x2093_tmp_4.connectLedger(module.io.in_x2093_tmp_4)
    module.io.in_x2240_ctrchain.input <> x2240_ctrchain.input; module.io.in_x2240_ctrchain.output <> x2240_ctrchain.output
    x2089_tmp_0.connectLedger(module.io.in_x2089_tmp_0)
    x2176_force_0.connectLedger(module.io.in_x2176_force_0)
    x2097_tmp_3.connectLedger(module.io.in_x2097_tmp_3)
    module.io.in_b2086 <> b2086
    module.io.in_x2239_ctrchain.input <> x2239_ctrchain.input; module.io.in_x2239_ctrchain.output <> x2239_ctrchain.output
    x2096_tmp_2.connectLedger(module.io.in_x2096_tmp_2)
    x2175_force_0.connectLedger(module.io.in_x2175_force_0)
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
  val x2240_ctrchain = list_x2240_ctrchain(0)
  val x2239_ctrchain = list_x2240_ctrchain(1)
  val x2094_tmp_0 = list_x2094_tmp_0(0)
  val x2090_tmp_1 = list_x2094_tmp_0(1)
  val x2093_tmp_4 = list_x2094_tmp_0(2)
  val x2089_tmp_0 = list_x2094_tmp_0(3)
  val x2176_force_0 = list_x2094_tmp_0(4)
  val x2097_tmp_3 = list_x2094_tmp_0(5)
  val x2096_tmp_2 = list_x2094_tmp_0(6)
  val x2175_force_0 = list_x2094_tmp_0(7)
  val x2092_tmp_3 = list_x2094_tmp_0(8)
  val x2098_tmp_4 = list_x2094_tmp_0(9)
  val x2095_tmp_1 = list_x2094_tmp_0(10)
  val x2091_tmp_2 = list_x2094_tmp_0(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2269")
    implicit val stack = ControllerStack.stack.toList
    class x2269_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2269_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2269 = Module(new InstrumentationCounter())
      val iters_x2269 = Module(new InstrumentationCounter())
      cycles_x2269.io.enable := io.sigsIn.baseEn
      iters_x2269.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2269_instrctr, cycles_x2269.io.count, iters_x2269.io.count, 0.U, 0.U)
      val x2254_inr_Foreach = new x2254_inr_Foreach_kernel(List(b2086,b564), List(x2090_tmp_1,x2093_tmp_4,x2089_tmp_0,x2175_force_0,x2092_tmp_3,x2091_tmp_2) ,  Some(me), List(x2239_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2254_inr_Foreach.sm.io.ctrDone := (x2254_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2254_inr_Foreach.backpressure := true.B | x2254_inr_Foreach.sm.io.doneLatch
      x2254_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2254_inr_Foreach.sm.io.doneLatch
      x2254_inr_Foreach.sm.io.enableOut.zip(x2254_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2254_inr_Foreach.sm.io.break := false.B
      x2254_inr_Foreach.mask := ~x2254_inr_Foreach.cchain.head.output.noop & b2086 & b564
      x2254_inr_Foreach.configure("x2254_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2254_inr_Foreach.kernel()
      val x2268_inr_Foreach = new x2268_inr_Foreach_kernel(List(b564,b2087), List(x2094_tmp_0,x2176_force_0,x2097_tmp_3,x2096_tmp_2,x2098_tmp_4,x2095_tmp_1) ,  Some(me), List(x2240_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2268_inr_Foreach.sm.io.ctrDone := (x2268_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2268_inr_Foreach.backpressure := true.B | x2268_inr_Foreach.sm.io.doneLatch
      x2268_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2268_inr_Foreach.sm.io.doneLatch
      x2268_inr_Foreach.sm.io.enableOut.zip(x2268_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2268_inr_Foreach.sm.io.break := false.B
      x2268_inr_Foreach.mask := ~x2268_inr_Foreach.cchain.head.output.noop & b2087 & b564
      x2268_inr_Foreach.configure("x2268_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2268_inr_Foreach.kernel()
      x2089_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2090_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2091_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2092_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2093_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2094_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2095_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2096_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2097_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2098_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2175_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2176_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x2269_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2269 **/
