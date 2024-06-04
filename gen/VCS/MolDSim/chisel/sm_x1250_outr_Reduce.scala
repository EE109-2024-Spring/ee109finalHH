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

/** Hierarchy: x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1250_outr_Reduce **/
class x1250_outr_Reduce_kernel(
  list_b559: List[Bool],
  list_x472_A_sram_1: List[StandardInterface],
  list_x572_accum_1: List[NBufInterface],
  list_x619_ctrchain: List[CounterChainInterface],
  list_b549: List[FixedPoint],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x1250_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1250_outr_Reduce_iiCtr"))
  
  abstract class x1250_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x619_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x619_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b559 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x572_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x572_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x571_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x571_accum_0_p").asInstanceOf[MemParams] ))
      val in_b549 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x619_ctrchain = {io.in_x619_ctrchain} ; io.in_x619_ctrchain := DontCare
    def b559 = {io.in_b559} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x572_accum_1 = {io.in_x572_accum_1} ; io.in_x572_accum_1 := DontCare
    def x571_accum_0 = {io.in_x571_accum_0} ; io.in_x571_accum_0 := DontCare
    def b549 = {io.in_b549} 
  }
  def connectWires0(module: x1250_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_x619_ctrchain.input <> x619_ctrchain.input; module.io.in_x619_ctrchain.output <> x619_ctrchain.output
    module.io.in_b559 <> b559
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x572_accum_1.connectLedger(module.io.in_x572_accum_1)
    x571_accum_0.connectLedger(module.io.in_x571_accum_0)
    module.io.in_b549 <> b549
  }
  val b559 = list_b559(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x571_accum_0 = list_x472_A_sram_1(2)
  val x572_accum_1 = list_x572_accum_1(0)
  val x619_ctrchain = list_x619_ctrchain(0)
  val b549 = list_b549(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1250_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x1250_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1250_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1250_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x1250_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x1250_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x1250_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1250_instrctr, cycles_x1250_outr_Reduce.io.count, iters_x1250_outr_Reduce.io.count, 0.U, 0.U)
      val b1043 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1043.suggestName("b1043")
      val b1043_chain = Module(new RegChainPass(8, 32, myName = "b1043_chain")); b1043_chain.io <> DontCare
      b1043_chain.chain_pass(b1043, io.sigsOut.smDoneIn.head)
      val b1043_chain_read_1 = b1043_chain.read(1).FP(true,32,0)
      val b1043_chain_read_2 = b1043_chain.read(2).FP(true,32,0)
      val b1043_chain_read_3 = b1043_chain.read(3).FP(true,32,0)
      val b1043_chain_read_4 = b1043_chain.read(4).FP(true,32,0)
      val b1043_chain_read_5 = b1043_chain.read(5).FP(true,32,0)
      val b1043_chain_read_6 = b1043_chain.read(6).FP(true,32,0)
      val b1043_chain_read_7 = b1043_chain.read(7).FP(true,32,0)
      val b1044 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b1044.suggestName("b1044")
      val b1044_chain = Module(new RegChainPass(8, 32, myName = "b1044_chain")); b1044_chain.io <> DontCare
      b1044_chain.chain_pass(b1044, io.sigsOut.smDoneIn.head)
      val b1044_chain_read_1 = b1044_chain.read(1).FP(true,32,0)
      val b1044_chain_read_2 = b1044_chain.read(2).FP(true,32,0)
      val b1044_chain_read_3 = b1044_chain.read(3).FP(true,32,0)
      val b1044_chain_read_4 = b1044_chain.read(4).FP(true,32,0)
      val b1044_chain_read_5 = b1044_chain.read(5).FP(true,32,0)
      val b1044_chain_read_6 = b1044_chain.read(6).FP(true,32,0)
      val b1044_chain_read_7 = b1044_chain.read(7).FP(true,32,0)
      val b1046 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1046.suggestName("b1046")
      val b1046_chain = Module(new RegChainPass(8, 1, myName = "b1046_chain")); b1046_chain.io <> DontCare
      b1046_chain.chain_pass(b1046, io.sigsOut.smDoneIn.head)
      val b1046_chain_read_1: Bool = b1046_chain.read(1).apply(0)
      val b1046_chain_read_2: Bool = b1046_chain.read(2).apply(0)
      val b1046_chain_read_3: Bool = b1046_chain.read(3).apply(0)
      val b1046_chain_read_4: Bool = b1046_chain.read(4).apply(0)
      val b1046_chain_read_5: Bool = b1046_chain.read(5).apply(0)
      val b1046_chain_read_6: Bool = b1046_chain.read(6).apply(0)
      val b1046_chain_read_7: Bool = b1046_chain.read(7).apply(0)
      val b1047 = ~io.sigsIn.cchainOutputs.head.oobs(1); b1047.suggestName("b1047")
      val b1047_chain = Module(new RegChainPass(8, 1, myName = "b1047_chain")); b1047_chain.io <> DontCare
      b1047_chain.chain_pass(b1047, io.sigsOut.smDoneIn.head)
      val b1047_chain_read_1: Bool = b1047_chain.read(1).apply(0)
      val b1047_chain_read_2: Bool = b1047_chain.read(2).apply(0)
      val b1047_chain_read_3: Bool = b1047_chain.read(3).apply(0)
      val b1047_chain_read_4: Bool = b1047_chain.read(4).apply(0)
      val b1047_chain_read_5: Bool = b1047_chain.read(5).apply(0)
      val b1047_chain_read_6: Bool = b1047_chain.read(6).apply(0)
      val b1047_chain_read_7: Bool = b1047_chain.read(7).apply(0)
      val x1049_tmp_0 = (new x1049_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1050_tmp_1 = (new x1050_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1051_tmp_2 = (new x1051_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1052_tmp_3 = (new x1052_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1053_tmp_4 = (new x1053_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1054_tmp_0 = (new x1054_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1055_tmp_1 = (new x1055_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1056_tmp_2 = (new x1056_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1057_tmp_3 = (new x1057_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1058_tmp_4 = (new x1058_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1059_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1060_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1061_ctrchain = (new CChainObject(List[CtrObject](x1059_ctr), "x1061_ctrchain")).cchain.io 
      x1061_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1061_ctrchain_p", (x1061_ctrchain.par, x1061_ctrchain.widths))
      val x1062_ctrchain = (new CChainObject(List[CtrObject](x1060_ctr), "x1062_ctrchain")).cchain.io 
      x1062_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1062_ctrchain_p", (x1062_ctrchain.par, x1062_ctrchain.widths))
      val x1105 = new x1105_kernel(List(b1046,b559,b1047), List(b1043,b1044,b549), List(x1061_ctrchain,x1062_ctrchain), List(x472_A_sram_1,x471_A_sram_0), List(x1055_tmp_1,x1051_tmp_2,x1057_tmp_3,x1050_tmp_1,x1054_tmp_0,x1058_tmp_4,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3,x1056_tmp_2) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1105.sm.io.ctrDone := risingEdge(x1105.sm.io.ctrInc)
      b1043_chain.connectStageCtrl((x1105.done).DS(1.toInt, rr, x1105.sm.io.backpressure), x1105.baseEn, 0)
      b1044_chain.connectStageCtrl((x1105.done).DS(1.toInt, rr, x1105.sm.io.backpressure), x1105.baseEn, 0)
      b1046_chain.connectStageCtrl((x1105.done).DS(1.toInt, rr, x1105.sm.io.backpressure), x1105.baseEn, 0)
      b1047_chain.connectStageCtrl((x1105.done).DS(1.toInt, rr, x1105.sm.io.backpressure), x1105.baseEn, 0)
      x1105.backpressure := true.B | x1105.sm.io.doneLatch
      x1105.forwardpressure := (true.B) && (true.B) | x1105.sm.io.doneLatch
      x1105.sm.io.enableOut.zip(x1105.smEnableOuts).foreach{case (l,r) => r := l}
      x1105.sm.io.break := false.B
      x1105.mask := true.B & b559
      x1105.configure("x1105", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1105.kernel()
      val x1106_r_0 = (new x1106_r_0).m.io.asInstanceOf[NBufInterface]
      val x1107_r_0 = (new x1107_r_0).m.io.asInstanceOf[NBufInterface]
      val x1134 = new x1134_kernel(List(b1046_chain_read_1,b559,b1047_chain_read_1), List(x1055_tmp_1,x1051_tmp_2,x1057_tmp_3,x1106_r_0,x1050_tmp_1,x1054_tmp_0,x1058_tmp_4,x1107_r_0,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3,x1056_tmp_2) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1134.sm.io.ctrDone := risingEdge(x1134.sm.io.ctrInc)
      b1043_chain.connectStageCtrl((x1134.done).DS(1.toInt, rr, x1134.sm.io.backpressure), x1134.baseEn, 1)
      b1044_chain.connectStageCtrl((x1134.done).DS(1.toInt, rr, x1134.sm.io.backpressure), x1134.baseEn, 1)
      b1046_chain.connectStageCtrl((x1134.done).DS(1.toInt, rr, x1134.sm.io.backpressure), x1134.baseEn, 1)
      b1047_chain.connectStageCtrl((x1134.done).DS(1.toInt, rr, x1134.sm.io.backpressure), x1134.baseEn, 1)
      x1134.backpressure := true.B | x1134.sm.io.doneLatch
      x1134.forwardpressure := (true.B) && (true.B) | x1134.sm.io.doneLatch
      x1134.sm.io.enableOut.zip(x1134.smEnableOuts).foreach{case (l,r) => r := l}
      x1134.sm.io.break := false.B
      x1134.mask := true.B & b559
      x1134.configure("x1134", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1134.kernel()
      val x1135_force_0 = (new x1135_force_0).m.io.asInstanceOf[NBufInterface]
      val x1136_force_0 = (new x1136_force_0).m.io.asInstanceOf[NBufInterface]
      val x1137_reg = (new x1137_reg).m.io.asInstanceOf[NBufInterface]
      val x1138_reg = (new x1138_reg).m.io.asInstanceOf[NBufInterface]
      val x1139_reg = (new x1139_reg).m.io.asInstanceOf[NBufInterface]
      val x1140_reg = (new x1140_reg).m.io.asInstanceOf[NBufInterface]
      val x1159 = new x1159_kernel(List(b1046_chain_read_2,b559,b1047_chain_read_2), List(x1137_reg,x1055_tmp_1,x1051_tmp_2,x1057_tmp_3,x1106_r_0,x1138_reg,x1050_tmp_1,x1054_tmp_0,x1139_reg,x1058_tmp_4,x1107_r_0,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3,x1140_reg,x1056_tmp_2) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1159.sm.io.ctrDone := risingEdge(x1159.sm.io.ctrInc)
      b1043_chain.connectStageCtrl((x1159.done).DS(1.toInt, rr, x1159.sm.io.backpressure), x1159.baseEn, 2)
      b1044_chain.connectStageCtrl((x1159.done).DS(1.toInt, rr, x1159.sm.io.backpressure), x1159.baseEn, 2)
      b1046_chain.connectStageCtrl((x1159.done).DS(1.toInt, rr, x1159.sm.io.backpressure), x1159.baseEn, 2)
      b1047_chain.connectStageCtrl((x1159.done).DS(1.toInt, rr, x1159.sm.io.backpressure), x1159.baseEn, 2)
      x1159.backpressure := true.B | x1159.sm.io.doneLatch
      x1159.forwardpressure := (true.B) && (true.B) | x1159.sm.io.doneLatch
      x1159.sm.io.enableOut.zip(x1159.smEnableOuts).foreach{case (l,r) => r := l}
      x1159.sm.io.break := false.B
      x1159.mask := true.B & b559
      x1159.configure("x1159", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1159.kernel()
      val x2935_rd_x1137 = Wire(Bool()).suggestName("""x2935_rd_x1137""")
      val x2935_rd_x1137_banks = List[UInt]()
      val x2935_rd_x1137_ofs = List[UInt]()
      val x2935_rd_x1137_en = List[Bool](true.B)
      val x2935_rd_x1137_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2935_rd_x1137_shared_en")
      x2935_rd_x1137.toSeq.zip(x1137_reg.connectRPort(2935, x2935_rd_x1137_banks, x2935_rd_x1137_ofs, io.sigsIn.backpressure, x2935_rd_x1137_en.map(_ && x2935_rd_x1137_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2936_rd_x1139 = Wire(Bool()).suggestName("""x2936_rd_x1139""")
      val x2936_rd_x1139_banks = List[UInt]()
      val x2936_rd_x1139_ofs = List[UInt]()
      val x2936_rd_x1139_en = List[Bool](true.B)
      val x2936_rd_x1139_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2936_rd_x1139_shared_en")
      x2936_rd_x1139.toSeq.zip(x1139_reg.connectRPort(2936, x2936_rd_x1139_banks, x2936_rd_x1139_ofs, io.sigsIn.backpressure, x2936_rd_x1139_en.map(_ && x2936_rd_x1139_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1177_inr_Switch_obj = new x1177_inr_Switch_kernel(List(x2936_rd_x1139,x2935_rd_x1137), List(x1137_reg,x1055_tmp_1,x1051_tmp_2,x1057_tmp_3,x1106_r_0,x1138_reg,x1050_tmp_1,x1054_tmp_0,x1139_reg,x1058_tmp_4,x1107_r_0,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3,x1140_reg,x1056_tmp_2) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1177_inr_Switch_obj.sm.io.selectsIn(0) := x2935_rd_x1137
      x1177_inr_Switch_obj.sm.io.selectsIn(1) := x2936_rd_x1139
      b1043_chain.connectStageCtrl((x1177_inr_Switch_obj.done).DS(1.toInt, rr, x1177_inr_Switch_obj.sm.io.backpressure), x1177_inr_Switch_obj.baseEn, 3)
      b1044_chain.connectStageCtrl((x1177_inr_Switch_obj.done).DS(1.toInt, rr, x1177_inr_Switch_obj.sm.io.backpressure), x1177_inr_Switch_obj.baseEn, 3)
      b1046_chain.connectStageCtrl((x1177_inr_Switch_obj.done).DS(1.toInt, rr, x1177_inr_Switch_obj.sm.io.backpressure), x1177_inr_Switch_obj.baseEn, 3)
      b1047_chain.connectStageCtrl((x1177_inr_Switch_obj.done).DS(1.toInt, rr, x1177_inr_Switch_obj.sm.io.backpressure), x1177_inr_Switch_obj.baseEn, 3)
      x1177_inr_Switch_obj.backpressure := true.B | x1177_inr_Switch_obj.sm.io.doneLatch
      x1177_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x1177_inr_Switch_obj.sm.io.doneLatch
      x1177_inr_Switch_obj.sm.io.enableOut.zip(x1177_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1177_inr_Switch_obj.sm.io.break := false.B
      val x1177_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1177_inr_Switch""")
      x1177_inr_Switch_obj.mask := true.B & true.B
      x1177_inr_Switch_obj.configure("x1177_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1177_inr_Switch.r := x1177_inr_Switch_obj.kernel().r
      val x2937_rd_x1138 = Wire(Bool()).suggestName("""x2937_rd_x1138""")
      val x2937_rd_x1138_banks = List[UInt]()
      val x2937_rd_x1138_ofs = List[UInt]()
      val x2937_rd_x1138_en = List[Bool](true.B)
      val x2937_rd_x1138_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2937_rd_x1138_shared_en")
      x2937_rd_x1138.toSeq.zip(x1138_reg.connectRPort(2937, x2937_rd_x1138_banks, x2937_rd_x1138_ofs, io.sigsIn.backpressure, x2937_rd_x1138_en.map(_ && x2937_rd_x1138_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2938_rd_x1140 = Wire(Bool()).suggestName("""x2938_rd_x1140""")
      val x2938_rd_x1140_banks = List[UInt]()
      val x2938_rd_x1140_ofs = List[UInt]()
      val x2938_rd_x1140_en = List[Bool](true.B)
      val x2938_rd_x1140_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2938_rd_x1140_shared_en")
      x2938_rd_x1140.toSeq.zip(x1140_reg.connectRPort(2938, x2938_rd_x1140_banks, x2938_rd_x1140_ofs, io.sigsIn.backpressure, x2938_rd_x1140_en.map(_ && x2938_rd_x1140_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1191_inr_Switch_obj = new x1191_inr_Switch_kernel(List(x2937_rd_x1138,x2938_rd_x1140), List(x1055_tmp_1,x1051_tmp_2,x1057_tmp_3,x1138_reg,x1050_tmp_1,x1054_tmp_0,x1058_tmp_4,x1107_r_0,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3,x1140_reg,x1056_tmp_2) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1191_inr_Switch_obj.sm.io.selectsIn(0) := x2937_rd_x1138
      x1191_inr_Switch_obj.sm.io.selectsIn(1) := x2938_rd_x1140
      b1043_chain.connectStageCtrl((x1191_inr_Switch_obj.done).DS(1.toInt, rr, x1191_inr_Switch_obj.sm.io.backpressure), x1191_inr_Switch_obj.baseEn, 4)
      b1044_chain.connectStageCtrl((x1191_inr_Switch_obj.done).DS(1.toInt, rr, x1191_inr_Switch_obj.sm.io.backpressure), x1191_inr_Switch_obj.baseEn, 4)
      b1046_chain.connectStageCtrl((x1191_inr_Switch_obj.done).DS(1.toInt, rr, x1191_inr_Switch_obj.sm.io.backpressure), x1191_inr_Switch_obj.baseEn, 4)
      b1047_chain.connectStageCtrl((x1191_inr_Switch_obj.done).DS(1.toInt, rr, x1191_inr_Switch_obj.sm.io.backpressure), x1191_inr_Switch_obj.baseEn, 4)
      x1191_inr_Switch_obj.backpressure := true.B | x1191_inr_Switch_obj.sm.io.doneLatch
      x1191_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x1191_inr_Switch_obj.sm.io.doneLatch
      x1191_inr_Switch_obj.sm.io.enableOut.zip(x1191_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1191_inr_Switch_obj.sm.io.break := false.B
      val x1191_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1191_inr_Switch""")
      x1191_inr_Switch_obj.mask := true.B & true.B
      x1191_inr_Switch_obj.configure("x1191_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1191_inr_Switch.r := x1191_inr_Switch_obj.kernel().r
      val x1196 = new x1196_kernel(List(b1046_chain_read_5,b559,b1047_chain_read_5), List(x1191_inr_Switch,x1177_inr_Switch), List(x1055_tmp_1,x1136_force_0,x1051_tmp_2,x1057_tmp_3,x1050_tmp_1,x1054_tmp_0,x1135_force_0,x1058_tmp_4,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3,x1056_tmp_2) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1196.sm.io.ctrDone := risingEdge(x1196.sm.io.ctrInc)
      b1043_chain.connectStageCtrl((x1196.done).DS(1.toInt, rr, x1196.sm.io.backpressure), x1196.baseEn, 5)
      b1044_chain.connectStageCtrl((x1196.done).DS(1.toInt, rr, x1196.sm.io.backpressure), x1196.baseEn, 5)
      b1046_chain.connectStageCtrl((x1196.done).DS(1.toInt, rr, x1196.sm.io.backpressure), x1196.baseEn, 5)
      b1047_chain.connectStageCtrl((x1196.done).DS(1.toInt, rr, x1196.sm.io.backpressure), x1196.baseEn, 5)
      x1196.backpressure := true.B | x1196.sm.io.doneLatch
      x1196.forwardpressure := (true.B) && (true.B) | x1196.sm.io.doneLatch
      x1196.sm.io.enableOut.zip(x1196.smEnableOuts).foreach{case (l,r) => r := l}
      x1196.sm.io.break := false.B
      x1196.mask := true.B & b559
      x1196.configure("x1196", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1196.kernel()
      val x1197_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1198_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1199_ctrchain = (new CChainObject(List[CtrObject](x1197_ctr), "x1199_ctrchain")).cchain.io 
      x1199_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1199_ctrchain_p", (x1199_ctrchain.par, x1199_ctrchain.widths))
      val x1200_ctrchain = (new CChainObject(List[CtrObject](x1198_ctr), "x1200_ctrchain")).cchain.io 
      x1200_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1200_ctrchain_p", (x1200_ctrchain.par, x1200_ctrchain.widths))
      val x1229 = new x1229_kernel(List(b1046_chain_read_6,b559,b1047_chain_read_6), List(x1200_ctrchain,x1199_ctrchain), List(x1055_tmp_1,x1136_force_0,x1051_tmp_2,x1057_tmp_3,x1050_tmp_1,x1054_tmp_0,x1135_force_0,x1058_tmp_4,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3,x1056_tmp_2) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1229.sm.io.ctrDone := risingEdge(x1229.sm.io.ctrInc)
      b1043_chain.connectStageCtrl((x1229.done).DS(1.toInt, rr, x1229.sm.io.backpressure), x1229.baseEn, 6)
      b1044_chain.connectStageCtrl((x1229.done).DS(1.toInt, rr, x1229.sm.io.backpressure), x1229.baseEn, 6)
      b1046_chain.connectStageCtrl((x1229.done).DS(1.toInt, rr, x1229.sm.io.backpressure), x1229.baseEn, 6)
      b1047_chain.connectStageCtrl((x1229.done).DS(1.toInt, rr, x1229.sm.io.backpressure), x1229.baseEn, 6)
      x1229.backpressure := true.B | x1229.sm.io.doneLatch
      x1229.forwardpressure := (true.B) && (true.B) | x1229.sm.io.doneLatch
      x1229.sm.io.enableOut.zip(x1229.smEnableOuts).foreach{case (l,r) => r := l}
      x1229.sm.io.break := false.B
      x1229.mask := true.B & b559
      x1229.configure("x1229", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1229.kernel()
      val x1249_inr_Foreach = new x1249_inr_Foreach_kernel(List(b559,b1047_chain_read_7), List(b1043_chain_read_7), List(x571_accum_0), List(x572_accum_1,x1058_tmp_4,x1053_tmp_4) ,  Some(me), List(x619_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1249_inr_Foreach.sm.io.ctrDone := (x1249_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b1043_chain.connectStageCtrl((x1249_inr_Foreach.done).DS(1.toInt, rr, x1249_inr_Foreach.sm.io.backpressure), x1249_inr_Foreach.baseEn, 7)
      b1044_chain.connectStageCtrl((x1249_inr_Foreach.done).DS(1.toInt, rr, x1249_inr_Foreach.sm.io.backpressure), x1249_inr_Foreach.baseEn, 7)
      b1046_chain.connectStageCtrl((x1249_inr_Foreach.done).DS(1.toInt, rr, x1249_inr_Foreach.sm.io.backpressure), x1249_inr_Foreach.baseEn, 7)
      b1047_chain.connectStageCtrl((x1249_inr_Foreach.done).DS(1.toInt, rr, x1249_inr_Foreach.sm.io.backpressure), x1249_inr_Foreach.baseEn, 7)
      x1249_inr_Foreach.backpressure := true.B | x1249_inr_Foreach.sm.io.doneLatch
      x1249_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1249_inr_Foreach.sm.io.doneLatch
      x1249_inr_Foreach.sm.io.enableOut.zip(x1249_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1249_inr_Foreach.sm.io.break := false.B
      x1249_inr_Foreach.mask := ~x1249_inr_Foreach.cchain.head.output.noop & true.B
      x1249_inr_Foreach.configure("x1249_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1249_inr_Foreach.kernel()
    }
    val module = Module(new x1250_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x1250_outr_Reduce **/
