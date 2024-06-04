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

/** Hierarchy: x653 -> x668 -> x444 **/
/** BEGIN None x653_outr_Reduce **/
class x653_outr_Reduce_kernel(
  list_b542: List[FixedPoint],
  list_b543: List[Bool],
  list_x545_accum_1: List[NBufInterface],
  list_x549_ctrchain: List[CounterChainInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 7, isFSM = false   , latency = 0.0.toInt, myName = "x653_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x653_outr_Reduce_iiCtr"))
  
  abstract class x653_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b542 = Input(new FixedPoint(true, 32, 0))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x545_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x545_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x544_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_accum_0_p").asInstanceOf[MemParams] ))
      val in_x549_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x549_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b543 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(7, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(7, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b542 = {io.in_b542} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x545_accum_1 = {io.in_x545_accum_1} ; io.in_x545_accum_1 := DontCare
    def x544_accum_0 = {io.in_x544_accum_0} ; io.in_x544_accum_0 := DontCare
    def x549_ctrchain = {io.in_x549_ctrchain} ; io.in_x549_ctrchain := DontCare
    def b543 = {io.in_b543} 
  }
  def connectWires0(module: x653_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b542 <> b542
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x545_accum_1.connectLedger(module.io.in_x545_accum_1)
    x544_accum_0.connectLedger(module.io.in_x544_accum_0)
    module.io.in_x549_ctrchain.input <> x549_ctrchain.input; module.io.in_x549_ctrchain.output <> x549_ctrchain.output
    module.io.in_b543 <> b543
  }
  val b542 = list_b542(0)
  val b543 = list_b543(0)
  val x545_accum_1 = list_x545_accum_1(0)
  val x549_ctrchain = list_x549_ctrchain(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x544_accum_0 = list_x472_A_sram_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x653_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x653_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x653_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b550 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b550.suggestName("b550")
      val b550_chain = Module(new RegChainPass(7, 32, myName = "b550_chain")); b550_chain.io <> DontCare
      b550_chain.chain_pass(b550, io.sigsOut.smDoneIn.head)
      val b550_chain_read_1 = b550_chain.read(1).FP(true,32,0)
      val b550_chain_read_2 = b550_chain.read(2).FP(true,32,0)
      val b550_chain_read_3 = b550_chain.read(3).FP(true,32,0)
      val b550_chain_read_4 = b550_chain.read(4).FP(true,32,0)
      val b550_chain_read_5 = b550_chain.read(5).FP(true,32,0)
      val b550_chain_read_6 = b550_chain.read(6).FP(true,32,0)
      val b552 = ~io.sigsIn.cchainOutputs.head.oobs(0); b552.suggestName("b552")
      val b552_chain = Module(new RegChainPass(7, 1, myName = "b552_chain")); b552_chain.io <> DontCare
      b552_chain.chain_pass(b552, io.sigsOut.smDoneIn.head)
      val b552_chain_read_1: Bool = b552_chain.read(1).apply(0)
      val b552_chain_read_2: Bool = b552_chain.read(2).apply(0)
      val b552_chain_read_3: Bool = b552_chain.read(3).apply(0)
      val b552_chain_read_4: Bool = b552_chain.read(4).apply(0)
      val b552_chain_read_5: Bool = b552_chain.read(5).apply(0)
      val b552_chain_read_6: Bool = b552_chain.read(6).apply(0)
      val x554_tmp_0 = (new x554_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x555_tmp_1 = (new x555_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x556_tmp_2 = (new x556_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x557_tmp_3 = (new x557_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x558_tmp_4 = (new x558_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x559_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x560_ctrchain = (new CChainObject(List[CtrObject](x559_ctr), "x560_ctrchain")).cchain.io 
      x560_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x560_ctrchain_p", (x560_ctrchain.par, x560_ctrchain.widths))
      val x579_inr_Foreach = new x579_inr_Foreach_kernel(List(b552,b543), List(b550,b542), List(x472_A_sram_1,x471_A_sram_0), List(x555_tmp_1,x554_tmp_0,x558_tmp_4,x557_tmp_3,x556_tmp_2) ,  Some(me), List(x560_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x579_inr_Foreach.sm.io.ctrDone := (x579_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b550_chain.connectStageCtrl((x579_inr_Foreach.done).DS(1.toInt, rr, x579_inr_Foreach.sm.io.backpressure), x579_inr_Foreach.baseEn, 0)
      b552_chain.connectStageCtrl((x579_inr_Foreach.done).DS(1.toInt, rr, x579_inr_Foreach.sm.io.backpressure), x579_inr_Foreach.baseEn, 0)
      x579_inr_Foreach.backpressure := true.B | x579_inr_Foreach.sm.io.doneLatch
      x579_inr_Foreach.forwardpressure := (true.B) && (true.B) | x579_inr_Foreach.sm.io.doneLatch
      x579_inr_Foreach.sm.io.enableOut.zip(x579_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x579_inr_Foreach.sm.io.break := false.B
      x579_inr_Foreach.mask := ~x579_inr_Foreach.cchain.head.output.noop & b552 & b543
      x579_inr_Foreach.configure("x579_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x579_inr_Foreach.kernel()
      val x580_r_0 = (new x580_r_0).m.io.asInstanceOf[NBufInterface]
      val x593_inr_UnitPipe = new x593_inr_UnitPipe_kernel(List(b552_chain_read_1,b543), List(x555_tmp_1,x554_tmp_0,x558_tmp_4,x557_tmp_3,x580_r_0,x556_tmp_2) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x593_inr_UnitPipe.sm.io.ctrDone := risingEdge(x593_inr_UnitPipe.sm.io.ctrInc)
      b550_chain.connectStageCtrl((x593_inr_UnitPipe.done).DS(1.toInt, rr, x593_inr_UnitPipe.sm.io.backpressure), x593_inr_UnitPipe.baseEn, 1)
      b552_chain.connectStageCtrl((x593_inr_UnitPipe.done).DS(1.toInt, rr, x593_inr_UnitPipe.sm.io.backpressure), x593_inr_UnitPipe.baseEn, 1)
      x593_inr_UnitPipe.backpressure := true.B | x593_inr_UnitPipe.sm.io.doneLatch
      x593_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x593_inr_UnitPipe.sm.io.doneLatch
      x593_inr_UnitPipe.sm.io.enableOut.zip(x593_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x593_inr_UnitPipe.sm.io.break := false.B
      x593_inr_UnitPipe.mask := true.B & b552_chain_read_1 & b543
      x593_inr_UnitPipe.configure("x593_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x593_inr_UnitPipe.kernel()
      val x594_force_0 = (new x594_force_0).m.io.asInstanceOf[NBufInterface]
      val x595_reg = (new x595_reg).m.io.asInstanceOf[NBufInterface]
      val x596_reg = (new x596_reg).m.io.asInstanceOf[NBufInterface]
      val x605_inr_UnitPipe = new x605_inr_UnitPipe_kernel(List(b552_chain_read_2,b543), List(x555_tmp_1,x554_tmp_0,x558_tmp_4,x557_tmp_3,x580_r_0,x595_reg,x556_tmp_2,x596_reg) ,  Some(me), List(), 2, 1, 1, List(1), List(32), breakpoints, rr)
      x605_inr_UnitPipe.sm.io.ctrDone := risingEdge(x605_inr_UnitPipe.sm.io.ctrInc)
      b550_chain.connectStageCtrl((x605_inr_UnitPipe.done).DS(1.toInt, rr, x605_inr_UnitPipe.sm.io.backpressure), x605_inr_UnitPipe.baseEn, 2)
      b552_chain.connectStageCtrl((x605_inr_UnitPipe.done).DS(1.toInt, rr, x605_inr_UnitPipe.sm.io.backpressure), x605_inr_UnitPipe.baseEn, 2)
      x605_inr_UnitPipe.backpressure := true.B | x605_inr_UnitPipe.sm.io.doneLatch
      x605_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x605_inr_UnitPipe.sm.io.doneLatch
      x605_inr_UnitPipe.sm.io.enableOut.zip(x605_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x605_inr_UnitPipe.sm.io.break := false.B
      x605_inr_UnitPipe.mask := true.B & b552_chain_read_2 & b543
      x605_inr_UnitPipe.configure("x605_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x605_inr_UnitPipe.kernel()
      val x735_rd_x595 = Wire(Bool()).suggestName("""x735_rd_x595""")
      val x735_rd_x595_banks = List[UInt]()
      val x735_rd_x595_ofs = List[UInt]()
      val x735_rd_x595_en = List[Bool](true.B)
      val x735_rd_x595_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x735_rd_x595_shared_en")
      x735_rd_x595.toSeq.zip(x595_reg.connectRPort(735, x735_rd_x595_banks, x735_rd_x595_ofs, io.sigsIn.backpressure, x735_rd_x595_en.map(_ && x735_rd_x595_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x736_rd_x596 = Wire(Bool()).suggestName("""x736_rd_x596""")
      val x736_rd_x596_banks = List[UInt]()
      val x736_rd_x596_ofs = List[UInt]()
      val x736_rd_x596_en = List[Bool](true.B)
      val x736_rd_x596_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x736_rd_x596_shared_en")
      x736_rd_x596.toSeq.zip(x596_reg.connectRPort(736, x736_rd_x596_banks, x736_rd_x596_ofs, io.sigsIn.backpressure, x736_rd_x596_en.map(_ && x736_rd_x596_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x621_inr_Switch_obj = new x621_inr_Switch_kernel(List(x736_rd_x596,x735_rd_x595), List(x555_tmp_1,x554_tmp_0,x558_tmp_4,x557_tmp_3,x580_r_0,x595_reg,x556_tmp_2,x596_reg) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, rr)
      x621_inr_Switch_obj.sm.io.selectsIn(0) := x735_rd_x595
      x621_inr_Switch_obj.sm.io.selectsIn(1) := x736_rd_x596
      b550_chain.connectStageCtrl((x621_inr_Switch_obj.done).DS(1.toInt, rr, x621_inr_Switch_obj.sm.io.backpressure), x621_inr_Switch_obj.baseEn, 3)
      b552_chain.connectStageCtrl((x621_inr_Switch_obj.done).DS(1.toInt, rr, x621_inr_Switch_obj.sm.io.backpressure), x621_inr_Switch_obj.baseEn, 3)
      x621_inr_Switch_obj.backpressure := true.B | x621_inr_Switch_obj.sm.io.doneLatch
      x621_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x621_inr_Switch_obj.sm.io.doneLatch
      x621_inr_Switch_obj.sm.io.enableOut.zip(x621_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x621_inr_Switch_obj.sm.io.break := false.B
      val x621_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x621_inr_Switch""")
      x621_inr_Switch_obj.mask := true.B & true.B
      x621_inr_Switch_obj.configure("x621_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x621_inr_Switch.r := x621_inr_Switch_obj.kernel().r
      val x623_inr_UnitPipe = new x623_inr_UnitPipe_kernel(List(b552_chain_read_4,b543), List(x621_inr_Switch), List(x555_tmp_1,x554_tmp_0,x558_tmp_4,x594_force_0,x557_tmp_3,x556_tmp_2) ,  Some(me), List(), 4, 1, 1, List(1), List(32), breakpoints, rr)
      x623_inr_UnitPipe.sm.io.ctrDone := risingEdge(x623_inr_UnitPipe.sm.io.ctrInc)
      b550_chain.connectStageCtrl((x623_inr_UnitPipe.done).DS(1.toInt, rr, x623_inr_UnitPipe.sm.io.backpressure), x623_inr_UnitPipe.baseEn, 4)
      b552_chain.connectStageCtrl((x623_inr_UnitPipe.done).DS(1.toInt, rr, x623_inr_UnitPipe.sm.io.backpressure), x623_inr_UnitPipe.baseEn, 4)
      x623_inr_UnitPipe.backpressure := true.B | x623_inr_UnitPipe.sm.io.doneLatch
      x623_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x623_inr_UnitPipe.sm.io.doneLatch
      x623_inr_UnitPipe.sm.io.enableOut.zip(x623_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x623_inr_UnitPipe.sm.io.break := false.B
      x623_inr_UnitPipe.mask := true.B & b552_chain_read_4 & b543
      x623_inr_UnitPipe.configure("x623_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x623_inr_UnitPipe.kernel()
      val x624_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x625_ctrchain = (new CChainObject(List[CtrObject](x624_ctr), "x625_ctrchain")).cchain.io 
      x625_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x625_ctrchain_p", (x625_ctrchain.par, x625_ctrchain.widths))
      val x639_inr_Foreach = new x639_inr_Foreach_kernel(List(b552_chain_read_5,b543), List(x555_tmp_1,x554_tmp_0,x558_tmp_4,x594_force_0,x557_tmp_3,x556_tmp_2) ,  Some(me), List(x625_ctrchain), 5, 1, 1, List(1), List(32), breakpoints, rr)
      x639_inr_Foreach.sm.io.ctrDone := (x639_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b550_chain.connectStageCtrl((x639_inr_Foreach.done).DS(1.toInt, rr, x639_inr_Foreach.sm.io.backpressure), x639_inr_Foreach.baseEn, 5)
      b552_chain.connectStageCtrl((x639_inr_Foreach.done).DS(1.toInt, rr, x639_inr_Foreach.sm.io.backpressure), x639_inr_Foreach.baseEn, 5)
      x639_inr_Foreach.backpressure := true.B | x639_inr_Foreach.sm.io.doneLatch
      x639_inr_Foreach.forwardpressure := (true.B) && (true.B) | x639_inr_Foreach.sm.io.doneLatch
      x639_inr_Foreach.sm.io.enableOut.zip(x639_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x639_inr_Foreach.sm.io.break := false.B
      x639_inr_Foreach.mask := ~x639_inr_Foreach.cchain.head.output.noop & b552_chain_read_5 & b543
      x639_inr_Foreach.configure("x639_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x639_inr_Foreach.kernel()
      val x652_inr_Foreach = new x652_inr_Foreach_kernel(List(b543), List(b550_chain_read_6), List(x544_accum_0), List(x558_tmp_4,x545_accum_1) ,  Some(me), List(x549_ctrchain), 6, 1, 1, List(1), List(32), breakpoints, rr)
      x652_inr_Foreach.sm.io.ctrDone := (x652_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b550_chain.connectStageCtrl((x652_inr_Foreach.done).DS(1.toInt, rr, x652_inr_Foreach.sm.io.backpressure), x652_inr_Foreach.baseEn, 6)
      b552_chain.connectStageCtrl((x652_inr_Foreach.done).DS(1.toInt, rr, x652_inr_Foreach.sm.io.backpressure), x652_inr_Foreach.baseEn, 6)
      x652_inr_Foreach.backpressure := true.B | x652_inr_Foreach.sm.io.doneLatch
      x652_inr_Foreach.forwardpressure := (true.B) && (true.B) | x652_inr_Foreach.sm.io.doneLatch
      x652_inr_Foreach.sm.io.enableOut.zip(x652_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x652_inr_Foreach.sm.io.break := false.B
      x652_inr_Foreach.mask := ~x652_inr_Foreach.cchain.head.output.noop & true.B
      x652_inr_Foreach.configure("x652_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x652_inr_Foreach.kernel()
      x545_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x653_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledReduce x653_outr_Reduce **/
