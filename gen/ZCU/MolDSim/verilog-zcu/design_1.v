//Copyright 1986-2019 Xilinx, Inc. All Rights Reserved.
//--------------------------------------------------------------------------------
//Tool Version: Vivado v.2019.1 (lin64) Build 2552052 Fri May 24 14:47:09 MDT 2019
//Date        : Tue Jun  4 02:23:16 2024
//Host        : lagos running 64-bit Ubuntu 22.04.4 LTS
//Command     : generate_target design_1.bd
//Design      : design_1
//Purpose     : IP block netlist
//--------------------------------------------------------------------------------
`timescale 1 ps / 1 ps

(* CORE_GENERATION_INFO = "design_1,IP_Integrator,{x_ipVendor=xilinx.com,x_ipLibrary=BlockDiagram,x_ipName=design_1,x_ipVersion=1.00.a,x_ipLanguage=VERILOG,numBlks=9,numReposBlks=7,numNonXlnxBlks=0,numHierBlks=2,maxHierDepth=0,numSysgenBlks=0,numHlsBlks=0,numHdlrefBlks=1,numPkgbdBlks=0,bdsource=USER,da_axi4_cnt=1,da_zynq_ultra_ps_e_cnt=1,synth_mode=OOC_per_IP}" *) (* HW_HANDOFF = "design_1.hwdef" *) 
module design_1
   ();

  wire [39:0]SpatialIP_0_io_M_AXI_0_ARADDR;
  wire [1:0]SpatialIP_0_io_M_AXI_0_ARBURST;
  wire [3:0]SpatialIP_0_io_M_AXI_0_ARCACHE;
  wire [31:0]SpatialIP_0_io_M_AXI_0_ARID;
  wire [7:0]SpatialIP_0_io_M_AXI_0_ARLEN;
  wire SpatialIP_0_io_M_AXI_0_ARLOCK;
  wire [2:0]SpatialIP_0_io_M_AXI_0_ARPROT;
  wire [3:0]SpatialIP_0_io_M_AXI_0_ARQOS;
  wire SpatialIP_0_io_M_AXI_0_ARREADY;
  wire [2:0]SpatialIP_0_io_M_AXI_0_ARSIZE;
  wire SpatialIP_0_io_M_AXI_0_ARVALID;
  wire [39:0]SpatialIP_0_io_M_AXI_0_AWADDR;
  wire [1:0]SpatialIP_0_io_M_AXI_0_AWBURST;
  wire [3:0]SpatialIP_0_io_M_AXI_0_AWCACHE;
  wire [31:0]SpatialIP_0_io_M_AXI_0_AWID;
  wire [7:0]SpatialIP_0_io_M_AXI_0_AWLEN;
  wire SpatialIP_0_io_M_AXI_0_AWLOCK;
  wire [2:0]SpatialIP_0_io_M_AXI_0_AWPROT;
  wire [3:0]SpatialIP_0_io_M_AXI_0_AWQOS;
  wire SpatialIP_0_io_M_AXI_0_AWREADY;
  wire [2:0]SpatialIP_0_io_M_AXI_0_AWSIZE;
  wire SpatialIP_0_io_M_AXI_0_AWVALID;
  wire [31:0]SpatialIP_0_io_M_AXI_0_BID;
  wire SpatialIP_0_io_M_AXI_0_BREADY;
  wire [1:0]SpatialIP_0_io_M_AXI_0_BRESP;
  wire SpatialIP_0_io_M_AXI_0_BVALID;
  wire [511:0]SpatialIP_0_io_M_AXI_0_RDATA;
  wire [31:0]SpatialIP_0_io_M_AXI_0_RID;
  wire SpatialIP_0_io_M_AXI_0_RLAST;
  wire SpatialIP_0_io_M_AXI_0_RREADY;
  wire [1:0]SpatialIP_0_io_M_AXI_0_RRESP;
  wire SpatialIP_0_io_M_AXI_0_RVALID;
  wire [511:0]SpatialIP_0_io_M_AXI_0_WDATA;
  wire SpatialIP_0_io_M_AXI_0_WLAST;
  wire SpatialIP_0_io_M_AXI_0_WREADY;
  wire [63:0]SpatialIP_0_io_M_AXI_0_WSTRB;
  wire SpatialIP_0_io_M_AXI_0_WVALID;
  wire [39:0]SpatialIP_0_io_M_AXI_1_ARADDR;
  wire [1:0]SpatialIP_0_io_M_AXI_1_ARBURST;
  wire [3:0]SpatialIP_0_io_M_AXI_1_ARCACHE;
  wire [31:0]SpatialIP_0_io_M_AXI_1_ARID;
  wire [7:0]SpatialIP_0_io_M_AXI_1_ARLEN;
  wire SpatialIP_0_io_M_AXI_1_ARLOCK;
  wire [2:0]SpatialIP_0_io_M_AXI_1_ARPROT;
  wire [3:0]SpatialIP_0_io_M_AXI_1_ARQOS;
  wire SpatialIP_0_io_M_AXI_1_ARREADY;
  wire [2:0]SpatialIP_0_io_M_AXI_1_ARSIZE;
  wire SpatialIP_0_io_M_AXI_1_ARVALID;
  wire [39:0]SpatialIP_0_io_M_AXI_1_AWADDR;
  wire [1:0]SpatialIP_0_io_M_AXI_1_AWBURST;
  wire [3:0]SpatialIP_0_io_M_AXI_1_AWCACHE;
  wire [31:0]SpatialIP_0_io_M_AXI_1_AWID;
  wire [7:0]SpatialIP_0_io_M_AXI_1_AWLEN;
  wire SpatialIP_0_io_M_AXI_1_AWLOCK;
  wire [2:0]SpatialIP_0_io_M_AXI_1_AWPROT;
  wire [3:0]SpatialIP_0_io_M_AXI_1_AWQOS;
  wire SpatialIP_0_io_M_AXI_1_AWREADY;
  wire [2:0]SpatialIP_0_io_M_AXI_1_AWSIZE;
  wire SpatialIP_0_io_M_AXI_1_AWVALID;
  wire [31:0]SpatialIP_0_io_M_AXI_1_BID;
  wire SpatialIP_0_io_M_AXI_1_BREADY;
  wire [1:0]SpatialIP_0_io_M_AXI_1_BRESP;
  wire SpatialIP_0_io_M_AXI_1_BVALID;
  wire [511:0]SpatialIP_0_io_M_AXI_1_RDATA;
  wire [31:0]SpatialIP_0_io_M_AXI_1_RID;
  wire SpatialIP_0_io_M_AXI_1_RLAST;
  wire SpatialIP_0_io_M_AXI_1_RREADY;
  wire [1:0]SpatialIP_0_io_M_AXI_1_RRESP;
  wire SpatialIP_0_io_M_AXI_1_RVALID;
  wire [511:0]SpatialIP_0_io_M_AXI_1_WDATA;
  wire SpatialIP_0_io_M_AXI_1_WLAST;
  wire SpatialIP_0_io_M_AXI_1_WREADY;
  wire [63:0]SpatialIP_0_io_M_AXI_1_WSTRB;
  wire SpatialIP_0_io_M_AXI_1_WVALID;
  wire [31:0]axi_dwidth_converter_0_M_AXI_ARADDR;
  wire [1:0]axi_dwidth_converter_0_M_AXI_ARBURST;
  wire [3:0]axi_dwidth_converter_0_M_AXI_ARCACHE;
  wire [7:0]axi_dwidth_converter_0_M_AXI_ARLEN;
  wire [0:0]axi_dwidth_converter_0_M_AXI_ARLOCK;
  wire [2:0]axi_dwidth_converter_0_M_AXI_ARPROT;
  wire [3:0]axi_dwidth_converter_0_M_AXI_ARQOS;
  wire axi_dwidth_converter_0_M_AXI_ARREADY;
  wire [2:0]axi_dwidth_converter_0_M_AXI_ARSIZE;
  wire axi_dwidth_converter_0_M_AXI_ARVALID;
  wire [31:0]axi_dwidth_converter_0_M_AXI_AWADDR;
  wire [1:0]axi_dwidth_converter_0_M_AXI_AWBURST;
  wire [3:0]axi_dwidth_converter_0_M_AXI_AWCACHE;
  wire [7:0]axi_dwidth_converter_0_M_AXI_AWLEN;
  wire [0:0]axi_dwidth_converter_0_M_AXI_AWLOCK;
  wire [2:0]axi_dwidth_converter_0_M_AXI_AWPROT;
  wire [3:0]axi_dwidth_converter_0_M_AXI_AWQOS;
  wire axi_dwidth_converter_0_M_AXI_AWREADY;
  wire [2:0]axi_dwidth_converter_0_M_AXI_AWSIZE;
  wire axi_dwidth_converter_0_M_AXI_AWVALID;
  wire axi_dwidth_converter_0_M_AXI_BREADY;
  wire [1:0]axi_dwidth_converter_0_M_AXI_BRESP;
  wire axi_dwidth_converter_0_M_AXI_BVALID;
  wire [127:0]axi_dwidth_converter_0_M_AXI_RDATA;
  wire axi_dwidth_converter_0_M_AXI_RLAST;
  wire axi_dwidth_converter_0_M_AXI_RREADY;
  wire [1:0]axi_dwidth_converter_0_M_AXI_RRESP;
  wire axi_dwidth_converter_0_M_AXI_RVALID;
  wire [127:0]axi_dwidth_converter_0_M_AXI_WDATA;
  wire axi_dwidth_converter_0_M_AXI_WLAST;
  wire axi_dwidth_converter_0_M_AXI_WREADY;
  wire [15:0]axi_dwidth_converter_0_M_AXI_WSTRB;
  wire axi_dwidth_converter_0_M_AXI_WVALID;
  wire [31:0]axi_dwidth_converter_1_M_AXI_ARADDR;
  wire [1:0]axi_dwidth_converter_1_M_AXI_ARBURST;
  wire [3:0]axi_dwidth_converter_1_M_AXI_ARCACHE;
  wire [7:0]axi_dwidth_converter_1_M_AXI_ARLEN;
  wire [0:0]axi_dwidth_converter_1_M_AXI_ARLOCK;
  wire [2:0]axi_dwidth_converter_1_M_AXI_ARPROT;
  wire [3:0]axi_dwidth_converter_1_M_AXI_ARQOS;
  wire axi_dwidth_converter_1_M_AXI_ARREADY;
  wire [2:0]axi_dwidth_converter_1_M_AXI_ARSIZE;
  wire axi_dwidth_converter_1_M_AXI_ARVALID;
  wire [31:0]axi_dwidth_converter_1_M_AXI_AWADDR;
  wire [1:0]axi_dwidth_converter_1_M_AXI_AWBURST;
  wire [3:0]axi_dwidth_converter_1_M_AXI_AWCACHE;
  wire [7:0]axi_dwidth_converter_1_M_AXI_AWLEN;
  wire [0:0]axi_dwidth_converter_1_M_AXI_AWLOCK;
  wire [2:0]axi_dwidth_converter_1_M_AXI_AWPROT;
  wire [3:0]axi_dwidth_converter_1_M_AXI_AWQOS;
  wire axi_dwidth_converter_1_M_AXI_AWREADY;
  wire [2:0]axi_dwidth_converter_1_M_AXI_AWSIZE;
  wire axi_dwidth_converter_1_M_AXI_AWVALID;
  wire axi_dwidth_converter_1_M_AXI_BREADY;
  wire [1:0]axi_dwidth_converter_1_M_AXI_BRESP;
  wire axi_dwidth_converter_1_M_AXI_BVALID;
  wire [127:0]axi_dwidth_converter_1_M_AXI_RDATA;
  wire axi_dwidth_converter_1_M_AXI_RLAST;
  wire axi_dwidth_converter_1_M_AXI_RREADY;
  wire [1:0]axi_dwidth_converter_1_M_AXI_RRESP;
  wire axi_dwidth_converter_1_M_AXI_RVALID;
  wire [127:0]axi_dwidth_converter_1_M_AXI_WDATA;
  wire axi_dwidth_converter_1_M_AXI_WLAST;
  wire axi_dwidth_converter_1_M_AXI_WREADY;
  wire [15:0]axi_dwidth_converter_1_M_AXI_WSTRB;
  wire axi_dwidth_converter_1_M_AXI_WVALID;
  wire [39:0]ps8_0_axi_periph_M00_AXI_ARADDR;
  wire [2:0]ps8_0_axi_periph_M00_AXI_ARPROT;
  wire ps8_0_axi_periph_M00_AXI_ARREADY;
  wire ps8_0_axi_periph_M00_AXI_ARVALID;
  wire [39:0]ps8_0_axi_periph_M00_AXI_AWADDR;
  wire [2:0]ps8_0_axi_periph_M00_AXI_AWPROT;
  wire ps8_0_axi_periph_M00_AXI_AWREADY;
  wire ps8_0_axi_periph_M00_AXI_AWVALID;
  wire ps8_0_axi_periph_M00_AXI_BREADY;
  wire [1:0]ps8_0_axi_periph_M00_AXI_BRESP;
  wire ps8_0_axi_periph_M00_AXI_BVALID;
  wire [63:0]ps8_0_axi_periph_M00_AXI_RDATA;
  wire ps8_0_axi_periph_M00_AXI_RREADY;
  wire [1:0]ps8_0_axi_periph_M00_AXI_RRESP;
  wire ps8_0_axi_periph_M00_AXI_RVALID;
  wire [63:0]ps8_0_axi_periph_M00_AXI_WDATA;
  wire ps8_0_axi_periph_M00_AXI_WREADY;
  wire [7:0]ps8_0_axi_periph_M00_AXI_WSTRB;
  wire ps8_0_axi_periph_M00_AXI_WVALID;
  wire [0:0]rst_ps8_0_99M_peripheral_aresetn;
  wire [39:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARADDR;
  wire [1:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARBURST;
  wire [3:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARCACHE;
  wire [15:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARID;
  wire [7:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARLEN;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARLOCK;
  wire [2:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARPROT;
  wire [3:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARQOS;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARREADY;
  wire [2:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARSIZE;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARVALID;
  wire [39:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWADDR;
  wire [1:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWBURST;
  wire [3:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWCACHE;
  wire [15:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWID;
  wire [7:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWLEN;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWLOCK;
  wire [2:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWPROT;
  wire [3:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWQOS;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWREADY;
  wire [2:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWSIZE;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWVALID;
  wire [15:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BID;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BREADY;
  wire [1:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BRESP;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BVALID;
  wire [127:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RDATA;
  wire [15:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RID;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RLAST;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RREADY;
  wire [1:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RRESP;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RVALID;
  wire [127:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WDATA;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WLAST;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WREADY;
  wire [15:0]zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WSTRB;
  wire zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WVALID;
  wire zynq_ultra_ps_e_0_pl_clk0;
  wire zynq_ultra_ps_e_0_pl_resetn0;

  SpatialIP SpatialIP_0
       (.clock(zynq_ultra_ps_e_0_pl_clk0),
        .io_CLOCKCONVERT_AXI_ARADDR({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_ARBURST({1'b0,1'b1}),
        .io_CLOCKCONVERT_AXI_ARCACHE({1'b0,1'b0,1'b1,1'b1}),
        .io_CLOCKCONVERT_AXI_ARID(1'b0),
        .io_CLOCKCONVERT_AXI_ARLEN({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_ARLOCK(1'b0),
        .io_CLOCKCONVERT_AXI_ARPROT({1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_ARQOS({1'b0,1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_ARREADY(1'b0),
        .io_CLOCKCONVERT_AXI_ARSIZE({1'b0,1'b1,1'b1}),
        .io_CLOCKCONVERT_AXI_ARUSER(1'b0),
        .io_CLOCKCONVERT_AXI_ARVALID(1'b0),
        .io_CLOCKCONVERT_AXI_AWADDR({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_AWBURST({1'b0,1'b1}),
        .io_CLOCKCONVERT_AXI_AWCACHE({1'b0,1'b0,1'b1,1'b1}),
        .io_CLOCKCONVERT_AXI_AWID(1'b0),
        .io_CLOCKCONVERT_AXI_AWLEN({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_AWLOCK(1'b0),
        .io_CLOCKCONVERT_AXI_AWPROT({1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_AWQOS({1'b0,1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_AWREADY(1'b0),
        .io_CLOCKCONVERT_AXI_AWSIZE({1'b0,1'b1,1'b1}),
        .io_CLOCKCONVERT_AXI_AWUSER(1'b0),
        .io_CLOCKCONVERT_AXI_AWVALID(1'b0),
        .io_CLOCKCONVERT_AXI_BID(1'b0),
        .io_CLOCKCONVERT_AXI_BREADY(1'b0),
        .io_CLOCKCONVERT_AXI_BRESP({1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_BUSER(1'b0),
        .io_CLOCKCONVERT_AXI_BVALID(1'b0),
        .io_CLOCKCONVERT_AXI_RDATA({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_RID(1'b0),
        .io_CLOCKCONVERT_AXI_RLAST(1'b0),
        .io_CLOCKCONVERT_AXI_RREADY(1'b0),
        .io_CLOCKCONVERT_AXI_RRESP({1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_RUSER(1'b0),
        .io_CLOCKCONVERT_AXI_RVALID(1'b0),
        .io_CLOCKCONVERT_AXI_WDATA({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_CLOCKCONVERT_AXI_WLAST(1'b0),
        .io_CLOCKCONVERT_AXI_WREADY(1'b0),
        .io_CLOCKCONVERT_AXI_WSTRB({1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1}),
        .io_CLOCKCONVERT_AXI_WVALID(1'b0),
        .io_DWIDTH_AXI_ARADDR({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_ARBURST({1'b0,1'b1}),
        .io_DWIDTH_AXI_ARCACHE({1'b0,1'b0,1'b1,1'b1}),
        .io_DWIDTH_AXI_ARID(1'b0),
        .io_DWIDTH_AXI_ARLEN({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_ARLOCK(1'b0),
        .io_DWIDTH_AXI_ARPROT({1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_ARQOS({1'b0,1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_ARREADY(1'b0),
        .io_DWIDTH_AXI_ARSIZE({1'b0,1'b1,1'b1}),
        .io_DWIDTH_AXI_ARUSER(1'b0),
        .io_DWIDTH_AXI_ARVALID(1'b0),
        .io_DWIDTH_AXI_AWADDR({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_AWBURST({1'b0,1'b1}),
        .io_DWIDTH_AXI_AWCACHE({1'b0,1'b0,1'b1,1'b1}),
        .io_DWIDTH_AXI_AWID(1'b0),
        .io_DWIDTH_AXI_AWLEN({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_AWLOCK(1'b0),
        .io_DWIDTH_AXI_AWPROT({1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_AWQOS({1'b0,1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_AWREADY(1'b0),
        .io_DWIDTH_AXI_AWSIZE({1'b0,1'b1,1'b1}),
        .io_DWIDTH_AXI_AWUSER(1'b0),
        .io_DWIDTH_AXI_AWVALID(1'b0),
        .io_DWIDTH_AXI_BID(1'b0),
        .io_DWIDTH_AXI_BREADY(1'b0),
        .io_DWIDTH_AXI_BRESP({1'b0,1'b0}),
        .io_DWIDTH_AXI_BUSER(1'b0),
        .io_DWIDTH_AXI_BVALID(1'b0),
        .io_DWIDTH_AXI_RDATA({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_RID(1'b0),
        .io_DWIDTH_AXI_RLAST(1'b0),
        .io_DWIDTH_AXI_RREADY(1'b0),
        .io_DWIDTH_AXI_RRESP({1'b0,1'b0}),
        .io_DWIDTH_AXI_RUSER(1'b0),
        .io_DWIDTH_AXI_RVALID(1'b0),
        .io_DWIDTH_AXI_WDATA({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_DWIDTH_AXI_WLAST(1'b0),
        .io_DWIDTH_AXI_WREADY(1'b0),
        .io_DWIDTH_AXI_WSTRB({1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1}),
        .io_DWIDTH_AXI_WVALID(1'b0),
        .io_M_AXI_0_ARADDR(SpatialIP_0_io_M_AXI_0_ARADDR),
        .io_M_AXI_0_ARBURST(SpatialIP_0_io_M_AXI_0_ARBURST),
        .io_M_AXI_0_ARCACHE(SpatialIP_0_io_M_AXI_0_ARCACHE),
        .io_M_AXI_0_ARID(SpatialIP_0_io_M_AXI_0_ARID),
        .io_M_AXI_0_ARLEN(SpatialIP_0_io_M_AXI_0_ARLEN),
        .io_M_AXI_0_ARLOCK(SpatialIP_0_io_M_AXI_0_ARLOCK),
        .io_M_AXI_0_ARPROT(SpatialIP_0_io_M_AXI_0_ARPROT),
        .io_M_AXI_0_ARQOS(SpatialIP_0_io_M_AXI_0_ARQOS),
        .io_M_AXI_0_ARREADY(SpatialIP_0_io_M_AXI_0_ARREADY),
        .io_M_AXI_0_ARSIZE(SpatialIP_0_io_M_AXI_0_ARSIZE),
        .io_M_AXI_0_ARVALID(SpatialIP_0_io_M_AXI_0_ARVALID),
        .io_M_AXI_0_AWADDR(SpatialIP_0_io_M_AXI_0_AWADDR),
        .io_M_AXI_0_AWBURST(SpatialIP_0_io_M_AXI_0_AWBURST),
        .io_M_AXI_0_AWCACHE(SpatialIP_0_io_M_AXI_0_AWCACHE),
        .io_M_AXI_0_AWID(SpatialIP_0_io_M_AXI_0_AWID),
        .io_M_AXI_0_AWLEN(SpatialIP_0_io_M_AXI_0_AWLEN),
        .io_M_AXI_0_AWLOCK(SpatialIP_0_io_M_AXI_0_AWLOCK),
        .io_M_AXI_0_AWPROT(SpatialIP_0_io_M_AXI_0_AWPROT),
        .io_M_AXI_0_AWQOS(SpatialIP_0_io_M_AXI_0_AWQOS),
        .io_M_AXI_0_AWREADY(SpatialIP_0_io_M_AXI_0_AWREADY),
        .io_M_AXI_0_AWSIZE(SpatialIP_0_io_M_AXI_0_AWSIZE),
        .io_M_AXI_0_AWVALID(SpatialIP_0_io_M_AXI_0_AWVALID),
        .io_M_AXI_0_BID(SpatialIP_0_io_M_AXI_0_BID),
        .io_M_AXI_0_BREADY(SpatialIP_0_io_M_AXI_0_BREADY),
        .io_M_AXI_0_BRESP(SpatialIP_0_io_M_AXI_0_BRESP),
        .io_M_AXI_0_BUSER({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_M_AXI_0_BVALID(SpatialIP_0_io_M_AXI_0_BVALID),
        .io_M_AXI_0_RDATA(SpatialIP_0_io_M_AXI_0_RDATA),
        .io_M_AXI_0_RID(SpatialIP_0_io_M_AXI_0_RID),
        .io_M_AXI_0_RLAST(SpatialIP_0_io_M_AXI_0_RLAST),
        .io_M_AXI_0_RREADY(SpatialIP_0_io_M_AXI_0_RREADY),
        .io_M_AXI_0_RRESP(SpatialIP_0_io_M_AXI_0_RRESP),
        .io_M_AXI_0_RUSER({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_M_AXI_0_RVALID(SpatialIP_0_io_M_AXI_0_RVALID),
        .io_M_AXI_0_WDATA(SpatialIP_0_io_M_AXI_0_WDATA),
        .io_M_AXI_0_WLAST(SpatialIP_0_io_M_AXI_0_WLAST),
        .io_M_AXI_0_WREADY(SpatialIP_0_io_M_AXI_0_WREADY),
        .io_M_AXI_0_WSTRB(SpatialIP_0_io_M_AXI_0_WSTRB),
        .io_M_AXI_0_WVALID(SpatialIP_0_io_M_AXI_0_WVALID),
        .io_M_AXI_1_ARADDR(SpatialIP_0_io_M_AXI_1_ARADDR),
        .io_M_AXI_1_ARBURST(SpatialIP_0_io_M_AXI_1_ARBURST),
        .io_M_AXI_1_ARCACHE(SpatialIP_0_io_M_AXI_1_ARCACHE),
        .io_M_AXI_1_ARID(SpatialIP_0_io_M_AXI_1_ARID),
        .io_M_AXI_1_ARLEN(SpatialIP_0_io_M_AXI_1_ARLEN),
        .io_M_AXI_1_ARLOCK(SpatialIP_0_io_M_AXI_1_ARLOCK),
        .io_M_AXI_1_ARPROT(SpatialIP_0_io_M_AXI_1_ARPROT),
        .io_M_AXI_1_ARQOS(SpatialIP_0_io_M_AXI_1_ARQOS),
        .io_M_AXI_1_ARREADY(SpatialIP_0_io_M_AXI_1_ARREADY),
        .io_M_AXI_1_ARSIZE(SpatialIP_0_io_M_AXI_1_ARSIZE),
        .io_M_AXI_1_ARVALID(SpatialIP_0_io_M_AXI_1_ARVALID),
        .io_M_AXI_1_AWADDR(SpatialIP_0_io_M_AXI_1_AWADDR),
        .io_M_AXI_1_AWBURST(SpatialIP_0_io_M_AXI_1_AWBURST),
        .io_M_AXI_1_AWCACHE(SpatialIP_0_io_M_AXI_1_AWCACHE),
        .io_M_AXI_1_AWID(SpatialIP_0_io_M_AXI_1_AWID),
        .io_M_AXI_1_AWLEN(SpatialIP_0_io_M_AXI_1_AWLEN),
        .io_M_AXI_1_AWLOCK(SpatialIP_0_io_M_AXI_1_AWLOCK),
        .io_M_AXI_1_AWPROT(SpatialIP_0_io_M_AXI_1_AWPROT),
        .io_M_AXI_1_AWQOS(SpatialIP_0_io_M_AXI_1_AWQOS),
        .io_M_AXI_1_AWREADY(SpatialIP_0_io_M_AXI_1_AWREADY),
        .io_M_AXI_1_AWSIZE(SpatialIP_0_io_M_AXI_1_AWSIZE),
        .io_M_AXI_1_AWVALID(SpatialIP_0_io_M_AXI_1_AWVALID),
        .io_M_AXI_1_BID(SpatialIP_0_io_M_AXI_1_BID),
        .io_M_AXI_1_BREADY(SpatialIP_0_io_M_AXI_1_BREADY),
        .io_M_AXI_1_BRESP(SpatialIP_0_io_M_AXI_1_BRESP),
        .io_M_AXI_1_BUSER({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_M_AXI_1_BVALID(SpatialIP_0_io_M_AXI_1_BVALID),
        .io_M_AXI_1_RDATA(SpatialIP_0_io_M_AXI_1_RDATA),
        .io_M_AXI_1_RID(SpatialIP_0_io_M_AXI_1_RID),
        .io_M_AXI_1_RLAST(SpatialIP_0_io_M_AXI_1_RLAST),
        .io_M_AXI_1_RREADY(SpatialIP_0_io_M_AXI_1_RREADY),
        .io_M_AXI_1_RRESP(SpatialIP_0_io_M_AXI_1_RRESP),
        .io_M_AXI_1_RUSER({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_M_AXI_1_RVALID(SpatialIP_0_io_M_AXI_1_RVALID),
        .io_M_AXI_1_WDATA(SpatialIP_0_io_M_AXI_1_WDATA),
        .io_M_AXI_1_WLAST(SpatialIP_0_io_M_AXI_1_WLAST),
        .io_M_AXI_1_WREADY(SpatialIP_0_io_M_AXI_1_WREADY),
        .io_M_AXI_1_WSTRB(SpatialIP_0_io_M_AXI_1_WSTRB),
        .io_M_AXI_1_WVALID(SpatialIP_0_io_M_AXI_1_WVALID),
        .io_PROTOCOL_AXI_ARADDR({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_ARBURST({1'b0,1'b1}),
        .io_PROTOCOL_AXI_ARCACHE({1'b0,1'b0,1'b1,1'b1}),
        .io_PROTOCOL_AXI_ARID(1'b0),
        .io_PROTOCOL_AXI_ARLEN({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_ARLOCK(1'b0),
        .io_PROTOCOL_AXI_ARPROT({1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_ARQOS({1'b0,1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_ARREADY(1'b0),
        .io_PROTOCOL_AXI_ARSIZE({1'b0,1'b1,1'b1}),
        .io_PROTOCOL_AXI_ARUSER(1'b0),
        .io_PROTOCOL_AXI_ARVALID(1'b0),
        .io_PROTOCOL_AXI_AWADDR({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_AWBURST({1'b0,1'b1}),
        .io_PROTOCOL_AXI_AWCACHE({1'b0,1'b0,1'b1,1'b1}),
        .io_PROTOCOL_AXI_AWID(1'b0),
        .io_PROTOCOL_AXI_AWLEN({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_AWLOCK(1'b0),
        .io_PROTOCOL_AXI_AWPROT({1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_AWQOS({1'b0,1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_AWREADY(1'b0),
        .io_PROTOCOL_AXI_AWSIZE({1'b0,1'b1,1'b1}),
        .io_PROTOCOL_AXI_AWUSER(1'b0),
        .io_PROTOCOL_AXI_AWVALID(1'b0),
        .io_PROTOCOL_AXI_BID(1'b0),
        .io_PROTOCOL_AXI_BREADY(1'b0),
        .io_PROTOCOL_AXI_BRESP({1'b0,1'b0}),
        .io_PROTOCOL_AXI_BUSER(1'b0),
        .io_PROTOCOL_AXI_BVALID(1'b0),
        .io_PROTOCOL_AXI_RDATA({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_RID(1'b0),
        .io_PROTOCOL_AXI_RLAST(1'b0),
        .io_PROTOCOL_AXI_RREADY(1'b0),
        .io_PROTOCOL_AXI_RRESP({1'b0,1'b0}),
        .io_PROTOCOL_AXI_RUSER(1'b0),
        .io_PROTOCOL_AXI_RVALID(1'b0),
        .io_PROTOCOL_AXI_WDATA({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_PROTOCOL_AXI_WLAST(1'b0),
        .io_PROTOCOL_AXI_WREADY(1'b0),
        .io_PROTOCOL_AXI_WSTRB({1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1}),
        .io_PROTOCOL_AXI_WVALID(1'b0),
        .io_S_AXI_ARADDR(ps8_0_axi_periph_M00_AXI_ARADDR),
        .io_S_AXI_ARPROT(ps8_0_axi_periph_M00_AXI_ARPROT),
        .io_S_AXI_ARREADY(ps8_0_axi_periph_M00_AXI_ARREADY),
        .io_S_AXI_ARVALID(ps8_0_axi_periph_M00_AXI_ARVALID),
        .io_S_AXI_AWADDR(ps8_0_axi_periph_M00_AXI_AWADDR),
        .io_S_AXI_AWPROT(ps8_0_axi_periph_M00_AXI_AWPROT),
        .io_S_AXI_AWREADY(ps8_0_axi_periph_M00_AXI_AWREADY),
        .io_S_AXI_AWVALID(ps8_0_axi_periph_M00_AXI_AWVALID),
        .io_S_AXI_BREADY(ps8_0_axi_periph_M00_AXI_BREADY),
        .io_S_AXI_BRESP(ps8_0_axi_periph_M00_AXI_BRESP),
        .io_S_AXI_BVALID(ps8_0_axi_periph_M00_AXI_BVALID),
        .io_S_AXI_RDATA(ps8_0_axi_periph_M00_AXI_RDATA),
        .io_S_AXI_RREADY(ps8_0_axi_periph_M00_AXI_RREADY),
        .io_S_AXI_RRESP(ps8_0_axi_periph_M00_AXI_RRESP),
        .io_S_AXI_RVALID(ps8_0_axi_periph_M00_AXI_RVALID),
        .io_S_AXI_WDATA(ps8_0_axi_periph_M00_AXI_WDATA),
        .io_S_AXI_WREADY(ps8_0_axi_periph_M00_AXI_WREADY),
        .io_S_AXI_WSTRB(ps8_0_axi_periph_M00_AXI_WSTRB),
        .io_S_AXI_WVALID(ps8_0_axi_periph_M00_AXI_WVALID),
        .io_TOP_AXI_ARADDR({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_TOP_AXI_ARBURST({1'b0,1'b1}),
        .io_TOP_AXI_ARCACHE({1'b0,1'b0,1'b1,1'b1}),
        .io_TOP_AXI_ARID(1'b0),
        .io_TOP_AXI_ARLEN({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_TOP_AXI_ARLOCK(1'b0),
        .io_TOP_AXI_ARPROT({1'b0,1'b0,1'b0}),
        .io_TOP_AXI_ARQOS({1'b0,1'b0,1'b0,1'b0}),
        .io_TOP_AXI_ARREADY(1'b0),
        .io_TOP_AXI_ARSIZE({1'b0,1'b1,1'b1}),
        .io_TOP_AXI_ARUSER(1'b0),
        .io_TOP_AXI_ARVALID(1'b0),
        .io_TOP_AXI_AWADDR({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_TOP_AXI_AWBURST({1'b0,1'b1}),
        .io_TOP_AXI_AWCACHE({1'b0,1'b0,1'b1,1'b1}),
        .io_TOP_AXI_AWID(1'b0),
        .io_TOP_AXI_AWLEN({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_TOP_AXI_AWLOCK(1'b0),
        .io_TOP_AXI_AWPROT({1'b0,1'b0,1'b0}),
        .io_TOP_AXI_AWQOS({1'b0,1'b0,1'b0,1'b0}),
        .io_TOP_AXI_AWREADY(1'b0),
        .io_TOP_AXI_AWSIZE({1'b0,1'b1,1'b1}),
        .io_TOP_AXI_AWUSER(1'b0),
        .io_TOP_AXI_AWVALID(1'b0),
        .io_TOP_AXI_BID(1'b0),
        .io_TOP_AXI_BREADY(1'b0),
        .io_TOP_AXI_BRESP({1'b0,1'b0}),
        .io_TOP_AXI_BUSER(1'b0),
        .io_TOP_AXI_BVALID(1'b0),
        .io_TOP_AXI_RDATA({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_TOP_AXI_RID(1'b0),
        .io_TOP_AXI_RLAST(1'b0),
        .io_TOP_AXI_RREADY(1'b0),
        .io_TOP_AXI_RRESP({1'b0,1'b0}),
        .io_TOP_AXI_RUSER(1'b0),
        .io_TOP_AXI_RVALID(1'b0),
        .io_TOP_AXI_WDATA({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .io_TOP_AXI_WLAST(1'b0),
        .io_TOP_AXI_WREADY(1'b0),
        .io_TOP_AXI_WSTRB({1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1,1'b1}),
        .io_TOP_AXI_WVALID(1'b0),
        .io_axil_s_clk(zynq_ultra_ps_e_0_pl_clk0),
        .io_raddr(1'b0),
        .io_waddr(1'b0),
        .io_wdata(1'b0),
        .io_wen(1'b0),
        .reset(rst_ps8_0_99M_peripheral_aresetn));
  design_1_axi_dwidth_converter_0_0 axi_dwidth_converter_0
       (.m_axi_araddr(axi_dwidth_converter_0_M_AXI_ARADDR),
        .m_axi_arburst(axi_dwidth_converter_0_M_AXI_ARBURST),
        .m_axi_arcache(axi_dwidth_converter_0_M_AXI_ARCACHE),
        .m_axi_arlen(axi_dwidth_converter_0_M_AXI_ARLEN),
        .m_axi_arlock(axi_dwidth_converter_0_M_AXI_ARLOCK),
        .m_axi_arprot(axi_dwidth_converter_0_M_AXI_ARPROT),
        .m_axi_arqos(axi_dwidth_converter_0_M_AXI_ARQOS),
        .m_axi_arready(axi_dwidth_converter_0_M_AXI_ARREADY),
        .m_axi_arsize(axi_dwidth_converter_0_M_AXI_ARSIZE),
        .m_axi_arvalid(axi_dwidth_converter_0_M_AXI_ARVALID),
        .m_axi_awaddr(axi_dwidth_converter_0_M_AXI_AWADDR),
        .m_axi_awburst(axi_dwidth_converter_0_M_AXI_AWBURST),
        .m_axi_awcache(axi_dwidth_converter_0_M_AXI_AWCACHE),
        .m_axi_awlen(axi_dwidth_converter_0_M_AXI_AWLEN),
        .m_axi_awlock(axi_dwidth_converter_0_M_AXI_AWLOCK),
        .m_axi_awprot(axi_dwidth_converter_0_M_AXI_AWPROT),
        .m_axi_awqos(axi_dwidth_converter_0_M_AXI_AWQOS),
        .m_axi_awready(axi_dwidth_converter_0_M_AXI_AWREADY),
        .m_axi_awsize(axi_dwidth_converter_0_M_AXI_AWSIZE),
        .m_axi_awvalid(axi_dwidth_converter_0_M_AXI_AWVALID),
        .m_axi_bready(axi_dwidth_converter_0_M_AXI_BREADY),
        .m_axi_bresp(axi_dwidth_converter_0_M_AXI_BRESP),
        .m_axi_bvalid(axi_dwidth_converter_0_M_AXI_BVALID),
        .m_axi_rdata(axi_dwidth_converter_0_M_AXI_RDATA),
        .m_axi_rlast(axi_dwidth_converter_0_M_AXI_RLAST),
        .m_axi_rready(axi_dwidth_converter_0_M_AXI_RREADY),
        .m_axi_rresp(axi_dwidth_converter_0_M_AXI_RRESP),
        .m_axi_rvalid(axi_dwidth_converter_0_M_AXI_RVALID),
        .m_axi_wdata(axi_dwidth_converter_0_M_AXI_WDATA),
        .m_axi_wlast(axi_dwidth_converter_0_M_AXI_WLAST),
        .m_axi_wready(axi_dwidth_converter_0_M_AXI_WREADY),
        .m_axi_wstrb(axi_dwidth_converter_0_M_AXI_WSTRB),
        .m_axi_wvalid(axi_dwidth_converter_0_M_AXI_WVALID),
        .s_axi_aclk(zynq_ultra_ps_e_0_pl_clk0),
        .s_axi_araddr(SpatialIP_0_io_M_AXI_0_ARADDR[31:0]),
        .s_axi_arburst(SpatialIP_0_io_M_AXI_0_ARBURST),
        .s_axi_arcache(SpatialIP_0_io_M_AXI_0_ARCACHE),
        .s_axi_aresetn(rst_ps8_0_99M_peripheral_aresetn),
        .s_axi_arid(SpatialIP_0_io_M_AXI_0_ARID),
        .s_axi_arlen(SpatialIP_0_io_M_AXI_0_ARLEN),
        .s_axi_arlock(SpatialIP_0_io_M_AXI_0_ARLOCK),
        .s_axi_arprot(SpatialIP_0_io_M_AXI_0_ARPROT),
        .s_axi_arqos(SpatialIP_0_io_M_AXI_0_ARQOS),
        .s_axi_arready(SpatialIP_0_io_M_AXI_0_ARREADY),
        .s_axi_arregion({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_arsize(SpatialIP_0_io_M_AXI_0_ARSIZE),
        .s_axi_arvalid(SpatialIP_0_io_M_AXI_0_ARVALID),
        .s_axi_awaddr(SpatialIP_0_io_M_AXI_0_AWADDR[31:0]),
        .s_axi_awburst(SpatialIP_0_io_M_AXI_0_AWBURST),
        .s_axi_awcache(SpatialIP_0_io_M_AXI_0_AWCACHE),
        .s_axi_awid(SpatialIP_0_io_M_AXI_0_AWID),
        .s_axi_awlen(SpatialIP_0_io_M_AXI_0_AWLEN),
        .s_axi_awlock(SpatialIP_0_io_M_AXI_0_AWLOCK),
        .s_axi_awprot(SpatialIP_0_io_M_AXI_0_AWPROT),
        .s_axi_awqos(SpatialIP_0_io_M_AXI_0_AWQOS),
        .s_axi_awready(SpatialIP_0_io_M_AXI_0_AWREADY),
        .s_axi_awregion({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_awsize(SpatialIP_0_io_M_AXI_0_AWSIZE),
        .s_axi_awvalid(SpatialIP_0_io_M_AXI_0_AWVALID),
        .s_axi_bid(SpatialIP_0_io_M_AXI_0_BID),
        .s_axi_bready(SpatialIP_0_io_M_AXI_0_BREADY),
        .s_axi_bresp(SpatialIP_0_io_M_AXI_0_BRESP),
        .s_axi_bvalid(SpatialIP_0_io_M_AXI_0_BVALID),
        .s_axi_rdata(SpatialIP_0_io_M_AXI_0_RDATA),
        .s_axi_rid(SpatialIP_0_io_M_AXI_0_RID),
        .s_axi_rlast(SpatialIP_0_io_M_AXI_0_RLAST),
        .s_axi_rready(SpatialIP_0_io_M_AXI_0_RREADY),
        .s_axi_rresp(SpatialIP_0_io_M_AXI_0_RRESP),
        .s_axi_rvalid(SpatialIP_0_io_M_AXI_0_RVALID),
        .s_axi_wdata(SpatialIP_0_io_M_AXI_0_WDATA),
        .s_axi_wlast(SpatialIP_0_io_M_AXI_0_WLAST),
        .s_axi_wready(SpatialIP_0_io_M_AXI_0_WREADY),
        .s_axi_wstrb(SpatialIP_0_io_M_AXI_0_WSTRB),
        .s_axi_wvalid(SpatialIP_0_io_M_AXI_0_WVALID));
  design_1_axi_dwidth_converter_1_0 axi_dwidth_converter_1
       (.m_axi_araddr(axi_dwidth_converter_1_M_AXI_ARADDR),
        .m_axi_arburst(axi_dwidth_converter_1_M_AXI_ARBURST),
        .m_axi_arcache(axi_dwidth_converter_1_M_AXI_ARCACHE),
        .m_axi_arlen(axi_dwidth_converter_1_M_AXI_ARLEN),
        .m_axi_arlock(axi_dwidth_converter_1_M_AXI_ARLOCK),
        .m_axi_arprot(axi_dwidth_converter_1_M_AXI_ARPROT),
        .m_axi_arqos(axi_dwidth_converter_1_M_AXI_ARQOS),
        .m_axi_arready(axi_dwidth_converter_1_M_AXI_ARREADY),
        .m_axi_arsize(axi_dwidth_converter_1_M_AXI_ARSIZE),
        .m_axi_arvalid(axi_dwidth_converter_1_M_AXI_ARVALID),
        .m_axi_awaddr(axi_dwidth_converter_1_M_AXI_AWADDR),
        .m_axi_awburst(axi_dwidth_converter_1_M_AXI_AWBURST),
        .m_axi_awcache(axi_dwidth_converter_1_M_AXI_AWCACHE),
        .m_axi_awlen(axi_dwidth_converter_1_M_AXI_AWLEN),
        .m_axi_awlock(axi_dwidth_converter_1_M_AXI_AWLOCK),
        .m_axi_awprot(axi_dwidth_converter_1_M_AXI_AWPROT),
        .m_axi_awqos(axi_dwidth_converter_1_M_AXI_AWQOS),
        .m_axi_awready(axi_dwidth_converter_1_M_AXI_AWREADY),
        .m_axi_awsize(axi_dwidth_converter_1_M_AXI_AWSIZE),
        .m_axi_awvalid(axi_dwidth_converter_1_M_AXI_AWVALID),
        .m_axi_bready(axi_dwidth_converter_1_M_AXI_BREADY),
        .m_axi_bresp(axi_dwidth_converter_1_M_AXI_BRESP),
        .m_axi_bvalid(axi_dwidth_converter_1_M_AXI_BVALID),
        .m_axi_rdata(axi_dwidth_converter_1_M_AXI_RDATA),
        .m_axi_rlast(axi_dwidth_converter_1_M_AXI_RLAST),
        .m_axi_rready(axi_dwidth_converter_1_M_AXI_RREADY),
        .m_axi_rresp(axi_dwidth_converter_1_M_AXI_RRESP),
        .m_axi_rvalid(axi_dwidth_converter_1_M_AXI_RVALID),
        .m_axi_wdata(axi_dwidth_converter_1_M_AXI_WDATA),
        .m_axi_wlast(axi_dwidth_converter_1_M_AXI_WLAST),
        .m_axi_wready(axi_dwidth_converter_1_M_AXI_WREADY),
        .m_axi_wstrb(axi_dwidth_converter_1_M_AXI_WSTRB),
        .m_axi_wvalid(axi_dwidth_converter_1_M_AXI_WVALID),
        .s_axi_aclk(zynq_ultra_ps_e_0_pl_clk0),
        .s_axi_araddr(SpatialIP_0_io_M_AXI_1_ARADDR[31:0]),
        .s_axi_arburst(SpatialIP_0_io_M_AXI_1_ARBURST),
        .s_axi_arcache(SpatialIP_0_io_M_AXI_1_ARCACHE),
        .s_axi_aresetn(rst_ps8_0_99M_peripheral_aresetn),
        .s_axi_arid(SpatialIP_0_io_M_AXI_1_ARID),
        .s_axi_arlen(SpatialIP_0_io_M_AXI_1_ARLEN),
        .s_axi_arlock(SpatialIP_0_io_M_AXI_1_ARLOCK),
        .s_axi_arprot(SpatialIP_0_io_M_AXI_1_ARPROT),
        .s_axi_arqos(SpatialIP_0_io_M_AXI_1_ARQOS),
        .s_axi_arready(SpatialIP_0_io_M_AXI_1_ARREADY),
        .s_axi_arregion({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_arsize(SpatialIP_0_io_M_AXI_1_ARSIZE),
        .s_axi_arvalid(SpatialIP_0_io_M_AXI_1_ARVALID),
        .s_axi_awaddr(SpatialIP_0_io_M_AXI_1_AWADDR[31:0]),
        .s_axi_awburst(SpatialIP_0_io_M_AXI_1_AWBURST),
        .s_axi_awcache(SpatialIP_0_io_M_AXI_1_AWCACHE),
        .s_axi_awid(SpatialIP_0_io_M_AXI_1_AWID),
        .s_axi_awlen(SpatialIP_0_io_M_AXI_1_AWLEN),
        .s_axi_awlock(SpatialIP_0_io_M_AXI_1_AWLOCK),
        .s_axi_awprot(SpatialIP_0_io_M_AXI_1_AWPROT),
        .s_axi_awqos(SpatialIP_0_io_M_AXI_1_AWQOS),
        .s_axi_awready(SpatialIP_0_io_M_AXI_1_AWREADY),
        .s_axi_awregion({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_awsize(SpatialIP_0_io_M_AXI_1_AWSIZE),
        .s_axi_awvalid(SpatialIP_0_io_M_AXI_1_AWVALID),
        .s_axi_bid(SpatialIP_0_io_M_AXI_1_BID),
        .s_axi_bready(SpatialIP_0_io_M_AXI_1_BREADY),
        .s_axi_bresp(SpatialIP_0_io_M_AXI_1_BRESP),
        .s_axi_bvalid(SpatialIP_0_io_M_AXI_1_BVALID),
        .s_axi_rdata(SpatialIP_0_io_M_AXI_1_RDATA),
        .s_axi_rid(SpatialIP_0_io_M_AXI_1_RID),
        .s_axi_rlast(SpatialIP_0_io_M_AXI_1_RLAST),
        .s_axi_rready(SpatialIP_0_io_M_AXI_1_RREADY),
        .s_axi_rresp(SpatialIP_0_io_M_AXI_1_RRESP),
        .s_axi_rvalid(SpatialIP_0_io_M_AXI_1_RVALID),
        .s_axi_wdata(SpatialIP_0_io_M_AXI_1_WDATA),
        .s_axi_wlast(SpatialIP_0_io_M_AXI_1_WLAST),
        .s_axi_wready(SpatialIP_0_io_M_AXI_1_WREADY),
        .s_axi_wstrb(SpatialIP_0_io_M_AXI_1_WSTRB),
        .s_axi_wvalid(SpatialIP_0_io_M_AXI_1_WVALID));
  design_1_ps8_0_axi_periph_0 ps8_0_axi_periph
       (.ACLK(zynq_ultra_ps_e_0_pl_clk0),
        .ARESETN(rst_ps8_0_99M_peripheral_aresetn),
        .M00_ACLK(zynq_ultra_ps_e_0_pl_clk0),
        .M00_ARESETN(rst_ps8_0_99M_peripheral_aresetn),
        .M00_AXI_araddr(ps8_0_axi_periph_M00_AXI_ARADDR),
        .M00_AXI_arprot(ps8_0_axi_periph_M00_AXI_ARPROT),
        .M00_AXI_arready(ps8_0_axi_periph_M00_AXI_ARREADY),
        .M00_AXI_arvalid(ps8_0_axi_periph_M00_AXI_ARVALID),
        .M00_AXI_awaddr(ps8_0_axi_periph_M00_AXI_AWADDR),
        .M00_AXI_awprot(ps8_0_axi_periph_M00_AXI_AWPROT),
        .M00_AXI_awready(ps8_0_axi_periph_M00_AXI_AWREADY),
        .M00_AXI_awvalid(ps8_0_axi_periph_M00_AXI_AWVALID),
        .M00_AXI_bready(ps8_0_axi_periph_M00_AXI_BREADY),
        .M00_AXI_bresp(ps8_0_axi_periph_M00_AXI_BRESP),
        .M00_AXI_bvalid(ps8_0_axi_periph_M00_AXI_BVALID),
        .M00_AXI_rdata(ps8_0_axi_periph_M00_AXI_RDATA),
        .M00_AXI_rready(ps8_0_axi_periph_M00_AXI_RREADY),
        .M00_AXI_rresp(ps8_0_axi_periph_M00_AXI_RRESP),
        .M00_AXI_rvalid(ps8_0_axi_periph_M00_AXI_RVALID),
        .M00_AXI_wdata(ps8_0_axi_periph_M00_AXI_WDATA),
        .M00_AXI_wready(ps8_0_axi_periph_M00_AXI_WREADY),
        .M00_AXI_wstrb(ps8_0_axi_periph_M00_AXI_WSTRB),
        .M00_AXI_wvalid(ps8_0_axi_periph_M00_AXI_WVALID),
        .S00_ACLK(zynq_ultra_ps_e_0_pl_clk0),
        .S00_ARESETN(rst_ps8_0_99M_peripheral_aresetn),
        .S00_AXI_araddr(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARADDR),
        .S00_AXI_arburst(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARBURST),
        .S00_AXI_arcache(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARCACHE),
        .S00_AXI_arid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARID),
        .S00_AXI_arlen(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARLEN),
        .S00_AXI_arlock(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARLOCK),
        .S00_AXI_arprot(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARPROT),
        .S00_AXI_arqos(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARQOS),
        .S00_AXI_arready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARREADY),
        .S00_AXI_arsize(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARSIZE),
        .S00_AXI_arvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARVALID),
        .S00_AXI_awaddr(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWADDR),
        .S00_AXI_awburst(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWBURST),
        .S00_AXI_awcache(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWCACHE),
        .S00_AXI_awid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWID),
        .S00_AXI_awlen(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWLEN),
        .S00_AXI_awlock(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWLOCK),
        .S00_AXI_awprot(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWPROT),
        .S00_AXI_awqos(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWQOS),
        .S00_AXI_awready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWREADY),
        .S00_AXI_awsize(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWSIZE),
        .S00_AXI_awvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWVALID),
        .S00_AXI_bid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BID),
        .S00_AXI_bready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BREADY),
        .S00_AXI_bresp(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BRESP),
        .S00_AXI_bvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BVALID),
        .S00_AXI_rdata(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RDATA),
        .S00_AXI_rid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RID),
        .S00_AXI_rlast(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RLAST),
        .S00_AXI_rready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RREADY),
        .S00_AXI_rresp(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RRESP),
        .S00_AXI_rvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RVALID),
        .S00_AXI_wdata(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WDATA),
        .S00_AXI_wlast(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WLAST),
        .S00_AXI_wready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WREADY),
        .S00_AXI_wstrb(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WSTRB),
        .S00_AXI_wvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WVALID));
  design_1_rst_ps8_0_99M_0 rst_ps8_0_99M
       (.aux_reset_in(1'b1),
        .dcm_locked(1'b1),
        .ext_reset_in(zynq_ultra_ps_e_0_pl_resetn0),
        .mb_debug_sys_rst(1'b0),
        .peripheral_aresetn(rst_ps8_0_99M_peripheral_aresetn),
        .slowest_sync_clk(zynq_ultra_ps_e_0_pl_clk0));
  design_1_zynq_ultra_ps_e_0_0 zynq_ultra_ps_e_0
       (.maxigp0_araddr(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARADDR),
        .maxigp0_arburst(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARBURST),
        .maxigp0_arcache(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARCACHE),
        .maxigp0_arid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARID),
        .maxigp0_arlen(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARLEN),
        .maxigp0_arlock(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARLOCK),
        .maxigp0_arprot(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARPROT),
        .maxigp0_arqos(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARQOS),
        .maxigp0_arready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARREADY),
        .maxigp0_arsize(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARSIZE),
        .maxigp0_arvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_ARVALID),
        .maxigp0_awaddr(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWADDR),
        .maxigp0_awburst(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWBURST),
        .maxigp0_awcache(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWCACHE),
        .maxigp0_awid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWID),
        .maxigp0_awlen(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWLEN),
        .maxigp0_awlock(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWLOCK),
        .maxigp0_awprot(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWPROT),
        .maxigp0_awqos(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWQOS),
        .maxigp0_awready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWREADY),
        .maxigp0_awsize(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWSIZE),
        .maxigp0_awvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_AWVALID),
        .maxigp0_bid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BID),
        .maxigp0_bready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BREADY),
        .maxigp0_bresp(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BRESP),
        .maxigp0_bvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_BVALID),
        .maxigp0_rdata(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RDATA),
        .maxigp0_rid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RID),
        .maxigp0_rlast(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RLAST),
        .maxigp0_rready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RREADY),
        .maxigp0_rresp(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RRESP),
        .maxigp0_rvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_RVALID),
        .maxigp0_wdata(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WDATA),
        .maxigp0_wlast(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WLAST),
        .maxigp0_wready(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WREADY),
        .maxigp0_wstrb(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WSTRB),
        .maxigp0_wvalid(zynq_ultra_ps_e_0_M_AXI_HPM0_FPD_WVALID),
        .maxigp1_arready(1'b0),
        .maxigp1_awready(1'b0),
        .maxigp1_bid({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .maxigp1_bresp({1'b0,1'b0}),
        .maxigp1_bvalid(1'b0),
        .maxigp1_rdata({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .maxigp1_rid({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .maxigp1_rlast(1'b0),
        .maxigp1_rresp({1'b0,1'b0}),
        .maxigp1_rvalid(1'b0),
        .maxigp1_wready(1'b0),
        .maxihpm0_fpd_aclk(zynq_ultra_ps_e_0_pl_clk0),
        .maxihpm1_fpd_aclk(zynq_ultra_ps_e_0_pl_clk0),
        .pl_clk0(zynq_ultra_ps_e_0_pl_clk0),
        .pl_ps_irq0(1'b0),
        .pl_resetn0(zynq_ultra_ps_e_0_pl_resetn0),
        .saxigp0_araddr({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,axi_dwidth_converter_0_M_AXI_ARADDR}),
        .saxigp0_arburst(axi_dwidth_converter_0_M_AXI_ARBURST),
        .saxigp0_arcache(axi_dwidth_converter_0_M_AXI_ARCACHE),
        .saxigp0_arid({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .saxigp0_arlen(axi_dwidth_converter_0_M_AXI_ARLEN),
        .saxigp0_arlock(axi_dwidth_converter_0_M_AXI_ARLOCK),
        .saxigp0_arprot(axi_dwidth_converter_0_M_AXI_ARPROT),
        .saxigp0_arqos(axi_dwidth_converter_0_M_AXI_ARQOS),
        .saxigp0_arready(axi_dwidth_converter_0_M_AXI_ARREADY),
        .saxigp0_arsize(axi_dwidth_converter_0_M_AXI_ARSIZE),
        .saxigp0_aruser(1'b0),
        .saxigp0_arvalid(axi_dwidth_converter_0_M_AXI_ARVALID),
        .saxigp0_awaddr({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,axi_dwidth_converter_0_M_AXI_AWADDR}),
        .saxigp0_awburst(axi_dwidth_converter_0_M_AXI_AWBURST),
        .saxigp0_awcache(axi_dwidth_converter_0_M_AXI_AWCACHE),
        .saxigp0_awid({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .saxigp0_awlen(axi_dwidth_converter_0_M_AXI_AWLEN),
        .saxigp0_awlock(axi_dwidth_converter_0_M_AXI_AWLOCK),
        .saxigp0_awprot(axi_dwidth_converter_0_M_AXI_AWPROT),
        .saxigp0_awqos(axi_dwidth_converter_0_M_AXI_AWQOS),
        .saxigp0_awready(axi_dwidth_converter_0_M_AXI_AWREADY),
        .saxigp0_awsize(axi_dwidth_converter_0_M_AXI_AWSIZE),
        .saxigp0_awuser(1'b0),
        .saxigp0_awvalid(axi_dwidth_converter_0_M_AXI_AWVALID),
        .saxigp0_bready(axi_dwidth_converter_0_M_AXI_BREADY),
        .saxigp0_bresp(axi_dwidth_converter_0_M_AXI_BRESP),
        .saxigp0_bvalid(axi_dwidth_converter_0_M_AXI_BVALID),
        .saxigp0_rdata(axi_dwidth_converter_0_M_AXI_RDATA),
        .saxigp0_rlast(axi_dwidth_converter_0_M_AXI_RLAST),
        .saxigp0_rready(axi_dwidth_converter_0_M_AXI_RREADY),
        .saxigp0_rresp(axi_dwidth_converter_0_M_AXI_RRESP),
        .saxigp0_rvalid(axi_dwidth_converter_0_M_AXI_RVALID),
        .saxigp0_wdata(axi_dwidth_converter_0_M_AXI_WDATA),
        .saxigp0_wlast(axi_dwidth_converter_0_M_AXI_WLAST),
        .saxigp0_wready(axi_dwidth_converter_0_M_AXI_WREADY),
        .saxigp0_wstrb(axi_dwidth_converter_0_M_AXI_WSTRB),
        .saxigp0_wvalid(axi_dwidth_converter_0_M_AXI_WVALID),
        .saxigp1_araddr({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,axi_dwidth_converter_1_M_AXI_ARADDR}),
        .saxigp1_arburst(axi_dwidth_converter_1_M_AXI_ARBURST),
        .saxigp1_arcache(axi_dwidth_converter_1_M_AXI_ARCACHE),
        .saxigp1_arid({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .saxigp1_arlen(axi_dwidth_converter_1_M_AXI_ARLEN),
        .saxigp1_arlock(axi_dwidth_converter_1_M_AXI_ARLOCK),
        .saxigp1_arprot(axi_dwidth_converter_1_M_AXI_ARPROT),
        .saxigp1_arqos(axi_dwidth_converter_1_M_AXI_ARQOS),
        .saxigp1_arready(axi_dwidth_converter_1_M_AXI_ARREADY),
        .saxigp1_arsize(axi_dwidth_converter_1_M_AXI_ARSIZE),
        .saxigp1_aruser(1'b0),
        .saxigp1_arvalid(axi_dwidth_converter_1_M_AXI_ARVALID),
        .saxigp1_awaddr({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,1'b0,axi_dwidth_converter_1_M_AXI_AWADDR}),
        .saxigp1_awburst(axi_dwidth_converter_1_M_AXI_AWBURST),
        .saxigp1_awcache(axi_dwidth_converter_1_M_AXI_AWCACHE),
        .saxigp1_awid({1'b0,1'b0,1'b0,1'b0,1'b0,1'b0}),
        .saxigp1_awlen(axi_dwidth_converter_1_M_AXI_AWLEN),
        .saxigp1_awlock(axi_dwidth_converter_1_M_AXI_AWLOCK),
        .saxigp1_awprot(axi_dwidth_converter_1_M_AXI_AWPROT),
        .saxigp1_awqos(axi_dwidth_converter_1_M_AXI_AWQOS),
        .saxigp1_awready(axi_dwidth_converter_1_M_AXI_AWREADY),
        .saxigp1_awsize(axi_dwidth_converter_1_M_AXI_AWSIZE),
        .saxigp1_awuser(1'b0),
        .saxigp1_awvalid(axi_dwidth_converter_1_M_AXI_AWVALID),
        .saxigp1_bready(axi_dwidth_converter_1_M_AXI_BREADY),
        .saxigp1_bresp(axi_dwidth_converter_1_M_AXI_BRESP),
        .saxigp1_bvalid(axi_dwidth_converter_1_M_AXI_BVALID),
        .saxigp1_rdata(axi_dwidth_converter_1_M_AXI_RDATA),
        .saxigp1_rlast(axi_dwidth_converter_1_M_AXI_RLAST),
        .saxigp1_rready(axi_dwidth_converter_1_M_AXI_RREADY),
        .saxigp1_rresp(axi_dwidth_converter_1_M_AXI_RRESP),
        .saxigp1_rvalid(axi_dwidth_converter_1_M_AXI_RVALID),
        .saxigp1_wdata(axi_dwidth_converter_1_M_AXI_WDATA),
        .saxigp1_wlast(axi_dwidth_converter_1_M_AXI_WLAST),
        .saxigp1_wready(axi_dwidth_converter_1_M_AXI_WREADY),
        .saxigp1_wstrb(axi_dwidth_converter_1_M_AXI_WSTRB),
        .saxigp1_wvalid(axi_dwidth_converter_1_M_AXI_WVALID),
        .saxihpc0_fpd_aclk(zynq_ultra_ps_e_0_pl_clk0),
        .saxihpc1_fpd_aclk(zynq_ultra_ps_e_0_pl_clk0));
endmodule

module design_1_ps8_0_axi_periph_0
   (ACLK,
    ARESETN,
    M00_ACLK,
    M00_ARESETN,
    M00_AXI_araddr,
    M00_AXI_arprot,
    M00_AXI_arready,
    M00_AXI_arvalid,
    M00_AXI_awaddr,
    M00_AXI_awprot,
    M00_AXI_awready,
    M00_AXI_awvalid,
    M00_AXI_bready,
    M00_AXI_bresp,
    M00_AXI_bvalid,
    M00_AXI_rdata,
    M00_AXI_rready,
    M00_AXI_rresp,
    M00_AXI_rvalid,
    M00_AXI_wdata,
    M00_AXI_wready,
    M00_AXI_wstrb,
    M00_AXI_wvalid,
    S00_ACLK,
    S00_ARESETN,
    S00_AXI_araddr,
    S00_AXI_arburst,
    S00_AXI_arcache,
    S00_AXI_arid,
    S00_AXI_arlen,
    S00_AXI_arlock,
    S00_AXI_arprot,
    S00_AXI_arqos,
    S00_AXI_arready,
    S00_AXI_arsize,
    S00_AXI_arvalid,
    S00_AXI_awaddr,
    S00_AXI_awburst,
    S00_AXI_awcache,
    S00_AXI_awid,
    S00_AXI_awlen,
    S00_AXI_awlock,
    S00_AXI_awprot,
    S00_AXI_awqos,
    S00_AXI_awready,
    S00_AXI_awsize,
    S00_AXI_awvalid,
    S00_AXI_bid,
    S00_AXI_bready,
    S00_AXI_bresp,
    S00_AXI_bvalid,
    S00_AXI_rdata,
    S00_AXI_rid,
    S00_AXI_rlast,
    S00_AXI_rready,
    S00_AXI_rresp,
    S00_AXI_rvalid,
    S00_AXI_wdata,
    S00_AXI_wlast,
    S00_AXI_wready,
    S00_AXI_wstrb,
    S00_AXI_wvalid);
  input ACLK;
  input ARESETN;
  input M00_ACLK;
  input M00_ARESETN;
  output [39:0]M00_AXI_araddr;
  output [2:0]M00_AXI_arprot;
  input M00_AXI_arready;
  output M00_AXI_arvalid;
  output [39:0]M00_AXI_awaddr;
  output [2:0]M00_AXI_awprot;
  input M00_AXI_awready;
  output M00_AXI_awvalid;
  output M00_AXI_bready;
  input [1:0]M00_AXI_bresp;
  input M00_AXI_bvalid;
  input [63:0]M00_AXI_rdata;
  output M00_AXI_rready;
  input [1:0]M00_AXI_rresp;
  input M00_AXI_rvalid;
  output [63:0]M00_AXI_wdata;
  input M00_AXI_wready;
  output [7:0]M00_AXI_wstrb;
  output M00_AXI_wvalid;
  input S00_ACLK;
  input S00_ARESETN;
  input [39:0]S00_AXI_araddr;
  input [1:0]S00_AXI_arburst;
  input [3:0]S00_AXI_arcache;
  input [15:0]S00_AXI_arid;
  input [7:0]S00_AXI_arlen;
  input [0:0]S00_AXI_arlock;
  input [2:0]S00_AXI_arprot;
  input [3:0]S00_AXI_arqos;
  output S00_AXI_arready;
  input [2:0]S00_AXI_arsize;
  input S00_AXI_arvalid;
  input [39:0]S00_AXI_awaddr;
  input [1:0]S00_AXI_awburst;
  input [3:0]S00_AXI_awcache;
  input [15:0]S00_AXI_awid;
  input [7:0]S00_AXI_awlen;
  input [0:0]S00_AXI_awlock;
  input [2:0]S00_AXI_awprot;
  input [3:0]S00_AXI_awqos;
  output S00_AXI_awready;
  input [2:0]S00_AXI_awsize;
  input S00_AXI_awvalid;
  output [15:0]S00_AXI_bid;
  input S00_AXI_bready;
  output [1:0]S00_AXI_bresp;
  output S00_AXI_bvalid;
  output [127:0]S00_AXI_rdata;
  output [15:0]S00_AXI_rid;
  output S00_AXI_rlast;
  input S00_AXI_rready;
  output [1:0]S00_AXI_rresp;
  output S00_AXI_rvalid;
  input [127:0]S00_AXI_wdata;
  input S00_AXI_wlast;
  output S00_AXI_wready;
  input [15:0]S00_AXI_wstrb;
  input S00_AXI_wvalid;

  wire S00_ACLK_1;
  wire S00_ARESETN_1;
  wire ps8_0_axi_periph_ACLK_net;
  wire ps8_0_axi_periph_ARESETN_net;
  wire [39:0]ps8_0_axi_periph_to_s00_couplers_ARADDR;
  wire [1:0]ps8_0_axi_periph_to_s00_couplers_ARBURST;
  wire [3:0]ps8_0_axi_periph_to_s00_couplers_ARCACHE;
  wire [15:0]ps8_0_axi_periph_to_s00_couplers_ARID;
  wire [7:0]ps8_0_axi_periph_to_s00_couplers_ARLEN;
  wire [0:0]ps8_0_axi_periph_to_s00_couplers_ARLOCK;
  wire [2:0]ps8_0_axi_periph_to_s00_couplers_ARPROT;
  wire [3:0]ps8_0_axi_periph_to_s00_couplers_ARQOS;
  wire ps8_0_axi_periph_to_s00_couplers_ARREADY;
  wire [2:0]ps8_0_axi_periph_to_s00_couplers_ARSIZE;
  wire ps8_0_axi_periph_to_s00_couplers_ARVALID;
  wire [39:0]ps8_0_axi_periph_to_s00_couplers_AWADDR;
  wire [1:0]ps8_0_axi_periph_to_s00_couplers_AWBURST;
  wire [3:0]ps8_0_axi_periph_to_s00_couplers_AWCACHE;
  wire [15:0]ps8_0_axi_periph_to_s00_couplers_AWID;
  wire [7:0]ps8_0_axi_periph_to_s00_couplers_AWLEN;
  wire [0:0]ps8_0_axi_periph_to_s00_couplers_AWLOCK;
  wire [2:0]ps8_0_axi_periph_to_s00_couplers_AWPROT;
  wire [3:0]ps8_0_axi_periph_to_s00_couplers_AWQOS;
  wire ps8_0_axi_periph_to_s00_couplers_AWREADY;
  wire [2:0]ps8_0_axi_periph_to_s00_couplers_AWSIZE;
  wire ps8_0_axi_periph_to_s00_couplers_AWVALID;
  wire [15:0]ps8_0_axi_periph_to_s00_couplers_BID;
  wire ps8_0_axi_periph_to_s00_couplers_BREADY;
  wire [1:0]ps8_0_axi_periph_to_s00_couplers_BRESP;
  wire ps8_0_axi_periph_to_s00_couplers_BVALID;
  wire [127:0]ps8_0_axi_periph_to_s00_couplers_RDATA;
  wire [15:0]ps8_0_axi_periph_to_s00_couplers_RID;
  wire ps8_0_axi_periph_to_s00_couplers_RLAST;
  wire ps8_0_axi_periph_to_s00_couplers_RREADY;
  wire [1:0]ps8_0_axi_periph_to_s00_couplers_RRESP;
  wire ps8_0_axi_periph_to_s00_couplers_RVALID;
  wire [127:0]ps8_0_axi_periph_to_s00_couplers_WDATA;
  wire ps8_0_axi_periph_to_s00_couplers_WLAST;
  wire ps8_0_axi_periph_to_s00_couplers_WREADY;
  wire [15:0]ps8_0_axi_periph_to_s00_couplers_WSTRB;
  wire ps8_0_axi_periph_to_s00_couplers_WVALID;
  wire [39:0]s00_couplers_to_ps8_0_axi_periph_ARADDR;
  wire [2:0]s00_couplers_to_ps8_0_axi_periph_ARPROT;
  wire s00_couplers_to_ps8_0_axi_periph_ARREADY;
  wire s00_couplers_to_ps8_0_axi_periph_ARVALID;
  wire [39:0]s00_couplers_to_ps8_0_axi_periph_AWADDR;
  wire [2:0]s00_couplers_to_ps8_0_axi_periph_AWPROT;
  wire s00_couplers_to_ps8_0_axi_periph_AWREADY;
  wire s00_couplers_to_ps8_0_axi_periph_AWVALID;
  wire s00_couplers_to_ps8_0_axi_periph_BREADY;
  wire [1:0]s00_couplers_to_ps8_0_axi_periph_BRESP;
  wire s00_couplers_to_ps8_0_axi_periph_BVALID;
  wire [63:0]s00_couplers_to_ps8_0_axi_periph_RDATA;
  wire s00_couplers_to_ps8_0_axi_periph_RREADY;
  wire [1:0]s00_couplers_to_ps8_0_axi_periph_RRESP;
  wire s00_couplers_to_ps8_0_axi_periph_RVALID;
  wire [63:0]s00_couplers_to_ps8_0_axi_periph_WDATA;
  wire s00_couplers_to_ps8_0_axi_periph_WREADY;
  wire [7:0]s00_couplers_to_ps8_0_axi_periph_WSTRB;
  wire s00_couplers_to_ps8_0_axi_periph_WVALID;

  assign M00_AXI_araddr[39:0] = s00_couplers_to_ps8_0_axi_periph_ARADDR;
  assign M00_AXI_arprot[2:0] = s00_couplers_to_ps8_0_axi_periph_ARPROT;
  assign M00_AXI_arvalid = s00_couplers_to_ps8_0_axi_periph_ARVALID;
  assign M00_AXI_awaddr[39:0] = s00_couplers_to_ps8_0_axi_periph_AWADDR;
  assign M00_AXI_awprot[2:0] = s00_couplers_to_ps8_0_axi_periph_AWPROT;
  assign M00_AXI_awvalid = s00_couplers_to_ps8_0_axi_periph_AWVALID;
  assign M00_AXI_bready = s00_couplers_to_ps8_0_axi_periph_BREADY;
  assign M00_AXI_rready = s00_couplers_to_ps8_0_axi_periph_RREADY;
  assign M00_AXI_wdata[63:0] = s00_couplers_to_ps8_0_axi_periph_WDATA;
  assign M00_AXI_wstrb[7:0] = s00_couplers_to_ps8_0_axi_periph_WSTRB;
  assign M00_AXI_wvalid = s00_couplers_to_ps8_0_axi_periph_WVALID;
  assign S00_ACLK_1 = S00_ACLK;
  assign S00_ARESETN_1 = S00_ARESETN;
  assign S00_AXI_arready = ps8_0_axi_periph_to_s00_couplers_ARREADY;
  assign S00_AXI_awready = ps8_0_axi_periph_to_s00_couplers_AWREADY;
  assign S00_AXI_bid[15:0] = ps8_0_axi_periph_to_s00_couplers_BID;
  assign S00_AXI_bresp[1:0] = ps8_0_axi_periph_to_s00_couplers_BRESP;
  assign S00_AXI_bvalid = ps8_0_axi_periph_to_s00_couplers_BVALID;
  assign S00_AXI_rdata[127:0] = ps8_0_axi_periph_to_s00_couplers_RDATA;
  assign S00_AXI_rid[15:0] = ps8_0_axi_periph_to_s00_couplers_RID;
  assign S00_AXI_rlast = ps8_0_axi_periph_to_s00_couplers_RLAST;
  assign S00_AXI_rresp[1:0] = ps8_0_axi_periph_to_s00_couplers_RRESP;
  assign S00_AXI_rvalid = ps8_0_axi_periph_to_s00_couplers_RVALID;
  assign S00_AXI_wready = ps8_0_axi_periph_to_s00_couplers_WREADY;
  assign ps8_0_axi_periph_ACLK_net = M00_ACLK;
  assign ps8_0_axi_periph_ARESETN_net = M00_ARESETN;
  assign ps8_0_axi_periph_to_s00_couplers_ARADDR = S00_AXI_araddr[39:0];
  assign ps8_0_axi_periph_to_s00_couplers_ARBURST = S00_AXI_arburst[1:0];
  assign ps8_0_axi_periph_to_s00_couplers_ARCACHE = S00_AXI_arcache[3:0];
  assign ps8_0_axi_periph_to_s00_couplers_ARID = S00_AXI_arid[15:0];
  assign ps8_0_axi_periph_to_s00_couplers_ARLEN = S00_AXI_arlen[7:0];
  assign ps8_0_axi_periph_to_s00_couplers_ARLOCK = S00_AXI_arlock[0];
  assign ps8_0_axi_periph_to_s00_couplers_ARPROT = S00_AXI_arprot[2:0];
  assign ps8_0_axi_periph_to_s00_couplers_ARQOS = S00_AXI_arqos[3:0];
  assign ps8_0_axi_periph_to_s00_couplers_ARSIZE = S00_AXI_arsize[2:0];
  assign ps8_0_axi_periph_to_s00_couplers_ARVALID = S00_AXI_arvalid;
  assign ps8_0_axi_periph_to_s00_couplers_AWADDR = S00_AXI_awaddr[39:0];
  assign ps8_0_axi_periph_to_s00_couplers_AWBURST = S00_AXI_awburst[1:0];
  assign ps8_0_axi_periph_to_s00_couplers_AWCACHE = S00_AXI_awcache[3:0];
  assign ps8_0_axi_periph_to_s00_couplers_AWID = S00_AXI_awid[15:0];
  assign ps8_0_axi_periph_to_s00_couplers_AWLEN = S00_AXI_awlen[7:0];
  assign ps8_0_axi_periph_to_s00_couplers_AWLOCK = S00_AXI_awlock[0];
  assign ps8_0_axi_periph_to_s00_couplers_AWPROT = S00_AXI_awprot[2:0];
  assign ps8_0_axi_periph_to_s00_couplers_AWQOS = S00_AXI_awqos[3:0];
  assign ps8_0_axi_periph_to_s00_couplers_AWSIZE = S00_AXI_awsize[2:0];
  assign ps8_0_axi_periph_to_s00_couplers_AWVALID = S00_AXI_awvalid;
  assign ps8_0_axi_periph_to_s00_couplers_BREADY = S00_AXI_bready;
  assign ps8_0_axi_periph_to_s00_couplers_RREADY = S00_AXI_rready;
  assign ps8_0_axi_periph_to_s00_couplers_WDATA = S00_AXI_wdata[127:0];
  assign ps8_0_axi_periph_to_s00_couplers_WLAST = S00_AXI_wlast;
  assign ps8_0_axi_periph_to_s00_couplers_WSTRB = S00_AXI_wstrb[15:0];
  assign ps8_0_axi_periph_to_s00_couplers_WVALID = S00_AXI_wvalid;
  assign s00_couplers_to_ps8_0_axi_periph_ARREADY = M00_AXI_arready;
  assign s00_couplers_to_ps8_0_axi_periph_AWREADY = M00_AXI_awready;
  assign s00_couplers_to_ps8_0_axi_periph_BRESP = M00_AXI_bresp[1:0];
  assign s00_couplers_to_ps8_0_axi_periph_BVALID = M00_AXI_bvalid;
  assign s00_couplers_to_ps8_0_axi_periph_RDATA = M00_AXI_rdata[63:0];
  assign s00_couplers_to_ps8_0_axi_periph_RRESP = M00_AXI_rresp[1:0];
  assign s00_couplers_to_ps8_0_axi_periph_RVALID = M00_AXI_rvalid;
  assign s00_couplers_to_ps8_0_axi_periph_WREADY = M00_AXI_wready;
  s00_couplers_imp_1A7ZMW4 s00_couplers
       (.M_ACLK(ps8_0_axi_periph_ACLK_net),
        .M_ARESETN(ps8_0_axi_periph_ARESETN_net),
        .M_AXI_araddr(s00_couplers_to_ps8_0_axi_periph_ARADDR),
        .M_AXI_arprot(s00_couplers_to_ps8_0_axi_periph_ARPROT),
        .M_AXI_arready(s00_couplers_to_ps8_0_axi_periph_ARREADY),
        .M_AXI_arvalid(s00_couplers_to_ps8_0_axi_periph_ARVALID),
        .M_AXI_awaddr(s00_couplers_to_ps8_0_axi_periph_AWADDR),
        .M_AXI_awprot(s00_couplers_to_ps8_0_axi_periph_AWPROT),
        .M_AXI_awready(s00_couplers_to_ps8_0_axi_periph_AWREADY),
        .M_AXI_awvalid(s00_couplers_to_ps8_0_axi_periph_AWVALID),
        .M_AXI_bready(s00_couplers_to_ps8_0_axi_periph_BREADY),
        .M_AXI_bresp(s00_couplers_to_ps8_0_axi_periph_BRESP),
        .M_AXI_bvalid(s00_couplers_to_ps8_0_axi_periph_BVALID),
        .M_AXI_rdata(s00_couplers_to_ps8_0_axi_periph_RDATA),
        .M_AXI_rready(s00_couplers_to_ps8_0_axi_periph_RREADY),
        .M_AXI_rresp(s00_couplers_to_ps8_0_axi_periph_RRESP),
        .M_AXI_rvalid(s00_couplers_to_ps8_0_axi_periph_RVALID),
        .M_AXI_wdata(s00_couplers_to_ps8_0_axi_periph_WDATA),
        .M_AXI_wready(s00_couplers_to_ps8_0_axi_periph_WREADY),
        .M_AXI_wstrb(s00_couplers_to_ps8_0_axi_periph_WSTRB),
        .M_AXI_wvalid(s00_couplers_to_ps8_0_axi_periph_WVALID),
        .S_ACLK(S00_ACLK_1),
        .S_ARESETN(S00_ARESETN_1),
        .S_AXI_araddr(ps8_0_axi_periph_to_s00_couplers_ARADDR),
        .S_AXI_arburst(ps8_0_axi_periph_to_s00_couplers_ARBURST),
        .S_AXI_arcache(ps8_0_axi_periph_to_s00_couplers_ARCACHE),
        .S_AXI_arid(ps8_0_axi_periph_to_s00_couplers_ARID),
        .S_AXI_arlen(ps8_0_axi_periph_to_s00_couplers_ARLEN),
        .S_AXI_arlock(ps8_0_axi_periph_to_s00_couplers_ARLOCK),
        .S_AXI_arprot(ps8_0_axi_periph_to_s00_couplers_ARPROT),
        .S_AXI_arqos(ps8_0_axi_periph_to_s00_couplers_ARQOS),
        .S_AXI_arready(ps8_0_axi_periph_to_s00_couplers_ARREADY),
        .S_AXI_arsize(ps8_0_axi_periph_to_s00_couplers_ARSIZE),
        .S_AXI_arvalid(ps8_0_axi_periph_to_s00_couplers_ARVALID),
        .S_AXI_awaddr(ps8_0_axi_periph_to_s00_couplers_AWADDR),
        .S_AXI_awburst(ps8_0_axi_periph_to_s00_couplers_AWBURST),
        .S_AXI_awcache(ps8_0_axi_periph_to_s00_couplers_AWCACHE),
        .S_AXI_awid(ps8_0_axi_periph_to_s00_couplers_AWID),
        .S_AXI_awlen(ps8_0_axi_periph_to_s00_couplers_AWLEN),
        .S_AXI_awlock(ps8_0_axi_periph_to_s00_couplers_AWLOCK),
        .S_AXI_awprot(ps8_0_axi_periph_to_s00_couplers_AWPROT),
        .S_AXI_awqos(ps8_0_axi_periph_to_s00_couplers_AWQOS),
        .S_AXI_awready(ps8_0_axi_periph_to_s00_couplers_AWREADY),
        .S_AXI_awsize(ps8_0_axi_periph_to_s00_couplers_AWSIZE),
        .S_AXI_awvalid(ps8_0_axi_periph_to_s00_couplers_AWVALID),
        .S_AXI_bid(ps8_0_axi_periph_to_s00_couplers_BID),
        .S_AXI_bready(ps8_0_axi_periph_to_s00_couplers_BREADY),
        .S_AXI_bresp(ps8_0_axi_periph_to_s00_couplers_BRESP),
        .S_AXI_bvalid(ps8_0_axi_periph_to_s00_couplers_BVALID),
        .S_AXI_rdata(ps8_0_axi_periph_to_s00_couplers_RDATA),
        .S_AXI_rid(ps8_0_axi_periph_to_s00_couplers_RID),
        .S_AXI_rlast(ps8_0_axi_periph_to_s00_couplers_RLAST),
        .S_AXI_rready(ps8_0_axi_periph_to_s00_couplers_RREADY),
        .S_AXI_rresp(ps8_0_axi_periph_to_s00_couplers_RRESP),
        .S_AXI_rvalid(ps8_0_axi_periph_to_s00_couplers_RVALID),
        .S_AXI_wdata(ps8_0_axi_periph_to_s00_couplers_WDATA),
        .S_AXI_wlast(ps8_0_axi_periph_to_s00_couplers_WLAST),
        .S_AXI_wready(ps8_0_axi_periph_to_s00_couplers_WREADY),
        .S_AXI_wstrb(ps8_0_axi_periph_to_s00_couplers_WSTRB),
        .S_AXI_wvalid(ps8_0_axi_periph_to_s00_couplers_WVALID));
endmodule

module s00_couplers_imp_1A7ZMW4
   (M_ACLK,
    M_ARESETN,
    M_AXI_araddr,
    M_AXI_arprot,
    M_AXI_arready,
    M_AXI_arvalid,
    M_AXI_awaddr,
    M_AXI_awprot,
    M_AXI_awready,
    M_AXI_awvalid,
    M_AXI_bready,
    M_AXI_bresp,
    M_AXI_bvalid,
    M_AXI_rdata,
    M_AXI_rready,
    M_AXI_rresp,
    M_AXI_rvalid,
    M_AXI_wdata,
    M_AXI_wready,
    M_AXI_wstrb,
    M_AXI_wvalid,
    S_ACLK,
    S_ARESETN,
    S_AXI_araddr,
    S_AXI_arburst,
    S_AXI_arcache,
    S_AXI_arid,
    S_AXI_arlen,
    S_AXI_arlock,
    S_AXI_arprot,
    S_AXI_arqos,
    S_AXI_arready,
    S_AXI_arsize,
    S_AXI_arvalid,
    S_AXI_awaddr,
    S_AXI_awburst,
    S_AXI_awcache,
    S_AXI_awid,
    S_AXI_awlen,
    S_AXI_awlock,
    S_AXI_awprot,
    S_AXI_awqos,
    S_AXI_awready,
    S_AXI_awsize,
    S_AXI_awvalid,
    S_AXI_bid,
    S_AXI_bready,
    S_AXI_bresp,
    S_AXI_bvalid,
    S_AXI_rdata,
    S_AXI_rid,
    S_AXI_rlast,
    S_AXI_rready,
    S_AXI_rresp,
    S_AXI_rvalid,
    S_AXI_wdata,
    S_AXI_wlast,
    S_AXI_wready,
    S_AXI_wstrb,
    S_AXI_wvalid);
  input M_ACLK;
  input M_ARESETN;
  output [39:0]M_AXI_araddr;
  output [2:0]M_AXI_arprot;
  input M_AXI_arready;
  output M_AXI_arvalid;
  output [39:0]M_AXI_awaddr;
  output [2:0]M_AXI_awprot;
  input M_AXI_awready;
  output M_AXI_awvalid;
  output M_AXI_bready;
  input [1:0]M_AXI_bresp;
  input M_AXI_bvalid;
  input [63:0]M_AXI_rdata;
  output M_AXI_rready;
  input [1:0]M_AXI_rresp;
  input M_AXI_rvalid;
  output [63:0]M_AXI_wdata;
  input M_AXI_wready;
  output [7:0]M_AXI_wstrb;
  output M_AXI_wvalid;
  input S_ACLK;
  input S_ARESETN;
  input [39:0]S_AXI_araddr;
  input [1:0]S_AXI_arburst;
  input [3:0]S_AXI_arcache;
  input [15:0]S_AXI_arid;
  input [7:0]S_AXI_arlen;
  input [0:0]S_AXI_arlock;
  input [2:0]S_AXI_arprot;
  input [3:0]S_AXI_arqos;
  output S_AXI_arready;
  input [2:0]S_AXI_arsize;
  input S_AXI_arvalid;
  input [39:0]S_AXI_awaddr;
  input [1:0]S_AXI_awburst;
  input [3:0]S_AXI_awcache;
  input [15:0]S_AXI_awid;
  input [7:0]S_AXI_awlen;
  input [0:0]S_AXI_awlock;
  input [2:0]S_AXI_awprot;
  input [3:0]S_AXI_awqos;
  output S_AXI_awready;
  input [2:0]S_AXI_awsize;
  input S_AXI_awvalid;
  output [15:0]S_AXI_bid;
  input S_AXI_bready;
  output [1:0]S_AXI_bresp;
  output S_AXI_bvalid;
  output [127:0]S_AXI_rdata;
  output [15:0]S_AXI_rid;
  output S_AXI_rlast;
  input S_AXI_rready;
  output [1:0]S_AXI_rresp;
  output S_AXI_rvalid;
  input [127:0]S_AXI_wdata;
  input S_AXI_wlast;
  output S_AXI_wready;
  input [15:0]S_AXI_wstrb;
  input S_AXI_wvalid;

  wire S_ACLK_1;
  wire S_ARESETN_1;
  wire [39:0]auto_ds_to_auto_pc_ARADDR;
  wire [1:0]auto_ds_to_auto_pc_ARBURST;
  wire [3:0]auto_ds_to_auto_pc_ARCACHE;
  wire [7:0]auto_ds_to_auto_pc_ARLEN;
  wire [0:0]auto_ds_to_auto_pc_ARLOCK;
  wire [2:0]auto_ds_to_auto_pc_ARPROT;
  wire [3:0]auto_ds_to_auto_pc_ARQOS;
  wire auto_ds_to_auto_pc_ARREADY;
  wire [3:0]auto_ds_to_auto_pc_ARREGION;
  wire [2:0]auto_ds_to_auto_pc_ARSIZE;
  wire auto_ds_to_auto_pc_ARVALID;
  wire [39:0]auto_ds_to_auto_pc_AWADDR;
  wire [1:0]auto_ds_to_auto_pc_AWBURST;
  wire [3:0]auto_ds_to_auto_pc_AWCACHE;
  wire [7:0]auto_ds_to_auto_pc_AWLEN;
  wire [0:0]auto_ds_to_auto_pc_AWLOCK;
  wire [2:0]auto_ds_to_auto_pc_AWPROT;
  wire [3:0]auto_ds_to_auto_pc_AWQOS;
  wire auto_ds_to_auto_pc_AWREADY;
  wire [3:0]auto_ds_to_auto_pc_AWREGION;
  wire [2:0]auto_ds_to_auto_pc_AWSIZE;
  wire auto_ds_to_auto_pc_AWVALID;
  wire auto_ds_to_auto_pc_BREADY;
  wire [1:0]auto_ds_to_auto_pc_BRESP;
  wire auto_ds_to_auto_pc_BVALID;
  wire [63:0]auto_ds_to_auto_pc_RDATA;
  wire auto_ds_to_auto_pc_RLAST;
  wire auto_ds_to_auto_pc_RREADY;
  wire [1:0]auto_ds_to_auto_pc_RRESP;
  wire auto_ds_to_auto_pc_RVALID;
  wire [63:0]auto_ds_to_auto_pc_WDATA;
  wire auto_ds_to_auto_pc_WLAST;
  wire auto_ds_to_auto_pc_WREADY;
  wire [7:0]auto_ds_to_auto_pc_WSTRB;
  wire auto_ds_to_auto_pc_WVALID;
  wire [39:0]auto_pc_to_s00_couplers_ARADDR;
  wire [2:0]auto_pc_to_s00_couplers_ARPROT;
  wire auto_pc_to_s00_couplers_ARREADY;
  wire auto_pc_to_s00_couplers_ARVALID;
  wire [39:0]auto_pc_to_s00_couplers_AWADDR;
  wire [2:0]auto_pc_to_s00_couplers_AWPROT;
  wire auto_pc_to_s00_couplers_AWREADY;
  wire auto_pc_to_s00_couplers_AWVALID;
  wire auto_pc_to_s00_couplers_BREADY;
  wire [1:0]auto_pc_to_s00_couplers_BRESP;
  wire auto_pc_to_s00_couplers_BVALID;
  wire [63:0]auto_pc_to_s00_couplers_RDATA;
  wire auto_pc_to_s00_couplers_RREADY;
  wire [1:0]auto_pc_to_s00_couplers_RRESP;
  wire auto_pc_to_s00_couplers_RVALID;
  wire [63:0]auto_pc_to_s00_couplers_WDATA;
  wire auto_pc_to_s00_couplers_WREADY;
  wire [7:0]auto_pc_to_s00_couplers_WSTRB;
  wire auto_pc_to_s00_couplers_WVALID;
  wire [39:0]s00_couplers_to_auto_ds_ARADDR;
  wire [1:0]s00_couplers_to_auto_ds_ARBURST;
  wire [3:0]s00_couplers_to_auto_ds_ARCACHE;
  wire [15:0]s00_couplers_to_auto_ds_ARID;
  wire [7:0]s00_couplers_to_auto_ds_ARLEN;
  wire [0:0]s00_couplers_to_auto_ds_ARLOCK;
  wire [2:0]s00_couplers_to_auto_ds_ARPROT;
  wire [3:0]s00_couplers_to_auto_ds_ARQOS;
  wire s00_couplers_to_auto_ds_ARREADY;
  wire [2:0]s00_couplers_to_auto_ds_ARSIZE;
  wire s00_couplers_to_auto_ds_ARVALID;
  wire [39:0]s00_couplers_to_auto_ds_AWADDR;
  wire [1:0]s00_couplers_to_auto_ds_AWBURST;
  wire [3:0]s00_couplers_to_auto_ds_AWCACHE;
  wire [15:0]s00_couplers_to_auto_ds_AWID;
  wire [7:0]s00_couplers_to_auto_ds_AWLEN;
  wire [0:0]s00_couplers_to_auto_ds_AWLOCK;
  wire [2:0]s00_couplers_to_auto_ds_AWPROT;
  wire [3:0]s00_couplers_to_auto_ds_AWQOS;
  wire s00_couplers_to_auto_ds_AWREADY;
  wire [2:0]s00_couplers_to_auto_ds_AWSIZE;
  wire s00_couplers_to_auto_ds_AWVALID;
  wire [15:0]s00_couplers_to_auto_ds_BID;
  wire s00_couplers_to_auto_ds_BREADY;
  wire [1:0]s00_couplers_to_auto_ds_BRESP;
  wire s00_couplers_to_auto_ds_BVALID;
  wire [127:0]s00_couplers_to_auto_ds_RDATA;
  wire [15:0]s00_couplers_to_auto_ds_RID;
  wire s00_couplers_to_auto_ds_RLAST;
  wire s00_couplers_to_auto_ds_RREADY;
  wire [1:0]s00_couplers_to_auto_ds_RRESP;
  wire s00_couplers_to_auto_ds_RVALID;
  wire [127:0]s00_couplers_to_auto_ds_WDATA;
  wire s00_couplers_to_auto_ds_WLAST;
  wire s00_couplers_to_auto_ds_WREADY;
  wire [15:0]s00_couplers_to_auto_ds_WSTRB;
  wire s00_couplers_to_auto_ds_WVALID;

  assign M_AXI_araddr[39:0] = auto_pc_to_s00_couplers_ARADDR;
  assign M_AXI_arprot[2:0] = auto_pc_to_s00_couplers_ARPROT;
  assign M_AXI_arvalid = auto_pc_to_s00_couplers_ARVALID;
  assign M_AXI_awaddr[39:0] = auto_pc_to_s00_couplers_AWADDR;
  assign M_AXI_awprot[2:0] = auto_pc_to_s00_couplers_AWPROT;
  assign M_AXI_awvalid = auto_pc_to_s00_couplers_AWVALID;
  assign M_AXI_bready = auto_pc_to_s00_couplers_BREADY;
  assign M_AXI_rready = auto_pc_to_s00_couplers_RREADY;
  assign M_AXI_wdata[63:0] = auto_pc_to_s00_couplers_WDATA;
  assign M_AXI_wstrb[7:0] = auto_pc_to_s00_couplers_WSTRB;
  assign M_AXI_wvalid = auto_pc_to_s00_couplers_WVALID;
  assign S_ACLK_1 = S_ACLK;
  assign S_ARESETN_1 = S_ARESETN;
  assign S_AXI_arready = s00_couplers_to_auto_ds_ARREADY;
  assign S_AXI_awready = s00_couplers_to_auto_ds_AWREADY;
  assign S_AXI_bid[15:0] = s00_couplers_to_auto_ds_BID;
  assign S_AXI_bresp[1:0] = s00_couplers_to_auto_ds_BRESP;
  assign S_AXI_bvalid = s00_couplers_to_auto_ds_BVALID;
  assign S_AXI_rdata[127:0] = s00_couplers_to_auto_ds_RDATA;
  assign S_AXI_rid[15:0] = s00_couplers_to_auto_ds_RID;
  assign S_AXI_rlast = s00_couplers_to_auto_ds_RLAST;
  assign S_AXI_rresp[1:0] = s00_couplers_to_auto_ds_RRESP;
  assign S_AXI_rvalid = s00_couplers_to_auto_ds_RVALID;
  assign S_AXI_wready = s00_couplers_to_auto_ds_WREADY;
  assign auto_pc_to_s00_couplers_ARREADY = M_AXI_arready;
  assign auto_pc_to_s00_couplers_AWREADY = M_AXI_awready;
  assign auto_pc_to_s00_couplers_BRESP = M_AXI_bresp[1:0];
  assign auto_pc_to_s00_couplers_BVALID = M_AXI_bvalid;
  assign auto_pc_to_s00_couplers_RDATA = M_AXI_rdata[63:0];
  assign auto_pc_to_s00_couplers_RRESP = M_AXI_rresp[1:0];
  assign auto_pc_to_s00_couplers_RVALID = M_AXI_rvalid;
  assign auto_pc_to_s00_couplers_WREADY = M_AXI_wready;
  assign s00_couplers_to_auto_ds_ARADDR = S_AXI_araddr[39:0];
  assign s00_couplers_to_auto_ds_ARBURST = S_AXI_arburst[1:0];
  assign s00_couplers_to_auto_ds_ARCACHE = S_AXI_arcache[3:0];
  assign s00_couplers_to_auto_ds_ARID = S_AXI_arid[15:0];
  assign s00_couplers_to_auto_ds_ARLEN = S_AXI_arlen[7:0];
  assign s00_couplers_to_auto_ds_ARLOCK = S_AXI_arlock[0];
  assign s00_couplers_to_auto_ds_ARPROT = S_AXI_arprot[2:0];
  assign s00_couplers_to_auto_ds_ARQOS = S_AXI_arqos[3:0];
  assign s00_couplers_to_auto_ds_ARSIZE = S_AXI_arsize[2:0];
  assign s00_couplers_to_auto_ds_ARVALID = S_AXI_arvalid;
  assign s00_couplers_to_auto_ds_AWADDR = S_AXI_awaddr[39:0];
  assign s00_couplers_to_auto_ds_AWBURST = S_AXI_awburst[1:0];
  assign s00_couplers_to_auto_ds_AWCACHE = S_AXI_awcache[3:0];
  assign s00_couplers_to_auto_ds_AWID = S_AXI_awid[15:0];
  assign s00_couplers_to_auto_ds_AWLEN = S_AXI_awlen[7:0];
  assign s00_couplers_to_auto_ds_AWLOCK = S_AXI_awlock[0];
  assign s00_couplers_to_auto_ds_AWPROT = S_AXI_awprot[2:0];
  assign s00_couplers_to_auto_ds_AWQOS = S_AXI_awqos[3:0];
  assign s00_couplers_to_auto_ds_AWSIZE = S_AXI_awsize[2:0];
  assign s00_couplers_to_auto_ds_AWVALID = S_AXI_awvalid;
  assign s00_couplers_to_auto_ds_BREADY = S_AXI_bready;
  assign s00_couplers_to_auto_ds_RREADY = S_AXI_rready;
  assign s00_couplers_to_auto_ds_WDATA = S_AXI_wdata[127:0];
  assign s00_couplers_to_auto_ds_WLAST = S_AXI_wlast;
  assign s00_couplers_to_auto_ds_WSTRB = S_AXI_wstrb[15:0];
  assign s00_couplers_to_auto_ds_WVALID = S_AXI_wvalid;
  design_1_auto_ds_0 auto_ds
       (.m_axi_araddr(auto_ds_to_auto_pc_ARADDR),
        .m_axi_arburst(auto_ds_to_auto_pc_ARBURST),
        .m_axi_arcache(auto_ds_to_auto_pc_ARCACHE),
        .m_axi_arlen(auto_ds_to_auto_pc_ARLEN),
        .m_axi_arlock(auto_ds_to_auto_pc_ARLOCK),
        .m_axi_arprot(auto_ds_to_auto_pc_ARPROT),
        .m_axi_arqos(auto_ds_to_auto_pc_ARQOS),
        .m_axi_arready(auto_ds_to_auto_pc_ARREADY),
        .m_axi_arregion(auto_ds_to_auto_pc_ARREGION),
        .m_axi_arsize(auto_ds_to_auto_pc_ARSIZE),
        .m_axi_arvalid(auto_ds_to_auto_pc_ARVALID),
        .m_axi_awaddr(auto_ds_to_auto_pc_AWADDR),
        .m_axi_awburst(auto_ds_to_auto_pc_AWBURST),
        .m_axi_awcache(auto_ds_to_auto_pc_AWCACHE),
        .m_axi_awlen(auto_ds_to_auto_pc_AWLEN),
        .m_axi_awlock(auto_ds_to_auto_pc_AWLOCK),
        .m_axi_awprot(auto_ds_to_auto_pc_AWPROT),
        .m_axi_awqos(auto_ds_to_auto_pc_AWQOS),
        .m_axi_awready(auto_ds_to_auto_pc_AWREADY),
        .m_axi_awregion(auto_ds_to_auto_pc_AWREGION),
        .m_axi_awsize(auto_ds_to_auto_pc_AWSIZE),
        .m_axi_awvalid(auto_ds_to_auto_pc_AWVALID),
        .m_axi_bready(auto_ds_to_auto_pc_BREADY),
        .m_axi_bresp(auto_ds_to_auto_pc_BRESP),
        .m_axi_bvalid(auto_ds_to_auto_pc_BVALID),
        .m_axi_rdata(auto_ds_to_auto_pc_RDATA),
        .m_axi_rlast(auto_ds_to_auto_pc_RLAST),
        .m_axi_rready(auto_ds_to_auto_pc_RREADY),
        .m_axi_rresp(auto_ds_to_auto_pc_RRESP),
        .m_axi_rvalid(auto_ds_to_auto_pc_RVALID),
        .m_axi_wdata(auto_ds_to_auto_pc_WDATA),
        .m_axi_wlast(auto_ds_to_auto_pc_WLAST),
        .m_axi_wready(auto_ds_to_auto_pc_WREADY),
        .m_axi_wstrb(auto_ds_to_auto_pc_WSTRB),
        .m_axi_wvalid(auto_ds_to_auto_pc_WVALID),
        .s_axi_aclk(S_ACLK_1),
        .s_axi_araddr(s00_couplers_to_auto_ds_ARADDR),
        .s_axi_arburst(s00_couplers_to_auto_ds_ARBURST),
        .s_axi_arcache(s00_couplers_to_auto_ds_ARCACHE),
        .s_axi_aresetn(S_ARESETN_1),
        .s_axi_arid(s00_couplers_to_auto_ds_ARID),
        .s_axi_arlen(s00_couplers_to_auto_ds_ARLEN),
        .s_axi_arlock(s00_couplers_to_auto_ds_ARLOCK),
        .s_axi_arprot(s00_couplers_to_auto_ds_ARPROT),
        .s_axi_arqos(s00_couplers_to_auto_ds_ARQOS),
        .s_axi_arready(s00_couplers_to_auto_ds_ARREADY),
        .s_axi_arregion({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_arsize(s00_couplers_to_auto_ds_ARSIZE),
        .s_axi_arvalid(s00_couplers_to_auto_ds_ARVALID),
        .s_axi_awaddr(s00_couplers_to_auto_ds_AWADDR),
        .s_axi_awburst(s00_couplers_to_auto_ds_AWBURST),
        .s_axi_awcache(s00_couplers_to_auto_ds_AWCACHE),
        .s_axi_awid(s00_couplers_to_auto_ds_AWID),
        .s_axi_awlen(s00_couplers_to_auto_ds_AWLEN),
        .s_axi_awlock(s00_couplers_to_auto_ds_AWLOCK),
        .s_axi_awprot(s00_couplers_to_auto_ds_AWPROT),
        .s_axi_awqos(s00_couplers_to_auto_ds_AWQOS),
        .s_axi_awready(s00_couplers_to_auto_ds_AWREADY),
        .s_axi_awregion({1'b0,1'b0,1'b0,1'b0}),
        .s_axi_awsize(s00_couplers_to_auto_ds_AWSIZE),
        .s_axi_awvalid(s00_couplers_to_auto_ds_AWVALID),
        .s_axi_bid(s00_couplers_to_auto_ds_BID),
        .s_axi_bready(s00_couplers_to_auto_ds_BREADY),
        .s_axi_bresp(s00_couplers_to_auto_ds_BRESP),
        .s_axi_bvalid(s00_couplers_to_auto_ds_BVALID),
        .s_axi_rdata(s00_couplers_to_auto_ds_RDATA),
        .s_axi_rid(s00_couplers_to_auto_ds_RID),
        .s_axi_rlast(s00_couplers_to_auto_ds_RLAST),
        .s_axi_rready(s00_couplers_to_auto_ds_RREADY),
        .s_axi_rresp(s00_couplers_to_auto_ds_RRESP),
        .s_axi_rvalid(s00_couplers_to_auto_ds_RVALID),
        .s_axi_wdata(s00_couplers_to_auto_ds_WDATA),
        .s_axi_wlast(s00_couplers_to_auto_ds_WLAST),
        .s_axi_wready(s00_couplers_to_auto_ds_WREADY),
        .s_axi_wstrb(s00_couplers_to_auto_ds_WSTRB),
        .s_axi_wvalid(s00_couplers_to_auto_ds_WVALID));
  design_1_auto_pc_0 auto_pc
       (.aclk(S_ACLK_1),
        .aresetn(S_ARESETN_1),
        .m_axi_araddr(auto_pc_to_s00_couplers_ARADDR),
        .m_axi_arprot(auto_pc_to_s00_couplers_ARPROT),
        .m_axi_arready(auto_pc_to_s00_couplers_ARREADY),
        .m_axi_arvalid(auto_pc_to_s00_couplers_ARVALID),
        .m_axi_awaddr(auto_pc_to_s00_couplers_AWADDR),
        .m_axi_awprot(auto_pc_to_s00_couplers_AWPROT),
        .m_axi_awready(auto_pc_to_s00_couplers_AWREADY),
        .m_axi_awvalid(auto_pc_to_s00_couplers_AWVALID),
        .m_axi_bready(auto_pc_to_s00_couplers_BREADY),
        .m_axi_bresp(auto_pc_to_s00_couplers_BRESP),
        .m_axi_bvalid(auto_pc_to_s00_couplers_BVALID),
        .m_axi_rdata(auto_pc_to_s00_couplers_RDATA),
        .m_axi_rready(auto_pc_to_s00_couplers_RREADY),
        .m_axi_rresp(auto_pc_to_s00_couplers_RRESP),
        .m_axi_rvalid(auto_pc_to_s00_couplers_RVALID),
        .m_axi_wdata(auto_pc_to_s00_couplers_WDATA),
        .m_axi_wready(auto_pc_to_s00_couplers_WREADY),
        .m_axi_wstrb(auto_pc_to_s00_couplers_WSTRB),
        .m_axi_wvalid(auto_pc_to_s00_couplers_WVALID),
        .s_axi_araddr(auto_ds_to_auto_pc_ARADDR),
        .s_axi_arburst(auto_ds_to_auto_pc_ARBURST),
        .s_axi_arcache(auto_ds_to_auto_pc_ARCACHE),
        .s_axi_arlen(auto_ds_to_auto_pc_ARLEN),
        .s_axi_arlock(auto_ds_to_auto_pc_ARLOCK),
        .s_axi_arprot(auto_ds_to_auto_pc_ARPROT),
        .s_axi_arqos(auto_ds_to_auto_pc_ARQOS),
        .s_axi_arready(auto_ds_to_auto_pc_ARREADY),
        .s_axi_arregion(auto_ds_to_auto_pc_ARREGION),
        .s_axi_arsize(auto_ds_to_auto_pc_ARSIZE),
        .s_axi_arvalid(auto_ds_to_auto_pc_ARVALID),
        .s_axi_awaddr(auto_ds_to_auto_pc_AWADDR),
        .s_axi_awburst(auto_ds_to_auto_pc_AWBURST),
        .s_axi_awcache(auto_ds_to_auto_pc_AWCACHE),
        .s_axi_awlen(auto_ds_to_auto_pc_AWLEN),
        .s_axi_awlock(auto_ds_to_auto_pc_AWLOCK),
        .s_axi_awprot(auto_ds_to_auto_pc_AWPROT),
        .s_axi_awqos(auto_ds_to_auto_pc_AWQOS),
        .s_axi_awready(auto_ds_to_auto_pc_AWREADY),
        .s_axi_awregion(auto_ds_to_auto_pc_AWREGION),
        .s_axi_awsize(auto_ds_to_auto_pc_AWSIZE),
        .s_axi_awvalid(auto_ds_to_auto_pc_AWVALID),
        .s_axi_bready(auto_ds_to_auto_pc_BREADY),
        .s_axi_bresp(auto_ds_to_auto_pc_BRESP),
        .s_axi_bvalid(auto_ds_to_auto_pc_BVALID),
        .s_axi_rdata(auto_ds_to_auto_pc_RDATA),
        .s_axi_rlast(auto_ds_to_auto_pc_RLAST),
        .s_axi_rready(auto_ds_to_auto_pc_RREADY),
        .s_axi_rresp(auto_ds_to_auto_pc_RRESP),
        .s_axi_rvalid(auto_ds_to_auto_pc_RVALID),
        .s_axi_wdata(auto_ds_to_auto_pc_WDATA),
        .s_axi_wlast(auto_ds_to_auto_pc_WLAST),
        .s_axi_wready(auto_ds_to_auto_pc_WREADY),
        .s_axi_wstrb(auto_ds_to_auto_pc_WSTRB),
        .s_axi_wvalid(auto_ds_to_auto_pc_WVALID));
endmodule
