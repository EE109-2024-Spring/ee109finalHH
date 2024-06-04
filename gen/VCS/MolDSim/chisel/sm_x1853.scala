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

/** Hierarchy: x1853 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1853 **/
class x1853_kernel(
  list_b1671: List[Bool],
  list_x1823_ctrchain: List[CounterChainInterface],
  list_x1760_force_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1853_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1853_iiCtr"))
  
  abstract class x1853_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1823_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1823_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b1671 = Input(Bool())
      val in_x1760_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1760_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1682_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1682_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1677_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1677_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1676_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1676_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1824_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1824_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x1759_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1759_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1680_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1680_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1675_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1675_tmp_2_p").asInstanceOf[NBufParams] ))
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
    def x1823_ctrchain = {io.in_x1823_ctrchain} ; io.in_x1823_ctrchain := DontCare
    def b1671 = {io.in_b1671} 
    def x1760_force_0 = {io.in_x1760_force_0} ; io.in_x1760_force_0 := DontCare
    def x1682_tmp_4 = {io.in_x1682_tmp_4} ; io.in_x1682_tmp_4 := DontCare
    def x1677_tmp_4 = {io.in_x1677_tmp_4} ; io.in_x1677_tmp_4 := DontCare
    def x1676_tmp_3 = {io.in_x1676_tmp_3} ; io.in_x1676_tmp_3 := DontCare
    def x1824_ctrchain = {io.in_x1824_ctrchain} ; io.in_x1824_ctrchain := DontCare
    def x1759_force_0 = {io.in_x1759_force_0} ; io.in_x1759_force_0 := DontCare
    def x1680_tmp_2 = {io.in_x1680_tmp_2} ; io.in_x1680_tmp_2 := DontCare
    def b562 = {io.in_b562} 
    def x1675_tmp_2 = {io.in_x1675_tmp_2} ; io.in_x1675_tmp_2 := DontCare
    def x1679_tmp_1 = {io.in_x1679_tmp_1} ; io.in_x1679_tmp_1 := DontCare
    def b1670 = {io.in_b1670} 
    def x1674_tmp_1 = {io.in_x1674_tmp_1} ; io.in_x1674_tmp_1 := DontCare
    def x1678_tmp_0 = {io.in_x1678_tmp_0} ; io.in_x1678_tmp_0 := DontCare
    def x1673_tmp_0 = {io.in_x1673_tmp_0} ; io.in_x1673_tmp_0 := DontCare
    def x1681_tmp_3 = {io.in_x1681_tmp_3} ; io.in_x1681_tmp_3 := DontCare
  }
  def connectWires0(module: x1853_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x1823_ctrchain.input <> x1823_ctrchain.input; module.io.in_x1823_ctrchain.output <> x1823_ctrchain.output
    module.io.in_b1671 <> b1671
    x1760_force_0.connectLedger(module.io.in_x1760_force_0)
    x1682_tmp_4.connectLedger(module.io.in_x1682_tmp_4)
    x1677_tmp_4.connectLedger(module.io.in_x1677_tmp_4)
    x1676_tmp_3.connectLedger(module.io.in_x1676_tmp_3)
    module.io.in_x1824_ctrchain.input <> x1824_ctrchain.input; module.io.in_x1824_ctrchain.output <> x1824_ctrchain.output
    x1759_force_0.connectLedger(module.io.in_x1759_force_0)
    x1680_tmp_2.connectLedger(module.io.in_x1680_tmp_2)
    module.io.in_b562 <> b562
    x1675_tmp_2.connectLedger(module.io.in_x1675_tmp_2)
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
  val x1823_ctrchain = list_x1823_ctrchain(0)
  val x1824_ctrchain = list_x1823_ctrchain(1)
  val x1760_force_0 = list_x1760_force_0(0)
  val x1682_tmp_4 = list_x1760_force_0(1)
  val x1677_tmp_4 = list_x1760_force_0(2)
  val x1676_tmp_3 = list_x1760_force_0(3)
  val x1759_force_0 = list_x1760_force_0(4)
  val x1680_tmp_2 = list_x1760_force_0(5)
  val x1675_tmp_2 = list_x1760_force_0(6)
  val x1679_tmp_1 = list_x1760_force_0(7)
  val x1674_tmp_1 = list_x1760_force_0(8)
  val x1678_tmp_0 = list_x1760_force_0(9)
  val x1673_tmp_0 = list_x1760_force_0(10)
  val x1681_tmp_3 = list_x1760_force_0(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1853")
    implicit val stack = ControllerStack.stack.toList
    class x1853_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1853_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1853 = Module(new InstrumentationCounter())
      val iters_x1853 = Module(new InstrumentationCounter())
      cycles_x1853.io.enable := io.sigsIn.baseEn
      iters_x1853.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1853_instrctr, cycles_x1853.io.count, iters_x1853.io.count, 0.U, 0.U)
      val x1838_inr_Foreach = new x1838_inr_Foreach_kernel(List(b562,b1670), List(x1677_tmp_4,x1676_tmp_3,x1759_force_0,x1675_tmp_2,x1674_tmp_1,x1673_tmp_0) ,  Some(me), List(x1823_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1838_inr_Foreach.sm.io.ctrDone := (x1838_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1838_inr_Foreach.backpressure := true.B | x1838_inr_Foreach.sm.io.doneLatch
      x1838_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1838_inr_Foreach.sm.io.doneLatch
      x1838_inr_Foreach.sm.io.enableOut.zip(x1838_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1838_inr_Foreach.sm.io.break := false.B
      x1838_inr_Foreach.mask := ~x1838_inr_Foreach.cchain.head.output.noop & b1670 & b562
      x1838_inr_Foreach.configure("x1838_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1838_inr_Foreach.kernel()
      val x1852_inr_Foreach = new x1852_inr_Foreach_kernel(List(b1671,b562), List(x1760_force_0,x1682_tmp_4,x1680_tmp_2,x1679_tmp_1,x1678_tmp_0,x1681_tmp_3) ,  Some(me), List(x1824_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1852_inr_Foreach.sm.io.ctrDone := (x1852_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1852_inr_Foreach.backpressure := true.B | x1852_inr_Foreach.sm.io.doneLatch
      x1852_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1852_inr_Foreach.sm.io.doneLatch
      x1852_inr_Foreach.sm.io.enableOut.zip(x1852_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1852_inr_Foreach.sm.io.break := false.B
      x1852_inr_Foreach.mask := ~x1852_inr_Foreach.cchain.head.output.noop & b1671 & b562
      x1852_inr_Foreach.configure("x1852_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1852_inr_Foreach.kernel()
      x1673_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1674_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1675_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1676_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1677_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1678_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1679_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1680_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1681_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1682_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1759_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1760_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x1853_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1853 **/
