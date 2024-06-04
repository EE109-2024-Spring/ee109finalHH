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

/** Hierarchy: x499 -> x538 -> x444 **/
/** BEGIN None x499_inr_Foreach **/
class x499_inr_Foreach_kernel(
  list_x468_A_dram: List[FixedPoint],
  list_x475_fifo: List[FIFOInterface],
  list_x474: List[DecoupledIO[AppCommandDense]],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 5.0.toInt, myName = "x499_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(5.0.toInt, 2 + _root_.utils.math.log2Up(5.0.toInt), "x499_inr_Foreach_iiCtr"))
  
  abstract class x499_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x468_A_dram = Input(new FixedPoint(true, 64, 0))
      val in_x475_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x475_fifo_p").asInstanceOf[MemParams] ))
      val in_x474 = Decoupled(new AppCommandDense(ModuleParams.getParams("x474_p").asInstanceOf[(Int,Int)] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x468_A_dram = {io.in_x468_A_dram} 
    def x475_fifo = {io.in_x475_fifo} ; io.in_x475_fifo := DontCare
    def x474 = {io.in_x474} 
  }
  def connectWires0(module: x499_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x468_A_dram <> x468_A_dram
    x475_fifo.connectLedger(module.io.in_x475_fifo)
    module.io.in_x474 <> x474
  }
  val x468_A_dram = list_x468_A_dram(0)
  val x475_fifo = list_x475_fifo(0)
  val x474 = list_x474(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x499_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x499_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x499_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b479 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b479.suggestName("b479")
      val b480 = ~io.sigsIn.cchainOutputs.head.oobs(0); b480.suggestName("b480")
      val x738 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x738""")
      val ensig0 = Wire(Bool())
      ensig0 := (~x475_fifo.full.D(5.0-1) | ~(x475_fifo.active(0).out)) & x474.ready
      x738.r := Math.arith_left_shift(b479, 1, Some(0.2), ensig0,"x738").r
      val x739_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x739_sum""")
      x739_sum.r := Math.add(x738,b479,Some(1.0), ensig0, Truncate, Wrapping, "x739_sum").r
      val x482 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x482""")
      x482.r := Math.arith_right_shift_div(x739_sum, 4, Some(0.2), ensig0,"x482").r
      val x483 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x483""")
      x483.r := Math.arith_left_shift(x482, 4, Some(0.2), ensig0,"x483").r
      val x740 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x740""")
      x740.r := Math.arith_left_shift(x482, 6, Some(0.2), ensig0,"x740").r
      val x485_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x485_sub""")
      x485_sub.r := Math.sub(x739_sum,x483,Some(1.0), ensig0, Truncate, Wrapping, "x485_sub").r
      val x486_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x486_sum""")
      x486_sum.r := Math.add(x485_sub,3L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x486_sum").r
      val x487_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x487_sum""")
      x487_sum.r := Math.add(x485_sub,18L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x487_sum").r
      val x488 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x488""")
      x488.r := Math.arith_right_shift_div(x487_sum, 4, Some(0.2), ensig0,"x488").r
      val x489 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x489""")
      x489.r := Math.arith_left_shift(x488, 4, Some(0.2 + 1.0), ensig0,"x489").r
      val x741 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x741""")
      x741.r := Math.arith_left_shift(x488, 6, Some(0.2 + 1.0), ensig0,"x741").r
      val x491 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x491""")
      x491.r := Math.fix2fix(x740, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x491").r
      val x492 = x468_A_dram
      val x758 = Wire(new FixedPoint(true, 64, 0)).suggestName("x758_x492_D1") 
      x758.r := getRetimed(x492.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x493_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x493_sum""")
      x493_sum.r := Math.add(x491,x758,Some(2.0), ensig0, Truncate, Wrapping, "x493_sum").r
      val x759 = Wire(new FixedPoint(true, 64, 0)).suggestName("x759_x493_sum_D1") 
      x759.r := getRetimed(x493_sum.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x494_tuple = Wire(UInt(97.W)).suggestName("""x494_tuple""")
      x494_tuple.r := ConvAndCat(true.B,x741.r,x759.r)
      val x495 = true.B
      val x760 = Wire(Bool()).suggestName("x760_x495_D4") 
      x760.r := getRetimed(x495.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x761 = Wire(Bool()).suggestName("x761_b480_D4") 
      x761.r := getRetimed(b480.r, 4.toInt, io.sigsIn.backpressure & true.B)
      x474.valid := (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(4.0.toInt.toInt, rr, io.sigsIn.backpressure & true.B) & x760&x761 & io.sigsIn.backpressure
      x474.bits.addr := x494_tuple(63,0)
      x474.bits.size := x494_tuple(95,64)
      val x762 = Wire(new FixedPoint(true, 32, 0)).suggestName("x762_x486_sum_D1") 
      x762.r := getRetimed(x486_sum.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x763 = Wire(new FixedPoint(true, 32, 0)).suggestName("x763_x485_sub_D2") 
      x763.r := getRetimed(x485_sub.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x497_tuple = Wire(UInt(96.W)).suggestName("""x497_tuple""")
      x497_tuple.r := ConvAndCat(x762.r,x763.r,x489.r)
      val x498_enq_x475_banks = List[UInt]()
      val x498_enq_x475_ofs = List[UInt]()
      val x498_enq_x475_en = List[Bool](true.B)
      val x498_enq_x475_data = List[UInt](x497_tuple.r)
      x475_fifo.connectWPort(498, x498_enq_x475_banks, x498_enq_x475_ofs, x498_enq_x475_data, x498_enq_x475_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(4.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B & x761))
      x475_fifo.connectAccessActivesIn(0, ((true.B & x761)))
    }
    val module = Module(new x499_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x499_inr_Foreach **/
