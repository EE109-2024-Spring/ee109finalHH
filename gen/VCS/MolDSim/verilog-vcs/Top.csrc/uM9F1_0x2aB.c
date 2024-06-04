#include "svdpi.h"
#include "DirectC.h"
#ifdef __cplusplus
extern "C" {
#endif
extern void writeReg_0x2a(const int A0, const U* A1);
#ifdef __cplusplus
} /*extern "C" */
#endif
#ifndef _DPI_WRAPPER_writeReg_0x2a
#define _DPI_WRAPPER_writeReg_0x2a
#ifdef __cplusplus
extern "C" {
#endif
void  writeReg(int A0,long long int  A1)
{
U A1_u2[2];

ConvLLI2UP(A1, A1_u2);

 writeReg_0x2a(A0,A1_u2);



}
#ifdef __cplusplus
} /*extern "C" */
#endif
#endif
