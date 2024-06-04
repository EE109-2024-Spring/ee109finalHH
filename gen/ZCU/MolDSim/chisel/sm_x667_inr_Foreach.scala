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

/** Hierarchy: x667 -> x668 -> x444 **/
/** BEGIN None x667_inr_Foreach **/
class x667_inr_Foreach_kernel(
  list_b543: List[Bool],
  list_b542: List[FixedPoint],
  list_x473_A_sram_2: List[StandardInterface],
  list_x545_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.2.toInt, myName = "x667_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x667_inr_Foreach_iiCtr"))
  
  abstract class x667_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b542 = Input(new FixedPoint(true, 32, 0))
      val in_x545_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x545_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x539_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x539_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_b543 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b542 = {io.in_b542} 
    def x545_accum_1 = {io.in_x545_accum_1} ; io.in_x545_accum_1 := DontCare
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x539_out_sram_0 = {io.in_x539_out_sram_0} ; io.in_x539_out_sram_0 := DontCare
    def b543 = {io.in_b543} 
  }
  def connectWires0(module: x667_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b542 <> b542
    x545_accum_1.connectLedger(module.io.in_x545_accum_1)
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x539_out_sram_0.connectLedger(module.io.in_x539_out_sram_0)
    module.io.in_b543 <> b543
  }
  val b543 = list_b543(0)
  val b542 = list_b542(0)
  val x473_A_sram_2 = list_x473_A_sram_2(0)
  val x539_out_sram_0 = list_x473_A_sram_2(1)
  val x545_accum_1 = list_x545_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x667_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x667_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x667_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b656 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b656.suggestName("b656")
      val b657 = ~io.sigsIn.cchainOutputs.head.oobs(0); b657.suggestName("b657")
      val x658_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x658_rd""")
      val x658_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x658_rd_ofs = List[UInt](b656.r)
      val x658_rd_en = List[Bool](true.B)
      val x658_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b657 & b543 ).suggestName("x658_rd_shared_en")
      x658_rd.toSeq.zip(x545_accum_1.connectRPort(658, x658_rd_banks, x658_rd_ofs, io.sigsIn.backpressure, x658_rd_en.map(_ && x658_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x659 = VecApply(x658,0)
      val x659_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x659_elem_0""")
      x659_elem_0.r := x658_rd(0).r
      val x750 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x750""")
      x750.r := Math.arith_left_shift(b542, 1, Some(0.2), true.B,"x750").r
      val x751_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x751_sum""")
      x751_sum.r := Math.add(x750,b542,Some(1.0), true.B, Truncate, Wrapping, "x751_sum").r
      val x794 = Wire(new FixedPoint(true, 32, 0)).suggestName("x794_b656_D1") 
      x794.r := getRetimed(b656.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x662_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x662_sum""")
      x662_sum.r := Math.add(x751_sum,x794,Some(1.0), true.B, Truncate, Wrapping, "x662_sum").r
      val x795 = Wire(Bool()).suggestName("x795_b543_D2") 
      x795.r := getRetimed(b543.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x796 = Wire(Bool()).suggestName("x796_b657_D2") 
      x796.r := getRetimed(b657.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x663_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x663_rd""")
      val x663_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x663_rd_ofs = List[UInt](x662_sum.r)
      val x663_rd_en = List[Bool](true.B)
      val x663_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.2.toInt, rr, io.sigsIn.backpressure & true.B) && x796 & x795 ).suggestName("x663_rd_shared_en")
      x663_rd.toSeq.zip(x473_A_sram_2.connectRPort(663, x663_rd_banks, x663_rd_ofs, io.sigsIn.backpressure, x663_rd_en.map(_ && x663_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x664 = VecApply(x663,0)
      val x664_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x664_elem_0""")
      x664_elem_0.r := x663_rd(0).r
      val x797 = Wire(new FixedPoint(true, 10, 22)).suggestName("x797_x659_elem_0_D2") 
      x797.r := getRetimed(x659_elem_0.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x665_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x665_sum""")
      x665_sum.r := Math.add(x797,x664_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x665_sum").r
      val x798 = Wire(Bool()).suggestName("x798_b543_D5") 
      x798.r := getRetimed(b543.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x799 = Wire(new FixedPoint(true, 32, 0)).suggestName("x799_x662_sum_D3") 
      x799.r := getRetimed(x662_sum.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x800 = Wire(Bool()).suggestName("x800_b657_D5") 
      x800.r := getRetimed(b657.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x666_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x666_wr_ofs = List[UInt](x799.r)
      val x666_wr_en = List[Bool](true.B)
      val x666_wr_data = List[UInt](x665_sum.r)
      x539_out_sram_0.connectWPort(666, x666_wr_banks, x666_wr_ofs, x666_wr_data, x666_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x800 & x798))
      x545_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x667_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x667_inr_Foreach **/
