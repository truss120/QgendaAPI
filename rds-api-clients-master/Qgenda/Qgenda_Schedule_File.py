
import requests
import csv
import json
from MonthRange import *


v_date = daterange(20180401)  # YYYYMMDD or '' for yesterday's date

print(v_date)

##GET TOKEN##
login = {'email': 'bcmAPI@qgenda.com' , 'password': 'p4I?8*emz#zOonIP'}
response = requests.post('https://api.qgenda.com/v2/login', data=login)


##DEFINE HEADERS##
token = response.json()['token_type']+" "+response.json()['access_token']
header = {'Authorization': token, 'Content-Type': 'application/json', 'Accept-Encoding': '*'}




##GET REQUEST##
payload = {'companyKey': '6dcfd6aa-5227-4918-b81b-fe946676ffc6' , 'startDate' : '03/21/2018' , 'endDate' : '03/21/2018',
           '$select': 'CallRole,CompKey,Credit,Date,EndDate,EndTime,IsCred,IsPublished,IsLocked,IsStruck,Notes,StaffAbbrev,StaffBillSysId,StaffEmail,StaffEmrId,StaffExtCallSysId,StaffFName,StaffId,StaffKey,StaffLName,StaffMobilePhone,StaffNpi,StaffPager,StaffPayrollId,StartDate,StartTime,TaskAbbrev,TaskBillSysId,TaskExtCallSysId,TaskId,TaskKey,TaskName,TaskPayrollId,TaskEmrId,TaskIsPrintEnd,TaskIsPrintStart,TaskShiftKey',
           '$orderby': 'StartDate'}
schedule = requests.get('https://api.qgenda.com/v2/schedule',params= payload, headers = header)

#print(schedule.url)


json_data = json.loads(schedule.text)
#print(json_data)
#print(schedule.text)




keys = json_data[0].keys()
#print(columns)
#keys = [x.upper() for x in columns]
#print(keys)


with open('Qgenda_schedule.csv', 'wb') as output_file:
   dict_writer = csv.DictWriter(output_file, keys)
   #dict_writer.writeheader()
   dict_writer.writerows(json_data)
   output_file.close()



