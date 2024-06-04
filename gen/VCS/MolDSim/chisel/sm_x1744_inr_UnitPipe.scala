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

/** Hierarchy: x1744 -> x1758 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1744_inr_UnitPipe **/
class x1744_inr_UnitPipe_kernel(
  list_b562: List[Bool],
  list_x1730_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1744_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1744_inr_UnitPipe_iiCtr"))
  
  abstract class x1744_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1730_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1730_r_0_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1675_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1675_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1670 = Input(Bool())
      val in_x1674_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1674_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1673_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1673_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1730_r_0 = {io.in_x1730_r_0} ; io.in_x1730_r_0 := DontCare
    def b562 = {io.in_b562} 
    def x1675_tmp_2 = {io.in_x1675_tmp_2} ; io.in_x1675_tmp_2 := DontCare
    def b1670 = {io.in_b1670} 
    def x1674_tmp_1 = {io.in_x1674_tmp_1} ; io.in_x1674_tmp_1 := DontCare
    def x1673_tmp_0 = {io.in_x1673_tmp_0} ; io.in_x1673_tmp_0 := DontCare
  }
  def connectWires0(module: x1744_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1730_r_0.connectLedger(module.io.in_x1730_r_0)
    module.io.in_b562 <> b562
    x1675_tmp_2.connectLedger(module.io.in_x1675_tmp_2)
    module.io.in_b1670 <> b1670
    x1674_tmp_1.connectLedger(module.io.in_x1674_tmp_1)
    x1673_tmp_0.connectLedger(module.io.in_x1673_tmp_0)
  }
  val b562 = list_b562(0)
  val b1670 = list_b562(1)
  val x1730_r_0 = list_x1730_r_0(0)
  val x1675_tmp_2 = list_x1730_r_0(1)
  val x1674_tmp_1 = list_x1730_r_0(2)
  val x1673_tmp_0 = list_x1730_r_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1744_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1744_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1744_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1744_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1744_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1744_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1744_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1744_instrctr, cycles_x1744_inr_UnitPipe.io.count, iters_x1744_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1732_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1732_rd""")
      val x1732_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1732_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1732_rd_en = List[Bool](true.B)
      val x1732_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1732_rd_shared_en")
      x1732_rd.toSeq.zip(x1673_tmp_0.connectRPort(1732, x1732_rd_banks, x1732_rd_ofs, io.sigsIn.backpressure, x1732_rd_en.map(_ && x1732_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1733 = VecApply(x1732,0)
      val x1733_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1733_elem_0""")
      x1733_elem_0.r := x1732_rd(0).r
      val x1735_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1735_rd""")
      val x1735_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1735_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1735_rd_en = List[Bool](true.B)
      val x1735_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1735_rd_shared_en")
      x1735_rd.toSeq.zip(x1674_tmp_1.connectRPort(1735, x1735_rd_banks, x1735_rd_ofs, io.sigsIn.backpressure, x1735_rd_en.map(_ && x1735_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1736 = VecApply(x1735,0)
      val x1736_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1736_elem_0""")
      x1736_elem_0.r := x1735_rd(0).r
      val x1737_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1737_mul""")
      x1737_mul.r := (Math.mul(x1736_elem_0, x1736_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1737_mul")).r
      val x3472 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3472_x1733_elem_0_D6") 
      x3472.r := getRetimed(x1733_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3045 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3045""")
      x3045.r := Math.fma(x3472,x3472,x1737_mul,Some(6.0), true.B, "x3045").toFixed(x3045, "cast_x3045").r
      val x1739_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1739_rd""")
      val x1739_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1739_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1739_rd_en = List[Bool](true.B)
      val x1739_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1739_rd_shared_en")
      x1739_rd.toSeq.zip(x1675_tmp_2.connectRPort(1739, x1739_rd_banks, x1739_rd_ofs, io.sigsIn.backpressure, x1739_rd_en.map(_ && x1739_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1740 = VecApply(x1739,0)
      val x1740_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1740_elem_0""")
      x1740_elem_0.r := x1739_rd(0).r
      val x3473 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3473_x1740_elem_0_D12") 
      x3473.r := getRetimed(x1740_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3046 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3046""")
      x3046.r := Math.fma(x3473,x3473,x3045,Some(6.0), true.B, "x3046").toFixed(x3046, "cast_x3046").r
      val x1743_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1743_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1743_wr_en = List[Bool](true.B)
      val x1743_wr_data = List[UInt](x3046.r)
      x1730_r_0.connectWPort(1743, x1743_wr_banks, x1743_wr_ofs, x1743_wr_data, x1743_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1744_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1744_inr_UnitPipe **/
