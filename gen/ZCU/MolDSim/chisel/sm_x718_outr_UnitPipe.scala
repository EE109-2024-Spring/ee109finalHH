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

/** Hierarchy: x718 -> x723 -> x724 -> x444 **/
/** BEGIN None x718_outr_UnitPipe **/
class x718_outr_UnitPipe_kernel(
  list_x539_out_sram_0: List[StandardInterface],
  list_x669: List[DecoupledIO[AppCommandDense]],
  list_b675: List[Bool],
  list_b674: List[FixedPoint],
  list_x670: List[DecoupledIO[AppStoreData]],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x718_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x718_outr_UnitPipe_iiCtr"))
  
  abstract class x718_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x670 = Decoupled(new AppStoreData(ModuleParams.getParams("x670_p").asInstanceOf[(Int,Int)] ))
      val in_x669 = Decoupled(new AppCommandDense(ModuleParams.getParams("x669_p").asInstanceOf[(Int,Int)] ))
      val in_b674 = Input(new FixedPoint(true, 32, 0))
      val in_b675 = Input(Bool())
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x539_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x539_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x670 = {io.in_x670} 
    def x669 = {io.in_x669} 
    def b674 = {io.in_b674} 
    def b675 = {io.in_b675} 
    def x470_out_host = {io.in_x470_out_host} 
    def x539_out_sram_0 = {io.in_x539_out_sram_0} ; io.in_x539_out_sram_0 := DontCare
  }
  def connectWires0(module: x718_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x670 <> x670
    module.io.in_x669 <> x669
    module.io.in_b674 <> b674
    module.io.in_b675 <> b675
    module.io.in_x470_out_host <> x470_out_host
    x539_out_sram_0.connectLedger(module.io.in_x539_out_sram_0)
  }
  val x539_out_sram_0 = list_x539_out_sram_0(0)
  val x669 = list_x669(0)
  val b675 = list_b675(0)
  val b674 = list_b674(0)
  val x470_out_host = list_b674(1)
  val x670 = list_x670(0)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x718_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x718_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x718_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val rr = io.rr
      val x676_reg = (new x676_reg).m.io.asInstanceOf[StandardInterface]
      val x677_reg = (new x677_reg).m.io.asInstanceOf[StandardInterface]
      val x678_reg = (new x678_reg).m.io.asInstanceOf[StandardInterface]
      val x698_inr_UnitPipe = new x698_inr_UnitPipe_kernel(List(b674,x470_out_host), List(x669), List(x677_reg,x678_reg,x676_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, rr)
      x698_inr_UnitPipe.sm.io.ctrDone := risingEdge(x698_inr_UnitPipe.sm.io.ctrInc)
      x698_inr_UnitPipe.backpressure := x669.ready | x698_inr_UnitPipe.sm.io.doneLatch
      x698_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x698_inr_UnitPipe.sm.io.doneLatch
      x698_inr_UnitPipe.sm.io.enableOut.zip(x698_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x698_inr_UnitPipe.sm.io.break := false.B
      x698_inr_UnitPipe.mask := true.B & true.B
      x698_inr_UnitPipe.configure("x698_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x698_inr_UnitPipe.kernel()
      val x737_rd_x678 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x737_rd_x678""")
      val x737_rd_x678_banks = List[UInt]()
      val x737_rd_x678_ofs = List[UInt]()
      val x737_rd_x678_en = List[Bool](true.B)
      val x737_rd_x678_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x737_rd_x678_shared_en")
      x737_rd_x678.toSeq.zip(x678_reg.connectRPort(737, x737_rd_x678_banks, x737_rd_x678_ofs, io.sigsIn.backpressure, x737_rd_x678_en.map(_ && x737_rd_x678_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x700_ctr = new CtrObject(Left(Some(0)), Right(x737_rd_x678), Left(Some(1)), 1, 32, false)
      val x701_ctrchain = (new CChainObject(List[CtrObject](x700_ctr), "x701_ctrchain")).cchain.io 
      x701_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x701_ctrchain_p", (x701_ctrchain.par, x701_ctrchain.widths))
      val x717_inr_Foreach = new x717_inr_Foreach_kernel(List(b674), List(x677_reg,x539_out_sram_0,x676_reg), List(x670) ,  Some(me), List(x701_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, rr)
      x717_inr_Foreach.sm.io.ctrDone := (x717_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x717_inr_Foreach.backpressure := x670.ready | x717_inr_Foreach.sm.io.doneLatch
      x717_inr_Foreach.forwardpressure := (true.B) && (true.B) | x717_inr_Foreach.sm.io.doneLatch
      x717_inr_Foreach.sm.io.enableOut.zip(x717_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x717_inr_Foreach.sm.io.break := false.B
      x717_inr_Foreach.mask := ~x717_inr_Foreach.cchain.head.output.noop & true.B
      x717_inr_Foreach.configure("x717_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x717_inr_Foreach.kernel()
    }
    val module = Module(new x718_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    Ledger.exit()
  }
}
/** END UnitPipe x718_outr_UnitPipe **/
