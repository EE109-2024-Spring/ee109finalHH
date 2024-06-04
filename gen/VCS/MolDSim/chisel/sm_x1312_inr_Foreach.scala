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

/** Hierarchy: x1312 -> x1313 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1312_inr_Foreach **/
class x1312_inr_Foreach_kernel(
  list_b1255: List[Bool],
  list_b550: List[FixedPoint],
  list_x1265_tmp_3: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1312_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1312_inr_Foreach_iiCtr"))
  
  abstract class x1312_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1265_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1265_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1264_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1264_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1255 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1263_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1263_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1266_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1266_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1252 = Input(new FixedPoint(true, 32, 0))
      val in_x1262_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1262_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b550 = {io.in_b550} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1265_tmp_3 = {io.in_x1265_tmp_3} ; io.in_x1265_tmp_3 := DontCare
    def x1264_tmp_2 = {io.in_x1264_tmp_2} ; io.in_x1264_tmp_2 := DontCare
    def b1255 = {io.in_b1255} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1263_tmp_1 = {io.in_x1263_tmp_1} ; io.in_x1263_tmp_1 := DontCare
    def x1266_tmp_4 = {io.in_x1266_tmp_4} ; io.in_x1266_tmp_4 := DontCare
    def b1252 = {io.in_b1252} 
    def x1262_tmp_0 = {io.in_x1262_tmp_0} ; io.in_x1262_tmp_0 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1312_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b550 <> b550
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1265_tmp_3.connectLedger(module.io.in_x1265_tmp_3)
    x1264_tmp_2.connectLedger(module.io.in_x1264_tmp_2)
    module.io.in_b1255 <> b1255
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1263_tmp_1.connectLedger(module.io.in_x1263_tmp_1)
    x1266_tmp_4.connectLedger(module.io.in_x1266_tmp_4)
    module.io.in_b1252 <> b1252
    x1262_tmp_0.connectLedger(module.io.in_x1262_tmp_0)
    module.io.in_b560 <> b560
  }
  val b1255 = list_b1255(0)
  val b560 = list_b1255(1)
  val b550 = list_b550(0)
  val b1252 = list_b550(1)
  val x1265_tmp_3 = list_x1265_tmp_3(0)
  val x1264_tmp_2 = list_x1265_tmp_3(1)
  val x1263_tmp_1 = list_x1265_tmp_3(2)
  val x1266_tmp_4 = list_x1265_tmp_3(3)
  val x1262_tmp_0 = list_x1265_tmp_3(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1312_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1312_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1312_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1312_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1312_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1312_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1312_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1312_instrctr, cycles_x1312_inr_Foreach.io.count, iters_x1312_inr_Foreach.io.count, 0.U, 0.U)
      val b1292 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1292.suggestName("b1292")
      val b1293 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1293.suggestName("b1293")
      val x1298_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1298_rd""")
      val x1298_rd_banks = List[UInt](0.U,0.U)
      val x1298_rd_ofs = List[UInt](0.U)
      val x1298_rd_en = List[Bool](true.B)
      val x1298_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1298_rd_shared_en")
      x1298_rd.toSeq.zip(x471_A_sram_0.connectRPort(1298, x1298_rd_banks, x1298_rd_ofs, io.sigsIn.backpressure, x1298_rd_en.map(_ && x1298_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1299 = VecApply(x1298,0)
      val x1299_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1299_elem_0""")
      x1299_elem_0.r := x1298_rd(0).r
      val x1304_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1304_rd""")
      val x1304_rd_banks = List[UInt](0.U,0.U)
      val x1304_rd_ofs = List[UInt](0.U)
      val x1304_rd_en = List[Bool](true.B)
      val x1304_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1304_rd_shared_en")
      x1304_rd.toSeq.zip(x472_A_sram_1.connectRPort(1304, x1304_rd_banks, x1304_rd_ofs, io.sigsIn.backpressure, x1304_rd_en.map(_ && x1304_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1305 = VecApply(x1304,0)
      val x1305_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1305_elem_0""")
      x1305_elem_0.r := x1304_rd(0).r
      val x3345 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3345_x1305_elem_0_D20") 
      x3345.r := getRetimed(x1305_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1306_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1306_sub""")
      x1306_sub.r := Math.sub(x1299_elem_0,x3345,Some(1.0), true.B, Truncate, Wrapping, "x1306_sub").r
      val x3346 = Wire(Bool()).suggestName("x3346_b1255_D25") 
      x3346.r := getRetimed(b1255.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3347 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3347_b1292_D25") 
      x3347.r := getRetimed(b1292.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3348 = Wire(Bool()).suggestName("x3348_b1293_D25") 
      x3348.r := getRetimed(b1293.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3349 = Wire(Bool()).suggestName("x3349_b560_D25") 
      x3349.r := getRetimed(b560.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1307_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1307_wr_ofs = List[UInt](x3347.r)
      val x1307_wr_en = List[Bool](true.B)
      val x1307_wr_data = List[UInt](x1306_sub.r)
      x1265_tmp_3.connectWPort(1307, x1307_wr_banks, x1307_wr_ofs, x1307_wr_data, x1307_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3348 & x3346 & x3349))
      val x1308_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1308_wr_ofs = List[UInt](x3347.r)
      val x1308_wr_en = List[Bool](true.B)
      val x1308_wr_data = List[UInt](x1306_sub.r)
      x1264_tmp_2.connectWPort(1308, x1308_wr_banks, x1308_wr_ofs, x1308_wr_data, x1308_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3348 & x3346 & x3349))
      val x1309_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1309_wr_ofs = List[UInt](x3347.r)
      val x1309_wr_en = List[Bool](true.B)
      val x1309_wr_data = List[UInt](x1306_sub.r)
      x1263_tmp_1.connectWPort(1309, x1309_wr_banks, x1309_wr_ofs, x1309_wr_data, x1309_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3348 & x3346 & x3349))
      val x1310_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1310_wr_ofs = List[UInt](x3347.r)
      val x1310_wr_en = List[Bool](true.B)
      val x1310_wr_data = List[UInt](x1306_sub.r)
      x1266_tmp_4.connectWPort(1310, x1310_wr_banks, x1310_wr_ofs, x1310_wr_data, x1310_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3348 & x3346 & x3349))
      val x1311_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1311_wr_ofs = List[UInt](x3347.r)
      val x1311_wr_en = List[Bool](true.B)
      val x1311_wr_data = List[UInt](x1306_sub.r)
      x1262_tmp_0.connectWPort(1311, x1311_wr_banks, x1311_wr_ofs, x1311_wr_data, x1311_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3348 & x3346 & x3349))
    }
    val module = Module(new x1312_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1312_inr_Foreach **/
