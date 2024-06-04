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

/** Hierarchy: x1783 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1783 **/
class x1783_kernel(
  list_b1671: List[Bool],
  list_x1761_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1783_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1783_iiCtr"))
  
  abstract class x1783_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1671 = Input(Bool())
      val in_x1761_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1761_reg_p").asInstanceOf[NBufParams] ))
      val in_x1682_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1682_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1677_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1677_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1730_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1730_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1676_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1676_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1762_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1762_reg_p").asInstanceOf[NBufParams] ))
      val in_x1764_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1764_reg_p").asInstanceOf[NBufParams] ))
      val in_x1680_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1680_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1675_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1675_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1731_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1731_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1763_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1763_reg_p").asInstanceOf[NBufParams] ))
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
    def x1761_reg = {io.in_x1761_reg} ; io.in_x1761_reg := DontCare
    def x1682_tmp_4 = {io.in_x1682_tmp_4} ; io.in_x1682_tmp_4 := DontCare
    def x1677_tmp_4 = {io.in_x1677_tmp_4} ; io.in_x1677_tmp_4 := DontCare
    def x1730_r_0 = {io.in_x1730_r_0} ; io.in_x1730_r_0 := DontCare
    def x1676_tmp_3 = {io.in_x1676_tmp_3} ; io.in_x1676_tmp_3 := DontCare
    def x1762_reg = {io.in_x1762_reg} ; io.in_x1762_reg := DontCare
    def x1764_reg = {io.in_x1764_reg} ; io.in_x1764_reg := DontCare
    def x1680_tmp_2 = {io.in_x1680_tmp_2} ; io.in_x1680_tmp_2 := DontCare
    def b562 = {io.in_b562} 
    def x1675_tmp_2 = {io.in_x1675_tmp_2} ; io.in_x1675_tmp_2 := DontCare
    def x1731_r_0 = {io.in_x1731_r_0} ; io.in_x1731_r_0 := DontCare
    def x1763_reg = {io.in_x1763_reg} ; io.in_x1763_reg := DontCare
    def x1679_tmp_1 = {io.in_x1679_tmp_1} ; io.in_x1679_tmp_1 := DontCare
    def b1670 = {io.in_b1670} 
    def x1674_tmp_1 = {io.in_x1674_tmp_1} ; io.in_x1674_tmp_1 := DontCare
    def x1678_tmp_0 = {io.in_x1678_tmp_0} ; io.in_x1678_tmp_0 := DontCare
    def x1673_tmp_0 = {io.in_x1673_tmp_0} ; io.in_x1673_tmp_0 := DontCare
    def x1681_tmp_3 = {io.in_x1681_tmp_3} ; io.in_x1681_tmp_3 := DontCare
  }
  def connectWires0(module: x1783_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1671 <> b1671
    x1761_reg.connectLedger(module.io.in_x1761_reg)
    x1682_tmp_4.connectLedger(module.io.in_x1682_tmp_4)
    x1677_tmp_4.connectLedger(module.io.in_x1677_tmp_4)
    x1730_r_0.connectLedger(module.io.in_x1730_r_0)
    x1676_tmp_3.connectLedger(module.io.in_x1676_tmp_3)
    x1762_reg.connectLedger(module.io.in_x1762_reg)
    x1764_reg.connectLedger(module.io.in_x1764_reg)
    x1680_tmp_2.connectLedger(module.io.in_x1680_tmp_2)
    module.io.in_b562 <> b562
    x1675_tmp_2.connectLedger(module.io.in_x1675_tmp_2)
    x1731_r_0.connectLedger(module.io.in_x1731_r_0)
    x1763_reg.connectLedger(module.io.in_x1763_reg)
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
  val x1761_reg = list_x1761_reg(0)
  val x1682_tmp_4 = list_x1761_reg(1)
  val x1677_tmp_4 = list_x1761_reg(2)
  val x1730_r_0 = list_x1761_reg(3)
  val x1676_tmp_3 = list_x1761_reg(4)
  val x1762_reg = list_x1761_reg(5)
  val x1764_reg = list_x1761_reg(6)
  val x1680_tmp_2 = list_x1761_reg(7)
  val x1675_tmp_2 = list_x1761_reg(8)
  val x1731_r_0 = list_x1761_reg(9)
  val x1763_reg = list_x1761_reg(10)
  val x1679_tmp_1 = list_x1761_reg(11)
  val x1674_tmp_1 = list_x1761_reg(12)
  val x1678_tmp_0 = list_x1761_reg(13)
  val x1673_tmp_0 = list_x1761_reg(14)
  val x1681_tmp_3 = list_x1761_reg(15)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1783")
    implicit val stack = ControllerStack.stack.toList
    class x1783_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1783_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1783 = Module(new InstrumentationCounter())
      val iters_x1783 = Module(new InstrumentationCounter())
      cycles_x1783.io.enable := io.sigsIn.baseEn
      iters_x1783.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1783_instrctr, cycles_x1783.io.count, iters_x1783.io.count, 0.U, 0.U)
      val x1773_inr_UnitPipe = new x1773_inr_UnitPipe_kernel(List(b562,b1670), List(x1761_reg,x1730_r_0,x1763_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1773_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1773_inr_UnitPipe.sm.io.ctrInc)
      x1773_inr_UnitPipe.backpressure := true.B | x1773_inr_UnitPipe.sm.io.doneLatch
      x1773_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1773_inr_UnitPipe.sm.io.doneLatch
      x1773_inr_UnitPipe.sm.io.enableOut.zip(x1773_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1773_inr_UnitPipe.sm.io.break := false.B
      x1773_inr_UnitPipe.mask := true.B & b1670 & b562
      x1773_inr_UnitPipe.configure("x1773_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1773_inr_UnitPipe.kernel()
      val x1782_inr_UnitPipe = new x1782_inr_UnitPipe_kernel(List(b1671,b562), List(x1762_reg,x1764_reg,x1731_r_0) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1782_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1782_inr_UnitPipe.sm.io.ctrInc)
      x1782_inr_UnitPipe.backpressure := true.B | x1782_inr_UnitPipe.sm.io.doneLatch
      x1782_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1782_inr_UnitPipe.sm.io.doneLatch
      x1782_inr_UnitPipe.sm.io.enableOut.zip(x1782_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1782_inr_UnitPipe.sm.io.break := false.B
      x1782_inr_UnitPipe.mask := true.B & b1671 & b562
      x1782_inr_UnitPipe.configure("x1782_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1782_inr_UnitPipe.kernel()
      x1673_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1674_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1675_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1676_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1677_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1678_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1679_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1680_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1681_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1682_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x1730_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1731_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1761_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1762_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1763_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1764_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1783_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1783 **/
