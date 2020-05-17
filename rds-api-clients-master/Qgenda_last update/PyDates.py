import datetime
import calendar
import time
from time import strftime


# test2

today = datetime.date.fromordinal(datetime.date.today().toordinal())
today = today.strftime("%Y%m%d")

yesterday = datetime.date.fromordinal(datetime.date.today().toordinal() - 1)
yesterday = yesterday.strftime("%Y%m%d")




def daterange(ip_date):
    '''

    if ip_date is '' then return Yesterday as MonthStart & MonthEnd
    otherwise determine the monthstart and monthend for the ip_date given

    ***ip_date should be in YYYYMMDD format

    '''


    ip_date = str(ip_date)

    if ip_date == '':
        yest = datetime.date.fromordinal(datetime.date.today().toordinal() - 1)

        MonthStart = yest.strftime("%m/%d/%Y")
        MonthEnd = yest.strftime("%m/%d/%Y")

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




def rollingyear(v_months):
    '''

    Takes a parameter v_months as an int and returns a list of months going back x months from today.
    If v_months is '' , then the default will be 12 months

    '''


    if v_months == '':
        x = 12
    else:
        x = v_months

    now = time.localtime()

    list = []
    for n in range(x):
        list.append(
            strftime("%Y%m%d", time.localtime(time.mktime((now.tm_year, now.tm_mon - n, 1, 0, 0, 0, 0, 0, 0))))
        )
    return(list)


