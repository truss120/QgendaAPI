'''
Taylor Russell
5/31/2018

        Takes a snapshot of the last 3 months of the Qgenda Request Table and writes it as a csv. Deletes csv files older than 60 days
'''



import json
from collections import OrderedDict
import requests
from PyDates import *
from Token import header
from Qgenda_Depts import Depts
import csv
import time
from Config import RequestLocation
import os






filedate = str(RequestLocation+time.strftime("%Y%m%d")+'.csv')
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
                   '$select': 'CallRole,CompKey,Credit,Date,EndTime,Notes,RequestKey,RequestType,RequestStatus,ResolutionDate,StaffAbbrev,StaffFName,StaffId,StaffKey,StaffLName,StaffPayrollId,StartTime,SubmittedByUser,SubmittedDate,TaskAbbrev,TaskKey,TaskName',
                   '$orderby': 'Date'}

        request = requests.get('https://api.qgenda.com/v2/request', params=payload, headers=header)

        json_data = json.loads(request.text, object_pairs_hook=OrderedDict)
        data.extend(json_data)
        d += 1
    s += 1


#Write File
keys = data[0].keys()
with open(filedate, 'w', newline='') as output_file:
   dict_writer = csv.DictWriter(output_file, keys)
   dict_writer.writeheader()
   dict_writer.writerows(data)
   output_file.close()





#delete old files
path = RequestLocation
now = time.time()

for f in os.listdir(path):
    f = os.path.join(path,f)

    # print(os.stat(f).st_mtime)
    # print(now - 5000)

    if os.stat(f).st_mtime < (now - 86400 * 60):
        if os.path.isfile(f):
            os.remove(os.path.join(path, f))

