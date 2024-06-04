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

/** Hierarchy: x897 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x897 **/
class x897_kernel(
  list_x853_ctrchain: List[CounterChainInterface],
  list_b838: List[Bool],
  list_x472_A_sram_1: List[StandardInterface],
  list_b548: List[FixedPoint],
  list_x846_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x897_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x897_iiCtr"))
  
  abstract class x897_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x846_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x846_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x841_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x841_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b838 = Input(Bool())
      val in_x853_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x853_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x849_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x849_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x847_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x847_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x842_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x842_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b558 = Input(Bool())
      val in_x843_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x843_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x848_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x848_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b548 = Input(new FixedPoint(true, 32, 0))
      val in_b836 = Input(new FixedPoint(true, 32, 0))
      val in_x845_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x845_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x844_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x844_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b835 = Input(new FixedPoint(true, 32, 0))
      val in_x854_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x854_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b839 = Input(Bool())
      val in_x850_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x850_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x846_tmp_0 = {io.in_x846_tmp_0} ; io.in_x846_tmp_0 := DontCare
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x841_tmp_0 = {io.in_x841_tmp_0} ; io.in_x841_tmp_0 := DontCare
    def b838 = {io.in_b838} 
    def x853_ctrchain = {io.in_x853_ctrchain} ; io.in_x853_ctrchain := DontCare
    def x849_tmp_3 = {io.in_x849_tmp_3} ; io.in_x849_tmp_3 := DontCare
    def x847_tmp_1 = {io.in_x847_tmp_1} ; io.in_x847_tmp_1 := DontCare
    def x842_tmp_1 = {io.in_x842_tmp_1} ; io.in_x842_tmp_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b558 = {io.in_b558} 
    def x843_tmp_2 = {io.in_x843_tmp_2} ; io.in_x843_tmp_2 := DontCare
    def x848_tmp_2 = {io.in_x848_tmp_2} ; io.in_x848_tmp_2 := DontCare
    def b548 = {io.in_b548} 
    def b836 = {io.in_b836} 
    def x845_tmp_4 = {io.in_x845_tmp_4} ; io.in_x845_tmp_4 := DontCare
    def x844_tmp_3 = {io.in_x844_tmp_3} ; io.in_x844_tmp_3 := DontCare
    def b835 = {io.in_b835} 
    def x854_ctrchain = {io.in_x854_ctrchain} ; io.in_x854_ctrchain := DontCare
    def b839 = {io.in_b839} 
    def x850_tmp_4 = {io.in_x850_tmp_4} ; io.in_x850_tmp_4 := DontCare
  }
  def connectWires0(module: x897_module)(implicit stack: List[KernelHash]): Unit = {
    x846_tmp_0.connectLedger(module.io.in_x846_tmp_0)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x841_tmp_0.connectLedger(module.io.in_x841_tmp_0)
    module.io.in_b838 <> b838
    module.io.in_x853_ctrchain.input <> x853_ctrchain.input; module.io.in_x853_ctrchain.output <> x853_ctrchain.output
    x849_tmp_3.connectLedger(module.io.in_x849_tmp_3)
    x847_tmp_1.connectLedger(module.io.in_x847_tmp_1)
    x842_tmp_1.connectLedger(module.io.in_x842_tmp_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b558 <> b558
    x843_tmp_2.connectLedger(module.io.in_x843_tmp_2)
    x848_tmp_2.connectLedger(module.io.in_x848_tmp_2)
    module.io.in_b548 <> b548
    module.io.in_b836 <> b836
    x845_tmp_4.connectLedger(module.io.in_x845_tmp_4)
    x844_tmp_3.connectLedger(module.io.in_x844_tmp_3)
    module.io.in_b835 <> b835
    module.io.in_x854_ctrchain.input <> x854_ctrchain.input; module.io.in_x854_ctrchain.output <> x854_ctrchain.output
    module.io.in_b839 <> b839
    x850_tmp_4.connectLedger(module.io.in_x850_tmp_4)
  }
  val x853_ctrchain = list_x853_ctrchain(0)
  val x854_ctrchain = list_x853_ctrchain(1)
  val b838 = list_b838(0)
  val b558 = list_b838(1)
  val b839 = list_b838(2)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val b548 = list_b548(0)
  val b836 = list_b548(1)
  val b835 = list_b548(2)
  val x846_tmp_0 = list_x846_tmp_0(0)
  val x841_tmp_0 = list_x846_tmp_0(1)
  val x849_tmp_3 = list_x846_tmp_0(2)
  val x847_tmp_1 = list_x846_tmp_0(3)
  val x842_tmp_1 = list_x846_tmp_0(4)
  val x843_tmp_2 = list_x846_tmp_0(5)
  val x848_tmp_2 = list_x846_tmp_0(6)
  val x845_tmp_4 = list_x846_tmp_0(7)
  val x844_tmp_3 = list_x846_tmp_0(8)
  val x850_tmp_4 = list_x846_tmp_0(9)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x897")
    implicit val stack = ControllerStack.stack.toList
    class x897_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x897_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x897 = Module(new InstrumentationCounter())
      val iters_x897 = Module(new InstrumentationCounter())
      cycles_x897.io.enable := io.sigsIn.baseEn
      iters_x897.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X897_instrctr, cycles_x897.io.count, iters_x897.io.count, 0.U, 0.U)
      val x875_inr_Foreach = new x875_inr_Foreach_kernel(List(b838,b558), List(b548,b835), List(x841_tmp_0,x842_tmp_1,x843_tmp_2,x845_tmp_4,x844_tmp_3), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x853_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x875_inr_Foreach.sm.io.ctrDone := (x875_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x875_inr_Foreach.backpressure := true.B | x875_inr_Foreach.sm.io.doneLatch
      x875_inr_Foreach.forwardpressure := (true.B) && (true.B) | x875_inr_Foreach.sm.io.doneLatch
      x875_inr_Foreach.sm.io.enableOut.zip(x875_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x875_inr_Foreach.sm.io.break := false.B
      x875_inr_Foreach.mask := ~x875_inr_Foreach.cchain.head.output.noop & b838 & b558
      x875_inr_Foreach.configure("x875_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x875_inr_Foreach.kernel()
      val x896_inr_Foreach = new x896_inr_Foreach_kernel(List(b558,b839), List(b548,b836), List(x472_A_sram_1,x471_A_sram_0), List(x846_tmp_0,x849_tmp_3,x847_tmp_1,x848_tmp_2,x850_tmp_4) ,  Some(me), List(x854_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x896_inr_Foreach.sm.io.ctrDone := (x896_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x896_inr_Foreach.backpressure := true.B | x896_inr_Foreach.sm.io.doneLatch
      x896_inr_Foreach.forwardpressure := (true.B) && (true.B) | x896_inr_Foreach.sm.io.doneLatch
      x896_inr_Foreach.sm.io.enableOut.zip(x896_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x896_inr_Foreach.sm.io.break := false.B
      x896_inr_Foreach.mask := ~x896_inr_Foreach.cchain.head.output.noop & b839 & b558
      x896_inr_Foreach.configure("x896_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x896_inr_Foreach.kernel()
      x841_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x842_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x843_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x844_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x845_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x846_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x847_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x848_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x849_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x850_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x897_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x897 **/
