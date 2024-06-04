
 extern void sim_init();

 extern int tick();

 extern int sendDRAMRequest(/* INPUT */long long addr, /* INPUT */long long rawAddr, /* INPUT */int size, /* INPUT */int tag, /* INPUT */int isWr);

 extern int sendWdataStrb(/* INPUT */int dramCmdValid, /* INPUT */int wdata0, /* INPUT */int wdata1, /* INPUT */int wdata2, /* INPUT */int wdata3, /* INPUT */int wdata4, /* INPUT */int wdata5, /* INPUT */int wdata6, /* INPUT */int wdata7, /* INPUT */int wdata8, 
/* INPUT */int wdata9, /* INPUT */int wdata10, /* INPUT */int wdata11, /* INPUT */int wdata12, /* INPUT */int wdata13, /* INPUT */int wdata14, /* INPUT */int wdata15, /* INPUT */int wdata16, /* INPUT */int wdata17, /* INPUT */int wdata18, 
/* INPUT */int wdata19, /* INPUT */int wdata20, /* INPUT */int wdata21, /* INPUT */int wdata22, /* INPUT */int wdata23, /* INPUT */int wdata24, /* INPUT */int wdata25, /* INPUT */int wdata26, /* INPUT */int wdata27, /* INPUT */int wdata28, 
/* INPUT */int wdata29, /* INPUT */int wdata30, /* INPUT */int wdata31, /* INPUT */int wdata32, /* INPUT */int wdata33, /* INPUT */int wdata34, /* INPUT */int wdata35, /* INPUT */int wdata36, /* INPUT */int wdata37, /* INPUT */int wdata38, 
/* INPUT */int wdata39, /* INPUT */int wdata40, /* INPUT */int wdata41, /* INPUT */int wdata42, /* INPUT */int wdata43, /* INPUT */int wdata44, /* INPUT */int wdata45, /* INPUT */int wdata46, /* INPUT */int wdata47, /* INPUT */int wdata48, 
/* INPUT */int wdata49, /* INPUT */int wdata50, /* INPUT */int wdata51, /* INPUT */int wdata52, /* INPUT */int wdata53, /* INPUT */int wdata54, /* INPUT */int wdata55, /* INPUT */int wdata56, /* INPUT */int wdata57, /* INPUT */int wdata58, 
/* INPUT */int wdata59, /* INPUT */int wdata60, /* INPUT */int wdata61, /* INPUT */int wdata62, /* INPUT */int wdata63, /* INPUT */int strb0, /* INPUT */int strb1, /* INPUT */int strb2, /* INPUT */int strb3, /* INPUT */int strb4, 
/* INPUT */int strb5, /* INPUT */int strb6, /* INPUT */int strb7, /* INPUT */int strb8, /* INPUT */int strb9, /* INPUT */int strb10, /* INPUT */int strb11, /* INPUT */int strb12, /* INPUT */int strb13, /* INPUT */int strb14, 
/* INPUT */int strb15, /* INPUT */int strb16, /* INPUT */int strb17, /* INPUT */int strb18, /* INPUT */int strb19, /* INPUT */int strb20, /* INPUT */int strb21, /* INPUT */int strb22, /* INPUT */int strb23, /* INPUT */int strb24, 
/* INPUT */int strb25, /* INPUT */int strb26, /* INPUT */int strb27, /* INPUT */int strb28, /* INPUT */int strb29, /* INPUT */int strb30, /* INPUT */int strb31, /* INPUT */int strb32, /* INPUT */int strb33, /* INPUT */int strb34, 
/* INPUT */int strb35, /* INPUT */int strb36, /* INPUT */int strb37, /* INPUT */int strb38, /* INPUT */int strb39, /* INPUT */int strb40, /* INPUT */int strb41, /* INPUT */int strb42, /* INPUT */int strb43, /* INPUT */int strb44, 
/* INPUT */int strb45, /* INPUT */int strb46, /* INPUT */int strb47, /* INPUT */int strb48, /* INPUT */int strb49, /* INPUT */int strb50, /* INPUT */int strb51, /* INPUT */int strb52, /* INPUT */int strb53, /* INPUT */int strb54, 
/* INPUT */int strb55, /* INPUT */int strb56, /* INPUT */int strb57, /* INPUT */int strb58, /* INPUT */int strb59, /* INPUT */int strb60, /* INPUT */int strb61, /* INPUT */int strb62, /* INPUT */int strb63);

 extern void serviceWRequest();

 extern void popDRAMReadQ();

 extern void popDRAMWriteQ();

 extern void readOutputStream(/* INPUT */int data, /* INPUT */int tag, /* INPUT */int last);
