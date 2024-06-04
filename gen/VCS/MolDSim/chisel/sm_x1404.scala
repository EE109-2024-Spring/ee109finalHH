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

/** Hierarchy: x1404 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1404 **/
class x1404_kernel(
  list_b1254: List[Bool],
  list_x1385_inr_Switch: List[FixedPoint],
  list_x1260_tmp_3: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1404_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1404_iiCtr"))
  
  abstract class x1404_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1260_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1260_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1265_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1265_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b1254 = Input(Bool())
      val in_x1264_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1264_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1343_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1343_force_0_p").asInstanceOf[NBufParams] ))
      val in_b1255 = Input(Bool())
      val in_x1259_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1259_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x1263_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1263_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1266_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1266_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1258_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1258_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1344_force_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1344_force_0_p").asInstanceOf[NBufParams] ))
      val in_x1262_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1262_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1257_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1257_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1385_inr_Switch = Input(new FixedPoint(true, 10, 22))
      val in_x1261_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1261_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_x1399_inr_Switch = Input(new FixedPoint(true, 10, 22))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x1260_tmp_3 = {io.in_x1260_tmp_3} ; io.in_x1260_tmp_3 := DontCare
    def x1265_tmp_3 = {io.in_x1265_tmp_3} ; io.in_x1265_tmp_3 := DontCare
    def b1254 = {io.in_b1254} 
    def x1264_tmp_2 = {io.in_x1264_tmp_2} ; io.in_x1264_tmp_2 := DontCare
    def x1343_force_0 = {io.in_x1343_force_0} ; io.in_x1343_force_0 := DontCare
    def b1255 = {io.in_b1255} 
    def x1259_tmp_2 = {io.in_x1259_tmp_2} ; io.in_x1259_tmp_2 := DontCare
    def x1263_tmp_1 = {io.in_x1263_tmp_1} ; io.in_x1263_tmp_1 := DontCare
    def x1266_tmp_4 = {io.in_x1266_tmp_4} ; io.in_x1266_tmp_4 := DontCare
    def x1258_tmp_1 = {io.in_x1258_tmp_1} ; io.in_x1258_tmp_1 := DontCare
    def x1344_force_0 = {io.in_x1344_force_0} ; io.in_x1344_force_0 := DontCare
    def x1262_tmp_0 = {io.in_x1262_tmp_0} ; io.in_x1262_tmp_0 := DontCare
    def x1257_tmp_0 = {io.in_x1257_tmp_0} ; io.in_x1257_tmp_0 := DontCare
    def x1385_inr_Switch = {io.in_x1385_inr_Switch} 
    def x1261_tmp_4 = {io.in_x1261_tmp_4} ; io.in_x1261_tmp_4 := DontCare
    def x1399_inr_Switch = {io.in_x1399_inr_Switch} 
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1404_module)(implicit stack: List[KernelHash]): Unit = {
    x1260_tmp_3.connectLedger(module.io.in_x1260_tmp_3)
    x1265_tmp_3.connectLedger(module.io.in_x1265_tmp_3)
    module.io.in_b1254 <> b1254
    x1264_tmp_2.connectLedger(module.io.in_x1264_tmp_2)
    x1343_force_0.connectLedger(module.io.in_x1343_force_0)
    module.io.in_b1255 <> b1255
    x1259_tmp_2.connectLedger(module.io.in_x1259_tmp_2)
    x1263_tmp_1.connectLedger(module.io.in_x1263_tmp_1)
    x1266_tmp_4.connectLedger(module.io.in_x1266_tmp_4)
    x1258_tmp_1.connectLedger(module.io.in_x1258_tmp_1)
    x1344_force_0.connectLedger(module.io.in_x1344_force_0)
    x1262_tmp_0.connectLedger(module.io.in_x1262_tmp_0)
    x1257_tmp_0.connectLedger(module.io.in_x1257_tmp_0)
    module.io.in_x1385_inr_Switch <> x1385_inr_Switch
    x1261_tmp_4.connectLedger(module.io.in_x1261_tmp_4)
    module.io.in_x1399_inr_Switch <> x1399_inr_Switch
    module.io.in_b560 <> b560
  }
  val b1254 = list_b1254(0)
  val b1255 = list_b1254(1)
  val b560 = list_b1254(2)
  val x1385_inr_Switch = list_x1385_inr_Switch(0)
  val x1399_inr_Switch = list_x1385_inr_Switch(1)
  val x1260_tmp_3 = list_x1260_tmp_3(0)
  val x1265_tmp_3 = list_x1260_tmp_3(1)
  val x1264_tmp_2 = list_x1260_tmp_3(2)
  val x1343_force_0 = list_x1260_tmp_3(3)
  val x1259_tmp_2 = list_x1260_tmp_3(4)
  val x1263_tmp_1 = list_x1260_tmp_3(5)
  val x1266_tmp_4 = list_x1260_tmp_3(6)
  val x1258_tmp_1 = list_x1260_tmp_3(7)
  val x1344_force_0 = list_x1260_tmp_3(8)
  val x1262_tmp_0 = list_x1260_tmp_3(9)
  val x1257_tmp_0 = list_x1260_tmp_3(10)
  val x1261_tmp_4 = list_x1260_tmp_3(11)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1404")
    implicit val stack = ControllerStack.stack.toList
    class x1404_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1404_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1404 = Module(new InstrumentationCounter())
      val iters_x1404 = Module(new InstrumentationCounter())
      cycles_x1404.io.enable := io.sigsIn.baseEn
      iters_x1404.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1404_instrctr, cycles_x1404.io.count, iters_x1404.io.count, 0.U, 0.U)
      val x1401_inr_UnitPipe = new x1401_inr_UnitPipe_kernel(List(b1254,b560), List(x1385_inr_Switch), List(x1343_force_0) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1401_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1401_inr_UnitPipe.sm.io.ctrInc)
      x1401_inr_UnitPipe.backpressure := true.B | x1401_inr_UnitPipe.sm.io.doneLatch
      x1401_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1401_inr_UnitPipe.sm.io.doneLatch
      x1401_inr_UnitPipe.sm.io.enableOut.zip(x1401_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1401_inr_UnitPipe.sm.io.break := false.B
      x1401_inr_UnitPipe.mask := true.B & b1254 & b560
      x1401_inr_UnitPipe.configure("x1401_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1401_inr_UnitPipe.kernel()
      val x1403_inr_UnitPipe = new x1403_inr_UnitPipe_kernel(List(b1255,b560), List(x1399_inr_Switch), List(x1344_force_0) ,  Some(me), List(), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1403_inr_UnitPipe.sm.io.ctrDone := risingEdge(x1403_inr_UnitPipe.sm.io.ctrInc)
      x1403_inr_UnitPipe.backpressure := true.B | x1403_inr_UnitPipe.sm.io.doneLatch
      x1403_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x1403_inr_UnitPipe.sm.io.doneLatch
      x1403_inr_UnitPipe.sm.io.enableOut.zip(x1403_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x1403_inr_UnitPipe.sm.io.break := false.B
      x1403_inr_UnitPipe.mask := true.B & b1255 & b560
      x1403_inr_UnitPipe.configure("x1403_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1403_inr_UnitPipe.kernel()
      x1257_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1258_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1259_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1260_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1261_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1262_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1263_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1264_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1265_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1266_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 5)
      x1343_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1344_force_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1404_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1404 **/
