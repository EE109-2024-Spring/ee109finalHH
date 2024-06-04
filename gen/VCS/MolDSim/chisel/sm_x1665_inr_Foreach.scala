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

/** Hierarchy: x1665 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1665_inr_Foreach **/
class x1665_inr_Foreach_kernel(
  list_b561: List[Bool],
  list_b1459: List[FixedPoint],
  list_x575_accum_0: List[StandardInterface],
  list_x1469_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 6.0.toInt, myName = "x1665_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1665_inr_Foreach_iiCtr"))
  
  abstract class x1665_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1469_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1469_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_x1474_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1474_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x576_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x576_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b1459 = Input(new FixedPoint(true, 32, 0))
      val in_x575_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x575_accum_0_p").asInstanceOf[MemParams] ))
      val in_b1463 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1469_tmp_4 = {io.in_x1469_tmp_4} ; io.in_x1469_tmp_4 := DontCare
    def b561 = {io.in_b561} 
    def x1474_tmp_4 = {io.in_x1474_tmp_4} ; io.in_x1474_tmp_4 := DontCare
    def x576_accum_1 = {io.in_x576_accum_1} ; io.in_x576_accum_1 := DontCare
    def b1459 = {io.in_b1459} 
    def x575_accum_0 = {io.in_x575_accum_0} ; io.in_x575_accum_0 := DontCare
    def b1463 = {io.in_b1463} 
  }
  def connectWires0(module: x1665_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1469_tmp_4.connectLedger(module.io.in_x1469_tmp_4)
    module.io.in_b561 <> b561
    x1474_tmp_4.connectLedger(module.io.in_x1474_tmp_4)
    x576_accum_1.connectLedger(module.io.in_x576_accum_1)
    module.io.in_b1459 <> b1459
    x575_accum_0.connectLedger(module.io.in_x575_accum_0)
    module.io.in_b1463 <> b1463
  }
  val b561 = list_b561(0)
  val b1463 = list_b561(1)
  val b1459 = list_b1459(0)
  val x575_accum_0 = list_x575_accum_0(0)
  val x1469_tmp_4 = list_x1469_tmp_4(0)
  val x1474_tmp_4 = list_x1469_tmp_4(1)
  val x576_accum_1 = list_x1469_tmp_4(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1665_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1665_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1665_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1665_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1665_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1665_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1665_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1665_instrctr, cycles_x1665_inr_Foreach.io.count, iters_x1665_inr_Foreach.io.count, 0.U, 0.U)
      val b1461 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1461.suggestName("b1461")
      val b1464 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1464.suggestName("b1464")
      val x1646_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1646_rd""")
      val x1646_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1646_rd_ofs = List[UInt](b1461.r)
      val x1646_rd_en = List[Bool](true.B)
      val x1646_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1464 & b561 ).suggestName("x1646_rd_shared_en")
      x1646_rd.toSeq.zip(x1469_tmp_4.connectRPort(1646, x1646_rd_banks, x1646_rd_ofs, io.sigsIn.backpressure, x1646_rd_en.map(_ && x1646_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1647 = VecApply(x1646,0)
      val x1647_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1647_elem_0""")
      x1647_elem_0.r := x1646_rd(0).r
      val x1648_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1648_rd""")
      val x1648_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1648_rd_ofs = List[UInt](b1461.r)
      val x1648_rd_en = List[Bool](true.B)
      val x1648_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1464 & b561 ).suggestName("x1648_rd_shared_en")
      x1648_rd.toSeq.zip(x1474_tmp_4.connectRPort(1648, x1648_rd_banks, x1648_rd_ofs, io.sigsIn.backpressure, x1648_rd_en.map(_ && x1648_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1649 = VecApply(x1648,0)
      val x1649_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1649_elem_0""")
      x1649_elem_0.r := x1648_rd(0).r
      val x3435 = Wire(Bool()).suggestName("x3435_b1464_D1") 
      x3435.r := getRetimed(b1464.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3436 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3436_b1461_D1") 
      x3436.r := getRetimed(b1461.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3437 = Wire(Bool()).suggestName("x3437_b561_D1") 
      x3437.r := getRetimed(b561.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1650_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1650_rd""")
      val x1650_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1650_rd_ofs = List[UInt](x3436.r)
      val x1650_rd_en = List[Bool](true.B)
      val x1650_rd_shared_en = ((io.sigsIn.forwardpressure).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(1.5.toInt, rr, io.sigsIn.backpressure & true.B) && x3435 & x3437 ).suggestName("x1650_rd_shared_en")
      x1650_rd.toSeq.zip(x575_accum_0.connectRPort(1650, x1650_rd_banks, x1650_rd_ofs, io.sigsIn.backpressure, x1650_rd_en.map(_ && x1650_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1651 = VecApply(x1650,0)
      val x1651_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1651_elem_0""")
      x1651_elem_0.r := x1650_rd(0).r
      val x1652 = Wire(Bool()).suggestName("""x1652""")
      x1652 := b1464 & b561
      val x1654 = Wire(Bool()).suggestName("""x1654""")
      x1654 := b1463 & b561
      val x1656 = Wire(Bool()).suggestName("""x1656""")
      x1656 := x1654 & x1652
      val x1657_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1657_sum""")
      x1657_sum.r := Math.add(x1647_elem_0,x1649_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1657_sum").r
      val x3438 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3438_x1647_elem_0_D1") 
      x3438.r := getRetimed(x1647_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3439 = Wire(Bool()).suggestName("x3439_x1656_D3") 
      x3439.r := getRetimed(x1656.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x1658 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1658""")
      x1658.r := Mux((x3439), x1657_sum.r, x3438.r)
      val x1660 = Wire(Bool()).suggestName("""x1660""")
      x1660.r := Math.eql(b1459, 0L.FP(true, 32, 0), Some(0.2), true.B,"x1660").r
      val x1661_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1661_sum""")
      x1661_sum.r := Math.add(x1658,x1651_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x1661_sum").r
      val x3440 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3440_x1658_D1") 
      x3440.r := getRetimed(x1658.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3441 = Wire(Bool()).suggestName("x3441_x1660_D4") 
      x3441.r := getRetimed(x1660.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x1662 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1662""")
      x1662.r := Mux((x3441), x3440.r, x1661_sum.r)
      val x3442 = Wire(Bool()).suggestName("x3442_b561_D5") 
      x3442.r := getRetimed(b561.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3443 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3443_b1461_D5") 
      x3443.r := getRetimed(b1461.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3444 = Wire(Bool()).suggestName("x3444_b1464_D5") 
      x3444.r := getRetimed(b1464.r, 5.toInt, io.sigsIn.backpressure & true.B)
      val x3445 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3445_x1662_D1") 
      x3445.r := getRetimed(x1662.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x1663_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1663_wr_ofs = List[UInt](x3443.r)
      val x1663_wr_en = List[Bool](true.B)
      val x1663_wr_data = List[UInt](x3445.r)
      x576_accum_1.connectWPort(1663, x1663_wr_banks, x1663_wr_ofs, x1663_wr_data, x1663_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3444 & x3442))
      val x1664_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1664_wr_ofs = List[UInt](x3443.r)
      val x1664_wr_en = List[Bool](true.B)
      val x1664_wr_data = List[UInt](x3445.r)
      x575_accum_0.connectWPort(1664, x1664_wr_banks, x1664_wr_ofs, x1664_wr_data, x1664_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(5.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3444 & x3442))
      x1469_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
      x1474_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 7)
    }
    val module = Module(new x1665_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1665_inr_Foreach **/
