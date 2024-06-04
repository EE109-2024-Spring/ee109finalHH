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

/** Hierarchy: x2439 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2439_inr_Switch **/
class x2439_inr_Switch_kernel(
  list_x2962_rd_x2388: List[Bool],
  list_x2306_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x2439_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2439_inr_Switch_iiCtr"))
  
  abstract class x2439_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2306_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2306_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2301_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2301_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2388_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2388_reg_p").asInstanceOf[NBufParams] ))
      val in_x2300_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2300_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2304_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2304_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2355_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2355_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2299_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2299_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2962_rd_x2388 = Input(Bool())
      val in_x2303_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2303_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2298_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2298_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2386_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2386_reg_p").asInstanceOf[NBufParams] ))
      val in_x2305_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2305_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2302_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2302_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2961_rd_x2386 = Input(Bool())
      val in_x2297_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2297_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2306_tmp_4 = {io.in_x2306_tmp_4} ; io.in_x2306_tmp_4 := DontCare
    def x2301_tmp_4 = {io.in_x2301_tmp_4} ; io.in_x2301_tmp_4 := DontCare
    def x2388_reg = {io.in_x2388_reg} ; io.in_x2388_reg := DontCare
    def x2300_tmp_3 = {io.in_x2300_tmp_3} ; io.in_x2300_tmp_3 := DontCare
    def x2304_tmp_2 = {io.in_x2304_tmp_2} ; io.in_x2304_tmp_2 := DontCare
    def x2355_r_0 = {io.in_x2355_r_0} ; io.in_x2355_r_0 := DontCare
    def x2299_tmp_2 = {io.in_x2299_tmp_2} ; io.in_x2299_tmp_2 := DontCare
    def x2962_rd_x2388 = {io.in_x2962_rd_x2388} 
    def x2303_tmp_1 = {io.in_x2303_tmp_1} ; io.in_x2303_tmp_1 := DontCare
    def x2298_tmp_1 = {io.in_x2298_tmp_1} ; io.in_x2298_tmp_1 := DontCare
    def x2386_reg = {io.in_x2386_reg} ; io.in_x2386_reg := DontCare
    def x2305_tmp_3 = {io.in_x2305_tmp_3} ; io.in_x2305_tmp_3 := DontCare
    def x2302_tmp_0 = {io.in_x2302_tmp_0} ; io.in_x2302_tmp_0 := DontCare
    def x2961_rd_x2386 = {io.in_x2961_rd_x2386} 
    def x2297_tmp_0 = {io.in_x2297_tmp_0} ; io.in_x2297_tmp_0 := DontCare
  }
  def connectWires0(module: x2439_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x2306_tmp_4.connectLedger(module.io.in_x2306_tmp_4)
    x2301_tmp_4.connectLedger(module.io.in_x2301_tmp_4)
    x2388_reg.connectLedger(module.io.in_x2388_reg)
    x2300_tmp_3.connectLedger(module.io.in_x2300_tmp_3)
    x2304_tmp_2.connectLedger(module.io.in_x2304_tmp_2)
    x2355_r_0.connectLedger(module.io.in_x2355_r_0)
    x2299_tmp_2.connectLedger(module.io.in_x2299_tmp_2)
    module.io.in_x2962_rd_x2388 <> x2962_rd_x2388
    x2303_tmp_1.connectLedger(module.io.in_x2303_tmp_1)
    x2298_tmp_1.connectLedger(module.io.in_x2298_tmp_1)
    x2386_reg.connectLedger(module.io.in_x2386_reg)
    x2305_tmp_3.connectLedger(module.io.in_x2305_tmp_3)
    x2302_tmp_0.connectLedger(module.io.in_x2302_tmp_0)
    module.io.in_x2961_rd_x2386 <> x2961_rd_x2386
    x2297_tmp_0.connectLedger(module.io.in_x2297_tmp_0)
  }
  val x2962_rd_x2388 = list_x2962_rd_x2388(0)
  val x2961_rd_x2386 = list_x2962_rd_x2388(1)
  val x2306_tmp_4 = list_x2306_tmp_4(0)
  val x2301_tmp_4 = list_x2306_tmp_4(1)
  val x2388_reg = list_x2306_tmp_4(2)
  val x2300_tmp_3 = list_x2306_tmp_4(3)
  val x2304_tmp_2 = list_x2306_tmp_4(4)
  val x2355_r_0 = list_x2306_tmp_4(5)
  val x2299_tmp_2 = list_x2306_tmp_4(6)
  val x2303_tmp_1 = list_x2306_tmp_4(7)
  val x2298_tmp_1 = list_x2306_tmp_4(8)
  val x2386_reg = list_x2306_tmp_4(9)
  val x2305_tmp_3 = list_x2306_tmp_4(10)
  val x2302_tmp_0 = list_x2306_tmp_4(11)
  val x2297_tmp_0 = list_x2306_tmp_4(12)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2439_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2439_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2439_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2439_inr_Switch = Module(new InstrumentationCounter())
      val iters_x2439_inr_Switch = Module(new InstrumentationCounter())
      cycles_x2439_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x2439_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2439_instrctr, cycles_x2439_inr_Switch.io.count, iters_x2439_inr_Switch.io.count, 0.U, 0.U)
      val x2437_inr_SwitchCase_obj = new x2437_inr_SwitchCase_kernel(List(x2355_r_0,x2386_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2437_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x2437_inr_SwitchCase_obj.childId)
      x2437_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x2437_inr_SwitchCase_obj.sm.io.ctrInc)
      x2437_inr_SwitchCase_obj.backpressure := true.B | x2437_inr_SwitchCase_obj.sm.io.doneLatch
      x2437_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x2437_inr_SwitchCase_obj.sm.io.doneLatch
      x2437_inr_SwitchCase_obj.sm.io.enableOut.zip(x2437_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2437_inr_SwitchCase_obj.sm.io.break := false.B
      val x2437_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2437_inr_SwitchCase""")
      x2437_inr_SwitchCase_obj.mask := true.B & true.B
      x2437_inr_SwitchCase_obj.configure("x2437_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x2437_inr_SwitchCase.r := x2437_inr_SwitchCase_obj.kernel().r
      val x2438_inr_SwitchCase_obj = new x2438_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2438_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x2438_inr_SwitchCase_obj.childId)
      x2438_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x2438_inr_SwitchCase_obj.sm.io.ctrInc)
      x2438_inr_SwitchCase_obj.backpressure := true.B | x2438_inr_SwitchCase_obj.sm.io.doneLatch
      x2438_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x2438_inr_SwitchCase_obj.sm.io.doneLatch
      x2438_inr_SwitchCase_obj.sm.io.enableOut.zip(x2438_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2438_inr_SwitchCase_obj.sm.io.break := false.B
      val x2438_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2438_inr_SwitchCase""")
      x2438_inr_SwitchCase_obj.mask := true.B & true.B
      x2438_inr_SwitchCase_obj.configure("x2438_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x2438_inr_SwitchCase.r := x2438_inr_SwitchCase_obj.kernel().r
      val x2439_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x2439_inr_Switch_onehot_selects""")
      val x2439_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x2439_inr_Switch_data_options""")
      x2439_inr_Switch_onehot_selects(0) := x2961_rd_x2386
      x2439_inr_Switch_data_options(0) := x2437_inr_SwitchCase
      x2439_inr_Switch_onehot_selects(1) := x2962_rd_x2388
      x2439_inr_Switch_data_options(1) := x2438_inr_SwitchCase
      io.ret.r := Mux1H(x2439_inr_Switch_onehot_selects, x2439_inr_Switch_data_options).r
      x2297_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2298_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2299_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2300_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2301_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2302_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2303_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2304_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2305_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2306_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x2355_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x2386_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x2388_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
    }
    val module = Module(new x2439_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x2439_inr_Switch **/
