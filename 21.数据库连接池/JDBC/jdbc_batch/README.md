# 建表语句

CREATE TABLE `tb` (
  `foo` int(11) DEFAULT NULL,
  `bar` int(11) NOT NULL,
  PRIMARY KEY (`bar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

# 使用说明

```
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8
export CLASSPATH="`pwd`/mysql-connector-java-8.0.23.jar:`pwd`"
javac TestBatch.java
java TestBatch
```