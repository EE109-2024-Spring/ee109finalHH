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

/** Hierarchy: x951 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x951 **/
class x951_kernel(
  list_b838: List[Bool],
  list_x846_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x951_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x951_iiCtr"))
  
  abstract class x951_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x846_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x846_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x930_reg = Flipped(new NBufInterface(ModuleParams.getParams("x930_reg_p").asInstanceOf[NBufParams] ))
      val in_x898_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x898_r_0_p").asInstanceOf[NBufParams] ))
      val in_x841_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x841_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b838 = Input(Bool())
      val in_x849_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x849_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x847_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x847_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x842_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x842_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b558 = Input(Bool())
      val in_x843_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x843_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x848_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x848_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x932_reg = Flipped(new NBufInterface(ModuleParams.getParams("x932_reg_p").asInstanceOf[NBufParams] ))
      val in_x845_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x845_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x931_reg = Flipped(new NBufInterface(ModuleParams.getParams("x931_reg_p").asInstanceOf[NBufParams] ))
      val in_x844_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x844_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x929_reg = Flipped(new NBufInterface(ModuleParams.getParams("x929_reg_p").asInstanceOf[NBufParams] ))
      val in_x899_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x899_r_0_p").asInstanceOf[NBufParams] ))
      val in_b839 = Input(Bool())
      val in_x850_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x850_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x846_tmp_0 = {io.in_x846_tmp_0} ; io.in_x846_tmp_0 := DontCare
    def x930_reg = {io.in_x930_reg} ; io.in_x930_reg := DontCare
    def x898_r_0 = {io.in_x898_r_0} ; io.in_x898_r_0 := DontCare
    def x841_tmp_0 = {io.in_x841_tmp_0} ; io.in_x841_tmp_0 := DontCare
    def b838 = {io.in_b838} 
    def x849_tmp_3 = {io.in_x849_tmp_3} ; io.in_x849_tmp_3 := DontCare
    def x847_tmp_1 = {io.in_x847_tmp_1} ; io.in_x847_tmp_1 := DontCare
    def x842_tmp_1 = {io.in_x842_tmp_1} ; io.in_x842_tmp_1 := DontCare
    def b558 = {io.in_b558} 
    def x843_tmp_2 = {io.in_x843_tmp_2} ; io.in_x843_tmp_2 := DontCare
    def x848_tmp_2 = {io.in_x848_tmp_2} ; io.in_x848_tmp_2 := DontCare
    def x932_reg = {io.in_x932_reg} ; io.in_x932_reg := DontCare
    def x845_tmp_4 = {io.in_x845_tmp_4} ; io.in_x845_tmp_4 := DontCare
    def x931_reg = {io.in_x931_reg} ; io.in_x931_reg := DontCare
    def x844_tmp_3 = {io.in_x844_tmp_3} ; io.in_x844_tmp_3 := DontCare
    def x929_reg = {io.in_x929_reg} ; io.in_x929_reg := DontCare
    def x899_r_0 = {io.in_x899_r_0} ; io.in_x899_r_0 := DontCare
    def b839 = {io.in_b839} 
    def x850_tmp_4 = {io.in_x850_tmp_4} ; io.in_x850_tmp_4 := DontCare
  }
  def connectWires0(module: x951_module)(implicit stack: List[KernelHash]): Unit = {
    x846_tmp_0.connectLedger(module.io.in_x846_tmp_0)
    x930_reg.connectLedger(module.io.in_x930_reg)
    x898_r_0.connectLedger(module.io.in_x898_r_0)
    x841_tmp_0.connectLedger(module.io.in_x841_tmp_0)
    module.io.in_b838 <> b838
    x849_tmp_3.connectLedger(module.io.in_x849_tmp_3)
    x847_tmp_1.connectLedger(module.io.in_x847_tmp_1)
    x842_tmp_1.connectLedger(module.io.in_x842_tmp_1)
    module.io.in_b558 <> b558
    x843_tmp_2.connectLedger(module.io.in_x843_tmp_2)
    x848_tmp_2.connectLedger(module.io.in_x848_tmp_2)
    x932_reg.connectLedger(module.io.in_x932_reg)
    x845_tmp_4.connectLedger(module.io.in_x845_tmp_4)
    x931_reg.connectLedger(module.io.in_x931_reg)
    x844_tmp_3.connectLedger(module.io.in_x844_tmp_3)
    x929_reg.connectLedger(module.io.in_x929_reg)
    x899_r_0.connectLedger(module.io.in_x899_r_0)
    module.io.in_b839 <> b839
    x850_tmp_4.connectLedger(module.io.in_x850_tmp_4)
  }
  val b838 = list_b838(0)
  val b558 = list_b838(1)
  val b839 = list_b838(2)
  val x846_tmp_0 = list_x846_tmp_0(0)
  val x930_reg = list_x846_tmp_0(1)
  val x898_r_0 = list_x846_tmp_0(2)
  val x841_tmp_0 = list_x846_tmp_0(3)
  val x849_tmp_3 = list_x846_tmp_0(4)
  val x847_tmp_1 = list_x846_tmp_0(5)
  val x842_tmp_1 = list_x846_tmp_0(6)
  val x843_tmp_2 = list_x846_tmp_0(7)
  val x848_tmp_2 = list_x846_tmp_0(8)
  val x932_reg = list_x846_tmp_0(9)
  val x845_tmp_4 = list_x846_tmp_0(10)
  val x931_reg = list_x846_tmp_0(11)
  val x844_tmp_3 = list_x846_tmp_0(12)
  val x929_reg = list_x846_tmp_0(13)
  val x899_r_0 = list_x846_tmp_0(14)
  val x850_tmp_4 = list_x846_tmp_0(15)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x951")
    implicit val stack = ControllerStack.stack.toList
    class x951_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x951_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x951 = Module(new InstrumentationCounter())
      val iters_x951 = Module(new InstrumentationCounter())
      cycles_x951.io.enable := io.sigsIn.baseEn
      iters_x951.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X951_instrctr, cycles_x951.io.count, iters_x951.io.count, 0.U, 0.U)
      val x941_inr_UnitPipe = new x941_inr_UnitPipe_kernel(List(b838,b558), List(x898_r_0,x931_reg,x929_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x941_inr_UnitPipe.sm.io.ctrDone := risingEdge(x941_inr_UnitPipe.sm.io.ctrInc)
      x941_inr_UnitPipe.backpressure := true.B | x941_inr_UnitPipe.sm.io.doneLatch
      x941_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x941_inr_UnitPipe.sm.io.doneLatch
      x941_inr_UnitPipe.sm.io.enableOut.zip(x941_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x941_inr_UnitPipe.sm.io.break := false.B
      x941_inr_UnitPipe.mask := true.B & b838 & b558
      x941_inr_UnitPipe.configure("x941_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x941_inr_UnitPipe.kernel()
      val x950_inr_UnitPipe = new x950_inr_UnitPipe_kernel(List(b558,b839), List(x930_reg,x932_reg,x899_r_0) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x950_inr_UnitPipe.sm.io.ctrDone := risingEdge(x950_inr_UnitPipe.sm.io.ctrInc)
      x950_inr_UnitPipe.backpressure := true.B | x950_inr_UnitPipe.sm.io.doneLatch
      x950_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x950_inr_UnitPipe.sm.io.doneLatch
      x950_inr_UnitPipe.sm.io.enableOut.zip(x950_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x950_inr_UnitPipe.sm.io.break := false.B
      x950_inr_UnitPipe.mask := true.B & b839 & b558
      x950_inr_UnitPipe.configure("x950_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x950_inr_UnitPipe.kernel()
      x841_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x842_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x843_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x844_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x845_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x846_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x847_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x848_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x849_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x850_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x898_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x899_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x929_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x930_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x931_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x932_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x951_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x951 **/
