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
c1->setNumArgOutInstrs(0);
c1->setNumEarlyExits(0);
c1->flushCache(1024);
time_t tstart = time(0);
c1->run();
time_t tend = time(0);
double elapsed = difftime(tend, tstart);
std::cout << "Kernel done, test run time = " << elapsed << " ms" << std::endl;
c1->flushCache(1024);
vector<double>* x725 = new vector<double>(300);
vector<int32_t>* x726_rawified = new vector<int32_t>((*x725).size());
c1->memcpy(&(*x726_rawified)[0], x470, (*x726_rawified).size() * sizeof(int32_t));
for (int x725_i = 0; x725_i < (*x725).size(); x725_i++) {
int32_t x725_tmp = (*x726_rawified)[x725_i];
(*x725)[x725_i] = (double) x725_tmp / ((int32_t)1 << 22);
}
std::ofstream x727_file (string("/home/hhollen/ee109finalHH/output.csv"));
assert(x727_file.good() && "File Const(/home/hhollen/ee109finalHH/output.csv) does not exist"); 
int32_t x728 = (*x725).size();
for (int b95 = 0; b95 < x728; b95++) {
if (x727_file.is_open()) {
double x729 = (*x725)[b95];
string x730 = std::to_string(x729);
x727_file << x730;
x727_file << ',';
}
}
x727_file.close();
string x733 = ("\n=================\n" + (string("ProjectTemplate.scala:58:11: Assertion failure") + "\n=================\n"));
if (true) { std::cout << std::flush; ASSERT(true, "%s", x733.c_str()); }
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
