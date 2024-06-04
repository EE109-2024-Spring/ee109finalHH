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

/** Hierarchy: x2916 -> x444 **/
/** BEGIN Some(DenseTransfer) x2916_outr_UnitPipe_DenseTransfer **/
class x2916_outr_UnitPipe_DenseTransfer_kernel(
  list_x2862: List[DecoupledIO[Bool]],
  list_x2860: List[DecoupledIO[AppCommandDense]],
  list_x470_out_host: List[FixedPoint],
  list_x2861: List[DecoupledIO[AppStoreData]],
  list_x544_out_sram_0: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 1, isFSM = false   , latency = 0.0.toInt, myName = "x2916_outr_UnitPipe_DenseTransfer_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2916_outr_UnitPipe_DenseTransfer_iiCtr"))
  
  abstract class x2916_outr_UnitPipe_DenseTransfer_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2861 = Decoupled(new AppStoreData(ModuleParams.getParams("x2861_p").asInstanceOf[(Int,Int)] ))
      val in_x2862 = Flipped(Decoupled(Bool()))
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2860 = Decoupled(new AppCommandDense(ModuleParams.getParams("x2860_p").asInstanceOf[(Int,Int)] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2861 = {io.in_x2861} 
    def x2862 = {io.in_x2862} 
    def x470_out_host = {io.in_x470_out_host} 
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def x2860 = {io.in_x2860} 
  }
  def connectWires0(module: x2916_outr_UnitPipe_DenseTransfer_module)(implicit stack: List[KernelHash]): Unit = {
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
    Ledger.enter(this.hashCode, "x2916_outr_UnitPipe_DenseTransfer")
    implicit val stack = ControllerStack.stack.toList
    class x2916_outr_UnitPipe_DenseTransfer_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2916_outr_UnitPipe_DenseTransfer_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2916_outr_UnitPipe_DenseTransfer = Module(new InstrumentationCounter())
      val iters_x2916_outr_UnitPipe_DenseTransfer = Module(new InstrumentationCounter())
      cycles_x2916_outr_UnitPipe_DenseTransfer.io.enable := io.sigsIn.baseEn
      iters_x2916_outr_UnitPipe_DenseTransfer.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2916_instrctr, cycles_x2916_outr_UnitPipe_DenseTransfer.io.count, iters_x2916_outr_UnitPipe_DenseTransfer.io.count, 0.U, 0.U)
      val x2863_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 1, 9, false)
      val x2864_ctrchain = (new CChainObject(List[CtrObject](x2863_ctr), "x2864_ctrchain")).cchain.io 
      x2864_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2864_ctrchain_p", (x2864_ctrchain.par, x2864_ctrchain.widths))
      val x2915_outr_Foreach = new x2915_outr_Foreach_kernel(List(x2862), List(x2860), List(x470_out_host), List(x2861), List(x544_out_sram_0) ,  Some(me), List(x2864_ctrchain), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2915_outr_Foreach.sm.io.ctrDone := (x2915_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2915_outr_Foreach.backpressure := true.B | x2915_outr_Foreach.sm.io.doneLatch
      x2915_outr_Foreach.forwardpressure := (true.B) && (true.B) | x2915_outr_Foreach.sm.io.doneLatch
      x2915_outr_Foreach.sm.io.enableOut.zip(x2915_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2915_outr_Foreach.sm.io.break := false.B
      x2915_outr_Foreach.mask := ~x2915_outr_Foreach.cchain.head.output.noop & true.B
      x2915_outr_Foreach.configure("x2915_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2915_outr_Foreach.kernel()
    }
    val module = Module(new x2916_outr_UnitPipe_DenseTransfer_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2916_outr_UnitPipe_DenseTransfer **/
