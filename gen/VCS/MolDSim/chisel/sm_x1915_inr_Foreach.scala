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

/** Hierarchy: x1915 -> x1937 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1915_inr_Foreach **/
class x1915_inr_Foreach_kernel(
  list_b1878: List[Bool],
  list_b1875: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x1882_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1915_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1915_inr_Foreach_iiCtr"))
  
  abstract class x1915_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1882_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1882_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b1875 = Input(new FixedPoint(true, 32, 0))
      val in_x1883_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1883_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1878 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1884_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1884_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_b553 = Input(new FixedPoint(true, 32, 0))
      val in_x1881_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1881_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1885_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1885_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1882_tmp_1 = {io.in_x1882_tmp_1} ; io.in_x1882_tmp_1 := DontCare
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b1875 = {io.in_b1875} 
    def x1883_tmp_2 = {io.in_x1883_tmp_2} ; io.in_x1883_tmp_2 := DontCare
    def b1878 = {io.in_b1878} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1884_tmp_3 = {io.in_x1884_tmp_3} ; io.in_x1884_tmp_3 := DontCare
    def b563 = {io.in_b563} 
    def b553 = {io.in_b553} 
    def x1881_tmp_0 = {io.in_x1881_tmp_0} ; io.in_x1881_tmp_0 := DontCare
    def x1885_tmp_4 = {io.in_x1885_tmp_4} ; io.in_x1885_tmp_4 := DontCare
  }
  def connectWires0(module: x1915_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1882_tmp_1.connectLedger(module.io.in_x1882_tmp_1)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b1875 <> b1875
    x1883_tmp_2.connectLedger(module.io.in_x1883_tmp_2)
    module.io.in_b1878 <> b1878
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1884_tmp_3.connectLedger(module.io.in_x1884_tmp_3)
    module.io.in_b563 <> b563
    module.io.in_b553 <> b553
    x1881_tmp_0.connectLedger(module.io.in_x1881_tmp_0)
    x1885_tmp_4.connectLedger(module.io.in_x1885_tmp_4)
  }
  val b1878 = list_b1878(0)
  val b563 = list_b1878(1)
  val b1875 = list_b1875(0)
  val b553 = list_b1875(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x1882_tmp_1 = list_x1882_tmp_1(0)
  val x1883_tmp_2 = list_x1882_tmp_1(1)
  val x1884_tmp_3 = list_x1882_tmp_1(2)
  val x1881_tmp_0 = list_x1882_tmp_1(3)
  val x1885_tmp_4 = list_x1882_tmp_1(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1915_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1915_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1915_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1915_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1915_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1915_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1915_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1915_instrctr, cycles_x1915_inr_Foreach.io.count, iters_x1915_inr_Foreach.io.count, 0.U, 0.U)
      val b1895 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1895.suggestName("b1895")
      val b1896 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1896.suggestName("b1896")
      val x1898_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1898_div""")
      x1898_div.r := (Math.div(b553, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x1898_div")).r
      val x3049 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3049""")
      x3049.r := Math.arith_left_shift(x1898_div, 1, Some(0.2), true.B,"x3049").r
      val x3050_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3050_sum""")
      x3050_sum.r := Math.add(x3049,x1898_div,Some(1.0), true.B, Truncate, Wrapping, "x3050_sum").r
      val x3507 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3507_b1895_D21") 
      x3507.r := getRetimed(b1895.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x1900_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1900_sum""")
      x1900_sum.r := Math.add(x3050_sum,x3507,Some(1.0), true.B, Truncate, Wrapping, "x1900_sum").r
      val x3508 = Wire(Bool()).suggestName("x3508_b1896_D22") 
      x3508.r := getRetimed(b1896.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3509 = Wire(Bool()).suggestName("x3509_b1878_D22") 
      x3509.r := getRetimed(b1878.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3510 = Wire(Bool()).suggestName("x3510_b563_D22") 
      x3510.r := getRetimed(b563.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x1901_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1901_rd""")
      val x1901_rd_banks = List[UInt](6L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x1901_rd_ofs = List[UInt](x1900_sum.r)
      val x1901_rd_en = List[Bool](true.B)
      val x1901_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3508 & x3509 & x3510 ).suggestName("x1901_rd_shared_en")
      x1901_rd.toSeq.zip(x471_A_sram_0.connectRPort(1901, x1901_rd_banks, x1901_rd_ofs, io.sigsIn.backpressure, x1901_rd_en.map(_ && x1901_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1902 = VecApply(x1901,0)
      val x1902_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1902_elem_0""")
      x1902_elem_0.r := x1901_rd(0).r
      val x1907_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1907_rd""")
      val x1907_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x1907_rd_ofs = List[UInt](0.U)
      val x1907_rd_en = List[Bool](true.B)
      val x1907_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1907_rd_shared_en")
      x1907_rd.toSeq.zip(x472_A_sram_1.connectRPort(1907, x1907_rd_banks, x1907_rd_ofs, io.sigsIn.backpressure, x1907_rd_en.map(_ && x1907_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1908 = VecApply(x1907,0)
      val x1908_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1908_elem_0""")
      x1908_elem_0.r := x1907_rd(0).r
      val x3515 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3515_x1908_elem_0_D20") 
      x3515.r := getRetimed(x1908_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1909_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1909_sub""")
      x1909_sub.r := Math.sub(x1902_elem_0,x3515,Some(1.0), true.B, Truncate, Wrapping, "x1909_sub").r
      val x3516 = Wire(Bool()).suggestName("x3516_b1896_D25") 
      x3516.r := getRetimed(b1896.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3517 = Wire(Bool()).suggestName("x3517_b1878_D25") 
      x3517.r := getRetimed(b1878.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3518 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3518_b1895_D25") 
      x3518.r := getRetimed(b1895.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3519 = Wire(Bool()).suggestName("x3519_b563_D25") 
      x3519.r := getRetimed(b563.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1910_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1910_wr_ofs = List[UInt](x3518.r)
      val x1910_wr_en = List[Bool](true.B)
      val x1910_wr_data = List[UInt](x1909_sub.r)
      x1882_tmp_1.connectWPort(1910, x1910_wr_banks, x1910_wr_ofs, x1910_wr_data, x1910_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3516 & x3517 & x3519))
      val x1911_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1911_wr_ofs = List[UInt](x3518.r)
      val x1911_wr_en = List[Bool](true.B)
      val x1911_wr_data = List[UInt](x1909_sub.r)
      x1883_tmp_2.connectWPort(1911, x1911_wr_banks, x1911_wr_ofs, x1911_wr_data, x1911_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3516 & x3517 & x3519))
      val x1912_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1912_wr_ofs = List[UInt](x3518.r)
      val x1912_wr_en = List[Bool](true.B)
      val x1912_wr_data = List[UInt](x1909_sub.r)
      x1884_tmp_3.connectWPort(1912, x1912_wr_banks, x1912_wr_ofs, x1912_wr_data, x1912_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3516 & x3517 & x3519))
      val x1913_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1913_wr_ofs = List[UInt](x3518.r)
      val x1913_wr_en = List[Bool](true.B)
      val x1913_wr_data = List[UInt](x1909_sub.r)
      x1881_tmp_0.connectWPort(1913, x1913_wr_banks, x1913_wr_ofs, x1913_wr_data, x1913_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3516 & x3517 & x3519))
      val x1914_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1914_wr_ofs = List[UInt](x3518.r)
      val x1914_wr_en = List[Bool](true.B)
      val x1914_wr_data = List[UInt](x1909_sub.r)
      x1885_tmp_4.connectWPort(1914, x1914_wr_banks, x1914_wr_ofs, x1914_wr_data, x1914_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3516 & x3517 & x3519))
    }
    val module = Module(new x1915_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1915_inr_Foreach **/
