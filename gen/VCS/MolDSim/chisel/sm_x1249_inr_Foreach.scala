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

/** Hierarchy: x1249 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1249_inr_Foreach **/
class x1249_inr_Foreach_kernel(
  list_b559: List[Bool],
  list_b1043: List[FixedPoint],
  list_x571_accum_0: List[StandardInterface],
  list_x572_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x1249_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1249_inr_Foreach_iiCtr"))
  
  abstract class x1249_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b559 = Input(Bool())
      val in_b1047 = Input(Bool())
      val in_x572_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x572_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x1058_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1058_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1043 = Input(new FixedPoint(true, 32, 0))
      val in_x1053_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1053_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x571_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x571_accum_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b559 = {io.in_b559} 
    def b1047 = {io.in_b1047} 
    def x572_accum_1 = {io.in_x572_accum_1} ; io.in_x572_accum_1 := DontCare
    def x1058_tmp_4 = {io.in_x1058_tmp_4} ; io.in_x1058_tmp_4 := DontCare
    def b1043 = {io.in_b1043} 
    def x1053_tmp_4 = {io.in_x1053_tmp_4} ; io.in_x1053_tmp_4 := DontCare
    def x571_accum_0 = {io.in_x571_accum_0} ; io.in_x571_accum_0 := DontCare
  }
  def connectWires0(module: x1249_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b559 <> b559
    module.io.in_b1047 <> b1047
    x572_accum_1.connectLedger(module.io.in_x572_accum_1)
    x1058_tmp_4.connectLedger(module.io.in_x1058_tmp_4)
    module.io.in_b1043 <> b1043
    x1053_tmp_4.connectLedger(module.io.in_x1053_tmp_4)
    x571_accum_0.connectLedger(module.io.in_x571_accum_0)
  }
  val b559 = list_b559(0)
  val b1047 = list_b559(1)
  val b1043 = list_b1043(0)
  val x571_accum_0 = list_x571_accum_0(0)
  val x572_accum_1 = list_x572_accum_1(0)
  val x1058_tmp_4 = list_x572_accum_1(1)
  val x1053_tmp_4 = list_x572_accum_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1249_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1249_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1249_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1249_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1249_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1249_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1249_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1249_instrctr, cycles_x1249_inr_Foreach.io.count, iters_x1249_inr_Foreach.io.count, 0.U, 0.U)
      val b1045 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1045.suggestName("b1045")
      val b1048 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1048.suggestName("b1048")
      val x1230_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1230_rd""")
      val x1230_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1230_rd_ofs = List[UInt](b1045.r)
      val x1230_rd_en = List[Bool](true.B)
      val x1230_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1048 & b559 ).suggestName("x1230_rd_shared_en")
      x1230_rd.toSeq.zip(x1053_tmp_4.connectRPort(1230, x1230_rd_banks, x1230_rd_ofs, io.sigsIn.backpressure, x1230_rd_en.map(_ && x1230_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1231 = VecApply(x1230,0)
      val x1231_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1231_elem_0""")
      x1231_elem_0.r := x1230_rd(0).r
      val x1232_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1232_rd""")
      val x1232_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1232_rd_ofs = List[UInt](b1045.r)
      val x1232_rd_en = List[Bool](true.B)
      val x1232_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1048 & b559 ).suggestName("x1232_rd_shared_en")
      x1232_rd.toSeq.zip(x1058_tmp_4.connectRPort(1232, x1232_rd_banks, x1232_rd_ofs, io.sigsIn.backpressure, x1232_rd_en.map(_ && x1232_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1233 = VecApply(x1232,0)
      val x1233_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1233_elem_0""")
      x1233_elem_0.r := x1232_rd(0).r
      val x3313 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3313_b1045_D1") 
      x3313.r := getRetimed(b1045.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3314 = Wire(Bool()).suggestName("x3314_b1048_D1") 
      x3314.r := getRetimed(b1048.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3315 = Wire(Bool()).suggestName("x3315_b559_D1") 
      x3315.r := getRetimed(b559.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1234_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1234_rd""")
      val x1234_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1234_rd_ofs = List[UInt](x3313.r)
      val x1234_rd_en = List[Bool](true.B)
      val x1234_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3314 & x3315 ).suggestName("x1234_rd_shared_en")
      x1234_rd.toSeq.zip(x571_accum_0.connectRPort(1234, x1234_rd_banks, x1234_rd_ofs, io.sigsIn.backpressure, x1234_rd_en.map(_ && x1234_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1235 = VecApply(x1234,0)
      val x1235_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1235_elem_0""")
      x1235_elem_0.r := x1234_rd(0).r
      val x1236 = Wire(Bool()).suggestName("""x1236""")
      x1236 := b1048 & b559
      val x1238 = Wire(Bool()).suggestName("""x1238""")
      x1238 := b1047 & b559
      val x1240 = Wire(Bool()).suggestName("""x1240""")
      x1240 := x1238 & x1236
      val x1241_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1241_sum""")
      x1241_sum.r := Math.add(x1231_elem_0,x1233_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1241_sum").r
      val x3316 = Wire(Bool()).suggestName("x3316_x1240_D3") 
      x3316.r := getRetimed(x1240.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3317 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3317_x1231_elem_0_D1") 
      x3317.r := getRetimed(x1231_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1242 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1242""")
      x1242.r := Mux((x3316), x1241_sum.r, x3317.r)
      val x1244 = Wire(Bool()).suggestName("""x1244""")
      x1244.r := Math.eql(b1043, 0L.FP(true, 32, 0), Some(0.2), true.B,"x1244").r
      val x1245_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1245_sum""")
      x1245_sum.r := Math.add(x1242,x1235_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1245_sum").r
      val x3318 = Wire(Bool()).suggestName("x3318_x1244_D4") 
      x3318.r := getRetimed(x1244.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x3319 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3319_x1242_D1") 
      x3319.r := getRetimed(x1242.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1246 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1246""")
      x1246.r := Mux((x3318), x3319.r, x1245_sum.r)
      val x3320 = Wire(Bool()).suggestName("x3320_b559_D5") 
      x3320.r := getRetimed(b559.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3321 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3321_x1246_D1") 
      x3321.r := getRetimed(x1246.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3322 = Wire(Bool()).suggestName("x3322_b1048_D5") 
      x3322.r := getRetimed(b1048.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3323 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3323_b1045_D5") 
      x3323.r := getRetimed(b1045.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x1247_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1247_wr_ofs = List[UInt](x3323.r)
      val x1247_wr_en = List[Bool](true.B)
      val x1247_wr_data = List[UInt](x3321.r)
      x572_accum_1.connectWPort(1247, x1247_wr_banks, x1247_wr_ofs, x1247_wr_data, x1247_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3322 & x3320))
      val x1248_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1248_wr_ofs = List[UInt](x3323.r)
      val x1248_wr_en = List[Bool](true.B)
      val x1248_wr_data = List[UInt](x3321.r)
      x571_accum_0.connectWPort(1248, x1248_wr_banks, x1248_wr_ofs, x1248_wr_data, x1248_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3322 & x3320))
      x1053_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x1058_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x1249_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1249_inr_Foreach **/
