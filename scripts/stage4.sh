#!/bin/bash
export password=$(cat /home/team23/project/bigdata-final-project-iu-2024/secrets/.psql.pass)
DIR=/home/team23/project/bigdata-final-project-iu-2024
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f  $DIR/sql/model1_predictions.hql > $DIR/output/hive_results.txt
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f  $DIR/sql/model2_predictions.hql > $DIR/output/hive_results.txt
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team23 -p $password -f  $DIR/sql/evaluation.hql > $DIR/output/hive_results.txt