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

/** Hierarchy: x2290 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2290_outr_Reduce **/
class x2290_outr_Reduce_kernel(
  list_x624_ctrchain: List[CounterChainInterface],
  list_b554: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x582_accum_1: List[NBufInterface],
  list_b564: List[Bool],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x2290_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2290_outr_Reduce_iiCtr"))
  
  abstract class x2290_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x582_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x582_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b554 = Input(new FixedPoint(true, 32, 0))
      val in_x581_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x581_accum_0_p").asInstanceOf[MemParams] ))
      val in_b564 = Input(Bool())
      val in_x624_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x624_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def x582_accum_1 = {io.in_x582_accum_1} ; io.in_x582_accum_1 := DontCare
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b554 = {io.in_b554} 
    def x581_accum_0 = {io.in_x581_accum_0} ; io.in_x581_accum_0 := DontCare
    def b564 = {io.in_b564} 
    def x624_ctrchain = {io.in_x624_ctrchain} ; io.in_x624_ctrchain := DontCare
  }
  def connectWires0(module: x2290_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x582_accum_1.connectLedger(module.io.in_x582_accum_1)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b554 <> b554
    x581_accum_0.connectLedger(module.io.in_x581_accum_0)
    module.io.in_b564 <> b564
    module.io.in_x624_ctrchain.input <> x624_ctrchain.input; module.io.in_x624_ctrchain.output <> x624_ctrchain.output
  }
  val x624_ctrchain = list_x624_ctrchain(0)
  val b554 = list_b554(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x581_accum_0 = list_x472_A_sram_1(2)
  val x582_accum_1 = list_x582_accum_1(0)
  val b564 = list_b564(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2290_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x2290_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2290_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2290_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x2290_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x2290_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x2290_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2290_instrctr, cycles_x2290_outr_Reduce.io.count, iters_x2290_outr_Reduce.io.count, 0.U, 0.U)
      val b2083 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2083.suggestName("b2083")
      val b2083_chain = Module(new RegChainPass(8, 32, myName = "b2083_chain")); b2083_chain.io <> DontCare
      b2083_chain.chain_pass(b2083, io.sigsOut.smDoneIn.head)
      val b2083_chain_read_1 = b2083_chain.read(1).FP(true,32,0)
      val b2083_chain_read_2 = b2083_chain.read(2).FP(true,32,0)
      val b2083_chain_read_3 = b2083_chain.read(3).FP(true,32,0)
      val b2083_chain_read_4 = b2083_chain.read(4).FP(true,32,0)
      val b2083_chain_read_5 = b2083_chain.read(5).FP(true,32,0)
      val b2083_chain_read_6 = b2083_chain.read(6).FP(true,32,0)
      val b2083_chain_read_7 = b2083_chain.read(7).FP(true,32,0)
      val b2084 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b2084.suggestName("b2084")
      val b2084_chain = Module(new RegChainPass(8, 32, myName = "b2084_chain")); b2084_chain.io <> DontCare
      b2084_chain.chain_pass(b2084, io.sigsOut.smDoneIn.head)
      val b2084_chain_read_1 = b2084_chain.read(1).FP(true,32,0)
      val b2084_chain_read_2 = b2084_chain.read(2).FP(true,32,0)
      val b2084_chain_read_3 = b2084_chain.read(3).FP(true,32,0)
      val b2084_chain_read_4 = b2084_chain.read(4).FP(true,32,0)
      val b2084_chain_read_5 = b2084_chain.read(5).FP(true,32,0)
      val b2084_chain_read_6 = b2084_chain.read(6).FP(true,32,0)
      val b2084_chain_read_7 = b2084_chain.read(7).FP(true,32,0)
      val b2086 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2086.suggestName("b2086")
      val b2086_chain = Module(new RegChainPass(8, 1, myName = "b2086_chain")); b2086_chain.io <> DontCare
      b2086_chain.chain_pass(b2086, io.sigsOut.smDoneIn.head)
      val b2086_chain_read_1: Bool = b2086_chain.read(1).apply(0)
      val b2086_chain_read_2: Bool = b2086_chain.read(2).apply(0)
      val b2086_chain_read_3: Bool = b2086_chain.read(3).apply(0)
      val b2086_chain_read_4: Bool = b2086_chain.read(4).apply(0)
      val b2086_chain_read_5: Bool = b2086_chain.read(5).apply(0)
      val b2086_chain_read_6: Bool = b2086_chain.read(6).apply(0)
      val b2086_chain_read_7: Bool = b2086_chain.read(7).apply(0)
      val b2087 = ~io.sigsIn.cchainOutputs.head.oobs(1); b2087.suggestName("b2087")
      val b2087_chain = Module(new RegChainPass(8, 1, myName = "b2087_chain")); b2087_chain.io <> DontCare
      b2087_chain.chain_pass(b2087, io.sigsOut.smDoneIn.head)
      val b2087_chain_read_1: Bool = b2087_chain.read(1).apply(0)
      val b2087_chain_read_2: Bool = b2087_chain.read(2).apply(0)
      val b2087_chain_read_3: Bool = b2087_chain.read(3).apply(0)
      val b2087_chain_read_4: Bool = b2087_chain.read(4).apply(0)
      val b2087_chain_read_5: Bool = b2087_chain.read(5).apply(0)
      val b2087_chain_read_6: Bool = b2087_chain.read(6).apply(0)
      val b2087_chain_read_7: Bool = b2087_chain.read(7).apply(0)
      val x2089_tmp_0 = (new x2089_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x2090_tmp_1 = (new x2090_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x2091_tmp_2 = (new x2091_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x2092_tmp_3 = (new x2092_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x2093_tmp_4 = (new x2093_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x2094_tmp_0 = (new x2094_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x2095_tmp_1 = (new x2095_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x2096_tmp_2 = (new x2096_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x2097_tmp_3 = (new x2097_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x2098_tmp_4 = (new x2098_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x2099_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2100_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2101_ctrchain = (new CChainObject(List[CtrObject](x2099_ctr), "x2101_ctrchain")).cchain.io 
      x2101_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2101_ctrchain_p", (x2101_ctrchain.par, x2101_ctrchain.widths))
      val x2102_ctrchain = (new CChainObject(List[CtrObject](x2100_ctr), "x2102_ctrchain")).cchain.io 
      x2102_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2102_ctrchain_p", (x2102_ctrchain.par, x2102_ctrchain.widths))
      val x2145 = new x2145_kernel(List(x2094_tmp_0,x2090_tmp_1,x2093_tmp_4,x2089_tmp_0,x2097_tmp_3,x2096_tmp_2,x2092_tmp_3,x2098_tmp_4,x2095_tmp_1,x2091_tmp_2), List(x2101_ctrchain,x2102_ctrchain), List(b2086,b564,b2087), List(b2083,b554,b2084), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2145.sm.io.ctrDone := risingEdge(x2145.sm.io.ctrInc)
      b2083_chain.connectStageCtrl((x2145.done).DS(1.toInt, rr, x2145.sm.io.backpressure), x2145.baseEn, 0)
      b2084_chain.connectStageCtrl((x2145.done).DS(1.toInt, rr, x2145.sm.io.backpressure), x2145.baseEn, 0)
      b2086_chain.connectStageCtrl((x2145.done).DS(1.toInt, rr, x2145.sm.io.backpressure), x2145.baseEn, 0)
      b2087_chain.connectStageCtrl((x2145.done).DS(1.toInt, rr, x2145.sm.io.backpressure), x2145.baseEn, 0)
      x2145.backpressure := true.B | x2145.sm.io.doneLatch
      x2145.forwardpressure := (true.B) && (true.B) | x2145.sm.io.doneLatch
      x2145.sm.io.enableOut.zip(x2145.smEnableOuts).foreach{case (l,r) => r := l}
      x2145.sm.io.break := false.B
      x2145.mask := true.B & b564
      x2145.configure("x2145", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2145.kernel()
      val x2146_r_0 = (new x2146_r_0).m.io.asInstanceOf[NBufInterface]
      val x2147_r_0 = (new x2147_r_0).m.io.asInstanceOf[NBufInterface]
      val x2174 = new x2174_kernel(List(b2086_chain_read_1,b564,b2087_chain_read_1), List(x2094_tmp_0,x2146_r_0,x2090_tmp_1,x2093_tmp_4,x2147_r_0,x2089_tmp_0,x2097_tmp_3,x2096_tmp_2,x2092_tmp_3,x2098_tmp_4,x2095_tmp_1,x2091_tmp_2) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2174.sm.io.ctrDone := risingEdge(x2174.sm.io.ctrInc)
      b2083_chain.connectStageCtrl((x2174.done).DS(1.toInt, rr, x2174.sm.io.backpressure), x2174.baseEn, 1)
      b2084_chain.connectStageCtrl((x2174.done).DS(1.toInt, rr, x2174.sm.io.backpressure), x2174.baseEn, 1)
      b2086_chain.connectStageCtrl((x2174.done).DS(1.toInt, rr, x2174.sm.io.backpressure), x2174.baseEn, 1)
      b2087_chain.connectStageCtrl((x2174.done).DS(1.toInt, rr, x2174.sm.io.backpressure), x2174.baseEn, 1)
      x2174.backpressure := true.B | x2174.sm.io.doneLatch
      x2174.forwardpressure := (true.B) && (true.B) | x2174.sm.io.doneLatch
      x2174.sm.io.enableOut.zip(x2174.smEnableOuts).foreach{case (l,r) => r := l}
      x2174.sm.io.break := false.B
      x2174.mask := true.B & b564
      x2174.configure("x2174", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2174.kernel()
      val x2175_force_0 = (new x2175_force_0).m.io.asInstanceOf[NBufInterface]
      val x2176_force_0 = (new x2176_force_0).m.io.asInstanceOf[NBufInterface]
      val x2177_reg = (new x2177_reg).m.io.asInstanceOf[NBufInterface]
      val x2178_reg = (new x2178_reg).m.io.asInstanceOf[NBufInterface]
      val x2179_reg = (new x2179_reg).m.io.asInstanceOf[NBufInterface]
      val x2180_reg = (new x2180_reg).m.io.asInstanceOf[NBufInterface]
      val x2199 = new x2199_kernel(List(b2086_chain_read_2,b564,b2087_chain_read_2), List(x2094_tmp_0,x2146_r_0,x2178_reg,x2090_tmp_1,x2093_tmp_4,x2147_r_0,x2179_reg,x2089_tmp_0,x2097_tmp_3,x2180_reg,x2096_tmp_2,x2092_tmp_3,x2098_tmp_4,x2095_tmp_1,x2091_tmp_2,x2177_reg) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2199.sm.io.ctrDone := risingEdge(x2199.sm.io.ctrInc)
      b2083_chain.connectStageCtrl((x2199.done).DS(1.toInt, rr, x2199.sm.io.backpressure), x2199.baseEn, 2)
      b2084_chain.connectStageCtrl((x2199.done).DS(1.toInt, rr, x2199.sm.io.backpressure), x2199.baseEn, 2)
      b2086_chain.connectStageCtrl((x2199.done).DS(1.toInt, rr, x2199.sm.io.backpressure), x2199.baseEn, 2)
      b2087_chain.connectStageCtrl((x2199.done).DS(1.toInt, rr, x2199.sm.io.backpressure), x2199.baseEn, 2)
      x2199.backpressure := true.B | x2199.sm.io.doneLatch
      x2199.forwardpressure := (true.B) && (true.B) | x2199.sm.io.doneLatch
      x2199.sm.io.enableOut.zip(x2199.smEnableOuts).foreach{case (l,r) => r := l}
      x2199.sm.io.break := false.B
      x2199.mask := true.B & b564
      x2199.configure("x2199", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2199.kernel()
      val x2955_rd_x2177 = Wire(Bool()).suggestName("""x2955_rd_x2177""")
      val x2955_rd_x2177_banks = List[UInt]()
      val x2955_rd_x2177_ofs = List[UInt]()
      val x2955_rd_x2177_en = List[Bool](true.B)
      val x2955_rd_x2177_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2955_rd_x2177_shared_en")
      x2955_rd_x2177.toSeq.zip(x2177_reg.connectRPort(2955, x2955_rd_x2177_banks, x2955_rd_x2177_ofs, io.sigsIn.backpressure, x2955_rd_x2177_en.map(_ && x2955_rd_x2177_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2956_rd_x2179 = Wire(Bool()).suggestName("""x2956_rd_x2179""")
      val x2956_rd_x2179_banks = List[UInt]()
      val x2956_rd_x2179_ofs = List[UInt]()
      val x2956_rd_x2179_en = List[Bool](true.B)
      val x2956_rd_x2179_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2956_rd_x2179_shared_en")
      x2956_rd_x2179.toSeq.zip(x2179_reg.connectRPort(2956, x2956_rd_x2179_banks, x2956_rd_x2179_ofs, io.sigsIn.backpressure, x2956_rd_x2179_en.map(_ && x2956_rd_x2179_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2217_inr_Switch_obj = new x2217_inr_Switch_kernel(List(x2955_rd_x2177,x2956_rd_x2179), List(x2094_tmp_0,x2146_r_0,x2178_reg,x2090_tmp_1,x2093_tmp_4,x2147_r_0,x2179_reg,x2089_tmp_0,x2097_tmp_3,x2180_reg,x2096_tmp_2,x2092_tmp_3,x2098_tmp_4,x2095_tmp_1,x2091_tmp_2,x2177_reg) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2217_inr_Switch_obj.sm.io.selectsIn(0) := x2955_rd_x2177
      x2217_inr_Switch_obj.sm.io.selectsIn(1) := x2956_rd_x2179
      b2083_chain.connectStageCtrl((x2217_inr_Switch_obj.done).DS(1.toInt, rr, x2217_inr_Switch_obj.sm.io.backpressure), x2217_inr_Switch_obj.baseEn, 3)
      b2084_chain.connectStageCtrl((x2217_inr_Switch_obj.done).DS(1.toInt, rr, x2217_inr_Switch_obj.sm.io.backpressure), x2217_inr_Switch_obj.baseEn, 3)
      b2086_chain.connectStageCtrl((x2217_inr_Switch_obj.done).DS(1.toInt, rr, x2217_inr_Switch_obj.sm.io.backpressure), x2217_inr_Switch_obj.baseEn, 3)
      b2087_chain.connectStageCtrl((x2217_inr_Switch_obj.done).DS(1.toInt, rr, x2217_inr_Switch_obj.sm.io.backpressure), x2217_inr_Switch_obj.baseEn, 3)
      x2217_inr_Switch_obj.backpressure := true.B | x2217_inr_Switch_obj.sm.io.doneLatch
      x2217_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x2217_inr_Switch_obj.sm.io.doneLatch
      x2217_inr_Switch_obj.sm.io.enableOut.zip(x2217_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2217_inr_Switch_obj.sm.io.break := false.B
      val x2217_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2217_inr_Switch""")
      x2217_inr_Switch_obj.mask := true.B & true.B
      x2217_inr_Switch_obj.configure("x2217_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2217_inr_Switch.r := x2217_inr_Switch_obj.kernel().r
      val x2957_rd_x2178 = Wire(Bool()).suggestName("""x2957_rd_x2178""")
      val x2957_rd_x2178_banks = List[UInt]()
      val x2957_rd_x2178_ofs = List[UInt]()
      val x2957_rd_x2178_en = List[Bool](true.B)
      val x2957_rd_x2178_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2957_rd_x2178_shared_en")
      x2957_rd_x2178.toSeq.zip(x2178_reg.connectRPort(2957, x2957_rd_x2178_banks, x2957_rd_x2178_ofs, io.sigsIn.backpressure, x2957_rd_x2178_en.map(_ && x2957_rd_x2178_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2958_rd_x2180 = Wire(Bool()).suggestName("""x2958_rd_x2180""")
      val x2958_rd_x2180_banks = List[UInt]()
      val x2958_rd_x2180_ofs = List[UInt]()
      val x2958_rd_x2180_en = List[Bool](true.B)
      val x2958_rd_x2180_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2958_rd_x2180_shared_en")
      x2958_rd_x2180.toSeq.zip(x2180_reg.connectRPort(2958, x2958_rd_x2180_banks, x2958_rd_x2180_ofs, io.sigsIn.backpressure, x2958_rd_x2180_en.map(_ && x2958_rd_x2180_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2231_inr_Switch_obj = new x2231_inr_Switch_kernel(List(x2957_rd_x2178,x2958_rd_x2180), List(x2094_tmp_0,x2178_reg,x2090_tmp_1,x2093_tmp_4,x2147_r_0,x2089_tmp_0,x2097_tmp_3,x2180_reg,x2096_tmp_2,x2092_tmp_3,x2098_tmp_4,x2095_tmp_1,x2091_tmp_2) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2231_inr_Switch_obj.sm.io.selectsIn(0) := x2957_rd_x2178
      x2231_inr_Switch_obj.sm.io.selectsIn(1) := x2958_rd_x2180
      b2083_chain.connectStageCtrl((x2231_inr_Switch_obj.done).DS(1.toInt, rr, x2231_inr_Switch_obj.sm.io.backpressure), x2231_inr_Switch_obj.baseEn, 4)
      b2084_chain.connectStageCtrl((x2231_inr_Switch_obj.done).DS(1.toInt, rr, x2231_inr_Switch_obj.sm.io.backpressure), x2231_inr_Switch_obj.baseEn, 4)
      b2086_chain.connectStageCtrl((x2231_inr_Switch_obj.done).DS(1.toInt, rr, x2231_inr_Switch_obj.sm.io.backpressure), x2231_inr_Switch_obj.baseEn, 4)
      b2087_chain.connectStageCtrl((x2231_inr_Switch_obj.done).DS(1.toInt, rr, x2231_inr_Switch_obj.sm.io.backpressure), x2231_inr_Switch_obj.baseEn, 4)
      x2231_inr_Switch_obj.backpressure := true.B | x2231_inr_Switch_obj.sm.io.doneLatch
      x2231_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x2231_inr_Switch_obj.sm.io.doneLatch
      x2231_inr_Switch_obj.sm.io.enableOut.zip(x2231_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2231_inr_Switch_obj.sm.io.break := false.B
      val x2231_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2231_inr_Switch""")
      x2231_inr_Switch_obj.mask := true.B & true.B
      x2231_inr_Switch_obj.configure("x2231_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2231_inr_Switch.r := x2231_inr_Switch_obj.kernel().r
      val x2236 = new x2236_kernel(List(b2086_chain_read_5,b564,b2087_chain_read_5), List(x2231_inr_Switch,x2217_inr_Switch), List(x2094_tmp_0,x2090_tmp_1,x2093_tmp_4,x2089_tmp_0,x2176_force_0,x2097_tmp_3,x2096_tmp_2,x2175_force_0,x2092_tmp_3,x2098_tmp_4,x2095_tmp_1,x2091_tmp_2) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2236.sm.io.ctrDone := risingEdge(x2236.sm.io.ctrInc)
      b2083_chain.connectStageCtrl((x2236.done).DS(1.toInt, rr, x2236.sm.io.backpressure), x2236.baseEn, 5)
      b2084_chain.connectStageCtrl((x2236.done).DS(1.toInt, rr, x2236.sm.io.backpressure), x2236.baseEn, 5)
      b2086_chain.connectStageCtrl((x2236.done).DS(1.toInt, rr, x2236.sm.io.backpressure), x2236.baseEn, 5)
      b2087_chain.connectStageCtrl((x2236.done).DS(1.toInt, rr, x2236.sm.io.backpressure), x2236.baseEn, 5)
      x2236.backpressure := true.B | x2236.sm.io.doneLatch
      x2236.forwardpressure := (true.B) && (true.B) | x2236.sm.io.doneLatch
      x2236.sm.io.enableOut.zip(x2236.smEnableOuts).foreach{case (l,r) => r := l}
      x2236.sm.io.break := false.B
      x2236.mask := true.B & b564
      x2236.configure("x2236", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2236.kernel()
      val x2237_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2238_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2239_ctrchain = (new CChainObject(List[CtrObject](x2237_ctr), "x2239_ctrchain")).cchain.io 
      x2239_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2239_ctrchain_p", (x2239_ctrchain.par, x2239_ctrchain.widths))
      val x2240_ctrchain = (new CChainObject(List[CtrObject](x2238_ctr), "x2240_ctrchain")).cchain.io 
      x2240_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2240_ctrchain_p", (x2240_ctrchain.par, x2240_ctrchain.widths))
      val x2269 = new x2269_kernel(List(b2086_chain_read_6,b564,b2087_chain_read_6), List(x2240_ctrchain,x2239_ctrchain), List(x2094_tmp_0,x2090_tmp_1,x2093_tmp_4,x2089_tmp_0,x2176_force_0,x2097_tmp_3,x2096_tmp_2,x2175_force_0,x2092_tmp_3,x2098_tmp_4,x2095_tmp_1,x2091_tmp_2) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2269.sm.io.ctrDone := risingEdge(x2269.sm.io.ctrInc)
      b2083_chain.connectStageCtrl((x2269.done).DS(1.toInt, rr, x2269.sm.io.backpressure), x2269.baseEn, 6)
      b2084_chain.connectStageCtrl((x2269.done).DS(1.toInt, rr, x2269.sm.io.backpressure), x2269.baseEn, 6)
      b2086_chain.connectStageCtrl((x2269.done).DS(1.toInt, rr, x2269.sm.io.backpressure), x2269.baseEn, 6)
      b2087_chain.connectStageCtrl((x2269.done).DS(1.toInt, rr, x2269.sm.io.backpressure), x2269.baseEn, 6)
      x2269.backpressure := true.B | x2269.sm.io.doneLatch
      x2269.forwardpressure := (true.B) && (true.B) | x2269.sm.io.doneLatch
      x2269.sm.io.enableOut.zip(x2269.smEnableOuts).foreach{case (l,r) => r := l}
      x2269.sm.io.break := false.B
      x2269.mask := true.B & b564
      x2269.configure("x2269", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2269.kernel()
      val x2289_inr_Foreach = new x2289_inr_Foreach_kernel(List(b564,b2087_chain_read_7), List(b2083_chain_read_7), List(x581_accum_0), List(x582_accum_1,x2093_tmp_4,x2098_tmp_4) ,  Some(me), List(x624_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2289_inr_Foreach.sm.io.ctrDone := (x2289_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b2083_chain.connectStageCtrl((x2289_inr_Foreach.done).DS(1.toInt, rr, x2289_inr_Foreach.sm.io.backpressure), x2289_inr_Foreach.baseEn, 7)
      b2084_chain.connectStageCtrl((x2289_inr_Foreach.done).DS(1.toInt, rr, x2289_inr_Foreach.sm.io.backpressure), x2289_inr_Foreach.baseEn, 7)
      b2086_chain.connectStageCtrl((x2289_inr_Foreach.done).DS(1.toInt, rr, x2289_inr_Foreach.sm.io.backpressure), x2289_inr_Foreach.baseEn, 7)
      b2087_chain.connectStageCtrl((x2289_inr_Foreach.done).DS(1.toInt, rr, x2289_inr_Foreach.sm.io.backpressure), x2289_inr_Foreach.baseEn, 7)
      x2289_inr_Foreach.backpressure := true.B | x2289_inr_Foreach.sm.io.doneLatch
      x2289_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2289_inr_Foreach.sm.io.doneLatch
      x2289_inr_Foreach.sm.io.enableOut.zip(x2289_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2289_inr_Foreach.sm.io.break := false.B
      x2289_inr_Foreach.mask := ~x2289_inr_Foreach.cchain.head.output.noop & true.B
      x2289_inr_Foreach.configure("x2289_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2289_inr_Foreach.kernel()
    }
    val module = Module(new x2290_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x2290_outr_Reduce **/
