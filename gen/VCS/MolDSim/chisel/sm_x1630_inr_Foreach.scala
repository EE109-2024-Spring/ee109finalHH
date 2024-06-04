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

/** Hierarchy: x1630 -> x1645 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1630_inr_Foreach **/
class x1630_inr_Foreach_kernel(
  list_b1462: List[Bool],
  list_x1469_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1630_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1630_inr_Foreach_iiCtr"))
  
  abstract class x1630_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1469_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1469_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1462 = Input(Bool())
      val in_x1465_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1465_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_x1466_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1466_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1467_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1467_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1551_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1551_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1468_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1468_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1469_tmp_4 = {io.in_x1469_tmp_4} ; io.in_x1469_tmp_4 := DontCare
    def b1462 = {io.in_b1462} 
    def x1465_tmp_0 = {io.in_x1465_tmp_0} ; io.in_x1465_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def x1466_tmp_1 = {io.in_x1466_tmp_1} ; io.in_x1466_tmp_1 := DontCare
    def x1467_tmp_2 = {io.in_x1467_tmp_2} ; io.in_x1467_tmp_2 := DontCare
    def x1551_force_0 = {io.in_x1551_force_0} ; io.in_x1551_force_0 := DontCare
    def x1468_tmp_3 = {io.in_x1468_tmp_3} ; io.in_x1468_tmp_3 := DontCare
  }
  def connectWires0(module: x1630_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1469_tmp_4.connectLedger(module.io.in_x1469_tmp_4)
    module.io.in_b1462 <> b1462
    x1465_tmp_0.connectLedger(module.io.in_x1465_tmp_0)
    module.io.in_b561 <> b561
    x1466_tmp_1.connectLedger(module.io.in_x1466_tmp_1)
    x1467_tmp_2.connectLedger(module.io.in_x1467_tmp_2)
    x1551_force_0.connectLedger(module.io.in_x1551_force_0)
    x1468_tmp_3.connectLedger(module.io.in_x1468_tmp_3)
  }
  val b1462 = list_b1462(0)
  val b561 = list_b1462(1)
  val x1469_tmp_4 = list_x1469_tmp_4(0)
  val x1465_tmp_0 = list_x1469_tmp_4(1)
  val x1466_tmp_1 = list_x1469_tmp_4(2)
  val x1467_tmp_2 = list_x1469_tmp_4(3)
  val x1551_force_0 = list_x1469_tmp_4(4)
  val x1468_tmp_3 = list_x1469_tmp_4(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1630_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1630_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1630_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1630_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1630_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1630_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1630_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1630_instrctr, cycles_x1630_inr_Foreach.io.count, iters_x1630_inr_Foreach.io.count, 0.U, 0.U)
      val b1617 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1617.suggestName("b1617")
      val b1618 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1618.suggestName("b1618")
      val x1619_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1619_rd""")
      val x1619_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1619_rd_ofs = List[UInt](b1617.r)
      val x1619_rd_en = List[Bool](true.B)
      val x1619_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1618 & b1462 & b561 ).suggestName("x1619_rd_shared_en")
      x1619_rd.toSeq.zip(x1468_tmp_3.connectRPort(1619, x1619_rd_banks, x1619_rd_ofs, io.sigsIn.backpressure, x1619_rd_en.map(_ && x1619_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1620 = VecApply(x1619,0)
      val x1620_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1620_elem_0""")
      x1620_elem_0.r := x1619_rd(0).r
      val x1621_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1621_mul""")
      x1621_mul.r := (Math.mul(x1620_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1621_mul")).r
      val x1622_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1622_rd""")
      val x1622_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1622_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1622_rd_en = List[Bool](true.B)
      val x1622_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1618 & b1462 & b561 ).suggestName("x1622_rd_shared_en")
      x1622_rd.toSeq.zip(x1551_force_0.connectRPort(1622, x1622_rd_banks, x1622_rd_ofs, io.sigsIn.backpressure, x1622_rd_en.map(_ && x1622_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1623 = VecApply(x1622,0)
      val x1623_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1623_elem_0""")
      x1623_elem_0.r := x1622_rd(0).r
      val x3425 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3425_x1623_elem_0_D6") 
      x3425.r := getRetimed(x1623_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1624_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1624_mul""")
      x1624_mul.r := (Math.mul(x1621_mul, x3425, Some(6.0), true.B, Truncate, Wrapping, "x1624_mul")).r
      val x3426 = Wire(Bool()).suggestName("x3426_b1618_D14") 
      x3426.r := getRetimed(b1618.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3427 = Wire(Bool()).suggestName("x3427_b1462_D14") 
      x3427.r := getRetimed(b1462.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3428 = Wire(Bool()).suggestName("x3428_b561_D14") 
      x3428.r := getRetimed(b561.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3429 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3429_b1617_D14") 
      x3429.r := getRetimed(b1617.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1625_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1625_wr_ofs = List[UInt](x3429.r)
      val x1625_wr_en = List[Bool](true.B)
      val x1625_wr_data = List[UInt](x1624_mul.r)
      x1469_tmp_4.connectWPort(1625, x1625_wr_banks, x1625_wr_ofs, x1625_wr_data, x1625_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3426 & x3427 & x3428))
      val x1626_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1626_wr_ofs = List[UInt](x3429.r)
      val x1626_wr_en = List[Bool](true.B)
      val x1626_wr_data = List[UInt](x1624_mul.r)
      x1465_tmp_0.connectWPort(1626, x1626_wr_banks, x1626_wr_ofs, x1626_wr_data, x1626_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3426 & x3427 & x3428))
      val x1627_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1627_wr_ofs = List[UInt](x3429.r)
      val x1627_wr_en = List[Bool](true.B)
      val x1627_wr_data = List[UInt](x1624_mul.r)
      x1466_tmp_1.connectWPort(1627, x1627_wr_banks, x1627_wr_ofs, x1627_wr_data, x1627_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3426 & x3427 & x3428))
      val x1628_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1628_wr_ofs = List[UInt](x3429.r)
      val x1628_wr_en = List[Bool](true.B)
      val x1628_wr_data = List[UInt](x1624_mul.r)
      x1467_tmp_2.connectWPort(1628, x1628_wr_banks, x1628_wr_ofs, x1628_wr_data, x1628_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3426 & x3427 & x3428))
      val x1629_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1629_wr_ofs = List[UInt](x3429.r)
      val x1629_wr_en = List[Bool](true.B)
      val x1629_wr_data = List[UInt](x1624_mul.r)
      x1468_tmp_3.connectWPort(1629, x1629_wr_banks, x1629_wr_ofs, x1629_wr_data, x1629_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3426 & x3427 & x3428))
    }
    val module = Module(new x1630_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1630_inr_Foreach **/
