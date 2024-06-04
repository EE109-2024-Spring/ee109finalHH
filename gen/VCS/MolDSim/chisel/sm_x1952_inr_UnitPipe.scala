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

/** Hierarchy: x1952 -> x1966 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1952_inr_UnitPipe **/
class x1952_inr_UnitPipe_kernel(
  list_b1878: List[Bool],
  list_x1882_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1952_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1952_inr_UnitPipe_iiCtr"))
  
  abstract class x1952_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1882_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1882_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1883_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1883_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1938_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1938_r_0_p").asInstanceOf[NBufParams] ))
      val in_b1878 = Input(Bool())
      val in_b563 = Input(Bool())
      val in_x1881_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1881_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1882_tmp_1 = {io.in_x1882_tmp_1} ; io.in_x1882_tmp_1 := DontCare
    def x1883_tmp_2 = {io.in_x1883_tmp_2} ; io.in_x1883_tmp_2 := DontCare
    def x1938_r_0 = {io.in_x1938_r_0} ; io.in_x1938_r_0 := DontCare
    def b1878 = {io.in_b1878} 
    def b563 = {io.in_b563} 
    def x1881_tmp_0 = {io.in_x1881_tmp_0} ; io.in_x1881_tmp_0 := DontCare
  }
  def connectWires0(module: x1952_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1882_tmp_1.connectLedger(module.io.in_x1882_tmp_1)
    x1883_tmp_2.connectLedger(module.io.in_x1883_tmp_2)
    x1938_r_0.connectLedger(module.io.in_x1938_r_0)
    module.io.in_b1878 <> b1878
    module.io.in_b563 <> b563
    x1881_tmp_0.connectLedger(module.io.in_x1881_tmp_0)
  }
  val b1878 = list_b1878(0)
  val b563 = list_b1878(1)
  val x1882_tmp_1 = list_x1882_tmp_1(0)
  val x1883_tmp_2 = list_x1882_tmp_1(1)
  val x1938_r_0 = list_x1882_tmp_1(2)
  val x1881_tmp_0 = list_x1882_tmp_1(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1952_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1952_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1952_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1952_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1952_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1952_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1952_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1952_instrctr, cycles_x1952_inr_UnitPipe.io.count, iters_x1952_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1940_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1940_rd""")
      val x1940_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1940_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1940_rd_en = List[Bool](true.B)
      val x1940_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1940_rd_shared_en")
      x1940_rd.toSeq.zip(x1881_tmp_0.connectRPort(1940, x1940_rd_banks, x1940_rd_ofs, io.sigsIn.backpressure, x1940_rd_en.map(_ && x1940_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1941 = VecApply(x1940,0)
      val x1941_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1941_elem_0""")
      x1941_elem_0.r := x1940_rd(0).r
      val x1943_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1943_rd""")
      val x1943_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1943_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1943_rd_en = List[Bool](true.B)
      val x1943_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1943_rd_shared_en")
      x1943_rd.toSeq.zip(x1882_tmp_1.connectRPort(1943, x1943_rd_banks, x1943_rd_ofs, io.sigsIn.backpressure, x1943_rd_en.map(_ && x1943_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1944 = VecApply(x1943,0)
      val x1944_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1944_elem_0""")
      x1944_elem_0.r := x1943_rd(0).r
      val x1945_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1945_mul""")
      x1945_mul.r := (Math.mul(x1944_elem_0, x1944_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1945_mul")).r
      val x3533 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3533_x1941_elem_0_D6") 
      x3533.r := getRetimed(x1941_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3057 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3057""")
      x3057.r := Math.fma(x3533,x3533,x1945_mul,Some(6.0), true.B, "x3057").toFixed(x3057, "cast_x3057").r
      val x1947_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1947_rd""")
      val x1947_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1947_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1947_rd_en = List[Bool](true.B)
      val x1947_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1947_rd_shared_en")
      x1947_rd.toSeq.zip(x1883_tmp_2.connectRPort(1947, x1947_rd_banks, x1947_rd_ofs, io.sigsIn.backpressure, x1947_rd_en.map(_ && x1947_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1948 = VecApply(x1947,0)
      val x1948_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1948_elem_0""")
      x1948_elem_0.r := x1947_rd(0).r
      val x3534 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3534_x1948_elem_0_D12") 
      x3534.r := getRetimed(x1948_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3058 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3058""")
      x3058.r := Math.fma(x3534,x3534,x3057,Some(6.0), true.B, "x3058").toFixed(x3058, "cast_x3058").r
      val x1951_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1951_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1951_wr_en = List[Bool](true.B)
      val x1951_wr_data = List[UInt](x3058.r)
      x1938_r_0.connectWPort(1951, x1951_wr_banks, x1951_wr_ofs, x1951_wr_data, x1951_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1952_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1952_inr_UnitPipe **/
