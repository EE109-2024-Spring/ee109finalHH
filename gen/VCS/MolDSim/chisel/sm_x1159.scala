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

/** Hierarchy: x1159 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1159 **/
class x1159_kernel(
  list_b1046: List[Bool],
  list_x1137_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1159_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1159_iiCtr"))
  
  abstract class x1159_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1137_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1137_reg_p").asInstanceOf[NBufParams] ))
      val in_b1046 = Input(Bool())
      val in_x1055_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1055_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b559 = Input(Bool())
      val in_x1051_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1051_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1047 = Input(Bool())
      val in_x1057_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1057_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1106_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1106_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1138_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1138_reg_p").asInstanceOf[NBufParams] ))
      val in_x1050_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1050_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1054_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1054_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1139_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1139_reg_p").asInstanceOf[NBufParams] ))
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
    })
    def x1137_reg = {io.in_x1137_reg} ; io.in_x1137_reg := DontCare
    def b1046 = {io.in_b1046} 
    def x1055_tmp_1 = {io.in_x1055_tmp_1} ; io.in_x1055_tmp_1 := DontCare
    def b559 = {io.in_b559} 
    def x1051_tmp_2 = {io.in_x1051_tmp_2} ; io.in_x1051_tmp_2 := DontCare
    def b1047 = {io.in_b1047} 
    def x1057_tmp_3 = {io.in_x1057_tmp_3} ; io.in_x1057_tmp_3 := DontCare
    def x1106_r_0 = {io.in_x1106_r_0} ; io.in_x1106_r_0 := DontCare
    def x1138_reg = {io.in_x1138_reg} ; io.in_x1138_reg := DontCare
    def x1050_tmp_1 = {io.in_x1050_tmp_1} ; io.in_x1050_tmp_1 := DontCare
    def x1054_tmp_0 = {io.in_x1054_tmp_0} ; io.in_x1054_tmp_0 := DontCare
    def x1139_reg = {io.in_x1139_reg} ; io.in_x1139_reg := DontCare
    def x1058_tmp_4 = {io.in_x1058_tmp_4} ; io.in_x1058_tmp_4 := DontCare
    def x1107_r_0 = {io.in_x1107_r_0} ; io.in_x1107_r_0 := DontCare
    def x1049_tmp_0 = {io.in_x1049_tmp_0} ; io.in_x1049_tmp_0 := DontCare
    def x1053_tmp_4 = {io.in_x1053_tmp_4} ; io.in_x1053_tmp_4 := DontCare
    def x1052_tmp_3 = {io.in_x1052_tmp_3} ; io.in_x1052_tmp_3 := DontCare
    def x1140_reg = {io.in_x1140_reg} ; io.in_x1140_reg := DontCare
    def x1056_tmp_2 = {io.in_x1056_tmp_2} ; io.in_x1056_tmp_2 := DontCare
  }
  def connectWires0(module: x1159_module)(implicit stack: List[KernelHash]): Unit = {
    x1137_reg.connectLedger(module.io.in_x1137_reg)
    module.io.in_b1046 <> b1046
    x1055_tmp_1.connectLedger(module.io.in_x1055_tmp_1)
    module.io.in_b559 <> b559
    x1051_tmp_2.connectLedger(module.io.in_x1051_tmp_2)
    module.io.in_b1047 <> b1047
    x1057_tmp_3.connectLedger(module.io.in_x1057_tmp_3)
    x1106_r_0.connectLedger(module.io.in_x1106_r_0)
    x1138_reg.connectLedger(module.io.in_x1138_reg)
    x1050_tmp_1.connectLedger(module.io.in_x1050_tmp_1)
    x1054_tmp_0.connectLedger(module.io.in_x1054_tmp_0)
    x1139_reg.connectLedger(module.io.in_x1139_reg)
    x1058_tmp_4.connectLedger(module.io.in_x1058_tmp_4)
    x1107_r_0.connectLedger(module.io.in_x1107_r_0)
    x1049_tmp_0.connectLedger(module.io.in_x1049_tmp_0)
    x1053_tmp_4.connectLedger(module.io.in_x1053_tmp_4)
    x1052_tmp_3.connectLedger(module.io.in_x1052_tmp_3)
    x1140_reg.connectLedger(module.io.in_x1140_reg)
    x1056_tmp_2.connectLedger(module.io.in_x1056_tmp_2)
  }
  val b1046 = list_b1046(0)
  val b559 = list_b1046(1)
  val b1047 = list_b1046(2)
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
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1159")
    implicit val stack = ControllerStack.stack.toList
    class x1159_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1159_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1159 = Module(new InstrumentationCounter())
      val iters_x1159 = Module(new InstrumentationCounter())
      cycles_x1159.io.enable := io.sigsIn.baseEn
      iters_x1159.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1159_instrctr, cycles_x1159.io.count, iters_x1159.io.count, 0.U, 0.U)
      val x1149_inr_UnitPipe = new x1149_inr_UnitPipe_kernel(List(b1046,b559), List(x1137_reg,x1106_r_0,x1139_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1149_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1149_inr_UnitPipe.sm.io.ctrInc)
      x1149_inr_UnitPipe.backpressure := true.B | x1149_inr_UnitPipe.sm.io.doneLatch
      x1149_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1149_inr_UnitPipe.sm.io.doneLatch
      x1149_inr_UnitPipe.sm.io.enableOut.zip(x1149_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1149_inr_UnitPipe.sm.io.break := false.B
      x1149_inr_UnitPipe.mask := true.B & b1046 & b559
      x1149_inr_UnitPipe.configure("x1149_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1149_inr_UnitPipe.kernel()
      val x1158_inr_UnitPipe = new x1158_inr_UnitPipe_kernel(List(b559,b1047), List(x1138_reg,x1107_r_0,x1140_reg) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1158_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1158_inr_UnitPipe.sm.io.ctrInc)
      x1158_inr_UnitPipe.backpressure := true.B | x1158_inr_UnitPipe.sm.io.doneLatch
      x1158_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1158_inr_UnitPipe.sm.io.doneLatch
      x1158_inr_UnitPipe.sm.io.enableOut.zip(x1158_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1158_inr_UnitPipe.sm.io.break := false.B
      x1158_inr_UnitPipe.mask := true.B & b1047 & b559
      x1158_inr_UnitPipe.configure("x1158_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1158_inr_UnitPipe.kernel()
      x1049_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1050_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1051_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1052_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1053_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1054_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1055_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1056_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1057_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1058_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1106_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1107_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1137_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1138_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1139_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1140_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1159_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1159 **/
