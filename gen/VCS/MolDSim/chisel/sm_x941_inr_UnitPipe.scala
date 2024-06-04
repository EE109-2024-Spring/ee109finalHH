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

/** Hierarchy: x941 -> x951 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x941_inr_UnitPipe **/
class x941_inr_UnitPipe_kernel(
  list_b838: List[Bool],
  list_x898_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x941_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x941_inr_UnitPipe_iiCtr"))
  
  abstract class x941_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x898_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x898_r_0_p").asInstanceOf[NBufParams] ))
      val in_b838 = Input(Bool())
      val in_b558 = Input(Bool())
      val in_x931_reg = Flipped(new NBufInterface(ModuleParams.getParams("x931_reg_p").asInstanceOf[NBufParams] ))
      val in_x929_reg = Flipped(new NBufInterface(ModuleParams.getParams("x929_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x898_r_0 = {io.in_x898_r_0} ; io.in_x898_r_0 := DontCare
    def b838 = {io.in_b838} 
    def b558 = {io.in_b558} 
    def x931_reg = {io.in_x931_reg} ; io.in_x931_reg := DontCare
    def x929_reg = {io.in_x929_reg} ; io.in_x929_reg := DontCare
  }
  def connectWires0(module: x941_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x898_r_0.connectLedger(module.io.in_x898_r_0)
    module.io.in_b838 <> b838
    module.io.in_b558 <> b558
    x931_reg.connectLedger(module.io.in_x931_reg)
    x929_reg.connectLedger(module.io.in_x929_reg)
  }
  val b838 = list_b838(0)
  val b558 = list_b838(1)
  val x898_r_0 = list_x898_r_0(0)
  val x931_reg = list_x898_r_0(1)
  val x929_reg = list_x898_r_0(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x941_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x941_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x941_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x941_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x941_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x941_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x941_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X941_instrctr, cycles_x941_inr_UnitPipe.io.count, iters_x941_inr_UnitPipe.io.count, 0.U, 0.U)
      val x933_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x933_rd""")
      val x933_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x933_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x933_rd_en = List[Bool](true.B)
      val x933_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x933_rd_shared_en")
      x933_rd.toSeq.zip(x898_r_0.connectRPort(933, x933_rd_banks, x933_rd_ofs, io.sigsIn.backpressure, x933_rd_en.map(_ && x933_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x934 = VecApply(x933,0)
      val x934_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x934_elem_0""")
      x934_elem_0.r := x933_rd(0).r
      val x935 = Wire(Bool()).suggestName("""x935""")
      x935.r := Math.lt(0.FP(true, 10, 22), x934_elem_0, Some(0.4), true.B,"x935").r
      val x936 = Wire(Bool()).suggestName("""x936""")
      x936.r := Math.lt(1.FP(true, 10, 22), x934_elem_0, Some(0.4), true.B,"x936").r
      val x937 = Wire(Bool()).suggestName("""x937""")
      x937 := x935 & x936
      val x938 = Wire(Bool()).suggestName("""x938""")
      x938 := ~x937
      val x939_wr_x929_banks = List[UInt]()
      val x939_wr_x929_ofs = List[UInt]()
      val x939_wr_x929_en = List[Bool](true.B)
      val x939_wr_x929_data = List[UInt](x937.r)
      x929_reg.connectWPort(939, x939_wr_x929_banks, x939_wr_x929_ofs, x939_wr_x929_data, x939_wr_x929_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x940_wr_x931_banks = List[UInt]()
      val x940_wr_x931_ofs = List[UInt]()
      val x940_wr_x931_en = List[Bool](true.B)
      val x940_wr_x931_data = List[UInt](x938.r)
      x931_reg.connectWPort(940, x940_wr_x931_banks, x940_wr_x931_ofs, x940_wr_x931_data, x940_wr_x931_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x941_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x941_inr_UnitPipe **/
