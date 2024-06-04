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

/** Hierarchy: x2423 -> x2425 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2423_inr_SwitchCase **/
class x2423_inr_SwitchCase_kernel(
  list_x2354_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x2423_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2423_inr_SwitchCase_iiCtr"))
  
  abstract class x2423_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2354_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2354_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2385_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2385_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2354_r_0 = {io.in_x2354_r_0} ; io.in_x2354_r_0 := DontCare
    def x2385_reg = {io.in_x2385_reg} ; io.in_x2385_reg := DontCare
  }
  def connectWires0(module: x2423_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x2354_r_0.connectLedger(module.io.in_x2354_r_0)
    x2385_reg.connectLedger(module.io.in_x2385_reg)
  }
  val x2354_r_0 = list_x2354_r_0(0)
  val x2385_reg = list_x2354_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2423_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2423_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2423_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2423_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x2423_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x2423_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x2423_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2423_instrctr, cycles_x2423_inr_SwitchCase.io.count, iters_x2423_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x2425, x2498, x2707, x2859, x444)
      val x2412_rd_x2385 = Wire(Bool()).suggestName("""x2412_rd_x2385""")
      val x2412_rd_x2385_banks = List[UInt]()
      val x2412_rd_x2385_ofs = List[UInt]()
      val x2412_rd_x2385_en = List[Bool](true.B)
      val x2412_rd_x2385_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2412_rd_x2385_shared_en")
      x2412_rd_x2385.toSeq.zip(x2385_reg.connectRPort(2412, x2412_rd_x2385_banks, x2412_rd_x2385_ofs, io.sigsIn.backpressure, x2412_rd_x2385_en.map(_ && x2412_rd_x2385_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2413_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2413_rd""")
      val x2413_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2413_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2413_rd_en = List[Bool](true.B)
      val x2413_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x2412_rd_x2385 ).suggestName("x2413_rd_shared_en")
      x2413_rd.toSeq.zip(x2354_r_0.connectRPort(2413, x2413_rd_banks, x2413_rd_ofs, io.sigsIn.backpressure, x2413_rd_en.map(_ && x2413_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2414 = VecApply(x2413,0)
      val x2414_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2414_elem_0""")
      x2414_elem_0.r := x2413_rd(0).r
      val x2415_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2415_div""")
      x2415_div.r := (Math.div(100.FP(true, 10, 22), x2414_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2415_div")).r
      val x3659 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3659_x2414_elem_0_D20") 
      x3659.r := getRetimed(x2414_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2416_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2416_div""")
      x2416_div.r := (Math.div(x2415_div, x3659, Some(20.0), true.B, Truncate, Wrapping, "x2416_div")).r
      val x3660 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3660_x2414_elem_0_D40") 
      x3660.r := getRetimed(x2414_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x2417_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2417_div""")
      x2417_div.r := (Math.div(x2416_div, x3660, Some(20.0), true.B, Truncate, Wrapping, "x2417_div")).r
      val x3661 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3661_x2414_elem_0_D60") 
      x3661.r := getRetimed(x2414_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2418_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2418_div""")
      x2418_div.r := (Math.div(x2417_div, x3661, Some(20.0), true.B, Truncate, Wrapping, "x2418_div")).r
      val x3662 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3662_x2414_elem_0_D80") 
      x3662.r := getRetimed(x2414_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x2419_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2419_div""")
      x2419_div.r := (Math.div(x2418_div, x3662, Some(20.0), true.B, Truncate, Wrapping, "x2419_div")).r
      val x2420_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2420_div""")
      x2420_div.r := (Math.div(10.FP(true, 10, 22), x2414_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2420_div")).r
      val x2421_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2421_div""")
      x2421_div.r := (Math.div(x2420_div, x3659, Some(20.0), true.B, Truncate, Wrapping, "x2421_div")).r
      val x3663 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3663_x2421_div_D60") 
      x3663.r := getRetimed(x2421_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2422_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2422_sub""")
      x2422_sub.r := Math.sub(x2419_div,x3663,Some(1.0), true.B, Truncate, Wrapping, "x2422_sub").r
      io.ret.r := x2422_sub.r
    }
    val module = Module(new x2423_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectInstrCtrs(instrctrs, module.io.in_instrctrs)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    val ret = module.io.ret
    Ledger.exit()
    ret
  }
}
/** END SwitchCase x2423_inr_SwitchCase **/
