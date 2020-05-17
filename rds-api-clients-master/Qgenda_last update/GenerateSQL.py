from HANA import environments
from PyDates import today
from Exceptions_SMTP import logger

env = environments

def CompileSQL(Table, Columns, DataSet):
    PlaceHolders = (','.join('?' * len(Columns.split(','))))

    x = 0
    while x < len(env):


        cur = env[x].cursor()
        try:

            INSERT = "INSERT INTO {} ({}) VALUES ({})".format(Table, Columns, PlaceHolders)
            UPDATE = "UPDATE {} SET LOAD_DATE = ? WHERE LOAD_DATE IS NULL".format(Table)

            cur.executemany(INSERT, DataSet)
            cur.execute(UPDATE, [today])
            environments[x].commit()
            cur.close
            print('Inserting into {} in {}'.format(Table,env[x].host))
            x += 1


        except Exception as e:
            logger.exception('Table {} failed in {} - Unhandled Exception:'.format(Table, env[x].host))

            return (print(e))

    return print('Load Successful')









# CompileSQL('BCM_SA.QGENDA_SCHEDULE','SOME_COLUMN','[(TEST)]')