#ifndef _GNU_SOURCE
#define _GNU_SOURCE
#endif
#include <stdio.h>
#include <dlfcn.h>
#include "svdpi.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef _VC_TYPES_
#define _VC_TYPES_
/* common definitions shared with DirectC.h */

typedef unsigned int U;
typedef unsigned char UB;
typedef unsigned char scalar;
typedef struct { U c; U d;} vec32;

#define scalar_0 0
#define scalar_1 1
#define scalar_z 2
#define scalar_x 3

extern long long int ConvUP2LLI(U* a);
extern void ConvLLI2UP(long long int a1, U* a2);
extern long long int GetLLIresult();
extern void StoreLLIresult(const unsigned int* data);
typedef struct VeriC_Descriptor *vc_handle;

#ifndef SV_3_COMPATIBILITY
#define SV_STRING const char*
#else
#define SV_STRING char*
#endif

#endif /* _VC_TYPES_ */


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

 extern void start();

 extern void rst();

 extern void startVPD();

 extern void startVCD();

 extern void stopVPD();

 extern void stopVCD();

 extern void readRegRaddr(/* INPUT */int r);

 extern void readRegRdataHi32(/* OUTPUT */svBitVecVal *rdatahi);

 extern void readRegRdataLo32(/* OUTPUT */svBitVecVal *rdatalo);

 extern void writeReg(/* INPUT */int r, /* INPUT */long long wdata);

 extern void getDRAMReadRespReady(/* OUTPUT */svBitVecVal *respReady);

 extern void getDRAMWriteRespReady(/* OUTPUT */svBitVecVal *respReady);

 extern void pokeDRAMReadResponse(/* INPUT */int tag, /* INPUT */int rdata0, /* INPUT */int rdata1, /* INPUT */int rdata2, /* INPUT */int rdata3, /* INPUT */int rdata4, /* INPUT */int rdata5, /* INPUT */int rdata6, /* INPUT */int rdata7, /* INPUT */int rdata8, 
/* INPUT */int rdata9, /* INPUT */int rdata10, /* INPUT */int rdata11, /* INPUT */int rdata12, /* INPUT */int rdata13, /* INPUT */int rdata14, /* INPUT */int rdata15, /* INPUT */int rdata16, /* INPUT */int rdata17, /* INPUT */int rdata18, 
/* INPUT */int rdata19, /* INPUT */int rdata20, /* INPUT */int rdata21, /* INPUT */int rdata22, /* INPUT */int rdata23, /* INPUT */int rdata24, /* INPUT */int rdata25, /* INPUT */int rdata26, /* INPUT */int rdata27, /* INPUT */int rdata28, 
/* INPUT */int rdata29, /* INPUT */int rdata30, /* INPUT */int rdata31, /* INPUT */int rdata32, /* INPUT */int rdata33, /* INPUT */int rdata34, /* INPUT */int rdata35, /* INPUT */int rdata36, /* INPUT */int rdata37, /* INPUT */int rdata38, 
/* INPUT */int rdata39, /* INPUT */int rdata40, /* INPUT */int rdata41, /* INPUT */int rdata42, /* INPUT */int rdata43, /* INPUT */int rdata44, /* INPUT */int rdata45, /* INPUT */int rdata46, /* INPUT */int rdata47, /* INPUT */int rdata48, 
/* INPUT */int rdata49, /* INPUT */int rdata50, /* INPUT */int rdata51, /* INPUT */int rdata52, /* INPUT */int rdata53, /* INPUT */int rdata54, /* INPUT */int rdata55, /* INPUT */int rdata56, /* INPUT */int rdata57, /* INPUT */int rdata58, 
/* INPUT */int rdata59, /* INPUT */int rdata60, /* INPUT */int rdata61, /* INPUT */int rdata62, /* INPUT */int rdata63);

 extern void pokeDRAMWriteResponse(/* INPUT */int tag);

 extern void writeStream(/* INPUT */int data, /* INPUT */int tag, /* INPUT */int last);

 extern void getCycles(/* OUTPUT */long long *cycles);

 extern void terminateSim();

#ifdef __cplusplus
}
#endif

