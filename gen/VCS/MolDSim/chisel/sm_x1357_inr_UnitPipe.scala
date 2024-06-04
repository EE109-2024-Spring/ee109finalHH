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

/** Hierarchy: x1357 -> x1367 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1357_inr_UnitPipe **/
class x1357_inr_UnitPipe_kernel(
  list_b1254: List[Bool],
  list_x1347_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1357_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1357_inr_UnitPipe_iiCtr"))
  
  abstract class x1357_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1254 = Input(Bool())
      val in_x1347_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1347_reg_p").asInstanceOf[NBufParams] ))
      val in_x1345_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1345_reg_p").asInstanceOf[NBufParams] ))
      val in_x1314_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1314_r_0_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1254 = {io.in_b1254} 
    def x1347_reg = {io.in_x1347_reg} ; io.in_x1347_reg := DontCare
    def x1345_reg = {io.in_x1345_reg} ; io.in_x1345_reg := DontCare
    def x1314_r_0 = {io.in_x1314_r_0} ; io.in_x1314_r_0 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1357_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1254 <> b1254
    x1347_reg.connectLedger(module.io.in_x1347_reg)
    x1345_reg.connectLedger(module.io.in_x1345_reg)
    x1314_r_0.connectLedger(module.io.in_x1314_r_0)
    module.io.in_b560 <> b560
  }
  val b1254 = list_b1254(0)
  val b560 = list_b1254(1)
  val x1347_reg = list_x1347_reg(0)
  val x1345_reg = list_x1347_reg(1)
  val x1314_r_0 = list_x1347_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1357_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1357_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1357_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1357_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1357_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1357_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1357_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1357_instrctr, cycles_x1357_inr_UnitPipe.io.count, iters_x1357_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1349_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1349_rd""")
      val x1349_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1349_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1349_rd_en = List[Bool](true.B)
      val x1349_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1349_rd_shared_en")
      x1349_rd.toSeq.zip(x1314_r_0.connectRPort(1349, x1349_rd_banks, x1349_rd_ofs, io.sigsIn.backpressure, x1349_rd_en.map(_ && x1349_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1350 = VecApply(x1349,0)
      val x1350_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1350_elem_0""")
      x1350_elem_0.r := x1349_rd(0).r
      val x1351 = Wire(Bool()).suggestName("""x1351""")
      x1351.r := Math.lt(0.FP(true, 10, 22), x1350_elem_0, Some(0.4), true.B,"x1351").r
      val x1352 = Wire(Bool()).suggestName("""x1352""")
      x1352.r := Math.lt(1.FP(true, 10, 22), x1350_elem_0, Some(0.4), true.B,"x1352").r
      val x1353 = Wire(Bool()).suggestName("""x1353""")
      x1353 := x1351 & x1352
      val x1354 = Wire(Bool()).suggestName("""x1354""")
      x1354 := ~x1353
      val x1355_wr_x1345_banks = List[UInt]()
      val x1355_wr_x1345_ofs = List[UInt]()
      val x1355_wr_x1345_en = List[Bool](true.B)
      val x1355_wr_x1345_data = List[UInt](x1353.r)
      x1345_reg.connectWPort(1355, x1355_wr_x1345_banks, x1355_wr_x1345_ofs, x1355_wr_x1345_data, x1355_wr_x1345_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1356_wr_x1347_banks = List[UInt]()
      val x1356_wr_x1347_ofs = List[UInt]()
      val x1356_wr_x1347_en = List[Bool](true.B)
      val x1356_wr_x1347_data = List[UInt](x1354.r)
      x1347_reg.connectWPort(1356, x1356_wr_x1347_banks, x1356_wr_x1347_ofs, x1356_wr_x1347_data, x1356_wr_x1347_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1357_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1357_inr_UnitPipe **/
