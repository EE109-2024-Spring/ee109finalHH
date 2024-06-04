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

/** Hierarchy: x1707 -> x1729 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1707_inr_Foreach **/
class x1707_inr_Foreach_kernel(
  list_b562: List[Bool],
  list_b1667: List[FixedPoint],
  list_x1677_tmp_4: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1707_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1707_inr_Foreach_iiCtr"))
  
  abstract class x1707_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1677_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1677_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1676_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1676_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b562 = Input(Bool())
      val in_x1675_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1675_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1667 = Input(new FixedPoint(true, 32, 0))
      val in_b552 = Input(new FixedPoint(true, 32, 0))
      val in_b1670 = Input(Bool())
      val in_x1674_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1674_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1673_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1673_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1677_tmp_4 = {io.in_x1677_tmp_4} ; io.in_x1677_tmp_4 := DontCare
    def x1676_tmp_3 = {io.in_x1676_tmp_3} ; io.in_x1676_tmp_3 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b562 = {io.in_b562} 
    def x1675_tmp_2 = {io.in_x1675_tmp_2} ; io.in_x1675_tmp_2 := DontCare
    def b1667 = {io.in_b1667} 
    def b552 = {io.in_b552} 
    def b1670 = {io.in_b1670} 
    def x1674_tmp_1 = {io.in_x1674_tmp_1} ; io.in_x1674_tmp_1 := DontCare
    def x1673_tmp_0 = {io.in_x1673_tmp_0} ; io.in_x1673_tmp_0 := DontCare
  }
  def connectWires0(module: x1707_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1677_tmp_4.connectLedger(module.io.in_x1677_tmp_4)
    x1676_tmp_3.connectLedger(module.io.in_x1676_tmp_3)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b562 <> b562
    x1675_tmp_2.connectLedger(module.io.in_x1675_tmp_2)
    module.io.in_b1667 <> b1667
    module.io.in_b552 <> b552
    module.io.in_b1670 <> b1670
    x1674_tmp_1.connectLedger(module.io.in_x1674_tmp_1)
    x1673_tmp_0.connectLedger(module.io.in_x1673_tmp_0)
  }
  val b562 = list_b562(0)
  val b1670 = list_b562(1)
  val b1667 = list_b1667(0)
  val b552 = list_b1667(1)
  val x1677_tmp_4 = list_x1677_tmp_4(0)
  val x1676_tmp_3 = list_x1677_tmp_4(1)
  val x1675_tmp_2 = list_x1677_tmp_4(2)
  val x1674_tmp_1 = list_x1677_tmp_4(3)
  val x1673_tmp_0 = list_x1677_tmp_4(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1707_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1707_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1707_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1707_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1707_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1707_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1707_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1707_instrctr, cycles_x1707_inr_Foreach.io.count, iters_x1707_inr_Foreach.io.count, 0.U, 0.U)
      val b1687 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1687.suggestName("b1687")
      val b1688 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1688.suggestName("b1688")
      val x1690_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1690_div""")
      x1690_div.r := (Math.div(b552, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x1690_div")).r
      val x3037 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3037""")
      x3037.r := Math.arith_left_shift(x1690_div, 1, Some(0.2), true.B,"x3037").r
      val x3038_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3038_sum""")
      x3038_sum.r := Math.add(x3037,x1690_div,Some(1.0), true.B, Truncate, Wrapping, "x3038_sum").r
      val x3446 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3446_b1687_D21") 
      x3446.r := getRetimed(b1687.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x1692_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1692_sum""")
      x1692_sum.r := Math.add(x3038_sum,x3446,Some(1.0), true.B, Truncate, Wrapping, "x1692_sum").r
      val x3447 = Wire(Bool()).suggestName("x3447_b562_D22") 
      x3447.r := getRetimed(b562.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3448 = Wire(Bool()).suggestName("x3448_b1688_D22") 
      x3448.r := getRetimed(b1688.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3449 = Wire(Bool()).suggestName("x3449_b1670_D22") 
      x3449.r := getRetimed(b1670.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x1693_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1693_rd""")
      val x1693_rd_banks = List[UInt](5L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x1693_rd_ofs = List[UInt](x1692_sum.r)
      val x1693_rd_en = List[Bool](true.B)
      val x1693_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3448 & x3449 & x3447 ).suggestName("x1693_rd_shared_en")
      x1693_rd.toSeq.zip(x471_A_sram_0.connectRPort(1693, x1693_rd_banks, x1693_rd_ofs, io.sigsIn.backpressure, x1693_rd_en.map(_ && x1693_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1694 = VecApply(x1693,0)
      val x1694_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1694_elem_0""")
      x1694_elem_0.r := x1693_rd(0).r
      val x1699_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1699_rd""")
      val x1699_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x1699_rd_ofs = List[UInt](0.U)
      val x1699_rd_en = List[Bool](true.B)
      val x1699_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1699_rd_shared_en")
      x1699_rd.toSeq.zip(x472_A_sram_1.connectRPort(1699, x1699_rd_banks, x1699_rd_ofs, io.sigsIn.backpressure, x1699_rd_en.map(_ && x1699_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1700 = VecApply(x1699,0)
      val x1700_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1700_elem_0""")
      x1700_elem_0.r := x1699_rd(0).r
      val x3454 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3454_x1700_elem_0_D20") 
      x3454.r := getRetimed(x1700_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1701_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1701_sub""")
      x1701_sub.r := Math.sub(x1694_elem_0,x3454,Some(1.0), true.B, Truncate, Wrapping, "x1701_sub").r
      val x3455 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3455_b1687_D25") 
      x3455.r := getRetimed(b1687.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3456 = Wire(Bool()).suggestName("x3456_b562_D25") 
      x3456.r := getRetimed(b562.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3457 = Wire(Bool()).suggestName("x3457_b1688_D25") 
      x3457.r := getRetimed(b1688.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3458 = Wire(Bool()).suggestName("x3458_b1670_D25") 
      x3458.r := getRetimed(b1670.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1702_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1702_wr_ofs = List[UInt](x3455.r)
      val x1702_wr_en = List[Bool](true.B)
      val x1702_wr_data = List[UInt](x1701_sub.r)
      x1677_tmp_4.connectWPort(1702, x1702_wr_banks, x1702_wr_ofs, x1702_wr_data, x1702_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3457 & x3458 & x3456))
      val x1703_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1703_wr_ofs = List[UInt](x3455.r)
      val x1703_wr_en = List[Bool](true.B)
      val x1703_wr_data = List[UInt](x1701_sub.r)
      x1676_tmp_3.connectWPort(1703, x1703_wr_banks, x1703_wr_ofs, x1703_wr_data, x1703_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3457 & x3458 & x3456))
      val x1704_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1704_wr_ofs = List[UInt](x3455.r)
      val x1704_wr_en = List[Bool](true.B)
      val x1704_wr_data = List[UInt](x1701_sub.r)
      x1675_tmp_2.connectWPort(1704, x1704_wr_banks, x1704_wr_ofs, x1704_wr_data, x1704_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3457 & x3458 & x3456))
      val x1705_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1705_wr_ofs = List[UInt](x3455.r)
      val x1705_wr_en = List[Bool](true.B)
      val x1705_wr_data = List[UInt](x1701_sub.r)
      x1674_tmp_1.connectWPort(1705, x1705_wr_banks, x1705_wr_ofs, x1705_wr_data, x1705_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3457 & x3458 & x3456))
      val x1706_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1706_wr_ofs = List[UInt](x3455.r)
      val x1706_wr_en = List[Bool](true.B)
      val x1706_wr_data = List[UInt](x1701_sub.r)
      x1673_tmp_0.connectWPort(1706, x1706_wr_banks, x1706_wr_ofs, x1706_wr_data, x1706_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3457 & x3458 & x3456))
    }
    val module = Module(new x1707_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1707_inr_Foreach **/
