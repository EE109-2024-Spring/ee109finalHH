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

/** Hierarchy: x1175 -> x1177 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1175_inr_SwitchCase **/
class x1175_inr_SwitchCase_kernel(
  list_x1137_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x1175_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1175_inr_SwitchCase_iiCtr"))
  
  abstract class x1175_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1137_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1137_reg_p").asInstanceOf[NBufParams] ))
      val in_x1106_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1106_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1137_reg = {io.in_x1137_reg} ; io.in_x1137_reg := DontCare
    def x1106_r_0 = {io.in_x1106_r_0} ; io.in_x1106_r_0 := DontCare
  }
  def connectWires0(module: x1175_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1137_reg.connectLedger(module.io.in_x1137_reg)
    x1106_r_0.connectLedger(module.io.in_x1106_r_0)
  }
  val x1137_reg = list_x1137_reg(0)
  val x1106_r_0 = list_x1137_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1175_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1175_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1175_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1175_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x1175_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x1175_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x1175_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1175_instrctr, cycles_x1175_inr_SwitchCase.io.count, iters_x1175_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x1177, x1250, x2707, x2859, x444)
      val x1164_rd_x1137 = Wire(Bool()).suggestName("""x1164_rd_x1137""")
      val x1164_rd_x1137_banks = List[UInt]()
      val x1164_rd_x1137_ofs = List[UInt]()
      val x1164_rd_x1137_en = List[Bool](true.B)
      val x1164_rd_x1137_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1164_rd_x1137_shared_en")
      x1164_rd_x1137.toSeq.zip(x1137_reg.connectRPort(1164, x1164_rd_x1137_banks, x1164_rd_x1137_ofs, io.sigsIn.backpressure, x1164_rd_x1137_en.map(_ && x1164_rd_x1137_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1165_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1165_rd""")
      val x1165_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1165_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1165_rd_en = List[Bool](true.B)
      val x1165_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x1164_rd_x1137 ).suggestName("x1165_rd_shared_en")
      x1165_rd.toSeq.zip(x1106_r_0.connectRPort(1165, x1165_rd_banks, x1165_rd_ofs, io.sigsIn.backpressure, x1165_rd_en.map(_ && x1165_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1166 = VecApply(x1165,0)
      val x1166_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1166_elem_0""")
      x1166_elem_0.r := x1165_rd(0).r
      val x1167_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1167_div""")
      x1167_div.r := (Math.div(100.FP(true, 10, 22), x1166_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1167_div")).r
      val x3293 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3293_x1166_elem_0_D20") 
      x3293.r := getRetimed(x1166_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1168_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1168_div""")
      x1168_div.r := (Math.div(x1167_div, x3293, Some(20.0), true.B, Truncate, Wrapping, "x1168_div")).r
      val x3294 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3294_x1166_elem_0_D40") 
      x3294.r := getRetimed(x1166_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x1169_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1169_div""")
      x1169_div.r := (Math.div(x1168_div, x3294, Some(20.0), true.B, Truncate, Wrapping, "x1169_div")).r
      val x3295 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3295_x1166_elem_0_D60") 
      x3295.r := getRetimed(x1166_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1170_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1170_div""")
      x1170_div.r := (Math.div(x1169_div, x3295, Some(20.0), true.B, Truncate, Wrapping, "x1170_div")).r
      val x3296 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3296_x1166_elem_0_D80") 
      x3296.r := getRetimed(x1166_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x1171_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1171_div""")
      x1171_div.r := (Math.div(x1170_div, x3296, Some(20.0), true.B, Truncate, Wrapping, "x1171_div")).r
      val x1172_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1172_div""")
      x1172_div.r := (Math.div(10.FP(true, 10, 22), x1166_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1172_div")).r
      val x1173_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1173_div""")
      x1173_div.r := (Math.div(x1172_div, x3293, Some(20.0), true.B, Truncate, Wrapping, "x1173_div")).r
      val x3297 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3297_x1173_div_D60") 
      x3297.r := getRetimed(x1173_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1174_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1174_sub""")
      x1174_sub.r := Math.sub(x1171_div,x3297,Some(1.0), true.B, Truncate, Wrapping, "x1174_sub").r
      io.ret.r := x1174_sub.r
    }
    val module = Module(new x1175_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x1175_inr_SwitchCase **/
