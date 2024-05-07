"""
This module bulids postgres database
It executes the following sql queries:
1. ../sql/create_tables.sql
2. ../sql/import_data.sql
3. ../sql/test_database.sql
"""


import os
from pprint import pprint
import psycopg2 as psql

ENC = "utf-8"


# Read password from secrets file
file = os.path.join("/home/team23/project/bigdata-final-project-iu-2024", "secrets", ".psql.pass")
with open(file, "r", encoding=ENC) as file:
    PASSWORD = file.read().rstrip()

HOST = "hadoop-04.uni.innopolis.ru"

# build connection string
CONN_STRING = f"host={HOST} port=5432 user=team23 dbname=team23_projectdb password={PASSWORD}"
PATH = "/home/team23/project/bigdata-final-project-iu-2024"


# Connect to the remote dbms
with psql.connect(CONN_STRING) as conn:
    # Create a cursor for executing psql commands
    cur = conn.cursor()
    # Read the commands from the file and execute them.
    with open(os.path.join(PATH, "sql", "create_tables.sql"), encoding=ENC) as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    # Read the commands from the file and execute them.
    with open(os.path.join(PATH, "sql", "import_data.sql"), encoding=ENC) as file:
        commands = file.readlines()
        with open(os.path.join(PATH, "data", "airbnb_preprocessed.csv"), "r", encoding=ENC) as dept:
            cur.copy_expert(" ".join(commands), dept)

    # If the sql statements are CRUD then you need to commit the change
    conn.commit()

    pprint(conn)
    cur = conn.cursor()
    # Read the sql commands from the file
    with open(os.path.join(PATH, "sql", "test_database.sql"), encoding=ENC) as file:
        commands = file.readlines()
        for command in commands:
            cur.execute(command)
            # Read all records and print them
            pprint(cur.fetchall())
