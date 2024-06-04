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

/** Hierarchy: x1341 -> x1342 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1341_inr_UnitPipe **/
class x1341_inr_UnitPipe_kernel(
  list_b1255: List[Bool],
  list_x1315_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x1341_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1341_inr_UnitPipe_iiCtr"))
  
  abstract class x1341_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1315_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1315_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1264_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1264_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1255 = Input(Bool())
      val in_x1263_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1263_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1262_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1262_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1315_r_0 = {io.in_x1315_r_0} ; io.in_x1315_r_0 := DontCare
    def x1264_tmp_2 = {io.in_x1264_tmp_2} ; io.in_x1264_tmp_2 := DontCare
    def b1255 = {io.in_b1255} 
    def x1263_tmp_1 = {io.in_x1263_tmp_1} ; io.in_x1263_tmp_1 := DontCare
    def x1262_tmp_0 = {io.in_x1262_tmp_0} ; io.in_x1262_tmp_0 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1341_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1315_r_0.connectLedger(module.io.in_x1315_r_0)
    x1264_tmp_2.connectLedger(module.io.in_x1264_tmp_2)
    module.io.in_b1255 <> b1255
    x1263_tmp_1.connectLedger(module.io.in_x1263_tmp_1)
    x1262_tmp_0.connectLedger(module.io.in_x1262_tmp_0)
    module.io.in_b560 <> b560
  }
  val b1255 = list_b1255(0)
  val b560 = list_b1255(1)
  val x1315_r_0 = list_x1315_r_0(0)
  val x1264_tmp_2 = list_x1315_r_0(1)
  val x1263_tmp_1 = list_x1315_r_0(2)
  val x1262_tmp_0 = list_x1315_r_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1341_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1341_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1341_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1341_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1341_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1341_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1341_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1341_instrctr, cycles_x1341_inr_UnitPipe.io.count, iters_x1341_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1329_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1329_rd""")
      val x1329_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1329_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1329_rd_en = List[Bool](true.B)
      val x1329_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1329_rd_shared_en")
      x1329_rd.toSeq.zip(x1262_tmp_0.connectRPort(1329, x1329_rd_banks, x1329_rd_ofs, io.sigsIn.backpressure, x1329_rd_en.map(_ && x1329_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1330 = VecApply(x1329,0)
      val x1330_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1330_elem_0""")
      x1330_elem_0.r := x1329_rd(0).r
      val x1332_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1332_rd""")
      val x1332_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1332_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x1332_rd_en = List[Bool](true.B)
      val x1332_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1332_rd_shared_en")
      x1332_rd.toSeq.zip(x1263_tmp_1.connectRPort(1332, x1332_rd_banks, x1332_rd_ofs, io.sigsIn.backpressure, x1332_rd_en.map(_ && x1332_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1333 = VecApply(x1332,0)
      val x1333_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1333_elem_0""")
      x1333_elem_0.r := x1332_rd(0).r
      val x1334_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1334_mul""")
      x1334_mul.r := (Math.mul(x1333_elem_0, x1333_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x1334_mul")).r
      val x3352 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3352_x1330_elem_0_D6") 
      x3352.r := getRetimed(x1330_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3023 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3023""")
      x3023.r := Math.fma(x3352,x3352,x1334_mul,Some(6.0), true.B, "x3023").toFixed(x3023, "cast_x3023").r
      val x1336_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1336_rd""")
      val x1336_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1336_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x1336_rd_en = List[Bool](true.B)
      val x1336_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1336_rd_shared_en")
      x1336_rd.toSeq.zip(x1264_tmp_2.connectRPort(1336, x1336_rd_banks, x1336_rd_ofs, io.sigsIn.backpressure, x1336_rd_en.map(_ && x1336_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1337 = VecApply(x1336,0)
      val x1337_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1337_elem_0""")
      x1337_elem_0.r := x1336_rd(0).r
      val x3353 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3353_x1337_elem_0_D12") 
      x3353.r := getRetimed(x1337_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3024 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3024""")
      x3024.r := Math.fma(x3353,x3353,x3023,Some(6.0), true.B, "x3024").toFixed(x3024, "cast_x3024").r
      val x1340_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1340_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1340_wr_en = List[Bool](true.B)
      val x1340_wr_data = List[UInt](x3024.r)
      x1315_r_0.connectWPort(1340, x1340_wr_banks, x1340_wr_ofs, x1340_wr_data, x1340_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1341_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1341_inr_UnitPipe **/
