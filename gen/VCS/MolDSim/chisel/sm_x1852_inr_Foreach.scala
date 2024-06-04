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

/** Hierarchy: x1852 -> x1853 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1852_inr_Foreach **/
class x1852_inr_Foreach_kernel(
  list_b1671: List[Bool],
  list_x1760_force_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1852_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1852_inr_Foreach_iiCtr"))
  
  abstract class x1852_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1671 = Input(Bool())
      val in_x1760_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1760_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1682_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1682_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1680_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1680_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
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
    def x1760_force_0 = {io.in_x1760_force_0} ; io.in_x1760_force_0 := DontCare
    def x1682_tmp_4 = {io.in_x1682_tmp_4} ; io.in_x1682_tmp_4 := DontCare
    def x1680_tmp_2 = {io.in_x1680_tmp_2} ; io.in_x1680_tmp_2 := DontCare
    def b562 = {io.in_b562} 
    def x1679_tmp_1 = {io.in_x1679_tmp_1} ; io.in_x1679_tmp_1 := DontCare
    def x1678_tmp_0 = {io.in_x1678_tmp_0} ; io.in_x1678_tmp_0 := DontCare
    def x1681_tmp_3 = {io.in_x1681_tmp_3} ; io.in_x1681_tmp_3 := DontCare
  }
  def connectWires0(module: x1852_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1671 <> b1671
    x1760_force_0.connectLedger(module.io.in_x1760_force_0)
    x1682_tmp_4.connectLedger(module.io.in_x1682_tmp_4)
    x1680_tmp_2.connectLedger(module.io.in_x1680_tmp_2)
    module.io.in_b562 <> b562
    x1679_tmp_1.connectLedger(module.io.in_x1679_tmp_1)
    x1678_tmp_0.connectLedger(module.io.in_x1678_tmp_0)
    x1681_tmp_3.connectLedger(module.io.in_x1681_tmp_3)
  }
  val b1671 = list_b1671(0)
  val b562 = list_b1671(1)
  val x1760_force_0 = list_x1760_force_0(0)
  val x1682_tmp_4 = list_x1760_force_0(1)
  val x1680_tmp_2 = list_x1760_force_0(2)
  val x1679_tmp_1 = list_x1760_force_0(3)
  val x1678_tmp_0 = list_x1760_force_0(4)
  val x1681_tmp_3 = list_x1760_force_0(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1852_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1852_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1852_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1852_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1852_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1852_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1852_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1852_instrctr, cycles_x1852_inr_Foreach.io.count, iters_x1852_inr_Foreach.io.count, 0.U, 0.U)
      val b1839 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1839.suggestName("b1839")
      val b1840 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1840.suggestName("b1840")
      val x1841_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1841_rd""")
      val x1841_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1841_rd_ofs = List[UInt](b1839.r)
      val x1841_rd_en = List[Bool](true.B)
      val x1841_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1840 & b1671 & b562 ).suggestName("x1841_rd_shared_en")
      x1841_rd.toSeq.zip(x1681_tmp_3.connectRPort(1841, x1841_rd_banks, x1841_rd_ofs, io.sigsIn.backpressure, x1841_rd_en.map(_ && x1841_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1842 = VecApply(x1841,0)
      val x1842_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1842_elem_0""")
      x1842_elem_0.r := x1841_rd(0).r
      val x1843_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1843_mul""")
      x1843_mul.r := (Math.mul(x1842_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1843_mul")).r
      val x1844_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1844_rd""")
      val x1844_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1844_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1844_rd_en = List[Bool](true.B)
      val x1844_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1840 & b1671 & b562 ).suggestName("x1844_rd_shared_en")
      x1844_rd.toSeq.zip(x1760_force_0.connectRPort(1844, x1844_rd_banks, x1844_rd_ofs, io.sigsIn.backpressure, x1844_rd_en.map(_ && x1844_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1845 = VecApply(x1844,0)
      val x1845_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1845_elem_0""")
      x1845_elem_0.r := x1844_rd(0).r
      val x3491 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3491_x1845_elem_0_D6") 
      x3491.r := getRetimed(x1845_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1846_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1846_mul""")
      x1846_mul.r := (Math.mul(x1843_mul, x3491, Some(6.0), true.B, Truncate, Wrapping, "x1846_mul")).r
      val x3492 = Wire(Bool()).suggestName("x3492_b1840_D14") 
      x3492.r := getRetimed(b1840.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3493 = Wire(Bool()).suggestName("x3493_b1671_D14") 
      x3493.r := getRetimed(b1671.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3494 = Wire(Bool()).suggestName("x3494_b562_D14") 
      x3494.r := getRetimed(b562.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3495 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3495_b1839_D14") 
      x3495.r := getRetimed(b1839.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1847_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1847_wr_ofs = List[UInt](x3495.r)
      val x1847_wr_en = List[Bool](true.B)
      val x1847_wr_data = List[UInt](x1846_mul.r)
      x1682_tmp_4.connectWPort(1847, x1847_wr_banks, x1847_wr_ofs, x1847_wr_data, x1847_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3492 & x3493 & x3494))
      val x1848_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1848_wr_ofs = List[UInt](x3495.r)
      val x1848_wr_en = List[Bool](true.B)
      val x1848_wr_data = List[UInt](x1846_mul.r)
      x1680_tmp_2.connectWPort(1848, x1848_wr_banks, x1848_wr_ofs, x1848_wr_data, x1848_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3492 & x3493 & x3494))
      val x1849_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1849_wr_ofs = List[UInt](x3495.r)
      val x1849_wr_en = List[Bool](true.B)
      val x1849_wr_data = List[UInt](x1846_mul.r)
      x1679_tmp_1.connectWPort(1849, x1849_wr_banks, x1849_wr_ofs, x1849_wr_data, x1849_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3492 & x3493 & x3494))
      val x1850_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1850_wr_ofs = List[UInt](x3495.r)
      val x1850_wr_en = List[Bool](true.B)
      val x1850_wr_data = List[UInt](x1846_mul.r)
      x1678_tmp_0.connectWPort(1850, x1850_wr_banks, x1850_wr_ofs, x1850_wr_data, x1850_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3492 & x3493 & x3494))
      val x1851_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1851_wr_ofs = List[UInt](x3495.r)
      val x1851_wr_en = List[Bool](true.B)
      val x1851_wr_data = List[UInt](x1846_mul.r)
      x1681_tmp_3.connectWPort(1851, x1851_wr_banks, x1851_wr_ofs, x1851_wr_data, x1851_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3492 & x3493 & x3494))
    }
    val module = Module(new x1852_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1852_inr_Foreach **/
