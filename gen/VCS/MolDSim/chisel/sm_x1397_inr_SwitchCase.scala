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

/** Hierarchy: x1397 -> x1399 -> x1458 -> x2707 -> x2859 -> x444 **/
/** BEGIN None x1397_inr_SwitchCase **/
class x1397_inr_SwitchCase_kernel(
  list_x1315_r_0: List[NBufInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new InnerControl(Sequenced, false   , latency = 103.0.toInt, myName = "x1397_inr_SwitchCase_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x1397_inr_SwitchCase_iiCtr"))
  
  abstract class x1397_inr_SwitchCase_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_x1315_r_0 = Flipped(new NBufInterface(ModuleParams.getParams("x1315_r_0_p").asInstanceOf[NBufParams] ))
      val in_x1346_reg = Flipped(new NBufInterface(ModuleParams.getParams("x1346_reg_p").asInstanceOf[NBufParams] ))
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(1, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(1, 1))
      val rr = Input(Bool())
      val ret = Output(new FixedPoint(true, 10, 22))
    })
    def x1315_r_0 = {io.in_x1315_r_0} ; io.in_x1315_r_0 := DontCare
    def x1346_reg = {io.in_x1346_reg} ; io.in_x1346_reg := DontCare
  }
  def connectWires0(module: x1397_inr_SwitchCase_module)(implicit stack: List[KernelHash]): Unit = {
    x1315_r_0.connectLedger(module.io.in_x1315_r_0)
    x1346_reg.connectLedger(module.io.in_x1346_reg)
  }
  val x1315_r_0 = list_x1315_r_0(0)
  val x1346_reg = list_x1315_r_0(1)
  def kernel(): FixedPoint = {
    Ledger.enter(this.hashCode, "x1397_inr_SwitchCase_obj")
    implicit val stack = ControllerStack.stack.toList
    class x1397_inr_SwitchCase_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x1397_inr_SwitchCase_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x1397_inr_SwitchCase = Module(new InstrumentationCounter())
      val iters_x1397_inr_SwitchCase = Module(new InstrumentationCounter())
      cycles_x1397_inr_SwitchCase.io.enable := io.sigsIn.baseEn
      iters_x1397_inr_SwitchCase.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X1397_instrctr, cycles_x1397_inr_SwitchCase.io.count, iters_x1397_inr_SwitchCase.io.count, 0.U, 0.U)
      // Controller Stack: Stack(x1399, x1458, x2707, x2859, x444)
      val x1386_rd_x1346 = Wire(Bool()).suggestName("""x1386_rd_x1346""")
      val x1386_rd_x1346_banks = List[UInt]()
      val x1386_rd_x1346_ofs = List[UInt]()
      val x1386_rd_x1346_en = List[Bool](true.B)
      val x1386_rd_x1346_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && true.B ).suggestName("x1386_rd_x1346_shared_en")
      x1386_rd_x1346.toSeq.zip(x1346_reg.connectRPort(1386, x1386_rd_x1346_banks, x1386_rd_x1346_ofs, io.sigsIn.backpressure, x1386_rd_x1346_en.map(_ && x1386_rd_x1346_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      val x1387_rd = Wire(Vec(1, new FixedPoint(true, 10, 22))).suggestName("""x1387_rd""")
      val x1387_rd_banks = List[UInt](0L.FP(true, 32, 0).r)
      val x1387_rd_ofs = List[UInt](0L.FP(true, 32, 0).r)
      val x1387_rd_en = List[Bool](true.B)
      val x1387_rd_shared_en = ((io.sigsIn.forwardpressure).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && ~io.sigsIn.break && (io.sigsIn.datapathEn & io.sigsIn.iiIssue).DS(0.0.toInt, rr, io.sigsIn.backpressure & true.B) && x1386_rd_x1346 ).suggestName("x1387_rd_shared_en")
      x1387_rd.toSeq.zip(x1315_r_0.connectRPort(1387, x1387_rd_banks, x1387_rd_ofs, io.sigsIn.backpressure, x1387_rd_en.map(_ && x1387_rd_shared_en), true)).foreach{case (a,b) => a.r := b.r}
      // x1388 = VecApply(x1387,0)
      val x1388_elem_0 = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1388_elem_0""")
      x1388_elem_0.r := x1387_rd(0).r
      val x1389_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1389_div""")
      x1389_div.r := (Math.div(100.FP(true, 10, 22), x1388_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1389_div")).r
      val x3359 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3359_x1388_elem_0_D20") 
      x3359.r := getRetimed(x1388_elem_0.r, 20.toInt, io.sigsIn.backpressure & true.B)
      val x1390_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1390_div""")
      x1390_div.r := (Math.div(x1389_div, x3359, Some(20.0), true.B, Truncate, Wrapping, "x1390_div")).r
      val x3360 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3360_x1388_elem_0_D40") 
      x3360.r := getRetimed(x1388_elem_0.r, 40.toInt, io.sigsIn.backpressure & true.B)
      val x1391_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1391_div""")
      x1391_div.r := (Math.div(x1390_div, x3360, Some(20.0), true.B, Truncate, Wrapping, "x1391_div")).r
      val x3361 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3361_x1388_elem_0_D60") 
      x3361.r := getRetimed(x1388_elem_0.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1392_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1392_div""")
      x1392_div.r := (Math.div(x1391_div, x3361, Some(20.0), true.B, Truncate, Wrapping, "x1392_div")).r
      val x3362 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3362_x1388_elem_0_D80") 
      x3362.r := getRetimed(x1388_elem_0.r, 80.toInt, io.sigsIn.backpressure & true.B)
      val x1393_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1393_div""")
      x1393_div.r := (Math.div(x1392_div, x3362, Some(20.0), true.B, Truncate, Wrapping, "x1393_div")).r
      val x1394_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1394_div""")
      x1394_div.r := (Math.div(10.FP(true, 10, 22), x1388_elem_0, Some(20.0), true.B, Truncate, Wrapping, "x1394_div")).r
      val x1395_div = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1395_div""")
      x1395_div.r := (Math.div(x1394_div, x3359, Some(20.0), true.B, Truncate, Wrapping, "x1395_div")).r
      val x3363 = Wire(new FixedPoint(true, 10, 22)).suggestName("x3363_x1395_div_D60") 
      x3363.r := getRetimed(x1395_div.r, 60.toInt, io.sigsIn.backpressure & true.B)
      val x1396_sub = Wire(new FixedPoint(true, 10, 22)).suggestName("""x1396_sub""")
      x1396_sub.r := Math.sub(x1393_div,x3363,Some(1.0), true.B, Truncate, Wrapping, "x1396_sub").r
      io.ret.r := x1396_sub.r
    }
    val module = Module(new x1397_inr_SwitchCase_concrete(sm.p.depth)); module.io := DontCare
    // Connect ports on this kernel to its parent
    connectWires0(module)
    Ledger.connectInstrCtrs(instrctrs, module.io.in_instrctrs)
    Ledger.connectBreakpoints(breakpoints, module.io.in_breakpoints)
    module.io.rr := rr
    module.io.sigsIn := me.sigsIn
    me.sigsOut := module.io.sigsOut
    val ret = module.io.ret
    Ledger.exit()
    ret
  }
}
/** END SwitchCase x1397_inr_SwitchCase **/
