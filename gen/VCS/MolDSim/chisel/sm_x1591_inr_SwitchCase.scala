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

/** Hierarchy: x1591 -> x1593 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1591_inr_SwitchCase **/
class x1591_inr_SwitchCase_kernel(
  list_x1522_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x1591_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1591_inr_SwitchCase_iiCtr"))
  
  abstract class x1591_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1522_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1522_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1553_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1553_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1522_r_0 = {io.in_x1522_r_0} ; io.in_x1522_r_0 := DontCare
    def x1553_reg = {io.in_x1553_reg} ; io.in_x1553_reg := DontCare
  }
  def connectWires0(module: x1591_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1522_r_0.connectLedger(module.io.in_x1522_r_0)
    x1553_reg.connectLedger(module.io.in_x1553_reg)
  }
  val x1522_r_0 = list_x1522_r_0(0)
  val x1553_reg = list_x1522_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1591_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1591_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1591_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1591_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x1591_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x1591_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x1591_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1591_instrctr, cycles_x1591_inr_SwitchCase.io.count, iters_x1591_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x1593, x1666, x2707, x2859, x444)
      val x1580_rd_x1553 = Wire(Bool()).suggestName("""x1580_rd_x1553""")
      val x1580_rd_x1553_banks = List[UInt]()
      val x1580_rd_x1553_ofs = List[UInt]()
      val x1580_rd_x1553_en = List[Bool](true.B)
      val x1580_rd_x1553_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1580_rd_x1553_shared_en")
      x1580_rd_x1553.toSeq.zip(x1553_reg.connectRPort(1580, x1580_rd_x1553_banks, x1580_rd_x1553_ofs, io.sigsIn.backpressure, x1580_rd_x1553_en.map(_ && x1580_rd_x1553_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1581_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1581_rd""")
      val x1581_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1581_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1581_rd_en = List[Bool](true.B)
      val x1581_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x1580_rd_x1553 ).suggestName("x1581_rd_shared_en")
      x1581_rd.toSeq.zip(x1522_r_0.connectRPort(1581, x1581_rd_banks, x1581_rd_ofs, io.sigsIn.backpressure, x1581_rd_en.map(_ && x1581_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1582 = VecApply(x1581,0)
      val x1582_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1582_elem_0""")
      x1582_elem_0.r := x1581_rd(0).r
      val x1583_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1583_div""")
      x1583_div.r := (Math.div(100.FP(true, 10, 22), x1582_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1583_div")).r
      val x3415 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3415_x1582_elem_0_D20") 
      x3415.r := getRetimed(x1582_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1584_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1584_div""")
      x1584_div.r := (Math.div(x1583_div, x3415, Some(20.0), true.B, Truncate, Wrapping, "x1584_div")).r
      val x3416 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3416_x1582_elem_0_D40") 
      x3416.r := getRetimed(x1582_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x1585_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1585_div""")
      x1585_div.r := (Math.div(x1584_div, x3416, Some(20.0), true.B, Truncate, Wrapping, "x1585_div")).r
      val x3417 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3417_x1582_elem_0_D60") 
      x3417.r := getRetimed(x1582_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1586_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1586_div""")
      x1586_div.r := (Math.div(x1585_div, x3417, Some(20.0), true.B, Truncate, Wrapping, "x1586_div")).r
      val x3418 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3418_x1582_elem_0_D80") 
      x3418.r := getRetimed(x1582_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x1587_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1587_div""")
      x1587_div.r := (Math.div(x1586_div, x3418, Some(20.0), true.B, Truncate, Wrapping, "x1587_div")).r
      val x1588_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1588_div""")
      x1588_div.r := (Math.div(10.FP(true, 10, 22), x1582_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1588_div")).r
      val x1589_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1589_div""")
      x1589_div.r := (Math.div(x1588_div, x3415, Some(20.0), true.B, Truncate, Wrapping, "x1589_div")).r
      val x3419 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3419_x1589_div_D60") 
      x3419.r := getRetimed(x1589_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1590_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1590_sub""")
      x1590_sub.r := Math.sub(x1587_div,x3419,Some(1.0), true.B, Truncate, Wrapping, "x1590_sub").r
      io.ret.r := x1590_sub.r
    }
    val module = Module(new x1591_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x1591_inr_SwitchCase **/
