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

/** Hierarchy: x2173 -> x2174 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2173_inr_UnitPipe **/
class x2173_inr_UnitPipe_kernel(
  list_b564: List[Bool],
  list_x2094_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x2173_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2173_inr_UnitPipe_iiCtr"))
  
  abstract class x2173_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2094_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2094_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2147_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2147_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2096_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2096_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2095_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2095_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b564 = Input(Bool())
      val in_b2087 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2094_tmp_0 = {io.in_x2094_tmp_0} ; io.in_x2094_tmp_0 := DontCare
    def x2147_r_0 = {io.in_x2147_r_0} ; io.in_x2147_r_0 := DontCare
    def x2096_tmp_2 = {io.in_x2096_tmp_2} ; io.in_x2096_tmp_2 := DontCare
    def x2095_tmp_1 = {io.in_x2095_tmp_1} ; io.in_x2095_tmp_1 := DontCare
    def b564 = {io.in_b564} 
    def b2087 = {io.in_b2087} 
  }
  def connectWires0(module: x2173_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2094_tmp_0.connectLedger(module.io.in_x2094_tmp_0)
    x2147_r_0.connectLedger(module.io.in_x2147_r_0)
    x2096_tmp_2.connectLedger(module.io.in_x2096_tmp_2)
    x2095_tmp_1.connectLedger(module.io.in_x2095_tmp_1)
    module.io.in_b564 <> b564
    module.io.in_b2087 <> b2087
  }
  val b564 = list_b564(0)
  val b2087 = list_b564(1)
  val x2094_tmp_0 = list_x2094_tmp_0(0)
  val x2147_r_0 = list_x2094_tmp_0(1)
  val x2096_tmp_2 = list_x2094_tmp_0(2)
  val x2095_tmp_1 = list_x2094_tmp_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2173_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2173_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2173_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2173_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2173_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2173_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2173_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2173_instrctr, cycles_x2173_inr_UnitPipe.io.count, iters_x2173_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2161_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2161_rd""")
      val x2161_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2161_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2161_rd_en = List[Bool](true.B)
      val x2161_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2161_rd_shared_en")
      x2161_rd.toSeq.zip(x2094_tmp_0.connectRPort(2161, x2161_rd_banks, x2161_rd_ofs, io.sigsIn.backpressure, x2161_rd_en.map(_ && x2161_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2162 = VecApply(x2161,0)
      val x2162_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2162_elem_0""")
      x2162_elem_0.r := x2161_rd(0).r
      val x2164_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2164_rd""")
      val x2164_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2164_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x2164_rd_en = List[Bool](true.B)
      val x2164_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2164_rd_shared_en")
      x2164_rd.toSeq.zip(x2095_tmp_1.connectRPort(2164, x2164_rd_banks, x2164_rd_ofs, io.sigsIn.backpressure, x2164_rd_en.map(_ && x2164_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2165 = VecApply(x2164,0)
      val x2165_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2165_elem_0""")
      x2165_elem_0.r := x2164_rd(0).r
      val x2166_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2166_mul""")
      x2166_mul.r := (Math.mul(x2165_elem_0, x2165_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x2166_mul")).r
      val x3596 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3596_x2162_elem_0_D6") 
      x3596.r := getRetimed(x2162_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3071 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3071""")
      x3071.r := Math.fma(x3596,x3596,x2166_mul,Some(6.0), true.B, "x3071").toFixed(x3071, "cast_x3071").r
      val x2168_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2168_rd""")
      val x2168_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2168_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x2168_rd_en = List[Bool](true.B)
      val x2168_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2168_rd_shared_en")
      x2168_rd.toSeq.zip(x2096_tmp_2.connectRPort(2168, x2168_rd_banks, x2168_rd_ofs, io.sigsIn.backpressure, x2168_rd_en.map(_ && x2168_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2169 = VecApply(x2168,0)
      val x2169_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2169_elem_0""")
      x2169_elem_0.r := x2168_rd(0).r
      val x3597 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3597_x2169_elem_0_D12") 
      x3597.r := getRetimed(x2169_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3072 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3072""")
      x3072.r := Math.fma(x3597,x3597,x3071,Some(6.0), true.B, "x3072").toFixed(x3072, "cast_x3072").r
      val x2172_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2172_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2172_wr_en = List[Bool](true.B)
      val x2172_wr_data = List[UInt](x3072.r)
      x2147_r_0.connectWPort(2172, x2172_wr_banks, x2172_wr_ofs, x2172_wr_data, x2172_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2173_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2173_inr_UnitPipe **/
