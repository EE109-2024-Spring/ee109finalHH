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

/** Hierarchy: x950 -> x951 -> x1042 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x950_inr_UnitPipe **/
class x950_inr_UnitPipe_kernel(
  list_b558: List[Bool],
  list_x930_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x950_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x950_inr_UnitPipe_iiCtr"))
  
  abstract class x950_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x930_reg = Flipped(new NBufInterface(ModuleParams.getParams("x930_reg_p").asInstanceOf[NBufParams] ))
      val in_b558 = Input(Bool())
      val in_x932_reg = Flipped(new NBufInterface(ModuleParams.getParams("x932_reg_p").asInstanceOf[NBufParams] ))
      val in_x899_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x899_r_0_p").asInstanceOf[NBufParams] ))
      val in_b839 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x930_reg = {io.in_x930_reg} ; io.in_x930_reg := DontCare
    def b558 = {io.in_b558} 
    def x932_reg = {io.in_x932_reg} ; io.in_x932_reg := DontCare
    def x899_r_0 = {io.in_x899_r_0} ; io.in_x899_r_0 := DontCare
    def b839 = {io.in_b839} 
  }
  def connectWires0(module: x950_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x930_reg.connectLedger(module.io.in_x930_reg)
    module.io.in_b558 <> b558
    x932_reg.connectLedger(module.io.in_x932_reg)
    x899_r_0.connectLedger(module.io.in_x899_r_0)
    module.io.in_b839 <> b839
  }
  val b558 = list_b558(0)
  val b839 = list_b558(1)
  val x930_reg = list_x930_reg(0)
  val x932_reg = list_x930_reg(1)
  val x899_r_0 = list_x930_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x950_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x950_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x950_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x950_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x950_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x950_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x950_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X950_instrctr, cycles_x950_inr_UnitPipe.io.count, iters_x950_inr_UnitPipe.io.count, 0.U, 0.U)
      val x942_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x942_rd""")
      val x942_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x942_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x942_rd_en = List[Bool](true.B)
      val x942_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x942_rd_shared_en")
      x942_rd.toSeq.zip(x899_r_0.connectRPort(942, x942_rd_banks, x942_rd_ofs, io.sigsIn.backpressure, x942_rd_en.map(_ && x942_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x943 = VecApply(x942,0)
      val x943_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x943_elem_0""")
      x943_elem_0.r := x942_rd(0).r
      val x944 = Wire(Bool()).suggestName("""x944""")
      x944.r := Math.lt(0.FP(true, 10, 22), x943_elem_0, Some(0.4), true.B,"x944").r
      val x945 = Wire(Bool()).suggestName("""x945""")
      x945.r := Math.lt(1.FP(true, 10, 22), x943_elem_0, Some(0.4), true.B,"x945").r
      val x946 = Wire(Bool()).suggestName("""x946""")
      x946 := x944 & x945
      val x947 = Wire(Bool()).suggestName("""x947""")
      x947 := ~x946
      val x948_wr_x930_banks = List[UInt]()
      val x948_wr_x930_ofs = List[UInt]()
      val x948_wr_x930_en = List[Bool](true.B)
      val x948_wr_x930_data = List[UInt](x946.r)
      x930_reg.connectWPort(948, x948_wr_x930_banks, x948_wr_x930_ofs, x948_wr_x930_data, x948_wr_x930_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x949_wr_x932_banks = List[UInt]()
      val x949_wr_x932_ofs = List[UInt]()
      val x949_wr_x932_en = List[Bool](true.B)
      val x949_wr_x932_data = List[UInt](x947.r)
      x932_reg.connectWPort(949, x949_wr_x932_banks, x949_wr_x932_ofs, x949_wr_x932_data, x949_wr_x932_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x950_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x950_inr_UnitPipe **/
