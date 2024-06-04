#ifndef _GNU_SOURCE
#define _GNU_SOURCE
#endif
#include <stdio.h>
#include <dlfcn.h>
#include "svdpi.h"

#ifdef __cplusplus
extern "C" {
#endif

/* VCS error reporting routine */
extern void vcsMsgReport1(const char *, const char *, int, void *, void*, const char *);

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

#ifndef __VCS_IMPORT_DPI_STUB_sim_init
#define __VCS_IMPORT_DPI_STUB_sim_init
__attribute__((weak)) void sim_init()
{
    static int _vcs_dpi_stub_initialized_ = 0;
    static void (*_vcs_dpi_fp_)() = NULL;
    if (!_vcs_dpi_stub_initialized_) {
        _vcs_dpi_stub_initialized_ = 1;
        _vcs_dpi_fp_ = (void (*)()) dlsym(RTLD_NEXT, "sim_init");
    }
    if (_vcs_dpi_fp_) {
        _vcs_dpi_fp_();
    } else {
        const char *fileName;
        int lineNumber;
        svGetCallerInfo(&fileName, &lineNumber);
        vcsMsgReport1("DPI-DIFNF", fileName, lineNumber, 0, 0, "sim_init");
    }
}
#endif /* __VCS_IMPORT_DPI_STUB_sim_init */

#ifndef __VCS_IMPORT_DPI_STUB_tick
#define __VCS_IMPORT_DPI_STUB_tick
__attribute__((weak)) int tick()
{
    static int _vcs_dpi_stub_initialized_ = 0;
    static int (*_vcs_dpi_fp_)() = NULL;
    if (!_vcs_dpi_stub_initialized_) {
        _vcs_dpi_stub_initialized_ = 1;
        _vcs_dpi_fp_ = (int (*)()) dlsym(RTLD_NEXT, "tick");
    }
    if (_vcs_dpi_fp_) {
        return _vcs_dpi_fp_();
    } else {
        const char *fileName;
        int lineNumber;
        svGetCallerInfo(&fileName, &lineNumber);
        vcsMsgReport1("DPI-DIFNF", fileName, lineNumber, 0, 0, "tick");
        return 0;
    }
}
#endif /* __VCS_IMPORT_DPI_STUB_tick */

#ifndef __VCS_IMPORT_DPI_STUB_sendDRAMRequest
#define __VCS_IMPORT_DPI_STUB_sendDRAMRequest
__attribute__((weak)) int sendDRAMRequest(/* INPUT */long long A_1, /* INPUT */long long A_2, /* INPUT */int A_3, /* INPUT */int A_4, /* INPUT */int A_5)
{
    static int _vcs_dpi_stub_initialized_ = 0;
    static int (*_vcs_dpi_fp_)(/* INPUT */long long A_1, /* INPUT */long long A_2, /* INPUT */int A_3, /* INPUT */int A_4, /* INPUT */int A_5) = NULL;
    if (!_vcs_dpi_stub_initialized_) {
        _vcs_dpi_stub_initialized_ = 1;
        _vcs_dpi_fp_ = (int (*)(long long A_1, long long A_2, int A_3, int A_4, int A_5)) dlsym(RTLD_NEXT, "sendDRAMRequest");
    }
    if (_vcs_dpi_fp_) {
        return _vcs_dpi_fp_(A_1, A_2, A_3, A_4, A_5);
    } else {
        const char *fileName;
        int lineNumber;
        svGetCallerInfo(&fileName, &lineNumber);
        vcsMsgReport1("DPI-DIFNF", fileName, lineNumber, 0, 0, "sendDRAMRequest");
        return 0;
    }
}
#endif /* __VCS_IMPORT_DPI_STUB_sendDRAMRequest */

#ifndef __VCS_IMPORT_DPI_STUB_sendWdataStrb
#define __VCS_IMPORT_DPI_STUB_sendWdataStrb
__attribute__((weak)) int sendWdataStrb(/* INPUT */int A_1, /* INPUT */int A_2, /* INPUT */int A_3, /* INPUT */int A_4, /* INPUT */int A_5, /* INPUT */int A_6, /* INPUT */int A_7, /* INPUT */int A_8, /* INPUT */int A_9, /* INPUT */int A_10, 
/* INPUT */int A_11, /* INPUT */int A_12, /* INPUT */int A_13, /* INPUT */int A_14, /* INPUT */int A_15, /* INPUT */int A_16, /* INPUT */int A_17, /* INPUT */int A_18, /* INPUT */int A_19, /* INPUT */int A_20, 
/* INPUT */int A_21, /* INPUT */int A_22, /* INPUT */int A_23, /* INPUT */int A_24, /* INPUT */int A_25, /* INPUT */int A_26, /* INPUT */int A_27, /* INPUT */int A_28, /* INPUT */int A_29, /* INPUT */int A_30, 
/* INPUT */int A_31, /* INPUT */int A_32, /* INPUT */int A_33, /* INPUT */int A_34, /* INPUT */int A_35, /* INPUT */int A_36, /* INPUT */int A_37, /* INPUT */int A_38, /* INPUT */int A_39, /* INPUT */int A_40, 
/* INPUT */int A_41, /* INPUT */int A_42, /* INPUT */int A_43, /* INPUT */int A_44, /* INPUT */int A_45, /* INPUT */int A_46, /* INPUT */int A_47, /* INPUT */int A_48, /* INPUT */int A_49, /* INPUT */int A_50, 
/* INPUT */int A_51, /* INPUT */int A_52, /* INPUT */int A_53, /* INPUT */int A_54, /* INPUT */int A_55, /* INPUT */int A_56, /* INPUT */int A_57, /* INPUT */int A_58, /* INPUT */int A_59, /* INPUT */int A_60, 
/* INPUT */int A_61, /* INPUT */int A_62, /* INPUT */int A_63, /* INPUT */int A_64, /* INPUT */int A_65, /* INPUT */int A_66, /* INPUT */int A_67, /* INPUT */int A_68, /* INPUT */int A_69, /* INPUT */int A_70, 
/* INPUT */int A_71, /* INPUT */int A_72, /* INPUT */int A_73, /* INPUT */int A_74, /* INPUT */int A_75, /* INPUT */int A_76, /* INPUT */int A_77, /* INPUT */int A_78, /* INPUT */int A_79, /* INPUT */int A_80, 
/* INPUT */int A_81, /* INPUT */int A_82, /* INPUT */int A_83, /* INPUT */int A_84, /* INPUT */int A_85, /* INPUT */int A_86, /* INPUT */int A_87, /* INPUT */int A_88, /* INPUT */int A_89, /* INPUT */int A_90, 
/* INPUT */int A_91, /* INPUT */int A_92, /* INPUT */int A_93, /* INPUT */int A_94, /* INPUT */int A_95, /* INPUT */int A_96, /* INPUT */int A_97, /* INPUT */int A_98, /* INPUT */int A_99, /* INPUT */int A_100, 
/* INPUT */int A_101, /* INPUT */int A_102, /* INPUT */int A_103, /* INPUT */int A_104, /* INPUT */int A_105, /* INPUT */int A_106, /* INPUT */int A_107, /* INPUT */int A_108, /* INPUT */int A_109, /* INPUT */int A_110, 
/* INPUT */int A_111, /* INPUT */int A_112, /* INPUT */int A_113, /* INPUT */int A_114, /* INPUT */int A_115, /* INPUT */int A_116, /* INPUT */int A_117, /* INPUT */int A_118, /* INPUT */int A_119, /* INPUT */int A_120, 
/* INPUT */int A_121, /* INPUT */int A_122, /* INPUT */int A_123, /* INPUT */int A_124, /* INPUT */int A_125, /* INPUT */int A_126, /* INPUT */int A_127, /* INPUT */int A_128, /* INPUT */int A_129)
{
    static int _vcs_dpi_stub_initialized_ = 0;
    static int (*_vcs_dpi_fp_)(/* INPUT */int A_1, /* INPUT */int A_2, /* INPUT */int A_3, /* INPUT */int A_4, /* INPUT */int A_5, /* INPUT */int A_6, /* INPUT */int A_7, /* INPUT */int A_8, /* INPUT */int A_9, /* INPUT */int A_10, 
/* INPUT */int A_11, /* INPUT */int A_12, /* INPUT */int A_13, /* INPUT */int A_14, /* INPUT */int A_15, /* INPUT */int A_16, /* INPUT */int A_17, /* INPUT */int A_18, /* INPUT */int A_19, /* INPUT */int A_20, 
/* INPUT */int A_21, /* INPUT */int A_22, /* INPUT */int A_23, /* INPUT */int A_24, /* INPUT */int A_25, /* INPUT */int A_26, /* INPUT */int A_27, /* INPUT */int A_28, /* INPUT */int A_29, /* INPUT */int A_30, 
/* INPUT */int A_31, /* INPUT */int A_32, /* INPUT */int A_33, /* INPUT */int A_34, /* INPUT */int A_35, /* INPUT */int A_36, /* INPUT */int A_37, /* INPUT */int A_38, /* INPUT */int A_39, /* INPUT */int A_40, 
/* INPUT */int A_41, /* INPUT */int A_42, /* INPUT */int A_43, /* INPUT */int A_44, /* INPUT */int A_45, /* INPUT */int A_46, /* INPUT */int A_47, /* INPUT */int A_48, /* INPUT */int A_49, /* INPUT */int A_50, 
/* INPUT */int A_51, /* INPUT */int A_52, /* INPUT */int A_53, /* INPUT */int A_54, /* INPUT */int A_55, /* INPUT */int A_56, /* INPUT */int A_57, /* INPUT */int A_58, /* INPUT */int A_59, /* INPUT */int A_60, 
/* INPUT */int A_61, /* INPUT */int A_62, /* INPUT */int A_63, /* INPUT */int A_64, /* INPUT */int A_65, /* INPUT */int A_66, /* INPUT */int A_67, /* INPUT */int A_68, /* INPUT */int A_69, /* INPUT */int A_70, 
/* INPUT */int A_71, /* INPUT */int A_72, /* INPUT */int A_73, /* INPUT */int A_74, /* INPUT */int A_75, /* INPUT */int A_76, /* INPUT */int A_77, /* INPUT */int A_78, /* INPUT */int A_79, /* INPUT */int A_80, 
/* INPUT */int A_81, /* INPUT */int A_82, /* INPUT */int A_83, /* INPUT */int A_84, /* INPUT */int A_85, /* INPUT */int A_86, /* INPUT */int A_87, /* INPUT */int A_88, /* INPUT */int A_89, /* INPUT */int A_90, 
/* INPUT */int A_91, /* INPUT */int A_92, /* INPUT */int A_93, /* INPUT */int A_94, /* INPUT */int A_95, /* INPUT */int A_96, /* INPUT */int A_97, /* INPUT */int A_98, /* INPUT */int A_99, /* INPUT */int A_100, 
/* INPUT */int A_101, /* INPUT */int A_102, /* INPUT */int A_103, /* INPUT */int A_104, /* INPUT */int A_105, /* INPUT */int A_106, /* INPUT */int A_107, /* INPUT */int A_108, /* INPUT */int A_109, /* INPUT */int A_110, 
/* INPUT */int A_111, /* INPUT */int A_112, /* INPUT */int A_113, /* INPUT */int A_114, /* INPUT */int A_115, /* INPUT */int A_116, /* INPUT */int A_117, /* INPUT */int A_118, /* INPUT */int A_119, /* INPUT */int A_120, 
/* INPUT */int A_121, /* INPUT */int A_122, /* INPUT */int A_123, /* INPUT */int A_124, /* INPUT */int A_125, /* INPUT */int A_126, /* INPUT */int A_127, /* INPUT */int A_128, /* INPUT */int A_129) = NULL;
    if (!_vcs_dpi_stub_initialized_) {
        _vcs_dpi_stub_initialized_ = 1;
        _vcs_dpi_fp_ = (int (*)(int A_1, int A_2, int A_3, int A_4, int A_5, int A_6, int A_7, int A_8, int A_9, int A_10, int A_11, int A_12, int A_13, int A_14, int A_15, int A_16, int A_17, int A_18, int A_19, int A_20, int A_21, int A_22, int A_23, int A_24, int A_25, int A_26, int A_27, int A_28, int A_29, int A_30, int A_31, int A_32, int A_33, int A_34, int A_35, int A_36, int A_37, int A_38, int A_39, int A_40, int A_41, int A_42, int A_43, int A_44, int A_45, int A_46, int A_47, int A_48, int A_49, int A_50, int A_51, int A_52, int A_53, int A_54, int A_55, int A_56, int A_57, int A_58, int A_59, int A_60, int A_61, int A_62, int A_63, int A_64, int A_65, int A_66, int A_67, int A_68, int A_69, int A_70, int A_71, int A_72, int A_73, int A_74, int A_75, int A_76, int A_77, int A_78, int A_79, int A_80, int A_81, int A_82, int A_83, int A_84, int A_85, int A_86, int A_87, int A_88, int A_89, int A_90, int A_91, int A_92, int A_93, int A_94, int A_95, int A_96, int A_97, int A_98, int A_99, int A_100, int A_101, int A_102, int A_103, int A_104, int A_105, int A_106, int A_107, int A_108, int A_109, int A_110, int A_111, int A_112, int A_113, int A_114, int A_115, int A_116, int A_117, int A_118, int A_119, int A_120, int A_121, int A_122, int A_123, int A_124, int A_125, int A_126, int A_127, int A_128, int A_129)) dlsym(RTLD_NEXT, "sendWdataStrb");
    }
    if (_vcs_dpi_fp_) {
        return _vcs_dpi_fp_(A_1, A_2, A_3, A_4, A_5, A_6, A_7, A_8, A_9, A_10, A_11, A_12, A_13, A_14, A_15, A_16, A_17, A_18, A_19, A_20, A_21, A_22, A_23, A_24, A_25, A_26, A_27, A_28, A_29, A_30, A_31, A_32, A_33, A_34, A_35, A_36, A_37, A_38, A_39, A_40, A_41, A_42, A_43, A_44, A_45, A_46, A_47, A_48, A_49, A_50, A_51, A_52, A_53, A_54, A_55, A_56, A_57, A_58, A_59, A_60, A_61, A_62, A_63, A_64, A_65, A_66, A_67, A_68, A_69, A_70, A_71, A_72, A_73, A_74, A_75, A_76, A_77, A_78, A_79, A_80, A_81, A_82, A_83, A_84, A_85, A_86, A_87, A_88, A_89, A_90, A_91, A_92, A_93, A_94, A_95, A_96, A_97, A_98, A_99, A_100, A_101, A_102, A_103, A_104, A_105, A_106, A_107, A_108, A_109, A_110, A_111, A_112, A_113, A_114, A_115, A_116, A_117, A_118, A_119, A_120, A_121, A_122, A_123, A_124, A_125, A_126, A_127, A_128, A_129);
    } else {
        const char *fileName;
        int lineNumber;
        svGetCallerInfo(&fileName, &lineNumber);
        vcsMsgReport1("DPI-DIFNF", fileName, lineNumber, 0, 0, "sendWdataStrb");
        return 0;
    }
}
#endif /* __VCS_IMPORT_DPI_STUB_sendWdataStrb */

#ifndef __VCS_IMPORT_DPI_STUB_serviceWRequest
#define __VCS_IMPORT_DPI_STUB_serviceWRequest
__attribute__((weak)) void serviceWRequest()
{
    static int _vcs_dpi_stub_initialized_ = 0;
    static void (*_vcs_dpi_fp_)() = NULL;
    if (!_vcs_dpi_stub_initialized_) {
        _vcs_dpi_stub_initialized_ = 1;
        _vcs_dpi_fp_ = (void (*)()) dlsym(RTLD_NEXT, "serviceWRequest");
    }
    if (_vcs_dpi_fp_) {
        _vcs_dpi_fp_();
    } else {
        const char *fileName;
        int lineNumber;
        svGetCallerInfo(&fileName, &lineNumber);
        vcsMsgReport1("DPI-DIFNF", fileName, lineNumber, 0, 0, "serviceWRequest");
    }
}
#endif /* __VCS_IMPORT_DPI_STUB_serviceWRequest */

#ifndef __VCS_IMPORT_DPI_STUB_popDRAMReadQ
#define __VCS_IMPORT_DPI_STUB_popDRAMReadQ
__attribute__((weak)) void popDRAMReadQ()
{
    static int _vcs_dpi_stub_initialized_ = 0;
    static void (*_vcs_dpi_fp_)() = NULL;
    if (!_vcs_dpi_stub_initialized_) {
        _vcs_dpi_stub_initialized_ = 1;
        _vcs_dpi_fp_ = (void (*)()) dlsym(RTLD_NEXT, "popDRAMReadQ");
    }
    if (_vcs_dpi_fp_) {
        _vcs_dpi_fp_();
    } else {
        const char *fileName;
        int lineNumber;
        svGetCallerInfo(&fileName, &lineNumber);
        vcsMsgReport1("DPI-DIFNF", fileName, lineNumber, 0, 0, "popDRAMReadQ");
    }
}
#endif /* __VCS_IMPORT_DPI_STUB_popDRAMReadQ */

#ifndef __VCS_IMPORT_DPI_STUB_popDRAMWriteQ
#define __VCS_IMPORT_DPI_STUB_popDRAMWriteQ
__attribute__((weak)) void popDRAMWriteQ()
{
    static int _vcs_dpi_stub_initialized_ = 0;
    static void (*_vcs_dpi_fp_)() = NULL;
    if (!_vcs_dpi_stub_initialized_) {
        _vcs_dpi_stub_initialized_ = 1;
        _vcs_dpi_fp_ = (void (*)()) dlsym(RTLD_NEXT, "popDRAMWriteQ");
    }
    if (_vcs_dpi_fp_) {
        _vcs_dpi_fp_();
    } else {
        const char *fileName;
        int lineNumber;
        svGetCallerInfo(&fileName, &lineNumber);
        vcsMsgReport1("DPI-DIFNF", fileName, lineNumber, 0, 0, "popDRAMWriteQ");
    }
}
#endif /* __VCS_IMPORT_DPI_STUB_popDRAMWriteQ */

#ifndef __VCS_IMPORT_DPI_STUB_readOutputStream
#define __VCS_IMPORT_DPI_STUB_readOutputStream
__attribute__((weak)) void readOutputStream(/* INPUT */int A_1, /* INPUT */int A_2, /* INPUT */int A_3)
{
    static int _vcs_dpi_stub_initialized_ = 0;
    static void (*_vcs_dpi_fp_)(/* INPUT */int A_1, /* INPUT */int A_2, /* INPUT */int A_3) = NULL;
    if (!_vcs_dpi_stub_initialized_) {
        _vcs_dpi_stub_initialized_ = 1;
        _vcs_dpi_fp_ = (void (*)(int A_1, int A_2, int A_3)) dlsym(RTLD_NEXT, "readOutputStream");
    }
    if (_vcs_dpi_fp_) {
        _vcs_dpi_fp_(A_1, A_2, A_3);
    } else {
        const char *fileName;
        int lineNumber;
        svGetCallerInfo(&fileName, &lineNumber);
        vcsMsgReport1("DPI-DIFNF", fileName, lineNumber, 0, 0, "readOutputStream");
    }
}
#endif /* __VCS_IMPORT_DPI_STUB_readOutputStream */

#ifndef __VCS_EXPORT_DPI_DUMMY_REFERENCES__
#define __VCS_EXPORT_DPI_DUMMY_REFERENCES__
/* Dummy references to those export DPI routines.
 * The symbols will be then exported, so the
 * import DPI routines in another shared
 * libraries can call.
 */
void __vcs_export_dpi_dummy_references__();
void __vcs_export_dpi_dummy_references__()
{
    extern void start(void);
    void (*fp0)(void) = (void (*)(void)) start;
    fp0 = fp0;
    extern void rst(void);
    void (*fp1)(void) = (void (*)(void)) rst;
    fp1 = fp1;
    extern void startVPD(void);
    void (*fp2)(void) = (void (*)(void)) startVPD;
    fp2 = fp2;
    extern void startVCD(void);
    void (*fp3)(void) = (void (*)(void)) startVCD;
    fp3 = fp3;
    extern void stopVPD(void);
    void (*fp4)(void) = (void (*)(void)) stopVPD;
    fp4 = fp4;
    extern void stopVCD(void);
    void (*fp5)(void) = (void (*)(void)) stopVCD;
    fp5 = fp5;
    extern void readRegRaddr(void);
    void (*fp6)(void) = (void (*)(void)) readRegRaddr;
    fp6 = fp6;
    extern void readRegRdataHi32(void);
    void (*fp7)(void) = (void (*)(void)) readRegRdataHi32;
    fp7 = fp7;
    extern void readRegRdataLo32(void);
    void (*fp8)(void) = (void (*)(void)) readRegRdataLo32;
    fp8 = fp8;
    extern void writeReg(void);
    void (*fp9)(void) = (void (*)(void)) writeReg;
    fp9 = fp9;
    extern void getDRAMReadRespReady(void);
    void (*fp10)(void) = (void (*)(void)) getDRAMReadRespReady;
    fp10 = fp10;
    extern void getDRAMWriteRespReady(void);
    void (*fp11)(void) = (void (*)(void)) getDRAMWriteRespReady;
    fp11 = fp11;
    extern void pokeDRAMReadResponse(void);
    void (*fp12)(void) = (void (*)(void)) pokeDRAMReadResponse;
    fp12 = fp12;
    extern void pokeDRAMWriteResponse(void);
    void (*fp13)(void) = (void (*)(void)) pokeDRAMWriteResponse;
    fp13 = fp13;
    extern void writeStream(void);
    void (*fp14)(void) = (void (*)(void)) writeStream;
    fp14 = fp14;
    extern void getCycles(void);
    void (*fp15)(void) = (void (*)(void)) getCycles;
    fp15 = fp15;
    extern void terminateSim(void);
    void (*fp16)(void) = (void (*)(void)) terminateSim;
    fp16 = fp16;
}
#endif /* __VCS_EXPORT_DPI_DUMMY_REFERENCES_ */

#ifdef __cplusplus
}
#endif

