#!/usr/bin/env bash
git push origin master
git push github master
git push gitlab master

git push --tags origin
git push --tags github
git push --tags gitlab
