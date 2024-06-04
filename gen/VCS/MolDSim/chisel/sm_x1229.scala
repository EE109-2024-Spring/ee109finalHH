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

/** Hierarchy: x1229 -> x1250 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1229 **/
class x1229_kernel(
  list_b1046: List[Bool],
  list_x1200_ctrchain: List[CounterChainInterface],
  list_x1055_tmp_1: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1229_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1229_iiCtr"))
  
  abstract class x1229_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1200_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1200_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b1046 = Input(Bool())
      val in_x1055_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1055_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b559 = Input(Bool())
      val in_x1136_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1136_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1051_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1051_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1199_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1199_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b1047 = Input(Bool())
      val in_x1057_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1057_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1050_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1050_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1054_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1054_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1135_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1135_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1058_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1058_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1049_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1049_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1053_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1053_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1052_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1052_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1056_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1056_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x1200_ctrchain = {io.in_x1200_ctrchain} ; io.in_x1200_ctrchain := DontCare
    def b1046 = {io.in_b1046} 
    def x1055_tmp_1 = {io.in_x1055_tmp_1} ; io.in_x1055_tmp_1 := DontCare
    def b559 = {io.in_b559} 
    def x1136_force_0 = {io.in_x1136_force_0} ; io.in_x1136_force_0 := DontCare
    def x1051_tmp_2 = {io.in_x1051_tmp_2} ; io.in_x1051_tmp_2 := DontCare
    def x1199_ctrchain = {io.in_x1199_ctrchain} ; io.in_x1199_ctrchain := DontCare
    def b1047 = {io.in_b1047} 
    def x1057_tmp_3 = {io.in_x1057_tmp_3} ; io.in_x1057_tmp_3 := DontCare
    def x1050_tmp_1 = {io.in_x1050_tmp_1} ; io.in_x1050_tmp_1 := DontCare
    def x1054_tmp_0 = {io.in_x1054_tmp_0} ; io.in_x1054_tmp_0 := DontCare
    def x1135_force_0 = {io.in_x1135_force_0} ; io.in_x1135_force_0 := DontCare
    def x1058_tmp_4 = {io.in_x1058_tmp_4} ; io.in_x1058_tmp_4 := DontCare
    def x1049_tmp_0 = {io.in_x1049_tmp_0} ; io.in_x1049_tmp_0 := DontCare
    def x1053_tmp_4 = {io.in_x1053_tmp_4} ; io.in_x1053_tmp_4 := DontCare
    def x1052_tmp_3 = {io.in_x1052_tmp_3} ; io.in_x1052_tmp_3 := DontCare
    def x1056_tmp_2 = {io.in_x1056_tmp_2} ; io.in_x1056_tmp_2 := DontCare
  }
  def connectWires0(module: x1229_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x1200_ctrchain.input <> x1200_ctrchain.input; module.io.in_x1200_ctrchain.output <> x1200_ctrchain.output
    module.io.in_b1046 <> b1046
    x1055_tmp_1.connectLedger(module.io.in_x1055_tmp_1)
    module.io.in_b559 <> b559
    x1136_force_0.connectLedger(module.io.in_x1136_force_0)
    x1051_tmp_2.connectLedger(module.io.in_x1051_tmp_2)
    module.io.in_x1199_ctrchain.input <> x1199_ctrchain.input; module.io.in_x1199_ctrchain.output <> x1199_ctrchain.output
    module.io.in_b1047 <> b1047
    x1057_tmp_3.connectLedger(module.io.in_x1057_tmp_3)
    x1050_tmp_1.connectLedger(module.io.in_x1050_tmp_1)
    x1054_tmp_0.connectLedger(module.io.in_x1054_tmp_0)
    x1135_force_0.connectLedger(module.io.in_x1135_force_0)
    x1058_tmp_4.connectLedger(module.io.in_x1058_tmp_4)
    x1049_tmp_0.connectLedger(module.io.in_x1049_tmp_0)
    x1053_tmp_4.connectLedger(module.io.in_x1053_tmp_4)
    x1052_tmp_3.connectLedger(module.io.in_x1052_tmp_3)
    x1056_tmp_2.connectLedger(module.io.in_x1056_tmp_2)
  }
  val b1046 = list_b1046(0)
  val b559 = list_b1046(1)
  val b1047 = list_b1046(2)
  val x1200_ctrchain = list_x1200_ctrchain(0)
  val x1199_ctrchain = list_x1200_ctrchain(1)
  val x1055_tmp_1 = list_x1055_tmp_1(0)
  val x1136_force_0 = list_x1055_tmp_1(1)
  val x1051_tmp_2 = list_x1055_tmp_1(2)
  val x1057_tmp_3 = list_x1055_tmp_1(3)
  val x1050_tmp_1 = list_x1055_tmp_1(4)
  val x1054_tmp_0 = list_x1055_tmp_1(5)
  val x1135_force_0 = list_x1055_tmp_1(6)
  val x1058_tmp_4 = list_x1055_tmp_1(7)
  val x1049_tmp_0 = list_x1055_tmp_1(8)
  val x1053_tmp_4 = list_x1055_tmp_1(9)
  val x1052_tmp_3 = list_x1055_tmp_1(10)
  val x1056_tmp_2 = list_x1055_tmp_1(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1229")
    implicit val stack = ControllerStack.stack.toList
    class x1229_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1229_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1229 = Module(new InstrumentationCounter())
      val iters_x1229 = Module(new InstrumentationCounter())
      cycles_x1229.io.enable := io.sigsIn.baseEn
      iters_x1229.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1229_instrctr, cycles_x1229.io.count, iters_x1229.io.count, 0.U, 0.U)
      val x1214_inr_Foreach = new x1214_inr_Foreach_kernel(List(b1046,b559), List(x1051_tmp_2,x1050_tmp_1,x1135_force_0,x1049_tmp_0,x1053_tmp_4,x1052_tmp_3) ,  Some(me), List(x1199_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1214_inr_Foreach.sm.io.ctrDone := (x1214_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1214_inr_Foreach.backpressure := true.B | x1214_inr_Foreach.sm.io.doneLatch
      x1214_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1214_inr_Foreach.sm.io.doneLatch
      x1214_inr_Foreach.sm.io.enableOut.zip(x1214_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1214_inr_Foreach.sm.io.break := false.B
      x1214_inr_Foreach.mask := ~x1214_inr_Foreach.cchain.head.output.noop & b1046 & b559
      x1214_inr_Foreach.configure("x1214_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1214_inr_Foreach.kernel()
      val x1228_inr_Foreach = new x1228_inr_Foreach_kernel(List(b559,b1047), List(x1055_tmp_1,x1136_force_0,x1057_tmp_3,x1054_tmp_0,x1058_tmp_4,x1056_tmp_2) ,  Some(me), List(x1200_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1228_inr_Foreach.sm.io.ctrDone := (x1228_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1228_inr_Foreach.backpressure := true.B | x1228_inr_Foreach.sm.io.doneLatch
      x1228_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1228_inr_Foreach.sm.io.doneLatch
      x1228_inr_Foreach.sm.io.enableOut.zip(x1228_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1228_inr_Foreach.sm.io.break := false.B
      x1228_inr_Foreach.mask := ~x1228_inr_Foreach.cchain.head.output.noop & b1047 & b559
      x1228_inr_Foreach.configure("x1228_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1228_inr_Foreach.kernel()
      x1049_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1050_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1051_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1052_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1053_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1054_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1055_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1056_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1057_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1058_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 6)
      x1135_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
      x1136_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 1)
    }
    val module = Module(new x1229_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1229 **/
