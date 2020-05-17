import pandas as pd
from Config import Filelocation



xls = pd.ExcelFile(Filelocation)

df = xls.parse(xls.sheet_names[0],header=0,usecols='B')
mylist = df.CompKey.unique().flatten().tolist()

Depts = [x for x in mylist]

