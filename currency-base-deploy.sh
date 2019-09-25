#!/usr/bin/env bash

cd base

cd currency.log

mvn clean deploy -Dmaven.test.skip=true

cd ../currency.result

mvn clean deploy -Dmaven.test.skip=true

cd ../currency.lock

mvn clean deploy -Dmaven.test.skip=true

cd ../currency.message

mvn clean deploy -Dmaven.test.skip=true
