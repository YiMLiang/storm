#!/bin/bash
bin/flume-ng agent -n agent3 -c conf -f conf/agent3.conf -Dflume.root.logger=DEBUG,console > ./agent3.log 2>&1 &
