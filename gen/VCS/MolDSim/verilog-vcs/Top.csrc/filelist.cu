PIC_LD=ld

ARCHIVE_OBJS=
ARCHIVE_OBJS += _2836241_archive_1.so
_2836241_archive_1.so : archive.3/_2836241_archive_1.a
	@$(AR) -s $<
	@$(PIC_LD) -shared  -o .//../accel.bit.bin.daidir//_2836241_archive_1.so --whole-archive $< --no-whole-archive
	@rm -f $@
	@ln -sf .//../accel.bit.bin.daidir//_2836241_archive_1.so $@


ARCHIVE_OBJS += _prev_archive_1.so
_prev_archive_1.so : archive.3/_prev_archive_1.a
	@$(AR) -s $<
	@$(PIC_LD) -shared  -o .//../accel.bit.bin.daidir//_prev_archive_1.so --whole-archive $< --no-whole-archive
	@rm -f $@
	@ln -sf .//../accel.bit.bin.daidir//_prev_archive_1.so $@






%.o: %.c
	$(CC_CG) $(CFLAGS_CG) -c -o $@ $<
CU_UDP_OBJS = \


CU_LVL_OBJS = \
SIM_l.o 

MAIN_OBJS = \
objs/amcQw_d.o 

CU_OBJS = $(MAIN_OBJS) $(ARCHIVE_OBJS) $(CU_UDP_OBJS) $(CU_LVL_OBJS)
