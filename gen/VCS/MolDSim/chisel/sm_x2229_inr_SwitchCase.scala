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

/** Hierarchy: x2229 -> x2231 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2229_inr_SwitchCase **/
class x2229_inr_SwitchCase_kernel(
  list_x2178_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x2229_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2229_inr_SwitchCase_iiCtr"))
  
  abstract class x2229_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2178_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2178_reg_p").asInstanceOf[NBufParams] ))
      val in_x2147_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2147_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2178_reg = {io.in_x2178_reg} ; io.in_x2178_reg := DontCare
    def x2147_r_0 = {io.in_x2147_r_0} ; io.in_x2147_r_0 := DontCare
  }
  def connectWires0(module: x2229_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x2178_reg.connectLedger(module.io.in_x2178_reg)
    x2147_r_0.connectLedger(module.io.in_x2147_r_0)
  }
  val x2178_reg = list_x2178_reg(0)
  val x2147_r_0 = list_x2178_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2229_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2229_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2229_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2229_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x2229_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x2229_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x2229_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2229_instrctr, cycles_x2229_inr_SwitchCase.io.count, iters_x2229_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x2231, x2290, x2707, x2859, x444)
      val x2218_rd_x2178 = Wire(Bool()).suggestName("""x2218_rd_x2178""")
      val x2218_rd_x2178_banks = List[UInt]()
      val x2218_rd_x2178_ofs = List[UInt]()
      val x2218_rd_x2178_en = List[Bool](true.B)
      val x2218_rd_x2178_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2218_rd_x2178_shared_en")
      x2218_rd_x2178.toSeq.zip(x2178_reg.connectRPort(2218, x2218_rd_x2178_banks, x2218_rd_x2178_ofs, io.sigsIn.backpressure, x2218_rd_x2178_en.map(_ && x2218_rd_x2178_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2219_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2219_rd""")
      val x2219_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2219_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2219_rd_en = List[Bool](true.B)
      val x2219_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x2218_rd_x2178 ).suggestName("x2219_rd_shared_en")
      x2219_rd.toSeq.zip(x2147_r_0.connectRPort(2219, x2219_rd_banks, x2219_rd_ofs, io.sigsIn.backpressure, x2219_rd_en.map(_ && x2219_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2220 = VecApply(x2219,0)
      val x2220_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2220_elem_0""")
      x2220_elem_0.r := x2219_rd(0).r
      val x2221_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2221_div""")
      x2221_div.r := (Math.div(100.FP(true, 10, 22), x2220_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2221_div")).r
      val x3603 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3603_x2220_elem_0_D20") 
      x3603.r := getRetimed(x2220_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2222_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2222_div""")
      x2222_div.r := (Math.div(x2221_div, x3603, Some(20.0), true.B, Truncate, Wrapping, "x2222_div")).r
      val x3604 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3604_x2220_elem_0_D40") 
      x3604.r := getRetimed(x2220_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x2223_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2223_div""")
      x2223_div.r := (Math.div(x2222_div, x3604, Some(20.0), true.B, Truncate, Wrapping, "x2223_div")).r
      val x3605 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3605_x2220_elem_0_D60") 
      x3605.r := getRetimed(x2220_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2224_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2224_div""")
      x2224_div.r := (Math.div(x2223_div, x3605, Some(20.0), true.B, Truncate, Wrapping, "x2224_div")).r
      val x3606 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3606_x2220_elem_0_D80") 
      x3606.r := getRetimed(x2220_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x2225_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2225_div""")
      x2225_div.r := (Math.div(x2224_div, x3606, Some(20.0), true.B, Truncate, Wrapping, "x2225_div")).r
      val x2226_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2226_div""")
      x2226_div.r := (Math.div(10.FP(true, 10, 22), x2220_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2226_div")).r
      val x2227_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2227_div""")
      x2227_div.r := (Math.div(x2226_div, x3603, Some(20.0), true.B, Truncate, Wrapping, "x2227_div")).r
      val x3607 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3607_x2227_div_D60") 
      x3607.r := getRetimed(x2227_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2228_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2228_sub""")
      x2228_sub.r := Math.sub(x2225_div,x3607,Some(1.0), true.B, Truncate, Wrapping, "x2228_sub").r
      io.ret.r := x2228_sub.r
    }
    val module = Module(new x2229_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x2229_inr_SwitchCase **/
