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

/** Hierarchy: x1328 -> x1342 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1328_inr_UnitPipe **/
class x1328_inr_UnitPipe_kernel(
  list_b1254: List[Bool],
  list_x1259_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1328_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1328_inr_UnitPipe_iiCtr"))
  
  abstract class x1328_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1254 = Input(Bool())
      val in_x1259_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1259_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1258_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1258_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1257_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1257_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1314_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1314_r_0_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1254 = {io.in_b1254} 
    def x1259_tmp_2 = {io.in_x1259_tmp_2} ; io.in_x1259_tmp_2 := DontCare
    def x1258_tmp_1 = {io.in_x1258_tmp_1} ; io.in_x1258_tmp_1 := DontCare
    def x1257_tmp_0 = {io.in_x1257_tmp_0} ; io.in_x1257_tmp_0 := DontCare
    def x1314_r_0 = {io.in_x1314_r_0} ; io.in_x1314_r_0 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1328_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1254 <> b1254
    x1259_tmp_2.connectLedger(module.io.in_x1259_tmp_2)
    x1258_tmp_1.connectLedger(module.io.in_x1258_tmp_1)
    x1257_tmp_0.connectLedger(module.io.in_x1257_tmp_0)
    x1314_r_0.connectLedger(module.io.in_x1314_r_0)
    module.io.in_b560 <> b560
  }
  val b1254 = list_b1254(0)
  val b560 = list_b1254(1)
  val x1259_tmp_2 = list_x1259_tmp_2(0)
  val x1258_tmp_1 = list_x1259_tmp_2(1)
  val x1257_tmp_0 = list_x1259_tmp_2(2)
  val x1314_r_0 = list_x1259_tmp_2(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1328_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1328_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1328_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1328_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1328_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1328_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1328_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1328_instrctr, cycles_x1328_inr_UnitPipe.io.count, iters_x1328_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1316_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1316_rd""")
      val x1316_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1316_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1316_rd_en = List[Bool](true.B)
      val x1316_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1316_rd_shared_en")
      x1316_rd.toSeq.zip(x1257_tmp_0.connectRPort(1316, x1316_rd_banks, x1316_rd_ofs, io.sigsIn.backpressure, x1316_rd_en.map(_ && x1316_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1317 = VecApply(x1316,0)
      val x1317_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1317_elem_0""")
      x1317_elem_0.r := x1316_rd(0).r
      val x1319_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1319_rd""")
      val x1319_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1319_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1319_rd_en = List[Bool](true.B)
      val x1319_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1319_rd_shared_en")
      x1319_rd.toSeq.zip(x1258_tmp_1.connectRPort(1319, x1319_rd_banks, x1319_rd_ofs, io.sigsIn.backpressure, x1319_rd_en.map(_ && x1319_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1320 = VecApply(x1319,0)
      val x1320_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1320_elem_0""")
      x1320_elem_0.r := x1319_rd(0).r
      val x1321_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1321_mul""")
      x1321_mul.r := (Math.mul(x1320_elem_0, x1320_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1321_mul")).r
      val x3350 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3350_x1317_elem_0_D6") 
      x3350.r := getRetimed(x1317_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3021 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3021""")
      x3021.r := Math.fma(x3350,x3350,x1321_mul,Some(6.0), true.B, "x3021").toFixed(x3021, "cast_x3021").r
      val x1323_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1323_rd""")
      val x1323_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1323_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1323_rd_en = List[Bool](true.B)
      val x1323_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1323_rd_shared_en")
      x1323_rd.toSeq.zip(x1259_tmp_2.connectRPort(1323, x1323_rd_banks, x1323_rd_ofs, io.sigsIn.backpressure, x1323_rd_en.map(_ && x1323_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1324 = VecApply(x1323,0)
      val x1324_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1324_elem_0""")
      x1324_elem_0.r := x1323_rd(0).r
      val x3351 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3351_x1324_elem_0_D12") 
      x3351.r := getRetimed(x1324_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3022 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3022""")
      x3022.r := Math.fma(x3351,x3351,x3021,Some(6.0), true.B, "x3022").toFixed(x3022, "cast_x3022").r
      val x1327_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1327_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1327_wr_en = List[Bool](true.B)
      val x1327_wr_data = List[UInt](x3022.r)
      x1314_r_0.connectWPort(1327, x1327_wr_banks, x1327_wr_ofs, x1327_wr_data, x1327_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1328_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1328_inr_UnitPipe **/
