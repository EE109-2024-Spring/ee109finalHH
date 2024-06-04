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

/** Hierarchy: x1605 -> x1607 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1605_inr_SwitchCase **/
class x1605_inr_SwitchCase_kernel(
  list_x1554_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x1605_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1605_inr_SwitchCase_iiCtr"))
  
  abstract class x1605_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1554_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1554_reg_p").asInstanceOf[NBufParams] ))
      val in_x1523_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1523_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1554_reg = {io.in_x1554_reg} ; io.in_x1554_reg := DontCare
    def x1523_r_0 = {io.in_x1523_r_0} ; io.in_x1523_r_0 := DontCare
  }
  def connectWires0(module: x1605_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1554_reg.connectLedger(module.io.in_x1554_reg)
    x1523_r_0.connectLedger(module.io.in_x1523_r_0)
  }
  val x1554_reg = list_x1554_reg(0)
  val x1523_r_0 = list_x1554_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1605_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1605_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1605_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1605_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x1605_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x1605_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x1605_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1605_instrctr, cycles_x1605_inr_SwitchCase.io.count, iters_x1605_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x1607, x1666, x2707, x2859, x444)
      val x1594_rd_x1554 = Wire(Bool()).suggestName("""x1594_rd_x1554""")
      val x1594_rd_x1554_banks = List[UInt]()
      val x1594_rd_x1554_ofs = List[UInt]()
      val x1594_rd_x1554_en = List[Bool](true.B)
      val x1594_rd_x1554_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1594_rd_x1554_shared_en")
      x1594_rd_x1554.toSeq.zip(x1554_reg.connectRPort(1594, x1594_rd_x1554_banks, x1594_rd_x1554_ofs, io.sigsIn.backpressure, x1594_rd_x1554_en.map(_ && x1594_rd_x1554_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1595_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1595_rd""")
      val x1595_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1595_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1595_rd_en = List[Bool](true.B)
      val x1595_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x1594_rd_x1554 ).suggestName("x1595_rd_shared_en")
      x1595_rd.toSeq.zip(x1523_r_0.connectRPort(1595, x1595_rd_banks, x1595_rd_ofs, io.sigsIn.backpressure, x1595_rd_en.map(_ && x1595_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1596 = VecApply(x1595,0)
      val x1596_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1596_elem_0""")
      x1596_elem_0.r := x1595_rd(0).r
      val x1597_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1597_div""")
      x1597_div.r := (Math.div(100.FP(true, 10, 22), x1596_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1597_div")).r
      val x3420 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3420_x1596_elem_0_D20") 
      x3420.r := getRetimed(x1596_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1598_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1598_div""")
      x1598_div.r := (Math.div(x1597_div, x3420, Some(20.0), true.B, Truncate, Wrapping, "x1598_div")).r
      val x3421 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3421_x1596_elem_0_D40") 
      x3421.r := getRetimed(x1596_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x1599_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1599_div""")
      x1599_div.r := (Math.div(x1598_div, x3421, Some(20.0), true.B, Truncate, Wrapping, "x1599_div")).r
      val x3422 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3422_x1596_elem_0_D60") 
      x3422.r := getRetimed(x1596_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1600_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1600_div""")
      x1600_div.r := (Math.div(x1599_div, x3422, Some(20.0), true.B, Truncate, Wrapping, "x1600_div")).r
      val x3423 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3423_x1596_elem_0_D80") 
      x3423.r := getRetimed(x1596_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x1601_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1601_div""")
      x1601_div.r := (Math.div(x1600_div, x3423, Some(20.0), true.B, Truncate, Wrapping, "x1601_div")).r
      val x1602_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1602_div""")
      x1602_div.r := (Math.div(10.FP(true, 10, 22), x1596_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1602_div")).r
      val x1603_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1603_div""")
      x1603_div.r := (Math.div(x1602_div, x3420, Some(20.0), true.B, Truncate, Wrapping, "x1603_div")).r
      val x3424 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3424_x1603_div_D60") 
      x3424.r := getRetimed(x1603_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1604_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1604_sub""")
      x1604_sub.r := Math.sub(x1601_div,x3424,Some(1.0), true.B, Truncate, Wrapping, "x1604_sub").r
      io.ret.r := x1604_sub.r
    }
    val module = Module(new x1605_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x1605_inr_SwitchCase **/
