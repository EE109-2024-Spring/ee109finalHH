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

/** Hierarchy: x542 -> x543 -> x444 **/
/** BEGIN None x542_outr_Foreach **/
class x542_outr_Foreach_kernel(
  list_x475_fifo: List[FIFOInterface],
  list_x476: List[DecoupledIO[AppLoadData]],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x542_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x542_outr_Foreach_iiCtr"))
  
  abstract class x542_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x475_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x475_fifo_p").asInstanceOf[MemParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x476 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x476_p").asInstanceOf[(Int, Int)] )))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x475_fifo = {io.in_x475_fifo} ; io.in_x475_fifo := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x476 = {io.in_x476} 
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
  }
  def connectWires0(module: x542_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x475_fifo.connectLedger(module.io.in_x475_fifo)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_x476 <> x476
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
  }
  val x475_fifo = list_x475_fifo(0)
  val x476 = list_x476(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x473_A_sram_2 = list_x472_A_sram_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x542_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x542_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x542_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x542_outr_Foreach = Module(new InstrumentationCounter())
      val iters_x542_outr_Foreach = Module(new InstrumentationCounter())
      cycles_x542_outr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x542_outr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X542_instrctr, cycles_x542_outr_Foreach.io.count, iters_x542_outr_Foreach.io.count, 0.U, 0.U)
      val b503 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b503.suggestName("b503")
      val b504 = ~io.sigsIn.cchainOutputs.head.oobs(0); b504.suggestName("b504")
      val x505_reg = (new x505_reg).m.io.asInstanceOf[StandardInterface]
      val x506_reg = (new x506_reg).m.io.asInstanceOf[StandardInterface]
      val x507_reg = (new x507_reg).m.io.asInstanceOf[StandardInterface]
      val x516_inr_UnitPipe = new x516_inr_UnitPipe_kernel(List(b504), List(x475_fifo), List(x507_reg,x505_reg,x506_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x516_inr_UnitPipe.sm.io.ctrDone := risingEdge(x516_inr_UnitPipe.sm.io.ctrInc)
      x516_inr_UnitPipe.backpressure := true.B | x516_inr_UnitPipe.sm.io.doneLatch
      x516_inr_UnitPipe.forwardpressure := ((~x475_fifo.empty.D(1.0-1) | ~(x475_fifo.active(1).out))) && (true.B) | x516_inr_UnitPipe.sm.io.doneLatch
      x516_inr_UnitPipe.sm.io.enableOut.zip(x516_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x516_inr_UnitPipe.sm.io.break := false.B
      x516_inr_UnitPipe.mask := true.B & b504
      x516_inr_UnitPipe.configure("x516_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x516_inr_UnitPipe.kernel()
      val x2926_rd_x507 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2926_rd_x507""")
      val x2926_rd_x507_banks = List[UInt]()
      val x2926_rd_x507_ofs = List[UInt]()
      val x2926_rd_x507_en = List[Bool](true.B)
      val x2926_rd_x507_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2926_rd_x507_shared_en")
      x2926_rd_x507.toSeq.zip(x507_reg.connectRPort(2926, x2926_rd_x507_banks, x2926_rd_x507_ofs, io.sigsIn.backpressure, x2926_rd_x507_en.map(_ && x2926_rd_x507_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x518_ctr = new CtrObject(Left(Some(0)), Right(x2926_rd_x507), Left(Some(1)), 1, 32, false)
      val x519_ctrchain = (new CChainObject(List[CtrObject](x518_ctr), "x519_ctrchain")).cchain.io 
      x519_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x519_ctrchain_p", (x519_ctrchain.par, x519_ctrchain.widths))
      val x541_inr_Foreach = new x541_inr_Foreach_kernel(List(b504), List(b503), List(x476), List(x472_A_sram_1,x471_A_sram_0,x505_reg,x473_A_sram_2,x506_reg) ,  Some(me), List(x519_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x541_inr_Foreach.sm.io.ctrDone := (x541_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x541_inr_Foreach.backpressure := true.B | x541_inr_Foreach.sm.io.doneLatch
      x541_inr_Foreach.forwardpressure := (x476.valid) && (true.B) | x541_inr_Foreach.sm.io.doneLatch
      x541_inr_Foreach.sm.io.enableOut.zip(x541_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x541_inr_Foreach.sm.io.break := false.B
      x541_inr_Foreach.mask := ~x541_inr_Foreach.cchain.head.output.noop & b504
      x541_inr_Foreach.configure("x541_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x541_inr_Foreach.kernel()
    }
    val module = Module(new x542_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x542_outr_Foreach **/
