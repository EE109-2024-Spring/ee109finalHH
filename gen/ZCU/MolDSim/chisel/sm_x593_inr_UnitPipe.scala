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

/** Hierarchy: x593 -> x653 -> x668 -> x444 **/
/** BEGIN None x593_inr_UnitPipe **/
class x593_inr_UnitPipe_kernel(
  list_b552: List[Bool],
  list_x555_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x593_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x593_inr_UnitPipe_iiCtr"))
  
  abstract class x593_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x555_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x555_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x554_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x554_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x558_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x558_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b552 = Input(Bool())
      val in_x557_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x557_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x580_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x580_r_0_p").asInstanceOf[NBufParams] ))
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
    def x557_tmp_3 = {io.in_x557_tmp_3} ; io.in_x557_tmp_3 := DontCare
    def x580_r_0 = {io.in_x580_r_0} ; io.in_x580_r_0 := DontCare
    def x556_tmp_2 = {io.in_x556_tmp_2} ; io.in_x556_tmp_2 := DontCare
    def b543 = {io.in_b543} 
  }
  def connectWires0(module: x593_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x555_tmp_1.connectLedger(module.io.in_x555_tmp_1)
    x554_tmp_0.connectLedger(module.io.in_x554_tmp_0)
    x558_tmp_4.connectLedger(module.io.in_x558_tmp_4)
    module.io.in_b552 <> b552
    x557_tmp_3.connectLedger(module.io.in_x557_tmp_3)
    x580_r_0.connectLedger(module.io.in_x580_r_0)
    x556_tmp_2.connectLedger(module.io.in_x556_tmp_2)
    module.io.in_b543 <> b543
  }
  val b552 = list_b552(0)
  val b543 = list_b552(1)
  val x555_tmp_1 = list_x555_tmp_1(0)
  val x554_tmp_0 = list_x555_tmp_1(1)
  val x558_tmp_4 = list_x555_tmp_1(2)
  val x557_tmp_3 = list_x555_tmp_1(3)
  val x580_r_0 = list_x555_tmp_1(4)
  val x556_tmp_2 = list_x555_tmp_1(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x593_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x593_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x593_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x581_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x581_rd""")
      val x581_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x581_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x581_rd_en = List[Bool](true.B)
      val x581_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x581_rd_shared_en")
      x581_rd.toSeq.zip(x554_tmp_0.connectRPort(581, x581_rd_banks, x581_rd_ofs, io.sigsIn.backpressure, x581_rd_en.map(_ && x581_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x582 = VecApply(x581,0)
      val x582_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x582_elem_0""")
      x582_elem_0.r := x581_rd(0).r
      val x584_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x584_rd""")
      val x584_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x584_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x584_rd_en = List[Bool](true.B)
      val x584_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x584_rd_shared_en")
      x584_rd.toSeq.zip(x555_tmp_1.connectRPort(584, x584_rd_banks, x584_rd_ofs, io.sigsIn.backpressure, x584_rd_en.map(_ && x584_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x585 = VecApply(x584,0)
      val x585_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x585_elem_0""")
      x585_elem_0.r := x584_rd(0).r
      val x586_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x586_mul""")
      x586_mul.r := (Math.mul(x585_elem_0, x585_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x586_mul")).r
      val x777 = Wire(new FixedPoint(true, 10, 22)).suggestName("x777_x582_elem_0_D6") 
      x777.r := getRetimed(x582_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x748 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x748""")
      x748.r := Math.fma(x777,x777,x586_mul,Some(6.0), true.B, "x748").toFixed(x748, "cast_x748").r
      val x588_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x588_rd""")
      val x588_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x588_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x588_rd_en = List[Bool](true.B)
      val x588_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x588_rd_shared_en")
      x588_rd.toSeq.zip(x556_tmp_2.connectRPort(588, x588_rd_banks, x588_rd_ofs, io.sigsIn.backpressure, x588_rd_en.map(_ && x588_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x589 = VecApply(x588,0)
      val x589_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x589_elem_0""")
      x589_elem_0.r := x588_rd(0).r
      val x778 = Wire(new FixedPoint(true, 10, 22)).suggestName("x778_x589_elem_0_D12") 
      x778.r := getRetimed(x589_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x749 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x749""")
      x749.r := Math.fma(x778,x778,x748,Some(6.0), true.B, "x749").toFixed(x749, "cast_x749").r
      val x592_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x592_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x592_wr_en = List[Bool](true.B)
      val x592_wr_data = List[UInt](x749.r)
      x580_r_0.connectWPort(592, x592_wr_banks, x592_wr_ofs, x592_wr_data, x592_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      x554_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x555_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x556_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x557_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x558_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x580_r_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x593_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x593_inr_UnitPipe **/
