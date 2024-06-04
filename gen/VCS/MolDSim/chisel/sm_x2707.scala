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

/** Hierarchy: x2707 -> x2859 -> x444 **/
/** BEGIN None x2707 **/
class x2707_kernel(
  list_x472_A_sram_1: List[StandardInterface],
  list_x582_accum_1: List[NBufInterface],
  list_b565: List[Bool],
  list_b555: List[FixedPoint],
  list_x597_ctrchain: List[CounterChainInterface],
   parent: Option[Kernel], cchain: List[CounterChainInterface], childId: Int, nMyChildren: Int, ctrcopies: Int, ctrPars: List[Int], ctrWidths: List[Int], breakpoints: Vec[Bool], instrctrs: List[InstrCtr], rr: Bool
) extends Kernel(parent, cchain, childId, nMyChildren, ctrcopies, ctrPars, ctrWidths) {
  
  val me = this
  val sm = Module(new OuterControl(ForkJoin, 10, isFSM = false   , latency = 0.0.toInt, myName = "x2707_sm")); sm.io <> DontCare
  val iiCtr = Module(new IICounter(1.0.toInt, 2 + _root_.utils.math.log2Up(1.0.toInt), "x2707_iiCtr"))
  
  abstract class x2707_module(depth: Int)(implicit stack: List[KernelHash]) extends Module {
    val io = IO(new Bundle {
      val in_b555 = Input(new FixedPoint(true, 32, 0))
      val in_x582_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x582_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x597_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x597_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b550 = Input(new FixedPoint(true, 32, 0))
      val in_x472_A_sram_1 = Flipped(new StandardInterface(ModuleParams.getParams("x472_A_sram_1_p").asInstanceOf[MemParams] ))
      val in_b565 = Input(Bool())
      val in_x570_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x570_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x619_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x619_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b559 = Input(Bool())
      val in_x606_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x606_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x623_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x623_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x574_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x574_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x602_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x602_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x598_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x598_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b561 = Input(Bool())
      val in_b566 = Input(Bool())
      val in_x625_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x625_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x583_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x583_accum_0_p").asInstanceOf[MemParams] ))
      val in_b551 = Input(new FixedPoint(true, 32, 0))
      val in_x578_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x578_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x471_A_sram_0 = Flipped(new StandardInterface(ModuleParams.getParams("x471_A_sram_0_p").asInstanceOf[MemParams] ))
      val in_b554 = Input(new FixedPoint(true, 32, 0))
      val in_b547 = Input(new FixedPoint(true, 32, 0))
      val in_x622_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x622_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x569_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x569_accum_0_p").asInstanceOf[MemParams] ))
      val in_x605_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x605_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b558 = Input(Bool())
      val in_x586_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x586_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x618_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x618_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x573_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x573_accum_0_p").asInstanceOf[MemParams] ))
      val in_x601_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x601_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x584_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x584_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b562 = Input(Bool())
      val in_x577_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x577_accum_0_p").asInstanceOf[MemParams] ))
      val in_x579_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x579_accum_0_p").asInstanceOf[MemParams] ))
      val in_x572_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x572_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x604_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x604_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x567_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x567_accum_0_p").asInstanceOf[MemParams] ))
      val in_x599_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x599_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b552 = Input(new FixedPoint(true, 32, 0))
      val in_x621_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x621_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x626_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x626_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b563 = Input(Bool())
      val in_b548 = Input(new FixedPoint(true, 32, 0))
      val in_x617_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x617_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b553 = Input(new FixedPoint(true, 32, 0))
      val in_b557 = Input(Bool())
      val in_x580_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x580_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x585_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x585_accum_0_p").asInstanceOf[MemParams] ))
      val in_x576_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x576_accum_1_p").asInstanceOf[NBufParams] ))
      val in_x600_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x600_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x571_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x571_accum_0_p").asInstanceOf[MemParams] ))
      val in_b556 = Input(new FixedPoint(true, 32, 0))
      val in_x581_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x581_accum_0_p").asInstanceOf[MemParams] ))
      val in_x568_accum_1 = Flipped(new NBufInterface(ModuleParams.getParams("x568_accum_1_p").asInstanceOf[NBufParams] ))
      val in_b549 = Input(new FixedPoint(true, 32, 0))
      val in_x620_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x620_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x603_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x603_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_b564 = Input(Bool())
      val in_x624_ctrchain = Flipped(new CounterChainInterface(ModuleParams.getParams("x624_ctrchain_p").asInstanceOf[(List[Int],List[Int])] ))
      val in_x575_accum_0 = Flipped(new StandardInterface(ModuleParams.getParams("x575_accum_0_p").asInstanceOf[MemParams] ))
      val in_b560 = Input(Bool())
      val in_instrctrs = Vec(api.numCtrls, Output(new InstrCtr()))
      val in_breakpoints = Vec(api.numArgOuts_breakpts, Output(Bool()))
      val sigsIn = Input(new InputKernelSignals(10, 1, List(1), List(32)))
      val sigsOut = Output(new OutputKernelSignals(10, 1))
      val rr = Input(Bool())
    })
    def b555 = {io.in_b555} 
    def x582_accum_1 = {io.in_x582_accum_1} ; io.in_x582_accum_1 := DontCare
    def x597_ctrchain = {io.in_x597_ctrchain} ; io.in_x597_ctrchain := DontCare
    def b550 = {io.in_b550} 
    def x472_A_sram_1 = {io.in_x472_A_sram_1} ; io.in_x472_A_sram_1 := DontCare
    def b565 = {io.in_b565} 
    def x570_accum_1 = {io.in_x570_accum_1} ; io.in_x570_accum_1 := DontCare
    def x619_ctrchain = {io.in_x619_ctrchain} ; io.in_x619_ctrchain := DontCare
    def b559 = {io.in_b559} 
    def x606_ctrchain = {io.in_x606_ctrchain} ; io.in_x606_ctrchain := DontCare
    def x623_ctrchain = {io.in_x623_ctrchain} ; io.in_x623_ctrchain := DontCare
    def x574_accum_1 = {io.in_x574_accum_1} ; io.in_x574_accum_1 := DontCare
    def x602_ctrchain = {io.in_x602_ctrchain} ; io.in_x602_ctrchain := DontCare
    def x598_ctrchain = {io.in_x598_ctrchain} ; io.in_x598_ctrchain := DontCare
    def b561 = {io.in_b561} 
    def b566 = {io.in_b566} 
    def x625_ctrchain = {io.in_x625_ctrchain} ; io.in_x625_ctrchain := DontCare
    def x583_accum_0 = {io.in_x583_accum_0} ; io.in_x583_accum_0 := DontCare
    def b551 = {io.in_b551} 
    def x578_accum_1 = {io.in_x578_accum_1} ; io.in_x578_accum_1 := DontCare
    def x471_A_sram_0 = {io.in_x471_A_sram_0} ; io.in_x471_A_sram_0 := DontCare
    def b554 = {io.in_b554} 
    def b547 = {io.in_b547} 
    def x622_ctrchain = {io.in_x622_ctrchain} ; io.in_x622_ctrchain := DontCare
    def x569_accum_0 = {io.in_x569_accum_0} ; io.in_x569_accum_0 := DontCare
    def x605_ctrchain = {io.in_x605_ctrchain} ; io.in_x605_ctrchain := DontCare
    def b558 = {io.in_b558} 
    def x586_accum_1 = {io.in_x586_accum_1} ; io.in_x586_accum_1 := DontCare
    def x618_ctrchain = {io.in_x618_ctrchain} ; io.in_x618_ctrchain := DontCare
    def x573_accum_0 = {io.in_x573_accum_0} ; io.in_x573_accum_0 := DontCare
    def x601_ctrchain = {io.in_x601_ctrchain} ; io.in_x601_ctrchain := DontCare
    def x584_accum_1 = {io.in_x584_accum_1} ; io.in_x584_accum_1 := DontCare
    def b562 = {io.in_b562} 
    def x577_accum_0 = {io.in_x577_accum_0} ; io.in_x577_accum_0 := DontCare
    def x579_accum_0 = {io.in_x579_accum_0} ; io.in_x579_accum_0 := DontCare
    def x572_accum_1 = {io.in_x572_accum_1} ; io.in_x572_accum_1 := DontCare
    def x604_ctrchain = {io.in_x604_ctrchain} ; io.in_x604_ctrchain := DontCare
    def x567_accum_0 = {io.in_x567_accum_0} ; io.in_x567_accum_0 := DontCare
    def x599_ctrchain = {io.in_x599_ctrchain} ; io.in_x599_ctrchain := DontCare
    def b552 = {io.in_b552} 
    def x621_ctrchain = {io.in_x621_ctrchain} ; io.in_x621_ctrchain := DontCare
    def x626_ctrchain = {io.in_x626_ctrchain} ; io.in_x626_ctrchain := DontCare
    def b563 = {io.in_b563} 
    def b548 = {io.in_b548} 
    def x617_ctrchain = {io.in_x617_ctrchain} ; io.in_x617_ctrchain := DontCare
    def b553 = {io.in_b553} 
    def b557 = {io.in_b557} 
    def x580_accum_1 = {io.in_x580_accum_1} ; io.in_x580_accum_1 := DontCare
    def x585_accum_0 = {io.in_x585_accum_0} ; io.in_x585_accum_0 := DontCare
    def x576_accum_1 = {io.in_x576_accum_1} ; io.in_x576_accum_1 := DontCare
    def x600_ctrchain = {io.in_x600_ctrchain} ; io.in_x600_ctrchain := DontCare
    def x571_accum_0 = {io.in_x571_accum_0} ; io.in_x571_accum_0 := DontCare
    def b556 = {io.in_b556} 
    def x581_accum_0 = {io.in_x581_accum_0} ; io.in_x581_accum_0 := DontCare
    def x568_accum_1 = {io.in_x568_accum_1} ; io.in_x568_accum_1 := DontCare
    def b549 = {io.in_b549} 
    def x620_ctrchain = {io.in_x620_ctrchain} ; io.in_x620_ctrchain := DontCare
    def x603_ctrchain = {io.in_x603_ctrchain} ; io.in_x603_ctrchain := DontCare
    def b564 = {io.in_b564} 
    def x624_ctrchain = {io.in_x624_ctrchain} ; io.in_x624_ctrchain := DontCare
    def x575_accum_0 = {io.in_x575_accum_0} ; io.in_x575_accum_0 := DontCare
    def b560 = {io.in_b560} 
  }
  def connectWires0(module: x2707_module)(implicit stack: List[KernelHash]): Unit = {
    module.io.in_b555 <> b555
    x582_accum_1.connectLedger(module.io.in_x582_accum_1)
    module.io.in_x597_ctrchain.input <> x597_ctrchain.input; module.io.in_x597_ctrchain.output <> x597_ctrchain.output
    module.io.in_b550 <> b550
    x472_A_sram_1.connectLedger(module.io.in_x472_A_sram_1)
    module.io.in_b565 <> b565
    x570_accum_1.connectLedger(module.io.in_x570_accum_1)
    module.io.in_x619_ctrchain.input <> x619_ctrchain.input; module.io.in_x619_ctrchain.output <> x619_ctrchain.output
    module.io.in_b559 <> b559
    module.io.in_x606_ctrchain.input <> x606_ctrchain.input; module.io.in_x606_ctrchain.output <> x606_ctrchain.output
    module.io.in_x623_ctrchain.input <> x623_ctrchain.input; module.io.in_x623_ctrchain.output <> x623_ctrchain.output
    x574_accum_1.connectLedger(module.io.in_x574_accum_1)
    module.io.in_x602_ctrchain.input <> x602_ctrchain.input; module.io.in_x602_ctrchain.output <> x602_ctrchain.output
    module.io.in_x598_ctrchain.input <> x598_ctrchain.input; module.io.in_x598_ctrchain.output <> x598_ctrchain.output
    module.io.in_b561 <> b561
    module.io.in_b566 <> b566
    module.io.in_x625_ctrchain.input <> x625_ctrchain.input; module.io.in_x625_ctrchain.output <> x625_ctrchain.output
    x583_accum_0.connectLedger(module.io.in_x583_accum_0)
    module.io.in_b551 <> b551
    x578_accum_1.connectLedger(module.io.in_x578_accum_1)
    x471_A_sram_0.connectLedger(module.io.in_x471_A_sram_0)
    module.io.in_b554 <> b554
    module.io.in_b547 <> b547
    module.io.in_x622_ctrchain.input <> x622_ctrchain.input; module.io.in_x622_ctrchain.output <> x622_ctrchain.output
    x569_accum_0.connectLedger(module.io.in_x569_accum_0)
    module.io.in_x605_ctrchain.input <> x605_ctrchain.input; module.io.in_x605_ctrchain.output <> x605_ctrchain.output
    module.io.in_b558 <> b558
    x586_accum_1.connectLedger(module.io.in_x586_accum_1)
    module.io.in_x618_ctrchain.input <> x618_ctrchain.input; module.io.in_x618_ctrchain.output <> x618_ctrchain.output
    x573_accum_0.connectLedger(module.io.in_x573_accum_0)
    module.io.in_x601_ctrchain.input <> x601_ctrchain.input; module.io.in_x601_ctrchain.output <> x601_ctrchain.output
    x584_accum_1.connectLedger(module.io.in_x584_accum_1)
    module.io.in_b562 <> b562
    x577_accum_0.connectLedger(module.io.in_x577_accum_0)
    x579_accum_0.connectLedger(module.io.in_x579_accum_0)
    x572_accum_1.connectLedger(module.io.in_x572_accum_1)
    module.io.in_x604_ctrchain.input <> x604_ctrchain.input; module.io.in_x604_ctrchain.output <> x604_ctrchain.output
    x567_accum_0.connectLedger(module.io.in_x567_accum_0)
    module.io.in_x599_ctrchain.input <> x599_ctrchain.input; module.io.in_x599_ctrchain.output <> x599_ctrchain.output
    module.io.in_b552 <> b552
    module.io.in_x621_ctrchain.input <> x621_ctrchain.input; module.io.in_x621_ctrchain.output <> x621_ctrchain.output
    module.io.in_x626_ctrchain.input <> x626_ctrchain.input; module.io.in_x626_ctrchain.output <> x626_ctrchain.output
    module.io.in_b563 <> b563
    module.io.in_b548 <> b548
    module.io.in_x617_ctrchain.input <> x617_ctrchain.input; module.io.in_x617_ctrchain.output <> x617_ctrchain.output
    module.io.in_b553 <> b553
    module.io.in_b557 <> b557
    x580_accum_1.connectLedger(module.io.in_x580_accum_1)
    x585_accum_0.connectLedger(module.io.in_x585_accum_0)
    x576_accum_1.connectLedger(module.io.in_x576_accum_1)
    module.io.in_x600_ctrchain.input <> x600_ctrchain.input; module.io.in_x600_ctrchain.output <> x600_ctrchain.output
    x571_accum_0.connectLedger(module.io.in_x571_accum_0)
    module.io.in_b556 <> b556
    x581_accum_0.connectLedger(module.io.in_x581_accum_0)
    x568_accum_1.connectLedger(module.io.in_x568_accum_1)
    module.io.in_b549 <> b549
    module.io.in_x620_ctrchain.input <> x620_ctrchain.input; module.io.in_x620_ctrchain.output <> x620_ctrchain.output
    module.io.in_x603_ctrchain.input <> x603_ctrchain.input; module.io.in_x603_ctrchain.output <> x603_ctrchain.output
    module.io.in_b564 <> b564
    module.io.in_x624_ctrchain.input <> x624_ctrchain.input; module.io.in_x624_ctrchain.output <> x624_ctrchain.output
    x575_accum_0.connectLedger(module.io.in_x575_accum_0)
    module.io.in_b560 <> b560
  }
  val x472_A_sram_1 = list_x472_A_sram_1(0)
  val x583_accum_0 = list_x472_A_sram_1(1)
  val x471_A_sram_0 = list_x472_A_sram_1(2)
  val x569_accum_0 = list_x472_A_sram_1(3)
  val x573_accum_0 = list_x472_A_sram_1(4)
  val x577_accum_0 = list_x472_A_sram_1(5)
  val x579_accum_0 = list_x472_A_sram_1(6)
  val x567_accum_0 = list_x472_A_sram_1(7)
  val x585_accum_0 = list_x472_A_sram_1(8)
  val x571_accum_0 = list_x472_A_sram_1(9)
  val x581_accum_0 = list_x472_A_sram_1(10)
  val x575_accum_0 = list_x472_A_sram_1(11)
  val x582_accum_1 = list_x582_accum_1(0)
  val x570_accum_1 = list_x582_accum_1(1)
  val x574_accum_1 = list_x582_accum_1(2)
  val x578_accum_1 = list_x582_accum_1(3)
  val x586_accum_1 = list_x582_accum_1(4)
  val x584_accum_1 = list_x582_accum_1(5)
  val x572_accum_1 = list_x582_accum_1(6)
  val x580_accum_1 = list_x582_accum_1(7)
  val x576_accum_1 = list_x582_accum_1(8)
  val x568_accum_1 = list_x582_accum_1(9)
  val b565 = list_b565(0)
  val b559 = list_b565(1)
  val b561 = list_b565(2)
  val b566 = list_b565(3)
  val b558 = list_b565(4)
  val b562 = list_b565(5)
  val b563 = list_b565(6)
  val b557 = list_b565(7)
  val b564 = list_b565(8)
  val b560 = list_b565(9)
  val b555 = list_b555(0)
  val b550 = list_b555(1)
  val b551 = list_b555(2)
  val b554 = list_b555(3)
  val b547 = list_b555(4)
  val b552 = list_b555(5)
  val b548 = list_b555(6)
  val b553 = list_b555(7)
  val b556 = list_b555(8)
  val b549 = list_b555(9)
  val x597_ctrchain = list_x597_ctrchain(0)
  val x619_ctrchain = list_x597_ctrchain(1)
  val x606_ctrchain = list_x597_ctrchain(2)
  val x623_ctrchain = list_x597_ctrchain(3)
  val x602_ctrchain = list_x597_ctrchain(4)
  val x598_ctrchain = list_x597_ctrchain(5)
  val x625_ctrchain = list_x597_ctrchain(6)
  val x622_ctrchain = list_x597_ctrchain(7)
  val x605_ctrchain = list_x597_ctrchain(8)
  val x618_ctrchain = list_x597_ctrchain(9)
  val x601_ctrchain = list_x597_ctrchain(10)
  val x604_ctrchain = list_x597_ctrchain(11)
  val x599_ctrchain = list_x597_ctrchain(12)
  val x621_ctrchain = list_x597_ctrchain(13)
  val x626_ctrchain = list_x597_ctrchain(14)
  val x617_ctrchain = list_x597_ctrchain(15)
  val x600_ctrchain = list_x597_ctrchain(16)
  val x620_ctrchain = list_x597_ctrchain(17)
  val x603_ctrchain = list_x597_ctrchain(18)
  val x624_ctrchain = list_x597_ctrchain(19)
  def kernel(): Unit = {
    Ledger.enter(this.hashCode, "x2707")
    implicit val stack = ControllerStack.stack.toList
    class x2707_concrete(depth: Int)(implicit stack: List[KernelHash]) extends x2707_module(depth) {
      io.sigsOut := DontCare
      val breakpoints = io.in_breakpoints; breakpoints := DontCare
      val instrctrs = io.in_instrctrs; instrctrs := DontCare
      val rr = io.rr
      val cycles_x2707 = Module(new InstrumentationCounter())
      val iters_x2707 = Module(new InstrumentationCounter())
      cycles_x2707.io.enable := io.sigsIn.baseEn
      iters_x2707.io.enable := risingEdge(io.sigsIn.done)
      Ledger.tieInstrCtr(instrctrs.toList, X2707_instrctr, cycles_x2707.io.count, iters_x2707.io.count, 0.U, 0.U)
      val x834_outr_Reduce = new x834_outr_Reduce_kernel(List(b547), List(b557), List(x472_A_sram_1,x471_A_sram_0,x567_accum_0), List(x617_ctrchain), List(x568_accum_1) ,  Some(me), List(x597_ctrchain), 0, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x834_outr_Reduce.sm.io.ctrDone := (x834_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x834_outr_Reduce.backpressure := true.B | x834_outr_Reduce.sm.io.doneLatch
      x834_outr_Reduce.forwardpressure := (true.B) && (true.B) | x834_outr_Reduce.sm.io.doneLatch
      x834_outr_Reduce.sm.io.enableOut.zip(x834_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x834_outr_Reduce.sm.io.break := false.B
      x834_outr_Reduce.mask := ~x834_outr_Reduce.cchain.head.output.noop & b557
      x834_outr_Reduce.configure("x834_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x834_outr_Reduce.kernel()
      val x1042_outr_Reduce = new x1042_outr_Reduce_kernel(List(x618_ctrchain), List(b548), List(x570_accum_1), List(x472_A_sram_1,x471_A_sram_0,x569_accum_0), List(b558) ,  Some(me), List(x598_ctrchain), 1, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x1042_outr_Reduce.sm.io.ctrDone := (x1042_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1042_outr_Reduce.backpressure := true.B | x1042_outr_Reduce.sm.io.doneLatch
      x1042_outr_Reduce.forwardpressure := (true.B) && (true.B) | x1042_outr_Reduce.sm.io.doneLatch
      x1042_outr_Reduce.sm.io.enableOut.zip(x1042_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x1042_outr_Reduce.sm.io.break := false.B
      x1042_outr_Reduce.mask := ~x1042_outr_Reduce.cchain.head.output.noop & b558
      x1042_outr_Reduce.configure("x1042_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1042_outr_Reduce.kernel()
      val x1250_outr_Reduce = new x1250_outr_Reduce_kernel(List(b559), List(x472_A_sram_1,x471_A_sram_0,x571_accum_0), List(x572_accum_1), List(x619_ctrchain), List(b549) ,  Some(me), List(x599_ctrchain), 2, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x1250_outr_Reduce.sm.io.ctrDone := (x1250_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1250_outr_Reduce.backpressure := true.B | x1250_outr_Reduce.sm.io.doneLatch
      x1250_outr_Reduce.forwardpressure := (true.B) && (true.B) | x1250_outr_Reduce.sm.io.doneLatch
      x1250_outr_Reduce.sm.io.enableOut.zip(x1250_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x1250_outr_Reduce.sm.io.break := false.B
      x1250_outr_Reduce.mask := ~x1250_outr_Reduce.cchain.head.output.noop & b559
      x1250_outr_Reduce.configure("x1250_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1250_outr_Reduce.kernel()
      val x1458_outr_Reduce = new x1458_outr_Reduce_kernel(List(x574_accum_1), List(b560), List(x620_ctrchain), List(x472_A_sram_1,x471_A_sram_0,x573_accum_0), List(b550) ,  Some(me), List(x600_ctrchain), 3, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x1458_outr_Reduce.sm.io.ctrDone := (x1458_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1458_outr_Reduce.backpressure := true.B | x1458_outr_Reduce.sm.io.doneLatch
      x1458_outr_Reduce.forwardpressure := (true.B) && (true.B) | x1458_outr_Reduce.sm.io.doneLatch
      x1458_outr_Reduce.sm.io.enableOut.zip(x1458_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x1458_outr_Reduce.sm.io.break := false.B
      x1458_outr_Reduce.mask := ~x1458_outr_Reduce.cchain.head.output.noop & b560
      x1458_outr_Reduce.configure("x1458_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1458_outr_Reduce.kernel()
      val x1666_outr_Reduce = new x1666_outr_Reduce_kernel(List(x621_ctrchain), List(b561), List(b551), List(x576_accum_1), List(x472_A_sram_1,x471_A_sram_0,x575_accum_0) ,  Some(me), List(x601_ctrchain), 4, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x1666_outr_Reduce.sm.io.ctrDone := (x1666_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1666_outr_Reduce.backpressure := true.B | x1666_outr_Reduce.sm.io.doneLatch
      x1666_outr_Reduce.forwardpressure := (true.B) && (true.B) | x1666_outr_Reduce.sm.io.doneLatch
      x1666_outr_Reduce.sm.io.enableOut.zip(x1666_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x1666_outr_Reduce.sm.io.break := false.B
      x1666_outr_Reduce.mask := ~x1666_outr_Reduce.cchain.head.output.noop & b561
      x1666_outr_Reduce.configure("x1666_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1666_outr_Reduce.kernel()
      val x1874_outr_Reduce = new x1874_outr_Reduce_kernel(List(x622_ctrchain), List(b552), List(x472_A_sram_1,x471_A_sram_0,x577_accum_0), List(x578_accum_1), List(b562) ,  Some(me), List(x602_ctrchain), 5, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x1874_outr_Reduce.sm.io.ctrDone := (x1874_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x1874_outr_Reduce.backpressure := true.B | x1874_outr_Reduce.sm.io.doneLatch
      x1874_outr_Reduce.forwardpressure := (true.B) && (true.B) | x1874_outr_Reduce.sm.io.doneLatch
      x1874_outr_Reduce.sm.io.enableOut.zip(x1874_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x1874_outr_Reduce.sm.io.break := false.B
      x1874_outr_Reduce.mask := ~x1874_outr_Reduce.cchain.head.output.noop & b562
      x1874_outr_Reduce.configure("x1874_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x1874_outr_Reduce.kernel()
      val x2082_outr_Reduce = new x2082_outr_Reduce_kernel(List(x580_accum_1), List(b563), List(x472_A_sram_1,x471_A_sram_0,x579_accum_0), List(x623_ctrchain), List(b553) ,  Some(me), List(x603_ctrchain), 6, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x2082_outr_Reduce.sm.io.ctrDone := (x2082_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2082_outr_Reduce.backpressure := true.B | x2082_outr_Reduce.sm.io.doneLatch
      x2082_outr_Reduce.forwardpressure := (true.B) && (true.B) | x2082_outr_Reduce.sm.io.doneLatch
      x2082_outr_Reduce.sm.io.enableOut.zip(x2082_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x2082_outr_Reduce.sm.io.break := false.B
      x2082_outr_Reduce.mask := ~x2082_outr_Reduce.cchain.head.output.noop & b563
      x2082_outr_Reduce.configure("x2082_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2082_outr_Reduce.kernel()
      val x2290_outr_Reduce = new x2290_outr_Reduce_kernel(List(x624_ctrchain), List(b554), List(x472_A_sram_1,x471_A_sram_0,x581_accum_0), List(x582_accum_1), List(b564) ,  Some(me), List(x604_ctrchain), 7, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x2290_outr_Reduce.sm.io.ctrDone := (x2290_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2290_outr_Reduce.backpressure := true.B | x2290_outr_Reduce.sm.io.doneLatch
      x2290_outr_Reduce.forwardpressure := (true.B) && (true.B) | x2290_outr_Reduce.sm.io.doneLatch
      x2290_outr_Reduce.sm.io.enableOut.zip(x2290_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x2290_outr_Reduce.sm.io.break := false.B
      x2290_outr_Reduce.mask := ~x2290_outr_Reduce.cchain.head.output.noop & b564
      x2290_outr_Reduce.configure("x2290_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2290_outr_Reduce.kernel()
      val x2498_outr_Reduce = new x2498_outr_Reduce_kernel(List(x584_accum_1), List(x472_A_sram_1,x583_accum_0,x471_A_sram_0), List(b565), List(b555), List(x625_ctrchain) ,  Some(me), List(x605_ctrchain), 8, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x2498_outr_Reduce.sm.io.ctrDone := (x2498_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2498_outr_Reduce.backpressure := true.B | x2498_outr_Reduce.sm.io.doneLatch
      x2498_outr_Reduce.forwardpressure := (true.B) && (true.B) | x2498_outr_Reduce.sm.io.doneLatch
      x2498_outr_Reduce.sm.io.enableOut.zip(x2498_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x2498_outr_Reduce.sm.io.break := false.B
      x2498_outr_Reduce.mask := ~x2498_outr_Reduce.cchain.head.output.noop & b565
      x2498_outr_Reduce.configure("x2498_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2498_outr_Reduce.kernel()
      val x2706_outr_Reduce = new x2706_outr_Reduce_kernel(List(x472_A_sram_1,x471_A_sram_0,x585_accum_0), List(b556), List(x586_accum_1), List(b566), List(x626_ctrchain) ,  Some(me), List(x606_ctrchain), 9, 8, 1, List(2), List(32), breakpoints, instrctrs.toList, rr)
      x2706_outr_Reduce.sm.io.ctrDone := (x2706_outr_Reduce.cchain.head.output.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B)
      x2706_outr_Reduce.backpressure := true.B | x2706_outr_Reduce.sm.io.doneLatch
      x2706_outr_Reduce.forwardpressure := (true.B) && (true.B) | x2706_outr_Reduce.sm.io.doneLatch
      x2706_outr_Reduce.sm.io.enableOut.zip(x2706_outr_Reduce.smEnableOuts).foreach{case (l,r) => r := l}
      x2706_outr_Reduce.sm.io.break := false.B
      x2706_outr_Reduce.mask := ~x2706_outr_Reduce.cchain.head.output.noop & b566
      x2706_outr_Reduce.configure("x2706_outr_Reduce", Some(io.sigsIn), Some(io.sigsOut), isSwitchCase = false)
      x2706_outr_Reduce.kernel()
      x568_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x570_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x572_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x574_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x576_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x578_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x580_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x582_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x584_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
      x586_accum_1.connectStageCtrl((io.sigsIn.done).DS(1.toInt, rr, io.sigsIn.backpressure & true.B), io.sigsIn.baseEn, 0)
    }
    val module = Module(new x2707_concrete(sm.p.depth)); module.io := DontCare
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
/** END ParallelPipe x2707 **/
