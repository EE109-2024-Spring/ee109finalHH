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

/** Hierarchy: x2684 -> x2685 -> x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2684_inr_Foreach **/
class x2684_inr_Foreach_kernel(
  list_b566: List[Bool],
  list_x2512_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x2684_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x2684_inr_Foreach_iiCtr"))
  
  abstract class x2684_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2512_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2512_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b566 = Input(Bool())
      val in_x2514_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x2514_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x2510_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2510_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x2592_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2592_force_0_p").asInstanceOf[NBufParams] ))
      val in_b2503 = Input(Bool())
      val in_x2513_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x2513_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x2511_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2511_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2512_tmp_2 = {io.in_x2512_tmp_2} ; io.in_x2512_tmp_2 := DontCare
    def b566 = {io.in_b566} 
    def x2514_tmp_4 = {io.in_x2514_tmp_4} ; io.in_x2514_tmp_4 := DontCare
    def x2510_tmp_0 = {io.in_x2510_tmp_0} ; io.in_x2510_tmp_0 := DontCare
    def x2592_force_0 = {io.in_x2592_force_0} ; io.in_x2592_force_0 := DontCare
    def b2503 = {io.in_b2503} 
    def x2513_tmp_3 = {io.in_x2513_tmp_3} ; io.in_x2513_tmp_3 := DontCare
    def x2511_tmp_1 = {io.in_x2511_tmp_1} ; io.in_x2511_tmp_1 := DontCare
  }
  def connectWires0(module: x2684_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x2512_tmp_2.connectLedger(module.io.in_x2512_tmp_2)
    module.io.in_b566 <> b566
    x2514_tmp_4.connectLedger(module.io.in_x2514_tmp_4)
    x2510_tmp_0.connectLedger(module.io.in_x2510_tmp_0)
    x2592_force_0.connectLedger(module.io.in_x2592_force_0)
    module.io.in_b2503 <> b2503
    x2513_tmp_3.connectLedger(module.io.in_x2513_tmp_3)
    x2511_tmp_1.connectLedger(module.io.in_x2511_tmp_1)
  }
  val b566 = list_b566(0)
  val b2503 = list_b566(1)
  val x2512_tmp_2 = list_x2512_tmp_2(0)
  val x2514_tmp_4 = list_x2512_tmp_2(1)
  val x2510_tmp_0 = list_x2512_tmp_2(2)
  val x2592_force_0 = list_x2512_tmp_2(3)
  val x2513_tmp_3 = list_x2512_tmp_2(4)
  val x2511_tmp_1 = list_x2512_tmp_2(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2684_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2684_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2684_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2684_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2684_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2684_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2684_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2684_instrctr, cycles_x2684_inr_Foreach.io.count, iters_x2684_inr_Foreach.io.count, 0.U, 0.U)
      val b2671 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2671.suggestName("b2671")
      val b2672 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2672.suggestName("b2672")
      val x2673_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2673_rd""")
      val x2673_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2673_rd_ofs = List[UInt](b2671.r)
      val x2673_rd_en = List[Bool](true.B)
      val x2673_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2672 & b2503 & b566 ).suggestName("x2673_rd_shared_en")
      x2673_rd.toSeq.zip(x2513_tmp_3.connectRPort(2673, x2673_rd_banks, x2673_rd_ofs, io.sigsIn.backpressure, x2673_rd_en.map(_ && x2673_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2674 = VecApply(x2673,0)
      val x2674_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2674_elem_0""")
      x2674_elem_0.r := x2673_rd(0).r
      val x2675_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2675_mul""")
      x2675_mul.r := (Math.mul(x2674_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x2675_mul")).r
      val x2676_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2676_rd""")
      val x2676_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2676_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2676_rd_en = List[Bool](true.B)
      val x2676_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2672 & b2503 & b566 ).suggestName("x2676_rd_shared_en")
      x2676_rd.toSeq.zip(x2592_force_0.connectRPort(2676, x2676_rd_banks, x2676_rd_ofs, io.sigsIn.backpressure, x2676_rd_en.map(_ && x2676_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2677 = VecApply(x2676,0)
      val x2677_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2677_elem_0""")
      x2677_elem_0.r := x2676_rd(0).r
      val x3735 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3735_x2677_elem_0_D6") 
      x3735.r := getRetimed(x2677_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2678_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2678_mul""")
      x2678_mul.r := (Math.mul(x2675_mul, x3735, Some(6.0), true.B, Truncate, Wrapping, "x2678_mul")).r
      val x3736 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3736_b2671_D14") 
      x3736.r := getRetimed(b2671.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3737 = Wire(Bool()).suggestName("x3737_b566_D14") 
      x3737.r := getRetimed(b566.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3738 = Wire(Bool()).suggestName("x3738_b2503_D14") 
      x3738.r := getRetimed(b2503.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3739 = Wire(Bool()).suggestName("x3739_b2672_D14") 
      x3739.r := getRetimed(b2672.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x2679_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2679_wr_ofs = List[UInt](x3736.r)
      val x2679_wr_en = List[Bool](true.B)
      val x2679_wr_data = List[UInt](x2678_mul.r)
      x2512_tmp_2.connectWPort(2679, x2679_wr_banks, x2679_wr_ofs, x2679_wr_data, x2679_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3739 & x3738 & x3737))
      val x2680_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2680_wr_ofs = List[UInt](x3736.r)
      val x2680_wr_en = List[Bool](true.B)
      val x2680_wr_data = List[UInt](x2678_mul.r)
      x2514_tmp_4.connectWPort(2680, x2680_wr_banks, x2680_wr_ofs, x2680_wr_data, x2680_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3739 & x3738 & x3737))
      val x2681_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2681_wr_ofs = List[UInt](x3736.r)
      val x2681_wr_en = List[Bool](true.B)
      val x2681_wr_data = List[UInt](x2678_mul.r)
      x2510_tmp_0.connectWPort(2681, x2681_wr_banks, x2681_wr_ofs, x2681_wr_data, x2681_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3739 & x3738 & x3737))
      val x2682_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2682_wr_ofs = List[UInt](x3736.r)
      val x2682_wr_en = List[Bool](true.B)
      val x2682_wr_data = List[UInt](x2678_mul.r)
      x2513_tmp_3.connectWPort(2682, x2682_wr_banks, x2682_wr_ofs, x2682_wr_data, x2682_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3739 & x3738 & x3737))
      val x2683_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2683_wr_ofs = List[UInt](x3736.r)
      val x2683_wr_en = List[Bool](true.B)
      val x2683_wr_data = List[UInt](x2678_mul.r)
      x2511_tmp_1.connectWPort(2683, x2683_wr_banks, x2683_wr_ofs, x2683_wr_data, x2683_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3739 & x3738 & x3737))
    }
    val module = Module(new x2684_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2684_inr_Foreach **/
