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

/** Hierarchy: x775 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x775_inr_Switch **/
class x775_inr_Switch_kernel(
  list_x2929_rd_x722: List[Bool],
  list_x724_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x775_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x775_inr_Switch_iiCtr"))
  
  abstract class x775_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x724_reg = Flipped(new NBufInterface(ModuleParams.getParams("x724_reg_p").asInstanceOf[NBufParams] ))
      val in_x638_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x638_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2929_rd_x722 = Input(Bool())
      val in_x634_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x634_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x642_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x642_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x637_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x637_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x633_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x633_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x641_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x641_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x636_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x636_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x722_reg = Flipped(new NBufInterface(ModuleParams.getParams("x722_reg_p").asInstanceOf[NBufParams] ))
      val in_x640_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x640_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2930_rd_x724 = Input(Bool())
      val in_x635_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x635_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x691_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x691_r_0_p").asInstanceOf[NBufParams] ))
      val in_x639_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x639_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x724_reg = {io.in_x724_reg} ; io.in_x724_reg := DontCare
    def x638_tmp_0 = {io.in_x638_tmp_0} ; io.in_x638_tmp_0 := DontCare
    def x2929_rd_x722 = {io.in_x2929_rd_x722} 
    def x634_tmp_1 = {io.in_x634_tmp_1} ; io.in_x634_tmp_1 := DontCare
    def x642_tmp_4 = {io.in_x642_tmp_4} ; io.in_x642_tmp_4 := DontCare
    def x637_tmp_4 = {io.in_x637_tmp_4} ; io.in_x637_tmp_4 := DontCare
    def x633_tmp_0 = {io.in_x633_tmp_0} ; io.in_x633_tmp_0 := DontCare
    def x641_tmp_3 = {io.in_x641_tmp_3} ; io.in_x641_tmp_3 := DontCare
    def x636_tmp_3 = {io.in_x636_tmp_3} ; io.in_x636_tmp_3 := DontCare
    def x722_reg = {io.in_x722_reg} ; io.in_x722_reg := DontCare
    def x640_tmp_2 = {io.in_x640_tmp_2} ; io.in_x640_tmp_2 := DontCare
    def x2930_rd_x724 = {io.in_x2930_rd_x724} 
    def x635_tmp_2 = {io.in_x635_tmp_2} ; io.in_x635_tmp_2 := DontCare
    def x691_r_0 = {io.in_x691_r_0} ; io.in_x691_r_0 := DontCare
    def x639_tmp_1 = {io.in_x639_tmp_1} ; io.in_x639_tmp_1 := DontCare
  }
  def connectWires0(module: x775_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x724_reg.connectLedger(module.io.in_x724_reg)
    x638_tmp_0.connectLedger(module.io.in_x638_tmp_0)
    module.io.in_x2929_rd_x722 <> x2929_rd_x722
    x634_tmp_1.connectLedger(module.io.in_x634_tmp_1)
    x642_tmp_4.connectLedger(module.io.in_x642_tmp_4)
    x637_tmp_4.connectLedger(module.io.in_x637_tmp_4)
    x633_tmp_0.connectLedger(module.io.in_x633_tmp_0)
    x641_tmp_3.connectLedger(module.io.in_x641_tmp_3)
    x636_tmp_3.connectLedger(module.io.in_x636_tmp_3)
    x722_reg.connectLedger(module.io.in_x722_reg)
    x640_tmp_2.connectLedger(module.io.in_x640_tmp_2)
    module.io.in_x2930_rd_x724 <> x2930_rd_x724
    x635_tmp_2.connectLedger(module.io.in_x635_tmp_2)
    x691_r_0.connectLedger(module.io.in_x691_r_0)
    x639_tmp_1.connectLedger(module.io.in_x639_tmp_1)
  }
  val x2929_rd_x722 = list_x2929_rd_x722(0)
  val x2930_rd_x724 = list_x2929_rd_x722(1)
  val x724_reg = list_x724_reg(0)
  val x638_tmp_0 = list_x724_reg(1)
  val x634_tmp_1 = list_x724_reg(2)
  val x642_tmp_4 = list_x724_reg(3)
  val x637_tmp_4 = list_x724_reg(4)
  val x633_tmp_0 = list_x724_reg(5)
  val x641_tmp_3 = list_x724_reg(6)
  val x636_tmp_3 = list_x724_reg(7)
  val x722_reg = list_x724_reg(8)
  val x640_tmp_2 = list_x724_reg(9)
  val x635_tmp_2 = list_x724_reg(10)
  val x691_r_0 = list_x724_reg(11)
  val x639_tmp_1 = list_x724_reg(12)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x775_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x775_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x775_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x775_inr_Switch = Module(new InstrumentationCounter())
      val iters_x775_inr_Switch = Module(new InstrumentationCounter())
      cycles_x775_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x775_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X775_instrctr, cycles_x775_inr_Switch.io.count, iters_x775_inr_Switch.io.count, 0.U, 0.U)
      val x773_inr_SwitchCase_obj = new x773_inr_SwitchCase_kernel(List(x722_reg,x691_r_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x773_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x773_inr_SwitchCase_obj.childId)
      x773_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x773_inr_SwitchCase_obj.sm.io.ctrInc)
      x773_inr_SwitchCase_obj.backpressure := true.B | x773_inr_SwitchCase_obj.sm.io.doneLatch
      x773_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x773_inr_SwitchCase_obj.sm.io.doneLatch
      x773_inr_SwitchCase_obj.sm.io.enableOut.zip(x773_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x773_inr_SwitchCase_obj.sm.io.break := false.B
      val x773_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x773_inr_SwitchCase""")
      x773_inr_SwitchCase_obj.mask := true.B & true.B
      x773_inr_SwitchCase_obj.configure("x773_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x773_inr_SwitchCase.r := x773_inr_SwitchCase_obj.kernel().r
      val x774_inr_SwitchCase_obj = new x774_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x774_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x774_inr_SwitchCase_obj.childId)
      x774_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x774_inr_SwitchCase_obj.sm.io.ctrInc)
      x774_inr_SwitchCase_obj.backpressure := true.B | x774_inr_SwitchCase_obj.sm.io.doneLatch
      x774_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x774_inr_SwitchCase_obj.sm.io.doneLatch
      x774_inr_SwitchCase_obj.sm.io.enableOut.zip(x774_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x774_inr_SwitchCase_obj.sm.io.break := false.B
      val x774_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x774_inr_SwitchCase""")
      x774_inr_SwitchCase_obj.mask := true.B & true.B
      x774_inr_SwitchCase_obj.configure("x774_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x774_inr_SwitchCase.r := x774_inr_SwitchCase_obj.kernel().r
      val x775_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x775_inr_Switch_onehot_selects""")
      val x775_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x775_inr_Switch_data_options""")
      x775_inr_Switch_onehot_selects(0) := x2929_rd_x722
      x775_inr_Switch_data_options(0) := x773_inr_SwitchCase
      x775_inr_Switch_onehot_selects(1) := x2930_rd_x724
      x775_inr_Switch_data_options(1) := x774_inr_SwitchCase
      io.ret.r := Mux1H(x775_inr_Switch_onehot_selects, x775_inr_Switch_data_options).r
      x633_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x634_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x635_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x636_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x637_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x638_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x639_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x640_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x641_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x642_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x691_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x722_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x724_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
    }
    val module = Module(new x775_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x775_inr_Switch **/
