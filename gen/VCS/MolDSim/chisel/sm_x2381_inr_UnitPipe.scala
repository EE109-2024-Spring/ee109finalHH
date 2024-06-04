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

/** Hierarchy: x2381 -> x2382 -> x2498 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2381_inr_UnitPipe **/
class x2381_inr_UnitPipe_kernel(
  list_b2295: List[Bool],
  list_x2304_tmp_2: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x2381_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2381_inr_UnitPipe_iiCtr"))
  
  abstract class x2381_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b2295 = Input(Bool())
      val in_b565 = Input(Bool())
      val in_x2304_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x2304_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x2355_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2355_r_0_p").asInstanceOf[NBufParams] ))
      val in_x2303_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x2303_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x2302_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x2302_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b2295 = {io.in_b2295} 
    def b565 = {io.in_b565} 
    def x2304_tmp_2 = {io.in_x2304_tmp_2} ; io.in_x2304_tmp_2 := DontCare
    def x2355_r_0 = {io.in_x2355_r_0} ; io.in_x2355_r_0 := DontCare
    def x2303_tmp_1 = {io.in_x2303_tmp_1} ; io.in_x2303_tmp_1 := DontCare
    def x2302_tmp_0 = {io.in_x2302_tmp_0} ; io.in_x2302_tmp_0 := DontCare
  }
  def connectWires0(module: x2381_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b2295 <> b2295
    module.io.in_b565 <> b565
    x2304_tmp_2.connectLedger(module.io.in_x2304_tmp_2)
    x2355_r_0.connectLedger(module.io.in_x2355_r_0)
    x2303_tmp_1.connectLedger(module.io.in_x2303_tmp_1)
    x2302_tmp_0.connectLedger(module.io.in_x2302_tmp_0)
  }
  val b2295 = list_b2295(0)
  val b565 = list_b2295(1)
  val x2304_tmp_2 = list_x2304_tmp_2(0)
  val x2355_r_0 = list_x2304_tmp_2(1)
  val x2303_tmp_1 = list_x2304_tmp_2(2)
  val x2302_tmp_0 = list_x2304_tmp_2(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2381_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2381_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2381_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2381_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2381_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2381_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2381_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2381_instrctr, cycles_x2381_inr_UnitPipe.io.count, iters_x2381_inr_UnitPipe.io.count, 0.U, 0.U)
      val x2369_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2369_rd""")
      val x2369_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2369_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2369_rd_en = List[Bool](true.B)
      val x2369_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2369_rd_shared_en")
      x2369_rd.toSeq.zip(x2302_tmp_0.connectRPort(2369, x2369_rd_banks, x2369_rd_ofs, io.sigsIn.backpressure, x2369_rd_en.map(_ && x2369_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2370 = VecApply(x2369,0)
      val x2370_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2370_elem_0""")
      x2370_elem_0.r := x2369_rd(0).r
      val x2372_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2372_rd""")
      val x2372_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2372_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x2372_rd_en = List[Bool](true.B)
      val x2372_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2372_rd_shared_en")
      x2372_rd.toSeq.zip(x2303_tmp_1.connectRPort(2372, x2372_rd_banks, x2372_rd_ofs, io.sigsIn.backpressure, x2372_rd_en.map(_ && x2372_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2373 = VecApply(x2372,0)
      val x2373_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2373_elem_0""")
      x2373_elem_0.r := x2372_rd(0).r
      val x2374_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2374_mul""")
      x2374_mul.r := (Math.mul(x2373_elem_0, x2373_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x2374_mul")).r
      val x3657 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3657_x2370_elem_0_D6") 
      x3657.r := getRetimed(x2370_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3083 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3083""")
      x3083.r := Math.fma(x3657,x3657,x2374_mul,Some(6.0), true.B, "x3083").toFixed(x3083, "cast_x3083").r
      val x2376_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2376_rd""")
      val x2376_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2376_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x2376_rd_en = List[Bool](true.B)
      val x2376_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2376_rd_shared_en")
      x2376_rd.toSeq.zip(x2304_tmp_2.connectRPort(2376, x2376_rd_banks, x2376_rd_ofs, io.sigsIn.backpressure, x2376_rd_en.map(_ && x2376_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2377 = VecApply(x2376,0)
      val x2377_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2377_elem_0""")
      x2377_elem_0.r := x2376_rd(0).r
      val x3658 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3658_x2377_elem_0_D12") 
      x3658.r := getRetimed(x2377_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x3084 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x3084""")
      x3084.r := Math.fma(x3658,x3658,x3083,Some(6.0), true.B, "x3084").toFixed(x3084, "cast_x3084").r
      val x2380_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2380_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2380_wr_en = List[Bool](true.B)
      val x2380_wr_data = List[UInt](x3084.r)
      x2355_r_0.connectWPort(2380, x2380_wr_banks, x2380_wr_ofs, x2380_wr_data, x2380_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x2381_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2381_inr_UnitPipe **/
