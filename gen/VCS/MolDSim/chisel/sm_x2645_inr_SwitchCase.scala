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

/** Hierarchy: x2645 -> x2647 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2645_inr_SwitchCase **/
class x2645_inr_SwitchCase_kernel(
  list_x2594_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x2645_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2645_inr_SwitchCase_iiCtr"))
  
  abstract class x2645_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2594_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2594_reg_p").asInstanceOf[NBufParams] ))
      val in_x2563_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2563_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2594_reg = {io.in_x2594_reg} ; io.in_x2594_reg := DontCare
    def x2563_r_0 = {io.in_x2563_r_0} ; io.in_x2563_r_0 := DontCare
  }
  def connectWires0(module: x2645_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x2594_reg.connectLedger(module.io.in_x2594_reg)
    x2563_r_0.connectLedger(module.io.in_x2563_r_0)
  }
  val x2594_reg = list_x2594_reg(0)
  val x2563_r_0 = list_x2594_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2645_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2645_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2645_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2645_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x2645_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x2645_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x2645_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2645_instrctr, cycles_x2645_inr_SwitchCase.io.count, iters_x2645_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x2647, x2706, x2707, x2859, x444)
      val x2634_rd_x2594 = Wire(Bool()).suggestName("""x2634_rd_x2594""")
      val x2634_rd_x2594_banks = List[UInt]()
      val x2634_rd_x2594_ofs = List[UInt]()
      val x2634_rd_x2594_en = List[Bool](true.B)
      val x2634_rd_x2594_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2634_rd_x2594_shared_en")
      x2634_rd_x2594.toSeq.zip(x2594_reg.connectRPort(2634, x2634_rd_x2594_banks, x2634_rd_x2594_ofs, io.sigsIn.backpressure, x2634_rd_x2594_en.map(_ && x2634_rd_x2594_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2635_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2635_rd""")
      val x2635_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2635_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2635_rd_en = List[Bool](true.B)
      val x2635_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x2634_rd_x2594 ).suggestName("x2635_rd_shared_en")
      x2635_rd.toSeq.zip(x2563_r_0.connectRPort(2635, x2635_rd_banks, x2635_rd_ofs, io.sigsIn.backpressure, x2635_rd_en.map(_ && x2635_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2636 = VecApply(x2635,0)
      val x2636_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2636_elem_0""")
      x2636_elem_0.r := x2635_rd(0).r
      val x2637_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2637_div""")
      x2637_div.r := (Math.div(100.FP(true, 10, 22), x2636_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2637_div")).r
      val x3725 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3725_x2636_elem_0_D20") 
      x3725.r := getRetimed(x2636_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2638_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2638_div""")
      x2638_div.r := (Math.div(x2637_div, x3725, Some(20.0), true.B, Truncate, Wrapping, "x2638_div")).r
      val x3726 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3726_x2636_elem_0_D40") 
      x3726.r := getRetimed(x2636_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x2639_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2639_div""")
      x2639_div.r := (Math.div(x2638_div, x3726, Some(20.0), true.B, Truncate, Wrapping, "x2639_div")).r
      val x3727 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3727_x2636_elem_0_D60") 
      x3727.r := getRetimed(x2636_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2640_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2640_div""")
      x2640_div.r := (Math.div(x2639_div, x3727, Some(20.0), true.B, Truncate, Wrapping, "x2640_div")).r
      val x3728 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3728_x2636_elem_0_D80") 
      x3728.r := getRetimed(x2636_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x2641_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2641_div""")
      x2641_div.r := (Math.div(x2640_div, x3728, Some(20.0), true.B, Truncate, Wrapping, "x2641_div")).r
      val x2642_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2642_div""")
      x2642_div.r := (Math.div(10.FP(true, 10, 22), x2636_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2642_div")).r
      val x2643_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2643_div""")
      x2643_div.r := (Math.div(x2642_div, x3725, Some(20.0), true.B, Truncate, Wrapping, "x2643_div")).r
      val x3729 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3729_x2643_div_D60") 
      x3729.r := getRetimed(x2643_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2644_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2644_sub""")
      x2644_sub.r := Math.sub(x2641_div,x3729,Some(1.0), true.B, Truncate, Wrapping, "x2644_sub").r
      io.ret.r := x2644_sub.r
    }
    val module = Module(new x2645_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x2645_inr_SwitchCase **/
