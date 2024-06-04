package model
import models.Runtime._

object AppRuntimeModel_dse extends App {
  def build_model(): ControllerModel = {
    val x90 = new ControllerModel(90, OuterControl, Left(Sequenced), CChainModel(Seq()), 0, 1, Ctx("x90", "18", "Accel {", "x90 = AccelScope(Block(Const(())))"))
    val x107 = CtrModel(0, 100, 1, 1)
    val x109 = CChainModel(List[CtrModel[_,_,_,_]](x107), Ctx("x109", "21", "A_sram load A_dram", "List(x107 = CounterNew(Const(0),Const(100),Const(1),Const(1)))"))
    val x163_ctrlast = CtrModel(0, 3, 1, 1)
    val x163 = new ControllerModel(163, OuterControl, Left(DenseLoad), List(x109, CChainModel(List(x163_ctrlast))), 0, 1, Ctx("x163", "21", "A_sram load A_dram", "x163 = OpForeach(Set(),x109,Block(Const(())),List(b108),None)"), bitsPerCycle = 32.toDouble)
    val x19 = CtrModel(0, 100, 1, 10)
    val x21 = CChainModel(List[CtrModel[_,_,_,_]](x19), Ctx("x21", "25", "Foreach(0 until N par 10) {i =>", "List(x19 = CounterNew(Const(0),Const(100),Const(1),Const(10)))"))
    val x88 = new ControllerModel(88, OuterControl, Left(Pipelined), x21, 0, 1, Ctx("x88", "25", "Foreach(0 until N par 10) {i =>", "x88 = OpForeach(Set(),x21,Block(Const(())),List(b20),None)"))
    val x23 = CtrModel(0, 100, 1, 2)
    val x24 = CChainModel(List[CtrModel[_,_,_,_]](x23), Ctx("x24", "49", "}{_+_}", "List(x23 = CounterNew(Const(0),Const(100),Const(1),Const(2)))"))
    val x25 = CtrModel(0, 3, 1, 1)
    val x26 = CChainModel(List[CtrModel[_,_,_,_]](x25), Ctx("x26", "49", "}{_+_}", "Vector(x25 = CounterNew(Const(0),Const(3),Const(1),Const(1)))"))
    val x79 = new ControllerModel(79, OuterControl, Left(Pipelined), List(x24, x26), 0, 1, Ctx("x79", "49", "}{_+_}", "x79 = OpMemReduce(Set(),x24,x26,x22,Block(x31),Block((x31) => x76),Block((x22) => x77),Block((b29,b30) => x75),Block((x22,x75) => x78),None,false,List(b27),List(b28),None,Fix[TRUE,_10,_22],SRAM1[Fix[TRUE,_10,_22]])"))
    val x32 = CtrModel(0, 3, 1, 1)
    val x34 = CChainModel(List[CtrModel[_,_,_,_]](x32), Ctx("x34", "35", "Foreach(0 until 3){k=> tmp(k) = A_sram(i,k) - A_sram(j,k)}", "List(x32 = CounterNew(Const(0),Const(3),Const(1),Const(1)))"))
    val x39 = new ControllerModel(39, InnerControl, Left(Pipelined), x34, 8, 1, Ctx("x39", "35", "Foreach(0 until 3){k=> tmp(k) = A_sram(i,k) - A_sram(j,k)}", "x39 = OpForeach(Set(),x34,Block(Const(())),List(b33),None)"))
    val x103 = new ControllerModel(103, InnerControl, Left(Sequenced), CChainModel(List()), 105 + 2, 1 + 2, Ctx("x103", "44", "force(0) = if (r(0) > 0.to[T] && r(0) > 1.to[T]) {((100.to[T])/r(0)/r(0)/r(0)/r(0)/r(0))-((10.to[T])/r(0)/r(0))} else {90.to[T]}", "x103 = SwitchCase(Block(x63))"))
    val x104 = new ControllerModel(104, InnerControl, Left(Sequenced), CChainModel(List()), 105 + 2, 1 + 2, Ctx("x104", "44", "force(0) = if (r(0) > 0.to[T] && r(0) > 1.to[T]) {((100.to[T])/r(0)/r(0)/r(0)/r(0)/r(0))-((10.to[T])/r(0)/r(0))} else {90.to[T]}", "x104 = SwitchCase(Block(Const(90)))"))
    val x106 = new ControllerModel(106, OuterControl, Left(Fork), CChainModel(List()), 105 + 2, 1 + 2, Ctx("x106", "44", "force(0) = if (r(0) > 0.to[T] && r(0) > 1.to[T]) {((100.to[T])/r(0)/r(0)/r(0)/r(0)/r(0))-((10.to[T])/r(0)/r(0))} else {90.to[T]}", "x106 = Switch(List(x54, x102),Block(x104))"))
    x106.registerChild(x103)
    x106.registerChild(x104)
    val x66 = CtrModel(0, 3, 1, 1)
    val x68 = CChainModel(List[CtrModel[_,_,_,_]](x66), Ctx("x68", "45", "Foreach(0 until 3){ k=>", "List(x66 = CounterNew(Const(0),Const(3),Const(1),Const(1)))"))
    val x74 = new ControllerModel(74, InnerControl, Left(Pipelined), x68, 19, 19, Ctx("x74", "45", "Foreach(0 until 3){ k=>", "x74 = OpForeach(Set(),x68,Block(Const(())),List(b67),None)"))
    x79.registerChild(x39)
    x79.registerChild(x106)
    x79.registerChild(x74)
    val x80 = CtrModel(0, 3, 1, 1)
    val x82 = CChainModel(List[CtrModel[_,_,_,_]](x80), Ctx("x82", "50", "Foreach(0 until 3){k=>", "List(x80 = CounterNew(Const(0),Const(3),Const(1),Const(1)))"))
    val x87 = new ControllerModel(87, InnerControl, Left(Pipelined), x82, 8, 1, Ctx("x87", "50", "Foreach(0 until 3){k=>", "x87 = OpForeach(Set(),x82,Block(Const(())),List(b81),None)"))
    x88.registerChild(x79)
    x88.registerChild(x87)
    val x164 = CtrModel(0, 100, 1, 1)
    val x166 = CChainModel(List[CtrModel[_,_,_,_]](x164), Ctx("x166", "54", "out_host store out_sram", "List(x164 = CounterNew(Const(0),Const(100),Const(1),Const(1)))"))
    val x217_ctrlast = CtrModel(0, 3, 1, 1)
    val x217 = new ControllerModel(217, OuterControl, Left(GatedDenseStore), List(x166, CChainModel(List(x217_ctrlast))), 0, 1, Ctx("x217", "54", "out_host store out_sram", "x217 = OpForeach(Set(),x166,Block(Const(())),List(b165),None)"), bitsPerCycle = 32.toDouble)
    x90.registerChild(x163)
    x90.registerChild(x88)
    x90.registerChild(x217)
    return x90
  }
  
  override def main(args: Array[String]): Unit = {
    begin("/home/hhollen/ee109finalHH/./gen/VCS/MolDSim///results_dse")
    if (args.size >= 1 && (args.contains("noninteractive") || args.contains("ni"))) {
        interactive = false
        val idx = {0 max args.indexOf("noninteractive")} + {0 max args.indexOf("ni")}
        cliParams = args.drop(idx+1).takeWhile{_ != "tune"}.map(_.toInt)
        emit(s"Noninteractive Args: ${cliParams.mkString(" ")}") 
    }
    else {
      println(s"Suggested args: List()")
    }
    val allTuneParams: Seq[Map[String, Any]] = if (args.size >= 1 && (args.contains("tune"))) {
        retune = true
        val indices: Seq[Int] = args.zipWithIndex.filter(_._1 == "tune").map(_._2)
        indices.map{idx => args.drop(idx+1).takeWhile{x => x != "noninteractive" && x != "ni" && x != "tune"}.grouped(2).map{x => (x(0) -> {try {x(1).toInt} catch {case _: Throwable => x(1)}} )}.toMap}
    } else {Seq(Map[String, Any]())}
    val root = build_model()
    root.initializeAskMap(AskMap.map)
    root.loadPreviousAskMap(PreviousAskMap.map) // Load previous run's askmap
    emit(s"[dse] Structure for app MolDSim")
    allTuneParams.foreach{tuneTo => 
        tuneParams = tuneTo
        root.printStructure()
        root.execute()
        emit(s"[dse] Runtime results for app MolDSim")
        root.printResults()
        root.storeAskMap("/home/hhollen/ee109finalHH/./gen/VCS/MolDSim///model/PreviousAskMap.scala") // Store this run's askmap
        emit(s"[dse] Total Cycles for App MolDSim: ${root.totalCycles()}")
    }
    end()
  }
}
