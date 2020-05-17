'''
Taylor Russell
5/31/2018

                Daily script that loads yesterdays data to the QGENDA_SCHEDULE table
'''


import json
import ast
from collections import OrderedDict
import requests
from PyDates import *
from Token import header
from Qgenda_Depts import Depts
from GenerateSQL import *

v_date = daterange('')  # YYYYMMDD or '' for yesterday's date




d=0
data = []
for Dept in Depts:

    payload = {'companyKey': Depts[d], 'startDate': v_date[0], 'endDate': v_date[1],
           '$select': 'CallRole,CompKey,Credit,Date,EndDate,EndTime,IsCred,IsPublished,IsLocked,IsStruck,Notes,StaffAbbrev,StaffBillSysId,StaffEmail,StaffEmrId,StaffExtCallSysId,StaffFName,StaffId,StaffKey,StaffLName,StaffMobilePhone,StaffNpi,StaffPager,StaffPayrollId,StartDate,StartTime,TaskAbbrev,TaskBillSysId,TaskExtCallSysId,TaskId,TaskKey,TaskName,TaskPayrollId,TaskEmrId,TaskIsPrintEnd,TaskIsPrintStart,TaskShiftKey',
           '$orderby': 'StartDate'}

    schedule = requests.get('https://api.qgenda.com/v2/schedule', params=payload, headers=header)

    json_data = json.loads(schedule.text, object_pairs_hook=OrderedDict)
    data.extend(json_data)
    d+=1

itembank = []
for od in data:
    itembank.append(od.values())
strbank = str(itembank)
formatbank = strbank.replace('[odict_values([','[(').replace('])]',')]').replace('odict_values([','(').replace('])',')')
finaldata = ast.literal_eval(formatbank)

CompileSQL('BCM_SA.QGENDA_SCHEDULE','TASKSHIFTKEY,TASKISPRINTSTART,TASKISPRINTEND,TASKEMRID,TASKPAYROLLID,TASKNAME,TASKKEY,TASKID,TASKEXTCALLSYSID,TASKBILLSYSID,TASKABBREV,STARTTIME,STARTDATE,STAFFPAYROLLID,STAFFPAGER,STAFFNPI,STAFFMOBILEPHONE,STAFFLNAME,STAFFKEY,STAFFID,STAFFFNAME,STAFFEXTCALLSYSID,STAFFEMRID,STAFFEMAIL,STAFFBILLSYSID,STAFFABBREV,NOTES,ISSTRUCK,ISLOCKED,ISPUBLISHED,ISCRED,ENDTIME,ENDDATE,DATE,CREDIT,COMPKEY,CALLROLE',finaldata)

