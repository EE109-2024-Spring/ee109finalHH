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

/** Hierarchy: x1385 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1385_inr_Switch **/
class x1385_inr_Switch_kernel(
  list_x2940_rd_x1347: List[Bool],
  list_x1315_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x1385_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1385_inr_Switch_iiCtr"))
  
  abstract class x1385_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1315_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1315_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2940_rd_x1347 = Input(Bool())
      val in_x1260_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1260_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1265_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1265_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1264_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1264_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1347_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1347_reg_p").asInstanceOf[NBufParams] ))
      val in_x1345_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1345_reg_p").asInstanceOf[NBufParams] ))
      val in_x1259_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1259_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1263_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1263_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1266_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1266_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1258_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1258_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1262_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1262_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1257_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1257_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2939_rd_x1345 = Input(Bool())
      val in_x1348_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1348_reg_p").asInstanceOf[NBufParams] ))
      val in_x1314_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1314_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1346_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1346_reg_p").asInstanceOf[NBufParams] ))
      val in_x1261_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1261_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1315_r_0 = {io.in_x1315_r_0} ; io.in_x1315_r_0 := DontCare
    def x2940_rd_x1347 = {io.in_x2940_rd_x1347} 
    def x1260_tmp_3 = {io.in_x1260_tmp_3} ; io.in_x1260_tmp_3 := DontCare
    def x1265_tmp_3 = {io.in_x1265_tmp_3} ; io.in_x1265_tmp_3 := DontCare
    def x1264_tmp_2 = {io.in_x1264_tmp_2} ; io.in_x1264_tmp_2 := DontCare
    def x1347_reg = {io.in_x1347_reg} ; io.in_x1347_reg := DontCare
    def x1345_reg = {io.in_x1345_reg} ; io.in_x1345_reg := DontCare
    def x1259_tmp_2 = {io.in_x1259_tmp_2} ; io.in_x1259_tmp_2 := DontCare
    def x1263_tmp_1 = {io.in_x1263_tmp_1} ; io.in_x1263_tmp_1 := DontCare
    def x1266_tmp_4 = {io.in_x1266_tmp_4} ; io.in_x1266_tmp_4 := DontCare
    def x1258_tmp_1 = {io.in_x1258_tmp_1} ; io.in_x1258_tmp_1 := DontCare
    def x1262_tmp_0 = {io.in_x1262_tmp_0} ; io.in_x1262_tmp_0 := DontCare
    def x1257_tmp_0 = {io.in_x1257_tmp_0} ; io.in_x1257_tmp_0 := DontCare
    def x2939_rd_x1345 = {io.in_x2939_rd_x1345} 
    def x1348_reg = {io.in_x1348_reg} ; io.in_x1348_reg := DontCare
    def x1314_r_0 = {io.in_x1314_r_0} ; io.in_x1314_r_0 := DontCare
    def x1346_reg = {io.in_x1346_reg} ; io.in_x1346_reg := DontCare
    def x1261_tmp_4 = {io.in_x1261_tmp_4} ; io.in_x1261_tmp_4 := DontCare
  }
  def connectWires0(module: x1385_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x1315_r_0.connectLedger(module.io.in_x1315_r_0)
    module.io.in_x2940_rd_x1347 <> x2940_rd_x1347
    x1260_tmp_3.connectLedger(module.io.in_x1260_tmp_3)
    x1265_tmp_3.connectLedger(module.io.in_x1265_tmp_3)
    x1264_tmp_2.connectLedger(module.io.in_x1264_tmp_2)
    x1347_reg.connectLedger(module.io.in_x1347_reg)
    x1345_reg.connectLedger(module.io.in_x1345_reg)
    x1259_tmp_2.connectLedger(module.io.in_x1259_tmp_2)
    x1263_tmp_1.connectLedger(module.io.in_x1263_tmp_1)
    x1266_tmp_4.connectLedger(module.io.in_x1266_tmp_4)
    x1258_tmp_1.connectLedger(module.io.in_x1258_tmp_1)
    x1262_tmp_0.connectLedger(module.io.in_x1262_tmp_0)
    x1257_tmp_0.connectLedger(module.io.in_x1257_tmp_0)
    module.io.in_x2939_rd_x1345 <> x2939_rd_x1345
    x1348_reg.connectLedger(module.io.in_x1348_reg)
    x1314_r_0.connectLedger(module.io.in_x1314_r_0)
    x1346_reg.connectLedger(module.io.in_x1346_reg)
    x1261_tmp_4.connectLedger(module.io.in_x1261_tmp_4)
  }
  val x2940_rd_x1347 = list_x2940_rd_x1347(0)
  val x2939_rd_x1345 = list_x2940_rd_x1347(1)
  val x1315_r_0 = list_x1315_r_0(0)
  val x1260_tmp_3 = list_x1315_r_0(1)
  val x1265_tmp_3 = list_x1315_r_0(2)
  val x1264_tmp_2 = list_x1315_r_0(3)
  val x1347_reg = list_x1315_r_0(4)
  val x1345_reg = list_x1315_r_0(5)
  val x1259_tmp_2 = list_x1315_r_0(6)
  val x1263_tmp_1 = list_x1315_r_0(7)
  val x1266_tmp_4 = list_x1315_r_0(8)
  val x1258_tmp_1 = list_x1315_r_0(9)
  val x1262_tmp_0 = list_x1315_r_0(10)
  val x1257_tmp_0 = list_x1315_r_0(11)
  val x1348_reg = list_x1315_r_0(12)
  val x1314_r_0 = list_x1315_r_0(13)
  val x1346_reg = list_x1315_r_0(14)
  val x1261_tmp_4 = list_x1315_r_0(15)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1385_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1385_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1385_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1385_inr_Switch = Module(new InstrumentationCounter())
      val iters_x1385_inr_Switch = Module(new InstrumentationCounter())
      cycles_x1385_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x1385_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1385_instrctr, cycles_x1385_inr_Switch.io.count, iters_x1385_inr_Switch.io.count, 0.U, 0.U)
      val x1383_inr_SwitchCase_obj = new x1383_inr_SwitchCase_kernel(List(x1345_reg,x1314_r_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1383_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1383_inr_SwitchCase_obj.childId)
      x1383_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1383_inr_SwitchCase_obj.sm.io.ctrInc)
      x1383_inr_SwitchCase_obj.backpressure := true.B | x1383_inr_SwitchCase_obj.sm.io.doneLatch
      x1383_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1383_inr_SwitchCase_obj.sm.io.doneLatch
      x1383_inr_SwitchCase_obj.sm.io.enableOut.zip(x1383_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1383_inr_SwitchCase_obj.sm.io.break := false.B
      val x1383_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1383_inr_SwitchCase""")
      x1383_inr_SwitchCase_obj.mask := true.B & true.B
      x1383_inr_SwitchCase_obj.configure("x1383_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1383_inr_SwitchCase.r := x1383_inr_SwitchCase_obj.kernel().r
      val x1384_inr_SwitchCase_obj = new x1384_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1384_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x1384_inr_SwitchCase_obj.childId)
      x1384_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x1384_inr_SwitchCase_obj.sm.io.ctrInc)
      x1384_inr_SwitchCase_obj.backpressure := true.B | x1384_inr_SwitchCase_obj.sm.io.doneLatch
      x1384_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x1384_inr_SwitchCase_obj.sm.io.doneLatch
      x1384_inr_SwitchCase_obj.sm.io.enableOut.zip(x1384_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1384_inr_SwitchCase_obj.sm.io.break := false.B
      val x1384_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1384_inr_SwitchCase""")
      x1384_inr_SwitchCase_obj.mask := true.B & true.B
      x1384_inr_SwitchCase_obj.configure("x1384_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x1384_inr_SwitchCase.r := x1384_inr_SwitchCase_obj.kernel().r
      val x1385_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x1385_inr_Switch_onehot_selects""")
      val x1385_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x1385_inr_Switch_data_options""")
      x1385_inr_Switch_onehot_selects(0) := x2939_rd_x1345
      x1385_inr_Switch_data_options(0) := x1383_inr_SwitchCase
      x1385_inr_Switch_onehot_selects(1) := x2940_rd_x1347
      x1385_inr_Switch_data_options(1) := x1384_inr_SwitchCase
      io.ret.r := Mux1H(x1385_inr_Switch_onehot_selects, x1385_inr_Switch_data_options).r
      x1257_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1258_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1259_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1260_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1261_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1262_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1263_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1264_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1265_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1266_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1314_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1315_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1345_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1346_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1347_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1348_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x1385_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x1385_inr_Switch **/
