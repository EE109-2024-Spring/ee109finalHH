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

/** Hierarchy: x1105 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1105 **/
class x1105_kernel(
  list_b1046: List[Bool],
  list_b1043: List[FixedPoint],
  list_x1061_ctrchain: List[CounterChainInterface],
  list_x472_A_sram_1: List[StandardInterface],
  list_x1055_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1105_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1105_iiCtr"))
  
  abstract class x1105_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b1046 = Input(Bool())
      val in_x1055_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1055_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b559 = Input(Bool())
      val in_x1051_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1051_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1047 = Input(Bool())
      val in_x1057_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1057_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1050_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1050_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1054_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1054_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1058_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1058_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1043 = Input(new FixedPoint(true, 32, 0))
      val in_x1061_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1061_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b1044 = Input(new FixedPoint(true, 32, 0))
      val in_x1049_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1049_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1053_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1053_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1052_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1052_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1062_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1062_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b549 = Input(new FixedPoint(true, 32, 0))
      val in_x1056_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1056_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b1046 = {io.in_b1046} 
    def x1055_tmp_1 = {io.in_x1055_tmp_1} ; io.in_x1055_tmp_1 := DontCare
    def b559 = {io.in_b559} 
    def x1051_tmp_2 = {io.in_x1051_tmp_2} ; io.in_x1051_tmp_2 := DontCare
    def b1047 = {io.in_b1047} 
    def x1057_tmp_3 = {io.in_x1057_tmp_3} ; io.in_x1057_tmp_3 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1050_tmp_1 = {io.in_x1050_tmp_1} ; io.in_x1050_tmp_1 := DontCare
    def x1054_tmp_0 = {io.in_x1054_tmp_0} ; io.in_x1054_tmp_0 := DontCare
    def x1058_tmp_4 = {io.in_x1058_tmp_4} ; io.in_x1058_tmp_4 := DontCare
    def b1043 = {io.in_b1043} 
    def x1061_ctrchain = {io.in_x1061_ctrchain} ; io.in_x1061_ctrchain := DontCare
    def b1044 = {io.in_b1044} 
    def x1049_tmp_0 = {io.in_x1049_tmp_0} ; io.in_x1049_tmp_0 := DontCare
    def x1053_tmp_4 = {io.in_x1053_tmp_4} ; io.in_x1053_tmp_4 := DontCare
    def x1052_tmp_3 = {io.in_x1052_tmp_3} ; io.in_x1052_tmp_3 := DontCare
    def x1062_ctrchain = {io.in_x1062_ctrchain} ; io.in_x1062_ctrchain := DontCare
    def b549 = {io.in_b549} 
    def x1056_tmp_2 = {io.in_x1056_tmp_2} ; io.in_x1056_tmp_2 := DontCare
  }
  def connectWires0(module: x1105_module)(implicit stack: List[KernelHash]): Unit = {
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b1046 <> b1046
    x1055_tmp_1.connectLedger(module.io.in_x1055_tmp_1)
    module.io.in_b559 <> b559
    x1051_tmp_2.connectLedger(module.io.in_x1051_tmp_2)
    module.io.in_b1047 <> b1047
    x1057_tmp_3.connectLedger(module.io.in_x1057_tmp_3)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1050_tmp_1.connectLedger(module.io.in_x1050_tmp_1)
    x1054_tmp_0.connectLedger(module.io.in_x1054_tmp_0)
    x1058_tmp_4.connectLedger(module.io.in_x1058_tmp_4)
    module.io.in_b1043 <> b1043
    module.io.in_x1061_ctrchain.input <> x1061_ctrchain.input; module.io.in_x1061_ctrchain.output <> x1061_ctrchain.output
    module.io.in_b1044 <> b1044
    x1049_tmp_0.connectLedger(module.io.in_x1049_tmp_0)
    x1053_tmp_4.connectLedger(module.io.in_x1053_tmp_4)
    x1052_tmp_3.connectLedger(module.io.in_x1052_tmp_3)
    module.io.in_x1062_ctrchain.input <> x1062_ctrchain.input; module.io.in_x1062_ctrchain.output <> x1062_ctrchain.output
    module.io.in_b549 <> b549
    x1056_tmp_2.connectLedger(module.io.in_x1056_tmp_2)
  }
  val b1046 = list_b1046(0)
  val b559 = list_b1046(1)
  val b1047 = list_b1046(2)
  val b1043 = list_b1043(0)
  val b1044 = list_b1043(1)
  val b549 = list_b1043(2)
  val x1061_ctrchain = list_x1061_ctrchain(0)
  val x1062_ctrchain = list_x1061_ctrchain(1)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x1055_tmp_1 = list_x1055_tmp_1(0)
  val x1051_tmp_2 = list_x1055_tmp_1(1)
  val x1057_tmp_3 = list_x1055_tmp_1(2)
  val x1050_tmp_1 = list_x1055_tmp_1(3)
  val x1054_tmp_0 = list_x1055_tmp_1(4)
  val x1058_tmp_4 = list_x1055_tmp_1(5)
  val x1049_tmp_0 = list_x1055_tmp_1(6)
  val x1053_tmp_4 = list_x1055_tmp_1(7)
  val x1052_tmp_3 = list_x1055_tmp_1(8)
  val x1056_tmp_2 = list_x1055_tmp_1(9)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1105")
    implicit val stack = ControllerStack.stack.toList
    class x1105_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1105_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1105 = Module(new InstrumentationCounter())
      val iters_x1105 = Module(new InstrumentationCounter())
      cycles_x1105.io.enable := io.sigsIn.baseEn
      iters_x1105.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1105_instrctr, cycles_x1105.io.count, iters_x1105.io.count, 0.U, 0.U)
      val x1083_inr_Foreach = new x1083_inr_Foreach_kernel(List(b1046,b559), List(b1043,b549), List(x1051_tmp_2,x1050_tmp_1,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x1061_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1083_inr_Foreach.sm.io.ctrDone := (x1083_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1083_inr_Foreach.backpressure := true.B | x1083_inr_Foreach.sm.io.doneLatch
      x1083_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1083_inr_Foreach.sm.io.doneLatch
      x1083_inr_Foreach.sm.io.enableOut.zip(x1083_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1083_inr_Foreach.sm.io.break := false.B
      x1083_inr_Foreach.mask := ~x1083_inr_Foreach.cchain.head.output.noop & b1046 & b559
      x1083_inr_Foreach.configure("x1083_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1083_inr_Foreach.kernel()
      val x1104_inr_Foreach = new x1104_inr_Foreach_kernel(List(b559,b1047), List(b1044,b549), List(x1055_tmp_1,x1057_tmp_3,x1054_tmp_0,x1058_tmp_4,x1056_tmp_2), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x1062_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1104_inr_Foreach.sm.io.ctrDone := (x1104_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1104_inr_Foreach.backpressure := true.B | x1104_inr_Foreach.sm.io.doneLatch
      x1104_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1104_inr_Foreach.sm.io.doneLatch
      x1104_inr_Foreach.sm.io.enableOut.zip(x1104_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1104_inr_Foreach.sm.io.break := false.B
      x1104_inr_Foreach.mask := ~x1104_inr_Foreach.cchain.head.output.noop & b1047 & b559
      x1104_inr_Foreach.configure("x1104_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1104_inr_Foreach.kernel()
      x1049_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1050_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1051_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1052_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1053_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1054_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1055_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1056_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1057_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1058_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1105_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1105 **/
