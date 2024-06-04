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

/** Hierarchy: x2397 -> x2407 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2397_inr_UnitPipe **/
class x2397_inr_UnitPipe_kernel(
  list_b565: List[Bool],
  list_x2387_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x2397_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2397_inr_UnitPipe_iiCtr"))
  
  abstract class x2397_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b565 = Input(Bool())
      val in_x2387_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2387_reg_p").asInstanceOf[NBufParams] ))
      val in_x2354_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2354_r_0_p").asInstanceOf[NBufParams] ))
      val in_b2294 = Input(Bool())
      val in_x2385_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2385_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b565 = {io.in_b565} 
    def x2387_reg = {io.in_x2387_reg} ; io.in_x2387_reg := DontCare
    def x2354_r_0 = {io.in_x2354_r_0} ; io.in_x2354_r_0 := DontCare
    def b2294 = {io.in_b2294} 
    def x2385_reg = {io.in_x2385_reg} ; io.in_x2385_reg := DontCare
  }
  def connectWires0(module: x2397_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b565 <> b565
    x2387_reg.connectLedger(module.io.in_x2387_reg)
    x2354_r_0.connectLedger(module.io.in_x2354_r_0)
    module.io.in_b2294 <> b2294
    x2385_reg.connectLedger(module.io.in_x2385_reg)
  }
  val b565 = list_b565(0)
  val b2294 = list_b565(1)
  val x2387_reg = list_x2387_reg(0)
  val x2354_r_0 = list_x2387_reg(1)
  val x2385_reg = list_x2387_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2397_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2397_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2397_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2397_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2397_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2397_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2397_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2397_instrctr, cycles_x2397_inr_UnitPipe.io.count, iters_x2397_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2389_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2389_rd""")
      val x2389_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2389_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2389_rd_en = List[Bool](true.B)
      val x2389_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2389_rd_shared_en")
      x2389_rd.toSeq.zip(x2354_r_0.connectRPort(2389, x2389_rd_banks, x2389_rd_ofs, io.sigsIn.backpressure, x2389_rd_en.map(_ && x2389_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2390 = VecApply(x2389,0)
      val x2390_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2390_elem_0""")
      x2390_elem_0.r := x2389_rd(0).r
      val x2391 = Wire(Bool()).suggestName("""x2391""")
      x2391.r := Math.lt(0.FP(true, 10, 22), x2390_elem_0, Some(0.4), true.B,"x2391").r
      val x2392 = Wire(Bool()).suggestName("""x2392""")
      x2392.r := Math.lt(1.FP(true, 10, 22), x2390_elem_0, Some(0.4), true.B,"x2392").r
      val x2393 = Wire(Bool()).suggestName("""x2393""")
      x2393 := x2391 & x2392
      val x2394 = Wire(Bool()).suggestName("""x2394""")
      x2394 := ~x2393
      val x2395_wr_x2385_banks = List[UInt]()
      val x2395_wr_x2385_ofs = List[UInt]()
      val x2395_wr_x2385_en = List[Bool](true.B)
      val x2395_wr_x2385_data = List[UInt](x2393.r)
      x2385_reg.connectWPort(2395, x2395_wr_x2385_banks, x2395_wr_x2385_ofs, x2395_wr_x2385_data, x2395_wr_x2385_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x2396_wr_x2387_banks = List[UInt]()
      val x2396_wr_x2387_ofs = List[UInt]()
      val x2396_wr_x2387_en = List[Bool](true.B)
      val x2396_wr_x2387_data = List[UInt](x2394.r)
      x2387_reg.connectWPort(2396, x2396_wr_x2387_banks, x2396_wr_x2387_ofs, x2396_wr_x2387_data, x2396_wr_x2387_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2397_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2397_inr_UnitPipe **/
