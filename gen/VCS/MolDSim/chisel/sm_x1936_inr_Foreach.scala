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

/** Hierarchy: x1936 -> x1937 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1936_inr_Foreach **/
class x1936_inr_Foreach_kernel(
  list_b1879: List[Bool],
  list_b553: List[FixedPoint],
  list_x1887_tmp_1: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1936_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1936_inr_Foreach_iiCtr"))
  
  abstract class x1936_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1879 = Input(Bool())
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1887_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1887_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1890_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1890_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1886_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1886_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1888_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1888_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1889_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1889_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_b553 = Input(new FixedPoint(true, 32, 0))
      val in_b1876 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1879 = {io.in_b1879} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1887_tmp_1 = {io.in_x1887_tmp_1} ; io.in_x1887_tmp_1 := DontCare
    def x1890_tmp_4 = {io.in_x1890_tmp_4} ; io.in_x1890_tmp_4 := DontCare
    def x1886_tmp_0 = {io.in_x1886_tmp_0} ; io.in_x1886_tmp_0 := DontCare
    def x1888_tmp_2 = {io.in_x1888_tmp_2} ; io.in_x1888_tmp_2 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1889_tmp_3 = {io.in_x1889_tmp_3} ; io.in_x1889_tmp_3 := DontCare
    def b563 = {io.in_b563} 
    def b553 = {io.in_b553} 
    def b1876 = {io.in_b1876} 
  }
  def connectWires0(module: x1936_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1879 <> b1879
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1887_tmp_1.connectLedger(module.io.in_x1887_tmp_1)
    x1890_tmp_4.connectLedger(module.io.in_x1890_tmp_4)
    x1886_tmp_0.connectLedger(module.io.in_x1886_tmp_0)
    x1888_tmp_2.connectLedger(module.io.in_x1888_tmp_2)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1889_tmp_3.connectLedger(module.io.in_x1889_tmp_3)
    module.io.in_b563 <> b563
    module.io.in_b553 <> b553
    module.io.in_b1876 <> b1876
  }
  val b1879 = list_b1879(0)
  val b563 = list_b1879(1)
  val b553 = list_b553(0)
  val b1876 = list_b553(1)
  val x1887_tmp_1 = list_x1887_tmp_1(0)
  val x1890_tmp_4 = list_x1887_tmp_1(1)
  val x1886_tmp_0 = list_x1887_tmp_1(2)
  val x1888_tmp_2 = list_x1887_tmp_1(3)
  val x1889_tmp_3 = list_x1887_tmp_1(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1936_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1936_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1936_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1936_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1936_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1936_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1936_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1936_instrctr, cycles_x1936_inr_Foreach.io.count, iters_x1936_inr_Foreach.io.count, 0.U, 0.U)
      val b1916 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1916.suggestName("b1916")
      val b1917 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1917.suggestName("b1917")
      val x1922_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1922_rd""")
      val x1922_rd_banks = List[UInt](0.U,0.U)
      val x1922_rd_ofs = List[UInt](0.U)
      val x1922_rd_en = List[Bool](true.B)
      val x1922_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1922_rd_shared_en")
      x1922_rd.toSeq.zip(x471_A_sram_0.connectRPort(1922, x1922_rd_banks, x1922_rd_ofs, io.sigsIn.backpressure, x1922_rd_en.map(_ && x1922_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1923 = VecApply(x1922,0)
      val x1923_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1923_elem_0""")
      x1923_elem_0.r := x1922_rd(0).r
      val x1928_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1928_rd""")
      val x1928_rd_banks = List[UInt](0.U,0.U)
      val x1928_rd_ofs = List[UInt](0.U)
      val x1928_rd_en = List[Bool](true.B)
      val x1928_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1928_rd_shared_en")
      x1928_rd.toSeq.zip(x472_A_sram_1.connectRPort(1928, x1928_rd_banks, x1928_rd_ofs, io.sigsIn.backpressure, x1928_rd_en.map(_ && x1928_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1929 = VecApply(x1928,0)
      val x1929_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1929_elem_0""")
      x1929_elem_0.r := x1928_rd(0).r
      val x3528 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3528_x1929_elem_0_D20") 
      x3528.r := getRetimed(x1929_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1930_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1930_sub""")
      x1930_sub.r := Math.sub(x1923_elem_0,x3528,Some(1.0), true.B, Truncate, Wrapping, "x1930_sub").r
      val x3529 = Wire(Bool()).suggestName("x3529_b1879_D25") 
      x3529.r := getRetimed(b1879.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3530 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3530_b1916_D25") 
      x3530.r := getRetimed(b1916.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3531 = Wire(Bool()).suggestName("x3531_b563_D25") 
      x3531.r := getRetimed(b563.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3532 = Wire(Bool()).suggestName("x3532_b1917_D25") 
      x3532.r := getRetimed(b1917.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1931_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1931_wr_ofs = List[UInt](x3530.r)
      val x1931_wr_en = List[Bool](true.B)
      val x1931_wr_data = List[UInt](x1930_sub.r)
      x1887_tmp_1.connectWPort(1931, x1931_wr_banks, x1931_wr_ofs, x1931_wr_data, x1931_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3532 & x3529 & x3531))
      val x1932_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1932_wr_ofs = List[UInt](x3530.r)
      val x1932_wr_en = List[Bool](true.B)
      val x1932_wr_data = List[UInt](x1930_sub.r)
      x1890_tmp_4.connectWPort(1932, x1932_wr_banks, x1932_wr_ofs, x1932_wr_data, x1932_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3532 & x3529 & x3531))
      val x1933_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1933_wr_ofs = List[UInt](x3530.r)
      val x1933_wr_en = List[Bool](true.B)
      val x1933_wr_data = List[UInt](x1930_sub.r)
      x1886_tmp_0.connectWPort(1933, x1933_wr_banks, x1933_wr_ofs, x1933_wr_data, x1933_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3532 & x3529 & x3531))
      val x1934_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1934_wr_ofs = List[UInt](x3530.r)
      val x1934_wr_en = List[Bool](true.B)
      val x1934_wr_data = List[UInt](x1930_sub.r)
      x1888_tmp_2.connectWPort(1934, x1934_wr_banks, x1934_wr_ofs, x1934_wr_data, x1934_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3532 & x3529 & x3531))
      val x1935_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1935_wr_ofs = List[UInt](x3530.r)
      val x1935_wr_en = List[Bool](true.B)
      val x1935_wr_data = List[UInt](x1930_sub.r)
      x1889_tmp_3.connectWPort(1935, x1935_wr_banks, x1935_wr_ofs, x1935_wr_data, x1935_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3532 & x3529 & x3531))
    }
    val module = Module(new x1936_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1936_inr_Foreach **/
