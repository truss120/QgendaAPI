import json
import requests
import pyhdb

from MonthRange import *
from Token import header
from HANA import environments
from Qgenda_Depts import Depts


v_date = daterange(20180101)  # YYYYMMDD or '' for yesterday's date


v_depts = str(Depts[0])

#print Depts[0]
#print type(v_depts)



##REQUEST##
payload = {'companyKey': v_depts , 'startDate' : v_date[0] , 'endDate' : v_date[1] ,
           '$select': 'CallRole,CompKey,Credit,Date,EndDate,EndTime,IsCred,IsPublished,IsLocked,IsStruck,Notes,StaffAbbrev,StaffBillSysId,StaffEmail,StaffEmrId,StaffExtCallSysId,StaffFName,StaffId,StaffKey,StaffLName,StaffMobilePhone,StaffNpi,StaffPager,StaffPayrollId,StartDate,StartTime,TaskAbbrev,TaskBillSysId,TaskExtCallSysId,TaskId,TaskKey,TaskName,TaskPayrollId,TaskEmrId,TaskIsPrintEnd,TaskIsPrintStart,TaskShiftKey',
            '$orderby': 'StartDate'}
            
#print payload

schedule = requests.get('https://api.qgenda.com/v2/schedule',params= payload, headers = header)
#print(schedule.url)
#print(schedule.text)


schedule.encoding='ISO-8859-1'
#print(schedule.encoding)


json_data = json.loads(schedule.text)
#print(tuple(json_data[0].values()))
#print json_data



x=0
for i in environments:
    cur = environments[x].cursor()
    n=0
    itemBank = []
    for row in json_data:

        Values = json_data[n].values()
        itemBank.append(tuple(Values))
        n += 1

        #placeholders = ', '.join('?' * len(json_data[n]))
        #print(placeholders)

        sql = "INSERT INTO TRUSSELL.QGENDA_SCHEDULE (CALLROLE,COMPKEY,CREDIT,DATE,ENDDATE,ENDTIME,ISCRED,ISPUBLISHED,ISLOCKED,ISSTRUCK,NOTES,STAFFABBREV,STAFFBILLSYSID,STAFFEMAIL,STAFFEMRID,STAFFEXTCALLSYSID,STAFFFNAME,STAFFID,STAFFKEY,STAFFLNAME,STAFFMOBILEPHONE,STAFFNPI,STAFFPAGER,STAFFPAYROLLID,STARTDATE,STARTTIME,TASKABBREV,TASKBILLSYSID,TASKEXTCALLSYSID,TASKID,TASKKEY,TASKNAME,TASKPAYROLLID,TASKEMRID,TASKISPRINTEND,TASKISPRINTSTART,TASKSHIFTKEY) VALUES (%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s,	%s)"


    print(itemBank)
    #cur.executemany(sql, itemBank)
    cur.close()
    environments[x].commit()
    x += 1









