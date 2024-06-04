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

/** Hierarchy: x1966 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1966 **/
class x1966_kernel(
  list_b1879: List[Bool],
  list_x1882_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1966_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1966_iiCtr"))
  
  abstract class x1966_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1879 = Input(Bool())
      val in_x1882_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1882_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1939_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1939_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1887_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1887_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1890_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1890_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1886_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1886_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1883_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1883_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1938_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1938_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1888_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1888_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1878 = Input(Bool())
      val in_x1889_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1889_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1884_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1884_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_x1881_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1881_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1885_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1885_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def b1879 = {io.in_b1879} 
    def x1882_tmp_1 = {io.in_x1882_tmp_1} ; io.in_x1882_tmp_1 := DontCare
    def x1939_r_0 = {io.in_x1939_r_0} ; io.in_x1939_r_0 := DontCare
    def x1887_tmp_1 = {io.in_x1887_tmp_1} ; io.in_x1887_tmp_1 := DontCare
    def x1890_tmp_4 = {io.in_x1890_tmp_4} ; io.in_x1890_tmp_4 := DontCare
    def x1886_tmp_0 = {io.in_x1886_tmp_0} ; io.in_x1886_tmp_0 := DontCare
    def x1883_tmp_2 = {io.in_x1883_tmp_2} ; io.in_x1883_tmp_2 := DontCare
    def x1938_r_0 = {io.in_x1938_r_0} ; io.in_x1938_r_0 := DontCare
    def x1888_tmp_2 = {io.in_x1888_tmp_2} ; io.in_x1888_tmp_2 := DontCare
    def b1878 = {io.in_b1878} 
    def x1889_tmp_3 = {io.in_x1889_tmp_3} ; io.in_x1889_tmp_3 := DontCare
    def x1884_tmp_3 = {io.in_x1884_tmp_3} ; io.in_x1884_tmp_3 := DontCare
    def b563 = {io.in_b563} 
    def x1881_tmp_0 = {io.in_x1881_tmp_0} ; io.in_x1881_tmp_0 := DontCare
    def x1885_tmp_4 = {io.in_x1885_tmp_4} ; io.in_x1885_tmp_4 := DontCare
  }
  def connectWires0(module: x1966_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1879 <> b1879
    x1882_tmp_1.connectLedger(module.io.in_x1882_tmp_1)
    x1939_r_0.connectLedger(module.io.in_x1939_r_0)
    x1887_tmp_1.connectLedger(module.io.in_x1887_tmp_1)
    x1890_tmp_4.connectLedger(module.io.in_x1890_tmp_4)
    x1886_tmp_0.connectLedger(module.io.in_x1886_tmp_0)
    x1883_tmp_2.connectLedger(module.io.in_x1883_tmp_2)
    x1938_r_0.connectLedger(module.io.in_x1938_r_0)
    x1888_tmp_2.connectLedger(module.io.in_x1888_tmp_2)
    module.io.in_b1878 <> b1878
    x1889_tmp_3.connectLedger(module.io.in_x1889_tmp_3)
    x1884_tmp_3.connectLedger(module.io.in_x1884_tmp_3)
    module.io.in_b563 <> b563
    x1881_tmp_0.connectLedger(module.io.in_x1881_tmp_0)
    x1885_tmp_4.connectLedger(module.io.in_x1885_tmp_4)
  }
  val b1879 = list_b1879(0)
  val b1878 = list_b1879(1)
  val b563 = list_b1879(2)
  val x1882_tmp_1 = list_x1882_tmp_1(0)
  val x1939_r_0 = list_x1882_tmp_1(1)
  val x1887_tmp_1 = list_x1882_tmp_1(2)
  val x1890_tmp_4 = list_x1882_tmp_1(3)
  val x1886_tmp_0 = list_x1882_tmp_1(4)
  val x1883_tmp_2 = list_x1882_tmp_1(5)
  val x1938_r_0 = list_x1882_tmp_1(6)
  val x1888_tmp_2 = list_x1882_tmp_1(7)
  val x1889_tmp_3 = list_x1882_tmp_1(8)
  val x1884_tmp_3 = list_x1882_tmp_1(9)
  val x1881_tmp_0 = list_x1882_tmp_1(10)
  val x1885_tmp_4 = list_x1882_tmp_1(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1966")
    implicit val stack = ControllerStack.stack.toList
    class x1966_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1966_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1966 = Module(new InstrumentationCounter())
      val iters_x1966 = Module(new InstrumentationCounter())
      cycles_x1966.io.enable := io.sigsIn.baseEn
      iters_x1966.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1966_instrctr, cycles_x1966.io.count, iters_x1966.io.count, 0.U, 0.U)
      val x1952_inr_UnitPipe = new x1952_inr_UnitPipe_kernel(List(b1878,b563), List(x1882_tmp_1,x1883_tmp_2,x1938_r_0,x1881_tmp_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1952_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1952_inr_UnitPipe.sm.io.ctrInc)
      x1952_inr_UnitPipe.backpressure := true.B | x1952_inr_UnitPipe.sm.io.doneLatch
      x1952_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1952_inr_UnitPipe.sm.io.doneLatch
      x1952_inr_UnitPipe.sm.io.enableOut.zip(x1952_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1952_inr_UnitPipe.sm.io.break := false.B
      x1952_inr_UnitPipe.mask := true.B & b1878 & b563
      x1952_inr_UnitPipe.configure("x1952_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1952_inr_UnitPipe.kernel()
      val x1965_inr_UnitPipe = new x1965_inr_UnitPipe_kernel(List(b1879,b563), List(x1939_r_0,x1887_tmp_1,x1886_tmp_0,x1888_tmp_2) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1965_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1965_inr_UnitPipe.sm.io.ctrInc)
      x1965_inr_UnitPipe.backpressure := true.B | x1965_inr_UnitPipe.sm.io.doneLatch
      x1965_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1965_inr_UnitPipe.sm.io.doneLatch
      x1965_inr_UnitPipe.sm.io.enableOut.zip(x1965_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1965_inr_UnitPipe.sm.io.break := false.B
      x1965_inr_UnitPipe.mask := true.B & b1879 & b563
      x1965_inr_UnitPipe.configure("x1965_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1965_inr_UnitPipe.kernel()
      x1881_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1882_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1883_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1884_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1885_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1886_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1887_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1888_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1889_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1890_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1938_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1939_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1966_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1966 **/
