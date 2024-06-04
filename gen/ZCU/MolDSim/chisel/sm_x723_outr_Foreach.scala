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

/** Hierarchy: x723 -> x724 -> x444 **/
/** BEGIN None x723_outr_Foreach **/
class x723_outr_Foreach_kernel(
  list_x539_out_sram_0: List[StandardInterface],
  list_x470_out_host: List[FixedPoint],
  list_x669: List[DecoupledIO[AppCommandDense]],
  list_x671: List[DecoupledIO[Bool]],
  list_x670: List[DecoupledIO[AppStoreData]],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x723_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x723_outr_Foreach_iiCtr"))
  
  abstract class x723_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x670 = Decoupled(new AppStoreData(ModuleParams.getParams("x670_p").asInstanceOf[(Int,Int)] ))
      val in_x669 = Decoupled(new AppCommandDense(ModuleParams.getParams("x669_p").asInstanceOf[(Int,Int)] ))
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x539_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x539_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_x671 = Flipped(Decoupled(Bool()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x670 = {io.in_x670} 
    def x669 = {io.in_x669} 
    def x470_out_host = {io.in_x470_out_host} 
    def x539_out_sram_0 = {io.in_x539_out_sram_0} ; io.in_x539_out_sram_0 := DontCare
    def x671 = {io.in_x671} 
  }
  def connectWires0(module: x723_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x670 <> x670
    module.io.in_x669 <> x669
    module.io.in_x470_out_host <> x470_out_host
    x539_out_sram_0.connectLedger(module.io.in_x539_out_sram_0)
    module.io.in_x671 <> x671
  }
  val x539_out_sram_0 = list_x539_out_sram_0(0)
  val x470_out_host = list_x470_out_host(0)
  val x669 = list_x669(0)
  val x671 = list_x671(0)
  val x670 = list_x670(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x723_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x723_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x723_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b674 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b674.suggestName("b674")
      val b675 = ~io.sigsIn.cchainOutputs.head.oobs(0); b675.suggestName("b675")
      val x718_outr_UnitPipe = new x718_outr_UnitPipe_kernel(List(x539_out_sram_0), List(x669), List(b675), List(b674,x470_out_host), List(x670) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, rr)
      x718_outr_UnitPipe.sm.io.ctrDone := risingEdge(x718_outr_UnitPipe.sm.io.ctrInc)
      x718_outr_UnitPipe.backpressure := true.B | x718_outr_UnitPipe.sm.io.doneLatch
      x718_outr_UnitPipe.forwardpressure := (true.B) && (true.B) | x718_outr_UnitPipe.sm.io.doneLatch
      x718_outr_UnitPipe.sm.io.enableOut.zip(x718_outr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x718_outr_UnitPipe.sm.io.break := false.B
      x718_outr_UnitPipe.mask := true.B & b675
      x718_outr_UnitPipe.configure("x718_outr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x718_outr_UnitPipe.kernel()
      val x722_inr_UnitPipe = new x722_inr_UnitPipe_kernel(List(b675), List(x671) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x722_inr_UnitPipe.sm.io.ctrDone := risingEdge(x722_inr_UnitPipe.sm.io.ctrInc)
      x722_inr_UnitPipe.backpressure := true.B | x722_inr_UnitPipe.sm.io.doneLatch
      x722_inr_UnitPipe.forwardpressure := (x671.valid) && (true.B) | x722_inr_UnitPipe.sm.io.doneLatch
      x722_inr_UnitPipe.sm.io.enableOut.zip(x722_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x722_inr_UnitPipe.sm.io.break := false.B
      x722_inr_UnitPipe.mask := true.B & b675
      x722_inr_UnitPipe.configure("x722_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x722_inr_UnitPipe.kernel()
    }
    val module = Module(new x723_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x723_outr_Foreach **/
