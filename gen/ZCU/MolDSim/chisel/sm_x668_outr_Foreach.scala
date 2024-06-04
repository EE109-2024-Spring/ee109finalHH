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

/** Hierarchy: x668 -> x444 **/
/** BEGIN None x668_outr_Foreach **/
class x668_outr_Foreach_kernel(
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 2, isFSM = false   , latency = 0.0.toInt, myName = "x668_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x668_outr_Foreach_iiCtr"))
  
  abstract class x668_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x539_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x539_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x539_out_sram_0 = {io.in_x539_out_sram_0} ; io.in_x539_out_sram_0 := DontCare
  }
  def connectWires0(module: x668_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x539_out_sram_0.connectLedger(module.io.in_x539_out_sram_0)
  }
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x473_A_sram_2 = list_x472_A_sram_1(2)
  val x539_out_sram_0 = list_x472_A_sram_1(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x668_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x668_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x668_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b542 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b542.suggestName("b542")
      val b542_chain = Module(new RegChainPass(2, 32, myName = "b542_chain")); b542_chain.io <> DontCare
      b542_chain.chain_pass(b542, io.sigsOut.smDoneIn.head)
      val b542_chain_read_1 = b542_chain.read(1).FP(true,32,0)
      val b543 = ~io.sigsIn.cchainOutputs.head.oobs(0); b543.suggestName("b543")
      val b543_chain = Module(new RegChainPass(2, 1, myName = "b543_chain")); b543_chain.io <> DontCare
      b543_chain.chain_pass(b543, io.sigsOut.smDoneIn.head)
      val b543_chain_read_1: Bool = b543_chain.read(1).apply(0)
      val x544_accum_0 = (new x544_accum_0).m.io.asInstanceOf[StandardInterface]
      val x545_accum_1 = (new x545_accum_1).m.io.asInstanceOf[NBufInterface]
      val x546_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 1, 9, false)
      val x547_ctrchain = (new CChainObject(List[CtrObject](x546_ctr), "x547_ctrchain")).cchain.io 
      x547_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x547_ctrchain_p", (x547_ctrchain.par, x547_ctrchain.widths))
      val x548_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x549_ctrchain = (new CChainObject(List[CtrObject](x548_ctr), "x549_ctrchain")).cchain.io 
      x549_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x549_ctrchain_p", (x549_ctrchain.par, x549_ctrchain.widths))
      val x653_outr_Reduce = new x653_outr_Reduce_kernel(List(b542), List(b543), List(x545_accum_1), List(x549_ctrchain), List(x472_A_sram_1,x471_A_sram_0,x544_accum_0) ,  Some(me), List(x547_ctrchain), 0, 7, 1, List(1), List(32), breakpoints, rr)
      x653_outr_Reduce.sm.io.ctrDone := (x653_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b542_chain.connectStageCtrl((x653_outr_Reduce.done).DS(1.toInt, rr, x653_outr_Reduce.sm.io.backpressure), x653_outr_Reduce.baseEn, 0)
      b543_chain.connectStageCtrl((x653_outr_Reduce.done).DS(1.toInt, rr, x653_outr_Reduce.sm.io.backpressure), x653_outr_Reduce.baseEn, 0)
      x653_outr_Reduce.backpressure := true.B | x653_outr_Reduce.sm.io.doneLatch
      x653_outr_Reduce.forwardpressure := (true.B) && (true.B) | x653_outr_Reduce.sm.io.doneLatch
      x653_outr_Reduce.sm.io.enableOut.zip(x653_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x653_outr_Reduce.sm.io.break := false.B
      x653_outr_Reduce.mask := ~x653_outr_Reduce.cchain.head.output.noop & b543
      x653_outr_Reduce.configure("x653_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x653_outr_Reduce.kernel()
      val x654_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x655_ctrchain = (new CChainObject(List[CtrObject](x654_ctr), "x655_ctrchain")).cchain.io 
      x655_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x655_ctrchain_p", (x655_ctrchain.par, x655_ctrchain.widths))
      val x667_inr_Foreach = new x667_inr_Foreach_kernel(List(b543_chain_read_1), List(b542_chain_read_1), List(x473_A_sram_2,x539_out_sram_0), List(x545_accum_1) ,  Some(me), List(x655_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x667_inr_Foreach.sm.io.ctrDone := (x667_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b542_chain.connectStageCtrl((x667_inr_Foreach.done).DS(1.toInt, rr, x667_inr_Foreach.sm.io.backpressure), x667_inr_Foreach.baseEn, 1)
      b543_chain.connectStageCtrl((x667_inr_Foreach.done).DS(1.toInt, rr, x667_inr_Foreach.sm.io.backpressure), x667_inr_Foreach.baseEn, 1)
      x667_inr_Foreach.backpressure := true.B | x667_inr_Foreach.sm.io.doneLatch
      x667_inr_Foreach.forwardpressure := (true.B) && (true.B) | x667_inr_Foreach.sm.io.doneLatch
      x667_inr_Foreach.sm.io.enableOut.zip(x667_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x667_inr_Foreach.sm.io.break := false.B
      x667_inr_Foreach.mask := ~x667_inr_Foreach.cchain.head.output.noop & b543_chain_read_1
      x667_inr_Foreach.configure("x667_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x667_inr_Foreach.kernel()
    }
    val module = Module(new x668_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x668_outr_Foreach **/
