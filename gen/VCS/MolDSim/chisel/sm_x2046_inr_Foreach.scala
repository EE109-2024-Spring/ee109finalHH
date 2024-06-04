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

/** Hierarchy: x2046 -> x2061 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2046_inr_Foreach **/
class x2046_inr_Foreach_kernel(
  list_b1878: List[Bool],
  list_x1882_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x2046_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x2046_inr_Foreach_iiCtr"))
  
  abstract class x2046_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1882_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1882_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1967_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1967_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1883_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1883_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1878 = Input(Bool())
      val in_x1884_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1884_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_x1881_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1881_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1885_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1885_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1882_tmp_1 = {io.in_x1882_tmp_1} ; io.in_x1882_tmp_1 := DontCare
    def x1967_force_0 = {io.in_x1967_force_0} ; io.in_x1967_force_0 := DontCare
    def x1883_tmp_2 = {io.in_x1883_tmp_2} ; io.in_x1883_tmp_2 := DontCare
    def b1878 = {io.in_b1878} 
    def x1884_tmp_3 = {io.in_x1884_tmp_3} ; io.in_x1884_tmp_3 := DontCare
    def b563 = {io.in_b563} 
    def x1881_tmp_0 = {io.in_x1881_tmp_0} ; io.in_x1881_tmp_0 := DontCare
    def x1885_tmp_4 = {io.in_x1885_tmp_4} ; io.in_x1885_tmp_4 := DontCare
  }
  def connectWires0(module: x2046_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1882_tmp_1.connectLedger(module.io.in_x1882_tmp_1)
    x1967_force_0.connectLedger(module.io.in_x1967_force_0)
    x1883_tmp_2.connectLedger(module.io.in_x1883_tmp_2)
    module.io.in_b1878 <> b1878
    x1884_tmp_3.connectLedger(module.io.in_x1884_tmp_3)
    module.io.in_b563 <> b563
    x1881_tmp_0.connectLedger(module.io.in_x1881_tmp_0)
    x1885_tmp_4.connectLedger(module.io.in_x1885_tmp_4)
  }
  val b1878 = list_b1878(0)
  val b563 = list_b1878(1)
  val x1882_tmp_1 = list_x1882_tmp_1(0)
  val x1967_force_0 = list_x1882_tmp_1(1)
  val x1883_tmp_2 = list_x1882_tmp_1(2)
  val x1884_tmp_3 = list_x1882_tmp_1(3)
  val x1881_tmp_0 = list_x1882_tmp_1(4)
  val x1885_tmp_4 = list_x1882_tmp_1(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2046_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2046_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2046_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2046_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2046_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2046_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2046_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2046_instrctr, cycles_x2046_inr_Foreach.io.count, iters_x2046_inr_Foreach.io.count, 0.U, 0.U)
      val b2033 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2033.suggestName("b2033")
      val b2034 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2034.suggestName("b2034")
      val x2035_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2035_rd""")
      val x2035_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2035_rd_ofs = List[UInt](b2033.r)
      val x2035_rd_en = List[Bool](true.B)
      val x2035_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2034 & b1878 & b563 ).suggestName("x2035_rd_shared_en")
      x2035_rd.toSeq.zip(x1884_tmp_3.connectRPort(2035, x2035_rd_banks, x2035_rd_ofs, io.sigsIn.backpressure, x2035_rd_en.map(_ && x2035_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2036 = VecApply(x2035,0)
      val x2036_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2036_elem_0""")
      x2036_elem_0.r := x2035_rd(0).r
      val x2037_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2037_mul""")
      x2037_mul.r := (Math.mul(x2036_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x2037_mul")).r
      val x2038_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2038_rd""")
      val x2038_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2038_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2038_rd_en = List[Bool](true.B)
      val x2038_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2034 & b1878 & b563 ).suggestName("x2038_rd_shared_en")
      x2038_rd.toSeq.zip(x1967_force_0.connectRPort(2038, x2038_rd_banks, x2038_rd_ofs, io.sigsIn.backpressure, x2038_rd_en.map(_ && x2038_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2039 = VecApply(x2038,0)
      val x2039_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2039_elem_0""")
      x2039_elem_0.r := x2038_rd(0).r
      val x3547 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3547_x2039_elem_0_D6") 
      x3547.r := getRetimed(x2039_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2040_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2040_mul""")
      x2040_mul.r := (Math.mul(x2037_mul, x3547, Some(6.0), true.B, Truncate, Wrapping, "x2040_mul")).r
      val x3548 = Wire(Bool()).suggestName("x3548_b2034_D14") 
      x3548.r := getRetimed(b2034.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3549 = Wire(Bool()).suggestName("x3549_b1878_D14") 
      x3549.r := getRetimed(b1878.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3550 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3550_b2033_D14") 
      x3550.r := getRetimed(b2033.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3551 = Wire(Bool()).suggestName("x3551_b563_D14") 
      x3551.r := getRetimed(b563.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x2041_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2041_wr_ofs = List[UInt](x3550.r)
      val x2041_wr_en = List[Bool](true.B)
      val x2041_wr_data = List[UInt](x2040_mul.r)
      x1882_tmp_1.connectWPort(2041, x2041_wr_banks, x2041_wr_ofs, x2041_wr_data, x2041_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3548 & x3549 & x3551))
      val x2042_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2042_wr_ofs = List[UInt](x3550.r)
      val x2042_wr_en = List[Bool](true.B)
      val x2042_wr_data = List[UInt](x2040_mul.r)
      x1883_tmp_2.connectWPort(2042, x2042_wr_banks, x2042_wr_ofs, x2042_wr_data, x2042_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3548 & x3549 & x3551))
      val x2043_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2043_wr_ofs = List[UInt](x3550.r)
      val x2043_wr_en = List[Bool](true.B)
      val x2043_wr_data = List[UInt](x2040_mul.r)
      x1884_tmp_3.connectWPort(2043, x2043_wr_banks, x2043_wr_ofs, x2043_wr_data, x2043_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3548 & x3549 & x3551))
      val x2044_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2044_wr_ofs = List[UInt](x3550.r)
      val x2044_wr_en = List[Bool](true.B)
      val x2044_wr_data = List[UInt](x2040_mul.r)
      x1881_tmp_0.connectWPort(2044, x2044_wr_banks, x2044_wr_ofs, x2044_wr_data, x2044_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3548 & x3549 & x3551))
      val x2045_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2045_wr_ofs = List[UInt](x3550.r)
      val x2045_wr_en = List[Bool](true.B)
      val x2045_wr_data = List[UInt](x2040_mul.r)
      x1885_tmp_4.connectWPort(2045, x2045_wr_banks, x2045_wr_ofs, x2045_wr_data, x2045_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3548 & x3549 & x3551))
    }
    val module = Module(new x2046_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2046_inr_Foreach **/
