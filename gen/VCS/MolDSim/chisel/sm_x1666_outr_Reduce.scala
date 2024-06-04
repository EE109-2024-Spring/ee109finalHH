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

/** Hierarchy: x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1666_outr_Reduce **/
class x1666_outr_Reduce_kernel(
  list_x621_ctrchain: List[CounterChainInterface],
  list_b561: List[Bool],
  list_b551: List[FixedPoint],
  list_x576_accum_1: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x1666_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1666_outr_Reduce_iiCtr"))
  
  abstract class x1666_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b561 = Input(Bool())
      val in_b551 = Input(new FixedPoint(true, 32, 0))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x621_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x621_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x576_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x576_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x575_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x575_accum_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b561 = {io.in_b561} 
    def b551 = {io.in_b551} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x621_ctrchain = {io.in_x621_ctrchain} ; io.in_x621_ctrchain := DontCare
    def x576_accum_1 = {io.in_x576_accum_1} ; io.in_x576_accum_1 := DontCare
    def x575_accum_0 = {io.in_x575_accum_0} ; io.in_x575_accum_0 := DontCare
  }
  def connectWires0(module: x1666_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b561 <> b561
    module.io.in_b551 <> b551
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_x621_ctrchain.input <> x621_ctrchain.input; module.io.in_x621_ctrchain.output <> x621_ctrchain.output
    x576_accum_1.connectLedger(module.io.in_x576_accum_1)
    x575_accum_0.connectLedger(module.io.in_x575_accum_0)
  }
  val x621_ctrchain = list_x621_ctrchain(0)
  val b561 = list_b561(0)
  val b551 = list_b551(0)
  val x576_accum_1 = list_x576_accum_1(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x575_accum_0 = list_x472_A_sram_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1666_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x1666_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1666_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1666_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x1666_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x1666_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x1666_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1666_instrctr, cycles_x1666_outr_Reduce.io.count, iters_x1666_outr_Reduce.io.count, 0.U, 0.U)
      val b1459 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1459.suggestName("b1459")
      val b1459_chain = Module(new RegChainPass(8, 32, myName = "b1459_chain")); b1459_chain.io <> DontCare
      b1459_chain.chain_pass(b1459, io.sigsOut.smDoneIn.head)
      val b1459_chain_read_1 = b1459_chain.read(1).FP(true,32,0)
      val b1459_chain_read_2 = b1459_chain.read(2).FP(true,32,0)
      val b1459_chain_read_3 = b1459_chain.read(3).FP(true,32,0)
      val b1459_chain_read_4 = b1459_chain.read(4).FP(true,32,0)
      val b1459_chain_read_5 = b1459_chain.read(5).FP(true,32,0)
      val b1459_chain_read_6 = b1459_chain.read(6).FP(true,32,0)
      val b1459_chain_read_7 = b1459_chain.read(7).FP(true,32,0)
      val b1460 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b1460.suggestName("b1460")
      val b1460_chain = Module(new RegChainPass(8, 32, myName = "b1460_chain")); b1460_chain.io <> DontCare
      b1460_chain.chain_pass(b1460, io.sigsOut.smDoneIn.head)
      val b1460_chain_read_1 = b1460_chain.read(1).FP(true,32,0)
      val b1460_chain_read_2 = b1460_chain.read(2).FP(true,32,0)
      val b1460_chain_read_3 = b1460_chain.read(3).FP(true,32,0)
      val b1460_chain_read_4 = b1460_chain.read(4).FP(true,32,0)
      val b1460_chain_read_5 = b1460_chain.read(5).FP(true,32,0)
      val b1460_chain_read_6 = b1460_chain.read(6).FP(true,32,0)
      val b1460_chain_read_7 = b1460_chain.read(7).FP(true,32,0)
      val b1462 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1462.suggestName("b1462")
      val b1462_chain = Module(new RegChainPass(8, 1, myName = "b1462_chain")); b1462_chain.io <> DontCare
      b1462_chain.chain_pass(b1462, io.sigsOut.smDoneIn.head)
      val b1462_chain_read_1: Bool = b1462_chain.read(1).apply(0)
      val b1462_chain_read_2: Bool = b1462_chain.read(2).apply(0)
      val b1462_chain_read_3: Bool = b1462_chain.read(3).apply(0)
      val b1462_chain_read_4: Bool = b1462_chain.read(4).apply(0)
      val b1462_chain_read_5: Bool = b1462_chain.read(5).apply(0)
      val b1462_chain_read_6: Bool = b1462_chain.read(6).apply(0)
      val b1462_chain_read_7: Bool = b1462_chain.read(7).apply(0)
      val b1463 = ~io.sigsIn.cchainOutputs.head.oobs(1); b1463.suggestName("b1463")
      val b1463_chain = Module(new RegChainPass(8, 1, myName = "b1463_chain")); b1463_chain.io <> DontCare
      b1463_chain.chain_pass(b1463, io.sigsOut.smDoneIn.head)
      val b1463_chain_read_1: Bool = b1463_chain.read(1).apply(0)
      val b1463_chain_read_2: Bool = b1463_chain.read(2).apply(0)
      val b1463_chain_read_3: Bool = b1463_chain.read(3).apply(0)
      val b1463_chain_read_4: Bool = b1463_chain.read(4).apply(0)
      val b1463_chain_read_5: Bool = b1463_chain.read(5).apply(0)
      val b1463_chain_read_6: Bool = b1463_chain.read(6).apply(0)
      val b1463_chain_read_7: Bool = b1463_chain.read(7).apply(0)
      val x1465_tmp_0 = (new x1465_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1466_tmp_1 = (new x1466_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1467_tmp_2 = (new x1467_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1468_tmp_3 = (new x1468_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1469_tmp_4 = (new x1469_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1470_tmp_0 = (new x1470_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1471_tmp_1 = (new x1471_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1472_tmp_2 = (new x1472_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1473_tmp_3 = (new x1473_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1474_tmp_4 = (new x1474_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1475_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1476_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1477_ctrchain = (new CChainObject(List[CtrObject](x1475_ctr), "x1477_ctrchain")).cchain.io 
      x1477_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1477_ctrchain_p", (x1477_ctrchain.par, x1477_ctrchain.widths))
      val x1478_ctrchain = (new CChainObject(List[CtrObject](x1476_ctr), "x1478_ctrchain")).cchain.io 
      x1478_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1478_ctrchain_p", (x1478_ctrchain.par, x1478_ctrchain.widths))
      val x1521 = new x1521_kernel(List(x1478_ctrchain,x1477_ctrchain), List(b551,b1460,b1459), List(x1469_tmp_4,x1465_tmp_0,x1470_tmp_0,x1466_tmp_1,x1471_tmp_1,x1474_tmp_4,x1467_tmp_2,x1472_tmp_2,x1473_tmp_3,x1468_tmp_3), List(b1462,b561,b1463), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1521.sm.io.ctrDone := risingEdge(x1521.sm.io.ctrInc)
      b1459_chain.connectStageCtrl((x1521.done).DS(1.toInt, rr, x1521.sm.io.backpressure), x1521.baseEn, 0)
      b1460_chain.connectStageCtrl((x1521.done).DS(1.toInt, rr, x1521.sm.io.backpressure), x1521.baseEn, 0)
      b1462_chain.connectStageCtrl((x1521.done).DS(1.toInt, rr, x1521.sm.io.backpressure), x1521.baseEn, 0)
      b1463_chain.connectStageCtrl((x1521.done).DS(1.toInt, rr, x1521.sm.io.backpressure), x1521.baseEn, 0)
      x1521.backpressure := true.B | x1521.sm.io.doneLatch
      x1521.forwardpressure := (true.B) && (true.B) | x1521.sm.io.doneLatch
      x1521.sm.io.enableOut.zip(x1521.smEnableOuts).foreach{case (l,r) => r := l}
      x1521.sm.io.break := false.B
      x1521.mask := true.B & b561
      x1521.configure("x1521", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1521.kernel()
      val x1522_r_0 = (new x1522_r_0).m.io.asInstanceOf[NBufInterface]
      val x1523_r_0 = (new x1523_r_0).m.io.asInstanceOf[NBufInterface]
      val x1550 = new x1550_kernel(List(b1462_chain_read_1,b561,b1463_chain_read_1), List(x1469_tmp_4,x1522_r_0,x1465_tmp_0,x1470_tmp_0,x1466_tmp_1,x1471_tmp_1,x1474_tmp_4,x1467_tmp_2,x1472_tmp_2,x1523_r_0,x1473_tmp_3,x1468_tmp_3) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1550.sm.io.ctrDone := risingEdge(x1550.sm.io.ctrInc)
      b1459_chain.connectStageCtrl((x1550.done).DS(1.toInt, rr, x1550.sm.io.backpressure), x1550.baseEn, 1)
      b1460_chain.connectStageCtrl((x1550.done).DS(1.toInt, rr, x1550.sm.io.backpressure), x1550.baseEn, 1)
      b1462_chain.connectStageCtrl((x1550.done).DS(1.toInt, rr, x1550.sm.io.backpressure), x1550.baseEn, 1)
      b1463_chain.connectStageCtrl((x1550.done).DS(1.toInt, rr, x1550.sm.io.backpressure), x1550.baseEn, 1)
      x1550.backpressure := true.B | x1550.sm.io.doneLatch
      x1550.forwardpressure := (true.B) && (true.B) | x1550.sm.io.doneLatch
      x1550.sm.io.enableOut.zip(x1550.smEnableOuts).foreach{case (l,r) => r := l}
      x1550.sm.io.break := false.B
      x1550.mask := true.B & b561
      x1550.configure("x1550", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1550.kernel()
      val x1551_force_0 = (new x1551_force_0).m.io.asInstanceOf[NBufInterface]
      val x1552_force_0 = (new x1552_force_0).m.io.asInstanceOf[NBufInterface]
      val x1553_reg = (new x1553_reg).m.io.asInstanceOf[NBufInterface]
      val x1554_reg = (new x1554_reg).m.io.asInstanceOf[NBufInterface]
      val x1555_reg = (new x1555_reg).m.io.asInstanceOf[NBufInterface]
      val x1556_reg = (new x1556_reg).m.io.asInstanceOf[NBufInterface]
      val x1575 = new x1575_kernel(List(b1462_chain_read_2,b561,b1463_chain_read_2), List(x1469_tmp_4,x1554_reg,x1522_r_0,x1465_tmp_0,x1470_tmp_0,x1555_reg,x1466_tmp_1,x1471_tmp_1,x1556_reg,x1474_tmp_4,x1467_tmp_2,x1472_tmp_2,x1553_reg,x1523_r_0,x1473_tmp_3,x1468_tmp_3) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1575.sm.io.ctrDone := risingEdge(x1575.sm.io.ctrInc)
      b1459_chain.connectStageCtrl((x1575.done).DS(1.toInt, rr, x1575.sm.io.backpressure), x1575.baseEn, 2)
      b1460_chain.connectStageCtrl((x1575.done).DS(1.toInt, rr, x1575.sm.io.backpressure), x1575.baseEn, 2)
      b1462_chain.connectStageCtrl((x1575.done).DS(1.toInt, rr, x1575.sm.io.backpressure), x1575.baseEn, 2)
      b1463_chain.connectStageCtrl((x1575.done).DS(1.toInt, rr, x1575.sm.io.backpressure), x1575.baseEn, 2)
      x1575.backpressure := true.B | x1575.sm.io.doneLatch
      x1575.forwardpressure := (true.B) && (true.B) | x1575.sm.io.doneLatch
      x1575.sm.io.enableOut.zip(x1575.smEnableOuts).foreach{case (l,r) => r := l}
      x1575.sm.io.break := false.B
      x1575.mask := true.B & b561
      x1575.configure("x1575", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1575.kernel()
      val x2943_rd_x1553 = Wire(Bool()).suggestName("""x2943_rd_x1553""")
      val x2943_rd_x1553_banks = List[UInt]()
      val x2943_rd_x1553_ofs = List[UInt]()
      val x2943_rd_x1553_en = List[Bool](true.B)
      val x2943_rd_x1553_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2943_rd_x1553_shared_en")
      x2943_rd_x1553.toSeq.zip(x1553_reg.connectRPort(2943, x2943_rd_x1553_banks, x2943_rd_x1553_ofs, io.sigsIn.backpressure, x2943_rd_x1553_en.map(_ && x2943_rd_x1553_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2944_rd_x1555 = Wire(Bool()).suggestName("""x2944_rd_x1555""")
      val x2944_rd_x1555_banks = List[UInt]()
      val x2944_rd_x1555_ofs = List[UInt]()
      val x2944_rd_x1555_en = List[Bool](true.B)
      val x2944_rd_x1555_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2944_rd_x1555_shared_en")
      x2944_rd_x1555.toSeq.zip(x1555_reg.connectRPort(2944, x2944_rd_x1555_banks, x2944_rd_x1555_ofs, io.sigsIn.backpressure, x2944_rd_x1555_en.map(_ && x2944_rd_x1555_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1593_inr_Switch_obj = new x1593_inr_Switch_kernel(List(x2943_rd_x1553,x2944_rd_x1555), List(x1469_tmp_4,x1554_reg,x1522_r_0,x1465_tmp_0,x1470_tmp_0,x1555_reg,x1466_tmp_1,x1471_tmp_1,x1556_reg,x1474_tmp_4,x1467_tmp_2,x1472_tmp_2,x1553_reg,x1523_r_0,x1473_tmp_3,x1468_tmp_3) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1593_inr_Switch_obj.sm.io.selectsIn(0) := x2943_rd_x1553
      x1593_inr_Switch_obj.sm.io.selectsIn(1) := x2944_rd_x1555
      b1459_chain.connectStageCtrl((x1593_inr_Switch_obj.done).DS(1.toInt, rr, x1593_inr_Switch_obj.sm.io.backpressure), x1593_inr_Switch_obj.baseEn, 3)
      b1460_chain.connectStageCtrl((x1593_inr_Switch_obj.done).DS(1.toInt, rr, x1593_inr_Switch_obj.sm.io.backpressure), x1593_inr_Switch_obj.baseEn, 3)
      b1462_chain.connectStageCtrl((x1593_inr_Switch_obj.done).DS(1.toInt, rr, x1593_inr_Switch_obj.sm.io.backpressure), x1593_inr_Switch_obj.baseEn, 3)
      b1463_chain.connectStageCtrl((x1593_inr_Switch_obj.done).DS(1.toInt, rr, x1593_inr_Switch_obj.sm.io.backpressure), x1593_inr_Switch_obj.baseEn, 3)
      x1593_inr_Switch_obj.backpressure := true.B | x1593_inr_Switch_obj.sm.io.doneLatch
      x1593_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x1593_inr_Switch_obj.sm.io.doneLatch
      x1593_inr_Switch_obj.sm.io.enableOut.zip(x1593_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1593_inr_Switch_obj.sm.io.break := false.B
      val x1593_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1593_inr_Switch""")
      x1593_inr_Switch_obj.mask := true.B & true.B
      x1593_inr_Switch_obj.configure("x1593_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1593_inr_Switch.r := x1593_inr_Switch_obj.kernel().r
      val x2945_rd_x1554 = Wire(Bool()).suggestName("""x2945_rd_x1554""")
      val x2945_rd_x1554_banks = List[UInt]()
      val x2945_rd_x1554_ofs = List[UInt]()
      val x2945_rd_x1554_en = List[Bool](true.B)
      val x2945_rd_x1554_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2945_rd_x1554_shared_en")
      x2945_rd_x1554.toSeq.zip(x1554_reg.connectRPort(2945, x2945_rd_x1554_banks, x2945_rd_x1554_ofs, io.sigsIn.backpressure, x2945_rd_x1554_en.map(_ && x2945_rd_x1554_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2946_rd_x1556 = Wire(Bool()).suggestName("""x2946_rd_x1556""")
      val x2946_rd_x1556_banks = List[UInt]()
      val x2946_rd_x1556_ofs = List[UInt]()
      val x2946_rd_x1556_en = List[Bool](true.B)
      val x2946_rd_x1556_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2946_rd_x1556_shared_en")
      x2946_rd_x1556.toSeq.zip(x1556_reg.connectRPort(2946, x2946_rd_x1556_banks, x2946_rd_x1556_ofs, io.sigsIn.backpressure, x2946_rd_x1556_en.map(_ && x2946_rd_x1556_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1607_inr_Switch_obj = new x1607_inr_Switch_kernel(List(x2946_rd_x1556,x2945_rd_x1554), List(x1469_tmp_4,x1554_reg,x1465_tmp_0,x1470_tmp_0,x1466_tmp_1,x1471_tmp_1,x1556_reg,x1474_tmp_4,x1467_tmp_2,x1472_tmp_2,x1523_r_0,x1473_tmp_3,x1468_tmp_3) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1607_inr_Switch_obj.sm.io.selectsIn(0) := x2945_rd_x1554
      x1607_inr_Switch_obj.sm.io.selectsIn(1) := x2946_rd_x1556
      b1459_chain.connectStageCtrl((x1607_inr_Switch_obj.done).DS(1.toInt, rr, x1607_inr_Switch_obj.sm.io.backpressure), x1607_inr_Switch_obj.baseEn, 4)
      b1460_chain.connectStageCtrl((x1607_inr_Switch_obj.done).DS(1.toInt, rr, x1607_inr_Switch_obj.sm.io.backpressure), x1607_inr_Switch_obj.baseEn, 4)
      b1462_chain.connectStageCtrl((x1607_inr_Switch_obj.done).DS(1.toInt, rr, x1607_inr_Switch_obj.sm.io.backpressure), x1607_inr_Switch_obj.baseEn, 4)
      b1463_chain.connectStageCtrl((x1607_inr_Switch_obj.done).DS(1.toInt, rr, x1607_inr_Switch_obj.sm.io.backpressure), x1607_inr_Switch_obj.baseEn, 4)
      x1607_inr_Switch_obj.backpressure := true.B | x1607_inr_Switch_obj.sm.io.doneLatch
      x1607_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x1607_inr_Switch_obj.sm.io.doneLatch
      x1607_inr_Switch_obj.sm.io.enableOut.zip(x1607_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1607_inr_Switch_obj.sm.io.break := false.B
      val x1607_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1607_inr_Switch""")
      x1607_inr_Switch_obj.mask := true.B & true.B
      x1607_inr_Switch_obj.configure("x1607_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1607_inr_Switch.r := x1607_inr_Switch_obj.kernel().r
      val x1612 = new x1612_kernel(List(b1462_chain_read_5,b561,b1463_chain_read_5), List(x1607_inr_Switch,x1593_inr_Switch), List(x1469_tmp_4,x1465_tmp_0,x1470_tmp_0,x1552_force_0,x1466_tmp_1,x1471_tmp_1,x1474_tmp_4,x1467_tmp_2,x1472_tmp_2,x1551_force_0,x1473_tmp_3,x1468_tmp_3) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1612.sm.io.ctrDone := risingEdge(x1612.sm.io.ctrInc)
      b1459_chain.connectStageCtrl((x1612.done).DS(1.toInt, rr, x1612.sm.io.backpressure), x1612.baseEn, 5)
      b1460_chain.connectStageCtrl((x1612.done).DS(1.toInt, rr, x1612.sm.io.backpressure), x1612.baseEn, 5)
      b1462_chain.connectStageCtrl((x1612.done).DS(1.toInt, rr, x1612.sm.io.backpressure), x1612.baseEn, 5)
      b1463_chain.connectStageCtrl((x1612.done).DS(1.toInt, rr, x1612.sm.io.backpressure), x1612.baseEn, 5)
      x1612.backpressure := true.B | x1612.sm.io.doneLatch
      x1612.forwardpressure := (true.B) && (true.B) | x1612.sm.io.doneLatch
      x1612.sm.io.enableOut.zip(x1612.smEnableOuts).foreach{case (l,r) => r := l}
      x1612.sm.io.break := false.B
      x1612.mask := true.B & b561
      x1612.configure("x1612", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1612.kernel()
      val x1613_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1614_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1615_ctrchain = (new CChainObject(List[CtrObject](x1613_ctr), "x1615_ctrchain")).cchain.io 
      x1615_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1615_ctrchain_p", (x1615_ctrchain.par, x1615_ctrchain.widths))
      val x1616_ctrchain = (new CChainObject(List[CtrObject](x1614_ctr), "x1616_ctrchain")).cchain.io 
      x1616_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1616_ctrchain_p", (x1616_ctrchain.par, x1616_ctrchain.widths))
      val x1645 = new x1645_kernel(List(b1462_chain_read_6,b561,b1463_chain_read_6), List(x1616_ctrchain,x1615_ctrchain), List(x1469_tmp_4,x1465_tmp_0,x1470_tmp_0,x1552_force_0,x1466_tmp_1,x1471_tmp_1,x1474_tmp_4,x1467_tmp_2,x1472_tmp_2,x1551_force_0,x1473_tmp_3,x1468_tmp_3) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1645.sm.io.ctrDone := risingEdge(x1645.sm.io.ctrInc)
      b1459_chain.connectStageCtrl((x1645.done).DS(1.toInt, rr, x1645.sm.io.backpressure), x1645.baseEn, 6)
      b1460_chain.connectStageCtrl((x1645.done).DS(1.toInt, rr, x1645.sm.io.backpressure), x1645.baseEn, 6)
      b1462_chain.connectStageCtrl((x1645.done).DS(1.toInt, rr, x1645.sm.io.backpressure), x1645.baseEn, 6)
      b1463_chain.connectStageCtrl((x1645.done).DS(1.toInt, rr, x1645.sm.io.backpressure), x1645.baseEn, 6)
      x1645.backpressure := true.B | x1645.sm.io.doneLatch
      x1645.forwardpressure := (true.B) && (true.B) | x1645.sm.io.doneLatch
      x1645.sm.io.enableOut.zip(x1645.smEnableOuts).foreach{case (l,r) => r := l}
      x1645.sm.io.break := false.B
      x1645.mask := true.B & b561
      x1645.configure("x1645", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1645.kernel()
      val x1665_inr_Foreach = new x1665_inr_Foreach_kernel(List(b561,b1463_chain_read_7), List(b1459_chain_read_7), List(x575_accum_0), List(x1469_tmp_4,x1474_tmp_4,x576_accum_1) ,  Some(me), List(x621_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1665_inr_Foreach.sm.io.ctrDone := (x1665_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b1459_chain.connectStageCtrl((x1665_inr_Foreach.done).DS(1.toInt, rr, x1665_inr_Foreach.sm.io.backpressure), x1665_inr_Foreach.baseEn, 7)
      b1460_chain.connectStageCtrl((x1665_inr_Foreach.done).DS(1.toInt, rr, x1665_inr_Foreach.sm.io.backpressure), x1665_inr_Foreach.baseEn, 7)
      b1462_chain.connectStageCtrl((x1665_inr_Foreach.done).DS(1.toInt, rr, x1665_inr_Foreach.sm.io.backpressure), x1665_inr_Foreach.baseEn, 7)
      b1463_chain.connectStageCtrl((x1665_inr_Foreach.done).DS(1.toInt, rr, x1665_inr_Foreach.sm.io.backpressure), x1665_inr_Foreach.baseEn, 7)
      x1665_inr_Foreach.backpressure := true.B | x1665_inr_Foreach.sm.io.doneLatch
      x1665_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1665_inr_Foreach.sm.io.doneLatch
      x1665_inr_Foreach.sm.io.enableOut.zip(x1665_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1665_inr_Foreach.sm.io.break := false.B
      x1665_inr_Foreach.mask := ~x1665_inr_Foreach.cchain.head.output.noop & true.B
      x1665_inr_Foreach.configure("x1665_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1665_inr_Foreach.kernel()
    }
    val module = Module(new x1666_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x1666_outr_Reduce **/
