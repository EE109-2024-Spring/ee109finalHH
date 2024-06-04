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

/** Hierarchy: x1083 -> x1105 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1083_inr_Foreach **/
class x1083_inr_Foreach_kernel(
  list_b1046: List[Bool],
  list_b1043: List[FixedPoint],
  list_x1051_tmp_2: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Pipelined, false   , latency = 26.2.toInt, myName = "x1083_inr_Foreach_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1083_inr_Foreach_iiCtr"))
  
  abstract class x1083_inr_Foreach_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b1046 = Input(Bool())
      val in_b559 = Input(Bool())
      val in_x1051_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1051_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1050_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1050_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b1043 = Input(new FixedPoint(true, 32, 0))
      val in_x1049_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1049_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1053_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1053_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1052_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1052_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b549 = Input(new FixedPoint(true, 32, 0))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b1046 = {io.in_b1046} 
    def b559 = {io.in_b559} 
    def x1051_tmp_2 = {io.in_x1051_tmp_2} ; io.in_x1051_tmp_2 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1050_tmp_1 = {io.in_x1050_tmp_1} ; io.in_x1050_tmp_1 := DontCare
    def b1043 = {io.in_b1043} 
    def x1049_tmp_0 = {io.in_x1049_tmp_0} ; io.in_x1049_tmp_0 := DontCare
    def x1053_tmp_4 = {io.in_x1053_tmp_4} ; io.in_x1053_tmp_4 := DontCare
    def x1052_tmp_3 = {io.in_x1052_tmp_3} ; io.in_x1052_tmp_3 := DontCare
    def b549 = {io.in_b549} 
  }
  def connectWires0(module: x1083_inr_Foreach_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b1046 <> b1046
    module.io.in_b559 <> b559
    x1051_tmp_2.connectLedger(module.io.in_x1051_tmp_2)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1050_tmp_1.connectLedger(module.io.in_x1050_tmp_1)
    module.io.in_b1043 <> b1043
    x1049_tmp_0.connectLedger(module.io.in_x1049_tmp_0)
    x1053_tmp_4.connectLedger(module.io.in_x1053_tmp_4)
    x1052_tmp_3.connectLedger(module.io.in_x1052_tmp_3)
    module.io.in_b549 <> b549
  }
  val b1046 = list_b1046(0)
  val b559 = list_b1046(1)
  val b1043 = list_b1043(0)
  val b549 = list_b1043(1)
  val x1051_tmp_2 = list_x1051_tmp_2(0)
  val x1050_tmp_1 = list_x1051_tmp_2(1)
  val x1049_tmp_0 = list_x1051_tmp_2(2)
  val x1053_tmp_4 = list_x1051_tmp_2(3)
  val x1052_tmp_3 = list_x1051_tmp_2(4)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1083_inr_Foreach")
    implicit val stack = ControllerStack.stack.toList
    class x1083_inr_Foreach_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1083_inr_Foreach_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1083_inr_Foreach = Module(new InstrumentationCounter())
      val iters_x1083_inr_Foreach = Module(new InstrumentationCounter())
      cycles_x1083_inr_Foreach.io.enable := io.sigsIn.baseEn
      iters_x1083_inr_Foreach.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1083_instrctr, cycles_x1083_inr_Foreach.io.count, iters_x1083_inr_Foreach.io.count, 0.U, 0.U)
      val b1063 = io.sigsIn.cchainOutputs.head.counts(0).FP(true, 32, 0); b1063.suggestName("b1063")
      val b1064 = ~io.sigsIn.cchainOutputs.head.oobs(0); b1064.suggestName("b1064")
      val x1066_div = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1066_div""")
      x1066_div.r := (Math.div(b549, 10L.FP(true, 32, 0), Some(20.0), true.B, Truncate, Wrapping, "x1066_div")).r
      val x3001 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3001""")
      x3001.r := Math.arith_left_shift(x1066_div, 1, Some(0.2), true.B,"x3001").r
      val x3002_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x3002_sum""")
      x3002_sum.r := Math.add(x3001,x1066_div,Some(1.0), true.B, Truncate, Wrapping, "x3002_sum").r
      val x3263 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3263_b1063_D21") 
      x3263.r := getRetimed(b1063.r, 21.toInt, io.sigsIn.backpressure & true.B)
      val x1068_sum = Wire(new FixedPoint(true, 32, 0)).suggestName("""x1068_sum""")
      x1068_sum.r := Math.add(x3002_sum,x3263,Some(1.0), true.B, Truncate, Wrapping, "x1068_sum").r
      val x3264 = Wire(Bool()).suggestName("x3264_b1046_D22") 
      x3264.r := getRetimed(b1046.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3265 = Wire(Bool()).suggestName("x3265_b559_D22") 
      x3265.r := getRetimed(b559.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x3266 = Wire(Bool()).suggestName("x3266_b1064_D22") 
      x3266.r := getRetimed(b1064.r, 22.toInt, io.sigsIn.backpressure & true.B)
      val x1069_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1069_rd""")
      val x1069_rd_banks = List[UInt](2L.FP(true, 32, 0).r,0L.FP(true, 32, 0).r)
      val x1069_rd_ofs = List[UInt](x1068_sum.r)
      val x1069_rd_en = List[Bool](true.B)
      val x1069_rd_shared_en = ((io.sigsIn.forwardpressure).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(22.2.toInt, rr, io.sigsIn.backpressure & true.B) && x3266 & x3264 & x3265 ).suggestName("x1069_rd_shared_en")
      x1069_rd.toSeq.zip(x471_A_sram_0.connectRPort(1069, x1069_rd_banks, x1069_rd_ofs, io.sigsIn.backpressure, x1069_rd_en.map(_ && x1069_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1070 = VecApply(x1069,0)
      val x1070_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1070_elem_0""")
      x1070_elem_0.r := x1069_rd(0).r
      val x1075_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1075_rd""")
      val x1075_rd_banks = List[UInt](0.U,0L.FP(true, 32, 0).r)
      val x1075_rd_ofs = List[UInt](0.U)
      val x1075_rd_en = List[Bool](true.B)
      val x1075_rd_shared_en = ((io.sigsIn.forwardpressure).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(2.4.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1075_rd_shared_en")
      x1075_rd.toSeq.zip(x472_A_sram_1.connectRPort(1075, x1075_rd_banks, x1075_rd_ofs, io.sigsIn.backpressure, x1075_rd_en.map(_ && x1075_rd_shared_en), false)).foreach{case (a,b) => a.r := b.r}
      // x1076 = VecApply(x1075,0)
      val x1076_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1076_elem_0""")
      x1076_elem_0.r := x1075_rd(0).r
      val x3271 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3271_x1076_elem_0_D20") 
      x3271.r := getRetimed(x1076_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1077_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1077_sub""")
      x1077_sub.r := Math.sub(x1070_elem_0,x3271,Some(1.0), true.B, Truncate, Wrapping, "x1077_sub").r
      val x3272 = Wire(new FixedPoint(true, 32, 0)).suggestName("x3272_b1063_D25") 
      x3272.r := getRetimed(b1063.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3273 = Wire(Bool()).suggestName("x3273_b1046_D25") 
      x3273.r := getRetimed(b1046.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3274 = Wire(Bool()).suggestName("x3274_b559_D25") 
      x3274.r := getRetimed(b559.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x3275 = Wire(Bool()).suggestName("x3275_b1064_D25") 
      x3275.r := getRetimed(b1064.r, 25.toInt, io.sigsIn.backpressure & true.B)
      val x1078_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1078_wr_ofs = List[UInt](x3272.r)
      val x1078_wr_en = List[Bool](true.B)
      val x1078_wr_data = List[UInt](x1077_sub.r)
      x1051_tmp_2.connectWPort(1078, x1078_wr_banks, x1078_wr_ofs, x1078_wr_data, x1078_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3275 & x3273 & x3274))
      val x1079_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1079_wr_ofs = List[UInt](x3272.r)
      val x1079_wr_en = List[Bool](true.B)
      val x1079_wr_data = List[UInt](x1077_sub.r)
      x1050_tmp_1.connectWPort(1079, x1079_wr_banks, x1079_wr_ofs, x1079_wr_data, x1079_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3275 & x3273 & x3274))
      val x1080_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1080_wr_ofs = List[UInt](x3272.r)
      val x1080_wr_en = List[Bool](true.B)
      val x1080_wr_data = List[UInt](x1077_sub.r)
      x1049_tmp_0.connectWPort(1080, x1080_wr_banks, x1080_wr_ofs, x1080_wr_data, x1080_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3275 & x3273 & x3274))
      val x1081_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1081_wr_ofs = List[UInt](x3272.r)
      val x1081_wr_en = List[Bool](true.B)
      val x1081_wr_data = List[UInt](x1077_sub.r)
      x1053_tmp_4.connectWPort(1081, x1081_wr_banks, x1081_wr_ofs, x1081_wr_data, x1081_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3275 & x3273 & x3274))
      val x1082_wr_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1082_wr_ofs = List[UInt](x3272.r)
      val x1082_wr_en = List[Bool](true.B)
      val x1082_wr_data = List[UInt](x1077_sub.r)
      x1052_tmp_3.connectWPort(1082, x1082_wr_banks, x1082_wr_ofs, x1082_wr_data, x1082_wr_en.map(_ && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(25.2.toInt, rr, io.sigsIn.backpressure & true.B) & ~io.sigsIn.break && io.sigsIn.backpressure && x3275 & x3273 & x3274))
    }
    val module = Module(new x1083_inr_Foreach_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnrolledForeach x1083_inr_Foreach **/
