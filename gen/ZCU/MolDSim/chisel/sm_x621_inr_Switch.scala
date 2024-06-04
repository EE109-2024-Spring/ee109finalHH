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

/** Hierarchy: x621 -> x653 -> x668 -> x444 **/
/** BEGIN None x621_inr_Switch **/
class x621_inr_Switch_kernel(
  list_x736_rd_x596: List[Bool],
  list_x555_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x621_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x621_inr_Switch_iiCtr"))
  
  abstract class x621_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x555_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x555_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x554_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x554_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x558_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x558_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x736_rd_x596 = Input(Bool())
      val in_x557_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x557_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x580_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x580_r_0_p").asInstanceOf[NBufParams] ))
      val in_x595_reg = Flipped(new NBufInterface(ModuleParams.getParams("x595_reg_p").asInstanceOf[NBufParams] ))
      val in_x556_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x556_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x735_rd_x595 = Input(Bool())
      val in_x596_reg = Flipped(new NBufInterface(ModuleParams.getParams("x596_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x555_tmp_1 = {io.in_x555_tmp_1} ; io.in_x555_tmp_1 := DontCare
    def x554_tmp_0 = {io.in_x554_tmp_0} ; io.in_x554_tmp_0 := DontCare
    def x558_tmp_4 = {io.in_x558_tmp_4} ; io.in_x558_tmp_4 := DontCare
    def x736_rd_x596 = {io.in_x736_rd_x596} 
    def x557_tmp_3 = {io.in_x557_tmp_3} ; io.in_x557_tmp_3 := DontCare
    def x580_r_0 = {io.in_x580_r_0} ; io.in_x580_r_0 := DontCare
    def x595_reg = {io.in_x595_reg} ; io.in_x595_reg := DontCare
    def x556_tmp_2 = {io.in_x556_tmp_2} ; io.in_x556_tmp_2 := DontCare
    def x735_rd_x595 = {io.in_x735_rd_x595} 
    def x596_reg = {io.in_x596_reg} ; io.in_x596_reg := DontCare
  }
  def connectWires0(module: x621_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x555_tmp_1.connectLedger(module.io.in_x555_tmp_1)
    x554_tmp_0.connectLedger(module.io.in_x554_tmp_0)
    x558_tmp_4.connectLedger(module.io.in_x558_tmp_4)
    module.io.in_x736_rd_x596 <> x736_rd_x596
    x557_tmp_3.connectLedger(module.io.in_x557_tmp_3)
    x580_r_0.connectLedger(module.io.in_x580_r_0)
    x595_reg.connectLedger(module.io.in_x595_reg)
    x556_tmp_2.connectLedger(module.io.in_x556_tmp_2)
    module.io.in_x735_rd_x595 <> x735_rd_x595
    x596_reg.connectLedger(module.io.in_x596_reg)
  }
  val x736_rd_x596 = list_x736_rd_x596(0)
  val x735_rd_x595 = list_x736_rd_x596(1)
  val x555_tmp_1 = list_x555_tmp_1(0)
  val x554_tmp_0 = list_x555_tmp_1(1)
  val x558_tmp_4 = list_x555_tmp_1(2)
  val x557_tmp_3 = list_x555_tmp_1(3)
  val x580_r_0 = list_x555_tmp_1(4)
  val x595_reg = list_x555_tmp_1(5)
  val x556_tmp_2 = list_x555_tmp_1(6)
  val x596_reg = list_x555_tmp_1(7)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x621_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x621_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x621_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x619_inr_SwitchCase_obj = new x619_inr_SwitchCase_kernel(List(x580_r_0,x595_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x619_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x619_inr_SwitchCase_obj.childId)
      x619_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x619_inr_SwitchCase_obj.sm.io.ctrInc)
      x619_inr_SwitchCase_obj.backpressure := true.B | x619_inr_SwitchCase_obj.sm.io.doneLatch
      x619_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x619_inr_SwitchCase_obj.sm.io.doneLatch
      x619_inr_SwitchCase_obj.sm.io.enableOut.zip(x619_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x619_inr_SwitchCase_obj.sm.io.break := false.B
      val x619_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x619_inr_SwitchCase""")
      x619_inr_SwitchCase_obj.mask := true.B & true.B
      x619_inr_SwitchCase_obj.configure("x619_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x619_inr_SwitchCase.r := x619_inr_SwitchCase_obj.kernel().r
      val x620_inr_SwitchCase_obj = new x620_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x620_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x620_inr_SwitchCase_obj.childId)
      x620_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x620_inr_SwitchCase_obj.sm.io.ctrInc)
      x620_inr_SwitchCase_obj.backpressure := true.B | x620_inr_SwitchCase_obj.sm.io.doneLatch
      x620_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x620_inr_SwitchCase_obj.sm.io.doneLatch
      x620_inr_SwitchCase_obj.sm.io.enableOut.zip(x620_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x620_inr_SwitchCase_obj.sm.io.break := false.B
      val x620_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x620_inr_SwitchCase""")
      x620_inr_SwitchCase_obj.mask := true.B & true.B
      x620_inr_SwitchCase_obj.configure("x620_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x620_inr_SwitchCase.r := x620_inr_SwitchCase_obj.kernel().r
      val x621_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x621_inr_Switch_onehot_selects""")
      val x621_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x621_inr_Switch_data_options""")
      x621_inr_Switch_onehot_selects(0) := x735_rd_x595
      x621_inr_Switch_data_options(0) := x619_inr_SwitchCase
      x621_inr_Switch_onehot_selects(1) := x736_rd_x596
      x621_inr_Switch_data_options(1) := x620_inr_SwitchCase
      io.ret.r := Mux1H(x621_inr_Switch_onehot_selects, x621_inr_Switch_data_options).r
      x554_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x555_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x556_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x557_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x558_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x580_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x595_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x596_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x621_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    val ret = module.io.ret
    Ledger.exit()
    ret
  }
}
/** END Switch x621_inr_Switch **/
