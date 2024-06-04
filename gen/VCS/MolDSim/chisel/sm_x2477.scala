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

/** Hierarchy: x2477 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2477 **/
class x2477_kernel(
  list_b2295: List[Bool],
  list_x2448_ctrchain: List[CounterChainInterface],
  list_x2306_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2477_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2477_iiCtr"))
  
  abstract class x2477_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2295 = Input(Bool())
      val in_x2306_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2306_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2448_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2448_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b565 = Input(Bool())
      val in_x2301_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2301_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2300_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2300_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2304_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2304_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2383_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2383_force_0_p").asInstanceOf[NBufParams] ))
      val in_x2299_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2299_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2303_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2303_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2298_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2298_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2305_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2305_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2447_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2447_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x2384_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2384_force_0_p").asInstanceOf[NBufParams] ))
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
    def x2448_ctrchain = {io.in_x2448_ctrchain} ; io.in_x2448_ctrchain := DontCare
    def b565 = {io.in_b565} 
    def x2301_tmp_4 = {io.in_x2301_tmp_4} ; io.in_x2301_tmp_4 := DontCare
    def x2300_tmp_3 = {io.in_x2300_tmp_3} ; io.in_x2300_tmp_3 := DontCare
    def x2304_tmp_2 = {io.in_x2304_tmp_2} ; io.in_x2304_tmp_2 := DontCare
    def x2383_force_0 = {io.in_x2383_force_0} ; io.in_x2383_force_0 := DontCare
    def x2299_tmp_2 = {io.in_x2299_tmp_2} ; io.in_x2299_tmp_2 := DontCare
    def x2303_tmp_1 = {io.in_x2303_tmp_1} ; io.in_x2303_tmp_1 := DontCare
    def x2298_tmp_1 = {io.in_x2298_tmp_1} ; io.in_x2298_tmp_1 := DontCare
    def x2305_tmp_3 = {io.in_x2305_tmp_3} ; io.in_x2305_tmp_3 := DontCare
    def x2447_ctrchain = {io.in_x2447_ctrchain} ; io.in_x2447_ctrchain := DontCare
    def x2384_force_0 = {io.in_x2384_force_0} ; io.in_x2384_force_0 := DontCare
    def b2294 = {io.in_b2294} 
    def x2302_tmp_0 = {io.in_x2302_tmp_0} ; io.in_x2302_tmp_0 := DontCare
    def x2297_tmp_0 = {io.in_x2297_tmp_0} ; io.in_x2297_tmp_0 := DontCare
  }
  def connectWires0(module: x2477_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2295 <> b2295
    x2306_tmp_4.connectLedger(module.io.in_x2306_tmp_4)
    module.io.in_x2448_ctrchain.input <> x2448_ctrchain.input; module.io.in_x2448_ctrchain.output <> x2448_ctrchain.output
    module.io.in_b565 <> b565
    x2301_tmp_4.connectLedger(module.io.in_x2301_tmp_4)
    x2300_tmp_3.connectLedger(module.io.in_x2300_tmp_3)
    x2304_tmp_2.connectLedger(module.io.in_x2304_tmp_2)
    x2383_force_0.connectLedger(module.io.in_x2383_force_0)
    x2299_tmp_2.connectLedger(module.io.in_x2299_tmp_2)
    x2303_tmp_1.connectLedger(module.io.in_x2303_tmp_1)
    x2298_tmp_1.connectLedger(module.io.in_x2298_tmp_1)
    x2305_tmp_3.connectLedger(module.io.in_x2305_tmp_3)
    module.io.in_x2447_ctrchain.input <> x2447_ctrchain.input; module.io.in_x2447_ctrchain.output <> x2447_ctrchain.output
    x2384_force_0.connectLedger(module.io.in_x2384_force_0)
    module.io.in_b2294 <> b2294
    x2302_tmp_0.connectLedger(module.io.in_x2302_tmp_0)
    x2297_tmp_0.connectLedger(module.io.in_x2297_tmp_0)
  }
  val b2295 = list_b2295(0)
  val b565 = list_b2295(1)
  val b2294 = list_b2295(2)
  val x2448_ctrchain = list_x2448_ctrchain(0)
  val x2447_ctrchain = list_x2448_ctrchain(1)
  val x2306_tmp_4 = list_x2306_tmp_4(0)
  val x2301_tmp_4 = list_x2306_tmp_4(1)
  val x2300_tmp_3 = list_x2306_tmp_4(2)
  val x2304_tmp_2 = list_x2306_tmp_4(3)
  val x2383_force_0 = list_x2306_tmp_4(4)
  val x2299_tmp_2 = list_x2306_tmp_4(5)
  val x2303_tmp_1 = list_x2306_tmp_4(6)
  val x2298_tmp_1 = list_x2306_tmp_4(7)
  val x2305_tmp_3 = list_x2306_tmp_4(8)
  val x2384_force_0 = list_x2306_tmp_4(9)
  val x2302_tmp_0 = list_x2306_tmp_4(10)
  val x2297_tmp_0 = list_x2306_tmp_4(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2477")
    implicit val stack = ControllerStack.stack.toList
    class x2477_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2477_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2477 = Module(new InstrumentationCounter())
      val iters_x2477 = Module(new InstrumentationCounter())
      cycles_x2477.io.enable := io.sigsIn.baseEn
      iters_x2477.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2477_instrctr, cycles_x2477.io.count, iters_x2477.io.count, 0.U, 0.U)
      val x2462_inr_Foreach = new x2462_inr_Foreach_kernel(List(b565,b2294), List(x2301_tmp_4,x2300_tmp_3,x2383_force_0,x2299_tmp_2,x2298_tmp_1,x2297_tmp_0) ,  Some(me), List(x2447_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2462_inr_Foreach.sm.io.ctrDone := (x2462_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2462_inr_Foreach.backpressure := true.B | x2462_inr_Foreach.sm.io.doneLatch
      x2462_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2462_inr_Foreach.sm.io.doneLatch
      x2462_inr_Foreach.sm.io.enableOut.zip(x2462_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2462_inr_Foreach.sm.io.break := false.B
      x2462_inr_Foreach.mask := ~x2462_inr_Foreach.cchain.head.output.noop & b2294 & b565
      x2462_inr_Foreach.configure("x2462_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2462_inr_Foreach.kernel()
      val x2476_inr_Foreach = new x2476_inr_Foreach_kernel(List(b2295,b565), List(x2306_tmp_4,x2304_tmp_2,x2303_tmp_1,x2305_tmp_3,x2384_force_0,x2302_tmp_0) ,  Some(me), List(x2448_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2476_inr_Foreach.sm.io.ctrDone := (x2476_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2476_inr_Foreach.backpressure := true.B | x2476_inr_Foreach.sm.io.doneLatch
      x2476_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2476_inr_Foreach.sm.io.doneLatch
      x2476_inr_Foreach.sm.io.enableOut.zip(x2476_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2476_inr_Foreach.sm.io.break := false.B
      x2476_inr_Foreach.mask := ~x2476_inr_Foreach.cchain.head.output.noop & b2295 & b565
      x2476_inr_Foreach.configure("x2476_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2476_inr_Foreach.kernel()
      x2297_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2298_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2299_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2300_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2301_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2302_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2303_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2304_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2305_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2306_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x2383_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2384_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x2477_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2477 **/
