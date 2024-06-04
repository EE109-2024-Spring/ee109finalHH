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

/** Hierarchy: x652 -> x653 -> x668 -> x444 **/
/** BEGIN None x652_inr_Foreach **/
class x652_inr_Foreach_kernel(
  list_b543: List[Bool],
  list_b550: List[FixedPoint],
  list_x544_accum_0: List[StandardInterface],
  list_x558_tmp_4: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 4.5.toInt, myName = "x652_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x652_inr_Foreach_iiCtr"))
  
  abstract class x652_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x558_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x558_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x545_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x545_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x544_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_accum_0_p").asInstanceOf[MemParams] ))
      val in_b543 = Input(Bool())
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def b550 = {io.in_b550} 
    def x558_tmp_4 = {io.in_x558_tmp_4} ; io.in_x558_tmp_4 := DontCare
    def x545_accum_1 = {io.in_x545_accum_1} ; io.in_x545_accum_1 := DontCare
    def x544_accum_0 = {io.in_x544_accum_0} ; io.in_x544_accum_0 := DontCare
    def b543 = {io.in_b543} 
  }
  def connectWires0(module: x652_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b550 <> b550
    x558_tmp_4.connectLedger(module.io.in_x558_tmp_4)
    x545_accum_1.connectLedger(module.io.in_x545_accum_1)
    x544_accum_0.connectLedger(module.io.in_x544_accum_0)
    module.io.in_b543 <> b543
  }
  val b543 = list_b543(0)
  val b550 = list_b550(0)
  val x544_accum_0 = list_x544_accum_0(0)
  val x558_tmp_4 = list_x558_tmp_4(0)
  val x545_accum_1 = list_x558_tmp_4(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x652_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x652_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x652_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b551 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b551.suggestName("b551")
      val b553 = ~io.sigsIn.cchainOutputs.head.oobs(0); b553.suggestName("b553")
      val x640_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x640_rd""")
      val x640_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x640_rd_ofs = List[UInt](b551.r)
      val x640_rd_en = List[Bool](true.B)
      val x640_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b553 & b543 ).suggestName("x640_rd_shared_en")
      x640_rd.toSeq.zip(x558_tmp_4.connectRPort(640, x640_rd_banks, x640_rd_ofs, io.sigsIn.backpressure, x640_rd_en.map(_ && x640_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x641 = VecApply(x640,0)
      val x641_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x641_elem_0""")
      x641_elem_0.r := x640_rd(0).r
      val x642_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x642_rd""")
      val x642_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x642_rd_ofs = List[UInt](b551.r)
      val x642_rd_en = List[Bool](true.B)
      val x642_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && b553 & b543 ).suggestName("x642_rd_shared_en")
      x642_rd.toSeq.zip(x544_accum_0.connectRPort(642, x642_rd_banks, x642_rd_ofs, io.sigsIn.backpressure, x642_rd_en.map(_ && x642_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x643 = VecApply(x642,0)
      val x643_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x643_elem_0""")
      x643_elem_0.r := x642_rd(0).r
      val x647 = Wire(Bool()).suggestName("""x647""")
      x647.r := Math.eql(b550, 0L.FP(true, 32, 0), Some(0.2), true.B,"x647").r
      val x648_sum = Wire(new FixedPoint(true, 10, 22)).suggestName("""x648_sum""")
      x648_sum.r := Math.add(x641_elem_0,x643_elem_0,Some(1.0), true.B, Truncate, Wrapping, "x648_sum").r
      val x789 = Wire(new FixedPoint(true, 10, 22)).suggestName("x789_x641_elem_0_D1") 
      x789.r := getRetimed(x641_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x790 = Wire(Bool()).suggestName("x790_x647_D3") 
      x790.r := getRetimed(x647.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x649 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x649""")
      x649.r := Mux((x790), x789.r, x648_sum.r)
      val x791 = Wire(Bool()).suggestName("x791_b543_D3") 
      x791.r := getRetimed(b543.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x792 = Wire(Bool()).suggestName("x792_b553_D3") 
      x792.r := getRetimed(b553.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x793 = Wire(new FixedPoint(true, 32, 0)).suggestName("x793_b551_D3") 
      x793.r := getRetimed(b551.r, 3.toInt, io.sigsIn.backpressure & true.B)
      val x650_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x650_wr_ofs = List[UInt](x793.r)
      val x650_wr_en = List[Bool](true.B)
      val x650_wr_data = List[UInt](x649.r)
      x545_accum_1.connectWPort(650, x650_wr_banks, x650_wr_ofs, x650_wr_data, x650_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(3.5.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x792 & x791))
      val x651_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x651_wr_ofs = List[UInt](x793.r)
      val x651_wr_en = List[Bool](true.B)
      val x651_wr_data = List[UInt](x649.r)
      x544_accum_0.connectWPort(651, x651_wr_banks, x651_wr_ofs, x651_wr_data, x651_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(3.5.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x792 & x791))
      x558_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
    }
    val module = Module(new x652_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x652_inr_Foreach **/
