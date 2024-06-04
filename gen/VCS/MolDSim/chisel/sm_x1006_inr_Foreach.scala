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

/** Hierarchy: x1006 -> x1021 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1006_inr_Foreach **/
class x1006_inr_Foreach_kernel(
  list_b838: List[Bool],
  list_x841_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1006_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1006_inr_Foreach_iiCtr"))
  
  abstract class x1006_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x841_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x841_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b838 = Input(Bool())
      val in_x842_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x842_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b558 = Input(Bool())
      val in_x843_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x843_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x927_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x927_force_0_p").asInstanceOf[NBufParams] ))
      val in_x845_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x845_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x844_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x844_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x841_tmp_0 = {io.in_x841_tmp_0} ; io.in_x841_tmp_0 := DontCare
    def b838 = {io.in_b838} 
    def x842_tmp_1 = {io.in_x842_tmp_1} ; io.in_x842_tmp_1 := DontCare
    def b558 = {io.in_b558} 
    def x843_tmp_2 = {io.in_x843_tmp_2} ; io.in_x843_tmp_2 := DontCare
    def x927_force_0 = {io.in_x927_force_0} ; io.in_x927_force_0 := DontCare
    def x845_tmp_4 = {io.in_x845_tmp_4} ; io.in_x845_tmp_4 := DontCare
    def x844_tmp_3 = {io.in_x844_tmp_3} ; io.in_x844_tmp_3 := DontCare
  }
  def connectWires0(module: x1006_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x841_tmp_0.connectLedger(module.io.in_x841_tmp_0)
    module.io.in_b838 <> b838
    x842_tmp_1.connectLedger(module.io.in_x842_tmp_1)
    module.io.in_b558 <> b558
    x843_tmp_2.connectLedger(module.io.in_x843_tmp_2)
    x927_force_0.connectLedger(module.io.in_x927_force_0)
    x845_tmp_4.connectLedger(module.io.in_x845_tmp_4)
    x844_tmp_3.connectLedger(module.io.in_x844_tmp_3)
  }
  val b838 = list_b838(0)
  val b558 = list_b838(1)
  val x841_tmp_0 = list_x841_tmp_0(0)
  val x842_tmp_1 = list_x841_tmp_0(1)
  val x843_tmp_2 = list_x841_tmp_0(2)
  val x927_force_0 = list_x841_tmp_0(3)
  val x845_tmp_4 = list_x841_tmp_0(4)
  val x844_tmp_3 = list_x841_tmp_0(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1006_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1006_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1006_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1006_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1006_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1006_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1006_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1006_instrctr, cycles_x1006_inr_Foreach.io.count, iters_x1006_inr_Foreach.io.count, 0.U, 0.U)
      val b993 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b993.suggestName("b993")
      val b994 = ~io.sigsIn.cchainOutputs.head.oobs(0); b994.suggestName("b994")
      val x995_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x995_rd""")
      val x995_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x995_rd_ofs = List[UInt](b993.r)
      val x995_rd_en = List[Bool](true.B)
      val x995_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b994 & b838 & b558 ).suggestName("x995_rd_shared_en")
      x995_rd.toSeq.zip(x844_tmp_3.connectRPort(995, x995_rd_banks, x995_rd_ofs, io.sigsIn.backpressure, x995_rd_en.map(_ && x995_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x996 = VecApply(x995,0)
      val x996_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x996_elem_0""")
      x996_elem_0.r := x995_rd(0).r
      val x997_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x997_mul""")
      x997_mul.r := (Math.mul(x996_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x997_mul")).r
      val x998_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x998_rd""")
      val x998_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x998_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x998_rd_en = List[Bool](true.B)
      val x998_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b994 & b838 & b558 ).suggestName("x998_rd_shared_en")
      x998_rd.toSeq.zip(x927_force_0.connectRPort(998, x998_rd_banks, x998_rd_ofs, io.sigsIn.backpressure, x998_rd_en.map(_ && x998_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x999 = VecApply(x998,0)
      val x999_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x999_elem_0""")
      x999_elem_0.r := x998_rd(0).r
      val x3242 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3242_x999_elem_0_D6") 
      x3242.r := getRetimed(x999_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1000_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1000_mul""")
      x1000_mul.r := (Math.mul(x997_mul, x3242, Some(6.0), true.B, Truncate, Wrapping, "x1000_mul")).r
      val x3243 = Wire(Bool()).suggestName("x3243_b994_D14") 
      x3243.r := getRetimed(b994.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3244 = Wire(Bool()).suggestName("x3244_b838_D14") 
      x3244.r := getRetimed(b838.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3245 = Wire(Bool()).suggestName("x3245_b558_D14") 
      x3245.r := getRetimed(b558.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3246 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3246_b993_D14") 
      x3246.r := getRetimed(b993.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1001_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1001_wr_ofs = List[UInt](x3246.r)
      val x1001_wr_en = List[Bool](true.B)
      val x1001_wr_data = List[UInt](x1000_mul.r)
      x841_tmp_0.connectWPort(1001, x1001_wr_banks, x1001_wr_ofs, x1001_wr_data, x1001_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3243 & x3244 & x3245))
      val x1002_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1002_wr_ofs = List[UInt](x3246.r)
      val x1002_wr_en = List[Bool](true.B)
      val x1002_wr_data = List[UInt](x1000_mul.r)
      x842_tmp_1.connectWPort(1002, x1002_wr_banks, x1002_wr_ofs, x1002_wr_data, x1002_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3243 & x3244 & x3245))
      val x1003_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1003_wr_ofs = List[UInt](x3246.r)
      val x1003_wr_en = List[Bool](true.B)
      val x1003_wr_data = List[UInt](x1000_mul.r)
      x843_tmp_2.connectWPort(1003, x1003_wr_banks, x1003_wr_ofs, x1003_wr_data, x1003_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3243 & x3244 & x3245))
      val x1004_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1004_wr_ofs = List[UInt](x3246.r)
      val x1004_wr_en = List[Bool](true.B)
      val x1004_wr_data = List[UInt](x1000_mul.r)
      x845_tmp_4.connectWPort(1004, x1004_wr_banks, x1004_wr_ofs, x1004_wr_data, x1004_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3243 & x3244 & x3245))
      val x1005_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1005_wr_ofs = List[UInt](x3246.r)
      val x1005_wr_en = List[Bool](true.B)
      val x1005_wr_data = List[UInt](x1000_mul.r)
      x844_tmp_3.connectWPort(1005, x1005_wr_banks, x1005_wr_ofs, x1005_wr_data, x1005_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3243 & x3244 & x3245))
    }
    val module = Module(new x1006_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1006_inr_Foreach **/
