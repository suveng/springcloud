chcp 65001

echo 正在生成Mybatis文件....

java -jar -Dfile.encoding=UTF-8 ./lib/mybatis-generator-core-1.3.3.jar -configfile generator.xml  -overwrite 
echo Mybatis文件生成成功!

pause
exit