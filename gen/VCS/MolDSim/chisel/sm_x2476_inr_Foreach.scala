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

/** Hierarchy: x2476 -> x2477 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2476_inr_Foreach **/
class x2476_inr_Foreach_kernel(
  list_b2295: List[Bool],
  list_x2306_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x2476_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x2476_inr_Foreach_iiCtr"))
  
  abstract class x2476_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2295 = Input(Bool())
      val in_x2306_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2306_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b565 = Input(Bool())
      val in_x2304_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2304_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2303_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2303_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2305_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2305_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2384_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2384_force_0_p").asInstanceOf[NBufParams] ))
      val in_x2302_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2302_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b2295 = {io.in_b2295} 
    def x2306_tmp_4 = {io.in_x2306_tmp_4} ; io.in_x2306_tmp_4 := DontCare
    def b565 = {io.in_b565} 
    def x2304_tmp_2 = {io.in_x2304_tmp_2} ; io.in_x2304_tmp_2 := DontCare
    def x2303_tmp_1 = {io.in_x2303_tmp_1} ; io.in_x2303_tmp_1 := DontCare
    def x2305_tmp_3 = {io.in_x2305_tmp_3} ; io.in_x2305_tmp_3 := DontCare
    def x2384_force_0 = {io.in_x2384_force_0} ; io.in_x2384_force_0 := DontCare
    def x2302_tmp_0 = {io.in_x2302_tmp_0} ; io.in_x2302_tmp_0 := DontCare
  }
  def connectWires0(module: x2476_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2295 <> b2295
    x2306_tmp_4.connectLedger(module.io.in_x2306_tmp_4)
    module.io.in_b565 <> b565
    x2304_tmp_2.connectLedger(module.io.in_x2304_tmp_2)
    x2303_tmp_1.connectLedger(module.io.in_x2303_tmp_1)
    x2305_tmp_3.connectLedger(module.io.in_x2305_tmp_3)
    x2384_force_0.connectLedger(module.io.in_x2384_force_0)
    x2302_tmp_0.connectLedger(module.io.in_x2302_tmp_0)
  }
  val b2295 = list_b2295(0)
  val b565 = list_b2295(1)
  val x2306_tmp_4 = list_x2306_tmp_4(0)
  val x2304_tmp_2 = list_x2306_tmp_4(1)
  val x2303_tmp_1 = list_x2306_tmp_4(2)
  val x2305_tmp_3 = list_x2306_tmp_4(3)
  val x2384_force_0 = list_x2306_tmp_4(4)
  val x2302_tmp_0 = list_x2306_tmp_4(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2476_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2476_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2476_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2476_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2476_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2476_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2476_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2476_instrctr, cycles_x2476_inr_Foreach.io.count, iters_x2476_inr_Foreach.io.count, 0.U, 0.U)
      val b2463 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2463.suggestName("b2463")
      val b2464 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2464.suggestName("b2464")
      val x2465_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2465_rd""")
      val x2465_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2465_rd_ofs = List[UInt](b2463.r)
      val x2465_rd_en = List[Bool](true.B)
      val x2465_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2464 & b2295 & b565 ).suggestName("x2465_rd_shared_en")
      x2465_rd.toSeq.zip(x2305_tmp_3.connectRPort(2465, x2465_rd_banks, x2465_rd_ofs, io.sigsIn.backpressure, x2465_rd_en.map(_ && x2465_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2466 = VecApply(x2465,0)
      val x2466_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2466_elem_0""")
      x2466_elem_0.r := x2465_rd(0).r
      val x2467_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2467_mul""")
      x2467_mul.r := (Math.mul(x2466_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x2467_mul")).r
      val x2468_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2468_rd""")
      val x2468_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2468_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2468_rd_en = List[Bool](true.B)
      val x2468_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2464 & b2295 & b565 ).suggestName("x2468_rd_shared_en")
      x2468_rd.toSeq.zip(x2384_force_0.connectRPort(2468, x2468_rd_banks, x2468_rd_ofs, io.sigsIn.backpressure, x2468_rd_en.map(_ && x2468_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2469 = VecApply(x2468,0)
      val x2469_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2469_elem_0""")
      x2469_elem_0.r := x2468_rd(0).r
      val x3674 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3674_x2469_elem_0_D6") 
      x3674.r := getRetimed(x2469_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2470_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2470_mul""")
      x2470_mul.r := (Math.mul(x2467_mul, x3674, Some(6.0), true.B, Truncate, Wrapping, "x2470_mul")).r
      val x3675 = Wire(Bool()).suggestName("x3675_b2295_D14") 
      x3675.r := getRetimed(b2295.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3676 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3676_b2463_D14") 
      x3676.r := getRetimed(b2463.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3677 = Wire(Bool()).suggestName("x3677_b565_D14") 
      x3677.r := getRetimed(b565.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3678 = Wire(Bool()).suggestName("x3678_b2464_D14") 
      x3678.r := getRetimed(b2464.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x2471_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2471_wr_ofs = List[UInt](x3676.r)
      val x2471_wr_en = List[Bool](true.B)
      val x2471_wr_data = List[UInt](x2470_mul.r)
      x2306_tmp_4.connectWPort(2471, x2471_wr_banks, x2471_wr_ofs, x2471_wr_data, x2471_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3678 & x3675 & x3677))
      val x2472_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2472_wr_ofs = List[UInt](x3676.r)
      val x2472_wr_en = List[Bool](true.B)
      val x2472_wr_data = List[UInt](x2470_mul.r)
      x2304_tmp_2.connectWPort(2472, x2472_wr_banks, x2472_wr_ofs, x2472_wr_data, x2472_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3678 & x3675 & x3677))
      val x2473_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2473_wr_ofs = List[UInt](x3676.r)
      val x2473_wr_en = List[Bool](true.B)
      val x2473_wr_data = List[UInt](x2470_mul.r)
      x2303_tmp_1.connectWPort(2473, x2473_wr_banks, x2473_wr_ofs, x2473_wr_data, x2473_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3678 & x3675 & x3677))
      val x2474_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2474_wr_ofs = List[UInt](x3676.r)
      val x2474_wr_en = List[Bool](true.B)
      val x2474_wr_data = List[UInt](x2470_mul.r)
      x2305_tmp_3.connectWPort(2474, x2474_wr_banks, x2474_wr_ofs, x2474_wr_data, x2474_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3678 & x3675 & x3677))
      val x2475_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2475_wr_ofs = List[UInt](x3676.r)
      val x2475_wr_en = List[Bool](true.B)
      val x2475_wr_data = List[UInt](x2470_mul.r)
      x2302_tmp_0.connectWPort(2475, x2475_wr_banks, x2475_wr_ofs, x2475_wr_data, x2475_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3678 & x3675 & x3677))
    }
    val module = Module(new x2476_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2476_inr_Foreach **/
