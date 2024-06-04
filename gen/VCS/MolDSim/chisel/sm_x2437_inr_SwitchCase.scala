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

/** Hierarchy: x2437 -> x2439 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2437_inr_SwitchCase **/
class x2437_inr_SwitchCase_kernel(
  list_x2355_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x2437_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2437_inr_SwitchCase_iiCtr"))
  
  abstract class x2437_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2355_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2355_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2386_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2386_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x2355_r_0 = {io.in_x2355_r_0} ; io.in_x2355_r_0 := DontCare
    def x2386_reg = {io.in_x2386_reg} ; io.in_x2386_reg := DontCare
  }
  def connectWires0(module: x2437_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x2355_r_0.connectLedger(module.io.in_x2355_r_0)
    x2386_reg.connectLedger(module.io.in_x2386_reg)
  }
  val x2355_r_0 = list_x2355_r_0(0)
  val x2386_reg = list_x2355_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x2437_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x2437_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2437_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2437_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x2437_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x2437_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x2437_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2437_instrctr, cycles_x2437_inr_SwitchCase.io.count, iters_x2437_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x2439, x2498, x2707, x2859, x444)
      val x2426_rd_x2386 = Wire(Bool()).suggestName("""x2426_rd_x2386""")
      val x2426_rd_x2386_banks = List[UInt]()
      val x2426_rd_x2386_ofs = List[UInt]()
      val x2426_rd_x2386_en = List[Bool](true.B)
      val x2426_rd_x2386_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2426_rd_x2386_shared_en")
      x2426_rd_x2386.toSeq.zip(x2386_reg.connectRPort(2426, x2426_rd_x2386_banks, x2426_rd_x2386_ofs, io.sigsIn.backpressure, x2426_rd_x2386_en.map(_ && x2426_rd_x2386_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2427_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2427_rd""")
      val x2427_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2427_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2427_rd_en = List[Bool](true.B)
      val x2427_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x2426_rd_x2386 ).suggestName("x2427_rd_shared_en")
      x2427_rd.toSeq.zip(x2355_r_0.connectRPort(2427, x2427_rd_banks, x2427_rd_ofs, io.sigsIn.backpressure, x2427_rd_en.map(_ && x2427_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2428 = VecApply(x2427,0)
      val x2428_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2428_elem_0""")
      x2428_elem_0.r := x2427_rd(0).r
      val x2429_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2429_div""")
      x2429_div.r := (Math.div(100.FP(true, 10, 22), x2428_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2429_div")).r
      val x3664 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3664_x2428_elem_0_D20") 
      x3664.r := getRetimed(x2428_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2430_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2430_div""")
      x2430_div.r := (Math.div(x2429_div, x3664, Some(20.0), true.B, Truncate, Wrapping, "x2430_div")).r
      val x3665 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3665_x2428_elem_0_D40") 
      x3665.r := getRetimed(x2428_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x2431_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2431_div""")
      x2431_div.r := (Math.div(x2430_div, x3665, Some(20.0), true.B, Truncate, Wrapping, "x2431_div")).r
      val x3666 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3666_x2428_elem_0_D60") 
      x3666.r := getRetimed(x2428_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2432_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2432_div""")
      x2432_div.r := (Math.div(x2431_div, x3666, Some(20.0), true.B, Truncate, Wrapping, "x2432_div")).r
      val x3667 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3667_x2428_elem_0_D80") 
      x3667.r := getRetimed(x2428_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x2433_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2433_div""")
      x2433_div.r := (Math.div(x2432_div, x3667, Some(20.0), true.B, Truncate, Wrapping, "x2433_div")).r
      val x2434_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2434_div""")
      x2434_div.r := (Math.div(10.FP(true, 10, 22), x2428_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x2434_div")).r
      val x2435_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2435_div""")
      x2435_div.r := (Math.div(x2434_div, x3664, Some(20.0), true.B, Truncate, Wrapping, "x2435_div")).r
      val x3668 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3668_x2435_div_D60") 
      x3668.r := getRetimed(x2435_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x2436_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2436_sub""")
      x2436_sub.r := Math.sub(x2433_div,x3668,Some(1.0), true.B, Truncate, Wrapping, "x2436_sub").r
      io.ret.r := x2436_sub.r
    }
    val module = Module(new x2437_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x2437_inr_SwitchCase **/
