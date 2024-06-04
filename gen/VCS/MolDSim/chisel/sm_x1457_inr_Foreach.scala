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

/** Hierarchy: x1457 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1457_inr_Foreach **/
class x1457_inr_Foreach_kernel(
  list_b1255: List[Bool],
  list_b1251: List[FixedPoint],
  list_x573_accum_0: List[StandardInterface],
  list_x574_accum_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x1457_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1457_inr_Foreach_iiCtr"))
  
  abstract class x1457_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x574_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x574_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b1255 = Input(Bool())
      val in_x1266_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1266_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1251 = Input(new FixedPoint(true, 32, 0))
      val in_x573_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x573_accum_0_p").asInstanceOf[MemParams] ))
      val in_x1261_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1261_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x574_accum_1 = {io.in_x574_accum_1} ; io.in_x574_accum_1 := DontCare
    def b1255 = {io.in_b1255} 
    def x1266_tmp_4 = {io.in_x1266_tmp_4} ; io.in_x1266_tmp_4 := DontCare
    def b1251 = {io.in_b1251} 
    def x573_accum_0 = {io.in_x573_accum_0} ; io.in_x573_accum_0 := DontCare
    def x1261_tmp_4 = {io.in_x1261_tmp_4} ; io.in_x1261_tmp_4 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1457_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x574_accum_1.connectLedger(module.io.in_x574_accum_1)
    module.io.in_b1255 <> b1255
    x1266_tmp_4.connectLedger(module.io.in_x1266_tmp_4)
    module.io.in_b1251 <> b1251
    x573_accum_0.connectLedger(module.io.in_x573_accum_0)
    x1261_tmp_4.connectLedger(module.io.in_x1261_tmp_4)
    module.io.in_b560 <> b560
  }
  val b1255 = list_b1255(0)
  val b560 = list_b1255(1)
  val b1251 = list_b1251(0)
  val x573_accum_0 = list_x573_accum_0(0)
  val x574_accum_1 = list_x574_accum_1(0)
  val x1266_tmp_4 = list_x574_accum_1(1)
  val x1261_tmp_4 = list_x574_accum_1(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1457_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1457_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1457_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1457_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1457_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1457_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1457_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1457_instrctr, cycles_x1457_inr_Foreach.io.count, iters_x1457_inr_Foreach.io.count, 0.U, 0.U)
      val b1253 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1253.suggestName("b1253")
      val b1256 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1256.suggestName("b1256")
      val x1438_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1438_rd""")
      val x1438_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1438_rd_ofs = List[UInt](b1253.r)
      val x1438_rd_en = List[Bool](true.B)
      val x1438_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1256 & b560 ).suggestName("x1438_rd_shared_en")
      x1438_rd.toSeq.zip(x1261_tmp_4.connectRPort(1438, x1438_rd_banks, x1438_rd_ofs, io.sigsIn.backpressure, x1438_rd_en.map(_ && x1438_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1439 = VecApply(x1438,0)
      val x1439_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1439_elem_0""")
      x1439_elem_0.r := x1438_rd(0).r
      val x1440_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1440_rd""")
      val x1440_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1440_rd_ofs = List[UInt](b1253.r)
      val x1440_rd_en = List[Bool](true.B)
      val x1440_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1256 & b560 ).suggestName("x1440_rd_shared_en")
      x1440_rd.toSeq.zip(x1266_tmp_4.connectRPort(1440, x1440_rd_banks, x1440_rd_ofs, io.sigsIn.backpressure, x1440_rd_en.map(_ && x1440_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1441 = VecApply(x1440,0)
      val x1441_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1441_elem_0""")
      x1441_elem_0.r := x1440_rd(0).r
      val x3374 = Wire(Bool()).suggestName("x3374_b560_D1") 
      x3374.r := getRetimed(b560.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3375 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3375_b1253_D1") 
      x3375.r := getRetimed(b1253.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3376 = Wire(Bool()).suggestName("x3376_b1256_D1") 
      x3376.r := getRetimed(b1256.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1442_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1442_rd""")
      val x1442_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1442_rd_ofs = List[UInt](x3375.r)
      val x1442_rd_en = List[Bool](true.B)
      val x1442_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3376 & x3374 ).suggestName("x1442_rd_shared_en")
      x1442_rd.toSeq.zip(x573_accum_0.connectRPort(1442, x1442_rd_banks, x1442_rd_ofs, io.sigsIn.backpressure, x1442_rd_en.map(_ && x1442_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1443 = VecApply(x1442,0)
      val x1443_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1443_elem_0""")
      x1443_elem_0.r := x1442_rd(0).r
      val x1444 = Wire(Bool()).suggestName("""x1444""")
      x1444 := b1256 & b560
      val x1446 = Wire(Bool()).suggestName("""x1446""")
      x1446 := b1255 & b560
      val x1448 = Wire(Bool()).suggestName("""x1448""")
      x1448 := x1446 & x1444
      val x1449_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1449_sum""")
      x1449_sum.r := Math.add(x1439_elem_0,x1441_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1449_sum").r
      val x3377 = Wire(Bool()).suggestName("x3377_x1448_D3") 
      x3377.r := getRetimed(x1448.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x3378 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3378_x1439_elem_0_D1") 
      x3378.r := getRetimed(x1439_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1450 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1450""")
      x1450.r := Mux((x3377), x1449_sum.r, x3378.r)
      val x1452 = Wire(Bool()).suggestName("""x1452""")
      x1452.r := Math.eql(b1251, 0L.FP(true, 32, 0), Some(0.2), true.B,"x1452").r
      val x1453_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1453_sum""")
      x1453_sum.r := Math.add(x1450,x1443_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1453_sum").r
      val x3379 = Wire(Bool()).suggestName("x3379_x1452_D4") 
      x3379.r := getRetimed(x1452.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x3380 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3380_x1450_D1") 
      x3380.r := getRetimed(x1450.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1454 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1454""")
      x1454.r := Mux((x3379), x3380.r, x1453_sum.r)
      val x3381 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3381_x1454_D1") 
      x3381.r := getRetimed(x1454.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3382 = Wire(Bool()).suggestName("x3382_b1256_D5") 
      x3382.r := getRetimed(b1256.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3383 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3383_b1253_D5") 
      x3383.r := getRetimed(b1253.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3384 = Wire(Bool()).suggestName("x3384_b560_D5") 
      x3384.r := getRetimed(b560.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x1455_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1455_wr_ofs = List[UInt](x3383.r)
      val x1455_wr_en = List[Bool](true.B)
      val x1455_wr_data = List[UInt](x3381.r)
      x573_accum_0.connectWPort(1455, x1455_wr_banks, x1455_wr_ofs, x1455_wr_data, x1455_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3382 & x3384))
      val x1456_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1456_wr_ofs = List[UInt](x3383.r)
      val x1456_wr_en = List[Bool](true.B)
      val x1456_wr_data = List[UInt](x3381.r)
      x574_accum_1.connectWPort(1456, x1456_wr_banks, x1456_wr_ofs, x1456_wr_data, x1456_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3382 & x3384))
      x1261_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x1266_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x1457_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1457_inr_Foreach **/
