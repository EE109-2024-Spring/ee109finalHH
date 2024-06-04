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

/** Hierarchy: x2909 -> x2910 -> x2915 -> x2916 -> x444 **/
/** BEGIN None x2909_inr_Foreach **/
class x2909_inr_Foreach_kernel(
  list_b2865: List[FixedPoint],
  list_x2868_reg: List[StandardInterface],
  list_x2861: List[DecoupledIO[AppStoreData]],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 24.2.toInt, myName = "x2909_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2909_inr_Foreach_iiCtr"))
  
  abstract class x2909_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2861 = Decoupled(new AppStoreData(ModuleParams.getParams("x2861_p").asInstanceOf[(Int,Int)] ))
      val in_x2868_reg = Flipped(new StandardInterface(ModuleParams.getParams("x2868_reg_p").asInstanceOf[MemParams] ))
      val in_x2867_reg = Flipped(new StandardInterface(ModuleParams.getParams("x2867_reg_p").asInstanceOf[MemParams] ))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_b2865 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x2861 = {io.in_x2861} 
    def x2868_reg = {io.in_x2868_reg} ; io.in_x2868_reg := DontCare
    def x2867_reg = {io.in_x2867_reg} ; io.in_x2867_reg := DontCare
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def b2865 = {io.in_b2865} 
  }
  def connectWires0(module: x2909_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2861 <> x2861
    x2868_reg.connectLedger(module.io.in_x2868_reg)
    x2867_reg.connectLedger(module.io.in_x2867_reg)
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    module.io.in_b2865 <> b2865
  }
  val b2865 = list_b2865(0)
  val x2868_reg = list_x2868_reg(0)
  val x2867_reg = list_x2868_reg(1)
  val x544_out_sram_0 = list_x2868_reg(2)
  val x2861 = list_x2861(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2909_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2909_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2909_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2909_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2909_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2909_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2909_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      val stalls_x2909_inr_Foreach = Module(new InstrumentationCounter())
      val idles_x2909_inr_Foreach = Module(new InstrumentationCounter())
      stalls_x2909_inr_Foreach.io.enable := io.sigsIn.baseEn & ~(x2861.ready)
      idles_x2909_inr_Foreach.io.enable := io.sigsIn.baseEn & ~((true.B) && (true.B))
      Ledger.tieInstrCtr(instrctrs.toList, X2909_instrctr, cycles_x2909_inr_Foreach.io.count, iters_x2909_inr_Foreach.io.count, stalls_x2909_inr_Foreach.io.count, idles_x2909_inr_Foreach.io.count)
      val b2893 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2893.suggestName("b2893")
      val b2894 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2894.suggestName("b2894")
      val x2895_rd_x2867 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2895_rd_x2867""")
      val x2895_rd_x2867_banks = List[UInt]()
      val x2895_rd_x2867_ofs = List[UInt]()
      val x2895_rd_x2867_en = List[Bool](true.B)
      val x2895_rd_x2867_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2895_rd_x2867_shared_en")
      x2895_rd_x2867.toSeq.zip(x2867_reg.connectRPort(2895, x2895_rd_x2867_banks, x2895_rd_x2867_ofs, io.sigsIn.backpressure, x2895_rd_x2867_en.map(_ && x2895_rd_x2867_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2896 = Wire(Bool()).suggestName("""x2896""")
      val ensig0 = Wire(Bool())
      ensig0 := x2861.ready
      x2896.r := Math.lte(x2895_rd_x2867, b2893, Some(0.4), ensig0,"x2896").r
      val x2897_rd_x2868 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2897_rd_x2868""")
      val x2897_rd_x2868_banks = List[UInt]()
      val x2897_rd_x2868_ofs = List[UInt]()
      val x2897_rd_x2868_en = List[Bool](true.B)
      val x2897_rd_x2868_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2897_rd_x2868_shared_en")
      x2897_rd_x2868.toSeq.zip(x2868_reg.connectRPort(2897, x2897_rd_x2868_banks, x2897_rd_x2868_ofs, io.sigsIn.backpressure, x2897_rd_x2868_en.map(_ && x2897_rd_x2868_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2898 = Wire(Bool()).suggestName("""x2898""")
      x2898.r := Math.lt(b2893, x2897_rd_x2868, Some(0.4), ensig0,"x2898").r
      val x2899 = Wire(Bool()).suggestName("""x2899""")
      x2899 := x2896 & x2898
      val x2900_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2900_sub""")
      x2900_sub.r := Math.sub(b2893,x2895_rd_x2867,Some(1.0), ensig0, Truncate, Wrapping, "x2900_sub").r
      val x2901 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2901""")
      x2901.r := (Math.mod(b2865, 10L.FP(true, 32, 0), Some(16.0), ensig0, Truncate, Wrapping, "x2901")).r
      val x2902_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2902_div""")
      x2902_div.r := (Math.div(b2865, 10L.FP(true, 32, 0), Some(20.0), ensig0, Truncate, Wrapping, "x2902_div")).r
      val x3121 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3121""")
      x3121.r := Math.arith_left_shift(x2902_div, 1, Some(0.2), ensig0,"x3121").r
      val x3122_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3122_sum""")
      x3122_sum.r := Math.add(x3121,x2902_div,Some(1.0), ensig0, Truncate, Wrapping, "x3122_sum").r
      val x3824 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3824_x2900_sub_D20") 
      x3824.r := getRetimed(x2900_sub.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x2904_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2904_sum""")
      x2904_sum.r := Math.add(x3122_sum,x3824,Some(1.0), ensig0, Truncate, Wrapping, "x2904_sum").r
      val x3825 = Wire(Bool()).suggestName("x3825_x2899_D22") 
      x3825.r := getRetimed(x2899.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3826 = Wire(Bool()).suggestName("x3826_b2894_D22") 
      x3826.r := getRetimed(b2894.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3827 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3827_x2901_D6") 
      x3827.r := getRetimed(x2901.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2905_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2905_rd""")
      val x2905_rd_banks = List[UInt](x3827.r,0L.FP(true, 32, 0).r)
      val x2905_rd_ofs = List[UInt](x2904_sum.r)
      val x2905_rd_en = List[Bool](true.B)
      val x2905_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3825 & x3826 ).suggestName("x2905_rd_shared_en")
      x2905_rd.toSeq.zip(x544_out_sram_0.connectRPort(2905, x2905_rd_banks, x2905_rd_ofs, io.sigsIn.backpressure, x2905_rd_en.map(_ && x2905_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2906 = VecApply(x2905,0)
      val x2906_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2906_elem_0""")
      x2906_elem_0.r := x2905_rd(0).r
      val x3828 = Wire(Bool()).suggestName("x3828_x2899_D24") 
      x3828.r := getRetimed(x2899.r, 24.toInt, io.sigsIn.backpressure & true.B)
      val x2907_tuple = Wire(UInt(33.W)).suggestName("""x2907_tuple""")
      x2907_tuple.r := ConvAndCat(x3828,x2906_elem_0.r)
      val x3829 = Wire(Bool()).suggestName("x3829_b2894_D24") 
      x3829.r := getRetimed(b2894.r, 24.toInt, io.sigsIn.backpressure & true.B)
      x2861.valid := (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(24.2.toInt.toInt, rr, io.sigsIn.backpressure & true.B) & x3829 & io.sigsIn.backpressure
      x2861.bits.wdata(0) := x2907_tuple(31,0)
      x2861.bits.wstrb := x2907_tuple(32,32)
    }
    val module = Module(new x2909_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2909_inr_Foreach **/
