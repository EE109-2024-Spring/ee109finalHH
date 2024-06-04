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

/** Hierarchy: x724 -> x444 **/
/** BEGIN Some(DenseTransfer) x724_outr_UnitPipe_DenseTransfer **/
class x724_outr_UnitPipe_DenseTransfer_kernel(
  list_x539_out_sram_0: List[StandardInterface],
  list_x470_out_host: List[FixedPoint],
  list_x669: List[DecoupledIO[AppCommandDense]],
  list_x671: List[DecoupledIO[Bool]],
  list_x670: List[DecoupledIO[AppStoreData]],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 1, isFSM = false   , latency = 0.0.toInt, myName = "x724_outr_UnitPipe_DenseTransfer_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x724_outr_UnitPipe_DenseTransfer_iiCtr"))
  
  abstract class x724_outr_UnitPipe_DenseTransfer_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x670 = Decoupled(new AppStoreData(ModuleParams.getParams("x670_p").asInstanceOf[(Int,Int)] ))
      val in_x669 = Decoupled(new AppCommandDense(ModuleParams.getParams("x669_p").asInstanceOf[(Int,Int)] ))
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x539_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x539_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_x671 = Flipped(Decoupled(Bool()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x670 = {io.in_x670} 
    def x669 = {io.in_x669} 
    def x470_out_host = {io.in_x470_out_host} 
    def x539_out_sram_0 = {io.in_x539_out_sram_0} ; io.in_x539_out_sram_0 := DontCare
    def x671 = {io.in_x671} 
  }
  def connectWires0(module: x724_outr_UnitPipe_DenseTransfer_module)(implicit stack: List[KernelHash]): Unit = {
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
    Ledger.enter(this.hashCode, "x724_outr_UnitPipe_DenseTransfer")
    implicit val stack = ControllerStack.stack.toList
    class x724_outr_UnitPipe_DenseTransfer_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x724_outr_UnitPipe_DenseTransfer_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x672_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 1, 9, false)
      val x673_ctrchain = (new CChainObject(List[CtrObject](x672_ctr), "x673_ctrchain")).cchain.io 
      x673_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x673_ctrchain_p", (x673_ctrchain.par, x673_ctrchain.widths))
      val x723_outr_Foreach = new x723_outr_Foreach_kernel(List(x539_out_sram_0), List(x470_out_host), List(x669), List(x671), List(x670) ,  Some(me), List(x673_ctrchain), 0, 2, 1, List(1), List(32), breakpoints, rr)
      x723_outr_Foreach.sm.io.ctrDone := (x723_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x723_outr_Foreach.backpressure := true.B | x723_outr_Foreach.sm.io.doneLatch
      x723_outr_Foreach.forwardpressure := (true.B) && (true.B) | x723_outr_Foreach.sm.io.doneLatch
      x723_outr_Foreach.sm.io.enableOut.zip(x723_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x723_outr_Foreach.sm.io.break := false.B
      x723_outr_Foreach.mask := ~x723_outr_Foreach.cchain.head.output.noop & true.B
      x723_outr_Foreach.configure("x723_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x723_outr_Foreach.kernel()
    }
    val module = Module(new x724_outr_UnitPipe_DenseTransfer_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x724_outr_UnitPipe_DenseTransfer **/
