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

/** Hierarchy: x2215 -> x2217 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2215_inr_SwitchCase **/
class x2215_inr_SwitchCase_kernel(
  list_x2146_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x2215_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2215_inr_SwitchCase_iiCtr"))
  
  abstract class x2215_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2146_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2146_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2177_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2177_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2146_r_0 = {io.in_x2146_r_0} ; io.in_x2146_r_0 := DontCare
    def x2177_reg = {io.in_x2177_reg} ; io.in_x2177_reg := DontCare
  }
  def connectWires0(module: x2215_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x2146_r_0.connectLedger(module.io.in_x2146_r_0)
    x2177_reg.connectLedger(module.io.in_x2177_reg)
  }
  val x2146_r_0 = list_x2146_r_0(0)
  val x2177_reg = list_x2146_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2215_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2215_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2215_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2215_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x2215_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x2215_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x2215_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2215_instrctr, cycles_x2215_inr_SwitchCase.io.count, iters_x2215_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x2217, x2290, x2707, x2859, x444)
      val x2204_rd_x2177 = Wire(Bool()).suggestName("""x2204_rd_x2177""")
      val x2204_rd_x2177_banks = List[UInt]()
      val x2204_rd_x2177_ofs = List[UInt]()
      val x2204_rd_x2177_en = List[Bool](true.B)
      val x2204_rd_x2177_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2204_rd_x2177_shared_en")
      x2204_rd_x2177.toSeq.zip(x2177_reg.connectRPort(2204, x2204_rd_x2177_banks, x2204_rd_x2177_ofs, io.sigsIn.backpressure, x2204_rd_x2177_en.map(_ && x2204_rd_x2177_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2205_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2205_rd""")
      val x2205_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2205_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2205_rd_en = List[Bool](true.B)
      val x2205_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x2204_rd_x2177 ).suggestName("x2205_rd_shared_en")
      x2205_rd.toSeq.zip(x2146_r_0.connectRPort(2205, x2205_rd_banks, x2205_rd_ofs, io.sigsIn.backpressure, x2205_rd_en.map(_ && x2205_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2206 = VecApply(x2205,0)
      val x2206_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2206_elem_0""")
      x2206_elem_0.r := x2205_rd(0).r
      val x2207_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2207_div""")
      x2207_div.r := (Math.div(100.FP(true, 10, 22), x2206_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2207_div")).r
      val x3598 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3598_x2206_elem_0_D20") 
      x3598.r := getRetimed(x2206_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2208_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2208_div""")
      x2208_div.r := (Math.div(x2207_div, x3598, Some(20.0), true.B, Truncate, Wrapping, "x2208_div")).r
      val x3599 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3599_x2206_elem_0_D40") 
      x3599.r := getRetimed(x2206_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x2209_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2209_div""")
      x2209_div.r := (Math.div(x2208_div, x3599, Some(20.0), true.B, Truncate, Wrapping, "x2209_div")).r
      val x3600 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3600_x2206_elem_0_D60") 
      x3600.r := getRetimed(x2206_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2210_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2210_div""")
      x2210_div.r := (Math.div(x2209_div, x3600, Some(20.0), true.B, Truncate, Wrapping, "x2210_div")).r
      val x3601 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3601_x2206_elem_0_D80") 
      x3601.r := getRetimed(x2206_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x2211_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2211_div""")
      x2211_div.r := (Math.div(x2210_div, x3601, Some(20.0), true.B, Truncate, Wrapping, "x2211_div")).r
      val x2212_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2212_div""")
      x2212_div.r := (Math.div(10.FP(true, 10, 22), x2206_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2212_div")).r
      val x2213_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2213_div""")
      x2213_div.r := (Math.div(x2212_div, x3598, Some(20.0), true.B, Truncate, Wrapping, "x2213_div")).r
      val x3602 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3602_x2213_div_D60") 
      x3602.r := getRetimed(x2213_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2214_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2214_sub""")
      x2214_sub.r := Math.sub(x2211_div,x3602,Some(1.0), true.B, Truncate, Wrapping, "x2214_sub").r
      io.ret.r := x2214_sub.r
    }
    val module = Module(new x2215_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x2215_inr_SwitchCase **/
