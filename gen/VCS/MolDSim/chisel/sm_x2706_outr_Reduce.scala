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

/** Hierarchy: x2706 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2706_outr_Reduce **/
class x2706_outr_Reduce_kernel(
  list_x472_A_sram_1: List[StandardInterface],
  list_b556: List[FixedPoint],
  list_x586_accum_1: List[NBufInterface],
  list_b566: List[Bool],
  list_x626_ctrchain: List[CounterChainInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x2706_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2706_outr_Reduce_iiCtr"))
  
  abstract class x2706_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b566 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x586_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x586_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x626_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x626_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x585_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x585_accum_0_p").asInstanceOf[MemParams] ))
      val in_b556 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b566 = {io.in_b566} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x586_accum_1 = {io.in_x586_accum_1} ; io.in_x586_accum_1 := DontCare
    def x626_ctrchain = {io.in_x626_ctrchain} ; io.in_x626_ctrchain := DontCare
    def x585_accum_0 = {io.in_x585_accum_0} ; io.in_x585_accum_0 := DontCare
    def b556 = {io.in_b556} 
  }
  def connectWires0(module: x2706_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b566 <> b566
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x586_accum_1.connectLedger(module.io.in_x586_accum_1)
    module.io.in_x626_ctrchain.input <> x626_ctrchain.input; module.io.in_x626_ctrchain.output <> x626_ctrchain.output
    x585_accum_0.connectLedger(module.io.in_x585_accum_0)
    module.io.in_b556 <> b556
  }
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x585_accum_0 = list_x472_A_sram_1(2)
  val b556 = list_b556(0)
  val x586_accum_1 = list_x586_accum_1(0)
  val b566 = list_b566(0)
  val x626_ctrchain = list_x626_ctrchain(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2706_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x2706_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2706_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2706_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x2706_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x2706_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x2706_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2706_instrctr, cycles_x2706_outr_Reduce.io.count, iters_x2706_outr_Reduce.io.count, 0.U, 0.U)
      val b2499 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2499.suggestName("b2499")
      val b2499_chain = Module(new RegChainPass(8, 32, myName = "b2499_chain")); b2499_chain.io <> DontCare
      b2499_chain.chain_pass(b2499, io.sigsOut.smDoneIn.head)
      val b2499_chain_read_1 = b2499_chain.read(1).FP(true,32,0)
      val b2499_chain_read_2 = b2499_chain.read(2).FP(true,32,0)
      val b2499_chain_read_3 = b2499_chain.read(3).FP(true,32,0)
      val b2499_chain_read_4 = b2499_chain.read(4).FP(true,32,0)
      val b2499_chain_read_5 = b2499_chain.read(5).FP(true,32,0)
      val b2499_chain_read_6 = b2499_chain.read(6).FP(true,32,0)
      val b2499_chain_read_7 = b2499_chain.read(7).FP(true,32,0)
      val b2500 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b2500.suggestName("b2500")
      val b2500_chain = Module(new RegChainPass(8, 32, myName = "b2500_chain")); b2500_chain.io <> DontCare
      b2500_chain.chain_pass(b2500, io.sigsOut.smDoneIn.head)
      val b2500_chain_read_1 = b2500_chain.read(1).FP(true,32,0)
      val b2500_chain_read_2 = b2500_chain.read(2).FP(true,32,0)
      val b2500_chain_read_3 = b2500_chain.read(3).FP(true,32,0)
      val b2500_chain_read_4 = b2500_chain.read(4).FP(true,32,0)
      val b2500_chain_read_5 = b2500_chain.read(5).FP(true,32,0)
      val b2500_chain_read_6 = b2500_chain.read(6).FP(true,32,0)
      val b2500_chain_read_7 = b2500_chain.read(7).FP(true,32,0)
      val b2502 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2502.suggestName("b2502")
      val b2502_chain = Module(new RegChainPass(8, 1, myName = "b2502_chain")); b2502_chain.io <> DontCare
      b2502_chain.chain_pass(b2502, io.sigsOut.smDoneIn.head)
      val b2502_chain_read_1: Bool = b2502_chain.read(1).apply(0)
      val b2502_chain_read_2: Bool = b2502_chain.read(2).apply(0)
      val b2502_chain_read_3: Bool = b2502_chain.read(3).apply(0)
      val b2502_chain_read_4: Bool = b2502_chain.read(4).apply(0)
      val b2502_chain_read_5: Bool = b2502_chain.read(5).apply(0)
      val b2502_chain_read_6: Bool = b2502_chain.read(6).apply(0)
      val b2502_chain_read_7: Bool = b2502_chain.read(7).apply(0)
      val b2503 = ~io.sigsIn.cchainOutputs.head.oobs(1); b2503.suggestName("b2503")
      val b2503_chain = Module(new RegChainPass(8, 1, myName = "b2503_chain")); b2503_chain.io <> DontCare
      b2503_chain.chain_pass(b2503, io.sigsOut.smDoneIn.head)
      val b2503_chain_read_1: Bool = b2503_chain.read(1).apply(0)
      val b2503_chain_read_2: Bool = b2503_chain.read(2).apply(0)
      val b2503_chain_read_3: Bool = b2503_chain.read(3).apply(0)
      val b2503_chain_read_4: Bool = b2503_chain.read(4).apply(0)
      val b2503_chain_read_5: Bool = b2503_chain.read(5).apply(0)
      val b2503_chain_read_6: Bool = b2503_chain.read(6).apply(0)
      val b2503_chain_read_7: Bool = b2503_chain.read(7).apply(0)
      val x2505_tmp_0 = (new x2505_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x2506_tmp_1 = (new x2506_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x2507_tmp_2 = (new x2507_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x2508_tmp_3 = (new x2508_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x2509_tmp_4 = (new x2509_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x2510_tmp_0 = (new x2510_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x2511_tmp_1 = (new x2511_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x2512_tmp_2 = (new x2512_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x2513_tmp_3 = (new x2513_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x2514_tmp_4 = (new x2514_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x2515_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2516_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2517_ctrchain = (new CChainObject(List[CtrObject](x2515_ctr), "x2517_ctrchain")).cchain.io 
      x2517_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2517_ctrchain_p", (x2517_ctrchain.par, x2517_ctrchain.widths))
      val x2518_ctrchain = (new CChainObject(List[CtrObject](x2516_ctr), "x2518_ctrchain")).cchain.io 
      x2518_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2518_ctrchain_p", (x2518_ctrchain.par, x2518_ctrchain.widths))
      val x2561 = new x2561_kernel(List(b566,b2503,b2502), List(x2512_tmp_2,x2508_tmp_3,x2509_tmp_4,x2505_tmp_0,x2514_tmp_4,x2510_tmp_0,x2506_tmp_1,x2513_tmp_3,x2511_tmp_1,x2507_tmp_2), List(x2518_ctrchain,x2517_ctrchain), List(x472_A_sram_1,x471_A_sram_0), List(b2499,b2500,b556) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2561.sm.io.ctrDone := risingEdge(x2561.sm.io.ctrInc)
      b2499_chain.connectStageCtrl((x2561.done).DS(1.toInt, rr, x2561.sm.io.backpressure), x2561.baseEn, 0)
      b2500_chain.connectStageCtrl((x2561.done).DS(1.toInt, rr, x2561.sm.io.backpressure), x2561.baseEn, 0)
      b2502_chain.connectStageCtrl((x2561.done).DS(1.toInt, rr, x2561.sm.io.backpressure), x2561.baseEn, 0)
      b2503_chain.connectStageCtrl((x2561.done).DS(1.toInt, rr, x2561.sm.io.backpressure), x2561.baseEn, 0)
      x2561.backpressure := true.B | x2561.sm.io.doneLatch
      x2561.forwardpressure := (true.B) && (true.B) | x2561.sm.io.doneLatch
      x2561.sm.io.enableOut.zip(x2561.smEnableOuts).foreach{case (l,r) => r := l}
      x2561.sm.io.break := false.B
      x2561.mask := true.B & b566
      x2561.configure("x2561", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2561.kernel()
      val x2562_r_0 = (new x2562_r_0).m.io.asInstanceOf[NBufInterface]
      val x2563_r_0 = (new x2563_r_0).m.io.asInstanceOf[NBufInterface]
      val x2590 = new x2590_kernel(List(b566,b2503_chain_read_1,b2502_chain_read_1), List(x2512_tmp_2,x2562_r_0,x2508_tmp_3,x2509_tmp_4,x2505_tmp_0,x2514_tmp_4,x2510_tmp_0,x2506_tmp_1,x2513_tmp_3,x2511_tmp_1,x2507_tmp_2,x2563_r_0) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2590.sm.io.ctrDone := risingEdge(x2590.sm.io.ctrInc)
      b2499_chain.connectStageCtrl((x2590.done).DS(1.toInt, rr, x2590.sm.io.backpressure), x2590.baseEn, 1)
      b2500_chain.connectStageCtrl((x2590.done).DS(1.toInt, rr, x2590.sm.io.backpressure), x2590.baseEn, 1)
      b2502_chain.connectStageCtrl((x2590.done).DS(1.toInt, rr, x2590.sm.io.backpressure), x2590.baseEn, 1)
      b2503_chain.connectStageCtrl((x2590.done).DS(1.toInt, rr, x2590.sm.io.backpressure), x2590.baseEn, 1)
      x2590.backpressure := true.B | x2590.sm.io.doneLatch
      x2590.forwardpressure := (true.B) && (true.B) | x2590.sm.io.doneLatch
      x2590.sm.io.enableOut.zip(x2590.smEnableOuts).foreach{case (l,r) => r := l}
      x2590.sm.io.break := false.B
      x2590.mask := true.B & b566
      x2590.configure("x2590", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2590.kernel()
      val x2591_force_0 = (new x2591_force_0).m.io.asInstanceOf[NBufInterface]
      val x2592_force_0 = (new x2592_force_0).m.io.asInstanceOf[NBufInterface]
      val x2593_reg = (new x2593_reg).m.io.asInstanceOf[NBufInterface]
      val x2594_reg = (new x2594_reg).m.io.asInstanceOf[NBufInterface]
      val x2595_reg = (new x2595_reg).m.io.asInstanceOf[NBufInterface]
      val x2596_reg = (new x2596_reg).m.io.asInstanceOf[NBufInterface]
      val x2615 = new x2615_kernel(List(b566,b2503_chain_read_2,b2502_chain_read_2), List(x2595_reg,x2512_tmp_2,x2562_r_0,x2508_tmp_3,x2596_reg,x2509_tmp_4,x2505_tmp_0,x2514_tmp_4,x2510_tmp_0,x2593_reg,x2506_tmp_1,x2513_tmp_3,x2511_tmp_1,x2594_reg,x2507_tmp_2,x2563_r_0) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2615.sm.io.ctrDone := risingEdge(x2615.sm.io.ctrInc)
      b2499_chain.connectStageCtrl((x2615.done).DS(1.toInt, rr, x2615.sm.io.backpressure), x2615.baseEn, 2)
      b2500_chain.connectStageCtrl((x2615.done).DS(1.toInt, rr, x2615.sm.io.backpressure), x2615.baseEn, 2)
      b2502_chain.connectStageCtrl((x2615.done).DS(1.toInt, rr, x2615.sm.io.backpressure), x2615.baseEn, 2)
      b2503_chain.connectStageCtrl((x2615.done).DS(1.toInt, rr, x2615.sm.io.backpressure), x2615.baseEn, 2)
      x2615.backpressure := true.B | x2615.sm.io.doneLatch
      x2615.forwardpressure := (true.B) && (true.B) | x2615.sm.io.doneLatch
      x2615.sm.io.enableOut.zip(x2615.smEnableOuts).foreach{case (l,r) => r := l}
      x2615.sm.io.break := false.B
      x2615.mask := true.B & b566
      x2615.configure("x2615", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2615.kernel()
      val x2963_rd_x2593 = Wire(Bool()).suggestName("""x2963_rd_x2593""")
      val x2963_rd_x2593_banks = List[UInt]()
      val x2963_rd_x2593_ofs = List[UInt]()
      val x2963_rd_x2593_en = List[Bool](true.B)
      val x2963_rd_x2593_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2963_rd_x2593_shared_en")
      x2963_rd_x2593.toSeq.zip(x2593_reg.connectRPort(2963, x2963_rd_x2593_banks, x2963_rd_x2593_ofs, io.sigsIn.backpressure, x2963_rd_x2593_en.map(_ && x2963_rd_x2593_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2964_rd_x2595 = Wire(Bool()).suggestName("""x2964_rd_x2595""")
      val x2964_rd_x2595_banks = List[UInt]()
      val x2964_rd_x2595_ofs = List[UInt]()
      val x2964_rd_x2595_en = List[Bool](true.B)
      val x2964_rd_x2595_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2964_rd_x2595_shared_en")
      x2964_rd_x2595.toSeq.zip(x2595_reg.connectRPort(2964, x2964_rd_x2595_banks, x2964_rd_x2595_ofs, io.sigsIn.backpressure, x2964_rd_x2595_en.map(_ && x2964_rd_x2595_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2633_inr_Switch_obj = new x2633_inr_Switch_kernel(List(x2964_rd_x2595,x2963_rd_x2593), List(x2595_reg,x2512_tmp_2,x2562_r_0,x2508_tmp_3,x2596_reg,x2509_tmp_4,x2505_tmp_0,x2514_tmp_4,x2510_tmp_0,x2593_reg,x2506_tmp_1,x2513_tmp_3,x2511_tmp_1,x2594_reg,x2507_tmp_2,x2563_r_0) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2633_inr_Switch_obj.sm.io.selectsIn(0) := x2963_rd_x2593
      x2633_inr_Switch_obj.sm.io.selectsIn(1) := x2964_rd_x2595
      b2499_chain.connectStageCtrl((x2633_inr_Switch_obj.done).DS(1.toInt, rr, x2633_inr_Switch_obj.sm.io.backpressure), x2633_inr_Switch_obj.baseEn, 3)
      b2500_chain.connectStageCtrl((x2633_inr_Switch_obj.done).DS(1.toInt, rr, x2633_inr_Switch_obj.sm.io.backpressure), x2633_inr_Switch_obj.baseEn, 3)
      b2502_chain.connectStageCtrl((x2633_inr_Switch_obj.done).DS(1.toInt, rr, x2633_inr_Switch_obj.sm.io.backpressure), x2633_inr_Switch_obj.baseEn, 3)
      b2503_chain.connectStageCtrl((x2633_inr_Switch_obj.done).DS(1.toInt, rr, x2633_inr_Switch_obj.sm.io.backpressure), x2633_inr_Switch_obj.baseEn, 3)
      x2633_inr_Switch_obj.backpressure := true.B | x2633_inr_Switch_obj.sm.io.doneLatch
      x2633_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x2633_inr_Switch_obj.sm.io.doneLatch
      x2633_inr_Switch_obj.sm.io.enableOut.zip(x2633_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2633_inr_Switch_obj.sm.io.break := false.B
      val x2633_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2633_inr_Switch""")
      x2633_inr_Switch_obj.mask := true.B & true.B
      x2633_inr_Switch_obj.configure("x2633_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2633_inr_Switch.r := x2633_inr_Switch_obj.kernel().r
      val x2965_rd_x2594 = Wire(Bool()).suggestName("""x2965_rd_x2594""")
      val x2965_rd_x2594_banks = List[UInt]()
      val x2965_rd_x2594_ofs = List[UInt]()
      val x2965_rd_x2594_en = List[Bool](true.B)
      val x2965_rd_x2594_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2965_rd_x2594_shared_en")
      x2965_rd_x2594.toSeq.zip(x2594_reg.connectRPort(2965, x2965_rd_x2594_banks, x2965_rd_x2594_ofs, io.sigsIn.backpressure, x2965_rd_x2594_en.map(_ && x2965_rd_x2594_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2966_rd_x2596 = Wire(Bool()).suggestName("""x2966_rd_x2596""")
      val x2966_rd_x2596_banks = List[UInt]()
      val x2966_rd_x2596_ofs = List[UInt]()
      val x2966_rd_x2596_en = List[Bool](true.B)
      val x2966_rd_x2596_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2966_rd_x2596_shared_en")
      x2966_rd_x2596.toSeq.zip(x2596_reg.connectRPort(2966, x2966_rd_x2596_banks, x2966_rd_x2596_ofs, io.sigsIn.backpressure, x2966_rd_x2596_en.map(_ && x2966_rd_x2596_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2647_inr_Switch_obj = new x2647_inr_Switch_kernel(List(x2965_rd_x2594,x2966_rd_x2596), List(x2512_tmp_2,x2508_tmp_3,x2596_reg,x2509_tmp_4,x2505_tmp_0,x2514_tmp_4,x2510_tmp_0,x2506_tmp_1,x2513_tmp_3,x2511_tmp_1,x2594_reg,x2507_tmp_2,x2563_r_0) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2647_inr_Switch_obj.sm.io.selectsIn(0) := x2965_rd_x2594
      x2647_inr_Switch_obj.sm.io.selectsIn(1) := x2966_rd_x2596
      b2499_chain.connectStageCtrl((x2647_inr_Switch_obj.done).DS(1.toInt, rr, x2647_inr_Switch_obj.sm.io.backpressure), x2647_inr_Switch_obj.baseEn, 4)
      b2500_chain.connectStageCtrl((x2647_inr_Switch_obj.done).DS(1.toInt, rr, x2647_inr_Switch_obj.sm.io.backpressure), x2647_inr_Switch_obj.baseEn, 4)
      b2502_chain.connectStageCtrl((x2647_inr_Switch_obj.done).DS(1.toInt, rr, x2647_inr_Switch_obj.sm.io.backpressure), x2647_inr_Switch_obj.baseEn, 4)
      b2503_chain.connectStageCtrl((x2647_inr_Switch_obj.done).DS(1.toInt, rr, x2647_inr_Switch_obj.sm.io.backpressure), x2647_inr_Switch_obj.baseEn, 4)
      x2647_inr_Switch_obj.backpressure := true.B | x2647_inr_Switch_obj.sm.io.doneLatch
      x2647_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x2647_inr_Switch_obj.sm.io.doneLatch
      x2647_inr_Switch_obj.sm.io.enableOut.zip(x2647_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2647_inr_Switch_obj.sm.io.break := false.B
      val x2647_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2647_inr_Switch""")
      x2647_inr_Switch_obj.mask := true.B & true.B
      x2647_inr_Switch_obj.configure("x2647_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2647_inr_Switch.r := x2647_inr_Switch_obj.kernel().r
      val x2652 = new x2652_kernel(List(b566,b2503_chain_read_5,b2502_chain_read_5), List(x2647_inr_Switch,x2633_inr_Switch), List(x2512_tmp_2,x2508_tmp_3,x2509_tmp_4,x2505_tmp_0,x2514_tmp_4,x2510_tmp_0,x2592_force_0,x2506_tmp_1,x2513_tmp_3,x2511_tmp_1,x2591_force_0,x2507_tmp_2) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2652.sm.io.ctrDone := risingEdge(x2652.sm.io.ctrInc)
      b2499_chain.connectStageCtrl((x2652.done).DS(1.toInt, rr, x2652.sm.io.backpressure), x2652.baseEn, 5)
      b2500_chain.connectStageCtrl((x2652.done).DS(1.toInt, rr, x2652.sm.io.backpressure), x2652.baseEn, 5)
      b2502_chain.connectStageCtrl((x2652.done).DS(1.toInt, rr, x2652.sm.io.backpressure), x2652.baseEn, 5)
      b2503_chain.connectStageCtrl((x2652.done).DS(1.toInt, rr, x2652.sm.io.backpressure), x2652.baseEn, 5)
      x2652.backpressure := true.B | x2652.sm.io.doneLatch
      x2652.forwardpressure := (true.B) && (true.B) | x2652.sm.io.doneLatch
      x2652.sm.io.enableOut.zip(x2652.smEnableOuts).foreach{case (l,r) => r := l}
      x2652.sm.io.break := false.B
      x2652.mask := true.B & b566
      x2652.configure("x2652", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2652.kernel()
      val x2653_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2654_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2655_ctrchain = (new CChainObject(List[CtrObject](x2653_ctr), "x2655_ctrchain")).cchain.io 
      x2655_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2655_ctrchain_p", (x2655_ctrchain.par, x2655_ctrchain.widths))
      val x2656_ctrchain = (new CChainObject(List[CtrObject](x2654_ctr), "x2656_ctrchain")).cchain.io 
      x2656_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2656_ctrchain_p", (x2656_ctrchain.par, x2656_ctrchain.widths))
      val x2685 = new x2685_kernel(List(b566,b2503_chain_read_6,b2502_chain_read_6), List(x2656_ctrchain,x2655_ctrchain), List(x2512_tmp_2,x2508_tmp_3,x2509_tmp_4,x2505_tmp_0,x2514_tmp_4,x2510_tmp_0,x2592_force_0,x2506_tmp_1,x2513_tmp_3,x2511_tmp_1,x2591_force_0,x2507_tmp_2) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2685.sm.io.ctrDone := risingEdge(x2685.sm.io.ctrInc)
      b2499_chain.connectStageCtrl((x2685.done).DS(1.toInt, rr, x2685.sm.io.backpressure), x2685.baseEn, 6)
      b2500_chain.connectStageCtrl((x2685.done).DS(1.toInt, rr, x2685.sm.io.backpressure), x2685.baseEn, 6)
      b2502_chain.connectStageCtrl((x2685.done).DS(1.toInt, rr, x2685.sm.io.backpressure), x2685.baseEn, 6)
      b2503_chain.connectStageCtrl((x2685.done).DS(1.toInt, rr, x2685.sm.io.backpressure), x2685.baseEn, 6)
      x2685.backpressure := true.B | x2685.sm.io.doneLatch
      x2685.forwardpressure := (true.B) && (true.B) | x2685.sm.io.doneLatch
      x2685.sm.io.enableOut.zip(x2685.smEnableOuts).foreach{case (l,r) => r := l}
      x2685.sm.io.break := false.B
      x2685.mask := true.B & b566
      x2685.configure("x2685", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2685.kernel()
      val x2705_inr_Foreach = new x2705_inr_Foreach_kernel(List(b566,b2503_chain_read_7), List(b2499_chain_read_7), List(x585_accum_0), List(x2509_tmp_4,x586_accum_1,x2514_tmp_4) ,  Some(me), List(x626_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2705_inr_Foreach.sm.io.ctrDone := (x2705_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b2499_chain.connectStageCtrl((x2705_inr_Foreach.done).DS(1.toInt, rr, x2705_inr_Foreach.sm.io.backpressure), x2705_inr_Foreach.baseEn, 7)
      b2500_chain.connectStageCtrl((x2705_inr_Foreach.done).DS(1.toInt, rr, x2705_inr_Foreach.sm.io.backpressure), x2705_inr_Foreach.baseEn, 7)
      b2502_chain.connectStageCtrl((x2705_inr_Foreach.done).DS(1.toInt, rr, x2705_inr_Foreach.sm.io.backpressure), x2705_inr_Foreach.baseEn, 7)
      b2503_chain.connectStageCtrl((x2705_inr_Foreach.done).DS(1.toInt, rr, x2705_inr_Foreach.sm.io.backpressure), x2705_inr_Foreach.baseEn, 7)
      x2705_inr_Foreach.backpressure := true.B | x2705_inr_Foreach.sm.io.doneLatch
      x2705_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2705_inr_Foreach.sm.io.doneLatch
      x2705_inr_Foreach.sm.io.enableOut.zip(x2705_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2705_inr_Foreach.sm.io.break := false.B
      x2705_inr_Foreach.mask := ~x2705_inr_Foreach.cchain.head.output.noop & true.B
      x2705_inr_Foreach.configure("x2705_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2705_inr_Foreach.kernel()
    }
    val module = Module(new x2706_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x2706_outr_Reduce **/
