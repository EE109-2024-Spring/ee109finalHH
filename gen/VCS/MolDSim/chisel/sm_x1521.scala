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

/** Hierarchy: x1521 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1521 **/
class x1521_kernel(
  list_x1478_ctrchain: List[CounterChainInterface],
  list_b551: List[FixedPoint],
  list_x1469_tmp_4: List[NBufInterface],
  list_b1462: List[Bool],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1521_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1521_iiCtr"))
  
  abstract class x1521_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1469_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1469_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b1462 = Input(Bool())
      val in_x1465_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1465_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1470_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1470_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_b551 = Input(new FixedPoint(true, 32, 0))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1478_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1478_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x1466_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1466_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1471_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1471_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b1460 = Input(new FixedPoint(true, 32, 0))
      val in_x1474_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1474_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1477_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1477_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x1467_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1467_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1472_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1472_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1459 = Input(new FixedPoint(true, 32, 0))
      val in_x1473_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1473_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b1463 = Input(Bool())
      val in_x1468_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1468_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x1469_tmp_4 = {io.in_x1469_tmp_4} ; io.in_x1469_tmp_4 := DontCare
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b1462 = {io.in_b1462} 
    def x1465_tmp_0 = {io.in_x1465_tmp_0} ; io.in_x1465_tmp_0 := DontCare
    def x1470_tmp_0 = {io.in_x1470_tmp_0} ; io.in_x1470_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def b551 = {io.in_b551} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1478_ctrchain = {io.in_x1478_ctrchain} ; io.in_x1478_ctrchain := DontCare
    def x1466_tmp_1 = {io.in_x1466_tmp_1} ; io.in_x1466_tmp_1 := DontCare
    def x1471_tmp_1 = {io.in_x1471_tmp_1} ; io.in_x1471_tmp_1 := DontCare
    def b1460 = {io.in_b1460} 
    def x1474_tmp_4 = {io.in_x1474_tmp_4} ; io.in_x1474_tmp_4 := DontCare
    def x1477_ctrchain = {io.in_x1477_ctrchain} ; io.in_x1477_ctrchain := DontCare
    def x1467_tmp_2 = {io.in_x1467_tmp_2} ; io.in_x1467_tmp_2 := DontCare
    def x1472_tmp_2 = {io.in_x1472_tmp_2} ; io.in_x1472_tmp_2 := DontCare
    def b1459 = {io.in_b1459} 
    def x1473_tmp_3 = {io.in_x1473_tmp_3} ; io.in_x1473_tmp_3 := DontCare
    def b1463 = {io.in_b1463} 
    def x1468_tmp_3 = {io.in_x1468_tmp_3} ; io.in_x1468_tmp_3 := DontCare
  }
  def connectWires0(module: x1521_module)(implicit stack: List[KernelHash]): Unit = {
    x1469_tmp_4.connectLedger(module.io.in_x1469_tmp_4)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b1462 <> b1462
    x1465_tmp_0.connectLedger(module.io.in_x1465_tmp_0)
    x1470_tmp_0.connectLedger(module.io.in_x1470_tmp_0)
    module.io.in_b561 <> b561
    module.io.in_b551 <> b551
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_x1478_ctrchain.input <> x1478_ctrchain.input; module.io.in_x1478_ctrchain.output <> x1478_ctrchain.output
    x1466_tmp_1.connectLedger(module.io.in_x1466_tmp_1)
    x1471_tmp_1.connectLedger(module.io.in_x1471_tmp_1)
    module.io.in_b1460 <> b1460
    x1474_tmp_4.connectLedger(module.io.in_x1474_tmp_4)
    module.io.in_x1477_ctrchain.input <> x1477_ctrchain.input; module.io.in_x1477_ctrchain.output <> x1477_ctrchain.output
    x1467_tmp_2.connectLedger(module.io.in_x1467_tmp_2)
    x1472_tmp_2.connectLedger(module.io.in_x1472_tmp_2)
    module.io.in_b1459 <> b1459
    x1473_tmp_3.connectLedger(module.io.in_x1473_tmp_3)
    module.io.in_b1463 <> b1463
    x1468_tmp_3.connectLedger(module.io.in_x1468_tmp_3)
  }
  val x1478_ctrchain = list_x1478_ctrchain(0)
  val x1477_ctrchain = list_x1478_ctrchain(1)
  val b551 = list_b551(0)
  val b1460 = list_b551(1)
  val b1459 = list_b551(2)
  val x1469_tmp_4 = list_x1469_tmp_4(0)
  val x1465_tmp_0 = list_x1469_tmp_4(1)
  val x1470_tmp_0 = list_x1469_tmp_4(2)
  val x1466_tmp_1 = list_x1469_tmp_4(3)
  val x1471_tmp_1 = list_x1469_tmp_4(4)
  val x1474_tmp_4 = list_x1469_tmp_4(5)
  val x1467_tmp_2 = list_x1469_tmp_4(6)
  val x1472_tmp_2 = list_x1469_tmp_4(7)
  val x1473_tmp_3 = list_x1469_tmp_4(8)
  val x1468_tmp_3 = list_x1469_tmp_4(9)
  val b1462 = list_b1462(0)
  val b561 = list_b1462(1)
  val b1463 = list_b1462(2)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1521")
    implicit val stack = ControllerStack.stack.toList
    class x1521_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1521_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1521 = Module(new InstrumentationCounter())
      val iters_x1521 = Module(new InstrumentationCounter())
      cycles_x1521.io.enable := io.sigsIn.baseEn
      iters_x1521.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1521_instrctr, cycles_x1521.io.count, iters_x1521.io.count, 0.U, 0.U)
      val x1499_inr_Foreach = new x1499_inr_Foreach_kernel(List(b1462,b561), List(b551,b1459), List(x472_A_sram_1,x471_A_sram_0), List(x1469_tmp_4,x1465_tmp_0,x1466_tmp_1,x1467_tmp_2,x1468_tmp_3) ,  Some(me), List(x1477_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1499_inr_Foreach.sm.io.ctrDone := (x1499_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1499_inr_Foreach.backpressure := true.B | x1499_inr_Foreach.sm.io.doneLatch
      x1499_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1499_inr_Foreach.sm.io.doneLatch
      x1499_inr_Foreach.sm.io.enableOut.zip(x1499_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1499_inr_Foreach.sm.io.break := false.B
      x1499_inr_Foreach.mask := ~x1499_inr_Foreach.cchain.head.output.noop & b1462 & b561
      x1499_inr_Foreach.configure("x1499_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1499_inr_Foreach.kernel()
      val x1520_inr_Foreach = new x1520_inr_Foreach_kernel(List(b561,b1463), List(b551,b1460), List(x1470_tmp_0,x1471_tmp_1,x1474_tmp_4,x1472_tmp_2,x1473_tmp_3), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x1478_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1520_inr_Foreach.sm.io.ctrDone := (x1520_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1520_inr_Foreach.backpressure := true.B | x1520_inr_Foreach.sm.io.doneLatch
      x1520_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1520_inr_Foreach.sm.io.doneLatch
      x1520_inr_Foreach.sm.io.enableOut.zip(x1520_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1520_inr_Foreach.sm.io.break := false.B
      x1520_inr_Foreach.mask := ~x1520_inr_Foreach.cchain.head.output.noop & b1463 & b561
      x1520_inr_Foreach.configure("x1520_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1520_inr_Foreach.kernel()
      x1465_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1466_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1467_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1468_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1469_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1470_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1471_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1472_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1473_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1474_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1521_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1521 **/
