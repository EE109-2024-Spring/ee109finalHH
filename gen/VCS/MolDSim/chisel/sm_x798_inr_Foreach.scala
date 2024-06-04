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

/** Hierarchy: x798 -> x813 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x798_inr_Foreach **/
class x798_inr_Foreach_kernel(
  list_b630: List[Bool],
  list_x719_force_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x798_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x798_inr_Foreach_iiCtr"))
  
  abstract class x798_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x719_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x719_force_0_p").asInstanceOf[NBufParams] ))
      val in_x634_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x634_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b630 = Input(Bool())
      val in_x637_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x637_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x633_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x633_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x636_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x636_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b557 = Input(Bool())
      val in_x635_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x635_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x719_force_0 = {io.in_x719_force_0} ; io.in_x719_force_0 := DontCare
    def x634_tmp_1 = {io.in_x634_tmp_1} ; io.in_x634_tmp_1 := DontCare
    def b630 = {io.in_b630} 
    def x637_tmp_4 = {io.in_x637_tmp_4} ; io.in_x637_tmp_4 := DontCare
    def x633_tmp_0 = {io.in_x633_tmp_0} ; io.in_x633_tmp_0 := DontCare
    def x636_tmp_3 = {io.in_x636_tmp_3} ; io.in_x636_tmp_3 := DontCare
    def b557 = {io.in_b557} 
    def x635_tmp_2 = {io.in_x635_tmp_2} ; io.in_x635_tmp_2 := DontCare
  }
  def connectWires0(module: x798_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x719_force_0.connectLedger(module.io.in_x719_force_0)
    x634_tmp_1.connectLedger(module.io.in_x634_tmp_1)
    module.io.in_b630 <> b630
    x637_tmp_4.connectLedger(module.io.in_x637_tmp_4)
    x633_tmp_0.connectLedger(module.io.in_x633_tmp_0)
    x636_tmp_3.connectLedger(module.io.in_x636_tmp_3)
    module.io.in_b557 <> b557
    x635_tmp_2.connectLedger(module.io.in_x635_tmp_2)
  }
  val b630 = list_b630(0)
  val b557 = list_b630(1)
  val x719_force_0 = list_x719_force_0(0)
  val x634_tmp_1 = list_x719_force_0(1)
  val x637_tmp_4 = list_x719_force_0(2)
  val x633_tmp_0 = list_x719_force_0(3)
  val x636_tmp_3 = list_x719_force_0(4)
  val x635_tmp_2 = list_x719_force_0(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x798_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x798_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x798_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x798_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x798_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x798_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x798_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X798_instrctr, cycles_x798_inr_Foreach.io.count, iters_x798_inr_Foreach.io.count, 0.U, 0.U)
      val b785 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b785.suggestName("b785")
      val b786 = ~io.sigsIn.cchainOutputs.head.oobs(0); b786.suggestName("b786")
      val x787_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x787_rd""")
      val x787_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x787_rd_ofs = List[UInt](b785.r)
      val x787_rd_en = List[Bool](true.B)
      val x787_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b786 & b630 & b557 ).suggestName("x787_rd_shared_en")
      x787_rd.toSeq.zip(x636_tmp_3.connectRPort(787, x787_rd_banks, x787_rd_ofs, io.sigsIn.backpressure, x787_rd_en.map(_ && x787_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x788 = VecApply(x787,0)
      val x788_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x788_elem_0""")
      x788_elem_0.r := x787_rd(0).r
      val x789_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x789_mul""")
      x789_mul.r := (Math.mul(x788_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x789_mul")).r
      val x790_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x790_rd""")
      val x790_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x790_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x790_rd_en = List[Bool](true.B)
      val x790_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b786 & b630 & b557 ).suggestName("x790_rd_shared_en")
      x790_rd.toSeq.zip(x719_force_0.connectRPort(790, x790_rd_banks, x790_rd_ofs, io.sigsIn.backpressure, x790_rd_en.map(_ && x790_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x791 = VecApply(x790,0)
      val x791_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x791_elem_0""")
      x791_elem_0.r := x790_rd(0).r
      val x3181 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3181_x791_elem_0_D6") 
      x3181.r := getRetimed(x791_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x792_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x792_mul""")
      x792_mul.r := (Math.mul(x789_mul, x3181, Some(6.0), true.B, Truncate, Wrapping, "x792_mul")).r
      val x3182 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3182_b785_D14") 
      x3182.r := getRetimed(b785.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3183 = Wire(Bool()).suggestName("x3183_b630_D14") 
      x3183.r := getRetimed(b630.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3184 = Wire(Bool()).suggestName("x3184_b557_D14") 
      x3184.r := getRetimed(b557.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3185 = Wire(Bool()).suggestName("x3185_b786_D14") 
      x3185.r := getRetimed(b786.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x793_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x793_wr_ofs = List[UInt](x3182.r)
      val x793_wr_en = List[Bool](true.B)
      val x793_wr_data = List[UInt](x792_mul.r)
      x634_tmp_1.connectWPort(793, x793_wr_banks, x793_wr_ofs, x793_wr_data, x793_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3185 & x3183 & x3184))
      val x794_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x794_wr_ofs = List[UInt](x3182.r)
      val x794_wr_en = List[Bool](true.B)
      val x794_wr_data = List[UInt](x792_mul.r)
      x637_tmp_4.connectWPort(794, x794_wr_banks, x794_wr_ofs, x794_wr_data, x794_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3185 & x3183 & x3184))
      val x795_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x795_wr_ofs = List[UInt](x3182.r)
      val x795_wr_en = List[Bool](true.B)
      val x795_wr_data = List[UInt](x792_mul.r)
      x633_tmp_0.connectWPort(795, x795_wr_banks, x795_wr_ofs, x795_wr_data, x795_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3185 & x3183 & x3184))
      val x796_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x796_wr_ofs = List[UInt](x3182.r)
      val x796_wr_en = List[Bool](true.B)
      val x796_wr_data = List[UInt](x792_mul.r)
      x636_tmp_3.connectWPort(796, x796_wr_banks, x796_wr_ofs, x796_wr_data, x796_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3185 & x3183 & x3184))
      val x797_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x797_wr_ofs = List[UInt](x3182.r)
      val x797_wr_en = List[Bool](true.B)
      val x797_wr_data = List[UInt](x792_mul.r)
      x635_tmp_2.connectWPort(797, x797_wr_banks, x797_wr_ofs, x797_wr_data, x797_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3185 & x3183 & x3184))
    }
    val module = Module(new x798_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectInstrCtrs(instrctrs, module.io.in_instrctrs)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x798_inr_Foreach **/
