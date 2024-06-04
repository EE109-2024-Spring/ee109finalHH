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

/** Hierarchy: x2406 -> x2407 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2406_inr_UnitPipe **/
class x2406_inr_UnitPipe_kernel(
  list_b2295: List[Bool],
  list_x2388_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x2406_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2406_inr_UnitPipe_iiCtr"))
  
  abstract class x2406_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2295 = Input(Bool())
      val in_b565 = Input(Bool())
      val in_x2388_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2388_reg_p").asInstanceOf[NBufParams] ))
      val in_x2355_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2355_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2386_reg = Flipped(new NBufInterface(ModuleParams.getParams("x2386_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b2295 = {io.in_b2295} 
    def b565 = {io.in_b565} 
    def x2388_reg = {io.in_x2388_reg} ; io.in_x2388_reg := DontCare
    def x2355_r_0 = {io.in_x2355_r_0} ; io.in_x2355_r_0 := DontCare
    def x2386_reg = {io.in_x2386_reg} ; io.in_x2386_reg := DontCare
  }
  def connectWires0(module: x2406_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2295 <> b2295
    module.io.in_b565 <> b565
    x2388_reg.connectLedger(module.io.in_x2388_reg)
    x2355_r_0.connectLedger(module.io.in_x2355_r_0)
    x2386_reg.connectLedger(module.io.in_x2386_reg)
  }
  val b2295 = list_b2295(0)
  val b565 = list_b2295(1)
  val x2388_reg = list_x2388_reg(0)
  val x2355_r_0 = list_x2388_reg(1)
  val x2386_reg = list_x2388_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2406_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2406_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2406_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2406_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2406_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2406_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2406_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2406_instrctr, cycles_x2406_inr_UnitPipe.io.count, iters_x2406_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2398_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2398_rd""")
      val x2398_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2398_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2398_rd_en = List[Bool](true.B)
      val x2398_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2398_rd_shared_en")
      x2398_rd.toSeq.zip(x2355_r_0.connectRPort(2398, x2398_rd_banks, x2398_rd_ofs, io.sigsIn.backpressure, x2398_rd_en.map(_ && x2398_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2399 = VecApply(x2398,0)
      val x2399_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2399_elem_0""")
      x2399_elem_0.r := x2398_rd(0).r
      val x2400 = Wire(Bool()).suggestName("""x2400""")
      x2400.r := Math.lt(0.FP(true, 10, 22), x2399_elem_0, Some(0.4), true.B,"x2400").r
      val x2401 = Wire(Bool()).suggestName("""x2401""")
      x2401.r := Math.lt(1.FP(true, 10, 22), x2399_elem_0, Some(0.4), true.B,"x2401").r
      val x2402 = Wire(Bool()).suggestName("""x2402""")
      x2402 := x2400 & x2401
      val x2403 = Wire(Bool()).suggestName("""x2403""")
      x2403 := ~x2402
      val x2404_wr_x2386_banks = List[UInt]()
      val x2404_wr_x2386_ofs = List[UInt]()
      val x2404_wr_x2386_en = List[Bool](true.B)
      val x2404_wr_x2386_data = List[UInt](x2402.r)
      x2386_reg.connectWPort(2404, x2404_wr_x2386_banks, x2404_wr_x2386_ofs, x2404_wr_x2386_data, x2404_wr_x2386_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x2405_wr_x2388_banks = List[UInt]()
      val x2405_wr_x2388_ofs = List[UInt]()
      val x2405_wr_x2388_en = List[Bool](true.B)
      val x2405_wr_x2388_data = List[UInt](x2403.r)
      x2388_reg.connectWPort(2405, x2405_wr_x2388_banks, x2405_wr_x2388_ofs, x2405_wr_x2388_data, x2405_wr_x2388_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2406_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2406_inr_UnitPipe **/
