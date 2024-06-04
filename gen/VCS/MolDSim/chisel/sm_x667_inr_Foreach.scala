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

/** Hierarchy: x667 -> x689 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x667_inr_Foreach **/
class x667_inr_Foreach_kernel(
  list_b630: List[Bool],
  list_b547: List[FixedPoint],
  list_x634_tmp_1: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x667_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x667_inr_Foreach_iiCtr"))
  
  abstract class x667_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x634_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x634_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b630 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x637_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x637_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b547 = Input(new FixedPoint(true, 32, 0))
      val in_x633_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x633_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x636_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x636_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b557 = Input(Bool())
      val in_b627 = Input(new FixedPoint(true, 32, 0))
      val in_x635_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x635_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x634_tmp_1 = {io.in_x634_tmp_1} ; io.in_x634_tmp_1 := DontCare
    def b630 = {io.in_b630} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x637_tmp_4 = {io.in_x637_tmp_4} ; io.in_x637_tmp_4 := DontCare
    def b547 = {io.in_b547} 
    def x633_tmp_0 = {io.in_x633_tmp_0} ; io.in_x633_tmp_0 := DontCare
    def x636_tmp_3 = {io.in_x636_tmp_3} ; io.in_x636_tmp_3 := DontCare
    def b557 = {io.in_b557} 
    def b627 = {io.in_b627} 
    def x635_tmp_2 = {io.in_x635_tmp_2} ; io.in_x635_tmp_2 := DontCare
  }
  def connectWires0(module: x667_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x634_tmp_1.connectLedger(module.io.in_x634_tmp_1)
    module.io.in_b630 <> b630
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x637_tmp_4.connectLedger(module.io.in_x637_tmp_4)
    module.io.in_b547 <> b547
    x633_tmp_0.connectLedger(module.io.in_x633_tmp_0)
    x636_tmp_3.connectLedger(module.io.in_x636_tmp_3)
    module.io.in_b557 <> b557
    module.io.in_b627 <> b627
    x635_tmp_2.connectLedger(module.io.in_x635_tmp_2)
  }
  val b630 = list_b630(0)
  val b557 = list_b630(1)
  val b547 = list_b547(0)
  val b627 = list_b547(1)
  val x634_tmp_1 = list_x634_tmp_1(0)
  val x637_tmp_4 = list_x634_tmp_1(1)
  val x633_tmp_0 = list_x634_tmp_1(2)
  val x636_tmp_3 = list_x634_tmp_1(3)
  val x635_tmp_2 = list_x634_tmp_1(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x667_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x667_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x667_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x667_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x667_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x667_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x667_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X667_instrctr, cycles_x667_inr_Foreach.io.count, iters_x667_inr_Foreach.io.count, 0.U, 0.U)
      val b647 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b647.suggestName("b647")
      val b648 = ~io.sigsIn.cchainOutputs.head.oobs(0); b648.suggestName("b648")
      val x650_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x650_div""")
      x650_div.r := (Math.div(b547, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x650_div")).r
      val x2977 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2977""")
      x2977.r := Math.arith_left_shift(x650_div, 1, Some(0.2), true.B,"x2977").r
      val x2978_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2978_sum""")
      x2978_sum.r := Math.add(x2977,x650_div,Some(1.0), true.B, Truncate, Wrapping, "x2978_sum").r
      val x3141 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3141_b647_D21") 
      x3141.r := getRetimed(b647.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x652_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x652_sum""")
      x652_sum.r := Math.add(x2978_sum,x3141,Some(1.0), true.B, Truncate, Wrapping, "x652_sum").r
      val x3142 = Wire(Bool()).suggestName("x3142_b557_D22") 
      x3142.r := getRetimed(b557.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3143 = Wire(Bool()).suggestName("x3143_b648_D22") 
      x3143.r := getRetimed(b648.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3144 = Wire(Bool()).suggestName("x3144_b630_D22") 
      x3144.r := getRetimed(b630.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x653_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x653_rd""")
      val x653_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x653_rd_ofs = List[UInt](x652_sum.r)
      val x653_rd_en = List[Bool](true.B)
      val x653_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3143 & x3144 & x3142 ).suggestName("x653_rd_shared_en")
      x653_rd.toSeq.zip(x471_A_sram_0.connectRPort(653, x653_rd_banks, x653_rd_ofs, io.sigsIn.backpressure, x653_rd_en.map(_ && x653_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x654 = VecApply(x653,0)
      val x654_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x654_elem_0""")
      x654_elem_0.r := x653_rd(0).r
      val x656 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x656""")
      x656.r := Math.arith_right_shift_div(b627, 1, Some(0.2), true.B,"x656").r
      val x2979 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2979""")
      x2979.r := Math.arith_left_shift(x656, 1, Some(0.2), true.B,"x2979").r
      val x2980_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2980_sum""")
      x2980_sum.r := Math.add(x2979,x656,Some(1.0), true.B, Truncate, Wrapping, "x2980_sum").r
      val x3145 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3145_b647_D1") 
      x3145.r := getRetimed(b647.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x658_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x658_sum""")
      x658_sum.r := Math.add(x2980_sum,x3145,Some(1.0), true.B, Truncate, Wrapping, "x658_sum").r
      val x3146 = Wire(Bool()).suggestName("x3146_b557_D2") 
      x3146.r := getRetimed(b557.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x3147 = Wire(Bool()).suggestName("x3147_b648_D2") 
      x3147.r := getRetimed(b648.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x3148 = Wire(Bool()).suggestName("x3148_b630_D2") 
      x3148.r := getRetimed(b630.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x659_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x659_rd""")
      val x659_rd_banks = List[UInt](0L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x659_rd_ofs = List[UInt](x658_sum.r)
      val x659_rd_en = List[Bool](true.B)
      val x659_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && x3147 & x3148 & x3146 ).suggestName("x659_rd_shared_en")
      x659_rd.toSeq.zip(x472_A_sram_1.connectRPort(659, x659_rd_banks, x659_rd_ofs, io.sigsIn.backpressure, x659_rd_en.map(_ && x659_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x660 = VecApply(x659,0)
      val x660_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x660_elem_0""")
      x660_elem_0.r := x659_rd(0).r
      val x3149 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3149_x660_elem_0_D20") 
      x3149.r := getRetimed(x660_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x661_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x661_sub""")
      x661_sub.r := Math.sub(x654_elem_0,x3149,Some(1.0), true.B, Truncate, Wrapping, "x661_sub").r
      val x3150 = Wire(Bool()).suggestName("x3150_b630_D25") 
      x3150.r := getRetimed(b630.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3151 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3151_b647_D25") 
      x3151.r := getRetimed(b647.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3152 = Wire(Bool()).suggestName("x3152_b648_D25") 
      x3152.r := getRetimed(b648.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3153 = Wire(Bool()).suggestName("x3153_b557_D25") 
      x3153.r := getRetimed(b557.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x662_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x662_wr_ofs = List[UInt](x3151.r)
      val x662_wr_en = List[Bool](true.B)
      val x662_wr_data = List[UInt](x661_sub.r)
      x634_tmp_1.connectWPort(662, x662_wr_banks, x662_wr_ofs, x662_wr_data, x662_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3152 & x3150 & x3153))
      val x663_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x663_wr_ofs = List[UInt](x3151.r)
      val x663_wr_en = List[Bool](true.B)
      val x663_wr_data = List[UInt](x661_sub.r)
      x637_tmp_4.connectWPort(663, x663_wr_banks, x663_wr_ofs, x663_wr_data, x663_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3152 & x3150 & x3153))
      val x664_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x664_wr_ofs = List[UInt](x3151.r)
      val x664_wr_en = List[Bool](true.B)
      val x664_wr_data = List[UInt](x661_sub.r)
      x633_tmp_0.connectWPort(664, x664_wr_banks, x664_wr_ofs, x664_wr_data, x664_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3152 & x3150 & x3153))
      val x665_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x665_wr_ofs = List[UInt](x3151.r)
      val x665_wr_en = List[Bool](true.B)
      val x665_wr_data = List[UInt](x661_sub.r)
      x636_tmp_3.connectWPort(665, x665_wr_banks, x665_wr_ofs, x665_wr_data, x665_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3152 & x3150 & x3153))
      val x666_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x666_wr_ofs = List[UInt](x3151.r)
      val x666_wr_en = List[Bool](true.B)
      val x666_wr_data = List[UInt](x661_sub.r)
      x635_tmp_2.connectWPort(666, x666_wr_banks, x666_wr_ofs, x666_wr_data, x666_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3152 & x3150 & x3153))
    }
    val module = Module(new x667_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x667_inr_Foreach **/
