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

/** Hierarchy: x2021 -> x2023 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2021_inr_SwitchCase **/
class x2021_inr_SwitchCase_kernel(
  list_x1939_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x2021_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2021_inr_SwitchCase_iiCtr"))
  
  abstract class x2021_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1939_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1939_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1970_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1970_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1939_r_0 = {io.in_x1939_r_0} ; io.in_x1939_r_0 := DontCare
    def x1970_reg = {io.in_x1970_reg} ; io.in_x1970_reg := DontCare
  }
  def connectWires0(module: x2021_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1939_r_0.connectLedger(module.io.in_x1939_r_0)
    x1970_reg.connectLedger(module.io.in_x1970_reg)
  }
  val x1939_r_0 = list_x1939_r_0(0)
  val x1970_reg = list_x1939_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2021_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2021_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2021_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2021_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x2021_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x2021_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x2021_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2021_instrctr, cycles_x2021_inr_SwitchCase.io.count, iters_x2021_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x2023, x2082, x2707, x2859, x444)
      val x2010_rd_x1970 = Wire(Bool()).suggestName("""x2010_rd_x1970""")
      val x2010_rd_x1970_banks = List[UInt]()
      val x2010_rd_x1970_ofs = List[UInt]()
      val x2010_rd_x1970_en = List[Bool](true.B)
      val x2010_rd_x1970_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2010_rd_x1970_shared_en")
      x2010_rd_x1970.toSeq.zip(x1970_reg.connectRPort(2010, x2010_rd_x1970_banks, x2010_rd_x1970_ofs, io.sigsIn.backpressure, x2010_rd_x1970_en.map(_ && x2010_rd_x1970_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2011_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2011_rd""")
      val x2011_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2011_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2011_rd_en = List[Bool](true.B)
      val x2011_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x2010_rd_x1970 ).suggestName("x2011_rd_shared_en")
      x2011_rd.toSeq.zip(x1939_r_0.connectRPort(2011, x2011_rd_banks, x2011_rd_ofs, io.sigsIn.backpressure, x2011_rd_en.map(_ && x2011_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2012 = VecApply(x2011,0)
      val x2012_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2012_elem_0""")
      x2012_elem_0.r := x2011_rd(0).r
      val x2013_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2013_div""")
      x2013_div.r := (Math.div(100.FP(true, 10, 22), x2012_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2013_div")).r
      val x3542 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3542_x2012_elem_0_D20") 
      x3542.r := getRetimed(x2012_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2014_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2014_div""")
      x2014_div.r := (Math.div(x2013_div, x3542, Some(20.0), true.B, Truncate, Wrapping, "x2014_div")).r
      val x3543 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3543_x2012_elem_0_D40") 
      x3543.r := getRetimed(x2012_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x2015_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2015_div""")
      x2015_div.r := (Math.div(x2014_div, x3543, Some(20.0), true.B, Truncate, Wrapping, "x2015_div")).r
      val x3544 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3544_x2012_elem_0_D60") 
      x3544.r := getRetimed(x2012_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2016_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2016_div""")
      x2016_div.r := (Math.div(x2015_div, x3544, Some(20.0), true.B, Truncate, Wrapping, "x2016_div")).r
      val x3545 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3545_x2012_elem_0_D80") 
      x3545.r := getRetimed(x2012_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x2017_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2017_div""")
      x2017_div.r := (Math.div(x2016_div, x3545, Some(20.0), true.B, Truncate, Wrapping, "x2017_div")).r
      val x2018_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2018_div""")
      x2018_div.r := (Math.div(10.FP(true, 10, 22), x2012_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2018_div")).r
      val x2019_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2019_div""")
      x2019_div.r := (Math.div(x2018_div, x3542, Some(20.0), true.B, Truncate, Wrapping, "x2019_div")).r
      val x3546 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3546_x2019_div_D60") 
      x3546.r := getRetimed(x2019_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2020_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2020_sub""")
      x2020_sub.r := Math.sub(x2017_div,x3546,Some(1.0), true.B, Truncate, Wrapping, "x2020_sub").r
      io.ret.r := x2020_sub.r
    }
    val module = Module(new x2021_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x2021_inr_SwitchCase **/
