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

/** Hierarchy: x1873 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1873_inr_Foreach **/
class x1873_inr_Foreach_kernel(
  list_b1671: List[Bool],
  list_b1667: List[FixedPoint],
  list_x577_accum_0: List[StandardInterface],
  list_x1682_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x1873_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1873_inr_Foreach_iiCtr"))
  
  abstract class x1873_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1671 = Input(Bool())
      val in_x1682_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1682_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1677_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1677_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x578_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x578_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x577_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x577_accum_0_p").asInstanceOf[MemParams] ))
      val in_b1667 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1671 = {io.in_b1671} 
    def x1682_tmp_4 = {io.in_x1682_tmp_4} ; io.in_x1682_tmp_4 := DontCare
    def x1677_tmp_4 = {io.in_x1677_tmp_4} ; io.in_x1677_tmp_4 := DontCare
    def x578_accum_1 = {io.in_x578_accum_1} ; io.in_x578_accum_1 := DontCare
    def b562 = {io.in_b562} 
    def x577_accum_0 = {io.in_x577_accum_0} ; io.in_x577_accum_0 := DontCare
    def b1667 = {io.in_b1667} 
  }
  def connectWires0(module: x1873_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1671 <> b1671
    x1682_tmp_4.connectLedger(module.io.in_x1682_tmp_4)
    x1677_tmp_4.connectLedger(module.io.in_x1677_tmp_4)
    x578_accum_1.connectLedger(module.io.in_x578_accum_1)
    module.io.in_b562 <> b562
    x577_accum_0.connectLedger(module.io.in_x577_accum_0)
    module.io.in_b1667 <> b1667
  }
  val b1671 = list_b1671(0)
  val b562 = list_b1671(1)
  val b1667 = list_b1667(0)
  val x577_accum_0 = list_x577_accum_0(0)
  val x1682_tmp_4 = list_x1682_tmp_4(0)
  val x1677_tmp_4 = list_x1682_tmp_4(1)
  val x578_accum_1 = list_x1682_tmp_4(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1873_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1873_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1873_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1873_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1873_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1873_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1873_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1873_instrctr, cycles_x1873_inr_Foreach.io.count, iters_x1873_inr_Foreach.io.count, 0.U, 0.U)
      val b1669 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1669.suggestName("b1669")
      val b1672 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1672.suggestName("b1672")
      val x1854_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1854_rd""")
      val x1854_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1854_rd_ofs = List[UInt](b1669.r)
      val x1854_rd_en = List[Bool](true.B)
      val x1854_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1672 & b562 ).suggestName("x1854_rd_shared_en")
      x1854_rd.toSeq.zip(x1677_tmp_4.connectRPort(1854, x1854_rd_banks, x1854_rd_ofs, io.sigsIn.backpressure, x1854_rd_en.map(_ && x1854_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1855 = VecApply(x1854,0)
      val x1855_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1855_elem_0""")
      x1855_elem_0.r := x1854_rd(0).r
      val x1856_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1856_rd""")
      val x1856_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1856_rd_ofs = List[UInt](b1669.r)
      val x1856_rd_en = List[Bool](true.B)
      val x1856_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1672 & b562 ).suggestName("x1856_rd_shared_en")
      x1856_rd.toSeq.zip(x1682_tmp_4.connectRPort(1856, x1856_rd_banks, x1856_rd_ofs, io.sigsIn.backpressure, x1856_rd_en.map(_ && x1856_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1857 = VecApply(x1856,0)
      val x1857_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1857_elem_0""")
      x1857_elem_0.r := x1856_rd(0).r
      val x3496 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3496_b1669_D1") 
      x3496.r := getRetimed(b1669.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3497 = Wire(Bool()).suggestName("x3497_b562_D1") 
      x3497.r := getRetimed(b562.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3498 = Wire(Bool()).suggestName("x3498_b1672_D1") 
      x3498.r := getRetimed(b1672.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1858_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1858_rd""")
      val x1858_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1858_rd_ofs = List[UInt](x3496.r)
      val x1858_rd_en = List[Bool](true.B)
      val x1858_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3498 & x3497 ).suggestName("x1858_rd_shared_en")
      x1858_rd.toSeq.zip(x577_accum_0.connectRPort(1858, x1858_rd_banks, x1858_rd_ofs, io.sigsIn.backpressure, x1858_rd_en.map(_ && x1858_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1859 = VecApply(x1858,0)
      val x1859_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1859_elem_0""")
      x1859_elem_0.r := x1858_rd(0).r
      val x1860 = Wire(Bool()).suggestName("""x1860""")
      x1860 := b1672 & b562
      val x1862 = Wire(Bool()).suggestName("""x1862""")
      x1862 := b1671 & b562
      val x1864 = Wire(Bool()).suggestName("""x1864""")
      x1864 := x1862 & x1860
      val x1865_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1865_sum""")
      x1865_sum.r := Math.add(x1855_elem_0,x1857_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1865_sum").r
      val x3499 = Wire(Bool()).suggestName("x3499_x1864_D3") 
      x3499.r := getRetimed(x1864.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3500 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3500_x1855_elem_0_D1") 
      x3500.r := getRetimed(x1855_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1866 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1866""")
      x1866.r := Mux((x3499), x1865_sum.r, x3500.r)
      val x1868 = Wire(Bool()).suggestName("""x1868""")
      x1868.r := Math.eql(b1667, 0L.FP(true, 32, 0), Some(0.2), true.B,"x1868").r
      val x1869_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1869_sum""")
      x1869_sum.r := Math.add(x1866,x1859_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1869_sum").r
      val x3501 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3501_x1866_D1") 
      x3501.r := getRetimed(x1866.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3502 = Wire(Bool()).suggestName("x3502_x1868_D4") 
      x3502.r := getRetimed(x1868.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x1870 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1870""")
      x1870.r := Mux((x3502), x3501.r, x1869_sum.r)
      val x3503 = Wire(Bool()).suggestName("x3503_b1672_D5") 
      x3503.r := getRetimed(b1672.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3504 = Wire(Bool()).suggestName("x3504_b562_D5") 
      x3504.r := getRetimed(b562.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3505 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3505_b1669_D5") 
      x3505.r := getRetimed(b1669.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3506 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3506_x1870_D1") 
      x3506.r := getRetimed(x1870.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1871_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1871_wr_ofs = List[UInt](x3505.r)
      val x1871_wr_en = List[Bool](true.B)
      val x1871_wr_data = List[UInt](x3506.r)
      x577_accum_0.connectWPort(1871, x1871_wr_banks, x1871_wr_ofs, x1871_wr_data, x1871_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3503 & x3504))
      val x1872_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1872_wr_ofs = List[UInt](x3505.r)
      val x1872_wr_en = List[Bool](true.B)
      val x1872_wr_data = List[UInt](x3506.r)
      x578_accum_1.connectWPort(1872, x1872_wr_banks, x1872_wr_ofs, x1872_wr_data, x1872_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3503 & x3504))
      x1677_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x1682_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x1873_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1873_inr_Foreach **/
