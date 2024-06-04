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

/** Hierarchy: x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1042_outr_Reduce **/
class x1042_outr_Reduce_kernel(
  list_x618_ctrchain: List[CounterChainInterface],
  list_b548: List[FixedPoint],
  list_x570_accum_1: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
  list_b558: List[Bool],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x1042_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1042_outr_Reduce_iiCtr"))
  
  abstract class x1042_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x570_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x570_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x569_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x569_accum_0_p").asInstanceOf[MemParams] ))
      val in_b558 = Input(Bool())
      val in_x618_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x618_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b548 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x570_accum_1 = {io.in_x570_accum_1} ; io.in_x570_accum_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x569_accum_0 = {io.in_x569_accum_0} ; io.in_x569_accum_0 := DontCare
    def b558 = {io.in_b558} 
    def x618_ctrchain = {io.in_x618_ctrchain} ; io.in_x618_ctrchain := DontCare
    def b548 = {io.in_b548} 
  }
  def connectWires0(module: x1042_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x570_accum_1.connectLedger(module.io.in_x570_accum_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x569_accum_0.connectLedger(module.io.in_x569_accum_0)
    module.io.in_b558 <> b558
    module.io.in_x618_ctrchain.input <> x618_ctrchain.input; module.io.in_x618_ctrchain.output <> x618_ctrchain.output
    module.io.in_b548 <> b548
  }
  val x618_ctrchain = list_x618_ctrchain(0)
  val b548 = list_b548(0)
  val x570_accum_1 = list_x570_accum_1(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x569_accum_0 = list_x472_A_sram_1(2)
  val b558 = list_b558(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1042_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x1042_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1042_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1042_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x1042_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x1042_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x1042_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1042_instrctr, cycles_x1042_outr_Reduce.io.count, iters_x1042_outr_Reduce.io.count, 0.U, 0.U)
      val b835 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b835.suggestName("b835")
      val b835_chain = Module(new RegChainPass(8, 32, myName = "b835_chain")); b835_chain.io <> DontCare
      b835_chain.chain_pass(b835, io.sigsOut.smDoneIn.head)
      val b835_chain_read_1 = b835_chain.read(1).FP(true,32,0)
      val b835_chain_read_2 = b835_chain.read(2).FP(true,32,0)
      val b835_chain_read_3 = b835_chain.read(3).FP(true,32,0)
      val b835_chain_read_4 = b835_chain.read(4).FP(true,32,0)
      val b835_chain_read_5 = b835_chain.read(5).FP(true,32,0)
      val b835_chain_read_6 = b835_chain.read(6).FP(true,32,0)
      val b835_chain_read_7 = b835_chain.read(7).FP(true,32,0)
      val b836 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b836.suggestName("b836")
      val b836_chain = Module(new RegChainPass(8, 32, myName = "b836_chain")); b836_chain.io <> DontCare
      b836_chain.chain_pass(b836, io.sigsOut.smDoneIn.head)
      val b836_chain_read_1 = b836_chain.read(1).FP(true,32,0)
      val b836_chain_read_2 = b836_chain.read(2).FP(true,32,0)
      val b836_chain_read_3 = b836_chain.read(3).FP(true,32,0)
      val b836_chain_read_4 = b836_chain.read(4).FP(true,32,0)
      val b836_chain_read_5 = b836_chain.read(5).FP(true,32,0)
      val b836_chain_read_6 = b836_chain.read(6).FP(true,32,0)
      val b836_chain_read_7 = b836_chain.read(7).FP(true,32,0)
      val b838 = ~io.sigsIn.cchainOutputs.head.oobs(0); b838.suggestName("b838")
      val b838_chain = Module(new RegChainPass(8, 1, myName = "b838_chain")); b838_chain.io <> DontCare
      b838_chain.chain_pass(b838, io.sigsOut.smDoneIn.head)
      val b838_chain_read_1: Bool = b838_chain.read(1).apply(0)
      val b838_chain_read_2: Bool = b838_chain.read(2).apply(0)
      val b838_chain_read_3: Bool = b838_chain.read(3).apply(0)
      val b838_chain_read_4: Bool = b838_chain.read(4).apply(0)
      val b838_chain_read_5: Bool = b838_chain.read(5).apply(0)
      val b838_chain_read_6: Bool = b838_chain.read(6).apply(0)
      val b838_chain_read_7: Bool = b838_chain.read(7).apply(0)
      val b839 = ~io.sigsIn.cchainOutputs.head.oobs(1); b839.suggestName("b839")
      val b839_chain = Module(new RegChainPass(8, 1, myName = "b839_chain")); b839_chain.io <> DontCare
      b839_chain.chain_pass(b839, io.sigsOut.smDoneIn.head)
      val b839_chain_read_1: Bool = b839_chain.read(1).apply(0)
      val b839_chain_read_2: Bool = b839_chain.read(2).apply(0)
      val b839_chain_read_3: Bool = b839_chain.read(3).apply(0)
      val b839_chain_read_4: Bool = b839_chain.read(4).apply(0)
      val b839_chain_read_5: Bool = b839_chain.read(5).apply(0)
      val b839_chain_read_6: Bool = b839_chain.read(6).apply(0)
      val b839_chain_read_7: Bool = b839_chain.read(7).apply(0)
      val x841_tmp_0 = (new x841_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x842_tmp_1 = (new x842_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x843_tmp_2 = (new x843_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x844_tmp_3 = (new x844_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x845_tmp_4 = (new x845_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x846_tmp_0 = (new x846_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x847_tmp_1 = (new x847_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x848_tmp_2 = (new x848_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x849_tmp_3 = (new x849_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x850_tmp_4 = (new x850_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x851_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x852_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x853_ctrchain = (new CChainObject(List[CtrObject](x851_ctr), "x853_ctrchain")).cchain.io 
      x853_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x853_ctrchain_p", (x853_ctrchain.par, x853_ctrchain.widths))
      val x854_ctrchain = (new CChainObject(List[CtrObject](x852_ctr), "x854_ctrchain")).cchain.io 
      x854_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x854_ctrchain_p", (x854_ctrchain.par, x854_ctrchain.widths))
      val x897 = new x897_kernel(List(x853_ctrchain,x854_ctrchain), List(b838,b558,b839), List(x472_A_sram_1,x471_A_sram_0), List(b548,b836,b835), List(x846_tmp_0,x841_tmp_0,x849_tmp_3,x847_tmp_1,x842_tmp_1,x843_tmp_2,x848_tmp_2,x845_tmp_4,x844_tmp_3,x850_tmp_4) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x897.sm.io.ctrDone := risingEdge(x897.sm.io.ctrInc)
      b835_chain.connectStageCtrl((x897.done).DS(1.toInt, rr, x897.sm.io.backpressure), x897.baseEn, 0)
      b836_chain.connectStageCtrl((x897.done).DS(1.toInt, rr, x897.sm.io.backpressure), x897.baseEn, 0)
      b838_chain.connectStageCtrl((x897.done).DS(1.toInt, rr, x897.sm.io.backpressure), x897.baseEn, 0)
      b839_chain.connectStageCtrl((x897.done).DS(1.toInt, rr, x897.sm.io.backpressure), x897.baseEn, 0)
      x897.backpressure := true.B | x897.sm.io.doneLatch
      x897.forwardpressure := (true.B) && (true.B) | x897.sm.io.doneLatch
      x897.sm.io.enableOut.zip(x897.smEnableOuts).foreach{case (l,r) => r := l}
      x897.sm.io.break := false.B
      x897.mask := true.B & b558
      x897.configure("x897", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x897.kernel()
      val x898_r_0 = (new x898_r_0).m.io.asInstanceOf[NBufInterface]
      val x899_r_0 = (new x899_r_0).m.io.asInstanceOf[NBufInterface]
      val x926 = new x926_kernel(List(b838_chain_read_1,b558,b839_chain_read_1), List(x846_tmp_0,x898_r_0,x841_tmp_0,x849_tmp_3,x847_tmp_1,x842_tmp_1,x843_tmp_2,x848_tmp_2,x845_tmp_4,x844_tmp_3,x899_r_0,x850_tmp_4) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x926.sm.io.ctrDone := risingEdge(x926.sm.io.ctrInc)
      b835_chain.connectStageCtrl((x926.done).DS(1.toInt, rr, x926.sm.io.backpressure), x926.baseEn, 1)
      b836_chain.connectStageCtrl((x926.done).DS(1.toInt, rr, x926.sm.io.backpressure), x926.baseEn, 1)
      b838_chain.connectStageCtrl((x926.done).DS(1.toInt, rr, x926.sm.io.backpressure), x926.baseEn, 1)
      b839_chain.connectStageCtrl((x926.done).DS(1.toInt, rr, x926.sm.io.backpressure), x926.baseEn, 1)
      x926.backpressure := true.B | x926.sm.io.doneLatch
      x926.forwardpressure := (true.B) && (true.B) | x926.sm.io.doneLatch
      x926.sm.io.enableOut.zip(x926.smEnableOuts).foreach{case (l,r) => r := l}
      x926.sm.io.break := false.B
      x926.mask := true.B & b558
      x926.configure("x926", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x926.kernel()
      val x927_force_0 = (new x927_force_0).m.io.asInstanceOf[NBufInterface]
      val x928_force_0 = (new x928_force_0).m.io.asInstanceOf[NBufInterface]
      val x929_reg = (new x929_reg).m.io.asInstanceOf[NBufInterface]
      val x930_reg = (new x930_reg).m.io.asInstanceOf[NBufInterface]
      val x931_reg = (new x931_reg).m.io.asInstanceOf[NBufInterface]
      val x932_reg = (new x932_reg).m.io.asInstanceOf[NBufInterface]
      val x951 = new x951_kernel(List(b838_chain_read_2,b558,b839_chain_read_2), List(x846_tmp_0,x930_reg,x898_r_0,x841_tmp_0,x849_tmp_3,x847_tmp_1,x842_tmp_1,x843_tmp_2,x848_tmp_2,x932_reg,x845_tmp_4,x931_reg,x844_tmp_3,x929_reg,x899_r_0,x850_tmp_4) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x951.sm.io.ctrDone := risingEdge(x951.sm.io.ctrInc)
      b835_chain.connectStageCtrl((x951.done).DS(1.toInt, rr, x951.sm.io.backpressure), x951.baseEn, 2)
      b836_chain.connectStageCtrl((x951.done).DS(1.toInt, rr, x951.sm.io.backpressure), x951.baseEn, 2)
      b838_chain.connectStageCtrl((x951.done).DS(1.toInt, rr, x951.sm.io.backpressure), x951.baseEn, 2)
      b839_chain.connectStageCtrl((x951.done).DS(1.toInt, rr, x951.sm.io.backpressure), x951.baseEn, 2)
      x951.backpressure := true.B | x951.sm.io.doneLatch
      x951.forwardpressure := (true.B) && (true.B) | x951.sm.io.doneLatch
      x951.sm.io.enableOut.zip(x951.smEnableOuts).foreach{case (l,r) => r := l}
      x951.sm.io.break := false.B
      x951.mask := true.B & b558
      x951.configure("x951", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x951.kernel()
      val x2931_rd_x929 = Wire(Bool()).suggestName("""x2931_rd_x929""")
      val x2931_rd_x929_banks = List[UInt]()
      val x2931_rd_x929_ofs = List[UInt]()
      val x2931_rd_x929_en = List[Bool](true.B)
      val x2931_rd_x929_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2931_rd_x929_shared_en")
      x2931_rd_x929.toSeq.zip(x929_reg.connectRPort(2931, x2931_rd_x929_banks, x2931_rd_x929_ofs, io.sigsIn.backpressure, x2931_rd_x929_en.map(_ && x2931_rd_x929_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2932_rd_x931 = Wire(Bool()).suggestName("""x2932_rd_x931""")
      val x2932_rd_x931_banks = List[UInt]()
      val x2932_rd_x931_ofs = List[UInt]()
      val x2932_rd_x931_en = List[Bool](true.B)
      val x2932_rd_x931_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2932_rd_x931_shared_en")
      x2932_rd_x931.toSeq.zip(x931_reg.connectRPort(2932, x2932_rd_x931_banks, x2932_rd_x931_ofs, io.sigsIn.backpressure, x2932_rd_x931_en.map(_ && x2932_rd_x931_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x969_inr_Switch_obj = new x969_inr_Switch_kernel(List(x2932_rd_x931,x2931_rd_x929), List(x846_tmp_0,x930_reg,x898_r_0,x841_tmp_0,x849_tmp_3,x847_tmp_1,x842_tmp_1,x843_tmp_2,x848_tmp_2,x932_reg,x845_tmp_4,x931_reg,x844_tmp_3,x929_reg,x899_r_0,x850_tmp_4) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x969_inr_Switch_obj.sm.io.selectsIn(0) := x2931_rd_x929
      x969_inr_Switch_obj.sm.io.selectsIn(1) := x2932_rd_x931
      b835_chain.connectStageCtrl((x969_inr_Switch_obj.done).DS(1.toInt, rr, x969_inr_Switch_obj.sm.io.backpressure), x969_inr_Switch_obj.baseEn, 3)
      b836_chain.connectStageCtrl((x969_inr_Switch_obj.done).DS(1.toInt, rr, x969_inr_Switch_obj.sm.io.backpressure), x969_inr_Switch_obj.baseEn, 3)
      b838_chain.connectStageCtrl((x969_inr_Switch_obj.done).DS(1.toInt, rr, x969_inr_Switch_obj.sm.io.backpressure), x969_inr_Switch_obj.baseEn, 3)
      b839_chain.connectStageCtrl((x969_inr_Switch_obj.done).DS(1.toInt, rr, x969_inr_Switch_obj.sm.io.backpressure), x969_inr_Switch_obj.baseEn, 3)
      x969_inr_Switch_obj.backpressure := true.B | x969_inr_Switch_obj.sm.io.doneLatch
      x969_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x969_inr_Switch_obj.sm.io.doneLatch
      x969_inr_Switch_obj.sm.io.enableOut.zip(x969_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x969_inr_Switch_obj.sm.io.break := false.B
      val x969_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x969_inr_Switch""")
      x969_inr_Switch_obj.mask := true.B & true.B
      x969_inr_Switch_obj.configure("x969_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x969_inr_Switch.r := x969_inr_Switch_obj.kernel().r
      val x2933_rd_x930 = Wire(Bool()).suggestName("""x2933_rd_x930""")
      val x2933_rd_x930_banks = List[UInt]()
      val x2933_rd_x930_ofs = List[UInt]()
      val x2933_rd_x930_en = List[Bool](true.B)
      val x2933_rd_x930_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2933_rd_x930_shared_en")
      x2933_rd_x930.toSeq.zip(x930_reg.connectRPort(2933, x2933_rd_x930_banks, x2933_rd_x930_ofs, io.sigsIn.backpressure, x2933_rd_x930_en.map(_ && x2933_rd_x930_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2934_rd_x932 = Wire(Bool()).suggestName("""x2934_rd_x932""")
      val x2934_rd_x932_banks = List[UInt]()
      val x2934_rd_x932_ofs = List[UInt]()
      val x2934_rd_x932_en = List[Bool](true.B)
      val x2934_rd_x932_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2934_rd_x932_shared_en")
      x2934_rd_x932.toSeq.zip(x932_reg.connectRPort(2934, x2934_rd_x932_banks, x2934_rd_x932_ofs, io.sigsIn.backpressure, x2934_rd_x932_en.map(_ && x2934_rd_x932_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x983_inr_Switch_obj = new x983_inr_Switch_kernel(List(x2933_rd_x930,x2934_rd_x932), List(x846_tmp_0,x930_reg,x841_tmp_0,x849_tmp_3,x847_tmp_1,x842_tmp_1,x843_tmp_2,x848_tmp_2,x932_reg,x845_tmp_4,x844_tmp_3,x899_r_0,x850_tmp_4) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x983_inr_Switch_obj.sm.io.selectsIn(0) := x2933_rd_x930
      x983_inr_Switch_obj.sm.io.selectsIn(1) := x2934_rd_x932
      b835_chain.connectStageCtrl((x983_inr_Switch_obj.done).DS(1.toInt, rr, x983_inr_Switch_obj.sm.io.backpressure), x983_inr_Switch_obj.baseEn, 4)
      b836_chain.connectStageCtrl((x983_inr_Switch_obj.done).DS(1.toInt, rr, x983_inr_Switch_obj.sm.io.backpressure), x983_inr_Switch_obj.baseEn, 4)
      b838_chain.connectStageCtrl((x983_inr_Switch_obj.done).DS(1.toInt, rr, x983_inr_Switch_obj.sm.io.backpressure), x983_inr_Switch_obj.baseEn, 4)
      b839_chain.connectStageCtrl((x983_inr_Switch_obj.done).DS(1.toInt, rr, x983_inr_Switch_obj.sm.io.backpressure), x983_inr_Switch_obj.baseEn, 4)
      x983_inr_Switch_obj.backpressure := true.B | x983_inr_Switch_obj.sm.io.doneLatch
      x983_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x983_inr_Switch_obj.sm.io.doneLatch
      x983_inr_Switch_obj.sm.io.enableOut.zip(x983_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x983_inr_Switch_obj.sm.io.break := false.B
      val x983_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x983_inr_Switch""")
      x983_inr_Switch_obj.mask := true.B & true.B
      x983_inr_Switch_obj.configure("x983_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x983_inr_Switch.r := x983_inr_Switch_obj.kernel().r
      val x988 = new x988_kernel(List(b838_chain_read_5,b558,b839_chain_read_5), List(x969_inr_Switch,x983_inr_Switch), List(x846_tmp_0,x841_tmp_0,x849_tmp_3,x847_tmp_1,x842_tmp_1,x843_tmp_2,x848_tmp_2,x927_force_0,x845_tmp_4,x844_tmp_3,x928_force_0,x850_tmp_4) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x988.sm.io.ctrDone := risingEdge(x988.sm.io.ctrInc)
      b835_chain.connectStageCtrl((x988.done).DS(1.toInt, rr, x988.sm.io.backpressure), x988.baseEn, 5)
      b836_chain.connectStageCtrl((x988.done).DS(1.toInt, rr, x988.sm.io.backpressure), x988.baseEn, 5)
      b838_chain.connectStageCtrl((x988.done).DS(1.toInt, rr, x988.sm.io.backpressure), x988.baseEn, 5)
      b839_chain.connectStageCtrl((x988.done).DS(1.toInt, rr, x988.sm.io.backpressure), x988.baseEn, 5)
      x988.backpressure := true.B | x988.sm.io.doneLatch
      x988.forwardpressure := (true.B) && (true.B) | x988.sm.io.doneLatch
      x988.sm.io.enableOut.zip(x988.smEnableOuts).foreach{case (l,r) => r := l}
      x988.sm.io.break := false.B
      x988.mask := true.B & b558
      x988.configure("x988", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x988.kernel()
      val x989_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x990_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x991_ctrchain = (new CChainObject(List[CtrObject](x989_ctr), "x991_ctrchain")).cchain.io 
      x991_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x991_ctrchain_p", (x991_ctrchain.par, x991_ctrchain.widths))
      val x992_ctrchain = (new CChainObject(List[CtrObject](x990_ctr), "x992_ctrchain")).cchain.io 
      x992_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x992_ctrchain_p", (x992_ctrchain.par, x992_ctrchain.widths))
      val x1021 = new x1021_kernel(List(b838_chain_read_6,b558,b839_chain_read_6), List(x991_ctrchain,x992_ctrchain), List(x846_tmp_0,x841_tmp_0,x849_tmp_3,x847_tmp_1,x842_tmp_1,x843_tmp_2,x848_tmp_2,x927_force_0,x845_tmp_4,x844_tmp_3,x928_force_0,x850_tmp_4) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1021.sm.io.ctrDone := risingEdge(x1021.sm.io.ctrInc)
      b835_chain.connectStageCtrl((x1021.done).DS(1.toInt, rr, x1021.sm.io.backpressure), x1021.baseEn, 6)
      b836_chain.connectStageCtrl((x1021.done).DS(1.toInt, rr, x1021.sm.io.backpressure), x1021.baseEn, 6)
      b838_chain.connectStageCtrl((x1021.done).DS(1.toInt, rr, x1021.sm.io.backpressure), x1021.baseEn, 6)
      b839_chain.connectStageCtrl((x1021.done).DS(1.toInt, rr, x1021.sm.io.backpressure), x1021.baseEn, 6)
      x1021.backpressure := true.B | x1021.sm.io.doneLatch
      x1021.forwardpressure := (true.B) && (true.B) | x1021.sm.io.doneLatch
      x1021.sm.io.enableOut.zip(x1021.smEnableOuts).foreach{case (l,r) => r := l}
      x1021.sm.io.break := false.B
      x1021.mask := true.B & b558
      x1021.configure("x1021", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1021.kernel()
      val x1041_inr_Foreach = new x1041_inr_Foreach_kernel(List(b558,b839_chain_read_7), List(b835_chain_read_7), List(x569_accum_0), List(x570_accum_1,x845_tmp_4,x850_tmp_4) ,  Some(me), List(x618_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1041_inr_Foreach.sm.io.ctrDone := (x1041_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b835_chain.connectStageCtrl((x1041_inr_Foreach.done).DS(1.toInt, rr, x1041_inr_Foreach.sm.io.backpressure), x1041_inr_Foreach.baseEn, 7)
      b836_chain.connectStageCtrl((x1041_inr_Foreach.done).DS(1.toInt, rr, x1041_inr_Foreach.sm.io.backpressure), x1041_inr_Foreach.baseEn, 7)
      b838_chain.connectStageCtrl((x1041_inr_Foreach.done).DS(1.toInt, rr, x1041_inr_Foreach.sm.io.backpressure), x1041_inr_Foreach.baseEn, 7)
      b839_chain.connectStageCtrl((x1041_inr_Foreach.done).DS(1.toInt, rr, x1041_inr_Foreach.sm.io.backpressure), x1041_inr_Foreach.baseEn, 7)
      x1041_inr_Foreach.backpressure := true.B | x1041_inr_Foreach.sm.io.doneLatch
      x1041_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1041_inr_Foreach.sm.io.doneLatch
      x1041_inr_Foreach.sm.io.enableOut.zip(x1041_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1041_inr_Foreach.sm.io.break := false.B
      x1041_inr_Foreach.mask := ~x1041_inr_Foreach.cchain.head.output.noop & true.B
      x1041_inr_Foreach.configure("x1041_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1041_inr_Foreach.kernel()
    }
    val module = Module(new x1042_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x1042_outr_Reduce **/
