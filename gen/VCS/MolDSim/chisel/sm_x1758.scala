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

/** Hierarchy: x1758 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1758 **/
class x1758_kernel(
  list_b1671: List[Bool],
  list_x1682_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1758_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1758_iiCtr"))
  
  abstract class x1758_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1671 = Input(Bool())
      val in_x1682_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1682_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1677_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1677_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1730_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1730_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1676_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1676_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1680_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1680_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1675_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1675_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1731_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1731_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1679_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1679_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b1670 = Input(Bool())
      val in_x1674_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1674_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1678_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1678_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1673_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1673_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1681_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1681_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def b1671 = {io.in_b1671} 
    def x1682_tmp_4 = {io.in_x1682_tmp_4} ; io.in_x1682_tmp_4 := DontCare
    def x1677_tmp_4 = {io.in_x1677_tmp_4} ; io.in_x1677_tmp_4 := DontCare
    def x1730_r_0 = {io.in_x1730_r_0} ; io.in_x1730_r_0 := DontCare
    def x1676_tmp_3 = {io.in_x1676_tmp_3} ; io.in_x1676_tmp_3 := DontCare
    def x1680_tmp_2 = {io.in_x1680_tmp_2} ; io.in_x1680_tmp_2 := DontCare
    def b562 = {io.in_b562} 
    def x1675_tmp_2 = {io.in_x1675_tmp_2} ; io.in_x1675_tmp_2 := DontCare
    def x1731_r_0 = {io.in_x1731_r_0} ; io.in_x1731_r_0 := DontCare
    def x1679_tmp_1 = {io.in_x1679_tmp_1} ; io.in_x1679_tmp_1 := DontCare
    def b1670 = {io.in_b1670} 
    def x1674_tmp_1 = {io.in_x1674_tmp_1} ; io.in_x1674_tmp_1 := DontCare
    def x1678_tmp_0 = {io.in_x1678_tmp_0} ; io.in_x1678_tmp_0 := DontCare
    def x1673_tmp_0 = {io.in_x1673_tmp_0} ; io.in_x1673_tmp_0 := DontCare
    def x1681_tmp_3 = {io.in_x1681_tmp_3} ; io.in_x1681_tmp_3 := DontCare
  }
  def connectWires0(module: x1758_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1671 <> b1671
    x1682_tmp_4.connectLedger(module.io.in_x1682_tmp_4)
    x1677_tmp_4.connectLedger(module.io.in_x1677_tmp_4)
    x1730_r_0.connectLedger(module.io.in_x1730_r_0)
    x1676_tmp_3.connectLedger(module.io.in_x1676_tmp_3)
    x1680_tmp_2.connectLedger(module.io.in_x1680_tmp_2)
    module.io.in_b562 <> b562
    x1675_tmp_2.connectLedger(module.io.in_x1675_tmp_2)
    x1731_r_0.connectLedger(module.io.in_x1731_r_0)
    x1679_tmp_1.connectLedger(module.io.in_x1679_tmp_1)
    module.io.in_b1670 <> b1670
    x1674_tmp_1.connectLedger(module.io.in_x1674_tmp_1)
    x1678_tmp_0.connectLedger(module.io.in_x1678_tmp_0)
    x1673_tmp_0.connectLedger(module.io.in_x1673_tmp_0)
    x1681_tmp_3.connectLedger(module.io.in_x1681_tmp_3)
  }
  val b1671 = list_b1671(0)
  val b562 = list_b1671(1)
  val b1670 = list_b1671(2)
  val x1682_tmp_4 = list_x1682_tmp_4(0)
  val x1677_tmp_4 = list_x1682_tmp_4(1)
  val x1730_r_0 = list_x1682_tmp_4(2)
  val x1676_tmp_3 = list_x1682_tmp_4(3)
  val x1680_tmp_2 = list_x1682_tmp_4(4)
  val x1675_tmp_2 = list_x1682_tmp_4(5)
  val x1731_r_0 = list_x1682_tmp_4(6)
  val x1679_tmp_1 = list_x1682_tmp_4(7)
  val x1674_tmp_1 = list_x1682_tmp_4(8)
  val x1678_tmp_0 = list_x1682_tmp_4(9)
  val x1673_tmp_0 = list_x1682_tmp_4(10)
  val x1681_tmp_3 = list_x1682_tmp_4(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1758")
    implicit val stack = ControllerStack.stack.toList
    class x1758_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1758_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1758 = Module(new InstrumentationCounter())
      val iters_x1758 = Module(new InstrumentationCounter())
      cycles_x1758.io.enable := io.sigsIn.baseEn
      iters_x1758.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1758_instrctr, cycles_x1758.io.count, iters_x1758.io.count, 0.U, 0.U)
      val x1744_inr_UnitPipe = new x1744_inr_UnitPipe_kernel(List(b562,b1670), List(x1730_r_0,x1675_tmp_2,x1674_tmp_1,x1673_tmp_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1744_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1744_inr_UnitPipe.sm.io.ctrInc)
      x1744_inr_UnitPipe.backpressure := true.B | x1744_inr_UnitPipe.sm.io.doneLatch
      x1744_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1744_inr_UnitPipe.sm.io.doneLatch
      x1744_inr_UnitPipe.sm.io.enableOut.zip(x1744_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1744_inr_UnitPipe.sm.io.break := false.B
      x1744_inr_UnitPipe.mask := true.B & b1670 & b562
      x1744_inr_UnitPipe.configure("x1744_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1744_inr_UnitPipe.kernel()
      val x1757_inr_UnitPipe = new x1757_inr_UnitPipe_kernel(List(b1671,b562), List(x1680_tmp_2,x1731_r_0,x1679_tmp_1,x1678_tmp_0) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1757_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1757_inr_UnitPipe.sm.io.ctrInc)
      x1757_inr_UnitPipe.backpressure := true.B | x1757_inr_UnitPipe.sm.io.doneLatch
      x1757_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1757_inr_UnitPipe.sm.io.doneLatch
      x1757_inr_UnitPipe.sm.io.enableOut.zip(x1757_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1757_inr_UnitPipe.sm.io.break := false.B
      x1757_inr_UnitPipe.mask := true.B & b1671 & b562
      x1757_inr_UnitPipe.configure("x1757_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1757_inr_UnitPipe.kernel()
      x1673_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1674_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1675_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1676_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1677_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1678_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1679_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1680_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1681_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1682_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1730_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1731_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1758_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1758 **/
