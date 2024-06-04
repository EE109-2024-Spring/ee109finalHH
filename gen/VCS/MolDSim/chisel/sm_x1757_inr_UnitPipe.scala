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

/** Hierarchy: x1757 -> x1758 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1757_inr_UnitPipe **/
class x1757_inr_UnitPipe_kernel(
  list_b1671: List[Bool],
  list_x1680_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1757_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1757_inr_UnitPipe_iiCtr"))
  
  abstract class x1757_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1671 = Input(Bool())
      val in_x1680_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1680_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1731_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1731_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1679_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1679_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1678_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1678_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1671 = {io.in_b1671} 
    def x1680_tmp_2 = {io.in_x1680_tmp_2} ; io.in_x1680_tmp_2 := DontCare
    def b562 = {io.in_b562} 
    def x1731_r_0 = {io.in_x1731_r_0} ; io.in_x1731_r_0 := DontCare
    def x1679_tmp_1 = {io.in_x1679_tmp_1} ; io.in_x1679_tmp_1 := DontCare
    def x1678_tmp_0 = {io.in_x1678_tmp_0} ; io.in_x1678_tmp_0 := DontCare
  }
  def connectWires0(module: x1757_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1671 <> b1671
    x1680_tmp_2.connectLedger(module.io.in_x1680_tmp_2)
    module.io.in_b562 <> b562
    x1731_r_0.connectLedger(module.io.in_x1731_r_0)
    x1679_tmp_1.connectLedger(module.io.in_x1679_tmp_1)
    x1678_tmp_0.connectLedger(module.io.in_x1678_tmp_0)
  }
  val b1671 = list_b1671(0)
  val b562 = list_b1671(1)
  val x1680_tmp_2 = list_x1680_tmp_2(0)
  val x1731_r_0 = list_x1680_tmp_2(1)
  val x1679_tmp_1 = list_x1680_tmp_2(2)
  val x1678_tmp_0 = list_x1680_tmp_2(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1757_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1757_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1757_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1757_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1757_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1757_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1757_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1757_instrctr, cycles_x1757_inr_UnitPipe.io.count, iters_x1757_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1745_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1745_rd""")
      val x1745_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1745_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1745_rd_en = List[Bool](true.B)
      val x1745_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1745_rd_shared_en")
      x1745_rd.toSeq.zip(x1678_tmp_0.connectRPort(1745, x1745_rd_banks, x1745_rd_ofs, io.sigsIn.backpressure, x1745_rd_en.map(_ && x1745_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1746 = VecApply(x1745,0)
      val x1746_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1746_elem_0""")
      x1746_elem_0.r := x1745_rd(0).r
      val x1748_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1748_rd""")
      val x1748_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1748_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1748_rd_en = List[Bool](true.B)
      val x1748_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1748_rd_shared_en")
      x1748_rd.toSeq.zip(x1679_tmp_1.connectRPort(1748, x1748_rd_banks, x1748_rd_ofs, io.sigsIn.backpressure, x1748_rd_en.map(_ && x1748_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1749 = VecApply(x1748,0)
      val x1749_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1749_elem_0""")
      x1749_elem_0.r := x1748_rd(0).r
      val x1750_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1750_mul""")
      x1750_mul.r := (Math.mul(x1749_elem_0, x1749_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1750_mul")).r
      val x3474 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3474_x1746_elem_0_D6") 
      x3474.r := getRetimed(x1746_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3047 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3047""")
      x3047.r := Math.fma(x3474,x3474,x1750_mul,Some(6.0), true.B, "x3047").toFixed(x3047, "cast_x3047").r
      val x1752_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1752_rd""")
      val x1752_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1752_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1752_rd_en = List[Bool](true.B)
      val x1752_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1752_rd_shared_en")
      x1752_rd.toSeq.zip(x1680_tmp_2.connectRPort(1752, x1752_rd_banks, x1752_rd_ofs, io.sigsIn.backpressure, x1752_rd_en.map(_ && x1752_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1753 = VecApply(x1752,0)
      val x1753_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1753_elem_0""")
      x1753_elem_0.r := x1752_rd(0).r
      val x3475 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3475_x1753_elem_0_D12") 
      x3475.r := getRetimed(x1753_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3048 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3048""")
      x3048.r := Math.fma(x3475,x3475,x3047,Some(6.0), true.B, "x3048").toFixed(x3048, "cast_x3048").r
      val x1756_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1756_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1756_wr_en = List[Bool](true.B)
      val x1756_wr_data = List[UInt](x3048.r)
      x1731_r_0.connectWPort(1756, x1756_wr_banks, x1756_wr_ofs, x1756_wr_data, x1756_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1757_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1757_inr_UnitPipe **/
