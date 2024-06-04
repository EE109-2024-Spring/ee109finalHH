import spatial.dsl._

@spatial class MolDSim extends SpatialTest {

  type T = FixPt[TRUE,_10,_22]

  val N = 100  // mols is Nx3i
  val Timesteps = 1 //we are doing one computationally expensive timestep
  val dt = 0.1.to[T]

  def main(args: Array[String]): Unit = {

    // These are on the HOST
    val A_host = loadCSV2D[T](s"/home/hhollen/ee109finalHH/mol_arr100.csv")
    val A_dram = DRAM[T](N, 3)
    setMem(A_dram, A_host)
    val out_host = DRAM[T](N, 3)
    Accel {
      val A_sram = SRAM[T](N, 3)

      A_sram load A_dram

      val out_sram = SRAM[T](N,3)

      Foreach(0 until N) {i =>

	 // out_sram(i,0) = i.to[T]
	 // out_sram(i,1) = i.to[T]
	 // out_sram(i,2) = i.to[T]
	  val accum = SRAM[T](3)
	  MemReduce(accum)(0 until N) {j=>
	  //we take mol i and compare it with each other mol j
	  //to calculate the distance and respective force. 
	    val tmp = SRAM[T](3).buffer
	    Foreach(0 until 3){k=> tmp(k) = A_sram(i,k) - A_sram(j,k)}
	    val r = SRAM[T](1)
	    r(0) = (tmp(0)*tmp(0)) + (tmp(1)*tmp(1)) + (tmp(2)*tmp(2))
	   // val test = SRAM[T](1)
	   // test(0) = 100.to[T]/(r(0))/(r(0))/(r(0))
            val force = SRAM[T](1)
	   // println("pussy!")
	   // printSRAM1(test)
	//INCORRECT FUNCTION, SHOULD BE A MIN HERE
	    force(0) = if (r(0) > 0.to[T] && r(0) > 1.to[T]) {((100.to[T])/r(0)/r(0)/r(0)/r(0)/r(0))-((10.to[T])/r(0)/r(0))} else {90.to[T]}
	    Foreach(0 until 3){ k=>
	     tmp(k) = tmp(k)*dt*force(0)
		 }
	    tmp
	}{_+_}
	  Foreach(0 until 3){k=>
	    out_sram(i, k) = accum(k) + A_sram(i,k)
	}
      }
      out_host store out_sram
    }

    writeCSV1D(getMem(out_host), s"/home/hhollen/ee109finalHH/output.csv")
    assert(Bit(true))
  }
}
