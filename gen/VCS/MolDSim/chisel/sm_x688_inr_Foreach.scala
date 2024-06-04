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

/** Hierarchy: x688 -> x689 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x688_inr_Foreach **/
class x688_inr_Foreach_kernel(
  list_b631: List[Bool],
  list_b628: List[FixedPoint],
  list_x638_tmp_0: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x688_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x688_inr_Foreach_iiCtr"))
  
  abstract class x688_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b628 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x638_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x638_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x642_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x642_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b547 = Input(new FixedPoint(true, 32, 0))
      val in_x641_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x641_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b631 = Input(Bool())
      val in_b557 = Input(Bool())
      val in_x640_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x640_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x639_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x639_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b628 = {io.in_b628} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x638_tmp_0 = {io.in_x638_tmp_0} ; io.in_x638_tmp_0 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x642_tmp_4 = {io.in_x642_tmp_4} ; io.in_x642_tmp_4 := DontCare
    def b547 = {io.in_b547} 
    def x641_tmp_3 = {io.in_x641_tmp_3} ; io.in_x641_tmp_3 := DontCare
    def b631 = {io.in_b631} 
    def b557 = {io.in_b557} 
    def x640_tmp_2 = {io.in_x640_tmp_2} ; io.in_x640_tmp_2 := DontCare
    def x639_tmp_1 = {io.in_x639_tmp_1} ; io.in_x639_tmp_1 := DontCare
  }
  def connectWires0(module: x688_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b628 <> b628
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x638_tmp_0.connectLedger(module.io.in_x638_tmp_0)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x642_tmp_4.connectLedger(module.io.in_x642_tmp_4)
    module.io.in_b547 <> b547
    x641_tmp_3.connectLedger(module.io.in_x641_tmp_3)
    module.io.in_b631 <> b631
    module.io.in_b557 <> b557
    x640_tmp_2.connectLedger(module.io.in_x640_tmp_2)
    x639_tmp_1.connectLedger(module.io.in_x639_tmp_1)
  }
  val b631 = list_b631(0)
  val b557 = list_b631(1)
  val b628 = list_b628(0)
  val b547 = list_b628(1)
  val x638_tmp_0 = list_x638_tmp_0(0)
  val x642_tmp_4 = list_x638_tmp_0(1)
  val x641_tmp_3 = list_x638_tmp_0(2)
  val x640_tmp_2 = list_x638_tmp_0(3)
  val x639_tmp_1 = list_x638_tmp_0(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x688_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x688_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x688_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x688_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x688_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x688_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x688_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X688_instrctr, cycles_x688_inr_Foreach.io.count, iters_x688_inr_Foreach.io.count, 0.U, 0.U)
      val b668 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b668.suggestName("b668")
      val b669 = ~io.sigsIn.cchainOutputs.head.oobs(0); b669.suggestName("b669")
      val x674_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x674_rd""")
      val x674_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x674_rd_ofs = List[UInt](0.U)
      val x674_rd_en = List[Bool](true.B)
      val x674_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x674_rd_shared_en")
      x674_rd.toSeq.zip(x471_A_sram_0.connectRPort(674, x674_rd_banks, x674_rd_ofs, io.sigsIn.backpressure, x674_rd_en.map(_ && x674_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x675 = VecApply(x674,0)
      val x675_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x675_elem_0""")
      x675_elem_0.r := x674_rd(0).r
      val x677 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x677""")
      x677.r := Math.arith_right_shift_div(b628, 1, Some(0.2), true.B,"x677").r
      val x2983 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2983""")
      x2983.r := Math.arith_left_shift(x677, 1, Some(0.2), true.B,"x2983").r
      val x2984_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2984_sum""")
      x2984_sum.r := Math.add(x2983,x677,Some(1.0), true.B, Truncate, Wrapping, "x2984_sum").r
      val x3158 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3158_b668_D1") 
      x3158.r := getRetimed(b668.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x679_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x679_sum""")
      x679_sum.r := Math.add(x2984_sum,x3158,Some(1.0), true.B, Truncate, Wrapping, "x679_sum").r
      val x3159 = Wire(Bool()).suggestName("x3159_b669_D2") 
      x3159.r := getRetimed(b669.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x3160 = Wire(Bool()).suggestName("x3160_b631_D2") 
      x3160.r := getRetimed(b631.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x3161 = Wire(Bool()).suggestName("x3161_b557_D2") 
      x3161.r := getRetimed(b557.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x680_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x680_rd""")
      val x680_rd_banks = List[UInt](1L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x680_rd_ofs = List[UInt](x679_sum.r)
      val x680_rd_en = List[Bool](true.B)
      val x680_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && x3159 & x3160 & x3161 ).suggestName("x680_rd_shared_en")
      x680_rd.toSeq.zip(x472_A_sram_1.connectRPort(680, x680_rd_banks, x680_rd_ofs, io.sigsIn.backpressure, x680_rd_en.map(_ && x680_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x681 = VecApply(x680,0)
      val x681_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x681_elem_0""")
      x681_elem_0.r := x680_rd(0).r
      val x3162 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3162_x681_elem_0_D20") 
      x3162.r := getRetimed(x681_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x682_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x682_sub""")
      x682_sub.r := Math.sub(x675_elem_0,x3162,Some(1.0), true.B, Truncate, Wrapping, "x682_sub").r
      val x3163 = Wire(Bool()).suggestName("x3163_b669_D25") 
      x3163.r := getRetimed(b669.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3164 = Wire(Bool()).suggestName("x3164_b631_D25") 
      x3164.r := getRetimed(b631.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3165 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3165_b668_D25") 
      x3165.r := getRetimed(b668.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3166 = Wire(Bool()).suggestName("x3166_b557_D25") 
      x3166.r := getRetimed(b557.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x683_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x683_wr_ofs = List[UInt](x3165.r)
      val x683_wr_en = List[Bool](true.B)
      val x683_wr_data = List[UInt](x682_sub.r)
      x638_tmp_0.connectWPort(683, x683_wr_banks, x683_wr_ofs, x683_wr_data, x683_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3163 & x3164 & x3166))
      val x684_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x684_wr_ofs = List[UInt](x3165.r)
      val x684_wr_en = List[Bool](true.B)
      val x684_wr_data = List[UInt](x682_sub.r)
      x642_tmp_4.connectWPort(684, x684_wr_banks, x684_wr_ofs, x684_wr_data, x684_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3163 & x3164 & x3166))
      val x685_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x685_wr_ofs = List[UInt](x3165.r)
      val x685_wr_en = List[Bool](true.B)
      val x685_wr_data = List[UInt](x682_sub.r)
      x641_tmp_3.connectWPort(685, x685_wr_banks, x685_wr_ofs, x685_wr_data, x685_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3163 & x3164 & x3166))
      val x686_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x686_wr_ofs = List[UInt](x3165.r)
      val x686_wr_en = List[Bool](true.B)
      val x686_wr_data = List[UInt](x682_sub.r)
      x640_tmp_2.connectWPort(686, x686_wr_banks, x686_wr_ofs, x686_wr_data, x686_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3163 & x3164 & x3166))
      val x687_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x687_wr_ofs = List[UInt](x3165.r)
      val x687_wr_en = List[Bool](true.B)
      val x687_wr_data = List[UInt](x682_sub.r)
      x639_tmp_1.connectWPort(687, x687_wr_banks, x687_wr_ofs, x687_wr_data, x687_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3163 & x3164 & x3166))
    }
    val module = Module(new x688_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x688_inr_Foreach **/
