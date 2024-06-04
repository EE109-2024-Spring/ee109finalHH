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

/** Hierarchy: x1729 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1729 **/
class x1729_kernel(
  list_b1671: List[Bool],
  list_x472_A_sram_1: List[StandardInterface],
  list_x1682_tmp_4: List[NBufInterface],
  list_b1668: List[FixedPoint],
  list_x1686_ctrchain: List[CounterChainInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1729_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1729_iiCtr"))
  
  abstract class x1729_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1686_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1686_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b1671 = Input(Bool())
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1682_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1682_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1677_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1677_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1676_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1676_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b1668 = Input(new FixedPoint(true, 32, 0))
      val in_x1680_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1680_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1675_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1675_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1667 = Input(new FixedPoint(true, 32, 0))
      val in_b552 = Input(new FixedPoint(true, 32, 0))
      val in_x1679_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1679_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b1670 = Input(Bool())
      val in_x1685_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1685_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
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
    def x1686_ctrchain = {io.in_x1686_ctrchain} ; io.in_x1686_ctrchain := DontCare
    def b1671 = {io.in_b1671} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1682_tmp_4 = {io.in_x1682_tmp_4} ; io.in_x1682_tmp_4 := DontCare
    def x1677_tmp_4 = {io.in_x1677_tmp_4} ; io.in_x1677_tmp_4 := DontCare
    def x1676_tmp_3 = {io.in_x1676_tmp_3} ; io.in_x1676_tmp_3 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b1668 = {io.in_b1668} 
    def x1680_tmp_2 = {io.in_x1680_tmp_2} ; io.in_x1680_tmp_2 := DontCare
    def b562 = {io.in_b562} 
    def x1675_tmp_2 = {io.in_x1675_tmp_2} ; io.in_x1675_tmp_2 := DontCare
    def b1667 = {io.in_b1667} 
    def b552 = {io.in_b552} 
    def x1679_tmp_1 = {io.in_x1679_tmp_1} ; io.in_x1679_tmp_1 := DontCare
    def b1670 = {io.in_b1670} 
    def x1685_ctrchain = {io.in_x1685_ctrchain} ; io.in_x1685_ctrchain := DontCare
    def x1674_tmp_1 = {io.in_x1674_tmp_1} ; io.in_x1674_tmp_1 := DontCare
    def x1678_tmp_0 = {io.in_x1678_tmp_0} ; io.in_x1678_tmp_0 := DontCare
    def x1673_tmp_0 = {io.in_x1673_tmp_0} ; io.in_x1673_tmp_0 := DontCare
    def x1681_tmp_3 = {io.in_x1681_tmp_3} ; io.in_x1681_tmp_3 := DontCare
  }
  def connectWires0(module: x1729_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x1686_ctrchain.input <> x1686_ctrchain.input; module.io.in_x1686_ctrchain.output <> x1686_ctrchain.output
    module.io.in_b1671 <> b1671
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1682_tmp_4.connectLedger(module.io.in_x1682_tmp_4)
    x1677_tmp_4.connectLedger(module.io.in_x1677_tmp_4)
    x1676_tmp_3.connectLedger(module.io.in_x1676_tmp_3)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b1668 <> b1668
    x1680_tmp_2.connectLedger(module.io.in_x1680_tmp_2)
    module.io.in_b562 <> b562
    x1675_tmp_2.connectLedger(module.io.in_x1675_tmp_2)
    module.io.in_b1667 <> b1667
    module.io.in_b552 <> b552
    x1679_tmp_1.connectLedger(module.io.in_x1679_tmp_1)
    module.io.in_b1670 <> b1670
    module.io.in_x1685_ctrchain.input <> x1685_ctrchain.input; module.io.in_x1685_ctrchain.output <> x1685_ctrchain.output
    x1674_tmp_1.connectLedger(module.io.in_x1674_tmp_1)
    x1678_tmp_0.connectLedger(module.io.in_x1678_tmp_0)
    x1673_tmp_0.connectLedger(module.io.in_x1673_tmp_0)
    x1681_tmp_3.connectLedger(module.io.in_x1681_tmp_3)
  }
  val b1671 = list_b1671(0)
  val b562 = list_b1671(1)
  val b1670 = list_b1671(2)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x1682_tmp_4 = list_x1682_tmp_4(0)
  val x1677_tmp_4 = list_x1682_tmp_4(1)
  val x1676_tmp_3 = list_x1682_tmp_4(2)
  val x1680_tmp_2 = list_x1682_tmp_4(3)
  val x1675_tmp_2 = list_x1682_tmp_4(4)
  val x1679_tmp_1 = list_x1682_tmp_4(5)
  val x1674_tmp_1 = list_x1682_tmp_4(6)
  val x1678_tmp_0 = list_x1682_tmp_4(7)
  val x1673_tmp_0 = list_x1682_tmp_4(8)
  val x1681_tmp_3 = list_x1682_tmp_4(9)
  val b1668 = list_b1668(0)
  val b1667 = list_b1668(1)
  val b552 = list_b1668(2)
  val x1686_ctrchain = list_x1686_ctrchain(0)
  val x1685_ctrchain = list_x1686_ctrchain(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1729")
    implicit val stack = ControllerStack.stack.toList
    class x1729_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1729_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1729 = Module(new InstrumentationCounter())
      val iters_x1729 = Module(new InstrumentationCounter())
      cycles_x1729.io.enable := io.sigsIn.baseEn
      iters_x1729.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1729_instrctr, cycles_x1729.io.count, iters_x1729.io.count, 0.U, 0.U)
      val x1707_inr_Foreach = new x1707_inr_Foreach_kernel(List(b562,b1670), List(b1667,b552), List(x1677_tmp_4,x1676_tmp_3,x1675_tmp_2,x1674_tmp_1,x1673_tmp_0), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x1685_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1707_inr_Foreach.sm.io.ctrDone := (x1707_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1707_inr_Foreach.backpressure := true.B | x1707_inr_Foreach.sm.io.doneLatch
      x1707_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1707_inr_Foreach.sm.io.doneLatch
      x1707_inr_Foreach.sm.io.enableOut.zip(x1707_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1707_inr_Foreach.sm.io.break := false.B
      x1707_inr_Foreach.mask := ~x1707_inr_Foreach.cchain.head.output.noop & b1670 & b562
      x1707_inr_Foreach.configure("x1707_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1707_inr_Foreach.kernel()
      val x1728_inr_Foreach = new x1728_inr_Foreach_kernel(List(b1671,b562), List(b1668,b552), List(x1682_tmp_4,x1680_tmp_2,x1679_tmp_1,x1678_tmp_0,x1681_tmp_3), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x1686_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1728_inr_Foreach.sm.io.ctrDone := (x1728_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1728_inr_Foreach.backpressure := true.B | x1728_inr_Foreach.sm.io.doneLatch
      x1728_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1728_inr_Foreach.sm.io.doneLatch
      x1728_inr_Foreach.sm.io.enableOut.zip(x1728_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1728_inr_Foreach.sm.io.break := false.B
      x1728_inr_Foreach.mask := ~x1728_inr_Foreach.cchain.head.output.noop & b1671 & b562
      x1728_inr_Foreach.configure("x1728_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1728_inr_Foreach.kernel()
      x1673_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1674_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1675_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1676_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1677_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1678_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1679_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1680_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1681_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1682_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1729_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1729 **/
