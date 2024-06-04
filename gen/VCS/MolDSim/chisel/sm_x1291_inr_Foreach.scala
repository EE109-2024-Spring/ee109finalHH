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

/** Hierarchy: x1291 -> x1313 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1291_inr_Foreach **/
class x1291_inr_Foreach_kernel(
  list_b1254: List[Bool],
  list_b550: List[FixedPoint],
  list_x1260_tmp_3: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1291_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1291_inr_Foreach_iiCtr"))
  
  abstract class x1291_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1260_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1260_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b1254 = Input(Bool())
      val in_x1259_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1259_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b1251 = Input(new FixedPoint(true, 32, 0))
      val in_x1258_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1258_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1257_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1257_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1261_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1261_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b550 = {io.in_b550} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1260_tmp_3 = {io.in_x1260_tmp_3} ; io.in_x1260_tmp_3 := DontCare
    def b1254 = {io.in_b1254} 
    def x1259_tmp_2 = {io.in_x1259_tmp_2} ; io.in_x1259_tmp_2 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b1251 = {io.in_b1251} 
    def x1258_tmp_1 = {io.in_x1258_tmp_1} ; io.in_x1258_tmp_1 := DontCare
    def x1257_tmp_0 = {io.in_x1257_tmp_0} ; io.in_x1257_tmp_0 := DontCare
    def x1261_tmp_4 = {io.in_x1261_tmp_4} ; io.in_x1261_tmp_4 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1291_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b550 <> b550
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1260_tmp_3.connectLedger(module.io.in_x1260_tmp_3)
    module.io.in_b1254 <> b1254
    x1259_tmp_2.connectLedger(module.io.in_x1259_tmp_2)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b1251 <> b1251
    x1258_tmp_1.connectLedger(module.io.in_x1258_tmp_1)
    x1257_tmp_0.connectLedger(module.io.in_x1257_tmp_0)
    x1261_tmp_4.connectLedger(module.io.in_x1261_tmp_4)
    module.io.in_b560 <> b560
  }
  val b1254 = list_b1254(0)
  val b560 = list_b1254(1)
  val b550 = list_b550(0)
  val b1251 = list_b550(1)
  val x1260_tmp_3 = list_x1260_tmp_3(0)
  val x1259_tmp_2 = list_x1260_tmp_3(1)
  val x1258_tmp_1 = list_x1260_tmp_3(2)
  val x1257_tmp_0 = list_x1260_tmp_3(3)
  val x1261_tmp_4 = list_x1260_tmp_3(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1291_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1291_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1291_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1291_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1291_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1291_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1291_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1291_instrctr, cycles_x1291_inr_Foreach.io.count, iters_x1291_inr_Foreach.io.count, 0.U, 0.U)
      val b1271 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1271.suggestName("b1271")
      val b1272 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1272.suggestName("b1272")
      val x1274_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1274_div""")
      x1274_div.r := (Math.div(b550, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x1274_div")).r
      val x3013 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3013""")
      x3013.r := Math.arith_left_shift(x1274_div, 1, Some(0.2), true.B,"x3013").r
      val x3014_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3014_sum""")
      x3014_sum.r := Math.add(x3013,x1274_div,Some(1.0), true.B, Truncate, Wrapping, "x3014_sum").r
      val x3324 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3324_b1271_D21") 
      x3324.r := getRetimed(b1271.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x1276_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1276_sum""")
      x1276_sum.r := Math.add(x3014_sum,x3324,Some(1.0), true.B, Truncate, Wrapping, "x1276_sum").r
      val x3325 = Wire(Bool()).suggestName("x3325_b1254_D22") 
      x3325.r := getRetimed(b1254.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3326 = Wire(Bool()).suggestName("x3326_b1272_D22") 
      x3326.r := getRetimed(b1272.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3327 = Wire(Bool()).suggestName("x3327_b560_D22") 
      x3327.r := getRetimed(b560.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x1277_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1277_rd""")
      val x1277_rd_banks = List[UInt](3L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x1277_rd_ofs = List[UInt](x1276_sum.r)
      val x1277_rd_en = List[Bool](true.B)
      val x1277_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3326 & x3325 & x3327 ).suggestName("x1277_rd_shared_en")
      x1277_rd.toSeq.zip(x471_A_sram_0.connectRPort(1277, x1277_rd_banks, x1277_rd_ofs, io.sigsIn.backpressure, x1277_rd_en.map(_ && x1277_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1278 = VecApply(x1277,0)
      val x1278_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1278_elem_0""")
      x1278_elem_0.r := x1277_rd(0).r
      val x1283_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1283_rd""")
      val x1283_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x1283_rd_ofs = List[UInt](0.U)
      val x1283_rd_en = List[Bool](true.B)
      val x1283_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1283_rd_shared_en")
      x1283_rd.toSeq.zip(x472_A_sram_1.connectRPort(1283, x1283_rd_banks, x1283_rd_ofs, io.sigsIn.backpressure, x1283_rd_en.map(_ && x1283_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1284 = VecApply(x1283,0)
      val x1284_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1284_elem_0""")
      x1284_elem_0.r := x1283_rd(0).r
      val x3332 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3332_x1284_elem_0_D20") 
      x3332.r := getRetimed(x1284_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1285_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1285_sub""")
      x1285_sub.r := Math.sub(x1278_elem_0,x3332,Some(1.0), true.B, Truncate, Wrapping, "x1285_sub").r
      val x3333 = Wire(Bool()).suggestName("x3333_b1254_D25") 
      x3333.r := getRetimed(b1254.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3334 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3334_b1271_D25") 
      x3334.r := getRetimed(b1271.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3335 = Wire(Bool()).suggestName("x3335_b1272_D25") 
      x3335.r := getRetimed(b1272.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3336 = Wire(Bool()).suggestName("x3336_b560_D25") 
      x3336.r := getRetimed(b560.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1286_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1286_wr_ofs = List[UInt](x3334.r)
      val x1286_wr_en = List[Bool](true.B)
      val x1286_wr_data = List[UInt](x1285_sub.r)
      x1260_tmp_3.connectWPort(1286, x1286_wr_banks, x1286_wr_ofs, x1286_wr_data, x1286_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3335 & x3333 & x3336))
      val x1287_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1287_wr_ofs = List[UInt](x3334.r)
      val x1287_wr_en = List[Bool](true.B)
      val x1287_wr_data = List[UInt](x1285_sub.r)
      x1259_tmp_2.connectWPort(1287, x1287_wr_banks, x1287_wr_ofs, x1287_wr_data, x1287_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3335 & x3333 & x3336))
      val x1288_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1288_wr_ofs = List[UInt](x3334.r)
      val x1288_wr_en = List[Bool](true.B)
      val x1288_wr_data = List[UInt](x1285_sub.r)
      x1258_tmp_1.connectWPort(1288, x1288_wr_banks, x1288_wr_ofs, x1288_wr_data, x1288_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3335 & x3333 & x3336))
      val x1289_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1289_wr_ofs = List[UInt](x3334.r)
      val x1289_wr_en = List[Bool](true.B)
      val x1289_wr_data = List[UInt](x1285_sub.r)
      x1257_tmp_0.connectWPort(1289, x1289_wr_banks, x1289_wr_ofs, x1289_wr_data, x1289_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3335 & x3333 & x3336))
      val x1290_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1290_wr_ofs = List[UInt](x3334.r)
      val x1290_wr_en = List[Bool](true.B)
      val x1290_wr_data = List[UInt](x1285_sub.r)
      x1261_tmp_4.connectWPort(1290, x1290_wr_banks, x1290_wr_ofs, x1290_wr_data, x1290_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3335 & x3333 & x3336))
    }
    val module = Module(new x1291_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1291_inr_Foreach **/
