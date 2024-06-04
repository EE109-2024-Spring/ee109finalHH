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

/** Hierarchy: x1228 -> x1229 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1228_inr_Foreach **/
class x1228_inr_Foreach_kernel(
  list_b559: List[Bool],
  list_x1055_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1228_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1228_inr_Foreach_iiCtr"))
  
  abstract class x1228_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1055_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1055_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b559 = Input(Bool())
      val in_x1136_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1136_force_0_p").asInstanceOf[NBufParams] ))
      val in_b1047 = Input(Bool())
      val in_x1057_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1057_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1054_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1054_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1058_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1058_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1056_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1056_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1055_tmp_1 = {io.in_x1055_tmp_1} ; io.in_x1055_tmp_1 := DontCare
    def b559 = {io.in_b559} 
    def x1136_force_0 = {io.in_x1136_force_0} ; io.in_x1136_force_0 := DontCare
    def b1047 = {io.in_b1047} 
    def x1057_tmp_3 = {io.in_x1057_tmp_3} ; io.in_x1057_tmp_3 := DontCare
    def x1054_tmp_0 = {io.in_x1054_tmp_0} ; io.in_x1054_tmp_0 := DontCare
    def x1058_tmp_4 = {io.in_x1058_tmp_4} ; io.in_x1058_tmp_4 := DontCare
    def x1056_tmp_2 = {io.in_x1056_tmp_2} ; io.in_x1056_tmp_2 := DontCare
  }
  def connectWires0(module: x1228_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1055_tmp_1.connectLedger(module.io.in_x1055_tmp_1)
    module.io.in_b559 <> b559
    x1136_force_0.connectLedger(module.io.in_x1136_force_0)
    module.io.in_b1047 <> b1047
    x1057_tmp_3.connectLedger(module.io.in_x1057_tmp_3)
    x1054_tmp_0.connectLedger(module.io.in_x1054_tmp_0)
    x1058_tmp_4.connectLedger(module.io.in_x1058_tmp_4)
    x1056_tmp_2.connectLedger(module.io.in_x1056_tmp_2)
  }
  val b559 = list_b559(0)
  val b1047 = list_b559(1)
  val x1055_tmp_1 = list_x1055_tmp_1(0)
  val x1136_force_0 = list_x1055_tmp_1(1)
  val x1057_tmp_3 = list_x1055_tmp_1(2)
  val x1054_tmp_0 = list_x1055_tmp_1(3)
  val x1058_tmp_4 = list_x1055_tmp_1(4)
  val x1056_tmp_2 = list_x1055_tmp_1(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1228_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1228_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1228_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1228_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1228_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1228_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1228_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1228_instrctr, cycles_x1228_inr_Foreach.io.count, iters_x1228_inr_Foreach.io.count, 0.U, 0.U)
      val b1215 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1215.suggestName("b1215")
      val b1216 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1216.suggestName("b1216")
      val x1217_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1217_rd""")
      val x1217_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1217_rd_ofs = List[UInt](b1215.r)
      val x1217_rd_en = List[Bool](true.B)
      val x1217_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1216 & b1047 & b559 ).suggestName("x1217_rd_shared_en")
      x1217_rd.toSeq.zip(x1057_tmp_3.connectRPort(1217, x1217_rd_banks, x1217_rd_ofs, io.sigsIn.backpressure, x1217_rd_en.map(_ && x1217_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1218 = VecApply(x1217,0)
      val x1218_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1218_elem_0""")
      x1218_elem_0.r := x1217_rd(0).r
      val x1219_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1219_mul""")
      x1219_mul.r := (Math.mul(x1218_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1219_mul")).r
      val x1220_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1220_rd""")
      val x1220_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1220_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1220_rd_en = List[Bool](true.B)
      val x1220_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1216 & b1047 & b559 ).suggestName("x1220_rd_shared_en")
      x1220_rd.toSeq.zip(x1136_force_0.connectRPort(1220, x1220_rd_banks, x1220_rd_ofs, io.sigsIn.backpressure, x1220_rd_en.map(_ && x1220_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1221 = VecApply(x1220,0)
      val x1221_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1221_elem_0""")
      x1221_elem_0.r := x1220_rd(0).r
      val x3308 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3308_x1221_elem_0_D6") 
      x3308.r := getRetimed(x1221_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1222_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1222_mul""")
      x1222_mul.r := (Math.mul(x1219_mul, x3308, Some(6.0), true.B, Truncate, Wrapping, "x1222_mul")).r
      val x3309 = Wire(Bool()).suggestName("x3309_b559_D14") 
      x3309.r := getRetimed(b559.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3310 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3310_b1215_D14") 
      x3310.r := getRetimed(b1215.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3311 = Wire(Bool()).suggestName("x3311_b1047_D14") 
      x3311.r := getRetimed(b1047.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3312 = Wire(Bool()).suggestName("x3312_b1216_D14") 
      x3312.r := getRetimed(b1216.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1223_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1223_wr_ofs = List[UInt](x3310.r)
      val x1223_wr_en = List[Bool](true.B)
      val x1223_wr_data = List[UInt](x1222_mul.r)
      x1055_tmp_1.connectWPort(1223, x1223_wr_banks, x1223_wr_ofs, x1223_wr_data, x1223_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3312 & x3311 & x3309))
      val x1224_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1224_wr_ofs = List[UInt](x3310.r)
      val x1224_wr_en = List[Bool](true.B)
      val x1224_wr_data = List[UInt](x1222_mul.r)
      x1057_tmp_3.connectWPort(1224, x1224_wr_banks, x1224_wr_ofs, x1224_wr_data, x1224_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3312 & x3311 & x3309))
      val x1225_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1225_wr_ofs = List[UInt](x3310.r)
      val x1225_wr_en = List[Bool](true.B)
      val x1225_wr_data = List[UInt](x1222_mul.r)
      x1054_tmp_0.connectWPort(1225, x1225_wr_banks, x1225_wr_ofs, x1225_wr_data, x1225_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3312 & x3311 & x3309))
      val x1226_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1226_wr_ofs = List[UInt](x3310.r)
      val x1226_wr_en = List[Bool](true.B)
      val x1226_wr_data = List[UInt](x1222_mul.r)
      x1058_tmp_4.connectWPort(1226, x1226_wr_banks, x1226_wr_ofs, x1226_wr_data, x1226_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3312 & x3311 & x3309))
      val x1227_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1227_wr_ofs = List[UInt](x3310.r)
      val x1227_wr_en = List[Bool](true.B)
      val x1227_wr_data = List[UInt](x1222_mul.r)
      x1056_tmp_2.connectWPort(1227, x1227_wr_banks, x1227_wr_ofs, x1227_wr_data, x1227_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3312 & x3311 & x3309))
    }
    val module = Module(new x1228_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1228_inr_Foreach **/
