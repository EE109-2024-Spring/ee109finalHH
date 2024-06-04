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

/** Hierarchy: x2670 -> x2685 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2670_inr_Foreach **/
class x2670_inr_Foreach_kernel(
  list_b566: List[Bool],
  list_x2508_tmp_3: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x2670_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x2670_inr_Foreach_iiCtr"))
  
  abstract class x2670_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2508_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2508_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_x2509_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2509_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2505_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2505_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2506_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2506_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2591_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2591_force_0_p").asInstanceOf[NBufParams] ))
      val in_b2502 = Input(Bool())
      val in_x2507_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2507_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2508_tmp_3 = {io.in_x2508_tmp_3} ; io.in_x2508_tmp_3 := DontCare
    def b566 = {io.in_b566} 
    def x2509_tmp_4 = {io.in_x2509_tmp_4} ; io.in_x2509_tmp_4 := DontCare
    def x2505_tmp_0 = {io.in_x2505_tmp_0} ; io.in_x2505_tmp_0 := DontCare
    def x2506_tmp_1 = {io.in_x2506_tmp_1} ; io.in_x2506_tmp_1 := DontCare
    def x2591_force_0 = {io.in_x2591_force_0} ; io.in_x2591_force_0 := DontCare
    def b2502 = {io.in_b2502} 
    def x2507_tmp_2 = {io.in_x2507_tmp_2} ; io.in_x2507_tmp_2 := DontCare
  }
  def connectWires0(module: x2670_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x2508_tmp_3.connectLedger(module.io.in_x2508_tmp_3)
    module.io.in_b566 <> b566
    x2509_tmp_4.connectLedger(module.io.in_x2509_tmp_4)
    x2505_tmp_0.connectLedger(module.io.in_x2505_tmp_0)
    x2506_tmp_1.connectLedger(module.io.in_x2506_tmp_1)
    x2591_force_0.connectLedger(module.io.in_x2591_force_0)
    module.io.in_b2502 <> b2502
    x2507_tmp_2.connectLedger(module.io.in_x2507_tmp_2)
  }
  val b566 = list_b566(0)
  val b2502 = list_b566(1)
  val x2508_tmp_3 = list_x2508_tmp_3(0)
  val x2509_tmp_4 = list_x2508_tmp_3(1)
  val x2505_tmp_0 = list_x2508_tmp_3(2)
  val x2506_tmp_1 = list_x2508_tmp_3(3)
  val x2591_force_0 = list_x2508_tmp_3(4)
  val x2507_tmp_2 = list_x2508_tmp_3(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2670_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2670_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2670_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2670_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2670_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2670_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2670_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2670_instrctr, cycles_x2670_inr_Foreach.io.count, iters_x2670_inr_Foreach.io.count, 0.U, 0.U)
      val b2657 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2657.suggestName("b2657")
      val b2658 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2658.suggestName("b2658")
      val x2659_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2659_rd""")
      val x2659_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2659_rd_ofs = List[UInt](b2657.r)
      val x2659_rd_en = List[Bool](true.B)
      val x2659_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2658 & b2502 & b566 ).suggestName("x2659_rd_shared_en")
      x2659_rd.toSeq.zip(x2508_tmp_3.connectRPort(2659, x2659_rd_banks, x2659_rd_ofs, io.sigsIn.backpressure, x2659_rd_en.map(_ && x2659_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2660 = VecApply(x2659,0)
      val x2660_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2660_elem_0""")
      x2660_elem_0.r := x2659_rd(0).r
      val x2661_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2661_mul""")
      x2661_mul.r := (Math.mul(x2660_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x2661_mul")).r
      val x2662_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2662_rd""")
      val x2662_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2662_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2662_rd_en = List[Bool](true.B)
      val x2662_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2658 & b2502 & b566 ).suggestName("x2662_rd_shared_en")
      x2662_rd.toSeq.zip(x2591_force_0.connectRPort(2662, x2662_rd_banks, x2662_rd_ofs, io.sigsIn.backpressure, x2662_rd_en.map(_ && x2662_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2663 = VecApply(x2662,0)
      val x2663_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2663_elem_0""")
      x2663_elem_0.r := x2662_rd(0).r
      val x3730 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3730_x2663_elem_0_D6") 
      x3730.r := getRetimed(x2663_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2664_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2664_mul""")
      x2664_mul.r := (Math.mul(x2661_mul, x3730, Some(6.0), true.B, Truncate, Wrapping, "x2664_mul")).r
      val x3731 = Wire(Bool()).suggestName("x3731_b566_D14") 
      x3731.r := getRetimed(b566.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3732 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3732_b2657_D14") 
      x3732.r := getRetimed(b2657.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3733 = Wire(Bool()).suggestName("x3733_b2658_D14") 
      x3733.r := getRetimed(b2658.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3734 = Wire(Bool()).suggestName("x3734_b2502_D14") 
      x3734.r := getRetimed(b2502.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x2665_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2665_wr_ofs = List[UInt](x3732.r)
      val x2665_wr_en = List[Bool](true.B)
      val x2665_wr_data = List[UInt](x2664_mul.r)
      x2508_tmp_3.connectWPort(2665, x2665_wr_banks, x2665_wr_ofs, x2665_wr_data, x2665_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3733 & x3734 & x3731))
      val x2666_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2666_wr_ofs = List[UInt](x3732.r)
      val x2666_wr_en = List[Bool](true.B)
      val x2666_wr_data = List[UInt](x2664_mul.r)
      x2509_tmp_4.connectWPort(2666, x2666_wr_banks, x2666_wr_ofs, x2666_wr_data, x2666_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3733 & x3734 & x3731))
      val x2667_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2667_wr_ofs = List[UInt](x3732.r)
      val x2667_wr_en = List[Bool](true.B)
      val x2667_wr_data = List[UInt](x2664_mul.r)
      x2505_tmp_0.connectWPort(2667, x2667_wr_banks, x2667_wr_ofs, x2667_wr_data, x2667_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3733 & x3734 & x3731))
      val x2668_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2668_wr_ofs = List[UInt](x3732.r)
      val x2668_wr_en = List[Bool](true.B)
      val x2668_wr_data = List[UInt](x2664_mul.r)
      x2506_tmp_1.connectWPort(2668, x2668_wr_banks, x2668_wr_ofs, x2668_wr_data, x2668_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3733 & x3734 & x3731))
      val x2669_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2669_wr_ofs = List[UInt](x3732.r)
      val x2669_wr_en = List[Bool](true.B)
      val x2669_wr_data = List[UInt](x2664_mul.r)
      x2507_tmp_2.connectWPort(2669, x2669_wr_banks, x2669_wr_ofs, x2669_wr_data, x2669_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3733 & x3734 & x3731))
    }
    val module = Module(new x2670_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2670_inr_Foreach **/
