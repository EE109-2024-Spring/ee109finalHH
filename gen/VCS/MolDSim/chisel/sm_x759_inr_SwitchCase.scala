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

/** Hierarchy: x759 -> x761 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x759_inr_SwitchCase **/
class x759_inr_SwitchCase_kernel(
  list_x721_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x759_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x759_inr_SwitchCase_iiCtr"))
  
  abstract class x759_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x721_reg = Flipped(new NBufInterface(ModuleParams.getParams("x721_reg_p").asInstanceOf[NBufParams] ))
      val in_x690_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x690_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x721_reg = {io.in_x721_reg} ; io.in_x721_reg := DontCare
    def x690_r_0 = {io.in_x690_r_0} ; io.in_x690_r_0 := DontCare
  }
  def connectWires0(module: x759_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x721_reg.connectLedger(module.io.in_x721_reg)
    x690_r_0.connectLedger(module.io.in_x690_r_0)
  }
  val x721_reg = list_x721_reg(0)
  val x690_r_0 = list_x721_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x759_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x759_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x759_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x759_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x759_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x759_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x759_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X759_instrctr, cycles_x759_inr_SwitchCase.io.count, iters_x759_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x761, x834, x2707, x2859, x444)
      val x748_rd_x721 = Wire(Bool()).suggestName("""x748_rd_x721""")
      val x748_rd_x721_banks = List[UInt]()
      val x748_rd_x721_ofs = List[UInt]()
      val x748_rd_x721_en = List[Bool](true.B)
      val x748_rd_x721_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x748_rd_x721_shared_en")
      x748_rd_x721.toSeq.zip(x721_reg.connectRPort(748, x748_rd_x721_banks, x748_rd_x721_ofs, io.sigsIn.backpressure, x748_rd_x721_en.map(_ && x748_rd_x721_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x749_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x749_rd""")
      val x749_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x749_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x749_rd_en = List[Bool](true.B)
      val x749_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x748_rd_x721 ).suggestName("x749_rd_shared_en")
      x749_rd.toSeq.zip(x690_r_0.connectRPort(749, x749_rd_banks, x749_rd_ofs, io.sigsIn.backpressure, x749_rd_en.map(_ && x749_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x750 = VecApply(x749,0)
      val x750_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x750_elem_0""")
      x750_elem_0.r := x749_rd(0).r
      val x751_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x751_div""")
      x751_div.r := (Math.div(100.FP(true, 10, 22), x750_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x751_div")).r
      val x3171 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3171_x750_elem_0_D20") 
      x3171.r := getRetimed(x750_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x752_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x752_div""")
      x752_div.r := (Math.div(x751_div, x3171, Some(20.0), true.B, Truncate, Wrapping, "x752_div")).r
      val x3172 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3172_x750_elem_0_D40") 
      x3172.r := getRetimed(x750_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x753_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x753_div""")
      x753_div.r := (Math.div(x752_div, x3172, Some(20.0), true.B, Truncate, Wrapping, "x753_div")).r
      val x3173 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3173_x750_elem_0_D60") 
      x3173.r := getRetimed(x750_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x754_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x754_div""")
      x754_div.r := (Math.div(x753_div, x3173, Some(20.0), true.B, Truncate, Wrapping, "x754_div")).r
      val x3174 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3174_x750_elem_0_D80") 
      x3174.r := getRetimed(x750_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x755_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x755_div""")
      x755_div.r := (Math.div(x754_div, x3174, Some(20.0), true.B, Truncate, Wrapping, "x755_div")).r
      val x756_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x756_div""")
      x756_div.r := (Math.div(10.FP(true, 10, 22), x750_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x756_div")).r
      val x757_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x757_div""")
      x757_div.r := (Math.div(x756_div, x3171, Some(20.0), true.B, Truncate, Wrapping, "x757_div")).r
      val x3175 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3175_x757_div_D60") 
      x3175.r := getRetimed(x757_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x758_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x758_sub""")
      x758_sub.r := Math.sub(x755_div,x3175,Some(1.0), true.B, Truncate, Wrapping, "x758_sub").r
      io.ret.r := x758_sub.r
    }
    val module = Module(new x759_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x759_inr_SwitchCase **/
