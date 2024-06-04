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

/** Hierarchy: x1813 -> x1815 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1813_inr_SwitchCase **/
class x1813_inr_SwitchCase_kernel(
  list_x1762_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x1813_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1813_inr_SwitchCase_iiCtr"))
  
  abstract class x1813_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1762_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1762_reg_p").asInstanceOf[NBufParams] ))
      val in_x1731_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1731_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1762_reg = {io.in_x1762_reg} ; io.in_x1762_reg := DontCare
    def x1731_r_0 = {io.in_x1731_r_0} ; io.in_x1731_r_0 := DontCare
  }
  def connectWires0(module: x1813_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1762_reg.connectLedger(module.io.in_x1762_reg)
    x1731_r_0.connectLedger(module.io.in_x1731_r_0)
  }
  val x1762_reg = list_x1762_reg(0)
  val x1731_r_0 = list_x1762_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1813_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1813_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1813_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1813_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x1813_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x1813_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x1813_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1813_instrctr, cycles_x1813_inr_SwitchCase.io.count, iters_x1813_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x1815, x1874, x2707, x2859, x444)
      val x1802_rd_x1762 = Wire(Bool()).suggestName("""x1802_rd_x1762""")
      val x1802_rd_x1762_banks = List[UInt]()
      val x1802_rd_x1762_ofs = List[UInt]()
      val x1802_rd_x1762_en = List[Bool](true.B)
      val x1802_rd_x1762_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1802_rd_x1762_shared_en")
      x1802_rd_x1762.toSeq.zip(x1762_reg.connectRPort(1802, x1802_rd_x1762_banks, x1802_rd_x1762_ofs, io.sigsIn.backpressure, x1802_rd_x1762_en.map(_ && x1802_rd_x1762_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1803_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1803_rd""")
      val x1803_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1803_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1803_rd_en = List[Bool](true.B)
      val x1803_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x1802_rd_x1762 ).suggestName("x1803_rd_shared_en")
      x1803_rd.toSeq.zip(x1731_r_0.connectRPort(1803, x1803_rd_banks, x1803_rd_ofs, io.sigsIn.backpressure, x1803_rd_en.map(_ && x1803_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1804 = VecApply(x1803,0)
      val x1804_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1804_elem_0""")
      x1804_elem_0.r := x1803_rd(0).r
      val x1805_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1805_div""")
      x1805_div.r := (Math.div(100.FP(true, 10, 22), x1804_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1805_div")).r
      val x3481 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3481_x1804_elem_0_D20") 
      x3481.r := getRetimed(x1804_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1806_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1806_div""")
      x1806_div.r := (Math.div(x1805_div, x3481, Some(20.0), true.B, Truncate, Wrapping, "x1806_div")).r
      val x3482 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3482_x1804_elem_0_D40") 
      x3482.r := getRetimed(x1804_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x1807_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1807_div""")
      x1807_div.r := (Math.div(x1806_div, x3482, Some(20.0), true.B, Truncate, Wrapping, "x1807_div")).r
      val x3483 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3483_x1804_elem_0_D60") 
      x3483.r := getRetimed(x1804_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1808_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1808_div""")
      x1808_div.r := (Math.div(x1807_div, x3483, Some(20.0), true.B, Truncate, Wrapping, "x1808_div")).r
      val x3484 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3484_x1804_elem_0_D80") 
      x3484.r := getRetimed(x1804_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x1809_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1809_div""")
      x1809_div.r := (Math.div(x1808_div, x3484, Some(20.0), true.B, Truncate, Wrapping, "x1809_div")).r
      val x1810_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1810_div""")
      x1810_div.r := (Math.div(10.FP(true, 10, 22), x1804_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1810_div")).r
      val x1811_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1811_div""")
      x1811_div.r := (Math.div(x1810_div, x3481, Some(20.0), true.B, Truncate, Wrapping, "x1811_div")).r
      val x3485 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3485_x1811_div_D60") 
      x3485.r := getRetimed(x1811_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1812_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1812_sub""")
      x1812_sub.r := Math.sub(x1809_div,x3485,Some(1.0), true.B, Truncate, Wrapping, "x1812_sub").r
      io.ret.r := x1812_sub.r
    }
    val module = Module(new x1813_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x1813_inr_SwitchCase **/
