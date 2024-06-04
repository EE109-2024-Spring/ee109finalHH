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

/** Hierarchy: x833 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x833_inr_Foreach **/
class x833_inr_Foreach_kernel(
  list_b631: List[Bool],
  list_b627: List[FixedPoint],
  list_x567_accum_0: List[StandardInterface],
  list_x642_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x833_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x833_inr_Foreach_iiCtr"))
  
  abstract class x833_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x642_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x642_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x637_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x637_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x567_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x567_accum_0_p").asInstanceOf[MemParams] ))
      val in_b631 = Input(Bool())
      val in_b557 = Input(Bool())
      val in_b627 = Input(new FixedPoint(true, 32, 0))
      val in_x568_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x568_accum_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x642_tmp_4 = {io.in_x642_tmp_4} ; io.in_x642_tmp_4 := DontCare
    def x637_tmp_4 = {io.in_x637_tmp_4} ; io.in_x637_tmp_4 := DontCare
    def x567_accum_0 = {io.in_x567_accum_0} ; io.in_x567_accum_0 := DontCare
    def b631 = {io.in_b631} 
    def b557 = {io.in_b557} 
    def b627 = {io.in_b627} 
    def x568_accum_1 = {io.in_x568_accum_1} ; io.in_x568_accum_1 := DontCare
  }
  def connectWires0(module: x833_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x642_tmp_4.connectLedger(module.io.in_x642_tmp_4)
    x637_tmp_4.connectLedger(module.io.in_x637_tmp_4)
    x567_accum_0.connectLedger(module.io.in_x567_accum_0)
    module.io.in_b631 <> b631
    module.io.in_b557 <> b557
    module.io.in_b627 <> b627
    x568_accum_1.connectLedger(module.io.in_x568_accum_1)
  }
  val b631 = list_b631(0)
  val b557 = list_b631(1)
  val b627 = list_b627(0)
  val x567_accum_0 = list_x567_accum_0(0)
  val x642_tmp_4 = list_x642_tmp_4(0)
  val x637_tmp_4 = list_x642_tmp_4(1)
  val x568_accum_1 = list_x642_tmp_4(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x833_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x833_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x833_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x833_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x833_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x833_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x833_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X833_instrctr, cycles_x833_inr_Foreach.io.count, iters_x833_inr_Foreach.io.count, 0.U, 0.U)
      val b629 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b629.suggestName("b629")
      val b632 = ~io.sigsIn.cchainOutputs.head.oobs(0); b632.suggestName("b632")
      val x814_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x814_rd""")
      val x814_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x814_rd_ofs = List[UInt](b629.r)
      val x814_rd_en = List[Bool](true.B)
      val x814_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b632 & b557 ).suggestName("x814_rd_shared_en")
      x814_rd.toSeq.zip(x637_tmp_4.connectRPort(814, x814_rd_banks, x814_rd_ofs, io.sigsIn.backpressure, x814_rd_en.map(_ && x814_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x815 = VecApply(x814,0)
      val x815_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x815_elem_0""")
      x815_elem_0.r := x814_rd(0).r
      val x816_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x816_rd""")
      val x816_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x816_rd_ofs = List[UInt](b629.r)
      val x816_rd_en = List[Bool](true.B)
      val x816_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b632 & b557 ).suggestName("x816_rd_shared_en")
      x816_rd.toSeq.zip(x642_tmp_4.connectRPort(816, x816_rd_banks, x816_rd_ofs, io.sigsIn.backpressure, x816_rd_en.map(_ && x816_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x817 = VecApply(x816,0)
      val x817_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x817_elem_0""")
      x817_elem_0.r := x816_rd(0).r
      val x3191 = Wire(Bool()).suggestName("x3191_b632_D1") 
      x3191.r := getRetimed(b632.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3192 = Wire(Bool()).suggestName("x3192_b557_D1") 
      x3192.r := getRetimed(b557.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3193 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3193_b629_D1") 
      x3193.r := getRetimed(b629.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x818_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x818_rd""")
      val x818_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x818_rd_ofs = List[UInt](x3193.r)
      val x818_rd_en = List[Bool](true.B)
      val x818_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3191 & x3192 ).suggestName("x818_rd_shared_en")
      x818_rd.toSeq.zip(x567_accum_0.connectRPort(818, x818_rd_banks, x818_rd_ofs, io.sigsIn.backpressure, x818_rd_en.map(_ && x818_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x819 = VecApply(x818,0)
      val x819_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x819_elem_0""")
      x819_elem_0.r := x818_rd(0).r
      val x820 = Wire(Bool()).suggestName("""x820""")
      x820 := b632 & b557
      val x822 = Wire(Bool()).suggestName("""x822""")
      x822 := b631 & b557
      val x824 = Wire(Bool()).suggestName("""x824""")
      x824 := x822 & x820
      val x825_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x825_sum""")
      x825_sum.r := Math.add(x815_elem_0,x817_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x825_sum").r
      val x3194 = Wire(Bool()).suggestName("x3194_x824_D3") 
      x3194.r := getRetimed(x824.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3195 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3195_x815_elem_0_D1") 
      x3195.r := getRetimed(x815_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x826 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x826""")
      x826.r := Mux((x3194), x825_sum.r, x3195.r)
      val x828 = Wire(Bool()).suggestName("""x828""")
      x828.r := Math.eql(b627, 0L.FP(true, 32, 0), Some(0.2), true.B,"x828").r
      val x829_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x829_sum""")
      x829_sum.r := Math.add(x826,x819_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x829_sum").r
      val x3196 = Wire(Bool()).suggestName("x3196_x828_D4") 
      x3196.r := getRetimed(x828.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x3197 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3197_x826_D1") 
      x3197.r := getRetimed(x826.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x830 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x830""")
      x830.r := Mux((x3196), x3197.r, x829_sum.r)
      val x3198 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3198_b629_D5") 
      x3198.r := getRetimed(b629.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3199 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3199_x830_D1") 
      x3199.r := getRetimed(x830.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3200 = Wire(Bool()).suggestName("x3200_b557_D5") 
      x3200.r := getRetimed(b557.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3201 = Wire(Bool()).suggestName("x3201_b632_D5") 
      x3201.r := getRetimed(b632.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x831_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x831_wr_ofs = List[UInt](x3198.r)
      val x831_wr_en = List[Bool](true.B)
      val x831_wr_data = List[UInt](x3199.r)
      x568_accum_1.connectWPort(831, x831_wr_banks, x831_wr_ofs, x831_wr_data, x831_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3201 & x3200))
      val x832_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x832_wr_ofs = List[UInt](x3198.r)
      val x832_wr_en = List[Bool](true.B)
      val x832_wr_data = List[UInt](x3199.r)
      x567_accum_0.connectWPort(832, x832_wr_banks, x832_wr_ofs, x832_wr_data, x832_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3201 & x3200))
      x637_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x642_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x833_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x833_inr_Foreach **/
