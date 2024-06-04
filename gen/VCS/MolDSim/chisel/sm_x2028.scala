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

/** Hierarchy: x2028 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2028 **/
class x2028_kernel(
  list_b1879: List[Bool],
  list_x2023_inr_Switch: List[FixedPoint],
  list_x1882_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2028_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2028_iiCtr"))
  
  abstract class x2028_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1879 = Input(Bool())
      val in_x1882_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1882_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1967_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1967_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1887_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1887_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1890_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1890_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1886_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1886_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1883_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1883_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1968_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1968_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1888_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1888_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1878 = Input(Bool())
      val in_x2023_inr_Switch = Input(new FixedPoint(true, 10, 22))
      val in_x1889_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1889_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1884_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1884_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_x1881_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1881_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2009_inr_Switch = Input(new FixedPoint(true, 10, 22))
      val in_x1885_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1885_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def b1879 = {io.in_b1879} 
    def x1882_tmp_1 = {io.in_x1882_tmp_1} ; io.in_x1882_tmp_1 := DontCare
    def x1967_force_0 = {io.in_x1967_force_0} ; io.in_x1967_force_0 := DontCare
    def x1887_tmp_1 = {io.in_x1887_tmp_1} ; io.in_x1887_tmp_1 := DontCare
    def x1890_tmp_4 = {io.in_x1890_tmp_4} ; io.in_x1890_tmp_4 := DontCare
    def x1886_tmp_0 = {io.in_x1886_tmp_0} ; io.in_x1886_tmp_0 := DontCare
    def x1883_tmp_2 = {io.in_x1883_tmp_2} ; io.in_x1883_tmp_2 := DontCare
    def x1968_force_0 = {io.in_x1968_force_0} ; io.in_x1968_force_0 := DontCare
    def x1888_tmp_2 = {io.in_x1888_tmp_2} ; io.in_x1888_tmp_2 := DontCare
    def b1878 = {io.in_b1878} 
    def x2023_inr_Switch = {io.in_x2023_inr_Switch} 
    def x1889_tmp_3 = {io.in_x1889_tmp_3} ; io.in_x1889_tmp_3 := DontCare
    def x1884_tmp_3 = {io.in_x1884_tmp_3} ; io.in_x1884_tmp_3 := DontCare
    def b563 = {io.in_b563} 
    def x1881_tmp_0 = {io.in_x1881_tmp_0} ; io.in_x1881_tmp_0 := DontCare
    def x2009_inr_Switch = {io.in_x2009_inr_Switch} 
    def x1885_tmp_4 = {io.in_x1885_tmp_4} ; io.in_x1885_tmp_4 := DontCare
  }
  def connectWires0(module: x2028_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1879 <> b1879
    x1882_tmp_1.connectLedger(module.io.in_x1882_tmp_1)
    x1967_force_0.connectLedger(module.io.in_x1967_force_0)
    x1887_tmp_1.connectLedger(module.io.in_x1887_tmp_1)
    x1890_tmp_4.connectLedger(module.io.in_x1890_tmp_4)
    x1886_tmp_0.connectLedger(module.io.in_x1886_tmp_0)
    x1883_tmp_2.connectLedger(module.io.in_x1883_tmp_2)
    x1968_force_0.connectLedger(module.io.in_x1968_force_0)
    x1888_tmp_2.connectLedger(module.io.in_x1888_tmp_2)
    module.io.in_b1878 <> b1878
    module.io.in_x2023_inr_Switch <> x2023_inr_Switch
    x1889_tmp_3.connectLedger(module.io.in_x1889_tmp_3)
    x1884_tmp_3.connectLedger(module.io.in_x1884_tmp_3)
    module.io.in_b563 <> b563
    x1881_tmp_0.connectLedger(module.io.in_x1881_tmp_0)
    module.io.in_x2009_inr_Switch <> x2009_inr_Switch
    x1885_tmp_4.connectLedger(module.io.in_x1885_tmp_4)
  }
  val b1879 = list_b1879(0)
  val b1878 = list_b1879(1)
  val b563 = list_b1879(2)
  val x2023_inr_Switch = list_x2023_inr_Switch(0)
  val x2009_inr_Switch = list_x2023_inr_Switch(1)
  val x1882_tmp_1 = list_x1882_tmp_1(0)
  val x1967_force_0 = list_x1882_tmp_1(1)
  val x1887_tmp_1 = list_x1882_tmp_1(2)
  val x1890_tmp_4 = list_x1882_tmp_1(3)
  val x1886_tmp_0 = list_x1882_tmp_1(4)
  val x1883_tmp_2 = list_x1882_tmp_1(5)
  val x1968_force_0 = list_x1882_tmp_1(6)
  val x1888_tmp_2 = list_x1882_tmp_1(7)
  val x1889_tmp_3 = list_x1882_tmp_1(8)
  val x1884_tmp_3 = list_x1882_tmp_1(9)
  val x1881_tmp_0 = list_x1882_tmp_1(10)
  val x1885_tmp_4 = list_x1882_tmp_1(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2028")
    implicit val stack = ControllerStack.stack.toList
    class x2028_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2028_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2028 = Module(new InstrumentationCounter())
      val iters_x2028 = Module(new InstrumentationCounter())
      cycles_x2028.io.enable := io.sigsIn.baseEn
      iters_x2028.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2028_instrctr, cycles_x2028.io.count, iters_x2028.io.count, 0.U, 0.U)
      val x2025_inr_UnitPipe = new x2025_inr_UnitPipe_kernel(List(b1878,b563), List(x2009_inr_Switch), List(x1967_force_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2025_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2025_inr_UnitPipe.sm.io.ctrInc)
      x2025_inr_UnitPipe.backpressure := true.B | x2025_inr_UnitPipe.sm.io.doneLatch
      x2025_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2025_inr_UnitPipe.sm.io.doneLatch
      x2025_inr_UnitPipe.sm.io.enableOut.zip(x2025_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2025_inr_UnitPipe.sm.io.break := false.B
      x2025_inr_UnitPipe.mask := true.B & b1878 & b563
      x2025_inr_UnitPipe.configure("x2025_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2025_inr_UnitPipe.kernel()
      val x2027_inr_UnitPipe = new x2027_inr_UnitPipe_kernel(List(b1879,b563), List(x2023_inr_Switch), List(x1968_force_0) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2027_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2027_inr_UnitPipe.sm.io.ctrInc)
      x2027_inr_UnitPipe.backpressure := true.B | x2027_inr_UnitPipe.sm.io.doneLatch
      x2027_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2027_inr_UnitPipe.sm.io.doneLatch
      x2027_inr_UnitPipe.sm.io.enableOut.zip(x2027_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2027_inr_UnitPipe.sm.io.break := false.B
      x2027_inr_UnitPipe.mask := true.B & b1879 & b563
      x2027_inr_UnitPipe.configure("x2027_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2027_inr_UnitPipe.kernel()
      x1881_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1882_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1883_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1884_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1885_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1886_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1887_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1888_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1889_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1890_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1967_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1968_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x2028_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2028 **/
