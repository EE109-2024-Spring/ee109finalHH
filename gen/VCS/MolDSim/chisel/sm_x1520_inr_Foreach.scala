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

/** Hierarchy: x1520 -> x1521 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1520_inr_Foreach **/
class x1520_inr_Foreach_kernel(
  list_b561: List[Bool],
  list_b551: List[FixedPoint],
  list_x1470_tmp_0: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1520_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1520_inr_Foreach_iiCtr"))
  
  abstract class x1520_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1470_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1470_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_b551 = Input(new FixedPoint(true, 32, 0))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1471_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1471_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b1460 = Input(new FixedPoint(true, 32, 0))
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
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1470_tmp_0 = {io.in_x1470_tmp_0} ; io.in_x1470_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def b551 = {io.in_b551} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1471_tmp_1 = {io.in_x1471_tmp_1} ; io.in_x1471_tmp_1 := DontCare
    def b1460 = {io.in_b1460} 
    def x1474_tmp_4 = {io.in_x1474_tmp_4} ; io.in_x1474_tmp_4 := DontCare
    def x1472_tmp_2 = {io.in_x1472_tmp_2} ; io.in_x1472_tmp_2 := DontCare
    def x1473_tmp_3 = {io.in_x1473_tmp_3} ; io.in_x1473_tmp_3 := DontCare
    def b1463 = {io.in_b1463} 
  }
  def connectWires0(module: x1520_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1470_tmp_0.connectLedger(module.io.in_x1470_tmp_0)
    module.io.in_b561 <> b561
    module.io.in_b551 <> b551
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1471_tmp_1.connectLedger(module.io.in_x1471_tmp_1)
    module.io.in_b1460 <> b1460
    x1474_tmp_4.connectLedger(module.io.in_x1474_tmp_4)
    x1472_tmp_2.connectLedger(module.io.in_x1472_tmp_2)
    x1473_tmp_3.connectLedger(module.io.in_x1473_tmp_3)
    module.io.in_b1463 <> b1463
  }
  val b561 = list_b561(0)
  val b1463 = list_b561(1)
  val b551 = list_b551(0)
  val b1460 = list_b551(1)
  val x1470_tmp_0 = list_x1470_tmp_0(0)
  val x1471_tmp_1 = list_x1470_tmp_0(1)
  val x1474_tmp_4 = list_x1470_tmp_0(2)
  val x1472_tmp_2 = list_x1470_tmp_0(3)
  val x1473_tmp_3 = list_x1470_tmp_0(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1520_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1520_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1520_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1520_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1520_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1520_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1520_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1520_instrctr, cycles_x1520_inr_Foreach.io.count, iters_x1520_inr_Foreach.io.count, 0.U, 0.U)
      val b1500 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1500.suggestName("b1500")
      val b1501 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1501.suggestName("b1501")
      val x1506_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1506_rd""")
      val x1506_rd_banks = List[UInt](0.U,0.U)
      val x1506_rd_ofs = List[UInt](0.U)
      val x1506_rd_en = List[Bool](true.B)
      val x1506_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1506_rd_shared_en")
      x1506_rd.toSeq.zip(x471_A_sram_0.connectRPort(1506, x1506_rd_banks, x1506_rd_ofs, io.sigsIn.backpressure, x1506_rd_en.map(_ && x1506_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1507 = VecApply(x1506,0)
      val x1507_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1507_elem_0""")
      x1507_elem_0.r := x1506_rd(0).r
      val x1512_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1512_rd""")
      val x1512_rd_banks = List[UInt](0.U,0.U)
      val x1512_rd_ofs = List[UInt](0.U)
      val x1512_rd_en = List[Bool](true.B)
      val x1512_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1512_rd_shared_en")
      x1512_rd.toSeq.zip(x472_A_sram_1.connectRPort(1512, x1512_rd_banks, x1512_rd_ofs, io.sigsIn.backpressure, x1512_rd_en.map(_ && x1512_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1513 = VecApply(x1512,0)
      val x1513_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1513_elem_0""")
      x1513_elem_0.r := x1512_rd(0).r
      val x3406 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3406_x1513_elem_0_D20") 
      x3406.r := getRetimed(x1513_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1514_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1514_sub""")
      x1514_sub.r := Math.sub(x1507_elem_0,x3406,Some(1.0), true.B, Truncate, Wrapping, "x1514_sub").r
      val x3407 = Wire(Bool()).suggestName("x3407_b1501_D25") 
      x3407.r := getRetimed(b1501.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3408 = Wire(Bool()).suggestName("x3408_b561_D25") 
      x3408.r := getRetimed(b561.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3409 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3409_b1500_D25") 
      x3409.r := getRetimed(b1500.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3410 = Wire(Bool()).suggestName("x3410_b1463_D25") 
      x3410.r := getRetimed(b1463.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1515_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1515_wr_ofs = List[UInt](x3409.r)
      val x1515_wr_en = List[Bool](true.B)
      val x1515_wr_data = List[UInt](x1514_sub.r)
      x1470_tmp_0.connectWPort(1515, x1515_wr_banks, x1515_wr_ofs, x1515_wr_data, x1515_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3407 & x3410 & x3408))
      val x1516_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1516_wr_ofs = List[UInt](x3409.r)
      val x1516_wr_en = List[Bool](true.B)
      val x1516_wr_data = List[UInt](x1514_sub.r)
      x1471_tmp_1.connectWPort(1516, x1516_wr_banks, x1516_wr_ofs, x1516_wr_data, x1516_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3407 & x3410 & x3408))
      val x1517_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1517_wr_ofs = List[UInt](x3409.r)
      val x1517_wr_en = List[Bool](true.B)
      val x1517_wr_data = List[UInt](x1514_sub.r)
      x1474_tmp_4.connectWPort(1517, x1517_wr_banks, x1517_wr_ofs, x1517_wr_data, x1517_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3407 & x3410 & x3408))
      val x1518_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1518_wr_ofs = List[UInt](x3409.r)
      val x1518_wr_en = List[Bool](true.B)
      val x1518_wr_data = List[UInt](x1514_sub.r)
      x1472_tmp_2.connectWPort(1518, x1518_wr_banks, x1518_wr_ofs, x1518_wr_data, x1518_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3407 & x3410 & x3408))
      val x1519_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1519_wr_ofs = List[UInt](x3409.r)
      val x1519_wr_en = List[Bool](true.B)
      val x1519_wr_data = List[UInt](x1514_sub.r)
      x1473_tmp_3.connectWPort(1519, x1519_wr_banks, x1519_wr_ofs, x1519_wr_data, x1519_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3407 & x3410 & x3408))
    }
    val module = Module(new x1520_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1520_inr_Foreach **/
