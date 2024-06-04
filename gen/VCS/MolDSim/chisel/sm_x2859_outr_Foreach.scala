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

/** Hierarchy: x2859 -> x444 **/
/** BEGIN None x2859_outr_Foreach **/
class x2859_outr_Foreach_kernel(
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Pipelined, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2859_outr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2859_outr_Foreach_iiCtr"))
  
  abstract class x2859_outr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(10), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
  }
  def connectWires0(module: x2859_outr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
  }
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x473_A_sram_2 = list_x472_A_sram_1(2)
  val x544_out_sram_0 = list_x472_A_sram_1(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2859_outr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2859_outr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2859_outr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2859_outr_Foreach = Module(new InstrumentationCounter())
      val iters_x2859_outr_Foreach = Module(new InstrumentationCounter())
      cycles_x2859_outr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2859_outr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2859_instrctr, cycles_x2859_outr_Foreach.io.count, iters_x2859_outr_Foreach.io.count, 0.U, 0.U)
      val b547 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b547.suggestName("b547")
      val b547_chain = Module(new RegChainPass(2, 32, myName = "b547_chain")); b547_chain.io <> DontCare
      b547_chain.chain_pass(b547, io.sigsOut.smDoneIn.head)
      val b547_chain_read_1 = b547_chain.read(1).FP(true,32,0)
      val b548 = io.sigsIn.cchainOutputs.head.counts(1).FP(true, 32, 0); b548.suggestName("b548")
      val b548_chain = Module(new RegChainPass(2, 32, myName = "b548_chain")); b548_chain.io <> DontCare
      b548_chain.chain_pass(b548, io.sigsOut.smDoneIn.head)
      val b548_chain_read_1 = b548_chain.read(1).FP(true,32,0)
      val b549 = io.sigsIn.cchainOutputs.head.counts(2).FP(true, 32, 0); b549.suggestName("b549")
      val b549_chain = Module(new RegChainPass(2, 32, myName = "b549_chain")); b549_chain.io <> DontCare
      b549_chain.chain_pass(b549, io.sigsOut.smDoneIn.head)
      val b549_chain_read_1 = b549_chain.read(1).FP(true,32,0)
      val b550 = io.sigsIn.cchainOutputs.head.counts(3).FP(true, 32, 0); b550.suggestName("b550")
      val b550_chain = Module(new RegChainPass(2, 32, myName = "b550_chain")); b550_chain.io <> DontCare
      b550_chain.chain_pass(b550, io.sigsOut.smDoneIn.head)
      val b550_chain_read_1 = b550_chain.read(1).FP(true,32,0)
      val b551 = io.sigsIn.cchainOutputs.head.counts(4).FP(true, 32, 0); b551.suggestName("b551")
      val b551_chain = Module(new RegChainPass(2, 32, myName = "b551_chain")); b551_chain.io <> DontCare
      b551_chain.chain_pass(b551, io.sigsOut.smDoneIn.head)
      val b551_chain_read_1 = b551_chain.read(1).FP(true,32,0)
      val b552 = io.sigsIn.cchainOutputs.head.counts(5).FP(true, 32, 0); b552.suggestName("b552")
      val b552_chain = Module(new RegChainPass(2, 32, myName = "b552_chain")); b552_chain.io <> DontCare
      b552_chain.chain_pass(b552, io.sigsOut.smDoneIn.head)
      val b552_chain_read_1 = b552_chain.read(1).FP(true,32,0)
      val b553 = io.sigsIn.cchainOutputs.head.counts(6).FP(true, 32, 0); b553.suggestName("b553")
      val b553_chain = Module(new RegChainPass(2, 32, myName = "b553_chain")); b553_chain.io <> DontCare
      b553_chain.chain_pass(b553, io.sigsOut.smDoneIn.head)
      val b553_chain_read_1 = b553_chain.read(1).FP(true,32,0)
      val b554 = io.sigsIn.cchainOutputs.head.counts(7).FP(true, 32, 0); b554.suggestName("b554")
      val b554_chain = Module(new RegChainPass(2, 32, myName = "b554_chain")); b554_chain.io <> DontCare
      b554_chain.chain_pass(b554, io.sigsOut.smDoneIn.head)
      val b554_chain_read_1 = b554_chain.read(1).FP(true,32,0)
      val b555 = io.sigsIn.cchainOutputs.head.counts(8).FP(true, 32, 0); b555.suggestName("b555")
      val b555_chain = Module(new RegChainPass(2, 32, myName = "b555_chain")); b555_chain.io <> DontCare
      b555_chain.chain_pass(b555, io.sigsOut.smDoneIn.head)
      val b555_chain_read_1 = b555_chain.read(1).FP(true,32,0)
      val b556 = io.sigsIn.cchainOutputs.head.counts(9).FP(true, 32, 0); b556.suggestName("b556")
      val b556_chain = Module(new RegChainPass(2, 32, myName = "b556_chain")); b556_chain.io <> DontCare
      b556_chain.chain_pass(b556, io.sigsOut.smDoneIn.head)
      val b556_chain_read_1 = b556_chain.read(1).FP(true,32,0)
      val b557 = ~io.sigsIn.cchainOutputs.head.oobs(0); b557.suggestName("b557")
      val b557_chain = Module(new RegChainPass(2, 1, myName = "b557_chain")); b557_chain.io <> DontCare
      b557_chain.chain_pass(b557, io.sigsOut.smDoneIn.head)
      val b557_chain_read_1: Bool = b557_chain.read(1).apply(0)
      val b558 = ~io.sigsIn.cchainOutputs.head.oobs(1); b558.suggestName("b558")
      val b558_chain = Module(new RegChainPass(2, 1, myName = "b558_chain")); b558_chain.io <> DontCare
      b558_chain.chain_pass(b558, io.sigsOut.smDoneIn.head)
      val b558_chain_read_1: Bool = b558_chain.read(1).apply(0)
      val b559 = ~io.sigsIn.cchainOutputs.head.oobs(2); b559.suggestName("b559")
      val b559_chain = Module(new RegChainPass(2, 1, myName = "b559_chain")); b559_chain.io <> DontCare
      b559_chain.chain_pass(b559, io.sigsOut.smDoneIn.head)
      val b559_chain_read_1: Bool = b559_chain.read(1).apply(0)
      val b560 = ~io.sigsIn.cchainOutputs.head.oobs(3); b560.suggestName("b560")
      val b560_chain = Module(new RegChainPass(2, 1, myName = "b560_chain")); b560_chain.io <> DontCare
      b560_chain.chain_pass(b560, io.sigsOut.smDoneIn.head)
      val b560_chain_read_1: Bool = b560_chain.read(1).apply(0)
      val b561 = ~io.sigsIn.cchainOutputs.head.oobs(4); b561.suggestName("b561")
      val b561_chain = Module(new RegChainPass(2, 1, myName = "b561_chain")); b561_chain.io <> DontCare
      b561_chain.chain_pass(b561, io.sigsOut.smDoneIn.head)
      val b561_chain_read_1: Bool = b561_chain.read(1).apply(0)
      val b562 = ~io.sigsIn.cchainOutputs.head.oobs(5); b562.suggestName("b562")
      val b562_chain = Module(new RegChainPass(2, 1, myName = "b562_chain")); b562_chain.io <> DontCare
      b562_chain.chain_pass(b562, io.sigsOut.smDoneIn.head)
      val b562_chain_read_1: Bool = b562_chain.read(1).apply(0)
      val b563 = ~io.sigsIn.cchainOutputs.head.oobs(6); b563.suggestName("b563")
      val b563_chain = Module(new RegChainPass(2, 1, myName = "b563_chain")); b563_chain.io <> DontCare
      b563_chain.chain_pass(b563, io.sigsOut.smDoneIn.head)
      val b563_chain_read_1: Bool = b563_chain.read(1).apply(0)
      val b564 = ~io.sigsIn.cchainOutputs.head.oobs(7); b564.suggestName("b564")
      val b564_chain = Module(new RegChainPass(2, 1, myName = "b564_chain")); b564_chain.io <> DontCare
      b564_chain.chain_pass(b564, io.sigsOut.smDoneIn.head)
      val b564_chain_read_1: Bool = b564_chain.read(1).apply(0)
      val b565 = ~io.sigsIn.cchainOutputs.head.oobs(8); b565.suggestName("b565")
      val b565_chain = Module(new RegChainPass(2, 1, myName = "b565_chain")); b565_chain.io <> DontCare
      b565_chain.chain_pass(b565, io.sigsOut.smDoneIn.head)
      val b565_chain_read_1: Bool = b565_chain.read(1).apply(0)
      val b566 = ~io.sigsIn.cchainOutputs.head.oobs(9); b566.suggestName("b566")
      val b566_chain = Module(new RegChainPass(2, 1, myName = "b566_chain")); b566_chain.io <> DontCare
      b566_chain.chain_pass(b566, io.sigsOut.smDoneIn.head)
      val b566_chain_read_1: Bool = b566_chain.read(1).apply(0)
      object Block1Chunker0 { // 49 nodes, 49 weight
        def gen(): Map[String, Any] = {
          val x567_accum_0 = (new x567_accum_0).m.io.asInstanceOf[StandardInterface]
          val x568_accum_1 = (new x568_accum_1).m.io.asInstanceOf[NBufInterface]
          val x569_accum_0 = (new x569_accum_0).m.io.asInstanceOf[StandardInterface]
          val x570_accum_1 = (new x570_accum_1).m.io.asInstanceOf[NBufInterface]
          val x571_accum_0 = (new x571_accum_0).m.io.asInstanceOf[StandardInterface]
          val x572_accum_1 = (new x572_accum_1).m.io.asInstanceOf[NBufInterface]
          val x573_accum_0 = (new x573_accum_0).m.io.asInstanceOf[StandardInterface]
          val x574_accum_1 = (new x574_accum_1).m.io.asInstanceOf[NBufInterface]
          val x575_accum_0 = (new x575_accum_0).m.io.asInstanceOf[StandardInterface]
          val x576_accum_1 = (new x576_accum_1).m.io.asInstanceOf[NBufInterface]
          val x577_accum_0 = (new x577_accum_0).m.io.asInstanceOf[StandardInterface]
          val x578_accum_1 = (new x578_accum_1).m.io.asInstanceOf[NBufInterface]
          val x579_accum_0 = (new x579_accum_0).m.io.asInstanceOf[StandardInterface]
          val x580_accum_1 = (new x580_accum_1).m.io.asInstanceOf[NBufInterface]
          val x581_accum_0 = (new x581_accum_0).m.io.asInstanceOf[StandardInterface]
          val x582_accum_1 = (new x582_accum_1).m.io.asInstanceOf[NBufInterface]
          val x583_accum_0 = (new x583_accum_0).m.io.asInstanceOf[StandardInterface]
          val x584_accum_1 = (new x584_accum_1).m.io.asInstanceOf[NBufInterface]
          val x585_accum_0 = (new x585_accum_0).m.io.asInstanceOf[StandardInterface]
          val x586_accum_1 = (new x586_accum_1).m.io.asInstanceOf[NBufInterface]
          val x587_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x588_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x589_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x590_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x591_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x592_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x593_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x594_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x595_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x596_ctr = new CtrObject(Left(Some(0)), Left(Some(100)), Left(Some(1)), 2, 9, false)
          val x597_ctrchain = (new CChainObject(List[CtrObject](x587_ctr), "x597_ctrchain")).cchain.io 
          x597_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x597_ctrchain_p", (x597_ctrchain.par, x597_ctrchain.widths))
          val x598_ctrchain = (new CChainObject(List[CtrObject](x588_ctr), "x598_ctrchain")).cchain.io 
          x598_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x598_ctrchain_p", (x598_ctrchain.par, x598_ctrchain.widths))
          val x599_ctrchain = (new CChainObject(List[CtrObject](x589_ctr), "x599_ctrchain")).cchain.io 
          x599_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x599_ctrchain_p", (x599_ctrchain.par, x599_ctrchain.widths))
          val x600_ctrchain = (new CChainObject(List[CtrObject](x590_ctr), "x600_ctrchain")).cchain.io 
          x600_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x600_ctrchain_p", (x600_ctrchain.par, x600_ctrchain.widths))
          val x601_ctrchain = (new CChainObject(List[CtrObject](x591_ctr), "x601_ctrchain")).cchain.io 
          x601_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x601_ctrchain_p", (x601_ctrchain.par, x601_ctrchain.widths))
          val x602_ctrchain = (new CChainObject(List[CtrObject](x592_ctr), "x602_ctrchain")).cchain.io 
          x602_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x602_ctrchain_p", (x602_ctrchain.par, x602_ctrchain.widths))
          val x603_ctrchain = (new CChainObject(List[CtrObject](x593_ctr), "x603_ctrchain")).cchain.io 
          x603_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x603_ctrchain_p", (x603_ctrchain.par, x603_ctrchain.widths))
          val x604_ctrchain = (new CChainObject(List[CtrObject](x594_ctr), "x604_ctrchain")).cchain.io 
          x604_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x604_ctrchain_p", (x604_ctrchain.par, x604_ctrchain.widths))
          val x605_ctrchain = (new CChainObject(List[CtrObject](x595_ctr), "x605_ctrchain")).cchain.io 
          x605_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x605_ctrchain_p", (x605_ctrchain.par, x605_ctrchain.widths))
          val x606_ctrchain = (new CChainObject(List[CtrObject](x596_ctr), "x606_ctrchain")).cchain.io 
          x606_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x606_ctrchain_p", (x606_ctrchain.par, x606_ctrchain.widths))
          val x607_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x608_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x609_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x610_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x611_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x612_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x613_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x614_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x615_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          Map[String,Any]("x567_accum_0" -> x567_accum_0, "x568_accum_1" -> x568_accum_1, "x569_accum_0" -> x569_accum_0, "x570_accum_1" -> x570_accum_1, "x571_accum_0" -> x571_accum_0, "x572_accum_1" -> x572_accum_1, "x573_accum_0" -> x573_accum_0, "x574_accum_1" -> x574_accum_1, "x575_accum_0" -> x575_accum_0, "x576_accum_1" -> x576_accum_1, "x577_accum_0" -> x577_accum_0, "x578_accum_1" -> x578_accum_1, "x579_accum_0" -> x579_accum_0, "x580_accum_1" -> x580_accum_1, "x581_accum_0" -> x581_accum_0, "x582_accum_1" -> x582_accum_1, "x583_accum_0" -> x583_accum_0, "x584_accum_1" -> x584_accum_1, "x585_accum_0" -> x585_accum_0, "x586_accum_1" -> x586_accum_1, "x597_ctrchain" -> x597_ctrchain, "x598_ctrchain" -> x598_ctrchain, "x599_ctrchain" -> x599_ctrchain, "x600_ctrchain" -> x600_ctrchain, "x601_ctrchain" -> x601_ctrchain, "x602_ctrchain" -> x602_ctrchain, "x603_ctrchain" -> x603_ctrchain, "x604_ctrchain" -> x604_ctrchain, "x605_ctrchain" -> x605_ctrchain, "x606_ctrchain" -> x606_ctrchain, "x607_ctr" -> x607_ctr, "x608_ctr" -> x608_ctr, "x609_ctr" -> x609_ctr, "x610_ctr" -> x610_ctr, "x611_ctr" -> x611_ctr, "x612_ctr" -> x612_ctr, "x613_ctr" -> x613_ctr, "x614_ctr" -> x614_ctr, "x615_ctr" -> x615_ctr)
        }
      }
      val block1chunk0: Map[String, Any] = Block1Chunker0.gen()
      object Block1Chunker1 { // 33 nodes, 33 weight
        def gen(): Map[String, Any] = {
          val x616_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x617_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x607_ctr").asInstanceOf[CtrObject]), "x617_ctrchain")).cchain.io 
          x617_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x617_ctrchain_p", (x617_ctrchain.par, x617_ctrchain.widths))
          val x618_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x608_ctr").asInstanceOf[CtrObject]), "x618_ctrchain")).cchain.io 
          x618_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x618_ctrchain_p", (x618_ctrchain.par, x618_ctrchain.widths))
          val x619_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x609_ctr").asInstanceOf[CtrObject]), "x619_ctrchain")).cchain.io 
          x619_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x619_ctrchain_p", (x619_ctrchain.par, x619_ctrchain.widths))
          val x620_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x610_ctr").asInstanceOf[CtrObject]), "x620_ctrchain")).cchain.io 
          x620_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x620_ctrchain_p", (x620_ctrchain.par, x620_ctrchain.widths))
          val x621_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x611_ctr").asInstanceOf[CtrObject]), "x621_ctrchain")).cchain.io 
          x621_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x621_ctrchain_p", (x621_ctrchain.par, x621_ctrchain.widths))
          val x622_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x612_ctr").asInstanceOf[CtrObject]), "x622_ctrchain")).cchain.io 
          x622_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x622_ctrchain_p", (x622_ctrchain.par, x622_ctrchain.widths))
          val x623_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x613_ctr").asInstanceOf[CtrObject]), "x623_ctrchain")).cchain.io 
          x623_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x623_ctrchain_p", (x623_ctrchain.par, x623_ctrchain.widths))
          val x624_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x614_ctr").asInstanceOf[CtrObject]), "x624_ctrchain")).cchain.io 
          x624_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x624_ctrchain_p", (x624_ctrchain.par, x624_ctrchain.widths))
          val x625_ctrchain = (new CChainObject(List[CtrObject](block1chunk0("x615_ctr").asInstanceOf[CtrObject]), "x625_ctrchain")).cchain.io 
          x625_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x625_ctrchain_p", (x625_ctrchain.par, x625_ctrchain.widths))
          val x626_ctrchain = (new CChainObject(List[CtrObject](x616_ctr), "x626_ctrchain")).cchain.io 
          x626_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x626_ctrchain_p", (x626_ctrchain.par, x626_ctrchain.widths))
          val x2707 = new x2707_kernel(List(x472_A_sram_1,block1chunk0("x583_accum_0").asInstanceOf[StandardInterface],x471_A_sram_0,block1chunk0("x569_accum_0").asInstanceOf[StandardInterface],block1chunk0("x573_accum_0").asInstanceOf[StandardInterface],block1chunk0("x577_accum_0").asInstanceOf[StandardInterface],block1chunk0("x579_accum_0").asInstanceOf[StandardInterface],block1chunk0("x567_accum_0").asInstanceOf[StandardInterface],block1chunk0("x585_accum_0").asInstanceOf[StandardInterface],block1chunk0("x571_accum_0").asInstanceOf[StandardInterface],block1chunk0("x581_accum_0").asInstanceOf[StandardInterface],block1chunk0("x575_accum_0").asInstanceOf[StandardInterface]), List(block1chunk0("x582_accum_1").asInstanceOf[NBufInterface],block1chunk0("x570_accum_1").asInstanceOf[NBufInterface],block1chunk0("x574_accum_1").asInstanceOf[NBufInterface],block1chunk0("x578_accum_1").asInstanceOf[NBufInterface],block1chunk0("x586_accum_1").asInstanceOf[NBufInterface],block1chunk0("x584_accum_1").asInstanceOf[NBufInterface],block1chunk0("x572_accum_1").asInstanceOf[NBufInterface],block1chunk0("x580_accum_1").asInstanceOf[NBufInterface],block1chunk0("x576_accum_1").asInstanceOf[NBufInterface],block1chunk0("x568_accum_1").asInstanceOf[NBufInterface]), List(b565,b559,b561,b566,b558,b562,b563,b557,b564,b560), List(b555,b550,b551,b554,b547,b552,b548,b553,b556,b549), List(block1chunk0("x597_ctrchain").asInstanceOf[CounterChainInterface],x619_ctrchain,block1chunk0("x606_ctrchain").asInstanceOf[CounterChainInterface],x623_ctrchain,block1chunk0("x602_ctrchain").asInstanceOf[CounterChainInterface],block1chunk0("x598_ctrchain").asInstanceOf[CounterChainInterface],x625_ctrchain,x622_ctrchain,block1chunk0("x605_ctrchain").asInstanceOf[CounterChainInterface],x618_ctrchain,block1chunk0("x601_ctrchain").asInstanceOf[CounterChainInterface],block1chunk0("x604_ctrchain").asInstanceOf[CounterChainInterface],block1chunk0("x599_ctrchain").asInstanceOf[CounterChainInterface],x621_ctrchain,x626_ctrchain,x617_ctrchain,block1chunk0("x600_ctrchain").asInstanceOf[CounterChainInterface],x620_ctrchain,block1chunk0("x603_ctrchain").asInstanceOf[CounterChainInterface],x624_ctrchain) ,  Some(me), List(), 0, 10, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
          x2707.sm.io.ctrDone := risingEdge(x2707.sm.io.ctrInc)
          b547_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b548_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b549_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b550_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b551_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b552_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b553_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b554_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b555_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b556_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b557_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b558_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b559_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b560_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b561_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b562_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b563_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b564_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b565_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          b566_chain.connectStageCtrl((x2707.done).DS(1.toInt, rr, x2707.sm.io.backpressure), x2707.baseEn, 0)
          x2707.backpressure := true.B | x2707.sm.io.doneLatch
          x2707.forwardpressure := (true.B) && (true.B) | x2707.sm.io.doneLatch
          x2707.sm.io.enableOut.zip(x2707.smEnableOuts).foreach{case (l,r) => r := l}
          x2707.sm.io.break := false.B
          x2707.mask := true.B & true.B
          x2707.configure("x2707", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
          x2707.kernel()
          val x2708_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2709_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2710_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2711_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2712_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2713_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2714_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2715_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2716_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2717_ctr = new CtrObject(Left(Some(0)), Left(Some(3)), Left(Some(1)), 1, 4, false)
          val x2718_ctrchain = (new CChainObject(List[CtrObject](x2708_ctr), "x2718_ctrchain")).cchain.io 
          x2718_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2718_ctrchain_p", (x2718_ctrchain.par, x2718_ctrchain.widths))
          val x2719_ctrchain = (new CChainObject(List[CtrObject](x2709_ctr), "x2719_ctrchain")).cchain.io 
          x2719_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2719_ctrchain_p", (x2719_ctrchain.par, x2719_ctrchain.widths))
          val x2720_ctrchain = (new CChainObject(List[CtrObject](x2710_ctr), "x2720_ctrchain")).cchain.io 
          x2720_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2720_ctrchain_p", (x2720_ctrchain.par, x2720_ctrchain.widths))
          val x2721_ctrchain = (new CChainObject(List[CtrObject](x2711_ctr), "x2721_ctrchain")).cchain.io 
          x2721_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2721_ctrchain_p", (x2721_ctrchain.par, x2721_ctrchain.widths))
          val x2722_ctrchain = (new CChainObject(List[CtrObject](x2712_ctr), "x2722_ctrchain")).cchain.io 
          x2722_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2722_ctrchain_p", (x2722_ctrchain.par, x2722_ctrchain.widths))
          val x2723_ctrchain = (new CChainObject(List[CtrObject](x2713_ctr), "x2723_ctrchain")).cchain.io 
          x2723_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2723_ctrchain_p", (x2723_ctrchain.par, x2723_ctrchain.widths))
          val x2724_ctrchain = (new CChainObject(List[CtrObject](x2714_ctr), "x2724_ctrchain")).cchain.io 
          x2724_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2724_ctrchain_p", (x2724_ctrchain.par, x2724_ctrchain.widths))
          val x2725_ctrchain = (new CChainObject(List[CtrObject](x2715_ctr), "x2725_ctrchain")).cchain.io 
          x2725_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2725_ctrchain_p", (x2725_ctrchain.par, x2725_ctrchain.widths))
          val x2726_ctrchain = (new CChainObject(List[CtrObject](x2716_ctr), "x2726_ctrchain")).cchain.io 
          x2726_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2726_ctrchain_p", (x2726_ctrchain.par, x2726_ctrchain.widths))
          val x2727_ctrchain = (new CChainObject(List[CtrObject](x2717_ctr), "x2727_ctrchain")).cchain.io 
          x2727_ctrchain.setup.isStream := false.B
          ModuleParams.addParams("x2727_ctrchain_p", (x2727_ctrchain.par, x2727_ctrchain.widths))
          val x2858 = new x2858_kernel(List(block1chunk0("x582_accum_1").asInstanceOf[NBufInterface],block1chunk0("x570_accum_1").asInstanceOf[NBufInterface],block1chunk0("x574_accum_1").asInstanceOf[NBufInterface],block1chunk0("x578_accum_1").asInstanceOf[NBufInterface],block1chunk0("x586_accum_1").asInstanceOf[NBufInterface],block1chunk0("x584_accum_1").asInstanceOf[NBufInterface],block1chunk0("x572_accum_1").asInstanceOf[NBufInterface],block1chunk0("x580_accum_1").asInstanceOf[NBufInterface],block1chunk0("x576_accum_1").asInstanceOf[NBufInterface],block1chunk0("x568_accum_1").asInstanceOf[NBufInterface]), List(x473_A_sram_2,x544_out_sram_0), List(x2723_ctrchain,x2718_ctrchain,x2726_ctrchain,x2724_ctrchain,x2727_ctrchain,x2721_ctrchain,x2725_ctrchain,x2720_ctrchain,x2722_ctrchain,x2719_ctrchain), List(b565_chain_read_1,b559_chain_read_1,b561_chain_read_1,b566_chain_read_1,b558_chain_read_1,b562_chain_read_1,b563_chain_read_1,b557_chain_read_1,b564_chain_read_1,b560_chain_read_1), List(b555_chain_read_1,b550_chain_read_1,b551_chain_read_1,b554_chain_read_1,b547_chain_read_1,b552_chain_read_1,b548_chain_read_1,b553_chain_read_1,b556_chain_read_1,b549_chain_read_1) ,  Some(me), List(), 1, 10, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
          x2858.sm.io.ctrDone := risingEdge(x2858.sm.io.ctrInc)
          b547_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b548_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b549_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b550_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b551_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b552_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b553_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b554_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b555_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b556_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b557_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b558_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b559_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b560_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b561_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b562_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b563_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b564_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b565_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          b566_chain.connectStageCtrl((x2858.done).DS(1.toInt, rr, x2858.sm.io.backpressure), x2858.baseEn, 1)
          x2858.backpressure := true.B | x2858.sm.io.doneLatch
          x2858.forwardpressure := (true.B) && (true.B) | x2858.sm.io.doneLatch
          x2858.sm.io.enableOut.zip(x2858.smEnableOuts).foreach{case (l,r) => r := l}
          x2858.sm.io.break := false.B
          x2858.mask := true.B & true.B
          x2858.configure("x2858", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
          x2858.kernel()
          Map[String,Any]()
        }
      }
      val block1chunk1: Map[String, Any] = Block1Chunker1.gen()
    }
    val module = Module(new x2859_outr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2859_outr_Foreach **/
