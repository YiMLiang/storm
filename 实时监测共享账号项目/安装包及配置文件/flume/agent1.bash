#!/bin/bash
bin/flume-ng agent -n agent1 -c conf -f conf/agent1.conf -Dflume.root.logger=DEBUG,console > ./agent1.log 2>&1 &
