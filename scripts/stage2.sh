#!/bin/bash
hdfs dfs -mv project/warehouse/airbnb_houses project/airbnb_houses
hdfs dfs -rm -r project/warehouse/*
hdfs dfs -mv project/airbnb_houses project/warehouse/airbnb_houses 
hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put ../output/*.avsc project/warehouse/avsc
password=$(cat ../secrets/.psql.pass)
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password  -f ../sql/db.hql > ../output/hive_results.txt
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f ../sql/q1.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q1.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f ../sql/q2.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q2.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f ../sql/q3.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q3.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f ../sql/q4.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q4.csv
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f ../sql/q5.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q5.csv

