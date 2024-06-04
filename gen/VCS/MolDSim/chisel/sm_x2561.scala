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

/** Hierarchy: x2561 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2561 **/
class x2561_kernel(
  list_b566: List[Bool],
  list_x2512_tmp_2: List[NBufInterface],
  list_x2518_ctrchain: List[CounterChainInterface],
  list_x472_A_sram_1: List[StandardInterface],
  list_b2499: List[FixedPoint],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2561_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2561_iiCtr"))
  
  abstract class x2561_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2499 = Input(new FixedPoint(true, 32, 0))
      val in_x2512_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2512_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x2508_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2508_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_x2509_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2509_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2505_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2505_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2514_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2514_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2510_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2510_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2506_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2506_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b2503 = Input(Bool())
      val in_x2513_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2513_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2518_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2518_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b2500 = Input(new FixedPoint(true, 32, 0))
      val in_x2511_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2511_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b556 = Input(new FixedPoint(true, 32, 0))
      val in_x2517_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2517_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b2502 = Input(Bool())
      val in_x2507_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2507_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def b2499 = {io.in_b2499} 
    def x2512_tmp_2 = {io.in_x2512_tmp_2} ; io.in_x2512_tmp_2 := DontCare
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x2508_tmp_3 = {io.in_x2508_tmp_3} ; io.in_x2508_tmp_3 := DontCare
    def b566 = {io.in_b566} 
    def x2509_tmp_4 = {io.in_x2509_tmp_4} ; io.in_x2509_tmp_4 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x2505_tmp_0 = {io.in_x2505_tmp_0} ; io.in_x2505_tmp_0 := DontCare
    def x2514_tmp_4 = {io.in_x2514_tmp_4} ; io.in_x2514_tmp_4 := DontCare
    def x2510_tmp_0 = {io.in_x2510_tmp_0} ; io.in_x2510_tmp_0 := DontCare
    def x2506_tmp_1 = {io.in_x2506_tmp_1} ; io.in_x2506_tmp_1 := DontCare
    def b2503 = {io.in_b2503} 
    def x2513_tmp_3 = {io.in_x2513_tmp_3} ; io.in_x2513_tmp_3 := DontCare
    def x2518_ctrchain = {io.in_x2518_ctrchain} ; io.in_x2518_ctrchain := DontCare
    def b2500 = {io.in_b2500} 
    def x2511_tmp_1 = {io.in_x2511_tmp_1} ; io.in_x2511_tmp_1 := DontCare
    def b556 = {io.in_b556} 
    def x2517_ctrchain = {io.in_x2517_ctrchain} ; io.in_x2517_ctrchain := DontCare
    def b2502 = {io.in_b2502} 
    def x2507_tmp_2 = {io.in_x2507_tmp_2} ; io.in_x2507_tmp_2 := DontCare
  }
  def connectWires0(module: x2561_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2499 <> b2499
    x2512_tmp_2.connectLedger(module.io.in_x2512_tmp_2)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x2508_tmp_3.connectLedger(module.io.in_x2508_tmp_3)
    module.io.in_b566 <> b566
    x2509_tmp_4.connectLedger(module.io.in_x2509_tmp_4)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x2505_tmp_0.connectLedger(module.io.in_x2505_tmp_0)
    x2514_tmp_4.connectLedger(module.io.in_x2514_tmp_4)
    x2510_tmp_0.connectLedger(module.io.in_x2510_tmp_0)
    x2506_tmp_1.connectLedger(module.io.in_x2506_tmp_1)
    module.io.in_b2503 <> b2503
    x2513_tmp_3.connectLedger(module.io.in_x2513_tmp_3)
    module.io.in_x2518_ctrchain.input <> x2518_ctrchain.input; module.io.in_x2518_ctrchain.output <> x2518_ctrchain.output
    module.io.in_b2500 <> b2500
    x2511_tmp_1.connectLedger(module.io.in_x2511_tmp_1)
    module.io.in_b556 <> b556
    module.io.in_x2517_ctrchain.input <> x2517_ctrchain.input; module.io.in_x2517_ctrchain.output <> x2517_ctrchain.output
    module.io.in_b2502 <> b2502
    x2507_tmp_2.connectLedger(module.io.in_x2507_tmp_2)
  }
  val b566 = list_b566(0)
  val b2503 = list_b566(1)
  val b2502 = list_b566(2)
  val x2512_tmp_2 = list_x2512_tmp_2(0)
  val x2508_tmp_3 = list_x2512_tmp_2(1)
  val x2509_tmp_4 = list_x2512_tmp_2(2)
  val x2505_tmp_0 = list_x2512_tmp_2(3)
  val x2514_tmp_4 = list_x2512_tmp_2(4)
  val x2510_tmp_0 = list_x2512_tmp_2(5)
  val x2506_tmp_1 = list_x2512_tmp_2(6)
  val x2513_tmp_3 = list_x2512_tmp_2(7)
  val x2511_tmp_1 = list_x2512_tmp_2(8)
  val x2507_tmp_2 = list_x2512_tmp_2(9)
  val x2518_ctrchain = list_x2518_ctrchain(0)
  val x2517_ctrchain = list_x2518_ctrchain(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val b2499 = list_b2499(0)
  val b2500 = list_b2499(1)
  val b556 = list_b2499(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2561")
    implicit val stack = ControllerStack.stack.toList
    class x2561_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2561_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2561 = Module(new InstrumentationCounter())
      val iters_x2561 = Module(new InstrumentationCounter())
      cycles_x2561.io.enable := io.sigsIn.baseEn
      iters_x2561.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2561_instrctr, cycles_x2561.io.count, iters_x2561.io.count, 0.U, 0.U)
      val x2539_inr_Foreach = new x2539_inr_Foreach_kernel(List(b566,b2502), List(b2499,b556), List(x2508_tmp_3,x2509_tmp_4,x2505_tmp_0,x2506_tmp_1,x2507_tmp_2), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x2517_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2539_inr_Foreach.sm.io.ctrDone := (x2539_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2539_inr_Foreach.backpressure := true.B | x2539_inr_Foreach.sm.io.doneLatch
      x2539_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2539_inr_Foreach.sm.io.doneLatch
      x2539_inr_Foreach.sm.io.enableOut.zip(x2539_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2539_inr_Foreach.sm.io.break := false.B
      x2539_inr_Foreach.mask := ~x2539_inr_Foreach.cchain.head.output.noop & b2502 & b566
      x2539_inr_Foreach.configure("x2539_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2539_inr_Foreach.kernel()
      val x2560_inr_Foreach = new x2560_inr_Foreach_kernel(List(b566,b2503), List(b2500,b556), List(x472_A_sram_1,x471_A_sram_0), List(x2512_tmp_2,x2514_tmp_4,x2510_tmp_0,x2513_tmp_3,x2511_tmp_1) ,  Some(me), List(x2518_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2560_inr_Foreach.sm.io.ctrDone := (x2560_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2560_inr_Foreach.backpressure := true.B | x2560_inr_Foreach.sm.io.doneLatch
      x2560_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2560_inr_Foreach.sm.io.doneLatch
      x2560_inr_Foreach.sm.io.enableOut.zip(x2560_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2560_inr_Foreach.sm.io.break := false.B
      x2560_inr_Foreach.mask := ~x2560_inr_Foreach.cchain.head.output.noop & b2503 & b566
      x2560_inr_Foreach.configure("x2560_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2560_inr_Foreach.kernel()
      x2505_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2506_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2507_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2508_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2509_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2510_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2511_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2512_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2513_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x2514_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x2561_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2561 **/
