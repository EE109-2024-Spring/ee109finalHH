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

/** Hierarchy: x773 -> x775 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x773_inr_SwitchCase **/
class x773_inr_SwitchCase_kernel(
  list_x722_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x773_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x773_inr_SwitchCase_iiCtr"))
  
  abstract class x773_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x722_reg = Flipped(new NBufInterface(ModuleParams.getParams("x722_reg_p").asInstanceOf[NBufParams] ))
      val in_x691_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x691_r_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x722_reg = {io.in_x722_reg} ; io.in_x722_reg := DontCare
    def x691_r_0 = {io.in_x691_r_0} ; io.in_x691_r_0 := DontCare
  }
  def connectWires0(module: x773_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x722_reg.connectLedger(module.io.in_x722_reg)
    x691_r_0.connectLedger(module.io.in_x691_r_0)
  }
  val x722_reg = list_x722_reg(0)
  val x691_r_0 = list_x722_reg(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x773_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x773_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x773_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x773_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x773_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x773_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x773_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X773_instrctr, cycles_x773_inr_SwitchCase.io.count, iters_x773_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x775, x834, x2707, x2859, x444)
      val x762_rd_x722 = Wire(Bool()).suggestName("""x762_rd_x722""")
      val x762_rd_x722_banks = List[UInt]()
      val x762_rd_x722_ofs = List[UInt]()
      val x762_rd_x722_en = List[Bool](true.B)
      val x762_rd_x722_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x762_rd_x722_shared_en")
      x762_rd_x722.toSeq.zip(x722_reg.connectRPort(762, x762_rd_x722_banks, x762_rd_x722_ofs, io.sigsIn.backpressure, x762_rd_x722_en.map(_ && x762_rd_x722_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x763_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x763_rd""")
      val x763_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x763_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x763_rd_en = List[Bool](true.B)
      val x763_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x762_rd_x722 ).suggestName("x763_rd_shared_en")
      x763_rd.toSeq.zip(x691_r_0.connectRPort(763, x763_rd_banks, x763_rd_ofs, io.sigsIn.backpressure, x763_rd_en.map(_ && x763_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x764 = VecApply(x763,0)
      val x764_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x764_elem_0""")
      x764_elem_0.r := x763_rd(0).r
      val x765_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x765_div""")
      x765_div.r := (Math.div(100.FP(true, 10, 22), x764_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x765_div")).r
      val x3176 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3176_x764_elem_0_D20") 
      x3176.r := getRetimed(x764_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x766_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x766_div""")
      x766_div.r := (Math.div(x765_div, x3176, Some(20.0), true.B, Truncate, Wrapping, "x766_div")).r
      val x3177 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3177_x764_elem_0_D40") 
      x3177.r := getRetimed(x764_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x767_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x767_div""")
      x767_div.r := (Math.div(x766_div, x3177, Some(20.0), true.B, Truncate, Wrapping, "x767_div")).r
      val x3178 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3178_x764_elem_0_D60") 
      x3178.r := getRetimed(x764_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x768_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x768_div""")
      x768_div.r := (Math.div(x767_div, x3178, Some(20.0), true.B, Truncate, Wrapping, "x768_div")).r
      val x3179 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3179_x764_elem_0_D80") 
      x3179.r := getRetimed(x764_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x769_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x769_div""")
      x769_div.r := (Math.div(x768_div, x3179, Some(20.0), true.B, Truncate, Wrapping, "x769_div")).r
      val x770_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x770_div""")
      x770_div.r := (Math.div(10.FP(true, 10, 22), x764_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x770_div")).r
      val x771_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x771_div""")
      x771_div.r := (Math.div(x770_div, x3176, Some(20.0), true.B, Truncate, Wrapping, "x771_div")).r
      val x3180 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3180_x771_div_D60") 
      x3180.r := getRetimed(x771_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x772_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x772_sub""")
      x772_sub.r := Math.sub(x769_div,x3180,Some(1.0), true.B, Truncate, Wrapping, "x772_sub").r
      io.ret.r := x772_sub.r
    }
    val module = Module(new x773_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
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
/** END SwitchCase x773_inr_SwitchCase **/
