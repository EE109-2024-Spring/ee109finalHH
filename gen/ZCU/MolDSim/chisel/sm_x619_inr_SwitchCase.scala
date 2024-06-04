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

/** Hierarchy: x619 -> x621 -> x653 -> x668 -> x444 **/
/** BEGIN None x619_inr_SwitchCase **/
class x619_inr_SwitchCase_kernel(
  list_x580_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x619_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x619_inr_SwitchCase_iiCtr"))
  
  abstract class x619_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x580_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x580_r_0_p").asInstanceOf[NBufParams] ))
      val in_x595_reg = Flipped(new NBufInterface(ModuleParams.getParams("x595_reg_p").asInstanceOf[NBufParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x580_r_0 = {io.in_x580_r_0} ; io.in_x580_r_0 := DontCare
    def x595_reg = {io.in_x595_reg} ; io.in_x595_reg := DontCare
  }
  def connectWires0(module: x619_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x580_r_0.connectLedger(module.io.in_x580_r_0)
    x595_reg.connectLedger(module.io.in_x595_reg)
  }
  val x580_r_0 = list_x580_r_0(0)
  val x595_reg = list_x580_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x619_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x619_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x619_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      // Controller Stack: Stack(x621, x653, x668, x444)
      val x608_rd_x595 = Wire(Bool()).suggestName("""x608_rd_x595""")
      val x608_rd_x595_banks = List[UInt]()
      val x608_rd_x595_ofs = List[UInt]()
      val x608_rd_x595_en = List[Bool](true.B)
      val x608_rd_x595_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x608_rd_x595_shared_en")
      x608_rd_x595.toSeq.zip(x595_reg.connectRPort(608, x608_rd_x595_banks, x608_rd_x595_ofs, io.sigsIn.backpressure, x608_rd_x595_en.map(_ && x608_rd_x595_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x609_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x609_rd""")
      val x609_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x609_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x609_rd_en = List[Bool](true.B)
      val x609_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x608_rd_x595 ).suggestName("x609_rd_shared_en")
      x609_rd.toSeq.zip(x580_r_0.connectRPort(609, x609_rd_banks, x609_rd_ofs, io.sigsIn.backpressure, x609_rd_en.map(_ && x609_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x610 = VecApply(x609,0)
      val x610_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x610_elem_0""")
      x610_elem_0.r := x609_rd(0).r
      val x611_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x611_div""")
      x611_div.r := (Math.div(100.FP(true, 10, 22), x610_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x611_div")).r
      val x779 = Wire(new FixedPoint(true, 10, 22)).suggestName("x779_x610_elem_0_D20") 
      x779.r := getRetimed(x610_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x612_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x612_div""")
      x612_div.r := (Math.div(x611_div, x779, Some(20.0), true.B, Truncate, Wrapping, "x612_div")).r
      val x780 = Wire(new FixedPoint(true, 10, 22)).suggestName("x780_x610_elem_0_D40") 
      x780.r := getRetimed(x610_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x613_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x613_div""")
      x613_div.r := (Math.div(x612_div, x780, Some(20.0), true.B, Truncate, Wrapping, "x613_div")).r
      val x781 = Wire(new FixedPoint(true, 10, 22)).suggestName("x781_x610_elem_0_D60") 
      x781.r := getRetimed(x610_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x614_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x614_div""")
      x614_div.r := (Math.div(x613_div, x781, Some(20.0), true.B, Truncate, Wrapping, "x614_div")).r
      val x782 = Wire(new FixedPoint(true, 10, 22)).suggestName("x782_x610_elem_0_D80") 
      x782.r := getRetimed(x610_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x615_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x615_div""")
      x615_div.r := (Math.div(x614_div, x782, Some(20.0), true.B, Truncate, Wrapping, "x615_div")).r
      val x616_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x616_div""")
      x616_div.r := (Math.div(10.FP(true, 10, 22), x610_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x616_div")).r
      val x617_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x617_div""")
      x617_div.r := (Math.div(x616_div, x779, Some(20.0), true.B, Truncate, Wrapping, "x617_div")).r
      val x783 = Wire(new FixedPoint(true, 10, 22)).suggestName("x783_x617_div_D60") 
      x783.r := getRetimed(x617_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x618_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x618_sub""")
      x618_sub.r := Math.sub(x615_div,x783,Some(1.0), true.B, Truncate, Wrapping, "x618_sub").r
      io.ret.r := x618_sub.r
    }
    val module = Module(new x619_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    val ret = module.io.ret
    Ledger.exit()
    ret
  }
}
/** END SwitchCase x619_inr_SwitchCase **/
