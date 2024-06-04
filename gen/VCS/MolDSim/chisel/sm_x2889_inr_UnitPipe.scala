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

/** Hierarchy: x2889 -> x2910 -> x2915 -> x2916 -> x444 **/
/** BEGIN None x2889_inr_UnitPipe **/
class x2889_inr_UnitPipe_kernel(
  list_x470_out_host: List[FixedPoint],
  list_x2860: List[DecoupledIO[AppCommandDense]],
  list_x2869_reg: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 5.0.toInt, myName = "x2889_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2889_inr_UnitPipe_iiCtr"))
  
  abstract class x2889_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2869_reg = Flipped(new StandardInterface(ModuleParams.getParams("x2869_reg_p").asInstanceOf[MemParams] ))
      val in_x2868_reg = Flipped(new StandardInterface(ModuleParams.getParams("x2868_reg_p").asInstanceOf[MemParams] ))
      val in_x2867_reg = Flipped(new StandardInterface(ModuleParams.getParams("x2867_reg_p").asInstanceOf[MemParams] ))
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x2860 = Decoupled(new AppCommandDense(ModuleParams.getParams("x2860_p").asInstanceOf[(Int,Int)] ))
      val in_b2865 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2869_reg = {io.in_x2869_reg} ; io.in_x2869_reg := DontCare
    def x2868_reg = {io.in_x2868_reg} ; io.in_x2868_reg := DontCare
    def x2867_reg = {io.in_x2867_reg} ; io.in_x2867_reg := DontCare
    def x470_out_host = {io.in_x470_out_host} 
    def x2860 = {io.in_x2860} 
    def b2865 = {io.in_b2865} 
  }
  def connectWires0(module: x2889_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2869_reg.connectLedger(module.io.in_x2869_reg)
    x2868_reg.connectLedger(module.io.in_x2868_reg)
    x2867_reg.connectLedger(module.io.in_x2867_reg)
    module.io.in_x470_out_host <> x470_out_host
    module.io.in_x2860 <> x2860
    module.io.in_b2865 <> b2865
  }
  val x470_out_host = list_x470_out_host(0)
  val b2865 = list_x470_out_host(1)
  val x2860 = list_x2860(0)
  val x2869_reg = list_x2869_reg(0)
  val x2868_reg = list_x2869_reg(1)
  val x2867_reg = list_x2869_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2889_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2889_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2889_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2889_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2889_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2889_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2889_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      val stalls_x2889_inr_UnitPipe = Module(new InstrumentationCounter())
      val idles_x2889_inr_UnitPipe = Module(new InstrumentationCounter())
      stalls_x2889_inr_UnitPipe.io.enable := io.sigsIn.baseEn & ~(x2860.ready)
      idles_x2889_inr_UnitPipe.io.enable := io.sigsIn.baseEn & ~((true.B) && (true.B))
      Ledger.tieInstrCtr(instrctrs.toList, X2889_instrctr, cycles_x2889_inr_UnitPipe.io.count, iters_x2889_inr_UnitPipe.io.count, stalls_x2889_inr_UnitPipe.io.count, idles_x2889_inr_UnitPipe.io.count)
      val x3117 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3117""")
      val ensig0 = Wire(Bool())
      ensig0 := x2860.ready
      x3117.r := Math.arith_left_shift(b2865, 1, Some(0.2), ensig0,"x3117").r
      val x3118_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3118_sum""")
      x3118_sum.r := Math.add(x3117,b2865,Some(1.0), ensig0, Truncate, Wrapping, "x3118_sum").r
      val x2871 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2871""")
      x2871.r := Math.arith_right_shift_div(x3118_sum, 4, Some(0.2), ensig0,"x2871").r
      val x2872 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2872""")
      x2872.r := Math.arith_left_shift(x2871, 4, Some(0.2), ensig0,"x2872").r
      val x3119 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3119""")
      x3119.r := Math.arith_left_shift(x2871, 6, Some(0.2), ensig0,"x3119").r
      val x2874_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2874_sub""")
      x2874_sub.r := Math.sub(x3118_sum,x2872,Some(1.0), ensig0, Truncate, Wrapping, "x2874_sub").r
      val x2875_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2875_sum""")
      x2875_sum.r := Math.add(x2874_sub,3L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x2875_sum").r
      val x2876_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2876_sum""")
      x2876_sum.r := Math.add(x2874_sub,18L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x2876_sum").r
      val x2877 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2877""")
      x2877.r := Math.arith_right_shift_div(x2876_sum, 4, Some(0.2), ensig0,"x2877").r
      val x2878 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2878""")
      x2878.r := Math.arith_left_shift(x2877, 4, Some(0.2 + 1.0), ensig0,"x2878").r
      val x3120 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3120""")
      x3120.r := Math.arith_left_shift(x2877, 6, Some(0.2 + 1.0), ensig0,"x3120").r
      val x2880 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x2880""")
      x2880.r := Math.fix2fix(x3119, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x2880").r
      val x2881 = x470_out_host
      val x3821 = Wire(new FixedPoint(true, 64, 0)).suggestName("x3821_x2881_D1") 
      x3821.r := getRetimed(x2881.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2882_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x2882_sum""")
      x2882_sum.r := Math.add(x2880,x3821,Some(2.0), ensig0, Truncate, Wrapping, "x2882_sum").r
      val x3822 = Wire(new FixedPoint(true, 64, 0)).suggestName("x3822_x2882_sum_D1") 
      x3822.r := getRetimed(x2882_sum.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2883_tuple = Wire(UInt(97.W)).suggestName("""x2883_tuple""")
      x2883_tuple.r := ConvAndCat(false.B,x3120.r,x3822.r)
      val x2884 = true.B
      val x3823 = Wire(Bool()).suggestName("x3823_x2884_D4") 
      x3823.r := getRetimed(x2884.r, 4.toInt, io.sigsIn.backpressure & true.B)
      x2860.valid := (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(4.0.toInt.toInt, rr, io.sigsIn.backpressure & true.B) & x3823 & io.sigsIn.backpressure
      x2860.bits.addr := x2883_tuple(63,0)
      x2860.bits.size := x2883_tuple(95,64)
      val x2886_wr_x2867_banks = List[UInt]()
      val x2886_wr_x2867_ofs = List[UInt]()
      val x2886_wr_x2867_en = List[Bool](true.B)
      val x2886_wr_x2867_data = List[UInt](x2874_sub.r)
      x2867_reg.connectWPort(2886, x2886_wr_x2867_banks, x2886_wr_x2867_ofs, x2886_wr_x2867_data, x2886_wr_x2867_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x2887_wr_x2868_banks = List[UInt]()
      val x2887_wr_x2868_ofs = List[UInt]()
      val x2887_wr_x2868_en = List[Bool](true.B)
      val x2887_wr_x2868_data = List[UInt](x2875_sum.r)
      x2868_reg.connectWPort(2887, x2887_wr_x2868_banks, x2887_wr_x2868_ofs, x2887_wr_x2868_data, x2887_wr_x2868_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(3.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x2888_wr_x2869_banks = List[UInt]()
      val x2888_wr_x2869_ofs = List[UInt]()
      val x2888_wr_x2869_en = List[Bool](true.B)
      val x2888_wr_x2869_data = List[UInt](x2878.r)
      x2869_reg.connectWPort(2888, x2888_wr_x2869_banks, x2888_wr_x2869_ofs, x2888_wr_x2869_data, x2888_wr_x2869_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(4.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2889_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2889_inr_UnitPipe **/
