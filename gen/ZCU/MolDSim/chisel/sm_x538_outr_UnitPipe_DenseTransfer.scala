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

/** Hierarchy: x538 -> x444 **/
/** BEGIN Some(DenseTransfer) x538_outr_UnitPipe_DenseTransfer **/
class x538_outr_UnitPipe_DenseTransfer_kernel(
  list_x468_A_dram: List[FixedPoint],
  list_x474: List[DecoupledIO[AppCommandDense]],
  list_x476: List[DecoupledIO[AppLoadData]],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Streaming, 2, isFSM = false   , latency = 0.0.toInt, myName = "x538_outr_UnitPipe_DenseTransfer_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x538_outr_UnitPipe_DenseTransfer_iiCtr"))
  
  abstract class x538_outr_UnitPipe_DenseTransfer_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x468_A_dram = Input(new FixedPoint(true, 64, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x476 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x476_p").asInstanceOf[(Int, Int)] )))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x474 = Decoupled(new AppCommandDense(ModuleParams.getParams("x474_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 2, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 2))
      val rr = Input(Bool())
    })
    def x468_A_dram = {io.in_x468_A_dram} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x476 = {io.in_x476} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x474 = {io.in_x474} 
  }
  def connectWires0(module: x538_outr_UnitPipe_DenseTransfer_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x468_A_dram <> x468_A_dram
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_x476 <> x476
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    module.io.in_x474 <> x474
  }
  val x468_A_dram = list_x468_A_dram(0)
  val x474 = list_x474(0)
  val x476 = list_x476(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x473_A_sram_2 = list_x472_A_sram_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x538_outr_UnitPipe_DenseTransfer")
    implicit val stack = ControllerStack.stack.toList
    class x538_outr_UnitPipe_DenseTransfer_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x538_outr_UnitPipe_DenseTransfer_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x475_fifo = (new x475_fifo).m.io.asInstanceOf[FIFOInterface]
      val x477_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 1, 9, false)
      val x478_ctrchain = (new CChainObject(List[CtrObject](x477_ctr), "x478_ctrchain")).cchain.io 
      x478_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x478_ctrchain_p", (x478_ctrchain.par, x478_ctrchain.widths))
      val x499_inr_Foreach = new x499_inr_Foreach_kernel(List(x468_A_dram), List(x475_fifo), List(x474) ,  Some(me), List(x478_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x499_inr_Foreach.sm.io.ctrDone := (x499_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x499_inr_Foreach.backpressure := (~x475_fifo.full.D(5.0-1) | ~(x475_fifo.active(0).out)) & x474.ready | x499_inr_Foreach.sm.io.doneLatch
      x499_inr_Foreach.forwardpressure := (true.B) && (true.B) | x499_inr_Foreach.sm.io.doneLatch
      x499_inr_Foreach.sm.io.enableOut.zip(x499_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x499_inr_Foreach.sm.io.break := false.B
      x499_inr_Foreach.mask := ~x499_inr_Foreach.cchain.head.output.noop & true.B
      x499_inr_Foreach.configure("x499_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x499_inr_Foreach.kernel()
      val x501_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 1, 9, false)
      val x502_ctrchain = (new CChainObject(List[CtrObject](x501_ctr), "x502_ctrchain")).cchain.io 
      x502_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x502_ctrchain_p", (x502_ctrchain.par, x502_ctrchain.widths))
      val x537_outr_Foreach = new x537_outr_Foreach_kernel(List(x475_fifo), List(x476), List(x472_A_sram_1,x471_A_sram_0,x473_A_sram_2) ,  Some(me), List(x502_ctrchain), 1, 2, 1, List(1), List(32), breakpoints, rr)
      x537_outr_Foreach.sm.io.ctrDone := (x537_outr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x537_outr_Foreach.backpressure := true.B | x537_outr_Foreach.sm.io.doneLatch
      x537_outr_Foreach.forwardpressure := (true.B) && (true.B) | x537_outr_Foreach.sm.io.doneLatch
      x537_outr_Foreach.sm.io.enableOut.zip(x537_outr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x537_outr_Foreach.sm.io.break := false.B
      x537_outr_Foreach.mask := ~x537_outr_Foreach.cchain.head.output.noop & true.B
      x537_outr_Foreach.configure("x537_outr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x537_outr_Foreach.kernel()
    }
    val module = Module(new x538_outr_UnitPipe_DenseTransfer_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x538_outr_UnitPipe_DenseTransfer **/
