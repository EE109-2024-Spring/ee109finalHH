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

/** Hierarchy: x2576 -> x2590 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2576_inr_UnitPipe **/
class x2576_inr_UnitPipe_kernel(
  list_b566: List[Bool],
  list_x2562_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x2576_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2576_inr_UnitPipe_iiCtr"))
  
  abstract class x2576_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2562_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2562_r_0_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_x2505_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2505_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2506_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2506_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b2502 = Input(Bool())
      val in_x2507_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2507_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2562_r_0 = {io.in_x2562_r_0} ; io.in_x2562_r_0 := DontCare
    def b566 = {io.in_b566} 
    def x2505_tmp_0 = {io.in_x2505_tmp_0} ; io.in_x2505_tmp_0 := DontCare
    def x2506_tmp_1 = {io.in_x2506_tmp_1} ; io.in_x2506_tmp_1 := DontCare
    def b2502 = {io.in_b2502} 
    def x2507_tmp_2 = {io.in_x2507_tmp_2} ; io.in_x2507_tmp_2 := DontCare
  }
  def connectWires0(module: x2576_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x2562_r_0.connectLedger(module.io.in_x2562_r_0)
    module.io.in_b566 <> b566
    x2505_tmp_0.connectLedger(module.io.in_x2505_tmp_0)
    x2506_tmp_1.connectLedger(module.io.in_x2506_tmp_1)
    module.io.in_b2502 <> b2502
    x2507_tmp_2.connectLedger(module.io.in_x2507_tmp_2)
  }
  val b566 = list_b566(0)
  val b2502 = list_b566(1)
  val x2562_r_0 = list_x2562_r_0(0)
  val x2505_tmp_0 = list_x2562_r_0(1)
  val x2506_tmp_1 = list_x2562_r_0(2)
  val x2507_tmp_2 = list_x2562_r_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2576_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2576_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2576_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2576_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2576_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2576_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2576_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2576_instrctr, cycles_x2576_inr_UnitPipe.io.count, iters_x2576_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2564_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2564_rd""")
      val x2564_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2564_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2564_rd_en = List[Bool](true.B)
      val x2564_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2564_rd_shared_en")
      x2564_rd.toSeq.zip(x2505_tmp_0.connectRPort(2564, x2564_rd_banks, x2564_rd_ofs, io.sigsIn.backpressure, x2564_rd_en.map(_ && x2564_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2565 = VecApply(x2564,0)
      val x2565_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2565_elem_0""")
      x2565_elem_0.r := x2564_rd(0).r
      val x2567_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2567_rd""")
      val x2567_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2567_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x2567_rd_en = List[Bool](true.B)
      val x2567_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2567_rd_shared_en")
      x2567_rd.toSeq.zip(x2506_tmp_1.connectRPort(2567, x2567_rd_banks, x2567_rd_ofs, io.sigsIn.backpressure, x2567_rd_en.map(_ && x2567_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2568 = VecApply(x2567,0)
      val x2568_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2568_elem_0""")
      x2568_elem_0.r := x2567_rd(0).r
      val x2569_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2569_mul""")
      x2569_mul.r := (Math.mul(x2568_elem_0, x2568_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x2569_mul")).r
      val x3716 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3716_x2565_elem_0_D6") 
      x3716.r := getRetimed(x2565_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3093 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3093""")
      x3093.r := Math.fma(x3716,x3716,x2569_mul,Some(6.0), true.B, "x3093").toFixed(x3093, "cast_x3093").r
      val x2571_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2571_rd""")
      val x2571_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2571_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x2571_rd_en = List[Bool](true.B)
      val x2571_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2571_rd_shared_en")
      x2571_rd.toSeq.zip(x2507_tmp_2.connectRPort(2571, x2571_rd_banks, x2571_rd_ofs, io.sigsIn.backpressure, x2571_rd_en.map(_ && x2571_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2572 = VecApply(x2571,0)
      val x2572_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2572_elem_0""")
      x2572_elem_0.r := x2571_rd(0).r
      val x3717 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3717_x2572_elem_0_D12") 
      x3717.r := getRetimed(x2572_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3094 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3094""")
      x3094.r := Math.fma(x3717,x3717,x3093,Some(6.0), true.B, "x3094").toFixed(x3094, "cast_x3094").r
      val x2575_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2575_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2575_wr_en = List[Bool](true.B)
      val x2575_wr_data = List[UInt](x3094.r)
      x2562_r_0.connectWPort(2575, x2575_wr_banks, x2575_wr_ofs, x2575_wr_data, x2575_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2576_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2576_inr_UnitPipe **/
