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

/** Hierarchy: x444 **/
/** BEGIN None RootController **/
class RootController_kernel(
  list_x669: List[DecoupledIO[AppCommandDense]],
  list_x476: List[DecoupledIO[AppLoadData]],
  list_x671: List[DecoupledIO[Bool]],
  list_x468_A_dram: List[FixedPoint],
  list_x670: List[DecoupledIO[AppStoreData]],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 3, isFSM = false   , latency = 0.0.toInt, myName = "RootController_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "RootController_iiCtr"))
  
  abstract class RootController_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x468_A_dram = Input(new FixedPoint(true, 64, 0))
      val in_x670 = Decoupled(new AppStoreData(ModuleParams.getParams("x670_p").asInstanceOf[(Int,Int)] ))
      val in_x669 = Decoupled(new AppCommandDense(ModuleParams.getParams("x669_p").asInstanceOf[(Int,Int)] ))
      val in_x476 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x476_p").asInstanceOf[(Int, Int)] )))
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x671 = Flipped(Decoupled(Bool()))
      val in_x474 = Decoupled(new AppCommandDense(ModuleParams.getParams("x474_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(3, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(3, 1))
      val rr = Input(Bool())
    })
    def x468_A_dram = {io.in_x468_A_dram} 
    def x670 = {io.in_x670} 
    def x669 = {io.in_x669} 
    def x476 = {io.in_x476} 
    def x470_out_host = {io.in_x470_out_host} 
    def x671 = {io.in_x671} 
    def x474 = {io.in_x474} 
  }
  def connectWires0(module: RootController_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x468_A_dram <> x468_A_dram
    module.io.in_x670 <> x670
    module.io.in_x669 <> x669
    module.io.in_x476 <> x476
    module.io.in_x470_out_host <> x470_out_host
    module.io.in_x671 <> x671
    module.io.in_x474 <> x474
  }
  val x669 = list_x669(0)
  val x474 = list_x669(1)
  val x476 = list_x476(0)
  val x671 = list_x671(0)
  val x468_A_dram = list_x468_A_dram(0)
  val x470_out_host = list_x468_A_dram(1)
  val x670 = list_x670(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "RootController")
    implicit val stack = ControllerStack.stack.toList
    class RootController_concrete(depth: Int)(implicit stack: List[KernelHash]) extends RootController_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x471_A_sram_0 = (new x471_A_sram_0).m.io.asInstanceOf[StandardInterface]
      val x472_A_sram_1 = (new x472_A_sram_1).m.io.asInstanceOf[StandardInterface]
      val x473_A_sram_2 = (new x473_A_sram_2).m.io.asInstanceOf[StandardInterface]
      val x538_outr_UnitPipe_DenseTransfer = new x538_outr_UnitPipe_DenseTransfer_kernel(List(x468_A_dram), List(x474), List(x476), List(x472_A_sram_1,x471_A_sram_0,x473_A_sram_2) ,  Some(me), List(), 0, 2, 2, List(1), List(32), breakpoints, rr)
      x538_outr_UnitPipe_DenseTransfer.backpressure := true.B | x538_outr_UnitPipe_DenseTransfer.sm.io.doneLatch
      x538_outr_UnitPipe_DenseTransfer.forwardpressure := (true.B) && (true.B) | x538_outr_UnitPipe_DenseTransfer.sm.io.doneLatch
      x538_outr_UnitPipe_DenseTransfer.sm.io.enableOut.zip(x538_outr_UnitPipe_DenseTransfer.smEnableOuts).foreach{case (l,r) => r := l}
      x538_outr_UnitPipe_DenseTransfer.sm.io.break := false.B
      x538_outr_UnitPipe_DenseTransfer.mask := true.B & true.B
      x538_outr_UnitPipe_DenseTransfer.configure("x538_outr_UnitPipe_DenseTransfer", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x538_outr_UnitPipe_DenseTransfer.kernel()
      val x539_out_sram_0 = (new x539_out_sram_0).m.io.asInstanceOf[StandardInterface]
      val x540_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 1, 9, false)
      val x541_ctrchain = (new CChainObject(List[CtrObject](x540_ctr), "x541_ctrchain")).cchain.io 
      x541_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x541_ctrchain_p", (x541_ctrchain.par, x541_ctrchain.widths))
      val x668_outr_Foreach = new x668_outr_Foreach_kernel(List(x472_A_sram_1,x471_A_sram_0,x473_A_sram_2,x539_out_sram_0) ,  Some(me), List(x541_ctrchain), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x668_outr_Foreach.sm.io.ctrDone := (x668_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x668_outr_Foreach.backpressure := true.B | x668_outr_Foreach.sm.io.doneLatch
      x668_outr_Foreach.forwardpressure := (true.B) && (true.B) | x668_outr_Foreach.sm.io.doneLatch
      x668_outr_Foreach.sm.io.enableOut.zip(x668_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x668_outr_Foreach.sm.io.break := false.B
      x668_outr_Foreach.mask := ~x668_outr_Foreach.cchain.head.output.noop & true.B
      x668_outr_Foreach.configure("x668_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x668_outr_Foreach.kernel()
      val x724_outr_UnitPipe_DenseTransfer = new x724_outr_UnitPipe_DenseTransfer_kernel(List(x539_out_sram_0), List(x470_out_host), List(x669), List(x671), List(x670) ,  Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      x724_outr_UnitPipe_DenseTransfer.backpressure := true.B | x724_outr_UnitPipe_DenseTransfer.sm.io.doneLatch
      x724_outr_UnitPipe_DenseTransfer.forwardpressure := (true.B) && (true.B) | x724_outr_UnitPipe_DenseTransfer.sm.io.doneLatch
      x724_outr_UnitPipe_DenseTransfer.sm.io.enableOut.zip(x724_outr_UnitPipe_DenseTransfer.smEnableOuts).foreach{case (l,r) => r := l}
      x724_outr_UnitPipe_DenseTransfer.sm.io.break := false.B
      x724_outr_UnitPipe_DenseTransfer.mask := true.B & true.B
      x724_outr_UnitPipe_DenseTransfer.configure("x724_outr_UnitPipe_DenseTransfer", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x724_outr_UnitPipe_DenseTransfer.kernel()
    }
    val module = Module(new RootController_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END AccelScope RootController **/
