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

/** Hierarchy: x1313 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1313 **/
class x1313_kernel(
  list_b1254: List[Bool],
  list_x1260_tmp_3: List[NBufInterface],
  list_x472_A_sram_1: List[StandardInterface],
  list_x1269_ctrchain: List[CounterChainInterface],
  list_b550: List[FixedPoint],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 2, isFSM = false   , latency = 0.0.toInt, myName = "x1313_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1313_iiCtr"))
  
  abstract class x1313_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1269_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1269_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_x1260_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1260_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_x1265_tmp_3 = Flipped(new NBufInterface(ModuleParams.getParams("x1265_tmp_3_p").asInstanceOf[NBufParams] ))
      val in_b1254 = Input(Bool())
      val in_x1264_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1264_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_b1255 = Input(Bool())
      val in_x1270_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x1270_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x1259_tmp_2 = Flipped(new NBufInterface(ModuleParams.getParams("x1259_tmp_2_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_x1263_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1263_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_x1266_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1266_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b1251 = Input(new FixedPoint(true, 32, 0))
      val in_x1258_tmp_1 = Flipped(new NBufInterface(ModuleParams.getParams("x1258_tmp_1_p").asInstanceOf[NBufParams] ))
      val in_b1252 = Input(new FixedPoint(true, 32, 0))
      val in_x1262_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1262_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1257_tmp_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1257_tmp_0_p").asInstanceOf[NBufParams] ))
      val in_x1261_tmp_4 = Flipped(new NBufInterface(ModuleParams.getParams("x1261_tmp_4_p").asInstanceOf[NBufParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x1269_ctrchain = {io.in_x1269_ctrchain} ; io.in_x1269_ctrchain := DontCare
    def b550 = {io.in_b550} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def x1260_tmp_3 = {io.in_x1260_tmp_3} ; io.in_x1260_tmp_3 := DontCare
    def x1265_tmp_3 = {io.in_x1265_tmp_3} ; io.in_x1265_tmp_3 := DontCare
    def b1254 = {io.in_b1254} 
    def x1264_tmp_2 = {io.in_x1264_tmp_2} ; io.in_x1264_tmp_2 := DontCare
    def b1255 = {io.in_b1255} 
    def x1270_ctrchain = {io.in_x1270_ctrchain} ; io.in_x1270_ctrchain := DontCare
    def x1259_tmp_2 = {io.in_x1259_tmp_2} ; io.in_x1259_tmp_2 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def x1263_tmp_1 = {io.in_x1263_tmp_1} ; io.in_x1263_tmp_1 := DontCare
    def x1266_tmp_4 = {io.in_x1266_tmp_4} ; io.in_x1266_tmp_4 := DontCare
    def b1251 = {io.in_b1251} 
    def x1258_tmp_1 = {io.in_x1258_tmp_1} ; io.in_x1258_tmp_1 := DontCare
    def b1252 = {io.in_b1252} 
    def x1262_tmp_0 = {io.in_x1262_tmp_0} ; io.in_x1262_tmp_0 := DontCare
    def x1257_tmp_0 = {io.in_x1257_tmp_0} ; io.in_x1257_tmp_0 := DontCare
    def x1261_tmp_4 = {io.in_x1261_tmp_4} ; io.in_x1261_tmp_4 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x1313_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x1269_ctrchain.input <> x1269_ctrchain.input; module.io.in_x1269_ctrchain.output <> x1269_ctrchain.output
    module.io.in_b550 <> b550
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    x1260_tmp_3.connectLedger(module.io.in_x1260_tmp_3)
    x1265_tmp_3.connectLedger(module.io.in_x1265_tmp_3)
    module.io.in_b1254 <> b1254
    x1264_tmp_2.connectLedger(module.io.in_x1264_tmp_2)
    module.io.in_b1255 <> b1255
    module.io.in_x1270_ctrchain.input <> x1270_ctrchain.input; module.io.in_x1270_ctrchain.output <> x1270_ctrchain.output
    x1259_tmp_2.connectLedger(module.io.in_x1259_tmp_2)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    x1263_tmp_1.connectLedger(module.io.in_x1263_tmp_1)
    x1266_tmp_4.connectLedger(module.io.in_x1266_tmp_4)
    module.io.in_b1251 <> b1251
    x1258_tmp_1.connectLedger(module.io.in_x1258_tmp_1)
    module.io.in_b1252 <> b1252
    x1262_tmp_0.connectLedger(module.io.in_x1262_tmp_0)
    x1257_tmp_0.connectLedger(module.io.in_x1257_tmp_0)
    x1261_tmp_4.connectLedger(module.io.in_x1261_tmp_4)
    module.io.in_b560 <> b560
  }
  val b1254 = list_b1254(0)
  val b1255 = list_b1254(1)
  val b560 = list_b1254(2)
  val x1260_tmp_3 = list_x1260_tmp_3(0)
  val x1265_tmp_3 = list_x1260_tmp_3(1)
  val x1264_tmp_2 = list_x1260_tmp_3(2)
  val x1259_tmp_2 = list_x1260_tmp_3(3)
  val x1263_tmp_1 = list_x1260_tmp_3(4)
  val x1266_tmp_4 = list_x1260_tmp_3(5)
  val x1258_tmp_1 = list_x1260_tmp_3(6)
  val x1262_tmp_0 = list_x1260_tmp_3(7)
  val x1257_tmp_0 = list_x1260_tmp_3(8)
  val x1261_tmp_4 = list_x1260_tmp_3(9)
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x471_A_sram_0 = list_x472_A_sram_1(1)
  val x1269_ctrchain = list_x1269_ctrchain(0)
  val x1270_ctrchain = list_x1269_ctrchain(1)
  val b550 = list_b550(0)
  val b1251 = list_b550(1)
  val b1252 = list_b550(2)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x1313")
    implicit val stack = ControllerStack.stack.toList
    class x1313_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1313_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1313 = Module(new InstrumentationCounter())
      val iters_x1313 = Module(new InstrumentationCounter())
      cycles_x1313.io.enable := io.sigsIn.baseEn
      iters_x1313.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1313_instrctr, cycles_x1313.io.count, iters_x1313.io.count, 0.U, 0.U)
      val x1291_inr_Foreach = new x1291_inr_Foreach_kernel(List(b1254,b560), List(b550,b1251), List(x1260_tmp_3,x1259_tmp_2,x1258_tmp_1,x1257_tmp_0,x1261_tmp_4), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x1269_ctrchain), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1291_inr_Foreach.sm.io.ctrDone := (x1291_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1291_inr_Foreach.backpressure := true.B | x1291_inr_Foreach.sm.io.doneLatch
      x1291_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1291_inr_Foreach.sm.io.doneLatch
      x1291_inr_Foreach.sm.io.enableOut.zip(x1291_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1291_inr_Foreach.sm.io.break := false.B
      x1291_inr_Foreach.mask := ~x1291_inr_Foreach.cchain.head.output.noop & b1254 & b560
      x1291_inr_Foreach.configure("x1291_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1291_inr_Foreach.kernel()
      val x1312_inr_Foreach = new x1312_inr_Foreach_kernel(List(b1255,b560), List(b550,b1252), List(x1265_tmp_3,x1264_tmp_2,x1263_tmp_1,x1266_tmp_4,x1262_tmp_0), List(x472_A_sram_1,x471_A_sram_0) ,  Some(me), List(x1270_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x1312_inr_Foreach.sm.io.ctrDone := (x1312_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1312_inr_Foreach.backpressure := true.B | x1312_inr_Foreach.sm.io.doneLatch
      x1312_inr_Foreach.forwardpressure := (true.B) && (true.B) | x1312_inr_Foreach.sm.io.doneLatch
      x1312_inr_Foreach.sm.io.enableOut.zip(x1312_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x1312_inr_Foreach.sm.io.break := false.B
      x1312_inr_Foreach.mask := ~x1312_inr_Foreach.cchain.head.output.noop & b1255 & b560
      x1312_inr_Foreach.configure("x1312_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1312_inr_Foreach.kernel()
      x1257_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1258_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1259_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1260_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1261_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1262_tmp_0.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1263_tmp_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1264_tmp_2.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1265_tmp_3.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x1266_tmp_4.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x1313_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x1313 **/
