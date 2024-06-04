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

/** Hierarchy: x2231 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2231_inr_Switch **/
class x2231_inr_Switch_kernel(
  list_x2957_rd_x2178: List[Bool],
  list_x2094_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x2231_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2231_inr_Switch_iiCtr"))
  
  abstract class x2231_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2094_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2094_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2957_rd_x2178 = Input(Bool())
      val in_x2178_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2178_reg_p").asInstanceOf[NBufParams] ))
      val in_x2090_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2090_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2093_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2093_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2147_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2147_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2958_rd_x2180 = Input(Bool())
      val in_x2089_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2089_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2097_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2097_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2180_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2180_reg_p").asInstanceOf[NBufParams] ))
      val in_x2096_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2096_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2092_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2092_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2098_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2098_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2095_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2095_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2091_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2091_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2094_tmp_0 = {io.in_x2094_tmp_0} ; io.in_x2094_tmp_0 := DontCare
    def x2957_rd_x2178 = {io.in_x2957_rd_x2178} 
    def x2178_reg = {io.in_x2178_reg} ; io.in_x2178_reg := DontCare
    def x2090_tmp_1 = {io.in_x2090_tmp_1} ; io.in_x2090_tmp_1 := DontCare
    def x2093_tmp_4 = {io.in_x2093_tmp_4} ; io.in_x2093_tmp_4 := DontCare
    def x2147_r_0 = {io.in_x2147_r_0} ; io.in_x2147_r_0 := DontCare
    def x2958_rd_x2180 = {io.in_x2958_rd_x2180} 
    def x2089_tmp_0 = {io.in_x2089_tmp_0} ; io.in_x2089_tmp_0 := DontCare
    def x2097_tmp_3 = {io.in_x2097_tmp_3} ; io.in_x2097_tmp_3 := DontCare
    def x2180_reg = {io.in_x2180_reg} ; io.in_x2180_reg := DontCare
    def x2096_tmp_2 = {io.in_x2096_tmp_2} ; io.in_x2096_tmp_2 := DontCare
    def x2092_tmp_3 = {io.in_x2092_tmp_3} ; io.in_x2092_tmp_3 := DontCare
    def x2098_tmp_4 = {io.in_x2098_tmp_4} ; io.in_x2098_tmp_4 := DontCare
    def x2095_tmp_1 = {io.in_x2095_tmp_1} ; io.in_x2095_tmp_1 := DontCare
    def x2091_tmp_2 = {io.in_x2091_tmp_2} ; io.in_x2091_tmp_2 := DontCare
  }
  def connectWires0(module: x2231_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x2094_tmp_0.connectLedger(module.io.in_x2094_tmp_0)
    module.io.in_x2957_rd_x2178 <> x2957_rd_x2178
    x2178_reg.connectLedger(module.io.in_x2178_reg)
    x2090_tmp_1.connectLedger(module.io.in_x2090_tmp_1)
    x2093_tmp_4.connectLedger(module.io.in_x2093_tmp_4)
    x2147_r_0.connectLedger(module.io.in_x2147_r_0)
    module.io.in_x2958_rd_x2180 <> x2958_rd_x2180
    x2089_tmp_0.connectLedger(module.io.in_x2089_tmp_0)
    x2097_tmp_3.connectLedger(module.io.in_x2097_tmp_3)
    x2180_reg.connectLedger(module.io.in_x2180_reg)
    x2096_tmp_2.connectLedger(module.io.in_x2096_tmp_2)
    x2092_tmp_3.connectLedger(module.io.in_x2092_tmp_3)
    x2098_tmp_4.connectLedger(module.io.in_x2098_tmp_4)
    x2095_tmp_1.connectLedger(module.io.in_x2095_tmp_1)
    x2091_tmp_2.connectLedger(module.io.in_x2091_tmp_2)
  }
  val x2957_rd_x2178 = list_x2957_rd_x2178(0)
  val x2958_rd_x2180 = list_x2957_rd_x2178(1)
  val x2094_tmp_0 = list_x2094_tmp_0(0)
  val x2178_reg = list_x2094_tmp_0(1)
  val x2090_tmp_1 = list_x2094_tmp_0(2)
  val x2093_tmp_4 = list_x2094_tmp_0(3)
  val x2147_r_0 = list_x2094_tmp_0(4)
  val x2089_tmp_0 = list_x2094_tmp_0(5)
  val x2097_tmp_3 = list_x2094_tmp_0(6)
  val x2180_reg = list_x2094_tmp_0(7)
  val x2096_tmp_2 = list_x2094_tmp_0(8)
  val x2092_tmp_3 = list_x2094_tmp_0(9)
  val x2098_tmp_4 = list_x2094_tmp_0(10)
  val x2095_tmp_1 = list_x2094_tmp_0(11)
  val x2091_tmp_2 = list_x2094_tmp_0(12)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2231_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2231_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2231_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2231_inr_Switch = Module(new InstrumentationCounter())
      val iters_x2231_inr_Switch = Module(new InstrumentationCounter())
      cycles_x2231_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x2231_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2231_instrctr, cycles_x2231_inr_Switch.io.count, iters_x2231_inr_Switch.io.count, 0.U, 0.U)
      val x2229_inr_SwitchCase_obj = new x2229_inr_SwitchCase_kernel(List(x2178_reg,x2147_r_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2229_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x2229_inr_SwitchCase_obj.childId)
      x2229_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x2229_inr_SwitchCase_obj.sm.io.ctrInc)
      x2229_inr_SwitchCase_obj.backpressure := true.B | x2229_inr_SwitchCase_obj.sm.io.doneLatch
      x2229_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x2229_inr_SwitchCase_obj.sm.io.doneLatch
      x2229_inr_SwitchCase_obj.sm.io.enableOut.zip(x2229_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2229_inr_SwitchCase_obj.sm.io.break := false.B
      val x2229_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2229_inr_SwitchCase""")
      x2229_inr_SwitchCase_obj.mask := true.B & true.B
      x2229_inr_SwitchCase_obj.configure("x2229_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x2229_inr_SwitchCase.r := x2229_inr_SwitchCase_obj.kernel().r
      val x2230_inr_SwitchCase_obj = new x2230_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2230_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x2230_inr_SwitchCase_obj.childId)
      x2230_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x2230_inr_SwitchCase_obj.sm.io.ctrInc)
      x2230_inr_SwitchCase_obj.backpressure := true.B | x2230_inr_SwitchCase_obj.sm.io.doneLatch
      x2230_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x2230_inr_SwitchCase_obj.sm.io.doneLatch
      x2230_inr_SwitchCase_obj.sm.io.enableOut.zip(x2230_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2230_inr_SwitchCase_obj.sm.io.break := false.B
      val x2230_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2230_inr_SwitchCase""")
      x2230_inr_SwitchCase_obj.mask := true.B & true.B
      x2230_inr_SwitchCase_obj.configure("x2230_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x2230_inr_SwitchCase.r := x2230_inr_SwitchCase_obj.kernel().r
      val x2231_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x2231_inr_Switch_onehot_selects""")
      val x2231_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x2231_inr_Switch_data_options""")
      x2231_inr_Switch_onehot_selects(0) := x2957_rd_x2178
      x2231_inr_Switch_data_options(0) := x2229_inr_SwitchCase
      x2231_inr_Switch_onehot_selects(1) := x2958_rd_x2180
      x2231_inr_Switch_data_options(1) := x2230_inr_SwitchCase
      io.ret.r := Mux1H(x2231_inr_Switch_onehot_selects, x2231_inr_Switch_data_options).r
      x2089_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2090_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2091_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2092_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2093_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2094_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2095_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2096_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2097_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2098_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2147_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2178_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2180_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
    }
    val module = Module(new x2231_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x2231_inr_Switch **/
