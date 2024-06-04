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

/** Hierarchy: x981 -> x983 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x981_inr_SwitchCase **/
class x981_inr_SwitchCase_kernel(
  list_x930_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x981_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x981_inr_SwitchCase_iiCtr"))
  
  abstract class x981_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x930_reg = Flipped(new NBufInterface(ModuleParams.getParams("x930_reg_p").asInstanceOf[NBufParams] ))
      val in_x899_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x899_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x930_reg = {io.in_x930_reg} ; io.in_x930_reg := DontCare
    def x899_r_0 = {io.in_x899_r_0} ; io.in_x899_r_0 := DontCare
  }
  def connectWires0(module: x981_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x930_reg.connectLedger(module.io.in_x930_reg)
    x899_r_0.connectLedger(module.io.in_x899_r_0)
  }
  val x930_reg = list_x930_reg(0)
  val x899_r_0 = list_x930_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x981_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x981_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x981_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x981_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x981_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x981_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x981_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X981_instrctr, cycles_x981_inr_SwitchCase.io.count, iters_x981_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x983, x1042, x2707, x2859, x444)
      val x970_rd_x930 = Wire(Bool()).suggestName("""x970_rd_x930""")
      val x970_rd_x930_banks = List[UInt]()
      val x970_rd_x930_ofs = List[UInt]()
      val x970_rd_x930_en = List[Bool](true.B)
      val x970_rd_x930_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x970_rd_x930_shared_en")
      x970_rd_x930.toSeq.zip(x930_reg.connectRPort(970, x970_rd_x930_banks, x970_rd_x930_ofs, io.sigsIn.backpressure, x970_rd_x930_en.map(_ && x970_rd_x930_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x971_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x971_rd""")
      val x971_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x971_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x971_rd_en = List[Bool](true.B)
      val x971_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x970_rd_x930 ).suggestName("x971_rd_shared_en")
      x971_rd.toSeq.zip(x899_r_0.connectRPort(971, x971_rd_banks, x971_rd_ofs, io.sigsIn.backpressure, x971_rd_en.map(_ && x971_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x972 = VecApply(x971,0)
      val x972_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x972_elem_0""")
      x972_elem_0.r := x971_rd(0).r
      val x973_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x973_div""")
      x973_div.r := (Math.div(100.FP(true, 10, 22), x972_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x973_div")).r
      val x3237 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3237_x972_elem_0_D20") 
      x3237.r := getRetimed(x972_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x974_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x974_div""")
      x974_div.r := (Math.div(x973_div, x3237, Some(20.0), true.B, Truncate, Wrapping, "x974_div")).r
      val x3238 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3238_x972_elem_0_D40") 
      x3238.r := getRetimed(x972_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x975_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x975_div""")
      x975_div.r := (Math.div(x974_div, x3238, Some(20.0), true.B, Truncate, Wrapping, "x975_div")).r
      val x3239 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3239_x972_elem_0_D60") 
      x3239.r := getRetimed(x972_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x976_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x976_div""")
      x976_div.r := (Math.div(x975_div, x3239, Some(20.0), true.B, Truncate, Wrapping, "x976_div")).r
      val x3240 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3240_x972_elem_0_D80") 
      x3240.r := getRetimed(x972_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x977_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x977_div""")
      x977_div.r := (Math.div(x976_div, x3240, Some(20.0), true.B, Truncate, Wrapping, "x977_div")).r
      val x978_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x978_div""")
      x978_div.r := (Math.div(10.FP(true, 10, 22), x972_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x978_div")).r
      val x979_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x979_div""")
      x979_div.r := (Math.div(x978_div, x3237, Some(20.0), true.B, Truncate, Wrapping, "x979_div")).r
      val x3241 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3241_x979_div_D60") 
      x3241.r := getRetimed(x979_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x980_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x980_sub""")
      x980_sub.r := Math.sub(x977_div,x3241,Some(1.0), true.B, Truncate, Wrapping, "x980_sub").r
      io.ret.r := x980_sub.r
    }
    val module = Module(new x981_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x981_inr_SwitchCase **/
