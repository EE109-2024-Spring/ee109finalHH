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

/** Hierarchy: x1177 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1177_inr_Switch **/
class x1177_inr_Switch_kernel(
  list_x2936_rd_x1139: List[Bool],
  list_x1137_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x1177_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1177_inr_Switch_iiCtr"))
  
  abstract class x1177_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1137_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1137_reg_p").asInstanceOf[NBufParams] ))
      val in_x1055_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1055_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1051_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1051_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1057_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1057_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1106_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1106_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1138_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1138_reg_p").asInstanceOf[NBufParams] ))
      val in_x1050_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1050_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1054_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1054_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2936_rd_x1139 = Input(Bool())
      val in_x1139_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1139_reg_p").asInstanceOf[NBufParams] ))
      val in_x2935_rd_x1137 = Input(Bool())
      val in_x1058_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1058_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1107_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1107_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1049_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1049_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1053_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1053_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1052_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1052_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1140_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1140_reg_p").asInstanceOf[NBufParams] ))
      val in_x1056_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1056_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1137_reg = {io.in_x1137_reg} ; io.in_x1137_reg := DontCare
    def x1055_tmp_1 = {io.in_x1055_tmp_1} ; io.in_x1055_tmp_1 := DontCare
    def x1051_tmp_2 = {io.in_x1051_tmp_2} ; io.in_x1051_tmp_2 := DontCare
    def x1057_tmp_3 = {io.in_x1057_tmp_3} ; io.in_x1057_tmp_3 := DontCare
    def x1106_r_0 = {io.in_x1106_r_0} ; io.in_x1106_r_0 := DontCare
    def x1138_reg = {io.in_x1138_reg} ; io.in_x1138_reg := DontCare
    def x1050_tmp_1 = {io.in_x1050_tmp_1} ; io.in_x1050_tmp_1 := DontCare
    def x1054_tmp_0 = {io.in_x1054_tmp_0} ; io.in_x1054_tmp_0 := DontCare
    def x2936_rd_x1139 = {io.in_x2936_rd_x1139} 
    def x1139_reg = {io.in_x1139_reg} ; io.in_x1139_reg := DontCare
    def x2935_rd_x1137 = {io.in_x2935_rd_x1137} 
    def x1058_tmp_4 = {io.in_x1058_tmp_4} ; io.in_x1058_tmp_4 := DontCare
    def x1107_r_0 = {io.in_x1107_r_0} ; io.in_x1107_r_0 := DontCare
    def x1049_tmp_0 = {io.in_x1049_tmp_0} ; io.in_x1049_tmp_0 := DontCare
    def x1053_tmp_4 = {io.in_x1053_tmp_4} ; io.in_x1053_tmp_4 := DontCare
    def x1052_tmp_3 = {io.in_x1052_tmp_3} ; io.in_x1052_tmp_3 := DontCare
    def x1140_reg = {io.in_x1140_reg} ; io.in_x1140_reg := DontCare
    def x1056_tmp_2 = {io.in_x1056_tmp_2} ; io.in_x1056_tmp_2 := DontCare
  }
  def connectWires0(module: x1177_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x1137_reg.connectLedger(module.io.in_x1137_reg)
    x1055_tmp_1.connectLedger(module.io.in_x1055_tmp_1)
    x1051_tmp_2.connectLedger(module.io.in_x1051_tmp_2)
    x1057_tmp_3.connectLedger(module.io.in_x1057_tmp_3)
    x1106_r_0.connectLedger(module.io.in_x1106_r_0)
    x1138_reg.connectLedger(module.io.in_x1138_reg)
    x1050_tmp_1.connectLedger(module.io.in_x1050_tmp_1)
    x1054_tmp_0.connectLedger(module.io.in_x1054_tmp_0)
    module.io.in_x2936_rd_x1139 <> x2936_rd_x1139
    x1139_reg.connectLedger(module.io.in_x1139_reg)
    module.io.in_x2935_rd_x1137 <> x2935_rd_x1137
    x1058_tmp_4.connectLedger(module.io.in_x1058_tmp_4)
    x1107_r_0.connectLedger(module.io.in_x1107_r_0)
    x1049_tmp_0.connectLedger(module.io.in_x1049_tmp_0)
    x1053_tmp_4.connectLedger(module.io.in_x1053_tmp_4)
    x1052_tmp_3.connectLedger(module.io.in_x1052_tmp_3)
    x1140_reg.connectLedger(module.io.in_x1140_reg)
    x1056_tmp_2.connectLedger(module.io.in_x1056_tmp_2)
  }
  val x2936_rd_x1139 = list_x2936_rd_x1139(0)
  val x2935_rd_x1137 = list_x2936_rd_x1139(1)
  val x1137_reg = list_x1137_reg(0)
  val x1055_tmp_1 = list_x1137_reg(1)
  val x1051_tmp_2 = list_x1137_reg(2)
  val x1057_tmp_3 = list_x1137_reg(3)
  val x1106_r_0 = list_x1137_reg(4)
  val x1138_reg = list_x1137_reg(5)
  val x1050_tmp_1 = list_x1137_reg(6)
  val x1054_tmp_0 = list_x1137_reg(7)
  val x1139_reg = list_x1137_reg(8)
  val x1058_tmp_4 = list_x1137_reg(9)
  val x1107_r_0 = list_x1137_reg(10)
  val x1049_tmp_0 = list_x1137_reg(11)
  val x1053_tmp_4 = list_x1137_reg(12)
  val x1052_tmp_3 = list_x1137_reg(13)
  val x1140_reg = list_x1137_reg(14)
  val x1056_tmp_2 = list_x1137_reg(15)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1177_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1177_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1177_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1177_inr_Switch = Module(new InstrumentationCounter())
      val iters_x1177_inr_Switch = Module(new InstrumentationCounter())
      cycles_x1177_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x1177_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1177_instrctr, cycles_x1177_inr_Switch.io.count, iters_x1177_inr_Switch.io.count, 0.U, 0.U)
      val x1175_inr_SwitchCase_obj = new x1175_inr_SwitchCase_kernel(List(x1137_reg,x1106_r_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1175_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1175_inr_SwitchCase_obj.childId)
      x1175_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1175_inr_SwitchCase_obj.sm.io.ctrInc)
      x1175_inr_SwitchCase_obj.backpressure := true.B | x1175_inr_SwitchCase_obj.sm.io.doneLatch
      x1175_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1175_inr_SwitchCase_obj.sm.io.doneLatch
      x1175_inr_SwitchCase_obj.sm.io.enableOut.zip(x1175_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1175_inr_SwitchCase_obj.sm.io.break := false.B
      val x1175_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1175_inr_SwitchCase""")
      x1175_inr_SwitchCase_obj.mask := true.B & true.B
      x1175_inr_SwitchCase_obj.configure("x1175_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1175_inr_SwitchCase.r := x1175_inr_SwitchCase_obj.kernel().r
      val x1176_inr_SwitchCase_obj = new x1176_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1176_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1176_inr_SwitchCase_obj.childId)
      x1176_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1176_inr_SwitchCase_obj.sm.io.ctrInc)
      x1176_inr_SwitchCase_obj.backpressure := true.B | x1176_inr_SwitchCase_obj.sm.io.doneLatch
      x1176_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1176_inr_SwitchCase_obj.sm.io.doneLatch
      x1176_inr_SwitchCase_obj.sm.io.enableOut.zip(x1176_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1176_inr_SwitchCase_obj.sm.io.break := false.B
      val x1176_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1176_inr_SwitchCase""")
      x1176_inr_SwitchCase_obj.mask := true.B & true.B
      x1176_inr_SwitchCase_obj.configure("x1176_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1176_inr_SwitchCase.r := x1176_inr_SwitchCase_obj.kernel().r
      val x1177_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x1177_inr_Switch_onehot_selects""")
      val x1177_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x1177_inr_Switch_data_options""")
      x1177_inr_Switch_onehot_selects(0) := x2935_rd_x1137
      x1177_inr_Switch_data_options(0) := x1175_inr_SwitchCase
      x1177_inr_Switch_onehot_selects(1) := x2936_rd_x1139
      x1177_inr_Switch_data_options(1) := x1176_inr_SwitchCase
      io.ret.r := Mux1H(x1177_inr_Switch_onehot_selects, x1177_inr_Switch_data_options).r
      x1049_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1050_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1051_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1052_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1053_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1054_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1055_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1056_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1057_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1058_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1106_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1107_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1137_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1138_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1139_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1140_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x1177_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x1177_inr_Switch **/
