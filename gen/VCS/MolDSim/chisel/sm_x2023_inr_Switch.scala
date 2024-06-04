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

/** Hierarchy: x2023 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2023_inr_Switch **/
class x2023_inr_Switch_kernel(
  list_x2953_rd_x1970: List[Bool],
  list_x1882_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Fork, false   ,cases = 2, latency = 103.0.toInt, myName = "x2023_inr_Switch_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2023_inr_Switch_iiCtr"))
  
  abstract class x2023_inr_Switch_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1882_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1882_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2953_rd_x1970 = Input(Bool())
      val in_x1939_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1939_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1887_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1887_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1890_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1890_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1886_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1886_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2954_rd_x1972 = Input(Bool())
      val in_x1883_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1883_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1888_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1888_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1970_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1970_reg_p").asInstanceOf[NBufParams] ))
      val in_x1889_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1889_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1884_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1884_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1972_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1972_reg_p").asInstanceOf[NBufParams] ))
      val in_x1881_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1881_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1885_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1885_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1882_tmp_1 = {io.in_x1882_tmp_1} ; io.in_x1882_tmp_1 := DontCare
    def x2953_rd_x1970 = {io.in_x2953_rd_x1970} 
    def x1939_r_0 = {io.in_x1939_r_0} ; io.in_x1939_r_0 := DontCare
    def x1887_tmp_1 = {io.in_x1887_tmp_1} ; io.in_x1887_tmp_1 := DontCare
    def x1890_tmp_4 = {io.in_x1890_tmp_4} ; io.in_x1890_tmp_4 := DontCare
    def x1886_tmp_0 = {io.in_x1886_tmp_0} ; io.in_x1886_tmp_0 := DontCare
    def x2954_rd_x1972 = {io.in_x2954_rd_x1972} 
    def x1883_tmp_2 = {io.in_x1883_tmp_2} ; io.in_x1883_tmp_2 := DontCare
    def x1888_tmp_2 = {io.in_x1888_tmp_2} ; io.in_x1888_tmp_2 := DontCare
    def x1970_reg = {io.in_x1970_reg} ; io.in_x1970_reg := DontCare
    def x1889_tmp_3 = {io.in_x1889_tmp_3} ; io.in_x1889_tmp_3 := DontCare
    def x1884_tmp_3 = {io.in_x1884_tmp_3} ; io.in_x1884_tmp_3 := DontCare
    def x1972_reg = {io.in_x1972_reg} ; io.in_x1972_reg := DontCare
    def x1881_tmp_0 = {io.in_x1881_tmp_0} ; io.in_x1881_tmp_0 := DontCare
    def x1885_tmp_4 = {io.in_x1885_tmp_4} ; io.in_x1885_tmp_4 := DontCare
  }
  def connectWires0(module: x2023_inr_Switch_module)(implicit stack: List[KernelHash]): Unit = {
    x1882_tmp_1.connectLedger(module.io.in_x1882_tmp_1)
    module.io.in_x2953_rd_x1970 <> x2953_rd_x1970
    x1939_r_0.connectLedger(module.io.in_x1939_r_0)
    x1887_tmp_1.connectLedger(module.io.in_x1887_tmp_1)
    x1890_tmp_4.connectLedger(module.io.in_x1890_tmp_4)
    x1886_tmp_0.connectLedger(module.io.in_x1886_tmp_0)
    module.io.in_x2954_rd_x1972 <> x2954_rd_x1972
    x1883_tmp_2.connectLedger(module.io.in_x1883_tmp_2)
    x1888_tmp_2.connectLedger(module.io.in_x1888_tmp_2)
    x1970_reg.connectLedger(module.io.in_x1970_reg)
    x1889_tmp_3.connectLedger(module.io.in_x1889_tmp_3)
    x1884_tmp_3.connectLedger(module.io.in_x1884_tmp_3)
    x1972_reg.connectLedger(module.io.in_x1972_reg)
    x1881_tmp_0.connectLedger(module.io.in_x1881_tmp_0)
    x1885_tmp_4.connectLedger(module.io.in_x1885_tmp_4)
  }
  val x2953_rd_x1970 = list_x2953_rd_x1970(0)
  val x2954_rd_x1972 = list_x2953_rd_x1970(1)
  val x1882_tmp_1 = list_x1882_tmp_1(0)
  val x1939_r_0 = list_x1882_tmp_1(1)
  val x1887_tmp_1 = list_x1882_tmp_1(2)
  val x1890_tmp_4 = list_x1882_tmp_1(3)
  val x1886_tmp_0 = list_x1882_tmp_1(4)
  val x1883_tmp_2 = list_x1882_tmp_1(5)
  val x1888_tmp_2 = list_x1882_tmp_1(6)
  val x1970_reg = list_x1882_tmp_1(7)
  val x1889_tmp_3 = list_x1882_tmp_1(8)
  val x1884_tmp_3 = list_x1882_tmp_1(9)
  val x1972_reg = list_x1882_tmp_1(10)
  val x1881_tmp_0 = list_x1882_tmp_1(11)
  val x1885_tmp_4 = list_x1882_tmp_1(12)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2023_inr_Switch_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2023_inr_Switch_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2023_inr_Switch_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2023_inr_Switch = Module(new InstrumentationCounter())
      val iters_x2023_inr_Switch = Module(new InstrumentationCounter())
      cycles_x2023_inr_Switch.io.enable := io.sigsIn.baseEn
      iters_x2023_inr_Switch.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2023_instrctr, cycles_x2023_inr_Switch.io.count, iters_x2023_inr_Switch.io.count, 0.U, 0.U)
      val x2021_inr_SwitchCase_obj = new x2021_inr_SwitchCase_kernel(List(x1939_r_0,x1970_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2021_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x2021_inr_SwitchCase_obj.childId)
      x2021_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x2021_inr_SwitchCase_obj.sm.io.ctrInc)
      x2021_inr_SwitchCase_obj.backpressure := true.B | x2021_inr_SwitchCase_obj.sm.io.doneLatch
      x2021_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x2021_inr_SwitchCase_obj.sm.io.doneLatch
      x2021_inr_SwitchCase_obj.sm.io.enableOut.zip(x2021_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2021_inr_SwitchCase_obj.sm.io.break := false.B
      val x2021_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2021_inr_SwitchCase""")
      x2021_inr_SwitchCase_obj.mask := true.B & true.B
      x2021_inr_SwitchCase_obj.configure("x2021_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x2021_inr_SwitchCase.r := x2021_inr_SwitchCase_obj.kernel().r
      val x2022_inr_SwitchCase_obj = new x2022_inr_SwitchCase_kernel(   Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2022_inr_SwitchCase_obj.baseEn := io.sigsIn.smSelectsOut(x2022_inr_SwitchCase_obj.childId)
      x2022_inr_SwitchCase_obj.sm.io.ctrDone := risingEdge(x2022_inr_SwitchCase_obj.sm.io.ctrInc)
      x2022_inr_SwitchCase_obj.backpressure := true.B | x2022_inr_SwitchCase_obj.sm.io.doneLatch
      x2022_inr_SwitchCase_obj.forwardpressure := (true.B) && (true.B) | x2022_inr_SwitchCase_obj.sm.io.doneLatch
      x2022_inr_SwitchCase_obj.sm.io.enableOut.zip(x2022_inr_SwitchCase_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2022_inr_SwitchCase_obj.sm.io.break := false.B
      val x2022_inr_SwitchCase = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2022_inr_SwitchCase""")
      x2022_inr_SwitchCase_obj.mask := true.B & true.B
      x2022_inr_SwitchCase_obj.configure("x2022_inr_SwitchCase_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = true)
      x2022_inr_SwitchCase.r := x2022_inr_SwitchCase_obj.kernel().r
      val x2023_inr_Switch_onehot_selects = Wire(Vec(2, Bool())).suggestName("""x2023_inr_Switch_onehot_selects""")
      val x2023_inr_Switch_data_options = Wire(Vec(2, new FixedPoint(true, 10, 22))).suggestName("""x2023_inr_Switch_data_options""")
      x2023_inr_Switch_onehot_selects(0) := x2953_rd_x1970
      x2023_inr_Switch_data_options(0) := x2021_inr_SwitchCase
      x2023_inr_Switch_onehot_selects(1) := x2954_rd_x1972
      x2023_inr_Switch_data_options(1) := x2022_inr_SwitchCase
      io.ret.r := Mux1H(x2023_inr_Switch_onehot_selects, x2023_inr_Switch_data_options).r
      x1881_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1882_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1883_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1884_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1885_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1886_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1887_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1888_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1889_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1890_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x1939_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 3)
      x1970_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1972_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
    }
    val module = Module(new x2023_inr_Switch_concrete(sm.p.depth)); module.io := DontCare
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
/** END Switch x2023_inr_Switch **/
