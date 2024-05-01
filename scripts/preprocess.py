"""
This module removes all newlines in the dataset
except those at ends of entries
"""


import pandas as pd

PATH = "/home/team23/project/bigdata-final-project-iu-2024"

df = pd.read_csv(f"{PATH}/data/airbnb.csv")


def remove_newlines(cell):
    """Removes newlines in a cell

    Args:
        cell: Pandas DataFrame cell

    Returns:
        cell: The cell without newlines
    """

    if isinstance(cell, str):
        return cell.replace("\n", "").replace("\r\n", "").replace("\r", "")
    return cell


for col in df.columns:
    df[col] = df[col].apply(remove_newlines)

df.to_csv(f"{PATH}/data/airbnb_preprocessed.csv", index=False)
