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

/** Hierarchy: x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2082_outr_Reduce **/
class x2082_outr_Reduce_kernel(
  list_x580_accum_1: List[NBufInterface],
  list_b563: List[Bool],
  list_x472_A_sram_1: List[StandardInterface],
  list_x623_ctrchain: List[CounterChainInterface],
  list_b553: List[FixedPoint],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 8, isFSM = false   , latency = 0.0.toInt, myName = "x2082_outr_Reduce_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2082_outr_Reduce_iiCtr"))
  
  abstract class x2082_outr_Reduce_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x623_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x623_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x579_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x579_accum_0_p").asInstanceOf[MemParams] ))
      val in_b563 = Input(Bool())
      val in_b553 = Input(new FixedPoint(true, 32, 0))
      val in_x580_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x580_accum_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(8, 1, List(2), List(32)))
      val sigsOut = Output(new OutputKernelSignals(8, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x623_ctrchain = {io.in_x623_ctrchain} ; io.in_x623_ctrchain := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x579_accum_0 = {io.in_x579_accum_0} ; io.in_x579_accum_0 := DontCare
    def b563 = {io.in_b563} 
    def b553 = {io.in_b553} 
    def x580_accum_1 = {io.in_x580_accum_1} ; io.in_x580_accum_1 := DontCare
  }
  def connectWires0(module: x2082_outr_Reduce_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_x623_ctrchain.input <> x623_ctrchain.input; module.io.in_x623_ctrchain.output <> x623_ctrchain.output
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x579_accum_0.connectLedger(module.io.in_x579_accum_0)
    module.io.in_b563 <> b563
    module.io.in_b553 <> b553
    x580_accum_1.connectLedger(module.io.in_x580_accum_1)
  }
  val x580_accum_1 = list_x580_accum_1(0)
  val b563 = list_b563(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x579_accum_0 = list_x472_A_sram_1(2)
  val x623_ctrchain = list_x623_ctrchain(0)
  val b553 = list_b553(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2082_outr_Reduce")
    implicit val stack = ControllerStack.stack.toList
    class x2082_outr_Reduce_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2082_outr_Reduce_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2082_outr_Reduce = Module(new InstrumentationCounter())
      val iters_x2082_outr_Reduce = Module(new InstrumentationCounter())
      cycles_x2082_outr_Reduce.io.enable := io.sigsIn.baseEn
      iters_x2082_outr_Reduce.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2082_instrctr, cycles_x2082_outr_Reduce.io.count, iters_x2082_outr_Reduce.io.count, 0.U, 0.U)
      val b1875 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1875.suggestName("b1875")
      val b1875_chain = Module(new RegChainPass(8, 32, myName = "b1875_chain")); b1875_chain.io <> DontCare
      b1875_chain.chain_pass(b1875, io.sigsOut.smDoneIn.head)
      val b1875_chain_read_1 = b1875_chain.read(1).FP(true,32,0)
      val b1875_chain_read_2 = b1875_chain.read(2).FP(true,32,0)
      val b1875_chain_read_3 = b1875_chain.read(3).FP(true,32,0)
      val b1875_chain_read_4 = b1875_chain.read(4).FP(true,32,0)
      val b1875_chain_read_5 = b1875_chain.read(5).FP(true,32,0)
      val b1875_chain_read_6 = b1875_chain.read(6).FP(true,32,0)
      val b1875_chain_read_7 = b1875_chain.read(7).FP(true,32,0)
      val b1876 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b1876.suggestName("b1876")
      val b1876_chain = Module(new RegChainPass(8, 32, myName = "b1876_chain")); b1876_chain.io <> DontCare
      b1876_chain.chain_pass(b1876, io.sigsOut.smDoneIn.head)
      val b1876_chain_read_1 = b1876_chain.read(1).FP(true,32,0)
      val b1876_chain_read_2 = b1876_chain.read(2).FP(true,32,0)
      val b1876_chain_read_3 = b1876_chain.read(3).FP(true,32,0)
      val b1876_chain_read_4 = b1876_chain.read(4).FP(true,32,0)
      val b1876_chain_read_5 = b1876_chain.read(5).FP(true,32,0)
      val b1876_chain_read_6 = b1876_chain.read(6).FP(true,32,0)
      val b1876_chain_read_7 = b1876_chain.read(7).FP(true,32,0)
      val b1878 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1878.suggestName("b1878")
      val b1878_chain = Module(new RegChainPass(8, 1, myName = "b1878_chain")); b1878_chain.io <> DontCare
      b1878_chain.chain_pass(b1878, io.sigsOut.smDoneIn.head)
      val b1878_chain_read_1: Bool = b1878_chain.read(1).apply(0)
      val b1878_chain_read_2: Bool = b1878_chain.read(2).apply(0)
      val b1878_chain_read_3: Bool = b1878_chain.read(3).apply(0)
      val b1878_chain_read_4: Bool = b1878_chain.read(4).apply(0)
      val b1878_chain_read_5: Bool = b1878_chain.read(5).apply(0)
      val b1878_chain_read_6: Bool = b1878_chain.read(6).apply(0)
      val b1878_chain_read_7: Bool = b1878_chain.read(7).apply(0)
      val b1879 = ~io.sigsIn.cchainOutputs.head.oobs(1); b1879.suggestName("b1879")
      val b1879_chain = Module(new RegChainPass(8, 1, myName = "b1879_chain")); b1879_chain.io <> DontCare
      b1879_chain.chain_pass(b1879, io.sigsOut.smDoneIn.head)
      val b1879_chain_read_1: Bool = b1879_chain.read(1).apply(0)
      val b1879_chain_read_2: Bool = b1879_chain.read(2).apply(0)
      val b1879_chain_read_3: Bool = b1879_chain.read(3).apply(0)
      val b1879_chain_read_4: Bool = b1879_chain.read(4).apply(0)
      val b1879_chain_read_5: Bool = b1879_chain.read(5).apply(0)
      val b1879_chain_read_6: Bool = b1879_chain.read(6).apply(0)
      val b1879_chain_read_7: Bool = b1879_chain.read(7).apply(0)
      val x1881_tmp_0 = (new x1881_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1882_tmp_1 = (new x1882_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1883_tmp_2 = (new x1883_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1884_tmp_3 = (new x1884_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1885_tmp_4 = (new x1885_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1886_tmp_0 = (new x1886_tmp_0).m.io.asInstanceOf[NBufInterface]
      val x1887_tmp_1 = (new x1887_tmp_1).m.io.asInstanceOf[NBufInterface]
      val x1888_tmp_2 = (new x1888_tmp_2).m.io.asInstanceOf[NBufInterface]
      val x1889_tmp_3 = (new x1889_tmp_3).m.io.asInstanceOf[NBufInterface]
      val x1890_tmp_4 = (new x1890_tmp_4).m.io.asInstanceOf[NBufInterface]
      val x1891_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1892_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x1893_ctrchain = (new CChainObject(List[CtrObject](x1891_ctr), "x1893_ctrchain")).cchain.io 
      x1893_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1893_ctrchain_p", (x1893_ctrchain.par, x1893_ctrchain.widths))
      val x1894_ctrchain = (new CChainObject(List[CtrObject](x1892_ctr), "x1894_ctrchain")).cchain.io 
      x1894_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x1894_ctrchain_p", (x1894_ctrchain.par, x1894_ctrchain.widths))
      val x1937 = new x1937_kernel(List(x1894_ctrchain,x1893_ctrchain), List(x1882_tmp_1,x1887_tmp_1,x1890_tmp_4,x1886_tmp_0,x1883_tmp_2,x1888_tmp_2,x1889_tmp_3,x1884_tmp_3,x1881_tmp_0,x1885_tmp_4), List(b1879,b1878,b563), List(x472_A_sram_1,x471_A_sram_0), List(b1875,b553,b1876) ,  Some(me), List(), 0, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1937.sm.io.ctrDone := risingEdge(x1937.sm.io.ctrInc)
      b1875_chain.connectStageCtrl((x1937.done).DS(1.toInt, rr, x1937.sm.io.backpressure), x1937.baseEn, 0)
      b1876_chain.connectStageCtrl((x1937.done).DS(1.toInt, rr, x1937.sm.io.backpressure), x1937.baseEn, 0)
      b1878_chain.connectStageCtrl((x1937.done).DS(1.toInt, rr, x1937.sm.io.backpressure), x1937.baseEn, 0)
      b1879_chain.connectStageCtrl((x1937.done).DS(1.toInt, rr, x1937.sm.io.backpressure), x1937.baseEn, 0)
      x1937.backpressure := true.B | x1937.sm.io.doneLatch
      x1937.forwardpressure := (true.B) && (true.B) | x1937.sm.io.doneLatch
      x1937.sm.io.enableOut.zip(x1937.smEnableOuts).foreach{case (l,r) => r := l}
      x1937.sm.io.break := false.B
      x1937.mask := true.B & b563
      x1937.configure("x1937", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1937.kernel()
      val x1938_r_0 = (new x1938_r_0).m.io.asInstanceOf[NBufInterface]
      val x1939_r_0 = (new x1939_r_0).m.io.asInstanceOf[NBufInterface]
      val x1966 = new x1966_kernel(List(b1879_chain_read_1,b1878_chain_read_1,b563), List(x1882_tmp_1,x1939_r_0,x1887_tmp_1,x1890_tmp_4,x1886_tmp_0,x1883_tmp_2,x1938_r_0,x1888_tmp_2,x1889_tmp_3,x1884_tmp_3,x1881_tmp_0,x1885_tmp_4) ,  Some(me), List(), 1, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1966.sm.io.ctrDone := risingEdge(x1966.sm.io.ctrInc)
      b1875_chain.connectStageCtrl((x1966.done).DS(1.toInt, rr, x1966.sm.io.backpressure), x1966.baseEn, 1)
      b1876_chain.connectStageCtrl((x1966.done).DS(1.toInt, rr, x1966.sm.io.backpressure), x1966.baseEn, 1)
      b1878_chain.connectStageCtrl((x1966.done).DS(1.toInt, rr, x1966.sm.io.backpressure), x1966.baseEn, 1)
      b1879_chain.connectStageCtrl((x1966.done).DS(1.toInt, rr, x1966.sm.io.backpressure), x1966.baseEn, 1)
      x1966.backpressure := true.B | x1966.sm.io.doneLatch
      x1966.forwardpressure := (true.B) && (true.B) | x1966.sm.io.doneLatch
      x1966.sm.io.enableOut.zip(x1966.smEnableOuts).foreach{case (l,r) => r := l}
      x1966.sm.io.break := false.B
      x1966.mask := true.B & b563
      x1966.configure("x1966", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1966.kernel()
      val x1967_force_0 = (new x1967_force_0).m.io.asInstanceOf[NBufInterface]
      val x1968_force_0 = (new x1968_force_0).m.io.asInstanceOf[NBufInterface]
      val x1969_reg = (new x1969_reg).m.io.asInstanceOf[NBufInterface]
      val x1970_reg = (new x1970_reg).m.io.asInstanceOf[NBufInterface]
      val x1971_reg = (new x1971_reg).m.io.asInstanceOf[NBufInterface]
      val x1972_reg = (new x1972_reg).m.io.asInstanceOf[NBufInterface]
      val x1991 = new x1991_kernel(List(b1879_chain_read_2,b1878_chain_read_2,b563), List(x1882_tmp_1,x1939_r_0,x1971_reg,x1887_tmp_1,x1890_tmp_4,x1886_tmp_0,x1883_tmp_2,x1938_r_0,x1888_tmp_2,x1970_reg,x1889_tmp_3,x1884_tmp_3,x1969_reg,x1972_reg,x1881_tmp_0,x1885_tmp_4) ,  Some(me), List(), 2, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1991.sm.io.ctrDone := risingEdge(x1991.sm.io.ctrInc)
      b1875_chain.connectStageCtrl((x1991.done).DS(1.toInt, rr, x1991.sm.io.backpressure), x1991.baseEn, 2)
      b1876_chain.connectStageCtrl((x1991.done).DS(1.toInt, rr, x1991.sm.io.backpressure), x1991.baseEn, 2)
      b1878_chain.connectStageCtrl((x1991.done).DS(1.toInt, rr, x1991.sm.io.backpressure), x1991.baseEn, 2)
      b1879_chain.connectStageCtrl((x1991.done).DS(1.toInt, rr, x1991.sm.io.backpressure), x1991.baseEn, 2)
      x1991.backpressure := true.B | x1991.sm.io.doneLatch
      x1991.forwardpressure := (true.B) && (true.B) | x1991.sm.io.doneLatch
      x1991.sm.io.enableOut.zip(x1991.smEnableOuts).foreach{case (l,r) => r := l}
      x1991.sm.io.break := false.B
      x1991.mask := true.B & b563
      x1991.configure("x1991", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1991.kernel()
      val x2951_rd_x1969 = Wire(Bool()).suggestName("""x2951_rd_x1969""")
      val x2951_rd_x1969_banks = List[UInt]()
      val x2951_rd_x1969_ofs = List[UInt]()
      val x2951_rd_x1969_en = List[Bool](true.B)
      val x2951_rd_x1969_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2951_rd_x1969_shared_en")
      x2951_rd_x1969.toSeq.zip(x1969_reg.connectRPort(2951, x2951_rd_x1969_banks, x2951_rd_x1969_ofs, io.sigsIn.backpressure, x2951_rd_x1969_en.map(_ && x2951_rd_x1969_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2952_rd_x1971 = Wire(Bool()).suggestName("""x2952_rd_x1971""")
      val x2952_rd_x1971_banks = List[UInt]()
      val x2952_rd_x1971_ofs = List[UInt]()
      val x2952_rd_x1971_en = List[Bool](true.B)
      val x2952_rd_x1971_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2952_rd_x1971_shared_en")
      x2952_rd_x1971.toSeq.zip(x1971_reg.connectRPort(2952, x2952_rd_x1971_banks, x2952_rd_x1971_ofs, io.sigsIn.backpressure, x2952_rd_x1971_en.map(_ && x2952_rd_x1971_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2009_inr_Switch_obj = new x2009_inr_Switch_kernel(List(x2952_rd_x1971,x2951_rd_x1969), List(x1882_tmp_1,x1939_r_0,x1971_reg,x1887_tmp_1,x1890_tmp_4,x1886_tmp_0,x1883_tmp_2,x1938_r_0,x1888_tmp_2,x1970_reg,x1889_tmp_3,x1884_tmp_3,x1969_reg,x1972_reg,x1881_tmp_0,x1885_tmp_4) ,  Some(me), List(), 3, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2009_inr_Switch_obj.sm.io.selectsIn(0) := x2951_rd_x1969
      x2009_inr_Switch_obj.sm.io.selectsIn(1) := x2952_rd_x1971
      b1875_chain.connectStageCtrl((x2009_inr_Switch_obj.done).DS(1.toInt, rr, x2009_inr_Switch_obj.sm.io.backpressure), x2009_inr_Switch_obj.baseEn, 3)
      b1876_chain.connectStageCtrl((x2009_inr_Switch_obj.done).DS(1.toInt, rr, x2009_inr_Switch_obj.sm.io.backpressure), x2009_inr_Switch_obj.baseEn, 3)
      b1878_chain.connectStageCtrl((x2009_inr_Switch_obj.done).DS(1.toInt, rr, x2009_inr_Switch_obj.sm.io.backpressure), x2009_inr_Switch_obj.baseEn, 3)
      b1879_chain.connectStageCtrl((x2009_inr_Switch_obj.done).DS(1.toInt, rr, x2009_inr_Switch_obj.sm.io.backpressure), x2009_inr_Switch_obj.baseEn, 3)
      x2009_inr_Switch_obj.backpressure := true.B | x2009_inr_Switch_obj.sm.io.doneLatch
      x2009_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x2009_inr_Switch_obj.sm.io.doneLatch
      x2009_inr_Switch_obj.sm.io.enableOut.zip(x2009_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2009_inr_Switch_obj.sm.io.break := false.B
      val x2009_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2009_inr_Switch""")
      x2009_inr_Switch_obj.mask := true.B & true.B
      x2009_inr_Switch_obj.configure("x2009_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2009_inr_Switch.r := x2009_inr_Switch_obj.kernel().r
      val x2953_rd_x1970 = Wire(Bool()).suggestName("""x2953_rd_x1970""")
      val x2953_rd_x1970_banks = List[UInt]()
      val x2953_rd_x1970_ofs = List[UInt]()
      val x2953_rd_x1970_en = List[Bool](true.B)
      val x2953_rd_x1970_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2953_rd_x1970_shared_en")
      x2953_rd_x1970.toSeq.zip(x1970_reg.connectRPort(2953, x2953_rd_x1970_banks, x2953_rd_x1970_ofs, io.sigsIn.backpressure, x2953_rd_x1970_en.map(_ && x2953_rd_x1970_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2954_rd_x1972 = Wire(Bool()).suggestName("""x2954_rd_x1972""")
      val x2954_rd_x1972_banks = List[UInt]()
      val x2954_rd_x1972_ofs = List[UInt]()
      val x2954_rd_x1972_en = List[Bool](true.B)
      val x2954_rd_x1972_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2954_rd_x1972_shared_en")
      x2954_rd_x1972.toSeq.zip(x1972_reg.connectRPort(2954, x2954_rd_x1972_banks, x2954_rd_x1972_ofs, io.sigsIn.backpressure, x2954_rd_x1972_en.map(_ && x2954_rd_x1972_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2023_inr_Switch_obj = new x2023_inr_Switch_kernel(List(x2953_rd_x1970,x2954_rd_x1972), List(x1882_tmp_1,x1939_r_0,x1887_tmp_1,x1890_tmp_4,x1886_tmp_0,x1883_tmp_2,x1888_tmp_2,x1970_reg,x1889_tmp_3,x1884_tmp_3,x1972_reg,x1881_tmp_0,x1885_tmp_4) ,  Some(me), List(), 4, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2023_inr_Switch_obj.sm.io.selectsIn(0) := x2953_rd_x1970
      x2023_inr_Switch_obj.sm.io.selectsIn(1) := x2954_rd_x1972
      b1875_chain.connectStageCtrl((x2023_inr_Switch_obj.done).DS(1.toInt, rr, x2023_inr_Switch_obj.sm.io.backpressure), x2023_inr_Switch_obj.baseEn, 4)
      b1876_chain.connectStageCtrl((x2023_inr_Switch_obj.done).DS(1.toInt, rr, x2023_inr_Switch_obj.sm.io.backpressure), x2023_inr_Switch_obj.baseEn, 4)
      b1878_chain.connectStageCtrl((x2023_inr_Switch_obj.done).DS(1.toInt, rr, x2023_inr_Switch_obj.sm.io.backpressure), x2023_inr_Switch_obj.baseEn, 4)
      b1879_chain.connectStageCtrl((x2023_inr_Switch_obj.done).DS(1.toInt, rr, x2023_inr_Switch_obj.sm.io.backpressure), x2023_inr_Switch_obj.baseEn, 4)
      x2023_inr_Switch_obj.backpressure := true.B | x2023_inr_Switch_obj.sm.io.doneLatch
      x2023_inr_Switch_obj.forwardpressure := (true.B) && (true.B) | x2023_inr_Switch_obj.sm.io.doneLatch
      x2023_inr_Switch_obj.sm.io.enableOut.zip(x2023_inr_Switch_obj.smEnableOuts).foreach{case (l,r) => r := l}
      x2023_inr_Switch_obj.sm.io.break := false.B
      val x2023_inr_Switch = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2023_inr_Switch""")
      x2023_inr_Switch_obj.mask := true.B & true.B
      x2023_inr_Switch_obj.configure("x2023_inr_Switch_obj", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2023_inr_Switch.r := x2023_inr_Switch_obj.kernel().r
      val x2028 = new x2028_kernel(List(b1879_chain_read_5,b1878_chain_read_5,b563), List(x2023_inr_Switch,x2009_inr_Switch), List(x1882_tmp_1,x1967_force_0,x1887_tmp_1,x1890_tmp_4,x1886_tmp_0,x1883_tmp_2,x1968_force_0,x1888_tmp_2,x1889_tmp_3,x1884_tmp_3,x1881_tmp_0,x1885_tmp_4) ,  Some(me), List(), 5, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2028.sm.io.ctrDone := risingEdge(x2028.sm.io.ctrInc)
      b1875_chain.connectStageCtrl((x2028.done).DS(1.toInt, rr, x2028.sm.io.backpressure), x2028.baseEn, 5)
      b1876_chain.connectStageCtrl((x2028.done).DS(1.toInt, rr, x2028.sm.io.backpressure), x2028.baseEn, 5)
      b1878_chain.connectStageCtrl((x2028.done).DS(1.toInt, rr, x2028.sm.io.backpressure), x2028.baseEn, 5)
      b1879_chain.connectStageCtrl((x2028.done).DS(1.toInt, rr, x2028.sm.io.backpressure), x2028.baseEn, 5)
      x2028.backpressure := true.B | x2028.sm.io.doneLatch
      x2028.forwardpressure := (true.B) && (true.B) | x2028.sm.io.doneLatch
      x2028.sm.io.enableOut.zip(x2028.smEnableOuts).foreach{case (l,r) => r := l}
      x2028.sm.io.break := false.B
      x2028.mask := true.B & b563
      x2028.configure("x2028", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2028.kernel()
      val x2029_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2030_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
      val x2031_ctrchain = (new CChainObject(List[CtrObject](x2029_ctr), "x2031_ctrchain")).cchain.io 
      x2031_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2031_ctrchain_p", (x2031_ctrchain.par, x2031_ctrchain.widths))
      val x2032_ctrchain = (new CChainObject(List[CtrObject](x2030_ctr), "x2032_ctrchain")).cchain.io 
      x2032_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2032_ctrchain_p", (x2032_ctrchain.par, x2032_ctrchain.widths))
      val x2061 = new x2061_kernel(List(b1879_chain_read_6,b1878_chain_read_6,b563), List(x2031_ctrchain,x2032_ctrchain), List(x1882_tmp_1,x1967_force_0,x1887_tmp_1,x1890_tmp_4,x1886_tmp_0,x1883_tmp_2,x1968_force_0,x1888_tmp_2,x1889_tmp_3,x1884_tmp_3,x1881_tmp_0,x1885_tmp_4) ,  Some(me), List(), 6, 2, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2061.sm.io.ctrDone := risingEdge(x2061.sm.io.ctrInc)
      b1875_chain.connectStageCtrl((x2061.done).DS(1.toInt, rr, x2061.sm.io.backpressure), x2061.baseEn, 6)
      b1876_chain.connectStageCtrl((x2061.done).DS(1.toInt, rr, x2061.sm.io.backpressure), x2061.baseEn, 6)
      b1878_chain.connectStageCtrl((x2061.done).DS(1.toInt, rr, x2061.sm.io.backpressure), x2061.baseEn, 6)
      b1879_chain.connectStageCtrl((x2061.done).DS(1.toInt, rr, x2061.sm.io.backpressure), x2061.baseEn, 6)
      x2061.backpressure := true.B | x2061.sm.io.doneLatch
      x2061.forwardpressure := (true.B) && (true.B) | x2061.sm.io.doneLatch
      x2061.sm.io.enableOut.zip(x2061.smEnableOuts).foreach{case (l,r) => r := l}
      x2061.sm.io.break := false.B
      x2061.mask := true.B & b563
      x2061.configure("x2061", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2061.kernel()
      val x2081_inr_Foreach = new x2081_inr_Foreach_kernel(List(b1879_chain_read_7,b563), List(b1875_chain_read_7), List(x579_accum_0), List(x1890_tmp_4,x580_accum_1,x1885_tmp_4) ,  Some(me), List(x623_ctrchain), 7, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2081_inr_Foreach.sm.io.ctrDone := (x2081_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      b1875_chain.connectStageCtrl((x2081_inr_Foreach.done).DS(1.toInt, rr, x2081_inr_Foreach.sm.io.backpressure), x2081_inr_Foreach.baseEn, 7)
      b1876_chain.connectStageCtrl((x2081_inr_Foreach.done).DS(1.toInt, rr, x2081_inr_Foreach.sm.io.backpressure), x2081_inr_Foreach.baseEn, 7)
      b1878_chain.connectStageCtrl((x2081_inr_Foreach.done).DS(1.toInt, rr, x2081_inr_Foreach.sm.io.backpressure), x2081_inr_Foreach.baseEn, 7)
      b1879_chain.connectStageCtrl((x2081_inr_Foreach.done).DS(1.toInt, rr, x2081_inr_Foreach.sm.io.backpressure), x2081_inr_Foreach.baseEn, 7)
      x2081_inr_Foreach.backpressure := true.B | x2081_inr_Foreach.sm.io.doneLatch
      x2081_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2081_inr_Foreach.sm.io.doneLatch
      x2081_inr_Foreach.sm.io.enableOut.zip(x2081_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2081_inr_Foreach.sm.io.break := false.B
      x2081_inr_Foreach.mask := ~x2081_inr_Foreach.cchain.head.output.noop & true.B
      x2081_inr_Foreach.configure("x2081_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2081_inr_Foreach.kernel()
    }
    val module = Module(new x2082_outr_Reduce_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledReduce x2082_outr_Reduce **/
