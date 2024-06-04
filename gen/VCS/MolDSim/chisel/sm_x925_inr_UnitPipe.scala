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

/** Hierarchy: x925 -> x926 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x925_inr_UnitPipe **/
class x925_inr_UnitPipe_kernel(
  list_b558: List[Bool],
  list_x846_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x925_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x925_inr_UnitPipe_iiCtr"))
  
  abstract class x925_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x846_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x846_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x847_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x847_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b558 = Input(Bool())
      val in_x848_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x848_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x899_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x899_r_0_p").asInstanceOf[NBufParams] ))
      val in_b839 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x846_tmp_0 = {io.in_x846_tmp_0} ; io.in_x846_tmp_0 := DontCare
    def x847_tmp_1 = {io.in_x847_tmp_1} ; io.in_x847_tmp_1 := DontCare
    def b558 = {io.in_b558} 
    def x848_tmp_2 = {io.in_x848_tmp_2} ; io.in_x848_tmp_2 := DontCare
    def x899_r_0 = {io.in_x899_r_0} ; io.in_x899_r_0 := DontCare
    def b839 = {io.in_b839} 
  }
  def connectWires0(module: x925_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x846_tmp_0.connectLedger(module.io.in_x846_tmp_0)
    x847_tmp_1.connectLedger(module.io.in_x847_tmp_1)
    module.io.in_b558 <> b558
    x848_tmp_2.connectLedger(module.io.in_x848_tmp_2)
    x899_r_0.connectLedger(module.io.in_x899_r_0)
    module.io.in_b839 <> b839
  }
  val b558 = list_b558(0)
  val b839 = list_b558(1)
  val x846_tmp_0 = list_x846_tmp_0(0)
  val x847_tmp_1 = list_x846_tmp_0(1)
  val x848_tmp_2 = list_x846_tmp_0(2)
  val x899_r_0 = list_x846_tmp_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x925_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x925_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x925_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x925_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x925_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x925_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x925_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X925_instrctr, cycles_x925_inr_UnitPipe.io.count, iters_x925_inr_UnitPipe.io.count, 0.U, 0.U)
      val x913_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x913_rd""")
      val x913_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x913_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x913_rd_en = List[Bool](true.B)
      val x913_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x913_rd_shared_en")
      x913_rd.toSeq.zip(x846_tmp_0.connectRPort(913, x913_rd_banks, x913_rd_ofs, io.sigsIn.backpressure, x913_rd_en.map(_ && x913_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x914 = VecApply(x913,0)
      val x914_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x914_elem_0""")
      x914_elem_0.r := x913_rd(0).r
      val x916_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x916_rd""")
      val x916_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x916_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x916_rd_en = List[Bool](true.B)
      val x916_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x916_rd_shared_en")
      x916_rd.toSeq.zip(x847_tmp_1.connectRPort(916, x916_rd_banks, x916_rd_ofs, io.sigsIn.backpressure, x916_rd_en.map(_ && x916_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x917 = VecApply(x916,0)
      val x917_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x917_elem_0""")
      x917_elem_0.r := x916_rd(0).r
      val x918_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x918_mul""")
      x918_mul.r := (Math.mul(x917_elem_0, x917_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x918_mul")).r
      val x3230 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3230_x914_elem_0_D6") 
      x3230.r := getRetimed(x914_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2999 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2999""")
      x2999.r := Math.fma(x3230,x3230,x918_mul,Some(6.0), true.B, "x2999").toFixed(x2999, "cast_x2999").r
      val x920_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x920_rd""")
      val x920_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x920_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x920_rd_en = List[Bool](true.B)
      val x920_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x920_rd_shared_en")
      x920_rd.toSeq.zip(x848_tmp_2.connectRPort(920, x920_rd_banks, x920_rd_ofs, io.sigsIn.backpressure, x920_rd_en.map(_ && x920_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x921 = VecApply(x920,0)
      val x921_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x921_elem_0""")
      x921_elem_0.r := x920_rd(0).r
      val x3231 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3231_x921_elem_0_D12") 
      x3231.r := getRetimed(x921_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3000 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3000""")
      x3000.r := Math.fma(x3231,x3231,x2999,Some(6.0), true.B, "x3000").toFixed(x3000, "cast_x3000").r
      val x924_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x924_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x924_wr_en = List[Bool](true.B)
      val x924_wr_data = List[UInt](x3000.r)
      x899_r_0.connectWPort(924, x924_wr_banks, x924_wr_ofs, x924_wr_data, x924_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x925_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x925_inr_UnitPipe **/
