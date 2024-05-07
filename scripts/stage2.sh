#!/bin/bash
hdfs dfs -mv project/warehouse/airbnb_houses project/airbnb_houses
hdfs dfs -rm -r project/warehouse/*
hdfs dfs -mv project/airbnb_houses project/warehouse/airbnb_houses 
hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put /home/team23/project/bigdata-final-project-iu-2024/output/*.avsc project/warehouse/avsc
password=$(cat /home/team23/project/bigdata-final-project-iu-2024/secrets/.psql.pass)
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password  -f /home/team23/project/bigdata-final-project-iu-2024/sql/db.hql > /home/team23/project/bigdata-final-project-iu-2024/output/hive_results.txt
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f /home/team23/project/bigdata-final-project-iu-2024/sql/q1.hql --hiveconf hive.resultset.use.unique.column.names=false > /home/team23/project/bigdata-final-project-iu-2024/output/q1.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f /home/team23/project/bigdata-final-project-iu-2024/sql/q2.hql --hiveconf hive.resultset.use.unique.column.names=false > /home/team23/project/bigdata-final-project-iu-2024/output/q2.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f /home/team23/project/bigdata-final-project-iu-2024/sql/q3.hql --hiveconf hive.resultset.use.unique.column.names=false > /home/team23/project/bigdata-final-project-iu-2024/output/q3.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f /home/team23/project/bigdata-final-project-iu-2024/sql/q4.hql --hiveconf hive.resultset.use.unique.column.names=false > /home/team23/project/bigdata-final-project-iu-2024/output/q4.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f /home/team23/project/bigdata-final-project-iu-2024/sql/q5.hql --hiveconf hive.resultset.use.unique.column.names=false > /home/team23/project/bigdata-final-project-iu-2024/output/q5.csv

