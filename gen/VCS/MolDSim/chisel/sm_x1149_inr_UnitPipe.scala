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

/** Hierarchy: x1149 -> x1159 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1149_inr_UnitPipe **/
class x1149_inr_UnitPipe_kernel(
  list_b1046: List[Bool],
  list_x1137_reg: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 3.8.toInt, myName = "x1149_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1149_inr_UnitPipe_iiCtr"))
  
  abstract class x1149_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1137_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1137_reg_p").asInstanceOf[NBufParams] ))
      val in_b1046 = Input(Bool())
      val in_b559 = Input(Bool())
      val in_x1106_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1106_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1139_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1139_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1137_reg = {io.in_x1137_reg} ; io.in_x1137_reg := DontCare
    def b1046 = {io.in_b1046} 
    def b559 = {io.in_b559} 
    def x1106_r_0 = {io.in_x1106_r_0} ; io.in_x1106_r_0 := DontCare
    def x1139_reg = {io.in_x1139_reg} ; io.in_x1139_reg := DontCare
  }
  def connectWires0(module: x1149_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x1137_reg.connectLedger(module.io.in_x1137_reg)
    module.io.in_b1046 <> b1046
    module.io.in_b559 <> b559
    x1106_r_0.connectLedger(module.io.in_x1106_r_0)
    x1139_reg.connectLedger(module.io.in_x1139_reg)
  }
  val b1046 = list_b1046(0)
  val b559 = list_b1046(1)
  val x1137_reg = list_x1137_reg(0)
  val x1106_r_0 = list_x1137_reg(1)
  val x1139_reg = list_x1137_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1149_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x1149_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1149_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1149_inr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x1149_inr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x1149_inr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x1149_inr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1149_instrctr, cycles_x1149_inr_UnitPipe.io.count, iters_x1149_inr_UnitPipe.io.count, 0.U, 0.U)
      val x1141_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1141_rd""")
      val x1141_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1141_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1141_rd_en = List[Bool](true.B)
      val x1141_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1141_rd_shared_en")
      x1141_rd.toSeq.zip(x1106_r_0.connectRPort(1141, x1141_rd_banks, x1141_rd_ofs, io.sigsIn.backpressure, x1141_rd_en.map(_ && x1141_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1142 = VecApply(x1141,0)
      val x1142_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1142_elem_0""")
      x1142_elem_0.r := x1141_rd(0).r
      val x1143 = Wire(Bool()).suggestName("""x1143""")
      x1143.r := Math.lt(0.FP(true, 10, 22), x1142_elem_0, Some(0.4), true.B,"x1143").r
      val x1144 = Wire(Bool()).suggestName("""x1144""")
      x1144.r := Math.lt(1.FP(true, 10, 22), x1142_elem_0, Some(0.4), true.B,"x1144").r
      val x1145 = Wire(Bool()).suggestName("""x1145""")
      x1145 := x1143 & x1144
      val x1146 = Wire(Bool()).suggestName("""x1146""")
      x1146 := ~x1145
      val x1147_wr_x1137_banks = List[UInt]()
      val x1147_wr_x1137_ofs = List[UInt]()
      val x1147_wr_x1137_en = List[Bool](true.B)
      val x1147_wr_x1137_data = List[UInt](x1145.r)
      x1137_reg.connectWPort(1147, x1147_wr_x1137_banks, x1147_wr_x1137_ofs, x1147_wr_x1137_data, x1147_wr_x1137_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x1148_wr_x1139_banks = List[UInt]()
      val x1148_wr_x1139_ofs = List[UInt]()
      val x1148_wr_x1139_en = List[Bool](true.B)
      val x1148_wr_x1139_data = List[UInt](x1146.r)
      x1139_reg.connectWPort(1148, x1148_wr_x1139_banks, x1148_wr_x1139_ofs, x1148_wr_x1139_data, x1148_wr_x1139_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.8.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x1149_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x1149_inr_UnitPipe **/
