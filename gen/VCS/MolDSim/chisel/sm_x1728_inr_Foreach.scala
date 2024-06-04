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

/** Hierarchy: x1728 -> x1729 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1728_inr_Foreach **/
class x1728_inr_Foreach_kernel(
  list_b1671: List[Bool],
  list_b1668: List[FixedPoint],
  list_x1682_tmp_4: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1728_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1728_inr_Foreach_iiCtr"))
  
  abstract class x1728_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1671 = Input(Bool())
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1682_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1682_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b1668 = Input(new FixedPoint(true, 32, 0))
      val in_x1680_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1680_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_b552 = Input(new FixedPoint(true, 32, 0))
      val in_x1679_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1679_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1678_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1678_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1681_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1681_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1671 = {io.in_b1671} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1682_tmp_4 = {io.in_x1682_tmp_4} ; io.in_x1682_tmp_4 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b1668 = {io.in_b1668} 
    def x1680_tmp_2 = {io.in_x1680_tmp_2} ; io.in_x1680_tmp_2 := DontCare
    def b562 = {io.in_b562} 
    def b552 = {io.in_b552} 
    def x1679_tmp_1 = {io.in_x1679_tmp_1} ; io.in_x1679_tmp_1 := DontCare
    def x1678_tmp_0 = {io.in_x1678_tmp_0} ; io.in_x1678_tmp_0 := DontCare
    def x1681_tmp_3 = {io.in_x1681_tmp_3} ; io.in_x1681_tmp_3 := DontCare
  }
  def connectWires0(module: x1728_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1671 <> b1671
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1682_tmp_4.connectLedger(module.io.in_x1682_tmp_4)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b1668 <> b1668
    x1680_tmp_2.connectLedger(module.io.in_x1680_tmp_2)
    module.io.in_b562 <> b562
    module.io.in_b552 <> b552
    x1679_tmp_1.connectLedger(module.io.in_x1679_tmp_1)
    x1678_tmp_0.connectLedger(module.io.in_x1678_tmp_0)
    x1681_tmp_3.connectLedger(module.io.in_x1681_tmp_3)
  }
  val b1671 = list_b1671(0)
  val b562 = list_b1671(1)
  val b1668 = list_b1668(0)
  val b552 = list_b1668(1)
  val x1682_tmp_4 = list_x1682_tmp_4(0)
  val x1680_tmp_2 = list_x1682_tmp_4(1)
  val x1679_tmp_1 = list_x1682_tmp_4(2)
  val x1678_tmp_0 = list_x1682_tmp_4(3)
  val x1681_tmp_3 = list_x1682_tmp_4(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1728_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1728_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1728_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1728_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1728_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1728_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1728_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1728_instrctr, cycles_x1728_inr_Foreach.io.count, iters_x1728_inr_Foreach.io.count, 0.U, 0.U)
      val b1708 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1708.suggestName("b1708")
      val b1709 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1709.suggestName("b1709")
      val x1714_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1714_rd""")
      val x1714_rd_banks = List[UInt](0.U,0.U)
      val x1714_rd_ofs = List[UInt](0.U)
      val x1714_rd_en = List[Bool](true.B)
      val x1714_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1714_rd_shared_en")
      x1714_rd.toSeq.zip(x471_A_sram_0.connectRPort(1714, x1714_rd_banks, x1714_rd_ofs, io.sigsIn.backpressure, x1714_rd_en.map(_ && x1714_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1715 = VecApply(x1714,0)
      val x1715_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1715_elem_0""")
      x1715_elem_0.r := x1714_rd(0).r
      val x1720_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1720_rd""")
      val x1720_rd_banks = List[UInt](0.U,0.U)
      val x1720_rd_ofs = List[UInt](0.U)
      val x1720_rd_en = List[Bool](true.B)
      val x1720_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1720_rd_shared_en")
      x1720_rd.toSeq.zip(x472_A_sram_1.connectRPort(1720, x1720_rd_banks, x1720_rd_ofs, io.sigsIn.backpressure, x1720_rd_en.map(_ && x1720_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1721 = VecApply(x1720,0)
      val x1721_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1721_elem_0""")
      x1721_elem_0.r := x1720_rd(0).r
      val x3467 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3467_x1721_elem_0_D20") 
      x3467.r := getRetimed(x1721_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1722_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1722_sub""")
      x1722_sub.r := Math.sub(x1715_elem_0,x3467,Some(1.0), true.B, Truncate, Wrapping, "x1722_sub").r
      val x3468 = Wire(Bool()).suggestName("x3468_b1671_D25") 
      x3468.r := getRetimed(b1671.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3469 = Wire(Bool()).suggestName("x3469_b1709_D25") 
      x3469.r := getRetimed(b1709.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3470 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3470_b1708_D25") 
      x3470.r := getRetimed(b1708.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3471 = Wire(Bool()).suggestName("x3471_b562_D25") 
      x3471.r := getRetimed(b562.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1723_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1723_wr_ofs = List[UInt](x3470.r)
      val x1723_wr_en = List[Bool](true.B)
      val x1723_wr_data = List[UInt](x1722_sub.r)
      x1682_tmp_4.connectWPort(1723, x1723_wr_banks, x1723_wr_ofs, x1723_wr_data, x1723_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3469 & x3468 & x3471))
      val x1724_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1724_wr_ofs = List[UInt](x3470.r)
      val x1724_wr_en = List[Bool](true.B)
      val x1724_wr_data = List[UInt](x1722_sub.r)
      x1680_tmp_2.connectWPort(1724, x1724_wr_banks, x1724_wr_ofs, x1724_wr_data, x1724_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3469 & x3468 & x3471))
      val x1725_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1725_wr_ofs = List[UInt](x3470.r)
      val x1725_wr_en = List[Bool](true.B)
      val x1725_wr_data = List[UInt](x1722_sub.r)
      x1679_tmp_1.connectWPort(1725, x1725_wr_banks, x1725_wr_ofs, x1725_wr_data, x1725_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3469 & x3468 & x3471))
      val x1726_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1726_wr_ofs = List[UInt](x3470.r)
      val x1726_wr_en = List[Bool](true.B)
      val x1726_wr_data = List[UInt](x1722_sub.r)
      x1678_tmp_0.connectWPort(1726, x1726_wr_banks, x1726_wr_ofs, x1726_wr_data, x1726_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3469 & x3468 & x3471))
      val x1727_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1727_wr_ofs = List[UInt](x3470.r)
      val x1727_wr_en = List[Bool](true.B)
      val x1727_wr_data = List[UInt](x1722_sub.r)
      x1681_tmp_3.connectWPort(1727, x1727_wr_banks, x1727_wr_ofs, x1727_wr_data, x1727_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3469 & x3468 & x3471))
    }
    val module = Module(new x1728_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1728_inr_Foreach **/
