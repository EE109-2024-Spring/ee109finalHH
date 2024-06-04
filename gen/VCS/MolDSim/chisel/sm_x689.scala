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

/** Hierarchy: x689 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x689 **/
class x689_kernel(
  list_b628: List[FixedPoint],
  list_x645_ctrchain: List[CounterChainInterface],
  list_x638_tmp_0: List[NBufInterface],
  list_b630: List[Bool],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x689_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x689_iiCtr"))
  
  abstract class x689_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x645_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x645_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b628 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x638_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x638_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x646_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x646_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x634_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x634_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b630 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x642_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x642_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x637_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x637_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b547 = Input(new FixedPoint(true, 32, 0))
      val in_x633_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x633_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x641_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x641_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b631 = Input(Bool())
      val in_x636_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x636_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b557 = Input(Bool())
      val in_x640_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x640_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b627 = Input(new FixedPoint(true, 32, 0))
      val in_x635_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x635_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x639_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x639_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x645_ctrchain = {io.in_x645_ctrchain} ; io.in_x645_ctrchain := DontCare
    def b628 = {io.in_b628} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x638_tmp_0 = {io.in_x638_tmp_0} ; io.in_x638_tmp_0 := DontCare
    def x646_ctrchain = {io.in_x646_ctrchain} ; io.in_x646_ctrchain := DontCare
    def x634_tmp_1 = {io.in_x634_tmp_1} ; io.in_x634_tmp_1 := DontCare
    def b630 = {io.in_b630} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x642_tmp_4 = {io.in_x642_tmp_4} ; io.in_x642_tmp_4 := DontCare
    def x637_tmp_4 = {io.in_x637_tmp_4} ; io.in_x637_tmp_4 := DontCare
    def b547 = {io.in_b547} 
    def x633_tmp_0 = {io.in_x633_tmp_0} ; io.in_x633_tmp_0 := DontCare
    def x641_tmp_3 = {io.in_x641_tmp_3} ; io.in_x641_tmp_3 := DontCare
    def b631 = {io.in_b631} 
    def x636_tmp_3 = {io.in_x636_tmp_3} ; io.in_x636_tmp_3 := DontCare
    def b557 = {io.in_b557} 
    def x640_tmp_2 = {io.in_x640_tmp_2} ; io.in_x640_tmp_2 := DontCare
    def b627 = {io.in_b627} 
    def x635_tmp_2 = {io.in_x635_tmp_2} ; io.in_x635_tmp_2 := DontCare
    def x639_tmp_1 = {io.in_x639_tmp_1} ; io.in_x639_tmp_1 := DontCare
  }
  def connectWires0(module: x689_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x645_ctrchain.input <> x645_ctrchain.input; module.io.in_x645_ctrchain.output <> x645_ctrchain.output
    module.io.in_b628 <> b628
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x638_tmp_0.connectLedger(module.io.in_x638_tmp_0)
    module.io.in_x646_ctrchain.input <> x646_ctrchain.input; module.io.in_x646_ctrchain.output <> x646_ctrchain.output
    x634_tmp_1.connectLedger(module.io.in_x634_tmp_1)
    module.io.in_b630 <> b630
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x642_tmp_4.connectLedger(module.io.in_x642_tmp_4)
    x637_tmp_4.connectLedger(module.io.in_x637_tmp_4)
    module.io.in_b547 <> b547
    x633_tmp_0.connectLedger(module.io.in_x633_tmp_0)
    x641_tmp_3.connectLedger(module.io.in_x641_tmp_3)
    module.io.in_b631 <> b631
    x636_tmp_3.connectLedger(module.io.in_x636_tmp_3)
    module.io.in_b557 <> b557
    x640_tmp_2.connectLedger(module.io.in_x640_tmp_2)
    module.io.in_b627 <> b627
    x635_tmp_2.connectLedger(module.io.in_x635_tmp_2)
    x639_tmp_1.connectLedger(module.io.in_x639_tmp_1)
  }
  val b628 = list_b628(0)
  val b547 = list_b628(1)
  val b627 = list_b628(2)
  val x645_ctrchain = list_x645_ctrchain(0)
  val x646_ctrchain = list_x645_ctrchain(1)
  val x638_tmp_0 = list_x638_tmp_0(0)
  val x634_tmp_1 = list_x638_tmp_0(1)
  val x642_tmp_4 = list_x638_tmp_0(2)
  val x637_tmp_4 = list_x638_tmp_0(3)
  val x633_tmp_0 = list_x638_tmp_0(4)
  val x641_tmp_3 = list_x638_tmp_0(5)
  val x636_tmp_3 = list_x638_tmp_0(6)
  val x640_tmp_2 = list_x638_tmp_0(7)
  val x635_tmp_2 = list_x638_tmp_0(8)
  val x639_tmp_1 = list_x638_tmp_0(9)
  val b630 = list_b630(0)
  val b631 = list_b630(1)
  val b557 = list_b630(2)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x689")
    implicit val stack = ControllerStack.stack.toList
    class x689_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x689_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x689 = Module(new InstrumentationCounter())
      val iters_x689 = Module(new InstrumentationCounter())
      cycles_x689.io.enable := io.sigsIn.baseEn
      iters_x689.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X689_instrctr, cycles_x689.io.count, iters_x689.io.count, 0.U, 0.U)
      val x667_inr_Foreach = new x667_inr_Foreach_kernel(List(b630,b557), List(b547,b627), List(x634_tmp_1,x637_tmp_4,x633_tmp_0,x636_tmp_3,x635_tmp_2), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x645_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x667_inr_Foreach.sm.io.ctrDone := (x667_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x667_inr_Foreach.backpressure := true.B | x667_inr_Foreach.sm.io.doneLatch
      x667_inr_Foreach.forwardpressure := (true.B) && (true.B) | x667_inr_Foreach.sm.io.doneLatch
      x667_inr_Foreach.sm.io.enableOut.zip(x667_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x667_inr_Foreach.sm.io.break := false.B
      x667_inr_Foreach.mask := ~x667_inr_Foreach.cchain.head.output.noop & b630 & b557
      x667_inr_Foreach.configure("x667_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x667_inr_Foreach.kernel()
      val x688_inr_Foreach = new x688_inr_Foreach_kernel(List(b631,b557), List(b628,b547), List(x638_tmp_0,x642_tmp_4,x641_tmp_3,x640_tmp_2,x639_tmp_1), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x646_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x688_inr_Foreach.sm.io.ctrDone := (x688_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x688_inr_Foreach.backpressure := true.B | x688_inr_Foreach.sm.io.doneLatch
      x688_inr_Foreach.forwardpressure := (true.B) && (true.B) | x688_inr_Foreach.sm.io.doneLatch
      x688_inr_Foreach.sm.io.enableOut.zip(x688_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x688_inr_Foreach.sm.io.break := false.B
      x688_inr_Foreach.mask := ~x688_inr_Foreach.cchain.head.output.noop & b631 & b557
      x688_inr_Foreach.configure("x688_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x688_inr_Foreach.kernel()
      x633_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x634_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x635_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x636_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x637_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x638_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x639_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x640_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x641_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x642_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x689_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x689 **/
