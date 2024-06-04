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

/** Hierarchy: x2199 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2199 **/
class x2199_kernel(
  list_b2086: List[Bool],
  list_x2094_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2199_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2199_iiCtr"))
  
  abstract class x2199_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2094_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2094_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2146_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2146_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2178_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2178_reg_p").asInstanceOf[NBufParams] ))
      val in_x2090_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2090_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2093_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2093_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2147_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2147_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2179_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2179_reg_p").asInstanceOf[NBufParams] ))
      val in_x2089_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2089_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2097_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2097_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2180_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2180_reg_p").asInstanceOf[NBufParams] ))
      val in_b2086 = Input(Bool())
      val in_x2096_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2096_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2092_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2092_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2098_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2098_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2095_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2095_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b564 = Input(Bool())
      val in_x2091_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2091_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b2087 = Input(Bool())
      val in_x2177_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2177_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x2094_tmp_0 = {io.in_x2094_tmp_0} ; io.in_x2094_tmp_0 := DontCare
    def x2146_r_0 = {io.in_x2146_r_0} ; io.in_x2146_r_0 := DontCare
    def x2178_reg = {io.in_x2178_reg} ; io.in_x2178_reg := DontCare
    def x2090_tmp_1 = {io.in_x2090_tmp_1} ; io.in_x2090_tmp_1 := DontCare
    def x2093_tmp_4 = {io.in_x2093_tmp_4} ; io.in_x2093_tmp_4 := DontCare
    def x2147_r_0 = {io.in_x2147_r_0} ; io.in_x2147_r_0 := DontCare
    def x2179_reg = {io.in_x2179_reg} ; io.in_x2179_reg := DontCare
    def x2089_tmp_0 = {io.in_x2089_tmp_0} ; io.in_x2089_tmp_0 := DontCare
    def x2097_tmp_3 = {io.in_x2097_tmp_3} ; io.in_x2097_tmp_3 := DontCare
    def x2180_reg = {io.in_x2180_reg} ; io.in_x2180_reg := DontCare
    def b2086 = {io.in_b2086} 
    def x2096_tmp_2 = {io.in_x2096_tmp_2} ; io.in_x2096_tmp_2 := DontCare
    def x2092_tmp_3 = {io.in_x2092_tmp_3} ; io.in_x2092_tmp_3 := DontCare
    def x2098_tmp_4 = {io.in_x2098_tmp_4} ; io.in_x2098_tmp_4 := DontCare
    def x2095_tmp_1 = {io.in_x2095_tmp_1} ; io.in_x2095_tmp_1 := DontCare
    def b564 = {io.in_b564} 
    def x2091_tmp_2 = {io.in_x2091_tmp_2} ; io.in_x2091_tmp_2 := DontCare
    def b2087 = {io.in_b2087} 
    def x2177_reg = {io.in_x2177_reg} ; io.in_x2177_reg := DontCare
  }
  def connectWires0(module: x2199_module)(implicit stack: List[KernelHash]): Unit = {
    x2094_tmp_0.connectLedger(module.io.in_x2094_tmp_0)
    x2146_r_0.connectLedger(module.io.in_x2146_r_0)
    x2178_reg.connectLedger(module.io.in_x2178_reg)
    x2090_tmp_1.connectLedger(module.io.in_x2090_tmp_1)
    x2093_tmp_4.connectLedger(module.io.in_x2093_tmp_4)
    x2147_r_0.connectLedger(module.io.in_x2147_r_0)
    x2179_reg.connectLedger(module.io.in_x2179_reg)
    x2089_tmp_0.connectLedger(module.io.in_x2089_tmp_0)
    x2097_tmp_3.connectLedger(module.io.in_x2097_tmp_3)
    x2180_reg.connectLedger(module.io.in_x2180_reg)
    module.io.in_b2086 <> b2086
    x2096_tmp_2.connectLedger(module.io.in_x2096_tmp_2)
    x2092_tmp_3.connectLedger(module.io.in_x2092_tmp_3)
    x2098_tmp_4.connectLedger(module.io.in_x2098_tmp_4)
    x2095_tmp_1.connectLedger(module.io.in_x2095_tmp_1)
    module.io.in_b564 <> b564
    x2091_tmp_2.connectLedger(module.io.in_x2091_tmp_2)
    module.io.in_b2087 <> b2087
    x2177_reg.connectLedger(module.io.in_x2177_reg)
  }
  val b2086 = list_b2086(0)
  val b564 = list_b2086(1)
  val b2087 = list_b2086(2)
  val x2094_tmp_0 = list_x2094_tmp_0(0)
  val x2146_r_0 = list_x2094_tmp_0(1)
  val x2178_reg = list_x2094_tmp_0(2)
  val x2090_tmp_1 = list_x2094_tmp_0(3)
  val x2093_tmp_4 = list_x2094_tmp_0(4)
  val x2147_r_0 = list_x2094_tmp_0(5)
  val x2179_reg = list_x2094_tmp_0(6)
  val x2089_tmp_0 = list_x2094_tmp_0(7)
  val x2097_tmp_3 = list_x2094_tmp_0(8)
  val x2180_reg = list_x2094_tmp_0(9)
  val x2096_tmp_2 = list_x2094_tmp_0(10)
  val x2092_tmp_3 = list_x2094_tmp_0(11)
  val x2098_tmp_4 = list_x2094_tmp_0(12)
  val x2095_tmp_1 = list_x2094_tmp_0(13)
  val x2091_tmp_2 = list_x2094_tmp_0(14)
  val x2177_reg = list_x2094_tmp_0(15)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2199")
    implicit val stack = ControllerStack.stack.toList
    class x2199_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2199_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2199 = Module(new InstrumentationCounter())
      val iters_x2199 = Module(new InstrumentationCounter())
      cycles_x2199.io.enable := io.sigsIn.baseEn
      iters_x2199.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2199_instrctr, cycles_x2199.io.count, iters_x2199.io.count, 0.U, 0.U)
      val x2189_inr_UnitPipe = new x2189_inr_UnitPipe_kernel(List(b2086,b564), List(x2146_r_0,x2179_reg,x2177_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2189_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2189_inr_UnitPipe.sm.io.ctrInc)
      x2189_inr_UnitPipe.backpressure := true.B | x2189_inr_UnitPipe.sm.io.doneLatch
      x2189_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2189_inr_UnitPipe.sm.io.doneLatch
      x2189_inr_UnitPipe.sm.io.enableOut.zip(x2189_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2189_inr_UnitPipe.sm.io.break := false.B
      x2189_inr_UnitPipe.mask := true.B & b2086 & b564
      x2189_inr_UnitPipe.configure("x2189_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2189_inr_UnitPipe.kernel()
      val x2198_inr_UnitPipe = new x2198_inr_UnitPipe_kernel(List(b564,b2087), List(x2178_reg,x2147_r_0,x2180_reg) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2198_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2198_inr_UnitPipe.sm.io.ctrInc)
      x2198_inr_UnitPipe.backpressure := true.B | x2198_inr_UnitPipe.sm.io.doneLatch
      x2198_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2198_inr_UnitPipe.sm.io.doneLatch
      x2198_inr_UnitPipe.sm.io.enableOut.zip(x2198_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2198_inr_UnitPipe.sm.io.break := false.B
      x2198_inr_UnitPipe.mask := true.B & b2087 & b564
      x2198_inr_UnitPipe.configure("x2198_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2198_inr_UnitPipe.kernel()
      x2089_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2090_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2091_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2092_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2093_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2094_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2095_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2096_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2097_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2098_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2146_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2147_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2177_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2178_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2179_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2180_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x2199_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2199 **/
