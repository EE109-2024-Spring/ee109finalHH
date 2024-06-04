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

/** Hierarchy: x1436 -> x1437 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1436_inr_Foreach **/
class x1436_inr_Foreach_kernel(
  list_b1255: List[Bool],
  list_x1265_tmp_3: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1436_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1436_inr_Foreach_iiCtr"))
  
  abstract class x1436_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1265_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1265_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1264_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1264_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1255 = Input(Bool())
      val in_x1263_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1263_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1266_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1266_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1344_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1344_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1262_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1262_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1265_tmp_3 = {io.in_x1265_tmp_3} ; io.in_x1265_tmp_3 := DontCare
    def x1264_tmp_2 = {io.in_x1264_tmp_2} ; io.in_x1264_tmp_2 := DontCare
    def b1255 = {io.in_b1255} 
    def x1263_tmp_1 = {io.in_x1263_tmp_1} ; io.in_x1263_tmp_1 := DontCare
    def x1266_tmp_4 = {io.in_x1266_tmp_4} ; io.in_x1266_tmp_4 := DontCare
    def x1344_force_0 = {io.in_x1344_force_0} ; io.in_x1344_force_0 := DontCare
    def x1262_tmp_0 = {io.in_x1262_tmp_0} ; io.in_x1262_tmp_0 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1436_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1265_tmp_3.connectLedger(module.io.in_x1265_tmp_3)
    x1264_tmp_2.connectLedger(module.io.in_x1264_tmp_2)
    module.io.in_b1255 <> b1255
    x1263_tmp_1.connectLedger(module.io.in_x1263_tmp_1)
    x1266_tmp_4.connectLedger(module.io.in_x1266_tmp_4)
    x1344_force_0.connectLedger(module.io.in_x1344_force_0)
    x1262_tmp_0.connectLedger(module.io.in_x1262_tmp_0)
    module.io.in_b560 <> b560
  }
  val b1255 = list_b1255(0)
  val b560 = list_b1255(1)
  val x1265_tmp_3 = list_x1265_tmp_3(0)
  val x1264_tmp_2 = list_x1265_tmp_3(1)
  val x1263_tmp_1 = list_x1265_tmp_3(2)
  val x1266_tmp_4 = list_x1265_tmp_3(3)
  val x1344_force_0 = list_x1265_tmp_3(4)
  val x1262_tmp_0 = list_x1265_tmp_3(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1436_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1436_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1436_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1436_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1436_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1436_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1436_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1436_instrctr, cycles_x1436_inr_Foreach.io.count, iters_x1436_inr_Foreach.io.count, 0.U, 0.U)
      val b1423 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1423.suggestName("b1423")
      val b1424 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1424.suggestName("b1424")
      val x1425_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1425_rd""")
      val x1425_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1425_rd_ofs = List[UInt](b1423.r)
      val x1425_rd_en = List[Bool](true.B)
      val x1425_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1424 & b1255 & b560 ).suggestName("x1425_rd_shared_en")
      x1425_rd.toSeq.zip(x1265_tmp_3.connectRPort(1425, x1425_rd_banks, x1425_rd_ofs, io.sigsIn.backpressure, x1425_rd_en.map(_ && x1425_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1426 = VecApply(x1425,0)
      val x1426_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1426_elem_0""")
      x1426_elem_0.r := x1425_rd(0).r
      val x1427_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1427_mul""")
      x1427_mul.r := (Math.mul(x1426_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1427_mul")).r
      val x1428_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1428_rd""")
      val x1428_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1428_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1428_rd_en = List[Bool](true.B)
      val x1428_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1424 & b1255 & b560 ).suggestName("x1428_rd_shared_en")
      x1428_rd.toSeq.zip(x1344_force_0.connectRPort(1428, x1428_rd_banks, x1428_rd_ofs, io.sigsIn.backpressure, x1428_rd_en.map(_ && x1428_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1429 = VecApply(x1428,0)
      val x1429_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1429_elem_0""")
      x1429_elem_0.r := x1428_rd(0).r
      val x3369 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3369_x1429_elem_0_D6") 
      x3369.r := getRetimed(x1429_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1430_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1430_mul""")
      x1430_mul.r := (Math.mul(x1427_mul, x3369, Some(6.0), true.B, Truncate, Wrapping, "x1430_mul")).r
      val x3370 = Wire(Bool()).suggestName("x3370_b1255_D14") 
      x3370.r := getRetimed(b1255.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3371 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3371_b1423_D14") 
      x3371.r := getRetimed(b1423.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3372 = Wire(Bool()).suggestName("x3372_b1424_D14") 
      x3372.r := getRetimed(b1424.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3373 = Wire(Bool()).suggestName("x3373_b560_D14") 
      x3373.r := getRetimed(b560.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1431_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1431_wr_ofs = List[UInt](x3371.r)
      val x1431_wr_en = List[Bool](true.B)
      val x1431_wr_data = List[UInt](x1430_mul.r)
      x1265_tmp_3.connectWPort(1431, x1431_wr_banks, x1431_wr_ofs, x1431_wr_data, x1431_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3372 & x3370 & x3373))
      val x1432_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1432_wr_ofs = List[UInt](x3371.r)
      val x1432_wr_en = List[Bool](true.B)
      val x1432_wr_data = List[UInt](x1430_mul.r)
      x1264_tmp_2.connectWPort(1432, x1432_wr_banks, x1432_wr_ofs, x1432_wr_data, x1432_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3372 & x3370 & x3373))
      val x1433_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1433_wr_ofs = List[UInt](x3371.r)
      val x1433_wr_en = List[Bool](true.B)
      val x1433_wr_data = List[UInt](x1430_mul.r)
      x1263_tmp_1.connectWPort(1433, x1433_wr_banks, x1433_wr_ofs, x1433_wr_data, x1433_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3372 & x3370 & x3373))
      val x1434_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1434_wr_ofs = List[UInt](x3371.r)
      val x1434_wr_en = List[Bool](true.B)
      val x1434_wr_data = List[UInt](x1430_mul.r)
      x1266_tmp_4.connectWPort(1434, x1434_wr_banks, x1434_wr_ofs, x1434_wr_data, x1434_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3372 & x3370 & x3373))
      val x1435_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1435_wr_ofs = List[UInt](x3371.r)
      val x1435_wr_en = List[Bool](true.B)
      val x1435_wr_data = List[UInt](x1430_mul.r)
      x1262_tmp_0.connectWPort(1435, x1435_wr_banks, x1435_wr_ofs, x1435_wr_data, x1435_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3372 & x3370 & x3373))
    }
    val module = Module(new x1436_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1436_inr_Foreach **/
