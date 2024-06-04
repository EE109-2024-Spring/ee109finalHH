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

/** Hierarchy: x516 -> x542 -> x543 -> x444 **/
/** BEGIN None x516_inr_UnitPipe **/
class x516_inr_UnitPipe_kernel(
  list_b504: List[Bool],
  list_x475_fifo: List[FIFOInterface],
  list_x507_reg: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 1.0.toInt, myName = "x516_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x516_inr_UnitPipe_iiCtr"))
  
  abstract class x516_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b504 = Input(Bool())
      val in_x475_fifo = Flipped(new FIFOInterface(ModuleParams.getParams("x475_fifo_p").asInstanceOf[MemParams] ))
      val in_x507_reg = Flipped(new StandardInterface(ModuleParams.getParams("x507_reg_p").asInstanceOf[MemParams] ))
      val in_x505_reg = Flipped(new StandardInterface(ModuleParams.getParams("x505_reg_p").asInstanceOf[MemParams] ))
      val in_x506_reg = Flipped(new StandardInterface(ModuleParams.getParams("x506_reg_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b504 = {io.in_b504} 
    def x475_fifo = {io.in_x475_fifo} ; io.in_x475_fifo := DontCare
    def x507_reg = {io.in_x507_reg} ; io.in_x507_reg := DontCare
    def x505_reg = {io.in_x505_reg} ; io.in_x505_reg := DontCare
    def x506_reg = {io.in_x506_reg} ; io.in_x506_reg := DontCare
  }
  def connectWires0(module: x516_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b504 <> b504
    x475_fifo.connectLedger(module.io.in_x475_fifo)
    x507_reg.connectLedger(module.io.in_x507_reg)
    x505_reg.connectLedger(module.io.in_x505_reg)
    x506_reg.connectLedger(module.io.in_x506_reg)
  }
  val b504 = list_b504(0)
  val x475_fifo = list_x475_fifo(0)
  val x507_reg = list_x507_reg(0)
  val x505_reg = list_x507_reg(1)
  val x506_reg = list_x507_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x516_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x516_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x516_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x516_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x516_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x516_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x516_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      val stalls_x516_inr_UnitPipe = Module(new InstrumentationCounter())
      val idles_x516_inr_UnitPipe = Module(new InstrumentationCounter())
      stalls_x516_inr_UnitPipe.io.enable := io.sigsIn.baseEn & ~(true.B)
      idles_x516_inr_UnitPipe.io.enable := io.sigsIn.baseEn & ~(((~x475_fifo.empty.D(1.0-1) | ~(x475_fifo.active(1).out))) && (true.B))
      Ledger.tieInstrCtr(instrctrs.toList, X516_instrctr, cycles_x516_inr_UnitPipe.io.count, iters_x516_inr_UnitPipe.io.count, stalls_x516_inr_UnitPipe.io.count, idles_x516_inr_UnitPipe.io.count)
      val x508_deq_x475 = Wire(Vec(1, UInt(96.W))).suggestName("""x508_deq_x475""")
      val x508_deq_x475_banks = List[UInt]()
      val x508_deq_x475_ofs = List[UInt]()
      val x508_deq_x475_en = List[Bool](true.B)
      val x508_deq_x475_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x508_deq_x475_shared_en")
      x508_deq_x475.toSeq.zip(x475_fifo.connectRPort(508, x508_deq_x475_banks, x508_deq_x475_ofs, io.sigsIn.backpressure, x508_deq_x475_en.map(_ && x508_deq_x475_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      x475_fifo.connectAccessActivesIn(1, ((true.B)))
      // x509 = VecApply(x508,0)
      val x509_elem_0 = Wire(UInt(96.W)).suggestName("""x509_elem_0""")
      x509_elem_0.r := x508_deq_x475(0).r
      val x510_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x510_apply""")
      x510_apply.r := x509_elem_0(63, 32)
      val x511_wr_x505_banks = List[UInt]()
      val x511_wr_x505_ofs = List[UInt]()
      val x511_wr_x505_en = List[Bool](true.B)
      val x511_wr_x505_data = List[UInt](x510_apply.r)
      x505_reg.connectWPort(511, x511_wr_x505_banks, x511_wr_x505_ofs, x511_wr_x505_data, x511_wr_x505_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x512_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x512_apply""")
      x512_apply.r := x509_elem_0(95, 64)
      val x513_wr_x506_banks = List[UInt]()
      val x513_wr_x506_ofs = List[UInt]()
      val x513_wr_x506_en = List[Bool](true.B)
      val x513_wr_x506_data = List[UInt](x512_apply.r)
      x506_reg.connectWPort(513, x513_wr_x506_banks, x513_wr_x506_ofs, x513_wr_x506_data, x513_wr_x506_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x514_apply = Wire(new FixedPoint(true, 32, 0)).suggestName("""x514_apply""")
      x514_apply.r := x509_elem_0(31, 0)
      val x515_wr_x507_banks = List[UInt]()
      val x515_wr_x507_ofs = List[UInt]()
      val x515_wr_x507_en = List[Bool](true.B)
      val x515_wr_x507_data = List[UInt](x514_apply.r)
      x507_reg.connectWPort(515, x515_wr_x507_banks, x515_wr_x507_ofs, x515_wr_x507_data, x515_wr_x507_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x516_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x516_inr_UnitPipe **/
