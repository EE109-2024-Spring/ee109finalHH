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

/** Hierarchy: x812 -> x813 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x812_inr_Foreach **/
class x812_inr_Foreach_kernel(
  list_b631: List[Bool],
  list_x638_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x812_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x812_inr_Foreach_iiCtr"))
  
  abstract class x812_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x638_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x638_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x642_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x642_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x641_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x641_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b631 = Input(Bool())
      val in_b557 = Input(Bool())
      val in_x640_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x640_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x720_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x720_force_0_p").asInstanceOf[NBufParams] ))
      val in_x639_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x639_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x638_tmp_0 = {io.in_x638_tmp_0} ; io.in_x638_tmp_0 := DontCare
    def x642_tmp_4 = {io.in_x642_tmp_4} ; io.in_x642_tmp_4 := DontCare
    def x641_tmp_3 = {io.in_x641_tmp_3} ; io.in_x641_tmp_3 := DontCare
    def b631 = {io.in_b631} 
    def b557 = {io.in_b557} 
    def x640_tmp_2 = {io.in_x640_tmp_2} ; io.in_x640_tmp_2 := DontCare
    def x720_force_0 = {io.in_x720_force_0} ; io.in_x720_force_0 := DontCare
    def x639_tmp_1 = {io.in_x639_tmp_1} ; io.in_x639_tmp_1 := DontCare
  }
  def connectWires0(module: x812_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x638_tmp_0.connectLedger(module.io.in_x638_tmp_0)
    x642_tmp_4.connectLedger(module.io.in_x642_tmp_4)
    x641_tmp_3.connectLedger(module.io.in_x641_tmp_3)
    module.io.in_b631 <> b631
    module.io.in_b557 <> b557
    x640_tmp_2.connectLedger(module.io.in_x640_tmp_2)
    x720_force_0.connectLedger(module.io.in_x720_force_0)
    x639_tmp_1.connectLedger(module.io.in_x639_tmp_1)
  }
  val b631 = list_b631(0)
  val b557 = list_b631(1)
  val x638_tmp_0 = list_x638_tmp_0(0)
  val x642_tmp_4 = list_x638_tmp_0(1)
  val x641_tmp_3 = list_x638_tmp_0(2)
  val x640_tmp_2 = list_x638_tmp_0(3)
  val x720_force_0 = list_x638_tmp_0(4)
  val x639_tmp_1 = list_x638_tmp_0(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x812_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x812_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x812_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x812_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x812_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x812_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x812_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X812_instrctr, cycles_x812_inr_Foreach.io.count, iters_x812_inr_Foreach.io.count, 0.U, 0.U)
      val b799 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b799.suggestName("b799")
      val b800 = ~io.sigsIn.cchainOutputs.head.oobs(0); b800.suggestName("b800")
      val x801_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x801_rd""")
      val x801_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x801_rd_ofs = List[UInt](b799.r)
      val x801_rd_en = List[Bool](true.B)
      val x801_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b800 & b631 & b557 ).suggestName("x801_rd_shared_en")
      x801_rd.toSeq.zip(x641_tmp_3.connectRPort(801, x801_rd_banks, x801_rd_ofs, io.sigsIn.backpressure, x801_rd_en.map(_ && x801_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x802 = VecApply(x801,0)
      val x802_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x802_elem_0""")
      x802_elem_0.r := x801_rd(0).r
      val x803_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x803_mul""")
      x803_mul.r := (Math.mul(x802_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x803_mul")).r
      val x804_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x804_rd""")
      val x804_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x804_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x804_rd_en = List[Bool](true.B)
      val x804_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b800 & b631 & b557 ).suggestName("x804_rd_shared_en")
      x804_rd.toSeq.zip(x720_force_0.connectRPort(804, x804_rd_banks, x804_rd_ofs, io.sigsIn.backpressure, x804_rd_en.map(_ && x804_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x805 = VecApply(x804,0)
      val x805_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x805_elem_0""")
      x805_elem_0.r := x804_rd(0).r
      val x3186 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3186_x805_elem_0_D6") 
      x3186.r := getRetimed(x805_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x806_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x806_mul""")
      x806_mul.r := (Math.mul(x803_mul, x3186, Some(6.0), true.B, Truncate, Wrapping, "x806_mul")).r
      val x3187 = Wire(Bool()).suggestName("x3187_b631_D14") 
      x3187.r := getRetimed(b631.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3188 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3188_b799_D14") 
      x3188.r := getRetimed(b799.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3189 = Wire(Bool()).suggestName("x3189_b557_D14") 
      x3189.r := getRetimed(b557.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3190 = Wire(Bool()).suggestName("x3190_b800_D14") 
      x3190.r := getRetimed(b800.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x807_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x807_wr_ofs = List[UInt](x3188.r)
      val x807_wr_en = List[Bool](true.B)
      val x807_wr_data = List[UInt](x806_mul.r)
      x638_tmp_0.connectWPort(807, x807_wr_banks, x807_wr_ofs, x807_wr_data, x807_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3190 & x3187 & x3189))
      val x808_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x808_wr_ofs = List[UInt](x3188.r)
      val x808_wr_en = List[Bool](true.B)
      val x808_wr_data = List[UInt](x806_mul.r)
      x642_tmp_4.connectWPort(808, x808_wr_banks, x808_wr_ofs, x808_wr_data, x808_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3190 & x3187 & x3189))
      val x809_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x809_wr_ofs = List[UInt](x3188.r)
      val x809_wr_en = List[Bool](true.B)
      val x809_wr_data = List[UInt](x806_mul.r)
      x641_tmp_3.connectWPort(809, x809_wr_banks, x809_wr_ofs, x809_wr_data, x809_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3190 & x3187 & x3189))
      val x810_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x810_wr_ofs = List[UInt](x3188.r)
      val x810_wr_en = List[Bool](true.B)
      val x810_wr_data = List[UInt](x806_mul.r)
      x640_tmp_2.connectWPort(810, x810_wr_banks, x810_wr_ofs, x810_wr_data, x810_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3190 & x3187 & x3189))
      val x811_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x811_wr_ofs = List[UInt](x3188.r)
      val x811_wr_en = List[Bool](true.B)
      val x811_wr_data = List[UInt](x806_mul.r)
      x639_tmp_1.connectWPort(811, x811_wr_banks, x811_wr_ofs, x811_wr_data, x811_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3190 & x3187 & x3189))
    }
    val module = Module(new x812_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x812_inr_Foreach **/
