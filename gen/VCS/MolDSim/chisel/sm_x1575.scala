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

/** Hierarchy: x1575 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1575 **/
class x1575_kernel(
  list_b1462: List[Bool],
  list_x1469_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1575_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1575_iiCtr"))
  
  abstract class x1575_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1469_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1469_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1554_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1554_reg_p").asInstanceOf[NBufParams] ))
      val in_x1522_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1522_r_0_p").asInstanceOf[NBufParams] ))
      val in_b1462 = Input(Bool())
      val in_x1465_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1465_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1470_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1470_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_x1555_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1555_reg_p").asInstanceOf[NBufParams] ))
      val in_x1466_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1466_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1471_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1471_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1556_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1556_reg_p").asInstanceOf[NBufParams] ))
      val in_x1474_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1474_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1467_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1467_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1472_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1472_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1553_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1553_reg_p").asInstanceOf[NBufParams] ))
      val in_x1523_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1523_r_0_p").asInstanceOf[NBufParams] ))
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
    def x1554_reg = {io.in_x1554_reg} ; io.in_x1554_reg := DontCare
    def x1522_r_0 = {io.in_x1522_r_0} ; io.in_x1522_r_0 := DontCare
    def b1462 = {io.in_b1462} 
    def x1465_tmp_0 = {io.in_x1465_tmp_0} ; io.in_x1465_tmp_0 := DontCare
    def x1470_tmp_0 = {io.in_x1470_tmp_0} ; io.in_x1470_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def x1555_reg = {io.in_x1555_reg} ; io.in_x1555_reg := DontCare
    def x1466_tmp_1 = {io.in_x1466_tmp_1} ; io.in_x1466_tmp_1 := DontCare
    def x1471_tmp_1 = {io.in_x1471_tmp_1} ; io.in_x1471_tmp_1 := DontCare
    def x1556_reg = {io.in_x1556_reg} ; io.in_x1556_reg := DontCare
    def x1474_tmp_4 = {io.in_x1474_tmp_4} ; io.in_x1474_tmp_4 := DontCare
    def x1467_tmp_2 = {io.in_x1467_tmp_2} ; io.in_x1467_tmp_2 := DontCare
    def x1472_tmp_2 = {io.in_x1472_tmp_2} ; io.in_x1472_tmp_2 := DontCare
    def x1553_reg = {io.in_x1553_reg} ; io.in_x1553_reg := DontCare
    def x1523_r_0 = {io.in_x1523_r_0} ; io.in_x1523_r_0 := DontCare
    def x1473_tmp_3 = {io.in_x1473_tmp_3} ; io.in_x1473_tmp_3 := DontCare
    def b1463 = {io.in_b1463} 
    def x1468_tmp_3 = {io.in_x1468_tmp_3} ; io.in_x1468_tmp_3 := DontCare
  }
  def connectWires0(module: x1575_module)(implicit stack: List[KernelHash]): Unit = {
    x1469_tmp_4.connectLedger(module.io.in_x1469_tmp_4)
    x1554_reg.connectLedger(module.io.in_x1554_reg)
    x1522_r_0.connectLedger(module.io.in_x1522_r_0)
    module.io.in_b1462 <> b1462
    x1465_tmp_0.connectLedger(module.io.in_x1465_tmp_0)
    x1470_tmp_0.connectLedger(module.io.in_x1470_tmp_0)
    module.io.in_b561 <> b561
    x1555_reg.connectLedger(module.io.in_x1555_reg)
    x1466_tmp_1.connectLedger(module.io.in_x1466_tmp_1)
    x1471_tmp_1.connectLedger(module.io.in_x1471_tmp_1)
    x1556_reg.connectLedger(module.io.in_x1556_reg)
    x1474_tmp_4.connectLedger(module.io.in_x1474_tmp_4)
    x1467_tmp_2.connectLedger(module.io.in_x1467_tmp_2)
    x1472_tmp_2.connectLedger(module.io.in_x1472_tmp_2)
    x1553_reg.connectLedger(module.io.in_x1553_reg)
    x1523_r_0.connectLedger(module.io.in_x1523_r_0)
    x1473_tmp_3.connectLedger(module.io.in_x1473_tmp_3)
    module.io.in_b1463 <> b1463
    x1468_tmp_3.connectLedger(module.io.in_x1468_tmp_3)
  }
  val b1462 = list_b1462(0)
  val b561 = list_b1462(1)
  val b1463 = list_b1462(2)
  val x1469_tmp_4 = list_x1469_tmp_4(0)
  val x1554_reg = list_x1469_tmp_4(1)
  val x1522_r_0 = list_x1469_tmp_4(2)
  val x1465_tmp_0 = list_x1469_tmp_4(3)
  val x1470_tmp_0 = list_x1469_tmp_4(4)
  val x1555_reg = list_x1469_tmp_4(5)
  val x1466_tmp_1 = list_x1469_tmp_4(6)
  val x1471_tmp_1 = list_x1469_tmp_4(7)
  val x1556_reg = list_x1469_tmp_4(8)
  val x1474_tmp_4 = list_x1469_tmp_4(9)
  val x1467_tmp_2 = list_x1469_tmp_4(10)
  val x1472_tmp_2 = list_x1469_tmp_4(11)
  val x1553_reg = list_x1469_tmp_4(12)
  val x1523_r_0 = list_x1469_tmp_4(13)
  val x1473_tmp_3 = list_x1469_tmp_4(14)
  val x1468_tmp_3 = list_x1469_tmp_4(15)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1575")
    implicit val stack = ControllerStack.stack.toList
    class x1575_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1575_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1575 = Module(new InstrumentationCounter())
      val iters_x1575 = Module(new InstrumentationCounter())
      cycles_x1575.io.enable := io.sigsIn.baseEn
      iters_x1575.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1575_instrctr, cycles_x1575.io.count, iters_x1575.io.count, 0.U, 0.U)
      val x1565_inr_UnitPipe = new x1565_inr_UnitPipe_kernel(List(b1462,b561), List(x1522_r_0,x1555_reg,x1553_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1565_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1565_inr_UnitPipe.sm.io.ctrInc)
      x1565_inr_UnitPipe.backpressure := true.B | x1565_inr_UnitPipe.sm.io.doneLatch
      x1565_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1565_inr_UnitPipe.sm.io.doneLatch
      x1565_inr_UnitPipe.sm.io.enableOut.zip(x1565_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1565_inr_UnitPipe.sm.io.break := false.B
      x1565_inr_UnitPipe.mask := true.B & b1462 & b561
      x1565_inr_UnitPipe.configure("x1565_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1565_inr_UnitPipe.kernel()
      val x1574_inr_UnitPipe = new x1574_inr_UnitPipe_kernel(List(b561,b1463), List(x1554_reg,x1556_reg,x1523_r_0) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1574_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1574_inr_UnitPipe.sm.io.ctrInc)
      x1574_inr_UnitPipe.backpressure := true.B | x1574_inr_UnitPipe.sm.io.doneLatch
      x1574_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1574_inr_UnitPipe.sm.io.doneLatch
      x1574_inr_UnitPipe.sm.io.enableOut.zip(x1574_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1574_inr_UnitPipe.sm.io.break := false.B
      x1574_inr_UnitPipe.mask := true.B & b1463 & b561
      x1574_inr_UnitPipe.configure("x1574_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1574_inr_UnitPipe.kernel()
      x1465_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1466_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1467_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1468_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1469_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1470_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1471_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1472_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1473_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1474_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1522_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1523_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1553_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1554_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1555_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1556_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1575_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1575 **/
