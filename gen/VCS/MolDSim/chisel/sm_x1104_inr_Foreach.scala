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

/** Hierarchy: x1104 -> x1105 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1104_inr_Foreach **/
class x1104_inr_Foreach_kernel(
  list_b559: List[Bool],
  list_b1044: List[FixedPoint],
  list_x1055_tmp_1: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1104_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1104_inr_Foreach_iiCtr"))
  
  abstract class x1104_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1055_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1055_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b559 = Input(Bool())
      val in_b1047 = Input(Bool())
      val in_x1057_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1057_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1054_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1054_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1058_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1058_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1044 = Input(new FixedPoint(true, 32, 0))
      val in_b549 = Input(new FixedPoint(true, 32, 0))
      val in_x1056_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1056_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1055_tmp_1 = {io.in_x1055_tmp_1} ; io.in_x1055_tmp_1 := DontCare
    def b559 = {io.in_b559} 
    def b1047 = {io.in_b1047} 
    def x1057_tmp_3 = {io.in_x1057_tmp_3} ; io.in_x1057_tmp_3 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1054_tmp_0 = {io.in_x1054_tmp_0} ; io.in_x1054_tmp_0 := DontCare
    def x1058_tmp_4 = {io.in_x1058_tmp_4} ; io.in_x1058_tmp_4 := DontCare
    def b1044 = {io.in_b1044} 
    def b549 = {io.in_b549} 
    def x1056_tmp_2 = {io.in_x1056_tmp_2} ; io.in_x1056_tmp_2 := DontCare
  }
  def connectWires0(module: x1104_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1055_tmp_1.connectLedger(module.io.in_x1055_tmp_1)
    module.io.in_b559 <> b559
    module.io.in_b1047 <> b1047
    x1057_tmp_3.connectLedger(module.io.in_x1057_tmp_3)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1054_tmp_0.connectLedger(module.io.in_x1054_tmp_0)
    x1058_tmp_4.connectLedger(module.io.in_x1058_tmp_4)
    module.io.in_b1044 <> b1044
    module.io.in_b549 <> b549
    x1056_tmp_2.connectLedger(module.io.in_x1056_tmp_2)
  }
  val b559 = list_b559(0)
  val b1047 = list_b559(1)
  val b1044 = list_b1044(0)
  val b549 = list_b1044(1)
  val x1055_tmp_1 = list_x1055_tmp_1(0)
  val x1057_tmp_3 = list_x1055_tmp_1(1)
  val x1054_tmp_0 = list_x1055_tmp_1(2)
  val x1058_tmp_4 = list_x1055_tmp_1(3)
  val x1056_tmp_2 = list_x1055_tmp_1(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1104_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1104_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1104_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1104_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1104_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1104_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1104_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1104_instrctr, cycles_x1104_inr_Foreach.io.count, iters_x1104_inr_Foreach.io.count, 0.U, 0.U)
      val b1084 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1084.suggestName("b1084")
      val b1085 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1085.suggestName("b1085")
      val x1090_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1090_rd""")
      val x1090_rd_banks = List[UInt](0.U,0.U)
      val x1090_rd_ofs = List[UInt](0.U)
      val x1090_rd_en = List[Bool](true.B)
      val x1090_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1090_rd_shared_en")
      x1090_rd.toSeq.zip(x471_A_sram_0.connectRPort(1090, x1090_rd_banks, x1090_rd_ofs, io.sigsIn.backpressure, x1090_rd_en.map(_ && x1090_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1091 = VecApply(x1090,0)
      val x1091_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1091_elem_0""")
      x1091_elem_0.r := x1090_rd(0).r
      val x1096_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1096_rd""")
      val x1096_rd_banks = List[UInt](0.U,0.U)
      val x1096_rd_ofs = List[UInt](0.U)
      val x1096_rd_en = List[Bool](true.B)
      val x1096_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1096_rd_shared_en")
      x1096_rd.toSeq.zip(x472_A_sram_1.connectRPort(1096, x1096_rd_banks, x1096_rd_ofs, io.sigsIn.backpressure, x1096_rd_en.map(_ && x1096_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1097 = VecApply(x1096,0)
      val x1097_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1097_elem_0""")
      x1097_elem_0.r := x1096_rd(0).r
      val x3284 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3284_x1097_elem_0_D20") 
      x3284.r := getRetimed(x1097_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1098_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1098_sub""")
      x1098_sub.r := Math.sub(x1091_elem_0,x3284,Some(1.0), true.B, Truncate, Wrapping, "x1098_sub").r
      val x3285 = Wire(Bool()).suggestName("x3285_b559_D25") 
      x3285.r := getRetimed(b559.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3286 = Wire(Bool()).suggestName("x3286_b1047_D25") 
      x3286.r := getRetimed(b1047.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3287 = Wire(Bool()).suggestName("x3287_b1085_D25") 
      x3287.r := getRetimed(b1085.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3288 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3288_b1084_D25") 
      x3288.r := getRetimed(b1084.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1099_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1099_wr_ofs = List[UInt](x3288.r)
      val x1099_wr_en = List[Bool](true.B)
      val x1099_wr_data = List[UInt](x1098_sub.r)
      x1055_tmp_1.connectWPort(1099, x1099_wr_banks, x1099_wr_ofs, x1099_wr_data, x1099_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3287 & x3286 & x3285))
      val x1100_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1100_wr_ofs = List[UInt](x3288.r)
      val x1100_wr_en = List[Bool](true.B)
      val x1100_wr_data = List[UInt](x1098_sub.r)
      x1057_tmp_3.connectWPort(1100, x1100_wr_banks, x1100_wr_ofs, x1100_wr_data, x1100_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3287 & x3286 & x3285))
      val x1101_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1101_wr_ofs = List[UInt](x3288.r)
      val x1101_wr_en = List[Bool](true.B)
      val x1101_wr_data = List[UInt](x1098_sub.r)
      x1054_tmp_0.connectWPort(1101, x1101_wr_banks, x1101_wr_ofs, x1101_wr_data, x1101_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3287 & x3286 & x3285))
      val x1102_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1102_wr_ofs = List[UInt](x3288.r)
      val x1102_wr_en = List[Bool](true.B)
      val x1102_wr_data = List[UInt](x1098_sub.r)
      x1058_tmp_4.connectWPort(1102, x1102_wr_banks, x1102_wr_ofs, x1102_wr_data, x1102_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3287 & x3286 & x3285))
      val x1103_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1103_wr_ofs = List[UInt](x3288.r)
      val x1103_wr_en = List[Bool](true.B)
      val x1103_wr_data = List[UInt](x1098_sub.r)
      x1056_tmp_2.connectWPort(1103, x1103_wr_banks, x1103_wr_ofs, x1103_wr_data, x1103_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3287 & x3286 & x3285))
    }
    val module = Module(new x1104_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1104_inr_Foreach **/
