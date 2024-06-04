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

/** Hierarchy: x1815 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1815_inr_Switch **/
class x1815_inr_Switch_kernel(
  list_x2950_rd_x1764: List[Bool],
  list_x1682_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x1815_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1815_inr_Switch_iiCtr"))
  
  abstract class x1815_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2950_rd_x1764 = Input(Bool())
      val in_x1682_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1682_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1677_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1677_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1676_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1676_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1762_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1762_reg_p").asInstanceOf[NBufParams] ))
      val in_x1764_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1764_reg_p").asInstanceOf[NBufParams] ))
      val in_x1680_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1680_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1675_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1675_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1731_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1731_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1679_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1679_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2949_rd_x1762 = Input(Bool())
      val in_x1674_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1674_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1678_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1678_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1673_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1673_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1681_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1681_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2950_rd_x1764 = {io.in_x2950_rd_x1764} 
    def x1682_tmp_4 = {io.in_x1682_tmp_4} ; io.in_x1682_tmp_4 := DontCare
    def x1677_tmp_4 = {io.in_x1677_tmp_4} ; io.in_x1677_tmp_4 := DontCare
    def x1676_tmp_3 = {io.in_x1676_tmp_3} ; io.in_x1676_tmp_3 := DontCare
    def x1762_reg = {io.in_x1762_reg} ; io.in_x1762_reg := DontCare
    def x1764_reg = {io.in_x1764_reg} ; io.in_x1764_reg := DontCare
    def x1680_tmp_2 = {io.in_x1680_tmp_2} ; io.in_x1680_tmp_2 := DontCare
    def x1675_tmp_2 = {io.in_x1675_tmp_2} ; io.in_x1675_tmp_2 := DontCare
    def x1731_r_0 = {io.in_x1731_r_0} ; io.in_x1731_r_0 := DontCare
    def x1679_tmp_1 = {io.in_x1679_tmp_1} ; io.in_x1679_tmp_1 := DontCare
    def x2949_rd_x1762 = {io.in_x2949_rd_x1762} 
    def x1674_tmp_1 = {io.in_x1674_tmp_1} ; io.in_x1674_tmp_1 := DontCare
    def x1678_tmp_0 = {io.in_x1678_tmp_0} ; io.in_x1678_tmp_0 := DontCare
    def x1673_tmp_0 = {io.in_x1673_tmp_0} ; io.in_x1673_tmp_0 := DontCare
    def x1681_tmp_3 = {io.in_x1681_tmp_3} ; io.in_x1681_tmp_3 := DontCare
  }
  def connectWires0(module: x1815_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2950_rd_x1764 <> x2950_rd_x1764
    x1682_tmp_4.connectLedger(module.io.in_x1682_tmp_4)
    x1677_tmp_4.connectLedger(module.io.in_x1677_tmp_4)
    x1676_tmp_3.connectLedger(module.io.in_x1676_tmp_3)
    x1762_reg.connectLedger(module.io.in_x1762_reg)
    x1764_reg.connectLedger(module.io.in_x1764_reg)
    x1680_tmp_2.connectLedger(module.io.in_x1680_tmp_2)
    x1675_tmp_2.connectLedger(module.io.in_x1675_tmp_2)
    x1731_r_0.connectLedger(module.io.in_x1731_r_0)
    x1679_tmp_1.connectLedger(module.io.in_x1679_tmp_1)
    module.io.in_x2949_rd_x1762 <> x2949_rd_x1762
    x1674_tmp_1.connectLedger(module.io.in_x1674_tmp_1)
    x1678_tmp_0.connectLedger(module.io.in_x1678_tmp_0)
    x1673_tmp_0.connectLedger(module.io.in_x1673_tmp_0)
    x1681_tmp_3.connectLedger(module.io.in_x1681_tmp_3)
  }
  val x2950_rd_x1764 = list_x2950_rd_x1764(0)
  val x2949_rd_x1762 = list_x2950_rd_x1764(1)
  val x1682_tmp_4 = list_x1682_tmp_4(0)
  val x1677_tmp_4 = list_x1682_tmp_4(1)
  val x1676_tmp_3 = list_x1682_tmp_4(2)
  val x1762_reg = list_x1682_tmp_4(3)
  val x1764_reg = list_x1682_tmp_4(4)
  val x1680_tmp_2 = list_x1682_tmp_4(5)
  val x1675_tmp_2 = list_x1682_tmp_4(6)
  val x1731_r_0 = list_x1682_tmp_4(7)
  val x1679_tmp_1 = list_x1682_tmp_4(8)
  val x1674_tmp_1 = list_x1682_tmp_4(9)
  val x1678_tmp_0 = list_x1682_tmp_4(10)
  val x1673_tmp_0 = list_x1682_tmp_4(11)
  val x1681_tmp_3 = list_x1682_tmp_4(12)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1815_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1815_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1815_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1815_inr_Switch = Module(new InstrumentationCounter())
      val iters_x1815_inr_Switch = Module(new InstrumentationCounter())
      cycles_x1815_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x1815_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1815_instrctr, cycles_x1815_inr_Switch.io.count, iters_x1815_inr_Switch.io.count, 0.U, 0.U)
      val x1813_inr_SwitchCase_obj = new x1813_inr_SwitchCase_kernel(List(x1762_reg,x1731_r_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1813_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1813_inr_SwitchCase_obj.childId)
      x1813_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1813_inr_SwitchCase_obj.sm.io.ctrInc)
      x1813_inr_SwitchCase_obj.backpressure := true.B | x1813_inr_SwitchCase_obj.sm.io.doneLatch
      x1813_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1813_inr_SwitchCase_obj.sm.io.doneLatch
      x1813_inr_SwitchCase_obj.sm.io.enableOut.zip(x1813_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1813_inr_SwitchCase_obj.sm.io.break := false.B
      val x1813_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1813_inr_SwitchCase""")
      x1813_inr_SwitchCase_obj.mask := true.B & true.B
      x1813_inr_SwitchCase_obj.configure("x1813_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1813_inr_SwitchCase.r := x1813_inr_SwitchCase_obj.kernel().r
      val x1814_inr_SwitchCase_obj = new x1814_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1814_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1814_inr_SwitchCase_obj.childId)
      x1814_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1814_inr_SwitchCase_obj.sm.io.ctrInc)
      x1814_inr_SwitchCase_obj.backpressure := true.B | x1814_inr_SwitchCase_obj.sm.io.doneLatch
      x1814_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1814_inr_SwitchCase_obj.sm.io.doneLatch
      x1814_inr_SwitchCase_obj.sm.io.enableOut.zip(x1814_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1814_inr_SwitchCase_obj.sm.io.break := false.B
      val x1814_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1814_inr_SwitchCase""")
      x1814_inr_SwitchCase_obj.mask := true.B & true.B
      x1814_inr_SwitchCase_obj.configure("x1814_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1814_inr_SwitchCase.r := x1814_inr_SwitchCase_obj.kernel().r
      val x1815_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x1815_inr_Switch_onehot_selects""")
      val x1815_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x1815_inr_Switch_data_options""")
      x1815_inr_Switch_onehot_selects(0) := x2949_rd_x1762
      x1815_inr_Switch_data_options(0) := x1813_inr_SwitchCase
      x1815_inr_Switch_onehot_selects(1) := x2950_rd_x1764
      x1815_inr_Switch_data_options(1) := x1814_inr_SwitchCase
      io.ret.r := Mux1H(x1815_inr_Switch_onehot_selects, x1815_inr_Switch_data_options).r
      x1673_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1674_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1675_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1676_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1677_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1678_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1679_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1680_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1681_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1682_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1731_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1762_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1764_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
    }
    val module = Module(new x1815_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x1815_inr_Switch **/
