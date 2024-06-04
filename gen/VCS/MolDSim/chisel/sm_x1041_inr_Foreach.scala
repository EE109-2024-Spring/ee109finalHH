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

/** Hierarchy: x1041 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1041_inr_Foreach **/
class x1041_inr_Foreach_kernel(
  list_b558: List[Bool],
  list_b835: List[FixedPoint],
  list_x569_accum_0: List[StandardInterface],
  list_x570_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x1041_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1041_inr_Foreach_iiCtr"))
  
  abstract class x1041_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x570_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x570_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x569_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x569_accum_0_p").asInstanceOf[MemParams] ))
      val in_b558 = Input(Bool())
      val in_x845_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x845_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b835 = Input(new FixedPoint(true, 32, 0))
      val in_b839 = Input(Bool())
      val in_x850_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x850_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x570_accum_1 = {io.in_x570_accum_1} ; io.in_x570_accum_1 := DontCare
    def x569_accum_0 = {io.in_x569_accum_0} ; io.in_x569_accum_0 := DontCare
    def b558 = {io.in_b558} 
    def x845_tmp_4 = {io.in_x845_tmp_4} ; io.in_x845_tmp_4 := DontCare
    def b835 = {io.in_b835} 
    def b839 = {io.in_b839} 
    def x850_tmp_4 = {io.in_x850_tmp_4} ; io.in_x850_tmp_4 := DontCare
  }
  def connectWires0(module: x1041_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x570_accum_1.connectLedger(module.io.in_x570_accum_1)
    x569_accum_0.connectLedger(module.io.in_x569_accum_0)
    module.io.in_b558 <> b558
    x845_tmp_4.connectLedger(module.io.in_x845_tmp_4)
    module.io.in_b835 <> b835
    module.io.in_b839 <> b839
    x850_tmp_4.connectLedger(module.io.in_x850_tmp_4)
  }
  val b558 = list_b558(0)
  val b839 = list_b558(1)
  val b835 = list_b835(0)
  val x569_accum_0 = list_x569_accum_0(0)
  val x570_accum_1 = list_x570_accum_1(0)
  val x845_tmp_4 = list_x570_accum_1(1)
  val x850_tmp_4 = list_x570_accum_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1041_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1041_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1041_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1041_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1041_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1041_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1041_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1041_instrctr, cycles_x1041_inr_Foreach.io.count, iters_x1041_inr_Foreach.io.count, 0.U, 0.U)
      val b837 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b837.suggestName("b837")
      val b840 = ~io.sigsIn.cchainOutputs.head.oobs(0); b840.suggestName("b840")
      val x1022_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1022_rd""")
      val x1022_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1022_rd_ofs = List[UInt](b837.r)
      val x1022_rd_en = List[Bool](true.B)
      val x1022_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b840 & b558 ).suggestName("x1022_rd_shared_en")
      x1022_rd.toSeq.zip(x845_tmp_4.connectRPort(1022, x1022_rd_banks, x1022_rd_ofs, io.sigsIn.backpressure, x1022_rd_en.map(_ && x1022_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1023 = VecApply(x1022,0)
      val x1023_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1023_elem_0""")
      x1023_elem_0.r := x1022_rd(0).r
      val x1024_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1024_rd""")
      val x1024_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1024_rd_ofs = List[UInt](b837.r)
      val x1024_rd_en = List[Bool](true.B)
      val x1024_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b840 & b558 ).suggestName("x1024_rd_shared_en")
      x1024_rd.toSeq.zip(x850_tmp_4.connectRPort(1024, x1024_rd_banks, x1024_rd_ofs, io.sigsIn.backpressure, x1024_rd_en.map(_ && x1024_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1025 = VecApply(x1024,0)
      val x1025_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1025_elem_0""")
      x1025_elem_0.r := x1024_rd(0).r
      val x3252 = Wire(Bool()).suggestName("x3252_b840_D1") 
      x3252.r := getRetimed(b840.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3253 = Wire(Bool()).suggestName("x3253_b558_D1") 
      x3253.r := getRetimed(b558.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3254 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3254_b837_D1") 
      x3254.r := getRetimed(b837.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1026_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1026_rd""")
      val x1026_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1026_rd_ofs = List[UInt](x3254.r)
      val x1026_rd_en = List[Bool](true.B)
      val x1026_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3252 & x3253 ).suggestName("x1026_rd_shared_en")
      x1026_rd.toSeq.zip(x569_accum_0.connectRPort(1026, x1026_rd_banks, x1026_rd_ofs, io.sigsIn.backpressure, x1026_rd_en.map(_ && x1026_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1027 = VecApply(x1026,0)
      val x1027_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1027_elem_0""")
      x1027_elem_0.r := x1026_rd(0).r
      val x1028 = Wire(Bool()).suggestName("""x1028""")
      x1028 := b840 & b558
      val x1030 = Wire(Bool()).suggestName("""x1030""")
      x1030 := b839 & b558
      val x1032 = Wire(Bool()).suggestName("""x1032""")
      x1032 := x1030 & x1028
      val x1033_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1033_sum""")
      x1033_sum.r := Math.add(x1023_elem_0,x1025_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1033_sum").r
      val x3255 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3255_x1023_elem_0_D1") 
      x3255.r := getRetimed(x1023_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3256 = Wire(Bool()).suggestName("x3256_x1032_D3") 
      x3256.r := getRetimed(x1032.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x1034 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1034""")
      x1034.r := Mux((x3256), x1033_sum.r, x3255.r)
      val x1036 = Wire(Bool()).suggestName("""x1036""")
      x1036.r := Math.eql(b835, 0L.FP(true, 32, 0), Some(0.2), true.B,"x1036").r
      val x1037_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1037_sum""")
      x1037_sum.r := Math.add(x1034,x1027_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1037_sum").r
      val x3257 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3257_x1034_D1") 
      x3257.r := getRetimed(x1034.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3258 = Wire(Bool()).suggestName("x3258_x1036_D4") 
      x3258.r := getRetimed(x1036.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x1038 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1038""")
      x1038.r := Mux((x3258), x3257.r, x1037_sum.r)
      val x3259 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3259_b837_D5") 
      x3259.r := getRetimed(b837.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3260 = Wire(Bool()).suggestName("x3260_b558_D5") 
      x3260.r := getRetimed(b558.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3261 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3261_x1038_D1") 
      x3261.r := getRetimed(x1038.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3262 = Wire(Bool()).suggestName("x3262_b840_D5") 
      x3262.r := getRetimed(b840.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x1039_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1039_wr_ofs = List[UInt](x3259.r)
      val x1039_wr_en = List[Bool](true.B)
      val x1039_wr_data = List[UInt](x3261.r)
      x570_accum_1.connectWPort(1039, x1039_wr_banks, x1039_wr_ofs, x1039_wr_data, x1039_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3262 & x3260))
      val x1040_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1040_wr_ofs = List[UInt](x3259.r)
      val x1040_wr_en = List[Bool](true.B)
      val x1040_wr_data = List[UInt](x3261.r)
      x569_accum_0.connectWPort(1040, x1040_wr_banks, x1040_wr_ofs, x1040_wr_data, x1040_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3262 & x3260))
      x845_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x850_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x1041_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1041_inr_Foreach **/
