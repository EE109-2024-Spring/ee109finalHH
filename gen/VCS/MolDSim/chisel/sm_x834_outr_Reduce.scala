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

/** Hierarchy: x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x834_outr_Reduce **/
class x834_outr_Reduce_kernel(
  list_b547: List[FixedPoint],
  list_b557: List[Bool],
  list_x472_A_sram_1: List[StandardInterface],
  list_x617_ctrchain: List[CounterChainInterface],
  list_x568_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x834_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x834_outr_Reduce_iiCtr"))
  
  abstract class x834_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b547 = Input(new FixedPoint(true, 32, 0))
      val in_x567_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x567_accum_0_p").asInstanceOf[MemParams] ))
      val in_x617_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x617_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b557 = Input(Bool())
      val in_x568_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x568_accum_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b547 = {io.in_b547} 
    def x567_accum_0 = {io.in_x567_accum_0} ; io.in_x567_accum_0 := DontCare
    def x617_ctrchain = {io.in_x617_ctrchain} ; io.in_x617_ctrchain := DontCare
    def b557 = {io.in_b557} 
    def x568_accum_1 = {io.in_x568_accum_1} ; io.in_x568_accum_1 := DontCare
  }
  def connectWires0(module: x834_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b547 <> b547
    x567_accum_0.connectLedger(module.io.in_x567_accum_0)
    module.io.in_x617_ctrchain.input <> x617_ctrchain.input; module.io.in_x617_ctrchain.output <> x617_ctrchain.output
    module.io.in_b557 <> b557
    x568_accum_1.connectLedger(module.io.in_x568_accum_1)
  }
  val b547 = list_b547(0)
  val b557 = list_b557(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x567_accum_0 = list_x472_A_sram_1(2)
  val x617_ctrchain = list_x617_ctrchain(0)
  val x568_accum_1 = list_x568_accum_1(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x834_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x834_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x834_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x834_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x834_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x834_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x834_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X834_instrctr, cycles_x834_outr_Reduce.io.count, iters_x834_outr_Reduce.io.count, 0.U, 0.U)
      val b627 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b627.suggestName("b627")
      val b627_chain = Module(new RegChainPass(8, 32, myName = "b627_chain")); b627_chain.io <> DontCare
      b627_chain.chain_pass(b627, io.sigsOut.smDoneIn.head)
      val b627_chain_read_1 = b627_chain.read(1).FP(true,32,0)
      val b627_chain_read_2 = b627_chain.read(2).FP(true,32,0)
      val b627_chain_read_3 = b627_chain.read(3).FP(true,32,0)
      val b627_chain_read_4 = b627_chain.read(4).FP(true,32,0)
      val b627_chain_read_5 = b627_chain.read(5).FP(true,32,0)
      val b627_chain_read_6 = b627_chain.read(6).FP(true,32,0)
      val b627_chain_read_7 = b627_chain.read(7).FP(true,32,0)
      val b628 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b628.suggestName("b628")
      val b628_chain = Module(new RegChainPass(8, 32, myName = "b628_chain")); b628_chain.io <> DontCare
      b628_chain.chain_pass(b628, io.sigsOut.smDoneIn.head)
      val b628_chain_read_1 = b628_chain.read(1).FP(true,32,0)
      val b628_chain_read_2 = b628_chain.read(2).FP(true,32,0)
      val b628_chain_read_3 = b628_chain.read(3).FP(true,32,0)
      val b628_chain_read_4 = b628_chain.read(4).FP(true,32,0)
      val b628_chain_read_5 = b628_chain.read(5).FP(true,32,0)
      val b628_chain_read_6 = b628_chain.read(6).FP(true,32,0)
      val b628_chain_read_7 = b628_chain.read(7).FP(true,32,0)
      val b630 = ~io.sigsIn.cchainOutputs.head.oobs(0); b630.suggestName("b630")
      val b630_chain = Module(new RegChainPass(8, 1, myName = "b630_chain")); b630_chain.io <> DontCare
      b630_chain.chain_pass(b630, io.sigsOut.smDoneIn.head)
      val b630_chain_read_1: Bool = b630_chain.read(1).apply(0)
      val b630_chain_read_2: Bool = b630_chain.read(2).apply(0)
      val b630_chain_read_3: Bool = b630_chain.read(3).apply(0)
      val b630_chain_read_4: Bool = b630_chain.read(4).apply(0)
      val b630_chain_read_5: Bool = b630_chain.read(5).apply(0)
      val b630_chain_read_6: Bool = b630_chain.read(6).apply(0)
      val b630_chain_read_7: Bool = b630_chain.read(7).apply(0)
      val b631 = ~io.sigsIn.cchainOutputs.head.oobs(1); b631.suggestName("b631")
      val b631_chain = Module(new RegChainPass(8, 1, myName = "b631_chain")); b631_chain.io <> DontCare
      b631_chain.chain_pass(b631, io.sigsOut.smDoneIn.head)
      val b631_chain_read_1: Bool = b631_chain.read(1).apply(0)
      val b631_chain_read_2: Bool = b631_chain.read(2).apply(0)
      val b631_chain_read_3: Bool = b631_chain.read(3).apply(0)
      val b631_chain_read_4: Bool = b631_chain.read(4).apply(0)
      val b631_chain_read_5: Bool = b631_chain.read(5).apply(0)
      val b631_chain_read_6: Bool = b631_chain.read(6).apply(0)
      val b631_chain_read_7: Bool = b631_chain.read(7).apply(0)
      val x633_tmp_0 = (new x633_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x634_tmp_1 = (new x634_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x635_tmp_2 = (new x635_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x636_tmp_3 = (new x636_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x637_tmp_4 = (new x637_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x638_tmp_0 = (new x638_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x639_tmp_1 = (new x639_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x640_tmp_2 = (new x640_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x641_tmp_3 = (new x641_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x642_tmp_4 = (new x642_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x643_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x644_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x645_ctrchain = (new CChainObject(List[CtrObject](x643_ctr), "x645_ctrchain")).cchain.io 
      x645_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x645_ctrchain_p", (x645_ctrchain.par, x645_ctrchain.widths))
      val x646_ctrchain = (new CChainObject(List[CtrObject](x644_ctr), "x646_ctrchain")).cchain.io 
      x646_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x646_ctrchain_p", (x646_ctrchain.par, x646_ctrchain.widths))
      val x689 = new x689_kernel(List(b628,b547,b627), List(x645_ctrchain,x646_ctrchain), List(x638_tmp_0,x634_tmp_1,x642_tmp_4,x637_tmp_4,x633_tmp_0,x641_tmp_3,x636_tmp_3,x640_tmp_2,x635_tmp_2,x639_tmp_1), List(b630,b631,b557), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x689.sm.io.ctrDone := risingEdge(x689.sm.io.ctrInc)
      b627_chain.connectStageCtrl((x689.done).DS(1.toInt, rr, x689.sm.io.backpressure), x689.baseEn, 0)
      b628_chain.connectStageCtrl((x689.done).DS(1.toInt, rr, x689.sm.io.backpressure), x689.baseEn, 0)
      b630_chain.connectStageCtrl((x689.done).DS(1.toInt, rr, x689.sm.io.backpressure), x689.baseEn, 0)
      b631_chain.connectStageCtrl((x689.done).DS(1.toInt, rr, x689.sm.io.backpressure), x689.baseEn, 0)
      x689.backpressure := true.B | x689.sm.io.doneLatch
      x689.forwardpressure := (true.B) && (true.B) | x689.sm.io.doneLatch
      x689.sm.io.enableOut.zip(x689.smEnableOuts).foreach{case (l,r) => r := l}
      x689.sm.io.break := false.B
      x689.mask := true.B & b557
      x689.configure("x689", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x689.kernel()
      val x690_r_0 = (new x690_r_0).m.io.asInstanceOf[NBufInterface]
      val x691_r_0 = (new x691_r_0).m.io.asInstanceOf[NBufInterface]
      val x718 = new x718_kernel(List(b630_chain_read_1,b631_chain_read_1,b557), List(x638_tmp_0,x634_tmp_1,x642_tmp_4,x637_tmp_4,x633_tmp_0,x641_tmp_3,x636_tmp_3,x690_r_0,x640_tmp_2,x635_tmp_2,x691_r_0,x639_tmp_1) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x718.sm.io.ctrDone := risingEdge(x718.sm.io.ctrInc)
      b627_chain.connectStageCtrl((x718.done).DS(1.toInt, rr, x718.sm.io.backpressure), x718.baseEn, 1)
      b628_chain.connectStageCtrl((x718.done).DS(1.toInt, rr, x718.sm.io.backpressure), x718.baseEn, 1)
      b630_chain.connectStageCtrl((x718.done).DS(1.toInt, rr, x718.sm.io.backpressure), x718.baseEn, 1)
      b631_chain.connectStageCtrl((x718.done).DS(1.toInt, rr, x718.sm.io.backpressure), x718.baseEn, 1)
      x718.backpressure := true.B | x718.sm.io.doneLatch
      x718.forwardpressure := (true.B) && (true.B) | x718.sm.io.doneLatch
      x718.sm.io.enableOut.zip(x718.smEnableOuts).foreach{case (l,r) => r := l}
      x718.sm.io.break := false.B
      x718.mask := true.B & b557
      x718.configure("x718", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x718.kernel()
      val x719_force_0 = (new x719_force_0).m.io.asInstanceOf[NBufInterface]
      val x720_force_0 = (new x720_force_0).m.io.asInstanceOf[NBufInterface]
      val x721_reg = (new x721_reg).m.io.asInstanceOf[NBufInterface]
      val x722_reg = (new x722_reg).m.io.asInstanceOf[NBufInterface]
      val x723_reg = (new x723_reg).m.io.asInstanceOf[NBufInterface]
      val x724_reg = (new x724_reg).m.io.asInstanceOf[NBufInterface]
      val x743 = new x743_kernel(List(b630_chain_read_2,b631_chain_read_2,b557), List(x724_reg,x638_tmp_0,x634_tmp_1,x642_tmp_4,x637_tmp_4,x721_reg,x633_tmp_0,x641_tmp_3,x636_tmp_3,x722_reg,x690_r_0,x640_tmp_2,x635_tmp_2,x723_reg,x691_r_0,x639_tmp_1) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x743.sm.io.ctrDone := risingEdge(x743.sm.io.ctrInc)
      b627_chain.connectStageCtrl((x743.done).DS(1.toInt, rr, x743.sm.io.backpressure), x743.baseEn, 2)
      b628_chain.connectStageCtrl((x743.done).DS(1.toInt, rr, x743.sm.io.backpressure), x743.baseEn, 2)
      b630_chain.connectStageCtrl((x743.done).DS(1.toInt, rr, x743.sm.io.backpressure), x743.baseEn, 2)
      b631_chain.connectStageCtrl((x743.done).DS(1.toInt, rr, x743.sm.io.backpressure), x743.baseEn, 2)
      x743.backpressure := true.B | x743.sm.io.doneLatch
      x743.forwardpressure := (true.B) && (true.B) | x743.sm.io.doneLatch
      x743.sm.io.enableOut.zip(x743.smEnableOuts).foreach{case (l,r) => r := l}
      x743.sm.io.break := false.B
      x743.mask := true.B & b557
      x743.configure("x743", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x743.kernel()
      val x2927_rd_x721 = Wire(Bool()).suggestName("""x2927_rd_x721""")
      val x2927_rd_x721_banks = List[UInt]()
      val x2927_rd_x721_ofs = List[UInt]()
      val x2927_rd_x721_en = List[Bool](true.B)
      val x2927_rd_x721_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2927_rd_x721_shared_en")
      x2927_rd_x721.toSeq.zip(x721_reg.connectRPort(2927, x2927_rd_x721_banks, x2927_rd_x721_ofs, io.sigsIn.backpressure, x2927_rd_x721_en.map(_ && x2927_rd_x721_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2928_rd_x723 = Wire(Bool()).suggestName("""x2928_rd_x723""")
      val x2928_rd_x723_banks = List[UInt]()
      val x2928_rd_x723_ofs = List[UInt]()
      val x2928_rd_x723_en = List[Bool](true.B)
      val x2928_rd_x723_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2928_rd_x723_shared_en")
      x2928_rd_x723.toSeq.zip(x723_reg.connectRPort(2928, x2928_rd_x723_banks, x2928_rd_x723_ofs, io.sigsIn.backpressure, x2928_rd_x723_en.map(_ && x2928_rd_x723_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x761_inr_Switch_obj = new x761_inr_Switch_kernel(List(x2928_rd_x723,x2927_rd_x721), List(x724_reg,x638_tmp_0,x634_tmp_1,x642_tmp_4,x637_tmp_4,x721_reg,x633_tmp_0,x641_tmp_3,x636_tmp_3,x722_reg,x690_r_0,x640_tmp_2,x635_tmp_2,x723_reg,x691_r_0,x639_tmp_1) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x761_inr_Switch_obj.sm.io.selectsIn(0) := x2927_rd_x721
      x761_inr_Switch_obj.sm.io.selectsIn(1) := x2928_rd_x723
      b627_chain.connectStageCtrl((x761_inr_Switch_obj.done).DS(1.toInt, rr, x761_inr_Switch_obj.sm.io.backpressure), x761_inr_Switch_obj.baseEn, 3)
      b628_chain.connectStageCtrl((x761_inr_Switch_obj.done).DS(1.toInt, rr, x761_inr_Switch_obj.sm.io.backpressure), x761_inr_Switch_obj.baseEn, 3)
      b630_chain.connectStageCtrl((x761_inr_Switch_obj.done).DS(1.toInt, rr, x761_inr_Switch_obj.sm.io.backpressure), x761_inr_Switch_obj.baseEn, 3)
      b631_chain.connectStageCtrl((x761_inr_Switch_obj.done).DS(1.toInt, rr, x761_inr_Switch_obj.sm.io.backpressure), x761_inr_Switch_obj.baseEn, 3)
      x761_inr_Switch_obj.backpressure := true.B | x761_inr_Switch_obj.sm.io.doneLatch
      x761_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x761_inr_Switch_obj.sm.io.doneLatch
      x761_inr_Switch_obj.sm.io.enableOut.zip(x761_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x761_inr_Switch_obj.sm.io.break := false.B
      val x761_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x761_inr_Switch""")
      x761_inr_Switch_obj.mask := true.B & true.B
      x761_inr_Switch_obj.configure("x761_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x761_inr_Switch.r := x761_inr_Switch_obj.kernel().r
      val x2929_rd_x722 = Wire(Bool()).suggestName("""x2929_rd_x722""")
      val x2929_rd_x722_banks = List[UInt]()
      val x2929_rd_x722_ofs = List[UInt]()
      val x2929_rd_x722_en = List[Bool](true.B)
      val x2929_rd_x722_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2929_rd_x722_shared_en")
      x2929_rd_x722.toSeq.zip(x722_reg.connectRPort(2929, x2929_rd_x722_banks, x2929_rd_x722_ofs, io.sigsIn.backpressure, x2929_rd_x722_en.map(_ && x2929_rd_x722_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2930_rd_x724 = Wire(Bool()).suggestName("""x2930_rd_x724""")
      val x2930_rd_x724_banks = List[UInt]()
      val x2930_rd_x724_ofs = List[UInt]()
      val x2930_rd_x724_en = List[Bool](true.B)
      val x2930_rd_x724_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2930_rd_x724_shared_en")
      x2930_rd_x724.toSeq.zip(x724_reg.connectRPort(2930, x2930_rd_x724_banks, x2930_rd_x724_ofs, io.sigsIn.backpressure, x2930_rd_x724_en.map(_ && x2930_rd_x724_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x775_inr_Switch_obj = new x775_inr_Switch_kernel(List(x2929_rd_x722,x2930_rd_x724), List(x724_reg,x638_tmp_0,x634_tmp_1,x642_tmp_4,x637_tmp_4,x633_tmp_0,x641_tmp_3,x636_tmp_3,x722_reg,x640_tmp_2,x635_tmp_2,x691_r_0,x639_tmp_1) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x775_inr_Switch_obj.sm.io.selectsIn(0) := x2929_rd_x722
      x775_inr_Switch_obj.sm.io.selectsIn(1) := x2930_rd_x724
      b627_chain.connectStageCtrl((x775_inr_Switch_obj.done).DS(1.toInt, rr, x775_inr_Switch_obj.sm.io.backpressure), x775_inr_Switch_obj.baseEn, 4)
      b628_chain.connectStageCtrl((x775_inr_Switch_obj.done).DS(1.toInt, rr, x775_inr_Switch_obj.sm.io.backpressure), x775_inr_Switch_obj.baseEn, 4)
      b630_chain.connectStageCtrl((x775_inr_Switch_obj.done).DS(1.toInt, rr, x775_inr_Switch_obj.sm.io.backpressure), x775_inr_Switch_obj.baseEn, 4)
      b631_chain.connectStageCtrl((x775_inr_Switch_obj.done).DS(1.toInt, rr, x775_inr_Switch_obj.sm.io.backpressure), x775_inr_Switch_obj.baseEn, 4)
      x775_inr_Switch_obj.backpressure := true.B | x775_inr_Switch_obj.sm.io.doneLatch
      x775_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x775_inr_Switch_obj.sm.io.doneLatch
      x775_inr_Switch_obj.sm.io.enableOut.zip(x775_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x775_inr_Switch_obj.sm.io.break := false.B
      val x775_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x775_inr_Switch""")
      x775_inr_Switch_obj.mask := true.B & true.B
      x775_inr_Switch_obj.configure("x775_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x775_inr_Switch.r := x775_inr_Switch_obj.kernel().r
      val x780 = new x780_kernel(List(b630_chain_read_5,b631_chain_read_5,b557), List(x761_inr_Switch,x775_inr_Switch), List(x719_force_0,x638_tmp_0,x634_tmp_1,x642_tmp_4,x637_tmp_4,x633_tmp_0,x641_tmp_3,x636_tmp_3,x640_tmp_2,x635_tmp_2,x720_force_0,x639_tmp_1) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x780.sm.io.ctrDone := risingEdge(x780.sm.io.ctrInc)
      b627_chain.connectStageCtrl((x780.done).DS(1.toInt, rr, x780.sm.io.backpressure), x780.baseEn, 5)
      b628_chain.connectStageCtrl((x780.done).DS(1.toInt, rr, x780.sm.io.backpressure), x780.baseEn, 5)
      b630_chain.connectStageCtrl((x780.done).DS(1.toInt, rr, x780.sm.io.backpressure), x780.baseEn, 5)
      b631_chain.connectStageCtrl((x780.done).DS(1.toInt, rr, x780.sm.io.backpressure), x780.baseEn, 5)
      x780.backpressure := true.B | x780.sm.io.doneLatch
      x780.forwardpressure := (true.B) && (true.B) | x780.sm.io.doneLatch
      x780.sm.io.enableOut.zip(x780.smEnableOuts).foreach{case (l,r) => r := l}
      x780.sm.io.break := false.B
      x780.mask := true.B & b557
      x780.configure("x780", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x780.kernel()
      val x781_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x782_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x783_ctrchain = (new CChainObject(List[CtrObject](x781_ctr), "x783_ctrchain")).cchain.io 
      x783_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x783_ctrchain_p", (x783_ctrchain.par, x783_ctrchain.widths))
      val x784_ctrchain = (new CChainObject(List[CtrObject](x782_ctr), "x784_ctrchain")).cchain.io 
      x784_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x784_ctrchain_p", (x784_ctrchain.par, x784_ctrchain.widths))
      val x813 = new x813_kernel(List(b630_chain_read_6,b631_chain_read_6,b557), List(x783_ctrchain,x784_ctrchain), List(x719_force_0,x638_tmp_0,x634_tmp_1,x642_tmp_4,x637_tmp_4,x633_tmp_0,x641_tmp_3,x636_tmp_3,x640_tmp_2,x635_tmp_2,x720_force_0,x639_tmp_1) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x813.sm.io.ctrDone := risingEdge(x813.sm.io.ctrInc)
      b627_chain.connectStageCtrl((x813.done).DS(1.toInt, rr, x813.sm.io.backpressure), x813.baseEn, 6)
      b628_chain.connectStageCtrl((x813.done).DS(1.toInt, rr, x813.sm.io.backpressure), x813.baseEn, 6)
      b630_chain.connectStageCtrl((x813.done).DS(1.toInt, rr, x813.sm.io.backpressure), x813.baseEn, 6)
      b631_chain.connectStageCtrl((x813.done).DS(1.toInt, rr, x813.sm.io.backpressure), x813.baseEn, 6)
      x813.backpressure := true.B | x813.sm.io.doneLatch
      x813.forwardpressure := (true.B) && (true.B) | x813.sm.io.doneLatch
      x813.sm.io.enableOut.zip(x813.smEnableOuts).foreach{case (l,r) => r := l}
      x813.sm.io.break := false.B
      x813.mask := true.B & b557
      x813.configure("x813", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x813.kernel()
      val x833_inr_Foreach = new x833_inr_Foreach_kernel(List(b631_chain_read_7,b557), List(b627_chain_read_7), List(x567_accum_0), List(x642_tmp_4,x637_tmp_4,x568_accum_1) ,  Some(me), List(x617_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x833_inr_Foreach.sm.io.ctrDone := (x833_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b627_chain.connectStageCtrl((x833_inr_Foreach.done).DS(1.toInt, rr, x833_inr_Foreach.sm.io.backpressure), x833_inr_Foreach.baseEn, 7)
      b628_chain.connectStageCtrl((x833_inr_Foreach.done).DS(1.toInt, rr, x833_inr_Foreach.sm.io.backpressure), x833_inr_Foreach.baseEn, 7)
      b630_chain.connectStageCtrl((x833_inr_Foreach.done).DS(1.toInt, rr, x833_inr_Foreach.sm.io.backpressure), x833_inr_Foreach.baseEn, 7)
      b631_chain.connectStageCtrl((x833_inr_Foreach.done).DS(1.toInt, rr, x833_inr_Foreach.sm.io.backpressure), x833_inr_Foreach.baseEn, 7)
      x833_inr_Foreach.backpressure := true.B | x833_inr_Foreach.sm.io.doneLatch
      x833_inr_Foreach.forwardpressure := (true.B) && (true.B) | x833_inr_Foreach.sm.io.doneLatch
      x833_inr_Foreach.sm.io.enableOut.zip(x833_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x833_inr_Foreach.sm.io.break := false.B
      x833_inr_Foreach.mask := ~x833_inr_Foreach.cchain.head.output.noop & true.B
      x833_inr_Foreach.configure("x833_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x833_inr_Foreach.kernel()
    }
    val module = Module(new x834_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x834_outr_Reduce **/
