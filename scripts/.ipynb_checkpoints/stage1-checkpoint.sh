#!/bin/bash
gdown -O /home/team23/project/bigdata-final-project-iu-2024/data/airbnb.csv  1-WTfhDxit9wF5pnskS8z4nQo07PiPSYO 

python3 preprocess.py 
python3 build_projectdb.py
export password=$(cat /home/team23/project/bigdata-final-project-iu-2024/secrets/.psql.pass)
hdfs dfs -rm -r /user/team23/project/warehouse/*
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team23_projectdb \
    --username team23 --password $password --compression-codec=snappy --compress --as-avrodatafile \
     --warehouse-dir=project/warehouse --m 1
rm ../output/* 
mv *.java ../output/
mv *.avsc ../output/
