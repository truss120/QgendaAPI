'''
Taylor Russell
5/31/2018

        Loads the Qgenda StaffMember Table and writes it as a csv. Deletes csv files older than 60 days

'''



import json
from collections import OrderedDict
import requests
from PyDates import *
from Token import header
import csv
import time
from Config import TaskLocation
import os






filedate = str(TaskLocation+time.strftime("%Y%m%d")+'.csv')



payload = {'$select':'Abbrev,BgColor,BillSysId,CallRole,CompKey,EmrId,EndDate,ExtCallSysId,ExtCallPriority,Extension,Name,OverrideSortOrder,PayrollId,PayrollUnits,StartDate,TaskId,TaskKey,TextColor','$orderby':'CompKey,StartDate'}

task = requests.get('https://api.qgenda.com/v2/task', params=payload, headers=header)

json_data = json.loads(task.text, object_pairs_hook=OrderedDict)


# print(json_data)

# write file
keys = json_data[0].keys()
with open(filedate, 'w', newline='') as output_file:
   dict_writer = csv.DictWriter(output_file, keys)
   dict_writer.writeheader()
   dict_writer.writerows(json_data)
   output_file.close()



#Delete old
path = TaskLocation
now = time.time()

for f in os.listdir(path):
    f = os.path.join(path,f)

    if os.stat(f).st_mtime < (now - 86400 * 60):
        if os.path.isfile(f):
            os.remove(os.path.join(path, f))

