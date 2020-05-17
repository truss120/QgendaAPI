'''
Taylor Russell
5/31/2018

        Takes a snapshot of the last 3 months of the Qgenda Schedule Table and writes it as a csv. Deletes csv files older than 60 days
'''



import json
from collections import OrderedDict
import requests
from PyDates import *
from Token import header
from Qgenda_Depts import Depts
import csv
import time
from Config import ScheduleLocation
import os






filedate = str(ScheduleLocation+time.strftime("%Y%m%d")+'.csv')
rollingmonths = rollingyear(3)


#loop through months
s = 0
data = []
for r in rollingmonths:

    v_date = daterange(rollingmonths[s])

    #loop through Depts
    d=0
    for Dept in Depts:

        payload = {'companyKey': Depts[d], 'startDate': v_date[0], 'endDate': v_date[1],
                  '$select': 'CallRole,CompKey,Credit,Date,EndDate,EndTime,IsCred,IsPublished,IsLocked,IsStruck,Notes,StaffAbbrev,StaffBillSysId,StaffEmail,StaffEmrId,StaffExtCallSysId,StaffFName,StaffId,StaffKey,StaffLName,StaffMobilePhone,StaffNpi,StaffPager,StaffPayrollId,StartDate,StartTime,TaskAbbrev,TaskBillSysId,TaskExtCallSysId,TaskId,TaskKey,TaskName,TaskPayrollId,TaskEmrId,TaskIsPrintEnd,TaskIsPrintStart,TaskShiftKey',
                  '$orderby': 'StartDate'}

        schedule = requests.get('https://api.qgenda.com/v2/schedule', params=payload, headers=header)

        json_data = json.loads(schedule.text, object_pairs_hook=OrderedDict)
        data.extend(json_data)
        d += 1
    s+=1


#write file
keys = data[0].keys()
with open(filedate, 'w', newline='') as output_file:
   dict_writer = csv.DictWriter(output_file, keys)
   dict_writer.writeheader()
   dict_writer.writerows(data)
   output_file.close()





#delete old files
path = ScheduleLocation
now = time.time()

for f in os.listdir(path):
    f = os.path.join(path,f)

    # print(os.stat(f).st_mtime)
    # print(now - 5000)

    if os.stat(f).st_mtime < (now - 86400 * 60):
        if os.path.isfile(f):
            os.remove(os.path.join(path, f))

