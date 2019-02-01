#!/bin/bash
bin/flume-ng agent -n agent2 -c conf -f conf/agent2.conf -Dflume.root.logger=DEBUG,console > ./agent2.log 2>&1 &
