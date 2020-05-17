import time
from time import strftime

x = 15
# print(range(x))

now = time.localtime()
# print(now)
list = []
for n in range(x):
    list.append(
                strftime("%Y%m%d",time.localtime(   time.mktime(  (now.tm_year, now.tm_mon - n, 1, 0, 0, 0, 0, 0, 0)  )  ))
                     )
rollingyear = list


# print(rollingyear)
