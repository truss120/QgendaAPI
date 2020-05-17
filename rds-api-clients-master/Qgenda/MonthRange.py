import datetime
import calendar

today = datetime.date.fromordinal(datetime.date.today().toordinal())
v_today = today.strftime("%Y-%m-%d")
# print(repr(v_today))
yesterday = datetime.date.fromordinal(datetime.date.today().toordinal() - 1)
v_yesterday = yesterday.strftime("%m/%d/%Y")
# print(repr(v_yesterday))

def daterange(ip_date):
    #ip_date as YYYYMMDD format

    ip_date = str(ip_date)

    if ip_date == '':
        today = datetime.date.fromordinal(datetime.date.today().toordinal() - 1)
        #today = datetime.date.today()
        #print(today)
        MonthRange = calendar.monthrange(today.year, today.month)
        # Start = datetime.date.today().replace(day=1)
        # #print(Start)
        # End = datetime.date.today().replace(day=MonthRange[1])
        # #print(End)

        MonthStart = today.strftime("%m/%d/%Y")
        #print(MonthStart)
        MonthEnd = today.strftime("%m/%d/%Y")
        #print(MonthEnd)



    else:
        year = int(ip_date[:4])
        month = int(ip_date[4:6])
        MonthRange = calendar.monthrange(year, month)
        Lastday = str(MonthRange[1])

        Start = ip_date[4:6]+"/"+'01'+"/"+ip_date[:4]
        End = ip_date[4:6]+"/"+Lastday+"/"+ip_date[:4]

        MonthStart = Start
        MonthEnd = End


    return(MonthStart,MonthEnd)




#print(daterange(''))
#print(yesterday)