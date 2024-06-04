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

/** Hierarchy: x1593 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1593_inr_Switch **/
class x1593_inr_Switch_kernel(
  list_x2943_rd_x1553: List[Bool],
  list_x1469_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x1593_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1593_inr_Switch_iiCtr"))
  
  abstract class x1593_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1469_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1469_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1554_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1554_reg_p").asInstanceOf[NBufParams] ))
      val in_x1522_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1522_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1465_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1465_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1470_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1470_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1555_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1555_reg_p").asInstanceOf[NBufParams] ))
      val in_x1466_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1466_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2943_rd_x1553 = Input(Bool())
      val in_x1471_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1471_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1556_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1556_reg_p").asInstanceOf[NBufParams] ))
      val in_x1474_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1474_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1467_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1467_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1472_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1472_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1553_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1553_reg_p").asInstanceOf[NBufParams] ))
      val in_x1523_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1523_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2944_rd_x1555 = Input(Bool())
      val in_x1473_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1473_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1468_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1468_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1469_tmp_4 = {io.in_x1469_tmp_4} ; io.in_x1469_tmp_4 := DontCare
    def x1554_reg = {io.in_x1554_reg} ; io.in_x1554_reg := DontCare
    def x1522_r_0 = {io.in_x1522_r_0} ; io.in_x1522_r_0 := DontCare
    def x1465_tmp_0 = {io.in_x1465_tmp_0} ; io.in_x1465_tmp_0 := DontCare
    def x1470_tmp_0 = {io.in_x1470_tmp_0} ; io.in_x1470_tmp_0 := DontCare
    def x1555_reg = {io.in_x1555_reg} ; io.in_x1555_reg := DontCare
    def x1466_tmp_1 = {io.in_x1466_tmp_1} ; io.in_x1466_tmp_1 := DontCare
    def x2943_rd_x1553 = {io.in_x2943_rd_x1553} 
    def x1471_tmp_1 = {io.in_x1471_tmp_1} ; io.in_x1471_tmp_1 := DontCare
    def x1556_reg = {io.in_x1556_reg} ; io.in_x1556_reg := DontCare
    def x1474_tmp_4 = {io.in_x1474_tmp_4} ; io.in_x1474_tmp_4 := DontCare
    def x1467_tmp_2 = {io.in_x1467_tmp_2} ; io.in_x1467_tmp_2 := DontCare
    def x1472_tmp_2 = {io.in_x1472_tmp_2} ; io.in_x1472_tmp_2 := DontCare
    def x1553_reg = {io.in_x1553_reg} ; io.in_x1553_reg := DontCare
    def x1523_r_0 = {io.in_x1523_r_0} ; io.in_x1523_r_0 := DontCare
    def x2944_rd_x1555 = {io.in_x2944_rd_x1555} 
    def x1473_tmp_3 = {io.in_x1473_tmp_3} ; io.in_x1473_tmp_3 := DontCare
    def x1468_tmp_3 = {io.in_x1468_tmp_3} ; io.in_x1468_tmp_3 := DontCare
  }
  def connectWires0(module: x1593_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x1469_tmp_4.connectLedger(module.io.in_x1469_tmp_4)
    x1554_reg.connectLedger(module.io.in_x1554_reg)
    x1522_r_0.connectLedger(module.io.in_x1522_r_0)
    x1465_tmp_0.connectLedger(module.io.in_x1465_tmp_0)
    x1470_tmp_0.connectLedger(module.io.in_x1470_tmp_0)
    x1555_reg.connectLedger(module.io.in_x1555_reg)
    x1466_tmp_1.connectLedger(module.io.in_x1466_tmp_1)
    module.io.in_x2943_rd_x1553 <> x2943_rd_x1553
    x1471_tmp_1.connectLedger(module.io.in_x1471_tmp_1)
    x1556_reg.connectLedger(module.io.in_x1556_reg)
    x1474_tmp_4.connectLedger(module.io.in_x1474_tmp_4)
    x1467_tmp_2.connectLedger(module.io.in_x1467_tmp_2)
    x1472_tmp_2.connectLedger(module.io.in_x1472_tmp_2)
    x1553_reg.connectLedger(module.io.in_x1553_reg)
    x1523_r_0.connectLedger(module.io.in_x1523_r_0)
    module.io.in_x2944_rd_x1555 <> x2944_rd_x1555
    x1473_tmp_3.connectLedger(module.io.in_x1473_tmp_3)
    x1468_tmp_3.connectLedger(module.io.in_x1468_tmp_3)
  }
  val x2943_rd_x1553 = list_x2943_rd_x1553(0)
  val x2944_rd_x1555 = list_x2943_rd_x1553(1)
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
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1593_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1593_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1593_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1593_inr_Switch = Module(new InstrumentationCounter())
      val iters_x1593_inr_Switch = Module(new InstrumentationCounter())
      cycles_x1593_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x1593_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1593_instrctr, cycles_x1593_inr_Switch.io.count, iters_x1593_inr_Switch.io.count, 0.U, 0.U)
      val x1591_inr_SwitchCase_obj = new x1591_inr_SwitchCase_kernel(List(x1522_r_0,x1553_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1591_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1591_inr_SwitchCase_obj.childId)
      x1591_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1591_inr_SwitchCase_obj.sm.io.ctrInc)
      x1591_inr_SwitchCase_obj.backpressure := true.B | x1591_inr_SwitchCase_obj.sm.io.doneLatch
      x1591_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1591_inr_SwitchCase_obj.sm.io.doneLatch
      x1591_inr_SwitchCase_obj.sm.io.enableOut.zip(x1591_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1591_inr_SwitchCase_obj.sm.io.break := false.B
      val x1591_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1591_inr_SwitchCase""")
      x1591_inr_SwitchCase_obj.mask := true.B & true.B
      x1591_inr_SwitchCase_obj.configure("x1591_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1591_inr_SwitchCase.r := x1591_inr_SwitchCase_obj.kernel().r
      val x1592_inr_SwitchCase_obj = new x1592_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1592_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1592_inr_SwitchCase_obj.childId)
      x1592_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1592_inr_SwitchCase_obj.sm.io.ctrInc)
      x1592_inr_SwitchCase_obj.backpressure := true.B | x1592_inr_SwitchCase_obj.sm.io.doneLatch
      x1592_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1592_inr_SwitchCase_obj.sm.io.doneLatch
      x1592_inr_SwitchCase_obj.sm.io.enableOut.zip(x1592_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1592_inr_SwitchCase_obj.sm.io.break := false.B
      val x1592_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1592_inr_SwitchCase""")
      x1592_inr_SwitchCase_obj.mask := true.B & true.B
      x1592_inr_SwitchCase_obj.configure("x1592_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1592_inr_SwitchCase.r := x1592_inr_SwitchCase_obj.kernel().r
      val x1593_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x1593_inr_Switch_onehot_selects""")
      val x1593_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x1593_inr_Switch_data_options""")
      x1593_inr_Switch_onehot_selects(0) := x2943_rd_x1553
      x1593_inr_Switch_data_options(0) := x1591_inr_SwitchCase
      x1593_inr_Switch_onehot_selects(1) := x2944_rd_x1555
      x1593_inr_Switch_data_options(1) := x1592_inr_SwitchCase
      io.ret.r := Mux1H(x1593_inr_Switch_onehot_selects, x1593_inr_Switch_data_options).r
      x1465_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1466_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1467_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1468_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1469_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1470_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1471_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1472_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1473_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1474_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1522_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1523_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1553_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1554_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1555_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1556_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x1593_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectInstrCtrs(instrctrs, module.io.in_instrctrs)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    val ret = module.io.ret
    Ledger.exit()
    ret
  }
}
/** END Switch x1593_inr_Switch **/
