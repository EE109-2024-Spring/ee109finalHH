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

/** Hierarchy: x2910 -> x2915 -> x2916 -> x444 **/
/** BEGIN None x2910_outr_UnitPipe **/
class x2910_outr_UnitPipe_kernel(
  list_x2860: List[DecoupledIO[AppCommandDense]],
  list_x2861: List[DecoupledIO[AppStoreData]],
  list_b2866: List[Bool],
  list_x544_out_sram_0: List[StandardInterface],
  list_x470_out_host: List[FixedPoint],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(Sequenced, 2, isFSM = false   , latency = 0.0.toInt, myName = "x2910_outr_UnitPipe_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2910_outr_UnitPipe_iiCtr"))
  
  abstract class x2910_outr_UnitPipe_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x2861 = Decoupled(new AppStoreData(ModuleParams.getParams("x2861_p").asInstanceOf[(Int,Int)] ))
      val in_x470_out_host = Input(new FixedPoint(true, 64, 0))
      val in_x544_out_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x544_out_sram_0_p").asInstanceOf[MemParams] ))
      val in_x2860 = Decoupled(new AppCommandDense(ModuleParams.getParams("x2860_p").asInstanceOf[(Int,Int)] ))
      val in_b2865 = Input(new FixedPoint(true, 32, 0))
      val in_b2866 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(2, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(2, 1))
      val rr = Input(Bool())
    })
    def x2861 = {io.in_x2861} 
    def x470_out_host = {io.in_x470_out_host} 
    def x544_out_sram_0 = {io.in_x544_out_sram_0} ; io.in_x544_out_sram_0 := DontCare
    def x2860 = {io.in_x2860} 
    def b2865 = {io.in_b2865} 
    def b2866 = {io.in_b2866} 
  }
  def connectWires0(module: x2910_outr_UnitPipe_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_x2861 <> x2861
    module.io.in_x470_out_host <> x470_out_host
    x544_out_sram_0.connectLedger(module.io.in_x544_out_sram_0)
    module.io.in_x2860 <> x2860
    module.io.in_b2865 <> b2865
    module.io.in_b2866 <> b2866
  }
  val x2860 = list_x2860(0)
  val x2861 = list_x2861(0)
  val b2866 = list_b2866(0)
  val x544_out_sram_0 = list_x544_out_sram_0(0)
  val x470_out_host = list_x470_out_host(0)
  val b2865 = list_x470_out_host(1)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2910_outr_UnitPipe")
    implicit val stack = ControllerStack.stack.toList
    class x2910_outr_UnitPipe_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2910_outr_UnitPipe_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2910_outr_UnitPipe = Module(new InstrumentationCounter())
      val iters_x2910_outr_UnitPipe = Module(new InstrumentationCounter())
      cycles_x2910_outr_UnitPipe.io.enable := io.sigsIn.baseEn
      iters_x2910_outr_UnitPipe.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2910_instrctr, cycles_x2910_outr_UnitPipe.io.count, iters_x2910_outr_UnitPipe.io.count, 0.U, 0.U)
      val x2867_reg = (new x2867_reg).m.io.asInstanceOf[StandardInterface]
      val x2868_reg = (new x2868_reg).m.io.asInstanceOf[StandardInterface]
      val x2869_reg = (new x2869_reg).m.io.asInstanceOf[StandardInterface]
      val x2889_inr_UnitPipe = new x2889_inr_UnitPipe_kernel(List(x470_out_host,b2865), List(x2860), List(x2869_reg,x2868_reg,x2867_reg) ,  Some(me), List(), 0, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2889_inr_UnitPipe.sm.io.ctrDone := risingEdge(x2889_inr_UnitPipe.sm.io.ctrInc)
      x2889_inr_UnitPipe.backpressure := x2860.ready | x2889_inr_UnitPipe.sm.io.doneLatch
      x2889_inr_UnitPipe.forwardpressure := (true.B) && (true.B) | x2889_inr_UnitPipe.sm.io.doneLatch
      x2889_inr_UnitPipe.sm.io.enableOut.zip(x2889_inr_UnitPipe.smEnableOuts).foreach{case (l,r) => r := l}
      x2889_inr_UnitPipe.sm.io.break := false.B
      x2889_inr_UnitPipe.mask := true.B & true.B
      x2889_inr_UnitPipe.configure("x2889_inr_UnitPipe", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2889_inr_UnitPipe.kernel()
      val x2967_rd_x2869 = Wire(new FixedPoint(true, 32, 0)).suggestName("""x2967_rd_x2869""")
      val x2967_rd_x2869_banks = List[UInt]()
      val x2967_rd_x2869_ofs = List[UInt]()
      val x2967_rd_x2869_en = List[Bool](true.B)
      val x2967_rd_x2869_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x2967_rd_x2869_shared_en")
      x2967_rd_x2869.toSeq.zip(x2869_reg.connectRPort(2967, x2967_rd_x2869_banks, x2967_rd_x2869_ofs, io.sigsIn.backpressure, x2967_rd_x2869_en.map(_ && x2967_rd_x2869_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x2891_ctr = new CtrObject(Left(Some(0)), Right(x2967_rd_x2869), Left(Some(1)), 1, 32, false)
      val x2892_ctrchain = (new CChainObject(List[CtrObject](x2891_ctr), "x2892_ctrchain")).cchain.io 
      x2892_ctrchain.setup.isStream := false.B
      ModuleParams.addParams("x2892_ctrchain_p", (x2892_ctrchain.par, x2892_ctrchain.widths))
      val x2909_inr_Foreach = new x2909_inr_Foreach_kernel(List(b2865), List(x2868_reg,x2867_reg,x544_out_sram_0), List(x2861) ,  Some(me), List(x2892_ctrchain), 1, 1, 1, List(1), List(32), breakpoints, instrctrs.toList, rr)
      x2909_inr_Foreach.sm.io.ctrDone := (x2909_inr_Foreach.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2909_inr_Foreach.backpressure := x2861.ready | x2909_inr_Foreach.sm.io.doneLatch
      x2909_inr_Foreach.forwardpressure := (true.B) && (true.B) | x2909_inr_Foreach.sm.io.doneLatch
      x2909_inr_Foreach.sm.io.enableOut.zip(x2909_inr_Foreach.smEnableOuts).foreach{case (l,r) => r := l}
      x2909_inr_Foreach.sm.io.break := false.B
      x2909_inr_Foreach.mask := ~x2909_inr_Foreach.cchain.head.output.noop & true.B
      x2909_inr_Foreach.configure("x2909_inr_Foreach", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2909_inr_Foreach.kernel()
    }
    val module = Module(new x2910_outr_UnitPipe_concrete(sm.p.depth)); module.io := DontCare
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
/** END UnitPipe x2910_outr_UnitPipe **/
