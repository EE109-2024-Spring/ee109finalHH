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

/** Hierarchy: x1645 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1645 **/
class x1645_kernel(
  list_b1462: List[Bool],
  list_x1616_ctrchain: List[CounterChainInterface],
  list_x1469_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1645_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1645_iiCtr"))
  
  abstract class x1645_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1469_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1469_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1462 = Input(Bool())
      val in_x1465_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1465_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1470_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1470_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_x1552_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1552_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1466_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1466_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1616_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1616_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x1615_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1615_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x1471_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1471_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1474_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1474_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1467_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1467_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1472_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1472_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1551_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1551_force_0_p").asInstanceOf[NBufParams] ))
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
    def b1462 = {io.in_b1462} 
    def x1465_tmp_0 = {io.in_x1465_tmp_0} ; io.in_x1465_tmp_0 := DontCare
    def x1470_tmp_0 = {io.in_x1470_tmp_0} ; io.in_x1470_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def x1552_force_0 = {io.in_x1552_force_0} ; io.in_x1552_force_0 := DontCare
    def x1466_tmp_1 = {io.in_x1466_tmp_1} ; io.in_x1466_tmp_1 := DontCare
    def x1616_ctrchain = {io.in_x1616_ctrchain} ; io.in_x1616_ctrchain := DontCare
    def x1615_ctrchain = {io.in_x1615_ctrchain} ; io.in_x1615_ctrchain := DontCare
    def x1471_tmp_1 = {io.in_x1471_tmp_1} ; io.in_x1471_tmp_1 := DontCare
    def x1474_tmp_4 = {io.in_x1474_tmp_4} ; io.in_x1474_tmp_4 := DontCare
    def x1467_tmp_2 = {io.in_x1467_tmp_2} ; io.in_x1467_tmp_2 := DontCare
    def x1472_tmp_2 = {io.in_x1472_tmp_2} ; io.in_x1472_tmp_2 := DontCare
    def x1551_force_0 = {io.in_x1551_force_0} ; io.in_x1551_force_0 := DontCare
    def x1473_tmp_3 = {io.in_x1473_tmp_3} ; io.in_x1473_tmp_3 := DontCare
    def b1463 = {io.in_b1463} 
    def x1468_tmp_3 = {io.in_x1468_tmp_3} ; io.in_x1468_tmp_3 := DontCare
  }
  def connectWires0(module: x1645_module)(implicit stack: List[KernelHash]): Unit = {
    x1469_tmp_4.connectLedger(module.io.in_x1469_tmp_4)
    module.io.in_b1462 <> b1462
    x1465_tmp_0.connectLedger(module.io.in_x1465_tmp_0)
    x1470_tmp_0.connectLedger(module.io.in_x1470_tmp_0)
    module.io.in_b561 <> b561
    x1552_force_0.connectLedger(module.io.in_x1552_force_0)
    x1466_tmp_1.connectLedger(module.io.in_x1466_tmp_1)
    module.io.in_x1616_ctrchain.input <> x1616_ctrchain.input; module.io.in_x1616_ctrchain.output <> x1616_ctrchain.output
    module.io.in_x1615_ctrchain.input <> x1615_ctrchain.input; module.io.in_x1615_ctrchain.output <> x1615_ctrchain.output
    x1471_tmp_1.connectLedger(module.io.in_x1471_tmp_1)
    x1474_tmp_4.connectLedger(module.io.in_x1474_tmp_4)
    x1467_tmp_2.connectLedger(module.io.in_x1467_tmp_2)
    x1472_tmp_2.connectLedger(module.io.in_x1472_tmp_2)
    x1551_force_0.connectLedger(module.io.in_x1551_force_0)
    x1473_tmp_3.connectLedger(module.io.in_x1473_tmp_3)
    module.io.in_b1463 <> b1463
    x1468_tmp_3.connectLedger(module.io.in_x1468_tmp_3)
  }
  val b1462 = list_b1462(0)
  val b561 = list_b1462(1)
  val b1463 = list_b1462(2)
  val x1616_ctrchain = list_x1616_ctrchain(0)
  val x1615_ctrchain = list_x1616_ctrchain(1)
  val x1469_tmp_4 = list_x1469_tmp_4(0)
  val x1465_tmp_0 = list_x1469_tmp_4(1)
  val x1470_tmp_0 = list_x1469_tmp_4(2)
  val x1552_force_0 = list_x1469_tmp_4(3)
  val x1466_tmp_1 = list_x1469_tmp_4(4)
  val x1471_tmp_1 = list_x1469_tmp_4(5)
  val x1474_tmp_4 = list_x1469_tmp_4(6)
  val x1467_tmp_2 = list_x1469_tmp_4(7)
  val x1472_tmp_2 = list_x1469_tmp_4(8)
  val x1551_force_0 = list_x1469_tmp_4(9)
  val x1473_tmp_3 = list_x1469_tmp_4(10)
  val x1468_tmp_3 = list_x1469_tmp_4(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1645")
    implicit val stack = ControllerStack.stack.toList
    class x1645_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1645_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1645 = Module(new InstrumentationCounter())
      val iters_x1645 = Module(new InstrumentationCounter())
      cycles_x1645.io.enable := io.sigsIn.baseEn
      iters_x1645.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1645_instrctr, cycles_x1645.io.count, iters_x1645.io.count, 0.U, 0.U)
      val x1630_inr_Foreach = new x1630_inr_Foreach_kernel(List(b1462,b561), List(x1469_tmp_4,x1465_tmp_0,x1466_tmp_1,x1467_tmp_2,x1551_force_0,x1468_tmp_3) ,  Some(me), List(x1615_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1630_inr_Foreach.sm.io.ctrDone := (x1630_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1630_inr_Foreach.backpressure := true.B | x1630_inr_Foreach.sm.io.doneLatch
      x1630_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1630_inr_Foreach.sm.io.doneLatch
      x1630_inr_Foreach.sm.io.enableOut.zip(x1630_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1630_inr_Foreach.sm.io.break := false.B
      x1630_inr_Foreach.mask := ~x1630_inr_Foreach.cchain.head.output.noop & b1462 & b561
      x1630_inr_Foreach.configure("x1630_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1630_inr_Foreach.kernel()
      val x1644_inr_Foreach = new x1644_inr_Foreach_kernel(List(b561,b1463), List(x1470_tmp_0,x1552_force_0,x1471_tmp_1,x1474_tmp_4,x1472_tmp_2,x1473_tmp_3) ,  Some(me), List(x1616_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1644_inr_Foreach.sm.io.ctrDone := (x1644_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1644_inr_Foreach.backpressure := true.B | x1644_inr_Foreach.sm.io.doneLatch
      x1644_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1644_inr_Foreach.sm.io.doneLatch
      x1644_inr_Foreach.sm.io.enableOut.zip(x1644_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1644_inr_Foreach.sm.io.break := false.B
      x1644_inr_Foreach.mask := ~x1644_inr_Foreach.cchain.head.output.noop & b1463 & b561
      x1644_inr_Foreach.configure("x1644_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1644_inr_Foreach.kernel()
      x1465_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1466_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1467_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1468_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1469_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1470_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1471_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1472_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1473_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1474_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1551_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1552_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x1645_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1645 **/
