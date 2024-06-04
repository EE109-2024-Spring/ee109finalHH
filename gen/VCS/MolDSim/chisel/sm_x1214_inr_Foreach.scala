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

/** Hierarchy: x1214 -> x1229 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1214_inr_Foreach **/
class x1214_inr_Foreach_kernel(
  list_b1046: List[Bool],
  list_x1051_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1214_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1214_inr_Foreach_iiCtr"))
  
  abstract class x1214_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1046 = Input(Bool())
      val in_b559 = Input(Bool())
      val in_x1051_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1051_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1050_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1050_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1135_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1135_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1049_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1049_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1053_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1053_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1052_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1052_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1046 = {io.in_b1046} 
    def b559 = {io.in_b559} 
    def x1051_tmp_2 = {io.in_x1051_tmp_2} ; io.in_x1051_tmp_2 := DontCare
    def x1050_tmp_1 = {io.in_x1050_tmp_1} ; io.in_x1050_tmp_1 := DontCare
    def x1135_force_0 = {io.in_x1135_force_0} ; io.in_x1135_force_0 := DontCare
    def x1049_tmp_0 = {io.in_x1049_tmp_0} ; io.in_x1049_tmp_0 := DontCare
    def x1053_tmp_4 = {io.in_x1053_tmp_4} ; io.in_x1053_tmp_4 := DontCare
    def x1052_tmp_3 = {io.in_x1052_tmp_3} ; io.in_x1052_tmp_3 := DontCare
  }
  def connectWires0(module: x1214_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1046 <> b1046
    module.io.in_b559 <> b559
    x1051_tmp_2.connectLedger(module.io.in_x1051_tmp_2)
    x1050_tmp_1.connectLedger(module.io.in_x1050_tmp_1)
    x1135_force_0.connectLedger(module.io.in_x1135_force_0)
    x1049_tmp_0.connectLedger(module.io.in_x1049_tmp_0)
    x1053_tmp_4.connectLedger(module.io.in_x1053_tmp_4)
    x1052_tmp_3.connectLedger(module.io.in_x1052_tmp_3)
  }
  val b1046 = list_b1046(0)
  val b559 = list_b1046(1)
  val x1051_tmp_2 = list_x1051_tmp_2(0)
  val x1050_tmp_1 = list_x1051_tmp_2(1)
  val x1135_force_0 = list_x1051_tmp_2(2)
  val x1049_tmp_0 = list_x1051_tmp_2(3)
  val x1053_tmp_4 = list_x1051_tmp_2(4)
  val x1052_tmp_3 = list_x1051_tmp_2(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1214_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1214_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1214_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1214_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1214_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1214_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1214_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1214_instrctr, cycles_x1214_inr_Foreach.io.count, iters_x1214_inr_Foreach.io.count, 0.U, 0.U)
      val b1201 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1201.suggestName("b1201")
      val b1202 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1202.suggestName("b1202")
      val x1203_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1203_rd""")
      val x1203_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1203_rd_ofs = List[UInt](b1201.r)
      val x1203_rd_en = List[Bool](true.B)
      val x1203_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1202 & b1046 & b559 ).suggestName("x1203_rd_shared_en")
      x1203_rd.toSeq.zip(x1052_tmp_3.connectRPort(1203, x1203_rd_banks, x1203_rd_ofs, io.sigsIn.backpressure, x1203_rd_en.map(_ && x1203_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1204 = VecApply(x1203,0)
      val x1204_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1204_elem_0""")
      x1204_elem_0.r := x1203_rd(0).r
      val x1205_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1205_mul""")
      x1205_mul.r := (Math.mul(x1204_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1205_mul")).r
      val x1206_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1206_rd""")
      val x1206_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1206_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1206_rd_en = List[Bool](true.B)
      val x1206_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1202 & b1046 & b559 ).suggestName("x1206_rd_shared_en")
      x1206_rd.toSeq.zip(x1135_force_0.connectRPort(1206, x1206_rd_banks, x1206_rd_ofs, io.sigsIn.backpressure, x1206_rd_en.map(_ && x1206_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1207 = VecApply(x1206,0)
      val x1207_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1207_elem_0""")
      x1207_elem_0.r := x1206_rd(0).r
      val x3303 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3303_x1207_elem_0_D6") 
      x3303.r := getRetimed(x1207_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1208_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1208_mul""")
      x1208_mul.r := (Math.mul(x1205_mul, x3303, Some(6.0), true.B, Truncate, Wrapping, "x1208_mul")).r
      val x3304 = Wire(Bool()).suggestName("x3304_b1046_D14") 
      x3304.r := getRetimed(b1046.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3305 = Wire(Bool()).suggestName("x3305_b559_D14") 
      x3305.r := getRetimed(b559.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3306 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3306_b1201_D14") 
      x3306.r := getRetimed(b1201.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3307 = Wire(Bool()).suggestName("x3307_b1202_D14") 
      x3307.r := getRetimed(b1202.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1209_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1209_wr_ofs = List[UInt](x3306.r)
      val x1209_wr_en = List[Bool](true.B)
      val x1209_wr_data = List[UInt](x1208_mul.r)
      x1051_tmp_2.connectWPort(1209, x1209_wr_banks, x1209_wr_ofs, x1209_wr_data, x1209_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3307 & x3304 & x3305))
      val x1210_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1210_wr_ofs = List[UInt](x3306.r)
      val x1210_wr_en = List[Bool](true.B)
      val x1210_wr_data = List[UInt](x1208_mul.r)
      x1050_tmp_1.connectWPort(1210, x1210_wr_banks, x1210_wr_ofs, x1210_wr_data, x1210_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3307 & x3304 & x3305))
      val x1211_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1211_wr_ofs = List[UInt](x3306.r)
      val x1211_wr_en = List[Bool](true.B)
      val x1211_wr_data = List[UInt](x1208_mul.r)
      x1049_tmp_0.connectWPort(1211, x1211_wr_banks, x1211_wr_ofs, x1211_wr_data, x1211_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3307 & x3304 & x3305))
      val x1212_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1212_wr_ofs = List[UInt](x3306.r)
      val x1212_wr_en = List[Bool](true.B)
      val x1212_wr_data = List[UInt](x1208_mul.r)
      x1053_tmp_4.connectWPort(1212, x1212_wr_banks, x1212_wr_ofs, x1212_wr_data, x1212_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3307 & x3304 & x3305))
      val x1213_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1213_wr_ofs = List[UInt](x3306.r)
      val x1213_wr_en = List[Bool](true.B)
      val x1213_wr_data = List[UInt](x1208_mul.r)
      x1052_tmp_3.connectWPort(1213, x1213_wr_banks, x1213_wr_ofs, x1213_wr_data, x1213_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3307 & x3304 & x3305))
    }
    val module = Module(new x1214_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1214_inr_Foreach **/
