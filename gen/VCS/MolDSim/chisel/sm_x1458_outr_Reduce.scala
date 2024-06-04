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

/** Hierarchy: x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1458_outr_Reduce **/
class x1458_outr_Reduce_kernel(
  list_x574_accum_1: List[NBufInterface],
  list_b560: List[Bool],
  list_x620_ctrchain: List[CounterChainInterface],
  list_x472_A_sram_1: List[StandardInterface],
  list_b550: List[FixedPoint],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x1458_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1458_outr_Reduce_iiCtr"))
  
  abstract class x1458_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x574_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x574_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x573_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x573_accum_0_p").asInstanceOf[MemParams] ))
      val in_x620_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x620_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def b550 = {io.in_b550} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x574_accum_1 = {io.in_x574_accum_1} ; io.in_x574_accum_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x573_accum_0 = {io.in_x573_accum_0} ; io.in_x573_accum_0 := DontCare
    def x620_ctrchain = {io.in_x620_ctrchain} ; io.in_x620_ctrchain := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1458_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b550 <> b550
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x574_accum_1.connectLedger(module.io.in_x574_accum_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x573_accum_0.connectLedger(module.io.in_x573_accum_0)
    module.io.in_x620_ctrchain.input <> x620_ctrchain.input; module.io.in_x620_ctrchain.output <> x620_ctrchain.output
    module.io.in_b560 <> b560
  }
  val x574_accum_1 = list_x574_accum_1(0)
  val b560 = list_b560(0)
  val x620_ctrchain = list_x620_ctrchain(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x573_accum_0 = list_x472_A_sram_1(2)
  val b550 = list_b550(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1458_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x1458_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1458_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1458_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x1458_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x1458_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x1458_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1458_instrctr, cycles_x1458_outr_Reduce.io.count, iters_x1458_outr_Reduce.io.count, 0.U, 0.U)
      val b1251 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1251.suggestName("b1251")
      val b1251_chain = Module(new RegChainPass(8, 32, myName = "b1251_chain")); b1251_chain.io <> DontCare
      b1251_chain.chain_pass(b1251, io.sigsOut.smDoneIn.head)
      val b1251_chain_read_1 = b1251_chain.read(1).FP(true,32,0)
      val b1251_chain_read_2 = b1251_chain.read(2).FP(true,32,0)
      val b1251_chain_read_3 = b1251_chain.read(3).FP(true,32,0)
      val b1251_chain_read_4 = b1251_chain.read(4).FP(true,32,0)
      val b1251_chain_read_5 = b1251_chain.read(5).FP(true,32,0)
      val b1251_chain_read_6 = b1251_chain.read(6).FP(true,32,0)
      val b1251_chain_read_7 = b1251_chain.read(7).FP(true,32,0)
      val b1252 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b1252.suggestName("b1252")
      val b1252_chain = Module(new RegChainPass(8, 32, myName = "b1252_chain")); b1252_chain.io <> DontCare
      b1252_chain.chain_pass(b1252, io.sigsOut.smDoneIn.head)
      val b1252_chain_read_1 = b1252_chain.read(1).FP(true,32,0)
      val b1252_chain_read_2 = b1252_chain.read(2).FP(true,32,0)
      val b1252_chain_read_3 = b1252_chain.read(3).FP(true,32,0)
      val b1252_chain_read_4 = b1252_chain.read(4).FP(true,32,0)
      val b1252_chain_read_5 = b1252_chain.read(5).FP(true,32,0)
      val b1252_chain_read_6 = b1252_chain.read(6).FP(true,32,0)
      val b1252_chain_read_7 = b1252_chain.read(7).FP(true,32,0)
      val b1254 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1254.suggestName("b1254")
      val b1254_chain = Module(new RegChainPass(8, 1, myName = "b1254_chain")); b1254_chain.io <> DontCare
      b1254_chain.chain_pass(b1254, io.sigsOut.smDoneIn.head)
      val b1254_chain_read_1: Bool = b1254_chain.read(1).apply(0)
      val b1254_chain_read_2: Bool = b1254_chain.read(2).apply(0)
      val b1254_chain_read_3: Bool = b1254_chain.read(3).apply(0)
      val b1254_chain_read_4: Bool = b1254_chain.read(4).apply(0)
      val b1254_chain_read_5: Bool = b1254_chain.read(5).apply(0)
      val b1254_chain_read_6: Bool = b1254_chain.read(6).apply(0)
      val b1254_chain_read_7: Bool = b1254_chain.read(7).apply(0)
      val b1255 = ~io.sigsIn.cchainOutputs.head.oobs(1); b1255.suggestName("b1255")
      val b1255_chain = Module(new RegChainPass(8, 1, myName = "b1255_chain")); b1255_chain.io <> DontCare
      b1255_chain.chain_pass(b1255, io.sigsOut.smDoneIn.head)
      val b1255_chain_read_1: Bool = b1255_chain.read(1).apply(0)
      val b1255_chain_read_2: Bool = b1255_chain.read(2).apply(0)
      val b1255_chain_read_3: Bool = b1255_chain.read(3).apply(0)
      val b1255_chain_read_4: Bool = b1255_chain.read(4).apply(0)
      val b1255_chain_read_5: Bool = b1255_chain.read(5).apply(0)
      val b1255_chain_read_6: Bool = b1255_chain.read(6).apply(0)
      val b1255_chain_read_7: Bool = b1255_chain.read(7).apply(0)
      val x1257_tmp_0 = (new x1257_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1258_tmp_1 = (new x1258_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1259_tmp_2 = (new x1259_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1260_tmp_3 = (new x1260_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1261_tmp_4 = (new x1261_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1262_tmp_0 = (new x1262_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1263_tmp_1 = (new x1263_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1264_tmp_2 = (new x1264_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1265_tmp_3 = (new x1265_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1266_tmp_4 = (new x1266_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1267_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1268_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1269_ctrchain = (new CChainObject(List[CtrObject](x1267_ctr), "x1269_ctrchain")).cchain.io 
      x1269_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1269_ctrchain_p", (x1269_ctrchain.par, x1269_ctrchain.widths))
      val x1270_ctrchain = (new CChainObject(List[CtrObject](x1268_ctr), "x1270_ctrchain")).cchain.io 
      x1270_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1270_ctrchain_p", (x1270_ctrchain.par, x1270_ctrchain.widths))
      val x1313 = new x1313_kernel(List(b1254,b1255,b560), List(x1260_tmp_3,x1265_tmp_3,x1264_tmp_2,x1259_tmp_2,x1263_tmp_1,x1266_tmp_4,x1258_tmp_1,x1262_tmp_0,x1257_tmp_0,x1261_tmp_4), List(x472_A_sram_1,x471_A_sram_0), List(x1269_ctrchain,x1270_ctrchain), List(b550,b1251,b1252) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1313.sm.io.ctrDone := risingEdge(x1313.sm.io.ctrInc)
      b1251_chain.connectStageCtrl((x1313.done).DS(1.toInt, rr, x1313.sm.io.backpressure), x1313.baseEn, 0)
      b1252_chain.connectStageCtrl((x1313.done).DS(1.toInt, rr, x1313.sm.io.backpressure), x1313.baseEn, 0)
      b1254_chain.connectStageCtrl((x1313.done).DS(1.toInt, rr, x1313.sm.io.backpressure), x1313.baseEn, 0)
      b1255_chain.connectStageCtrl((x1313.done).DS(1.toInt, rr, x1313.sm.io.backpressure), x1313.baseEn, 0)
      x1313.backpressure := true.B | x1313.sm.io.doneLatch
      x1313.forwardpressure := (true.B) && (true.B) | x1313.sm.io.doneLatch
      x1313.sm.io.enableOut.zip(x1313.smEnableOuts).foreach{case (l,r) => r := l}
      x1313.sm.io.break := false.B
      x1313.mask := true.B & b560
      x1313.configure("x1313", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1313.kernel()
      val x1314_r_0 = (new x1314_r_0).m.io.asInstanceOf[NBufInterface]
      val x1315_r_0 = (new x1315_r_0).m.io.asInstanceOf[NBufInterface]
      val x1342 = new x1342_kernel(List(b1254_chain_read_1,b1255_chain_read_1,b560), List(x1315_r_0,x1260_tmp_3,x1265_tmp_3,x1264_tmp_2,x1259_tmp_2,x1263_tmp_1,x1266_tmp_4,x1258_tmp_1,x1262_tmp_0,x1257_tmp_0,x1314_r_0,x1261_tmp_4) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1342.sm.io.ctrDone := risingEdge(x1342.sm.io.ctrInc)
      b1251_chain.connectStageCtrl((x1342.done).DS(1.toInt, rr, x1342.sm.io.backpressure), x1342.baseEn, 1)
      b1252_chain.connectStageCtrl((x1342.done).DS(1.toInt, rr, x1342.sm.io.backpressure), x1342.baseEn, 1)
      b1254_chain.connectStageCtrl((x1342.done).DS(1.toInt, rr, x1342.sm.io.backpressure), x1342.baseEn, 1)
      b1255_chain.connectStageCtrl((x1342.done).DS(1.toInt, rr, x1342.sm.io.backpressure), x1342.baseEn, 1)
      x1342.backpressure := true.B | x1342.sm.io.doneLatch
      x1342.forwardpressure := (true.B) && (true.B) | x1342.sm.io.doneLatch
      x1342.sm.io.enableOut.zip(x1342.smEnableOuts).foreach{case (l,r) => r := l}
      x1342.sm.io.break := false.B
      x1342.mask := true.B & b560
      x1342.configure("x1342", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1342.kernel()
      val x1343_force_0 = (new x1343_force_0).m.io.asInstanceOf[NBufInterface]
      val x1344_force_0 = (new x1344_force_0).m.io.asInstanceOf[NBufInterface]
      val x1345_reg = (new x1345_reg).m.io.asInstanceOf[NBufInterface]
      val x1346_reg = (new x1346_reg).m.io.asInstanceOf[NBufInterface]
      val x1347_reg = (new x1347_reg).m.io.asInstanceOf[NBufInterface]
      val x1348_reg = (new x1348_reg).m.io.asInstanceOf[NBufInterface]
      val x1367 = new x1367_kernel(List(b1254_chain_read_2,b1255_chain_read_2,b560), List(x1315_r_0,x1260_tmp_3,x1265_tmp_3,x1264_tmp_2,x1347_reg,x1345_reg,x1259_tmp_2,x1263_tmp_1,x1266_tmp_4,x1258_tmp_1,x1262_tmp_0,x1257_tmp_0,x1348_reg,x1314_r_0,x1346_reg,x1261_tmp_4) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1367.sm.io.ctrDone := risingEdge(x1367.sm.io.ctrInc)
      b1251_chain.connectStageCtrl((x1367.done).DS(1.toInt, rr, x1367.sm.io.backpressure), x1367.baseEn, 2)
      b1252_chain.connectStageCtrl((x1367.done).DS(1.toInt, rr, x1367.sm.io.backpressure), x1367.baseEn, 2)
      b1254_chain.connectStageCtrl((x1367.done).DS(1.toInt, rr, x1367.sm.io.backpressure), x1367.baseEn, 2)
      b1255_chain.connectStageCtrl((x1367.done).DS(1.toInt, rr, x1367.sm.io.backpressure), x1367.baseEn, 2)
      x1367.backpressure := true.B | x1367.sm.io.doneLatch
      x1367.forwardpressure := (true.B) && (true.B) | x1367.sm.io.doneLatch
      x1367.sm.io.enableOut.zip(x1367.smEnableOuts).foreach{case (l,r) => r := l}
      x1367.sm.io.break := false.B
      x1367.mask := true.B & b560
      x1367.configure("x1367", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1367.kernel()
      val x2939_rd_x1345 = Wire(Bool()).suggestName("""x2939_rd_x1345""")
      val x2939_rd_x1345_banks = List[UInt]()
      val x2939_rd_x1345_ofs = List[UInt]()
      val x2939_rd_x1345_en = List[Bool](true.B)
      val x2939_rd_x1345_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2939_rd_x1345_shared_en")
      x2939_rd_x1345.toSeq.zip(x1345_reg.connectRPort(2939, x2939_rd_x1345_banks, x2939_rd_x1345_ofs, io.sigsIn.backpressure, x2939_rd_x1345_en.map(_ && x2939_rd_x1345_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2940_rd_x1347 = Wire(Bool()).suggestName("""x2940_rd_x1347""")
      val x2940_rd_x1347_banks = List[UInt]()
      val x2940_rd_x1347_ofs = List[UInt]()
      val x2940_rd_x1347_en = List[Bool](true.B)
      val x2940_rd_x1347_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2940_rd_x1347_shared_en")
      x2940_rd_x1347.toSeq.zip(x1347_reg.connectRPort(2940, x2940_rd_x1347_banks, x2940_rd_x1347_ofs, io.sigsIn.backpressure, x2940_rd_x1347_en.map(_ && x2940_rd_x1347_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1385_inr_Switch_obj = new x1385_inr_Switch_kernel(List(x2940_rd_x1347,x2939_rd_x1345), List(x1315_r_0,x1260_tmp_3,x1265_tmp_3,x1264_tmp_2,x1347_reg,x1345_reg,x1259_tmp_2,x1263_tmp_1,x1266_tmp_4,x1258_tmp_1,x1262_tmp_0,x1257_tmp_0,x1348_reg,x1314_r_0,x1346_reg,x1261_tmp_4) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1385_inr_Switch_obj.sm.io.selectsIn(0) := x2939_rd_x1345
      x1385_inr_Switch_obj.sm.io.selectsIn(1) := x2940_rd_x1347
      b1251_chain.connectStageCtrl((x1385_inr_Switch_obj.done).DS(1.toInt, rr, x1385_inr_Switch_obj.sm.io.backpressure), x1385_inr_Switch_obj.baseEn, 3)
      b1252_chain.connectStageCtrl((x1385_inr_Switch_obj.done).DS(1.toInt, rr, x1385_inr_Switch_obj.sm.io.backpressure), x1385_inr_Switch_obj.baseEn, 3)
      b1254_chain.connectStageCtrl((x1385_inr_Switch_obj.done).DS(1.toInt, rr, x1385_inr_Switch_obj.sm.io.backpressure), x1385_inr_Switch_obj.baseEn, 3)
      b1255_chain.connectStageCtrl((x1385_inr_Switch_obj.done).DS(1.toInt, rr, x1385_inr_Switch_obj.sm.io.backpressure), x1385_inr_Switch_obj.baseEn, 3)
      x1385_inr_Switch_obj.backpressure := true.B | x1385_inr_Switch_obj.sm.io.doneLatch
      x1385_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x1385_inr_Switch_obj.sm.io.doneLatch
      x1385_inr_Switch_obj.sm.io.enableOut.zip(x1385_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1385_inr_Switch_obj.sm.io.break := false.B
      val x1385_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1385_inr_Switch""")
      x1385_inr_Switch_obj.mask := true.B & true.B
      x1385_inr_Switch_obj.configure("x1385_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1385_inr_Switch.r := x1385_inr_Switch_obj.kernel().r
      val x2941_rd_x1346 = Wire(Bool()).suggestName("""x2941_rd_x1346""")
      val x2941_rd_x1346_banks = List[UInt]()
      val x2941_rd_x1346_ofs = List[UInt]()
      val x2941_rd_x1346_en = List[Bool](true.B)
      val x2941_rd_x1346_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2941_rd_x1346_shared_en")
      x2941_rd_x1346.toSeq.zip(x1346_reg.connectRPort(2941, x2941_rd_x1346_banks, x2941_rd_x1346_ofs, io.sigsIn.backpressure, x2941_rd_x1346_en.map(_ && x2941_rd_x1346_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2942_rd_x1348 = Wire(Bool()).suggestName("""x2942_rd_x1348""")
      val x2942_rd_x1348_banks = List[UInt]()
      val x2942_rd_x1348_ofs = List[UInt]()
      val x2942_rd_x1348_en = List[Bool](true.B)
      val x2942_rd_x1348_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2942_rd_x1348_shared_en")
      x2942_rd_x1348.toSeq.zip(x1348_reg.connectRPort(2942, x2942_rd_x1348_banks, x2942_rd_x1348_ofs, io.sigsIn.backpressure, x2942_rd_x1348_en.map(_ && x2942_rd_x1348_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1399_inr_Switch_obj = new x1399_inr_Switch_kernel(List(x2941_rd_x1346,x2942_rd_x1348), List(x1315_r_0,x1260_tmp_3,x1265_tmp_3,x1264_tmp_2,x1259_tmp_2,x1263_tmp_1,x1266_tmp_4,x1258_tmp_1,x1262_tmp_0,x1257_tmp_0,x1348_reg,x1346_reg,x1261_tmp_4) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1399_inr_Switch_obj.sm.io.selectsIn(0) := x2941_rd_x1346
      x1399_inr_Switch_obj.sm.io.selectsIn(1) := x2942_rd_x1348
      b1251_chain.connectStageCtrl((x1399_inr_Switch_obj.done).DS(1.toInt, rr, x1399_inr_Switch_obj.sm.io.backpressure), x1399_inr_Switch_obj.baseEn, 4)
      b1252_chain.connectStageCtrl((x1399_inr_Switch_obj.done).DS(1.toInt, rr, x1399_inr_Switch_obj.sm.io.backpressure), x1399_inr_Switch_obj.baseEn, 4)
      b1254_chain.connectStageCtrl((x1399_inr_Switch_obj.done).DS(1.toInt, rr, x1399_inr_Switch_obj.sm.io.backpressure), x1399_inr_Switch_obj.baseEn, 4)
      b1255_chain.connectStageCtrl((x1399_inr_Switch_obj.done).DS(1.toInt, rr, x1399_inr_Switch_obj.sm.io.backpressure), x1399_inr_Switch_obj.baseEn, 4)
      x1399_inr_Switch_obj.backpressure := true.B | x1399_inr_Switch_obj.sm.io.doneLatch
      x1399_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x1399_inr_Switch_obj.sm.io.doneLatch
      x1399_inr_Switch_obj.sm.io.enableOut.zip(x1399_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1399_inr_Switch_obj.sm.io.break := false.B
      val x1399_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1399_inr_Switch""")
      x1399_inr_Switch_obj.mask := true.B & true.B
      x1399_inr_Switch_obj.configure("x1399_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1399_inr_Switch.r := x1399_inr_Switch_obj.kernel().r
      val x1404 = new x1404_kernel(List(b1254_chain_read_5,b1255_chain_read_5,b560), List(x1385_inr_Switch,x1399_inr_Switch), List(x1260_tmp_3,x1265_tmp_3,x1264_tmp_2,x1343_force_0,x1259_tmp_2,x1263_tmp_1,x1266_tmp_4,x1258_tmp_1,x1344_force_0,x1262_tmp_0,x1257_tmp_0,x1261_tmp_4) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1404.sm.io.ctrDone := risingEdge(x1404.sm.io.ctrInc)
      b1251_chain.connectStageCtrl((x1404.done).DS(1.toInt, rr, x1404.sm.io.backpressure), x1404.baseEn, 5)
      b1252_chain.connectStageCtrl((x1404.done).DS(1.toInt, rr, x1404.sm.io.backpressure), x1404.baseEn, 5)
      b1254_chain.connectStageCtrl((x1404.done).DS(1.toInt, rr, x1404.sm.io.backpressure), x1404.baseEn, 5)
      b1255_chain.connectStageCtrl((x1404.done).DS(1.toInt, rr, x1404.sm.io.backpressure), x1404.baseEn, 5)
      x1404.backpressure := true.B | x1404.sm.io.doneLatch
      x1404.forwardpressure := (true.B) && (true.B) | x1404.sm.io.doneLatch
      x1404.sm.io.enableOut.zip(x1404.smEnableOuts).foreach{case (l,r) => r := l}
      x1404.sm.io.break := false.B
      x1404.mask := true.B & b560
      x1404.configure("x1404", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1404.kernel()
      val x1405_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1406_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1407_ctrchain = (new CChainObject(List[CtrObject](x1405_ctr), "x1407_ctrchain")).cchain.io 
      x1407_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1407_ctrchain_p", (x1407_ctrchain.par, x1407_ctrchain.widths))
      val x1408_ctrchain = (new CChainObject(List[CtrObject](x1406_ctr), "x1408_ctrchain")).cchain.io 
      x1408_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1408_ctrchain_p", (x1408_ctrchain.par, x1408_ctrchain.widths))
      val x1437 = new x1437_kernel(List(b1254_chain_read_6,b1255_chain_read_6,b560), List(x1407_ctrchain,x1408_ctrchain), List(x1260_tmp_3,x1265_tmp_3,x1264_tmp_2,x1343_force_0,x1259_tmp_2,x1263_tmp_1,x1266_tmp_4,x1258_tmp_1,x1344_force_0,x1262_tmp_0,x1257_tmp_0,x1261_tmp_4) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1437.sm.io.ctrDone := risingEdge(x1437.sm.io.ctrInc)
      b1251_chain.connectStageCtrl((x1437.done).DS(1.toInt, rr, x1437.sm.io.backpressure), x1437.baseEn, 6)
      b1252_chain.connectStageCtrl((x1437.done).DS(1.toInt, rr, x1437.sm.io.backpressure), x1437.baseEn, 6)
      b1254_chain.connectStageCtrl((x1437.done).DS(1.toInt, rr, x1437.sm.io.backpressure), x1437.baseEn, 6)
      b1255_chain.connectStageCtrl((x1437.done).DS(1.toInt, rr, x1437.sm.io.backpressure), x1437.baseEn, 6)
      x1437.backpressure := true.B | x1437.sm.io.doneLatch
      x1437.forwardpressure := (true.B) && (true.B) | x1437.sm.io.doneLatch
      x1437.sm.io.enableOut.zip(x1437.smEnableOuts).foreach{case (l,r) => r := l}
      x1437.sm.io.break := false.B
      x1437.mask := true.B & b560
      x1437.configure("x1437", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1437.kernel()
      val x1457_inr_Foreach = new x1457_inr_Foreach_kernel(List(b1255_chain_read_7,b560), List(b1251_chain_read_7), List(x573_accum_0), List(x574_accum_1,x1266_tmp_4,x1261_tmp_4) ,  Some(me), List(x620_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1457_inr_Foreach.sm.io.ctrDone := (x1457_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b1251_chain.connectStageCtrl((x1457_inr_Foreach.done).DS(1.toInt, rr, x1457_inr_Foreach.sm.io.backpressure), x1457_inr_Foreach.baseEn, 7)
      b1252_chain.connectStageCtrl((x1457_inr_Foreach.done).DS(1.toInt, rr, x1457_inr_Foreach.sm.io.backpressure), x1457_inr_Foreach.baseEn, 7)
      b1254_chain.connectStageCtrl((x1457_inr_Foreach.done).DS(1.toInt, rr, x1457_inr_Foreach.sm.io.backpressure), x1457_inr_Foreach.baseEn, 7)
      b1255_chain.connectStageCtrl((x1457_inr_Foreach.done).DS(1.toInt, rr, x1457_inr_Foreach.sm.io.backpressure), x1457_inr_Foreach.baseEn, 7)
      x1457_inr_Foreach.backpressure := true.B | x1457_inr_Foreach.sm.io.doneLatch
      x1457_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1457_inr_Foreach.sm.io.doneLatch
      x1457_inr_Foreach.sm.io.enableOut.zip(x1457_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1457_inr_Foreach.sm.io.break := false.B
      x1457_inr_Foreach.mask := ~x1457_inr_Foreach.cchain.head.output.noop & true.B
      x1457_inr_Foreach.configure("x1457_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1457_inr_Foreach.kernel()
    }
    val module = Module(new x1458_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x1458_outr_Reduce **/
