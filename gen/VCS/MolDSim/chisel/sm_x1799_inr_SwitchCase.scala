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

/** Hierarchy: x1799 -> x1801 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1799_inr_SwitchCase **/
class x1799_inr_SwitchCase_kernel(
  list_x1761_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x1799_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1799_inr_SwitchCase_iiCtr"))
  
  abstract class x1799_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1761_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1761_reg_p").asInstanceOf[NBufParams] ))
      val in_x1730_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1730_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1761_reg = {io.in_x1761_reg} ; io.in_x1761_reg := DontCare
    def x1730_r_0 = {io.in_x1730_r_0} ; io.in_x1730_r_0 := DontCare
  }
  def connectWires0(module: x1799_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1761_reg.connectLedger(module.io.in_x1761_reg)
    x1730_r_0.connectLedger(module.io.in_x1730_r_0)
  }
  val x1761_reg = list_x1761_reg(0)
  val x1730_r_0 = list_x1761_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1799_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1799_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1799_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1799_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x1799_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x1799_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x1799_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1799_instrctr, cycles_x1799_inr_SwitchCase.io.count, iters_x1799_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x1801, x1874, x2707, x2859, x444)
      val x1788_rd_x1761 = Wire(Bool()).suggestName("""x1788_rd_x1761""")
      val x1788_rd_x1761_banks = List[UInt]()
      val x1788_rd_x1761_ofs = List[UInt]()
      val x1788_rd_x1761_en = List[Bool](true.B)
      val x1788_rd_x1761_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1788_rd_x1761_shared_en")
      x1788_rd_x1761.toSeq.zip(x1761_reg.connectRPort(1788, x1788_rd_x1761_banks, x1788_rd_x1761_ofs, io.sigsIn.backpressure, x1788_rd_x1761_en.map(_ && x1788_rd_x1761_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1789_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1789_rd""")
      val x1789_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1789_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1789_rd_en = List[Bool](true.B)
      val x1789_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x1788_rd_x1761 ).suggestName("x1789_rd_shared_en")
      x1789_rd.toSeq.zip(x1730_r_0.connectRPort(1789, x1789_rd_banks, x1789_rd_ofs, io.sigsIn.backpressure, x1789_rd_en.map(_ && x1789_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1790 = VecApply(x1789,0)
      val x1790_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1790_elem_0""")
      x1790_elem_0.r := x1789_rd(0).r
      val x1791_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1791_div""")
      x1791_div.r := (Math.div(100.FP(true, 10, 22), x1790_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1791_div")).r
      val x3476 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3476_x1790_elem_0_D20") 
      x3476.r := getRetimed(x1790_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1792_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1792_div""")
      x1792_div.r := (Math.div(x1791_div, x3476, Some(20.0), true.B, Truncate, Wrapping, "x1792_div")).r
      val x3477 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3477_x1790_elem_0_D40") 
      x3477.r := getRetimed(x1790_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x1793_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1793_div""")
      x1793_div.r := (Math.div(x1792_div, x3477, Some(20.0), true.B, Truncate, Wrapping, "x1793_div")).r
      val x3478 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3478_x1790_elem_0_D60") 
      x3478.r := getRetimed(x1790_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1794_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1794_div""")
      x1794_div.r := (Math.div(x1793_div, x3478, Some(20.0), true.B, Truncate, Wrapping, "x1794_div")).r
      val x3479 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3479_x1790_elem_0_D80") 
      x3479.r := getRetimed(x1790_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x1795_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1795_div""")
      x1795_div.r := (Math.div(x1794_div, x3479, Some(20.0), true.B, Truncate, Wrapping, "x1795_div")).r
      val x1796_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1796_div""")
      x1796_div.r := (Math.div(10.FP(true, 10, 22), x1790_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1796_div")).r
      val x1797_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1797_div""")
      x1797_div.r := (Math.div(x1796_div, x3476, Some(20.0), true.B, Truncate, Wrapping, "x1797_div")).r
      val x3480 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3480_x1797_div_D60") 
      x3480.r := getRetimed(x1797_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1798_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1798_sub""")
      x1798_sub.r := Math.sub(x1795_div,x3480,Some(1.0), true.B, Truncate, Wrapping, "x1798_sub").r
      io.ret.r := x1798_sub.r
    }
    val module = Module(new x1799_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x1799_inr_SwitchCase **/
