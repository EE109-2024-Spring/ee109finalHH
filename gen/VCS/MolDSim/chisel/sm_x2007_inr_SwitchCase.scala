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

/** Hierarchy: x2007 -> x2009 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2007_inr_SwitchCase **/
class x2007_inr_SwitchCase_kernel(
  list_x1938_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x2007_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2007_inr_SwitchCase_iiCtr"))
  
  abstract class x2007_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1938_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1938_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1969_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1969_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1938_r_0 = {io.in_x1938_r_0} ; io.in_x1938_r_0 := DontCare
    def x1969_reg = {io.in_x1969_reg} ; io.in_x1969_reg := DontCare
  }
  def connectWires0(module: x2007_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1938_r_0.connectLedger(module.io.in_x1938_r_0)
    x1969_reg.connectLedger(module.io.in_x1969_reg)
  }
  val x1938_r_0 = list_x1938_r_0(0)
  val x1969_reg = list_x1938_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2007_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2007_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2007_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2007_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x2007_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x2007_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x2007_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2007_instrctr, cycles_x2007_inr_SwitchCase.io.count, iters_x2007_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x2009, x2082, x2707, x2859, x444)
      val x1996_rd_x1969 = Wire(Bool()).suggestName("""x1996_rd_x1969""")
      val x1996_rd_x1969_banks = List[UInt]()
      val x1996_rd_x1969_ofs = List[UInt]()
      val x1996_rd_x1969_en = List[Bool](true.B)
      val x1996_rd_x1969_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1996_rd_x1969_shared_en")
      x1996_rd_x1969.toSeq.zip(x1969_reg.connectRPort(1996, x1996_rd_x1969_banks, x1996_rd_x1969_ofs, io.sigsIn.backpressure, x1996_rd_x1969_en.map(_ && x1996_rd_x1969_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1997_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1997_rd""")
      val x1997_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1997_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1997_rd_en = List[Bool](true.B)
      val x1997_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x1996_rd_x1969 ).suggestName("x1997_rd_shared_en")
      x1997_rd.toSeq.zip(x1938_r_0.connectRPort(1997, x1997_rd_banks, x1997_rd_ofs, io.sigsIn.backpressure, x1997_rd_en.map(_ && x1997_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1998 = VecApply(x1997,0)
      val x1998_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1998_elem_0""")
      x1998_elem_0.r := x1997_rd(0).r
      val x1999_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1999_div""")
      x1999_div.r := (Math.div(100.FP(true, 10, 22), x1998_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1999_div")).r
      val x3537 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3537_x1998_elem_0_D20") 
      x3537.r := getRetimed(x1998_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2000_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2000_div""")
      x2000_div.r := (Math.div(x1999_div, x3537, Some(20.0), true.B, Truncate, Wrapping, "x2000_div")).r
      val x3538 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3538_x1998_elem_0_D40") 
      x3538.r := getRetimed(x1998_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x2001_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2001_div""")
      x2001_div.r := (Math.div(x2000_div, x3538, Some(20.0), true.B, Truncate, Wrapping, "x2001_div")).r
      val x3539 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3539_x1998_elem_0_D60") 
      x3539.r := getRetimed(x1998_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2002_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2002_div""")
      x2002_div.r := (Math.div(x2001_div, x3539, Some(20.0), true.B, Truncate, Wrapping, "x2002_div")).r
      val x3540 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3540_x1998_elem_0_D80") 
      x3540.r := getRetimed(x1998_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x2003_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2003_div""")
      x2003_div.r := (Math.div(x2002_div, x3540, Some(20.0), true.B, Truncate, Wrapping, "x2003_div")).r
      val x2004_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2004_div""")
      x2004_div.r := (Math.div(10.FP(true, 10, 22), x1998_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2004_div")).r
      val x2005_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2005_div""")
      x2005_div.r := (Math.div(x2004_div, x3537, Some(20.0), true.B, Truncate, Wrapping, "x2005_div")).r
      val x3541 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3541_x2005_div_D60") 
      x3541.r := getRetimed(x2005_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2006_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2006_sub""")
      x2006_sub.r := Math.sub(x2003_div,x3541,Some(1.0), true.B, Truncate, Wrapping, "x2006_sub").r
      io.ret.r := x2006_sub.r
    }
    val module = Module(new x2007_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x2007_inr_SwitchCase **/
