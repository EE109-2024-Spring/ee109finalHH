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

/** Hierarchy: x1499 -> x1521 -> x1666 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1499_inr_Foreach **/
class x1499_inr_Foreach_kernel(
  list_b1462: List[Bool],
  list_b551: List[FixedPoint],
  list_x472_A_sram_1: List[StandardInterface],
  list_x1469_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1499_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1499_inr_Foreach_iiCtr"))
  
  abstract class x1499_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1469_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1469_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b1462 = Input(Bool())
      val in_x1465_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1465_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_b561 = Input(Bool())
      val in_b551 = Input(new FixedPoint(true, 32, 0))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1466_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1466_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1467_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1467_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1459 = Input(new FixedPoint(true, 32, 0))
      val in_x1468_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1468_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1469_tmp_4 = {io.in_x1469_tmp_4} ; io.in_x1469_tmp_4 := DontCare
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b1462 = {io.in_b1462} 
    def x1465_tmp_0 = {io.in_x1465_tmp_0} ; io.in_x1465_tmp_0 := DontCare
    def b561 = {io.in_b561} 
    def b551 = {io.in_b551} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1466_tmp_1 = {io.in_x1466_tmp_1} ; io.in_x1466_tmp_1 := DontCare
    def x1467_tmp_2 = {io.in_x1467_tmp_2} ; io.in_x1467_tmp_2 := DontCare
    def b1459 = {io.in_b1459} 
    def x1468_tmp_3 = {io.in_x1468_tmp_3} ; io.in_x1468_tmp_3 := DontCare
  }
  def connectWires0(module: x1499_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1469_tmp_4.connectLedger(module.io.in_x1469_tmp_4)
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b1462 <> b1462
    x1465_tmp_0.connectLedger(module.io.in_x1465_tmp_0)
    module.io.in_b561 <> b561
    module.io.in_b551 <> b551
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1466_tmp_1.connectLedger(module.io.in_x1466_tmp_1)
    x1467_tmp_2.connectLedger(module.io.in_x1467_tmp_2)
    module.io.in_b1459 <> b1459
    x1468_tmp_3.connectLedger(module.io.in_x1468_tmp_3)
  }
  val b1462 = list_b1462(0)
  val b561 = list_b1462(1)
  val b551 = list_b551(0)
  val b1459 = list_b551(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x1469_tmp_4 = list_x1469_tmp_4(0)
  val x1465_tmp_0 = list_x1469_tmp_4(1)
  val x1466_tmp_1 = list_x1469_tmp_4(2)
  val x1467_tmp_2 = list_x1469_tmp_4(3)
  val x1468_tmp_3 = list_x1469_tmp_4(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1499_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1499_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1499_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1499_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1499_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1499_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1499_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1499_instrctr, cycles_x1499_inr_Foreach.io.count, iters_x1499_inr_Foreach.io.count, 0.U, 0.U)
      val b1479 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1479.suggestName("b1479")
      val b1480 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1480.suggestName("b1480")
      val x1482_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1482_div""")
      x1482_div.r := (Math.div(b551, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x1482_div")).r
      val x3025 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3025""")
      x3025.r := Math.arith_left_shift(x1482_div, 1, Some(0.2), true.B,"x3025").r
      val x3026_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3026_sum""")
      x3026_sum.r := Math.add(x3025,x1482_div,Some(1.0), true.B, Truncate, Wrapping, "x3026_sum").r
      val x3385 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3385_b1479_D21") 
      x3385.r := getRetimed(b1479.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x1484_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1484_sum""")
      x1484_sum.r := Math.add(x3026_sum,x3385,Some(1.0), true.B, Truncate, Wrapping, "x1484_sum").r
      val x3386 = Wire(Bool()).suggestName("x3386_b1462_D22") 
      x3386.r := getRetimed(b1462.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3387 = Wire(Bool()).suggestName("x3387_b561_D22") 
      x3387.r := getRetimed(b561.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3388 = Wire(Bool()).suggestName("x3388_b1480_D22") 
      x3388.r := getRetimed(b1480.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x1485_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1485_rd""")
      val x1485_rd_banks = List[UInt](4L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x1485_rd_ofs = List[UInt](x1484_sum.r)
      val x1485_rd_en = List[Bool](true.B)
      val x1485_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3388 & x3386 & x3387 ).suggestName("x1485_rd_shared_en")
      x1485_rd.toSeq.zip(x471_A_sram_0.connectRPort(1485, x1485_rd_banks, x1485_rd_ofs, io.sigsIn.backpressure, x1485_rd_en.map(_ && x1485_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1486 = VecApply(x1485,0)
      val x1486_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1486_elem_0""")
      x1486_elem_0.r := x1485_rd(0).r
      val x1491_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1491_rd""")
      val x1491_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x1491_rd_ofs = List[UInt](0.U)
      val x1491_rd_en = List[Bool](true.B)
      val x1491_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1491_rd_shared_en")
      x1491_rd.toSeq.zip(x472_A_sram_1.connectRPort(1491, x1491_rd_banks, x1491_rd_ofs, io.sigsIn.backpressure, x1491_rd_en.map(_ && x1491_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1492 = VecApply(x1491,0)
      val x1492_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1492_elem_0""")
      x1492_elem_0.r := x1491_rd(0).r
      val x3393 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3393_x1492_elem_0_D20") 
      x3393.r := getRetimed(x1492_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1493_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1493_sub""")
      x1493_sub.r := Math.sub(x1486_elem_0,x3393,Some(1.0), true.B, Truncate, Wrapping, "x1493_sub").r
      val x3394 = Wire(Bool()).suggestName("x3394_b1462_D25") 
      x3394.r := getRetimed(b1462.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3395 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3395_b1479_D25") 
      x3395.r := getRetimed(b1479.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3396 = Wire(Bool()).suggestName("x3396_b561_D25") 
      x3396.r := getRetimed(b561.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3397 = Wire(Bool()).suggestName("x3397_b1480_D25") 
      x3397.r := getRetimed(b1480.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1494_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1494_wr_ofs = List[UInt](x3395.r)
      val x1494_wr_en = List[Bool](true.B)
      val x1494_wr_data = List[UInt](x1493_sub.r)
      x1469_tmp_4.connectWPort(1494, x1494_wr_banks, x1494_wr_ofs, x1494_wr_data, x1494_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3397 & x3394 & x3396))
      val x1495_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1495_wr_ofs = List[UInt](x3395.r)
      val x1495_wr_en = List[Bool](true.B)
      val x1495_wr_data = List[UInt](x1493_sub.r)
      x1465_tmp_0.connectWPort(1495, x1495_wr_banks, x1495_wr_ofs, x1495_wr_data, x1495_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3397 & x3394 & x3396))
      val x1496_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1496_wr_ofs = List[UInt](x3395.r)
      val x1496_wr_en = List[Bool](true.B)
      val x1496_wr_data = List[UInt](x1493_sub.r)
      x1466_tmp_1.connectWPort(1496, x1496_wr_banks, x1496_wr_ofs, x1496_wr_data, x1496_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3397 & x3394 & x3396))
      val x1497_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1497_wr_ofs = List[UInt](x3395.r)
      val x1497_wr_en = List[Bool](true.B)
      val x1497_wr_data = List[UInt](x1493_sub.r)
      x1467_tmp_2.connectWPort(1497, x1497_wr_banks, x1497_wr_ofs, x1497_wr_data, x1497_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3397 & x3394 & x3396))
      val x1498_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1498_wr_ofs = List[UInt](x3395.r)
      val x1498_wr_en = List[Bool](true.B)
      val x1498_wr_data = List[UInt](x1493_sub.r)
      x1468_tmp_3.connectWPort(1498, x1498_wr_banks, x1498_wr_ofs, x1498_wr_data, x1498_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3397 & x3394 & x3396))
    }
    val module = Module(new x1499_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1499_inr_Foreach **/
