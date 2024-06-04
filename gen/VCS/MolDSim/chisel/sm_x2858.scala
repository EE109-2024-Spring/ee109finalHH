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

/** Hierarchy: x2858 -> x2859 -> x444 **/
/** BEGIN None x2858 **/
class x2858_kernel(
  list_x582_accum_1: List[NBufInterface],
  list_x473_A_sram_2: List[StandardInterface],
  list_x2723_ctrchain: List[CounterChainInterface],
  list_b565: List[Bool],
  list_b555: List[FixedPoint],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 10, isFSM = false   , latency = 0.0.toInt, myName = "x2858_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2858_iiCtr"))
  
  abstract class x2858_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b555 = Input(new FixedPoint(true, 32, 0))
      val in_x582_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x582_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x2723_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2723_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b565 = Input(Bool())
      val in_x570_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x570_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b559 = Input(Bool())
      val in_x574_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x574_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x2718_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2718_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b561 = Input(Bool())
      val in_b566 = Input(Bool())
      val in_b551 = Input(new FixedPoint(true, 32, 0))
      val in_x578_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x578_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x2726_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2726_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x2724_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2724_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b554 = Input(new FixedPoint(true, 32, 0))
      val in_b547 = Input(new FixedPoint(true, 32, 0))
      val in_b558 = Input(Bool())
      val in_x586_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x586_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x584_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x584_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x2727_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2727_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x572_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x572_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x2721_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2721_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b552 = Input(new FixedPoint(true, 32, 0))
      val in_x2725_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2725_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b563 = Input(Bool())
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_b548 = Input(new FixedPoint(true, 32, 0))
      val in_b553 = Input(new FixedPoint(true, 32, 0))
      val in_b557 = Input(Bool())
      val in_x580_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x580_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x2720_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2720_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x576_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x576_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2722_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2722_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b556 = Input(new FixedPoint(true, 32, 0))
      val in_x568_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x568_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b549 = Input(new FixedPoint(true, 32, 0))
      val in_x2719_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x2719_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b564 = Input(Bool())
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(10, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(10, 1))
      val rr = Input(Bool())
    })
    def b555 = {io.in_b555} 
    def x582_accum_1 = {io.in_x582_accum_1} ; io.in_x582_accum_1 := DontCare
    def b550 = {io.in_b550} 
    def x2723_ctrchain = {io.in_x2723_ctrchain} ; io.in_x2723_ctrchain := DontCare
    def b565 = {io.in_b565} 
    def x570_accum_1 = {io.in_x570_accum_1} ; io.in_x570_accum_1 := DontCare
    def b559 = {io.in_b559} 
    def x574_accum_1 = {io.in_x574_accum_1} ; io.in_x574_accum_1 := DontCare
    def x2718_ctrchain = {io.in_x2718_ctrchain} ; io.in_x2718_ctrchain := DontCare
    def b561 = {io.in_b561} 
    def b566 = {io.in_b566} 
    def b551 = {io.in_b551} 
    def x578_accum_1 = {io.in_x578_accum_1} ; io.in_x578_accum_1 := DontCare
    def x2726_ctrchain = {io.in_x2726_ctrchain} ; io.in_x2726_ctrchain := DontCare
    def x2724_ctrchain = {io.in_x2724_ctrchain} ; io.in_x2724_ctrchain := DontCare
    def b554 = {io.in_b554} 
    def b547 = {io.in_b547} 
    def b558 = {io.in_b558} 
    def x586_accum_1 = {io.in_x586_accum_1} ; io.in_x586_accum_1 := DontCare
    def x584_accum_1 = {io.in_x584_accum_1} ; io.in_x584_accum_1 := DontCare
    def b562 = {io.in_b562} 
    def x2727_ctrchain = {io.in_x2727_ctrchain} ; io.in_x2727_ctrchain := DontCare
    def x572_accum_1 = {io.in_x572_accum_1} ; io.in_x572_accum_1 := DontCare
    def x2721_ctrchain = {io.in_x2721_ctrchain} ; io.in_x2721_ctrchain := DontCare
    def b552 = {io.in_b552} 
    def x2725_ctrchain = {io.in_x2725_ctrchain} ; io.in_x2725_ctrchain := DontCare
    def b563 = {io.in_b563} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def b548 = {io.in_b548} 
    def b553 = {io.in_b553} 
    def b557 = {io.in_b557} 
    def x580_accum_1 = {io.in_x580_accum_1} ; io.in_x580_accum_1 := DontCare
    def x2720_ctrchain = {io.in_x2720_ctrchain} ; io.in_x2720_ctrchain := DontCare
    def x576_accum_1 = {io.in_x576_accum_1} ; io.in_x576_accum_1 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def x2722_ctrchain = {io.in_x2722_ctrchain} ; io.in_x2722_ctrchain := DontCare
    def b556 = {io.in_b556} 
    def x568_accum_1 = {io.in_x568_accum_1} ; io.in_x568_accum_1 := DontCare
    def b549 = {io.in_b549} 
    def x2719_ctrchain = {io.in_x2719_ctrchain} ; io.in_x2719_ctrchain := DontCare
    def b564 = {io.in_b564} 
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x2858_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b555 <> b555
    x582_accum_1.connectLedger(module.io.in_x582_accum_1)
    module.io.in_b550 <> b550
    module.io.in_x2723_ctrchain.input <> x2723_ctrchain.input; module.io.in_x2723_ctrchain.output <> x2723_ctrchain.output
    module.io.in_b565 <> b565
    x570_accum_1.connectLedger(module.io.in_x570_accum_1)
    module.io.in_b559 <> b559
    x574_accum_1.connectLedger(module.io.in_x574_accum_1)
    module.io.in_x2718_ctrchain.input <> x2718_ctrchain.input; module.io.in_x2718_ctrchain.output <> x2718_ctrchain.output
    module.io.in_b561 <> b561
    module.io.in_b566 <> b566
    module.io.in_b551 <> b551
    x578_accum_1.connectLedger(module.io.in_x578_accum_1)
    module.io.in_x2726_ctrchain.input <> x2726_ctrchain.input; module.io.in_x2726_ctrchain.output <> x2726_ctrchain.output
    module.io.in_x2724_ctrchain.input <> x2724_ctrchain.input; module.io.in_x2724_ctrchain.output <> x2724_ctrchain.output
    module.io.in_b554 <> b554
    module.io.in_b547 <> b547
    module.io.in_b558 <> b558
    x586_accum_1.connectLedger(module.io.in_x586_accum_1)
    x584_accum_1.connectLedger(module.io.in_x584_accum_1)
    module.io.in_b562 <> b562
    module.io.in_x2727_ctrchain.input <> x2727_ctrchain.input; module.io.in_x2727_ctrchain.output <> x2727_ctrchain.output
    x572_accum_1.connectLedger(module.io.in_x572_accum_1)
    module.io.in_x2721_ctrchain.input <> x2721_ctrchain.input; module.io.in_x2721_ctrchain.output <> x2721_ctrchain.output
    module.io.in_b552 <> b552
    module.io.in_x2725_ctrchain.input <> x2725_ctrchain.input; module.io.in_x2725_ctrchain.output <> x2725_ctrchain.output
    module.io.in_b563 <> b563
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    module.io.in_b548 <> b548
    module.io.in_b553 <> b553
    module.io.in_b557 <> b557
    x580_accum_1.connectLedger(module.io.in_x580_accum_1)
    module.io.in_x2720_ctrchain.input <> x2720_ctrchain.input; module.io.in_x2720_ctrchain.output <> x2720_ctrchain.output
    x576_accum_1.connectLedger(module.io.in_x576_accum_1)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    module.io.in_x2722_ctrchain.input <> x2722_ctrchain.input; module.io.in_x2722_ctrchain.output <> x2722_ctrchain.output
    module.io.in_b556 <> b556
    x568_accum_1.connectLedger(module.io.in_x568_accum_1)
    module.io.in_b549 <> b549
    module.io.in_x2719_ctrchain.input <> x2719_ctrchain.input; module.io.in_x2719_ctrchain.output <> x2719_ctrchain.output
    module.io.in_b564 <> b564
    module.io.in_b560 <> b560
  }
  val x582_accum_1 = list_x582_accum_1(0)
  val x570_accum_1 = list_x582_accum_1(1)
  val x574_accum_1 = list_x582_accum_1(2)
  val x578_accum_1 = list_x582_accum_1(3)
  val x586_accum_1 = list_x582_accum_1(4)
  val x584_accum_1 = list_x582_accum_1(5)
  val x572_accum_1 = list_x582_accum_1(6)
  val x580_accum_1 = list_x582_accum_1(7)
  val x576_accum_1 = list_x582_accum_1(8)
  val x568_accum_1 = list_x582_accum_1(9)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x544_out_sram_0 = list_x473_A_sram_2(1)
  val x2723_ctrchain = list_x2723_ctrchain(0)
  val x2718_ctrchain = list_x2723_ctrchain(1)
  val x2726_ctrchain = list_x2723_ctrchain(2)
  val x2724_ctrchain = list_x2723_ctrchain(3)
  val x2727_ctrchain = list_x2723_ctrchain(4)
  val x2721_ctrchain = list_x2723_ctrchain(5)
  val x2725_ctrchain = list_x2723_ctrchain(6)
  val x2720_ctrchain = list_x2723_ctrchain(7)
  val x2722_ctrchain = list_x2723_ctrchain(8)
  val x2719_ctrchain = list_x2723_ctrchain(9)
  val b565 = list_b565(0)
  val b559 = list_b565(1)
  val b561 = list_b565(2)
  val b566 = list_b565(3)
  val b558 = list_b565(4)
  val b562 = list_b565(5)
  val b563 = list_b565(6)
  val b557 = list_b565(7)
  val b564 = list_b565(8)
  val b560 = list_b565(9)
  val b555 = list_b555(0)
  val b550 = list_b555(1)
  val b551 = list_b555(2)
  val b554 = list_b555(3)
  val b547 = list_b555(4)
  val b552 = list_b555(5)
  val b548 = list_b555(6)
  val b553 = list_b555(7)
  val b556 = list_b555(8)
  val b549 = list_b555(9)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2858")
    implicit val stack = ControllerStack.stack.toList
    class x2858_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2858_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2858 = Module(new InstrumentationCounter())
      val iters_x2858 = Module(new InstrumentationCounter())
      cycles_x2858.io.enable := io.sigsIn.baseEn
      iters_x2858.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2858_instrctr, cycles_x2858.io.count, iters_x2858.io.count, 0.U, 0.U)
      val x2740_inr_Foreach = new x2740_inr_Foreach_kernel(List(b557), List(b547), List(x568_accum_1), List(x473_A_sram_2,x544_out_sram_0) ,  Some(me), List(x2718_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2740_inr_Foreach.sm.io.ctrDone := (x2740_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2740_inr_Foreach.backpressure := true.B | x2740_inr_Foreach.sm.io.doneLatch
      x2740_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2740_inr_Foreach.sm.io.doneLatch
      x2740_inr_Foreach.sm.io.enableOut.zip(x2740_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2740_inr_Foreach.sm.io.break := false.B
      x2740_inr_Foreach.mask := ~x2740_inr_Foreach.cchain.head.output.noop & b557
      x2740_inr_Foreach.configure("x2740_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2740_inr_Foreach.kernel()
      val x2753_inr_Foreach = new x2753_inr_Foreach_kernel(List(b558), List(b548), List(x473_A_sram_2,x544_out_sram_0), List(x570_accum_1) ,  Some(me), List(x2719_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2753_inr_Foreach.sm.io.ctrDone := (x2753_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2753_inr_Foreach.backpressure := true.B | x2753_inr_Foreach.sm.io.doneLatch
      x2753_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2753_inr_Foreach.sm.io.doneLatch
      x2753_inr_Foreach.sm.io.enableOut.zip(x2753_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2753_inr_Foreach.sm.io.break := false.B
      x2753_inr_Foreach.mask := ~x2753_inr_Foreach.cchain.head.output.noop & b558
      x2753_inr_Foreach.configure("x2753_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2753_inr_Foreach.kernel()
      val x2766_inr_Foreach = new x2766_inr_Foreach_kernel(List(b559), List(b549), List(x473_A_sram_2,x544_out_sram_0), List(x572_accum_1) ,  Some(me), List(x2720_ctrchain), 2, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2766_inr_Foreach.sm.io.ctrDone := (x2766_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2766_inr_Foreach.backpressure := true.B | x2766_inr_Foreach.sm.io.doneLatch
      x2766_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2766_inr_Foreach.sm.io.doneLatch
      x2766_inr_Foreach.sm.io.enableOut.zip(x2766_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2766_inr_Foreach.sm.io.break := false.B
      x2766_inr_Foreach.mask := ~x2766_inr_Foreach.cchain.head.output.noop & b559
      x2766_inr_Foreach.configure("x2766_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2766_inr_Foreach.kernel()
      val x2779_inr_Foreach = new x2779_inr_Foreach_kernel(List(b560), List(b550), List(x473_A_sram_2,x544_out_sram_0), List(x574_accum_1) ,  Some(me), List(x2721_ctrchain), 3, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2779_inr_Foreach.sm.io.ctrDone := (x2779_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2779_inr_Foreach.backpressure := true.B | x2779_inr_Foreach.sm.io.doneLatch
      x2779_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2779_inr_Foreach.sm.io.doneLatch
      x2779_inr_Foreach.sm.io.enableOut.zip(x2779_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2779_inr_Foreach.sm.io.break := false.B
      x2779_inr_Foreach.mask := ~x2779_inr_Foreach.cchain.head.output.noop & b560
      x2779_inr_Foreach.configure("x2779_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2779_inr_Foreach.kernel()
      val x2792_inr_Foreach = new x2792_inr_Foreach_kernel(List(b561), List(b551), List(x576_accum_1), List(x473_A_sram_2,x544_out_sram_0) ,  Some(me), List(x2722_ctrchain), 4, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2792_inr_Foreach.sm.io.ctrDone := (x2792_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2792_inr_Foreach.backpressure := true.B | x2792_inr_Foreach.sm.io.doneLatch
      x2792_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2792_inr_Foreach.sm.io.doneLatch
      x2792_inr_Foreach.sm.io.enableOut.zip(x2792_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2792_inr_Foreach.sm.io.break := false.B
      x2792_inr_Foreach.mask := ~x2792_inr_Foreach.cchain.head.output.noop & b561
      x2792_inr_Foreach.configure("x2792_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2792_inr_Foreach.kernel()
      val x2805_inr_Foreach = new x2805_inr_Foreach_kernel(List(b562), List(b552), List(x473_A_sram_2,x544_out_sram_0), List(x578_accum_1) ,  Some(me), List(x2723_ctrchain), 5, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2805_inr_Foreach.sm.io.ctrDone := (x2805_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2805_inr_Foreach.backpressure := true.B | x2805_inr_Foreach.sm.io.doneLatch
      x2805_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2805_inr_Foreach.sm.io.doneLatch
      x2805_inr_Foreach.sm.io.enableOut.zip(x2805_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2805_inr_Foreach.sm.io.break := false.B
      x2805_inr_Foreach.mask := ~x2805_inr_Foreach.cchain.head.output.noop & b562
      x2805_inr_Foreach.configure("x2805_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2805_inr_Foreach.kernel()
      val x2818_inr_Foreach = new x2818_inr_Foreach_kernel(List(b563), List(b553), List(x580_accum_1), List(x473_A_sram_2,x544_out_sram_0) ,  Some(me), List(x2724_ctrchain), 6, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2818_inr_Foreach.sm.io.ctrDone := (x2818_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2818_inr_Foreach.backpressure := true.B | x2818_inr_Foreach.sm.io.doneLatch
      x2818_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2818_inr_Foreach.sm.io.doneLatch
      x2818_inr_Foreach.sm.io.enableOut.zip(x2818_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2818_inr_Foreach.sm.io.break := false.B
      x2818_inr_Foreach.mask := ~x2818_inr_Foreach.cchain.head.output.noop & b563
      x2818_inr_Foreach.configure("x2818_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2818_inr_Foreach.kernel()
      val x2831_inr_Foreach = new x2831_inr_Foreach_kernel(List(b564), List(b554), List(x473_A_sram_2,x544_out_sram_0), List(x582_accum_1) ,  Some(me), List(x2725_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2831_inr_Foreach.sm.io.ctrDone := (x2831_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2831_inr_Foreach.backpressure := true.B | x2831_inr_Foreach.sm.io.doneLatch
      x2831_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2831_inr_Foreach.sm.io.doneLatch
      x2831_inr_Foreach.sm.io.enableOut.zip(x2831_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2831_inr_Foreach.sm.io.break := false.B
      x2831_inr_Foreach.mask := ~x2831_inr_Foreach.cchain.head.output.noop & b564
      x2831_inr_Foreach.configure("x2831_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2831_inr_Foreach.kernel()
      val x2844_inr_Foreach = new x2844_inr_Foreach_kernel(List(b565), List(b555), List(x473_A_sram_2,x544_out_sram_0), List(x584_accum_1) ,  Some(me), List(x2726_ctrchain), 8, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2844_inr_Foreach.sm.io.ctrDone := (x2844_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2844_inr_Foreach.backpressure := true.B | x2844_inr_Foreach.sm.io.doneLatch
      x2844_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2844_inr_Foreach.sm.io.doneLatch
      x2844_inr_Foreach.sm.io.enableOut.zip(x2844_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2844_inr_Foreach.sm.io.break := false.B
      x2844_inr_Foreach.mask := ~x2844_inr_Foreach.cchain.head.output.noop & b565
      x2844_inr_Foreach.configure("x2844_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2844_inr_Foreach.kernel()
      val x2857_inr_Foreach = new x2857_inr_Foreach_kernel(List(b566), List(b556), List(x473_A_sram_2,x544_out_sram_0), List(x586_accum_1) ,  Some(me), List(x2727_ctrchain), 9, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2857_inr_Foreach.sm.io.ctrDone := (x2857_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2857_inr_Foreach.backpressure := true.B | x2857_inr_Foreach.sm.io.doneLatch
      x2857_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2857_inr_Foreach.sm.io.doneLatch
      x2857_inr_Foreach.sm.io.enableOut.zip(x2857_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2857_inr_Foreach.sm.io.break := false.B
      x2857_inr_Foreach.mask := ~x2857_inr_Foreach.cchain.head.output.noop & b566
      x2857_inr_Foreach.configure("x2857_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2857_inr_Foreach.kernel()
      x568_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x570_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x572_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x574_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x576_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x578_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x580_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x582_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x584_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x586_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x2858_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2858 **/
