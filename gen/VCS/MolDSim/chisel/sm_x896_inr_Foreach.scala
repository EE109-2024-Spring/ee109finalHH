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

/** Hierarchy: x896 -> x897 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x896_inr_Foreach **/
class x896_inr_Foreach_kernel(
  list_b558: List[Bool],
  list_b548: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x846_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x896_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x896_inr_Foreach_iiCtr"))
  
  abstract class x896_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x846_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x846_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x849_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x849_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x847_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x847_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b558 = Input(Bool())
      val in_x848_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x848_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b548 = Input(new FixedPoint(true, 32, 0))
      val in_b836 = Input(new FixedPoint(true, 32, 0))
      val in_b839 = Input(Bool())
      val in_x850_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x850_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x846_tmp_0 = {io.in_x846_tmp_0} ; io.in_x846_tmp_0 := DontCare
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x849_tmp_3 = {io.in_x849_tmp_3} ; io.in_x849_tmp_3 := DontCare
    def x847_tmp_1 = {io.in_x847_tmp_1} ; io.in_x847_tmp_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b558 = {io.in_b558} 
    def x848_tmp_2 = {io.in_x848_tmp_2} ; io.in_x848_tmp_2 := DontCare
    def b548 = {io.in_b548} 
    def b836 = {io.in_b836} 
    def b839 = {io.in_b839} 
    def x850_tmp_4 = {io.in_x850_tmp_4} ; io.in_x850_tmp_4 := DontCare
  }
  def connectWires0(module: x896_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x846_tmp_0.connectLedger(module.io.in_x846_tmp_0)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x849_tmp_3.connectLedger(module.io.in_x849_tmp_3)
    x847_tmp_1.connectLedger(module.io.in_x847_tmp_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b558 <> b558
    x848_tmp_2.connectLedger(module.io.in_x848_tmp_2)
    module.io.in_b548 <> b548
    module.io.in_b836 <> b836
    module.io.in_b839 <> b839
    x850_tmp_4.connectLedger(module.io.in_x850_tmp_4)
  }
  val b558 = list_b558(0)
  val b839 = list_b558(1)
  val b548 = list_b548(0)
  val b836 = list_b548(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x846_tmp_0 = list_x846_tmp_0(0)
  val x849_tmp_3 = list_x846_tmp_0(1)
  val x847_tmp_1 = list_x846_tmp_0(2)
  val x848_tmp_2 = list_x846_tmp_0(3)
  val x850_tmp_4 = list_x846_tmp_0(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x896_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x896_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x896_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x896_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x896_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x896_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x896_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X896_instrctr, cycles_x896_inr_Foreach.io.count, iters_x896_inr_Foreach.io.count, 0.U, 0.U)
      val b876 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b876.suggestName("b876")
      val b877 = ~io.sigsIn.cchainOutputs.head.oobs(0); b877.suggestName("b877")
      val x882_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x882_rd""")
      val x882_rd_banks = List[UInt](0.U,0.U)
      val x882_rd_ofs = List[UInt](0.U)
      val x882_rd_en = List[Bool](true.B)
      val x882_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x882_rd_shared_en")
      x882_rd.toSeq.zip(x471_A_sram_0.connectRPort(882, x882_rd_banks, x882_rd_ofs, io.sigsIn.backpressure, x882_rd_en.map(_ && x882_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x883 = VecApply(x882,0)
      val x883_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x883_elem_0""")
      x883_elem_0.r := x882_rd(0).r
      val x888_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x888_rd""")
      val x888_rd_banks = List[UInt](0.U,0.U)
      val x888_rd_ofs = List[UInt](0.U)
      val x888_rd_en = List[Bool](true.B)
      val x888_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x888_rd_shared_en")
      x888_rd.toSeq.zip(x472_A_sram_1.connectRPort(888, x888_rd_banks, x888_rd_ofs, io.sigsIn.backpressure, x888_rd_en.map(_ && x888_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x889 = VecApply(x888,0)
      val x889_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x889_elem_0""")
      x889_elem_0.r := x888_rd(0).r
      val x3223 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3223_x889_elem_0_D20") 
      x3223.r := getRetimed(x889_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x890_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x890_sub""")
      x890_sub.r := Math.sub(x883_elem_0,x3223,Some(1.0), true.B, Truncate, Wrapping, "x890_sub").r
      val x3224 = Wire(Bool()).suggestName("x3224_b877_D25") 
      x3224.r := getRetimed(b877.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3225 = Wire(Bool()).suggestName("x3225_b558_D25") 
      x3225.r := getRetimed(b558.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3226 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3226_b876_D25") 
      x3226.r := getRetimed(b876.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3227 = Wire(Bool()).suggestName("x3227_b839_D25") 
      x3227.r := getRetimed(b839.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x891_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x891_wr_ofs = List[UInt](x3226.r)
      val x891_wr_en = List[Bool](true.B)
      val x891_wr_data = List[UInt](x890_sub.r)
      x846_tmp_0.connectWPort(891, x891_wr_banks, x891_wr_ofs, x891_wr_data, x891_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3224 & x3227 & x3225))
      val x892_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x892_wr_ofs = List[UInt](x3226.r)
      val x892_wr_en = List[Bool](true.B)
      val x892_wr_data = List[UInt](x890_sub.r)
      x849_tmp_3.connectWPort(892, x892_wr_banks, x892_wr_ofs, x892_wr_data, x892_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3224 & x3227 & x3225))
      val x893_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x893_wr_ofs = List[UInt](x3226.r)
      val x893_wr_en = List[Bool](true.B)
      val x893_wr_data = List[UInt](x890_sub.r)
      x847_tmp_1.connectWPort(893, x893_wr_banks, x893_wr_ofs, x893_wr_data, x893_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3224 & x3227 & x3225))
      val x894_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x894_wr_ofs = List[UInt](x3226.r)
      val x894_wr_en = List[Bool](true.B)
      val x894_wr_data = List[UInt](x890_sub.r)
      x848_tmp_2.connectWPort(894, x894_wr_banks, x894_wr_ofs, x894_wr_data, x894_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3224 & x3227 & x3225))
      val x895_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x895_wr_ofs = List[UInt](x3226.r)
      val x895_wr_en = List[Bool](true.B)
      val x895_wr_data = List[UInt](x890_sub.r)
      x850_tmp_4.connectWPort(895, x895_wr_banks, x895_wr_ofs, x895_wr_data, x895_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3224 & x3227 & x3225))
    }
    val module = Module(new x896_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x896_inr_Foreach **/
