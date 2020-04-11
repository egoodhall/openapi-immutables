#!/usr/bin/env bash

branch="$(git rev-parse --abbrev-ref HEAD)"
if [[ "$branch" == "master" ]];then
  echo "1.0-SNAPSHOT"
else
  echo "1.0-$branch-SNAPSHOT"
fi
