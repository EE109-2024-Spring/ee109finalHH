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

/** Hierarchy: x2382 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2382 **/
class x2382_kernel(
  list_b2295: List[Bool],
  list_x2306_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2382_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2382_iiCtr"))
  
  abstract class x2382_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2295 = Input(Bool())
      val in_x2306_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2306_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b565 = Input(Bool())
      val in_x2301_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2301_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2300_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2300_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2304_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2304_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2355_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2355_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2299_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2299_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2303_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2303_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2298_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2298_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2354_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2354_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2305_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2305_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b2294 = Input(Bool())
      val in_x2302_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2302_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2297_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2297_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def b2295 = {io.in_b2295} 
    def x2306_tmp_4 = {io.in_x2306_tmp_4} ; io.in_x2306_tmp_4 := DontCare
    def b565 = {io.in_b565} 
    def x2301_tmp_4 = {io.in_x2301_tmp_4} ; io.in_x2301_tmp_4 := DontCare
    def x2300_tmp_3 = {io.in_x2300_tmp_3} ; io.in_x2300_tmp_3 := DontCare
    def x2304_tmp_2 = {io.in_x2304_tmp_2} ; io.in_x2304_tmp_2 := DontCare
    def x2355_r_0 = {io.in_x2355_r_0} ; io.in_x2355_r_0 := DontCare
    def x2299_tmp_2 = {io.in_x2299_tmp_2} ; io.in_x2299_tmp_2 := DontCare
    def x2303_tmp_1 = {io.in_x2303_tmp_1} ; io.in_x2303_tmp_1 := DontCare
    def x2298_tmp_1 = {io.in_x2298_tmp_1} ; io.in_x2298_tmp_1 := DontCare
    def x2354_r_0 = {io.in_x2354_r_0} ; io.in_x2354_r_0 := DontCare
    def x2305_tmp_3 = {io.in_x2305_tmp_3} ; io.in_x2305_tmp_3 := DontCare
    def b2294 = {io.in_b2294} 
    def x2302_tmp_0 = {io.in_x2302_tmp_0} ; io.in_x2302_tmp_0 := DontCare
    def x2297_tmp_0 = {io.in_x2297_tmp_0} ; io.in_x2297_tmp_0 := DontCare
  }
  def connectWires0(module: x2382_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2295 <> b2295
    x2306_tmp_4.connectLedger(module.io.in_x2306_tmp_4)
    module.io.in_b565 <> b565
    x2301_tmp_4.connectLedger(module.io.in_x2301_tmp_4)
    x2300_tmp_3.connectLedger(module.io.in_x2300_tmp_3)
    x2304_tmp_2.connectLedger(module.io.in_x2304_tmp_2)
    x2355_r_0.connectLedger(module.io.in_x2355_r_0)
    x2299_tmp_2.connectLedger(module.io.in_x2299_tmp_2)
    x2303_tmp_1.connectLedger(module.io.in_x2303_tmp_1)
    x2298_tmp_1.connectLedger(module.io.in_x2298_tmp_1)
    x2354_r_0.connectLedger(module.io.in_x2354_r_0)
    x2305_tmp_3.connectLedger(module.io.in_x2305_tmp_3)
    module.io.in_b2294 <> b2294
    x2302_tmp_0.connectLedger(module.io.in_x2302_tmp_0)
    x2297_tmp_0.connectLedger(module.io.in_x2297_tmp_0)
  }
  val b2295 = list_b2295(0)
  val b565 = list_b2295(1)
  val b2294 = list_b2295(2)
  val x2306_tmp_4 = list_x2306_tmp_4(0)
  val x2301_tmp_4 = list_x2306_tmp_4(1)
  val x2300_tmp_3 = list_x2306_tmp_4(2)
  val x2304_tmp_2 = list_x2306_tmp_4(3)
  val x2355_r_0 = list_x2306_tmp_4(4)
  val x2299_tmp_2 = list_x2306_tmp_4(5)
  val x2303_tmp_1 = list_x2306_tmp_4(6)
  val x2298_tmp_1 = list_x2306_tmp_4(7)
  val x2354_r_0 = list_x2306_tmp_4(8)
  val x2305_tmp_3 = list_x2306_tmp_4(9)
  val x2302_tmp_0 = list_x2306_tmp_4(10)
  val x2297_tmp_0 = list_x2306_tmp_4(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2382")
    implicit val stack = ControllerStack.stack.toList
    class x2382_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2382_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2382 = Module(new InstrumentationCounter())
      val iters_x2382 = Module(new InstrumentationCounter())
      cycles_x2382.io.enable := io.sigsIn.baseEn
      iters_x2382.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2382_instrctr, cycles_x2382.io.count, iters_x2382.io.count, 0.U, 0.U)
      val x2368_inr_UnitPipe = new x2368_inr_UnitPipe_kernel(List(b565,b2294), List(x2299_tmp_2,x2298_tmp_1,x2354_r_0,x2297_tmp_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2368_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2368_inr_UnitPipe.sm.io.ctrInc)
      x2368_inr_UnitPipe.backpressure := true.B | x2368_inr_UnitPipe.sm.io.doneLatch
      x2368_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2368_inr_UnitPipe.sm.io.doneLatch
      x2368_inr_UnitPipe.sm.io.enableOut.zip(x2368_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2368_inr_UnitPipe.sm.io.break := false.B
      x2368_inr_UnitPipe.mask := true.B & b2294 & b565
      x2368_inr_UnitPipe.configure("x2368_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2368_inr_UnitPipe.kernel()
      val x2381_inr_UnitPipe = new x2381_inr_UnitPipe_kernel(List(b2295,b565), List(x2304_tmp_2,x2355_r_0,x2303_tmp_1,x2302_tmp_0) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2381_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2381_inr_UnitPipe.sm.io.ctrInc)
      x2381_inr_UnitPipe.backpressure := true.B | x2381_inr_UnitPipe.sm.io.doneLatch
      x2381_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2381_inr_UnitPipe.sm.io.doneLatch
      x2381_inr_UnitPipe.sm.io.enableOut.zip(x2381_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2381_inr_UnitPipe.sm.io.break := false.B
      x2381_inr_UnitPipe.mask := true.B & b2295 & b565
      x2381_inr_UnitPipe.configure("x2381_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2381_inr_UnitPipe.kernel()
      x2297_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2298_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2299_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2300_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2301_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2302_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2303_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2304_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2305_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2306_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2354_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2355_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x2382_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2382 **/
