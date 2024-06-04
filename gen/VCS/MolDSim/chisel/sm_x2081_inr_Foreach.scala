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

/** Hierarchy: x2081 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2081_inr_Foreach **/
class x2081_inr_Foreach_kernel(
  list_b1879: List[Bool],
  list_b1875: List[FixedPoint],
  list_x579_accum_0: List[StandardInterface],
  list_x1890_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x2081_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2081_inr_Foreach_iiCtr"))
  
  abstract class x2081_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1879 = Input(Bool())
      val in_x1890_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1890_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1875 = Input(new FixedPoint(true, 32, 0))
      val in_x579_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x579_accum_0_p").asInstanceOf[MemParams] ))
      val in_b563 = Input(Bool())
      val in_x580_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x580_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x1885_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1885_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1879 = {io.in_b1879} 
    def x1890_tmp_4 = {io.in_x1890_tmp_4} ; io.in_x1890_tmp_4 := DontCare
    def b1875 = {io.in_b1875} 
    def x579_accum_0 = {io.in_x579_accum_0} ; io.in_x579_accum_0 := DontCare
    def b563 = {io.in_b563} 
    def x580_accum_1 = {io.in_x580_accum_1} ; io.in_x580_accum_1 := DontCare
    def x1885_tmp_4 = {io.in_x1885_tmp_4} ; io.in_x1885_tmp_4 := DontCare
  }
  def connectWires0(module: x2081_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1879 <> b1879
    x1890_tmp_4.connectLedger(module.io.in_x1890_tmp_4)
    module.io.in_b1875 <> b1875
    x579_accum_0.connectLedger(module.io.in_x579_accum_0)
    module.io.in_b563 <> b563
    x580_accum_1.connectLedger(module.io.in_x580_accum_1)
    x1885_tmp_4.connectLedger(module.io.in_x1885_tmp_4)
  }
  val b1879 = list_b1879(0)
  val b563 = list_b1879(1)
  val b1875 = list_b1875(0)
  val x579_accum_0 = list_x579_accum_0(0)
  val x1890_tmp_4 = list_x1890_tmp_4(0)
  val x580_accum_1 = list_x1890_tmp_4(1)
  val x1885_tmp_4 = list_x1890_tmp_4(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2081_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2081_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2081_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2081_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2081_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2081_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2081_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2081_instrctr, cycles_x2081_inr_Foreach.io.count, iters_x2081_inr_Foreach.io.count, 0.U, 0.U)
      val b1877 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1877.suggestName("b1877")
      val b1880 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1880.suggestName("b1880")
      val x2062_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2062_rd""")
      val x2062_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2062_rd_ofs = List[UInt](b1877.r)
      val x2062_rd_en = List[Bool](true.B)
      val x2062_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1880 & b563 ).suggestName("x2062_rd_shared_en")
      x2062_rd.toSeq.zip(x1885_tmp_4.connectRPort(2062, x2062_rd_banks, x2062_rd_ofs, io.sigsIn.backpressure, x2062_rd_en.map(_ && x2062_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2063 = VecApply(x2062,0)
      val x2063_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2063_elem_0""")
      x2063_elem_0.r := x2062_rd(0).r
      val x2064_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2064_rd""")
      val x2064_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2064_rd_ofs = List[UInt](b1877.r)
      val x2064_rd_en = List[Bool](true.B)
      val x2064_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1880 & b563 ).suggestName("x2064_rd_shared_en")
      x2064_rd.toSeq.zip(x1890_tmp_4.connectRPort(2064, x2064_rd_banks, x2064_rd_ofs, io.sigsIn.backpressure, x2064_rd_en.map(_ && x2064_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2065 = VecApply(x2064,0)
      val x2065_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2065_elem_0""")
      x2065_elem_0.r := x2064_rd(0).r
      val x3557 = Wire(Bool()).suggestName("x3557_b1880_D1") 
      x3557.r := getRetimed(b1880.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3558 = Wire(Bool()).suggestName("x3558_b563_D1") 
      x3558.r := getRetimed(b563.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3559 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3559_b1877_D1") 
      x3559.r := getRetimed(b1877.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2066_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2066_rd""")
      val x2066_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2066_rd_ofs = List[UInt](x3559.r)
      val x2066_rd_en = List[Bool](true.B)
      val x2066_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3557 & x3558 ).suggestName("x2066_rd_shared_en")
      x2066_rd.toSeq.zip(x579_accum_0.connectRPort(2066, x2066_rd_banks, x2066_rd_ofs, io.sigsIn.backpressure, x2066_rd_en.map(_ && x2066_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2067 = VecApply(x2066,0)
      val x2067_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2067_elem_0""")
      x2067_elem_0.r := x2066_rd(0).r
      val x2068 = Wire(Bool()).suggestName("""x2068""")
      x2068 := b1880 & b563
      val x2070 = Wire(Bool()).suggestName("""x2070""")
      x2070 := b1879 & b563
      val x2072 = Wire(Bool()).suggestName("""x2072""")
      x2072 := x2070 & x2068
      val x2073_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2073_sum""")
      x2073_sum.r := Math.add(x2063_elem_0,x2065_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2073_sum").r
      val x3560 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3560_x2063_elem_0_D1") 
      x3560.r := getRetimed(x2063_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3561 = Wire(Bool()).suggestName("x3561_x2072_D3") 
      x3561.r := getRetimed(x2072.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x2074 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2074""")
      x2074.r := Mux((x3561), x2073_sum.r, x3560.r)
      val x2076 = Wire(Bool()).suggestName("""x2076""")
      x2076.r := Math.eql(b1875, 0L.FP(true, 32, 0), Some(0.2), true.B,"x2076").r
      val x2077_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2077_sum""")
      x2077_sum.r := Math.add(x2074,x2067_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2077_sum").r
      val x3562 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3562_x2074_D1") 
      x3562.r := getRetimed(x2074.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3563 = Wire(Bool()).suggestName("x3563_x2076_D4") 
      x3563.r := getRetimed(x2076.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x2078 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2078""")
      x2078.r := Mux((x3563), x3562.r, x2077_sum.r)
      val x3564 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3564_b1877_D5") 
      x3564.r := getRetimed(b1877.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3565 = Wire(Bool()).suggestName("x3565_b563_D5") 
      x3565.r := getRetimed(b563.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3566 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3566_x2078_D1") 
      x3566.r := getRetimed(x2078.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3567 = Wire(Bool()).suggestName("x3567_b1880_D5") 
      x3567.r := getRetimed(b1880.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x2079_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2079_wr_ofs = List[UInt](x3564.r)
      val x2079_wr_en = List[Bool](true.B)
      val x2079_wr_data = List[UInt](x3566.r)
      x579_accum_0.connectWPort(2079, x2079_wr_banks, x2079_wr_ofs, x2079_wr_data, x2079_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3567 & x3565))
      val x2080_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2080_wr_ofs = List[UInt](x3564.r)
      val x2080_wr_en = List[Bool](true.B)
      val x2080_wr_data = List[UInt](x3566.r)
      x580_accum_1.connectWPort(2080, x2080_wr_banks, x2080_wr_ofs, x2080_wr_data, x2080_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3567 & x3565))
      x1885_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x1890_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x2081_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2081_inr_Foreach **/
