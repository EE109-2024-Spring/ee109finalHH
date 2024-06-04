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

/** Hierarchy: x605 -> x653 -> x668 -> x444 **/
/** BEGIN None x605_inr_UnitPipe **/
class x605_inr_UnitPipe_kernel(
  list_b552: List[Bool],
  list_x555_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x605_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x605_inr_UnitPipe_iiCtr"))
  
  abstract class x605_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x555_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x555_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x554_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x554_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x558_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x558_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b552 = Input(Bool())
      val in_x557_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x557_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x580_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x580_r_0_p").asInstanceOf[NBufParams] ))
      val in_x595_reg = Flipped(new NBufInterface(ModuleParams.getParams("x595_reg_p").asInstanceOf[NBufParams] ))
      val in_x556_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x556_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x596_reg = Flipped(new NBufInterface(ModuleParams.getParams("x596_reg_p").asInstanceOf[NBufParams] ))
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
    def x557_tmp_3 = {io.in_x557_tmp_3} ; io.in_x557_tmp_3 := DontCare
    def x580_r_0 = {io.in_x580_r_0} ; io.in_x580_r_0 := DontCare
    def x595_reg = {io.in_x595_reg} ; io.in_x595_reg := DontCare
    def x556_tmp_2 = {io.in_x556_tmp_2} ; io.in_x556_tmp_2 := DontCare
    def x596_reg = {io.in_x596_reg} ; io.in_x596_reg := DontCare
    def b543 = {io.in_b543} 
  }
  def connectWires0(module: x605_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x555_tmp_1.connectLedger(module.io.in_x555_tmp_1)
    x554_tmp_0.connectLedger(module.io.in_x554_tmp_0)
    x558_tmp_4.connectLedger(module.io.in_x558_tmp_4)
    module.io.in_b552 <> b552
    x557_tmp_3.connectLedger(module.io.in_x557_tmp_3)
    x580_r_0.connectLedger(module.io.in_x580_r_0)
    x595_reg.connectLedger(module.io.in_x595_reg)
    x556_tmp_2.connectLedger(module.io.in_x556_tmp_2)
    x596_reg.connectLedger(module.io.in_x596_reg)
    module.io.in_b543 <> b543
  }
  val b552 = list_b552(0)
  val b543 = list_b552(1)
  val x555_tmp_1 = list_x555_tmp_1(0)
  val x554_tmp_0 = list_x555_tmp_1(1)
  val x558_tmp_4 = list_x555_tmp_1(2)
  val x557_tmp_3 = list_x555_tmp_1(3)
  val x580_r_0 = list_x555_tmp_1(4)
  val x595_reg = list_x555_tmp_1(5)
  val x556_tmp_2 = list_x555_tmp_1(6)
  val x596_reg = list_x555_tmp_1(7)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x605_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x605_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x605_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x597_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x597_rd""")
      val x597_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x597_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x597_rd_en = List[Bool](true.B)
      val x597_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x597_rd_shared_en")
      x597_rd.toSeq.zip(x580_r_0.connectRPort(597, x597_rd_banks, x597_rd_ofs, io.sigsIn.backpressure, x597_rd_en.map(_ && x597_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x598 = VecApply(x597,0)
      val x598_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x598_elem_0""")
      x598_elem_0.r := x597_rd(0).r
      val x599 = Wire(Bool()).suggestName("""x599""")
      x599.r := Math.lt(0.FP(true, 10, 22), x598_elem_0, Some(0.4), true.B,"x599").r
      val x600 = Wire(Bool()).suggestName("""x600""")
      x600.r := Math.lt(1.FP(true, 10, 22), x598_elem_0, Some(0.4), true.B,"x600").r
      val x601 = Wire(Bool()).suggestName("""x601""")
      x601 := x599 & x600
      val x602 = Wire(Bool()).suggestName("""x602""")
      x602 := ~x601
      val x603_wr_x595_banks = List[UInt]()
      val x603_wr_x595_ofs = List[UInt]()
      val x603_wr_x595_en = List[Bool](true.B)
      val x603_wr_x595_data = List[UInt](x601.r)
      x595_reg.connectWPort(603, x603_wr_x595_banks, x603_wr_x595_ofs, x603_wr_x595_data, x603_wr_x595_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x604_wr_x596_banks = List[UInt]()
      val x604_wr_x596_ofs = List[UInt]()
      val x604_wr_x596_en = List[Bool](true.B)
      val x604_wr_x596_data = List[UInt](x602.r)
      x596_reg.connectWPort(604, x604_wr_x596_banks, x604_wr_x596_ofs, x604_wr_x596_data, x604_wr_x596_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x554_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x555_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x556_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x557_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x558_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 2)
      x580_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x595_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x596_reg.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x605_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x605_inr_UnitPipe **/
