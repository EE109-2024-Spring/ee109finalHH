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

/** Hierarchy: x1133 -> x1134 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1133_inr_UnitPipe **/
class x1133_inr_UnitPipe_kernel(
  list_b559: List[Bool],
  list_x1055_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1133_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1133_inr_UnitPipe_iiCtr"))
  
  abstract class x1133_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1055_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1055_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b559 = Input(Bool())
      val in_b1047 = Input(Bool())
      val in_x1054_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1054_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1107_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1107_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1056_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1056_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1055_tmp_1 = {io.in_x1055_tmp_1} ; io.in_x1055_tmp_1 := DontCare
    def b559 = {io.in_b559} 
    def b1047 = {io.in_b1047} 
    def x1054_tmp_0 = {io.in_x1054_tmp_0} ; io.in_x1054_tmp_0 := DontCare
    def x1107_r_0 = {io.in_x1107_r_0} ; io.in_x1107_r_0 := DontCare
    def x1056_tmp_2 = {io.in_x1056_tmp_2} ; io.in_x1056_tmp_2 := DontCare
  }
  def connectWires0(module: x1133_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1055_tmp_1.connectLedger(module.io.in_x1055_tmp_1)
    module.io.in_b559 <> b559
    module.io.in_b1047 <> b1047
    x1054_tmp_0.connectLedger(module.io.in_x1054_tmp_0)
    x1107_r_0.connectLedger(module.io.in_x1107_r_0)
    x1056_tmp_2.connectLedger(module.io.in_x1056_tmp_2)
  }
  val b559 = list_b559(0)
  val b1047 = list_b559(1)
  val x1055_tmp_1 = list_x1055_tmp_1(0)
  val x1054_tmp_0 = list_x1055_tmp_1(1)
  val x1107_r_0 = list_x1055_tmp_1(2)
  val x1056_tmp_2 = list_x1055_tmp_1(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1133_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1133_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1133_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1133_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1133_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1133_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1133_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1133_instrctr, cycles_x1133_inr_UnitPipe.io.count, iters_x1133_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1121_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1121_rd""")
      val x1121_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1121_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1121_rd_en = List[Bool](true.B)
      val x1121_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1121_rd_shared_en")
      x1121_rd.toSeq.zip(x1054_tmp_0.connectRPort(1121, x1121_rd_banks, x1121_rd_ofs, io.sigsIn.backpressure, x1121_rd_en.map(_ && x1121_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1122 = VecApply(x1121,0)
      val x1122_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1122_elem_0""")
      x1122_elem_0.r := x1121_rd(0).r
      val x1124_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1124_rd""")
      val x1124_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1124_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1124_rd_en = List[Bool](true.B)
      val x1124_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1124_rd_shared_en")
      x1124_rd.toSeq.zip(x1055_tmp_1.connectRPort(1124, x1124_rd_banks, x1124_rd_ofs, io.sigsIn.backpressure, x1124_rd_en.map(_ && x1124_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1125 = VecApply(x1124,0)
      val x1125_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1125_elem_0""")
      x1125_elem_0.r := x1124_rd(0).r
      val x1126_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1126_mul""")
      x1126_mul.r := (Math.mul(x1125_elem_0, x1125_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1126_mul")).r
      val x3291 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3291_x1122_elem_0_D6") 
      x3291.r := getRetimed(x1122_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3011 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3011""")
      x3011.r := Math.fma(x3291,x3291,x1126_mul,Some(6.0), true.B, "x3011").toFixed(x3011, "cast_x3011").r
      val x1128_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1128_rd""")
      val x1128_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1128_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1128_rd_en = List[Bool](true.B)
      val x1128_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1128_rd_shared_en")
      x1128_rd.toSeq.zip(x1056_tmp_2.connectRPort(1128, x1128_rd_banks, x1128_rd_ofs, io.sigsIn.backpressure, x1128_rd_en.map(_ && x1128_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1129 = VecApply(x1128,0)
      val x1129_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1129_elem_0""")
      x1129_elem_0.r := x1128_rd(0).r
      val x3292 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3292_x1129_elem_0_D12") 
      x3292.r := getRetimed(x1129_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3012 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3012""")
      x3012.r := Math.fma(x3292,x3292,x3011,Some(6.0), true.B, "x3012").toFixed(x3012, "cast_x3012").r
      val x1132_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1132_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1132_wr_en = List[Bool](true.B)
      val x1132_wr_data = List[UInt](x3012.r)
      x1107_r_0.connectWPort(1132, x1132_wr_banks, x1132_wr_ofs, x1132_wr_data, x1132_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1133_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1133_inr_UnitPipe **/
