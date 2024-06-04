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

/** Hierarchy: x1366 -> x1367 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1366_inr_UnitPipe **/
class x1366_inr_UnitPipe_kernel(
  list_b1255: List[Bool],
  list_x1315_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1366_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1366_inr_UnitPipe_iiCtr"))
  
  abstract class x1366_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1315_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1315_r_0_p").asInstanceOf[NBufParams] ))
      val in_b1255 = Input(Bool())
      val in_x1348_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1348_reg_p").asInstanceOf[NBufParams] ))
      val in_x1346_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1346_reg_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1315_r_0 = {io.in_x1315_r_0} ; io.in_x1315_r_0 := DontCare
    def b1255 = {io.in_b1255} 
    def x1348_reg = {io.in_x1348_reg} ; io.in_x1348_reg := DontCare
    def x1346_reg = {io.in_x1346_reg} ; io.in_x1346_reg := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1366_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1315_r_0.connectLedger(module.io.in_x1315_r_0)
    module.io.in_b1255 <> b1255
    x1348_reg.connectLedger(module.io.in_x1348_reg)
    x1346_reg.connectLedger(module.io.in_x1346_reg)
    module.io.in_b560 <> b560
  }
  val b1255 = list_b1255(0)
  val b560 = list_b1255(1)
  val x1315_r_0 = list_x1315_r_0(0)
  val x1348_reg = list_x1315_r_0(1)
  val x1346_reg = list_x1315_r_0(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1366_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1366_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1366_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1366_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1366_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1366_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1366_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1366_instrctr, cycles_x1366_inr_UnitPipe.io.count, iters_x1366_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1358_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1358_rd""")
      val x1358_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1358_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1358_rd_en = List[Bool](true.B)
      val x1358_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1358_rd_shared_en")
      x1358_rd.toSeq.zip(x1315_r_0.connectRPort(1358, x1358_rd_banks, x1358_rd_ofs, io.sigsIn.backpressure, x1358_rd_en.map(_ && x1358_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1359 = VecApply(x1358,0)
      val x1359_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1359_elem_0""")
      x1359_elem_0.r := x1358_rd(0).r
      val x1360 = Wire(Bool()).suggestName("""x1360""")
      x1360.r := Math.lt(0.FP(true, 10, 22), x1359_elem_0, Some(0.4), true.B,"x1360").r
      val x1361 = Wire(Bool()).suggestName("""x1361""")
      x1361.r := Math.lt(1.FP(true, 10, 22), x1359_elem_0, Some(0.4), true.B,"x1361").r
      val x1362 = Wire(Bool()).suggestName("""x1362""")
      x1362 := x1360 & x1361
      val x1363 = Wire(Bool()).suggestName("""x1363""")
      x1363 := ~x1362
      val x1364_wr_x1346_banks = List[UInt]()
      val x1364_wr_x1346_ofs = List[UInt]()
      val x1364_wr_x1346_en = List[Bool](true.B)
      val x1364_wr_x1346_data = List[UInt](x1362.r)
      x1346_reg.connectWPort(1364, x1364_wr_x1346_banks, x1364_wr_x1346_ofs, x1364_wr_x1346_data, x1364_wr_x1346_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1365_wr_x1348_banks = List[UInt]()
      val x1365_wr_x1348_ofs = List[UInt]()
      val x1365_wr_x1348_en = List[Bool](true.B)
      val x1365_wr_x1348_data = List[UInt](x1363.r)
      x1348_reg.connectWPort(1365, x1365_wr_x1348_banks, x1365_wr_x1348_ofs, x1365_wr_x1348_data, x1365_wr_x1348_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1366_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1366_inr_UnitPipe **/
