'''
Taylor Russell
5/31/2018

            Daily script that loads yesterdays data to the QGENDA_REQUEST table
'''



import json
import ast
from collections import OrderedDict
import requests
from MonthRange import *
from Token import header
from Qgenda_Depts import Depts
from GenerateSQL import *

v_date = daterange('')  # YYYYMMDD or '' for yesterday's date


d=0
data = []
for Dept in Depts:

   payload = {'companyKey': Depts[d] , 'startDate' : v_date[0] , 'endDate' : v_date[1],
              '$select' : 'CallRole,CompKey,Credit,Date,EndTime,Notes,RequestKey,RequestType,RequestStatus,ResolutionDate,StaffAbbrev,StaffFName,StaffId,StaffKey,StaffLName,StaffPayrollId,StartTime,SubmittedByUser,SubmittedDate,TaskAbbrev,TaskKey,TaskName',
              '$orderby': 'Date'}

   request = requests.get('https://api.qgenda.com/v2/request',params= payload, headers = header)

   json_data = json.loads(request.text,object_pairs_hook=OrderedDict)
   data.extend(json_data)
   d+=1

# print(data)

itembank = []
for od in data:
    itembank.append(od.values())
strbank = str(itembank)
formatbank = strbank.replace('[odict_values([','[(').replace('])]',')]').replace('odict_values([','(').replace('])',')')
finaldata = ast.literal_eval(formatbank)



CompileSQL('BCM_SA.QGENDA_REQUEST','TASKNAME, TASKKEY, TASKABBREV, SUBMITTEDDATE, SUBMITTEDBYUSER, STARTTIME, STAFFPAYROLLID, STAFFLNAME, STAFFKEY, STAFFID, STAFFFNAME, STAFFABBREV, RESOLUTIONDATE, REQUESTSTATUS, REQUESTTYPE, REQUESTKEY, NOTES, ENDTIME, DATE, CREDIT, COMPKEY, CALLROLE',finaldata)
