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

/** Hierarchy: x2462 -> x2477 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2462_inr_Foreach **/
class x2462_inr_Foreach_kernel(
  list_b565: List[Bool],
  list_x2301_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x2462_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x2462_inr_Foreach_iiCtr"))
  
  abstract class x2462_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b565 = Input(Bool())
      val in_x2301_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2301_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2300_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2300_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2383_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2383_force_0_p").asInstanceOf[NBufParams] ))
      val in_x2299_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2299_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2298_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2298_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b2294 = Input(Bool())
      val in_x2297_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2297_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b565 = {io.in_b565} 
    def x2301_tmp_4 = {io.in_x2301_tmp_4} ; io.in_x2301_tmp_4 := DontCare
    def x2300_tmp_3 = {io.in_x2300_tmp_3} ; io.in_x2300_tmp_3 := DontCare
    def x2383_force_0 = {io.in_x2383_force_0} ; io.in_x2383_force_0 := DontCare
    def x2299_tmp_2 = {io.in_x2299_tmp_2} ; io.in_x2299_tmp_2 := DontCare
    def x2298_tmp_1 = {io.in_x2298_tmp_1} ; io.in_x2298_tmp_1 := DontCare
    def b2294 = {io.in_b2294} 
    def x2297_tmp_0 = {io.in_x2297_tmp_0} ; io.in_x2297_tmp_0 := DontCare
  }
  def connectWires0(module: x2462_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b565 <> b565
    x2301_tmp_4.connectLedger(module.io.in_x2301_tmp_4)
    x2300_tmp_3.connectLedger(module.io.in_x2300_tmp_3)
    x2383_force_0.connectLedger(module.io.in_x2383_force_0)
    x2299_tmp_2.connectLedger(module.io.in_x2299_tmp_2)
    x2298_tmp_1.connectLedger(module.io.in_x2298_tmp_1)
    module.io.in_b2294 <> b2294
    x2297_tmp_0.connectLedger(module.io.in_x2297_tmp_0)
  }
  val b565 = list_b565(0)
  val b2294 = list_b565(1)
  val x2301_tmp_4 = list_x2301_tmp_4(0)
  val x2300_tmp_3 = list_x2301_tmp_4(1)
  val x2383_force_0 = list_x2301_tmp_4(2)
  val x2299_tmp_2 = list_x2301_tmp_4(3)
  val x2298_tmp_1 = list_x2301_tmp_4(4)
  val x2297_tmp_0 = list_x2301_tmp_4(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2462_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2462_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2462_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2462_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2462_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2462_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2462_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2462_instrctr, cycles_x2462_inr_Foreach.io.count, iters_x2462_inr_Foreach.io.count, 0.U, 0.U)
      val b2449 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2449.suggestName("b2449")
      val b2450 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2450.suggestName("b2450")
      val x2451_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2451_rd""")
      val x2451_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2451_rd_ofs = List[UInt](b2449.r)
      val x2451_rd_en = List[Bool](true.B)
      val x2451_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2450 & b2294 & b565 ).suggestName("x2451_rd_shared_en")
      x2451_rd.toSeq.zip(x2300_tmp_3.connectRPort(2451, x2451_rd_banks, x2451_rd_ofs, io.sigsIn.backpressure, x2451_rd_en.map(_ && x2451_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2452 = VecApply(x2451,0)
      val x2452_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2452_elem_0""")
      x2452_elem_0.r := x2451_rd(0).r
      val x2453_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2453_mul""")
      x2453_mul.r := (Math.mul(x2452_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x2453_mul")).r
      val x2454_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2454_rd""")
      val x2454_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2454_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2454_rd_en = List[Bool](true.B)
      val x2454_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2450 & b2294 & b565 ).suggestName("x2454_rd_shared_en")
      x2454_rd.toSeq.zip(x2383_force_0.connectRPort(2454, x2454_rd_banks, x2454_rd_ofs, io.sigsIn.backpressure, x2454_rd_en.map(_ && x2454_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2455 = VecApply(x2454,0)
      val x2455_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2455_elem_0""")
      x2455_elem_0.r := x2454_rd(0).r
      val x3669 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3669_x2455_elem_0_D6") 
      x3669.r := getRetimed(x2455_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2456_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2456_mul""")
      x2456_mul.r := (Math.mul(x2453_mul, x3669, Some(6.0), true.B, Truncate, Wrapping, "x2456_mul")).r
      val x3670 = Wire(Bool()).suggestName("x3670_b565_D14") 
      x3670.r := getRetimed(b565.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3671 = Wire(Bool()).suggestName("x3671_b2450_D14") 
      x3671.r := getRetimed(b2450.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3672 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3672_b2449_D14") 
      x3672.r := getRetimed(b2449.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3673 = Wire(Bool()).suggestName("x3673_b2294_D14") 
      x3673.r := getRetimed(b2294.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x2457_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2457_wr_ofs = List[UInt](x3672.r)
      val x2457_wr_en = List[Bool](true.B)
      val x2457_wr_data = List[UInt](x2456_mul.r)
      x2301_tmp_4.connectWPort(2457, x2457_wr_banks, x2457_wr_ofs, x2457_wr_data, x2457_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3671 & x3673 & x3670))
      val x2458_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2458_wr_ofs = List[UInt](x3672.r)
      val x2458_wr_en = List[Bool](true.B)
      val x2458_wr_data = List[UInt](x2456_mul.r)
      x2300_tmp_3.connectWPort(2458, x2458_wr_banks, x2458_wr_ofs, x2458_wr_data, x2458_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3671 & x3673 & x3670))
      val x2459_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2459_wr_ofs = List[UInt](x3672.r)
      val x2459_wr_en = List[Bool](true.B)
      val x2459_wr_data = List[UInt](x2456_mul.r)
      x2299_tmp_2.connectWPort(2459, x2459_wr_banks, x2459_wr_ofs, x2459_wr_data, x2459_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3671 & x3673 & x3670))
      val x2460_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2460_wr_ofs = List[UInt](x3672.r)
      val x2460_wr_en = List[Bool](true.B)
      val x2460_wr_data = List[UInt](x2456_mul.r)
      x2298_tmp_1.connectWPort(2460, x2460_wr_banks, x2460_wr_ofs, x2460_wr_data, x2460_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3671 & x3673 & x3670))
      val x2461_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2461_wr_ofs = List[UInt](x3672.r)
      val x2461_wr_en = List[Bool](true.B)
      val x2461_wr_data = List[UInt](x2456_mul.r)
      x2297_tmp_0.connectWPort(2461, x2461_wr_banks, x2461_wr_ofs, x2461_wr_data, x2461_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3671 & x3673 & x3670))
    }
    val module = Module(new x2462_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2462_inr_Foreach **/
