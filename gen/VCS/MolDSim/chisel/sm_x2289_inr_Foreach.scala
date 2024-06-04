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

/** Hierarchy: x2289 -> x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2289_inr_Foreach **/
class x2289_inr_Foreach_kernel(
  list_b564: List[Bool],
  list_b2083: List[FixedPoint],
  list_x581_accum_0: List[StandardInterface],
  list_x582_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x2289_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2289_inr_Foreach_iiCtr"))
  
  abstract class x2289_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x582_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x582_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x2093_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2093_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b2083 = Input(new FixedPoint(true, 32, 0))
      val in_x581_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x581_accum_0_p").asInstanceOf[MemParams] ))
      val in_x2098_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2098_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b564 = Input(Bool())
      val in_b2087 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x582_accum_1 = {io.in_x582_accum_1} ; io.in_x582_accum_1 := DontCare
    def x2093_tmp_4 = {io.in_x2093_tmp_4} ; io.in_x2093_tmp_4 := DontCare
    def b2083 = {io.in_b2083} 
    def x581_accum_0 = {io.in_x581_accum_0} ; io.in_x581_accum_0 := DontCare
    def x2098_tmp_4 = {io.in_x2098_tmp_4} ; io.in_x2098_tmp_4 := DontCare
    def b564 = {io.in_b564} 
    def b2087 = {io.in_b2087} 
  }
  def connectWires0(module: x2289_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x582_accum_1.connectLedger(module.io.in_x582_accum_1)
    x2093_tmp_4.connectLedger(module.io.in_x2093_tmp_4)
    module.io.in_b2083 <> b2083
    x581_accum_0.connectLedger(module.io.in_x581_accum_0)
    x2098_tmp_4.connectLedger(module.io.in_x2098_tmp_4)
    module.io.in_b564 <> b564
    module.io.in_b2087 <> b2087
  }
  val b564 = list_b564(0)
  val b2087 = list_b564(1)
  val b2083 = list_b2083(0)
  val x581_accum_0 = list_x581_accum_0(0)
  val x582_accum_1 = list_x582_accum_1(0)
  val x2093_tmp_4 = list_x582_accum_1(1)
  val x2098_tmp_4 = list_x582_accum_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2289_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2289_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2289_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2289_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2289_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2289_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2289_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2289_instrctr, cycles_x2289_inr_Foreach.io.count, iters_x2289_inr_Foreach.io.count, 0.U, 0.U)
      val b2085 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2085.suggestName("b2085")
      val b2088 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2088.suggestName("b2088")
      val x2270_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2270_rd""")
      val x2270_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2270_rd_ofs = List[UInt](b2085.r)
      val x2270_rd_en = List[Bool](true.B)
      val x2270_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2088 & b564 ).suggestName("x2270_rd_shared_en")
      x2270_rd.toSeq.zip(x2093_tmp_4.connectRPort(2270, x2270_rd_banks, x2270_rd_ofs, io.sigsIn.backpressure, x2270_rd_en.map(_ && x2270_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2271 = VecApply(x2270,0)
      val x2271_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2271_elem_0""")
      x2271_elem_0.r := x2270_rd(0).r
      val x2272_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2272_rd""")
      val x2272_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2272_rd_ofs = List[UInt](b2085.r)
      val x2272_rd_en = List[Bool](true.B)
      val x2272_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2088 & b564 ).suggestName("x2272_rd_shared_en")
      x2272_rd.toSeq.zip(x2098_tmp_4.connectRPort(2272, x2272_rd_banks, x2272_rd_ofs, io.sigsIn.backpressure, x2272_rd_en.map(_ && x2272_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2273 = VecApply(x2272,0)
      val x2273_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2273_elem_0""")
      x2273_elem_0.r := x2272_rd(0).r
      val x3618 = Wire(Bool()).suggestName("x3618_b564_D1") 
      x3618.r := getRetimed(b564.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3619 = Wire(Bool()).suggestName("x3619_b2088_D1") 
      x3619.r := getRetimed(b2088.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3620 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3620_b2085_D1") 
      x3620.r := getRetimed(b2085.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2274_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2274_rd""")
      val x2274_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2274_rd_ofs = List[UInt](x3620.r)
      val x2274_rd_en = List[Bool](true.B)
      val x2274_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3619 & x3618 ).suggestName("x2274_rd_shared_en")
      x2274_rd.toSeq.zip(x581_accum_0.connectRPort(2274, x2274_rd_banks, x2274_rd_ofs, io.sigsIn.backpressure, x2274_rd_en.map(_ && x2274_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2275 = VecApply(x2274,0)
      val x2275_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2275_elem_0""")
      x2275_elem_0.r := x2274_rd(0).r
      val x2276 = Wire(Bool()).suggestName("""x2276""")
      x2276 := b2088 & b564
      val x2278 = Wire(Bool()).suggestName("""x2278""")
      x2278 := b2087 & b564
      val x2280 = Wire(Bool()).suggestName("""x2280""")
      x2280 := x2278 & x2276
      val x2281_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2281_sum""")
      x2281_sum.r := Math.add(x2271_elem_0,x2273_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2281_sum").r
      val x3621 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3621_x2271_elem_0_D1") 
      x3621.r := getRetimed(x2271_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3622 = Wire(Bool()).suggestName("x3622_x2280_D3") 
      x3622.r := getRetimed(x2280.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x2282 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2282""")
      x2282.r := Mux((x3622), x2281_sum.r, x3621.r)
      val x2284 = Wire(Bool()).suggestName("""x2284""")
      x2284.r := Math.eql(b2083, 0L.FP(true, 32, 0), Some(0.2), true.B,"x2284").r
      val x2285_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2285_sum""")
      x2285_sum.r := Math.add(x2282,x2275_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x2285_sum").r
      val x3623 = Wire(Bool()).suggestName("x3623_x2284_D4") 
      x3623.r := getRetimed(x2284.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x3624 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3624_x2282_D1") 
      x3624.r := getRetimed(x2282.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x2286 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2286""")
      x2286.r := Mux((x3623), x3624.r, x2285_sum.r)
      val x3625 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3625_x2286_D1") 
      x3625.r := getRetimed(x2286.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3626 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3626_b2085_D5") 
      x3626.r := getRetimed(b2085.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3627 = Wire(Bool()).suggestName("x3627_b2088_D5") 
      x3627.r := getRetimed(b2088.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3628 = Wire(Bool()).suggestName("x3628_b564_D5") 
      x3628.r := getRetimed(b564.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x2287_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2287_wr_ofs = List[UInt](x3626.r)
      val x2287_wr_en = List[Bool](true.B)
      val x2287_wr_data = List[UInt](x3625.r)
      x582_accum_1.connectWPort(2287, x2287_wr_banks, x2287_wr_ofs, x2287_wr_data, x2287_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3627 & x3628))
      val x2288_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2288_wr_ofs = List[UInt](x3626.r)
      val x2288_wr_en = List[Bool](true.B)
      val x2288_wr_data = List[UInt](x3625.r)
      x581_accum_0.connectWPort(2288, x2288_wr_banks, x2288_wr_ofs, x2288_wr_data, x2288_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3627 & x3628))
      x2093_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x2098_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x2289_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2289_inr_Foreach **/
