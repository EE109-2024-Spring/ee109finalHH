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

/** Hierarchy: x1838 -> x1853 -> x1874 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1838_inr_Foreach **/
class x1838_inr_Foreach_kernel(
  list_b562: List[Bool],
  list_x1677_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x1838_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x1838_inr_Foreach_iiCtr"))
  
  abstract class x1838_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1677_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1677_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1676_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1676_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1759_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1759_force_0_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x1675_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1675_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1670 = Input(Bool())
      val in_x1674_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1674_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1673_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1673_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x1677_tmp_4 = {io.in_x1677_tmp_4} ; io.in_x1677_tmp_4 := DontCare
    def x1676_tmp_3 = {io.in_x1676_tmp_3} ; io.in_x1676_tmp_3 := DontCare
    def x1759_force_0 = {io.in_x1759_force_0} ; io.in_x1759_force_0 := DontCare
    def b562 = {io.in_b562} 
    def x1675_tmp_2 = {io.in_x1675_tmp_2} ; io.in_x1675_tmp_2 := DontCare
    def b1670 = {io.in_b1670} 
    def x1674_tmp_1 = {io.in_x1674_tmp_1} ; io.in_x1674_tmp_1 := DontCare
    def x1673_tmp_0 = {io.in_x1673_tmp_0} ; io.in_x1673_tmp_0 := DontCare
  }
  def connectWires0(module: x1838_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x1677_tmp_4.connectLedger(module.io.in_x1677_tmp_4)
    x1676_tmp_3.connectLedger(module.io.in_x1676_tmp_3)
    x1759_force_0.connectLedger(module.io.in_x1759_force_0)
    module.io.in_b562 <> b562
    x1675_tmp_2.connectLedger(module.io.in_x1675_tmp_2)
    module.io.in_b1670 <> b1670
    x1674_tmp_1.connectLedger(module.io.in_x1674_tmp_1)
    x1673_tmp_0.connectLedger(module.io.in_x1673_tmp_0)
  }
  val b562 = list_b562(0)
  val b1670 = list_b562(1)
  val x1677_tmp_4 = list_x1677_tmp_4(0)
  val x1676_tmp_3 = list_x1677_tmp_4(1)
  val x1759_force_0 = list_x1677_tmp_4(2)
  val x1675_tmp_2 = list_x1677_tmp_4(3)
  val x1674_tmp_1 = list_x1677_tmp_4(4)
  val x1673_tmp_0 = list_x1677_tmp_4(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1838_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1838_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1838_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1838_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1838_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1838_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1838_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1838_instrctr, cycles_x1838_inr_Foreach.io.count, iters_x1838_inr_Foreach.io.count, 0.U, 0.U)
      val b1825 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1825.suggestName("b1825")
      val b1826 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1826.suggestName("b1826")
      val x1827_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1827_rd""")
      val x1827_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1827_rd_ofs = List[UInt](b1825.r)
      val x1827_rd_en = List[Bool](true.B)
      val x1827_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1826 & b1670 & b562 ).suggestName("x1827_rd_shared_en")
      x1827_rd.toSeq.zip(x1676_tmp_3.connectRPort(1827, x1827_rd_banks, x1827_rd_ofs, io.sigsIn.backpressure, x1827_rd_en.map(_ && x1827_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1828 = VecApply(x1827,0)
      val x1828_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1828_elem_0""")
      x1828_elem_0.r := x1827_rd(0).r
      val x1829_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1829_mul""")
      x1829_mul.r := (Math.mul(x1828_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x1829_mul")).r
      val x1830_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1830_rd""")
      val x1830_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1830_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1830_rd_en = List[Bool](true.B)
      val x1830_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b1826 & b1670 & b562 ).suggestName("x1830_rd_shared_en")
      x1830_rd.toSeq.zip(x1759_force_0.connectRPort(1830, x1830_rd_banks, x1830_rd_ofs, io.sigsIn.backpressure, x1830_rd_en.map(_ && x1830_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1831 = VecApply(x1830,0)
      val x1831_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1831_elem_0""")
      x1831_elem_0.r := x1830_rd(0).r
      val x3486 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3486_x1831_elem_0_D6") 
      x3486.r := getRetimed(x1831_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x1832_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1832_mul""")
      x1832_mul.r := (Math.mul(x1829_mul, x3486, Some(6.0), true.B, Truncate, Wrapping, "x1832_mul")).r
      val x3487 = Wire(Bool()).suggestName("x3487_b1826_D14") 
      x3487.r := getRetimed(b1826.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3488 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3488_b1825_D14") 
      x3488.r := getRetimed(b1825.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3489 = Wire(Bool()).suggestName("x3489_b562_D14") 
      x3489.r := getRetimed(b562.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3490 = Wire(Bool()).suggestName("x3490_b1670_D14") 
      x3490.r := getRetimed(b1670.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x1833_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1833_wr_ofs = List[UInt](x3488.r)
      val x1833_wr_en = List[Bool](true.B)
      val x1833_wr_data = List[UInt](x1832_mul.r)
      x1677_tmp_4.connectWPort(1833, x1833_wr_banks, x1833_wr_ofs, x1833_wr_data, x1833_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3487 & x3490 & x3489))
      val x1834_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1834_wr_ofs = List[UInt](x3488.r)
      val x1834_wr_en = List[Bool](true.B)
      val x1834_wr_data = List[UInt](x1832_mul.r)
      x1676_tmp_3.connectWPort(1834, x1834_wr_banks, x1834_wr_ofs, x1834_wr_data, x1834_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3487 & x3490 & x3489))
      val x1835_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1835_wr_ofs = List[UInt](x3488.r)
      val x1835_wr_en = List[Bool](true.B)
      val x1835_wr_data = List[UInt](x1832_mul.r)
      x1675_tmp_2.connectWPort(1835, x1835_wr_banks, x1835_wr_ofs, x1835_wr_data, x1835_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3487 & x3490 & x3489))
      val x1836_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1836_wr_ofs = List[UInt](x3488.r)
      val x1836_wr_en = List[Bool](true.B)
      val x1836_wr_data = List[UInt](x1832_mul.r)
      x1674_tmp_1.connectWPort(1836, x1836_wr_banks, x1836_wr_ofs, x1836_wr_data, x1836_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3487 & x3490 & x3489))
      val x1837_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1837_wr_ofs = List[UInt](x3488.r)
      val x1837_wr_en = List[Bool](true.B)
      val x1837_wr_data = List[UInt](x1832_mul.r)
      x1673_tmp_0.connectWPort(1837, x1837_wr_banks, x1837_wr_ofs, x1837_wr_data, x1837_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3487 & x3490 & x3489))
    }
    val module = Module(new x1838_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1838_inr_Foreach **/
