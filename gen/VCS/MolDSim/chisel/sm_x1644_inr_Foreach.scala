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

/** Hierarchy: x1644 -> x1645 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1644_inr_Foreach **/
class x1644_inr_Foreach_kernel(
  list_b561: List[Bool],
  list_x1470_tmp_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1644_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1644_inr_Foreach_iiCtr"))
  
  abstract class x1644_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1470_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1470_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_x1552_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1552_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1471_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1471_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1474_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1474_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1472_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1472_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1473_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1473_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b1463 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1470_tmp_0 = {io.in_x1470_tmp_0} ; io.in_x1470_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def x1552_force_0 = {io.in_x1552_force_0} ; io.in_x1552_force_0 := DontCare
    def x1471_tmp_1 = {io.in_x1471_tmp_1} ; io.in_x1471_tmp_1 := DontCare
    def x1474_tmp_4 = {io.in_x1474_tmp_4} ; io.in_x1474_tmp_4 := DontCare
    def x1472_tmp_2 = {io.in_x1472_tmp_2} ; io.in_x1472_tmp_2 := DontCare
    def x1473_tmp_3 = {io.in_x1473_tmp_3} ; io.in_x1473_tmp_3 := DontCare
    def b1463 = {io.in_b1463} 
  }
  def connectWires0(module: x1644_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1470_tmp_0.connectLedger(module.io.in_x1470_tmp_0)
    module.io.in_b561 <> b561
    x1552_force_0.connectLedger(module.io.in_x1552_force_0)
    x1471_tmp_1.connectLedger(module.io.in_x1471_tmp_1)
    x1474_tmp_4.connectLedger(module.io.in_x1474_tmp_4)
    x1472_tmp_2.connectLedger(module.io.in_x1472_tmp_2)
    x1473_tmp_3.connectLedger(module.io.in_x1473_tmp_3)
    module.io.in_b1463 <> b1463
  }
  val b561 = list_b561(0)
  val b1463 = list_b561(1)
  val x1470_tmp_0 = list_x1470_tmp_0(0)
  val x1552_force_0 = list_x1470_tmp_0(1)
  val x1471_tmp_1 = list_x1470_tmp_0(2)
  val x1474_tmp_4 = list_x1470_tmp_0(3)
  val x1472_tmp_2 = list_x1470_tmp_0(4)
  val x1473_tmp_3 = list_x1470_tmp_0(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1644_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1644_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1644_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1644_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1644_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1644_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1644_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1644_instrctr, cycles_x1644_inr_Foreach.io.count, iters_x1644_inr_Foreach.io.count, 0.U, 0.U)
      val b1631 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1631.suggestName("b1631")
      val b1632 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1632.suggestName("b1632")
      val x1633_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1633_rd""")
      val x1633_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1633_rd_ofs = List[UInt](b1631.r)
      val x1633_rd_en = List[Bool](true.B)
      val x1633_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1632 & b1463 & b561 ).suggestName("x1633_rd_shared_en")
      x1633_rd.toSeq.zip(x1473_tmp_3.connectRPort(1633, x1633_rd_banks, x1633_rd_ofs, io.sigsIn.backpressure, x1633_rd_en.map(_ && x1633_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1634 = VecApply(x1633,0)
      val x1634_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1634_elem_0""")
      x1634_elem_0.r := x1633_rd(0).r
      val x1635_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1635_mul""")
      x1635_mul.r := (Math.mul(x1634_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1635_mul")).r
      val x1636_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1636_rd""")
      val x1636_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1636_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1636_rd_en = List[Bool](true.B)
      val x1636_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1632 & b1463 & b561 ).suggestName("x1636_rd_shared_en")
      x1636_rd.toSeq.zip(x1552_force_0.connectRPort(1636, x1636_rd_banks, x1636_rd_ofs, io.sigsIn.backpressure, x1636_rd_en.map(_ && x1636_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1637 = VecApply(x1636,0)
      val x1637_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1637_elem_0""")
      x1637_elem_0.r := x1636_rd(0).r
      val x3430 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3430_x1637_elem_0_D6") 
      x3430.r := getRetimed(x1637_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1638_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1638_mul""")
      x1638_mul.r := (Math.mul(x1635_mul, x3430, Some(6.0), true.B, Truncate, Wrapping, "x1638_mul")).r
      val x3431 = Wire(Bool()).suggestName("x3431_b1632_D14") 
      x3431.r := getRetimed(b1632.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3432 = Wire(Bool()).suggestName("x3432_b561_D14") 
      x3432.r := getRetimed(b561.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3433 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3433_b1631_D14") 
      x3433.r := getRetimed(b1631.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3434 = Wire(Bool()).suggestName("x3434_b1463_D14") 
      x3434.r := getRetimed(b1463.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1639_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1639_wr_ofs = List[UInt](x3433.r)
      val x1639_wr_en = List[Bool](true.B)
      val x1639_wr_data = List[UInt](x1638_mul.r)
      x1470_tmp_0.connectWPort(1639, x1639_wr_banks, x1639_wr_ofs, x1639_wr_data, x1639_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3431 & x3434 & x3432))
      val x1640_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1640_wr_ofs = List[UInt](x3433.r)
      val x1640_wr_en = List[Bool](true.B)
      val x1640_wr_data = List[UInt](x1638_mul.r)
      x1471_tmp_1.connectWPort(1640, x1640_wr_banks, x1640_wr_ofs, x1640_wr_data, x1640_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3431 & x3434 & x3432))
      val x1641_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1641_wr_ofs = List[UInt](x3433.r)
      val x1641_wr_en = List[Bool](true.B)
      val x1641_wr_data = List[UInt](x1638_mul.r)
      x1474_tmp_4.connectWPort(1641, x1641_wr_banks, x1641_wr_ofs, x1641_wr_data, x1641_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3431 & x3434 & x3432))
      val x1642_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1642_wr_ofs = List[UInt](x3433.r)
      val x1642_wr_en = List[Bool](true.B)
      val x1642_wr_data = List[UInt](x1638_mul.r)
      x1472_tmp_2.connectWPort(1642, x1642_wr_banks, x1642_wr_ofs, x1642_wr_data, x1642_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3431 & x3434 & x3432))
      val x1643_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1643_wr_ofs = List[UInt](x3433.r)
      val x1643_wr_en = List[Bool](true.B)
      val x1643_wr_data = List[UInt](x1638_mul.r)
      x1473_tmp_3.connectWPort(1643, x1643_wr_banks, x1643_wr_ofs, x1643_wr_data, x1643_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3431 & x3434 & x3432))
    }
    val module = Module(new x1644_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1644_inr_Foreach **/
