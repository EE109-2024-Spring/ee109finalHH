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

/** Hierarchy: x717 -> x718 -> x723 -> x724 -> x444 **/
/** BEGIN None x717_inr_Foreach **/
class x717_inr_Foreach_kernel(
  list_b674: List[FixedPoint],
  list_x677_reg: List[StandardInterface],
  list_x670: List[DecoupledIO[AppStoreData]],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 4.2.toInt, myName = "x717_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x717_inr_Foreach_iiCtr"))
  
  abstract class x717_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x677_reg = Flipped(new StandardInterface(ModuleParams.getParams("x677_reg_p").asInstanceOf[MemParams] ))
      val in_x670 = Decoupled(new AppStoreData(ModuleParams.getParams("x670_p").asInstanceOf[(Int,Int)] ))
      val in_b674 = Input(new FixedPoint(true, 32, 0))
      val in_x539_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x539_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_x676_reg = Flipped(new StandardInterface(ModuleParams.getParams("x676_reg_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x677_reg = {io.in_x677_reg} ; io.in_x677_reg := DontCare
    def x670 = {io.in_x670} 
    def b674 = {io.in_b674} 
    def x539_out_sram_0 = {io.in_x539_out_sram_0} ; io.in_x539_out_sram_0 := DontCare
    def x676_reg = {io.in_x676_reg} ; io.in_x676_reg := DontCare
  }
  def connectWires0(module: x717_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x677_reg.connectLedger(module.io.in_x677_reg)
    module.io.in_x670 <> x670
    module.io.in_b674 <> b674
    x539_out_sram_0.connectLedger(module.io.in_x539_out_sram_0)
    x676_reg.connectLedger(module.io.in_x676_reg)
  }
  val b674 = list_b674(0)
  val x677_reg = list_x677_reg(0)
  val x539_out_sram_0 = list_x677_reg(1)
  val x676_reg = list_x677_reg(2)
  val x670 = list_x670(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x717_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x717_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x717_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val b702 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b702.suggestName("b702")
      val b703 = ~io.sigsIn.cchainOutputs.head.oobs(0); b703.suggestName("b703")
      val x704_rd_x676 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x704_rd_x676""")
      val x704_rd_x676_banks = List[UInt]()
      val x704_rd_x676_ofs = List[UInt]()
      val x704_rd_x676_en = List[Bool](true.B)
      val x704_rd_x676_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x704_rd_x676_shared_en")
      x704_rd_x676.toSeq.zip(x676_reg.connectRPort(704, x704_rd_x676_banks, x704_rd_x676_ofs, io.sigsIn.backpressure, x704_rd_x676_en.map(_ && x704_rd_x676_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x705 = Wire(Bool()).suggestName("""x705""")
      val ensig0 = Wire(Bool())
      ensig0 := x670.ready
      x705.r := Math.lte(x704_rd_x676, b702, Some(0.4), ensig0,"x705").r
      val x706_rd_x677 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x706_rd_x677""")
      val x706_rd_x677_banks = List[UInt]()
      val x706_rd_x677_ofs = List[UInt]()
      val x706_rd_x677_en = List[Bool](true.B)
      val x706_rd_x677_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x706_rd_x677_shared_en")
      x706_rd_x677.toSeq.zip(x677_reg.connectRPort(706, x706_rd_x677_banks, x706_rd_x677_ofs, io.sigsIn.backpressure, x706_rd_x677_en.map(_ && x706_rd_x677_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x707 = Wire(Bool()).suggestName("""x707""")
      x707.r := Math.lt(b702, x706_rd_x677, Some(0.4), ensig0,"x707").r
      val x708 = Wire(Bool()).suggestName("""x708""")
      x708 := x705 & x707
      val x709_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x709_sub""")
      x709_sub.r := Math.sub(b702,x704_rd_x676,Some(1.0), ensig0, Truncate, Wrapping, "x709_sub").r
      val x756 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x756""")
      x756.r := Math.arith_left_shift(b674, 1, Some(0.2), ensig0,"x756").r
      val x757_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x757_sum""")
      x757_sum.r := Math.add(x756,b674,Some(1.0), ensig0, Truncate, Wrapping, "x757_sum").r
      val x712_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x712_sum""")
      x712_sum.r := Math.add(x757_sum,x709_sub,Some(1.0), ensig0, Truncate, Wrapping, "x712_sum").r
      val x804 = Wire(Bool()).suggestName("x804_b703_D2") 
      x804.r := getRetimed(b703.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x805 = Wire(Bool()).suggestName("x805_x708_D2") 
      x805.r := getRetimed(x708.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x713_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x713_rd""")
      val x713_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x713_rd_ofs = List[UInt](x712_sum.r)
      val x713_rd_en = List[Bool](true.B)
      val x713_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.2.toInt, rr, io.sigsIn.backpressure & true.B) && x805 & x804 ).suggestName("x713_rd_shared_en")
      x713_rd.toSeq.zip(x539_out_sram_0.connectRPort(713, x713_rd_banks, x713_rd_ofs, io.sigsIn.backpressure, x713_rd_en.map(_ && x713_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x714 = VecApply(x713,0)
      val x714_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x714_elem_0""")
      x714_elem_0.r := x713_rd(0).r
      val x806 = Wire(Bool()).suggestName("x806_x708_D4") 
      x806.r := getRetimed(x708.r, 4.toInt, io.sigsIn.backpressure & true.B)
      val x715_tuple = Wire(UInt(33.W)).suggestName("""x715_tuple""")
      x715_tuple.r := ConvAndCat(x806,x714_elem_0.r)
      val x807 = Wire(Bool()).suggestName("x807_b703_D4") 
      x807.r := getRetimed(b703.r, 4.toInt, io.sigsIn.backpressure & true.B)
      x670.valid := (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(4.2.toInt.toInt, rr, io.sigsIn.backpressure & true.B) & x807 & io.sigsIn.backpressure
      x670.bits.wdata(0) := x715_tuple(31,0)
      x670.bits.wstrb := x715_tuple(32,32)
    }
    val module = Module(new x717_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnrolledForeach x717_inr_Foreach **/
