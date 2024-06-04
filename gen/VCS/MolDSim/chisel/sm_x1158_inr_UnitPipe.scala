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

/** Hierarchy: x1158 -> x1159 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1158_inr_UnitPipe **/
class x1158_inr_UnitPipe_kernel(
  list_b559: List[Bool],
  list_x1138_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1158_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1158_inr_UnitPipe_iiCtr"))
  
  abstract class x1158_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b559 = Input(Bool())
      val in_b1047 = Input(Bool())
      val in_x1138_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1138_reg_p").asInstanceOf[NBufParams] ))
      val in_x1107_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1107_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1140_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1140_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b559 = {io.in_b559} 
    def b1047 = {io.in_b1047} 
    def x1138_reg = {io.in_x1138_reg} ; io.in_x1138_reg := DontCare
    def x1107_r_0 = {io.in_x1107_r_0} ; io.in_x1107_r_0 := DontCare
    def x1140_reg = {io.in_x1140_reg} ; io.in_x1140_reg := DontCare
  }
  def connectWires0(module: x1158_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b559 <> b559
    module.io.in_b1047 <> b1047
    x1138_reg.connectLedger(module.io.in_x1138_reg)
    x1107_r_0.connectLedger(module.io.in_x1107_r_0)
    x1140_reg.connectLedger(module.io.in_x1140_reg)
  }
  val b559 = list_b559(0)
  val b1047 = list_b559(1)
  val x1138_reg = list_x1138_reg(0)
  val x1107_r_0 = list_x1138_reg(1)
  val x1140_reg = list_x1138_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1158_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1158_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1158_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1158_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1158_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1158_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1158_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1158_instrctr, cycles_x1158_inr_UnitPipe.io.count, iters_x1158_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1150_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1150_rd""")
      val x1150_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1150_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1150_rd_en = List[Bool](true.B)
      val x1150_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1150_rd_shared_en")
      x1150_rd.toSeq.zip(x1107_r_0.connectRPort(1150, x1150_rd_banks, x1150_rd_ofs, io.sigsIn.backpressure, x1150_rd_en.map(_ && x1150_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1151 = VecApply(x1150,0)
      val x1151_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1151_elem_0""")
      x1151_elem_0.r := x1150_rd(0).r
      val x1152 = Wire(Bool()).suggestName("""x1152""")
      x1152.r := Math.lt(0.FP(true, 10, 22), x1151_elem_0, Some(0.4), true.B,"x1152").r
      val x1153 = Wire(Bool()).suggestName("""x1153""")
      x1153.r := Math.lt(1.FP(true, 10, 22), x1151_elem_0, Some(0.4), true.B,"x1153").r
      val x1154 = Wire(Bool()).suggestName("""x1154""")
      x1154 := x1152 & x1153
      val x1155 = Wire(Bool()).suggestName("""x1155""")
      x1155 := ~x1154
      val x1156_wr_x1138_banks = List[UInt]()
      val x1156_wr_x1138_ofs = List[UInt]()
      val x1156_wr_x1138_en = List[Bool](true.B)
      val x1156_wr_x1138_data = List[UInt](x1154.r)
      x1138_reg.connectWPort(1156, x1156_wr_x1138_banks, x1156_wr_x1138_ofs, x1156_wr_x1138_data, x1156_wr_x1138_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1157_wr_x1140_banks = List[UInt]()
      val x1157_wr_x1140_ofs = List[UInt]()
      val x1157_wr_x1140_en = List[Bool](true.B)
      val x1157_wr_x1140_data = List[UInt](x1155.r)
      x1140_reg.connectWPort(1157, x1157_wr_x1140_banks, x1157_wr_x1140_ofs, x1157_wr_x1140_data, x1157_wr_x1140_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1158_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1158_inr_UnitPipe **/
