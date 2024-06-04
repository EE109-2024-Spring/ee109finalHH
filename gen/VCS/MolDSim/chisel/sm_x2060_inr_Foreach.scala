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

/** Hierarchy: x2060 -> x2061 -> x2082 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x2060_inr_Foreach **/
class x2060_inr_Foreach_kernel(
  list_b1879: List[Bool],
  list_x1887_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 15.0.toInt, myName = "x2060_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(15.0.toInt, 2 + _root_.utils.math.log2Up(15.0.toInt), "x2060_inr_Foreach_iiCtr"))
  
  abstract class x2060_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b1879 = Input(Bool())
      val in_x1887_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1887_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1890_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1890_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1886_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1886_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1968_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1968_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1888_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1888_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1889_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1889_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b563 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b1879 = {io.in_b1879} 
    def x1887_tmp_1 = {io.in_x1887_tmp_1} ; io.in_x1887_tmp_1 := DontCare
    def x1890_tmp_4 = {io.in_x1890_tmp_4} ; io.in_x1890_tmp_4 := DontCare
    def x1886_tmp_0 = {io.in_x1886_tmp_0} ; io.in_x1886_tmp_0 := DontCare
    def x1968_force_0 = {io.in_x1968_force_0} ; io.in_x1968_force_0 := DontCare
    def x1888_tmp_2 = {io.in_x1888_tmp_2} ; io.in_x1888_tmp_2 := DontCare
    def x1889_tmp_3 = {io.in_x1889_tmp_3} ; io.in_x1889_tmp_3 := DontCare
    def b563 = {io.in_b563} 
  }
  def connectWires0(module: x2060_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b1879 <> b1879
    x1887_tmp_1.connectLedger(module.io.in_x1887_tmp_1)
    x1890_tmp_4.connectLedger(module.io.in_x1890_tmp_4)
    x1886_tmp_0.connectLedger(module.io.in_x1886_tmp_0)
    x1968_force_0.connectLedger(module.io.in_x1968_force_0)
    x1888_tmp_2.connectLedger(module.io.in_x1888_tmp_2)
    x1889_tmp_3.connectLedger(module.io.in_x1889_tmp_3)
    module.io.in_b563 <> b563
  }
  val b1879 = list_b1879(0)
  val b563 = list_b1879(1)
  val x1887_tmp_1 = list_x1887_tmp_1(0)
  val x1890_tmp_4 = list_x1887_tmp_1(1)
  val x1886_tmp_0 = list_x1887_tmp_1(2)
  val x1968_force_0 = list_x1887_tmp_1(3)
  val x1888_tmp_2 = list_x1887_tmp_1(4)
  val x1889_tmp_3 = list_x1887_tmp_1(5)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2060_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x2060_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2060_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2060_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x2060_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x2060_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x2060_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2060_instrctr, cycles_x2060_inr_Foreach.io.count, iters_x2060_inr_Foreach.io.count, 0.U, 0.U)
      val b2047 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b2047.suggestName("b2047")
      val b2048 = ~io.sigsIn.cchainOutputs.head.oobs(0); b2048.suggestName("b2048")
      val x2049_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2049_rd""")
      val x2049_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2049_rd_ofs = List[UInt](b2047.r)
      val x2049_rd_en = List[Bool](true.B)
      val x2049_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2048 & b1879 & b563 ).suggestName("x2049_rd_shared_en")
      x2049_rd.toSeq.zip(x1889_tmp_3.connectRPort(2049, x2049_rd_banks, x2049_rd_ofs, io.sigsIn.backpressure, x2049_rd_en.map(_ && x2049_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2050 = VecApply(x2049,0)
      val x2050_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2050_elem_0""")
      x2050_elem_0.r := x2049_rd(0).r
      val x2051_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2051_mul""")
      x2051_mul.r := (Math.mul(x2050_elem_0, 0.099999904632568359375.FP(true, 10, 22), Some(6.0), true.B, Truncate, Wrapping, "x2051_mul")).r
      val x2052_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x2052_rd""")
      val x2052_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2052_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x2052_rd_en = List[Bool](true.B)
      val x2052_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b2048 & b1879 & b563 ).suggestName("x2052_rd_shared_en")
      x2052_rd.toSeq.zip(x1968_force_0.connectRPort(2052, x2052_rd_banks, x2052_rd_ofs, io.sigsIn.backpressure, x2052_rd_en.map(_ && x2052_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x2053 = VecApply(x2052,0)
      val x2053_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2053_elem_0""")
      x2053_elem_0.r := x2052_rd(0).r
      val x3552 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3552_x2053_elem_0_D6") 
      x3552.r := getRetimed(x2053_elem_0.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x2054_mul = Wire(new FixedPoint(true, 10, 22)).suggestName("""x2054_mul""")
      x2054_mul.r := (Math.mul(x2051_mul, x3552, Some(6.0), true.B, Truncate, Wrapping, "x2054_mul")).r
      val x3553 = Wire(Bool()).suggestName("x3553_b1879_D14") 
      x3553.r := getRetimed(b1879.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3554 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3554_b2047_D14") 
      x3554.r := getRetimed(b2047.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3555 = Wire(Bool()).suggestName("x3555_b2048_D14") 
      x3555.r := getRetimed(b2048.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x3556 = Wire(Bool()).suggestName("x3556_b563_D14") 
      x3556.r := getRetimed(b563.r, 14.toInt, io.sigsIn.backpressure & true.B)
      val x2055_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2055_wr_ofs = List[UInt](x3554.r)
      val x2055_wr_en = List[Bool](true.B)
      val x2055_wr_data = List[UInt](x2054_mul.r)
      x1887_tmp_1.connectWPort(2055, x2055_wr_banks, x2055_wr_ofs, x2055_wr_data, x2055_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3555 & x3553 & x3556))
      val x2056_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2056_wr_ofs = List[UInt](x3554.r)
      val x2056_wr_en = List[Bool](true.B)
      val x2056_wr_data = List[UInt](x2054_mul.r)
      x1890_tmp_4.connectWPort(2056, x2056_wr_banks, x2056_wr_ofs, x2056_wr_data, x2056_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3555 & x3553 & x3556))
      val x2057_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2057_wr_ofs = List[UInt](x3554.r)
      val x2057_wr_en = List[Bool](true.B)
      val x2057_wr_data = List[UInt](x2054_mul.r)
      x1886_tmp_0.connectWPort(2057, x2057_wr_banks, x2057_wr_ofs, x2057_wr_data, x2057_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3555 & x3553 & x3556))
      val x2058_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2058_wr_ofs = List[UInt](x3554.r)
      val x2058_wr_en = List[Bool](true.B)
      val x2058_wr_data = List[UInt](x2054_mul.r)
      x1888_tmp_2.connectWPort(2058, x2058_wr_banks, x2058_wr_ofs, x2058_wr_data, x2058_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3555 & x3553 & x3556))
      val x2059_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x2059_wr_ofs = List[UInt](x3554.r)
      val x2059_wr_en = List[Bool](true.B)
      val x2059_wr_data = List[UInt](x2054_mul.r)
      x1889_tmp_3.connectWPort(2059, x2059_wr_banks, x2059_wr_ofs, x2059_wr_data, x2059_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(14.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3555 & x3553 & x3556))
    }
    val module = Module(new x2060_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x2060_inr_Foreach **/
