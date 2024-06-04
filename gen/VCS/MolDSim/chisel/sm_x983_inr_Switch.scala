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

/** Hierarchy: x983 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x983_inr_Switch **/
class x983_inr_Switch_kernel(
  list_x2933_rd_x930: List[Bool],
  list_x846_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x983_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x983_inr_Switch_iiCtr"))
  
  abstract class x983_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x846_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x846_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2933_rd_x930 = Input(Bool())
      val in_x930_reg = Flipped(new NBufInterface(ModuleParams.getParams("x930_reg_p").asInstanceOf[NBufParams] ))
      val in_x841_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x841_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x849_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x849_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x847_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x847_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x842_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x842_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x843_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x843_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x848_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x848_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x932_reg = Flipped(new NBufInterface(ModuleParams.getParams("x932_reg_p").asInstanceOf[NBufParams] ))
      val in_x845_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x845_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x844_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x844_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2934_rd_x932 = Input(Bool())
      val in_x899_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x899_r_0_p").asInstanceOf[NBufParams] ))
      val in_x850_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x850_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x846_tmp_0 = {io.in_x846_tmp_0} ; io.in_x846_tmp_0 := DontCare
    def x2933_rd_x930 = {io.in_x2933_rd_x930} 
    def x930_reg = {io.in_x930_reg} ; io.in_x930_reg := DontCare
    def x841_tmp_0 = {io.in_x841_tmp_0} ; io.in_x841_tmp_0 := DontCare
    def x849_tmp_3 = {io.in_x849_tmp_3} ; io.in_x849_tmp_3 := DontCare
    def x847_tmp_1 = {io.in_x847_tmp_1} ; io.in_x847_tmp_1 := DontCare
    def x842_tmp_1 = {io.in_x842_tmp_1} ; io.in_x842_tmp_1 := DontCare
    def x843_tmp_2 = {io.in_x843_tmp_2} ; io.in_x843_tmp_2 := DontCare
    def x848_tmp_2 = {io.in_x848_tmp_2} ; io.in_x848_tmp_2 := DontCare
    def x932_reg = {io.in_x932_reg} ; io.in_x932_reg := DontCare
    def x845_tmp_4 = {io.in_x845_tmp_4} ; io.in_x845_tmp_4 := DontCare
    def x844_tmp_3 = {io.in_x844_tmp_3} ; io.in_x844_tmp_3 := DontCare
    def x2934_rd_x932 = {io.in_x2934_rd_x932} 
    def x899_r_0 = {io.in_x899_r_0} ; io.in_x899_r_0 := DontCare
    def x850_tmp_4 = {io.in_x850_tmp_4} ; io.in_x850_tmp_4 := DontCare
  }
  def connectWires0(module: x983_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x846_tmp_0.connectLedger(module.io.in_x846_tmp_0)
    module.io.in_x2933_rd_x930 <> x2933_rd_x930
    x930_reg.connectLedger(module.io.in_x930_reg)
    x841_tmp_0.connectLedger(module.io.in_x841_tmp_0)
    x849_tmp_3.connectLedger(module.io.in_x849_tmp_3)
    x847_tmp_1.connectLedger(module.io.in_x847_tmp_1)
    x842_tmp_1.connectLedger(module.io.in_x842_tmp_1)
    x843_tmp_2.connectLedger(module.io.in_x843_tmp_2)
    x848_tmp_2.connectLedger(module.io.in_x848_tmp_2)
    x932_reg.connectLedger(module.io.in_x932_reg)
    x845_tmp_4.connectLedger(module.io.in_x845_tmp_4)
    x844_tmp_3.connectLedger(module.io.in_x844_tmp_3)
    module.io.in_x2934_rd_x932 <> x2934_rd_x932
    x899_r_0.connectLedger(module.io.in_x899_r_0)
    x850_tmp_4.connectLedger(module.io.in_x850_tmp_4)
  }
  val x2933_rd_x930 = list_x2933_rd_x930(0)
  val x2934_rd_x932 = list_x2933_rd_x930(1)
  val x846_tmp_0 = list_x846_tmp_0(0)
  val x930_reg = list_x846_tmp_0(1)
  val x841_tmp_0 = list_x846_tmp_0(2)
  val x849_tmp_3 = list_x846_tmp_0(3)
  val x847_tmp_1 = list_x846_tmp_0(4)
  val x842_tmp_1 = list_x846_tmp_0(5)
  val x843_tmp_2 = list_x846_tmp_0(6)
  val x848_tmp_2 = list_x846_tmp_0(7)
  val x932_reg = list_x846_tmp_0(8)
  val x845_tmp_4 = list_x846_tmp_0(9)
  val x844_tmp_3 = list_x846_tmp_0(10)
  val x899_r_0 = list_x846_tmp_0(11)
  val x850_tmp_4 = list_x846_tmp_0(12)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x983_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x983_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x983_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x983_inr_Switch = Module(new InstrumentationCounter())
      val iters_x983_inr_Switch = Module(new InstrumentationCounter())
      cycles_x983_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x983_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X983_instrctr, cycles_x983_inr_Switch.io.count, iters_x983_inr_Switch.io.count, 0.U, 0.U)
      val x981_inr_SwitchCase_obj = new x981_inr_SwitchCase_kernel(List(x930_reg,x899_r_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x981_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x981_inr_SwitchCase_obj.childId)
      x981_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x981_inr_SwitchCase_obj.sm.io.ctrInc)
      x981_inr_SwitchCase_obj.backpressure := true.B | x981_inr_SwitchCase_obj.sm.io.doneLatch
      x981_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x981_inr_SwitchCase_obj.sm.io.doneLatch
      x981_inr_SwitchCase_obj.sm.io.enableOut.zip(x981_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x981_inr_SwitchCase_obj.sm.io.break := false.B
      val x981_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x981_inr_SwitchCase""")
      x981_inr_SwitchCase_obj.mask := true.B & true.B
      x981_inr_SwitchCase_obj.configure("x981_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x981_inr_SwitchCase.r := x981_inr_SwitchCase_obj.kernel().r
      val x982_inr_SwitchCase_obj = new x982_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x982_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x982_inr_SwitchCase_obj.childId)
      x982_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x982_inr_SwitchCase_obj.sm.io.ctrInc)
      x982_inr_SwitchCase_obj.backpressure := true.B | x982_inr_SwitchCase_obj.sm.io.doneLatch
      x982_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x982_inr_SwitchCase_obj.sm.io.doneLatch
      x982_inr_SwitchCase_obj.sm.io.enableOut.zip(x982_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x982_inr_SwitchCase_obj.sm.io.break := false.B
      val x982_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x982_inr_SwitchCase""")
      x982_inr_SwitchCase_obj.mask := true.B & true.B
      x982_inr_SwitchCase_obj.configure("x982_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x982_inr_SwitchCase.r := x982_inr_SwitchCase_obj.kernel().r
      val x983_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x983_inr_Switch_onehot_selects""")
      val x983_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x983_inr_Switch_data_options""")
      x983_inr_Switch_onehot_selects(0) := x2933_rd_x930
      x983_inr_Switch_data_options(0) := x981_inr_SwitchCase
      x983_inr_Switch_onehot_selects(1) := x2934_rd_x932
      x983_inr_Switch_data_options(1) := x982_inr_SwitchCase
      io.ret.r := Mux1H(x983_inr_Switch_onehot_selects, x983_inr_Switch_data_options).r
      x841_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x842_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x843_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x844_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x845_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x846_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x847_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x848_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x849_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x850_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x899_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x930_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x932_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
    }
    val module = Module(new x983_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x983_inr_Switch **/
