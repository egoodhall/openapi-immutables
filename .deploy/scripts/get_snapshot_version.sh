#!/usr/bin/env bash

if [[ "$GITHUB_HEAD_REF" == "" ]];then
  echo "1.0-SNAPSHOT"
else
  echo "1.0-$GITHUB_HEAD_REF-SNAPSHOT"
fi
