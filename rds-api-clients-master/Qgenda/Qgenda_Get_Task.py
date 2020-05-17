import json
import ast
from collections import OrderedDict
import requests
from PyDates import *
from Token import header
from GenerateSQL import *


x = 0
for i in environments:

    cur = environments[x].cursor()
    TRUNCATE = "TRUNCATE TABLE BCM_SA.QGENDA_TASK"
    cur.execute(TRUNCATE)
    environments[x].commit()
    cur.close
    x += 1


# TASKID COLUMN HAS BSLMC ... VALUES, THAT SHOULD BE IN NAME COLUMN? PHONE NUMBERS IN NAME COLUMN?

payload = {'$select':'Abbrev,BgColor,BillSysId,CallRole,CompKey,EmrId,EndDate,ExtCallSysId,ExtCallPriority,Extension,Name,OverrideSortOrder,PayrollId,PayrollUnits,StartDate,TaskId,TaskKey,TextColor','$orderby':'CompKey,StartDate'}

task = requests.get('https://api.qgenda.com/v2/task', params=payload, headers=header)

json_data = json.loads(task.text, object_pairs_hook=OrderedDict)


itembank = []
for od in json_data:
    itembank.append(od.values())
strbank = str(itembank)
formatbank = strbank.replace('[odict_values([','[(').replace('])]',')]').replace('odict_values([','(').replace('])',')')
finaldata = ast.literal_eval(formatbank)


CompileSQL('BCM_SA.QGENDA_TASK','TEXTCOLOR,TASKKEY,TASKID,STARTDATE,PAYROLLUNITS,PAYROLLID,OVERRIDESORTORDER,NAME,EXTENSION,EXTCALLPRIORITY,EXTCALLSYSID,ENDDATE,EMRID,COMPKEY,CALLROLE,BILLSYSID,BGCOLOR,ABBREV',finaldata)
