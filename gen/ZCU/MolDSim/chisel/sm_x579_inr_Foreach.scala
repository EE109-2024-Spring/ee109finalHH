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

/** Hierarchy: x579 -> x653 -> x668 -> x444 **/
/** BEGIN None x579_inr_Foreach **/
class x579_inr_Foreach_kernel(
  list_b552: List[Bool],
  list_b550: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x555_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.2.toInt, myName = "x579_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x579_inr_Foreach_iiCtr"))
  
  abstract class x579_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x555_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x555_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b542 = Input(new FixedPoint(true, 32, 0))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x554_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x554_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x558_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x558_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b552 = Input(Bool())
      val in_x557_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x557_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x556_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x556_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b543 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x555_tmp_1 = {io.in_x555_tmp_1} ; io.in_x555_tmp_1 := DontCare
    def b550 = {io.in_b550} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b542 = {io.in_b542} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x554_tmp_0 = {io.in_x554_tmp_0} ; io.in_x554_tmp_0 := DontCare
    def x558_tmp_4 = {io.in_x558_tmp_4} ; io.in_x558_tmp_4 := DontCare
    def b552 = {io.in_b552} 
    def x557_tmp_3 = {io.in_x557_tmp_3} ; io.in_x557_tmp_3 := DontCare
    def x556_tmp_2 = {io.in_x556_tmp_2} ; io.in_x556_tmp_2 := DontCare
    def b543 = {io.in_b543} 
  }
  def connectWires0(module: x579_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x555_tmp_1.connectLedger(module.io.in_x555_tmp_1)
    module.io.in_b550 <> b550
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b542 <> b542
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x554_tmp_0.connectLedger(module.io.in_x554_tmp_0)
    x558_tmp_4.connectLedger(module.io.in_x558_tmp_4)
    module.io.in_b552 <> b552
    x557_tmp_3.connectLedger(module.io.in_x557_tmp_3)
    x556_tmp_2.connectLedger(module.io.in_x556_tmp_2)
    module.io.in_b543 <> b543
  }
  val b552 = list_b552(0)
  val b543 = list_b552(1)
  val b550 = list_b550(0)
  val b542 = list_b550(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x555_tmp_1 = list_x555_tmp_1(0)
  val x554_tmp_0 = list_x555_tmp_1(1)
  val x558_tmp_4 = list_x555_tmp_1(2)
  val x557_tmp_3 = list_x555_tmp_1(3)
  val x556_tmp_2 = list_x555_tmp_1(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x579_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x579_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x579_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b561 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b561.suggestName("b561")
      val b562 = ~io.sigsIn.cchainOutputs.head.oobs(0); b562.suggestName("b562")
      val x744 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x744""")
      x744.r := Math.arith_left_shift(b542, 1, Some(0.2), true.B,"x744").r
      val x745_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x745_sum""")
      x745_sum.r := Math.add(x744,b542,Some(1.0), true.B, Truncate, Wrapping, "x745_sum").r
      val x769 = Wire(new FixedPoint(true, 32, 0)).suggestName("x769_b561_D1") 
      x769.r := getRetimed(b561.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x565_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x565_sum""")
      x565_sum.r := Math.add(x745_sum,x769,Some(1.0), true.B, Truncate, Wrapping, "x565_sum").r
      val x770 = Wire(Bool()).suggestName("x770_b543_D2") 
      x770.r := getRetimed(b543.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x771 = Wire(Bool()).suggestName("x771_b552_D2") 
      x771.r := getRetimed(b552.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x772 = Wire(Bool()).suggestName("x772_b562_D2") 
      x772.r := getRetimed(b562.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x566_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x566_rd""")
      val x566_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x566_rd_ofs = List[UInt](x565_sum.r)
      val x566_rd_en = List[Bool](true.B)
      val x566_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.2.toInt, rr, io.sigsIn.backpressure & true.B) && x772 & x771 & x770 ).suggestName("x566_rd_shared_en")
      x566_rd.toSeq.zip(x471_A_sram_0.connectRPort(566, x566_rd_banks, x566_rd_ofs, io.sigsIn.backpressure, x566_rd_en.map(_ && x566_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x567 = VecApply(x566,0)
      val x567_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x567_elem_0""")
      x567_elem_0.r := x566_rd(0).r
      val x746 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x746""")
      x746.r := Math.arith_left_shift(b550, 1, Some(0.2), true.B,"x746").r
      val x747_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x747_sum""")
      x747_sum.r := Math.add(x746,b550,Some(1.0), true.B, Truncate, Wrapping, "x747_sum").r
      val x570_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x570_sum""")
      x570_sum.r := Math.add(x747_sum,x769,Some(1.0), true.B, Truncate, Wrapping, "x570_sum").r
      val x571_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x571_rd""")
      val x571_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x571_rd_ofs = List[UInt](x570_sum.r)
      val x571_rd_en = List[Bool](true.B)
      val x571_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.2.toInt, rr, io.sigsIn.backpressure & true.B) && x772 & x771 & x770 ).suggestName("x571_rd_shared_en")
      x571_rd.toSeq.zip(x472_A_sram_1.connectRPort(571, x571_rd_banks, x571_rd_ofs, io.sigsIn.backpressure, x571_rd_en.map(_ && x571_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x572 = VecApply(x571,0)
      val x572_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x572_elem_0""")
      x572_elem_0.r := x571_rd(0).r
      val x573_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x573_sub""")
      x573_sub.r := Math.sub(x567_elem_0,x572_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x573_sub").r
      val x773 = Wire(new FixedPoint(true, 32, 0)).suggestName("x773_b561_D5") 
      x773.r := getRetimed(b561.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x774 = Wire(Bool()).suggestName("x774_b562_D5") 
      x774.r := getRetimed(b562.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x775 = Wire(Bool()).suggestName("x775_b552_D5") 
      x775.r := getRetimed(b552.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x776 = Wire(Bool()).suggestName("x776_b543_D5") 
      x776.r := getRetimed(b543.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x574_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x574_wr_ofs = List[UInt](x773.r)
      val x574_wr_en = List[Bool](true.B)
      val x574_wr_data = List[UInt](x573_sub.r)
      x555_tmp_1.connectWPort(574, x574_wr_banks, x574_wr_ofs, x574_wr_data, x574_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x774 & x775 & x776))
      val x575_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x575_wr_ofs = List[UInt](x773.r)
      val x575_wr_en = List[Bool](true.B)
      val x575_wr_data = List[UInt](x573_sub.r)
      x554_tmp_0.connectWPort(575, x575_wr_banks, x575_wr_ofs, x575_wr_data, x575_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x774 & x775 & x776))
      val x576_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x576_wr_ofs = List[UInt](x773.r)
      val x576_wr_en = List[Bool](true.B)
      val x576_wr_data = List[UInt](x573_sub.r)
      x558_tmp_4.connectWPort(576, x576_wr_banks, x576_wr_ofs, x576_wr_data, x576_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x774 & x775 & x776))
      val x577_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x577_wr_ofs = List[UInt](x773.r)
      val x577_wr_en = List[Bool](true.B)
      val x577_wr_data = List[UInt](x573_sub.r)
      x557_tmp_3.connectWPort(577, x577_wr_banks, x577_wr_ofs, x577_wr_data, x577_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x774 & x775 & x776))
      val x578_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x578_wr_ofs = List[UInt](x773.r)
      val x578_wr_en = List[Bool](true.B)
      val x578_wr_data = List[UInt](x573_sub.r)
      x556_tmp_2.connectWPort(578, x578_wr_banks, x578_wr_ofs, x578_wr_data, x578_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x774 & x775 & x776))
      x554_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x555_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x556_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x557_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x558_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x579_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x579_inr_Foreach **/
