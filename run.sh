# Write any command you want to run
#sbt -Dtest.CS217=true "; testOnly MolDSim"
source ./exports.sh
sbt -Dtest.ZCU=true "; testOnly MolDSim"
