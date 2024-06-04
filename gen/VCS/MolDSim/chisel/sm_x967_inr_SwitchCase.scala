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

/** Hierarchy: x967 -> x969 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x967_inr_SwitchCase **/
class x967_inr_SwitchCase_kernel(
  list_x898_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x967_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x967_inr_SwitchCase_iiCtr"))
  
  abstract class x967_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x898_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x898_r_0_p").asInstanceOf[NBufParams] ))
      val in_x929_reg = Flipped(new NBufInterface(ModuleParams.getParams("x929_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x898_r_0 = {io.in_x898_r_0} ; io.in_x898_r_0 := DontCare
    def x929_reg = {io.in_x929_reg} ; io.in_x929_reg := DontCare
  }
  def connectWires0(module: x967_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x898_r_0.connectLedger(module.io.in_x898_r_0)
    x929_reg.connectLedger(module.io.in_x929_reg)
  }
  val x898_r_0 = list_x898_r_0(0)
  val x929_reg = list_x898_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x967_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x967_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x967_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x967_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x967_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x967_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x967_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X967_instrctr, cycles_x967_inr_SwitchCase.io.count, iters_x967_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x969, x1042, x2707, x2859, x444)
      val x956_rd_x929 = Wire(Bool()).suggestName("""x956_rd_x929""")
      val x956_rd_x929_banks = List[UInt]()
      val x956_rd_x929_ofs = List[UInt]()
      val x956_rd_x929_en = List[Bool](true.B)
      val x956_rd_x929_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x956_rd_x929_shared_en")
      x956_rd_x929.toSeq.zip(x929_reg.connectRPort(956, x956_rd_x929_banks, x956_rd_x929_ofs, io.sigsIn.backpressure, x956_rd_x929_en.map(_ && x956_rd_x929_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x957_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x957_rd""")
      val x957_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x957_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x957_rd_en = List[Bool](true.B)
      val x957_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x956_rd_x929 ).suggestName("x957_rd_shared_en")
      x957_rd.toSeq.zip(x898_r_0.connectRPort(957, x957_rd_banks, x957_rd_ofs, io.sigsIn.backpressure, x957_rd_en.map(_ && x957_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x958 = VecApply(x957,0)
      val x958_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x958_elem_0""")
      x958_elem_0.r := x957_rd(0).r
      val x959_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x959_div""")
      x959_div.r := (Math.div(100.FP(true, 10, 22), x958_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x959_div")).r
      val x3232 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3232_x958_elem_0_D20") 
      x3232.r := getRetimed(x958_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x960_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x960_div""")
      x960_div.r := (Math.div(x959_div, x3232, Some(20.0), true.B, Truncate, Wrapping, "x960_div")).r
      val x3233 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3233_x958_elem_0_D40") 
      x3233.r := getRetimed(x958_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x961_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x961_div""")
      x961_div.r := (Math.div(x960_div, x3233, Some(20.0), true.B, Truncate, Wrapping, "x961_div")).r
      val x3234 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3234_x958_elem_0_D60") 
      x3234.r := getRetimed(x958_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x962_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x962_div""")
      x962_div.r := (Math.div(x961_div, x3234, Some(20.0), true.B, Truncate, Wrapping, "x962_div")).r
      val x3235 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3235_x958_elem_0_D80") 
      x3235.r := getRetimed(x958_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x963_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x963_div""")
      x963_div.r := (Math.div(x962_div, x3235, Some(20.0), true.B, Truncate, Wrapping, "x963_div")).r
      val x964_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x964_div""")
      x964_div.r := (Math.div(10.FP(true, 10, 22), x958_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x964_div")).r
      val x965_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x965_div""")
      x965_div.r := (Math.div(x964_div, x3232, Some(20.0), true.B, Truncate, Wrapping, "x965_div")).r
      val x3236 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3236_x965_div_D60") 
      x3236.r := getRetimed(x965_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x966_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x966_sub""")
      x966_sub.r := Math.sub(x963_div,x3236,Some(1.0), true.B, Truncate, Wrapping, "x966_sub").r
      io.ret.r := x966_sub.r
    }
    val module = Module(new x967_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x967_inr_SwitchCase **/
