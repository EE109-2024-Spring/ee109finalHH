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

/** Hierarchy: x639 -> x653 -> x668 -> x444 **/
/** BEGIN None x639_inr_Foreach **/
class x639_inr_Foreach_kernel(
  list_b552: List[Bool],
  list_x555_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x639_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x639_inr_Foreach_iiCtr"))
  
  abstract class x639_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x555_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x555_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x554_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x554_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x558_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x558_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b552 = Input(Bool())
      val in_x594_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x594_force_0_p").asInstanceOf[NBufParams] ))
      val in_x557_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x557_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x556_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x556_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b543 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x555_tmp_1 = {io.in_x555_tmp_1} ; io.in_x555_tmp_1 := DontCare
    def x554_tmp_0 = {io.in_x554_tmp_0} ; io.in_x554_tmp_0 := DontCare
    def x558_tmp_4 = {io.in_x558_tmp_4} ; io.in_x558_tmp_4 := DontCare
    def b552 = {io.in_b552} 
    def x594_force_0 = {io.in_x594_force_0} ; io.in_x594_force_0 := DontCare
    def x557_tmp_3 = {io.in_x557_tmp_3} ; io.in_x557_tmp_3 := DontCare
    def x556_tmp_2 = {io.in_x556_tmp_2} ; io.in_x556_tmp_2 := DontCare
    def b543 = {io.in_b543} 
  }
  def connectWires0(module: x639_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x555_tmp_1.connectLedger(module.io.in_x555_tmp_1)
    x554_tmp_0.connectLedger(module.io.in_x554_tmp_0)
    x558_tmp_4.connectLedger(module.io.in_x558_tmp_4)
    module.io.in_b552 <> b552
    x594_force_0.connectLedger(module.io.in_x594_force_0)
    x557_tmp_3.connectLedger(module.io.in_x557_tmp_3)
    x556_tmp_2.connectLedger(module.io.in_x556_tmp_2)
    module.io.in_b543 <> b543
  }
  val b552 = list_b552(0)
  val b543 = list_b552(1)
  val x555_tmp_1 = list_x555_tmp_1(0)
  val x554_tmp_0 = list_x555_tmp_1(1)
  val x558_tmp_4 = list_x555_tmp_1(2)
  val x594_force_0 = list_x555_tmp_1(3)
  val x557_tmp_3 = list_x555_tmp_1(4)
  val x556_tmp_2 = list_x555_tmp_1(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x639_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x639_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x639_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b626 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b626.suggestName("b626")
      val b627 = ~io.sigsIn.cchainOutputs.head.oobs(0); b627.suggestName("b627")
      val x628_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x628_rd""")
      val x628_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x628_rd_ofs = List[UInt](b626.r)
      val x628_rd_en = List[Bool](true.B)
      val x628_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b627 & b552 & b543 ).suggestName("x628_rd_shared_en")
      x628_rd.toSeq.zip(x557_tmp_3.connectRPort(628, x628_rd_banks, x628_rd_ofs, io.sigsIn.backpressure, x628_rd_en.map(_ && x628_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x629 = VecApply(x628,0)
      val x629_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x629_elem_0""")
      x629_elem_0.r := x628_rd(0).r
      val x630_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x630_mul""")
      x630_mul.r := (Math.mul(x629_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x630_mul")).r
      val x631_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x631_rd""")
      val x631_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x631_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x631_rd_en = List[Bool](true.B)
      val x631_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b627 & b552 & b543 ).suggestName("x631_rd_shared_en")
      x631_rd.toSeq.zip(x594_force_0.connectRPort(631, x631_rd_banks, x631_rd_ofs, io.sigsIn.backpressure, x631_rd_en.map(_ && x631_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x632 = VecApply(x631,0)
      val x632_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x632_elem_0""")
      x632_elem_0.r := x631_rd(0).r
      val x784 = Wire(new FixedPoint(true, 10, 22)).suggestName("x784_x632_elem_0_D6") 
      x784.r := getRetimed(x632_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x633_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x633_mul""")
      x633_mul.r := (Math.mul(x630_mul, x784, Some(6.0), true.B, Truncate, Wrapping, "x633_mul")).r
      val x785 = Wire(Bool()).suggestName("x785_b552_D14") 
      x785.r := getRetimed(b552.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x786 = Wire(new FixedPoint(true, 32, 0)).suggestName("x786_b626_D14") 
      x786.r := getRetimed(b626.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x787 = Wire(Bool()).suggestName("x787_b627_D14") 
      x787.r := getRetimed(b627.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x788 = Wire(Bool()).suggestName("x788_b543_D14") 
      x788.r := getRetimed(b543.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x634_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x634_wr_ofs = List[UInt](x786.r)
      val x634_wr_en = List[Bool](true.B)
      val x634_wr_data = List[UInt](x633_mul.r)
      x555_tmp_1.connectWPort(634, x634_wr_banks, x634_wr_ofs, x634_wr_data, x634_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x787 & x785 & x788))
      val x635_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x635_wr_ofs = List[UInt](x786.r)
      val x635_wr_en = List[Bool](true.B)
      val x635_wr_data = List[UInt](x633_mul.r)
      x554_tmp_0.connectWPort(635, x635_wr_banks, x635_wr_ofs, x635_wr_data, x635_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x787 & x785 & x788))
      val x636_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x636_wr_ofs = List[UInt](x786.r)
      val x636_wr_en = List[Bool](true.B)
      val x636_wr_data = List[UInt](x633_mul.r)
      x558_tmp_4.connectWPort(636, x636_wr_banks, x636_wr_ofs, x636_wr_data, x636_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x787 & x785 & x788))
      val x637_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x637_wr_ofs = List[UInt](x786.r)
      val x637_wr_en = List[Bool](true.B)
      val x637_wr_data = List[UInt](x633_mul.r)
      x557_tmp_3.connectWPort(637, x637_wr_banks, x637_wr_ofs, x637_wr_data, x637_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x787 & x785 & x788))
      val x638_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x638_wr_ofs = List[UInt](x786.r)
      val x638_wr_en = List[Bool](true.B)
      val x638_wr_data = List[UInt](x633_mul.r)
      x556_tmp_2.connectWPort(638, x638_wr_banks, x638_wr_ofs, x638_wr_data, x638_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x787 & x785 & x788))
      x554_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x555_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x556_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x557_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x558_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x594_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x639_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x639_inr_Foreach **/
