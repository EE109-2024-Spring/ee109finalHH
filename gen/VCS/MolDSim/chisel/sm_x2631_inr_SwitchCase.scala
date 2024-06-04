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

/** Hierarchy: x2631 -> x2633 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2631_inr_SwitchCase **/
class x2631_inr_SwitchCase_kernel(
  list_x2562_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x2631_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2631_inr_SwitchCase_iiCtr"))
  
  abstract class x2631_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2562_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2562_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2593_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2593_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2562_r_0 = {io.in_x2562_r_0} ; io.in_x2562_r_0 := DontCare
    def x2593_reg = {io.in_x2593_reg} ; io.in_x2593_reg := DontCare
  }
  def connectWires0(module: x2631_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x2562_r_0.connectLedger(module.io.in_x2562_r_0)
    x2593_reg.connectLedger(module.io.in_x2593_reg)
  }
  val x2562_r_0 = list_x2562_r_0(0)
  val x2593_reg = list_x2562_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2631_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2631_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2631_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2631_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x2631_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x2631_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x2631_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2631_instrctr, cycles_x2631_inr_SwitchCase.io.count, iters_x2631_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x2633, x2706, x2707, x2859, x444)
      val x2620_rd_x2593 = Wire(Bool()).suggestName("""x2620_rd_x2593""")
      val x2620_rd_x2593_banks = List[UInt]()
      val x2620_rd_x2593_ofs = List[UInt]()
      val x2620_rd_x2593_en = List[Bool](true.B)
      val x2620_rd_x2593_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2620_rd_x2593_shared_en")
      x2620_rd_x2593.toSeq.zip(x2593_reg.connectRPort(2620, x2620_rd_x2593_banks, x2620_rd_x2593_ofs, io.sigsIn.backpressure, x2620_rd_x2593_en.map(_ && x2620_rd_x2593_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2621_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2621_rd""")
      val x2621_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2621_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2621_rd_en = List[Bool](true.B)
      val x2621_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x2620_rd_x2593 ).suggestName("x2621_rd_shared_en")
      x2621_rd.toSeq.zip(x2562_r_0.connectRPort(2621, x2621_rd_banks, x2621_rd_ofs, io.sigsIn.backpressure, x2621_rd_en.map(_ && x2621_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2622 = VecApply(x2621,0)
      val x2622_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2622_elem_0""")
      x2622_elem_0.r := x2621_rd(0).r
      val x2623_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2623_div""")
      x2623_div.r := (Math.div(100.FP(true, 10, 22), x2622_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2623_div")).r
      val x3720 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3720_x2622_elem_0_D20") 
      x3720.r := getRetimed(x2622_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2624_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2624_div""")
      x2624_div.r := (Math.div(x2623_div, x3720, Some(20.0), true.B, Truncate, Wrapping, "x2624_div")).r
      val x3721 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3721_x2622_elem_0_D40") 
      x3721.r := getRetimed(x2622_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x2625_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2625_div""")
      x2625_div.r := (Math.div(x2624_div, x3721, Some(20.0), true.B, Truncate, Wrapping, "x2625_div")).r
      val x3722 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3722_x2622_elem_0_D60") 
      x3722.r := getRetimed(x2622_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2626_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2626_div""")
      x2626_div.r := (Math.div(x2625_div, x3722, Some(20.0), true.B, Truncate, Wrapping, "x2626_div")).r
      val x3723 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3723_x2622_elem_0_D80") 
      x3723.r := getRetimed(x2622_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x2627_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2627_div""")
      x2627_div.r := (Math.div(x2626_div, x3723, Some(20.0), true.B, Truncate, Wrapping, "x2627_div")).r
      val x2628_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2628_div""")
      x2628_div.r := (Math.div(10.FP(true, 10, 22), x2622_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2628_div")).r
      val x2629_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2629_div""")
      x2629_div.r := (Math.div(x2628_div, x3720, Some(20.0), true.B, Truncate, Wrapping, "x2629_div")).r
      val x3724 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3724_x2629_div_D60") 
      x3724.r := getRetimed(x2629_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2630_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2630_sub""")
      x2630_sub.r := Math.sub(x2627_div,x3724,Some(1.0), true.B, Truncate, Wrapping, "x2630_sub").r
      io.ret.r := x2630_sub.r
    }
    val module = Module(new x2631_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x2631_inr_SwitchCase **/
