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

/** Hierarchy: x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1874_outr_Reduce **/
class x1874_outr_Reduce_kernel(
  list_x622_ctrchain: List[CounterChainInterface],
  list_b552: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x578_accum_1: List[NBufInterface],
  list_b562: List[Bool],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x1874_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1874_outr_Reduce_iiCtr"))
  
  abstract class x1874_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x578_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x578_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x622_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x622_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b562 = Input(Bool())
      val in_x577_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x577_accum_0_p").asInstanceOf[MemParams] ))
      val in_b552 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x578_accum_1 = {io.in_x578_accum_1} ; io.in_x578_accum_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x622_ctrchain = {io.in_x622_ctrchain} ; io.in_x622_ctrchain := DontCare
    def b562 = {io.in_b562} 
    def x577_accum_0 = {io.in_x577_accum_0} ; io.in_x577_accum_0 := DontCare
    def b552 = {io.in_b552} 
  }
  def connectWires0(module: x1874_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x578_accum_1.connectLedger(module.io.in_x578_accum_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_x622_ctrchain.input <> x622_ctrchain.input; module.io.in_x622_ctrchain.output <> x622_ctrchain.output
    module.io.in_b562 <> b562
    x577_accum_0.connectLedger(module.io.in_x577_accum_0)
    module.io.in_b552 <> b552
  }
  val x622_ctrchain = list_x622_ctrchain(0)
  val b552 = list_b552(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x577_accum_0 = list_x472_A_sram_1(2)
  val x578_accum_1 = list_x578_accum_1(0)
  val b562 = list_b562(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1874_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x1874_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1874_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1874_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x1874_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x1874_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x1874_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1874_instrctr, cycles_x1874_outr_Reduce.io.count, iters_x1874_outr_Reduce.io.count, 0.U, 0.U)
      val b1667 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1667.suggestName("b1667")
      val b1667_chain = Module(new RegChainPass(8, 32, myName = "b1667_chain")); b1667_chain.io <> DontCare
      b1667_chain.chain_pass(b1667, io.sigsOut.smDoneIn.head)
      val b1667_chain_read_1 = b1667_chain.read(1).FP(true,32,0)
      val b1667_chain_read_2 = b1667_chain.read(2).FP(true,32,0)
      val b1667_chain_read_3 = b1667_chain.read(3).FP(true,32,0)
      val b1667_chain_read_4 = b1667_chain.read(4).FP(true,32,0)
      val b1667_chain_read_5 = b1667_chain.read(5).FP(true,32,0)
      val b1667_chain_read_6 = b1667_chain.read(6).FP(true,32,0)
      val b1667_chain_read_7 = b1667_chain.read(7).FP(true,32,0)
      val b1668 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b1668.suggestName("b1668")
      val b1668_chain = Module(new RegChainPass(8, 32, myName = "b1668_chain")); b1668_chain.io <> DontCare
      b1668_chain.chain_pass(b1668, io.sigsOut.smDoneIn.head)
      val b1668_chain_read_1 = b1668_chain.read(1).FP(true,32,0)
      val b1668_chain_read_2 = b1668_chain.read(2).FP(true,32,0)
      val b1668_chain_read_3 = b1668_chain.read(3).FP(true,32,0)
      val b1668_chain_read_4 = b1668_chain.read(4).FP(true,32,0)
      val b1668_chain_read_5 = b1668_chain.read(5).FP(true,32,0)
      val b1668_chain_read_6 = b1668_chain.read(6).FP(true,32,0)
      val b1668_chain_read_7 = b1668_chain.read(7).FP(true,32,0)
      val b1670 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1670.suggestName("b1670")
      val b1670_chain = Module(new RegChainPass(8, 1, myName = "b1670_chain")); b1670_chain.io <> DontCare
      b1670_chain.chain_pass(b1670, io.sigsOut.smDoneIn.head)
      val b1670_chain_read_1: Bool = b1670_chain.read(1).apply(0)
      val b1670_chain_read_2: Bool = b1670_chain.read(2).apply(0)
      val b1670_chain_read_3: Bool = b1670_chain.read(3).apply(0)
      val b1670_chain_read_4: Bool = b1670_chain.read(4).apply(0)
      val b1670_chain_read_5: Bool = b1670_chain.read(5).apply(0)
      val b1670_chain_read_6: Bool = b1670_chain.read(6).apply(0)
      val b1670_chain_read_7: Bool = b1670_chain.read(7).apply(0)
      val b1671 = ~io.sigsIn.cchainOutputs.head.oobs(1); b1671.suggestName("b1671")
      val b1671_chain = Module(new RegChainPass(8, 1, myName = "b1671_chain")); b1671_chain.io <> DontCare
      b1671_chain.chain_pass(b1671, io.sigsOut.smDoneIn.head)
      val b1671_chain_read_1: Bool = b1671_chain.read(1).apply(0)
      val b1671_chain_read_2: Bool = b1671_chain.read(2).apply(0)
      val b1671_chain_read_3: Bool = b1671_chain.read(3).apply(0)
      val b1671_chain_read_4: Bool = b1671_chain.read(4).apply(0)
      val b1671_chain_read_5: Bool = b1671_chain.read(5).apply(0)
      val b1671_chain_read_6: Bool = b1671_chain.read(6).apply(0)
      val b1671_chain_read_7: Bool = b1671_chain.read(7).apply(0)
      val x1673_tmp_0 = (new x1673_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1674_tmp_1 = (new x1674_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1675_tmp_2 = (new x1675_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1676_tmp_3 = (new x1676_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1677_tmp_4 = (new x1677_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1678_tmp_0 = (new x1678_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1679_tmp_1 = (new x1679_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1680_tmp_2 = (new x1680_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1681_tmp_3 = (new x1681_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1682_tmp_4 = (new x1682_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1683_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1684_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1685_ctrchain = (new CChainObject(List[CtrObject](x1683_ctr), "x1685_ctrchain")).cchain.io 
      x1685_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1685_ctrchain_p", (x1685_ctrchain.par, x1685_ctrchain.widths))
      val x1686_ctrchain = (new CChainObject(List[CtrObject](x1684_ctr), "x1686_ctrchain")).cchain.io 
      x1686_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1686_ctrchain_p", (x1686_ctrchain.par, x1686_ctrchain.widths))
      val x1729 = new x1729_kernel(List(b1671,b562,b1670), List(x472_A_sram_1,x471_A_sram_0), List(x1682_tmp_4,x1677_tmp_4,x1676_tmp_3,x1680_tmp_2,x1675_tmp_2,x1679_tmp_1,x1674_tmp_1,x1678_tmp_0,x1673_tmp_0,x1681_tmp_3), List(b1668,b1667,b552), List(x1686_ctrchain,x1685_ctrchain) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1729.sm.io.ctrDone := risingEdge(x1729.sm.io.ctrInc)
      b1667_chain.connectStageCtrl((x1729.done).DS(1.toInt, rr, x1729.sm.io.backpressure), x1729.baseEn, 0)
      b1668_chain.connectStageCtrl((x1729.done).DS(1.toInt, rr, x1729.sm.io.backpressure), x1729.baseEn, 0)
      b1670_chain.connectStageCtrl((x1729.done).DS(1.toInt, rr, x1729.sm.io.backpressure), x1729.baseEn, 0)
      b1671_chain.connectStageCtrl((x1729.done).DS(1.toInt, rr, x1729.sm.io.backpressure), x1729.baseEn, 0)
      x1729.backpressure := true.B | x1729.sm.io.doneLatch
      x1729.forwardpressure := (true.B) && (true.B) | x1729.sm.io.doneLatch
      x1729.sm.io.enableOut.zip(x1729.smEnableOuts).foreach{case (l,r) => r := l}
      x1729.sm.io.break := false.B
      x1729.mask := true.B & b562
      x1729.configure("x1729", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1729.kernel()
      val x1730_r_0 = (new x1730_r_0).m.io.asInstanceOf[NBufInterface]
      val x1731_r_0 = (new x1731_r_0).m.io.asInstanceOf[NBufInterface]
      val x1758 = new x1758_kernel(List(b1671_chain_read_1,b562,b1670_chain_read_1), List(x1682_tmp_4,x1677_tmp_4,x1730_r_0,x1676_tmp_3,x1680_tmp_2,x1675_tmp_2,x1731_r_0,x1679_tmp_1,x1674_tmp_1,x1678_tmp_0,x1673_tmp_0,x1681_tmp_3) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1758.sm.io.ctrDone := risingEdge(x1758.sm.io.ctrInc)
      b1667_chain.connectStageCtrl((x1758.done).DS(1.toInt, rr, x1758.sm.io.backpressure), x1758.baseEn, 1)
      b1668_chain.connectStageCtrl((x1758.done).DS(1.toInt, rr, x1758.sm.io.backpressure), x1758.baseEn, 1)
      b1670_chain.connectStageCtrl((x1758.done).DS(1.toInt, rr, x1758.sm.io.backpressure), x1758.baseEn, 1)
      b1671_chain.connectStageCtrl((x1758.done).DS(1.toInt, rr, x1758.sm.io.backpressure), x1758.baseEn, 1)
      x1758.backpressure := true.B | x1758.sm.io.doneLatch
      x1758.forwardpressure := (true.B) && (true.B) | x1758.sm.io.doneLatch
      x1758.sm.io.enableOut.zip(x1758.smEnableOuts).foreach{case (l,r) => r := l}
      x1758.sm.io.break := false.B
      x1758.mask := true.B & b562
      x1758.configure("x1758", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1758.kernel()
      val x1759_force_0 = (new x1759_force_0).m.io.asInstanceOf[NBufInterface]
      val x1760_force_0 = (new x1760_force_0).m.io.asInstanceOf[NBufInterface]
      val x1761_reg = (new x1761_reg).m.io.asInstanceOf[NBufInterface]
      val x1762_reg = (new x1762_reg).m.io.asInstanceOf[NBufInterface]
      val x1763_reg = (new x1763_reg).m.io.asInstanceOf[NBufInterface]
      val x1764_reg = (new x1764_reg).m.io.asInstanceOf[NBufInterface]
      val x1783 = new x1783_kernel(List(b1671_chain_read_2,b562,b1670_chain_read_2), List(x1761_reg,x1682_tmp_4,x1677_tmp_4,x1730_r_0,x1676_tmp_3,x1762_reg,x1764_reg,x1680_tmp_2,x1675_tmp_2,x1731_r_0,x1763_reg,x1679_tmp_1,x1674_tmp_1,x1678_tmp_0,x1673_tmp_0,x1681_tmp_3) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1783.sm.io.ctrDone := risingEdge(x1783.sm.io.ctrInc)
      b1667_chain.connectStageCtrl((x1783.done).DS(1.toInt, rr, x1783.sm.io.backpressure), x1783.baseEn, 2)
      b1668_chain.connectStageCtrl((x1783.done).DS(1.toInt, rr, x1783.sm.io.backpressure), x1783.baseEn, 2)
      b1670_chain.connectStageCtrl((x1783.done).DS(1.toInt, rr, x1783.sm.io.backpressure), x1783.baseEn, 2)
      b1671_chain.connectStageCtrl((x1783.done).DS(1.toInt, rr, x1783.sm.io.backpressure), x1783.baseEn, 2)
      x1783.backpressure := true.B | x1783.sm.io.doneLatch
      x1783.forwardpressure := (true.B) && (true.B) | x1783.sm.io.doneLatch
      x1783.sm.io.enableOut.zip(x1783.smEnableOuts).foreach{case (l,r) => r := l}
      x1783.sm.io.break := false.B
      x1783.mask := true.B & b562
      x1783.configure("x1783", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1783.kernel()
      val x2947_rd_x1761 = Wire(Bool()).suggestName("""x2947_rd_x1761""")
      val x2947_rd_x1761_banks = List[UInt]()
      val x2947_rd_x1761_ofs = List[UInt]()
      val x2947_rd_x1761_en = List[Bool](true.B)
      val x2947_rd_x1761_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2947_rd_x1761_shared_en")
      x2947_rd_x1761.toSeq.zip(x1761_reg.connectRPort(2947, x2947_rd_x1761_banks, x2947_rd_x1761_ofs, io.sigsIn.backpressure, x2947_rd_x1761_en.map(_ && x2947_rd_x1761_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2948_rd_x1763 = Wire(Bool()).suggestName("""x2948_rd_x1763""")
      val x2948_rd_x1763_banks = List[UInt]()
      val x2948_rd_x1763_ofs = List[UInt]()
      val x2948_rd_x1763_en = List[Bool](true.B)
      val x2948_rd_x1763_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2948_rd_x1763_shared_en")
      x2948_rd_x1763.toSeq.zip(x1763_reg.connectRPort(2948, x2948_rd_x1763_banks, x2948_rd_x1763_ofs, io.sigsIn.backpressure, x2948_rd_x1763_en.map(_ && x2948_rd_x1763_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1801_inr_Switch_obj = new x1801_inr_Switch_kernel(List(x2947_rd_x1761,x2948_rd_x1763), List(x1761_reg,x1682_tmp_4,x1677_tmp_4,x1730_r_0,x1676_tmp_3,x1762_reg,x1764_reg,x1680_tmp_2,x1675_tmp_2,x1731_r_0,x1763_reg,x1679_tmp_1,x1674_tmp_1,x1678_tmp_0,x1673_tmp_0,x1681_tmp_3) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1801_inr_Switch_obj.sm.io.selectsIn(0) := x2947_rd_x1761
      x1801_inr_Switch_obj.sm.io.selectsIn(1) := x2948_rd_x1763
      b1667_chain.connectStageCtrl((x1801_inr_Switch_obj.done).DS(1.toInt, rr, x1801_inr_Switch_obj.sm.io.backpressure), x1801_inr_Switch_obj.baseEn, 3)
      b1668_chain.connectStageCtrl((x1801_inr_Switch_obj.done).DS(1.toInt, rr, x1801_inr_Switch_obj.sm.io.backpressure), x1801_inr_Switch_obj.baseEn, 3)
      b1670_chain.connectStageCtrl((x1801_inr_Switch_obj.done).DS(1.toInt, rr, x1801_inr_Switch_obj.sm.io.backpressure), x1801_inr_Switch_obj.baseEn, 3)
      b1671_chain.connectStageCtrl((x1801_inr_Switch_obj.done).DS(1.toInt, rr, x1801_inr_Switch_obj.sm.io.backpressure), x1801_inr_Switch_obj.baseEn, 3)
      x1801_inr_Switch_obj.backpressure := true.B | x1801_inr_Switch_obj.sm.io.doneLatch
      x1801_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x1801_inr_Switch_obj.sm.io.doneLatch
      x1801_inr_Switch_obj.sm.io.enableOut.zip(x1801_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1801_inr_Switch_obj.sm.io.break := false.B
      val x1801_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1801_inr_Switch""")
      x1801_inr_Switch_obj.mask := true.B & true.B
      x1801_inr_Switch_obj.configure("x1801_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1801_inr_Switch.r := x1801_inr_Switch_obj.kernel().r
      val x2949_rd_x1762 = Wire(Bool()).suggestName("""x2949_rd_x1762""")
      val x2949_rd_x1762_banks = List[UInt]()
      val x2949_rd_x1762_ofs = List[UInt]()
      val x2949_rd_x1762_en = List[Bool](true.B)
      val x2949_rd_x1762_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2949_rd_x1762_shared_en")
      x2949_rd_x1762.toSeq.zip(x1762_reg.connectRPort(2949, x2949_rd_x1762_banks, x2949_rd_x1762_ofs, io.sigsIn.backpressure, x2949_rd_x1762_en.map(_ && x2949_rd_x1762_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2950_rd_x1764 = Wire(Bool()).suggestName("""x2950_rd_x1764""")
      val x2950_rd_x1764_banks = List[UInt]()
      val x2950_rd_x1764_ofs = List[UInt]()
      val x2950_rd_x1764_en = List[Bool](true.B)
      val x2950_rd_x1764_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2950_rd_x1764_shared_en")
      x2950_rd_x1764.toSeq.zip(x1764_reg.connectRPort(2950, x2950_rd_x1764_banks, x2950_rd_x1764_ofs, io.sigsIn.backpressure, x2950_rd_x1764_en.map(_ && x2950_rd_x1764_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1815_inr_Switch_obj = new x1815_inr_Switch_kernel(List(x2950_rd_x1764,x2949_rd_x1762), List(x1682_tmp_4,x1677_tmp_4,x1676_tmp_3,x1762_reg,x1764_reg,x1680_tmp_2,x1675_tmp_2,x1731_r_0,x1679_tmp_1,x1674_tmp_1,x1678_tmp_0,x1673_tmp_0,x1681_tmp_3) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1815_inr_Switch_obj.sm.io.selectsIn(0) := x2949_rd_x1762
      x1815_inr_Switch_obj.sm.io.selectsIn(1) := x2950_rd_x1764
      b1667_chain.connectStageCtrl((x1815_inr_Switch_obj.done).DS(1.toInt, rr, x1815_inr_Switch_obj.sm.io.backpressure), x1815_inr_Switch_obj.baseEn, 4)
      b1668_chain.connectStageCtrl((x1815_inr_Switch_obj.done).DS(1.toInt, rr, x1815_inr_Switch_obj.sm.io.backpressure), x1815_inr_Switch_obj.baseEn, 4)
      b1670_chain.connectStageCtrl((x1815_inr_Switch_obj.done).DS(1.toInt, rr, x1815_inr_Switch_obj.sm.io.backpressure), x1815_inr_Switch_obj.baseEn, 4)
      b1671_chain.connectStageCtrl((x1815_inr_Switch_obj.done).DS(1.toInt, rr, x1815_inr_Switch_obj.sm.io.backpressure), x1815_inr_Switch_obj.baseEn, 4)
      x1815_inr_Switch_obj.backpressure := true.B | x1815_inr_Switch_obj.sm.io.doneLatch
      x1815_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x1815_inr_Switch_obj.sm.io.doneLatch
      x1815_inr_Switch_obj.sm.io.enableOut.zip(x1815_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x1815_inr_Switch_obj.sm.io.break := false.B
      val x1815_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1815_inr_Switch""")
      x1815_inr_Switch_obj.mask := true.B & true.B
      x1815_inr_Switch_obj.configure("x1815_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1815_inr_Switch.r := x1815_inr_Switch_obj.kernel().r
      val x1820 = new x1820_kernel(List(b1671_chain_read_5,b562,b1670_chain_read_5), List(x1815_inr_Switch,x1801_inr_Switch), List(x1760_force_0,x1682_tmp_4,x1677_tmp_4,x1676_tmp_3,x1759_force_0,x1680_tmp_2,x1675_tmp_2,x1679_tmp_1,x1674_tmp_1,x1678_tmp_0,x1673_tmp_0,x1681_tmp_3) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1820.sm.io.ctrDone := risingEdge(x1820.sm.io.ctrInc)
      b1667_chain.connectStageCtrl((x1820.done).DS(1.toInt, rr, x1820.sm.io.backpressure), x1820.baseEn, 5)
      b1668_chain.connectStageCtrl((x1820.done).DS(1.toInt, rr, x1820.sm.io.backpressure), x1820.baseEn, 5)
      b1670_chain.connectStageCtrl((x1820.done).DS(1.toInt, rr, x1820.sm.io.backpressure), x1820.baseEn, 5)
      b1671_chain.connectStageCtrl((x1820.done).DS(1.toInt, rr, x1820.sm.io.backpressure), x1820.baseEn, 5)
      x1820.backpressure := true.B | x1820.sm.io.doneLatch
      x1820.forwardpressure := (true.B) && (true.B) | x1820.sm.io.doneLatch
      x1820.sm.io.enableOut.zip(x1820.smEnableOuts).foreach{case (l,r) => r := l}
      x1820.sm.io.break := false.B
      x1820.mask := true.B & b562
      x1820.configure("x1820", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1820.kernel()
      val x1821_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1822_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1823_ctrchain = (new CChainObject(List[CtrObject](x1821_ctr), "x1823_ctrchain")).cchain.io 
      x1823_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1823_ctrchain_p", (x1823_ctrchain.par, x1823_ctrchain.widths))
      val x1824_ctrchain = (new CChainObject(List[CtrObject](x1822_ctr), "x1824_ctrchain")).cchain.io 
      x1824_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1824_ctrchain_p", (x1824_ctrchain.par, x1824_ctrchain.widths))
      val x1853 = new x1853_kernel(List(b1671_chain_read_6,b562,b1670_chain_read_6), List(x1823_ctrchain,x1824_ctrchain), List(x1760_force_0,x1682_tmp_4,x1677_tmp_4,x1676_tmp_3,x1759_force_0,x1680_tmp_2,x1675_tmp_2,x1679_tmp_1,x1674_tmp_1,x1678_tmp_0,x1673_tmp_0,x1681_tmp_3) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1853.sm.io.ctrDone := risingEdge(x1853.sm.io.ctrInc)
      b1667_chain.connectStageCtrl((x1853.done).DS(1.toInt, rr, x1853.sm.io.backpressure), x1853.baseEn, 6)
      b1668_chain.connectStageCtrl((x1853.done).DS(1.toInt, rr, x1853.sm.io.backpressure), x1853.baseEn, 6)
      b1670_chain.connectStageCtrl((x1853.done).DS(1.toInt, rr, x1853.sm.io.backpressure), x1853.baseEn, 6)
      b1671_chain.connectStageCtrl((x1853.done).DS(1.toInt, rr, x1853.sm.io.backpressure), x1853.baseEn, 6)
      x1853.backpressure := true.B | x1853.sm.io.doneLatch
      x1853.forwardpressure := (true.B) && (true.B) | x1853.sm.io.doneLatch
      x1853.sm.io.enableOut.zip(x1853.smEnableOuts).foreach{case (l,r) => r := l}
      x1853.sm.io.break := false.B
      x1853.mask := true.B & b562
      x1853.configure("x1853", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1853.kernel()
      val x1873_inr_Foreach = new x1873_inr_Foreach_kernel(List(b1671_chain_read_7,b562), List(b1667_chain_read_7), List(x577_accum_0), List(x1682_tmp_4,x1677_tmp_4,x578_accum_1) ,  Some(me), List(x622_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1873_inr_Foreach.sm.io.ctrDone := (x1873_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b1667_chain.connectStageCtrl((x1873_inr_Foreach.done).DS(1.toInt, rr, x1873_inr_Foreach.sm.io.backpressure), x1873_inr_Foreach.baseEn, 7)
      b1668_chain.connectStageCtrl((x1873_inr_Foreach.done).DS(1.toInt, rr, x1873_inr_Foreach.sm.io.backpressure), x1873_inr_Foreach.baseEn, 7)
      b1670_chain.connectStageCtrl((x1873_inr_Foreach.done).DS(1.toInt, rr, x1873_inr_Foreach.sm.io.backpressure), x1873_inr_Foreach.baseEn, 7)
      b1671_chain.connectStageCtrl((x1873_inr_Foreach.done).DS(1.toInt, rr, x1873_inr_Foreach.sm.io.backpressure), x1873_inr_Foreach.baseEn, 7)
      x1873_inr_Foreach.backpressure := true.B | x1873_inr_Foreach.sm.io.doneLatch
      x1873_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1873_inr_Foreach.sm.io.doneLatch
      x1873_inr_Foreach.sm.io.enableOut.zip(x1873_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1873_inr_Foreach.sm.io.break := false.B
      x1873_inr_Foreach.mask := ~x1873_inr_Foreach.cchain.head.output.noop & true.B
      x1873_inr_Foreach.configure("x1873_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1873_inr_Foreach.kernel()
    }
    val module = Module(new x1874_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x1874_outr_Reduce **/
