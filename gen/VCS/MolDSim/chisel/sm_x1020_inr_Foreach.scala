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

/** Hierarchy: x1020 -> x1021 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1020_inr_Foreach **/
class x1020_inr_Foreach_kernel(
  list_b558: List[Bool],
  list_x846_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1020_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1020_inr_Foreach_iiCtr"))
  
  abstract class x1020_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x846_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x846_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x849_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x849_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x847_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x847_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b558 = Input(Bool())
      val in_x848_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x848_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x928_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x928_force_0_p").asInstanceOf[NBufParams] ))
      val in_b839 = Input(Bool())
      val in_x850_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x850_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x846_tmp_0 = {io.in_x846_tmp_0} ; io.in_x846_tmp_0 := DontCare
    def x849_tmp_3 = {io.in_x849_tmp_3} ; io.in_x849_tmp_3 := DontCare
    def x847_tmp_1 = {io.in_x847_tmp_1} ; io.in_x847_tmp_1 := DontCare
    def b558 = {io.in_b558} 
    def x848_tmp_2 = {io.in_x848_tmp_2} ; io.in_x848_tmp_2 := DontCare
    def x928_force_0 = {io.in_x928_force_0} ; io.in_x928_force_0 := DontCare
    def b839 = {io.in_b839} 
    def x850_tmp_4 = {io.in_x850_tmp_4} ; io.in_x850_tmp_4 := DontCare
  }
  def connectWires0(module: x1020_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x846_tmp_0.connectLedger(module.io.in_x846_tmp_0)
    x849_tmp_3.connectLedger(module.io.in_x849_tmp_3)
    x847_tmp_1.connectLedger(module.io.in_x847_tmp_1)
    module.io.in_b558 <> b558
    x848_tmp_2.connectLedger(module.io.in_x848_tmp_2)
    x928_force_0.connectLedger(module.io.in_x928_force_0)
    module.io.in_b839 <> b839
    x850_tmp_4.connectLedger(module.io.in_x850_tmp_4)
  }
  val b558 = list_b558(0)
  val b839 = list_b558(1)
  val x846_tmp_0 = list_x846_tmp_0(0)
  val x849_tmp_3 = list_x846_tmp_0(1)
  val x847_tmp_1 = list_x846_tmp_0(2)
  val x848_tmp_2 = list_x846_tmp_0(3)
  val x928_force_0 = list_x846_tmp_0(4)
  val x850_tmp_4 = list_x846_tmp_0(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1020_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1020_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1020_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1020_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1020_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1020_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1020_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1020_instrctr, cycles_x1020_inr_Foreach.io.count, iters_x1020_inr_Foreach.io.count, 0.U, 0.U)
      val b1007 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1007.suggestName("b1007")
      val b1008 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1008.suggestName("b1008")
      val x1009_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1009_rd""")
      val x1009_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1009_rd_ofs = List[UInt](b1007.r)
      val x1009_rd_en = List[Bool](true.B)
      val x1009_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1008 & b839 & b558 ).suggestName("x1009_rd_shared_en")
      x1009_rd.toSeq.zip(x849_tmp_3.connectRPort(1009, x1009_rd_banks, x1009_rd_ofs, io.sigsIn.backpressure, x1009_rd_en.map(_ && x1009_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1010 = VecApply(x1009,0)
      val x1010_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1010_elem_0""")
      x1010_elem_0.r := x1009_rd(0).r
      val x1011_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1011_mul""")
      x1011_mul.r := (Math.mul(x1010_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1011_mul")).r
      val x1012_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1012_rd""")
      val x1012_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1012_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1012_rd_en = List[Bool](true.B)
      val x1012_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1008 & b839 & b558 ).suggestName("x1012_rd_shared_en")
      x1012_rd.toSeq.zip(x928_force_0.connectRPort(1012, x1012_rd_banks, x1012_rd_ofs, io.sigsIn.backpressure, x1012_rd_en.map(_ && x1012_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1013 = VecApply(x1012,0)
      val x1013_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1013_elem_0""")
      x1013_elem_0.r := x1012_rd(0).r
      val x3247 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3247_x1013_elem_0_D6") 
      x3247.r := getRetimed(x1013_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1014_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1014_mul""")
      x1014_mul.r := (Math.mul(x1011_mul, x3247, Some(6.0), true.B, Truncate, Wrapping, "x1014_mul")).r
      val x3248 = Wire(Bool()).suggestName("x3248_b558_D14") 
      x3248.r := getRetimed(b558.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3249 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3249_b1007_D14") 
      x3249.r := getRetimed(b1007.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3250 = Wire(Bool()).suggestName("x3250_b1008_D14") 
      x3250.r := getRetimed(b1008.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3251 = Wire(Bool()).suggestName("x3251_b839_D14") 
      x3251.r := getRetimed(b839.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1015_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1015_wr_ofs = List[UInt](x3249.r)
      val x1015_wr_en = List[Bool](true.B)
      val x1015_wr_data = List[UInt](x1014_mul.r)
      x846_tmp_0.connectWPort(1015, x1015_wr_banks, x1015_wr_ofs, x1015_wr_data, x1015_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3250 & x3251 & x3248))
      val x1016_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1016_wr_ofs = List[UInt](x3249.r)
      val x1016_wr_en = List[Bool](true.B)
      val x1016_wr_data = List[UInt](x1014_mul.r)
      x849_tmp_3.connectWPort(1016, x1016_wr_banks, x1016_wr_ofs, x1016_wr_data, x1016_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3250 & x3251 & x3248))
      val x1017_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1017_wr_ofs = List[UInt](x3249.r)
      val x1017_wr_en = List[Bool](true.B)
      val x1017_wr_data = List[UInt](x1014_mul.r)
      x847_tmp_1.connectWPort(1017, x1017_wr_banks, x1017_wr_ofs, x1017_wr_data, x1017_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3250 & x3251 & x3248))
      val x1018_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1018_wr_ofs = List[UInt](x3249.r)
      val x1018_wr_en = List[Bool](true.B)
      val x1018_wr_data = List[UInt](x1014_mul.r)
      x848_tmp_2.connectWPort(1018, x1018_wr_banks, x1018_wr_ofs, x1018_wr_data, x1018_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3250 & x3251 & x3248))
      val x1019_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1019_wr_ofs = List[UInt](x3249.r)
      val x1019_wr_en = List[Bool](true.B)
      val x1019_wr_data = List[UInt](x1014_mul.r)
      x850_tmp_4.connectWPort(1019, x1019_wr_banks, x1019_wr_ofs, x1019_wr_data, x1019_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3250 & x3251 & x3248))
    }
    val module = Module(new x1020_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1020_inr_Foreach **/
