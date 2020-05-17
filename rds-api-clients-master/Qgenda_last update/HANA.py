import pyhdb

HAD = pyhdb.connect(
    host="172.29.13.55",
    port=30615,
    user='BCM_DATA_ADMIN',
    password='Byr_2015'
)

HAQ = pyhdb.connect(
    user='BCM_DATA_ADMIN',
    host="172.29.13.62",
    port=30415,
    password='Byr_2015'
)

HAP = pyhdb.connect(
    host="172.29.13.65",
    port=30215,
    user='BCM_DATA_ADMIN',
    password='Byr_2015'
)
#print(HAD.isconnected())


#environments = [HAD,HAQ,HAP]
#environments = [HAD]
#environments = [HAQ]
#environments = [HAP]
environments = [HAQ,HAP]







