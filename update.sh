#!/usr/bin/env bash
git pull origin master
git pull origin develop

git checkout master
git merge develop

git checkout develop

git push origin master
git push github master
git push gitlab master

git push origin develop
git push github develop
git push gitlab develop

git push --tags origin
git push --tags github
git push --tags gitlab
