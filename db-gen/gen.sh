#!/bin/sh

echo "正在生成文件"

java -jar -Dfile.encoding=UTF-8 ./lib/mybatis-generator-core-1.3.3.jar -configfile generator.xml  -overwrite

echo "完成"
