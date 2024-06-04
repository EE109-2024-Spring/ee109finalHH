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

/** Hierarchy: x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2498_outr_Reduce **/
class x2498_outr_Reduce_kernel(
  list_x584_accum_1: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
  list_b565: List[Bool],
  list_b555: List[FixedPoint],
  list_x625_ctrchain: List[CounterChainInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x2498_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2498_outr_Reduce_iiCtr"))
  
  abstract class x2498_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b555 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b565 = Input(Bool())
      val in_x625_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x625_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x583_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x583_accum_0_p").asInstanceOf[MemParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x584_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x584_accum_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def b555 = {io.in_b555} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b565 = {io.in_b565} 
    def x625_ctrchain = {io.in_x625_ctrchain} ; io.in_x625_ctrchain := DontCare
    def x583_accum_0 = {io.in_x583_accum_0} ; io.in_x583_accum_0 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x584_accum_1 = {io.in_x584_accum_1} ; io.in_x584_accum_1 := DontCare
  }
  def connectWires0(module: x2498_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b555 <> b555
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b565 <> b565
    module.io.in_x625_ctrchain.input <> x625_ctrchain.input; module.io.in_x625_ctrchain.output <> x625_ctrchain.output
    x583_accum_0.connectLedger(module.io.in_x583_accum_0)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x584_accum_1.connectLedger(module.io.in_x584_accum_1)
  }
  val x584_accum_1 = list_x584_accum_1(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x583_accum_0 = list_x472_A_sram_1(1)
  val x471_A_sram_0 = list_x472_A_sram_1(2)
  val b565 = list_b565(0)
  val b555 = list_b555(0)
  val x625_ctrchain = list_x625_ctrchain(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2498_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x2498_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2498_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2498_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x2498_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x2498_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x2498_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2498_instrctr, cycles_x2498_outr_Reduce.io.count, iters_x2498_outr_Reduce.io.count, 0.U, 0.U)
      val b2291 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2291.suggestName("b2291")
      val b2291_chain = Module(new RegChainPass(8, 32, myName = "b2291_chain")); b2291_chain.io <> DontCare
      b2291_chain.chain_pass(b2291, io.sigsOut.smDoneIn.head)
      val b2291_chain_read_1 = b2291_chain.read(1).FP(true,32,0)
      val b2291_chain_read_2 = b2291_chain.read(2).FP(true,32,0)
      val b2291_chain_read_3 = b2291_chain.read(3).FP(true,32,0)
      val b2291_chain_read_4 = b2291_chain.read(4).FP(true,32,0)
      val b2291_chain_read_5 = b2291_chain.read(5).FP(true,32,0)
      val b2291_chain_read_6 = b2291_chain.read(6).FP(true,32,0)
      val b2291_chain_read_7 = b2291_chain.read(7).FP(true,32,0)
      val b2292 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b2292.suggestName("b2292")
      val b2292_chain = Module(new RegChainPass(8, 32, myName = "b2292_chain")); b2292_chain.io <> DontCare
      b2292_chain.chain_pass(b2292, io.sigsOut.smDoneIn.head)
      val b2292_chain_read_1 = b2292_chain.read(1).FP(true,32,0)
      val b2292_chain_read_2 = b2292_chain.read(2).FP(true,32,0)
      val b2292_chain_read_3 = b2292_chain.read(3).FP(true,32,0)
      val b2292_chain_read_4 = b2292_chain.read(4).FP(true,32,0)
      val b2292_chain_read_5 = b2292_chain.read(5).FP(true,32,0)
      val b2292_chain_read_6 = b2292_chain.read(6).FP(true,32,0)
      val b2292_chain_read_7 = b2292_chain.read(7).FP(true,32,0)
      val b2294 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2294.suggestName("b2294")
      val b2294_chain = Module(new RegChainPass(8, 1, myName = "b2294_chain")); b2294_chain.io <> DontCare
      b2294_chain.chain_pass(b2294, io.sigsOut.smDoneIn.head)
      val b2294_chain_read_1: Bool = b2294_chain.read(1).apply(0)
      val b2294_chain_read_2: Bool = b2294_chain.read(2).apply(0)
      val b2294_chain_read_3: Bool = b2294_chain.read(3).apply(0)
      val b2294_chain_read_4: Bool = b2294_chain.read(4).apply(0)
      val b2294_chain_read_5: Bool = b2294_chain.read(5).apply(0)
      val b2294_chain_read_6: Bool = b2294_chain.read(6).apply(0)
      val b2294_chain_read_7: Bool = b2294_chain.read(7).apply(0)
      val b2295 = ~io.sigsIn.cchainOutputs.head.oobs(1); b2295.suggestName("b2295")
      val b2295_chain = Module(new RegChainPass(8, 1, myName = "b2295_chain")); b2295_chain.io <> DontCare
      b2295_chain.chain_pass(b2295, io.sigsOut.smDoneIn.head)
      val b2295_chain_read_1: Bool = b2295_chain.read(1).apply(0)
      val b2295_chain_read_2: Bool = b2295_chain.read(2).apply(0)
      val b2295_chain_read_3: Bool = b2295_chain.read(3).apply(0)
      val b2295_chain_read_4: Bool = b2295_chain.read(4).apply(0)
      val b2295_chain_read_5: Bool = b2295_chain.read(5).apply(0)
      val b2295_chain_read_6: Bool = b2295_chain.read(6).apply(0)
      val b2295_chain_read_7: Bool = b2295_chain.read(7).apply(0)
      val x2297_tmp_0 = (new x2297_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x2298_tmp_1 = (new x2298_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x2299_tmp_2 = (new x2299_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x2300_tmp_3 = (new x2300_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x2301_tmp_4 = (new x2301_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x2302_tmp_0 = (new x2302_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x2303_tmp_1 = (new x2303_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x2304_tmp_2 = (new x2304_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x2305_tmp_3 = (new x2305_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x2306_tmp_4 = (new x2306_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x2307_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2308_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2309_ctrchain = (new CChainObject(List[CtrObject](x2307_ctr), "x2309_ctrchain")).cchain.io 
      x2309_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2309_ctrchain_p", (x2309_ctrchain.par, x2309_ctrchain.widths))
      val x2310_ctrchain = (new CChainObject(List[CtrObject](x2308_ctr), "x2310_ctrchain")).cchain.io 
      x2310_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2310_ctrchain_p", (x2310_ctrchain.par, x2310_ctrchain.widths))
      val x2353 = new x2353_kernel(List(b2295,b565,b2294), List(b555,b2291,b2292), List(x472_A_sram_1,x471_A_sram_0), List(x2309_ctrchain,x2310_ctrchain), List(x2306_tmp_4,x2301_tmp_4,x2300_tmp_3,x2304_tmp_2,x2299_tmp_2,x2303_tmp_1,x2298_tmp_1,x2305_tmp_3,x2302_tmp_0,x2297_tmp_0) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2353.sm.io.ctrDone := risingEdge(x2353.sm.io.ctrInc)
      b2291_chain.connectStageCtrl((x2353.done).DS(1.toInt, rr, x2353.sm.io.backpressure), x2353.baseEn, 0)
      b2292_chain.connectStageCtrl((x2353.done).DS(1.toInt, rr, x2353.sm.io.backpressure), x2353.baseEn, 0)
      b2294_chain.connectStageCtrl((x2353.done).DS(1.toInt, rr, x2353.sm.io.backpressure), x2353.baseEn, 0)
      b2295_chain.connectStageCtrl((x2353.done).DS(1.toInt, rr, x2353.sm.io.backpressure), x2353.baseEn, 0)
      x2353.backpressure := true.B | x2353.sm.io.doneLatch
      x2353.forwardpressure := (true.B) && (true.B) | x2353.sm.io.doneLatch
      x2353.sm.io.enableOut.zip(x2353.smEnableOuts).foreach{case (l,r) => r := l}
      x2353.sm.io.break := false.B
      x2353.mask := true.B & b565
      x2353.configure("x2353", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2353.kernel()
      val x2354_r_0 = (new x2354_r_0).m.io.asInstanceOf[NBufInterface]
      val x2355_r_0 = (new x2355_r_0).m.io.asInstanceOf[NBufInterface]
      val x2382 = new x2382_kernel(List(b2295_chain_read_1,b565,b2294_chain_read_1), List(x2306_tmp_4,x2301_tmp_4,x2300_tmp_3,x2304_tmp_2,x2355_r_0,x2299_tmp_2,x2303_tmp_1,x2298_tmp_1,x2354_r_0,x2305_tmp_3,x2302_tmp_0,x2297_tmp_0) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2382.sm.io.ctrDone := risingEdge(x2382.sm.io.ctrInc)
      b2291_chain.connectStageCtrl((x2382.done).DS(1.toInt, rr, x2382.sm.io.backpressure), x2382.baseEn, 1)
      b2292_chain.connectStageCtrl((x2382.done).DS(1.toInt, rr, x2382.sm.io.backpressure), x2382.baseEn, 1)
      b2294_chain.connectStageCtrl((x2382.done).DS(1.toInt, rr, x2382.sm.io.backpressure), x2382.baseEn, 1)
      b2295_chain.connectStageCtrl((x2382.done).DS(1.toInt, rr, x2382.sm.io.backpressure), x2382.baseEn, 1)
      x2382.backpressure := true.B | x2382.sm.io.doneLatch
      x2382.forwardpressure := (true.B) && (true.B) | x2382.sm.io.doneLatch
      x2382.sm.io.enableOut.zip(x2382.smEnableOuts).foreach{case (l,r) => r := l}
      x2382.sm.io.break := false.B
      x2382.mask := true.B & b565
      x2382.configure("x2382", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2382.kernel()
      val x2383_force_0 = (new x2383_force_0).m.io.asInstanceOf[NBufInterface]
      val x2384_force_0 = (new x2384_force_0).m.io.asInstanceOf[NBufInterface]
      val x2385_reg = (new x2385_reg).m.io.asInstanceOf[NBufInterface]
      val x2386_reg = (new x2386_reg).m.io.asInstanceOf[NBufInterface]
      val x2387_reg = (new x2387_reg).m.io.asInstanceOf[NBufInterface]
      val x2388_reg = (new x2388_reg).m.io.asInstanceOf[NBufInterface]
      val x2407 = new x2407_kernel(List(b2295_chain_read_2,b565,b2294_chain_read_2), List(x2306_tmp_4,x2301_tmp_4,x2388_reg,x2300_tmp_3,x2304_tmp_2,x2387_reg,x2355_r_0,x2299_tmp_2,x2303_tmp_1,x2298_tmp_1,x2386_reg,x2354_r_0,x2305_tmp_3,x2302_tmp_0,x2385_reg,x2297_tmp_0) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2407.sm.io.ctrDone := risingEdge(x2407.sm.io.ctrInc)
      b2291_chain.connectStageCtrl((x2407.done).DS(1.toInt, rr, x2407.sm.io.backpressure), x2407.baseEn, 2)
      b2292_chain.connectStageCtrl((x2407.done).DS(1.toInt, rr, x2407.sm.io.backpressure), x2407.baseEn, 2)
      b2294_chain.connectStageCtrl((x2407.done).DS(1.toInt, rr, x2407.sm.io.backpressure), x2407.baseEn, 2)
      b2295_chain.connectStageCtrl((x2407.done).DS(1.toInt, rr, x2407.sm.io.backpressure), x2407.baseEn, 2)
      x2407.backpressure := true.B | x2407.sm.io.doneLatch
      x2407.forwardpressure := (true.B) && (true.B) | x2407.sm.io.doneLatch
      x2407.sm.io.enableOut.zip(x2407.smEnableOuts).foreach{case (l,r) => r := l}
      x2407.sm.io.break := false.B
      x2407.mask := true.B & b565
      x2407.configure("x2407", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2407.kernel()
      val x2959_rd_x2385 = Wire(Bool()).suggestName("""x2959_rd_x2385""")
      val x2959_rd_x2385_banks = List[UInt]()
      val x2959_rd_x2385_ofs = List[UInt]()
      val x2959_rd_x2385_en = List[Bool](true.B)
      val x2959_rd_x2385_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2959_rd_x2385_shared_en")
      x2959_rd_x2385.toSeq.zip(x2385_reg.connectRPort(2959, x2959_rd_x2385_banks, x2959_rd_x2385_ofs, io.sigsIn.backpressure, x2959_rd_x2385_en.map(_ && x2959_rd_x2385_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2960_rd_x2387 = Wire(Bool()).suggestName("""x2960_rd_x2387""")
      val x2960_rd_x2387_banks = List[UInt]()
      val x2960_rd_x2387_ofs = List[UInt]()
      val x2960_rd_x2387_en = List[Bool](true.B)
      val x2960_rd_x2387_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2960_rd_x2387_shared_en")
      x2960_rd_x2387.toSeq.zip(x2387_reg.connectRPort(2960, x2960_rd_x2387_banks, x2960_rd_x2387_ofs, io.sigsIn.backpressure, x2960_rd_x2387_en.map(_ && x2960_rd_x2387_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2425_inr_Switch_obj = new x2425_inr_Switch_kernel(List(x2959_rd_x2385,x2960_rd_x2387), List(x2306_tmp_4,x2301_tmp_4,x2388_reg,x2300_tmp_3,x2304_tmp_2,x2387_reg,x2355_r_0,x2299_tmp_2,x2303_tmp_1,x2298_tmp_1,x2386_reg,x2354_r_0,x2305_tmp_3,x2302_tmp_0,x2385_reg,x2297_tmp_0) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2425_inr_Switch_obj.sm.io.selectsIn(0) := x2959_rd_x2385
      x2425_inr_Switch_obj.sm.io.selectsIn(1) := x2960_rd_x2387
      b2291_chain.connectStageCtrl((x2425_inr_Switch_obj.done).DS(1.toInt, rr, x2425_inr_Switch_obj.sm.io.backpressure), x2425_inr_Switch_obj.baseEn, 3)
      b2292_chain.connectStageCtrl((x2425_inr_Switch_obj.done).DS(1.toInt, rr, x2425_inr_Switch_obj.sm.io.backpressure), x2425_inr_Switch_obj.baseEn, 3)
      b2294_chain.connectStageCtrl((x2425_inr_Switch_obj.done).DS(1.toInt, rr, x2425_inr_Switch_obj.sm.io.backpressure), x2425_inr_Switch_obj.baseEn, 3)
      b2295_chain.connectStageCtrl((x2425_inr_Switch_obj.done).DS(1.toInt, rr, x2425_inr_Switch_obj.sm.io.backpressure), x2425_inr_Switch_obj.baseEn, 3)
      x2425_inr_Switch_obj.backpressure := true.B | x2425_inr_Switch_obj.sm.io.doneLatch
      x2425_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x2425_inr_Switch_obj.sm.io.doneLatch
      x2425_inr_Switch_obj.sm.io.enableOut.zip(x2425_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2425_inr_Switch_obj.sm.io.break := false.B
      val x2425_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2425_inr_Switch""")
      x2425_inr_Switch_obj.mask := true.B & true.B
      x2425_inr_Switch_obj.configure("x2425_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2425_inr_Switch.r := x2425_inr_Switch_obj.kernel().r
      val x2961_rd_x2386 = Wire(Bool()).suggestName("""x2961_rd_x2386""")
      val x2961_rd_x2386_banks = List[UInt]()
      val x2961_rd_x2386_ofs = List[UInt]()
      val x2961_rd_x2386_en = List[Bool](true.B)
      val x2961_rd_x2386_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2961_rd_x2386_shared_en")
      x2961_rd_x2386.toSeq.zip(x2386_reg.connectRPort(2961, x2961_rd_x2386_banks, x2961_rd_x2386_ofs, io.sigsIn.backpressure, x2961_rd_x2386_en.map(_ && x2961_rd_x2386_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2962_rd_x2388 = Wire(Bool()).suggestName("""x2962_rd_x2388""")
      val x2962_rd_x2388_banks = List[UInt]()
      val x2962_rd_x2388_ofs = List[UInt]()
      val x2962_rd_x2388_en = List[Bool](true.B)
      val x2962_rd_x2388_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2962_rd_x2388_shared_en")
      x2962_rd_x2388.toSeq.zip(x2388_reg.connectRPort(2962, x2962_rd_x2388_banks, x2962_rd_x2388_ofs, io.sigsIn.backpressure, x2962_rd_x2388_en.map(_ && x2962_rd_x2388_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2439_inr_Switch_obj = new x2439_inr_Switch_kernel(List(x2962_rd_x2388,x2961_rd_x2386), List(x2306_tmp_4,x2301_tmp_4,x2388_reg,x2300_tmp_3,x2304_tmp_2,x2355_r_0,x2299_tmp_2,x2303_tmp_1,x2298_tmp_1,x2386_reg,x2305_tmp_3,x2302_tmp_0,x2297_tmp_0) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2439_inr_Switch_obj.sm.io.selectsIn(0) := x2961_rd_x2386
      x2439_inr_Switch_obj.sm.io.selectsIn(1) := x2962_rd_x2388
      b2291_chain.connectStageCtrl((x2439_inr_Switch_obj.done).DS(1.toInt, rr, x2439_inr_Switch_obj.sm.io.backpressure), x2439_inr_Switch_obj.baseEn, 4)
      b2292_chain.connectStageCtrl((x2439_inr_Switch_obj.done).DS(1.toInt, rr, x2439_inr_Switch_obj.sm.io.backpressure), x2439_inr_Switch_obj.baseEn, 4)
      b2294_chain.connectStageCtrl((x2439_inr_Switch_obj.done).DS(1.toInt, rr, x2439_inr_Switch_obj.sm.io.backpressure), x2439_inr_Switch_obj.baseEn, 4)
      b2295_chain.connectStageCtrl((x2439_inr_Switch_obj.done).DS(1.toInt, rr, x2439_inr_Switch_obj.sm.io.backpressure), x2439_inr_Switch_obj.baseEn, 4)
      x2439_inr_Switch_obj.backpressure := true.B | x2439_inr_Switch_obj.sm.io.doneLatch
      x2439_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x2439_inr_Switch_obj.sm.io.doneLatch
      x2439_inr_Switch_obj.sm.io.enableOut.zip(x2439_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2439_inr_Switch_obj.sm.io.break := false.B
      val x2439_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2439_inr_Switch""")
      x2439_inr_Switch_obj.mask := true.B & true.B
      x2439_inr_Switch_obj.configure("x2439_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2439_inr_Switch.r := x2439_inr_Switch_obj.kernel().r
      val x2444 = new x2444_kernel(List(b2295_chain_read_5,b565,b2294_chain_read_5), List(x2425_inr_Switch,x2439_inr_Switch), List(x2306_tmp_4,x2301_tmp_4,x2300_tmp_3,x2304_tmp_2,x2383_force_0,x2299_tmp_2,x2303_tmp_1,x2298_tmp_1,x2305_tmp_3,x2384_force_0,x2302_tmp_0,x2297_tmp_0) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2444.sm.io.ctrDone := risingEdge(x2444.sm.io.ctrInc)
      b2291_chain.connectStageCtrl((x2444.done).DS(1.toInt, rr, x2444.sm.io.backpressure), x2444.baseEn, 5)
      b2292_chain.connectStageCtrl((x2444.done).DS(1.toInt, rr, x2444.sm.io.backpressure), x2444.baseEn, 5)
      b2294_chain.connectStageCtrl((x2444.done).DS(1.toInt, rr, x2444.sm.io.backpressure), x2444.baseEn, 5)
      b2295_chain.connectStageCtrl((x2444.done).DS(1.toInt, rr, x2444.sm.io.backpressure), x2444.baseEn, 5)
      x2444.backpressure := true.B | x2444.sm.io.doneLatch
      x2444.forwardpressure := (true.B) && (true.B) | x2444.sm.io.doneLatch
      x2444.sm.io.enableOut.zip(x2444.smEnableOuts).foreach{case (l,r) => r := l}
      x2444.sm.io.break := false.B
      x2444.mask := true.B & b565
      x2444.configure("x2444", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2444.kernel()
      val x2445_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2446_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2447_ctrchain = (new CChainObject(List[CtrObject](x2445_ctr), "x2447_ctrchain")).cchain.io 
      x2447_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2447_ctrchain_p", (x2447_ctrchain.par, x2447_ctrchain.widths))
      val x2448_ctrchain = (new CChainObject(List[CtrObject](x2446_ctr), "x2448_ctrchain")).cchain.io 
      x2448_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2448_ctrchain_p", (x2448_ctrchain.par, x2448_ctrchain.widths))
      val x2477 = new x2477_kernel(List(b2295_chain_read_6,b565,b2294_chain_read_6), List(x2448_ctrchain,x2447_ctrchain), List(x2306_tmp_4,x2301_tmp_4,x2300_tmp_3,x2304_tmp_2,x2383_force_0,x2299_tmp_2,x2303_tmp_1,x2298_tmp_1,x2305_tmp_3,x2384_force_0,x2302_tmp_0,x2297_tmp_0) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2477.sm.io.ctrDone := risingEdge(x2477.sm.io.ctrInc)
      b2291_chain.connectStageCtrl((x2477.done).DS(1.toInt, rr, x2477.sm.io.backpressure), x2477.baseEn, 6)
      b2292_chain.connectStageCtrl((x2477.done).DS(1.toInt, rr, x2477.sm.io.backpressure), x2477.baseEn, 6)
      b2294_chain.connectStageCtrl((x2477.done).DS(1.toInt, rr, x2477.sm.io.backpressure), x2477.baseEn, 6)
      b2295_chain.connectStageCtrl((x2477.done).DS(1.toInt, rr, x2477.sm.io.backpressure), x2477.baseEn, 6)
      x2477.backpressure := true.B | x2477.sm.io.doneLatch
      x2477.forwardpressure := (true.B) && (true.B) | x2477.sm.io.doneLatch
      x2477.sm.io.enableOut.zip(x2477.smEnableOuts).foreach{case (l,r) => r := l}
      x2477.sm.io.break := false.B
      x2477.mask := true.B & b565
      x2477.configure("x2477", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2477.kernel()
      val x2497_inr_Foreach = new x2497_inr_Foreach_kernel(List(b2295_chain_read_7,b565), List(b2291_chain_read_7), List(x583_accum_0), List(x2306_tmp_4,x2301_tmp_4,x584_accum_1) ,  Some(me), List(x625_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2497_inr_Foreach.sm.io.ctrDone := (x2497_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b2291_chain.connectStageCtrl((x2497_inr_Foreach.done).DS(1.toInt, rr, x2497_inr_Foreach.sm.io.backpressure), x2497_inr_Foreach.baseEn, 7)
      b2292_chain.connectStageCtrl((x2497_inr_Foreach.done).DS(1.toInt, rr, x2497_inr_Foreach.sm.io.backpressure), x2497_inr_Foreach.baseEn, 7)
      b2294_chain.connectStageCtrl((x2497_inr_Foreach.done).DS(1.toInt, rr, x2497_inr_Foreach.sm.io.backpressure), x2497_inr_Foreach.baseEn, 7)
      b2295_chain.connectStageCtrl((x2497_inr_Foreach.done).DS(1.toInt, rr, x2497_inr_Foreach.sm.io.backpressure), x2497_inr_Foreach.baseEn, 7)
      x2497_inr_Foreach.backpressure := true.B | x2497_inr_Foreach.sm.io.doneLatch
      x2497_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2497_inr_Foreach.sm.io.doneLatch
      x2497_inr_Foreach.sm.io.enableOut.zip(x2497_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2497_inr_Foreach.sm.io.break := false.B
      x2497_inr_Foreach.mask := ~x2497_inr_Foreach.cchain.head.output.noop & true.B
      x2497_inr_Foreach.configure("x2497_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2497_inr_Foreach.kernel()
    }
    val module = Module(new x2498_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x2498_outr_Reduce **/
