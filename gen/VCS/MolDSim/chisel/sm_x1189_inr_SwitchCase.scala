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

/** Hierarchy: x1189 -> x1191 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1189_inr_SwitchCase **/
class x1189_inr_SwitchCase_kernel(
  list_x1138_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x1189_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1189_inr_SwitchCase_iiCtr"))
  
  abstract class x1189_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1138_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1138_reg_p").asInstanceOf[NBufParams] ))
      val in_x1107_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1107_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1138_reg = {io.in_x1138_reg} ; io.in_x1138_reg := DontCare
    def x1107_r_0 = {io.in_x1107_r_0} ; io.in_x1107_r_0 := DontCare
  }
  def connectWires0(module: x1189_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1138_reg.connectLedger(module.io.in_x1138_reg)
    x1107_r_0.connectLedger(module.io.in_x1107_r_0)
  }
  val x1138_reg = list_x1138_reg(0)
  val x1107_r_0 = list_x1138_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1189_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1189_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1189_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1189_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x1189_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x1189_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x1189_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1189_instrctr, cycles_x1189_inr_SwitchCase.io.count, iters_x1189_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x1191, x1250, x2707, x2859, x444)
      val x1178_rd_x1138 = Wire(Bool()).suggestName("""x1178_rd_x1138""")
      val x1178_rd_x1138_banks = List[UInt]()
      val x1178_rd_x1138_ofs = List[UInt]()
      val x1178_rd_x1138_en = List[Bool](true.B)
      val x1178_rd_x1138_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1178_rd_x1138_shared_en")
      x1178_rd_x1138.toSeq.zip(x1138_reg.connectRPort(1178, x1178_rd_x1138_banks, x1178_rd_x1138_ofs, io.sigsIn.backpressure, x1178_rd_x1138_en.map(_ && x1178_rd_x1138_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1179_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1179_rd""")
      val x1179_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1179_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1179_rd_en = List[Bool](true.B)
      val x1179_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x1178_rd_x1138 ).suggestName("x1179_rd_shared_en")
      x1179_rd.toSeq.zip(x1107_r_0.connectRPort(1179, x1179_rd_banks, x1179_rd_ofs, io.sigsIn.backpressure, x1179_rd_en.map(_ && x1179_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1180 = VecApply(x1179,0)
      val x1180_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1180_elem_0""")
      x1180_elem_0.r := x1179_rd(0).r
      val x1181_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1181_div""")
      x1181_div.r := (Math.div(100.FP(true, 10, 22), x1180_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1181_div")).r
      val x3298 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3298_x1180_elem_0_D20") 
      x3298.r := getRetimed(x1180_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1182_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1182_div""")
      x1182_div.r := (Math.div(x1181_div, x3298, Some(20.0), true.B, Truncate, Wrapping, "x1182_div")).r
      val x3299 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3299_x1180_elem_0_D40") 
      x3299.r := getRetimed(x1180_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x1183_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1183_div""")
      x1183_div.r := (Math.div(x1182_div, x3299, Some(20.0), true.B, Truncate, Wrapping, "x1183_div")).r
      val x3300 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3300_x1180_elem_0_D60") 
      x3300.r := getRetimed(x1180_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1184_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1184_div""")
      x1184_div.r := (Math.div(x1183_div, x3300, Some(20.0), true.B, Truncate, Wrapping, "x1184_div")).r
      val x3301 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3301_x1180_elem_0_D80") 
      x3301.r := getRetimed(x1180_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x1185_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1185_div""")
      x1185_div.r := (Math.div(x1184_div, x3301, Some(20.0), true.B, Truncate, Wrapping, "x1185_div")).r
      val x1186_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1186_div""")
      x1186_div.r := (Math.div(10.FP(true, 10, 22), x1180_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1186_div")).r
      val x1187_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1187_div""")
      x1187_div.r := (Math.div(x1186_div, x3298, Some(20.0), true.B, Truncate, Wrapping, "x1187_div")).r
      val x3302 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3302_x1187_div_D60") 
      x3302.r := getRetimed(x1187_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1188_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1188_sub""")
      x1188_sub.r := Math.sub(x1185_div,x3302,Some(1.0), true.B, Truncate, Wrapping, "x1188_sub").r
      io.ret.r := x1188_sub.r
    }
    val module = Module(new x1189_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x1189_inr_SwitchCase **/
