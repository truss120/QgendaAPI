'''
Taylor Russell
5/31/2018

            Daily script that truncates and loads the QGENDA_SCHDULE table for the last 18 months
'''


import json
import ast
from collections import OrderedDict
import requests
from PyDates import *
from Token import header
from Qgenda_Depts import Depts
from GenerateSQL import *
from HANA import environments



rollingmonths = rollingyear(18)


x = 0
for i in environments:

    cur = environments[x].cursor()
    TRUNCATE = "TRUNCATE TABLE BCM_SA.QGENDA_SCHEDULE"
    cur.execute(TRUNCATE)
    environments[x].commit()
    cur.close
    x += 1



s = 0
for r in rollingmonths:
    # FOR EACH MONTH DO

    v_date = daterange(rollingmonths[s])  # GET THE START & END OF THE MONTH

    d=0
    deptdata = []
    for Dept in Depts:
        # FOR EACH DEPT AT THAT MONTH QUERY QGENDA

        payload = {'companyKey': Depts[d], 'startDate': v_date[0], 'endDate': v_date[1],
               '$select': 'CallRole,CompKey,Credit,Date,EndDate,EndTime,IsCred,IsPublished,IsLocked,IsStruck,Notes,StaffAbbrev,StaffBillSysId,StaffEmail,StaffEmrId,StaffExtCallSysId,StaffFName,StaffId,StaffKey,StaffLName,StaffMobilePhone,StaffNpi,StaffPager,StaffPayrollId,StartDate,StartTime,TaskAbbrev,TaskBillSysId,TaskExtCallSysId,TaskId,TaskKey,TaskName,TaskPayrollId,TaskEmrId,TaskIsPrintEnd,TaskIsPrintStart,TaskShiftKey',
               '$orderby': 'StartDate'}

        schedule = requests.get('https://api.qgenda.com/v2/schedule', params=payload, headers=header)

        json_data = json.loads(schedule.text, object_pairs_hook=OrderedDict)
        deptdata.extend(json_data)
        d+=1



    valuebank = []
    for od in deptdata:
        valuebank.append(od.values())
    strbank = str(valuebank)
    formatbank = strbank.replace('[odict_values([','[(').replace('])]',')]').replace('odict_values([','(').replace('])',')')
    finaldataset = ast.literal_eval(formatbank)

    CompileSQL('BCM_SA.QGENDA_SCHEDULE','TASKSHIFTKEY,TASKISPRINTSTART,TASKISPRINTEND,TASKEMRID,TASKPAYROLLID,TASKNAME,TASKKEY,TASKID,TASKEXTCALLSYSID,TASKBILLSYSID,TASKABBREV,STARTTIME,STARTDATE,STAFFPAYROLLID,STAFFPAGER,STAFFNPI,STAFFMOBILEPHONE,STAFFLNAME,STAFFKEY,STAFFID,STAFFFNAME,STAFFEXTCALLSYSID,STAFFEMRID,STAFFEMAIL,STAFFBILLSYSID,STAFFABBREV,NOTES,ISSTRUCK,ISLOCKED,ISPUBLISHED,ISCRED,ENDTIME,ENDDATE,DATE,CREDIT,COMPKEY,CALLROLE',finaldataset)

    s+=1

