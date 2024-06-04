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

/** Hierarchy: x541 -> x542 -> x543 -> x444 **/
/** BEGIN None x541_inr_Foreach **/
class x541_inr_Foreach_kernel(
  list_b504: List[Bool],
  list_b503: List[FixedPoint],
  list_x476: List[DecoupledIO[AppLoadData]],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 23.2.toInt, myName = "x541_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x541_inr_Foreach_iiCtr"))
  
  abstract class x541_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b504 = Input(Bool())
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x476 = Flipped(Decoupled(new AppLoadData(ModuleParams.getParams("x476_p").asInstanceOf[(Int, Int)] )))
      val in_b503 = Input(new FixedPoint(true, 32, 0))
      val in_x505_reg = Flipped(new StandardInterface(ModuleParams.getParams("x505_reg_p").asInstanceOf[MemParams] ))
      val in_x473_A_sram_2 = Flipped(new StandardInterface(ModuleParams.getParams("x473_A_sram_2_p").asInstanceOf[MemParams] ))
      val in_x506_reg = Flipped(new StandardInterface(ModuleParams.getParams("x506_reg_p").asInstanceOf[MemParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b504 = {io.in_b504} 
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x476 = {io.in_x476} 
    def b503 = {io.in_b503} 
    def x505_reg = {io.in_x505_reg} ; io.in_x505_reg := DontCare
    def x473_A_sram_2 = {io.in_x473_A_sram_2} ; io.in_x473_A_sram_2 := DontCare
    def x506_reg = {io.in_x506_reg} ; io.in_x506_reg := DontCare
  }
  def connectWires0(module: x541_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b504 <> b504
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_x476 <> x476
    module.io.in_b503 <> b503
    x505_reg.connectLedger(module.io.in_x505_reg)
    x473_A_sram_2.connectLedger(module.io.in_x473_A_sram_2)
    x506_reg.connectLedger(module.io.in_x506_reg)
  }
  val b504 = list_b504(0)
  val b503 = list_b503(0)
  val x476 = list_x476(0)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x505_reg = list_x472_A_sram_1(2)
  val x473_A_sram_2 = list_x472_A_sram_1(3)
  val x506_reg = list_x472_A_sram_1(4)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x541_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x541_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x541_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x541_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x541_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x541_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x541_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      val stalls_x541_inr_Foreach = Module(new InstrumentationCounter())
      val idles_x541_inr_Foreach = Module(new InstrumentationCounter())
      stalls_x541_inr_Foreach.io.enable := io.sigsIn.baseEn & ~(true.B)
      idles_x541_inr_Foreach.io.enable := io.sigsIn.baseEn & ~((x476.valid) && (true.B))
      Ledger.tieInstrCtr(instrctrs.toList, X541_instrctr, cycles_x541_inr_Foreach.io.count, iters_x541_inr_Foreach.io.count, stalls_x541_inr_Foreach.io.count, idles_x541_inr_Foreach.io.count)
      val b520 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b520.suggestName("b520")
      val b521 = ~io.sigsIn.cchainOutputs.head.oobs(0); b521.suggestName("b521")
      val x522_rd_x505 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x522_rd_x505""")
      val x522_rd_x505_banks = List[UInt]()
      val x522_rd_x505_ofs = List[UInt]()
      val x522_rd_x505_en = List[Bool](true.B)
      val x522_rd_x505_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x522_rd_x505_shared_en")
      x522_rd_x505.toSeq.zip(x505_reg.connectRPort(522, x522_rd_x505_banks, x522_rd_x505_ofs, io.sigsIn.backpressure, x522_rd_x505_en.map(_ && x522_rd_x505_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x523 = Wire(Bool()).suggestName("""x523""")
      x523.r := Math.lte(x522_rd_x505, b520, Some(0.4), true.B,"x523").r
      val x524_rd_x506 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x524_rd_x506""")
      val x524_rd_x506_banks = List[UInt]()
      val x524_rd_x506_ofs = List[UInt]()
      val x524_rd_x506_en = List[Bool](true.B)
      val x524_rd_x506_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x524_rd_x506_shared_en")
      x524_rd_x506.toSeq.zip(x506_reg.connectRPort(524, x524_rd_x506_banks, x524_rd_x506_ofs, io.sigsIn.backpressure, x524_rd_x506_en.map(_ && x524_rd_x506_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x525 = Wire(Bool()).suggestName("""x525""")
      x525.r := Math.lt(b520, x524_rd_x506, Some(0.4), true.B,"x525").r
      val x526 = Wire(Bool()).suggestName("""x526""")
      x526 := x523 & x525
      val x527_sub = Wire(new FixedPoint(true, 32, 0)).suggestName("""x527_sub""")
      x527_sub.r := Math.sub(b520,x522_rd_x505,Some(1.0), true.B, Truncate, Wrapping, "x527_sub").r
      val x528 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x528""")
      x476.ready := b521 & b504 & (io.sigsIn.datapathEn) 
      (0 until 1).map{ i => x528(i).r := x476.bits.rdata(i).r }
      val x3129 = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("x3129_x528_D1") 
      (0 until 1).foreach{i => x3129(i).r := getRetimed(x528(i).r, 1.toInt, io.sigsIn.backpressure & true.B)}
      // x529 = VecApply(x3129,0)
      val x529_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x529_elem_0""")
      x529_elem_0.r := x3129(0).r
      val x2972 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2972""")
      x2972.r := Math.and(b503,1L.FP(true, 32, 0),Some(0.2), true.B,"x2972").r
      val x531 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x531""")
      x531.r := Math.arith_right_shift_div(b503, 1, Some(0.2), true.B,"x531").r
      val x2973 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2973""")
      x2973.r := Math.arith_left_shift(x531, 1, Some(0.2), true.B,"x2973").r
      val x2974_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2974_sum""")
      x2974_sum.r := Math.add(x2973,x531,Some(1.0), true.B, Truncate, Wrapping, "x2974_sum").r
      val x533_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x533_sum""")
      x533_sum.r := Math.add(x2974_sum,x527_sub,Some(1.0), true.B, Truncate, Wrapping, "x533_sum").r
      val x3130 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3130_x2972_D2") 
      x3130.r := getRetimed(x2972.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x3131 = Wire(Bool()).suggestName("x3131_b504_D2") 
      x3131.r := getRetimed(b504.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x3132 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3132_x529_elem_0_D1") 
      x3132.r := getRetimed(x529_elem_0.r, 1.toInt, io.sigsIn.backpressure & true.B)
      val x3133 = Wire(Bool()).suggestName("x3133_x526_D2") 
      x3133.r := getRetimed(x526.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x3134 = Wire(Bool()).suggestName("x3134_b521_D2") 
      x3134.r := getRetimed(b521.r, 2.toInt, io.sigsIn.backpressure & true.B)
      val x534_wr_banks = List[UInt](x3130.r,0L.FP(true, 32, 0).r)
      val x534_wr_ofs = List[UInt](x533_sum.r)
      val x534_wr_en = List[Bool](true.B)
      val x534_wr_data = List[UInt](x3132.r)
      x472_A_sram_1.connectWPort(534, x534_wr_banks, x534_wr_ofs, x534_wr_data, x534_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3133 & x3134 & x3131))
      val x535 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x535""")
      x535.r := (Math.mod(b503, 10L.FP(true, 32, 0), Some(16.0), true.B, Truncate, Wrapping, "x535")).r
      val x536_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x536_div""")
      x536_div.r := (Math.div(b503, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x536_div")).r
      val x2975 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2975""")
      x2975.r := Math.arith_left_shift(x536_div, 1, Some(0.2), true.B,"x2975").r
      val x2976_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2976_sum""")
      x2976_sum.r := Math.add(x2975,x536_div,Some(1.0), true.B, Truncate, Wrapping, "x2976_sum").r
      val x3135 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3135_x527_sub_D20") 
      x3135.r := getRetimed(x527_sub.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x538_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x538_sum""")
      x538_sum.r := Math.add(x2976_sum,x3135,Some(1.0), true.B, Truncate, Wrapping, "x538_sum").r
      val x3136 = Wire(Bool()).suggestName("x3136_b504_D22") 
      x3136.r := getRetimed(b504.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3137 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3137_x529_elem_0_D21") 
      x3137.r := getRetimed(x529_elem_0.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x3138 = Wire(Bool()).suggestName("x3138_x526_D22") 
      x3138.r := getRetimed(x526.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3139 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3139_x535_D6") 
      x3139.r := getRetimed(x535.r, 6.toInt, io.sigsIn.backpressure & true.B)
      val x3140 = Wire(Bool()).suggestName("x3140_b521_D22") 
      x3140.r := getRetimed(b521.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x539_wr_banks = List[UInt](x3139.r,0L.FP(true, 32, 0).r)
      val x539_wr_ofs = List[UInt](x538_sum.r)
      val x539_wr_en = List[Bool](true.B)
      val x539_wr_data = List[UInt](x3137.r)
      x471_A_sram_0.connectWPort(539, x539_wr_banks, x539_wr_ofs, x539_wr_data, x539_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3138 & x3140 & x3136))
      val x540_wr_banks = List[UInt](x3139.r,0L.FP(true, 32, 0).r)
      val x540_wr_ofs = List[UInt](x538_sum.r)
      val x540_wr_en = List[Bool](true.B)
      val x540_wr_data = List[UInt](x3137.r)
      x473_A_sram_2.connectWPort(540, x540_wr_banks, x540_wr_ofs, x540_wr_data, x540_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3138 & x3140 & x3136))
    }
    val module = Module(new x541_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x541_inr_Foreach **/
