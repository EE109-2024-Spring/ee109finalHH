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

/** Hierarchy: x2915 -> x2916 -> x444 **/
/** BEGIN None x2915_outr_Foreach **/
class x2915_outr_Foreach_kernel(
  list_x2862: List[DecoupledIO[Bool]],
  list_x2860: List[DecoupledIO[AppCommandDense]],
  list_x470_out_host: List[FixedPoint],
  list_x2861: List[DecoupledIO[AppStoreData]],
  list_x544_out_sram_0: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2915_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2915_outr_Foreach_iiCtr"))
  
  abstract class x2915_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2861 = Decoupled(new AppStoreData(ModuleParams.getParams("x2861_p").asInstanceOf[(Int,Int)] ))
      val in_x2862 = Flipped(Decoupled(Bool()))
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2860 = Decoupled(new AppCommandDense(ModuleParams.getParams("x2860_p").asInstanceOf[(Int,Int)] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x2861 = {io.in_x2861} 
    def x2862 = {io.in_x2862} 
    def x470_out_host = {io.in_x470_out_host} 
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def x2860 = {io.in_x2860} 
  }
  def connectWires0(module: x2915_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2861 <> x2861
    module.io.in_x2862 <> x2862
    module.io.in_x470_out_host <> x470_out_host
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    module.io.in_x2860 <> x2860
  }
  val x2862 = list_x2862(0)
  val x2860 = list_x2860(0)
  val x470_out_host = list_x470_out_host(0)
  val x2861 = list_x2861(0)
  val x544_out_sram_0 = list_x544_out_sram_0(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2915_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2915_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2915_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2915_outr_Foreach = Module(new InstrumentationCounter())
      val iters_x2915_outr_Foreach = Module(new InstrumentationCounter())
      cycles_x2915_outr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2915_outr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2915_instrctr, cycles_x2915_outr_Foreach.io.count, iters_x2915_outr_Foreach.io.count, 0.U, 0.U)
      val b2865 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2865.suggestName("b2865")
      val b2866 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2866.suggestName("b2866")
      val x2910_outr_UnitPipe = new x2910_outr_UnitPipe_kernel(List(x2860), List(x2861), List(b2866), List(x544_out_sram_0), List(x470_out_host,b2865) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2910_outr_UnitPipe.sm.io.ctrDone := risingEdge(x2910_outr_UnitPipe.sm.io.ctrInc)
      x2910_outr_UnitPipe.backpressure := true.B | x2910_outr_UnitPipe.sm.io.doneLatch
      x2910_outr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2910_outr_UnitPipe.sm.io.doneLatch
      x2910_outr_UnitPipe.sm.io.enableOut.zip(x2910_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2910_outr_UnitPipe.sm.io.break := false.B
      x2910_outr_UnitPipe.mask := true.B & b2866
      x2910_outr_UnitPipe.configure("x2910_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2910_outr_UnitPipe.kernel()
      val x2914_inr_UnitPipe = new x2914_inr_UnitPipe_kernel(List(b2866), List(x2862) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2914_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2914_inr_UnitPipe.sm.io.ctrInc)
      x2914_inr_UnitPipe.backpressure := true.B | x2914_inr_UnitPipe.sm.io.doneLatch
      x2914_inr_UnitPipe.forwardpressure := (x2862.valid) && (true.B) | x2914_inr_UnitPipe.sm.io.doneLatch
      x2914_inr_UnitPipe.sm.io.enableOut.zip(x2914_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2914_inr_UnitPipe.sm.io.break := false.B
      x2914_inr_UnitPipe.mask := true.B & b2866
      x2914_inr_UnitPipe.configure("x2914_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2914_inr_UnitPipe.kernel()
    }
    val module = Module(new x2915_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2915_outr_Foreach **/
