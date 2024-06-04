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

/** Hierarchy: x698 -> x718 -> x723 -> x724 -> x444 **/
/** BEGIN None x698_inr_UnitPipe **/
class x698_inr_UnitPipe_kernel(
  list_b674: List[FixedPoint],
  list_x669: List[DecoupledIO[AppCommandDense]],
  list_x677_reg: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 5.0.toInt, myName = "x698_inr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x698_inr_UnitPipe_iiCtr"))
  
  abstract class x698_inr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x677_reg = Flipped(new StandardInterface(ModuleParams.getParams("x677_reg_p").asInstanceOf[MemParams] ))
      val in_x678_reg = Flipped(new StandardInterface(ModuleParams.getParams("x678_reg_p").asInstanceOf[MemParams] ))
      val in_x669 = Decoupled(new AppCommandDense(ModuleParams.getParams("x669_p").asInstanceOf[(Int,Int)] ))
      val in_b674 = Input(new FixedPoint(true, 32, 0))
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x676_reg = Flipped(new StandardInterface(ModuleParams.getParams("x676_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x677_reg = {io.in_x677_reg} ; io.in_x677_reg := DontCare
    def x678_reg = {io.in_x678_reg} ; io.in_x678_reg := DontCare
    def x669 = {io.in_x669} 
    def b674 = {io.in_b674} 
    def x470_out_host = {io.in_x470_out_host} 
    def x676_reg = {io.in_x676_reg} ; io.in_x676_reg := DontCare
  }
  def connectWires0(module: x698_inr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    x677_reg.connectLedger(module.io.in_x677_reg)
    x678_reg.connectLedger(module.io.in_x678_reg)
    module.io.in_x669 <> x669
    module.io.in_b674 <> b674
    module.io.in_x470_out_host <> x470_out_host
    x676_reg.connectLedger(module.io.in_x676_reg)
  }
  val b674 = list_b674(0)
  val x470_out_host = list_b674(1)
  val x669 = list_x669(0)
  val x677_reg = list_x677_reg(0)
  val x678_reg = list_x677_reg(1)
  val x676_reg = list_x677_reg(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x698_inr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x698_inr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x698_inr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x752 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x752""")
      val ensig0 = Wire(Bool())
      ensig0 := x669.ready
      x752.r := Math.arith_left_shift(b674, 1, Some(0.2), ensig0,"x752").r
      val x753_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x753_sum""")
      x753_sum.r := Math.add(x752,b674,Some(1.0), ensig0, Truncate, Wrapping, "x753_sum").r
      val x680 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x680""")
      x680.r := Math.arith_right_shift_div(x753_sum, 4, Some(0.2), ensig0,"x680").r
      val x681 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x681""")
      x681.r := Math.arith_left_shift(x680, 4, Some(0.2), ensig0,"x681").r
      val x754 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x754""")
      x754.r := Math.arith_left_shift(x680, 6, Some(0.2), ensig0,"x754").r
      val x683_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x683_sub""")
      x683_sub.r := Math.sub(x753_sum,x681,Some(1.0), ensig0, Truncate, Wrapping, "x683_sub").r
      val x684_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x684_sum""")
      x684_sum.r := Math.add(x683_sub,3L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x684_sum").r
      val x685_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x685_sum""")
      x685_sum.r := Math.add(x683_sub,18L.FP(true, 32, 0),Some(1.0), ensig0, Truncate, Wrapping, "x685_sum").r
      val x686 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x686""")
      x686.r := Math.arith_right_shift_div(x685_sum, 4, Some(0.2), ensig0,"x686").r
      val x687 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x687""")
      x687.r := Math.arith_left_shift(x686, 4, Some(0.2 + 1.0), ensig0,"x687").r
      val x755 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x755""")
      x755.r := Math.arith_left_shift(x686, 6, Some(0.2 + 1.0), ensig0,"x755").r
      val x689 = Wire(new FixedPoint(true, 64, 0)).suggestName("""x689""")
      x689.r := Math.fix2fix(x754, true, 64, 0, Some(0.0), ensig0, Truncate, Wrapping, "x689").r
      val x690 = x470_out_host
      val x801 = Wire(new FixedPoint(true, 64, 0)).suggestName("x801_x690_D1") 
      x801.r := getRetimed(x690.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x691_sum = Wire(new FixedPoint(true, 64, 0)).suggestName("""x691_sum""")
      x691_sum.r := Math.add(x689,x801,Some(2.0), ensig0, Truncate, Wrapping, "x691_sum").r
      val x802 = Wire(new FixedPoint(true, 64, 0)).suggestName("x802_x691_sum_D1") 
      x802.r := getRetimed(x691_sum.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x692_tuple = Wire(UInt(97.W)).suggestName("""x692_tuple""")
      x692_tuple.r := ConvAndCat(false.B,x755.r,x802.r)
      val x693 = true.B
      val x803 = Wire(Bool()).suggestName("x803_x693_D4") 
      x803.r := getRetimed(x693.r, 4.toInt, io.sigsIn.backpressure & true.B)
      x669.valid := (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(4.0.toInt.toInt, rr, io.sigsIn.backpressure & true.B) & x803 & io.sigsIn.backpressure
      x669.bits.addr := x692_tuple(63,0)
      x669.bits.size := x692_tuple(95,64)
      val x695_wr_x676_banks = List[UInt]()
      val x695_wr_x676_ofs = List[UInt]()
      val x695_wr_x676_en = List[Bool](true.B)
      val x695_wr_x676_data = List[UInt](x683_sub.r)
      x676_reg.connectWPort(695, x695_wr_x676_banks, x695_wr_x676_ofs, x695_wr_x676_data, x695_wr_x676_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x696_wr_x677_banks = List[UInt]()
      val x696_wr_x677_ofs = List[UInt]()
      val x696_wr_x677_en = List[Bool](true.B)
      val x696_wr_x677_data = List[UInt](x684_sum.r)
      x677_reg.connectWPort(696, x696_wr_x677_banks, x696_wr_x677_ofs, x696_wr_x677_data, x696_wr_x677_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(3.6.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
      val x697_wr_x678_banks = List[UInt]()
      val x697_wr_x678_ofs = List[UInt]()
      val x697_wr_x678_en = List[Bool](true.B)
      val x697_wr_x678_data = List[UInt](x687.r)
      x678_reg.connectWPort(697, x697_wr_x678_banks, x697_wr_x678_ofs, x697_wr_x678_data, x697_wr_x678_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(4.0.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && true.B))
    }
    val module = Module(new x698_inr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x698_inr_UnitPipe **/
