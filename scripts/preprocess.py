import pandas as pd

df = pd.read_csv("/home/team23/project/bigdata-final-project-iu-2024/data/airbnb.csv")

def remove_newlines(cell):
    if isinstance(cell, str):
        return cell.replace("\n", "").replace("\r\n", "").replace("\r", "")
    else:
        return cell

for col in df.columns:
    df[col] = df[col].apply(remove_newlines)

df.to_csv("/home/team23/project/bigdata-final-project-iu-2024/data/airbnb_preprocessed.csv", index=False)
