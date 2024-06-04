#include "structs.hpp"
#include <stdint.h>
#include <sys/time.h>
#include <iostream>
#include <fstream>
#include <string> 
#include <sstream> 
#include <stdarg.h>
#include <signal.h>
#include <sys/wait.h>
#include <pwd.h>
#include <map>
#include <math.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#ifndef MAX_CYCLES
#define MAX_CYCLES 10000000000
#endif
#include "FringeContext.h"
#include "functions.hpp"
#include "ArgAPI.hpp"
#include "Fixed.hpp"
#include <vector>
using std::vector;

#ifndef ZYNQ
typedef __int128 int128_t;
#endif

void printHelp(); 

using namespace std;

void Application(int numThreads, vector<string> * args) {
  // Create an execution context.
  FringeContext *c1 = new FringeContext("./verilog/accel.bit.bin");
  c1->load();
  std::ifstream x462_file (string("/home/hhollen/ee109finalHH/mol_arr100.csv"));
  assert(x462_file.good() && "File Const(/home/hhollen/ee109finalHH/mol_arr100.csv) does not exist"); 
  std::vector<string>* x463 = new std::vector<string>; 
  if (x462_file.is_open()) {
    while ( x462_file.good() ) {
      string x463_line;
      getline (x462_file, x463_line);
      string x463_delim = string(",");
      size_t x463_pos = 0;
      while (x463_line.find(x463_delim) != std::string::npos | x463_line.length() > 0) {
        if (x463_line.find(x463_delim) != std::string::npos) {
          x463_pos = x463_line.find(x463_delim);
        } else {
          x463_pos = x463_line.length();
        }
        string x463_token = x463_line.substr(0, x463_pos);
        x463_line.erase(0, x463_pos + x463_delim.length());
        x463->push_back(x463_token);
      }
    }
  }
  x462_file.clear();
  x462_file.seekg(0, x462_file.beg);
  x462_file.close();
  vector<double>* x467 = new vector<double>((*x463).size());
  for (int b5 = 0; b5 < (*x463).size(); b5++) { 
    string x465 = (*x463)[b5];
    double x466 = std::stod(x465);
    (*x467)[b5] = x466;
  }
  uint64_t x468 = c1->malloc(sizeof(double) * 100*3);
  c1->setArg(A_DRAM_ptr, x468, false);
  printf("Allocate mem of size 100*3 at %p\n", (void*)x468);
  vector<int32_t>* x469_rawified = new vector<int32_t>((*x467).size());
  for (int x469_rawified_i = 0; x469_rawified_i < (*x467).size(); x469_rawified_i++) {
    (*x469_rawified)[x469_rawified_i] = (int32_t) ((*x467)[x469_rawified_i] * ((int32_t)1 << 22));
  }
  c1->memcpy(x468, &(*x469_rawified)[0], (*x469_rawified).size() * sizeof(int32_t));
  uint64_t x470 = c1->malloc(sizeof(double) * 100*3);
  c1->setArg(OUT_HOST_ptr, x470, false);
  printf("Allocate mem of size 100*3 at %p\n", (void*)x470);
// Register ArgIns and ArgIOs in case some are unused
c1->setNumArgIns(0 + 2 + 0);
c1->setNumArgIOs(0);
c1->setNumArgOuts(0);
c1->setNumArgOutInstrs(522);
c1->setNumEarlyExits(0);
c1->flushCache(1024);
time_t tstart = time(0);
c1->run();
time_t tend = time(0);
double elapsed = difftime(tend, tstart);
std::cout << "Kernel done, test run time = " << elapsed << " ms" << std::endl;
c1->flushCache(1024);
std::ofstream instrumentation ("./instrumentation.txt");
// Need to instrument List((x444,1), (x543,2), (x499,3), (x542,3), (x516,4), (x541,4), (x2859,2), (x2707,3), (x834,4), (x689,5), (x667,6), (x688,6), (x718,5), (x704,6), (x717,6), (x743,5), (x733,6), (x742,6), (x761,5), (x759,6), (x760,6), (x775,5), (x773,6), (x774,6), (x780,5), (x777,6), (x779,6), (x813,5), (x798,6), (x812,6), (x833,5), (x1042,4), (x897,5), (x875,6), (x896,6), (x926,5), (x912,6), (x925,6), (x951,5), (x941,6), (x950,6), (x969,5), (x967,6), (x968,6), (x983,5), (x981,6), (x982,6), (x988,5), (x985,6), (x987,6), (x1021,5), (x1006,6), (x1020,6), (x1041,5), (x1250,4), (x1105,5), (x1083,6), (x1104,6), (x1134,5), (x1120,6), (x1133,6), (x1159,5), (x1149,6), (x1158,6), (x1177,5), (x1175,6), (x1176,6), (x1191,5), (x1189,6), (x1190,6), (x1196,5), (x1193,6), (x1195,6), (x1229,5), (x1214,6), (x1228,6), (x1249,5), (x1458,4), (x1313,5), (x1291,6), (x1312,6), (x1342,5), (x1328,6), (x1341,6), (x1367,5), (x1357,6), (x1366,6), (x1385,5), (x1383,6), (x1384,6), (x1399,5), (x1397,6), (x1398,6), (x1404,5), (x1401,6), (x1403,6), (x1437,5), (x1422,6), (x1436,6), (x1457,5), (x1666,4), (x1521,5), (x1499,6), (x1520,6), (x1550,5), (x1536,6), (x1549,6), (x1575,5), (x1565,6), (x1574,6), (x1593,5), (x1591,6), (x1592,6), (x1607,5), (x1605,6), (x1606,6), (x1612,5), (x1609,6), (x1611,6), (x1645,5), (x1630,6), (x1644,6), (x1665,5), (x1874,4), (x1729,5), (x1707,6), (x1728,6), (x1758,5), (x1744,6), (x1757,6), (x1783,5), (x1773,6), (x1782,6), (x1801,5), (x1799,6), (x1800,6), (x1815,5), (x1813,6), (x1814,6), (x1820,5), (x1817,6), (x1819,6), (x1853,5), (x1838,6), (x1852,6), (x1873,5), (x2082,4), (x1937,5), (x1915,6), (x1936,6), (x1966,5), (x1952,6), (x1965,6), (x1991,5), (x1981,6), (x1990,6), (x2009,5), (x2007,6), (x2008,6), (x2023,5), (x2021,6), (x2022,6), (x2028,5), (x2025,6), (x2027,6), (x2061,5), (x2046,6), (x2060,6), (x2081,5), (x2290,4), (x2145,5), (x2123,6), (x2144,6), (x2174,5), (x2160,6), (x2173,6), (x2199,5), (x2189,6), (x2198,6), (x2217,5), (x2215,6), (x2216,6), (x2231,5), (x2229,6), (x2230,6), (x2236,5), (x2233,6), (x2235,6), (x2269,5), (x2254,6), (x2268,6), (x2289,5), (x2498,4), (x2353,5), (x2331,6), (x2352,6), (x2382,5), (x2368,6), (x2381,6), (x2407,5), (x2397,6), (x2406,6), (x2425,5), (x2423,6), (x2424,6), (x2439,5), (x2437,6), (x2438,6), (x2444,5), (x2441,6), (x2443,6), (x2477,5), (x2462,6), (x2476,6), (x2497,5), (x2706,4), (x2561,5), (x2539,6), (x2560,6), (x2590,5), (x2576,6), (x2589,6), (x2615,5), (x2605,6), (x2614,6), (x2633,5), (x2631,6), (x2632,6), (x2647,5), (x2645,6), (x2646,6), (x2652,5), (x2649,6), (x2651,6), (x2685,5), (x2670,6), (x2684,6), (x2705,5), (x2858,3), (x2740,4), (x2753,4), (x2766,4), (x2779,4), (x2792,4), (x2805,4), (x2818,4), (x2831,4), (x2844,4), (x2857,4), (x2916,2), (x2915,3), (x2910,4), (x2889,5), (x2909,5), (x2914,4))
std::cout << "ArgIns:" <<  " "  << ", ArgIOs:" <<  " "  << std::endl;
if (instrumentation.is_open()) {
instrumentation << "ArgIns:" <<  " "  << ", ArgIOs:" <<  " "  << std::endl;
}
 // immediate parent hashmap now Map(1 -> x444), current node x444 is at depth 1
long x444_cycles = c1->getArg(X444_cycles_arg, false);
long x444_iters = c1->getArg(X444_iters_arg, false);
long x444_iters_per_parent = x444_iters / std::max((long)1,x444_iters);
long x444_avg = x444_cycles / std::max((long)1,x444_iters);
std::cout << "  x444 - " << x444_avg << " (" << x444_cycles << " / " << x444_iters << ") ";
std::cout << "[" << x444_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "  x444 - " << x444_avg << " (" << x444_cycles << " / " << x444_iters << ") ";
instrumentation << "[" << x444_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x543, 1 -> x444), current node x543 is at depth 2
long x543_cycles = c1->getArg(X543_cycles_arg, false);
long x543_iters = c1->getArg(X543_iters_arg, false);
long x543_iters_per_parent = x543_iters / std::max((long)1,x444_iters);
long x543_avg = x543_cycles / std::max((long)1,x543_iters);
std::cout << "    x543 - " << x543_avg << " (" << x543_cycles << " / " << x543_iters << ") ";
std::cout << "[" << x543_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "    x543 - " << x543_avg << " (" << x543_cycles << " / " << x543_iters << ") ";
instrumentation << "[" << x543_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x543, 1 -> x444, 3 -> x499), current node x499 is at depth 3
long x499_cycles = c1->getArg(X499_cycles_arg, false);
long x499_iters = c1->getArg(X499_iters_arg, false);
long x499_iters_per_parent = x499_iters / std::max((long)1,x543_iters);
long x499_avg = x499_cycles / std::max((long)1,x499_iters);
std::cout << "      x499 - " << x499_avg << " (" << x499_cycles << " / " << x499_iters << ") ";
std::cout << "[" << x499_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "      x499 - " << x499_avg << " (" << x499_cycles << " / " << x499_iters << ") ";
instrumentation << "[" << x499_iters_per_parent << " iters/parent execution]";
}
long x499_stalled = c1->getArg(X499_stalled_arg, false);
long x499_idle = c1->getArg(X499_idle_arg, false);
std::cout << " <# stalled: " << x499_stalled << ", #idle: " << x499_idle << ">";
if (instrumentation.is_open()) {
instrumentation << " <# stalled: " << x499_stalled << ", # idle: " << x499_idle << ">";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x543, 1 -> x444, 3 -> x542), current node x542 is at depth 3
long x542_cycles = c1->getArg(X542_cycles_arg, false);
long x542_iters = c1->getArg(X542_iters_arg, false);
long x542_iters_per_parent = x542_iters / std::max((long)1,x543_iters);
long x542_avg = x542_cycles / std::max((long)1,x542_iters);
std::cout << "      x542 - " << x542_avg << " (" << x542_cycles << " / " << x542_iters << ") ";
std::cout << "[" << x542_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "      x542 - " << x542_avg << " (" << x542_cycles << " / " << x542_iters << ") ";
instrumentation << "[" << x542_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x543, 4 -> x516, 1 -> x444, 3 -> x542), current node x516 is at depth 4
long x516_cycles = c1->getArg(X516_cycles_arg, false);
long x516_iters = c1->getArg(X516_iters_arg, false);
long x516_iters_per_parent = x516_iters / std::max((long)1,x542_iters);
long x516_avg = x516_cycles / std::max((long)1,x516_iters);
std::cout << "        x516 - " << x516_avg << " (" << x516_cycles << " / " << x516_iters << ") ";
std::cout << "[" << x516_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x516 - " << x516_avg << " (" << x516_cycles << " / " << x516_iters << ") ";
instrumentation << "[" << x516_iters_per_parent << " iters/parent execution]";
}
long x516_stalled = c1->getArg(X516_stalled_arg, false);
long x516_idle = c1->getArg(X516_idle_arg, false);
std::cout << " <# stalled: " << x516_stalled << ", #idle: " << x516_idle << ">";
if (instrumentation.is_open()) {
instrumentation << " <# stalled: " << x516_stalled << ", # idle: " << x516_idle << ">";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x543, 4 -> x541, 1 -> x444, 3 -> x542), current node x541 is at depth 4
long x541_cycles = c1->getArg(X541_cycles_arg, false);
long x541_iters = c1->getArg(X541_iters_arg, false);
long x541_iters_per_parent = x541_iters / std::max((long)1,x542_iters);
long x541_avg = x541_cycles / std::max((long)1,x541_iters);
std::cout << "        x541 - " << x541_avg << " (" << x541_cycles << " / " << x541_iters << ") ";
std::cout << "[" << x541_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x541 - " << x541_avg << " (" << x541_cycles << " / " << x541_iters << ") ";
instrumentation << "[" << x541_iters_per_parent << " iters/parent execution]";
}
long x541_stalled = c1->getArg(X541_stalled_arg, false);
long x541_idle = c1->getArg(X541_idle_arg, false);
std::cout << " <# stalled: " << x541_stalled << ", #idle: " << x541_idle << ">";
if (instrumentation.is_open()) {
instrumentation << " <# stalled: " << x541_stalled << ", # idle: " << x541_idle << ">";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 4 -> x541, 1 -> x444, 3 -> x542), current node x2859 is at depth 2
long x2859_cycles = c1->getArg(X2859_cycles_arg, false);
long x2859_iters = c1->getArg(X2859_iters_arg, false);
long x2859_iters_per_parent = x2859_iters / std::max((long)1,x444_iters);
long x2859_avg = x2859_cycles / std::max((long)1,x2859_iters);
std::cout << "    x2859 - " << x2859_avg << " (" << x2859_cycles << " / " << x2859_iters << ") ";
std::cout << "[" << x2859_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "    x2859 - " << x2859_avg << " (" << x2859_cycles << " / " << x2859_iters << ") ";
instrumentation << "[" << x2859_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 4 -> x541, 1 -> x444, 3 -> x2707), current node x2707 is at depth 3
long x2707_cycles = c1->getArg(X2707_cycles_arg, false);
long x2707_iters = c1->getArg(X2707_iters_arg, false);
long x2707_iters_per_parent = x2707_iters / std::max((long)1,x2859_iters);
long x2707_avg = x2707_cycles / std::max((long)1,x2707_iters);
std::cout << "      x2707 - " << x2707_avg << " (" << x2707_cycles << " / " << x2707_iters << ") ";
std::cout << "[" << x2707_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "      x2707 - " << x2707_avg << " (" << x2707_cycles << " / " << x2707_iters << ") ";
instrumentation << "[" << x2707_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 4 -> x834, 1 -> x444, 3 -> x2707), current node x834 is at depth 4
long x834_cycles = c1->getArg(X834_cycles_arg, false);
long x834_iters = c1->getArg(X834_iters_arg, false);
long x834_iters_per_parent = x834_iters / std::max((long)1,x2707_iters);
long x834_avg = x834_cycles / std::max((long)1,x834_iters);
std::cout << "        x834 - " << x834_avg << " (" << x834_cycles << " / " << x834_iters << ") ";
std::cout << "[" << x834_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x834 - " << x834_avg << " (" << x834_cycles << " / " << x834_iters << ") ";
instrumentation << "[" << x834_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x689, 4 -> x834, 1 -> x444, 3 -> x2707), current node x689 is at depth 5
long x689_cycles = c1->getArg(X689_cycles_arg, false);
long x689_iters = c1->getArg(X689_iters_arg, false);
long x689_iters_per_parent = x689_iters / std::max((long)1,x834_iters);
long x689_avg = x689_cycles / std::max((long)1,x689_iters);
std::cout << "          x689 - " << x689_avg << " (" << x689_cycles << " / " << x689_iters << ") ";
std::cout << "[" << x689_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x689 - " << x689_avg << " (" << x689_cycles << " / " << x689_iters << ") ";
instrumentation << "[" << x689_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x689, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x667), current node x667 is at depth 6
long x667_cycles = c1->getArg(X667_cycles_arg, false);
long x667_iters = c1->getArg(X667_iters_arg, false);
long x667_iters_per_parent = x667_iters / std::max((long)1,x689_iters);
long x667_avg = x667_cycles / std::max((long)1,x667_iters);
std::cout << "            x667 - " << x667_avg << " (" << x667_cycles << " / " << x667_iters << ") ";
std::cout << "[" << x667_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x667 - " << x667_avg << " (" << x667_cycles << " / " << x667_iters << ") ";
instrumentation << "[" << x667_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x689, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x688), current node x688 is at depth 6
long x688_cycles = c1->getArg(X688_cycles_arg, false);
long x688_iters = c1->getArg(X688_iters_arg, false);
long x688_iters_per_parent = x688_iters / std::max((long)1,x689_iters);
long x688_avg = x688_cycles / std::max((long)1,x688_iters);
std::cout << "            x688 - " << x688_avg << " (" << x688_cycles << " / " << x688_iters << ") ";
std::cout << "[" << x688_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x688 - " << x688_avg << " (" << x688_cycles << " / " << x688_iters << ") ";
instrumentation << "[" << x688_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x718, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x688), current node x718 is at depth 5
long x718_cycles = c1->getArg(X718_cycles_arg, false);
long x718_iters = c1->getArg(X718_iters_arg, false);
long x718_iters_per_parent = x718_iters / std::max((long)1,x834_iters);
long x718_avg = x718_cycles / std::max((long)1,x718_iters);
std::cout << "          x718 - " << x718_avg << " (" << x718_cycles << " / " << x718_iters << ") ";
std::cout << "[" << x718_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x718 - " << x718_avg << " (" << x718_cycles << " / " << x718_iters << ") ";
instrumentation << "[" << x718_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x718, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x704), current node x704 is at depth 6
long x704_cycles = c1->getArg(X704_cycles_arg, false);
long x704_iters = c1->getArg(X704_iters_arg, false);
long x704_iters_per_parent = x704_iters / std::max((long)1,x718_iters);
long x704_avg = x704_cycles / std::max((long)1,x704_iters);
std::cout << "            x704 - " << x704_avg << " (" << x704_cycles << " / " << x704_iters << ") ";
std::cout << "[" << x704_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x704 - " << x704_avg << " (" << x704_cycles << " / " << x704_iters << ") ";
instrumentation << "[" << x704_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x718, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x717), current node x717 is at depth 6
long x717_cycles = c1->getArg(X717_cycles_arg, false);
long x717_iters = c1->getArg(X717_iters_arg, false);
long x717_iters_per_parent = x717_iters / std::max((long)1,x718_iters);
long x717_avg = x717_cycles / std::max((long)1,x717_iters);
std::cout << "            x717 - " << x717_avg << " (" << x717_cycles << " / " << x717_iters << ") ";
std::cout << "[" << x717_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x717 - " << x717_avg << " (" << x717_cycles << " / " << x717_iters << ") ";
instrumentation << "[" << x717_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x743, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x717), current node x743 is at depth 5
long x743_cycles = c1->getArg(X743_cycles_arg, false);
long x743_iters = c1->getArg(X743_iters_arg, false);
long x743_iters_per_parent = x743_iters / std::max((long)1,x834_iters);
long x743_avg = x743_cycles / std::max((long)1,x743_iters);
std::cout << "          x743 - " << x743_avg << " (" << x743_cycles << " / " << x743_iters << ") ";
std::cout << "[" << x743_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x743 - " << x743_avg << " (" << x743_cycles << " / " << x743_iters << ") ";
instrumentation << "[" << x743_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x743, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x733), current node x733 is at depth 6
long x733_cycles = c1->getArg(X733_cycles_arg, false);
long x733_iters = c1->getArg(X733_iters_arg, false);
long x733_iters_per_parent = x733_iters / std::max((long)1,x743_iters);
long x733_avg = x733_cycles / std::max((long)1,x733_iters);
std::cout << "            x733 - " << x733_avg << " (" << x733_cycles << " / " << x733_iters << ") ";
std::cout << "[" << x733_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x733 - " << x733_avg << " (" << x733_cycles << " / " << x733_iters << ") ";
instrumentation << "[" << x733_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x743, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x742), current node x742 is at depth 6
long x742_cycles = c1->getArg(X742_cycles_arg, false);
long x742_iters = c1->getArg(X742_iters_arg, false);
long x742_iters_per_parent = x742_iters / std::max((long)1,x743_iters);
long x742_avg = x742_cycles / std::max((long)1,x742_iters);
std::cout << "            x742 - " << x742_avg << " (" << x742_cycles << " / " << x742_iters << ") ";
std::cout << "[" << x742_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x742 - " << x742_avg << " (" << x742_cycles << " / " << x742_iters << ") ";
instrumentation << "[" << x742_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x761, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x742), current node x761 is at depth 5
long x761_cycles = c1->getArg(X761_cycles_arg, false);
long x761_iters = c1->getArg(X761_iters_arg, false);
long x761_iters_per_parent = x761_iters / std::max((long)1,x834_iters);
long x761_avg = x761_cycles / std::max((long)1,x761_iters);
std::cout << "          x761 - " << x761_avg << " (" << x761_cycles << " / " << x761_iters << ") ";
std::cout << "[" << x761_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x761 - " << x761_avg << " (" << x761_cycles << " / " << x761_iters << ") ";
instrumentation << "[" << x761_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x761, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x759), current node x759 is at depth 6
long x759_cycles = c1->getArg(X759_cycles_arg, false);
long x759_iters = c1->getArg(X759_iters_arg, false);
long x759_iters_per_parent = x759_iters / std::max((long)1,x761_iters);
long x759_avg = x759_cycles / std::max((long)1,x759_iters);
std::cout << "            x759 - " << x759_avg << " (" << x759_cycles << " / " << x759_iters << ") ";
std::cout << "[" << x759_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x759 - " << x759_avg << " (" << x759_cycles << " / " << x759_iters << ") ";
instrumentation << "[" << x759_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x761, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x760), current node x760 is at depth 6
long x760_cycles = c1->getArg(X760_cycles_arg, false);
long x760_iters = c1->getArg(X760_iters_arg, false);
long x760_iters_per_parent = x760_iters / std::max((long)1,x761_iters);
long x760_avg = x760_cycles / std::max((long)1,x760_iters);
std::cout << "            x760 - " << x760_avg << " (" << x760_cycles << " / " << x760_iters << ") ";
std::cout << "[" << x760_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x760 - " << x760_avg << " (" << x760_cycles << " / " << x760_iters << ") ";
instrumentation << "[" << x760_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x775, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x760), current node x775 is at depth 5
long x775_cycles = c1->getArg(X775_cycles_arg, false);
long x775_iters = c1->getArg(X775_iters_arg, false);
long x775_iters_per_parent = x775_iters / std::max((long)1,x834_iters);
long x775_avg = x775_cycles / std::max((long)1,x775_iters);
std::cout << "          x775 - " << x775_avg << " (" << x775_cycles << " / " << x775_iters << ") ";
std::cout << "[" << x775_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x775 - " << x775_avg << " (" << x775_cycles << " / " << x775_iters << ") ";
instrumentation << "[" << x775_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x775, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x773), current node x773 is at depth 6
long x773_cycles = c1->getArg(X773_cycles_arg, false);
long x773_iters = c1->getArg(X773_iters_arg, false);
long x773_iters_per_parent = x773_iters / std::max((long)1,x775_iters);
long x773_avg = x773_cycles / std::max((long)1,x773_iters);
std::cout << "            x773 - " << x773_avg << " (" << x773_cycles << " / " << x773_iters << ") ";
std::cout << "[" << x773_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x773 - " << x773_avg << " (" << x773_cycles << " / " << x773_iters << ") ";
instrumentation << "[" << x773_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x775, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x774), current node x774 is at depth 6
long x774_cycles = c1->getArg(X774_cycles_arg, false);
long x774_iters = c1->getArg(X774_iters_arg, false);
long x774_iters_per_parent = x774_iters / std::max((long)1,x775_iters);
long x774_avg = x774_cycles / std::max((long)1,x774_iters);
std::cout << "            x774 - " << x774_avg << " (" << x774_cycles << " / " << x774_iters << ") ";
std::cout << "[" << x774_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x774 - " << x774_avg << " (" << x774_cycles << " / " << x774_iters << ") ";
instrumentation << "[" << x774_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x780, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x774), current node x780 is at depth 5
long x780_cycles = c1->getArg(X780_cycles_arg, false);
long x780_iters = c1->getArg(X780_iters_arg, false);
long x780_iters_per_parent = x780_iters / std::max((long)1,x834_iters);
long x780_avg = x780_cycles / std::max((long)1,x780_iters);
std::cout << "          x780 - " << x780_avg << " (" << x780_cycles << " / " << x780_iters << ") ";
std::cout << "[" << x780_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x780 - " << x780_avg << " (" << x780_cycles << " / " << x780_iters << ") ";
instrumentation << "[" << x780_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x780, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x777), current node x777 is at depth 6
long x777_cycles = c1->getArg(X777_cycles_arg, false);
long x777_iters = c1->getArg(X777_iters_arg, false);
long x777_iters_per_parent = x777_iters / std::max((long)1,x780_iters);
long x777_avg = x777_cycles / std::max((long)1,x777_iters);
std::cout << "            x777 - " << x777_avg << " (" << x777_cycles << " / " << x777_iters << ") ";
std::cout << "[" << x777_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x777 - " << x777_avg << " (" << x777_cycles << " / " << x777_iters << ") ";
instrumentation << "[" << x777_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x780, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x779), current node x779 is at depth 6
long x779_cycles = c1->getArg(X779_cycles_arg, false);
long x779_iters = c1->getArg(X779_iters_arg, false);
long x779_iters_per_parent = x779_iters / std::max((long)1,x780_iters);
long x779_avg = x779_cycles / std::max((long)1,x779_iters);
std::cout << "            x779 - " << x779_avg << " (" << x779_cycles << " / " << x779_iters << ") ";
std::cout << "[" << x779_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x779 - " << x779_avg << " (" << x779_cycles << " / " << x779_iters << ") ";
instrumentation << "[" << x779_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x813, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x779), current node x813 is at depth 5
long x813_cycles = c1->getArg(X813_cycles_arg, false);
long x813_iters = c1->getArg(X813_iters_arg, false);
long x813_iters_per_parent = x813_iters / std::max((long)1,x834_iters);
long x813_avg = x813_cycles / std::max((long)1,x813_iters);
std::cout << "          x813 - " << x813_avg << " (" << x813_cycles << " / " << x813_iters << ") ";
std::cout << "[" << x813_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x813 - " << x813_avg << " (" << x813_cycles << " / " << x813_iters << ") ";
instrumentation << "[" << x813_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x813, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x798), current node x798 is at depth 6
long x798_cycles = c1->getArg(X798_cycles_arg, false);
long x798_iters = c1->getArg(X798_iters_arg, false);
long x798_iters_per_parent = x798_iters / std::max((long)1,x813_iters);
long x798_avg = x798_cycles / std::max((long)1,x798_iters);
std::cout << "            x798 - " << x798_avg << " (" << x798_cycles << " / " << x798_iters << ") ";
std::cout << "[" << x798_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x798 - " << x798_avg << " (" << x798_cycles << " / " << x798_iters << ") ";
instrumentation << "[" << x798_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x813, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x812), current node x812 is at depth 6
long x812_cycles = c1->getArg(X812_cycles_arg, false);
long x812_iters = c1->getArg(X812_iters_arg, false);
long x812_iters_per_parent = x812_iters / std::max((long)1,x813_iters);
long x812_avg = x812_cycles / std::max((long)1,x812_iters);
std::cout << "            x812 - " << x812_avg << " (" << x812_cycles << " / " << x812_iters << ") ";
std::cout << "[" << x812_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x812 - " << x812_avg << " (" << x812_cycles << " / " << x812_iters << ") ";
instrumentation << "[" << x812_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x833, 4 -> x834, 1 -> x444, 3 -> x2707, 6 -> x812), current node x833 is at depth 5
long x833_cycles = c1->getArg(X833_cycles_arg, false);
long x833_iters = c1->getArg(X833_iters_arg, false);
long x833_iters_per_parent = x833_iters / std::max((long)1,x834_iters);
long x833_avg = x833_cycles / std::max((long)1,x833_iters);
std::cout << "          x833 - " << x833_avg << " (" << x833_cycles << " / " << x833_iters << ") ";
std::cout << "[" << x833_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x833 - " << x833_avg << " (" << x833_cycles << " / " << x833_iters << ") ";
instrumentation << "[" << x833_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x833, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x812), current node x1042 is at depth 4
long x1042_cycles = c1->getArg(X1042_cycles_arg, false);
long x1042_iters = c1->getArg(X1042_iters_arg, false);
long x1042_iters_per_parent = x1042_iters / std::max((long)1,x2707_iters);
long x1042_avg = x1042_cycles / std::max((long)1,x1042_iters);
std::cout << "        x1042 - " << x1042_avg << " (" << x1042_cycles << " / " << x1042_iters << ") ";
std::cout << "[" << x1042_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x1042 - " << x1042_avg << " (" << x1042_cycles << " / " << x1042_iters << ") ";
instrumentation << "[" << x1042_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x897, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x812), current node x897 is at depth 5
long x897_cycles = c1->getArg(X897_cycles_arg, false);
long x897_iters = c1->getArg(X897_iters_arg, false);
long x897_iters_per_parent = x897_iters / std::max((long)1,x1042_iters);
long x897_avg = x897_cycles / std::max((long)1,x897_iters);
std::cout << "          x897 - " << x897_avg << " (" << x897_cycles << " / " << x897_iters << ") ";
std::cout << "[" << x897_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x897 - " << x897_avg << " (" << x897_cycles << " / " << x897_iters << ") ";
instrumentation << "[" << x897_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x897, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x875), current node x875 is at depth 6
long x875_cycles = c1->getArg(X875_cycles_arg, false);
long x875_iters = c1->getArg(X875_iters_arg, false);
long x875_iters_per_parent = x875_iters / std::max((long)1,x897_iters);
long x875_avg = x875_cycles / std::max((long)1,x875_iters);
std::cout << "            x875 - " << x875_avg << " (" << x875_cycles << " / " << x875_iters << ") ";
std::cout << "[" << x875_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x875 - " << x875_avg << " (" << x875_cycles << " / " << x875_iters << ") ";
instrumentation << "[" << x875_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x897, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x896), current node x896 is at depth 6
long x896_cycles = c1->getArg(X896_cycles_arg, false);
long x896_iters = c1->getArg(X896_iters_arg, false);
long x896_iters_per_parent = x896_iters / std::max((long)1,x897_iters);
long x896_avg = x896_cycles / std::max((long)1,x896_iters);
std::cout << "            x896 - " << x896_avg << " (" << x896_cycles << " / " << x896_iters << ") ";
std::cout << "[" << x896_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x896 - " << x896_avg << " (" << x896_cycles << " / " << x896_iters << ") ";
instrumentation << "[" << x896_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x926, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x896), current node x926 is at depth 5
long x926_cycles = c1->getArg(X926_cycles_arg, false);
long x926_iters = c1->getArg(X926_iters_arg, false);
long x926_iters_per_parent = x926_iters / std::max((long)1,x1042_iters);
long x926_avg = x926_cycles / std::max((long)1,x926_iters);
std::cout << "          x926 - " << x926_avg << " (" << x926_cycles << " / " << x926_iters << ") ";
std::cout << "[" << x926_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x926 - " << x926_avg << " (" << x926_cycles << " / " << x926_iters << ") ";
instrumentation << "[" << x926_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x926, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x912), current node x912 is at depth 6
long x912_cycles = c1->getArg(X912_cycles_arg, false);
long x912_iters = c1->getArg(X912_iters_arg, false);
long x912_iters_per_parent = x912_iters / std::max((long)1,x926_iters);
long x912_avg = x912_cycles / std::max((long)1,x912_iters);
std::cout << "            x912 - " << x912_avg << " (" << x912_cycles << " / " << x912_iters << ") ";
std::cout << "[" << x912_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x912 - " << x912_avg << " (" << x912_cycles << " / " << x912_iters << ") ";
instrumentation << "[" << x912_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x926, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x925), current node x925 is at depth 6
long x925_cycles = c1->getArg(X925_cycles_arg, false);
long x925_iters = c1->getArg(X925_iters_arg, false);
long x925_iters_per_parent = x925_iters / std::max((long)1,x926_iters);
long x925_avg = x925_cycles / std::max((long)1,x925_iters);
std::cout << "            x925 - " << x925_avg << " (" << x925_cycles << " / " << x925_iters << ") ";
std::cout << "[" << x925_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x925 - " << x925_avg << " (" << x925_cycles << " / " << x925_iters << ") ";
instrumentation << "[" << x925_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x951, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x925), current node x951 is at depth 5
long x951_cycles = c1->getArg(X951_cycles_arg, false);
long x951_iters = c1->getArg(X951_iters_arg, false);
long x951_iters_per_parent = x951_iters / std::max((long)1,x1042_iters);
long x951_avg = x951_cycles / std::max((long)1,x951_iters);
std::cout << "          x951 - " << x951_avg << " (" << x951_cycles << " / " << x951_iters << ") ";
std::cout << "[" << x951_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x951 - " << x951_avg << " (" << x951_cycles << " / " << x951_iters << ") ";
instrumentation << "[" << x951_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x951, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x941), current node x941 is at depth 6
long x941_cycles = c1->getArg(X941_cycles_arg, false);
long x941_iters = c1->getArg(X941_iters_arg, false);
long x941_iters_per_parent = x941_iters / std::max((long)1,x951_iters);
long x941_avg = x941_cycles / std::max((long)1,x941_iters);
std::cout << "            x941 - " << x941_avg << " (" << x941_cycles << " / " << x941_iters << ") ";
std::cout << "[" << x941_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x941 - " << x941_avg << " (" << x941_cycles << " / " << x941_iters << ") ";
instrumentation << "[" << x941_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x951, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x950), current node x950 is at depth 6
long x950_cycles = c1->getArg(X950_cycles_arg, false);
long x950_iters = c1->getArg(X950_iters_arg, false);
long x950_iters_per_parent = x950_iters / std::max((long)1,x951_iters);
long x950_avg = x950_cycles / std::max((long)1,x950_iters);
std::cout << "            x950 - " << x950_avg << " (" << x950_cycles << " / " << x950_iters << ") ";
std::cout << "[" << x950_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x950 - " << x950_avg << " (" << x950_cycles << " / " << x950_iters << ") ";
instrumentation << "[" << x950_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x969, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x950), current node x969 is at depth 5
long x969_cycles = c1->getArg(X969_cycles_arg, false);
long x969_iters = c1->getArg(X969_iters_arg, false);
long x969_iters_per_parent = x969_iters / std::max((long)1,x1042_iters);
long x969_avg = x969_cycles / std::max((long)1,x969_iters);
std::cout << "          x969 - " << x969_avg << " (" << x969_cycles << " / " << x969_iters << ") ";
std::cout << "[" << x969_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x969 - " << x969_avg << " (" << x969_cycles << " / " << x969_iters << ") ";
instrumentation << "[" << x969_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x969, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x967), current node x967 is at depth 6
long x967_cycles = c1->getArg(X967_cycles_arg, false);
long x967_iters = c1->getArg(X967_iters_arg, false);
long x967_iters_per_parent = x967_iters / std::max((long)1,x969_iters);
long x967_avg = x967_cycles / std::max((long)1,x967_iters);
std::cout << "            x967 - " << x967_avg << " (" << x967_cycles << " / " << x967_iters << ") ";
std::cout << "[" << x967_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x967 - " << x967_avg << " (" << x967_cycles << " / " << x967_iters << ") ";
instrumentation << "[" << x967_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x969, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x968), current node x968 is at depth 6
long x968_cycles = c1->getArg(X968_cycles_arg, false);
long x968_iters = c1->getArg(X968_iters_arg, false);
long x968_iters_per_parent = x968_iters / std::max((long)1,x969_iters);
long x968_avg = x968_cycles / std::max((long)1,x968_iters);
std::cout << "            x968 - " << x968_avg << " (" << x968_cycles << " / " << x968_iters << ") ";
std::cout << "[" << x968_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x968 - " << x968_avg << " (" << x968_cycles << " / " << x968_iters << ") ";
instrumentation << "[" << x968_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x983, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x968), current node x983 is at depth 5
long x983_cycles = c1->getArg(X983_cycles_arg, false);
long x983_iters = c1->getArg(X983_iters_arg, false);
long x983_iters_per_parent = x983_iters / std::max((long)1,x1042_iters);
long x983_avg = x983_cycles / std::max((long)1,x983_iters);
std::cout << "          x983 - " << x983_avg << " (" << x983_cycles << " / " << x983_iters << ") ";
std::cout << "[" << x983_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x983 - " << x983_avg << " (" << x983_cycles << " / " << x983_iters << ") ";
instrumentation << "[" << x983_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x983, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x981), current node x981 is at depth 6
long x981_cycles = c1->getArg(X981_cycles_arg, false);
long x981_iters = c1->getArg(X981_iters_arg, false);
long x981_iters_per_parent = x981_iters / std::max((long)1,x983_iters);
long x981_avg = x981_cycles / std::max((long)1,x981_iters);
std::cout << "            x981 - " << x981_avg << " (" << x981_cycles << " / " << x981_iters << ") ";
std::cout << "[" << x981_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x981 - " << x981_avg << " (" << x981_cycles << " / " << x981_iters << ") ";
instrumentation << "[" << x981_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x983, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x982), current node x982 is at depth 6
long x982_cycles = c1->getArg(X982_cycles_arg, false);
long x982_iters = c1->getArg(X982_iters_arg, false);
long x982_iters_per_parent = x982_iters / std::max((long)1,x983_iters);
long x982_avg = x982_cycles / std::max((long)1,x982_iters);
std::cout << "            x982 - " << x982_avg << " (" << x982_cycles << " / " << x982_iters << ") ";
std::cout << "[" << x982_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x982 - " << x982_avg << " (" << x982_cycles << " / " << x982_iters << ") ";
instrumentation << "[" << x982_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x988, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x982), current node x988 is at depth 5
long x988_cycles = c1->getArg(X988_cycles_arg, false);
long x988_iters = c1->getArg(X988_iters_arg, false);
long x988_iters_per_parent = x988_iters / std::max((long)1,x1042_iters);
long x988_avg = x988_cycles / std::max((long)1,x988_iters);
std::cout << "          x988 - " << x988_avg << " (" << x988_cycles << " / " << x988_iters << ") ";
std::cout << "[" << x988_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x988 - " << x988_avg << " (" << x988_cycles << " / " << x988_iters << ") ";
instrumentation << "[" << x988_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x988, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x985), current node x985 is at depth 6
long x985_cycles = c1->getArg(X985_cycles_arg, false);
long x985_iters = c1->getArg(X985_iters_arg, false);
long x985_iters_per_parent = x985_iters / std::max((long)1,x988_iters);
long x985_avg = x985_cycles / std::max((long)1,x985_iters);
std::cout << "            x985 - " << x985_avg << " (" << x985_cycles << " / " << x985_iters << ") ";
std::cout << "[" << x985_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x985 - " << x985_avg << " (" << x985_cycles << " / " << x985_iters << ") ";
instrumentation << "[" << x985_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x988, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x987), current node x987 is at depth 6
long x987_cycles = c1->getArg(X987_cycles_arg, false);
long x987_iters = c1->getArg(X987_iters_arg, false);
long x987_iters_per_parent = x987_iters / std::max((long)1,x988_iters);
long x987_avg = x987_cycles / std::max((long)1,x987_iters);
std::cout << "            x987 - " << x987_avg << " (" << x987_cycles << " / " << x987_iters << ") ";
std::cout << "[" << x987_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x987 - " << x987_avg << " (" << x987_cycles << " / " << x987_iters << ") ";
instrumentation << "[" << x987_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1021, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x987), current node x1021 is at depth 5
long x1021_cycles = c1->getArg(X1021_cycles_arg, false);
long x1021_iters = c1->getArg(X1021_iters_arg, false);
long x1021_iters_per_parent = x1021_iters / std::max((long)1,x1042_iters);
long x1021_avg = x1021_cycles / std::max((long)1,x1021_iters);
std::cout << "          x1021 - " << x1021_avg << " (" << x1021_cycles << " / " << x1021_iters << ") ";
std::cout << "[" << x1021_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1021 - " << x1021_avg << " (" << x1021_cycles << " / " << x1021_iters << ") ";
instrumentation << "[" << x1021_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1021, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x1006), current node x1006 is at depth 6
long x1006_cycles = c1->getArg(X1006_cycles_arg, false);
long x1006_iters = c1->getArg(X1006_iters_arg, false);
long x1006_iters_per_parent = x1006_iters / std::max((long)1,x1021_iters);
long x1006_avg = x1006_cycles / std::max((long)1,x1006_iters);
std::cout << "            x1006 - " << x1006_avg << " (" << x1006_cycles << " / " << x1006_iters << ") ";
std::cout << "[" << x1006_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1006 - " << x1006_avg << " (" << x1006_cycles << " / " << x1006_iters << ") ";
instrumentation << "[" << x1006_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1021, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x1020), current node x1020 is at depth 6
long x1020_cycles = c1->getArg(X1020_cycles_arg, false);
long x1020_iters = c1->getArg(X1020_iters_arg, false);
long x1020_iters_per_parent = x1020_iters / std::max((long)1,x1021_iters);
long x1020_avg = x1020_cycles / std::max((long)1,x1020_iters);
std::cout << "            x1020 - " << x1020_avg << " (" << x1020_cycles << " / " << x1020_iters << ") ";
std::cout << "[" << x1020_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1020 - " << x1020_avg << " (" << x1020_cycles << " / " << x1020_iters << ") ";
instrumentation << "[" << x1020_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1041, 4 -> x1042, 1 -> x444, 3 -> x2707, 6 -> x1020), current node x1041 is at depth 5
long x1041_cycles = c1->getArg(X1041_cycles_arg, false);
long x1041_iters = c1->getArg(X1041_iters_arg, false);
long x1041_iters_per_parent = x1041_iters / std::max((long)1,x1042_iters);
long x1041_avg = x1041_cycles / std::max((long)1,x1041_iters);
std::cout << "          x1041 - " << x1041_avg << " (" << x1041_cycles << " / " << x1041_iters << ") ";
std::cout << "[" << x1041_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1041 - " << x1041_avg << " (" << x1041_cycles << " / " << x1041_iters << ") ";
instrumentation << "[" << x1041_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1041, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1020), current node x1250 is at depth 4
long x1250_cycles = c1->getArg(X1250_cycles_arg, false);
long x1250_iters = c1->getArg(X1250_iters_arg, false);
long x1250_iters_per_parent = x1250_iters / std::max((long)1,x2707_iters);
long x1250_avg = x1250_cycles / std::max((long)1,x1250_iters);
std::cout << "        x1250 - " << x1250_avg << " (" << x1250_cycles << " / " << x1250_iters << ") ";
std::cout << "[" << x1250_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x1250 - " << x1250_avg << " (" << x1250_cycles << " / " << x1250_iters << ") ";
instrumentation << "[" << x1250_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1105, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1020), current node x1105 is at depth 5
long x1105_cycles = c1->getArg(X1105_cycles_arg, false);
long x1105_iters = c1->getArg(X1105_iters_arg, false);
long x1105_iters_per_parent = x1105_iters / std::max((long)1,x1250_iters);
long x1105_avg = x1105_cycles / std::max((long)1,x1105_iters);
std::cout << "          x1105 - " << x1105_avg << " (" << x1105_cycles << " / " << x1105_iters << ") ";
std::cout << "[" << x1105_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1105 - " << x1105_avg << " (" << x1105_cycles << " / " << x1105_iters << ") ";
instrumentation << "[" << x1105_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1105, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1083), current node x1083 is at depth 6
long x1083_cycles = c1->getArg(X1083_cycles_arg, false);
long x1083_iters = c1->getArg(X1083_iters_arg, false);
long x1083_iters_per_parent = x1083_iters / std::max((long)1,x1105_iters);
long x1083_avg = x1083_cycles / std::max((long)1,x1083_iters);
std::cout << "            x1083 - " << x1083_avg << " (" << x1083_cycles << " / " << x1083_iters << ") ";
std::cout << "[" << x1083_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1083 - " << x1083_avg << " (" << x1083_cycles << " / " << x1083_iters << ") ";
instrumentation << "[" << x1083_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1105, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1104), current node x1104 is at depth 6
long x1104_cycles = c1->getArg(X1104_cycles_arg, false);
long x1104_iters = c1->getArg(X1104_iters_arg, false);
long x1104_iters_per_parent = x1104_iters / std::max((long)1,x1105_iters);
long x1104_avg = x1104_cycles / std::max((long)1,x1104_iters);
std::cout << "            x1104 - " << x1104_avg << " (" << x1104_cycles << " / " << x1104_iters << ") ";
std::cout << "[" << x1104_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1104 - " << x1104_avg << " (" << x1104_cycles << " / " << x1104_iters << ") ";
instrumentation << "[" << x1104_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1134, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1104), current node x1134 is at depth 5
long x1134_cycles = c1->getArg(X1134_cycles_arg, false);
long x1134_iters = c1->getArg(X1134_iters_arg, false);
long x1134_iters_per_parent = x1134_iters / std::max((long)1,x1250_iters);
long x1134_avg = x1134_cycles / std::max((long)1,x1134_iters);
std::cout << "          x1134 - " << x1134_avg << " (" << x1134_cycles << " / " << x1134_iters << ") ";
std::cout << "[" << x1134_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1134 - " << x1134_avg << " (" << x1134_cycles << " / " << x1134_iters << ") ";
instrumentation << "[" << x1134_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1134, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1120), current node x1120 is at depth 6
long x1120_cycles = c1->getArg(X1120_cycles_arg, false);
long x1120_iters = c1->getArg(X1120_iters_arg, false);
long x1120_iters_per_parent = x1120_iters / std::max((long)1,x1134_iters);
long x1120_avg = x1120_cycles / std::max((long)1,x1120_iters);
std::cout << "            x1120 - " << x1120_avg << " (" << x1120_cycles << " / " << x1120_iters << ") ";
std::cout << "[" << x1120_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1120 - " << x1120_avg << " (" << x1120_cycles << " / " << x1120_iters << ") ";
instrumentation << "[" << x1120_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1134, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1133), current node x1133 is at depth 6
long x1133_cycles = c1->getArg(X1133_cycles_arg, false);
long x1133_iters = c1->getArg(X1133_iters_arg, false);
long x1133_iters_per_parent = x1133_iters / std::max((long)1,x1134_iters);
long x1133_avg = x1133_cycles / std::max((long)1,x1133_iters);
std::cout << "            x1133 - " << x1133_avg << " (" << x1133_cycles << " / " << x1133_iters << ") ";
std::cout << "[" << x1133_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1133 - " << x1133_avg << " (" << x1133_cycles << " / " << x1133_iters << ") ";
instrumentation << "[" << x1133_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1159, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1133), current node x1159 is at depth 5
long x1159_cycles = c1->getArg(X1159_cycles_arg, false);
long x1159_iters = c1->getArg(X1159_iters_arg, false);
long x1159_iters_per_parent = x1159_iters / std::max((long)1,x1250_iters);
long x1159_avg = x1159_cycles / std::max((long)1,x1159_iters);
std::cout << "          x1159 - " << x1159_avg << " (" << x1159_cycles << " / " << x1159_iters << ") ";
std::cout << "[" << x1159_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1159 - " << x1159_avg << " (" << x1159_cycles << " / " << x1159_iters << ") ";
instrumentation << "[" << x1159_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1159, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1149), current node x1149 is at depth 6
long x1149_cycles = c1->getArg(X1149_cycles_arg, false);
long x1149_iters = c1->getArg(X1149_iters_arg, false);
long x1149_iters_per_parent = x1149_iters / std::max((long)1,x1159_iters);
long x1149_avg = x1149_cycles / std::max((long)1,x1149_iters);
std::cout << "            x1149 - " << x1149_avg << " (" << x1149_cycles << " / " << x1149_iters << ") ";
std::cout << "[" << x1149_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1149 - " << x1149_avg << " (" << x1149_cycles << " / " << x1149_iters << ") ";
instrumentation << "[" << x1149_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1159, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1158), current node x1158 is at depth 6
long x1158_cycles = c1->getArg(X1158_cycles_arg, false);
long x1158_iters = c1->getArg(X1158_iters_arg, false);
long x1158_iters_per_parent = x1158_iters / std::max((long)1,x1159_iters);
long x1158_avg = x1158_cycles / std::max((long)1,x1158_iters);
std::cout << "            x1158 - " << x1158_avg << " (" << x1158_cycles << " / " << x1158_iters << ") ";
std::cout << "[" << x1158_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1158 - " << x1158_avg << " (" << x1158_cycles << " / " << x1158_iters << ") ";
instrumentation << "[" << x1158_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1177, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1158), current node x1177 is at depth 5
long x1177_cycles = c1->getArg(X1177_cycles_arg, false);
long x1177_iters = c1->getArg(X1177_iters_arg, false);
long x1177_iters_per_parent = x1177_iters / std::max((long)1,x1250_iters);
long x1177_avg = x1177_cycles / std::max((long)1,x1177_iters);
std::cout << "          x1177 - " << x1177_avg << " (" << x1177_cycles << " / " << x1177_iters << ") ";
std::cout << "[" << x1177_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1177 - " << x1177_avg << " (" << x1177_cycles << " / " << x1177_iters << ") ";
instrumentation << "[" << x1177_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1177, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1175), current node x1175 is at depth 6
long x1175_cycles = c1->getArg(X1175_cycles_arg, false);
long x1175_iters = c1->getArg(X1175_iters_arg, false);
long x1175_iters_per_parent = x1175_iters / std::max((long)1,x1177_iters);
long x1175_avg = x1175_cycles / std::max((long)1,x1175_iters);
std::cout << "            x1175 - " << x1175_avg << " (" << x1175_cycles << " / " << x1175_iters << ") ";
std::cout << "[" << x1175_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1175 - " << x1175_avg << " (" << x1175_cycles << " / " << x1175_iters << ") ";
instrumentation << "[" << x1175_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1177, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1176), current node x1176 is at depth 6
long x1176_cycles = c1->getArg(X1176_cycles_arg, false);
long x1176_iters = c1->getArg(X1176_iters_arg, false);
long x1176_iters_per_parent = x1176_iters / std::max((long)1,x1177_iters);
long x1176_avg = x1176_cycles / std::max((long)1,x1176_iters);
std::cout << "            x1176 - " << x1176_avg << " (" << x1176_cycles << " / " << x1176_iters << ") ";
std::cout << "[" << x1176_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1176 - " << x1176_avg << " (" << x1176_cycles << " / " << x1176_iters << ") ";
instrumentation << "[" << x1176_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1191, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1176), current node x1191 is at depth 5
long x1191_cycles = c1->getArg(X1191_cycles_arg, false);
long x1191_iters = c1->getArg(X1191_iters_arg, false);
long x1191_iters_per_parent = x1191_iters / std::max((long)1,x1250_iters);
long x1191_avg = x1191_cycles / std::max((long)1,x1191_iters);
std::cout << "          x1191 - " << x1191_avg << " (" << x1191_cycles << " / " << x1191_iters << ") ";
std::cout << "[" << x1191_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1191 - " << x1191_avg << " (" << x1191_cycles << " / " << x1191_iters << ") ";
instrumentation << "[" << x1191_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1191, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1189), current node x1189 is at depth 6
long x1189_cycles = c1->getArg(X1189_cycles_arg, false);
long x1189_iters = c1->getArg(X1189_iters_arg, false);
long x1189_iters_per_parent = x1189_iters / std::max((long)1,x1191_iters);
long x1189_avg = x1189_cycles / std::max((long)1,x1189_iters);
std::cout << "            x1189 - " << x1189_avg << " (" << x1189_cycles << " / " << x1189_iters << ") ";
std::cout << "[" << x1189_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1189 - " << x1189_avg << " (" << x1189_cycles << " / " << x1189_iters << ") ";
instrumentation << "[" << x1189_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1191, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1190), current node x1190 is at depth 6
long x1190_cycles = c1->getArg(X1190_cycles_arg, false);
long x1190_iters = c1->getArg(X1190_iters_arg, false);
long x1190_iters_per_parent = x1190_iters / std::max((long)1,x1191_iters);
long x1190_avg = x1190_cycles / std::max((long)1,x1190_iters);
std::cout << "            x1190 - " << x1190_avg << " (" << x1190_cycles << " / " << x1190_iters << ") ";
std::cout << "[" << x1190_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1190 - " << x1190_avg << " (" << x1190_cycles << " / " << x1190_iters << ") ";
instrumentation << "[" << x1190_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1196, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1190), current node x1196 is at depth 5
long x1196_cycles = c1->getArg(X1196_cycles_arg, false);
long x1196_iters = c1->getArg(X1196_iters_arg, false);
long x1196_iters_per_parent = x1196_iters / std::max((long)1,x1250_iters);
long x1196_avg = x1196_cycles / std::max((long)1,x1196_iters);
std::cout << "          x1196 - " << x1196_avg << " (" << x1196_cycles << " / " << x1196_iters << ") ";
std::cout << "[" << x1196_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1196 - " << x1196_avg << " (" << x1196_cycles << " / " << x1196_iters << ") ";
instrumentation << "[" << x1196_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1196, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1193), current node x1193 is at depth 6
long x1193_cycles = c1->getArg(X1193_cycles_arg, false);
long x1193_iters = c1->getArg(X1193_iters_arg, false);
long x1193_iters_per_parent = x1193_iters / std::max((long)1,x1196_iters);
long x1193_avg = x1193_cycles / std::max((long)1,x1193_iters);
std::cout << "            x1193 - " << x1193_avg << " (" << x1193_cycles << " / " << x1193_iters << ") ";
std::cout << "[" << x1193_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1193 - " << x1193_avg << " (" << x1193_cycles << " / " << x1193_iters << ") ";
instrumentation << "[" << x1193_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1196, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1195), current node x1195 is at depth 6
long x1195_cycles = c1->getArg(X1195_cycles_arg, false);
long x1195_iters = c1->getArg(X1195_iters_arg, false);
long x1195_iters_per_parent = x1195_iters / std::max((long)1,x1196_iters);
long x1195_avg = x1195_cycles / std::max((long)1,x1195_iters);
std::cout << "            x1195 - " << x1195_avg << " (" << x1195_cycles << " / " << x1195_iters << ") ";
std::cout << "[" << x1195_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1195 - " << x1195_avg << " (" << x1195_cycles << " / " << x1195_iters << ") ";
instrumentation << "[" << x1195_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1229, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1195), current node x1229 is at depth 5
long x1229_cycles = c1->getArg(X1229_cycles_arg, false);
long x1229_iters = c1->getArg(X1229_iters_arg, false);
long x1229_iters_per_parent = x1229_iters / std::max((long)1,x1250_iters);
long x1229_avg = x1229_cycles / std::max((long)1,x1229_iters);
std::cout << "          x1229 - " << x1229_avg << " (" << x1229_cycles << " / " << x1229_iters << ") ";
std::cout << "[" << x1229_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1229 - " << x1229_avg << " (" << x1229_cycles << " / " << x1229_iters << ") ";
instrumentation << "[" << x1229_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1229, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1214), current node x1214 is at depth 6
long x1214_cycles = c1->getArg(X1214_cycles_arg, false);
long x1214_iters = c1->getArg(X1214_iters_arg, false);
long x1214_iters_per_parent = x1214_iters / std::max((long)1,x1229_iters);
long x1214_avg = x1214_cycles / std::max((long)1,x1214_iters);
std::cout << "            x1214 - " << x1214_avg << " (" << x1214_cycles << " / " << x1214_iters << ") ";
std::cout << "[" << x1214_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1214 - " << x1214_avg << " (" << x1214_cycles << " / " << x1214_iters << ") ";
instrumentation << "[" << x1214_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1229, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1228), current node x1228 is at depth 6
long x1228_cycles = c1->getArg(X1228_cycles_arg, false);
long x1228_iters = c1->getArg(X1228_iters_arg, false);
long x1228_iters_per_parent = x1228_iters / std::max((long)1,x1229_iters);
long x1228_avg = x1228_cycles / std::max((long)1,x1228_iters);
std::cout << "            x1228 - " << x1228_avg << " (" << x1228_cycles << " / " << x1228_iters << ") ";
std::cout << "[" << x1228_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1228 - " << x1228_avg << " (" << x1228_cycles << " / " << x1228_iters << ") ";
instrumentation << "[" << x1228_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1249, 4 -> x1250, 1 -> x444, 3 -> x2707, 6 -> x1228), current node x1249 is at depth 5
long x1249_cycles = c1->getArg(X1249_cycles_arg, false);
long x1249_iters = c1->getArg(X1249_iters_arg, false);
long x1249_iters_per_parent = x1249_iters / std::max((long)1,x1250_iters);
long x1249_avg = x1249_cycles / std::max((long)1,x1249_iters);
std::cout << "          x1249 - " << x1249_avg << " (" << x1249_cycles << " / " << x1249_iters << ") ";
std::cout << "[" << x1249_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1249 - " << x1249_avg << " (" << x1249_cycles << " / " << x1249_iters << ") ";
instrumentation << "[" << x1249_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1249, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1228), current node x1458 is at depth 4
long x1458_cycles = c1->getArg(X1458_cycles_arg, false);
long x1458_iters = c1->getArg(X1458_iters_arg, false);
long x1458_iters_per_parent = x1458_iters / std::max((long)1,x2707_iters);
long x1458_avg = x1458_cycles / std::max((long)1,x1458_iters);
std::cout << "        x1458 - " << x1458_avg << " (" << x1458_cycles << " / " << x1458_iters << ") ";
std::cout << "[" << x1458_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x1458 - " << x1458_avg << " (" << x1458_cycles << " / " << x1458_iters << ") ";
instrumentation << "[" << x1458_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1313, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1228), current node x1313 is at depth 5
long x1313_cycles = c1->getArg(X1313_cycles_arg, false);
long x1313_iters = c1->getArg(X1313_iters_arg, false);
long x1313_iters_per_parent = x1313_iters / std::max((long)1,x1458_iters);
long x1313_avg = x1313_cycles / std::max((long)1,x1313_iters);
std::cout << "          x1313 - " << x1313_avg << " (" << x1313_cycles << " / " << x1313_iters << ") ";
std::cout << "[" << x1313_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1313 - " << x1313_avg << " (" << x1313_cycles << " / " << x1313_iters << ") ";
instrumentation << "[" << x1313_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1313, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1291), current node x1291 is at depth 6
long x1291_cycles = c1->getArg(X1291_cycles_arg, false);
long x1291_iters = c1->getArg(X1291_iters_arg, false);
long x1291_iters_per_parent = x1291_iters / std::max((long)1,x1313_iters);
long x1291_avg = x1291_cycles / std::max((long)1,x1291_iters);
std::cout << "            x1291 - " << x1291_avg << " (" << x1291_cycles << " / " << x1291_iters << ") ";
std::cout << "[" << x1291_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1291 - " << x1291_avg << " (" << x1291_cycles << " / " << x1291_iters << ") ";
instrumentation << "[" << x1291_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1313, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1312), current node x1312 is at depth 6
long x1312_cycles = c1->getArg(X1312_cycles_arg, false);
long x1312_iters = c1->getArg(X1312_iters_arg, false);
long x1312_iters_per_parent = x1312_iters / std::max((long)1,x1313_iters);
long x1312_avg = x1312_cycles / std::max((long)1,x1312_iters);
std::cout << "            x1312 - " << x1312_avg << " (" << x1312_cycles << " / " << x1312_iters << ") ";
std::cout << "[" << x1312_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1312 - " << x1312_avg << " (" << x1312_cycles << " / " << x1312_iters << ") ";
instrumentation << "[" << x1312_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1342, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1312), current node x1342 is at depth 5
long x1342_cycles = c1->getArg(X1342_cycles_arg, false);
long x1342_iters = c1->getArg(X1342_iters_arg, false);
long x1342_iters_per_parent = x1342_iters / std::max((long)1,x1458_iters);
long x1342_avg = x1342_cycles / std::max((long)1,x1342_iters);
std::cout << "          x1342 - " << x1342_avg << " (" << x1342_cycles << " / " << x1342_iters << ") ";
std::cout << "[" << x1342_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1342 - " << x1342_avg << " (" << x1342_cycles << " / " << x1342_iters << ") ";
instrumentation << "[" << x1342_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1342, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1328), current node x1328 is at depth 6
long x1328_cycles = c1->getArg(X1328_cycles_arg, false);
long x1328_iters = c1->getArg(X1328_iters_arg, false);
long x1328_iters_per_parent = x1328_iters / std::max((long)1,x1342_iters);
long x1328_avg = x1328_cycles / std::max((long)1,x1328_iters);
std::cout << "            x1328 - " << x1328_avg << " (" << x1328_cycles << " / " << x1328_iters << ") ";
std::cout << "[" << x1328_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1328 - " << x1328_avg << " (" << x1328_cycles << " / " << x1328_iters << ") ";
instrumentation << "[" << x1328_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1342, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1341), current node x1341 is at depth 6
long x1341_cycles = c1->getArg(X1341_cycles_arg, false);
long x1341_iters = c1->getArg(X1341_iters_arg, false);
long x1341_iters_per_parent = x1341_iters / std::max((long)1,x1342_iters);
long x1341_avg = x1341_cycles / std::max((long)1,x1341_iters);
std::cout << "            x1341 - " << x1341_avg << " (" << x1341_cycles << " / " << x1341_iters << ") ";
std::cout << "[" << x1341_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1341 - " << x1341_avg << " (" << x1341_cycles << " / " << x1341_iters << ") ";
instrumentation << "[" << x1341_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1367, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1341), current node x1367 is at depth 5
long x1367_cycles = c1->getArg(X1367_cycles_arg, false);
long x1367_iters = c1->getArg(X1367_iters_arg, false);
long x1367_iters_per_parent = x1367_iters / std::max((long)1,x1458_iters);
long x1367_avg = x1367_cycles / std::max((long)1,x1367_iters);
std::cout << "          x1367 - " << x1367_avg << " (" << x1367_cycles << " / " << x1367_iters << ") ";
std::cout << "[" << x1367_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1367 - " << x1367_avg << " (" << x1367_cycles << " / " << x1367_iters << ") ";
instrumentation << "[" << x1367_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1367, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1357), current node x1357 is at depth 6
long x1357_cycles = c1->getArg(X1357_cycles_arg, false);
long x1357_iters = c1->getArg(X1357_iters_arg, false);
long x1357_iters_per_parent = x1357_iters / std::max((long)1,x1367_iters);
long x1357_avg = x1357_cycles / std::max((long)1,x1357_iters);
std::cout << "            x1357 - " << x1357_avg << " (" << x1357_cycles << " / " << x1357_iters << ") ";
std::cout << "[" << x1357_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1357 - " << x1357_avg << " (" << x1357_cycles << " / " << x1357_iters << ") ";
instrumentation << "[" << x1357_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1367, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1366), current node x1366 is at depth 6
long x1366_cycles = c1->getArg(X1366_cycles_arg, false);
long x1366_iters = c1->getArg(X1366_iters_arg, false);
long x1366_iters_per_parent = x1366_iters / std::max((long)1,x1367_iters);
long x1366_avg = x1366_cycles / std::max((long)1,x1366_iters);
std::cout << "            x1366 - " << x1366_avg << " (" << x1366_cycles << " / " << x1366_iters << ") ";
std::cout << "[" << x1366_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1366 - " << x1366_avg << " (" << x1366_cycles << " / " << x1366_iters << ") ";
instrumentation << "[" << x1366_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1385, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1366), current node x1385 is at depth 5
long x1385_cycles = c1->getArg(X1385_cycles_arg, false);
long x1385_iters = c1->getArg(X1385_iters_arg, false);
long x1385_iters_per_parent = x1385_iters / std::max((long)1,x1458_iters);
long x1385_avg = x1385_cycles / std::max((long)1,x1385_iters);
std::cout << "          x1385 - " << x1385_avg << " (" << x1385_cycles << " / " << x1385_iters << ") ";
std::cout << "[" << x1385_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1385 - " << x1385_avg << " (" << x1385_cycles << " / " << x1385_iters << ") ";
instrumentation << "[" << x1385_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1385, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1383), current node x1383 is at depth 6
long x1383_cycles = c1->getArg(X1383_cycles_arg, false);
long x1383_iters = c1->getArg(X1383_iters_arg, false);
long x1383_iters_per_parent = x1383_iters / std::max((long)1,x1385_iters);
long x1383_avg = x1383_cycles / std::max((long)1,x1383_iters);
std::cout << "            x1383 - " << x1383_avg << " (" << x1383_cycles << " / " << x1383_iters << ") ";
std::cout << "[" << x1383_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1383 - " << x1383_avg << " (" << x1383_cycles << " / " << x1383_iters << ") ";
instrumentation << "[" << x1383_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1385, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1384), current node x1384 is at depth 6
long x1384_cycles = c1->getArg(X1384_cycles_arg, false);
long x1384_iters = c1->getArg(X1384_iters_arg, false);
long x1384_iters_per_parent = x1384_iters / std::max((long)1,x1385_iters);
long x1384_avg = x1384_cycles / std::max((long)1,x1384_iters);
std::cout << "            x1384 - " << x1384_avg << " (" << x1384_cycles << " / " << x1384_iters << ") ";
std::cout << "[" << x1384_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1384 - " << x1384_avg << " (" << x1384_cycles << " / " << x1384_iters << ") ";
instrumentation << "[" << x1384_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1399, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1384), current node x1399 is at depth 5
long x1399_cycles = c1->getArg(X1399_cycles_arg, false);
long x1399_iters = c1->getArg(X1399_iters_arg, false);
long x1399_iters_per_parent = x1399_iters / std::max((long)1,x1458_iters);
long x1399_avg = x1399_cycles / std::max((long)1,x1399_iters);
std::cout << "          x1399 - " << x1399_avg << " (" << x1399_cycles << " / " << x1399_iters << ") ";
std::cout << "[" << x1399_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1399 - " << x1399_avg << " (" << x1399_cycles << " / " << x1399_iters << ") ";
instrumentation << "[" << x1399_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1399, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1397), current node x1397 is at depth 6
long x1397_cycles = c1->getArg(X1397_cycles_arg, false);
long x1397_iters = c1->getArg(X1397_iters_arg, false);
long x1397_iters_per_parent = x1397_iters / std::max((long)1,x1399_iters);
long x1397_avg = x1397_cycles / std::max((long)1,x1397_iters);
std::cout << "            x1397 - " << x1397_avg << " (" << x1397_cycles << " / " << x1397_iters << ") ";
std::cout << "[" << x1397_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1397 - " << x1397_avg << " (" << x1397_cycles << " / " << x1397_iters << ") ";
instrumentation << "[" << x1397_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1399, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1398), current node x1398 is at depth 6
long x1398_cycles = c1->getArg(X1398_cycles_arg, false);
long x1398_iters = c1->getArg(X1398_iters_arg, false);
long x1398_iters_per_parent = x1398_iters / std::max((long)1,x1399_iters);
long x1398_avg = x1398_cycles / std::max((long)1,x1398_iters);
std::cout << "            x1398 - " << x1398_avg << " (" << x1398_cycles << " / " << x1398_iters << ") ";
std::cout << "[" << x1398_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1398 - " << x1398_avg << " (" << x1398_cycles << " / " << x1398_iters << ") ";
instrumentation << "[" << x1398_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1404, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1398), current node x1404 is at depth 5
long x1404_cycles = c1->getArg(X1404_cycles_arg, false);
long x1404_iters = c1->getArg(X1404_iters_arg, false);
long x1404_iters_per_parent = x1404_iters / std::max((long)1,x1458_iters);
long x1404_avg = x1404_cycles / std::max((long)1,x1404_iters);
std::cout << "          x1404 - " << x1404_avg << " (" << x1404_cycles << " / " << x1404_iters << ") ";
std::cout << "[" << x1404_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1404 - " << x1404_avg << " (" << x1404_cycles << " / " << x1404_iters << ") ";
instrumentation << "[" << x1404_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1404, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1401), current node x1401 is at depth 6
long x1401_cycles = c1->getArg(X1401_cycles_arg, false);
long x1401_iters = c1->getArg(X1401_iters_arg, false);
long x1401_iters_per_parent = x1401_iters / std::max((long)1,x1404_iters);
long x1401_avg = x1401_cycles / std::max((long)1,x1401_iters);
std::cout << "            x1401 - " << x1401_avg << " (" << x1401_cycles << " / " << x1401_iters << ") ";
std::cout << "[" << x1401_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1401 - " << x1401_avg << " (" << x1401_cycles << " / " << x1401_iters << ") ";
instrumentation << "[" << x1401_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1404, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1403), current node x1403 is at depth 6
long x1403_cycles = c1->getArg(X1403_cycles_arg, false);
long x1403_iters = c1->getArg(X1403_iters_arg, false);
long x1403_iters_per_parent = x1403_iters / std::max((long)1,x1404_iters);
long x1403_avg = x1403_cycles / std::max((long)1,x1403_iters);
std::cout << "            x1403 - " << x1403_avg << " (" << x1403_cycles << " / " << x1403_iters << ") ";
std::cout << "[" << x1403_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1403 - " << x1403_avg << " (" << x1403_cycles << " / " << x1403_iters << ") ";
instrumentation << "[" << x1403_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1437, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1403), current node x1437 is at depth 5
long x1437_cycles = c1->getArg(X1437_cycles_arg, false);
long x1437_iters = c1->getArg(X1437_iters_arg, false);
long x1437_iters_per_parent = x1437_iters / std::max((long)1,x1458_iters);
long x1437_avg = x1437_cycles / std::max((long)1,x1437_iters);
std::cout << "          x1437 - " << x1437_avg << " (" << x1437_cycles << " / " << x1437_iters << ") ";
std::cout << "[" << x1437_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1437 - " << x1437_avg << " (" << x1437_cycles << " / " << x1437_iters << ") ";
instrumentation << "[" << x1437_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1437, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1422), current node x1422 is at depth 6
long x1422_cycles = c1->getArg(X1422_cycles_arg, false);
long x1422_iters = c1->getArg(X1422_iters_arg, false);
long x1422_iters_per_parent = x1422_iters / std::max((long)1,x1437_iters);
long x1422_avg = x1422_cycles / std::max((long)1,x1422_iters);
std::cout << "            x1422 - " << x1422_avg << " (" << x1422_cycles << " / " << x1422_iters << ") ";
std::cout << "[" << x1422_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1422 - " << x1422_avg << " (" << x1422_cycles << " / " << x1422_iters << ") ";
instrumentation << "[" << x1422_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1437, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1436), current node x1436 is at depth 6
long x1436_cycles = c1->getArg(X1436_cycles_arg, false);
long x1436_iters = c1->getArg(X1436_iters_arg, false);
long x1436_iters_per_parent = x1436_iters / std::max((long)1,x1437_iters);
long x1436_avg = x1436_cycles / std::max((long)1,x1436_iters);
std::cout << "            x1436 - " << x1436_avg << " (" << x1436_cycles << " / " << x1436_iters << ") ";
std::cout << "[" << x1436_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1436 - " << x1436_avg << " (" << x1436_cycles << " / " << x1436_iters << ") ";
instrumentation << "[" << x1436_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1457, 4 -> x1458, 1 -> x444, 3 -> x2707, 6 -> x1436), current node x1457 is at depth 5
long x1457_cycles = c1->getArg(X1457_cycles_arg, false);
long x1457_iters = c1->getArg(X1457_iters_arg, false);
long x1457_iters_per_parent = x1457_iters / std::max((long)1,x1458_iters);
long x1457_avg = x1457_cycles / std::max((long)1,x1457_iters);
std::cout << "          x1457 - " << x1457_avg << " (" << x1457_cycles << " / " << x1457_iters << ") ";
std::cout << "[" << x1457_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1457 - " << x1457_avg << " (" << x1457_cycles << " / " << x1457_iters << ") ";
instrumentation << "[" << x1457_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1457, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1436), current node x1666 is at depth 4
long x1666_cycles = c1->getArg(X1666_cycles_arg, false);
long x1666_iters = c1->getArg(X1666_iters_arg, false);
long x1666_iters_per_parent = x1666_iters / std::max((long)1,x2707_iters);
long x1666_avg = x1666_cycles / std::max((long)1,x1666_iters);
std::cout << "        x1666 - " << x1666_avg << " (" << x1666_cycles << " / " << x1666_iters << ") ";
std::cout << "[" << x1666_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x1666 - " << x1666_avg << " (" << x1666_cycles << " / " << x1666_iters << ") ";
instrumentation << "[" << x1666_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1521, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1436), current node x1521 is at depth 5
long x1521_cycles = c1->getArg(X1521_cycles_arg, false);
long x1521_iters = c1->getArg(X1521_iters_arg, false);
long x1521_iters_per_parent = x1521_iters / std::max((long)1,x1666_iters);
long x1521_avg = x1521_cycles / std::max((long)1,x1521_iters);
std::cout << "          x1521 - " << x1521_avg << " (" << x1521_cycles << " / " << x1521_iters << ") ";
std::cout << "[" << x1521_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1521 - " << x1521_avg << " (" << x1521_cycles << " / " << x1521_iters << ") ";
instrumentation << "[" << x1521_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1521, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1499), current node x1499 is at depth 6
long x1499_cycles = c1->getArg(X1499_cycles_arg, false);
long x1499_iters = c1->getArg(X1499_iters_arg, false);
long x1499_iters_per_parent = x1499_iters / std::max((long)1,x1521_iters);
long x1499_avg = x1499_cycles / std::max((long)1,x1499_iters);
std::cout << "            x1499 - " << x1499_avg << " (" << x1499_cycles << " / " << x1499_iters << ") ";
std::cout << "[" << x1499_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1499 - " << x1499_avg << " (" << x1499_cycles << " / " << x1499_iters << ") ";
instrumentation << "[" << x1499_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1521, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1520), current node x1520 is at depth 6
long x1520_cycles = c1->getArg(X1520_cycles_arg, false);
long x1520_iters = c1->getArg(X1520_iters_arg, false);
long x1520_iters_per_parent = x1520_iters / std::max((long)1,x1521_iters);
long x1520_avg = x1520_cycles / std::max((long)1,x1520_iters);
std::cout << "            x1520 - " << x1520_avg << " (" << x1520_cycles << " / " << x1520_iters << ") ";
std::cout << "[" << x1520_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1520 - " << x1520_avg << " (" << x1520_cycles << " / " << x1520_iters << ") ";
instrumentation << "[" << x1520_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1550, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1520), current node x1550 is at depth 5
long x1550_cycles = c1->getArg(X1550_cycles_arg, false);
long x1550_iters = c1->getArg(X1550_iters_arg, false);
long x1550_iters_per_parent = x1550_iters / std::max((long)1,x1666_iters);
long x1550_avg = x1550_cycles / std::max((long)1,x1550_iters);
std::cout << "          x1550 - " << x1550_avg << " (" << x1550_cycles << " / " << x1550_iters << ") ";
std::cout << "[" << x1550_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1550 - " << x1550_avg << " (" << x1550_cycles << " / " << x1550_iters << ") ";
instrumentation << "[" << x1550_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1550, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1536), current node x1536 is at depth 6
long x1536_cycles = c1->getArg(X1536_cycles_arg, false);
long x1536_iters = c1->getArg(X1536_iters_arg, false);
long x1536_iters_per_parent = x1536_iters / std::max((long)1,x1550_iters);
long x1536_avg = x1536_cycles / std::max((long)1,x1536_iters);
std::cout << "            x1536 - " << x1536_avg << " (" << x1536_cycles << " / " << x1536_iters << ") ";
std::cout << "[" << x1536_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1536 - " << x1536_avg << " (" << x1536_cycles << " / " << x1536_iters << ") ";
instrumentation << "[" << x1536_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1550, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1549), current node x1549 is at depth 6
long x1549_cycles = c1->getArg(X1549_cycles_arg, false);
long x1549_iters = c1->getArg(X1549_iters_arg, false);
long x1549_iters_per_parent = x1549_iters / std::max((long)1,x1550_iters);
long x1549_avg = x1549_cycles / std::max((long)1,x1549_iters);
std::cout << "            x1549 - " << x1549_avg << " (" << x1549_cycles << " / " << x1549_iters << ") ";
std::cout << "[" << x1549_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1549 - " << x1549_avg << " (" << x1549_cycles << " / " << x1549_iters << ") ";
instrumentation << "[" << x1549_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1575, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1549), current node x1575 is at depth 5
long x1575_cycles = c1->getArg(X1575_cycles_arg, false);
long x1575_iters = c1->getArg(X1575_iters_arg, false);
long x1575_iters_per_parent = x1575_iters / std::max((long)1,x1666_iters);
long x1575_avg = x1575_cycles / std::max((long)1,x1575_iters);
std::cout << "          x1575 - " << x1575_avg << " (" << x1575_cycles << " / " << x1575_iters << ") ";
std::cout << "[" << x1575_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1575 - " << x1575_avg << " (" << x1575_cycles << " / " << x1575_iters << ") ";
instrumentation << "[" << x1575_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1575, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1565), current node x1565 is at depth 6
long x1565_cycles = c1->getArg(X1565_cycles_arg, false);
long x1565_iters = c1->getArg(X1565_iters_arg, false);
long x1565_iters_per_parent = x1565_iters / std::max((long)1,x1575_iters);
long x1565_avg = x1565_cycles / std::max((long)1,x1565_iters);
std::cout << "            x1565 - " << x1565_avg << " (" << x1565_cycles << " / " << x1565_iters << ") ";
std::cout << "[" << x1565_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1565 - " << x1565_avg << " (" << x1565_cycles << " / " << x1565_iters << ") ";
instrumentation << "[" << x1565_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1575, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1574), current node x1574 is at depth 6
long x1574_cycles = c1->getArg(X1574_cycles_arg, false);
long x1574_iters = c1->getArg(X1574_iters_arg, false);
long x1574_iters_per_parent = x1574_iters / std::max((long)1,x1575_iters);
long x1574_avg = x1574_cycles / std::max((long)1,x1574_iters);
std::cout << "            x1574 - " << x1574_avg << " (" << x1574_cycles << " / " << x1574_iters << ") ";
std::cout << "[" << x1574_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1574 - " << x1574_avg << " (" << x1574_cycles << " / " << x1574_iters << ") ";
instrumentation << "[" << x1574_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1593, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1574), current node x1593 is at depth 5
long x1593_cycles = c1->getArg(X1593_cycles_arg, false);
long x1593_iters = c1->getArg(X1593_iters_arg, false);
long x1593_iters_per_parent = x1593_iters / std::max((long)1,x1666_iters);
long x1593_avg = x1593_cycles / std::max((long)1,x1593_iters);
std::cout << "          x1593 - " << x1593_avg << " (" << x1593_cycles << " / " << x1593_iters << ") ";
std::cout << "[" << x1593_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1593 - " << x1593_avg << " (" << x1593_cycles << " / " << x1593_iters << ") ";
instrumentation << "[" << x1593_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1593, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1591), current node x1591 is at depth 6
long x1591_cycles = c1->getArg(X1591_cycles_arg, false);
long x1591_iters = c1->getArg(X1591_iters_arg, false);
long x1591_iters_per_parent = x1591_iters / std::max((long)1,x1593_iters);
long x1591_avg = x1591_cycles / std::max((long)1,x1591_iters);
std::cout << "            x1591 - " << x1591_avg << " (" << x1591_cycles << " / " << x1591_iters << ") ";
std::cout << "[" << x1591_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1591 - " << x1591_avg << " (" << x1591_cycles << " / " << x1591_iters << ") ";
instrumentation << "[" << x1591_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1593, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1592), current node x1592 is at depth 6
long x1592_cycles = c1->getArg(X1592_cycles_arg, false);
long x1592_iters = c1->getArg(X1592_iters_arg, false);
long x1592_iters_per_parent = x1592_iters / std::max((long)1,x1593_iters);
long x1592_avg = x1592_cycles / std::max((long)1,x1592_iters);
std::cout << "            x1592 - " << x1592_avg << " (" << x1592_cycles << " / " << x1592_iters << ") ";
std::cout << "[" << x1592_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1592 - " << x1592_avg << " (" << x1592_cycles << " / " << x1592_iters << ") ";
instrumentation << "[" << x1592_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1607, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1592), current node x1607 is at depth 5
long x1607_cycles = c1->getArg(X1607_cycles_arg, false);
long x1607_iters = c1->getArg(X1607_iters_arg, false);
long x1607_iters_per_parent = x1607_iters / std::max((long)1,x1666_iters);
long x1607_avg = x1607_cycles / std::max((long)1,x1607_iters);
std::cout << "          x1607 - " << x1607_avg << " (" << x1607_cycles << " / " << x1607_iters << ") ";
std::cout << "[" << x1607_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1607 - " << x1607_avg << " (" << x1607_cycles << " / " << x1607_iters << ") ";
instrumentation << "[" << x1607_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1607, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1605), current node x1605 is at depth 6
long x1605_cycles = c1->getArg(X1605_cycles_arg, false);
long x1605_iters = c1->getArg(X1605_iters_arg, false);
long x1605_iters_per_parent = x1605_iters / std::max((long)1,x1607_iters);
long x1605_avg = x1605_cycles / std::max((long)1,x1605_iters);
std::cout << "            x1605 - " << x1605_avg << " (" << x1605_cycles << " / " << x1605_iters << ") ";
std::cout << "[" << x1605_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1605 - " << x1605_avg << " (" << x1605_cycles << " / " << x1605_iters << ") ";
instrumentation << "[" << x1605_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1607, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1606), current node x1606 is at depth 6
long x1606_cycles = c1->getArg(X1606_cycles_arg, false);
long x1606_iters = c1->getArg(X1606_iters_arg, false);
long x1606_iters_per_parent = x1606_iters / std::max((long)1,x1607_iters);
long x1606_avg = x1606_cycles / std::max((long)1,x1606_iters);
std::cout << "            x1606 - " << x1606_avg << " (" << x1606_cycles << " / " << x1606_iters << ") ";
std::cout << "[" << x1606_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1606 - " << x1606_avg << " (" << x1606_cycles << " / " << x1606_iters << ") ";
instrumentation << "[" << x1606_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1612, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1606), current node x1612 is at depth 5
long x1612_cycles = c1->getArg(X1612_cycles_arg, false);
long x1612_iters = c1->getArg(X1612_iters_arg, false);
long x1612_iters_per_parent = x1612_iters / std::max((long)1,x1666_iters);
long x1612_avg = x1612_cycles / std::max((long)1,x1612_iters);
std::cout << "          x1612 - " << x1612_avg << " (" << x1612_cycles << " / " << x1612_iters << ") ";
std::cout << "[" << x1612_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1612 - " << x1612_avg << " (" << x1612_cycles << " / " << x1612_iters << ") ";
instrumentation << "[" << x1612_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1612, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1609), current node x1609 is at depth 6
long x1609_cycles = c1->getArg(X1609_cycles_arg, false);
long x1609_iters = c1->getArg(X1609_iters_arg, false);
long x1609_iters_per_parent = x1609_iters / std::max((long)1,x1612_iters);
long x1609_avg = x1609_cycles / std::max((long)1,x1609_iters);
std::cout << "            x1609 - " << x1609_avg << " (" << x1609_cycles << " / " << x1609_iters << ") ";
std::cout << "[" << x1609_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1609 - " << x1609_avg << " (" << x1609_cycles << " / " << x1609_iters << ") ";
instrumentation << "[" << x1609_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1612, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1611), current node x1611 is at depth 6
long x1611_cycles = c1->getArg(X1611_cycles_arg, false);
long x1611_iters = c1->getArg(X1611_iters_arg, false);
long x1611_iters_per_parent = x1611_iters / std::max((long)1,x1612_iters);
long x1611_avg = x1611_cycles / std::max((long)1,x1611_iters);
std::cout << "            x1611 - " << x1611_avg << " (" << x1611_cycles << " / " << x1611_iters << ") ";
std::cout << "[" << x1611_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1611 - " << x1611_avg << " (" << x1611_cycles << " / " << x1611_iters << ") ";
instrumentation << "[" << x1611_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1645, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1611), current node x1645 is at depth 5
long x1645_cycles = c1->getArg(X1645_cycles_arg, false);
long x1645_iters = c1->getArg(X1645_iters_arg, false);
long x1645_iters_per_parent = x1645_iters / std::max((long)1,x1666_iters);
long x1645_avg = x1645_cycles / std::max((long)1,x1645_iters);
std::cout << "          x1645 - " << x1645_avg << " (" << x1645_cycles << " / " << x1645_iters << ") ";
std::cout << "[" << x1645_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1645 - " << x1645_avg << " (" << x1645_cycles << " / " << x1645_iters << ") ";
instrumentation << "[" << x1645_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1645, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1630), current node x1630 is at depth 6
long x1630_cycles = c1->getArg(X1630_cycles_arg, false);
long x1630_iters = c1->getArg(X1630_iters_arg, false);
long x1630_iters_per_parent = x1630_iters / std::max((long)1,x1645_iters);
long x1630_avg = x1630_cycles / std::max((long)1,x1630_iters);
std::cout << "            x1630 - " << x1630_avg << " (" << x1630_cycles << " / " << x1630_iters << ") ";
std::cout << "[" << x1630_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1630 - " << x1630_avg << " (" << x1630_cycles << " / " << x1630_iters << ") ";
instrumentation << "[" << x1630_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1645, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1644), current node x1644 is at depth 6
long x1644_cycles = c1->getArg(X1644_cycles_arg, false);
long x1644_iters = c1->getArg(X1644_iters_arg, false);
long x1644_iters_per_parent = x1644_iters / std::max((long)1,x1645_iters);
long x1644_avg = x1644_cycles / std::max((long)1,x1644_iters);
std::cout << "            x1644 - " << x1644_avg << " (" << x1644_cycles << " / " << x1644_iters << ") ";
std::cout << "[" << x1644_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1644 - " << x1644_avg << " (" << x1644_cycles << " / " << x1644_iters << ") ";
instrumentation << "[" << x1644_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1665, 4 -> x1666, 1 -> x444, 3 -> x2707, 6 -> x1644), current node x1665 is at depth 5
long x1665_cycles = c1->getArg(X1665_cycles_arg, false);
long x1665_iters = c1->getArg(X1665_iters_arg, false);
long x1665_iters_per_parent = x1665_iters / std::max((long)1,x1666_iters);
long x1665_avg = x1665_cycles / std::max((long)1,x1665_iters);
std::cout << "          x1665 - " << x1665_avg << " (" << x1665_cycles << " / " << x1665_iters << ") ";
std::cout << "[" << x1665_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1665 - " << x1665_avg << " (" << x1665_cycles << " / " << x1665_iters << ") ";
instrumentation << "[" << x1665_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1665, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1644), current node x1874 is at depth 4
long x1874_cycles = c1->getArg(X1874_cycles_arg, false);
long x1874_iters = c1->getArg(X1874_iters_arg, false);
long x1874_iters_per_parent = x1874_iters / std::max((long)1,x2707_iters);
long x1874_avg = x1874_cycles / std::max((long)1,x1874_iters);
std::cout << "        x1874 - " << x1874_avg << " (" << x1874_cycles << " / " << x1874_iters << ") ";
std::cout << "[" << x1874_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x1874 - " << x1874_avg << " (" << x1874_cycles << " / " << x1874_iters << ") ";
instrumentation << "[" << x1874_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1729, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1644), current node x1729 is at depth 5
long x1729_cycles = c1->getArg(X1729_cycles_arg, false);
long x1729_iters = c1->getArg(X1729_iters_arg, false);
long x1729_iters_per_parent = x1729_iters / std::max((long)1,x1874_iters);
long x1729_avg = x1729_cycles / std::max((long)1,x1729_iters);
std::cout << "          x1729 - " << x1729_avg << " (" << x1729_cycles << " / " << x1729_iters << ") ";
std::cout << "[" << x1729_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1729 - " << x1729_avg << " (" << x1729_cycles << " / " << x1729_iters << ") ";
instrumentation << "[" << x1729_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1729, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1707), current node x1707 is at depth 6
long x1707_cycles = c1->getArg(X1707_cycles_arg, false);
long x1707_iters = c1->getArg(X1707_iters_arg, false);
long x1707_iters_per_parent = x1707_iters / std::max((long)1,x1729_iters);
long x1707_avg = x1707_cycles / std::max((long)1,x1707_iters);
std::cout << "            x1707 - " << x1707_avg << " (" << x1707_cycles << " / " << x1707_iters << ") ";
std::cout << "[" << x1707_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1707 - " << x1707_avg << " (" << x1707_cycles << " / " << x1707_iters << ") ";
instrumentation << "[" << x1707_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1729, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1728), current node x1728 is at depth 6
long x1728_cycles = c1->getArg(X1728_cycles_arg, false);
long x1728_iters = c1->getArg(X1728_iters_arg, false);
long x1728_iters_per_parent = x1728_iters / std::max((long)1,x1729_iters);
long x1728_avg = x1728_cycles / std::max((long)1,x1728_iters);
std::cout << "            x1728 - " << x1728_avg << " (" << x1728_cycles << " / " << x1728_iters << ") ";
std::cout << "[" << x1728_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1728 - " << x1728_avg << " (" << x1728_cycles << " / " << x1728_iters << ") ";
instrumentation << "[" << x1728_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1758, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1728), current node x1758 is at depth 5
long x1758_cycles = c1->getArg(X1758_cycles_arg, false);
long x1758_iters = c1->getArg(X1758_iters_arg, false);
long x1758_iters_per_parent = x1758_iters / std::max((long)1,x1874_iters);
long x1758_avg = x1758_cycles / std::max((long)1,x1758_iters);
std::cout << "          x1758 - " << x1758_avg << " (" << x1758_cycles << " / " << x1758_iters << ") ";
std::cout << "[" << x1758_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1758 - " << x1758_avg << " (" << x1758_cycles << " / " << x1758_iters << ") ";
instrumentation << "[" << x1758_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1758, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1744), current node x1744 is at depth 6
long x1744_cycles = c1->getArg(X1744_cycles_arg, false);
long x1744_iters = c1->getArg(X1744_iters_arg, false);
long x1744_iters_per_parent = x1744_iters / std::max((long)1,x1758_iters);
long x1744_avg = x1744_cycles / std::max((long)1,x1744_iters);
std::cout << "            x1744 - " << x1744_avg << " (" << x1744_cycles << " / " << x1744_iters << ") ";
std::cout << "[" << x1744_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1744 - " << x1744_avg << " (" << x1744_cycles << " / " << x1744_iters << ") ";
instrumentation << "[" << x1744_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1758, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1757), current node x1757 is at depth 6
long x1757_cycles = c1->getArg(X1757_cycles_arg, false);
long x1757_iters = c1->getArg(X1757_iters_arg, false);
long x1757_iters_per_parent = x1757_iters / std::max((long)1,x1758_iters);
long x1757_avg = x1757_cycles / std::max((long)1,x1757_iters);
std::cout << "            x1757 - " << x1757_avg << " (" << x1757_cycles << " / " << x1757_iters << ") ";
std::cout << "[" << x1757_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1757 - " << x1757_avg << " (" << x1757_cycles << " / " << x1757_iters << ") ";
instrumentation << "[" << x1757_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1783, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1757), current node x1783 is at depth 5
long x1783_cycles = c1->getArg(X1783_cycles_arg, false);
long x1783_iters = c1->getArg(X1783_iters_arg, false);
long x1783_iters_per_parent = x1783_iters / std::max((long)1,x1874_iters);
long x1783_avg = x1783_cycles / std::max((long)1,x1783_iters);
std::cout << "          x1783 - " << x1783_avg << " (" << x1783_cycles << " / " << x1783_iters << ") ";
std::cout << "[" << x1783_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1783 - " << x1783_avg << " (" << x1783_cycles << " / " << x1783_iters << ") ";
instrumentation << "[" << x1783_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1783, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1773), current node x1773 is at depth 6
long x1773_cycles = c1->getArg(X1773_cycles_arg, false);
long x1773_iters = c1->getArg(X1773_iters_arg, false);
long x1773_iters_per_parent = x1773_iters / std::max((long)1,x1783_iters);
long x1773_avg = x1773_cycles / std::max((long)1,x1773_iters);
std::cout << "            x1773 - " << x1773_avg << " (" << x1773_cycles << " / " << x1773_iters << ") ";
std::cout << "[" << x1773_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1773 - " << x1773_avg << " (" << x1773_cycles << " / " << x1773_iters << ") ";
instrumentation << "[" << x1773_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1783, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1782), current node x1782 is at depth 6
long x1782_cycles = c1->getArg(X1782_cycles_arg, false);
long x1782_iters = c1->getArg(X1782_iters_arg, false);
long x1782_iters_per_parent = x1782_iters / std::max((long)1,x1783_iters);
long x1782_avg = x1782_cycles / std::max((long)1,x1782_iters);
std::cout << "            x1782 - " << x1782_avg << " (" << x1782_cycles << " / " << x1782_iters << ") ";
std::cout << "[" << x1782_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1782 - " << x1782_avg << " (" << x1782_cycles << " / " << x1782_iters << ") ";
instrumentation << "[" << x1782_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1801, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1782), current node x1801 is at depth 5
long x1801_cycles = c1->getArg(X1801_cycles_arg, false);
long x1801_iters = c1->getArg(X1801_iters_arg, false);
long x1801_iters_per_parent = x1801_iters / std::max((long)1,x1874_iters);
long x1801_avg = x1801_cycles / std::max((long)1,x1801_iters);
std::cout << "          x1801 - " << x1801_avg << " (" << x1801_cycles << " / " << x1801_iters << ") ";
std::cout << "[" << x1801_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1801 - " << x1801_avg << " (" << x1801_cycles << " / " << x1801_iters << ") ";
instrumentation << "[" << x1801_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1801, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1799), current node x1799 is at depth 6
long x1799_cycles = c1->getArg(X1799_cycles_arg, false);
long x1799_iters = c1->getArg(X1799_iters_arg, false);
long x1799_iters_per_parent = x1799_iters / std::max((long)1,x1801_iters);
long x1799_avg = x1799_cycles / std::max((long)1,x1799_iters);
std::cout << "            x1799 - " << x1799_avg << " (" << x1799_cycles << " / " << x1799_iters << ") ";
std::cout << "[" << x1799_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1799 - " << x1799_avg << " (" << x1799_cycles << " / " << x1799_iters << ") ";
instrumentation << "[" << x1799_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1801, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1800), current node x1800 is at depth 6
long x1800_cycles = c1->getArg(X1800_cycles_arg, false);
long x1800_iters = c1->getArg(X1800_iters_arg, false);
long x1800_iters_per_parent = x1800_iters / std::max((long)1,x1801_iters);
long x1800_avg = x1800_cycles / std::max((long)1,x1800_iters);
std::cout << "            x1800 - " << x1800_avg << " (" << x1800_cycles << " / " << x1800_iters << ") ";
std::cout << "[" << x1800_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1800 - " << x1800_avg << " (" << x1800_cycles << " / " << x1800_iters << ") ";
instrumentation << "[" << x1800_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1815, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1800), current node x1815 is at depth 5
long x1815_cycles = c1->getArg(X1815_cycles_arg, false);
long x1815_iters = c1->getArg(X1815_iters_arg, false);
long x1815_iters_per_parent = x1815_iters / std::max((long)1,x1874_iters);
long x1815_avg = x1815_cycles / std::max((long)1,x1815_iters);
std::cout << "          x1815 - " << x1815_avg << " (" << x1815_cycles << " / " << x1815_iters << ") ";
std::cout << "[" << x1815_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1815 - " << x1815_avg << " (" << x1815_cycles << " / " << x1815_iters << ") ";
instrumentation << "[" << x1815_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1815, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1813), current node x1813 is at depth 6
long x1813_cycles = c1->getArg(X1813_cycles_arg, false);
long x1813_iters = c1->getArg(X1813_iters_arg, false);
long x1813_iters_per_parent = x1813_iters / std::max((long)1,x1815_iters);
long x1813_avg = x1813_cycles / std::max((long)1,x1813_iters);
std::cout << "            x1813 - " << x1813_avg << " (" << x1813_cycles << " / " << x1813_iters << ") ";
std::cout << "[" << x1813_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1813 - " << x1813_avg << " (" << x1813_cycles << " / " << x1813_iters << ") ";
instrumentation << "[" << x1813_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1815, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1814), current node x1814 is at depth 6
long x1814_cycles = c1->getArg(X1814_cycles_arg, false);
long x1814_iters = c1->getArg(X1814_iters_arg, false);
long x1814_iters_per_parent = x1814_iters / std::max((long)1,x1815_iters);
long x1814_avg = x1814_cycles / std::max((long)1,x1814_iters);
std::cout << "            x1814 - " << x1814_avg << " (" << x1814_cycles << " / " << x1814_iters << ") ";
std::cout << "[" << x1814_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1814 - " << x1814_avg << " (" << x1814_cycles << " / " << x1814_iters << ") ";
instrumentation << "[" << x1814_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1820, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1814), current node x1820 is at depth 5
long x1820_cycles = c1->getArg(X1820_cycles_arg, false);
long x1820_iters = c1->getArg(X1820_iters_arg, false);
long x1820_iters_per_parent = x1820_iters / std::max((long)1,x1874_iters);
long x1820_avg = x1820_cycles / std::max((long)1,x1820_iters);
std::cout << "          x1820 - " << x1820_avg << " (" << x1820_cycles << " / " << x1820_iters << ") ";
std::cout << "[" << x1820_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1820 - " << x1820_avg << " (" << x1820_cycles << " / " << x1820_iters << ") ";
instrumentation << "[" << x1820_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1820, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1817), current node x1817 is at depth 6
long x1817_cycles = c1->getArg(X1817_cycles_arg, false);
long x1817_iters = c1->getArg(X1817_iters_arg, false);
long x1817_iters_per_parent = x1817_iters / std::max((long)1,x1820_iters);
long x1817_avg = x1817_cycles / std::max((long)1,x1817_iters);
std::cout << "            x1817 - " << x1817_avg << " (" << x1817_cycles << " / " << x1817_iters << ") ";
std::cout << "[" << x1817_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1817 - " << x1817_avg << " (" << x1817_cycles << " / " << x1817_iters << ") ";
instrumentation << "[" << x1817_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1820, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1819), current node x1819 is at depth 6
long x1819_cycles = c1->getArg(X1819_cycles_arg, false);
long x1819_iters = c1->getArg(X1819_iters_arg, false);
long x1819_iters_per_parent = x1819_iters / std::max((long)1,x1820_iters);
long x1819_avg = x1819_cycles / std::max((long)1,x1819_iters);
std::cout << "            x1819 - " << x1819_avg << " (" << x1819_cycles << " / " << x1819_iters << ") ";
std::cout << "[" << x1819_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1819 - " << x1819_avg << " (" << x1819_cycles << " / " << x1819_iters << ") ";
instrumentation << "[" << x1819_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1853, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1819), current node x1853 is at depth 5
long x1853_cycles = c1->getArg(X1853_cycles_arg, false);
long x1853_iters = c1->getArg(X1853_iters_arg, false);
long x1853_iters_per_parent = x1853_iters / std::max((long)1,x1874_iters);
long x1853_avg = x1853_cycles / std::max((long)1,x1853_iters);
std::cout << "          x1853 - " << x1853_avg << " (" << x1853_cycles << " / " << x1853_iters << ") ";
std::cout << "[" << x1853_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1853 - " << x1853_avg << " (" << x1853_cycles << " / " << x1853_iters << ") ";
instrumentation << "[" << x1853_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1853, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1838), current node x1838 is at depth 6
long x1838_cycles = c1->getArg(X1838_cycles_arg, false);
long x1838_iters = c1->getArg(X1838_iters_arg, false);
long x1838_iters_per_parent = x1838_iters / std::max((long)1,x1853_iters);
long x1838_avg = x1838_cycles / std::max((long)1,x1838_iters);
std::cout << "            x1838 - " << x1838_avg << " (" << x1838_cycles << " / " << x1838_iters << ") ";
std::cout << "[" << x1838_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1838 - " << x1838_avg << " (" << x1838_cycles << " / " << x1838_iters << ") ";
instrumentation << "[" << x1838_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1853, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1852), current node x1852 is at depth 6
long x1852_cycles = c1->getArg(X1852_cycles_arg, false);
long x1852_iters = c1->getArg(X1852_iters_arg, false);
long x1852_iters_per_parent = x1852_iters / std::max((long)1,x1853_iters);
long x1852_avg = x1852_cycles / std::max((long)1,x1852_iters);
std::cout << "            x1852 - " << x1852_avg << " (" << x1852_cycles << " / " << x1852_iters << ") ";
std::cout << "[" << x1852_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1852 - " << x1852_avg << " (" << x1852_cycles << " / " << x1852_iters << ") ";
instrumentation << "[" << x1852_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1873, 4 -> x1874, 1 -> x444, 3 -> x2707, 6 -> x1852), current node x1873 is at depth 5
long x1873_cycles = c1->getArg(X1873_cycles_arg, false);
long x1873_iters = c1->getArg(X1873_iters_arg, false);
long x1873_iters_per_parent = x1873_iters / std::max((long)1,x1874_iters);
long x1873_avg = x1873_cycles / std::max((long)1,x1873_iters);
std::cout << "          x1873 - " << x1873_avg << " (" << x1873_cycles << " / " << x1873_iters << ") ";
std::cout << "[" << x1873_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1873 - " << x1873_avg << " (" << x1873_cycles << " / " << x1873_iters << ") ";
instrumentation << "[" << x1873_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1873, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1852), current node x2082 is at depth 4
long x2082_cycles = c1->getArg(X2082_cycles_arg, false);
long x2082_iters = c1->getArg(X2082_iters_arg, false);
long x2082_iters_per_parent = x2082_iters / std::max((long)1,x2707_iters);
long x2082_avg = x2082_cycles / std::max((long)1,x2082_iters);
std::cout << "        x2082 - " << x2082_avg << " (" << x2082_cycles << " / " << x2082_iters << ") ";
std::cout << "[" << x2082_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2082 - " << x2082_avg << " (" << x2082_cycles << " / " << x2082_iters << ") ";
instrumentation << "[" << x2082_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1937, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1852), current node x1937 is at depth 5
long x1937_cycles = c1->getArg(X1937_cycles_arg, false);
long x1937_iters = c1->getArg(X1937_iters_arg, false);
long x1937_iters_per_parent = x1937_iters / std::max((long)1,x2082_iters);
long x1937_avg = x1937_cycles / std::max((long)1,x1937_iters);
std::cout << "          x1937 - " << x1937_avg << " (" << x1937_cycles << " / " << x1937_iters << ") ";
std::cout << "[" << x1937_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1937 - " << x1937_avg << " (" << x1937_cycles << " / " << x1937_iters << ") ";
instrumentation << "[" << x1937_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1937, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1915), current node x1915 is at depth 6
long x1915_cycles = c1->getArg(X1915_cycles_arg, false);
long x1915_iters = c1->getArg(X1915_iters_arg, false);
long x1915_iters_per_parent = x1915_iters / std::max((long)1,x1937_iters);
long x1915_avg = x1915_cycles / std::max((long)1,x1915_iters);
std::cout << "            x1915 - " << x1915_avg << " (" << x1915_cycles << " / " << x1915_iters << ") ";
std::cout << "[" << x1915_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1915 - " << x1915_avg << " (" << x1915_cycles << " / " << x1915_iters << ") ";
instrumentation << "[" << x1915_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1937, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1936), current node x1936 is at depth 6
long x1936_cycles = c1->getArg(X1936_cycles_arg, false);
long x1936_iters = c1->getArg(X1936_iters_arg, false);
long x1936_iters_per_parent = x1936_iters / std::max((long)1,x1937_iters);
long x1936_avg = x1936_cycles / std::max((long)1,x1936_iters);
std::cout << "            x1936 - " << x1936_avg << " (" << x1936_cycles << " / " << x1936_iters << ") ";
std::cout << "[" << x1936_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1936 - " << x1936_avg << " (" << x1936_cycles << " / " << x1936_iters << ") ";
instrumentation << "[" << x1936_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1966, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1936), current node x1966 is at depth 5
long x1966_cycles = c1->getArg(X1966_cycles_arg, false);
long x1966_iters = c1->getArg(X1966_iters_arg, false);
long x1966_iters_per_parent = x1966_iters / std::max((long)1,x2082_iters);
long x1966_avg = x1966_cycles / std::max((long)1,x1966_iters);
std::cout << "          x1966 - " << x1966_avg << " (" << x1966_cycles << " / " << x1966_iters << ") ";
std::cout << "[" << x1966_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1966 - " << x1966_avg << " (" << x1966_cycles << " / " << x1966_iters << ") ";
instrumentation << "[" << x1966_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1966, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1952), current node x1952 is at depth 6
long x1952_cycles = c1->getArg(X1952_cycles_arg, false);
long x1952_iters = c1->getArg(X1952_iters_arg, false);
long x1952_iters_per_parent = x1952_iters / std::max((long)1,x1966_iters);
long x1952_avg = x1952_cycles / std::max((long)1,x1952_iters);
std::cout << "            x1952 - " << x1952_avg << " (" << x1952_cycles << " / " << x1952_iters << ") ";
std::cout << "[" << x1952_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1952 - " << x1952_avg << " (" << x1952_cycles << " / " << x1952_iters << ") ";
instrumentation << "[" << x1952_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1966, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1965), current node x1965 is at depth 6
long x1965_cycles = c1->getArg(X1965_cycles_arg, false);
long x1965_iters = c1->getArg(X1965_iters_arg, false);
long x1965_iters_per_parent = x1965_iters / std::max((long)1,x1966_iters);
long x1965_avg = x1965_cycles / std::max((long)1,x1965_iters);
std::cout << "            x1965 - " << x1965_avg << " (" << x1965_cycles << " / " << x1965_iters << ") ";
std::cout << "[" << x1965_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1965 - " << x1965_avg << " (" << x1965_cycles << " / " << x1965_iters << ") ";
instrumentation << "[" << x1965_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1991, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1965), current node x1991 is at depth 5
long x1991_cycles = c1->getArg(X1991_cycles_arg, false);
long x1991_iters = c1->getArg(X1991_iters_arg, false);
long x1991_iters_per_parent = x1991_iters / std::max((long)1,x2082_iters);
long x1991_avg = x1991_cycles / std::max((long)1,x1991_iters);
std::cout << "          x1991 - " << x1991_avg << " (" << x1991_cycles << " / " << x1991_iters << ") ";
std::cout << "[" << x1991_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x1991 - " << x1991_avg << " (" << x1991_cycles << " / " << x1991_iters << ") ";
instrumentation << "[" << x1991_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1991, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1981), current node x1981 is at depth 6
long x1981_cycles = c1->getArg(X1981_cycles_arg, false);
long x1981_iters = c1->getArg(X1981_iters_arg, false);
long x1981_iters_per_parent = x1981_iters / std::max((long)1,x1991_iters);
long x1981_avg = x1981_cycles / std::max((long)1,x1981_iters);
std::cout << "            x1981 - " << x1981_avg << " (" << x1981_cycles << " / " << x1981_iters << ") ";
std::cout << "[" << x1981_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1981 - " << x1981_avg << " (" << x1981_cycles << " / " << x1981_iters << ") ";
instrumentation << "[" << x1981_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x1991, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1990), current node x1990 is at depth 6
long x1990_cycles = c1->getArg(X1990_cycles_arg, false);
long x1990_iters = c1->getArg(X1990_iters_arg, false);
long x1990_iters_per_parent = x1990_iters / std::max((long)1,x1991_iters);
long x1990_avg = x1990_cycles / std::max((long)1,x1990_iters);
std::cout << "            x1990 - " << x1990_avg << " (" << x1990_cycles << " / " << x1990_iters << ") ";
std::cout << "[" << x1990_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x1990 - " << x1990_avg << " (" << x1990_cycles << " / " << x1990_iters << ") ";
instrumentation << "[" << x1990_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2009, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x1990), current node x2009 is at depth 5
long x2009_cycles = c1->getArg(X2009_cycles_arg, false);
long x2009_iters = c1->getArg(X2009_iters_arg, false);
long x2009_iters_per_parent = x2009_iters / std::max((long)1,x2082_iters);
long x2009_avg = x2009_cycles / std::max((long)1,x2009_iters);
std::cout << "          x2009 - " << x2009_avg << " (" << x2009_cycles << " / " << x2009_iters << ") ";
std::cout << "[" << x2009_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2009 - " << x2009_avg << " (" << x2009_cycles << " / " << x2009_iters << ") ";
instrumentation << "[" << x2009_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2009, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2007), current node x2007 is at depth 6
long x2007_cycles = c1->getArg(X2007_cycles_arg, false);
long x2007_iters = c1->getArg(X2007_iters_arg, false);
long x2007_iters_per_parent = x2007_iters / std::max((long)1,x2009_iters);
long x2007_avg = x2007_cycles / std::max((long)1,x2007_iters);
std::cout << "            x2007 - " << x2007_avg << " (" << x2007_cycles << " / " << x2007_iters << ") ";
std::cout << "[" << x2007_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2007 - " << x2007_avg << " (" << x2007_cycles << " / " << x2007_iters << ") ";
instrumentation << "[" << x2007_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2009, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2008), current node x2008 is at depth 6
long x2008_cycles = c1->getArg(X2008_cycles_arg, false);
long x2008_iters = c1->getArg(X2008_iters_arg, false);
long x2008_iters_per_parent = x2008_iters / std::max((long)1,x2009_iters);
long x2008_avg = x2008_cycles / std::max((long)1,x2008_iters);
std::cout << "            x2008 - " << x2008_avg << " (" << x2008_cycles << " / " << x2008_iters << ") ";
std::cout << "[" << x2008_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2008 - " << x2008_avg << " (" << x2008_cycles << " / " << x2008_iters << ") ";
instrumentation << "[" << x2008_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2023, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2008), current node x2023 is at depth 5
long x2023_cycles = c1->getArg(X2023_cycles_arg, false);
long x2023_iters = c1->getArg(X2023_iters_arg, false);
long x2023_iters_per_parent = x2023_iters / std::max((long)1,x2082_iters);
long x2023_avg = x2023_cycles / std::max((long)1,x2023_iters);
std::cout << "          x2023 - " << x2023_avg << " (" << x2023_cycles << " / " << x2023_iters << ") ";
std::cout << "[" << x2023_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2023 - " << x2023_avg << " (" << x2023_cycles << " / " << x2023_iters << ") ";
instrumentation << "[" << x2023_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2023, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2021), current node x2021 is at depth 6
long x2021_cycles = c1->getArg(X2021_cycles_arg, false);
long x2021_iters = c1->getArg(X2021_iters_arg, false);
long x2021_iters_per_parent = x2021_iters / std::max((long)1,x2023_iters);
long x2021_avg = x2021_cycles / std::max((long)1,x2021_iters);
std::cout << "            x2021 - " << x2021_avg << " (" << x2021_cycles << " / " << x2021_iters << ") ";
std::cout << "[" << x2021_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2021 - " << x2021_avg << " (" << x2021_cycles << " / " << x2021_iters << ") ";
instrumentation << "[" << x2021_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2023, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2022), current node x2022 is at depth 6
long x2022_cycles = c1->getArg(X2022_cycles_arg, false);
long x2022_iters = c1->getArg(X2022_iters_arg, false);
long x2022_iters_per_parent = x2022_iters / std::max((long)1,x2023_iters);
long x2022_avg = x2022_cycles / std::max((long)1,x2022_iters);
std::cout << "            x2022 - " << x2022_avg << " (" << x2022_cycles << " / " << x2022_iters << ") ";
std::cout << "[" << x2022_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2022 - " << x2022_avg << " (" << x2022_cycles << " / " << x2022_iters << ") ";
instrumentation << "[" << x2022_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2028, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2022), current node x2028 is at depth 5
long x2028_cycles = c1->getArg(X2028_cycles_arg, false);
long x2028_iters = c1->getArg(X2028_iters_arg, false);
long x2028_iters_per_parent = x2028_iters / std::max((long)1,x2082_iters);
long x2028_avg = x2028_cycles / std::max((long)1,x2028_iters);
std::cout << "          x2028 - " << x2028_avg << " (" << x2028_cycles << " / " << x2028_iters << ") ";
std::cout << "[" << x2028_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2028 - " << x2028_avg << " (" << x2028_cycles << " / " << x2028_iters << ") ";
instrumentation << "[" << x2028_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2028, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2025), current node x2025 is at depth 6
long x2025_cycles = c1->getArg(X2025_cycles_arg, false);
long x2025_iters = c1->getArg(X2025_iters_arg, false);
long x2025_iters_per_parent = x2025_iters / std::max((long)1,x2028_iters);
long x2025_avg = x2025_cycles / std::max((long)1,x2025_iters);
std::cout << "            x2025 - " << x2025_avg << " (" << x2025_cycles << " / " << x2025_iters << ") ";
std::cout << "[" << x2025_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2025 - " << x2025_avg << " (" << x2025_cycles << " / " << x2025_iters << ") ";
instrumentation << "[" << x2025_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2028, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2027), current node x2027 is at depth 6
long x2027_cycles = c1->getArg(X2027_cycles_arg, false);
long x2027_iters = c1->getArg(X2027_iters_arg, false);
long x2027_iters_per_parent = x2027_iters / std::max((long)1,x2028_iters);
long x2027_avg = x2027_cycles / std::max((long)1,x2027_iters);
std::cout << "            x2027 - " << x2027_avg << " (" << x2027_cycles << " / " << x2027_iters << ") ";
std::cout << "[" << x2027_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2027 - " << x2027_avg << " (" << x2027_cycles << " / " << x2027_iters << ") ";
instrumentation << "[" << x2027_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2061, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2027), current node x2061 is at depth 5
long x2061_cycles = c1->getArg(X2061_cycles_arg, false);
long x2061_iters = c1->getArg(X2061_iters_arg, false);
long x2061_iters_per_parent = x2061_iters / std::max((long)1,x2082_iters);
long x2061_avg = x2061_cycles / std::max((long)1,x2061_iters);
std::cout << "          x2061 - " << x2061_avg << " (" << x2061_cycles << " / " << x2061_iters << ") ";
std::cout << "[" << x2061_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2061 - " << x2061_avg << " (" << x2061_cycles << " / " << x2061_iters << ") ";
instrumentation << "[" << x2061_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2061, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2046), current node x2046 is at depth 6
long x2046_cycles = c1->getArg(X2046_cycles_arg, false);
long x2046_iters = c1->getArg(X2046_iters_arg, false);
long x2046_iters_per_parent = x2046_iters / std::max((long)1,x2061_iters);
long x2046_avg = x2046_cycles / std::max((long)1,x2046_iters);
std::cout << "            x2046 - " << x2046_avg << " (" << x2046_cycles << " / " << x2046_iters << ") ";
std::cout << "[" << x2046_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2046 - " << x2046_avg << " (" << x2046_cycles << " / " << x2046_iters << ") ";
instrumentation << "[" << x2046_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2061, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2060), current node x2060 is at depth 6
long x2060_cycles = c1->getArg(X2060_cycles_arg, false);
long x2060_iters = c1->getArg(X2060_iters_arg, false);
long x2060_iters_per_parent = x2060_iters / std::max((long)1,x2061_iters);
long x2060_avg = x2060_cycles / std::max((long)1,x2060_iters);
std::cout << "            x2060 - " << x2060_avg << " (" << x2060_cycles << " / " << x2060_iters << ") ";
std::cout << "[" << x2060_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2060 - " << x2060_avg << " (" << x2060_cycles << " / " << x2060_iters << ") ";
instrumentation << "[" << x2060_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2081, 4 -> x2082, 1 -> x444, 3 -> x2707, 6 -> x2060), current node x2081 is at depth 5
long x2081_cycles = c1->getArg(X2081_cycles_arg, false);
long x2081_iters = c1->getArg(X2081_iters_arg, false);
long x2081_iters_per_parent = x2081_iters / std::max((long)1,x2082_iters);
long x2081_avg = x2081_cycles / std::max((long)1,x2081_iters);
std::cout << "          x2081 - " << x2081_avg << " (" << x2081_cycles << " / " << x2081_iters << ") ";
std::cout << "[" << x2081_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2081 - " << x2081_avg << " (" << x2081_cycles << " / " << x2081_iters << ") ";
instrumentation << "[" << x2081_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2081, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2060), current node x2290 is at depth 4
long x2290_cycles = c1->getArg(X2290_cycles_arg, false);
long x2290_iters = c1->getArg(X2290_iters_arg, false);
long x2290_iters_per_parent = x2290_iters / std::max((long)1,x2707_iters);
long x2290_avg = x2290_cycles / std::max((long)1,x2290_iters);
std::cout << "        x2290 - " << x2290_avg << " (" << x2290_cycles << " / " << x2290_iters << ") ";
std::cout << "[" << x2290_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2290 - " << x2290_avg << " (" << x2290_cycles << " / " << x2290_iters << ") ";
instrumentation << "[" << x2290_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2145, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2060), current node x2145 is at depth 5
long x2145_cycles = c1->getArg(X2145_cycles_arg, false);
long x2145_iters = c1->getArg(X2145_iters_arg, false);
long x2145_iters_per_parent = x2145_iters / std::max((long)1,x2290_iters);
long x2145_avg = x2145_cycles / std::max((long)1,x2145_iters);
std::cout << "          x2145 - " << x2145_avg << " (" << x2145_cycles << " / " << x2145_iters << ") ";
std::cout << "[" << x2145_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2145 - " << x2145_avg << " (" << x2145_cycles << " / " << x2145_iters << ") ";
instrumentation << "[" << x2145_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2145, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2123), current node x2123 is at depth 6
long x2123_cycles = c1->getArg(X2123_cycles_arg, false);
long x2123_iters = c1->getArg(X2123_iters_arg, false);
long x2123_iters_per_parent = x2123_iters / std::max((long)1,x2145_iters);
long x2123_avg = x2123_cycles / std::max((long)1,x2123_iters);
std::cout << "            x2123 - " << x2123_avg << " (" << x2123_cycles << " / " << x2123_iters << ") ";
std::cout << "[" << x2123_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2123 - " << x2123_avg << " (" << x2123_cycles << " / " << x2123_iters << ") ";
instrumentation << "[" << x2123_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2145, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2144), current node x2144 is at depth 6
long x2144_cycles = c1->getArg(X2144_cycles_arg, false);
long x2144_iters = c1->getArg(X2144_iters_arg, false);
long x2144_iters_per_parent = x2144_iters / std::max((long)1,x2145_iters);
long x2144_avg = x2144_cycles / std::max((long)1,x2144_iters);
std::cout << "            x2144 - " << x2144_avg << " (" << x2144_cycles << " / " << x2144_iters << ") ";
std::cout << "[" << x2144_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2144 - " << x2144_avg << " (" << x2144_cycles << " / " << x2144_iters << ") ";
instrumentation << "[" << x2144_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2174, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2144), current node x2174 is at depth 5
long x2174_cycles = c1->getArg(X2174_cycles_arg, false);
long x2174_iters = c1->getArg(X2174_iters_arg, false);
long x2174_iters_per_parent = x2174_iters / std::max((long)1,x2290_iters);
long x2174_avg = x2174_cycles / std::max((long)1,x2174_iters);
std::cout << "          x2174 - " << x2174_avg << " (" << x2174_cycles << " / " << x2174_iters << ") ";
std::cout << "[" << x2174_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2174 - " << x2174_avg << " (" << x2174_cycles << " / " << x2174_iters << ") ";
instrumentation << "[" << x2174_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2174, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2160), current node x2160 is at depth 6
long x2160_cycles = c1->getArg(X2160_cycles_arg, false);
long x2160_iters = c1->getArg(X2160_iters_arg, false);
long x2160_iters_per_parent = x2160_iters / std::max((long)1,x2174_iters);
long x2160_avg = x2160_cycles / std::max((long)1,x2160_iters);
std::cout << "            x2160 - " << x2160_avg << " (" << x2160_cycles << " / " << x2160_iters << ") ";
std::cout << "[" << x2160_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2160 - " << x2160_avg << " (" << x2160_cycles << " / " << x2160_iters << ") ";
instrumentation << "[" << x2160_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2174, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2173), current node x2173 is at depth 6
long x2173_cycles = c1->getArg(X2173_cycles_arg, false);
long x2173_iters = c1->getArg(X2173_iters_arg, false);
long x2173_iters_per_parent = x2173_iters / std::max((long)1,x2174_iters);
long x2173_avg = x2173_cycles / std::max((long)1,x2173_iters);
std::cout << "            x2173 - " << x2173_avg << " (" << x2173_cycles << " / " << x2173_iters << ") ";
std::cout << "[" << x2173_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2173 - " << x2173_avg << " (" << x2173_cycles << " / " << x2173_iters << ") ";
instrumentation << "[" << x2173_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2199, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2173), current node x2199 is at depth 5
long x2199_cycles = c1->getArg(X2199_cycles_arg, false);
long x2199_iters = c1->getArg(X2199_iters_arg, false);
long x2199_iters_per_parent = x2199_iters / std::max((long)1,x2290_iters);
long x2199_avg = x2199_cycles / std::max((long)1,x2199_iters);
std::cout << "          x2199 - " << x2199_avg << " (" << x2199_cycles << " / " << x2199_iters << ") ";
std::cout << "[" << x2199_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2199 - " << x2199_avg << " (" << x2199_cycles << " / " << x2199_iters << ") ";
instrumentation << "[" << x2199_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2199, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2189), current node x2189 is at depth 6
long x2189_cycles = c1->getArg(X2189_cycles_arg, false);
long x2189_iters = c1->getArg(X2189_iters_arg, false);
long x2189_iters_per_parent = x2189_iters / std::max((long)1,x2199_iters);
long x2189_avg = x2189_cycles / std::max((long)1,x2189_iters);
std::cout << "            x2189 - " << x2189_avg << " (" << x2189_cycles << " / " << x2189_iters << ") ";
std::cout << "[" << x2189_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2189 - " << x2189_avg << " (" << x2189_cycles << " / " << x2189_iters << ") ";
instrumentation << "[" << x2189_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2199, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2198), current node x2198 is at depth 6
long x2198_cycles = c1->getArg(X2198_cycles_arg, false);
long x2198_iters = c1->getArg(X2198_iters_arg, false);
long x2198_iters_per_parent = x2198_iters / std::max((long)1,x2199_iters);
long x2198_avg = x2198_cycles / std::max((long)1,x2198_iters);
std::cout << "            x2198 - " << x2198_avg << " (" << x2198_cycles << " / " << x2198_iters << ") ";
std::cout << "[" << x2198_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2198 - " << x2198_avg << " (" << x2198_cycles << " / " << x2198_iters << ") ";
instrumentation << "[" << x2198_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2217, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2198), current node x2217 is at depth 5
long x2217_cycles = c1->getArg(X2217_cycles_arg, false);
long x2217_iters = c1->getArg(X2217_iters_arg, false);
long x2217_iters_per_parent = x2217_iters / std::max((long)1,x2290_iters);
long x2217_avg = x2217_cycles / std::max((long)1,x2217_iters);
std::cout << "          x2217 - " << x2217_avg << " (" << x2217_cycles << " / " << x2217_iters << ") ";
std::cout << "[" << x2217_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2217 - " << x2217_avg << " (" << x2217_cycles << " / " << x2217_iters << ") ";
instrumentation << "[" << x2217_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2217, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2215), current node x2215 is at depth 6
long x2215_cycles = c1->getArg(X2215_cycles_arg, false);
long x2215_iters = c1->getArg(X2215_iters_arg, false);
long x2215_iters_per_parent = x2215_iters / std::max((long)1,x2217_iters);
long x2215_avg = x2215_cycles / std::max((long)1,x2215_iters);
std::cout << "            x2215 - " << x2215_avg << " (" << x2215_cycles << " / " << x2215_iters << ") ";
std::cout << "[" << x2215_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2215 - " << x2215_avg << " (" << x2215_cycles << " / " << x2215_iters << ") ";
instrumentation << "[" << x2215_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2217, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2216), current node x2216 is at depth 6
long x2216_cycles = c1->getArg(X2216_cycles_arg, false);
long x2216_iters = c1->getArg(X2216_iters_arg, false);
long x2216_iters_per_parent = x2216_iters / std::max((long)1,x2217_iters);
long x2216_avg = x2216_cycles / std::max((long)1,x2216_iters);
std::cout << "            x2216 - " << x2216_avg << " (" << x2216_cycles << " / " << x2216_iters << ") ";
std::cout << "[" << x2216_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2216 - " << x2216_avg << " (" << x2216_cycles << " / " << x2216_iters << ") ";
instrumentation << "[" << x2216_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2231, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2216), current node x2231 is at depth 5
long x2231_cycles = c1->getArg(X2231_cycles_arg, false);
long x2231_iters = c1->getArg(X2231_iters_arg, false);
long x2231_iters_per_parent = x2231_iters / std::max((long)1,x2290_iters);
long x2231_avg = x2231_cycles / std::max((long)1,x2231_iters);
std::cout << "          x2231 - " << x2231_avg << " (" << x2231_cycles << " / " << x2231_iters << ") ";
std::cout << "[" << x2231_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2231 - " << x2231_avg << " (" << x2231_cycles << " / " << x2231_iters << ") ";
instrumentation << "[" << x2231_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2231, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2229), current node x2229 is at depth 6
long x2229_cycles = c1->getArg(X2229_cycles_arg, false);
long x2229_iters = c1->getArg(X2229_iters_arg, false);
long x2229_iters_per_parent = x2229_iters / std::max((long)1,x2231_iters);
long x2229_avg = x2229_cycles / std::max((long)1,x2229_iters);
std::cout << "            x2229 - " << x2229_avg << " (" << x2229_cycles << " / " << x2229_iters << ") ";
std::cout << "[" << x2229_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2229 - " << x2229_avg << " (" << x2229_cycles << " / " << x2229_iters << ") ";
instrumentation << "[" << x2229_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2231, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2230), current node x2230 is at depth 6
long x2230_cycles = c1->getArg(X2230_cycles_arg, false);
long x2230_iters = c1->getArg(X2230_iters_arg, false);
long x2230_iters_per_parent = x2230_iters / std::max((long)1,x2231_iters);
long x2230_avg = x2230_cycles / std::max((long)1,x2230_iters);
std::cout << "            x2230 - " << x2230_avg << " (" << x2230_cycles << " / " << x2230_iters << ") ";
std::cout << "[" << x2230_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2230 - " << x2230_avg << " (" << x2230_cycles << " / " << x2230_iters << ") ";
instrumentation << "[" << x2230_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2236, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2230), current node x2236 is at depth 5
long x2236_cycles = c1->getArg(X2236_cycles_arg, false);
long x2236_iters = c1->getArg(X2236_iters_arg, false);
long x2236_iters_per_parent = x2236_iters / std::max((long)1,x2290_iters);
long x2236_avg = x2236_cycles / std::max((long)1,x2236_iters);
std::cout << "          x2236 - " << x2236_avg << " (" << x2236_cycles << " / " << x2236_iters << ") ";
std::cout << "[" << x2236_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2236 - " << x2236_avg << " (" << x2236_cycles << " / " << x2236_iters << ") ";
instrumentation << "[" << x2236_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2236, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2233), current node x2233 is at depth 6
long x2233_cycles = c1->getArg(X2233_cycles_arg, false);
long x2233_iters = c1->getArg(X2233_iters_arg, false);
long x2233_iters_per_parent = x2233_iters / std::max((long)1,x2236_iters);
long x2233_avg = x2233_cycles / std::max((long)1,x2233_iters);
std::cout << "            x2233 - " << x2233_avg << " (" << x2233_cycles << " / " << x2233_iters << ") ";
std::cout << "[" << x2233_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2233 - " << x2233_avg << " (" << x2233_cycles << " / " << x2233_iters << ") ";
instrumentation << "[" << x2233_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2236, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2235), current node x2235 is at depth 6
long x2235_cycles = c1->getArg(X2235_cycles_arg, false);
long x2235_iters = c1->getArg(X2235_iters_arg, false);
long x2235_iters_per_parent = x2235_iters / std::max((long)1,x2236_iters);
long x2235_avg = x2235_cycles / std::max((long)1,x2235_iters);
std::cout << "            x2235 - " << x2235_avg << " (" << x2235_cycles << " / " << x2235_iters << ") ";
std::cout << "[" << x2235_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2235 - " << x2235_avg << " (" << x2235_cycles << " / " << x2235_iters << ") ";
instrumentation << "[" << x2235_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2269, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2235), current node x2269 is at depth 5
long x2269_cycles = c1->getArg(X2269_cycles_arg, false);
long x2269_iters = c1->getArg(X2269_iters_arg, false);
long x2269_iters_per_parent = x2269_iters / std::max((long)1,x2290_iters);
long x2269_avg = x2269_cycles / std::max((long)1,x2269_iters);
std::cout << "          x2269 - " << x2269_avg << " (" << x2269_cycles << " / " << x2269_iters << ") ";
std::cout << "[" << x2269_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2269 - " << x2269_avg << " (" << x2269_cycles << " / " << x2269_iters << ") ";
instrumentation << "[" << x2269_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2269, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2254), current node x2254 is at depth 6
long x2254_cycles = c1->getArg(X2254_cycles_arg, false);
long x2254_iters = c1->getArg(X2254_iters_arg, false);
long x2254_iters_per_parent = x2254_iters / std::max((long)1,x2269_iters);
long x2254_avg = x2254_cycles / std::max((long)1,x2254_iters);
std::cout << "            x2254 - " << x2254_avg << " (" << x2254_cycles << " / " << x2254_iters << ") ";
std::cout << "[" << x2254_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2254 - " << x2254_avg << " (" << x2254_cycles << " / " << x2254_iters << ") ";
instrumentation << "[" << x2254_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2269, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2268), current node x2268 is at depth 6
long x2268_cycles = c1->getArg(X2268_cycles_arg, false);
long x2268_iters = c1->getArg(X2268_iters_arg, false);
long x2268_iters_per_parent = x2268_iters / std::max((long)1,x2269_iters);
long x2268_avg = x2268_cycles / std::max((long)1,x2268_iters);
std::cout << "            x2268 - " << x2268_avg << " (" << x2268_cycles << " / " << x2268_iters << ") ";
std::cout << "[" << x2268_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2268 - " << x2268_avg << " (" << x2268_cycles << " / " << x2268_iters << ") ";
instrumentation << "[" << x2268_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2289, 4 -> x2290, 1 -> x444, 3 -> x2707, 6 -> x2268), current node x2289 is at depth 5
long x2289_cycles = c1->getArg(X2289_cycles_arg, false);
long x2289_iters = c1->getArg(X2289_iters_arg, false);
long x2289_iters_per_parent = x2289_iters / std::max((long)1,x2290_iters);
long x2289_avg = x2289_cycles / std::max((long)1,x2289_iters);
std::cout << "          x2289 - " << x2289_avg << " (" << x2289_cycles << " / " << x2289_iters << ") ";
std::cout << "[" << x2289_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2289 - " << x2289_avg << " (" << x2289_cycles << " / " << x2289_iters << ") ";
instrumentation << "[" << x2289_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2289, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2268), current node x2498 is at depth 4
long x2498_cycles = c1->getArg(X2498_cycles_arg, false);
long x2498_iters = c1->getArg(X2498_iters_arg, false);
long x2498_iters_per_parent = x2498_iters / std::max((long)1,x2707_iters);
long x2498_avg = x2498_cycles / std::max((long)1,x2498_iters);
std::cout << "        x2498 - " << x2498_avg << " (" << x2498_cycles << " / " << x2498_iters << ") ";
std::cout << "[" << x2498_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2498 - " << x2498_avg << " (" << x2498_cycles << " / " << x2498_iters << ") ";
instrumentation << "[" << x2498_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2353, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2268), current node x2353 is at depth 5
long x2353_cycles = c1->getArg(X2353_cycles_arg, false);
long x2353_iters = c1->getArg(X2353_iters_arg, false);
long x2353_iters_per_parent = x2353_iters / std::max((long)1,x2498_iters);
long x2353_avg = x2353_cycles / std::max((long)1,x2353_iters);
std::cout << "          x2353 - " << x2353_avg << " (" << x2353_cycles << " / " << x2353_iters << ") ";
std::cout << "[" << x2353_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2353 - " << x2353_avg << " (" << x2353_cycles << " / " << x2353_iters << ") ";
instrumentation << "[" << x2353_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2353, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2331), current node x2331 is at depth 6
long x2331_cycles = c1->getArg(X2331_cycles_arg, false);
long x2331_iters = c1->getArg(X2331_iters_arg, false);
long x2331_iters_per_parent = x2331_iters / std::max((long)1,x2353_iters);
long x2331_avg = x2331_cycles / std::max((long)1,x2331_iters);
std::cout << "            x2331 - " << x2331_avg << " (" << x2331_cycles << " / " << x2331_iters << ") ";
std::cout << "[" << x2331_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2331 - " << x2331_avg << " (" << x2331_cycles << " / " << x2331_iters << ") ";
instrumentation << "[" << x2331_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2353, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2352), current node x2352 is at depth 6
long x2352_cycles = c1->getArg(X2352_cycles_arg, false);
long x2352_iters = c1->getArg(X2352_iters_arg, false);
long x2352_iters_per_parent = x2352_iters / std::max((long)1,x2353_iters);
long x2352_avg = x2352_cycles / std::max((long)1,x2352_iters);
std::cout << "            x2352 - " << x2352_avg << " (" << x2352_cycles << " / " << x2352_iters << ") ";
std::cout << "[" << x2352_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2352 - " << x2352_avg << " (" << x2352_cycles << " / " << x2352_iters << ") ";
instrumentation << "[" << x2352_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2382, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2352), current node x2382 is at depth 5
long x2382_cycles = c1->getArg(X2382_cycles_arg, false);
long x2382_iters = c1->getArg(X2382_iters_arg, false);
long x2382_iters_per_parent = x2382_iters / std::max((long)1,x2498_iters);
long x2382_avg = x2382_cycles / std::max((long)1,x2382_iters);
std::cout << "          x2382 - " << x2382_avg << " (" << x2382_cycles << " / " << x2382_iters << ") ";
std::cout << "[" << x2382_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2382 - " << x2382_avg << " (" << x2382_cycles << " / " << x2382_iters << ") ";
instrumentation << "[" << x2382_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2382, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2368), current node x2368 is at depth 6
long x2368_cycles = c1->getArg(X2368_cycles_arg, false);
long x2368_iters = c1->getArg(X2368_iters_arg, false);
long x2368_iters_per_parent = x2368_iters / std::max((long)1,x2382_iters);
long x2368_avg = x2368_cycles / std::max((long)1,x2368_iters);
std::cout << "            x2368 - " << x2368_avg << " (" << x2368_cycles << " / " << x2368_iters << ") ";
std::cout << "[" << x2368_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2368 - " << x2368_avg << " (" << x2368_cycles << " / " << x2368_iters << ") ";
instrumentation << "[" << x2368_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2382, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2381), current node x2381 is at depth 6
long x2381_cycles = c1->getArg(X2381_cycles_arg, false);
long x2381_iters = c1->getArg(X2381_iters_arg, false);
long x2381_iters_per_parent = x2381_iters / std::max((long)1,x2382_iters);
long x2381_avg = x2381_cycles / std::max((long)1,x2381_iters);
std::cout << "            x2381 - " << x2381_avg << " (" << x2381_cycles << " / " << x2381_iters << ") ";
std::cout << "[" << x2381_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2381 - " << x2381_avg << " (" << x2381_cycles << " / " << x2381_iters << ") ";
instrumentation << "[" << x2381_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2407, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2381), current node x2407 is at depth 5
long x2407_cycles = c1->getArg(X2407_cycles_arg, false);
long x2407_iters = c1->getArg(X2407_iters_arg, false);
long x2407_iters_per_parent = x2407_iters / std::max((long)1,x2498_iters);
long x2407_avg = x2407_cycles / std::max((long)1,x2407_iters);
std::cout << "          x2407 - " << x2407_avg << " (" << x2407_cycles << " / " << x2407_iters << ") ";
std::cout << "[" << x2407_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2407 - " << x2407_avg << " (" << x2407_cycles << " / " << x2407_iters << ") ";
instrumentation << "[" << x2407_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2407, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2397), current node x2397 is at depth 6
long x2397_cycles = c1->getArg(X2397_cycles_arg, false);
long x2397_iters = c1->getArg(X2397_iters_arg, false);
long x2397_iters_per_parent = x2397_iters / std::max((long)1,x2407_iters);
long x2397_avg = x2397_cycles / std::max((long)1,x2397_iters);
std::cout << "            x2397 - " << x2397_avg << " (" << x2397_cycles << " / " << x2397_iters << ") ";
std::cout << "[" << x2397_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2397 - " << x2397_avg << " (" << x2397_cycles << " / " << x2397_iters << ") ";
instrumentation << "[" << x2397_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2407, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2406), current node x2406 is at depth 6
long x2406_cycles = c1->getArg(X2406_cycles_arg, false);
long x2406_iters = c1->getArg(X2406_iters_arg, false);
long x2406_iters_per_parent = x2406_iters / std::max((long)1,x2407_iters);
long x2406_avg = x2406_cycles / std::max((long)1,x2406_iters);
std::cout << "            x2406 - " << x2406_avg << " (" << x2406_cycles << " / " << x2406_iters << ") ";
std::cout << "[" << x2406_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2406 - " << x2406_avg << " (" << x2406_cycles << " / " << x2406_iters << ") ";
instrumentation << "[" << x2406_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2425, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2406), current node x2425 is at depth 5
long x2425_cycles = c1->getArg(X2425_cycles_arg, false);
long x2425_iters = c1->getArg(X2425_iters_arg, false);
long x2425_iters_per_parent = x2425_iters / std::max((long)1,x2498_iters);
long x2425_avg = x2425_cycles / std::max((long)1,x2425_iters);
std::cout << "          x2425 - " << x2425_avg << " (" << x2425_cycles << " / " << x2425_iters << ") ";
std::cout << "[" << x2425_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2425 - " << x2425_avg << " (" << x2425_cycles << " / " << x2425_iters << ") ";
instrumentation << "[" << x2425_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2425, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2423), current node x2423 is at depth 6
long x2423_cycles = c1->getArg(X2423_cycles_arg, false);
long x2423_iters = c1->getArg(X2423_iters_arg, false);
long x2423_iters_per_parent = x2423_iters / std::max((long)1,x2425_iters);
long x2423_avg = x2423_cycles / std::max((long)1,x2423_iters);
std::cout << "            x2423 - " << x2423_avg << " (" << x2423_cycles << " / " << x2423_iters << ") ";
std::cout << "[" << x2423_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2423 - " << x2423_avg << " (" << x2423_cycles << " / " << x2423_iters << ") ";
instrumentation << "[" << x2423_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2425, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2424), current node x2424 is at depth 6
long x2424_cycles = c1->getArg(X2424_cycles_arg, false);
long x2424_iters = c1->getArg(X2424_iters_arg, false);
long x2424_iters_per_parent = x2424_iters / std::max((long)1,x2425_iters);
long x2424_avg = x2424_cycles / std::max((long)1,x2424_iters);
std::cout << "            x2424 - " << x2424_avg << " (" << x2424_cycles << " / " << x2424_iters << ") ";
std::cout << "[" << x2424_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2424 - " << x2424_avg << " (" << x2424_cycles << " / " << x2424_iters << ") ";
instrumentation << "[" << x2424_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2439, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2424), current node x2439 is at depth 5
long x2439_cycles = c1->getArg(X2439_cycles_arg, false);
long x2439_iters = c1->getArg(X2439_iters_arg, false);
long x2439_iters_per_parent = x2439_iters / std::max((long)1,x2498_iters);
long x2439_avg = x2439_cycles / std::max((long)1,x2439_iters);
std::cout << "          x2439 - " << x2439_avg << " (" << x2439_cycles << " / " << x2439_iters << ") ";
std::cout << "[" << x2439_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2439 - " << x2439_avg << " (" << x2439_cycles << " / " << x2439_iters << ") ";
instrumentation << "[" << x2439_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2439, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2437), current node x2437 is at depth 6
long x2437_cycles = c1->getArg(X2437_cycles_arg, false);
long x2437_iters = c1->getArg(X2437_iters_arg, false);
long x2437_iters_per_parent = x2437_iters / std::max((long)1,x2439_iters);
long x2437_avg = x2437_cycles / std::max((long)1,x2437_iters);
std::cout << "            x2437 - " << x2437_avg << " (" << x2437_cycles << " / " << x2437_iters << ") ";
std::cout << "[" << x2437_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2437 - " << x2437_avg << " (" << x2437_cycles << " / " << x2437_iters << ") ";
instrumentation << "[" << x2437_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2439, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2438), current node x2438 is at depth 6
long x2438_cycles = c1->getArg(X2438_cycles_arg, false);
long x2438_iters = c1->getArg(X2438_iters_arg, false);
long x2438_iters_per_parent = x2438_iters / std::max((long)1,x2439_iters);
long x2438_avg = x2438_cycles / std::max((long)1,x2438_iters);
std::cout << "            x2438 - " << x2438_avg << " (" << x2438_cycles << " / " << x2438_iters << ") ";
std::cout << "[" << x2438_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2438 - " << x2438_avg << " (" << x2438_cycles << " / " << x2438_iters << ") ";
instrumentation << "[" << x2438_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2444, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2438), current node x2444 is at depth 5
long x2444_cycles = c1->getArg(X2444_cycles_arg, false);
long x2444_iters = c1->getArg(X2444_iters_arg, false);
long x2444_iters_per_parent = x2444_iters / std::max((long)1,x2498_iters);
long x2444_avg = x2444_cycles / std::max((long)1,x2444_iters);
std::cout << "          x2444 - " << x2444_avg << " (" << x2444_cycles << " / " << x2444_iters << ") ";
std::cout << "[" << x2444_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2444 - " << x2444_avg << " (" << x2444_cycles << " / " << x2444_iters << ") ";
instrumentation << "[" << x2444_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2444, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2441), current node x2441 is at depth 6
long x2441_cycles = c1->getArg(X2441_cycles_arg, false);
long x2441_iters = c1->getArg(X2441_iters_arg, false);
long x2441_iters_per_parent = x2441_iters / std::max((long)1,x2444_iters);
long x2441_avg = x2441_cycles / std::max((long)1,x2441_iters);
std::cout << "            x2441 - " << x2441_avg << " (" << x2441_cycles << " / " << x2441_iters << ") ";
std::cout << "[" << x2441_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2441 - " << x2441_avg << " (" << x2441_cycles << " / " << x2441_iters << ") ";
instrumentation << "[" << x2441_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2444, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2443), current node x2443 is at depth 6
long x2443_cycles = c1->getArg(X2443_cycles_arg, false);
long x2443_iters = c1->getArg(X2443_iters_arg, false);
long x2443_iters_per_parent = x2443_iters / std::max((long)1,x2444_iters);
long x2443_avg = x2443_cycles / std::max((long)1,x2443_iters);
std::cout << "            x2443 - " << x2443_avg << " (" << x2443_cycles << " / " << x2443_iters << ") ";
std::cout << "[" << x2443_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2443 - " << x2443_avg << " (" << x2443_cycles << " / " << x2443_iters << ") ";
instrumentation << "[" << x2443_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2477, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2443), current node x2477 is at depth 5
long x2477_cycles = c1->getArg(X2477_cycles_arg, false);
long x2477_iters = c1->getArg(X2477_iters_arg, false);
long x2477_iters_per_parent = x2477_iters / std::max((long)1,x2498_iters);
long x2477_avg = x2477_cycles / std::max((long)1,x2477_iters);
std::cout << "          x2477 - " << x2477_avg << " (" << x2477_cycles << " / " << x2477_iters << ") ";
std::cout << "[" << x2477_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2477 - " << x2477_avg << " (" << x2477_cycles << " / " << x2477_iters << ") ";
instrumentation << "[" << x2477_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2477, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2462), current node x2462 is at depth 6
long x2462_cycles = c1->getArg(X2462_cycles_arg, false);
long x2462_iters = c1->getArg(X2462_iters_arg, false);
long x2462_iters_per_parent = x2462_iters / std::max((long)1,x2477_iters);
long x2462_avg = x2462_cycles / std::max((long)1,x2462_iters);
std::cout << "            x2462 - " << x2462_avg << " (" << x2462_cycles << " / " << x2462_iters << ") ";
std::cout << "[" << x2462_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2462 - " << x2462_avg << " (" << x2462_cycles << " / " << x2462_iters << ") ";
instrumentation << "[" << x2462_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2477, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2476), current node x2476 is at depth 6
long x2476_cycles = c1->getArg(X2476_cycles_arg, false);
long x2476_iters = c1->getArg(X2476_iters_arg, false);
long x2476_iters_per_parent = x2476_iters / std::max((long)1,x2477_iters);
long x2476_avg = x2476_cycles / std::max((long)1,x2476_iters);
std::cout << "            x2476 - " << x2476_avg << " (" << x2476_cycles << " / " << x2476_iters << ") ";
std::cout << "[" << x2476_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2476 - " << x2476_avg << " (" << x2476_cycles << " / " << x2476_iters << ") ";
instrumentation << "[" << x2476_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2497, 4 -> x2498, 1 -> x444, 3 -> x2707, 6 -> x2476), current node x2497 is at depth 5
long x2497_cycles = c1->getArg(X2497_cycles_arg, false);
long x2497_iters = c1->getArg(X2497_iters_arg, false);
long x2497_iters_per_parent = x2497_iters / std::max((long)1,x2498_iters);
long x2497_avg = x2497_cycles / std::max((long)1,x2497_iters);
std::cout << "          x2497 - " << x2497_avg << " (" << x2497_cycles << " / " << x2497_iters << ") ";
std::cout << "[" << x2497_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2497 - " << x2497_avg << " (" << x2497_cycles << " / " << x2497_iters << ") ";
instrumentation << "[" << x2497_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2497, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2476), current node x2706 is at depth 4
long x2706_cycles = c1->getArg(X2706_cycles_arg, false);
long x2706_iters = c1->getArg(X2706_iters_arg, false);
long x2706_iters_per_parent = x2706_iters / std::max((long)1,x2707_iters);
long x2706_avg = x2706_cycles / std::max((long)1,x2706_iters);
std::cout << "        x2706 - " << x2706_avg << " (" << x2706_cycles << " / " << x2706_iters << ") ";
std::cout << "[" << x2706_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2706 - " << x2706_avg << " (" << x2706_cycles << " / " << x2706_iters << ") ";
instrumentation << "[" << x2706_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2561, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2476), current node x2561 is at depth 5
long x2561_cycles = c1->getArg(X2561_cycles_arg, false);
long x2561_iters = c1->getArg(X2561_iters_arg, false);
long x2561_iters_per_parent = x2561_iters / std::max((long)1,x2706_iters);
long x2561_avg = x2561_cycles / std::max((long)1,x2561_iters);
std::cout << "          x2561 - " << x2561_avg << " (" << x2561_cycles << " / " << x2561_iters << ") ";
std::cout << "[" << x2561_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2561 - " << x2561_avg << " (" << x2561_cycles << " / " << x2561_iters << ") ";
instrumentation << "[" << x2561_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2561, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2539), current node x2539 is at depth 6
long x2539_cycles = c1->getArg(X2539_cycles_arg, false);
long x2539_iters = c1->getArg(X2539_iters_arg, false);
long x2539_iters_per_parent = x2539_iters / std::max((long)1,x2561_iters);
long x2539_avg = x2539_cycles / std::max((long)1,x2539_iters);
std::cout << "            x2539 - " << x2539_avg << " (" << x2539_cycles << " / " << x2539_iters << ") ";
std::cout << "[" << x2539_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2539 - " << x2539_avg << " (" << x2539_cycles << " / " << x2539_iters << ") ";
instrumentation << "[" << x2539_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2561, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2560), current node x2560 is at depth 6
long x2560_cycles = c1->getArg(X2560_cycles_arg, false);
long x2560_iters = c1->getArg(X2560_iters_arg, false);
long x2560_iters_per_parent = x2560_iters / std::max((long)1,x2561_iters);
long x2560_avg = x2560_cycles / std::max((long)1,x2560_iters);
std::cout << "            x2560 - " << x2560_avg << " (" << x2560_cycles << " / " << x2560_iters << ") ";
std::cout << "[" << x2560_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2560 - " << x2560_avg << " (" << x2560_cycles << " / " << x2560_iters << ") ";
instrumentation << "[" << x2560_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2590, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2560), current node x2590 is at depth 5
long x2590_cycles = c1->getArg(X2590_cycles_arg, false);
long x2590_iters = c1->getArg(X2590_iters_arg, false);
long x2590_iters_per_parent = x2590_iters / std::max((long)1,x2706_iters);
long x2590_avg = x2590_cycles / std::max((long)1,x2590_iters);
std::cout << "          x2590 - " << x2590_avg << " (" << x2590_cycles << " / " << x2590_iters << ") ";
std::cout << "[" << x2590_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2590 - " << x2590_avg << " (" << x2590_cycles << " / " << x2590_iters << ") ";
instrumentation << "[" << x2590_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2590, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2576), current node x2576 is at depth 6
long x2576_cycles = c1->getArg(X2576_cycles_arg, false);
long x2576_iters = c1->getArg(X2576_iters_arg, false);
long x2576_iters_per_parent = x2576_iters / std::max((long)1,x2590_iters);
long x2576_avg = x2576_cycles / std::max((long)1,x2576_iters);
std::cout << "            x2576 - " << x2576_avg << " (" << x2576_cycles << " / " << x2576_iters << ") ";
std::cout << "[" << x2576_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2576 - " << x2576_avg << " (" << x2576_cycles << " / " << x2576_iters << ") ";
instrumentation << "[" << x2576_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2590, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2589), current node x2589 is at depth 6
long x2589_cycles = c1->getArg(X2589_cycles_arg, false);
long x2589_iters = c1->getArg(X2589_iters_arg, false);
long x2589_iters_per_parent = x2589_iters / std::max((long)1,x2590_iters);
long x2589_avg = x2589_cycles / std::max((long)1,x2589_iters);
std::cout << "            x2589 - " << x2589_avg << " (" << x2589_cycles << " / " << x2589_iters << ") ";
std::cout << "[" << x2589_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2589 - " << x2589_avg << " (" << x2589_cycles << " / " << x2589_iters << ") ";
instrumentation << "[" << x2589_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2615, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2589), current node x2615 is at depth 5
long x2615_cycles = c1->getArg(X2615_cycles_arg, false);
long x2615_iters = c1->getArg(X2615_iters_arg, false);
long x2615_iters_per_parent = x2615_iters / std::max((long)1,x2706_iters);
long x2615_avg = x2615_cycles / std::max((long)1,x2615_iters);
std::cout << "          x2615 - " << x2615_avg << " (" << x2615_cycles << " / " << x2615_iters << ") ";
std::cout << "[" << x2615_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2615 - " << x2615_avg << " (" << x2615_cycles << " / " << x2615_iters << ") ";
instrumentation << "[" << x2615_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2615, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2605), current node x2605 is at depth 6
long x2605_cycles = c1->getArg(X2605_cycles_arg, false);
long x2605_iters = c1->getArg(X2605_iters_arg, false);
long x2605_iters_per_parent = x2605_iters / std::max((long)1,x2615_iters);
long x2605_avg = x2605_cycles / std::max((long)1,x2605_iters);
std::cout << "            x2605 - " << x2605_avg << " (" << x2605_cycles << " / " << x2605_iters << ") ";
std::cout << "[" << x2605_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2605 - " << x2605_avg << " (" << x2605_cycles << " / " << x2605_iters << ") ";
instrumentation << "[" << x2605_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2615, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2614), current node x2614 is at depth 6
long x2614_cycles = c1->getArg(X2614_cycles_arg, false);
long x2614_iters = c1->getArg(X2614_iters_arg, false);
long x2614_iters_per_parent = x2614_iters / std::max((long)1,x2615_iters);
long x2614_avg = x2614_cycles / std::max((long)1,x2614_iters);
std::cout << "            x2614 - " << x2614_avg << " (" << x2614_cycles << " / " << x2614_iters << ") ";
std::cout << "[" << x2614_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2614 - " << x2614_avg << " (" << x2614_cycles << " / " << x2614_iters << ") ";
instrumentation << "[" << x2614_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2633, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2614), current node x2633 is at depth 5
long x2633_cycles = c1->getArg(X2633_cycles_arg, false);
long x2633_iters = c1->getArg(X2633_iters_arg, false);
long x2633_iters_per_parent = x2633_iters / std::max((long)1,x2706_iters);
long x2633_avg = x2633_cycles / std::max((long)1,x2633_iters);
std::cout << "          x2633 - " << x2633_avg << " (" << x2633_cycles << " / " << x2633_iters << ") ";
std::cout << "[" << x2633_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2633 - " << x2633_avg << " (" << x2633_cycles << " / " << x2633_iters << ") ";
instrumentation << "[" << x2633_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2633, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2631), current node x2631 is at depth 6
long x2631_cycles = c1->getArg(X2631_cycles_arg, false);
long x2631_iters = c1->getArg(X2631_iters_arg, false);
long x2631_iters_per_parent = x2631_iters / std::max((long)1,x2633_iters);
long x2631_avg = x2631_cycles / std::max((long)1,x2631_iters);
std::cout << "            x2631 - " << x2631_avg << " (" << x2631_cycles << " / " << x2631_iters << ") ";
std::cout << "[" << x2631_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2631 - " << x2631_avg << " (" << x2631_cycles << " / " << x2631_iters << ") ";
instrumentation << "[" << x2631_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2633, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2632), current node x2632 is at depth 6
long x2632_cycles = c1->getArg(X2632_cycles_arg, false);
long x2632_iters = c1->getArg(X2632_iters_arg, false);
long x2632_iters_per_parent = x2632_iters / std::max((long)1,x2633_iters);
long x2632_avg = x2632_cycles / std::max((long)1,x2632_iters);
std::cout << "            x2632 - " << x2632_avg << " (" << x2632_cycles << " / " << x2632_iters << ") ";
std::cout << "[" << x2632_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2632 - " << x2632_avg << " (" << x2632_cycles << " / " << x2632_iters << ") ";
instrumentation << "[" << x2632_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2647, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2632), current node x2647 is at depth 5
long x2647_cycles = c1->getArg(X2647_cycles_arg, false);
long x2647_iters = c1->getArg(X2647_iters_arg, false);
long x2647_iters_per_parent = x2647_iters / std::max((long)1,x2706_iters);
long x2647_avg = x2647_cycles / std::max((long)1,x2647_iters);
std::cout << "          x2647 - " << x2647_avg << " (" << x2647_cycles << " / " << x2647_iters << ") ";
std::cout << "[" << x2647_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2647 - " << x2647_avg << " (" << x2647_cycles << " / " << x2647_iters << ") ";
instrumentation << "[" << x2647_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2647, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2645), current node x2645 is at depth 6
long x2645_cycles = c1->getArg(X2645_cycles_arg, false);
long x2645_iters = c1->getArg(X2645_iters_arg, false);
long x2645_iters_per_parent = x2645_iters / std::max((long)1,x2647_iters);
long x2645_avg = x2645_cycles / std::max((long)1,x2645_iters);
std::cout << "            x2645 - " << x2645_avg << " (" << x2645_cycles << " / " << x2645_iters << ") ";
std::cout << "[" << x2645_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2645 - " << x2645_avg << " (" << x2645_cycles << " / " << x2645_iters << ") ";
instrumentation << "[" << x2645_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2647, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2646), current node x2646 is at depth 6
long x2646_cycles = c1->getArg(X2646_cycles_arg, false);
long x2646_iters = c1->getArg(X2646_iters_arg, false);
long x2646_iters_per_parent = x2646_iters / std::max((long)1,x2647_iters);
long x2646_avg = x2646_cycles / std::max((long)1,x2646_iters);
std::cout << "            x2646 - " << x2646_avg << " (" << x2646_cycles << " / " << x2646_iters << ") ";
std::cout << "[" << x2646_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2646 - " << x2646_avg << " (" << x2646_cycles << " / " << x2646_iters << ") ";
instrumentation << "[" << x2646_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2652, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2646), current node x2652 is at depth 5
long x2652_cycles = c1->getArg(X2652_cycles_arg, false);
long x2652_iters = c1->getArg(X2652_iters_arg, false);
long x2652_iters_per_parent = x2652_iters / std::max((long)1,x2706_iters);
long x2652_avg = x2652_cycles / std::max((long)1,x2652_iters);
std::cout << "          x2652 - " << x2652_avg << " (" << x2652_cycles << " / " << x2652_iters << ") ";
std::cout << "[" << x2652_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2652 - " << x2652_avg << " (" << x2652_cycles << " / " << x2652_iters << ") ";
instrumentation << "[" << x2652_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2652, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2649), current node x2649 is at depth 6
long x2649_cycles = c1->getArg(X2649_cycles_arg, false);
long x2649_iters = c1->getArg(X2649_iters_arg, false);
long x2649_iters_per_parent = x2649_iters / std::max((long)1,x2652_iters);
long x2649_avg = x2649_cycles / std::max((long)1,x2649_iters);
std::cout << "            x2649 - " << x2649_avg << " (" << x2649_cycles << " / " << x2649_iters << ") ";
std::cout << "[" << x2649_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2649 - " << x2649_avg << " (" << x2649_cycles << " / " << x2649_iters << ") ";
instrumentation << "[" << x2649_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2652, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2651), current node x2651 is at depth 6
long x2651_cycles = c1->getArg(X2651_cycles_arg, false);
long x2651_iters = c1->getArg(X2651_iters_arg, false);
long x2651_iters_per_parent = x2651_iters / std::max((long)1,x2652_iters);
long x2651_avg = x2651_cycles / std::max((long)1,x2651_iters);
std::cout << "            x2651 - " << x2651_avg << " (" << x2651_cycles << " / " << x2651_iters << ") ";
std::cout << "[" << x2651_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2651 - " << x2651_avg << " (" << x2651_cycles << " / " << x2651_iters << ") ";
instrumentation << "[" << x2651_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2685, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2651), current node x2685 is at depth 5
long x2685_cycles = c1->getArg(X2685_cycles_arg, false);
long x2685_iters = c1->getArg(X2685_iters_arg, false);
long x2685_iters_per_parent = x2685_iters / std::max((long)1,x2706_iters);
long x2685_avg = x2685_cycles / std::max((long)1,x2685_iters);
std::cout << "          x2685 - " << x2685_avg << " (" << x2685_cycles << " / " << x2685_iters << ") ";
std::cout << "[" << x2685_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2685 - " << x2685_avg << " (" << x2685_cycles << " / " << x2685_iters << ") ";
instrumentation << "[" << x2685_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2685, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2670), current node x2670 is at depth 6
long x2670_cycles = c1->getArg(X2670_cycles_arg, false);
long x2670_iters = c1->getArg(X2670_iters_arg, false);
long x2670_iters_per_parent = x2670_iters / std::max((long)1,x2685_iters);
long x2670_avg = x2670_cycles / std::max((long)1,x2670_iters);
std::cout << "            x2670 - " << x2670_avg << " (" << x2670_cycles << " / " << x2670_iters << ") ";
std::cout << "[" << x2670_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2670 - " << x2670_avg << " (" << x2670_cycles << " / " << x2670_iters << ") ";
instrumentation << "[" << x2670_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2685, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2684), current node x2684 is at depth 6
long x2684_cycles = c1->getArg(X2684_cycles_arg, false);
long x2684_iters = c1->getArg(X2684_iters_arg, false);
long x2684_iters_per_parent = x2684_iters / std::max((long)1,x2685_iters);
long x2684_avg = x2684_cycles / std::max((long)1,x2684_iters);
std::cout << "            x2684 - " << x2684_avg << " (" << x2684_cycles << " / " << x2684_iters << ") ";
std::cout << "[" << x2684_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "            x2684 - " << x2684_avg << " (" << x2684_cycles << " / " << x2684_iters << ") ";
instrumentation << "[" << x2684_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2706, 1 -> x444, 3 -> x2707, 6 -> x2684), current node x2705 is at depth 5
long x2705_cycles = c1->getArg(X2705_cycles_arg, false);
long x2705_iters = c1->getArg(X2705_iters_arg, false);
long x2705_iters_per_parent = x2705_iters / std::max((long)1,x2706_iters);
long x2705_avg = x2705_cycles / std::max((long)1,x2705_iters);
std::cout << "          x2705 - " << x2705_avg << " (" << x2705_cycles << " / " << x2705_iters << ") ";
std::cout << "[" << x2705_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2705 - " << x2705_avg << " (" << x2705_cycles << " / " << x2705_iters << ") ";
instrumentation << "[" << x2705_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2706, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2858 is at depth 3
long x2858_cycles = c1->getArg(X2858_cycles_arg, false);
long x2858_iters = c1->getArg(X2858_iters_arg, false);
long x2858_iters_per_parent = x2858_iters / std::max((long)1,x2859_iters);
long x2858_avg = x2858_cycles / std::max((long)1,x2858_iters);
std::cout << "      x2858 - " << x2858_avg << " (" << x2858_cycles << " / " << x2858_iters << ") ";
std::cout << "[" << x2858_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "      x2858 - " << x2858_avg << " (" << x2858_cycles << " / " << x2858_iters << ") ";
instrumentation << "[" << x2858_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2740, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2740 is at depth 4
long x2740_cycles = c1->getArg(X2740_cycles_arg, false);
long x2740_iters = c1->getArg(X2740_iters_arg, false);
long x2740_iters_per_parent = x2740_iters / std::max((long)1,x2858_iters);
long x2740_avg = x2740_cycles / std::max((long)1,x2740_iters);
std::cout << "        x2740 - " << x2740_avg << " (" << x2740_cycles << " / " << x2740_iters << ") ";
std::cout << "[" << x2740_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2740 - " << x2740_avg << " (" << x2740_cycles << " / " << x2740_iters << ") ";
instrumentation << "[" << x2740_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2753, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2753 is at depth 4
long x2753_cycles = c1->getArg(X2753_cycles_arg, false);
long x2753_iters = c1->getArg(X2753_iters_arg, false);
long x2753_iters_per_parent = x2753_iters / std::max((long)1,x2858_iters);
long x2753_avg = x2753_cycles / std::max((long)1,x2753_iters);
std::cout << "        x2753 - " << x2753_avg << " (" << x2753_cycles << " / " << x2753_iters << ") ";
std::cout << "[" << x2753_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2753 - " << x2753_avg << " (" << x2753_cycles << " / " << x2753_iters << ") ";
instrumentation << "[" << x2753_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2766, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2766 is at depth 4
long x2766_cycles = c1->getArg(X2766_cycles_arg, false);
long x2766_iters = c1->getArg(X2766_iters_arg, false);
long x2766_iters_per_parent = x2766_iters / std::max((long)1,x2858_iters);
long x2766_avg = x2766_cycles / std::max((long)1,x2766_iters);
std::cout << "        x2766 - " << x2766_avg << " (" << x2766_cycles << " / " << x2766_iters << ") ";
std::cout << "[" << x2766_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2766 - " << x2766_avg << " (" << x2766_cycles << " / " << x2766_iters << ") ";
instrumentation << "[" << x2766_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2779, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2779 is at depth 4
long x2779_cycles = c1->getArg(X2779_cycles_arg, false);
long x2779_iters = c1->getArg(X2779_iters_arg, false);
long x2779_iters_per_parent = x2779_iters / std::max((long)1,x2858_iters);
long x2779_avg = x2779_cycles / std::max((long)1,x2779_iters);
std::cout << "        x2779 - " << x2779_avg << " (" << x2779_cycles << " / " << x2779_iters << ") ";
std::cout << "[" << x2779_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2779 - " << x2779_avg << " (" << x2779_cycles << " / " << x2779_iters << ") ";
instrumentation << "[" << x2779_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2792, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2792 is at depth 4
long x2792_cycles = c1->getArg(X2792_cycles_arg, false);
long x2792_iters = c1->getArg(X2792_iters_arg, false);
long x2792_iters_per_parent = x2792_iters / std::max((long)1,x2858_iters);
long x2792_avg = x2792_cycles / std::max((long)1,x2792_iters);
std::cout << "        x2792 - " << x2792_avg << " (" << x2792_cycles << " / " << x2792_iters << ") ";
std::cout << "[" << x2792_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2792 - " << x2792_avg << " (" << x2792_cycles << " / " << x2792_iters << ") ";
instrumentation << "[" << x2792_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2805, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2805 is at depth 4
long x2805_cycles = c1->getArg(X2805_cycles_arg, false);
long x2805_iters = c1->getArg(X2805_iters_arg, false);
long x2805_iters_per_parent = x2805_iters / std::max((long)1,x2858_iters);
long x2805_avg = x2805_cycles / std::max((long)1,x2805_iters);
std::cout << "        x2805 - " << x2805_avg << " (" << x2805_cycles << " / " << x2805_iters << ") ";
std::cout << "[" << x2805_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2805 - " << x2805_avg << " (" << x2805_cycles << " / " << x2805_iters << ") ";
instrumentation << "[" << x2805_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2818, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2818 is at depth 4
long x2818_cycles = c1->getArg(X2818_cycles_arg, false);
long x2818_iters = c1->getArg(X2818_iters_arg, false);
long x2818_iters_per_parent = x2818_iters / std::max((long)1,x2858_iters);
long x2818_avg = x2818_cycles / std::max((long)1,x2818_iters);
std::cout << "        x2818 - " << x2818_avg << " (" << x2818_cycles << " / " << x2818_iters << ") ";
std::cout << "[" << x2818_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2818 - " << x2818_avg << " (" << x2818_cycles << " / " << x2818_iters << ") ";
instrumentation << "[" << x2818_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2831, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2831 is at depth 4
long x2831_cycles = c1->getArg(X2831_cycles_arg, false);
long x2831_iters = c1->getArg(X2831_iters_arg, false);
long x2831_iters_per_parent = x2831_iters / std::max((long)1,x2858_iters);
long x2831_avg = x2831_cycles / std::max((long)1,x2831_iters);
std::cout << "        x2831 - " << x2831_avg << " (" << x2831_cycles << " / " << x2831_iters << ") ";
std::cout << "[" << x2831_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2831 - " << x2831_avg << " (" << x2831_cycles << " / " << x2831_iters << ") ";
instrumentation << "[" << x2831_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2844, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2844 is at depth 4
long x2844_cycles = c1->getArg(X2844_cycles_arg, false);
long x2844_iters = c1->getArg(X2844_iters_arg, false);
long x2844_iters_per_parent = x2844_iters / std::max((long)1,x2858_iters);
long x2844_avg = x2844_cycles / std::max((long)1,x2844_iters);
std::cout << "        x2844 - " << x2844_avg << " (" << x2844_cycles << " / " << x2844_iters << ") ";
std::cout << "[" << x2844_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2844 - " << x2844_avg << " (" << x2844_cycles << " / " << x2844_iters << ") ";
instrumentation << "[" << x2844_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2859, 5 -> x2705, 4 -> x2857, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2857 is at depth 4
long x2857_cycles = c1->getArg(X2857_cycles_arg, false);
long x2857_iters = c1->getArg(X2857_iters_arg, false);
long x2857_iters_per_parent = x2857_iters / std::max((long)1,x2858_iters);
long x2857_avg = x2857_cycles / std::max((long)1,x2857_iters);
std::cout << "        x2857 - " << x2857_avg << " (" << x2857_cycles << " / " << x2857_iters << ") ";
std::cout << "[" << x2857_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2857 - " << x2857_avg << " (" << x2857_cycles << " / " << x2857_iters << ") ";
instrumentation << "[" << x2857_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2916, 5 -> x2705, 4 -> x2857, 1 -> x444, 3 -> x2858, 6 -> x2684), current node x2916 is at depth 2
long x2916_cycles = c1->getArg(X2916_cycles_arg, false);
long x2916_iters = c1->getArg(X2916_iters_arg, false);
long x2916_iters_per_parent = x2916_iters / std::max((long)1,x444_iters);
long x2916_avg = x2916_cycles / std::max((long)1,x2916_iters);
std::cout << "    x2916 - " << x2916_avg << " (" << x2916_cycles << " / " << x2916_iters << ") ";
std::cout << "[" << x2916_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "    x2916 - " << x2916_avg << " (" << x2916_cycles << " / " << x2916_iters << ") ";
instrumentation << "[" << x2916_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2916, 5 -> x2705, 4 -> x2857, 1 -> x444, 3 -> x2915, 6 -> x2684), current node x2915 is at depth 3
long x2915_cycles = c1->getArg(X2915_cycles_arg, false);
long x2915_iters = c1->getArg(X2915_iters_arg, false);
long x2915_iters_per_parent = x2915_iters / std::max((long)1,x2916_iters);
long x2915_avg = x2915_cycles / std::max((long)1,x2915_iters);
std::cout << "      x2915 - " << x2915_avg << " (" << x2915_cycles << " / " << x2915_iters << ") ";
std::cout << "[" << x2915_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "      x2915 - " << x2915_avg << " (" << x2915_cycles << " / " << x2915_iters << ") ";
instrumentation << "[" << x2915_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2916, 5 -> x2705, 4 -> x2910, 1 -> x444, 3 -> x2915, 6 -> x2684), current node x2910 is at depth 4
long x2910_cycles = c1->getArg(X2910_cycles_arg, false);
long x2910_iters = c1->getArg(X2910_iters_arg, false);
long x2910_iters_per_parent = x2910_iters / std::max((long)1,x2915_iters);
long x2910_avg = x2910_cycles / std::max((long)1,x2910_iters);
std::cout << "        x2910 - " << x2910_avg << " (" << x2910_cycles << " / " << x2910_iters << ") ";
std::cout << "[" << x2910_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2910 - " << x2910_avg << " (" << x2910_cycles << " / " << x2910_iters << ") ";
instrumentation << "[" << x2910_iters_per_parent << " iters/parent execution]";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2916, 5 -> x2889, 4 -> x2910, 1 -> x444, 3 -> x2915, 6 -> x2684), current node x2889 is at depth 5
long x2889_cycles = c1->getArg(X2889_cycles_arg, false);
long x2889_iters = c1->getArg(X2889_iters_arg, false);
long x2889_iters_per_parent = x2889_iters / std::max((long)1,x2910_iters);
long x2889_avg = x2889_cycles / std::max((long)1,x2889_iters);
std::cout << "          x2889 - " << x2889_avg << " (" << x2889_cycles << " / " << x2889_iters << ") ";
std::cout << "[" << x2889_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2889 - " << x2889_avg << " (" << x2889_cycles << " / " << x2889_iters << ") ";
instrumentation << "[" << x2889_iters_per_parent << " iters/parent execution]";
}
long x2889_stalled = c1->getArg(X2889_stalled_arg, false);
long x2889_idle = c1->getArg(X2889_idle_arg, false);
std::cout << " <# stalled: " << x2889_stalled << ", #idle: " << x2889_idle << ">";
if (instrumentation.is_open()) {
instrumentation << " <# stalled: " << x2889_stalled << ", # idle: " << x2889_idle << ">";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2916, 5 -> x2909, 4 -> x2910, 1 -> x444, 3 -> x2915, 6 -> x2684), current node x2909 is at depth 5
long x2909_cycles = c1->getArg(X2909_cycles_arg, false);
long x2909_iters = c1->getArg(X2909_iters_arg, false);
long x2909_iters_per_parent = x2909_iters / std::max((long)1,x2910_iters);
long x2909_avg = x2909_cycles / std::max((long)1,x2909_iters);
std::cout << "          x2909 - " << x2909_avg << " (" << x2909_cycles << " / " << x2909_iters << ") ";
std::cout << "[" << x2909_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "          x2909 - " << x2909_avg << " (" << x2909_cycles << " / " << x2909_iters << ") ";
instrumentation << "[" << x2909_iters_per_parent << " iters/parent execution]";
}
long x2909_stalled = c1->getArg(X2909_stalled_arg, false);
long x2909_idle = c1->getArg(X2909_idle_arg, false);
std::cout << " <# stalled: " << x2909_stalled << ", #idle: " << x2909_idle << ">";
if (instrumentation.is_open()) {
instrumentation << " <# stalled: " << x2909_stalled << ", # idle: " << x2909_idle << ">";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
 // immediate parent hashmap now Map(2 -> x2916, 5 -> x2909, 4 -> x2914, 1 -> x444, 3 -> x2915, 6 -> x2684), current node x2914 is at depth 4
long x2914_cycles = c1->getArg(X2914_cycles_arg, false);
long x2914_iters = c1->getArg(X2914_iters_arg, false);
long x2914_iters_per_parent = x2914_iters / std::max((long)1,x2915_iters);
long x2914_avg = x2914_cycles / std::max((long)1,x2914_iters);
std::cout << "        x2914 - " << x2914_avg << " (" << x2914_cycles << " / " << x2914_iters << ") ";
std::cout << "[" << x2914_iters_per_parent << " iters/parent execution]";
if (instrumentation.is_open()) {
instrumentation << "        x2914 - " << x2914_avg << " (" << x2914_cycles << " / " << x2914_iters << ") ";
instrumentation << "[" << x2914_iters_per_parent << " iters/parent execution]";
}
long x2914_stalled = c1->getArg(X2914_stalled_arg, false);
long x2914_idle = c1->getArg(X2914_idle_arg, false);
std::cout << " <# stalled: " << x2914_stalled << ", #idle: " << x2914_idle << ">";
if (instrumentation.is_open()) {
instrumentation << " <# stalled: " << x2914_stalled << ", # idle: " << x2914_idle << ">";
}
std::cout << std::endl;
if (instrumentation.is_open()) {
instrumentation << std::endl;
}
instrumentation.close();
vector<double>* x2917 = new vector<double>(300);
vector<int32_t>* x2918_rawified = new vector<int32_t>((*x2917).size());
c1->memcpy(&(*x2918_rawified)[0], x470, (*x2918_rawified).size() * sizeof(int32_t));
for (int x2917_i = 0; x2917_i < (*x2917).size(); x2917_i++) {
int32_t x2917_tmp = (*x2918_rawified)[x2917_i];
(*x2917)[x2917_i] = (double) x2917_tmp / ((int32_t)1 << 22);
}
std::ofstream x2919_file (string("/home/hhollen/ee109finalHH/output.csv"));
assert(x2919_file.good() && "File Const(/home/hhollen/ee109finalHH/output.csv) does not exist"); 
int32_t x2920 = (*x2917).size();
for (int b95 = 0; b95 < x2920; b95++) {
if (x2919_file.is_open()) {
double x2921 = (*x2917)[b95];
string x2922 = std::to_string(x2921);
x2919_file << x2922;
x2919_file << ',';
}
}
x2919_file.close();
string x2925 = ("\n=================\n" + (string("ProjectTemplate.scala:58:11: Assertion failure") + "\n=================\n"));
if (true) { std::cout << std::flush; ASSERT(true, "%s", x2925.c_str()); }
delete c1;
}

void printHelp() {
fprintf(stderr, "Help for app: MolDSim\n");
fprintf(stderr, "  -- Args:    <No input args>\n");
fprintf(stderr, "    -- Example: bash run.sh \n");
exit(1);
}

int main(int argc, char *argv[]) {
vector<string> *args = new vector<string>(argc-1);
for (int i=1; i<argc; i++) {
(*args)[i-1] = std::string(argv[i]);
if (std::string(argv[i]) == "--help" | std::string(argv[i]) == "-h") {printHelp();}
}
int numThreads = 1;
char *env_threads = getenv("DELITE_NUM_THREADS");
if (env_threads != NULL) { numThreads = atoi(env_threads); } else {
  fprintf(stderr, "[WARNING]: DELITE_NUM_THREADS undefined, defaulting to 1\n");
}
fprintf(stderr, "Executing with %d thread(s)\n", numThreads);
Application(numThreads, args);
return 0;
}
