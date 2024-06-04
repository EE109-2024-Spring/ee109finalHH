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

/** Hierarchy: x2633 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2633_inr_Switch **/
class x2633_inr_Switch_kernel(
  list_x2964_rd_x2595: List[Bool],
  list_x2595_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x2633_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2633_inr_Switch_iiCtr"))
  
  abstract class x2633_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2595_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2595_reg_p").asInstanceOf[NBufParams] ))
      val in_x2512_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2512_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2562_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2562_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2508_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2508_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2964_rd_x2595 = Input(Bool())
      val in_x2596_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2596_reg_p").asInstanceOf[NBufParams] ))
      val in_x2509_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2509_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2505_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2505_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2963_rd_x2593 = Input(Bool())
      val in_x2514_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2514_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2510_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2510_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2593_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2593_reg_p").asInstanceOf[NBufParams] ))
      val in_x2506_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2506_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2513_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2513_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2511_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2511_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2594_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2594_reg_p").asInstanceOf[NBufParams] ))
      val in_x2507_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2507_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2563_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2563_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2595_reg = {io.in_x2595_reg} ; io.in_x2595_reg := DontCare
    def x2512_tmp_2 = {io.in_x2512_tmp_2} ; io.in_x2512_tmp_2 := DontCare
    def x2562_r_0 = {io.in_x2562_r_0} ; io.in_x2562_r_0 := DontCare
    def x2508_tmp_3 = {io.in_x2508_tmp_3} ; io.in_x2508_tmp_3 := DontCare
    def x2964_rd_x2595 = {io.in_x2964_rd_x2595} 
    def x2596_reg = {io.in_x2596_reg} ; io.in_x2596_reg := DontCare
    def x2509_tmp_4 = {io.in_x2509_tmp_4} ; io.in_x2509_tmp_4 := DontCare
    def x2505_tmp_0 = {io.in_x2505_tmp_0} ; io.in_x2505_tmp_0 := DontCare
    def x2963_rd_x2593 = {io.in_x2963_rd_x2593} 
    def x2514_tmp_4 = {io.in_x2514_tmp_4} ; io.in_x2514_tmp_4 := DontCare
    def x2510_tmp_0 = {io.in_x2510_tmp_0} ; io.in_x2510_tmp_0 := DontCare
    def x2593_reg = {io.in_x2593_reg} ; io.in_x2593_reg := DontCare
    def x2506_tmp_1 = {io.in_x2506_tmp_1} ; io.in_x2506_tmp_1 := DontCare
    def x2513_tmp_3 = {io.in_x2513_tmp_3} ; io.in_x2513_tmp_3 := DontCare
    def x2511_tmp_1 = {io.in_x2511_tmp_1} ; io.in_x2511_tmp_1 := DontCare
    def x2594_reg = {io.in_x2594_reg} ; io.in_x2594_reg := DontCare
    def x2507_tmp_2 = {io.in_x2507_tmp_2} ; io.in_x2507_tmp_2 := DontCare
    def x2563_r_0 = {io.in_x2563_r_0} ; io.in_x2563_r_0 := DontCare
  }
  def connectWires0(module: x2633_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x2595_reg.connectLedger(module.io.in_x2595_reg)
    x2512_tmp_2.connectLedger(module.io.in_x2512_tmp_2)
    x2562_r_0.connectLedger(module.io.in_x2562_r_0)
    x2508_tmp_3.connectLedger(module.io.in_x2508_tmp_3)
    module.io.in_x2964_rd_x2595 <> x2964_rd_x2595
    x2596_reg.connectLedger(module.io.in_x2596_reg)
    x2509_tmp_4.connectLedger(module.io.in_x2509_tmp_4)
    x2505_tmp_0.connectLedger(module.io.in_x2505_tmp_0)
    module.io.in_x2963_rd_x2593 <> x2963_rd_x2593
    x2514_tmp_4.connectLedger(module.io.in_x2514_tmp_4)
    x2510_tmp_0.connectLedger(module.io.in_x2510_tmp_0)
    x2593_reg.connectLedger(module.io.in_x2593_reg)
    x2506_tmp_1.connectLedger(module.io.in_x2506_tmp_1)
    x2513_tmp_3.connectLedger(module.io.in_x2513_tmp_3)
    x2511_tmp_1.connectLedger(module.io.in_x2511_tmp_1)
    x2594_reg.connectLedger(module.io.in_x2594_reg)
    x2507_tmp_2.connectLedger(module.io.in_x2507_tmp_2)
    x2563_r_0.connectLedger(module.io.in_x2563_r_0)
  }
  val x2964_rd_x2595 = list_x2964_rd_x2595(0)
  val x2963_rd_x2593 = list_x2964_rd_x2595(1)
  val x2595_reg = list_x2595_reg(0)
  val x2512_tmp_2 = list_x2595_reg(1)
  val x2562_r_0 = list_x2595_reg(2)
  val x2508_tmp_3 = list_x2595_reg(3)
  val x2596_reg = list_x2595_reg(4)
  val x2509_tmp_4 = list_x2595_reg(5)
  val x2505_tmp_0 = list_x2595_reg(6)
  val x2514_tmp_4 = list_x2595_reg(7)
  val x2510_tmp_0 = list_x2595_reg(8)
  val x2593_reg = list_x2595_reg(9)
  val x2506_tmp_1 = list_x2595_reg(10)
  val x2513_tmp_3 = list_x2595_reg(11)
  val x2511_tmp_1 = list_x2595_reg(12)
  val x2594_reg = list_x2595_reg(13)
  val x2507_tmp_2 = list_x2595_reg(14)
  val x2563_r_0 = list_x2595_reg(15)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2633_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2633_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2633_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2633_inr_Switch = Module(new InstrumentationCounter())
      val iters_x2633_inr_Switch = Module(new InstrumentationCounter())
      cycles_x2633_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x2633_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2633_instrctr, cycles_x2633_inr_Switch.io.count, iters_x2633_inr_Switch.io.count, 0.U, 0.U)
      val x2631_inr_SwitchCase_obj = new x2631_inr_SwitchCase_kernel(List(x2562_r_0,x2593_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2631_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x2631_inr_SwitchCase_obj.childId)
      x2631_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x2631_inr_SwitchCase_obj.sm.io.ctrInc)
      x2631_inr_SwitchCase_obj.backpressure := true.B | x2631_inr_SwitchCase_obj.sm.io.doneLatch
      x2631_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x2631_inr_SwitchCase_obj.sm.io.doneLatch
      x2631_inr_SwitchCase_obj.sm.io.enableOut.zip(x2631_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2631_inr_SwitchCase_obj.sm.io.break := false.B
      val x2631_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2631_inr_SwitchCase""")
      x2631_inr_SwitchCase_obj.mask := true.B & true.B
      x2631_inr_SwitchCase_obj.configure("x2631_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x2631_inr_SwitchCase.r := x2631_inr_SwitchCase_obj.kernel().r
      val x2632_inr_SwitchCase_obj = new x2632_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2632_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x2632_inr_SwitchCase_obj.childId)
      x2632_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x2632_inr_SwitchCase_obj.sm.io.ctrInc)
      x2632_inr_SwitchCase_obj.backpressure := true.B | x2632_inr_SwitchCase_obj.sm.io.doneLatch
      x2632_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x2632_inr_SwitchCase_obj.sm.io.doneLatch
      x2632_inr_SwitchCase_obj.sm.io.enableOut.zip(x2632_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2632_inr_SwitchCase_obj.sm.io.break := false.B
      val x2632_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2632_inr_SwitchCase""")
      x2632_inr_SwitchCase_obj.mask := true.B & true.B
      x2632_inr_SwitchCase_obj.configure("x2632_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x2632_inr_SwitchCase.r := x2632_inr_SwitchCase_obj.kernel().r
      val x2633_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x2633_inr_Switch_onehot_selects""")
      val x2633_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x2633_inr_Switch_data_options""")
      x2633_inr_Switch_onehot_selects(0) := x2963_rd_x2593
      x2633_inr_Switch_data_options(0) := x2631_inr_SwitchCase
      x2633_inr_Switch_onehot_selects(1) := x2964_rd_x2595
      x2633_inr_Switch_data_options(1) := x2632_inr_SwitchCase
      io.ret.r := Mux1H(x2633_inr_Switch_onehot_selects, x2633_inr_Switch_data_options).r
      x2505_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2506_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2507_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2508_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2509_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2510_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2511_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2512_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2513_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2514_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2562_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2563_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2593_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2594_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2595_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x2596_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x2633_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x2633_inr_Switch **/
