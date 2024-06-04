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

/** Hierarchy: x1120 -> x1134 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1120_inr_UnitPipe **/
class x1120_inr_UnitPipe_kernel(
  list_b1046: List[Bool],
  list_x1051_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1120_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1120_inr_UnitPipe_iiCtr"))
  
  abstract class x1120_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1046 = Input(Bool())
      val in_b559 = Input(Bool())
      val in_x1051_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1051_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1106_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1106_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1050_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1050_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1049_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1049_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1046 = {io.in_b1046} 
    def b559 = {io.in_b559} 
    def x1051_tmp_2 = {io.in_x1051_tmp_2} ; io.in_x1051_tmp_2 := DontCare
    def x1106_r_0 = {io.in_x1106_r_0} ; io.in_x1106_r_0 := DontCare
    def x1050_tmp_1 = {io.in_x1050_tmp_1} ; io.in_x1050_tmp_1 := DontCare
    def x1049_tmp_0 = {io.in_x1049_tmp_0} ; io.in_x1049_tmp_0 := DontCare
  }
  def connectWires0(module: x1120_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1046 <> b1046
    module.io.in_b559 <> b559
    x1051_tmp_2.connectLedger(module.io.in_x1051_tmp_2)
    x1106_r_0.connectLedger(module.io.in_x1106_r_0)
    x1050_tmp_1.connectLedger(module.io.in_x1050_tmp_1)
    x1049_tmp_0.connectLedger(module.io.in_x1049_tmp_0)
  }
  val b1046 = list_b1046(0)
  val b559 = list_b1046(1)
  val x1051_tmp_2 = list_x1051_tmp_2(0)
  val x1106_r_0 = list_x1051_tmp_2(1)
  val x1050_tmp_1 = list_x1051_tmp_2(2)
  val x1049_tmp_0 = list_x1051_tmp_2(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1120_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1120_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1120_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1120_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1120_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1120_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1120_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1120_instrctr, cycles_x1120_inr_UnitPipe.io.count, iters_x1120_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1108_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1108_rd""")
      val x1108_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1108_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1108_rd_en = List[Bool](true.B)
      val x1108_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1108_rd_shared_en")
      x1108_rd.toSeq.zip(x1049_tmp_0.connectRPort(1108, x1108_rd_banks, x1108_rd_ofs, io.sigsIn.backpressure, x1108_rd_en.map(_ && x1108_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1109 = VecApply(x1108,0)
      val x1109_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1109_elem_0""")
      x1109_elem_0.r := x1108_rd(0).r
      val x1111_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1111_rd""")
      val x1111_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1111_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1111_rd_en = List[Bool](true.B)
      val x1111_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1111_rd_shared_en")
      x1111_rd.toSeq.zip(x1050_tmp_1.connectRPort(1111, x1111_rd_banks, x1111_rd_ofs, io.sigsIn.backpressure, x1111_rd_en.map(_ && x1111_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1112 = VecApply(x1111,0)
      val x1112_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1112_elem_0""")
      x1112_elem_0.r := x1111_rd(0).r
      val x1113_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1113_mul""")
      x1113_mul.r := (Math.mul(x1112_elem_0, x1112_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1113_mul")).r
      val x3289 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3289_x1109_elem_0_D6") 
      x3289.r := getRetimed(x1109_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3009 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3009""")
      x3009.r := Math.fma(x3289,x3289,x1113_mul,Some(6.0), true.B, "x3009").toFixed(x3009, "cast_x3009").r
      val x1115_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1115_rd""")
      val x1115_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1115_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1115_rd_en = List[Bool](true.B)
      val x1115_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1115_rd_shared_en")
      x1115_rd.toSeq.zip(x1051_tmp_2.connectRPort(1115, x1115_rd_banks, x1115_rd_ofs, io.sigsIn.backpressure, x1115_rd_en.map(_ && x1115_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1116 = VecApply(x1115,0)
      val x1116_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1116_elem_0""")
      x1116_elem_0.r := x1115_rd(0).r
      val x3290 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3290_x1116_elem_0_D12") 
      x3290.r := getRetimed(x1116_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3010 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3010""")
      x3010.r := Math.fma(x3290,x3290,x3009,Some(6.0), true.B, "x3010").toFixed(x3010, "cast_x3010").r
      val x1119_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1119_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1119_wr_en = List[Bool](true.B)
      val x1119_wr_data = List[UInt](x3010.r)
      x1106_r_0.connectWPort(1119, x1119_wr_banks, x1119_wr_ofs, x1119_wr_data, x1119_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1120_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1120_inr_UnitPipe **/
