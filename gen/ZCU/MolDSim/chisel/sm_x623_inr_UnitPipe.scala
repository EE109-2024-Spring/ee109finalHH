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

/** Hierarchy: x623 -> x653 -> x668 -> x444 **/
/** BEGIN None x623_inr_UnitPipe **/
class x623_inr_UnitPipe_kernel(
  list_b552: List[Bool],
  list_x621_inr_Switch: List[FixedPoint],
  list_x555_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 1.0.toInt, myName = "x623_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x623_inr_UnitPipe_iiCtr"))
  
  abstract class x623_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x555_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x555_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x554_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x554_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x558_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x558_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b552 = Input(Bool())
      val in_x594_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x594_force_0_p").asInstanceOf[NBufParams] ))
      val in_x621_inr_Switch = Input(new FixedPoint(true, 10, 22))
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
    def x621_inr_Switch = {io.in_x621_inr_Switch} 
    def x557_tmp_3 = {io.in_x557_tmp_3} ; io.in_x557_tmp_3 := DontCare
    def x556_tmp_2 = {io.in_x556_tmp_2} ; io.in_x556_tmp_2 := DontCare
    def b543 = {io.in_b543} 
  }
  def connectWires0(module: x623_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x555_tmp_1.connectLedger(module.io.in_x555_tmp_1)
    x554_tmp_0.connectLedger(module.io.in_x554_tmp_0)
    x558_tmp_4.connectLedger(module.io.in_x558_tmp_4)
    module.io.in_b552 <> b552
    x594_force_0.connectLedger(module.io.in_x594_force_0)
    module.io.in_x621_inr_Switch <> x621_inr_Switch
    x557_tmp_3.connectLedger(module.io.in_x557_tmp_3)
    x556_tmp_2.connectLedger(module.io.in_x556_tmp_2)
    module.io.in_b543 <> b543
  }
  val b552 = list_b552(0)
  val b543 = list_b552(1)
  val x621_inr_Switch = list_x621_inr_Switch(0)
  val x555_tmp_1 = list_x555_tmp_1(0)
  val x554_tmp_0 = list_x555_tmp_1(1)
  val x558_tmp_4 = list_x555_tmp_1(2)
  val x594_force_0 = list_x555_tmp_1(3)
  val x557_tmp_3 = list_x555_tmp_1(4)
  val x556_tmp_2 = list_x555_tmp_1(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x623_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x623_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x623_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x622_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x622_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x622_wr_en = List[Bool](true.B)
      val x622_wr_data = List[UInt](x621_inr_Switch.r)
      x594_force_0.connectWPort(622, x622_wr_banks, x622_wr_ofs, x622_wr_data, x622_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x554_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x555_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x556_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x557_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x558_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 4)
      x594_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x623_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x623_inr_UnitPipe **/
