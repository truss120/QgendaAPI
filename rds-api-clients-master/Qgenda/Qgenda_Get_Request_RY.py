'''
Taylor Russell
5/31/2018

            Daily script that truncates and loads the QGENDA_REQUESTS table for the last 18 months
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
    TRUNCATE = "TRUNCATE TABLE BCM_SA.QGENDA_REQUEST"
    cur.execute(TRUNCATE)
    environments[x].commit()
    cur.close
    x += 1



s = 0
for r in rollingmonths:
    # FOR EACH YEAR DO

    v_date = daterange(rollingmonths[s])  # YYYYMMDD or '' for yesterday's date

    d=0
    deptdata = []
    for Dept in Depts:
        # FOR EACH DEPT DO

        payload = {'companyKey': Depts[d], 'startDate': v_date[0], 'endDate': v_date[1],
                   '$select': 'CallRole,CompKey,Credit,Date,EndTime,Notes,RequestKey,RequestType,RequestStatus,ResolutionDate,StaffAbbrev,StaffFName,StaffId,StaffKey,StaffLName,StaffPayrollId,StartTime,SubmittedByUser,SubmittedDate,TaskAbbrev,TaskKey,TaskName',
                   '$orderby': 'Date'}

        request = requests.get('https://api.qgenda.com/v2/request', params=payload, headers=header)

        json_data = json.loads(request.text, object_pairs_hook=OrderedDict)
        deptdata.extend(json_data)
        d+=1



    valuebank = []
    for od in deptdata:
        valuebank.append(od.values())
    strbank = str(valuebank)
    formatbank = strbank.replace('[odict_values([','[(').replace('])]',')]').replace('odict_values([','(').replace('])',')')
    finaldata = ast.literal_eval(formatbank)

    CompileSQL('BCM_SA.QGENDA_REQUEST','TASKNAME, TASKKEY, TASKABBREV, SUBMITTEDDATE, SUBMITTEDBYUSER, STARTTIME, STAFFPAYROLLID, STAFFLNAME, STAFFKEY, STAFFID, STAFFFNAME, STAFFABBREV, RESOLUTIONDATE, REQUESTSTATUS, REQUESTTYPE, REQUESTKEY, NOTES, ENDTIME, DATE, CREDIT, COMPKEY, CALLROLE',finaldata)

    s+=1

