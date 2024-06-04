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

/** Hierarchy: x1965 -> x1966 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1965_inr_UnitPipe **/
class x1965_inr_UnitPipe_kernel(
  list_b1879: List[Bool],
  list_x1939_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1965_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1965_inr_UnitPipe_iiCtr"))
  
  abstract class x1965_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1879 = Input(Bool())
      val in_x1939_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1939_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1887_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1887_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1886_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1886_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1888_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1888_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1879 = {io.in_b1879} 
    def x1939_r_0 = {io.in_x1939_r_0} ; io.in_x1939_r_0 := DontCare
    def x1887_tmp_1 = {io.in_x1887_tmp_1} ; io.in_x1887_tmp_1 := DontCare
    def x1886_tmp_0 = {io.in_x1886_tmp_0} ; io.in_x1886_tmp_0 := DontCare
    def x1888_tmp_2 = {io.in_x1888_tmp_2} ; io.in_x1888_tmp_2 := DontCare
    def b563 = {io.in_b563} 
  }
  def connectWires0(module: x1965_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1879 <> b1879
    x1939_r_0.connectLedger(module.io.in_x1939_r_0)
    x1887_tmp_1.connectLedger(module.io.in_x1887_tmp_1)
    x1886_tmp_0.connectLedger(module.io.in_x1886_tmp_0)
    x1888_tmp_2.connectLedger(module.io.in_x1888_tmp_2)
    module.io.in_b563 <> b563
  }
  val b1879 = list_b1879(0)
  val b563 = list_b1879(1)
  val x1939_r_0 = list_x1939_r_0(0)
  val x1887_tmp_1 = list_x1939_r_0(1)
  val x1886_tmp_0 = list_x1939_r_0(2)
  val x1888_tmp_2 = list_x1939_r_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1965_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1965_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1965_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1965_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1965_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1965_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1965_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1965_instrctr, cycles_x1965_inr_UnitPipe.io.count, iters_x1965_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1953_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1953_rd""")
      val x1953_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1953_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1953_rd_en = List[Bool](true.B)
      val x1953_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1953_rd_shared_en")
      x1953_rd.toSeq.zip(x1886_tmp_0.connectRPort(1953, x1953_rd_banks, x1953_rd_ofs, io.sigsIn.backpressure, x1953_rd_en.map(_ && x1953_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1954 = VecApply(x1953,0)
      val x1954_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1954_elem_0""")
      x1954_elem_0.r := x1953_rd(0).r
      val x1956_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1956_rd""")
      val x1956_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1956_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1956_rd_en = List[Bool](true.B)
      val x1956_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1956_rd_shared_en")
      x1956_rd.toSeq.zip(x1887_tmp_1.connectRPort(1956, x1956_rd_banks, x1956_rd_ofs, io.sigsIn.backpressure, x1956_rd_en.map(_ && x1956_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1957 = VecApply(x1956,0)
      val x1957_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1957_elem_0""")
      x1957_elem_0.r := x1956_rd(0).r
      val x1958_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1958_mul""")
      x1958_mul.r := (Math.mul(x1957_elem_0, x1957_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1958_mul")).r
      val x3535 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3535_x1954_elem_0_D6") 
      x3535.r := getRetimed(x1954_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3059 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3059""")
      x3059.r := Math.fma(x3535,x3535,x1958_mul,Some(6.0), true.B, "x3059").toFixed(x3059, "cast_x3059").r
      val x1960_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1960_rd""")
      val x1960_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1960_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1960_rd_en = List[Bool](true.B)
      val x1960_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1960_rd_shared_en")
      x1960_rd.toSeq.zip(x1888_tmp_2.connectRPort(1960, x1960_rd_banks, x1960_rd_ofs, io.sigsIn.backpressure, x1960_rd_en.map(_ && x1960_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1961 = VecApply(x1960,0)
      val x1961_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1961_elem_0""")
      x1961_elem_0.r := x1960_rd(0).r
      val x3536 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3536_x1961_elem_0_D12") 
      x3536.r := getRetimed(x1961_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3060 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3060""")
      x3060.r := Math.fma(x3536,x3536,x3059,Some(6.0), true.B, "x3060").toFixed(x3060, "cast_x3060").r
      val x1964_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1964_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1964_wr_en = List[Bool](true.B)
      val x1964_wr_data = List[UInt](x3060.r)
      x1939_r_0.connectWPort(1964, x1964_wr_banks, x1964_wr_ofs, x1964_wr_data, x1964_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1965_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1965_inr_UnitPipe **/
