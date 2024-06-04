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

/** Hierarchy: x717 -> x718 -> x834 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x717_inr_UnitPipe **/
class x717_inr_UnitPipe_kernel(
  list_b631: List[Bool],
  list_x638_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 21.0.toInt, myName = "x717_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x717_inr_UnitPipe_iiCtr"))
  
  abstract class x717_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x638_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x638_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b631 = Input(Bool())
      val in_b557 = Input(Bool())
      val in_x640_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x640_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x691_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x691_r_0_p").asInstanceOf[NBufParams] ))
      val in_x639_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x639_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x638_tmp_0 = {io.in_x638_tmp_0} ; io.in_x638_tmp_0 := DontCare
    def b631 = {io.in_b631} 
    def b557 = {io.in_b557} 
    def x640_tmp_2 = {io.in_x640_tmp_2} ; io.in_x640_tmp_2 := DontCare
    def x691_r_0 = {io.in_x691_r_0} ; io.in_x691_r_0 := DontCare
    def x639_tmp_1 = {io.in_x639_tmp_1} ; io.in_x639_tmp_1 := DontCare
  }
  def connectWires0(module: x717_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x638_tmp_0.connectLedger(module.io.in_x638_tmp_0)
    module.io.in_b631 <> b631
    module.io.in_b557 <> b557
    x640_tmp_2.connectLedger(module.io.in_x640_tmp_2)
    x691_r_0.connectLedger(module.io.in_x691_r_0)
    x639_tmp_1.connectLedger(module.io.in_x639_tmp_1)
  }
  val b631 = list_b631(0)
  val b557 = list_b631(1)
  val x638_tmp_0 = list_x638_tmp_0(0)
  val x640_tmp_2 = list_x638_tmp_0(1)
  val x691_r_0 = list_x638_tmp_0(2)
  val x639_tmp_1 = list_x638_tmp_0(3)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x717_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x717_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x717_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x717_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x717_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x717_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x717_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X717_instrctr, cycles_x717_inr_UnitPipe.io.count, iters_x717_inr_UnitPipe.io.count, 0.U, 0.U)
      val x705_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x705_rd""")
      val x705_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x705_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x705_rd_en = List[Bool](true.B)
      val x705_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x705_rd_shared_en")
      x705_rd.toSeq.zip(x638_tmp_0.connectRPort(705, x705_rd_banks, x705_rd_ofs, io.sigsIn.backpressure, x705_rd_en.map(_ && x705_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x706 = VecApply(x705,0)
      val x706_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x706_elem_0""")
      x706_elem_0.r := x705_rd(0).r
      val x708_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x708_rd""")
      val x708_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x708_rd_ofs = List[UInt](1L.FP(true, 32, 0).r)
      val x708_rd_en = List[Bool](true.B)
      val x708_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x708_rd_shared_en")
      x708_rd.toSeq.zip(x639_tmp_1.connectRPort(708, x708_rd_banks, x708_rd_ofs, io.sigsIn.backpressure, x708_rd_en.map(_ && x708_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x709 = VecApply(x708,0)
      val x709_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x709_elem_0""")
      x709_elem_0.r := x708_rd(0).r
      val x710_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x710_mul""")
      x710_mul.r := (Math.mul(x709_elem_0, x709_elem_0, Some(6.0), true.B, Truncate, Wrapping, "x710_mul")).r
      val x3169 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3169_x706_elem_0_D6") 
      x3169.r := getRetimed(x706_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2987 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2987""")
      x2987.r := Math.fma(x3169,x3169,x710_mul,Some(6.0), true.B, "x2987").toFixed(x2987, "cast_x2987").r
      val x712_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x712_rd""")
      val x712_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x712_rd_ofs = List[UInt](2L.FP(true, 32, 0).r)
      val x712_rd_en = List[Bool](true.B)
      val x712_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x712_rd_shared_en")
      x712_rd.toSeq.zip(x640_tmp_2.connectRPort(712, x712_rd_banks, x712_rd_ofs, io.sigsIn.backpressure, x712_rd_en.map(_ && x712_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x713 = VecApply(x712,0)
      val x713_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x713_elem_0""")
      x713_elem_0.r := x712_rd(0).r
      val x3170 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3170_x713_elem_0_D12") 
      x3170.r := getRetimed(x713_elem_0.r, 12.toInt, io.sigsIn.backpressure & true.B)
      val x2988 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2988""")
      x2988.r := Math.fma(x3170,x3170,x2987,Some(6.0), true.B, "x2988").toFixed(x2988, "cast_x2988").r
      val x716_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x716_wr_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x716_wr_en = List[Bool](true.B)
      val x716_wr_data = List[UInt](x2988.r)
      x691_r_0.connectWPort(716, x716_wr_banks, x716_wr_ofs, x716_wr_data, x716_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(20.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x717_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x717_inr_UnitPipe **/
