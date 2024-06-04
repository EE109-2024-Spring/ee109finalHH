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

/** Hierarchy: x1021 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1021 **/
class x1021_kernel(
  list_b838: List[Bool],
  list_x991_ctrchain: List[CounterChainInterface],
  list_x846_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1021_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1021_iiCtr"))
  
  abstract class x1021_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x846_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x846_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x841_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x841_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b838 = Input(Bool())
      val in_x849_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x849_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x847_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x847_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x842_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x842_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b558 = Input(Bool())
      val in_x843_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x843_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x848_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x848_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x927_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x927_force_0_p").asInstanceOf[NBufParams] ))
      val in_x991_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x991_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x845_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x845_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x844_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x844_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x928_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x928_force_0_p").asInstanceOf[NBufParams] ))
      val in_b839 = Input(Bool())
      val in_x992_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x992_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x850_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x850_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x846_tmp_0 = {io.in_x846_tmp_0} ; io.in_x846_tmp_0 := DontCare
    def x841_tmp_0 = {io.in_x841_tmp_0} ; io.in_x841_tmp_0 := DontCare
    def b838 = {io.in_b838} 
    def x849_tmp_3 = {io.in_x849_tmp_3} ; io.in_x849_tmp_3 := DontCare
    def x847_tmp_1 = {io.in_x847_tmp_1} ; io.in_x847_tmp_1 := DontCare
    def x842_tmp_1 = {io.in_x842_tmp_1} ; io.in_x842_tmp_1 := DontCare
    def b558 = {io.in_b558} 
    def x843_tmp_2 = {io.in_x843_tmp_2} ; io.in_x843_tmp_2 := DontCare
    def x848_tmp_2 = {io.in_x848_tmp_2} ; io.in_x848_tmp_2 := DontCare
    def x927_force_0 = {io.in_x927_force_0} ; io.in_x927_force_0 := DontCare
    def x991_ctrchain = {io.in_x991_ctrchain} ; io.in_x991_ctrchain := DontCare
    def x845_tmp_4 = {io.in_x845_tmp_4} ; io.in_x845_tmp_4 := DontCare
    def x844_tmp_3 = {io.in_x844_tmp_3} ; io.in_x844_tmp_3 := DontCare
    def x928_force_0 = {io.in_x928_force_0} ; io.in_x928_force_0 := DontCare
    def b839 = {io.in_b839} 
    def x992_ctrchain = {io.in_x992_ctrchain} ; io.in_x992_ctrchain := DontCare
    def x850_tmp_4 = {io.in_x850_tmp_4} ; io.in_x850_tmp_4 := DontCare
  }
  def connectWires0(module: x1021_module)(implicit stack: List[KernelHash]): Unit = {
    x846_tmp_0.connectLedger(module.io.in_x846_tmp_0)
    x841_tmp_0.connectLedger(module.io.in_x841_tmp_0)
    module.io.in_b838 <> b838
    x849_tmp_3.connectLedger(module.io.in_x849_tmp_3)
    x847_tmp_1.connectLedger(module.io.in_x847_tmp_1)
    x842_tmp_1.connectLedger(module.io.in_x842_tmp_1)
    module.io.in_b558 <> b558
    x843_tmp_2.connectLedger(module.io.in_x843_tmp_2)
    x848_tmp_2.connectLedger(module.io.in_x848_tmp_2)
    x927_force_0.connectLedger(module.io.in_x927_force_0)
    module.io.in_x991_ctrchain.input <> x991_ctrchain.input; module.io.in_x991_ctrchain.output <> x991_ctrchain.output
    x845_tmp_4.connectLedger(module.io.in_x845_tmp_4)
    x844_tmp_3.connectLedger(module.io.in_x844_tmp_3)
    x928_force_0.connectLedger(module.io.in_x928_force_0)
    module.io.in_b839 <> b839
    module.io.in_x992_ctrchain.input <> x992_ctrchain.input; module.io.in_x992_ctrchain.output <> x992_ctrchain.output
    x850_tmp_4.connectLedger(module.io.in_x850_tmp_4)
  }
  val b838 = list_b838(0)
  val b558 = list_b838(1)
  val b839 = list_b838(2)
  val x991_ctrchain = list_x991_ctrchain(0)
  val x992_ctrchain = list_x991_ctrchain(1)
  val x846_tmp_0 = list_x846_tmp_0(0)
  val x841_tmp_0 = list_x846_tmp_0(1)
  val x849_tmp_3 = list_x846_tmp_0(2)
  val x847_tmp_1 = list_x846_tmp_0(3)
  val x842_tmp_1 = list_x846_tmp_0(4)
  val x843_tmp_2 = list_x846_tmp_0(5)
  val x848_tmp_2 = list_x846_tmp_0(6)
  val x927_force_0 = list_x846_tmp_0(7)
  val x845_tmp_4 = list_x846_tmp_0(8)
  val x844_tmp_3 = list_x846_tmp_0(9)
  val x928_force_0 = list_x846_tmp_0(10)
  val x850_tmp_4 = list_x846_tmp_0(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1021")
    implicit val stack = ControllerStack.stack.toList
    class x1021_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1021_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1021 = Module(new InstrumentationCounter())
      val iters_x1021 = Module(new InstrumentationCounter())
      cycles_x1021.io.enable := io.sigsIn.baseEn
      iters_x1021.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1021_instrctr, cycles_x1021.io.count, iters_x1021.io.count, 0.U, 0.U)
      val x1006_inr_Foreach = new x1006_inr_Foreach_kernel(List(b838,b558), List(x841_tmp_0,x842_tmp_1,x843_tmp_2,x927_force_0,x845_tmp_4,x844_tmp_3) ,  Some(me), List(x991_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1006_inr_Foreach.sm.io.ctrDone := (x1006_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1006_inr_Foreach.backpressure := true.B | x1006_inr_Foreach.sm.io.doneLatch
      x1006_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1006_inr_Foreach.sm.io.doneLatch
      x1006_inr_Foreach.sm.io.enableOut.zip(x1006_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1006_inr_Foreach.sm.io.break := false.B
      x1006_inr_Foreach.mask := ~x1006_inr_Foreach.cchain.head.output.noop & b838 & b558
      x1006_inr_Foreach.configure("x1006_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1006_inr_Foreach.kernel()
      val x1020_inr_Foreach = new x1020_inr_Foreach_kernel(List(b558,b839), List(x846_tmp_0,x849_tmp_3,x847_tmp_1,x848_tmp_2,x928_force_0,x850_tmp_4) ,  Some(me), List(x992_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1020_inr_Foreach.sm.io.ctrDone := (x1020_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1020_inr_Foreach.backpressure := true.B | x1020_inr_Foreach.sm.io.doneLatch
      x1020_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1020_inr_Foreach.sm.io.doneLatch
      x1020_inr_Foreach.sm.io.enableOut.zip(x1020_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1020_inr_Foreach.sm.io.break := false.B
      x1020_inr_Foreach.mask := ~x1020_inr_Foreach.cchain.head.output.noop & b839 & b558
      x1020_inr_Foreach.configure("x1020_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1020_inr_Foreach.kernel()
      x841_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x842_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x843_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x844_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x845_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x846_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x847_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x848_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x849_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x850_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x927_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x928_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x1021_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1021 **/
