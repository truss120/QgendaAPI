'''
Taylor Russell
5/31/2018

        Loads the QGENDA_STAFFMEMBER TABLE


'''


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
    TRUNCATE = "TRUNCATE TABLE BCM_SA.QGENDA_STAFFMEMBER"
    cur.execute(TRUNCATE)
    environments[x].commit()
    cur.close
    x += 1


#HOW TO IDENTIFY INCREMENTALS? NO STARTDATE PARAMETER, USE FILTER?

payload = {'$select':'TextColor,StartDate,StaffKey,StaffId,RegHours,PayrollId,PayPeriodGroupName,Pager,Npi,MobilePhone,LastName,HomePhone,FirstName,ExtCallSysId,EndDate,EmrId,Email,CompKey,BillSysId,BgColor,Abbrev','$orderby':'CompKey,StartDate'}

staff = requests.get('https://api.qgenda.com/v2/staffmember', params=payload, headers=header)

json_data = json.loads(staff.text, object_pairs_hook=OrderedDict)


itembank = []
for od in json_data:
    itembank.append(od.values())
strbank = str(itembank)
formatbank = strbank.replace('[odict_values([','[(').replace('])]',')]').replace('odict_values([','(').replace('])',')')
finaldata = ast.literal_eval(formatbank)


CompileSQL('BCM_SA.QGENDA_STAFFMEMBER','Abbrev,BgColor,BillSysId,CompKey,Email,EmrId,EndDate,ExtCallSysId,FirstName,HomePhone,LastName,MobilePhone,Npi,Pager,PayPeriodGroupName,PayrollId,RegHours,StaffId,StaffKey,StartDate,TextColor',finaldata)
