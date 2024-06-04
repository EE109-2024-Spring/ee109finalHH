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

/** Hierarchy: x1422 -> x1437 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1422_inr_Foreach **/
class x1422_inr_Foreach_kernel(
  list_b1254: List[Bool],
  list_x1260_tmp_3: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1422_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1422_inr_Foreach_iiCtr"))
  
  abstract class x1422_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1260_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1260_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b1254 = Input(Bool())
      val in_x1343_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1343_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1259_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1259_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1258_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1258_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1257_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1257_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1261_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1261_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1260_tmp_3 = {io.in_x1260_tmp_3} ; io.in_x1260_tmp_3 := DontCare
    def b1254 = {io.in_b1254} 
    def x1343_force_0 = {io.in_x1343_force_0} ; io.in_x1343_force_0 := DontCare
    def x1259_tmp_2 = {io.in_x1259_tmp_2} ; io.in_x1259_tmp_2 := DontCare
    def x1258_tmp_1 = {io.in_x1258_tmp_1} ; io.in_x1258_tmp_1 := DontCare
    def x1257_tmp_0 = {io.in_x1257_tmp_0} ; io.in_x1257_tmp_0 := DontCare
    def x1261_tmp_4 = {io.in_x1261_tmp_4} ; io.in_x1261_tmp_4 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1422_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1260_tmp_3.connectLedger(module.io.in_x1260_tmp_3)
    module.io.in_b1254 <> b1254
    x1343_force_0.connectLedger(module.io.in_x1343_force_0)
    x1259_tmp_2.connectLedger(module.io.in_x1259_tmp_2)
    x1258_tmp_1.connectLedger(module.io.in_x1258_tmp_1)
    x1257_tmp_0.connectLedger(module.io.in_x1257_tmp_0)
    x1261_tmp_4.connectLedger(module.io.in_x1261_tmp_4)
    module.io.in_b560 <> b560
  }
  val b1254 = list_b1254(0)
  val b560 = list_b1254(1)
  val x1260_tmp_3 = list_x1260_tmp_3(0)
  val x1343_force_0 = list_x1260_tmp_3(1)
  val x1259_tmp_2 = list_x1260_tmp_3(2)
  val x1258_tmp_1 = list_x1260_tmp_3(3)
  val x1257_tmp_0 = list_x1260_tmp_3(4)
  val x1261_tmp_4 = list_x1260_tmp_3(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1422_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1422_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1422_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1422_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1422_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1422_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1422_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1422_instrctr, cycles_x1422_inr_Foreach.io.count, iters_x1422_inr_Foreach.io.count, 0.U, 0.U)
      val b1409 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1409.suggestName("b1409")
      val b1410 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1410.suggestName("b1410")
      val x1411_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1411_rd""")
      val x1411_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1411_rd_ofs = List[UInt](b1409.r)
      val x1411_rd_en = List[Bool](true.B)
      val x1411_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1410 & b1254 & b560 ).suggestName("x1411_rd_shared_en")
      x1411_rd.toSeq.zip(x1260_tmp_3.connectRPort(1411, x1411_rd_banks, x1411_rd_ofs, io.sigsIn.backpressure, x1411_rd_en.map(_ && x1411_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1412 = VecApply(x1411,0)
      val x1412_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1412_elem_0""")
      x1412_elem_0.r := x1411_rd(0).r
      val x1413_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1413_mul""")
      x1413_mul.r := (Math.mul(x1412_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1413_mul")).r
      val x1414_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1414_rd""")
      val x1414_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1414_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1414_rd_en = List[Bool](true.B)
      val x1414_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1410 & b1254 & b560 ).suggestName("x1414_rd_shared_en")
      x1414_rd.toSeq.zip(x1343_force_0.connectRPort(1414, x1414_rd_banks, x1414_rd_ofs, io.sigsIn.backpressure, x1414_rd_en.map(_ && x1414_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1415 = VecApply(x1414,0)
      val x1415_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1415_elem_0""")
      x1415_elem_0.r := x1414_rd(0).r
      val x3364 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3364_x1415_elem_0_D6") 
      x3364.r := getRetimed(x1415_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1416_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1416_mul""")
      x1416_mul.r := (Math.mul(x1413_mul, x3364, Some(6.0), true.B, Truncate, Wrapping, "x1416_mul")).r
      val x3365 = Wire(Bool()).suggestName("x3365_b1254_D14") 
      x3365.r := getRetimed(b1254.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3366 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3366_b1409_D14") 
      x3366.r := getRetimed(b1409.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3367 = Wire(Bool()).suggestName("x3367_b1410_D14") 
      x3367.r := getRetimed(b1410.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3368 = Wire(Bool()).suggestName("x3368_b560_D14") 
      x3368.r := getRetimed(b560.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1417_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1417_wr_ofs = List[UInt](x3366.r)
      val x1417_wr_en = List[Bool](true.B)
      val x1417_wr_data = List[UInt](x1416_mul.r)
      x1260_tmp_3.connectWPort(1417, x1417_wr_banks, x1417_wr_ofs, x1417_wr_data, x1417_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3367 & x3365 & x3368))
      val x1418_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1418_wr_ofs = List[UInt](x3366.r)
      val x1418_wr_en = List[Bool](true.B)
      val x1418_wr_data = List[UInt](x1416_mul.r)
      x1259_tmp_2.connectWPort(1418, x1418_wr_banks, x1418_wr_ofs, x1418_wr_data, x1418_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3367 & x3365 & x3368))
      val x1419_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1419_wr_ofs = List[UInt](x3366.r)
      val x1419_wr_en = List[Bool](true.B)
      val x1419_wr_data = List[UInt](x1416_mul.r)
      x1258_tmp_1.connectWPort(1419, x1419_wr_banks, x1419_wr_ofs, x1419_wr_data, x1419_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3367 & x3365 & x3368))
      val x1420_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1420_wr_ofs = List[UInt](x3366.r)
      val x1420_wr_en = List[Bool](true.B)
      val x1420_wr_data = List[UInt](x1416_mul.r)
      x1257_tmp_0.connectWPort(1420, x1420_wr_banks, x1420_wr_ofs, x1420_wr_data, x1420_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3367 & x3365 & x3368))
      val x1421_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1421_wr_ofs = List[UInt](x3366.r)
      val x1421_wr_en = List[Bool](true.B)
      val x1421_wr_data = List[UInt](x1416_mul.r)
      x1261_tmp_4.connectWPort(1421, x1421_wr_banks, x1421_wr_ofs, x1421_wr_data, x1421_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3367 & x3365 & x3368))
    }
    val module = Module(new x1422_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1422_inr_Foreach **/
