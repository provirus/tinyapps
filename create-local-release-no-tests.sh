#!/bin/bash

set -e

# Set environment
export LANG="C.UTF-8"

RUN_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd $RUN_PATH

./step-clean.sh
./step-compile-no-tests.sh
./step-copy-zips.sh

echo ---[ Applications compiled ]---
find apps
