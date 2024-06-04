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

/** Hierarchy: x875 -> x897 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x875_inr_Foreach **/
class x875_inr_Foreach_kernel(
  list_b838: List[Bool],
  list_b548: List[FixedPoint],
  list_x841_tmp_0: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x875_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x875_inr_Foreach_iiCtr"))
  
  abstract class x875_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x841_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x841_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b838 = Input(Bool())
      val in_x842_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x842_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b558 = Input(Bool())
      val in_x843_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x843_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b548 = Input(new FixedPoint(true, 32, 0))
      val in_x845_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x845_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x844_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x844_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b835 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x841_tmp_0 = {io.in_x841_tmp_0} ; io.in_x841_tmp_0 := DontCare
    def b838 = {io.in_b838} 
    def x842_tmp_1 = {io.in_x842_tmp_1} ; io.in_x842_tmp_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b558 = {io.in_b558} 
    def x843_tmp_2 = {io.in_x843_tmp_2} ; io.in_x843_tmp_2 := DontCare
    def b548 = {io.in_b548} 
    def x845_tmp_4 = {io.in_x845_tmp_4} ; io.in_x845_tmp_4 := DontCare
    def x844_tmp_3 = {io.in_x844_tmp_3} ; io.in_x844_tmp_3 := DontCare
    def b835 = {io.in_b835} 
  }
  def connectWires0(module: x875_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x841_tmp_0.connectLedger(module.io.in_x841_tmp_0)
    module.io.in_b838 <> b838
    x842_tmp_1.connectLedger(module.io.in_x842_tmp_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b558 <> b558
    x843_tmp_2.connectLedger(module.io.in_x843_tmp_2)
    module.io.in_b548 <> b548
    x845_tmp_4.connectLedger(module.io.in_x845_tmp_4)
    x844_tmp_3.connectLedger(module.io.in_x844_tmp_3)
    module.io.in_b835 <> b835
  }
  val b838 = list_b838(0)
  val b558 = list_b838(1)
  val b548 = list_b548(0)
  val b835 = list_b548(1)
  val x841_tmp_0 = list_x841_tmp_0(0)
  val x842_tmp_1 = list_x841_tmp_0(1)
  val x843_tmp_2 = list_x841_tmp_0(2)
  val x845_tmp_4 = list_x841_tmp_0(3)
  val x844_tmp_3 = list_x841_tmp_0(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x875_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x875_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x875_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x875_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x875_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x875_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x875_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X875_instrctr, cycles_x875_inr_Foreach.io.count, iters_x875_inr_Foreach.io.count, 0.U, 0.U)
      val b855 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b855.suggestName("b855")
      val b856 = ~io.sigsIn.cchainOutputs.head.oobs(0); b856.suggestName("b856")
      val x858_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x858_div""")
      x858_div.r := (Math.div(b548, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x858_div")).r
      val x2989 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2989""")
      x2989.r := Math.arith_left_shift(x858_div, 1, Some(0.2), true.B,"x2989").r
      val x2990_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2990_sum""")
      x2990_sum.r := Math.add(x2989,x858_div,Some(1.0), true.B, Truncate, Wrapping, "x2990_sum").r
      val x3202 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3202_b855_D21") 
      x3202.r := getRetimed(b855.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x860_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x860_sum""")
      x860_sum.r := Math.add(x2990_sum,x3202,Some(1.0), true.B, Truncate, Wrapping, "x860_sum").r
      val x3203 = Wire(Bool()).suggestName("x3203_b838_D22") 
      x3203.r := getRetimed(b838.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3204 = Wire(Bool()).suggestName("x3204_b558_D22") 
      x3204.r := getRetimed(b558.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3205 = Wire(Bool()).suggestName("x3205_b856_D22") 
      x3205.r := getRetimed(b856.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x861_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x861_rd""")
      val x861_rd_banks = List[UInt](1L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x861_rd_ofs = List[UInt](x860_sum.r)
      val x861_rd_en = List[Bool](true.B)
      val x861_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3205 & x3203 & x3204 ).suggestName("x861_rd_shared_en")
      x861_rd.toSeq.zip(x471_A_sram_0.connectRPort(861, x861_rd_banks, x861_rd_ofs, io.sigsIn.backpressure, x861_rd_en.map(_ && x861_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x862 = VecApply(x861,0)
      val x862_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x862_elem_0""")
      x862_elem_0.r := x861_rd(0).r
      val x867_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x867_rd""")
      val x867_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x867_rd_ofs = List[UInt](0.U)
      val x867_rd_en = List[Bool](true.B)
      val x867_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x867_rd_shared_en")
      x867_rd.toSeq.zip(x472_A_sram_1.connectRPort(867, x867_rd_banks, x867_rd_ofs, io.sigsIn.backpressure, x867_rd_en.map(_ && x867_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x868 = VecApply(x867,0)
      val x868_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x868_elem_0""")
      x868_elem_0.r := x867_rd(0).r
      val x3210 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3210_x868_elem_0_D20") 
      x3210.r := getRetimed(x868_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x869_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x869_sub""")
      x869_sub.r := Math.sub(x862_elem_0,x3210,Some(1.0), true.B, Truncate, Wrapping, "x869_sub").r
      val x3211 = Wire(Bool()).suggestName("x3211_b838_D25") 
      x3211.r := getRetimed(b838.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3212 = Wire(Bool()).suggestName("x3212_b558_D25") 
      x3212.r := getRetimed(b558.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3213 = Wire(Bool()).suggestName("x3213_b856_D25") 
      x3213.r := getRetimed(b856.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3214 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3214_b855_D25") 
      x3214.r := getRetimed(b855.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x870_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x870_wr_ofs = List[UInt](x3214.r)
      val x870_wr_en = List[Bool](true.B)
      val x870_wr_data = List[UInt](x869_sub.r)
      x841_tmp_0.connectWPort(870, x870_wr_banks, x870_wr_ofs, x870_wr_data, x870_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3213 & x3211 & x3212))
      val x871_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x871_wr_ofs = List[UInt](x3214.r)
      val x871_wr_en = List[Bool](true.B)
      val x871_wr_data = List[UInt](x869_sub.r)
      x842_tmp_1.connectWPort(871, x871_wr_banks, x871_wr_ofs, x871_wr_data, x871_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3213 & x3211 & x3212))
      val x872_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x872_wr_ofs = List[UInt](x3214.r)
      val x872_wr_en = List[Bool](true.B)
      val x872_wr_data = List[UInt](x869_sub.r)
      x843_tmp_2.connectWPort(872, x872_wr_banks, x872_wr_ofs, x872_wr_data, x872_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3213 & x3211 & x3212))
      val x873_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x873_wr_ofs = List[UInt](x3214.r)
      val x873_wr_en = List[Bool](true.B)
      val x873_wr_data = List[UInt](x869_sub.r)
      x845_tmp_4.connectWPort(873, x873_wr_banks, x873_wr_ofs, x873_wr_data, x873_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3213 & x3211 & x3212))
      val x874_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x874_wr_ofs = List[UInt](x3214.r)
      val x874_wr_en = List[Bool](true.B)
      val x874_wr_data = List[UInt](x869_sub.r)
      x844_tmp_3.connectWPort(874, x874_wr_banks, x874_wr_ofs, x874_wr_data, x874_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3213 & x3211 & x3212))
    }
    val module = Module(new x875_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x875_inr_Foreach **/
