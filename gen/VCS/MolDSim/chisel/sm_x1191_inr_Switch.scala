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

/** Hierarchy: x1191 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1191_inr_Switch **/
class x1191_inr_Switch_kernel(
  list_x2937_rd_x1138: List[Bool],
  list_x1055_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x1191_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1191_inr_Switch_iiCtr"))
  
  abstract class x1191_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1055_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1055_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1051_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1051_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1057_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1057_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2937_rd_x1138 = Input(Bool())
      val in_x1138_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1138_reg_p").asInstanceOf[NBufParams] ))
      val in_x1050_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1050_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1054_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1054_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2938_rd_x1140 = Input(Bool())
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
    def x1055_tmp_1 = {io.in_x1055_tmp_1} ; io.in_x1055_tmp_1 := DontCare
    def x1051_tmp_2 = {io.in_x1051_tmp_2} ; io.in_x1051_tmp_2 := DontCare
    def x1057_tmp_3 = {io.in_x1057_tmp_3} ; io.in_x1057_tmp_3 := DontCare
    def x2937_rd_x1138 = {io.in_x2937_rd_x1138} 
    def x1138_reg = {io.in_x1138_reg} ; io.in_x1138_reg := DontCare
    def x1050_tmp_1 = {io.in_x1050_tmp_1} ; io.in_x1050_tmp_1 := DontCare
    def x1054_tmp_0 = {io.in_x1054_tmp_0} ; io.in_x1054_tmp_0 := DontCare
    def x2938_rd_x1140 = {io.in_x2938_rd_x1140} 
    def x1058_tmp_4 = {io.in_x1058_tmp_4} ; io.in_x1058_tmp_4 := DontCare
    def x1107_r_0 = {io.in_x1107_r_0} ; io.in_x1107_r_0 := DontCare
    def x1049_tmp_0 = {io.in_x1049_tmp_0} ; io.in_x1049_tmp_0 := DontCare
    def x1053_tmp_4 = {io.in_x1053_tmp_4} ; io.in_x1053_tmp_4 := DontCare
    def x1052_tmp_3 = {io.in_x1052_tmp_3} ; io.in_x1052_tmp_3 := DontCare
    def x1140_reg = {io.in_x1140_reg} ; io.in_x1140_reg := DontCare
    def x1056_tmp_2 = {io.in_x1056_tmp_2} ; io.in_x1056_tmp_2 := DontCare
  }
  def connectWires0(module: x1191_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x1055_tmp_1.connectLedger(module.io.in_x1055_tmp_1)
    x1051_tmp_2.connectLedger(module.io.in_x1051_tmp_2)
    x1057_tmp_3.connectLedger(module.io.in_x1057_tmp_3)
    module.io.in_x2937_rd_x1138 <> x2937_rd_x1138
    x1138_reg.connectLedger(module.io.in_x1138_reg)
    x1050_tmp_1.connectLedger(module.io.in_x1050_tmp_1)
    x1054_tmp_0.connectLedger(module.io.in_x1054_tmp_0)
    module.io.in_x2938_rd_x1140 <> x2938_rd_x1140
    x1058_tmp_4.connectLedger(module.io.in_x1058_tmp_4)
    x1107_r_0.connectLedger(module.io.in_x1107_r_0)
    x1049_tmp_0.connectLedger(module.io.in_x1049_tmp_0)
    x1053_tmp_4.connectLedger(module.io.in_x1053_tmp_4)
    x1052_tmp_3.connectLedger(module.io.in_x1052_tmp_3)
    x1140_reg.connectLedger(module.io.in_x1140_reg)
    x1056_tmp_2.connectLedger(module.io.in_x1056_tmp_2)
  }
  val x2937_rd_x1138 = list_x2937_rd_x1138(0)
  val x2938_rd_x1140 = list_x2937_rd_x1138(1)
  val x1055_tmp_1 = list_x1055_tmp_1(0)
  val x1051_tmp_2 = list_x1055_tmp_1(1)
  val x1057_tmp_3 = list_x1055_tmp_1(2)
  val x1138_reg = list_x1055_tmp_1(3)
  val x1050_tmp_1 = list_x1055_tmp_1(4)
  val x1054_tmp_0 = list_x1055_tmp_1(5)
  val x1058_tmp_4 = list_x1055_tmp_1(6)
  val x1107_r_0 = list_x1055_tmp_1(7)
  val x1049_tmp_0 = list_x1055_tmp_1(8)
  val x1053_tmp_4 = list_x1055_tmp_1(9)
  val x1052_tmp_3 = list_x1055_tmp_1(10)
  val x1140_reg = list_x1055_tmp_1(11)
  val x1056_tmp_2 = list_x1055_tmp_1(12)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1191_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1191_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1191_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1191_inr_Switch = Module(new InstrumentationCounter())
      val iters_x1191_inr_Switch = Module(new InstrumentationCounter())
      cycles_x1191_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x1191_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1191_instrctr, cycles_x1191_inr_Switch.io.count, iters_x1191_inr_Switch.io.count, 0.U, 0.U)
      val x1189_inr_SwitchCase_obj = new x1189_inr_SwitchCase_kernel(List(x1138_reg,x1107_r_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1189_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1189_inr_SwitchCase_obj.childId)
      x1189_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1189_inr_SwitchCase_obj.sm.io.ctrInc)
      x1189_inr_SwitchCase_obj.backpressure := true.B | x1189_inr_SwitchCase_obj.sm.io.doneLatch
      x1189_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1189_inr_SwitchCase_obj.sm.io.doneLatch
      x1189_inr_SwitchCase_obj.sm.io.enableOut.zip(x1189_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1189_inr_SwitchCase_obj.sm.io.break := false.B
      val x1189_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1189_inr_SwitchCase""")
      x1189_inr_SwitchCase_obj.mask := true.B & true.B
      x1189_inr_SwitchCase_obj.configure("x1189_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1189_inr_SwitchCase.r := x1189_inr_SwitchCase_obj.kernel().r
      val x1190_inr_SwitchCase_obj = new x1190_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1190_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1190_inr_SwitchCase_obj.childId)
      x1190_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1190_inr_SwitchCase_obj.sm.io.ctrInc)
      x1190_inr_SwitchCase_obj.backpressure := true.B | x1190_inr_SwitchCase_obj.sm.io.doneLatch
      x1190_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1190_inr_SwitchCase_obj.sm.io.doneLatch
      x1190_inr_SwitchCase_obj.sm.io.enableOut.zip(x1190_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1190_inr_SwitchCase_obj.sm.io.break := false.B
      val x1190_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1190_inr_SwitchCase""")
      x1190_inr_SwitchCase_obj.mask := true.B & true.B
      x1190_inr_SwitchCase_obj.configure("x1190_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1190_inr_SwitchCase.r := x1190_inr_SwitchCase_obj.kernel().r
      val x1191_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x1191_inr_Switch_onehot_selects""")
      val x1191_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x1191_inr_Switch_data_options""")
      x1191_inr_Switch_onehot_selects(0) := x2937_rd_x1138
      x1191_inr_Switch_data_options(0) := x1189_inr_SwitchCase
      x1191_inr_Switch_onehot_selects(1) := x2938_rd_x1140
      x1191_inr_Switch_data_options(1) := x1190_inr_SwitchCase
      io.ret.r := Mux1H(x1191_inr_Switch_onehot_selects, x1191_inr_Switch_data_options).r
      x1049_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1050_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1051_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1052_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1053_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1054_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1055_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1056_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1057_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1058_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1107_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1138_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1140_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
    }
    val module = Module(new x1191_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x1191_inr_Switch **/
